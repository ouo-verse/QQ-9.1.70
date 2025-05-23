package com.tencent.qqlive.tvkplayer.postprocess.tpprocessor;

import com.tencent.qqlive.tvkplayer.api.postprocess.effect.audio.ITVKPanoSurroundFx;

/* loaded from: classes23.dex */
public class TVKPanoSurroundFx implements ITVKPanoSurroundFx {
    private static final String AUDIO_EFFECT_PANO_SURROUND = "pano_surround";

    @Override // com.tencent.qqlive.tvkplayer.api.postprocess.effect.audio.ITVKAudioFx
    public String audioFxDescription() {
        return "pano_surround";
    }
}
