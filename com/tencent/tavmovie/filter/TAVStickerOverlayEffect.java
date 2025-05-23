package com.tencent.tavmovie.filter;

import android.support.annotation.NonNull;
import android.util.Log;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.report.IReportable;
import com.tencent.tavkit.report.MemoryReportHelper;
import com.tencent.tavsticker.core.TAVStickerRenderContext;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVStickerOverlayEffect implements TAVVideoEffect {
    private static final String TAG = "TAVStickerOverlayEffect";
    protected boolean realTimeReleaseEachSticker;
    protected boolean realTimeReleaseStickerContext;
    protected TAVStickerRenderContext stickerContext;

    @Nullable
    protected List<TAVSticker> stickers;
    protected int count = 0;
    protected String reportKey = TAG;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    private class MyVideoCompositionEffect implements TAVVideoEffect.Filter, IReportable {

        @Nullable
        private TAVStickerRenderContext cloneStickerContext;
        private CMTime currentTime;

        @Nullable
        private TAVStickerRenderContext stickerContext;

        private CIImage applyEffectHard(@NonNull TAVStickerRenderContext tAVStickerRenderContext, CIImage cIImage, CMTime cMTime, CIContext cIContext) {
            boolean z16;
            List<TAVSticker> list = TAVStickerOverlayEffect.this.stickers;
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (TAVSticker tAVSticker : TAVStickerOverlayEffect.this.stickers) {
                    if (tAVSticker.getTimeRange().containsTime(cMTime)) {
                        arrayList.add(tAVSticker);
                    }
                }
                if (arrayList.isEmpty()) {
                    Log.d(TAVStickerOverlayEffect.TAG, "applyEffectHard: renderStickers.isEmpty()");
                    releaseCloneRenderContext();
                }
                if (TAVStickerOverlayEffect.this.realTimeReleaseEachSticker && this.cloneStickerContext != null && arrayList.size() < this.cloneStickerContext.getStickerCount()) {
                    Log.d(TAVStickerOverlayEffect.TAG, "applyEffectHard: renderStickers.size() = " + arrayList.size() + ", cloneStickerContext.getStickerCount() = " + this.cloneStickerContext.getStickerCount());
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
                if (z16 && TAVStickerOverlayEffect.this.realTimeReleaseEachSticker) {
                    releaseCloneRenderContext();
                }
                renderByCloneContext(tAVStickerRenderContext, arrayList, cIImage, cMTime, cIContext);
            }
            return cIImage;
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
            CIContext ciContext = renderInfo.getCiContext();
            if (this.stickerContext == null) {
                return cIImage;
            }
            this.currentTime = renderInfo.getTime();
            if (TAVStickerOverlayEffect.this.realTimeReleaseStickerContext) {
                return applyEffectHard(this.stickerContext, cIImage, renderInfo.getTime(), ciContext);
            }
            this.stickerContext.setRenderSize(cIImage.getSize());
            CMSampleBuffer renderSticker = this.stickerContext.renderSticker(renderInfo.getTime().getTimeUs() / 1000, null, ciContext.getRenderContext().eglContext());
            ciContext.getRenderContext().makeCurrent();
            if (noStickerRender(renderInfo.getTime(), this.stickerContext.getStickers())) {
                return cIImage;
            }
            if (renderSticker != null) {
                if (renderSticker.isNewFrame()) {
                    this.stickerContext.getStickerTexture().awaitNewImage(1000L);
                }
                TextureInfo textureInfo = renderSticker.getTextureInfo();
                textureInfo.setMixAlpha(false);
                new CIImage(textureInfo).imageByCompositingOverImage(cIImage);
            }
            return cIImage;
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
                return TAVStickerOverlayEffect.this.reportKey + ":[" + MemoryReportHelper.appendKeys(arrayList) + "]";
            }
            return null;
        }

        @Override // com.tencent.tavkit.composition.video.Releasable
        public void release() {
            releaseCloneRenderContext();
            TAVStickerRenderContext tAVStickerRenderContext = this.stickerContext;
            if (tAVStickerRenderContext != null && TAVStickerOverlayEffect.this.stickerContext != tAVStickerRenderContext) {
                tAVStickerRenderContext.release();
                this.stickerContext = null;
            }
        }

        MyVideoCompositionEffect(@NotNull TAVStickerRenderContext tAVStickerRenderContext) {
            this.currentTime = CMTime.CMTimeZero;
            this.stickerContext = tAVStickerRenderContext;
        }
    }

    public TAVStickerOverlayEffect(TAVStickerRenderContext tAVStickerRenderContext) {
        this.stickerContext = tAVStickerRenderContext;
    }

    @Override // com.tencent.tavkit.composition.video.TAVVideoEffect
    public TAVVideoEffect.Filter createFilter() {
        int i3 = this.count;
        if (i3 == 0) {
            this.count = i3 + 1;
            return new MyVideoCompositionEffect(this.stickerContext);
        }
        return new MyVideoCompositionEffect(this.stickerContext.copy());
    }

    @Override // com.tencent.tavkit.composition.video.TAVVideoEffect
    @NonNull
    /* renamed from: effectId */
    public String getMEffectId() {
        return TAG;
    }

    public TAVStickerRenderContext getStickerContext() {
        return this.stickerContext;
    }

    public void setReportKey(String str) {
        this.reportKey = str;
    }

    public void setStickers(List<TAVSticker> list, boolean z16, boolean z17) {
        this.stickers = list;
        this.realTimeReleaseStickerContext = z16;
        this.realTimeReleaseEachSticker = z17;
    }
}
