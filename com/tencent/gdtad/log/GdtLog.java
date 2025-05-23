package com.tencent.gdtad.log;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GdtLog {
    public static final String BOTTOM_CARD_WEB_TAG = "BottomCardWeb";
    public static final String ENDCARD_WEB_TAG = "EndCardWeb";
    public static final String VIDEO_TAG = "VideoGdt";
    public static final String WEB_TAG = "Web";

    public static void d(String str, String str2) {
        d(str, str2, null);
    }

    public static void e(String str, String str2) {
        e(str, str2, null);
    }

    public static void i(String str, String str2) {
        i(str, str2, null);
    }

    public static void w(String str, String str2) {
        w(str, str2, null);
    }

    public static void d(String str, String str2, Throwable th5) {
        if (QLog.isColorLevel()) {
            QLog.d(str, 2, str2, th5);
        }
    }

    public static void e(String str, String str2, Throwable th5) {
        if (QLog.isColorLevel()) {
            QLog.e(str, 2, str2, th5);
        }
    }

    public static void i(String str, String str2, Throwable th5) {
        if (QLog.isColorLevel()) {
            QLog.i(str, 2, str2, th5);
        }
    }

    public static void w(String str, String str2, Throwable th5) {
        if (QLog.isColorLevel()) {
            QLog.w(str, 2, str2, th5);
        }
    }
}
