package com.tencent.qqmusic.mediaplayer.util;

import com.tencent.qqmusic.mediaplayer.AudioPlayerConfigure;
import com.tencent.qqmusic.mediaplayer.NativeLibs;

/* compiled from: P */
/* loaded from: classes23.dex */
public class Util4NativeCommon {
    private static final String TAG = "Util4NativeCommon";

    static {
        try {
            AudioPlayerConfigure.getSoLibraryLoader().load(NativeLibs.audioCommon.getName());
        } catch (Throwable th5) {
            Logger.e(TAG, th5);
        }
    }

    public static native boolean isSupportARMv7();

    public static native boolean isSupportNeon();
}
