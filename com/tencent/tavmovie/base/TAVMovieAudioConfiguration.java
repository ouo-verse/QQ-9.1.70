package com.tencent.tavmovie.base;

import com.tencent.tavkit.composition.model.TAVAudioConfiguration;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVMovieAudioConfiguration implements Cloneable {
    private TAVAudioConfiguration.VolumeEdge endVolumeEdge;
    private TAVAudioConfiguration.VolumeEdge startVolumeEdge;
    private float volume = 1.0f;

    public TAVAudioConfiguration convertToConfiguration() {
        TAVAudioConfiguration tAVAudioConfiguration = new TAVAudioConfiguration();
        tAVAudioConfiguration.setVolume(this.volume);
        tAVAudioConfiguration.setStartVolumeEdge(this.startVolumeEdge);
        tAVAudioConfiguration.setEndVolumeEdge(this.endVolumeEdge);
        return tAVAudioConfiguration;
    }

    public TAVAudioConfiguration.VolumeEdge getEndVolumeEdge() {
        return this.endVolumeEdge;
    }

    public TAVAudioConfiguration.VolumeEdge getStartVolumeEdge() {
        return this.startVolumeEdge;
    }

    public float getVolume() {
        return this.volume;
    }

    public void setEndVolumeEdge(TAVAudioConfiguration.VolumeEdge volumeEdge) {
        this.endVolumeEdge = volumeEdge;
    }

    public void setStartVolumeEdge(TAVAudioConfiguration.VolumeEdge volumeEdge) {
        this.startVolumeEdge = volumeEdge;
    }

    public void setVolume(float f16) {
        this.volume = f16;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public TAVMovieAudioConfiguration m274clone() {
        TAVMovieAudioConfiguration tAVMovieAudioConfiguration = new TAVMovieAudioConfiguration();
        tAVMovieAudioConfiguration.volume = this.volume;
        tAVMovieAudioConfiguration.startVolumeEdge = this.startVolumeEdge;
        tAVMovieAudioConfiguration.endVolumeEdge = this.endVolumeEdge;
        return tAVMovieAudioConfiguration;
    }
}
