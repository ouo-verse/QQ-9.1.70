package com.tencent.tav.core;

import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.core.AudioMixInputParameters;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.Iterator;

/* loaded from: classes26.dex */
public class MutableAudioMixInputParameters extends AudioMixInputParameters {
    public MutableAudioMixInputParameters(AssetTrack assetTrack, String str) {
        super(assetTrack.getTrackID(), str);
    }

    public void setAudioTapProcessor(AudioTapProcessor audioTapProcessor) {
        this.audioTapProcessor = audioTapProcessor;
    }

    public void setAudioTimePitchAlgorithm(String str) {
        this.audioTimePitchAlgorithm = str;
    }

    public void setTrackID(int i3) {
        this.trackID = i3;
    }

    public void setVolumeForTimeRange(float f16) {
        Iterator<AudioMixInputParameters.VolumeRange> it = this.volumeRanges.iterator();
        while (it.hasNext()) {
            AudioMixInputParameters.VolumeRange next = it.next();
            next.startVolume = f16;
            next.endVolume = f16;
        }
    }

    public void setVolumeRampForTimeRange(float f16, float f17, CMTimeRange cMTimeRange) {
        AudioMixInputParameters.VolumeRange volumeRange = new AudioMixInputParameters.VolumeRange();
        volumeRange.timeRange = cMTimeRange;
        volumeRange.startVolume = f16;
        volumeRange.endVolume = f17;
        this.volumeRanges.add(0, volumeRange);
    }

    public MutableAudioMixInputParameters(AssetTrack assetTrack) {
        super(assetTrack.getTrackID(), "");
    }

    public void setVolumeForTimeRange(float f16, CMTimeRange cMTimeRange) {
        setVolumeRampForTimeRange(f16, f16, cMTimeRange);
    }

    public void setVolumeAtTime(float f16, CMTime cMTime) {
    }
}
