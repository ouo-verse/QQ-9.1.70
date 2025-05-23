package com.tencent.qqlive.tvkplayer.postprocess.tpprocessor;

import com.tencent.qqlive.tvkplayer.api.postprocess.effect.audio.ITVKLiveConcertFx;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKLiveConcertFx implements ITVKLiveConcertFx {
    private static final String AUDIO_EFFECT_LIVE_CONCERT = "live_concert";

    @Override // com.tencent.qqlive.tvkplayer.api.postprocess.effect.audio.ITVKAudioFx
    public String audioFxDescription() {
        return "live_concert";
    }
}
