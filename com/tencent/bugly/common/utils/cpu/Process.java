package com.tencent.bugly.common.utils.cpu;

/* loaded from: classes5.dex */
public class Process {
    public static final int PROC_CHAR = 2048;
    public static final int PROC_COMBINE = 256;
    public static final int PROC_NEWLINE_TERM = 10;
    public static final int PROC_OUT_FLOAT = 16384;
    public static final int PROC_OUT_LONG = 8192;
    public static final int PROC_OUT_STRING = 4096;
    public static final int PROC_PARENS = 512;
    public static final int PROC_QUOTES = 1024;
    public static final int PROC_SPACE_TERM = 32;
    public static final int PROC_TAB_TERM = 9;
    public static final int PROC_TERM_MASK = 255;
    public static final int PROC_ZERO_TERM = 0;

    static {
        System.loadLibrary("rmonitor_base");
    }

    public static native int[] getPids(String str, int[] iArr);

    public static final int getUidForPid(int i3) {
        long[] jArr = {-1};
        readProcLines("/proc/" + i3 + "/status", new String[]{"Uid:"}, jArr);
        return (int) jArr[0];
    }

    public static native boolean parseProcLine(byte[] bArr, int i3, int i16, int[] iArr, String[] strArr, long[] jArr, float[] fArr);

    public static native boolean readProcFile(String str, int[] iArr, String[] strArr, long[] jArr, float[] fArr);

    public static native void readProcLines(String str, String[] strArr, long[] jArr);
}
