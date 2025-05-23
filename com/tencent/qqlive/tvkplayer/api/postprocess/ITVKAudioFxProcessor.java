package com.tencent.qqlive.tvkplayer.api.postprocess;

import com.tencent.qqlive.tvkplayer.api.TVKAudioEffectInfo;
import com.tencent.qqlive.tvkplayer.api.postprocess.effect.audio.ITVKAudioFx;

/* loaded from: classes23.dex */
public interface ITVKAudioFxProcessor extends ITVKPostProcessor {
    boolean addEffect(ITVKAudioFx iTVKAudioFx);

    TVKAudioEffectInfo[] getSupportedAudioEffectInfo();

    void removeAllEffects();

    void removeEffect(ITVKAudioFx iTVKAudioFx);

    void setListener(ITVKAudioPostProcessorListener iTVKAudioPostProcessorListener);
}
