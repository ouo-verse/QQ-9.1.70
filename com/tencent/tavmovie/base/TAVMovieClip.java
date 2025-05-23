package com.tencent.tavmovie.base;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavmovie.resource.TAVMovieImageResource;
import com.tencent.tavmovie.resource.TAVMovieResource;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVMovieClip implements Cloneable {
    private TAVMovieResource resource;
    private TAVMovieVideoConfiguration videoConfiguration = new TAVMovieVideoConfiguration();
    private TAVMovieAudioConfiguration audioConfiguration = new TAVMovieAudioConfiguration();
    private CMTime startTime = CMTime.CMTimeZero;

    public TAVClip convertToClip() {
        TAVClip tAVClip = new TAVClip(this.resource.convertToResource());
        TAVMovieVideoConfiguration tAVMovieVideoConfiguration = this.videoConfiguration;
        if (tAVMovieVideoConfiguration != null) {
            tAVClip.setVideoConfiguration(tAVMovieVideoConfiguration.convertToConfiguration());
        }
        TAVMovieAudioConfiguration tAVMovieAudioConfiguration = this.audioConfiguration;
        if (tAVMovieAudioConfiguration != null) {
            tAVClip.setAudioConfiguration(tAVMovieAudioConfiguration.convertToConfiguration());
        }
        tAVClip.setStartTime(this.startTime);
        return tAVClip;
    }

    public TAVMovieClip dataClone() {
        TAVMovieClip tAVMovieClip = new TAVMovieClip();
        tAVMovieClip.setResource(this.resource.dataClone());
        tAVMovieClip.setVideoConfiguration(this.videoConfiguration.m277clone());
        tAVMovieClip.setAudioConfiguration(this.audioConfiguration.m274clone());
        tAVMovieClip.setStartTime(this.startTime.m259clone());
        return tAVMovieClip;
    }

    public TAVMovieAudioConfiguration getAudioConfiguration() {
        return this.audioConfiguration;
    }

    public int getPreferRotation() {
        return this.videoConfiguration.getPreferRotation();
    }

    public TAVMovieResource getResource() {
        return this.resource;
    }

    public TAVMovieVideoConfiguration getVideoConfiguration() {
        return this.videoConfiguration;
    }

    public void release() {
        TAVMovieResource tAVMovieResource = this.resource;
        if (tAVMovieResource != null && (tAVMovieResource instanceof TAVMovieImageResource)) {
            ((TAVMovieImageResource) tAVMovieResource).release();
        }
    }

    public void setAudioConfiguration(TAVMovieAudioConfiguration tAVMovieAudioConfiguration) {
        this.audioConfiguration = tAVMovieAudioConfiguration;
    }

    public void setPreferRotation(int i3) {
        this.videoConfiguration.setPreferRotation(i3);
    }

    public void setResource(TAVMovieResource tAVMovieResource) {
        this.resource = tAVMovieResource;
    }

    public void setStartTime(CMTime cMTime) {
        this.startTime = cMTime;
    }

    public void setVideoConfiguration(TAVMovieVideoConfiguration tAVMovieVideoConfiguration) {
        this.videoConfiguration = tAVMovieVideoConfiguration;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public TAVMovieClip m275clone() {
        TAVMovieClip tAVMovieClip = new TAVMovieClip();
        tAVMovieClip.setResource(this.resource.mo280clone());
        tAVMovieClip.setVideoConfiguration(this.videoConfiguration.m277clone());
        tAVMovieClip.setAudioConfiguration(this.audioConfiguration.m274clone());
        tAVMovieClip.setStartTime(this.startTime.m259clone());
        return tAVMovieClip;
    }
}
