package com.tencent.tavkit.composition.resource;

import androidx.annotation.Nullable;
import com.tencent.tav.asset.CompositionTrackSegment;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.ImageDecoder;
import com.tencent.tavkit.ciimage.CIImage;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVImageTrackResource extends TAVResource {
    private boolean emptyAudioTrack;

    @Nullable
    private CGSize imageDecodeSize;
    private String path;

    public TAVImageTrackResource(String str, CMTime cMTime) {
        this(str, cMTime, false);
    }

    public String getPath() {
        return this.path;
    }

    @Override // com.tencent.tavkit.composition.resource.TAVResource
    public CIImage imageAtTime(CMTime cMTime, CGSize cGSize) {
        return null;
    }

    public void setImageDecodeSize(CGSize cGSize) {
        this.imageDecodeSize = cGSize;
    }

    @Override // com.tencent.tavkit.composition.resource.TAVResource
    @Nullable
    public TrackInfo trackInfoForType(int i3, int i16) {
        if (i3 != 1 && !this.emptyAudioTrack) {
            return null;
        }
        if (i3 == 1) {
            i3 = 3;
        }
        String str = this.path;
        CMTimeRange cMTimeRange = this.sourceTimeRange;
        CompositionTrackSegment compositionTrackSegment = new CompositionTrackSegment(str, 0, cMTimeRange, cMTimeRange, i3);
        if (this.imageDecodeSize != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(ImageDecoder.EXTRA_INFO_KEY_DECODE_SIZE, this.imageDecodeSize);
            compositionTrackSegment.setExtraInfo(hashMap);
        }
        TrackInfo trackInfo = new TrackInfo();
        trackInfo.setCompositionTrackSegment(compositionTrackSegment);
        trackInfo.setSelectedTimeRange(getSourceTimeRange());
        trackInfo.setScaleToDuration(getScaledDuration());
        return trackInfo;
    }

    public TAVImageTrackResource(String str, CMTime cMTime, boolean z16) {
        this.path = str;
        this.emptyAudioTrack = z16;
        this.duration = cMTime;
        this.sourceTimeRange = new CMTimeRange(CMTime.CMTimeZero, cMTime);
    }

    @Override // com.tencent.tavkit.composition.resource.TAVResource
    /* renamed from: clone */
    public TAVImageTrackResource mo272clone() {
        TAVImageTrackResource tAVImageTrackResource = new TAVImageTrackResource(this.path, this.duration.m259clone());
        tAVImageTrackResource.sourceTimeRange = this.sourceTimeRange.m260clone();
        tAVImageTrackResource.scaledDuration = this.scaledDuration.m259clone();
        return tAVImageTrackResource;
    }
}
