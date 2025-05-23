package com.heytap.databaseengine.utils;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HLog {
    private static boolean isLoggable = false;
    private static IHLogDelegate mLogDelegate;

    public static void d(String str, String str2) {
        if (isLoggable) {
            Log.d(str, str2);
            IHLogDelegate iHLogDelegate = mLogDelegate;
            if (iHLogDelegate != null) {
                iHLogDelegate.d(str, str2);
            }
        }
    }

    public static void e(String str, String str2) {
        if (isLoggable) {
            Log.e(str, str2);
            IHLogDelegate iHLogDelegate = mLogDelegate;
            if (iHLogDelegate != null) {
                iHLogDelegate.e(str, str2);
            }
        }
    }

    public static String getCaller() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        StringBuilder sb5 = new StringBuilder();
        int i3 = 0;
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (i3 > 1 && i3 <= 5) {
                sb5.append("(");
                sb5.append(stackTraceElement.getClassName());
                sb5.append(",");
                sb5.append(stackTraceElement.getMethodName());
                sb5.append("),");
            }
            if (i3 > 4) {
                break;
            }
            i3++;
        }
        return sb5.toString();
    }

    public static void i(String str, String str2) {
        if (isLoggable) {
            Log.i(str, str2);
            IHLogDelegate iHLogDelegate = mLogDelegate;
            if (iHLogDelegate != null) {
                iHLogDelegate.i(str, str2);
            }
        }
    }

    public static boolean isLoggable() {
        return isLoggable;
    }

    public static void setIsLoggable(boolean z16) {
        isLoggable = z16;
    }

    public static void setLog(IHLogDelegate iHLogDelegate) {
        mLogDelegate = iHLogDelegate;
    }

    public static void w(String str, String str2) {
        if (isLoggable) {
            Log.w(str, str2);
            IHLogDelegate iHLogDelegate = mLogDelegate;
            if (iHLogDelegate != null) {
                iHLogDelegate.w(str, str2);
            }
        }
    }
}
