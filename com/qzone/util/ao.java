package com.qzone.util;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ao {

    /* renamed from: a, reason: collision with root package name */
    private static long f59789a;

    /* renamed from: b, reason: collision with root package name */
    private static long f59790b;

    public static boolean b(int i3) {
        long currentTimeMillis = System.currentTimeMillis();
        f59790b = currentTimeMillis;
        boolean z16 = currentTimeMillis - f59789a > ((long) i3);
        f59789a = currentTimeMillis;
        return z16;
    }

    public static void c(Context context, View view) {
        ((InputMethodManager) context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).showSoftInput(view, 1);
    }

    public static void a(Context context, View view) {
        if (context == null || view == null) {
            return;
        }
        ((InputMethodManager) context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
