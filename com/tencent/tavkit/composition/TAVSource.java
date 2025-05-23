package com.tencent.tavkit.composition;

import com.tencent.tav.asset.Asset;
import com.tencent.tav.core.AudioMix;
import com.tencent.tav.core.composition.VideoComposition;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVSource {
    private Asset asset;
    private AudioMix audioMix;
    private VideoComposition videoComposition;

    public Asset getAsset() {
        return this.asset;
    }

    public AudioMix getAudioMix() {
        return this.audioMix;
    }

    public VideoComposition getVideoComposition() {
        return this.videoComposition;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public void setAudioMix(AudioMix audioMix) {
        this.audioMix = audioMix;
    }

    public void setVideoComposition(VideoComposition videoComposition) {
        this.videoComposition = videoComposition;
    }

    public String toString() {
        return "TAVSource{\nasset=" + this.asset + "\nvideoComposition=" + this.videoComposition + "\naudioMix=" + this.audioMix + '}';
    }
}
