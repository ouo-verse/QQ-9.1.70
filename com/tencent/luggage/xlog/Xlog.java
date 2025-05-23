package com.tencent.luggage.xlog;

/* compiled from: P */
/* loaded from: classes9.dex */
public class Xlog {
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
    public static final int ZLIB_MODE = 0;
    public static final int ZSTD_COMPRESS_LEVEL1 = 1;
    public static final int ZSTD_COMPRESS_LEVEL2 = 2;
    public static final int ZSTD_COMPRESS_LEVEL3 = 3;
    public static final int ZSTD_COMPRESS_LEVEL4 = 4;
    public static final int ZSTD_COMPRESS_LEVEL5 = 5;
    public static final int ZSTD_COMPRESS_LEVEL6 = 6;
    public static final int ZSTD_COMPRESS_LEVEL7 = 7;
    public static final int ZSTD_COMPRESS_LEVEL8 = 8;
    public static final int ZSTD_COMPRESS_LEVEL9 = 9;
    public static final int ZSTD_MODE = 1;
    private static String mCacheDir = null;
    private static String mLogDir = null;
    private static String xlog_pubkey = "1dac3876bd566b60c7dcbffd219ca6af2d2c07f045711bf2a6d111a2b1fc27c4df31c1f568879708c5159e370ab141e6627ea028b47f8a5cf4d39ca30d501f81";

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class XLogConfig {
        public String cachedir;
        public String logdir;
        public String nameprefix;
        public int level = 2;
        public int mode = 0;
        public String pubkey = "";
        public int compressmode = 0;
        public int compresslevel = 6;
        public int cachedays = 0;
    }

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

    private static native void appenderOpen(XLogConfig xLogConfig);

    public static native void logWrite(XLoggerInfo xLoggerInfo, String str);

    public static void logWrite2(int i3, String str, String str2, String str3, int i16, int i17, long j3, long j16, String str4) {
        logWrite2(0L, i3, str, str2, str3, i16, i17, j3, j16, str4);
    }

    public static native void logWrite2(long j3, int i3, String str, String str2, String str3, int i16, int i17, long j16, long j17, String str4);

    public static void open(boolean z16, int i3, int i16, String str, String str2, String str3, int i17) {
        if (z16) {
            System.loadLibrary("tencentxlog");
        }
        XLogConfig xLogConfig = new XLogConfig();
        xLogConfig.level = i3;
        xLogConfig.mode = i16;
        xLogConfig.logdir = str2;
        xLogConfig.nameprefix = str3;
        xLogConfig.compressmode = 0;
        xLogConfig.pubkey = xlog_pubkey;
        xLogConfig.cachedir = str;
        xLogConfig.cachedays = i17;
        appenderOpen(xLogConfig);
    }

    public native void appenderClose();

    public native void appenderFlush(long j3, boolean z16);

    public void appenderOpen(int i3, int i16, String str, String str2, String str3, int i17) {
        mCacheDir = str;
        mLogDir = str2;
        XLogConfig xLogConfig = new XLogConfig();
        xLogConfig.level = i3;
        xLogConfig.mode = i16;
        xLogConfig.logdir = str2;
        xLogConfig.nameprefix = str3;
        xLogConfig.compressmode = 0;
        xLogConfig.pubkey = xlog_pubkey;
        xLogConfig.cachedir = str;
        xLogConfig.cachedays = i17;
        appenderOpen(xLogConfig);
    }

    public native int getLogLevel(long j3);

    public native long getXlogInstance(String str);

    public void logD(long j3, String str, String str2, String str3, int i3, int i16, long j16, long j17, String str4) {
        logWrite2(j3, 1, decryptTag(str), str2, str3, i3, i16, j16, j17, LogLogic.appendMemLog(str4));
    }

    public void logE(long j3, String str, String str2, String str3, int i3, int i16, long j16, long j17, String str4) {
        logWrite2(j3, 4, decryptTag(str), str2, str3, i3, i16, j16, j17, LogLogic.appendMemLog(str4));
    }

    public void logF(long j3, String str, String str2, String str3, int i3, int i16, long j16, long j17, String str4) {
        logWrite2(j3, 5, decryptTag(str), str2, str3, i3, i16, j16, j17, str4);
    }

    public void logI(long j3, String str, String str2, String str3, int i3, int i16, long j16, long j17, String str4) {
        logWrite2(j3, 2, decryptTag(str), str2, str3, i3, i16, j16, j17, LogLogic.appendMemLog(str4));
    }

    public void logV(long j3, String str, String str2, String str3, int i3, int i16, long j16, long j17, String str4) {
        logWrite2(j3, 0, decryptTag(str), str2, str3, i3, i16, j16, j17, str4);
    }

    public void logW(long j3, String str, String str2, String str3, int i3, int i16, long j16, long j17, String str4) {
        logWrite2(j3, 3, decryptTag(str), str2, str3, i3, i16, j16, j17, LogLogic.appendMemLog(str4));
    }

    public native long newXlogInstance(XLogConfig xLogConfig);

    public long openLogInstance(int i3, int i16, String str, String str2, String str3, int i17) {
        XLogConfig xLogConfig = new XLogConfig();
        xLogConfig.level = i3;
        xLogConfig.mode = i16;
        xLogConfig.logdir = str2;
        xLogConfig.nameprefix = str3;
        xLogConfig.compressmode = 0;
        xLogConfig.pubkey = xlog_pubkey;
        xLogConfig.cachedir = str;
        xLogConfig.cachedays = i17;
        return newXlogInstance(xLogConfig);
    }

    public native void releaseXlogInstance(String str);

    public native void setAppenderMode(long j3, int i3);

    public native void setConsoleLogOpen(long j3, boolean z16);

    public native void setMaxAliveTime(long j3, long j16);

    public native void setMaxFileSize(long j3, long j16);

    private static String decryptTag(String str) {
        return str;
    }

    public void moveLogsFromCacheDirToLogDir() {
    }
}
