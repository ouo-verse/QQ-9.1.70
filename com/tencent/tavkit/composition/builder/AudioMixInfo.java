package com.tencent.tavkit.composition.builder;

import com.tencent.tav.asset.CompositionTrack;
import com.tencent.tavkit.composition.model.TAVAudio;

/* compiled from: P */
/* loaded from: classes26.dex */
class AudioMixInfo {
    TAVAudio audio;
    CompositionTrack track;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioMixInfo(CompositionTrack compositionTrack, TAVAudio tAVAudio) {
        this.track = compositionTrack;
        this.audio = tAVAudio;
    }
}
