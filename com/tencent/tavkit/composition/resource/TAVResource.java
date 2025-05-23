package com.tencent.tavkit.composition.resource;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.asset.MutableComposition;
import com.tencent.tav.asset.MutableCompositionTrack;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.ciimage.CIImage;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class TAVResource implements Cloneable {

    @NonNull
    protected CMTime duration;

    @NonNull
    protected CMTime scaledDuration;

    @NonNull
    protected CMTimeRange sourceTimeRange;

    public TAVResource() {
        CMTime cMTime = CMTime.CMTimeZero;
        this.duration = cMTime;
        this.sourceTimeRange = new CMTimeRange(cMTime, cMTime);
        this.scaledDuration = CMTime.CMTimeInvalid;
    }

    @Override // 
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public abstract TAVResource mo272clone();

    public CMTime getDuration() {
        return this.duration;
    }

    public CMTime getScaledDuration() {
        if (this.scaledDuration.equals(CMTime.CMTimeInvalid)) {
            return this.sourceTimeRange.getDuration();
        }
        return this.scaledDuration;
    }

    @NonNull
    public CMTimeRange getSourceTimeRange() {
        return this.sourceTimeRange;
    }

    public CIImage imageAtTime(CMTime cMTime, CGSize cGSize) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public TrackInfo newEmptyTrackInfo(int i3, int i16) {
        AssetTrack assetTrack = tracksForType(i3).get(i16);
        TrackInfo trackInfo = new TrackInfo();
        trackInfo.setTrack(assetTrack);
        trackInfo.setSelectedTimeRange(new CMTimeRange(CMTime.CMTimeZero, new CMTime(1L, 30)));
        trackInfo.setScaleToDuration(getScaledDuration());
        return trackInfo;
    }

    public void setDuration(@NonNull CMTime cMTime) {
        this.duration = cMTime;
    }

    public void setScaledDuration(@NonNull CMTime cMTime) {
        this.scaledDuration = cMTime;
    }

    public void setSourceTimeRange(@NonNull CMTimeRange cMTimeRange) {
        this.sourceTimeRange = cMTimeRange.m260clone();
    }

    public String toString() {
        return "TAVResource{duration=" + this.duration.getTimeUs() + ", sourceTimeRange=" + this.sourceTimeRange.toSimpleString() + ", scaledDuration=" + this.scaledDuration.getTimeUs() + '}';
    }

    @Nullable
    public TrackInfo trackInfoForType(int i3, int i16) {
        return newEmptyTrackInfo(i3, i16);
    }

    public List<AssetTrack> tracksForType(int i3) {
        ArrayList arrayList = new ArrayList();
        MutableCompositionTrack addMutableTrackWithMediaType = new MutableComposition().addMutableTrackWithMediaType(i3, 0);
        addMutableTrackWithMediaType.insertEmptyTimeRange(new CMTimeRange(CMTime.CMTimeZero, this.duration));
        arrayList.add(addMutableTrackWithMediaType);
        return arrayList;
    }
}
