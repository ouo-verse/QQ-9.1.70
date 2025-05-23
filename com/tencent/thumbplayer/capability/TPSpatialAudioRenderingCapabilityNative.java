package com.tencent.thumbplayer.capability;

import com.tencent.thumbplayer.api.exception.TPLoadLibraryException;
import com.tencent.thumbplayer.common.log.TPLogUtil;

/* loaded from: classes26.dex */
public class TPSpatialAudioRenderingCapabilityNative {
    private static final String TAG = "TPSpatialAudioRenderingCapabilityNative";

    public static void addCustomizedCapability(int i3, int i16, int i17) throws TPLoadLibraryException {
        try {
            native_addCustomizedSpatialAudioRenderingCapability(i3, i16, i17);
        } catch (Throwable th5) {
            TPLogUtil.e(TAG, "call native_addCustomizedSpatialAudioRenderingCapability has exception:" + th5.getMessage());
            throw new TPLoadLibraryException("Failed to call native_addCustomizedSpatialAudioRenderingCapability.");
        }
    }

    private static native void native_addCustomizedSpatialAudioRenderingCapability(int i3, int i16, int i17);
}
