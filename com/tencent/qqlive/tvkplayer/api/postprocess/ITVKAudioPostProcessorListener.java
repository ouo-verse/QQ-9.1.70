package com.tencent.qqlive.tvkplayer.api.postprocess;

import com.tencent.qqlive.tvkplayer.api.postprocess.effect.audio.ITVKAudioFx;

/* loaded from: classes23.dex */
public interface ITVKAudioPostProcessorListener {
    void onCurrentEffectDisable(ITVKAudioFx iTVKAudioFx);

    void onSupportedAudioEffectInfoUpdate();
}
