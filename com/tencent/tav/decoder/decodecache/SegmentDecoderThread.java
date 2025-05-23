package com.tencent.tav.decoder.decodecache;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.ITexturePool;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.TexturePool;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes26.dex */
public class SegmentDecoderThread implements Handler.Callback {
    private static final int MSG_DECODER_FRAME = 3;
    private static final int MSG_DECODER_SEGMENT = 2;
    private static final int MSG_QUIT = 1000;
    private static final int MSG_START = 1;
    private static final String TAG = "SegmentDecoderThread";
    private CachedVideoDecoderTrack cachedVideoDecoderTrack;
    RenderContext context;
    private Handler decoderHandler;
    private HandlerThread decoderThread;
    IDecoderTrack decoderTrack;
    private CopyFilter filter;
    CMSampleBuffer seekSampleBuffer;
    boolean cancel = false;
    private volatile boolean started = false;
    ITexturePool texturePool = new TexturePool();

    /* JADX INFO: Access modifiers changed from: package-private */
    public SegmentDecoderThread(CachedVideoDecoderTrack cachedVideoDecoderTrack, IDecoderTrack iDecoderTrack) {
        this.cachedVideoDecoderTrack = cachedVideoDecoderTrack;
        this.decoderTrack = iDecoderTrack;
    }

    private void decoder(DecoderSegmentMsg decoderSegmentMsg) {
        RenderContext renderContext;
        synchronized (this.cachedVideoDecoderTrack.nextFrameDecoderLock) {
            this.cancel = false;
            CacheSegment cacheSegment = decoderSegmentMsg.segment;
            Logger.d(TAG, "decoder:------------------- " + decoderSegmentMsg.segment.segmentTimeRange.getStart() + "  -  " + decoderSegmentMsg.segment.segmentTimeRange.getEnd());
            CMTime start = cacheSegment.segmentTimeRange.getStart();
            CMTime end = cacheSegment.segmentTimeRange.getEnd();
            CMTime duration = cacheSegment.segmentTimeRange.getDuration();
            if (end.bigThan(this.decoderTrack.getDuration())) {
                end = this.decoderTrack.getDuration();
                duration = end.sub(start);
            }
            CMTimeRange cMTimeRange = new CMTimeRange(start, cacheSegment.segmentTimeRange.getDuration());
            if (this.cachedVideoDecoderTrack.revert) {
                CMTime sub = this.decoderTrack.getDuration().sub(end);
                CMTime cMTime = CMTime.CMTimeZero;
                if (sub.smallThan(cMTime)) {
                    sub = cMTime;
                }
                cMTimeRange = new CMTimeRange(sub, duration);
            }
            Logger.d(TAG, "decoder2:------------------- " + cMTimeRange.getStart() + "  -  " + cMTimeRange.getEnd());
            if (cMTimeRange.getStart() != CMTime.CMTimeInvalid && this.cachedVideoDecoderTrack != null && (renderContext = this.context) != null) {
                renderContext.makeCurrent();
                this.decoderTrack.seekTo(cMTimeRange.getStart(), false, false);
                CMSampleBuffer readSample = this.decoderTrack.readSample(cMTimeRange.getStart());
                Logger.d(TAG, "decoder: readFirst " + readSample.getTime() + " cancel = " + this.cancel + "  - " + cMTimeRange.getEnd());
                while (!readSample.getTime().smallThan(CMTime.CMTimeZero) && !this.cancel && readSample.getTime().smallThan(cMTimeRange.getEnd())) {
                    CacheFrame cacheFrame = new CacheFrame();
                    cacheFrame.texturePool = this.texturePool;
                    cacheFrame.frameTime = readSample.getTime();
                    Logger.d(TAG, "decoder:==================== frame.frameTime = " + cacheFrame.frameTime + "  " + readSample.getTextureInfo());
                    if (this.cachedVideoDecoderTrack.revert) {
                        cacheFrame.frameTime = this.decoderTrack.getDuration().sub(readSample.getTime());
                    }
                    cacheFrame.realFrameTime = readSample.getTime();
                    if (readSample.getTextureInfo() != null) {
                        RenderContext renderContext2 = this.context;
                        this.filter.setRenderForScreen(false);
                        this.filter.setRendererWidth(renderContext2.width());
                        this.filter.setRendererHeight(renderContext2.height());
                        renderContext2.makeCurrent();
                        TextureInfo popTexture = this.texturePool.popTexture(GLSLRender.GL_TEXTURE_2D, renderContext2.width(), renderContext2.height());
                        this.filter.setDesTextureInfo(popTexture);
                        Logger.d(TAG, "decoder:==================== " + readSample.getTime() + "  " + readSample.isNewFrame() + "  " + cacheFrame.frameTime);
                        this.filter.clearBufferBuffer(-16777216);
                        this.filter.applyFilter(readSample.getTextureInfo(), readSample.getTextureInfo().getTextureMatrix());
                        cacheFrame.sampleBuffer = new CMSampleBuffer(cacheFrame.frameTime, popTexture, readSample.isNewFrame());
                        cacheSegment.pushFrame(cacheFrame);
                    }
                    if (!cacheFrame.realFrameTime.add(this.cachedVideoDecoderTrack.getFrameDuration()).smallThan(cMTimeRange.getEnd())) {
                        break;
                    } else {
                        readSample = this.decoderTrack.readSample();
                    }
                }
            }
        }
        RequestStatus requestStatus = decoderSegmentMsg.callbackObject;
        if (requestStatus != null) {
            synchronized (requestStatus) {
                decoderSegmentMsg.callbackObject.setFinish(true);
                decoderSegmentMsg.callbackObject.notifyAll();
            }
        }
    }

    private void quit() {
        CMSampleBuffer cMSampleBuffer = this.seekSampleBuffer;
        if (cMSampleBuffer != null && cMSampleBuffer.getTextureInfo() != null) {
            this.seekSampleBuffer.getTextureInfo().release();
        }
        this.filter.release();
        this.decoderTrack.release();
        this.texturePool.release();
        this.context.release();
        this.decoderHandler.removeCallbacksAndMessages(null);
        this.decoderThread.quit();
    }

    private void start() {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("SegmentDecoder");
        this.decoderThread = baseHandlerThread;
        baseHandlerThread.start();
        this.decoderHandler = new Handler(this.decoderThread.getLooper(), this);
    }

    private void startDecoder() {
        RenderContext renderContext = new RenderContext(this.cachedVideoDecoderTrack.renderContext.width(), this.cachedVideoDecoderTrack.renderContext.height(), (Surface) null, this.cachedVideoDecoderTrack.renderContext.eglContext());
        this.context = renderContext;
        this.decoderTrack.start(renderContext, this.cachedVideoDecoderTrack.validTimeRange);
        this.started = true;
        this.context.makeCurrent();
        this.filter = new CopyFilter();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void decoderSegment(CacheSegment cacheSegment, RequestStatus requestStatus) {
        this.cancel = true;
        this.decoderHandler.removeCallbacksAndMessages(null);
        this.decoderHandler.obtainMessage(2, new DecoderSegmentMsg(cacheSegment, requestStatus)).sendToTarget();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 1000) {
                        quit();
                        return false;
                    }
                    return false;
                }
                decoder((DecoderFrameMsg) message.obj);
                return false;
            }
            decoder((DecoderSegmentMsg) message.obj);
            return false;
        }
        startDecoder();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void release() {
        this.cancel = true;
        if (this.decoderThread != null) {
            this.decoderHandler.removeCallbacksAndMessages(null);
            this.decoderHandler.sendEmptyMessage(1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startForReady() {
        start();
        this.decoderHandler.sendEmptyMessage(1);
        while (!this.started) {
            try {
                LockMethodProxy.sleep(1L);
            } catch (InterruptedException e16) {
                e16.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void decoderSegment(CMTime cMTime, CountDownLatch countDownLatch) {
        this.cancel = true;
        this.decoderHandler.removeCallbacksAndMessages(null);
        this.decoderHandler.obtainMessage(3, new DecoderFrameMsg(cMTime, countDownLatch)).sendToTarget();
    }

    private void decoder(DecoderFrameMsg decoderFrameMsg) {
        TextureInfo popTexture;
        CMTime cMTime = decoderFrameMsg.time;
        if (this.cachedVideoDecoderTrack.revert) {
            cMTime = this.decoderTrack.getDuration().sub(decoderFrameMsg.time);
        }
        RenderContext renderContext = this.context;
        if (renderContext != null) {
            renderContext.makeCurrent();
        }
        CMSampleBuffer seekTo = this.decoderTrack.seekTo(cMTime, true, false);
        if (seekTo.getTextureInfo() != null) {
            RenderContext renderContext2 = this.context;
            this.filter.setRenderForScreen(false);
            this.filter.setRendererWidth(renderContext2.width());
            this.filter.setRendererHeight(renderContext2.height());
            CMSampleBuffer cMSampleBuffer = this.seekSampleBuffer;
            if (cMSampleBuffer != null) {
                popTexture = cMSampleBuffer.getTextureInfo();
            } else {
                popTexture = this.texturePool.popTexture(GLSLRender.GL_TEXTURE_2D, renderContext2.width(), renderContext2.height());
            }
            this.filter.setDesTextureInfo(popTexture);
            Logger.d(TAG, "decoder:==========|=|========= " + seekTo.getTime() + "  " + seekTo.isNewFrame() + "  ");
            this.filter.clearBufferBuffer(-16777216);
            this.filter.applyFilter(seekTo.getTextureInfo(), seekTo.getTextureInfo().getTextureMatrix());
            CMTime time = seekTo.getTime();
            if (this.cachedVideoDecoderTrack.revert) {
                time = this.decoderTrack.getDuration().sub(time);
            }
            this.seekSampleBuffer = new CMSampleBuffer(time, popTexture, seekTo.isNewFrame());
        }
        CountDownLatch countDownLatch = decoderFrameMsg.finishWait;
        if (countDownLatch != null) {
            synchronized (countDownLatch) {
                decoderFrameMsg.finishWait.countDown();
            }
        }
    }
}
