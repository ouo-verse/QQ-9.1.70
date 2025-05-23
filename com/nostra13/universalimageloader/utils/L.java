package com.nostra13.universalimageloader.utils;

import android.util.Log;
import com.nostra13.universalimageloader.core.ImageLoader;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class L {
    private static final String LOG_FORMAT = "%1$s\n%2$s";
    private static volatile boolean writeDebugLogs = false;
    private static volatile boolean writeLogs = true;

    L() {
    }

    public static void d(String str, Object... objArr) {
        if (writeDebugLogs) {
            log(3, null, str, objArr);
        }
    }

    @Deprecated
    public static void disableLogging() {
        writeLogs(false);
    }

    public static void e(Throwable th5) {
        log(6, th5, null, new Object[0]);
    }

    @Deprecated
    public static void enableLogging() {
        writeLogs(true);
    }

    public static void i(String str, Object... objArr) {
        log(4, null, str, objArr);
    }

    private static void log(int i3, Throwable th5, String str, Object... objArr) {
        if (!writeLogs) {
            return;
        }
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        if (th5 != null) {
            if (str == null) {
                str = th5.getMessage();
            }
            str = String.format(LOG_FORMAT, str, Log.getStackTraceString(th5));
        }
        Log.println(i3, ImageLoader.TAG, str);
    }

    public static void w(String str, Object... objArr) {
        log(5, null, str, objArr);
    }

    public static void writeDebugLogs(boolean z16) {
        writeDebugLogs = z16;
    }

    public static void writeLogs(boolean z16) {
        writeLogs = z16;
    }

    public static void e(String str, Object... objArr) {
        log(6, null, str, objArr);
    }

    public static void e(Throwable th5, String str, Object... objArr) {
        log(6, th5, str, objArr);
    }
}
