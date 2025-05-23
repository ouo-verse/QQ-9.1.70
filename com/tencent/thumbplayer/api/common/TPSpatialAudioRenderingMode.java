package com.tencent.thumbplayer.api.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes26.dex */
public @interface TPSpatialAudioRenderingMode {
    public static final int TP_SPATIAL_AUDIO_RENDERING_MODE_NONE = -1;
    public static final int TP_SPATIAL_AUDIO_RENDERING_MODE_SYSTEM = 0;
    public static final int TP_SPATIAL_AUDIO_RENDERING_MODE_TENCENT = 1;
    public static final int TP_SPATIAL_AUDIO_RENDERING_MODE_UWA = 2;
}
