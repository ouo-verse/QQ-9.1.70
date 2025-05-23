package com.tencent.autotemplate.filter;

import android.graphics.PointF;
import android.support.annotation.NonNull;
import android.util.Log;
import android.util.Pair;
import com.tencent.autotemplate.TAVAutomaticRenderContext;
import com.tencent.autotemplate.extra.ExtraData;
import com.tencent.autotemplate.transition.FaceTransition;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.model.TAVVideoCompositionTrack;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration;
import com.tencent.tavkit.composition.video.ImageCollection;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import com.tencent.tavkit.report.MemoryReportHelper;
import com.tencent.tavkit.utils.BenchUtil;
import com.tencent.tavsticker.log.TLog;
import com.tencent.tavsticker.model.TAVSourceImage;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.utils.CollectionUtil;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TAVOneClickFilmStickerEffect implements TAVVideoMixEffect {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "TAVStickerOverlayEffect";
    public static final String TRACK_INDEX = "trackIndex";
    private int count;
    private List<FaceTransition> faceTransitions;
    private int mRenderSceneType;
    protected String reportKey;
    private TAVAutomaticRenderContext stickerContext;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class SceneType {
        static IPatchRedirector $redirector_ = null;
        public static final int AUTO_TEMPLATE_SCENE = 2;
        public static final int DEFAULT_SCENE = 0;
        public static final int TEMPLATE_SCENE = 1;

        public SceneType() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private class StickerVideoCompositionMixerEffect extends TAVBaseMixFilter {
        static IPatchRedirector $redirector_;
        private TAVFaceMorphingFilter faceMorphingFilter;
        private TAVAutomaticRenderContext stickerContext;

        /* synthetic */ StickerVideoCompositionMixerEffect(TAVOneClickFilmStickerEffect tAVOneClickFilmStickerEffect, TAVAutomaticRenderContext tAVAutomaticRenderContext, AnonymousClass1 anonymousClass1) {
            this(tAVAutomaticRenderContext);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                return;
            }
            iPatchRedirector.redirect((short) 8, this, tAVOneClickFilmStickerEffect, tAVAutomaticRenderContext, anonymousClass1);
        }

        @Override // com.tencent.autotemplate.filter.TAVBaseMixFilter, com.tencent.tavkit.composition.video.TAVVideoMixEffect.Filter
        public CIImage apply(TAVVideoMixEffect tAVVideoMixEffect, ImageCollection imageCollection, RenderInfo renderInfo) {
            TextureInfo textureInfo;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (CIImage) iPatchRedirector.redirect((short) 2, this, tAVVideoMixEffect, imageCollection, renderInfo);
            }
            super.apply(tAVVideoMixEffect, imageCollection, renderInfo);
            CGSize renderSize = renderInfo.getRenderSize();
            List<TAVSourceImage> arrayList = new ArrayList<>();
            ArrayList arrayList2 = new ArrayList();
            TAVFaceMorphingFilter tAVFaceMorphingFilter = this.faceMorphingFilter;
            if (tAVFaceMorphingFilter != null && tAVFaceMorphingFilter.needRender(imageCollection, this.currentTime)) {
                CIImage apply = this.faceMorphingFilter.apply(tAVVideoMixEffect, imageCollection, renderInfo);
                textureInfo = getCachedTexture(apply, apply.getSize(), renderInfo);
                arrayList.add(new TAVSourceImage(textureInfo, true, 0));
            } else {
                arrayList = getCachedTextures(imageCollection.getVideoChannelImages(), arrayList2, renderInfo, renderSize);
                textureInfo = null;
            }
            this.stickerContext.setRenderSize(renderSize);
            BenchUtil.benchStart("renderStickerChain");
            CMSampleBuffer renderStickerChainWithTexture = this.stickerContext.renderStickerChainWithTexture(this.currentTime.getTimeUs() / 1000, arrayList);
            BenchUtil.benchEnd("renderStickerChain");
            this.renderContext.makeCurrent();
            if (renderStickerChainWithTexture != null) {
                return new CIImage(renderStickerChainWithTexture.getTextureInfo());
            }
            if (textureInfo != null) {
                return new CIImage(textureInfo);
            }
            if (!needCropTexture(imageCollection)) {
                return null;
            }
            return getOutputImage(arrayList2.get(0), renderInfo);
        }

        public List<TAVSourceImage> getCachedTextures(List<ImageCollection.TrackImagePair> list, List<TextureInfo> list2, RenderInfo renderInfo, CGSize cGSize) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (List) iPatchRedirector.redirect((short) 5, this, list, list2, renderInfo, cGSize);
            }
            ArrayList arrayList = new ArrayList();
            if (CollectionUtil.isEmptyList(list)) {
                return arrayList;
            }
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                ImageCollection.TrackImagePair trackImagePair = list.get(i3);
                if (trackImagePair != null) {
                    int pAGLayerIndex = getPAGLayerIndex(trackImagePair);
                    if (TAVOneClickFilmStickerEffect.this.mRenderSceneType != 1 || pAGLayerIndex != -1) {
                        Pair<CIImage, CGSize> applyContentMode = applyContentMode(trackImagePair, cGSize, renderInfo);
                        TextureInfo cachedTexture = getCachedTexture((CIImage) applyContentMode.first, (CGSize) applyContentMode.second, renderInfo);
                        list2.add(cachedTexture);
                        TLog.d(TAVOneClickFilmStickerEffect.TAG, "PAGImage::layerIndex: " + i3 + ", renderSize: " + cachedTexture.width + ", " + cachedTexture.height + ", textureID: " + cachedTexture.textureID + ", context: " + this.renderContext.eglContext());
                        if (pAGLayerIndex == -1) {
                            arrayList.add(new TAVSourceImage(cachedTexture, true, i3));
                        } else {
                            arrayList.add(new TAVSourceImage(cachedTexture, true, pAGLayerIndex));
                        }
                    }
                }
            }
            return arrayList;
        }

        public CIImage getOutputImage(TextureInfo textureInfo, RenderInfo renderInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (CIImage) iPatchRedirector.redirect((short) 4, (Object) this, (Object) textureInfo, (Object) renderInfo);
            }
            CIImage cIImage = new CIImage(textureInfo);
            cIImage.applyFillInFrame(new CGRect(new PointF(), renderInfo.getRenderSize()), TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
            CGSize size = cIImage.getSize();
            size.width = renderInfo.getRenderWidth();
            size.height = renderInfo.getRenderHeight();
            return cIImage;
        }

        @Override // com.tencent.tavkit.report.IReportable
        public String getReportKey() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            ArrayList arrayList = new ArrayList();
            TAVAutomaticRenderContext tAVAutomaticRenderContext = this.stickerContext;
            if (tAVAutomaticRenderContext != null) {
                synchronized (tAVAutomaticRenderContext.getStickers()) {
                    for (TAVSticker tAVSticker : this.stickerContext.getStickers()) {
                        if (tAVSticker != null && tAVSticker.getTimeRange() != null && tAVSticker.getTimeRange().containsTime(this.currentTime)) {
                            arrayList.add(tAVSticker.getStickerId());
                        }
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                return TAVOneClickFilmStickerEffect.this.reportKey + ":[" + MemoryReportHelper.appendKeys(arrayList) + "]";
            }
            return null;
        }

        public boolean needCropTexture(ImageCollection imageCollection) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) imageCollection)).booleanValue();
            }
            List<ImageCollection.TrackImagePair> videoChannelImages = imageCollection.getVideoChannelImages();
            if (!videoChannelImages.isEmpty()) {
                TAVVideoCompositionTrack track = videoChannelImages.get(0).getTrack();
                if (isTAVClip(track) && track.getExtraTrackInfo(ExtraData.EXTRA_FRAME_INFO) != null) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.tencent.autotemplate.filter.TAVBaseMixFilter, com.tencent.tavkit.composition.video.Releasable
        public void release() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
                return;
            }
            super.release();
            TAVAutomaticRenderContext tAVAutomaticRenderContext = this.stickerContext;
            if (tAVAutomaticRenderContext != null) {
                tAVAutomaticRenderContext.release();
                this.stickerContext = null;
            }
            TLog.d(TAVOneClickFilmStickerEffect.TAG, "release cache." + Log.getStackTraceString(new RuntimeException()));
        }

        StickerVideoCompositionMixerEffect(TAVAutomaticRenderContext tAVAutomaticRenderContext) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TAVOneClickFilmStickerEffect.this, (Object) tAVAutomaticRenderContext);
                return;
            }
            this.stickerContext = tAVAutomaticRenderContext;
            if (CollectionUtil.isEmptyList(TAVOneClickFilmStickerEffect.this.faceTransitions)) {
                return;
            }
            this.faceMorphingFilter = new TAVFaceMorphingFilter(TAVOneClickFilmStickerEffect.this.faceTransitions);
        }
    }

    public TAVOneClickFilmStickerEffect(TAVAutomaticRenderContext tAVAutomaticRenderContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) tAVAutomaticRenderContext);
            return;
        }
        this.count = 0;
        this.mRenderSceneType = 0;
        this.reportKey = "TAVOneClickFilmStickerEffect";
        this.stickerContext = tAVAutomaticRenderContext;
    }

    @Override // com.tencent.tavkit.composition.video.TAVVideoMixEffect
    public TAVVideoMixEffect.Filter createFilter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (TAVVideoMixEffect.Filter) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        int i3 = this.count;
        AnonymousClass1 anonymousClass1 = null;
        if (i3 == 0) {
            this.count = i3 + 1;
            return new StickerVideoCompositionMixerEffect(this, this.stickerContext, anonymousClass1);
        }
        return new StickerVideoCompositionMixerEffect(this, this.stickerContext.copyRenderContext(), anonymousClass1);
    }

    @Override // com.tencent.tavkit.composition.video.TAVVideoMixEffect
    @NonNull
    public String effectId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "TAVOneClickFilmStickerEffect";
    }

    public TAVAutomaticRenderContext getStickerContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TAVAutomaticRenderContext) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.stickerContext;
    }

    public void setFaceTransitions(List<FaceTransition> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
        } else {
            this.faceTransitions = list;
        }
    }

    public void setRenderSceneType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            this.mRenderSceneType = i3;
        }
    }

    public void setReportKey(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.reportKey = str;
        }
    }
}
