package com.tencent.qqlive.tvkplayer.vinfo.ckey.comm;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes23.dex */
public class VsLog {
    public static final String LOG_TAG = "[ckey_sdk]";
    public static boolean logIf = false;

    private static boolean checkLog() {
        if (logIf) {
            return true;
        }
        return false;
    }

    public static void debug(String str, Object... objArr) {
        if (checkLog()) {
            Log.d(LOG_TAG, String.format(str, objArr));
        }
    }

    public static void error(String str, Object... objArr) {
        Log.e(LOG_TAG, String.format(str, objArr));
    }

    public static void info(String str, Object... objArr) {
        if (checkLog()) {
            Log.i(LOG_TAG, String.format(str, objArr));
        }
    }

    public static void printStackTrace(Throwable th5) {
        if (th5 != null) {
            if (checkLog()) {
                th5.printStackTrace();
            } else {
                error(th5.getMessage(), new Object[0]);
            }
        }
    }

    public static void warn(String str, Object... objArr) {
        if (checkLog()) {
            Log.w(LOG_TAG, String.format(str, objArr));
        }
    }
}
