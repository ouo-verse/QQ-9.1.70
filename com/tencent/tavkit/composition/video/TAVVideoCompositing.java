package com.tencent.tavkit.composition.video;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.tav.core.compositing.AsynchronousVideoCompositionRequest;
import com.tencent.tav.core.compositing.IVideoCompositionInstruction;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.core.compositing.VideoCompositionRenderContext;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.ErrorMsg;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.ciimage.ThreadLocalTextureCache;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration;
import com.tencent.tavkit.composition.video.TAVAttachTimeRangeSourceEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import com.tencent.tavkit.composition.video.TAVVideoTransition;
import com.tencent.tavkit.report.CompositingReportSession;
import com.tencent.tavkit.report.MemoryReportHelper;
import com.tencent.tavkit.report.TAVAutoTestHelper;
import com.tencent.tavkit.utils.BenchUtil;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVVideoCompositing implements VideoCompositing {
    public static boolean LOG_EMPTY_IMAGE_WARNING = false;

    @Nullable
    private CIContext ciContext;

    @Nullable
    private Thread renderThread;

    @Nullable
    private CompositingReportSession reportSession;
    private final String mTAG = "TAVVideoCompositing@" + Integer.toHexString(hashCode());
    private final HashMap<String, TAVVideoTransition.Filter> transitionFilterMap = new HashMap<>();
    private final HashMap<String, TAVVideoEffect.Filter> sourceFilterMap = new HashMap<>();
    private final HashMap<String, TAVVideoMixEffect.Filter> mixFilterMap = new HashMap<>();
    private final HashMap<String, TAVVideoEffect.Filter> globalFilterMap = new HashMap<>();
    private final TAVVideoMixEffect.Filter defaultVideoMixFilter = new DefaultVideoMixFilter();
    private boolean tryPostReleaseDone = false;

    private CIImage applyClipSourceEffect(RenderInfo renderInfo, @NonNull CIImage cIImage, List<TAVVideoEffect> list) {
        if (list != null && !list.isEmpty()) {
            for (TAVVideoEffect tAVVideoEffect : list) {
                TAVVideoEffect.Filter sourceFilter = getSourceFilter(tAVVideoEffect, renderInfo);
                if (sourceFilter != null) {
                    cIImage = sourceFilter.apply(tAVVideoEffect, cIImage, renderInfo);
                }
            }
        }
        return cIImage;
    }

    private CIImage applyCompositionSourceEffect(RenderInfo renderInfo, CIImage cIImage, TAVVideoEffect tAVVideoEffect) {
        TAVVideoEffect.Filter sourceFilter = getSourceFilter(tAVVideoEffect, renderInfo);
        if (sourceFilter == null) {
            return cIImage;
        }
        return sourceFilter.apply(tAVVideoEffect, cIImage, renderInfo);
    }

    private void applySourceTransform(TAVVideoConfiguration tAVVideoConfiguration, CIImage cIImage, RenderInfo renderInfo) {
        Logger.v(this.mTAG, "applySourceTransform() called with: config = [" + tAVVideoConfiguration + "]");
        if (tAVVideoConfiguration.frameEnable()) {
            cIImage.imageApplyFillInFrame(tAVVideoConfiguration.getFrame(), tAVVideoConfiguration.getContentMode());
        } else if (tAVVideoConfiguration.getFrame() == TAVVideoConfiguration.FIX_RENDER_SIZE) {
            cIImage.applyFixInSize(renderInfo.getRenderSize(), tAVVideoConfiguration.getContentMode());
        }
        cIImage.safeApplyTransform(tAVVideoConfiguration.getTransform());
    }

    private void attachTimeToSourceFilters(AsynchronousVideoCompositionRequest asynchronousVideoCompositionRequest) {
        for (TAVVideoEffect.Filter filter : this.sourceFilterMap.values()) {
            if (filter instanceof TAVAttachTimeRangeSourceEffect.TimeAttachFilter) {
                ((TAVAttachTimeRangeSourceEffect.TimeAttachFilter) filter).attachPositionTime(asynchronousVideoCompositionRequest.getCompositionTime());
            }
        }
    }

    private CIImage compositingImages(AsynchronousVideoCompositionRequest asynchronousVideoCompositionRequest, TAVVideoCompositionInstruction tAVVideoCompositionInstruction) {
        CIImage cIImage;
        if (this.ciContext == null) {
            return null;
        }
        attachTimeToSourceFilters(asynchronousVideoCompositionRequest);
        RenderInfo renderInfo = new RenderInfo(asynchronousVideoCompositionRequest.getCompositionTime(), asynchronousVideoCompositionRequest.getRenderContext().getSize(), this.ciContext);
        ImageCollection convertToImageCollection = convertToImageCollection(asynchronousVideoCompositionRequest, renderInfo, tAVVideoCompositionInstruction);
        TAVVideoMixEffect.Filter videoMixFilter = getVideoMixFilter(tAVVideoCompositionInstruction, tAVVideoCompositionInstruction.getVideoMixEffect());
        if (videoMixFilter != null) {
            cIImage = videoMixFilter.apply(tAVVideoCompositionInstruction.getVideoMixEffect(), convertToImageCollection, renderInfo);
        } else {
            cIImage = null;
        }
        if (cIImage == null) {
            cIImage = this.defaultVideoMixFilter.apply(null, convertToImageCollection, renderInfo);
        }
        if (cIImage == null) {
            return null;
        }
        TAVVideoEffect.Filter globalFilter = getGlobalFilter(tAVVideoCompositionInstruction.getGlobalVideoEffect(), renderInfo);
        if (globalFilter != null) {
            return globalFilter.apply(tAVVideoCompositionInstruction.getGlobalVideoEffect(), cIImage, renderInfo);
        }
        return cIImage;
    }

    @Nullable
    private CIImage convertLayerToImage(AsynchronousVideoCompositionRequest asynchronousVideoCompositionRequest, RenderInfo renderInfo, TAVVideoCompositionLayerInstruction tAVVideoCompositionLayerInstruction, TAVVideoEffect tAVVideoEffect) {
        if (!tAVVideoCompositionLayerInstruction.getTimeRange().containsTime(renderInfo.getTime())) {
            return null;
        }
        CIImage sourceImageAtTime = tAVVideoCompositionLayerInstruction.getImageSource().sourceImageAtTime(renderInfo.getTime().sub(tAVVideoCompositionLayerInstruction.getTimeRange().getStart()), renderInfo.getRenderSize());
        if (sourceImageAtTime == null) {
            sourceImageAtTime = getImageWithRequest(asynchronousVideoCompositionRequest, tAVVideoCompositionLayerInstruction);
        }
        if (sourceImageAtTime == null) {
            return null;
        }
        renderInfo.addTrack(tAVVideoCompositionLayerInstruction.getImageSource());
        sourceImageAtTime.applyPreferRotation(tAVVideoCompositionLayerInstruction.getVideoConfiguration().getPreferRotation());
        applySourceTransform(tAVVideoCompositionLayerInstruction.getVideoConfiguration(), sourceImageAtTime, renderInfo);
        CIImage applyCompositionSourceEffect = applyCompositionSourceEffect(renderInfo, applyClipSourceEffect(renderInfo, sourceImageAtTime, tAVVideoCompositionLayerInstruction.getVideoConfiguration().getEffects()), tAVVideoEffect);
        Logger.v(this.mTAG, "convertLayerToImage: end, returned: " + applyCompositionSourceEffect);
        return applyCompositionSourceEffect;
    }

    @NonNull
    private ImageCollection convertToImageCollection(AsynchronousVideoCompositionRequest asynchronousVideoCompositionRequest, RenderInfo renderInfo, TAVVideoCompositionInstruction tAVVideoCompositionInstruction) {
        ImageCollection imageCollection = new ImageCollection();
        Iterator<List<TAVVideoCompositionLayerInstruction>> it = tAVVideoCompositionInstruction.getChannelLayers().iterator();
        while (it.hasNext()) {
            for (TAVVideoCompositionLayerInstruction tAVVideoCompositionLayerInstruction : it.next()) {
                CIImage convertLayerToImage = convertLayerToImage(asynchronousVideoCompositionRequest, renderInfo, tAVVideoCompositionLayerInstruction, tAVVideoCompositionInstruction.getSourceVideoEffect());
                if (convertLayerToImage != null) {
                    imageCollection.addChannelImage(convertLayerToImage, tAVVideoCompositionLayerInstruction.getImageSource());
                }
            }
        }
        for (TAVVideoCompositionLayerInstruction tAVVideoCompositionLayerInstruction2 : tAVVideoCompositionInstruction.getOverlayLayers()) {
            CIImage convertLayerToImage2 = convertLayerToImage(asynchronousVideoCompositionRequest, renderInfo, tAVVideoCompositionLayerInstruction2, tAVVideoCompositionInstruction.getSourceVideoEffect());
            if (convertLayerToImage2 != null) {
                imageCollection.addOverlayImage(convertLayerToImage2, tAVVideoCompositionLayerInstruction2.getImageSource());
            }
        }
        Logger.v(this.mTAG, "convertToImageCollection: result imageCollection = " + imageCollection);
        return imageCollection;
    }

    private TAVVideoEffect.Filter createFilter(TAVVideoEffect tAVVideoEffect, RenderInfo renderInfo) {
        if (tAVVideoEffect instanceof BaseVideoEffect) {
            return ((BaseVideoEffect) tAVVideoEffect).createFilter(renderInfo);
        }
        return tAVVideoEffect.createFilter();
    }

    @Nullable
    private TAVVideoEffect.Filter getGlobalFilter(TAVVideoEffect tAVVideoEffect, RenderInfo renderInfo) {
        if (tAVVideoEffect != null && !TextUtils.isEmpty(tAVVideoEffect.getMEffectId())) {
            String mEffectId = tAVVideoEffect.getMEffectId();
            if (this.globalFilterMap.containsKey(mEffectId)) {
                return this.globalFilterMap.get(mEffectId);
            }
            TAVVideoEffect.Filter createFilter = createFilter(tAVVideoEffect, renderInfo);
            this.globalFilterMap.put(mEffectId, createFilter);
            return createFilter;
        }
        return null;
    }

    @Nullable
    private CIImage getImageWithRequest(AsynchronousVideoCompositionRequest asynchronousVideoCompositionRequest, TAVVideoCompositionLayerInstruction tAVVideoCompositionLayerInstruction) {
        CMSampleBuffer sourceFrameByTrackID = asynchronousVideoCompositionRequest.sourceFrameByTrackID(tAVVideoCompositionLayerInstruction.getTrackID());
        if (sourceFrameByTrackID != null && sourceFrameByTrackID.getTextureInfo() != null) {
            return new CIImage(sourceFrameByTrackID.getTextureInfo());
        }
        return null;
    }

    @Nullable
    private TAVVideoEffect.Filter getSourceFilter(TAVVideoEffect tAVVideoEffect, RenderInfo renderInfo) {
        if (tAVVideoEffect != null && !TextUtils.isEmpty(tAVVideoEffect.getMEffectId())) {
            String mEffectId = tAVVideoEffect.getMEffectId();
            if (this.sourceFilterMap.containsKey(mEffectId)) {
                return this.sourceFilterMap.get(mEffectId);
            }
            TAVVideoEffect.Filter createFilter = createFilter(tAVVideoEffect, renderInfo);
            this.sourceFilterMap.put(mEffectId, createFilter);
            return createFilter;
        }
        return null;
    }

    @Nullable
    private TAVVideoMixEffect.Filter getVideoMixFilter(TAVVideoCompositionInstruction tAVVideoCompositionInstruction, TAVVideoMixEffect tAVVideoMixEffect) {
        if (tAVVideoMixEffect != null && !TextUtils.isEmpty(tAVVideoMixEffect.effectId())) {
            String effectId = tAVVideoMixEffect.effectId();
            if (this.mixFilterMap.containsKey(effectId)) {
                return this.mixFilterMap.get(effectId);
            }
            TAVVideoMixEffect.Filter createFilter = tAVVideoCompositionInstruction.getVideoMixEffect().createFilter();
            this.mixFilterMap.put(effectId, createFilter);
            return createFilter;
        }
        return null;
    }

    private void reportMemory() {
        if (MemoryReportHelper.isInIntervalTime()) {
            return;
        }
        MemoryReportHelper.getInstance().tick("sourceFilter:[" + MemoryReportHelper.appendReportKey(this.sourceFilterMap.values()) + "], mixFilter:[" + MemoryReportHelper.appendReportKey(this.mixFilterMap.values()) + "], globalFilter:[" + MemoryReportHelper.appendReportKey(this.globalFilterMap.values()) + "]");
    }

    private void tryPostReleaseToRenderThread() {
        if (this.tryPostReleaseDone) {
            return;
        }
        this.tryPostReleaseDone = true;
        Thread thread = this.renderThread;
        if ((thread instanceof HandlerThread) && ((HandlerThread) thread).getLooper() != null) {
            new Handler(((HandlerThread) this.renderThread).getLooper()).post(new Runnable() { // from class: com.tencent.tavkit.composition.video.TAVVideoCompositing.1
                @Override // java.lang.Runnable
                public void run() {
                    TAVVideoCompositing.this.release();
                }
            });
        }
    }

    @Override // com.tencent.tav.core.compositing.VideoCompositing
    public void release() {
        if (this.renderThread != null && !Thread.currentThread().equals(this.renderThread)) {
            Logger.e(this.mTAG, "release: \u5f53\u524d\u7ebf\u7a0b\u975e\u6e32\u67d3\u7ebf\u7a0b\uff01currentThread = " + Thread.currentThread().getName() + ", renderThread = " + this.renderThread.getName());
            tryPostReleaseToRenderThread();
            return;
        }
        this.tryPostReleaseDone = false;
        Logger.d(this.mTAG, "release: begin, currentThread = " + Thread.currentThread().getName());
        release(this.ciContext);
        release(this.transitionFilterMap.values());
        release(this.sourceFilterMap.values());
        release(this.mixFilterMap.values());
        release(this.globalFilterMap.values());
        this.transitionFilterMap.clear();
        this.sourceFilterMap.clear();
        this.mixFilterMap.clear();
        this.globalFilterMap.clear();
        release(ThreadLocalTextureCache.getInstance());
        CompositingReportSession compositingReportSession = this.reportSession;
        if (compositingReportSession != null) {
            compositingReportSession.flush();
            this.reportSession = null;
        }
        Logger.d(this.mTAG, "release: end, currentThread = " + Thread.currentThread().getName());
    }

    @Override // com.tencent.tav.core.compositing.VideoCompositing
    public HashMap<String, Object> requiredPixelBufferAttributesForRenderContext() {
        return null;
    }

    @Override // com.tencent.tav.core.compositing.VideoCompositing
    public HashMap<String, Object> sourcePixelBufferAttributes() {
        return null;
    }

    @Override // com.tencent.tav.core.compositing.VideoCompositing
    public void startVideoCompositionRequest(AsynchronousVideoCompositionRequest asynchronousVideoCompositionRequest) {
        if (this.reportSession == null) {
            CGSize size = asynchronousVideoCompositionRequest.getRenderContext().getSize();
            this.reportSession = new CompositingReportSession(size.width, size.height);
        }
        long nanoTime = System.nanoTime();
        if (this.ciContext == null) {
            this.ciContext = new CIContext(asynchronousVideoCompositionRequest.getRenderContext().getRenderContext());
        }
        if (this.renderThread == null) {
            this.renderThread = Thread.currentThread();
        }
        IVideoCompositionInstruction videoCompositionInstruction = asynchronousVideoCompositionRequest.getVideoCompositionInstruction();
        if (!(videoCompositionInstruction instanceof TAVVideoCompositionInstruction)) {
            Logger.e(this.mTAG, "startVideoCompositionRequest: end, instruction not instanceof TAVVideoCompositionInstruction");
            this.reportSession.tickFailed();
            asynchronousVideoCompositionRequest.finishWithError(new ErrorMsg(10086, "instruction not instanceof TAVVideoCompositionInstruction"));
            return;
        }
        BenchUtil.benchStart("compositingImages");
        CIImage compositingImages = compositingImages(asynchronousVideoCompositionRequest, (TAVVideoCompositionInstruction) videoCompositionInstruction);
        BenchUtil.benchEnd("compositingImages");
        BenchUtil.benchStart("renderToSampleBuffer");
        reportMemory();
        if (compositingImages != null) {
            CMSampleBuffer convertToSampleBuffer = this.ciContext.convertToSampleBuffer(compositingImages, asynchronousVideoCompositionRequest.getCompositionTime(), asynchronousVideoCompositionRequest.getRenderContext().getRenderContext());
            Logger.v(this.mTAG, "startVideoCompositionRequest: end, resultPixels = [" + convertToSampleBuffer + "]");
            this.reportSession.tickSuccess(System.nanoTime() - nanoTime);
            TAVAutoTestHelper.onRender(convertToSampleBuffer);
            asynchronousVideoCompositionRequest.finishWithComposedVideoFrame(convertToSampleBuffer);
        } else {
            Logger.e(this.mTAG, "startVideoCompositionRequest: end, destImage is null ");
            this.reportSession.tickFailed();
            asynchronousVideoCompositionRequest.finishWithError(new ErrorMsg(10086, "destImage is null "));
        }
        BenchUtil.benchEnd("renderToSampleBuffer");
    }

    @Override // com.tencent.tav.core.compositing.VideoCompositing
    public void cancelAllPendingVideoCompositionRequests() {
    }

    private void release(Collection<? extends Releasable> collection) {
        Iterator<? extends Releasable> it = collection.iterator();
        while (it.hasNext()) {
            release(it.next());
        }
    }

    @Override // com.tencent.tav.core.compositing.VideoCompositing
    public void renderContextChanged(VideoCompositionRenderContext videoCompositionRenderContext) {
    }

    private void release(Releasable releasable) {
        if (releasable != null) {
            releasable.release();
        }
    }
}
