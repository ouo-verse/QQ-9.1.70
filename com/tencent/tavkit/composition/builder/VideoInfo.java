package com.tencent.tavkit.composition.builder;

import com.tencent.tav.asset.CompositionTrack;
import com.tencent.tavkit.composition.model.TAVTransitionableVideo;

/* compiled from: P */
/* loaded from: classes26.dex */
class VideoInfo {
    TAVTransitionableVideo clip;
    CompositionTrack compositionTrack;

    /* JADX INFO: Access modifiers changed from: package-private */
    public VideoInfo(CompositionTrack compositionTrack, TAVTransitionableVideo tAVTransitionableVideo) {
        this.compositionTrack = compositionTrack;
        this.clip = tAVTransitionableVideo;
    }
}
