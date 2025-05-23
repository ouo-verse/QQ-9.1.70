package com.tencent.qqlive.tvkplayer.api.postprocess;

import com.tencent.qqlive.tvkplayer.api.postprocess.effect.video.ITVKVideoFx;

/* loaded from: classes23.dex */
public interface ITVKVideoFxProcessor extends ITVKPostProcessor {
    void addFxModel(ITVKVideoFx iTVKVideoFx) throws IllegalStateException;

    void removeFx(ITVKVideoFx iTVKVideoFx);
}
