package com.tencent.tav.asset;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class CompositionTrack extends AssetTrack<CompositionTrackSegment> {
    protected List<CompositionTrackSegment> segments;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CompositionTrack() {
        this.segments = new ArrayList();
    }

    @Override // com.tencent.tav.asset.AssetTrack
    public List<CompositionTrackSegment> getSegments() {
        return this.segments;
    }

    public String toString() {
        return "CompositionTrack{segments=" + this.segments + ", trackID=" + this.trackID + ", mediaType=" + this.mediaType + '}';
    }

    @Override // com.tencent.tav.asset.AssetTrack
    public CompositionTrackSegment segmentForTrackTime(CMTime cMTime) {
        CMTimeRange target;
        List<CompositionTrackSegment> list = this.segments;
        if (list == null) {
            return null;
        }
        for (CompositionTrackSegment compositionTrackSegment : list) {
            if (compositionTrackSegment != null && (target = compositionTrackSegment.getTimeMapping().getTarget()) != null && target.containsTime(cMTime) && (compositionTrackSegment instanceof CompositionTrackSegment)) {
                return compositionTrackSegment;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CompositionTrack(Asset asset, int i3, int i16, CMTimeRange cMTimeRange) {
        super(asset, i3, i16, cMTimeRange);
        this.segments = new ArrayList();
    }
}
