package com.tencent.tav.core.composition;

import androidx.annotation.Nullable;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.asset.Composition;
import com.tencent.tav.core.VideoCompositor;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class MutableVideoComposition extends VideoComposition {
    private static final String TAG = "VideoComposition";
    private Asset asset;

    @Nullable
    private Class<? extends VideoCompositing> customVideoCompositorClass;
    private CMTime frameDuration;
    private List<? extends VideoCompositionInstruction> instructions;
    private VideoComposition.RenderLayoutMode renderLayoutMode;
    private float renderScale;
    private CGSize renderSize;
    private int sourceTrackIDForFrameTiming;

    public MutableVideoComposition(Asset asset) {
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
                    if (r5.timeScale > assetTrack.getNominalFrameRate()) {
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
        this.renderScale = 1.0f;
    }

    @Override // com.tencent.tav.core.composition.VideoComposition
    @Nullable
    public VideoCompositing getCustomVideoCompositor() {
        Class<? extends VideoCompositing> cls = this.customVideoCompositorClass;
        if (cls != null) {
            try {
                return cls.newInstance();
            } catch (IllegalAccessException | InstantiationException e16) {
                e16.printStackTrace();
                return new VideoCompositor();
            }
        }
        return new VideoCompositor();
    }

    @Override // com.tencent.tav.core.composition.VideoComposition
    @Nullable
    public Class<? extends VideoCompositing> getCustomVideoCompositorClass() {
        return this.customVideoCompositorClass;
    }

    @Override // com.tencent.tav.core.composition.VideoComposition
    public CMTime getFrameDuration() {
        return this.frameDuration;
    }

    @Override // com.tencent.tav.core.composition.VideoComposition
    public List<? extends VideoCompositionInstruction> getInstructions() {
        return this.instructions;
    }

    @Override // com.tencent.tav.core.composition.VideoComposition
    public VideoComposition.RenderLayoutMode getRenderLayoutMode() {
        return this.renderLayoutMode;
    }

    @Override // com.tencent.tav.core.composition.VideoComposition
    public float getRenderScale() {
        return this.renderScale;
    }

    @Override // com.tencent.tav.core.composition.VideoComposition
    public CGSize getRenderSize() {
        return this.renderSize;
    }

    @Override // com.tencent.tav.core.composition.VideoComposition
    public int getSourceTrackIDForFrameTiming() {
        return this.sourceTrackIDForFrameTiming;
    }

    public void setCustomVideoCompositorClass(@Nullable Class<? extends VideoCompositing> cls) {
        this.customVideoCompositorClass = cls;
    }

    public void setFrameDuration(CMTime cMTime) {
        this.frameDuration = cMTime;
    }

    public void setInstructions(List<? extends VideoCompositionInstruction> list) {
        this.instructions = list;
    }

    public void setRenderLayoutMode(VideoComposition.RenderLayoutMode renderLayoutMode) {
        this.renderLayoutMode = renderLayoutMode;
    }

    public void setRenderScale(float f16) {
        this.renderScale = f16;
    }

    public void setRenderSize(CGSize cGSize) {
        this.renderSize = cGSize;
    }

    public void setSourceTrackIDForFrameTiming(int i3) {
        this.sourceTrackIDForFrameTiming = i3;
    }

    @Override // com.tencent.tav.core.composition.VideoComposition
    public String toString() {
        return "MutableVideoComposition{, frameDuration=" + this.frameDuration + ", renderSize=" + this.renderSize + ", renderLayoutMode=" + this.renderLayoutMode + ", instructions=" + this.instructions + '}';
    }

    public MutableVideoComposition() {
    }
}
