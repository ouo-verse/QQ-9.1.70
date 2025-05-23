package com.tencent.tavkit.composition.resource;

import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.asset.URLAsset;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVAssetTrackResource extends TAVResource {
    private Asset asset;

    public TAVAssetTrackResource(String str) {
        this(new URLAsset(str, false));
    }

    public Asset getAsset() {
        return this.asset;
    }

    @Override // com.tencent.tavkit.composition.resource.TAVResource
    public TrackInfo trackInfoForType(int i3, int i16) {
        AssetTrack assetTrack = tracksForType(i3).get(i16);
        TrackInfo trackInfo = new TrackInfo();
        trackInfo.setTrack(assetTrack);
        trackInfo.setSelectedTimeRange(getSourceTimeRange());
        trackInfo.setScaleToDuration(getScaledDuration());
        return trackInfo;
    }

    @Override // com.tencent.tavkit.composition.resource.TAVResource
    public List<AssetTrack> tracksForType(int i3) {
        Asset asset = this.asset;
        if (asset != null) {
            return asset.tracksWithMediaType(i3);
        }
        return new ArrayList();
    }

    public TAVAssetTrackResource(Asset asset) {
        this.asset = asset;
        this.duration = asset.getDuration();
        this.sourceTimeRange = new CMTimeRange(CMTime.CMTimeZero, asset.getDuration());
    }

    @Override // com.tencent.tavkit.composition.resource.TAVResource
    /* renamed from: clone */
    public TAVResource mo272clone() {
        TAVAssetTrackResource tAVAssetTrackResource = new TAVAssetTrackResource(this.asset);
        tAVAssetTrackResource.sourceTimeRange = this.sourceTimeRange.m260clone();
        tAVAssetTrackResource.scaledDuration = this.scaledDuration.m259clone();
        tAVAssetTrackResource.duration = this.duration.m259clone();
        return tAVAssetTrackResource;
    }
}
