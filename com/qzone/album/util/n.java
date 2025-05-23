package com.qzone.album.util;

import android.os.Build;
import android.view.View;
import android.widget.EditText;

/* compiled from: P */
/* loaded from: classes39.dex */
public class n {
    public static void a(View view) {
        if (view != null && Build.VERSION.SDK_INT >= 31) {
            view.setClickable(true);
            if (view instanceof EditText) {
                view.setFocusable(true);
                view.setFocusableInTouchMode(true);
            }
        }
    }
}
