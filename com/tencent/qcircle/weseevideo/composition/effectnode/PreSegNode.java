package com.tencent.qcircle.weseevideo.composition.effectnode;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.opengl.GLES20;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.aekit.api.standard.filter.AEAdjust;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.qcircle.tavcut.aekit.PreSegModel;
import com.tencent.qcircle.tavcut.util.DurationUtil;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.qcircle.weseevideo.model.effect.CropModel;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.report.IReportable;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.filter.AlphaAdjustFilter;
import com.tencent.ttpic.openapi.util.VideoSDKMaterialParser;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.light.bean.Texture;
import org.light.callback.ExternalRenderCallback;

/* loaded from: classes22.dex */
public class PreSegNode implements TAVVideoEffect {
    private static final String TAG = "PreSegNode";
    private CropModel cropModel;
    private AEFilterManager outAEFilterManager;
    private PicSaveDelegate picSaveDelegate;
    private PreSegModel preSegModel;
    private final String mEffectId = TAG + Integer.toHexString(hashCode());
    private String reportKey = TAG;

    /* loaded from: classes22.dex */
    private class AEKitFilter implements TAVVideoEffect.Filter, IReportable, ExternalRenderCallback {
        public static final String BaseFragShader = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\nvec2 flipTex = vec2(textureCoordinate.x, 1.0 - textureCoordinate.y);\ngl_FragColor = texture2D (inputImageTexture, flipTex);\n}\n";
        public static final String BaseVertexShader = "precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main() {\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}\n";
        AEAdjust aeAdjust;
        AEFilterManager aeFilterManager;
        AlphaAdjustFilter alphaAdjustFilter;
        private Frame cacheFrame;
        private TextureInfo cacheInputTextureInfo;
        private TextureInfo cacheOutTexture;
        private CIImage curCIImage;
        private VideoFilterBase mFlipFilter;
        private Frame mFlipFrame;
        private int[] mFlipTextureID;

        AEKitFilter() {
            this.mFlipTextureID = new int[1];
            this.mFlipFrame = new Frame();
        }

        private Bitmap checkSegCentre(Bitmap bitmap) {
            if (bitmap == null) {
                return null;
            }
            int height = bitmap.getHeight();
            int width = bitmap.getWidth();
            int i3 = 0;
            boolean z16 = false;
            int i16 = 0;
            for (int i17 = 0; i17 < bitmap.getWidth(); i17++) {
                for (int height2 = bitmap.getHeight() - 1; height2 >= 0; height2--) {
                    if (Color.alpha(bitmap.getPixel(i17, height2)) != 0) {
                        i16 = i17;
                        z16 = true;
                    }
                }
                if (z16) {
                    break;
                }
            }
            boolean z17 = false;
            int i18 = 0;
            for (int i19 = 0; i19 < bitmap.getHeight(); i19++) {
                for (int width2 = bitmap.getWidth() - 1; width2 >= 0; width2--) {
                    if (Color.alpha(bitmap.getPixel(width2, i19)) != 0) {
                        i18 = i19;
                        z17 = true;
                    }
                }
                if (z17) {
                    break;
                }
            }
            boolean z18 = false;
            for (int width3 = bitmap.getWidth() - 1; width3 >= 0; width3--) {
                for (int height3 = bitmap.getHeight() - 1; height3 >= 0; height3--) {
                    if (Color.alpha(bitmap.getPixel(width3, height3)) != 0) {
                        width = width3;
                        z18 = true;
                    }
                }
                if (z18) {
                    break;
                }
            }
            boolean z19 = false;
            for (int height4 = bitmap.getHeight() - 1; height4 >= 0; height4--) {
                for (int width4 = bitmap.getWidth() - 1; width4 >= 0; width4--) {
                    if (Color.alpha(bitmap.getPixel(width4, height4)) != 0) {
                        height = height4;
                        z19 = true;
                    }
                }
                if (z19) {
                    break;
                }
            }
            if (i18 == height) {
                height = bitmap.getHeight();
                i18 = 0;
            }
            if (i16 == width) {
                width = bitmap.getHeight();
            } else {
                i3 = i16;
            }
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, i3, i18, width - i3, height - i18);
            bitmap.recycle();
            return createBitmap;
        }

        private Bitmap getTextureInfoBitmap(int i3, int i16, int i17) {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i3 * i16 * 4);
            allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
            allocateDirect.rewind();
            int[] iArr = new int[1];
            GLES20.glGenFramebuffers(1, iArr, 0);
            GLES20.glBindFramebuffer(36160, iArr[0]);
            GLES20.glFramebufferTexture2D(36160, 36064, this.cacheOutTexture.textureType, i17, 0);
            GLES20.glReadPixels(0, 0, i3, i16, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, allocateDirect);
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glDeleteFramebuffers(1, iArr, 0);
            Bitmap createBitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_4444);
            allocateDirect.rewind();
            createBitmap.copyPixelsFromBuffer(allocateDirect);
            return createBitmap;
        }

        private void initAEFilterManager(int i3, int i16) {
            Logger.i("AEKitFilter", "constructing");
            DurationUtil.start("init aeFilterManager");
            AEFilterManager aEFilterManager = new AEFilterManager("defaultBeautyV6.json", false, false, null);
            this.aeFilterManager = aEFilterManager;
            aEFilterManager.supportMultiThreads(true);
            this.aeFilterManager.initInGL(i3, i16);
            this.aeFilterManager.defineFiltersAndOrder(300, 100);
            this.aeFilterManager.setFilterInSmooth(true);
            this.aeFilterManager.setExternalRenderCallback(this);
            AEAdjust aEAdjust = new AEAdjust();
            this.aeAdjust = aEAdjust;
            aEAdjust.apply();
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
                AEFilterManager aEFilterManager = PreSegNode.this.outAEFilterManager;
                this.aeFilterManager = aEFilterManager;
                if (aEFilterManager != null) {
                    aEFilterManager.initInGL(i3, i16);
                    this.aeFilterManager.setExternalRenderCallback(this);
                    this.cacheFrame = new Frame();
                    AEAdjust aEAdjust = new AEAdjust();
                    this.aeAdjust = aEAdjust;
                    aEAdjust.apply();
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
            int i3;
            Frame frame;
            long currentTimeMillis = System.currentTimeMillis();
            Logger.i("PreSegNode begin", String.valueOf(currentTimeMillis));
            if (PreSegNode.this.preSegModel == null) {
                return cIImage;
            }
            String cacheName = WSSegmentManager.getCacheName(PreSegNode.this.preSegModel, PreSegNode.this.cropModel);
            int index = PreSegNode.this.preSegModel.getIndex();
            if (index < 0) {
                return cIImage;
            }
            if (PreSegNode.this.picSaveDelegate != null) {
                String str = PreSegNode.this.picSaveDelegate.getCachePath() + File.pathSeparator + cacheName + ".jpg";
                if (new File(str).exists()) {
                    CIImage cIImage2 = this.curCIImage;
                    if (cIImage2 != null) {
                        cIImage2.release();
                    }
                    CIImage cIImage3 = new CIImage(str);
                    this.curCIImage = cIImage3;
                    return cIImage3;
                }
            }
            Bitmap bitmap = WSSegmentManager.get(index, cacheName);
            if (bitmap != null && bitmap.getHeight() > 0 && bitmap.getWidth() > 0) {
                CIImage cIImage4 = this.curCIImage;
                if (cIImage4 != null) {
                    cIImage4.release();
                }
                CIImage cIImage5 = new CIImage(bitmap.copy(bitmap.getConfig(), true));
                this.curCIImage = cIImage5;
                return cIImage5;
            }
            DurationUtil.start("apply aeFilterManager");
            int i16 = (int) cIImage.getSize().width;
            int i17 = (int) cIImage.getSize().height;
            initFilterManagerWrap(i16, i17);
            if (!this.aeFilterManager.isInited() || (ciContext = renderInfo.getCiContext()) == null || ciContext.getRenderContext() == null) {
                return cIImage;
            }
            if (this.cacheInputTextureInfo == null) {
                ciContext.getRenderContext().makeCurrent();
                this.cacheInputTextureInfo = CIContext.newTextureInfo(i16, i17);
            }
            TextureInfo textureInfo = this.cacheInputTextureInfo;
            if (textureInfo.width != i16 || textureInfo.height != i17) {
                ciContext.getRenderContext().makeCurrent();
                this.cacheInputTextureInfo.release();
                this.cacheInputTextureInfo = CIContext.newTextureInfo(i16, i17);
            }
            TextureInfo textureInfo2 = this.cacheOutTexture;
            if (textureInfo2 == null) {
                ciContext.getRenderContext().makeCurrent();
                this.cacheOutTexture = CIContext.newTextureInfo(i16, i17);
            } else if (textureInfo2.width != i16 || textureInfo2.height != i17) {
                ciContext.getRenderContext().makeCurrent();
                this.cacheOutTexture.release();
                this.cacheOutTexture = CIContext.newTextureInfo(i16, i17);
            }
            ciContext.convertImageToTexture(cIImage, this.cacheInputTextureInfo);
            TextureInfo textureInfo3 = this.cacheInputTextureInfo;
            if (textureInfo3 == null) {
                return cIImage;
            }
            this.aeFilterManager.updateWidthHeight(textureInfo3.width, textureInfo3.height);
            if (PreSegNode.this.preSegModel != null) {
                String segMaterial = PreSegNode.this.preSegModel.getSegMaterial();
                if (TextUtils.isEmpty(segMaterial)) {
                    return cIImage;
                }
                this.aeFilterManager.switchAbilityInLightNode("smooth.enable", false);
                if (!TextUtils.isEmpty(segMaterial)) {
                    i3 = i17;
                    this.mFlipFilter.RenderProcess(textureInfo3.textureID, textureInfo3.width, textureInfo3.height, this.mFlipTextureID[0], 0.0d, this.mFlipFrame);
                    frame = this.mFlipFrame;
                } else {
                    i3 = i17;
                    frame = null;
                }
                this.aeFilterManager.switchAbilityInLightNode("sticker.enable", true);
                this.aeFilterManager.updateMaterialGL(VideoSDKMaterialParser.parseVideoMaterial(segMaterial, "params"));
                this.aeFilterManager.setSyncMode(true);
            } else {
                i3 = i17;
                frame = null;
            }
            int i18 = textureInfo3.textureID;
            Logger.i("PreSegNode set up", String.valueOf(System.currentTimeMillis() - currentTimeMillis));
            long currentTimeMillis2 = System.currentTimeMillis();
            DurationUtil.start("aeFilterManager.drawFrame");
            int drawFrame = this.aeFilterManager.drawFrame(i18, false, 0L);
            DurationUtil.end("aeFilterManager.drawFrame");
            Logger.i("PreSegNode draw frame", String.valueOf(System.currentTimeMillis() - currentTimeMillis2));
            long currentTimeMillis3 = System.currentTimeMillis();
            TextureInfo textureInfo4 = this.cacheInputTextureInfo;
            Bitmap checkSegCentre = checkSegCentre(getTextureInfoBitmap(textureInfo4.width, textureInfo4.height, drawFrame));
            if (checkSegCentre == null) {
                return cIImage;
            }
            WSSegmentManager.put(index, cacheName, checkSegCentre);
            if (PreSegNode.this.picSaveDelegate != null && checkSegCentre.getWidth() > 0 && checkSegCentre.getHeight() > 0) {
                PreSegNode.this.picSaveDelegate.savePic(PreSegNode.this.picSaveDelegate.getCachePath() + File.pathSeparator + cacheName + ".jpg", checkSegCentre);
            }
            this.mFlipFilter.OnDrawFrameGLSL();
            this.mFlipFilter.RenderProcess(drawFrame, i16, i3, this.cacheOutTexture.textureID, 0.0d, this.cacheFrame);
            if (frame != null && !frame.unlock()) {
                frame.clear();
            }
            this.aeFilterManager.updateMaterialGL(null);
            FrameBufferCache.getInstance().forceRecycle();
            this.aeFilterManager.freeCache();
            CIImage cIImage6 = new CIImage(checkSegCentre);
            Logger.i("PreSegNode after", String.valueOf(System.currentTimeMillis() - currentTimeMillis3));
            return cIImage6;
        }

        @Override // com.tencent.tavkit.report.IReportable
        public String getReportKey() {
            return PreSegNode.this.reportKey;
        }

        @Override // org.light.callback.ExternalRenderCallback
        public void onRender(Texture texture, String str, String str2, Texture texture2) {
            LogUtils.d(PreSegNode.TAG, "onRender: \u89e6\u53d1\u5916\u6302\u6ee4\u955c\uff0c\u53c2\u6570\uff1a" + texture + "|" + str + "|" + str2 + "|" + texture2);
            texture2.f423804id = texture.f423804id;
            texture2.width = texture.width;
            texture2.height = texture.height;
        }

        @Override // com.tencent.tavkit.composition.video.Releasable
        public void release() {
            Log.i(PreSegNode.TAG, "releaseAEKitFilter---");
            int[] iArr = this.mFlipTextureID;
            GLES20.glDeleteTextures(iArr.length, iArr, 0);
            AEFilterManager aEFilterManager = this.aeFilterManager;
            if (aEFilterManager != null) {
                aEFilterManager.setExternalRenderCallback(null);
                if (PreSegNode.this.outAEFilterManager == null) {
                    this.aeFilterManager.destroy();
                }
                this.aeFilterManager = null;
            }
            if (PreSegNode.this.outAEFilterManager != null) {
                PreSegNode.this.outAEFilterManager = null;
            }
            CIImage cIImage = this.curCIImage;
            if (cIImage != null) {
                cIImage.release();
                this.curCIImage = null;
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
            TextureInfo textureInfo = this.cacheInputTextureInfo;
            if (textureInfo != null && !textureInfo.isReleased()) {
                this.cacheInputTextureInfo.release();
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
            AEAdjust aEAdjust = this.aeAdjust;
            if (aEAdjust != null) {
                aEAdjust.clear();
                this.aeAdjust = null;
            }
        }
    }

    /* loaded from: classes22.dex */
    public interface PicSaveDelegate {
        String getCachePath();

        void savePic(String str, Bitmap bitmap);
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

    public void setCropModel(CropModel cropModel) {
        this.cropModel = cropModel;
    }

    public void setFilterManager(AEFilterManager aEFilterManager) {
        this.outAEFilterManager = aEFilterManager;
    }

    public void setPicSaveDelegate(PicSaveDelegate picSaveDelegate) {
        this.picSaveDelegate = picSaveDelegate;
    }

    public void setPreSegModel(PreSegModel preSegModel) {
        this.preSegModel = preSegModel;
    }
}
