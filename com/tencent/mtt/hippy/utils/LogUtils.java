package com.tencent.mtt.hippy.utils;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes20.dex */
public class LogUtils {
    private static boolean DEBUG_ENABLE = false;

    public static void d(String str, String str2) {
        if (DEBUG_ENABLE) {
            Log.d(str, str2);
        }
    }

    public static void e(String str, String str2) {
        Log.e(str, str2);
    }

    public static void enableDebugLog(boolean z16) {
        DEBUG_ENABLE = z16;
    }

    public static void i(String str, String str2) {
        if (DEBUG_ENABLE) {
            Log.i(str, str2);
        }
    }

    public static void l(String str, String str2) {
        if (!DEBUG_ENABLE) {
            return;
        }
        int i3 = 3800;
        int i16 = 0;
        while (i16 < str2.length()) {
            if (str2.length() < i3) {
                i3 = str2.length();
            }
            Log.i(str, str2.substring(i16, i3));
            i16 = i3;
            i3 += 3800;
        }
    }

    public static void v(String str, String str2) {
        if (DEBUG_ENABLE) {
            Log.v(str, str2);
        }
    }

    public static void w(String str, String str2) {
        if (DEBUG_ENABLE) {
            Log.w(str, str2);
        }
    }

    public static void d(String str, String str2, Throwable th5) {
        if (DEBUG_ENABLE) {
            Log.d(str, str2, th5);
        }
    }

    public static void e(String str, String str2, Throwable th5) {
        Log.e(str, str2, th5);
    }
}
