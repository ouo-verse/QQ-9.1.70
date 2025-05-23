package com.tencent.mars.ilink.xlog;

import com.tencent.mars.ilink.xlog.Log;

/* compiled from: P */
/* loaded from: classes9.dex */
public class Xlog implements Log.LogImp {
    public static final int AppednerModeAsync = 0;
    public static final int AppednerModeSync = 1;
    public static final int LEVEL_ALL = 0;
    public static final int LEVEL_DEBUG = 1;
    public static final int LEVEL_ERROR = 4;
    public static final int LEVEL_FATAL = 5;
    public static final int LEVEL_INFO = 2;
    public static final int LEVEL_NONE = 6;
    public static final int LEVEL_VERBOSE = 0;
    public static final int LEVEL_WARNING = 3;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class XLoggerInfo {
        public String filename;
        public String funcname;
        public int level;
        public int line;
        public long maintid;
        public long pid;
        public String tag;
        public long tid;
    }

    public static native void appenderOpen(int i3, int i16, String str, String str2, String str3, int i17, String str4);

    public static native void logWrite(XLoggerInfo xLoggerInfo, String str);

    public static native void logWrite2(int i3, String str, String str2, String str3, int i16, int i17, long j3, long j16, String str4);

    public static void open(boolean z16, int i3, int i16, String str, String str2, String str3, String str4) {
        if (z16) {
            System.loadLibrary("c++_shared");
            System.loadLibrary("ilink_xlog");
        }
        appenderOpen(i3, i16, str, str2, str3, 0, str4);
    }

    public static native void setAppenderMode(int i3);

    public static native void setConsoleLogOpen(boolean z16);

    public static native void setErrLogOpen(boolean z16);

    public static native void setLogLevel(int i3);

    public static native void setMaxAliveTime(long j3);

    public static native void setMaxFileSize(long j3);

    @Override // com.tencent.mars.ilink.xlog.Log.LogImp
    public native void appenderClose();

    @Override // com.tencent.mars.ilink.xlog.Log.LogImp
    public native void appenderFlush(boolean z16);

    @Override // com.tencent.mars.ilink.xlog.Log.LogImp
    public native int getLogLevel();

    @Override // com.tencent.mars.ilink.xlog.Log.LogImp
    public void logD(String str, String str2, String str3, int i3, int i16, long j3, long j16, String str4) {
        logWrite2(1, decryptTag(str), str2, str3, i3, i16, j3, j16, str4);
    }

    @Override // com.tencent.mars.ilink.xlog.Log.LogImp
    public void logE(String str, String str2, String str3, int i3, int i16, long j3, long j16, String str4) {
        logWrite2(4, decryptTag(str), str2, str3, i3, i16, j3, j16, str4);
    }

    @Override // com.tencent.mars.ilink.xlog.Log.LogImp
    public void logF(String str, String str2, String str3, int i3, int i16, long j3, long j16, String str4) {
        logWrite2(5, decryptTag(str), str2, str3, i3, i16, j3, j16, str4);
    }

    @Override // com.tencent.mars.ilink.xlog.Log.LogImp
    public void logI(String str, String str2, String str3, int i3, int i16, long j3, long j16, String str4) {
        logWrite2(2, decryptTag(str), str2, str3, i3, i16, j3, j16, str4);
    }

    @Override // com.tencent.mars.ilink.xlog.Log.LogImp
    public void logV(String str, String str2, String str3, int i3, int i16, long j3, long j16, String str4) {
        logWrite2(0, decryptTag(str), str2, str3, i3, i16, j3, j16, str4);
    }

    @Override // com.tencent.mars.ilink.xlog.Log.LogImp
    public void logW(String str, String str2, String str3, int i3, int i16, long j3, long j16, String str4) {
        logWrite2(3, decryptTag(str), str2, str3, i3, i16, j3, j16, str4);
    }

    private static String decryptTag(String str) {
        return str;
    }
}
