package com.tencent.tavkit.composition.resource;

import androidx.annotation.Nullable;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.ciimage.CIImage;
import java.util.HashMap;

/* compiled from: P */
@Deprecated
/* loaded from: classes26.dex */
public class TAVImageResource extends TAVResource {
    private HashMap<Thread, CIImage> ciImageHashMap;
    private boolean emptyAudioTrack;
    private CIImage image;

    public TAVImageResource(CIImage cIImage, CMTime cMTime) {
        this(cIImage, cMTime, false);
    }

    @Override // com.tencent.tavkit.composition.resource.TAVResource
    public CIImage imageAtTime(CMTime cMTime, CGSize cGSize) {
        if (!this.sourceTimeRange.containsTime(cMTime) || this.image == null) {
            return null;
        }
        Thread currentThread = Thread.currentThread();
        CIImage cIImage = this.ciImageHashMap.get(currentThread);
        if (cIImage == null) {
            cIImage = this.image.simpleClone();
            this.ciImageHashMap.put(currentThread, cIImage);
        }
        cIImage.reset();
        return cIImage;
    }

    @Override // com.tencent.tavkit.composition.resource.TAVResource
    @Nullable
    public TrackInfo trackInfoForType(int i3, int i16) {
        if (i3 == 1) {
            return newEmptyTrackInfo(i3, i16);
        }
        if (this.emptyAudioTrack && i3 == 2) {
            return newEmptyTrackInfo(i3, i16);
        }
        return null;
    }

    public TAVImageResource(CIImage cIImage, CMTime cMTime, boolean z16) {
        this.ciImageHashMap = new HashMap<>();
        this.image = cIImage;
        this.duration = cMTime;
        this.sourceTimeRange = new CMTimeRange(CMTime.CMTimeZero, cMTime);
        this.emptyAudioTrack = z16;
    }

    @Override // com.tencent.tavkit.composition.resource.TAVResource
    /* renamed from: clone */
    public TAVResource mo272clone() {
        TAVImageResource tAVImageResource = new TAVImageResource(this.image, this.duration.m259clone());
        tAVImageResource.sourceTimeRange = this.sourceTimeRange.m260clone();
        tAVImageResource.scaledDuration = this.scaledDuration.m259clone();
        tAVImageResource.ciImageHashMap = this.ciImageHashMap;
        return tAVImageResource;
    }
}
