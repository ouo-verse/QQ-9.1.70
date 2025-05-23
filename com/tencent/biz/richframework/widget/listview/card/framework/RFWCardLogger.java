package com.tencent.biz.richframework.widget.listview.card.framework;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWCardLogger {
    public static int CLR = 2;
    public static int DEV = 4;
    public static int USR = 1;

    public static void debug(String str, String str2) {
        QLog.d("RFW_CARD_" + str, DEV, str2);
    }

    public static void error(String str, int i3, String str2, Throwable th5) {
        QLog.e("RFW_CARD_" + str, i3, str2, th5);
    }

    public static void info(String str, int i3, String str2) {
        QLog.i("RFW_CARD_" + str, i3, str2);
    }

    public static boolean isColorLevel() {
        return QLog.isColorLevel();
    }
}
