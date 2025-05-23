package com.tencent.thumbplayer.core.utils;

import com.tencent.thumbplayer.core.utils.TPScreenRefreshRateDetector;

/* loaded from: classes26.dex */
public class TPScreenRefreshRateCallBackToNative implements TPScreenRefreshRateDetector.ScreenRefreshRateChangedListener {
    private static final String TAG = "TPScreenRefreshRateCallBack";
    private long mNativeContext;

    TPScreenRefreshRateCallBackToNative(long j3) {
        this.mNativeContext = j3;
    }

    private native void _onScreenRefreshRateChanged(float f16);

    @TPMethodCalledByNative
    private long getNativeContext() {
        return this.mNativeContext;
    }

    @TPMethodCalledByNative
    private void registerCallback() {
        TPScreenRefreshRateDetector.addListener(this);
    }

    @TPMethodCalledByNative
    private void unregisterCallback() {
        TPScreenRefreshRateDetector.removeListener(this);
    }

    @Override // com.tencent.thumbplayer.core.utils.TPScreenRefreshRateDetector.ScreenRefreshRateChangedListener
    public void onScreenRefreshRateChanged(float f16) {
        TPNativeLog.printLog(2, TAG, "onScreenRefreshRateChanged refreshRate:" + f16);
        _onScreenRefreshRateChanged(f16);
    }
}
