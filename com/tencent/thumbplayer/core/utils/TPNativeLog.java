package com.tencent.thumbplayer.core.utils;

import android.util.Log;

/* loaded from: classes26.dex */
public class TPNativeLog {
    public static final int LEVEL_DEBUG = 3;
    public static final int LEVEL_ERROR = 0;
    public static final int LEVEL_INFO = 2;
    public static final int LEVEL_VERBOSE = 4;
    public static final int LEVEL_WARN = 1;
    private static final String TAG = "PlayerCore";
    private static volatile ITPNativeLogCallback mLogCallback;

    private static native void native_setMinPrintLevel(int i3);

    @TPMethodCalledByNative
    private static void onPrintLog(int i3, byte[] bArr, int i16, byte[] bArr2, int i17) {
        try {
            printLog(i3, new String(bArr, 0, i16, "UTF-8"), new String(bArr2, 0, i17, "UTF-8"));
        } catch (Exception e16) {
            printLog(0, e16.getMessage());
        }
    }

    public static void printLog(int i3, String str) {
        printLog(i3, TAG, str);
    }

    public static void printLogDefault(int i3, String str, String str2) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            Log.v(str, str2);
                            return;
                        } else {
                            Log.v(str, str2);
                            return;
                        }
                    }
                    Log.d(str, str2);
                    return;
                }
                Log.i(str, str2);
                return;
            }
            Log.w(str, str2);
            return;
        }
        Log.e(str, str2);
    }

    public static void setLogCallback(ITPNativeLogCallback iTPNativeLogCallback) {
        mLogCallback = iTPNativeLogCallback;
    }

    public static void setMinPrintLevel(int i3) {
        try {
            native_setMinPrintLevel(i3);
        } catch (UnsatisfiedLinkError e16) {
            printLog(0, TAG, "failed to setMinPrintLevel:" + e16);
        }
    }

    public static void printLog(int i3, String str, String str2) {
        if (mLogCallback != null) {
            mLogCallback.onPrintLog(i3, str, str2);
        } else {
            printLogDefault(i3, str, str2);
        }
    }
}
