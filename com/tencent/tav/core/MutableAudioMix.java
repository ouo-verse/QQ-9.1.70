package com.tencent.tav.core;

import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class MutableAudioMix extends AudioMix {
    public MutableAudioMix(List<? extends AudioMixInputParameters> list) {
        super(list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setInputParameters(List<AudioMixInputParameters> list) {
        this.inputParameters = list;
    }
}
