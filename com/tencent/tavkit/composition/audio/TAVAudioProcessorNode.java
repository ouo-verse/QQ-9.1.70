package com.tencent.tavkit.composition.audio;

import com.tencent.tav.core.AudioTapProcessor;

/* loaded from: classes26.dex */
public interface TAVAudioProcessorNode {

    /* loaded from: classes26.dex */
    public interface TAVAudioProcessorEffect extends AudioTapProcessor {
    }

    TAVAudioProcessorEffect createAudioProcessor();

    String getIdentifier();
}
