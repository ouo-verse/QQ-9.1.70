package com.tencent.tav.asset;

import android.graphics.Matrix;
import com.tencent.tav.asset.AssetTrackSegment;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.tav.extractor.AssetExtractor;
import com.tencent.tav.extractor.ExtractorUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class AssetTrack<Segment extends AssetTrackSegment> {
    public static final int PersistentTrackID_Invalid = -1;
    protected WeakReference<Asset> asset;
    protected List<String> availableMetadataFormats;
    protected List<String> availableTrackAssociationTypes;
    protected List<MetadataItem> commonMetadata;
    protected boolean enabled;
    protected float estimatedDataRate;
    protected HashMap<String, Object> extraInfo;
    protected int mediaType;
    protected CGSize naturalSize;
    protected int naturalTimeScale;
    protected float nominalFrameRate;
    protected int preferredRotation;
    protected Matrix preferredTransform;
    protected float preferredVolume;
    protected List<Segment> segments;
    protected String sourcePath;
    protected CMTimeRange timeRange;
    protected long totalSampleDataLength;
    protected int trackID;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AssetTrack() {
        this.enabled = true;
        this.preferredVolume = 1.0f;
        this.preferredRotation = 0;
        this.nominalFrameRate = 30.0f;
        this.segments = new ArrayList();
    }

    public List<AssetTrack> associatedTracksOfType(String str) {
        return null;
    }

    protected void createAssetTrackSegments(Asset asset) {
        if (this.segments == null) {
            this.segments = new ArrayList();
        }
        if (asset != null && asset.getTrackCount() > this.trackID) {
            CMTimeRange cMTimeRange = this.timeRange;
            this.segments.add(new AssetTrackSegment(cMTimeRange, cMTimeRange));
        }
    }

    public Asset getAsset() {
        WeakReference<Asset> weakReference = this.asset;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public List<String> getAvailableMetadataFormats() {
        return this.availableMetadataFormats;
    }

    public List<String> getAvailableTrackAssociationTypes() {
        return this.availableTrackAssociationTypes;
    }

    public List<MetadataItem> getCommonMetadata() {
        return this.commonMetadata;
    }

    public CMTime getDuration() {
        CMTimeRange cMTimeRange = this.timeRange;
        if (cMTimeRange != null) {
            return cMTimeRange.getDuration();
        }
        return CMTime.CMTimeZero;
    }

    public float getEstimatedDataRate() {
        return this.estimatedDataRate;
    }

    public HashMap<String, Object> getExtraInfo() {
        return this.extraInfo;
    }

    public int getMediaType() {
        return this.mediaType;
    }

    public CGSize getNaturalSize() {
        return this.naturalSize;
    }

    public int getNaturalTimeScale() {
        return this.naturalTimeScale;
    }

    public float getNominalFrameRate() {
        return this.nominalFrameRate;
    }

    public int getPreferredRotation() {
        return this.preferredRotation;
    }

    public Matrix getPreferredTransform() {
        return this.preferredTransform;
    }

    public float getPreferredVolume() {
        return this.preferredVolume;
    }

    public List<Segment> getSegments() {
        return this.segments;
    }

    public String getSourcePath() {
        return this.sourcePath;
    }

    public CMTimeRange getTimeRange() {
        CMTimeRange cMTimeRange = this.timeRange;
        if (cMTimeRange == null || cMTimeRange == CMTimeRange.CMTimeRangeInvalid) {
            this.timeRange = new CMTimeRange(CMTime.CMTimeZero, getDuration());
        }
        return this.timeRange;
    }

    public long getTotalSampleDataLength() {
        return this.totalSampleDataLength;
    }

    public int getTrackID() {
        return this.trackID;
    }

    public boolean hasMediaCharacteristic(String str) {
        return false;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public List<MetadataItem> metadataForFormat(String str) {
        return null;
    }

    public CMTime samplePresentationTimeForTrackTime(CMTime cMTime) {
        AssetExtractor extractor;
        WeakReference<Asset> weakReference = this.asset;
        if (weakReference != null && weakReference.get() != null && (extractor = this.asset.get().getExtractor()) != null) {
            extractor.seekTo(cMTime.getTimeUs(), 2);
            if (extractor.getSampleTime() > cMTime.getTimeUs()) {
                extractor.seekTo(cMTime.getTimeUs(), 0);
            }
            return TimeUtil.us2CMTime(extractor.getSampleTime());
        }
        return null;
    }

    public AssetTrackSegment segmentForTrackTime(CMTime cMTime) {
        CMTimeRange target;
        List<Segment> list = this.segments;
        if (list != null) {
            for (Segment segment : list) {
                if (segment != null && (target = segment.getTimeMapping().getTarget()) != null && target.containsTime(cMTime)) {
                    return segment;
                }
            }
            return null;
        }
        return null;
    }

    public void setExtraInfo(HashMap<String, Object> hashMap) {
        this.extraInfo = hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPreferredRotation(int i3) {
        this.preferredRotation = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPreferredTransform(Matrix matrix) {
        this.preferredTransform = matrix;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPreferredVolume(float f16) {
        this.preferredVolume = f16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AssetTrack(Asset asset, int i3, int i16, CMTimeRange cMTimeRange) {
        this.enabled = true;
        this.preferredVolume = 1.0f;
        this.preferredRotation = 0;
        this.nominalFrameRate = 30.0f;
        this.segments = new ArrayList();
        this.trackID = i3;
        this.mediaType = i16;
        this.timeRange = cMTimeRange;
        if (asset != null && i3 < asset.getTrackCount()) {
            this.asset = new WeakReference<>(asset);
            this.nominalFrameRate = ExtractorUtils.getFrameRate(asset.getTrackFormat(i3));
            this.naturalSize = asset.getNaturalSize();
            this.sourcePath = asset.getSourcePath();
            this.extraInfo = asset.extraInfo;
        }
        createAssetTrackSegments(asset);
    }
}
