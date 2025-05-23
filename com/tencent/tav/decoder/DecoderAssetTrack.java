package com.tencent.tav.decoder;

import android.graphics.Matrix;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.asset.AssetTrackSegment;
import com.tencent.tav.asset.CompositionTrackSegment;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.extractor.AssetExtractor;
import com.tencent.tav.extractor.ExtractorUtils;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public class DecoderAssetTrack {
    public String assetPath;
    public HashMap<String, Object> extraInfo;
    public int frameRate;
    public int mediaType;
    public int preferRotation;
    public Matrix preferredTransform;
    public float preferredVolume;
    public CGSize size;
    public int sourceType;
    public int trackId;

    public static DecoderAssetTrack create(AssetTrack assetTrack, AssetTrackSegment assetTrackSegment) {
        if (assetTrackSegment instanceof CompositionTrackSegment) {
            return createFromCompositionTrackSegment(assetTrack, (CompositionTrackSegment) assetTrackSegment);
        }
        return createFromTrackSegment(assetTrack, assetTrackSegment);
    }

    @Nullable
    private static DecoderAssetTrack createFromCompositionTrackSegment(AssetTrack assetTrack, CompositionTrackSegment compositionTrackSegment) {
        if (!compositionTrackSegment.isEmpty()) {
            DecoderAssetTrack decoderAssetTrack = new DecoderAssetTrack();
            decoderAssetTrack.assetPath = compositionTrackSegment.getSourcePath();
            decoderAssetTrack.extraInfo = compositionTrackSegment.getExtraInfo();
            decoderAssetTrack.trackId = compositionTrackSegment.getSourceTrackID();
            decoderAssetTrack.mediaType = assetTrack.getMediaType();
            if (!TextUtils.isEmpty(compositionTrackSegment.getSourcePath())) {
                AssetExtractor assetExtractor = new AssetExtractor();
                assetExtractor.setDataSource(compositionTrackSegment.getSourcePath());
                decoderAssetTrack.size = ExtractorUtils.getVideoSize(assetExtractor);
                decoderAssetTrack.preferRotation = assetExtractor.getPreferRotation();
                decoderAssetTrack.preferredTransform = assetTrack.getPreferredTransform();
                decoderAssetTrack.sourceType = compositionTrackSegment.getSourceType();
            }
            decoderAssetTrack.preferredVolume = 1.0f;
            decoderAssetTrack.frameRate = 30;
            return decoderAssetTrack;
        }
        return null;
    }

    private static DecoderAssetTrack createFromTrackSegment(AssetTrack assetTrack, AssetTrackSegment assetTrackSegment) {
        if (!assetTrackSegment.isEmpty()) {
            DecoderAssetTrack decoderAssetTrack = new DecoderAssetTrack();
            decoderAssetTrack.assetPath = assetTrack.getSourcePath();
            decoderAssetTrack.extraInfo = assetTrack.getExtraInfo();
            decoderAssetTrack.trackId = assetTrack.getTrackID();
            decoderAssetTrack.mediaType = assetTrack.getMediaType();
            if (assetTrackSegment instanceof CompositionTrackSegment) {
                decoderAssetTrack.sourceType = ((CompositionTrackSegment) assetTrackSegment).getSourceType();
            }
            decoderAssetTrack.size = assetTrack.getNaturalSize();
            decoderAssetTrack.preferredTransform = assetTrack.getPreferredTransform();
            decoderAssetTrack.preferredVolume = assetTrack.getPreferredVolume();
            decoderAssetTrack.preferRotation = assetTrack.getPreferredRotation();
            decoderAssetTrack.frameRate = (int) assetTrack.getNominalFrameRate();
            return decoderAssetTrack;
        }
        return null;
    }
}
