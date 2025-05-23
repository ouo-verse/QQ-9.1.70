package com.tencent.autotemplate.filter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Pair;
import com.tencent.autotemplate.extra.ExtraData;
import com.tencent.autotemplate.extra.FaceInfo;
import com.tencent.autotemplate.extra.FrameInfo;
import com.tencent.autotemplate.transition.FaceTransition;
import com.tencent.filter.GLSLRender;
import com.tencent.gradientface.SmartKitGradientFaceEffect;
import com.tencent.gradientface.SmartKitGradientFaceInfo;
import com.tencent.gradientface.SmartKitGradientFaceInput;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.ciimage.TAVGLUtils;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.model.TAVVideoCompositionTrack;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration;
import com.tencent.tavkit.composition.video.ImageCollection;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import com.tencent.tavkit.utils.BenchUtil;
import com.tencent.tavsticker.utils.CollectionUtil;
import com.tencent.ttpic.openapi.PTFaceAttr;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TAVFaceMorphingFilter extends TAVBaseMixFilter {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "TAVAutoTemplateExtraFilter";
    private List<FaceTransition> faceTransitions;
    private SmartKitGradientFaceEffect gradientFaceEffect;

    public TAVFaceMorphingFilter(@NotNull List<FaceTransition> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) list);
        } else {
            this.faceTransitions = list;
        }
    }

    private CIImage faceTransition(SmartKitGradientFaceInfo smartKitGradientFaceInfo, SmartKitGradientFaceInfo smartKitGradientFaceInfo2, float f16) {
        getGradientFaceEffect().setValueForRender("inputGradientFace", new SmartKitGradientFaceInput(smartKitGradientFaceInfo, smartKitGradientFaceInfo2, f16));
        Map render = getGradientFaceEffect().render();
        return new CIImage(new TextureInfo(((Integer) render.get("outputGradientFace")).intValue(), GLSLRender.GL_TEXTURE_2D, ((Integer) render.get("outputGradientFaceWidth")).intValue(), ((Integer) render.get("outputGradientFaceHeight")).intValue(), 0));
    }

    private PTFaceAttr getFaceInfo(ImageCollection.TrackImagePair trackImagePair, TextureInfo textureInfo) {
        if (trackImagePair != null && trackImagePair.getTrack() != null && (trackImagePair.getTrack().getExtraTrackInfo(ExtraData.EXTRA_FACE_INFO) instanceof FaceInfo)) {
            return transform((FaceInfo) trackImagePair.getTrack().getExtraTrackInfo(ExtraData.EXTRA_FACE_INFO), textureInfo);
        }
        return null;
    }

    private List<PTFaceAttr> getFaceInfos(List<ImageCollection.TrackImagePair> list, List<TextureInfo> list2) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            arrayList.add(getFaceInfo(list.get(i3), list2.get(i3)));
        }
        return arrayList;
    }

    private Rect getFrameInfo(ImageCollection.TrackImagePair trackImagePair, TextureInfo textureInfo) {
        if (trackImagePair != null && trackImagePair.getTrack() != null && (trackImagePair.getTrack().getExtraTrackInfo(ExtraData.EXTRA_FRAME_INFO) instanceof FrameInfo)) {
            return transform((FrameInfo) trackImagePair.getTrack().getExtraTrackInfo(ExtraData.EXTRA_FRAME_INFO), textureInfo);
        }
        return null;
    }

    private List<Rect> getFrameInfos(List<ImageCollection.TrackImagePair> list, List<TextureInfo> list2) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            arrayList.add(getFrameInfo(list.get(i3), list2.get(i3)));
        }
        return arrayList;
    }

    private SmartKitGradientFaceEffect getGradientFaceEffect() {
        if (this.gradientFaceEffect == null) {
            SmartKitGradientFaceEffect smartKitGradientFaceEffect = new SmartKitGradientFaceEffect();
            this.gradientFaceEffect = smartKitGradientFaceEffect;
            smartKitGradientFaceEffect.prepare();
        }
        return this.gradientFaceEffect;
    }

    private float getTransitionProgress() {
        CMTimeRange transitionTimeRange = getTransitionTimeRange(this.currentTime);
        if (transitionTimeRange == null) {
            return 0.0f;
        }
        float timeUs = ((float) (this.currentTime.getTimeUs() - transitionTimeRange.getStartUs())) / ((float) transitionTimeRange.getDurationUs());
        if (timeUs < 0.0f) {
            return 0.0f;
        }
        if (timeUs > 1.0f) {
            return 1.0f;
        }
        return timeUs;
    }

    private CMTimeRange getTransitionTimeRange(CMTime cMTime) {
        Iterator<FaceTransition> it = this.faceTransitions.iterator();
        while (it.hasNext()) {
            CMTimeRange timeRange = it.next().getTimeRange();
            if (timeRange.containsTime(cMTime)) {
                return timeRange;
            }
        }
        return null;
    }

    private boolean needTransition() {
        Iterator<FaceTransition> it = this.faceTransitions.iterator();
        while (it.hasNext()) {
            if (it.next().getTimeRange().containsTime(this.currentTime)) {
                return true;
            }
        }
        return false;
    }

    private PTFaceAttr transform(FaceInfo faceInfo, TextureInfo textureInfo) {
        float f16 = faceInfo.sourceWidth / textureInfo.width;
        PTFaceAttr pTFaceAttr = faceInfo.faceAttr;
        pTFaceAttr.setFaceDetectScale(f16);
        return pTFaceAttr;
    }

    @Override // com.tencent.autotemplate.filter.TAVBaseMixFilter, com.tencent.tavkit.composition.video.TAVVideoMixEffect.Filter
    public CIImage apply(TAVVideoMixEffect tAVVideoMixEffect, ImageCollection imageCollection, RenderInfo renderInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CIImage) iPatchRedirector.redirect((short) 2, this, tAVVideoMixEffect, imageCollection, renderInfo);
        }
        super.apply(tAVVideoMixEffect, imageCollection, renderInfo);
        List<ImageCollection.TrackImagePair> videoChannelImages = imageCollection.getVideoChannelImages();
        CGSize renderSize = renderInfo.getRenderSize();
        CIImage cIImage = null;
        if (!CollectionUtil.isEmptyList(videoChannelImages)) {
            BenchUtil.benchStart("renderExtraChain");
            if (needTransition() && videoChannelImages.size() >= 2) {
                List<TextureInfo> cachedTextures = getCachedTextures(videoChannelImages, renderInfo, renderSize);
                getFrameInfos(videoChannelImages, cachedTextures);
                cIImage = transitionRender(cachedTextures, getFaceInfos(videoChannelImages, cachedTextures), renderSize);
            }
            BenchUtil.benchEnd("renderExtraChain");
            this.renderContext.makeCurrent();
        }
        return cIImage;
    }

    @Override // com.tencent.autotemplate.filter.TAVBaseMixFilter
    public Pair<CIImage, CGSize> applyContentMode(ImageCollection.TrackImagePair trackImagePair, CGSize cGSize, RenderInfo renderInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Pair) iPatchRedirector.redirect((short) 6, this, trackImagePair, cGSize, renderInfo);
        }
        Pair<CIImage, CGSize> applyContentMode = super.applyContentMode(trackImagePair, cGSize, renderInfo);
        ((CIImage) applyContentMode.first).applyFlip(false, true);
        return applyContentMode;
    }

    public Bitmap debugFaceInfo(PTFaceAttr pTFaceAttr, TextureInfo textureInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Bitmap) iPatchRedirector.redirect((short) 3, (Object) this, (Object) pTFaceAttr, (Object) textureInfo);
        }
        Bitmap saveBitmap = TAVGLUtils.saveBitmap(textureInfo);
        Canvas canvas = new Canvas(saveBitmap);
        List<PointF> list = pTFaceAttr.getAllFacePoints().get(0);
        double faceDetectScale = pTFaceAttr.getFaceDetectScale();
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#ff00ff"));
        paint.setAntiAlias(true);
        paint.setStrokeWidth(3.0f);
        for (PointF pointF : list) {
            canvas.drawPoint((float) (pointF.x / faceDetectScale), (float) (pointF.y / faceDetectScale), paint);
        }
        return saveBitmap;
    }

    public List<TextureInfo> getCachedTextures(List<ImageCollection.TrackImagePair> list, RenderInfo renderInfo, CGSize cGSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, this, list, renderInfo, cGSize);
        }
        int size = list.size();
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < size; i3++) {
            ImageCollection.TrackImagePair trackImagePair = list.get(i3);
            if (trackImagePair != null) {
                Pair<CIImage, CGSize> applyContentMode = applyContentMode(trackImagePair, cGSize, renderInfo);
                arrayList.add(getCachedTexture((CIImage) applyContentMode.first, (CGSize) applyContentMode.second, renderInfo));
            }
        }
        return arrayList;
    }

    @Override // com.tencent.tavkit.report.IReportable
    public String getReportKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return TAG;
    }

    public boolean needRender(ImageCollection imageCollection, CMTime cMTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) imageCollection, (Object) cMTime)).booleanValue();
        }
        List<ImageCollection.TrackImagePair> videoChannelImages = imageCollection.getVideoChannelImages();
        if (CollectionUtil.isEmptyList(videoChannelImages) || getTransitionTimeRange(cMTime) == null) {
            return false;
        }
        Iterator<ImageCollection.TrackImagePair> it = videoChannelImages.iterator();
        while (it.hasNext()) {
            TAVVideoCompositionTrack track = it.next().getTrack();
            if (track instanceof TAVClip) {
                Object extraTrackInfo = track.getExtraTrackInfo(ExtraData.EXTRA_FACE_INFO);
                Object extraTrackInfo2 = track.getExtraTrackInfo(ExtraData.EXTRA_FRAME_INFO);
                if (extraTrackInfo == null || extraTrackInfo2 == null) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.tencent.autotemplate.filter.TAVBaseMixFilter, com.tencent.tavkit.composition.video.Releasable
    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.release();
        SmartKitGradientFaceEffect smartKitGradientFaceEffect = this.gradientFaceEffect;
        if (smartKitGradientFaceEffect != null) {
            smartKitGradientFaceEffect.clean();
            this.gradientFaceEffect = null;
        }
    }

    public CIImage transitionRender(List<TextureInfo> list, List<PTFaceAttr> list2, CGSize cGSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CIImage) iPatchRedirector.redirect((short) 4, this, list, list2, cGSize);
        }
        TextureInfo textureInfo = list.get(0);
        TextureInfo textureInfo2 = list.get(1);
        PTFaceAttr pTFaceAttr = list2.get(0);
        PTFaceAttr pTFaceAttr2 = list2.get(1);
        SmartKitGradientFaceInfo smartKitGradientFaceInfo = new SmartKitGradientFaceInfo(textureInfo.textureID, pTFaceAttr);
        smartKitGradientFaceInfo.width = textureInfo.width;
        smartKitGradientFaceInfo.height = textureInfo.height;
        SmartKitGradientFaceInfo smartKitGradientFaceInfo2 = new SmartKitGradientFaceInfo(textureInfo2.textureID, pTFaceAttr2);
        smartKitGradientFaceInfo2.width = textureInfo2.width;
        smartKitGradientFaceInfo2.height = textureInfo2.height;
        CIImage faceTransition = faceTransition(smartKitGradientFaceInfo, smartKitGradientFaceInfo2, getTransitionProgress());
        faceTransition.applyFlip(false, true);
        faceTransition.applyFillInFrame(new CGRect(new PointF(), cGSize), TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
        CGSize size = faceTransition.getSize();
        size.width = cGSize.width;
        size.height = cGSize.height;
        return faceTransition;
    }

    private Rect transform(FrameInfo frameInfo, TextureInfo textureInfo) {
        Rect rect = frameInfo.frame;
        float f16 = textureInfo.width / frameInfo.sourceWidth;
        float f17 = textureInfo.height / frameInfo.sourceHeight;
        return new Rect((int) (rect.left * f16), (int) (rect.top * f17), (int) (rect.right * f16), (int) (rect.bottom * f17));
    }
}
