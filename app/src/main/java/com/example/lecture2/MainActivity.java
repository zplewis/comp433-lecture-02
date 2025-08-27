package com.example.lecture2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    public void clickButton(View view) {
        // This is done to make sure that the button was clicked.
        // There is a button for "LogCat" on the left-hand side of Android Studio.
        // You may have to import the Log class
        Log.v("MYTAG", "Button was clicked.");

        // the activity files are in the app/java/com.example.lecture2 folder
        // You know
        Intent x = new Intent(this, Activity2.class);
        // this is not a method I had to define; this is a method of the Intent class
        // You can use any name, doesn't have to be formatted this way
        // I think this just pushes data to Activity2; you'll need to modify Activity2.java
        x.putExtra("VAL", 123);
        x.putExtra("MSG", "This is the message");
        startActivity(x);
    }
}