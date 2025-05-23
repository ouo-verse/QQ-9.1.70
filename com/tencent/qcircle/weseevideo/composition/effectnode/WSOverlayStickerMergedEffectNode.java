package com.tencent.qcircle.weseevideo.composition.effectnode;

import android.graphics.PointF;
import android.support.annotation.NonNull;
import android.util.Log;
import com.tencent.autotemplate.filter.GaosiBlurFilter;
import com.tencent.autotemplate.filter.ScaleTextureFilter;
import com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager;
import com.tencent.qcircle.weseevideo.editor.sticker.IBlurStickerRenderContext;
import com.tencent.qcircle.weseevideo.editor.utils.HandlerUtils;
import com.tencent.qcircle.weseevideo.model.effect.StickerModel;
import com.tencent.qcircle.weseevideo.model.effect.SubtitleModel;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.report.IReportable;
import com.tencent.tavkit.report.MemoryReportHelper;
import com.tencent.tavmovie.filter.TAVStickerOverlayEffect;
import com.tencent.tavsticker.core.TAVStickerContext;
import com.tencent.tavsticker.core.TAVStickerRenderContext;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerMode;
import com.tencent.tavsticker.utils.CollectionUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes22.dex */
public class WSOverlayStickerMergedEffectNode extends TAVStickerOverlayEffect {
    public static final int BLUR_RADIUS = 10;
    public static final float BLUR_SCALE = 0.25f;
    private VideoRenderChainManager.IStickerContextInterface mContextCreator;
    private List<StickerModel> mStickerModels;
    private SubtitleModel mSubtitleModel;
    boolean needRender;
    private final String sEffectId;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private class WsVideoCompositionEffect implements TAVVideoEffect.Filter, IReportable {
        long applyEffectStartTime;

        @Nullable
        private TAVStickerRenderContext cloneStickerContext;
        private CMTime currentTime;
        private GaosiBlurFilter horizontalBlurFilter;
        private ScaleTextureFilter scaleBigTextureFilter;
        private ScaleTextureFilter scaleSmallTextureFilter;

        @Nullable
        private TAVStickerRenderContext stickerContext;
        private HashMap<String, TextureInfo> textureMap;
        private GaosiBlurFilter verticalBlurFilter;

        private CIImage applyEffectHard(@NonNull TAVStickerRenderContext tAVStickerRenderContext, CIImage cIImage, CMTime cMTime, CIContext cIContext) {
            boolean z16;
            if (((TAVStickerOverlayEffect) WSOverlayStickerMergedEffectNode.this).stickers != null && !((TAVStickerOverlayEffect) WSOverlayStickerMergedEffectNode.this).stickers.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (TAVSticker tAVSticker : ((TAVStickerOverlayEffect) WSOverlayStickerMergedEffectNode.this).stickers) {
                    if (tAVSticker.getTimeRange().containsTime(cMTime)) {
                        arrayList.add(tAVSticker);
                    }
                }
                if (arrayList.isEmpty()) {
                    releaseCloneRenderContext();
                }
                if (((TAVStickerOverlayEffect) WSOverlayStickerMergedEffectNode.this).realTimeReleaseEachSticker && this.cloneStickerContext != null && arrayList.size() < this.cloneStickerContext.getStickerCount()) {
                    releaseCloneRenderContext();
                }
                Iterator<TAVSticker> it = arrayList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        TAVSticker next = it.next();
                        TAVStickerRenderContext tAVStickerRenderContext2 = this.cloneStickerContext;
                        if (tAVStickerRenderContext2 != null && !tAVStickerRenderContext2.containSticker(next)) {
                            z16 = true;
                            break;
                        }
                    } else {
                        z16 = false;
                        break;
                    }
                }
                if (z16 && ((TAVStickerOverlayEffect) WSOverlayStickerMergedEffectNode.this).realTimeReleaseEachSticker) {
                    releaseCloneRenderContext();
                }
                renderByCloneContext(tAVStickerRenderContext, arrayList, cIImage, cMTime, cIContext);
            }
            return cIImage;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private CIImage applyWithBlurStickerRenderContext(TAVStickerRenderContext tAVStickerRenderContext, TAVVideoEffect tAVVideoEffect, CIImage cIImage, RenderInfo renderInfo) {
            this.applyEffectStartTime = System.currentTimeMillis();
            CIContext ciContext = renderInfo.getCiContext();
            if (tAVStickerRenderContext == 0) {
                return cIImage;
            }
            this.stickerContext.setRenderSize(cIImage.getSize());
            WSOverLayBlurManager.updateSourceCIImage(tAVStickerRenderContext, cIImage, renderInfo);
            this.currentTime = renderInfo.getTime();
            if (((TAVStickerOverlayEffect) WSOverlayStickerMergedEffectNode.this).realTimeReleaseStickerContext) {
                return applyEffectHard(tAVStickerRenderContext, cIImage, renderInfo.getTime(), ciContext);
            }
            CMSampleBuffer renderSticker = this.stickerContext.renderSticker(renderInfo.getTime().getTimeUs() / 1000, null, ciContext.getRenderContext().eglContext());
            ciContext.getRenderContext().makeCurrent();
            if (noStickerRender(renderInfo.getTime(), tAVStickerRenderContext.getStickers())) {
                return cIImage;
            }
            this.applyEffectStartTime = System.currentTimeMillis();
            if (renderSticker != null) {
                TextureInfo textureInfo = renderSticker.getTextureInfo();
                textureInfo.setMixAlpha(false);
                CIImage cIImage2 = new CIImage(textureInfo);
                if (((IBlurStickerRenderContext) tAVStickerRenderContext).shouldRenderBlurSticker()) {
                    insertBlurCIImage(cIImage, renderInfo, cIImage2);
                } else if (WSOverlayStickerMergedEffectNode.this.needRender) {
                    cIImage2.imageByCompositingOverImage(cIImage);
                    Log.d("blur_cost", String.format("------------------\u65e0\u9a6c\u8d5b\u514b\u6e32\u67d3\u603b\u8017\u65f6\uff1a%d%s", Long.valueOf(System.currentTimeMillis() - this.applyEffectStartTime), "------------------"));
                }
            }
            return cIImage;
        }

        private CIImage applyWithTAVStickerRenderContext(TAVStickerRenderContext tAVStickerRenderContext, TAVVideoEffect tAVVideoEffect, CIImage cIImage, RenderInfo renderInfo) {
            CIContext ciContext = renderInfo.getCiContext();
            if (tAVStickerRenderContext == null) {
                return cIImage;
            }
            this.stickerContext.setRenderSize(cIImage.getSize());
            if (!WSOverlayStickerMergedEffectNode.this.needRender) {
                return cIImage;
            }
            this.currentTime = renderInfo.getTime();
            if (((TAVStickerOverlayEffect) WSOverlayStickerMergedEffectNode.this).realTimeReleaseStickerContext) {
                return applyEffectHard(tAVStickerRenderContext, cIImage, renderInfo.getTime(), ciContext);
            }
            CMSampleBuffer renderSticker = this.stickerContext.renderSticker(renderInfo.getTime().getTimeUs() / 1000, null, ciContext.getRenderContext().eglContext());
            ciContext.getRenderContext().makeCurrent();
            if (noStickerRender(renderInfo.getTime(), tAVStickerRenderContext.getStickers())) {
                return cIImage;
            }
            if (renderSticker != null) {
                TextureInfo textureInfo = renderSticker.getTextureInfo();
                textureInfo.setMixAlpha(false);
                new CIImage(textureInfo).imageByCompositingOverImage(cIImage);
            }
            return cIImage;
        }

        private TextureInfo extractTextureInfoFromCIImage(CIImage cIImage, RenderInfo renderInfo) {
            return renderInfo.getCiContext().convertImageToTexture(cIImage, getCacheTextureInfo((int) cIImage.getSize().width, (int) cIImage.getSize().height));
        }

        private TextureInfo getCacheTextureInfo(int i3, int i16) {
            TextureInfo textureInfo;
            String str = i3 + "_" + i16;
            if (this.textureMap.containsKey(str)) {
                textureInfo = this.textureMap.get(str);
            } else {
                textureInfo = null;
            }
            if (textureInfo == null) {
                TextureInfo newTextureInfo = CIContext.newTextureInfo(i3, i16);
                this.textureMap.put(str, newTextureInfo);
                return newTextureInfo;
            }
            return textureInfo;
        }

        private void insertBlurCIImage(CIImage cIImage, RenderInfo renderInfo, CIImage cIImage2) {
            List<TAVSticker> blurStickers = ((IBlurStickerRenderContext) this.stickerContext).getBlurStickers();
            TextureInfo extractTextureInfoFromCIImage = extractTextureInfoFromCIImage(cIImage, renderInfo);
            int i3 = extractTextureInfoFromCIImage.preferRotation;
            CIImage cIImage3 = new CIImage(WSOverLayBlurManager.getBlurredTextureInfo(extractTextureInfoFromCIImage, renderInfo, i3, 10, 0.25f, this.horizontalBlurFilter, this.verticalBlurFilter, this.scaleSmallTextureFilter, this.scaleBigTextureFilter));
            cIImage3.applyPreferRotation(0);
            for (TAVSticker tAVSticker : blurStickers) {
                if (tAVSticker.getMode() == TAVStickerMode.INACTIVE) {
                    CIImage cIImage4 = new CIImage(cIImage3.getDrawTextureInfo().m261clone());
                    cIImage4.applyPreferRotation(0);
                    cIImage4.applyFillInFrame(new CGRect(new PointF(0.0f, 0.0f), renderInfo.getRenderSize()), TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
                    CGRect blurRect = WSOverLayBlurManager.getBlurRect(i3, tAVSticker, cIImage4, renderInfo);
                    if (cIImage4.getDrawTextureInfo() != null) {
                        float min = Math.min(cIImage4.getDrawTextureInfo().height, blurRect.size.height);
                        float min2 = Math.min(cIImage4.getDrawTextureInfo().width, blurRect.size.width);
                        PointF pointF = blurRect.origin;
                        float f16 = pointF.x;
                        CGSize cGSize = blurRect.size;
                        pointF.x = (f16 + (cGSize.width / 2.0f)) - (min2 / 2.0f);
                        pointF.y = (pointF.y + (cGSize.height / 2.0f)) - (min / 2.0f);
                        cGSize.width = min2;
                        cGSize.height = min;
                    }
                    cIImage4.setFrame(blurRect);
                    cIImage4.imageByCompositingOverImage(cIImage3);
                }
            }
            if (isRenderNormalSticker()) {
                cIImage2.imageByCompositingOverImage(cIImage3);
            }
            cIImage3.imageByCompositingOverImage(cIImage);
            cIImage3.clearSelfTexture();
        }

        private boolean isRenderNormalSticker() {
            if (!WSOverlayStickerMergedEffectNode.this.needRender || this.stickerContext.getStickers().size() <= ((IBlurStickerRenderContext) this.stickerContext).getBlurStickers().size()) {
                return false;
            }
            for (TAVSticker tAVSticker : this.stickerContext.getStickers()) {
                if (!((IBlurStickerRenderContext) this.stickerContext).getBlurStickers().contains(tAVSticker) && tAVSticker.getMode() == TAVStickerMode.INACTIVE) {
                    return true;
                }
            }
            return false;
        }

        private boolean noStickerRender(CMTime cMTime, List<TAVSticker> list) {
            for (TAVSticker tAVSticker : list) {
                CMTimeRange timeRange = tAVSticker.getTimeRange();
                if (timeRange == null || timeRange.containsTime(cMTime)) {
                    if (tAVSticker.getMode() == TAVStickerMode.INACTIVE) {
                        return false;
                    }
                }
            }
            return true;
        }

        private void releaseCloneRenderContext() {
            TAVStickerRenderContext tAVStickerRenderContext = this.cloneStickerContext;
            if (tAVStickerRenderContext != null) {
                tAVStickerRenderContext.release();
                this.cloneStickerContext.removeAllStickers();
                this.cloneStickerContext = null;
            }
        }

        private void renderByCloneContext(@NonNull TAVStickerRenderContext tAVStickerRenderContext, List<TAVSticker> list, CIImage cIImage, CMTime cMTime, CIContext cIContext) {
            if (list != null && !list.isEmpty()) {
                if (this.cloneStickerContext == null) {
                    this.cloneStickerContext = tAVStickerRenderContext.copy();
                }
                if (this.cloneStickerContext == null) {
                    return;
                }
                for (TAVSticker tAVSticker : list) {
                    if (!this.cloneStickerContext.containSticker(tAVSticker)) {
                        this.cloneStickerContext.loadSticker(tAVSticker);
                    }
                }
                this.cloneStickerContext.setRenderSize(cIImage.getSize());
                CMSampleBuffer renderSticker = this.cloneStickerContext.renderSticker(cMTime.getTimeUs() / 1000, null, cIContext.getRenderContext().eglContext());
                cIContext.getRenderContext().makeCurrent();
                if (renderSticker != null) {
                    if (renderSticker.isNewFrame()) {
                        this.cloneStickerContext.getStickerTexture().awaitNewImage(1000L);
                    }
                    new CIImage(renderSticker.getTextureInfo()).imageByCompositingOverImage(cIImage);
                }
            }
        }

        @Override // com.tencent.tavkit.composition.video.TAVVideoEffect.Filter
        public CIImage apply(TAVVideoEffect tAVVideoEffect, CIImage cIImage, RenderInfo renderInfo) {
            TAVStickerRenderContext tAVStickerRenderContext = this.stickerContext;
            if (tAVStickerRenderContext instanceof IBlurStickerRenderContext) {
                return applyWithBlurStickerRenderContext(tAVStickerRenderContext, tAVVideoEffect, cIImage, renderInfo);
            }
            return applyWithTAVStickerRenderContext(tAVStickerRenderContext, tAVVideoEffect, cIImage, renderInfo);
        }

        @Override // com.tencent.tavkit.report.IReportable
        public String getReportKey() {
            ArrayList arrayList = new ArrayList();
            TAVStickerRenderContext tAVStickerRenderContext = this.stickerContext;
            if (tAVStickerRenderContext != null) {
                synchronized (tAVStickerRenderContext.getStickers()) {
                    for (TAVSticker tAVSticker : this.stickerContext.getStickers()) {
                        if (tAVSticker != null && (tAVSticker.getTimeRange() == null || tAVSticker.getTimeRange().containsTime(this.currentTime))) {
                            arrayList.add(tAVSticker.getStickerId());
                        }
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                return ((TAVStickerOverlayEffect) WSOverlayStickerMergedEffectNode.this).reportKey + ":[" + MemoryReportHelper.appendKeys(arrayList) + "]";
            }
            return null;
        }

        @Override // com.tencent.tavkit.composition.video.Releasable
        public void release() {
            releaseCloneRenderContext();
            if (this.stickerContext != null) {
                TAVStickerRenderContext stickerContext = WSOverlayStickerMergedEffectNode.this.getStickerContext();
                TAVStickerRenderContext tAVStickerRenderContext = this.stickerContext;
                if (stickerContext != tAVStickerRenderContext) {
                    tAVStickerRenderContext.release();
                    this.stickerContext = null;
                }
            }
            GaosiBlurFilter gaosiBlurFilter = this.verticalBlurFilter;
            if (gaosiBlurFilter != null) {
                gaosiBlurFilter.release();
                this.verticalBlurFilter = null;
            }
            GaosiBlurFilter gaosiBlurFilter2 = this.horizontalBlurFilter;
            if (gaosiBlurFilter2 != null) {
                gaosiBlurFilter2.release();
                this.horizontalBlurFilter = null;
            }
        }

        WsVideoCompositionEffect(@NotNull TAVStickerRenderContext tAVStickerRenderContext) {
            this.textureMap = new HashMap<>();
            this.horizontalBlurFilter = new GaosiBlurFilter(true, 20);
            this.verticalBlurFilter = new GaosiBlurFilter(false, 20);
            this.scaleSmallTextureFilter = new ScaleTextureFilter();
            this.scaleBigTextureFilter = new ScaleTextureFilter();
            this.currentTime = CMTime.CMTimeZero;
            this.stickerContext = tAVStickerRenderContext;
        }
    }

    public WSOverlayStickerMergedEffectNode(TAVStickerRenderContext tAVStickerRenderContext, VideoRenderChainManager.IStickerContextInterface iStickerContextInterface, boolean z16) {
        super(tAVStickerRenderContext);
        this.sEffectId = "WSOverlayStickerMergedEffectNode" + Integer.toHexString(hashCode());
        this.mContextCreator = iStickerContextInterface;
        this.needRender = z16;
        this.reportKey = "WSOverlayStickerMergedEffectNode";
    }

    private List<TAVSticker> findStickerByType(int i3) {
        ArrayList arrayList = new ArrayList();
        if (isAvailable()) {
            synchronized (getStickerContext().getStickers()) {
                for (TAVSticker tAVSticker : getStickerContext().getStickers()) {
                    if (tAVSticker != null && i3 == VideoEffectType.TYPE_STICKER.value) {
                        arrayList.add(tAVSticker);
                    }
                }
            }
        }
        return arrayList;
    }

    private boolean isAvailable() {
        if (getStickerContext() != null) {
            return true;
        }
        return false;
    }

    private boolean isEmpty() {
        return false;
    }

    private void removeStickers(List<TAVSticker> list) {
        if (isAvailable() && !CollectionUtil.isEmptyList(list)) {
            for (final TAVSticker tAVSticker : list) {
                final TAVStickerRenderContext stickerContext = getStickerContext();
                if (stickerContext instanceof TAVStickerContext) {
                    HandlerUtils.getMainHandler().post(new Runnable() { // from class: com.tencent.qcircle.weseevideo.composition.effectnode.WSOverlayStickerMergedEffectNode.1
                        @Override // java.lang.Runnable
                        public void run() {
                            stickerContext.removeSticker(tAVSticker);
                        }
                    });
                } else {
                    stickerContext.removeSticker(tAVSticker);
                }
            }
        }
    }

    private void updateCommonSticker(@NonNull CGSize cGSize) {
        if (isAvailable()) {
            removeStickers(findStickerByType(VideoEffectType.TYPE_STICKER.value));
            if (!CollectionUtil.isEmptyList(this.mStickerModels)) {
                VideoEffectNodeFactory.addStickerEffectNode(this.mStickerModels, cGSize, getStickerContext(), this.mContextCreator);
            }
        }
    }

    private void updateSubtitleSticker(@NonNull CGSize cGSize) {
        if (isAvailable()) {
            removeStickers(findStickerByType(VideoEffectType.TYPE_SUBTITLE.value));
            SubtitleModel subtitleModel = this.mSubtitleModel;
            if (subtitleModel != null) {
                VideoEffectNodeFactory.addPagOverlayEffectNode(subtitleModel, cGSize, getStickerContext(), this.mContextCreator);
            }
        }
    }

    @Override // com.tencent.tavmovie.filter.TAVStickerOverlayEffect, com.tencent.tavkit.composition.video.TAVVideoEffect
    public TAVVideoEffect.Filter createFilter() {
        int i3 = this.count;
        if (i3 == 0) {
            this.count = i3 + 1;
            return new WsVideoCompositionEffect(this.stickerContext);
        }
        return new WsVideoCompositionEffect(this.stickerContext.copy());
    }

    @Override // com.tencent.tavmovie.filter.TAVStickerOverlayEffect, com.tencent.tavkit.composition.video.TAVVideoEffect
    @NonNull
    /* renamed from: effectId */
    public String getMEffectId() {
        String str = "";
        if (isEmpty()) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.sEffectId);
        TAVStickerRenderContext tAVStickerRenderContext = this.stickerContext;
        if (tAVStickerRenderContext != null) {
            str = tAVStickerRenderContext.getClass().getSimpleName();
        }
        sb5.append(str);
        return sb5.toString();
    }

    public List<StickerModel> getStickerModels() {
        return this.mStickerModels;
    }

    public SubtitleModel getSubtitleModel() {
        return this.mSubtitleModel;
    }

    public void setNeedRender(boolean z16) {
        this.needRender = z16;
    }

    public void setStickerModels(List<StickerModel> list, CGSize cGSize) {
        this.mStickerModels = list;
        updateCommonSticker(cGSize);
    }

    public void setSubtitleModel(SubtitleModel subtitleModel, CGSize cGSize) {
        this.mSubtitleModel = subtitleModel;
        updateSubtitleSticker(cGSize);
    }
}
