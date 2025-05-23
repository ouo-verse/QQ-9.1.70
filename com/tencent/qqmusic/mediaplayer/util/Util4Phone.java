package com.tencent.qqmusic.mediaplayer.util;

/* loaded from: classes23.dex */
public class Util4Phone {
    private static final String TAG = "Util4Phone";

    public static boolean isSupportARMv7() {
        try {
            return Util4NativeCommon.isSupportARMv7();
        } catch (Throwable th5) {
            Logger.e(TAG, "isSupportARMv7", th5);
            return true;
        }
    }

    public static boolean isSupportNeon() {
        try {
            return Util4NativeCommon.isSupportNeon();
        } catch (Throwable th5) {
            Logger.e(TAG, "isSupportNeon", th5);
            return false;
        }
    }
}
