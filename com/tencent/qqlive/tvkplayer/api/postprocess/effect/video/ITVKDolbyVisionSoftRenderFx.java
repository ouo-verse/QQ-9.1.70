package com.tencent.qqlive.tvkplayer.api.postprocess.effect.video;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ITVKDolbyVisionSoftRenderFx extends ITVKVideoFx {
    public static final int DOLBY_VISION_PQ_MODE_BRIGHT = 0;
    public static final int DOLBY_VISION_PQ_MODE_DARK = 2;
    public static final int DOLBY_VISION_PQ_MODE_VIVID = 1;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface DolbyVisionPQMode {
    }

    void setDolbyVisionPQMode(int i3);
}
