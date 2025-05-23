package com.tencent.qcircle.tavcut.util;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes22.dex */
public class Logger {
    private static final boolean ENABLE_LOG = true;
    private static final String TAG = "Logger";

    public static void d(String str, String str2) {
        Log.d(str, str2);
    }

    public static void e(String str, String str2) {
        Log.e(str, str2);
    }

    public static void i(String str, String str2) {
        Log.w(str, str2);
    }

    public static void w(String str, String str2) {
        Log.w(str, str2);
    }

    public static void e(Throwable th5) {
        e(TAG, th5.toString(), th5);
    }

    public static void e(String str, String str2, Throwable th5) {
        Log.e(TAG, th5.toString(), th5);
    }
}
