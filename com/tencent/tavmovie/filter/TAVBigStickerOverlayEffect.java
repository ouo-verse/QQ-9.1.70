package com.tencent.tavmovie.filter;

import android.util.Log;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.ImageCollection;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import com.tencent.tavkit.report.IReportable;
import com.tencent.tavmovie.TAVMovieConfig;
import com.tencent.tavsticker.core.TAVStickerRenderContext;
import com.tencent.tavsticker.log.TLog;
import com.tencent.tavsticker.model.TAVSourceImage;
import com.tencent.tavsticker.model.TAVSticker;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVBigStickerOverlayEffect implements TAVVideoMixEffect {
    private static final String TAG = "TAVBigStickerOverlayEffect";
    private int count = 0;
    protected String reportKey = TAG;
    private TAVStickerRenderContext stickerContext;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    private class StickerVideoCompositionMixerEffect implements TAVVideoMixEffect.Filter, IReportable {
        private CMTime currentTime;
        private RenderContext renderContext;
        private HashMap<String, Integer> sizeKeys;
        private TAVStickerRenderContext stickerContext;
        private HashMap<String, TextureInfo> textureMap;

        @Override // com.tencent.tavkit.composition.video.TAVVideoMixEffect.Filter
        public CIImage apply(TAVVideoMixEffect tAVVideoMixEffect, ImageCollection imageCollection, RenderInfo renderInfo) {
            int i3;
            List<ImageCollection.TrackImagePair> videoChannelImages = imageCollection.getVideoChannelImages();
            this.stickerContext.setRenderSize(renderInfo.getRenderSize());
            ArrayList arrayList = new ArrayList();
            this.currentTime = renderInfo.getTime();
            this.renderContext = renderInfo.getCiContext().getRenderContext();
            this.sizeKeys.clear();
            if (videoChannelImages != null && !videoChannelImages.isEmpty()) {
                for (int i16 = 0; i16 < videoChannelImages.size(); i16++) {
                    ImageCollection.TrackImagePair trackImagePair = videoChannelImages.get(i16);
                    if (trackImagePair != null && trackImagePair.getImage() != null) {
                        Object extraTrackInfo = trackImagePair.getTrack().getExtraTrackInfo(TAVMovieConfig.PAG_LAYER_INDEX_KEY);
                        if (extraTrackInfo instanceof String) {
                            i3 = Integer.parseInt((String) extraTrackInfo);
                        } else {
                            i3 = -1;
                        }
                        if (i3 != -1) {
                            CIImage image = trackImagePair.getImage();
                            int i17 = (int) image.getSize().width;
                            int i18 = (int) image.getSize().height;
                            String str = i17 + "_" + i18;
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
                                textureInfo = CIContext.newTextureInfo(i17, i18);
                                this.textureMap.put(str2, textureInfo);
                            }
                            renderInfo.getCiContext().convertImageToTexture(image, textureInfo);
                            TLog.d(TAVBigStickerOverlayEffect.TAG, "PAGImage::layerIndex: " + i3 + ", renderSize: " + textureInfo.width + ", " + textureInfo.height + ", textureID: " + textureInfo.textureID + ", textureKey: " + str2 + ", context: " + this.renderContext.eglContext());
                            arrayList.add(new TAVSourceImage(textureInfo, true, i3));
                        }
                    }
                }
            }
            CMSampleBuffer renderSticker = this.stickerContext.renderSticker(renderInfo.getTime().getTimeUs() / 1000, arrayList, this.renderContext.eglContext());
            this.renderContext.makeCurrent();
            if (renderSticker != null) {
                try {
                    if (renderSticker.isNewFrame()) {
                        this.stickerContext.getStickerTexture().awaitNewImage(1000L);
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                return new CIImage(renderSticker.getTextureInfo());
            }
            return null;
        }

        @Override // com.tencent.tavkit.report.IReportable
        public String getReportKey() {
            TAVStickerRenderContext tAVStickerRenderContext = this.stickerContext;
            if (tAVStickerRenderContext != null) {
                synchronized (tAVStickerRenderContext.getStickers()) {
                    for (TAVSticker tAVSticker : this.stickerContext.getStickers()) {
                        if (tAVSticker != null && tAVSticker.getTimeRange() != null && tAVSticker.getTimeRange().containsTime(this.currentTime)) {
                            return TAVBigStickerOverlayEffect.this.reportKey;
                        }
                    }
                    return null;
                }
            }
            return null;
        }

        @Override // com.tencent.tavkit.composition.video.Releasable
        public void release() {
            RenderContext renderContext = this.renderContext;
            if (renderContext != null) {
                renderContext.makeCurrent();
            }
            TAVStickerRenderContext tAVStickerRenderContext = this.stickerContext;
            if (tAVStickerRenderContext != null) {
                tAVStickerRenderContext.release();
                this.stickerContext = null;
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
            TLog.d(TAVBigStickerOverlayEffect.TAG, "release cache." + Log.getStackTraceString(new RuntimeException()));
        }

        StickerVideoCompositionMixerEffect(TAVStickerRenderContext tAVStickerRenderContext) {
            this.sizeKeys = new HashMap<>();
            this.textureMap = new HashMap<>();
            this.currentTime = CMTime.CMTimeZero;
            this.stickerContext = tAVStickerRenderContext;
        }
    }

    public TAVBigStickerOverlayEffect(TAVStickerRenderContext tAVStickerRenderContext) {
        this.stickerContext = tAVStickerRenderContext;
    }

    @Override // com.tencent.tavkit.composition.video.TAVVideoMixEffect
    public TAVVideoMixEffect.Filter createFilter() {
        int i3 = this.count;
        if (i3 == 0) {
            this.count = i3 + 1;
            return new StickerVideoCompositionMixerEffect(this.stickerContext);
        }
        return new StickerVideoCompositionMixerEffect(this.stickerContext.copy());
    }

    @Override // com.tencent.tavkit.composition.video.TAVVideoMixEffect
    public String effectId() {
        return TAG;
    }

    public TAVStickerRenderContext getStickerContext() {
        return this.stickerContext;
    }

    public void setReportKey(String str) {
        this.reportKey = str;
    }
}
