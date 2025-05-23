package com.tencent.thumbplayer.core.utils;

import com.tencent.thumbplayer.core.utils.TPHeadsetPluginDetector;
import java.util.Set;

/* loaded from: classes26.dex */
public class TPHeadsetPluginCallbackToNative implements TPHeadsetPluginDetector.HeadsetPluginListener {
    private static final String TAG = "TPHeadsetPluginCallback";
    private long mNativeContext;

    TPHeadsetPluginCallbackToNative(long j3) {
        this.mNativeContext = j3;
    }

    private native void _onAudioRouteChanged(Set<Integer> set, Set<Integer> set2);

    @TPMethodCalledByNative
    private long getNativeContext() {
        return this.mNativeContext;
    }

    @TPMethodCalledByNative
    private void registerCallback() {
        TPHeadsetPluginDetector.addHeadsetPluginListener(this);
    }

    @TPMethodCalledByNative
    private void unregisterCallback() {
        TPHeadsetPluginDetector.removeHeadsetPluginListener(this);
    }

    @Override // com.tencent.thumbplayer.core.utils.TPHeadsetPluginDetector.HeadsetPluginListener
    public void onHeadsetPlugin(Set<Integer> set, Set<Integer> set2) {
        TPNativeLog.printLog(2, TAG, "onHeadsetPlugin: oldOutputs: " + set + ", newOutputs: " + set2);
        _onAudioRouteChanged(set, set2);
    }
}
