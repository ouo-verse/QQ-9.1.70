package com.tencent.tav.decoder;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.asset.AssetTrackSegment;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;

/* compiled from: P */
/* loaded from: classes26.dex */
public class DecoderTrackSegment {
    private CMTime decoderStartTime;
    private CMTime scaledDuration;
    private CMTimeRange timeRange;
    private DecoderAssetTrack videoAsset;

    public DecoderTrackSegment(long j3) {
        this(new CMTimeRange(CMTime.CMTimeZero, new CMTime(((float) j3) / 1000.0f)), (DecoderAssetTrack) null);
    }

    public CMTime getDecoderStartTime() {
        return this.decoderStartTime;
    }

    public CMTime getScaledDuration() {
        return this.scaledDuration;
    }

    @NonNull
    public CMTimeRange getTimeRange() {
        return this.timeRange;
    }

    @Nullable
    public DecoderAssetTrack getVideoAsset() {
        return this.videoAsset;
    }

    public void setScaledDuration(CMTime cMTime) {
        this.scaledDuration = cMTime;
    }

    public void setTimeRange(@NonNull CMTimeRange cMTimeRange) {
        this.timeRange = cMTimeRange;
    }

    public DecoderTrackSegment(@NonNull CMTimeRange cMTimeRange, @Nullable DecoderAssetTrack decoderAssetTrack) {
        this.videoAsset = decoderAssetTrack;
        this.timeRange = cMTimeRange;
        this.scaledDuration = cMTimeRange.getDuration();
        this.decoderStartTime = CMTime.CMTimeZero;
    }

    public DecoderTrackSegment(AssetTrack assetTrack, AssetTrackSegment assetTrackSegment) {
        this(assetTrackSegment.getTimeMapping().getSource().m260clone(), DecoderAssetTrack.create(assetTrack, assetTrackSegment));
        setScaledDuration(assetTrackSegment.getScaleDuration());
    }
}
