package com.tencent.luggage.wxa.h6;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class h {
    public static boolean a(Context context) {
        InputMethodManager inputMethodManager;
        Activity a16;
        View currentFocus;
        IBinder windowToken;
        if (context == null || (inputMethodManager = (InputMethodManager) context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)) == null || (a16 = com.tencent.luggage.wxa.bo.a.a(context)) == null || (currentFocus = a16.getCurrentFocus()) == null || (windowToken = currentFocus.getWindowToken()) == null) {
            return false;
        }
        if (com.tencent.luggage.wxa.bo.c.b()) {
            try {
                if (!ViewCompat.getRootWindowInsets(currentFocus).isVisible(WindowInsetsCompat.Type.ime())) {
                    return false;
                }
            } catch (NullPointerException unused) {
            }
        }
        try {
            return inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        } catch (IllegalArgumentException | IllegalStateException unused2) {
            return false;
        }
    }

    public static void b(Context context) {
        Activity activity;
        InputMethodManager inputMethodManager;
        View currentFocus;
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity == null || (inputMethodManager = (InputMethodManager) activity.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)) == null || (currentFocus = activity.getCurrentFocus()) == null || currentFocus.getWindowToken() == null) {
            return;
        }
        inputMethodManager.toggleSoftInput(0, 2);
    }
}
