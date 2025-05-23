package com.tencent.qcircle.weseevideo.composition.effectnode;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.qcircle.weishi.module.publisher.data.AbilityPresetData;
import com.tencent.qcircle.weishi.module.publisher.data.AiModelInfo;
import com.tencent.qcircle.weishi.module.publisher.model.AIModelConfig;
import com.tencent.qcircle.weishi.module.publisher.utils.AIUtils;
import com.tencent.qcircle.weseevideo.composition.interfaces.OnNodeRenderListener;
import com.tencent.qcircle.weseevideo.model.utils.CollectionUtils;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import java.util.List;
import org.light.CameraConfig;
import org.light.LightAsset;
import org.light.LightEngine;
import org.light.LightSurface;
import org.light.VideoOutput;

/* compiled from: P */
/* loaded from: classes22.dex */
public class LightVideoRenderNote implements TAVVideoEffect {
    private static final int SHORT_EDGE_LENGTH = 180;
    private LightAsset mLightAsset;
    private final LightEngine mLightEngine;
    private OnNodeRenderListener mOnNodeRenderListener;
    private final String mTAG = "LightVideoRenderNote@" + Integer.toHexString(hashCode());

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class LightVideoRenderFilter implements TAVVideoEffect.Filter {
        private LightAsset mLightAsset;
        private LightEngine mLightEngine;
        private LightSurface mLightSurface;
        private OnNodeRenderListener mOnNodeRenderListener;
        private TextureInfo mTextureInfo;
        private VideoOutput mVideoOutput;

        LightVideoRenderFilter(LightEngine lightEngine, OnNodeRenderListener onNodeRenderListener, LightAsset lightAsset) {
            this.mLightEngine = lightEngine;
            this.mOnNodeRenderListener = onNodeRenderListener;
            this.mLightAsset = lightAsset;
        }

        private void initReader(RenderInfo renderInfo) {
            TextureInfo newTextureInfo = CIContext.newTextureInfo(renderInfo.getRenderSize());
            this.mTextureInfo = newTextureInfo;
            LightSurface makeFromTexture = LightSurface.makeFromTexture(newTextureInfo.textureID, newTextureInfo.width, newTextureInfo.height, true);
            this.mLightSurface = makeFromTexture;
            this.mLightEngine.setSurface(makeFromTexture);
            setAIForEngine(this.mLightEngine);
            this.mVideoOutput = this.mLightEngine.videoOutput();
        }

        private boolean isTextureChanged(RenderInfo renderInfo) {
            TextureInfo textureInfo = this.mTextureInfo;
            if (textureInfo != null && textureInfo.width == renderInfo.getRenderWidth() && this.mTextureInfo.height == renderInfo.getRenderHeight()) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.tavkit.composition.video.TAVVideoEffect.Filter
        @NonNull
        public CIImage apply(TAVVideoEffect tAVVideoEffect, CIImage cIImage, RenderInfo renderInfo) {
            if (this.mVideoOutput == null || isTextureChanged(renderInfo)) {
                initReader(renderInfo);
            }
            long currentTimeMillis = System.currentTimeMillis();
            this.mVideoOutput.readSample(renderInfo.getTime().getTimeUs());
            Logger.i("lightsdkcost", "[light sdk]\u6bcf\u5e27\u6e32\u67d3\u8017\u65f6\uff1a" + (System.currentTimeMillis() - currentTimeMillis));
            OnNodeRenderListener onNodeRenderListener = this.mOnNodeRenderListener;
            if (onNodeRenderListener != null) {
                onNodeRenderListener.onNodeRender();
            }
            return new CIImage(this.mTextureInfo);
        }

        @Override // com.tencent.tavkit.composition.video.Releasable
        public void release() {
            VideoOutput videoOutput = this.mVideoOutput;
            if (videoOutput != null) {
                videoOutput.release();
            }
            TextureInfo textureInfo = this.mTextureInfo;
            if (textureInfo != null) {
                textureInfo.release();
            }
            LightEngine lightEngine = this.mLightEngine;
            if (lightEngine != null) {
                lightEngine.release();
            }
            LightSurface lightSurface = this.mLightSurface;
            if (lightSurface != null) {
                lightSurface.freeCache();
                this.mLightSurface.release();
            }
        }

        public void setAIForEngine(LightEngine lightEngine) {
            CameraConfig make = CameraConfig.make();
            lightEngine.setConfig(make);
            List<AiModelInfo> aiModelPath = AIUtils.getAiModelPath(new AbilityPresetData(this.mLightAsset), AIModelConfig.getAIModelPathMap(), true);
            if (!CollectionUtils.isEmpty(aiModelPath)) {
                for (AiModelInfo aiModelInfo : aiModelPath) {
                    make.setLightAIModelPath(aiModelInfo.modelPath, aiModelInfo.modelAgent);
                }
            }
            make.setDetectShorterEdgeLength(180, "");
        }
    }

    public LightVideoRenderNote(LightEngine lightEngine) {
        this.mLightEngine = lightEngine;
    }

    @Override // com.tencent.tavkit.composition.video.TAVVideoEffect
    public TAVVideoEffect.Filter createFilter() {
        return new LightVideoRenderFilter(this.mLightEngine, this.mOnNodeRenderListener, this.mLightAsset);
    }

    @Override // com.tencent.tavkit.composition.video.TAVVideoEffect
    @Nullable
    /* renamed from: effectId */
    public String getMEffectId() {
        return this.mTAG;
    }

    public void setLightAsset(LightAsset lightAsset) {
        this.mLightAsset = lightAsset;
    }

    public void setOnNodeRenderListener(OnNodeRenderListener onNodeRenderListener) {
        this.mOnNodeRenderListener = onNodeRenderListener;
    }
}
