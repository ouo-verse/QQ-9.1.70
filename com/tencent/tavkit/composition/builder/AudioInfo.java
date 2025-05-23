package com.tencent.tavkit.composition.builder;

import androidx.annotation.Nullable;
import com.tencent.tav.asset.CompositionTrack;
import com.tencent.tav.asset.CompositionTrackSegment;
import com.tencent.tavkit.composition.model.TAVTransitionableAudio;

/* compiled from: P */
/* loaded from: classes26.dex */
class AudioInfo {
    TAVTransitionableAudio audio;
    CompositionTrack compositionTrack;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioInfo(CompositionTrack compositionTrack, TAVTransitionableAudio tAVTransitionableAudio) {
        this.compositionTrack = compositionTrack;
        this.audio = tAVTransitionableAudio;
    }

    @Nullable
    CompositionTrackSegment getCurrentSegmentBy() {
        for (int i3 = 0; i3 < this.compositionTrack.getSegments().size(); i3++) {
            CompositionTrackSegment compositionTrackSegment = this.compositionTrack.getSegments().get(i3);
            if (compositionTrackSegment.getTimeMapping().getTarget().equals(this.audio.getTimeRange())) {
                return compositionTrackSegment;
            }
        }
        return null;
    }
}
