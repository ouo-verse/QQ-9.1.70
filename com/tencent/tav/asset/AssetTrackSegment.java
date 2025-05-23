package com.tencent.tav.asset;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeMapping;
import com.tencent.tav.coremedia.CMTimeRange;

/* compiled from: P */
/* loaded from: classes26.dex */
public class AssetTrackSegment {
    protected boolean empty;
    protected CMTime scaleDuration;
    protected CMTimeMapping timeMapping;
    protected CMTimeRange timeRange;

    protected AssetTrackSegment() {
        this.scaleDuration = CMTime.CMTimeZero;
    }

    public CMTime getScaleDuration() {
        return this.scaleDuration;
    }

    public CMTimeMapping getTimeMapping() {
        return this.timeMapping;
    }

    public boolean isEmpty() {
        return this.empty;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AssetTrackSegment(CMTimeRange cMTimeRange, CMTimeRange cMTimeRange2) {
        this.scaleDuration = CMTime.CMTimeZero;
        this.timeMapping = new CMTimeMapping(cMTimeRange, cMTimeRange2);
        this.scaleDuration = cMTimeRange2.getDuration().m259clone();
        this.timeRange = cMTimeRange2.m260clone();
    }
}
