package com.tencent.tav.decoder.decodecache;

import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.DecoderTrackSegment;
import com.tencent.tav.decoder.IDecoder;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.logger.Logger;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes26.dex */
public class CachedVideoDecoderTrack implements IDecoderTrack {
    private static final String TAG = "CachedVideoTrack";
    private CacheSegment currentFrameSegment;
    private CacheSegment nextFrameSegment;
    RenderContext renderContext;
    boolean revert;
    private SegmentDecoderThread segmentDecoder;
    CMTimeRange validTimeRange;
    private int segmentSize = 60;
    final Object nextFrameDecoderLock = new Object();
    private CMSampleState lastSampleState = new CMSampleState();

    public CachedVideoDecoderTrack(IDecoderTrack iDecoderTrack, boolean z16) {
        this.revert = z16;
        this.segmentDecoder = new SegmentDecoderThread(this, iDecoderTrack);
    }

    private void clearCurrentFrameSegment() {
        CacheSegment cacheSegment = this.currentFrameSegment;
        if (cacheSegment != null) {
            cacheSegment.clear();
            this.currentFrameSegment = null;
        }
    }

    private CMSampleBuffer decoderFrame(CMTime cMTime) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.segmentDecoder.decoderSegment(cMTime, countDownLatch);
        try {
            countDownLatch.await(5L, TimeUnit.SECONDS);
        } catch (InterruptedException e16) {
            e16.printStackTrace();
        }
        return this.segmentDecoder.seekSampleBuffer;
    }

    private CMSampleBuffer decoderSegment(CMTime cMTime) {
        Object obj;
        Object obj2;
        RequestStatus requestStatus = new RequestStatus();
        CacheSegment cacheSegment = this.nextFrameSegment;
        boolean z16 = false;
        if (cacheSegment != null && cacheSegment.segmentTimeRange != null && this.nextFrameSegment.segmentTimeRange.containsTime(cMTime)) {
            synchronized (this.nextFrameDecoderLock) {
                clearCurrentFrameSegment();
                this.currentFrameSegment = new CacheSegment(this.nextFrameSegment.segmentTimeRange);
                Iterator<CacheFrame> it = this.nextFrameSegment.cacheFrameList.iterator();
                while (it.hasNext()) {
                    this.currentFrameSegment.pushFrame(it.next());
                }
                CacheFrame popFrame = this.currentFrameSegment.popFrame(cMTime);
                if (popFrame != null) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("readSample: hint nextFrameSegment ");
                    CMSampleBuffer cMSampleBuffer = popFrame.sampleBuffer;
                    if (cMSampleBuffer != null && cMSampleBuffer.getTextureInfo() != null) {
                        z16 = true;
                    }
                    sb5.append(z16);
                    sb5.append("  ");
                    CMSampleBuffer cMSampleBuffer2 = popFrame.sampleBuffer;
                    if (cMSampleBuffer2 != null) {
                        obj2 = Boolean.valueOf(cMSampleBuffer2.isNewFrame());
                    } else {
                        obj2 = "null";
                    }
                    sb5.append(obj2);
                    sb5.append(" time = ");
                    sb5.append(popFrame.realFrameTime);
                    sb5.append("  ");
                    sb5.append(popFrame.frameTime);
                    Logger.v(TAG, sb5.toString());
                    CacheSegment cacheSegment2 = new CacheSegment(new CMTimeRange(this.currentFrameSegment.getLastFrameTime(), getFrameDuration().multi(this.segmentSize)));
                    this.nextFrameSegment = cacheSegment2;
                    this.segmentDecoder.decoderSegment(cacheSegment2, (RequestStatus) null);
                    this.lastSampleState = new CMSampleState(popFrame.frameTime);
                    return popFrame.sampleBuffer;
                }
                Logger.w(TAG, "readSample: hint nextFrameSegment frame == null " + this.nextFrameSegment.cacheFrameList.size() + "  " + this.currentFrameSegment.cacheFrameList.size());
                this.segmentDecoder.cancel = true;
            }
        } else {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("readSample: hint nextFrameSegment --- ");
            CacheSegment cacheSegment3 = this.nextFrameSegment;
            if (cacheSegment3 == null) {
                obj = "";
            } else {
                obj = cacheSegment3.segmentTimeRange;
            }
            sb6.append(obj);
            sb6.append("  ");
            sb6.append(cMTime);
            Logger.w(TAG, sb6.toString());
        }
        synchronized (this.nextFrameDecoderLock) {
            CacheSegment cacheSegment4 = this.nextFrameSegment;
            if (cacheSegment4 != null) {
                cacheSegment4.clear();
            }
            CacheSegment cacheSegment5 = new CacheSegment(new CMTimeRange(cMTime, getFrameDuration().multi(this.segmentSize)));
            this.nextFrameSegment = cacheSegment5;
            this.segmentDecoder.decoderSegment(cacheSegment5, requestStatus);
        }
        synchronized (requestStatus) {
            try {
                if (!requestStatus.getFinish()) {
                    requestStatus.wait(10000L);
                }
            } catch (InterruptedException e16) {
                e16.printStackTrace();
            }
        }
        if (this.nextFrameSegment.cacheFrameList.size() == 0) {
            return new CMSampleBuffer(CMSampleState.fromError(-1L));
        }
        clearCurrentFrameSegment();
        this.currentFrameSegment = new CacheSegment(this.nextFrameSegment.segmentTimeRange);
        Iterator<CacheFrame> it5 = this.nextFrameSegment.cacheFrameList.iterator();
        while (it5.hasNext()) {
            this.currentFrameSegment.pushFrame(it5.next());
        }
        synchronized (this.nextFrameDecoderLock) {
            CacheSegment cacheSegment6 = new CacheSegment(new CMTimeRange(this.currentFrameSegment.getLastFrameTime(), getFrameDuration().multi(this.segmentSize)));
            this.nextFrameSegment = cacheSegment6;
            this.segmentDecoder.decoderSegment(cacheSegment6, (RequestStatus) null);
        }
        CacheSegment cacheSegment7 = this.currentFrameSegment;
        if (cacheSegment7 == null || cacheSegment7.cacheFrameList.size() <= 0) {
            return null;
        }
        CacheFrame cacheFrame = this.currentFrameSegment.cacheFrameList.get(0);
        this.lastSampleState = new CMSampleState(cacheFrame.frameTime);
        return cacheFrame.sampleBuffer;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void clipRangeAndClearRange(CMTimeRange cMTimeRange) {
        this.segmentDecoder.decoderTrack.clipRangeAndClearRange(cMTimeRange);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMTime getCurrentSampleTime() {
        return this.lastSampleState.getTime();
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMTime getDuration() {
        return this.segmentDecoder.decoderTrack.getDuration();
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMTime getFrameDuration() {
        return this.segmentDecoder.decoderTrack.getFrameDuration();
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public int getFrameRate() {
        return this.segmentDecoder.decoderTrack.getFrameRate();
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public int getTrackId() {
        return this.segmentDecoder.decoderTrack.getTrackId();
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMSampleBuffer readCurrentSample() {
        return null;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMSampleBuffer readSample() {
        if (this.lastSampleState.isInvalid()) {
            return readSample(CMTime.CMTimeZero);
        }
        if (this.lastSampleState.getTime().smallThan(CMTime.CMTimeZero)) {
            return new CMSampleBuffer(this.lastSampleState);
        }
        return readSample(this.lastSampleState.getTime().add(getFrameDuration()));
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void release() {
        CacheSegment cacheSegment = this.currentFrameSegment;
        if (cacheSegment != null) {
            cacheSegment.clear();
        }
        CacheSegment cacheSegment2 = this.nextFrameSegment;
        if (cacheSegment2 != null) {
            cacheSegment2.clear();
        }
        synchronized (this.nextFrameDecoderLock) {
            SegmentDecoderThread segmentDecoderThread = this.segmentDecoder;
            if (segmentDecoderThread != null) {
                segmentDecoderThread.release();
                this.segmentDecoder = null;
            }
        }
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMSampleBuffer seekTo(CMTime cMTime, boolean z16, boolean z17) {
        int i3;
        CMSampleState state;
        Logger.v(TAG, "seekTo: PlayerThreadMain " + cMTime);
        if (cMTime.bigThan(getFrameDuration())) {
            this.lastSampleState = new CMSampleState(cMTime.sub(getFrameDuration()));
        } else {
            this.lastSampleState = new CMSampleState(cMTime);
        }
        CacheSegment cacheSegment = this.currentFrameSegment;
        if (cacheSegment != null) {
            cacheSegment.clear();
            this.currentFrameSegment = null;
        }
        CacheSegment cacheSegment2 = this.nextFrameSegment;
        if (cacheSegment2 != null) {
            cacheSegment2.clear();
            this.nextFrameSegment = null;
        }
        if (!z16) {
            return null;
        }
        long timeUs = cMTime.getTimeUs() / getFrameDuration().getTimeUs();
        if (cMTime.getTimeUs() % getFrameDuration().getTimeUs() > 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        CMSampleBuffer decoderFrame = decoderFrame(new CMTime(((float) ((timeUs + i3) * getFrameDuration().getTimeUs())) / 1000000.0f));
        if (decoderFrame == null) {
            state = CMSampleState.fromError(-1L);
        } else {
            state = decoderFrame.getState();
        }
        this.lastSampleState = state;
        return decoderFrame;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void setDecodeType(IDecoder.DecodeType decodeType) {
        this.segmentDecoder.decoderTrack.setDecodeType(decodeType);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void setFrameRate(int i3) {
        this.segmentDecoder.decoderTrack.setFrameRate(i3);
    }

    public void setMaxFrameCacheSize(int i3) {
        if (i3 > 0) {
            this.segmentSize = i3;
            SegmentDecoderThread segmentDecoderThread = this.segmentDecoder;
            if (segmentDecoderThread != null) {
                segmentDecoderThread.texturePool.setMaxCacheLength(i3);
            }
        }
    }

    public void setRevert(boolean z16) {
        this.revert = z16;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void setTrackSegments(List<DecoderTrackSegment> list) {
        this.segmentDecoder.decoderTrack.setTrackSegments(list);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void setVolume(float f16) {
        this.segmentDecoder.decoderTrack.setVolume(f16);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void start() {
        start(null);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void start(IDecoderTrack.SurfaceCreator surfaceCreator) {
        start(surfaceCreator, null);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void start(IDecoderTrack.SurfaceCreator surfaceCreator, CMTimeRange cMTimeRange) {
        this.validTimeRange = cMTimeRange;
        this.renderContext = (RenderContext) surfaceCreator;
        this.segmentDecoder.startForReady();
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMSampleBuffer readSample(CMTime cMTime) {
        CacheFrame popFrame;
        if (cMTime.smallThan(CMTime.CMTimeZero)) {
            return readSample();
        }
        Logger.v(TAG, "readSample: targetTime = " + cMTime);
        CacheSegment cacheSegment = this.currentFrameSegment;
        if (cacheSegment != null && (popFrame = cacheSegment.popFrame(cMTime)) != null) {
            this.lastSampleState = new CMSampleState(popFrame.frameTime);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("readSample: hint currentSegment ");
            CMSampleBuffer cMSampleBuffer = popFrame.sampleBuffer;
            sb5.append((cMSampleBuffer == null || cMSampleBuffer.getTextureInfo() == null) ? false : true);
            sb5.append("  ");
            CMSampleBuffer cMSampleBuffer2 = popFrame.sampleBuffer;
            sb5.append(cMSampleBuffer2 != null ? Boolean.valueOf(cMSampleBuffer2.isNewFrame()) : "null");
            sb5.append(" time = ");
            sb5.append(popFrame.realFrameTime);
            sb5.append("  ");
            sb5.append(popFrame.frameTime);
            Logger.v(TAG, sb5.toString());
            return popFrame.sampleBuffer;
        }
        if (!cMTime.smallThan(getDuration())) {
            this.lastSampleState = CMSampleState.fromError(-1L);
            return new CMSampleBuffer(CMSampleState.fromError(-1L));
        }
        CMSampleBuffer decoderSegment = decoderSegment(cMTime);
        if (decoderSegment != null) {
            Logger.v(TAG, "readSample: hint currentSegment - " + decoderSegment.getTime());
            return decoderSegment;
        }
        if (cMTime.bigThan(getDuration())) {
            this.lastSampleState = CMSampleState.fromError(-1L);
            return new CMSampleBuffer(CMSampleState.fromError(-1L));
        }
        this.lastSampleState = CMSampleState.fromError(-3L);
        return new CMSampleBuffer(CMSampleState.fromError(-3L));
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void asyncReadNextSample(CMTime cMTime) {
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void setTrackIndex(int i3) {
    }
}
