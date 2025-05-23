package com.tencent.tavmovie.resource;

import android.text.TextUtils;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.URLAsset;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.composition.resource.TAVAssetTrackResource;
import com.tencent.tavkit.composition.resource.TAVResource;
import com.tencent.tavmovie.base.TAVMovieTimeEffect;
import com.tencent.tavmovie.resource.TAVMovieResource;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVMovieTrackResource extends TAVMovieResource {
    private static final String TAG = "TAVMovieTrackResource";
    private transient Asset asset;
    private String filePath;

    public TAVMovieTrackResource(Asset asset) {
        this.asset = asset;
        reloadAVAsset();
    }

    private void loadAVAssetImpl() {
        if (TextUtils.isEmpty(this.filePath)) {
            this.status = TAVMovieResource.TAVMovieResourceStatus.TAVMovieResourceStatusError;
            return;
        }
        try {
            tryInitAsset();
        } catch (Throwable th5) {
            Logger.e(TAG, "loadAVAssetImpl: ", th5);
            this.status = TAVMovieResource.TAVMovieResourceStatus.TAVMovieResourceStatusError;
            this.asset = null;
        }
    }

    private void reloadAVAsset() {
        Asset asset = this.asset;
        if (asset != null) {
            this.filePath = asset.getSourcePath();
            this.timeRange = new CMTimeRange(CMTime.CMTimeZero, this.asset.getDuration());
            this.naturalSize = this.asset.getNaturalSize();
            this.status = TAVMovieResource.TAVMovieResourceStatus.TAVMovieResourceStatusAvailable;
        }
    }

    private void tryInitAsset() {
        this.asset = new URLAsset(this.filePath);
        this.timeRange = new CMTimeRange(CMTime.CMTimeZero, this.asset.getDuration());
        this.naturalSize = this.asset.getNaturalSize();
        this.status = TAVMovieResource.TAVMovieResourceStatus.TAVMovieResourceStatusAvailable;
    }

    @Override // com.tencent.tavmovie.resource.TAVMovieResource
    public TAVResource convertToResource() {
        Asset asset = this.asset;
        if (asset == null) {
            return null;
        }
        TAVAssetTrackResource tAVAssetTrackResource = new TAVAssetTrackResource(asset);
        CMTimeRange cMTimeRange = this.timeRange;
        if (cMTimeRange != null && cMTimeRange.getDurationUs() > 0) {
            tAVAssetTrackResource.setSourceTimeRange(this.timeRange);
            TAVMovieTimeEffect tAVMovieTimeEffect = this.timeEffect;
            if (tAVMovieTimeEffect != null) {
                float speed = tAVMovieTimeEffect.getSpeed();
                if (speed == 0.0f) {
                    tAVAssetTrackResource.setSourceTimeRange(this.timeEffect.getSourceTimeRange());
                    tAVAssetTrackResource.setScaledDuration(this.timeEffect.getTimeRange().getDuration());
                } else {
                    tAVAssetTrackResource.setSourceTimeRange(getTimeRange());
                    tAVAssetTrackResource.setScaledDuration(getTimeRange().getDuration().divide(speed));
                }
            }
        }
        return tAVAssetTrackResource;
    }

    public Asset getAsset() {
        return this.asset;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public void loadAVAsset() {
        if (this.asset == null && this.status != TAVMovieResource.TAVMovieResourceStatus.TAVMovieResourceStatusError) {
            loadAVAssetImpl();
        }
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
        reloadAVAsset();
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    @Override // com.tencent.tavmovie.resource.TAVMovieResource
    public TAVMovieTrackResource dataClone() {
        TAVMovieTrackResource tAVMovieTrackResource = new TAVMovieTrackResource(this.asset);
        tAVMovieTrackResource.cloneFrom(this);
        return tAVMovieTrackResource;
    }

    @Override // com.tencent.tavmovie.resource.TAVMovieResource
    /* renamed from: clone */
    public TAVMovieTrackResource mo280clone() {
        TAVMovieTrackResource tAVMovieTrackResource = new TAVMovieTrackResource(this.filePath);
        tAVMovieTrackResource.cloneFrom(this);
        return tAVMovieTrackResource;
    }

    public TAVMovieTrackResource(String str) {
        this.filePath = str;
        loadAVAssetImpl();
    }
}
