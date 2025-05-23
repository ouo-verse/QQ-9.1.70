package com.tencent.tav.core.composition;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.asset.Composition;
import com.tencent.tav.core.VideoCompositor;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class VideoComposition {
    private static final String TAG = "VideoComposition";
    private Asset asset;

    @Nullable
    private Class<? extends VideoCompositing> customVideoCompositorClass;
    private CMTime frameDuration;
    private List<? extends VideoCompositionInstruction> instructions;
    private RenderLayoutMode renderLayoutMode;
    private float renderScale;
    private CGSize renderSize;
    private int sourceTrackIDForFrameTiming;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public enum RenderLayoutMode {
        aspectFit,
        aspectFill
    }

    public VideoComposition(Asset asset) {
        this.frameDuration = new CMTime(1L, 30);
        this.asset = asset;
        this.instructions = new ArrayList();
        fillSourceProperty();
    }

    private void fillSourceProperty() {
        CMTime cMTime;
        List<AssetTrack> tracksWithMediaType = this.asset.tracksWithMediaType(1);
        this.frameDuration = null;
        this.renderSize = null;
        if (tracksWithMediaType != null) {
            for (AssetTrack assetTrack : tracksWithMediaType) {
                if (this.frameDuration == null) {
                    this.frameDuration = new CMTime(1L, (int) assetTrack.getNominalFrameRate());
                } else {
                    if (r7.timeScale > assetTrack.getNominalFrameRate()) {
                        cMTime = this.frameDuration;
                    } else {
                        cMTime = new CMTime(1L, (int) assetTrack.getNominalFrameRate());
                    }
                    this.frameDuration = cMTime;
                }
            }
        }
        CMTime cMTime2 = this.frameDuration;
        if (cMTime2 == null || cMTime2.timeScale == 0) {
            this.frameDuration = new CMTime(1L, 30);
        }
        Asset asset = this.asset;
        if (asset instanceof Composition) {
            this.renderSize = asset.getNaturalSize();
        } else if (tracksWithMediaType != null) {
            for (AssetTrack assetTrack2 : tracksWithMediaType) {
                if (this.renderSize == null) {
                    this.renderSize = assetTrack2.getNaturalSize();
                } else if (assetTrack2.getNaturalSize() != null) {
                    this.renderSize = new CGSize(Math.max(this.renderSize.width, assetTrack2.getNaturalSize().width), Math.max(this.renderSize.height, assetTrack2.getNaturalSize().height));
                }
            }
        }
        this.instructions = new ArrayList();
        if (tracksWithMediaType != null && !(this.asset instanceof Composition)) {
            for (AssetTrack assetTrack3 : tracksWithMediaType) {
                VideoCompositionInstruction videoCompositionInstruction = new VideoCompositionInstruction();
                videoCompositionInstruction.backgroundColor = -16777216;
                videoCompositionInstruction.enablePostProcessing = true;
                videoCompositionInstruction.passthroughTrackID = assetTrack3.getTrackID();
                videoCompositionInstruction.timeRange = new CMTimeRange(CMTime.CMTimeZero, assetTrack3.getDuration());
                videoCompositionInstruction.requiredSourceTrackIDs = Arrays.asList(Integer.valueOf(assetTrack3.getTrackID()));
                MutableVideoCompositionLayerInstruction mutableVideoCompositionLayerInstruction = new MutableVideoCompositionLayerInstruction();
                mutableVideoCompositionLayerInstruction.setTrackID(assetTrack3.getTrackID());
                mutableVideoCompositionLayerInstruction.setTransformRampFromStartTransform(null, null, videoCompositionInstruction.timeRange);
                mutableVideoCompositionLayerInstruction.setCropRectangleRampFromStartCropRectangle(null, null, videoCompositionInstruction.timeRange);
                mutableVideoCompositionLayerInstruction.setOpacityRampFromStartOpacity(1.0f, 1.0f, videoCompositionInstruction.timeRange);
                videoCompositionInstruction.layerInstructions.add(mutableVideoCompositionLayerInstruction);
            }
        }
        this.renderScale = 1.0f;
    }

    public static VideoCompositionInstruction findInstruction(VideoComposition videoComposition, CMTime cMTime) {
        VideoCompositionInstruction videoCompositionInstruction = null;
        if (videoComposition.getInstructions() == null) {
            return null;
        }
        for (VideoCompositionInstruction videoCompositionInstruction2 : videoComposition.getInstructions()) {
            if (videoCompositionInstruction2.getTimeRange() != null && (videoCompositionInstruction == null || videoCompositionInstruction.getTimeRange().getEnd().smallThan(videoCompositionInstruction2.getTimeRange().getEnd()))) {
                videoCompositionInstruction = videoCompositionInstruction2;
            }
            CMTimeRange timeRange = videoCompositionInstruction2.getTimeRange();
            if (timeRange != null && timeRange.getStartUs() <= cMTime.getTimeUs() && timeRange.getEndUs() > cMTime.getTimeUs()) {
                return videoCompositionInstruction2;
            }
        }
        return videoCompositionInstruction;
    }

    @NonNull
    public VideoCompositing getCustomVideoCompositor() {
        Class<? extends VideoCompositing> cls = this.customVideoCompositorClass;
        if (cls != null) {
            try {
                return cls.newInstance();
            } catch (IllegalAccessException e16) {
                e16.printStackTrace();
                return new VideoCompositor();
            } catch (InstantiationException e17) {
                e17.printStackTrace();
                return new VideoCompositor();
            }
        }
        return new VideoCompositor();
    }

    public Class<? extends VideoCompositing> getCustomVideoCompositorClass() {
        return this.customVideoCompositorClass;
    }

    public CMTime getFrameDuration() {
        return this.frameDuration;
    }

    public <T extends VideoCompositionInstruction> List<T> getInstructions() {
        return (List<T>) this.instructions;
    }

    public RenderLayoutMode getRenderLayoutMode() {
        return this.renderLayoutMode;
    }

    public float getRenderScale() {
        return this.renderScale;
    }

    public CGSize getRenderSize() {
        return this.renderSize;
    }

    public int getSourceTrackIDForFrameTiming() {
        return this.sourceTrackIDForFrameTiming;
    }

    public String toString() {
        return "MutableVideoComposition{, frameDuration=" + this.frameDuration + ", renderSize=" + this.renderSize + ", renderLayoutMode=" + this.renderLayoutMode + ", instructions=" + this.instructions + '}';
    }

    public VideoComposition() {
        this.frameDuration = new CMTime(1L, 30);
    }
}
