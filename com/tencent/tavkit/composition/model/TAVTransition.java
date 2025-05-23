package com.tencent.tavkit.composition.model;

import com.tencent.tav.core.MutableAudioMixInputParameters;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.audio.TAVAudioTransition;
import com.tencent.tavkit.composition.video.TAVVideoTransition;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVTransition {
    private TAVAudioTransition audioTransition;
    private CMTime duration;
    private TAVVideoTransition videoTransition;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    private static class EmptyVideoTransition implements TAVVideoTransition {
        private CMTime duration;

        public EmptyVideoTransition(CMTime cMTime) {
            this.duration = cMTime;
        }

        @Override // com.tencent.tavkit.composition.video.TAVVideoTransition
        public TAVVideoTransition.Filter createFilter() {
            return null;
        }

        @Override // com.tencent.tavkit.composition.video.TAVVideoTransition
        public String effectId() {
            return toString();
        }

        @Override // com.tencent.tavkit.composition.video.TAVVideoTransition
        public CMTime getDuration() {
            return this.duration;
        }
    }

    public TAVTransition(CMTime cMTime) {
        this.duration = cMTime;
        this.audioTransition = new EmptyAudioTransition(cMTime);
        this.videoTransition = new EmptyVideoTransition(cMTime);
    }

    public TAVAudioTransition getAudioTransition() {
        return this.audioTransition;
    }

    public CMTime getDuration() {
        return this.duration;
    }

    public TAVVideoTransition getVideoTransition() {
        return this.videoTransition;
    }

    public void setAudioTransition(TAVAudioTransition tAVAudioTransition) {
        this.audioTransition = tAVAudioTransition;
    }

    public void setVideoTransition(TAVVideoTransition tAVVideoTransition) {
        this.videoTransition = tAVVideoTransition;
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    private static class EmptyAudioTransition implements TAVAudioTransition {
        private CMTime duration;
        private String identifier;

        EmptyAudioTransition(CMTime cMTime) {
            this.duration = cMTime;
        }

        @Override // com.tencent.tavkit.composition.audio.TAVAudioTransition
        public CMTime getDuration() {
            return this.duration;
        }

        @Override // com.tencent.tavkit.composition.audio.TAVAudioTransition
        public String getIdentifier() {
            return this.identifier;
        }

        @Override // com.tencent.tavkit.composition.audio.TAVAudioTransition
        public void setIdentifier(String str) {
            this.identifier = str;
        }

        @Override // com.tencent.tavkit.composition.audio.TAVAudioTransition
        public void applyNextAudioMixInputParameters(MutableAudioMixInputParameters mutableAudioMixInputParameters, CMTimeRange cMTimeRange) {
        }

        @Override // com.tencent.tavkit.composition.audio.TAVAudioTransition
        public void applyPreviousAudioMixInputParameters(MutableAudioMixInputParameters mutableAudioMixInputParameters, CMTimeRange cMTimeRange) {
        }
    }
}
