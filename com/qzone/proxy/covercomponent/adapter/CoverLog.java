package com.qzone.proxy.covercomponent.adapter;

import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CoverLog {
    public static int CLR = 2;
    public static int DEV = 4;
    public static int USR = 1;

    public static void d(String str, int i3, String str2) {
        QZLog.d("COVER@" + str, i3, str2);
    }

    public static void e(String str, String str2, Throwable th5) {
        QZLog.e("COVER@" + str, str2, th5);
    }

    public static void i(String str, int i3, String str2) {
        QZLog.i("COVER@" + str, i3, str2);
    }

    public static boolean isColorLevel() {
        return QZLog.isColorLevel();
    }

    public static boolean isDevelopLevel() {
        return QZLog.isDevelopLevel();
    }

    public static void w(String str, String str2, Throwable th5) {
        QZLog.w("COVER@" + str, str2, th5);
    }
}
