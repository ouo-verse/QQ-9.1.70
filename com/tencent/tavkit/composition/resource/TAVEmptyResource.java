package com.tencent.tavkit.composition.resource;

import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.ciimage.CIImage;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVEmptyResource extends TAVResource {
    private boolean insertTimeRange;
    private boolean provideEmptyImage;

    public TAVEmptyResource(CMTime cMTime) {
        this(cMTime, true);
    }

    @Override // com.tencent.tavkit.composition.resource.TAVResource
    public CIImage imageAtTime(CMTime cMTime, CGSize cGSize) {
        if (this.provideEmptyImage) {
            return new CIImage(cGSize);
        }
        return null;
    }

    public void setInsertTimeRange(boolean z16) {
        this.insertTimeRange = z16;
    }

    public void setProvideEmptyImage(boolean z16) {
        this.provideEmptyImage = z16;
    }

    @Override // com.tencent.tavkit.composition.resource.TAVResource
    public TrackInfo trackInfoForType(int i3, int i16) {
        if (!this.insertTimeRange) {
            return null;
        }
        return super.trackInfoForType(i3, i16);
    }

    public TAVEmptyResource(CMTime cMTime, boolean z16) {
        this(cMTime, z16, false);
    }

    @Override // com.tencent.tavkit.composition.resource.TAVResource
    /* renamed from: clone */
    public TAVResource mo272clone() {
        TAVEmptyResource tAVEmptyResource = new TAVEmptyResource(this.duration.m259clone());
        tAVEmptyResource.insertTimeRange = this.insertTimeRange;
        tAVEmptyResource.provideEmptyImage = this.provideEmptyImage;
        tAVEmptyResource.sourceTimeRange = this.sourceTimeRange.m260clone();
        tAVEmptyResource.scaledDuration = this.scaledDuration.m259clone();
        return tAVEmptyResource;
    }

    public TAVEmptyResource(CMTime cMTime, boolean z16, boolean z17) {
        this.provideEmptyImage = z17;
        this.insertTimeRange = z16;
        this.duration = cMTime;
        this.sourceTimeRange = new CMTimeRange(CMTime.CMTimeZero, cMTime);
    }
}
