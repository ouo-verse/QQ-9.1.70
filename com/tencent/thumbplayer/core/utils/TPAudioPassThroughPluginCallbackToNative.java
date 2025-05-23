package com.tencent.thumbplayer.core.utils;

import com.tencent.thumbplayer.core.utils.TPAudioPassThroughPluginDetector;

/* loaded from: classes26.dex */
public class TPAudioPassThroughPluginCallbackToNative implements TPAudioPassThroughPluginDetector.AudioPassThroughPluginListener {
    private static final String TAG = "TPAudioPassThroughPluginCallback";
    private long mNativeContext;

    TPAudioPassThroughPluginCallbackToNative(long j3) {
        this.mNativeContext = j3;
    }

    private native void _onAudioPassThroughStateChanged(boolean z16);

    @TPMethodCalledByNative
    private long getNativeContext() {
        return this.mNativeContext;
    }

    @TPMethodCalledByNative
    private void registerCallback() {
        TPAudioPassThroughPluginDetector.addListener(this);
    }

    @TPMethodCalledByNative
    private void unregisterCallback() {
        TPAudioPassThroughPluginDetector.removeListener(this);
    }

    @Override // com.tencent.thumbplayer.core.utils.TPAudioPassThroughPluginDetector.AudioPassThroughPluginListener
    public void onAudioPassThroughPlugin(boolean z16) {
        TPNativeLog.printLog(2, TAG, "onAudioPassThroughPlugin bPlugin:" + z16);
        _onAudioPassThroughStateChanged(z16);
    }
}
