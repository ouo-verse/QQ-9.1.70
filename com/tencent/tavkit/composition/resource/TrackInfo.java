package com.tencent.tavkit.composition.resource;

import androidx.annotation.Nullable;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.asset.CompositionTrackSegment;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TrackInfo {
    private CompositionTrackSegment compositionTrackSegment;
    private CMTime scaleToDuration;
    private CMTimeRange selectedTimeRange;

    @Nullable
    private AssetTrack track;

    public CompositionTrackSegment getCompositionTrackSegment(CMTimeRange cMTimeRange) {
        CompositionTrackSegment compositionTrackSegment = new CompositionTrackSegment(this.compositionTrackSegment.getSourcePath(), this.compositionTrackSegment.getSourceTrackID(), this.compositionTrackSegment.getTimeMapping().getSource(), cMTimeRange, this.compositionTrackSegment.getSourceType());
        compositionTrackSegment.setExtraInfo(this.compositionTrackSegment.getExtraInfo());
        return compositionTrackSegment;
    }

    public int getMediaType() {
        AssetTrack assetTrack = this.track;
        if (assetTrack != null) {
            return assetTrack.getMediaType();
        }
        CompositionTrackSegment compositionTrackSegment = this.compositionTrackSegment;
        if (compositionTrackSegment != null) {
            int sourceType = compositionTrackSegment.getSourceType();
            if (sourceType == 3) {
                return 1;
            }
            return sourceType;
        }
        return 0;
    }

    public CMTime getScaleToDuration() {
        return this.scaleToDuration;
    }

    public CMTimeRange getSelectedTimeRange() {
        return this.selectedTimeRange;
    }

    @Nullable
    public AssetTrack getTrack() {
        return this.track;
    }

    public void setCompositionTrackSegment(CompositionTrackSegment compositionTrackSegment) {
        this.compositionTrackSegment = compositionTrackSegment;
    }

    public void setScaleToDuration(CMTime cMTime) {
        this.scaleToDuration = cMTime;
    }

    public void setSelectedTimeRange(CMTimeRange cMTimeRange) {
        this.selectedTimeRange = cMTimeRange;
    }

    public void setTrack(AssetTrack assetTrack) {
        this.track = assetTrack;
    }
}
