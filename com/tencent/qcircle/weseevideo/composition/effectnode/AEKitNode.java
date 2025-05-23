package com.tencent.qcircle.weseevideo.composition.effectnode;

import android.opengl.GLES20;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.qcircle.tavcut.aekit.AEKitModel;
import com.tencent.qcircle.tavcut.util.DurationUtil;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.report.IReportable;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.filter.AlphaAdjustFilter;
import com.tencent.ttpic.openapi.filter.LightNode;
import com.tencent.ttpic.openapi.util.VideoSDKMaterialParser;
import java.util.HashMap;
import java.util.Map;
import org.light.bean.Texture;
import org.light.callback.ExternalRenderCallback;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AEKitNode implements TAVVideoEffect {
    private static final String TAG = "AEKitNode";
    private boolean isBasePicActive;
    private AEKitModel mAEKitModel;
    private AEFilterManager outAEFilterManager;
    private final String mEffectId = "AIFilterNode" + Integer.toHexString(hashCode());
    private String reportKey = TAG;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private class AEKitFilter implements TAVVideoEffect.Filter, IReportable, ExternalRenderCallback {
        public static final String BaseFragShader = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\nvec2 flipTex = vec2(textureCoordinate.x, 1.0 - textureCoordinate.y);\ngl_FragColor = texture2D (inputImageTexture, flipTex);\n}\n";
        public static final String BaseVertexShader = "precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main() {\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}\n";
        EnhancedAEAdjust aeAdjust;
        AEFilterManager aeFilterManager;
        AlphaAdjustFilter alphaAdjustFilter;
        private Frame cacheFrame;
        private TextureInfo cacheOutTexture;
        private TextureInfo cacheTextureInfo;
        private String currentAppliedLutPath;
        private String currentAppliedMaterialPath;
        private boolean currentSyncMode;
        private VideoFilterBase mFlipFilter;
        private Frame mFlipFrame;
        private int[] mFlipTextureID;

        AEKitFilter() {
            this.mFlipTextureID = new int[1];
            this.mFlipFrame = new Frame();
        }

        private void initAEFilterManager(int i3, int i16) {
            Logger.i("AEKitFilter", "constructing");
            DurationUtil.start("init aeFilterManager");
            if (AEKitNode.this.mAEKitModel.getMediaType() == 1) {
                this.aeFilterManager = new AEFilterManager("defaultBeautyV6.json", false, false, null);
            } else {
                this.aeFilterManager = new AEFilterManager();
            }
            this.aeFilterManager.supportMultiThreads(true);
            this.aeFilterManager.initInGL(i3, i16);
            this.aeFilterManager.defineFiltersAndOrder(300, 100);
            this.aeFilterManager.setFilterInSmooth(true);
            this.aeFilterManager.setExternalRenderCallback(this);
            EnhancedAEAdjust enhancedAEAdjust = new EnhancedAEAdjust();
            this.aeAdjust = enhancedAEAdjust;
            enhancedAEAdjust.apply();
            this.cacheFrame = new Frame();
            AlphaAdjustFilter alphaAdjustFilter = new AlphaAdjustFilter();
            this.alphaAdjustFilter = alphaAdjustFilter;
            alphaAdjustFilter.apply();
            int[] iArr = this.mFlipTextureID;
            GLES20.glGenTextures(iArr.length, iArr, 0);
            VideoFilterBase videoFilterBase = new VideoFilterBase("precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main() {\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}\n", "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\nvec2 flipTex = vec2(textureCoordinate.x, 1.0 - textureCoordinate.y);\ngl_FragColor = texture2D (inputImageTexture, flipTex);\n}\n");
            this.mFlipFilter = videoFilterBase;
            videoFilterBase.ApplyGLSLFilter();
            DurationUtil.end("init aeFilterManager");
        }

        private void initFilterManagerWrap(int i3, int i16) {
            if (this.aeFilterManager == null) {
                AEFilterManager aEFilterManager = AEKitNode.this.outAEFilterManager;
                this.aeFilterManager = aEFilterManager;
                if (aEFilterManager != null) {
                    aEFilterManager.initInGL(i3, i16);
                    this.aeFilterManager.setExternalRenderCallback(this);
                    this.cacheFrame = new Frame();
                    EnhancedAEAdjust enhancedAEAdjust = new EnhancedAEAdjust();
                    this.aeAdjust = enhancedAEAdjust;
                    enhancedAEAdjust.apply();
                    AlphaAdjustFilter alphaAdjustFilter = new AlphaAdjustFilter();
                    this.alphaAdjustFilter = alphaAdjustFilter;
                    alphaAdjustFilter.apply();
                    int[] iArr = this.mFlipTextureID;
                    GLES20.glGenTextures(iArr.length, iArr, 0);
                    VideoFilterBase videoFilterBase = new VideoFilterBase("precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main() {\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}\n", "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\nvec2 flipTex = vec2(textureCoordinate.x, 1.0 - textureCoordinate.y);\ngl_FragColor = texture2D (inputImageTexture, flipTex);\n}\n");
                    this.mFlipFilter = videoFilterBase;
                    videoFilterBase.ApplyGLSLFilter();
                }
            }
            if (this.aeFilterManager == null) {
                initAEFilterManager(i3, i16);
            }
        }

        @Override // com.tencent.tavkit.composition.video.TAVVideoEffect.Filter
        @NonNull
        public CIImage apply(TAVVideoEffect tAVVideoEffect, CIImage cIImage, RenderInfo renderInfo) {
            CIContext ciContext;
            boolean z16;
            Frame frame;
            if (AEKitNode.this.mAEKitModel == null) {
                return cIImage;
            }
            if (AEKitNode.this.mAEKitModel != null && AEKitNode.this.mAEKitModel.isDisable()) {
                return cIImage;
            }
            if (AEKitNode.this.mAEKitModel != null) {
                String overlayImgPath = AEKitNode.this.mAEKitModel.getOverlayImgPath();
                if (!TextUtils.isEmpty(overlayImgPath)) {
                    Logger.i(AEKitNode.TAG, "apply---has overlayPath: " + overlayImgPath);
                    return new CIImage(overlayImgPath);
                }
            }
            DurationUtil.start("apply aeFilterManager");
            int i3 = (int) cIImage.getSize().width;
            int i16 = (int) cIImage.getSize().height;
            initFilterManagerWrap(i3, i16);
            if (!this.aeFilterManager.isInited() || (ciContext = renderInfo.getCiContext()) == null || ciContext.getRenderContext() == null) {
                return cIImage;
            }
            long timeUs = renderInfo.getTime().getTimeUs() / 1000;
            if (AEKitNode.this.mAEKitModel != null && (timeUs < AEKitNode.this.mAEKitModel.getStartTime() || timeUs > AEKitNode.this.mAEKitModel.getStartTime() + AEKitNode.this.mAEKitModel.getDuration())) {
                return cIImage;
            }
            if (this.cacheTextureInfo == null) {
                ciContext.getRenderContext().makeCurrent();
                this.cacheTextureInfo = CIContext.newTextureInfo(i3, i16);
            }
            TextureInfo textureInfo = this.cacheTextureInfo;
            if (textureInfo.width != i3 || textureInfo.height != i16) {
                ciContext.getRenderContext().makeCurrent();
                this.cacheTextureInfo.release();
                this.cacheTextureInfo = CIContext.newTextureInfo(i3, i16);
            }
            TextureInfo textureInfo2 = this.cacheOutTexture;
            if (textureInfo2 == null) {
                ciContext.getRenderContext().makeCurrent();
                this.cacheOutTexture = CIContext.newTextureInfo(i3, i16);
            } else if (textureInfo2.width != i3 || textureInfo2.height != i16) {
                ciContext.getRenderContext().makeCurrent();
                this.cacheOutTexture.release();
                this.cacheOutTexture = CIContext.newTextureInfo(i3, i16);
            }
            ciContext.convertImageToTexture(cIImage, this.cacheTextureInfo);
            TextureInfo textureInfo3 = this.cacheTextureInfo;
            if (textureInfo3 == null) {
                return cIImage;
            }
            if (AEKitNode.this.mAEKitModel.getMediaType() == 2 && AEKitNode.this.mAEKitModel.isDisable() != AEKitNode.this.mAEKitModel.getLastState() && !AEKitNode.this.mAEKitModel.isDisable()) {
                if (!this.currentSyncMode) {
                    this.aeFilterManager.setSyncMode(true);
                    this.currentSyncMode = true;
                } else {
                    this.aeFilterManager.setSyncMode(false);
                    this.currentSyncMode = false;
                    AEKitNode.this.mAEKitModel.setLastState(false);
                }
            }
            if (AEKitNode.this.mAEKitModel.getMediaType() == 1 && this.currentSyncMode == AEKitNode.this.isBasePicActive) {
                this.aeFilterManager.setSyncMode(!AEKitNode.this.isBasePicActive);
                this.currentSyncMode = !AEKitNode.this.isBasePicActive;
            }
            this.aeFilterManager.updateWidthHeight(textureInfo3.width, textureInfo3.height);
            Frame frame2 = null;
            if (AEKitNode.this.mAEKitModel != null) {
                this.aeFilterManager.setGlowAlpha(AEKitNode.this.mAEKitModel.getGlowAlpha());
                String lutPath = this.aeFilterManager.getLutPath();
                if ((TextUtils.isEmpty(lutPath) && TextUtils.isEmpty(AEKitNode.this.mAEKitModel.getLutPath())) || TextUtils.equals(lutPath, AEKitNode.this.mAEKitModel.getLutPath())) {
                    z16 = false;
                } else {
                    if (AEKitNode.this.mAEKitModel.getLutPath() != null) {
                        this.currentAppliedLutPath = AEKitNode.this.mAEKitModel.getLutPath();
                    } else {
                        this.currentAppliedLutPath = "";
                    }
                    this.aeFilterManager.updateLutGL(this.currentAppliedLutPath);
                    z16 = true;
                }
                this.aeFilterManager.setmIntensity(AEKitNode.this.mAEKitModel.getLutAlpha() * 100.0f);
                this.aeFilterManager.setSmoothLevel(AEKitNode.this.mAEKitModel.getSmoothLevel());
                String material = AEKitNode.this.mAEKitModel.getMaterial();
                this.aeFilterManager.switchAbilityInLightNode("smooth.enable", AEKitNode.this.mAEKitModel.getSmoothLevel() > 0);
                if (TextUtils.isEmpty(material)) {
                    frame = null;
                } else {
                    this.mFlipFilter.RenderProcess(textureInfo3.textureID, textureInfo3.width, textureInfo3.height, this.mFlipTextureID[0], 0.0d, this.mFlipFrame);
                    frame = this.mFlipFrame;
                }
                String dataPath = (this.aeFilterManager.getVideoMaterial() == null || this.aeFilterManager.getVideoMaterial().getDataPath().equals(LightNode.getEmptyMaterialPath())) ? null : this.aeFilterManager.getVideoMaterial().getDataPath();
                if (!(TextUtils.isEmpty(dataPath) && TextUtils.isEmpty(material)) && !TextUtils.equals(dataPath, material)) {
                    this.currentAppliedMaterialPath = material;
                    if (TextUtils.isEmpty(material)) {
                        this.aeFilterManager.updateMaterialGL(null);
                    } else {
                        this.aeFilterManager.updateMaterialGL(VideoSDKMaterialParser.parseVideoMaterial(material, "params"));
                    }
                    z16 = true;
                }
                frame2 = frame;
            } else {
                z16 = false;
            }
            this.aeFilterManager.setExternalRenderCallback(this);
            int i17 = textureInfo3.textureID;
            DurationUtil.start("aeFilterManager.drawFrame");
            int drawFrame = this.aeFilterManager.drawFrame(i17, false, 0L);
            DurationUtil.end("aeFilterManager.drawFrame");
            this.mFlipFilter.OnDrawFrameGLSL();
            Frame RenderProcess = this.mFlipFilter.RenderProcess(drawFrame, i3, i16);
            if (RenderProcess != null) {
                drawFrame = RenderProcess.getTextureId();
            }
            this.alphaAdjustFilter.setFilterTexture(drawFrame);
            this.alphaAdjustFilter.setAdjustParam(AEKitNode.this.mAEKitModel != null ? AEKitNode.this.mAEKitModel.getEffectStrength() : 1.0f);
            this.alphaAdjustFilter.RenderProcess(textureInfo3.textureID, textureInfo3.width, textureInfo3.height, this.cacheOutTexture.textureID, 0.0d, this.cacheFrame);
            if (frame2 != null && !frame2.unlock()) {
                frame2.clear();
            }
            if (RenderProcess != null && !RenderProcess.unlock()) {
                RenderProcess.clear();
            }
            FrameBufferCache.getInstance().forceRecycle();
            if (AEKitNode.this.mAEKitModel.getMediaType() == 1 && z16) {
                this.aeFilterManager.freeCache();
            }
            DurationUtil.end("apply aeFilterManager");
            return new CIImage(this.cacheOutTexture);
        }

        @Override // com.tencent.tavkit.report.IReportable
        public String getReportKey() {
            return AEKitNode.this.reportKey;
        }

        @Override // org.light.callback.ExternalRenderCallback
        public void onRender(Texture texture, String str, String str2, Texture texture2) {
            Map<String, String> adjustParams;
            LogUtils.d(AEKitNode.TAG, "onRender: \u89e6\u53d1\u5916\u6302\u6ee4\u955c\uff0c\u53c2\u6570\uff1a" + texture + "|" + str + "|" + str2 + "|" + texture2);
            if (this.aeAdjust != null && AEKitNode.this.mAEKitModel != null && (adjustParams = AEKitNode.this.mAEKitModel.getAdjustParams()) != null && !adjustParams.isEmpty()) {
                this.aeAdjust.setAdjustParams(new HashMap<>(adjustParams));
                Frame frame = new Frame();
                frame.setSizedTexture(texture.f423804id, texture.width, texture.height);
                Frame render = this.aeAdjust.render(frame);
                texture2.f423804id = render.getTextureId();
                texture2.width = render.width;
                texture2.height = render.height;
                return;
            }
            texture2.f423804id = texture.f423804id;
            texture2.width = texture.width;
            texture2.height = texture.height;
        }

        @Override // com.tencent.tavkit.composition.video.Releasable
        public void release() {
            Log.i(AEKitNode.TAG, "releaseAEKitFilter---");
            int[] iArr = this.mFlipTextureID;
            GLES20.glDeleteTextures(iArr.length, iArr, 0);
            AEFilterManager aEFilterManager = this.aeFilterManager;
            if (aEFilterManager != null) {
                aEFilterManager.setExternalRenderCallback(null);
                if (AEKitNode.this.outAEFilterManager == null) {
                    this.aeFilterManager.destroy();
                }
                this.aeFilterManager = null;
            }
            if (AEKitNode.this.outAEFilterManager != null) {
                AEKitNode.this.outAEFilterManager = null;
            }
            Frame frame = this.mFlipFrame;
            if (frame != null) {
                frame.clear();
                this.mFlipFrame = null;
            }
            AlphaAdjustFilter alphaAdjustFilter = this.alphaAdjustFilter;
            if (alphaAdjustFilter != null) {
                alphaAdjustFilter.clear();
            }
            TextureInfo textureInfo = this.cacheTextureInfo;
            if (textureInfo != null && !textureInfo.isReleased()) {
                this.cacheTextureInfo.release();
            }
            TextureInfo textureInfo2 = this.cacheOutTexture;
            if (textureInfo2 != null && !textureInfo2.isReleased()) {
                this.cacheOutTexture.release();
            }
            Frame frame2 = this.cacheFrame;
            if (frame2 != null) {
                frame2.clear();
                this.cacheFrame = null;
            }
            VideoFilterBase videoFilterBase = this.mFlipFilter;
            if (videoFilterBase != null) {
                videoFilterBase.clearGLSLSelf();
                this.mFlipFilter = null;
            }
            EnhancedAEAdjust enhancedAEAdjust = this.aeAdjust;
            if (enhancedAEAdjust != null) {
                enhancedAEAdjust.clear();
                this.aeAdjust = null;
            }
        }
    }

    @Override // com.tencent.tavkit.composition.video.TAVVideoEffect
    public TAVVideoEffect.Filter createFilter() {
        Logger.i(TAG, "createFilter---");
        return new AEKitFilter();
    }

    @Override // com.tencent.tavkit.composition.video.TAVVideoEffect
    @Nullable
    /* renamed from: effectId */
    public String getMEffectId() {
        return this.mEffectId;
    }

    public void setAEKitModel(AEKitModel aEKitModel) {
        Logger.i(TAG, "setAEKitModel---: " + aEKitModel);
        this.mAEKitModel = aEKitModel;
    }

    public void setBasePicActive(boolean z16) {
        this.isBasePicActive = z16;
    }

    public void setFilterManager(AEFilterManager aEFilterManager) {
        this.outAEFilterManager = aEFilterManager;
    }
}
