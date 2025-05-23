package com.tencent.karaoke.audiobasesdk.util;

import com.tencent.karaoke.audiobasesdk.AudiobaseContext;

/* compiled from: P */
/* loaded from: classes7.dex */
public class AudioBaseVersionUtil {
    private static final String TAG = "AudioBaseVersionUtil";
    private static boolean mIsLoaded = AudiobaseContext.loadLibrary();
    private boolean mIsValid = false;
    private long nativeHandle;

    private native String getAudioBaseVersion();

    private native String getLibAudiobaseVersion();

    private native void setDebug(boolean z16);

    public void enableDebug(boolean z16) {
        if (!mIsLoaded) {
            return;
        }
        setDebug(z16);
    }

    public String getAudioBaseSdkVersion() {
        if (!mIsLoaded) {
            return "";
        }
        return getAudioBaseVersion();
    }

    public String getLibAudioBaseSdkVersion() {
        if (!mIsLoaded) {
            return "";
        }
        return getLibAudiobaseVersion();
    }
}
