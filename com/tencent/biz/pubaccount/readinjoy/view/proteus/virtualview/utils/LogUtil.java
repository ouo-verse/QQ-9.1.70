package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes4.dex */
public class LogUtil {
    static ProteusLog proteusLog;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class LogTag {
        public static final String TAG_READINJOY_PROTEUS = "readinjoy.proteus";
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface ProteusLog {
        void d(String str, int i3, String str2);

        void d(String str, int i3, String str2, Throwable th5);

        void e(String str, int i3, String str2);

        void e(String str, int i3, String str2, Throwable th5);

        void i(String str, int i3, String str2);

        void i(String str, int i3, String str2, Throwable th5);

        boolean isColorLevel();

        void w(String str, int i3, String str2);

        void w(String str, int i3, String str2, Throwable th5);
    }

    public static void setProteusLog(ProteusLog proteusLog2) {
        proteusLog = proteusLog2;
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class QLog {
        public static final int CLR = 2;
        public static final int DEV = 4;
        public static final int USR = 1;

        public static void d(String str, int i3, String str2) {
            ProteusLog proteusLog = LogUtil.proteusLog;
            if (proteusLog != null) {
                proteusLog.d(str, i3, str2);
            } else {
                Log.d(str, str2);
            }
        }

        public static void e(String str, int i3, String str2) {
            ProteusLog proteusLog = LogUtil.proteusLog;
            if (proteusLog != null) {
                proteusLog.e(str, i3, str2);
            } else {
                Log.e(str, str2);
            }
        }

        public static void i(String str, int i3, String str2) {
            ProteusLog proteusLog = LogUtil.proteusLog;
            if (proteusLog != null) {
                proteusLog.i(str, i3, str2);
            } else {
                Log.i(str, str2);
            }
        }

        public static boolean isColorLevel() {
            ProteusLog proteusLog = LogUtil.proteusLog;
            if (proteusLog != null) {
                return proteusLog.isColorLevel();
            }
            return false;
        }

        public static void w(String str, int i3, String str2) {
            ProteusLog proteusLog = LogUtil.proteusLog;
            if (proteusLog != null) {
                proteusLog.w(str, i3, str2);
            } else {
                Log.w(str, str2);
            }
        }

        public static void d(String str, int i3, String str2, Throwable th5) {
            ProteusLog proteusLog = LogUtil.proteusLog;
            if (proteusLog != null) {
                proteusLog.d(str, i3, str2, th5);
            } else {
                Log.d(str, str2, th5);
            }
        }

        public static void e(String str, int i3, String str2, Throwable th5) {
            ProteusLog proteusLog = LogUtil.proteusLog;
            if (proteusLog != null) {
                proteusLog.e(str, i3, str2, th5);
            } else {
                Log.e(str, str2, th5);
            }
        }

        public static void i(String str, int i3, String str2, Throwable th5) {
            ProteusLog proteusLog = LogUtil.proteusLog;
            if (proteusLog != null) {
                proteusLog.i(str, i3, str2, th5);
            } else {
                Log.i(str, str2, th5);
            }
        }

        public static void w(String str, int i3, String str2, Throwable th5) {
            ProteusLog proteusLog = LogUtil.proteusLog;
            if (proteusLog != null) {
                proteusLog.w(str, i3, str2, th5);
            } else {
                Log.w(str, str2, th5);
            }
        }
    }
}
