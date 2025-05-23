package com.tencent.thumbplayer.core.utils;

import com.tencent.thumbplayer.core.utils.TPAudioSpatializerDetector;

/* loaded from: classes26.dex */
public class TPAudioSpatializerCallbackToNative implements TPAudioSpatializerDetector.IOutputDeviceStateChangedListener {
    private static final String TAG = "TPAudioSpatializerCallback";
    private boolean mIsOutputDeviceAvailable;
    private boolean mIsOutputDeviceSwitchOn;
    private long mNativeContext;

    TPAudioSpatializerCallbackToNative(long j3) {
        this.mIsOutputDeviceSwitchOn = false;
        this.mIsOutputDeviceAvailable = false;
        this.mNativeContext = j3;
        this.mIsOutputDeviceSwitchOn = TPAudioSpatializerDetector.isOutputDeviceSwitchOn();
        this.mIsOutputDeviceAvailable = TPAudioSpatializerDetector.isOutputDeviceAvailable();
    }

    @TPMethodCalledByNative
    private long getNativeContext() {
        return this.mNativeContext;
    }

    private native void navtive_onOutputDeviceAvailableChanged(boolean z16);

    @TPMethodCalledByNative
    private void registerCallback() {
        TPAudioSpatializerDetector.addListener(this);
    }

    @TPMethodCalledByNative
    private void unregisterCallback() {
        TPAudioSpatializerDetector.removeListener(this);
    }

    @Override // com.tencent.thumbplayer.core.utils.TPAudioSpatializerDetector.IOutputDeviceStateChangedListener
    public void onOutputDeviceAvailableChanged(boolean z16) {
        boolean z17;
        TPNativeLog.printLog(2, TAG, "onOutputDeviceSwitchChanged, available: " + this.mIsOutputDeviceAvailable + " to " + z16);
        boolean z18 = this.mIsOutputDeviceSwitchOn;
        boolean z19 = true;
        if (z18 && z16) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z18 || !this.mIsOutputDeviceAvailable) {
            z19 = false;
        }
        if (z17 != z19) {
            navtive_onOutputDeviceAvailableChanged(z17);
        }
        this.mIsOutputDeviceAvailable = z16;
    }

    @Override // com.tencent.thumbplayer.core.utils.TPAudioSpatializerDetector.IOutputDeviceStateChangedListener
    public void onOutputDeviceSwitchChanged(boolean z16) {
        boolean z17;
        TPNativeLog.printLog(2, TAG, "onOutputDeviceSwitchChanged, isSwithOn: " + this.mIsOutputDeviceSwitchOn + " to " + z16);
        boolean z18 = true;
        if (z16 && this.mIsOutputDeviceAvailable) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!this.mIsOutputDeviceSwitchOn || !this.mIsOutputDeviceAvailable) {
            z18 = false;
        }
        if (z17 != z18) {
            navtive_onOutputDeviceAvailableChanged(z17);
        }
        this.mIsOutputDeviceSwitchOn = z16;
    }
}
