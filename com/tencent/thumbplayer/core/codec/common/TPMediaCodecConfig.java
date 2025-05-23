package com.tencent.thumbplayer.core.codec.common;

import com.tencent.thumbplayer.core.utils.TPNativeLog;

/* loaded from: classes26.dex */
public class TPMediaCodecConfig {
    private static final String TAG = "TPMediaCodecConfig";

    public static boolean getMediaCodecInstanceCountLimitEnable() {
        try {
            return native_getMediaCodecInstanceCountLimitEnable();
        } catch (UnsatisfiedLinkError e16) {
            TPNativeLog.printLog(0, TAG, "failed to getMediaCodecInstanceCountLimitEnable" + e16.getMessage());
            return false;
        }
    }

    private static native boolean native_getMediaCodecInstanceCountLimitEnable();
}
