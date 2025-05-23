package com.tencent.autotemplate.filter;

import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Pair;
import com.tencent.autotemplate.extra.ExtraData;
import com.tencent.autotemplate.extra.FrameInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.model.TAVVideoCompositionTrack;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration;
import com.tencent.tavkit.composition.video.ImageCollection;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import com.tencent.tavkit.report.IReportable;
import com.tencent.tavmovie.TAVMovieConfig;
import com.tencent.tavsticker.utils.CollectionUtil;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class TAVBaseMixFilter implements TAVVideoMixEffect.Filter, IReportable {
    static IPatchRedirector $redirector_;
    protected CMTime currentTime;
    protected RenderContext renderContext;
    protected HashMap<String, Integer> sizeKeys;
    protected HashMap<String, TextureInfo> textureMap;

    public TAVBaseMixFilter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.sizeKeys = new HashMap<>();
        this.textureMap = new HashMap<>();
        this.currentTime = CMTime.CMTimeZero;
    }

    private Rect transform(FrameInfo frameInfo, CGSize cGSize) {
        Rect rect = frameInfo.frame;
        float f16 = cGSize.width / frameInfo.sourceWidth;
        float f17 = cGSize.height / frameInfo.sourceHeight;
        return new Rect((int) (rect.left * f16), (int) (rect.top * f17), (int) (rect.right * f16), (int) (rect.bottom * f17));
    }

    @Override // com.tencent.tavkit.composition.video.TAVVideoMixEffect.Filter
    public CIImage apply(TAVVideoMixEffect tAVVideoMixEffect, ImageCollection imageCollection, RenderInfo renderInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CIImage) iPatchRedirector.redirect((short) 2, this, tAVVideoMixEffect, imageCollection, renderInfo);
        }
        this.currentTime = renderInfo.getTime();
        this.renderContext = renderInfo.getCiContext().getRenderContext();
        this.sizeKeys.clear();
        List<ImageCollection.TrackImagePair> videoChannelImages = imageCollection.getVideoChannelImages();
        if (!CollectionUtil.isEmptyList(videoChannelImages)) {
            sortTrackImages(videoChannelImages);
            removeRedundantImage(videoChannelImages);
            return null;
        }
        return null;
    }

    public Pair<CIImage, CGSize> applyContentMode(ImageCollection.TrackImagePair trackImagePair, CGSize cGSize, RenderInfo renderInfo) {
        CIImage image;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Pair) iPatchRedirector.redirect((short) 6, this, trackImagePair, cGSize, renderInfo);
        }
        Rect frameCropRect = getFrameCropRect(trackImagePair.getTrack(), trackImagePair.getImage().getSize());
        if (frameCropRect != null) {
            CIImage m267clone = trackImagePair.getImage().m267clone();
            CGSize size = m267clone.getSize();
            image = new CIImage(getCachedTexture(m267clone, size, renderInfo));
            image.imageByCroppingToRect(new CGRect(frameCropRect.left, size.height - frameCropRect.bottom, frameCropRect.right - r1, r3 - frameCropRect.top));
            cGSize = image.getSize();
        } else {
            if (isTAVClip(trackImagePair.getTrack())) {
                TAVVideoConfiguration.TAVVideoConfigurationContentMode tAVVideoConfigurationContentMode = TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill;
                if (tAVVideoConfigurationContentMode.equals(getContentMode(trackImagePair.getTrack()))) {
                    CIImage m267clone2 = trackImagePair.getImage().m267clone();
                    m267clone2.applyFillInFrame(new CGRect(new PointF(), cGSize), tAVVideoConfigurationContentMode);
                    image = m267clone2;
                }
            }
            image = trackImagePair.getImage();
            cGSize = image.getSize();
        }
        return new Pair<>(image, cGSize);
    }

    public TextureInfo getCachedTexture(CIImage cIImage, CGSize cGSize, RenderInfo renderInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (TextureInfo) iPatchRedirector.redirect((short) 7, this, cIImage, cGSize, renderInfo);
        }
        int i3 = (int) cGSize.width;
        int i16 = (int) cGSize.height;
        String str = i3 + "_" + i16;
        Integer num = this.sizeKeys.get(str);
        if (num == null) {
            this.sizeKeys.put(str, 1);
        } else {
            this.sizeKeys.put(str, Integer.valueOf(num.intValue() + 1));
        }
        String str2 = str + "_" + this.sizeKeys.get(str);
        TextureInfo textureInfo = this.textureMap.get(str2);
        if (textureInfo == null) {
            this.renderContext.makeCurrent();
            textureInfo = CIContext.newTextureInfo(i3, i16);
            this.textureMap.put(str2, textureInfo);
        }
        renderInfo.getCiContext().convertImageToTexture(cIImage, textureInfo);
        return textureInfo;
    }

    public TAVVideoConfiguration.TAVVideoConfigurationContentMode getContentMode(TAVVideoCompositionTrack tAVVideoCompositionTrack) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (TAVVideoConfiguration.TAVVideoConfigurationContentMode) iPatchRedirector.redirect((short) 10, (Object) this, (Object) tAVVideoCompositionTrack);
        }
        return ((TAVClip) tAVVideoCompositionTrack).getVideoConfiguration().getContentMode();
    }

    public Rect getFrameCropRect(TAVVideoCompositionTrack tAVVideoCompositionTrack, CGSize cGSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Rect) iPatchRedirector.redirect((short) 12, (Object) this, (Object) tAVVideoCompositionTrack, (Object) cGSize);
        }
        if (isTAVClip(tAVVideoCompositionTrack) && tAVVideoCompositionTrack.getExtraTrackInfo(ExtraData.EXTRA_FRAME_INFO) != null) {
            return transform((FrameInfo) tAVVideoCompositionTrack.getExtraTrackInfo(ExtraData.EXTRA_FRAME_INFO), cGSize);
        }
        return null;
    }

    public int getPAGLayerIndex(ImageCollection.TrackImagePair trackImagePair) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, (Object) trackImagePair)).intValue();
        }
        if (trackImagePair == null || trackImagePair.getTrack() == null) {
            return -1;
        }
        Object extraTrackInfo = trackImagePair.getTrack().getExtraTrackInfo(TAVMovieConfig.PAG_LAYER_INDEX_KEY);
        if (!(extraTrackInfo instanceof String)) {
            return -1;
        }
        return Integer.parseInt((String) extraTrackInfo);
    }

    public int getTrackIndex(ImageCollection.TrackImagePair trackImagePair) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, (Object) trackImagePair)).intValue();
        }
        if (trackImagePair != null && trackImagePair.getTrack() != null && (trackImagePair.getTrack().getExtraTrackInfo(TAVOneClickFilmStickerEffect.TRACK_INDEX) instanceof Integer)) {
            return ((Integer) trackImagePair.getTrack().getExtraTrackInfo(TAVOneClickFilmStickerEffect.TRACK_INDEX)).intValue();
        }
        return 0;
    }

    public boolean isTAVClip(TAVVideoCompositionTrack tAVVideoCompositionTrack) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) tAVVideoCompositionTrack)).booleanValue();
        }
        return tAVVideoCompositionTrack instanceof TAVClip;
    }

    @Override // com.tencent.tavkit.composition.video.Releasable
    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        RenderContext renderContext = this.renderContext;
        if (renderContext != null) {
            renderContext.makeCurrent();
        }
        HashMap<String, TextureInfo> hashMap = this.textureMap;
        if (hashMap != null) {
            Iterator<TextureInfo> it = hashMap.values().iterator();
            while (it.hasNext()) {
                it.next().release();
            }
            this.textureMap.clear();
        }
        HashMap<String, Integer> hashMap2 = this.sizeKeys;
        if (hashMap2 != null) {
            hashMap2.clear();
        }
    }

    public void removeRedundantImage(List<ImageCollection.TrackImagePair> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
            return;
        }
        if (list.size() > 1) {
            Iterator<ImageCollection.TrackImagePair> it = list.iterator();
            while (it.hasNext()) {
                ImageCollection.TrackImagePair next = it.next();
                if (next != null && next.getTrack() != null && next.getTrack().getExtraTrackInfo(TAVOneClickFilmStickerEffect.TRACK_INDEX) == null && next.getTrack().getExtraTrackInfo(TAVMovieConfig.PAG_LAYER_INDEX_KEY) == null) {
                    it.remove();
                }
            }
        }
    }

    public void sortTrackImages(List<ImageCollection.TrackImagePair> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) list);
        } else {
            if (CollectionUtil.isEmptyList(list)) {
                return;
            }
            Collections.sort(list, new Comparator<ImageCollection.TrackImagePair>() { // from class: com.tencent.autotemplate.filter.TAVBaseMixFilter.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TAVBaseMixFilter.this);
                    }
                }

                @Override // java.util.Comparator
                public int compare(ImageCollection.TrackImagePair trackImagePair, ImageCollection.TrackImagePair trackImagePair2) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? TAVBaseMixFilter.this.getTrackIndex(trackImagePair) - TAVBaseMixFilter.this.getTrackIndex(trackImagePair2) : ((Integer) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) trackImagePair, (Object) trackImagePair2)).intValue();
                }
            });
        }
    }
}
