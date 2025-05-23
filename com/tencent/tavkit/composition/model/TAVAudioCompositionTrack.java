package com.tencent.tavkit.composition.model;

import com.tencent.tav.asset.CompositionTrack;
import com.tencent.tav.asset.MutableComposition;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface TAVAudioCompositionTrack {
    CompositionTrack audioCompositionTrackForComposition(MutableComposition mutableComposition, int i3, boolean z16);

    int numberOfAudioTracks();
}
