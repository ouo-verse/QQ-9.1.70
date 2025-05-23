package com.tencent.qqlive.tvkplayer.postprocess.api;

import com.tencent.qqlive.tvkplayer.api.postprocess.ITVKAudioFxProcessor;
import com.tencent.qqlive.tvkplayer.api.postprocess.effect.audio.ITVKAudioFx;

/* loaded from: classes23.dex */
public interface ITVKAudioFxProcessorInternal extends ITVKAudioFxProcessor {
    ITVKAudioFx currentEffect();

    void destroy();

    boolean flush();

    boolean hasAudioEffect();

    TVKSonaAudioFrame onAudioData(TVKSonaAudioFrame tVKSonaAudioFrame);
}
