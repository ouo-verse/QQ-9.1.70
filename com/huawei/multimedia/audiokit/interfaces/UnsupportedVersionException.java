package com.huawei.multimedia.audiokit.interfaces;

import com.huawei.multimedia.audiokit.utils.LogUtils;

/* compiled from: P */
/* loaded from: classes2.dex */
public class UnsupportedVersionException extends Exception {
    private static final String TAG = "HwAudioKit.UnsupportedVersionException";

    public UnsupportedVersionException() {
        LogUtils.error(TAG, "getEnhancedDeviceInfo UnsupportedVersionException");
    }
}
