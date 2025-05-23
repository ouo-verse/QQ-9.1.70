package com.gcore.abase.log;

/* compiled from: P */
/* loaded from: classes2.dex */
public class XLog {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class ALogPriority {
        public static final int DEBUG = 0;
        public static final int ERROR = 4;
        public static final int EVENT = 3;
        public static final int INFO = 1;
        public static final int NONE = 5;
        public static final int WARNING = 2;

        ALogPriority() {
        }
    }

    public static void d(String str) {
        nativeXLog(0, str);
    }

    public static void e(String str) {
        nativeXLog(4, str);
    }

    public static void i(String str) {
        nativeXLog(1, str);
    }

    private static native void nativeXLog(int i3, String str);

    public static void w(String str) {
        nativeXLog(2, str);
    }

    public static void d(String str, String str2) {
        nativeXLog(0, "[" + str + "]" + str2);
    }

    public static void e(String str, String str2) {
        nativeXLog(4, "[" + str + "]" + str2);
    }

    public static void i(String str, String str2) {
        nativeXLog(1, "[" + str + "]" + str2);
    }

    public static void w(String str, String str2) {
        nativeXLog(2, "[" + str + "]" + str2);
    }
}
