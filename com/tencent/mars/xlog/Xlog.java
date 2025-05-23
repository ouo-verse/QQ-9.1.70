package com.tencent.mars.xlog;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Date;

/* compiled from: P */
/* loaded from: classes9.dex */
public class Xlog {
    static IPatchRedirector $redirector_ = null;
    public static final int AppednerModeAsync = 0;
    public static final int AppednerModeSync = 1;
    public static final int COMPRESS_LEVEL1 = 1;
    public static final int COMPRESS_LEVEL2 = 2;
    public static final int COMPRESS_LEVEL3 = 3;
    public static final int COMPRESS_LEVEL4 = 4;
    public static final int COMPRESS_LEVEL5 = 5;
    public static final int COMPRESS_LEVEL6 = 6;
    public static final int COMPRESS_LEVEL7 = 7;
    public static final int COMPRESS_LEVEL8 = 8;
    public static final int COMPRESS_LEVEL9 = 9;
    public static final int LEVEL_ALL = 0;
    public static final int LEVEL_DEBUG = 1;
    public static final int LEVEL_ERROR = 4;
    public static final int LEVEL_FATAL = 5;
    public static final int LEVEL_INFO = 2;
    public static final int LEVEL_NONE = 6;
    public static final int LEVEL_VERBOSE = 0;
    public static final int LEVEL_WARNING = 3;
    public static final long LOG_INSTANCE_PTR = 0;
    private static final String PUBLIC_KEY = "1e8eec1d829649d24d1abc31f12acc6a8f0e92092b6a5ead027fd4bbfe169841ca681925e01bca187364fe0e0d8e2ef6b482fc7dc619b6b0a24260ea7c5b05b4";
    public static final int ZLIB_MODE = 0;
    public static final int ZSTD_MODE = 1;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class XLogConfig {
        static IPatchRedirector $redirector_;
        public int cachedays;
        public String cachedir;
        public int compresslevel;
        public int compressmode;
        public int level;
        public String logdir;
        public int mode;
        public String nameprefix;
        public String pubkey;

        public XLogConfig() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.level = 2;
            this.mode = 0;
            this.pubkey = "";
            this.compressmode = 1;
            this.compresslevel = 6;
            this.cachedays = 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    static class XLoggerInfo {
        static IPatchRedirector $redirector_;
        public String filename;
        public String funcname;
        public int level;
        public int line;
        public long maintid;
        public long pid;
        public String tag;
        public long tid;

        XLoggerInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public Xlog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static native void appenderOpen(XLogConfig xLogConfig);

    public static native void logWrite2(long j3, int i3, String str, String str2, String str3, int i16, int i17, long j16, long j17, String str4);

    public native int androidExtractLog(long j3, Date date, Date date2, String str, String str2);

    public native void appenderClose();

    public native void appenderFlush(long j3, boolean z16);

    public void appenderOpen(int i3, int i16, String str, String str2, String str3, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), str, str2, str3, Integer.valueOf(i17));
            return;
        }
        XLogConfig xLogConfig = new XLogConfig();
        xLogConfig.level = i3;
        xLogConfig.mode = i16;
        xLogConfig.logdir = str2;
        xLogConfig.nameprefix = str3;
        xLogConfig.compressmode = 1;
        xLogConfig.compresslevel = 6;
        xLogConfig.pubkey = PUBLIC_KEY;
        xLogConfig.cachedir = str;
        xLogConfig.cachedays = i17;
        appenderOpen(xLogConfig);
    }

    public void logD(String str, int i3, long j3, long j16, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), str2);
        } else {
            logWrite2(0L, 1, decryptTag(str), "", "", 0, i3, j3, j16, str2);
        }
    }

    public void logE(String str, int i3, long j3, long j16, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), str2);
        } else {
            logWrite2(0L, 4, decryptTag(str), "", "", 0, i3, j3, j16, str2);
        }
    }

    public void logF(String str, int i3, long j3, long j16, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), str2);
        } else {
            logWrite2(0L, 5, decryptTag(str), "", "", 0, i3, j3, j16, str2);
        }
    }

    public void logI(String str, int i3, long j3, long j16, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), str2);
        } else {
            logWrite2(0L, 2, decryptTag(str), "", "", 0, i3, j3, j16, str2);
        }
    }

    public void logV(String str, int i3, long j3, long j16, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), str2);
        } else {
            logWrite2(0L, 0, decryptTag(str), "", "", 0, i3, j3, j16, str2);
        }
    }

    public void logW(String str, int i3, long j3, long j16, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), str2);
        } else {
            logWrite2(0L, 3, decryptTag(str), "", "", 0, i3, j3, j16, str2);
        }
    }

    public native void setConsoleLogOpen(long j3, boolean z16);

    public native void setMaxAliveTime(long j3, long j16);

    private static String decryptTag(String str) {
        return str;
    }
}
