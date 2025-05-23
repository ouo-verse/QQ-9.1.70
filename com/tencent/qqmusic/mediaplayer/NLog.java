package com.tencent.qqmusic.mediaplayer;

import android.util.Log;
import com.tencent.qqmusic.mediaplayer.util.Logger;

/* compiled from: P */
/* loaded from: classes23.dex */
public class NLog {
    private static final int LEVEL_DEBUG = 1;
    private static final int LEVEL_ERROR = 4;
    private static final int LEVEL_INFO = 2;
    private static final int LEVEL_WARNING = 3;
    private static final String TAG = "NLog";
    private static volatile boolean mIsLoadSuccess = false;

    public static void D(String str, String str2) {
        if (!mIsLoadSuccess) {
            Logger.e(TAG, "Not load NLog lib!!!");
            return;
        }
        try {
            d(str, str2);
        } catch (UnsatisfiedLinkError e16) {
            Logger.e(TAG, e16);
        }
    }

    public static void E(String str, String str2) {
        if (!mIsLoadSuccess) {
            Logger.e(TAG, "Not load NLog lib!!!");
            return;
        }
        try {
            e(str, str2);
        } catch (UnsatisfiedLinkError e16) {
            Logger.e(TAG, e16);
        }
    }

    public static String GetLogPath() {
        if (!mIsLoadSuccess) {
            Logger.e(TAG, "Not load NLog lib!!!");
            return "";
        }
        try {
            return getLogPath();
        } catch (UnsatisfiedLinkError e16) {
            Logger.e(TAG, e16);
            return "";
        }
    }

    public static void I(String str, String str2) {
        if (!mIsLoadSuccess) {
            Logger.e(TAG, "Not load NLog lib!!!");
            return;
        }
        try {
            i(str, str2);
        } catch (UnsatisfiedLinkError e16) {
            Logger.e(TAG, e16);
        }
    }

    public static boolean Start(String str, int i3) {
        if (!mIsLoadSuccess) {
            Logger.e(TAG, "Not load NLog lib!!!");
            return false;
        }
        try {
            return start(str, i3);
        } catch (UnsatisfiedLinkError e16) {
            Logger.e(TAG, e16);
            return false;
        }
    }

    public static void Stop() {
        if (!mIsLoadSuccess) {
            Logger.e(TAG, "Not load NLog lib!!!");
            return;
        }
        try {
            stop();
        } catch (UnsatisfiedLinkError e16) {
            Logger.e(TAG, e16);
        }
    }

    public static void W(String str, String str2) {
        if (!mIsLoadSuccess) {
            Logger.e(TAG, "Not load NLog lib!!!");
            return;
        }
        try {
            w(str, str2);
        } catch (UnsatisfiedLinkError e16) {
            Logger.e(TAG, e16);
        }
    }

    private static void WriteLogCallback(int i3, String str, String str2) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        Logger.i(str, str2);
                        return;
                    } else {
                        Logger.e(str, str2);
                        return;
                    }
                }
                Logger.w(str, str2);
                return;
            }
            Logger.i(str, str2);
            return;
        }
        Logger.d(str, str2);
    }

    private static native void d(String str, String str2);

    private static native void e(String str, String str2);

    private static native String getLogPath();

    private static native void i(String str, String str2);

    public static boolean init(String str, String str2, int i3) {
        if (AudioPlayerConfigure.getSoLibraryLoader().load(str)) {
            mIsLoadSuccess = true;
            Start(str2, i3);
            return true;
        }
        return false;
    }

    private static native void setLogWriteCallback(int i3);

    public static void setWriteCallback(boolean z16) {
        if (!mIsLoadSuccess) {
            Logger.e(TAG, "Not load NLog lib!!!");
            return;
        }
        try {
            setLogWriteCallback(z16 ? 1 : 0);
        } catch (UnsatisfiedLinkError e16) {
            Logger.e(TAG, e16);
        }
    }

    private static native boolean start(String str, int i3);

    private static native void stop();

    private static native void w(String str, String str2);

    public static void D(String str, String str2, Throwable th5) {
        d(str, str2 + "\n" + Log.getStackTraceString(th5));
    }

    public static void E(String str, String str2, Throwable th5) {
        e(str, str2 + "\n" + Log.getStackTraceString(th5));
    }

    public static void I(String str, String str2, Throwable th5) {
        i(str, str2 + "\n" + Log.getStackTraceString(th5));
    }

    public static void W(String str, String str2, Throwable th5) {
        w(str, str2 + "\n" + Log.getStackTraceString(th5));
    }
}
