package com.tencent.tavkit.composition.audio;

import com.tencent.tav.core.MutableAudioMixInputParameters;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface TAVAudioTransition {
    void applyNextAudioMixInputParameters(MutableAudioMixInputParameters mutableAudioMixInputParameters, CMTimeRange cMTimeRange);

    void applyPreviousAudioMixInputParameters(MutableAudioMixInputParameters mutableAudioMixInputParameters, CMTimeRange cMTimeRange);

    CMTime getDuration();

    String getIdentifier();

    void setIdentifier(String str);
}
