package com.tencent.tav.decoder.reverseaudio;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.tav.core.AudioCompositionDecoderTrack;
import com.tencent.tav.core.AudioMix;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tav.decoder.DecoderTrackSegment;
import com.tencent.tav.decoder.IDecoder;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.decodecache.CacheFrame;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.decoder.reverseaudio.ReverseAudioSegmentCacheHandler;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes26.dex */
public class ReverseAudioDecoderTrack implements IDecoderTrack {
    private ReverseAudioSegmentCacheHandler audioCacheHandler;
    private final AudioCompositionDecoderTrack audioDecoderTrack;
    private CacheFrame lastCacheFrame;
    private final CMTime segmentDuration;
    private final String TAG = "ReverseAudioDecoderTrack";
    private CMTime reverseTime = new CMTime(0.0f);
    private CMTime currentSampleTime = new CMTime(0.0f);
    private final CopyOnWriteArrayList<CacheFrame> audioCacheList = new CopyOnWriteArrayList<>();
    private final CopyOnWriteArrayList<CacheFrame> nextAudioCacheList = new CopyOnWriteArrayList<>();
    private volatile boolean isDecodingNextSegment = false;
    private final Object preDecodeNextSegment = new Object();
    private long totalSize = 0;

    public ReverseAudioDecoderTrack(AudioCompositionDecoderTrack audioCompositionDecoderTrack, int i3) {
        this.audioDecoderTrack = audioCompositionDecoderTrack;
        this.segmentDuration = new CMTime(i3 * 0.09287982f);
    }

    private CMTime calculateEndTime() {
        if (this.reverseTime.equals(CMTime.CMTimeZero)) {
            CacheFrame cacheFrame = this.lastCacheFrame;
            if (cacheFrame == null) {
                return this.audioDecoderTrack.getDuration();
            }
            return cacheFrame.realFrameTime;
        }
        return this.reverseTime;
    }

    @NonNull
    private CMTime calculateStartTime(CMTime cMTime) {
        CMTime sub = cMTime.sub(this.segmentDuration);
        CMTime cMTime2 = CMTime.CMTimeZero;
        if (sub.smallThan(cMTime2)) {
            return cMTime2;
        }
        return sub;
    }

    @NonNull
    private CMSampleBuffer createCMSampleBuffer(CMSampleBuffer cMSampleBuffer) {
        this.totalSize += cMSampleBuffer.getSampleByteBuffer().limit();
        return new CMSampleBuffer(new CMSampleState(new CMTime((((float) this.totalSize) * 1.0f) / 88200.0f)), cMSampleBuffer.getSampleByteBuffer(), true);
    }

    private void preDecodeNextSegmentCache() {
        CMTime cMTime;
        this.isDecodingNextSegment = true;
        CMTime cMTime2 = CMTime.CMTimeInvalid;
        if (this.audioCacheList.size() != 0) {
            cMTime = this.audioCacheList.get(0).realFrameTime;
        } else {
            CacheFrame cacheFrame = this.lastCacheFrame;
            if (cacheFrame != null) {
                cMTime = cacheFrame.realFrameTime;
            } else {
                cMTime = cMTime2;
            }
        }
        if (cMTime.equalsTo(cMTime2)) {
            return;
        }
        CMTime calculateStartTime = calculateStartTime(cMTime);
        Logger.i("ReverseAudioDecoderTrack", "\u5f00\u59cb\u9884\u52a0\u8f7d\u8bfb\u53d6\u4e8c\u7ea7\u7f13\u5b58 startime = " + calculateStartTime.getTimeUs() + " endTime = " + cMTime.getTimeUs());
        this.audioCacheHandler.readSegmentSample(calculateStartTime, cMTime, new ReverseAudioSegmentCacheHandler.DecodeSegmentListener() { // from class: com.tencent.tav.decoder.reverseaudio.ReverseAudioDecoderTrack.2
            @Override // com.tencent.tav.decoder.reverseaudio.ReverseAudioSegmentCacheHandler.DecodeSegmentListener
            public void onSegmentDecodedFinish(List<CacheFrame> list) {
                Logger.i("ReverseAudioDecoderTrack", "\u4e8c\u7ea7\u7f13\u5b58\u52a0\u8f7d\u6210\u529f");
                ReverseAudioDecoderTrack.this.nextAudioCacheList.addAll(list);
                ReverseAudioDecoderTrack.this.isDecodingNextSegment = false;
                synchronized (ReverseAudioDecoderTrack.this.preDecodeNextSegment) {
                    ReverseAudioDecoderTrack.this.preDecodeNextSegment.notify();
                }
            }
        });
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void clipRangeAndClearRange(CMTimeRange cMTimeRange) {
        this.audioDecoderTrack.clipRangeAndClearRange(cMTimeRange);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMTime getCurrentSampleTime() {
        return this.currentSampleTime;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMTime getDuration() {
        return this.audioDecoderTrack.getDuration();
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMTime getFrameDuration() {
        return this.audioDecoderTrack.getFrameDuration();
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public int getFrameRate() {
        return this.audioDecoderTrack.getFrameRate();
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public int getTrackId() {
        return this.audioDecoderTrack.getTrackId();
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMSampleBuffer readCurrentSample() {
        return this.audioDecoderTrack.readCurrentSample();
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMSampleBuffer readSample() {
        if (this.audioCacheHandler == null) {
            return null;
        }
        final Object obj = new Object();
        if (this.audioCacheList.size() != 0) {
            Logger.i("ReverseAudioDecoderTrack", "\u8bfb\u53d6\u4e00\u7ea7\u7f13\u5b58\u6570\u636e");
            CacheFrame remove = this.audioCacheList.remove(this.audioCacheList.size() - 1);
            this.lastCacheFrame = remove;
            return createCMSampleBuffer(remove.sampleBuffer);
        }
        if (this.isDecodingNextSegment) {
            Logger.i("ReverseAudioDecoderTrack", "\u6b63\u5728\u9884\u52a0\u8f7d\u4e8c\u7ea7\u7f13\u5b58");
            try {
                synchronized (this.preDecodeNextSegment) {
                    LockMethodProxy.wait(this.preDecodeNextSegment);
                }
            } catch (InterruptedException e16) {
                e16.printStackTrace();
            }
        }
        if (this.nextAudioCacheList.size() != 0) {
            Logger.i("ReverseAudioDecoderTrack", "\u4e00\u7ea7\u7f13\u5b58\u4e2d\u6ca1\u6709\u6570\u636e\uff0c\u5f00\u59cb\u8bfb\u53d6\u4e8c\u7ea7\u7f13\u5b58");
            this.audioCacheList.addAll(this.nextAudioCacheList);
            int size = this.audioCacheList.size() - 1;
            this.nextAudioCacheList.clear();
            if (this.audioCacheList.get(0).sampleBuffer.getState().getStateCode() != -1) {
                preDecodeNextSegmentCache();
            }
            CacheFrame remove2 = this.audioCacheList.remove(size);
            this.lastCacheFrame = remove2;
            return createCMSampleBuffer(remove2.sampleBuffer);
        }
        CMTime calculateEndTime = calculateEndTime();
        CMTime calculateStartTime = calculateStartTime(calculateEndTime);
        Logger.i("ReverseAudioDecoderTrack", "\u4e00\u3001\u4e8c\u7ea7\u7f13\u5b58\u4e2d\u90fd\u6ca1\u6709\u6570\u636e\uff0c\u5148\u5f00\u59cb\u52a0\u8f7d\u4e00\u7ea7\u7f13\u5b58 startime = " + calculateStartTime.getTimeUs() + " endTime = " + calculateEndTime.getTimeUs() + " duration = " + getDuration());
        this.audioCacheHandler.readSegmentSample(calculateStartTime, calculateEndTime, new ReverseAudioSegmentCacheHandler.DecodeSegmentListener() { // from class: com.tencent.tav.decoder.reverseaudio.ReverseAudioDecoderTrack.1
            @Override // com.tencent.tav.decoder.reverseaudio.ReverseAudioSegmentCacheHandler.DecodeSegmentListener
            public void onSegmentDecodedFinish(List<CacheFrame> list) {
                Logger.i("ReverseAudioDecoderTrack", "\u4e00\u7ea7\u7f13\u5b58\u52a0\u8f7d\u6210\u529f");
                try {
                    if (list.size() > 0) {
                        ReverseAudioDecoderTrack.this.audioCacheList.addAll(list);
                        int size2 = ReverseAudioDecoderTrack.this.audioCacheList.size() - 1;
                        ReverseAudioDecoderTrack reverseAudioDecoderTrack = ReverseAudioDecoderTrack.this;
                        reverseAudioDecoderTrack.lastCacheFrame = (CacheFrame) reverseAudioDecoderTrack.audioCacheList.remove(size2);
                    }
                    synchronized (obj) {
                        obj.notify();
                    }
                } catch (Throwable th5) {
                    synchronized (obj) {
                        obj.notify();
                        throw th5;
                    }
                }
            }
        });
        try {
            synchronized (obj) {
                LockMethodProxy.wait(obj);
            }
        } catch (InterruptedException e17) {
            e17.printStackTrace();
        }
        Logger.i("ReverseAudioDecoderTrack", "\u7b2c\u4e00\u6b21\u5f00\u59cb\u5f00\u59cb\u8bfb\u53d6\u4e8c\u7ea7\u7f13\u5b58");
        preDecodeNextSegmentCache();
        CacheFrame cacheFrame = this.lastCacheFrame;
        if (cacheFrame == null) {
            return new CMSampleBuffer(CMSampleState.fromError(-1L));
        }
        return createCMSampleBuffer(cacheFrame.sampleBuffer);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void release() {
        this.audioCacheHandler.release();
        this.audioCacheHandler = null;
        CMTime cMTime = CMTime.CMTimeZero;
        this.reverseTime = cMTime;
        this.currentSampleTime = cMTime;
        this.audioDecoderTrack.release();
        this.audioCacheList.clear();
        this.nextAudioCacheList.clear();
        this.totalSize = 0L;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMSampleBuffer seekTo(CMTime cMTime, boolean z16, boolean z17) {
        if (cMTime.bigThan(CMTime.CMTimeZero)) {
            this.reverseTime = this.audioDecoderTrack.getDuration().sub(cMTime);
        } else {
            this.reverseTime = cMTime;
        }
        CMSampleBuffer seekTo = this.audioDecoderTrack.seekTo(this.reverseTime, z16, z17);
        this.audioCacheList.clear();
        this.nextAudioCacheList.clear();
        this.lastCacheFrame = null;
        this.totalSize = 0L;
        return seekTo;
    }

    public void setAudioInfo(AudioInfo audioInfo) {
        this.audioDecoderTrack.setAudioInfo(audioInfo);
    }

    public void setAudioMix(AudioMix audioMix) {
        this.audioDecoderTrack.setAudioMix(audioMix);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void setDecodeType(IDecoder.DecodeType decodeType) {
        this.audioDecoderTrack.setDecodeType(decodeType);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void setFrameRate(int i3) {
        this.audioDecoderTrack.setFrameRate(i3);
    }

    public void setRate(float f16) {
        this.audioDecoderTrack.setRate(f16);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void setTrackIndex(int i3) {
        this.audioDecoderTrack.setTrackIndex(i3);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void setTrackSegments(List<DecoderTrackSegment> list) {
        this.audioDecoderTrack.setTrackSegments(list);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void setVolume(float f16) {
        this.audioDecoderTrack.setVolume(f16);
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
        this.audioCacheHandler = new ReverseAudioSegmentCacheHandler(this.audioDecoderTrack);
        this.audioDecoderTrack.start(surfaceCreator, cMTimeRange);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public void asyncReadNextSample(CMTime cMTime) {
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack
    public CMSampleBuffer readSample(CMTime cMTime) {
        return readSample();
    }
}
