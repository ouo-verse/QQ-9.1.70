package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ExcitingTransferUtil {

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class Log {
        public static int CLR = 1;
        public static int DEV = 2;
        public static String LG_HEAD = "ExcitingT.";
        public static int USR;

        public static void d(String str, int i3, String str2) {
            QLog.d(str, qlogLevelOf(i3), LG_HEAD + str2);
        }

        public static void e(String str, int i3, String str2) {
            QLog.e(str, qlogLevelOf(i3), LG_HEAD + str2);
        }

        public static void i(String str, int i3, String str2) {
            QLog.i(str, qlogLevelOf(i3), LG_HEAD + str2);
        }

        public static boolean isDevelopLevel() {
            return QLog.isDevelopLevel();
        }

        private static int qlogLevelOf(int i3) {
            if (USR == i3) {
                return 1;
            }
            if (CLR == i3 || DEV != i3) {
                return 2;
            }
            return 4;
        }

        public static void w(String str, int i3, String str2) {
            QLog.w(str, qlogLevelOf(i3), LG_HEAD + str2);
        }
    }
}
