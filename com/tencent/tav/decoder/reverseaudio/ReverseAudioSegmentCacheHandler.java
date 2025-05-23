package com.tencent.tav.decoder.reverseaudio;

import androidx.annotation.NonNull;
import com.tencent.tav.core.AudioCompositionDecoderTrack;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.decodecache.CacheFrame;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: P */
/* loaded from: classes26.dex */
public class ReverseAudioSegmentCacheHandler {
    private AudioCompositionDecoderTrack audioCompositionDecoderTrack;
    private CMTime audioDuration;
    private final Lock decodeSegmentLock = new ReentrantLock(true);
    private ExecutorService threadPool = ProxyExecutors.newFixedThreadPool(3);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface DecodeSegmentListener {
        void onSegmentDecodedFinish(List<CacheFrame> list);
    }

    public ReverseAudioSegmentCacheHandler(AudioCompositionDecoderTrack audioCompositionDecoderTrack) {
        this.audioCompositionDecoderTrack = audioCompositionDecoderTrack;
        this.audioDuration = audioCompositionDecoderTrack.getDuration();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public CacheFrame createCacheFrame(CMSampleBuffer cMSampleBuffer, CMTime cMTime, CMSampleState cMSampleState) {
        ByteBuffer revertByteBuffer = revertByteBuffer(cMSampleBuffer);
        CacheFrame cacheFrame = new CacheFrame();
        CMSampleBuffer cMSampleBuffer2 = new CMSampleBuffer(cMSampleState, revertByteBuffer, true);
        cacheFrame.frameTime = cMTime;
        cacheFrame.sampleBuffer = cMSampleBuffer2;
        cacheFrame.realFrameTime = cMSampleBuffer.getTime();
        return cacheFrame;
    }

    private ByteBuffer revertByteBuffer(CMSampleBuffer cMSampleBuffer) {
        ByteBuffer sampleByteBuffer = cMSampleBuffer.getSampleByteBuffer();
        if (sampleByteBuffer == null) {
            return sampleByteBuffer;
        }
        ShortBuffer asShortBuffer = sampleByteBuffer.asShortBuffer();
        int limit = asShortBuffer.limit();
        short[] sArr = new short[limit];
        asShortBuffer.get(sArr);
        short[] sArr2 = new short[limit];
        for (int i3 = 0; i3 < limit; i3++) {
            sArr2[i3] = sArr[(limit - i3) - 1];
        }
        int i16 = limit * 2;
        ByteBuffer allocate = ByteBuffer.allocate(i16);
        allocate.order(sampleByteBuffer.order());
        allocate.asShortBuffer().put(sArr2);
        allocate.position(0);
        allocate.limit(i16);
        return allocate;
    }

    public void readSegmentSample(final CMTime cMTime, final CMTime cMTime2, final DecodeSegmentListener decodeSegmentListener) {
        this.threadPool.execute(new Runnable() { // from class: com.tencent.tav.decoder.reverseaudio.ReverseAudioSegmentCacheHandler.1
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                CMTime cMTime3;
                CMSampleState fromError;
                boolean z17;
                CMSampleState state;
                ReverseAudioSegmentCacheHandler.this.decodeSegmentLock.lock();
                try {
                    boolean equals = cMTime.equals(CMTime.CMTimeZero);
                    ReverseAudioSegmentCacheHandler.this.audioCompositionDecoderTrack.seekTo(cMTime, false, true);
                    LinkedList linkedList = new LinkedList();
                    CMSampleBuffer cMSampleBuffer = null;
                    boolean z18 = false;
                    while (true) {
                        if (cMSampleBuffer != null && (!cMSampleBuffer.getTime().smallThan(cMTime2) || z18)) {
                            break;
                        }
                        cMSampleBuffer = ReverseAudioSegmentCacheHandler.this.audioCompositionDecoderTrack.readSample();
                        if (cMSampleBuffer.getState().getTime().bigThan(cMTime2)) {
                            break;
                        }
                        long stateCode = cMSampleBuffer.getState().getStateCode();
                        if (stateCode == -1) {
                            cMTime3 = CMTime.CMTimeZero;
                            z16 = true;
                        } else {
                            CMTime time = cMSampleBuffer.getTime();
                            CMTime cMTime4 = CMTime.CMTimeZero;
                            if (time.bigThan(cMTime4)) {
                                z16 = z18;
                                cMTime3 = ReverseAudioSegmentCacheHandler.this.audioDuration.sub(cMSampleBuffer.getTime());
                            } else {
                                z16 = z18;
                                cMTime3 = cMTime4;
                            }
                        }
                        if ((cMSampleBuffer.getState().getTime().smallThan(CMTime.CMTimeZero) || equals) && cMSampleBuffer.getState().getStateCode() >= 0) {
                            fromError = CMSampleState.fromError(-1L);
                            z17 = false;
                        } else {
                            if (stateCode != -3 && stateCode != -2 && stateCode != -4) {
                                state = new CMSampleState(cMTime3);
                                CMSampleState cMSampleState = state;
                                z17 = equals;
                                fromError = cMSampleState;
                            }
                            state = cMSampleBuffer.getState();
                            CMSampleState cMSampleState2 = state;
                            z17 = equals;
                            fromError = cMSampleState2;
                        }
                        linkedList.add(ReverseAudioSegmentCacheHandler.this.createCacheFrame(cMSampleBuffer, cMTime3, fromError));
                        equals = z17;
                        z18 = z16;
                    }
                    decodeSegmentListener.onSegmentDecodedFinish(linkedList);
                } finally {
                    ReverseAudioSegmentCacheHandler.this.decodeSegmentLock.unlock();
                }
            }
        });
    }

    public void release() {
        this.threadPool.shutdownNow();
    }
}
