package com.tencent.qqlive.tvkplayer.postprocess.tpprocessor;

import com.tencent.qqlive.tvkplayer.api.postprocess.effect.audio.ITVKClearVoiceFx;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKClearVoiceFx implements ITVKClearVoiceFx {
    private static final String AUDIO_EFFECT_CLEAR_VOICE = "clear_voice";

    @Override // com.tencent.qqlive.tvkplayer.api.postprocess.effect.audio.ITVKAudioFx
    public String audioFxDescription() {
        return "clear_voice";
    }
}
