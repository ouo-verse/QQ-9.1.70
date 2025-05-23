package com.tencent.qqlive.tvkplayer.postprocess.tpprocessor;

import com.tencent.qqlive.tvkplayer.api.postprocess.effect.audio.ITVKSurroundFx;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKSurroundFx implements ITVKSurroundFx {
    private static final String AUDIO_EFFECT_SURROUND = "surround";

    @Override // com.tencent.qqlive.tvkplayer.api.postprocess.effect.audio.ITVKAudioFx
    public String audioFxDescription() {
        return "surround";
    }
}
