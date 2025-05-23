package com.tencent.tavkit.composition.builder;

import com.tencent.tavkit.composition.audio.TAVAudioTransition;

/* compiled from: P */
/* loaded from: classes26.dex */
class AudioTransitionInfo {
    TAVAudioTransition next;
    TAVAudioTransition prev;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioTransitionInfo(TAVAudioTransition tAVAudioTransition, TAVAudioTransition tAVAudioTransition2) {
        this.prev = tAVAudioTransition;
        this.next = tAVAudioTransition2;
    }
}
