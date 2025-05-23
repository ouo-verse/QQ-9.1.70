package com.tencent.thumbplayer.api.capability;

import com.tencent.thumbplayer.api.exception.TPLoadLibraryException;
import com.tencent.thumbplayer.capability.TPSpatialAudioRenderingCapabilityNative;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes26.dex */
public class TPSpatialAudioRenderingCapability {
    public static final int TP_SPATIAL_AUDIO_CAP_NOT_SUPPORT = 0;
    public static final int TP_SPATIAL_AUDIO_CAP_SUPPORT = 1;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface TPSpatialAudioCap {
    }

    public static void addCustomizedCapability(int i3, int i16, int i17) throws TPLoadLibraryException {
        TPSpatialAudioRenderingCapabilityNative.addCustomizedCapability(i3, i16, i17);
    }
}
