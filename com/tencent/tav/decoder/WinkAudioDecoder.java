package com.tencent.tav.decoder;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.IVideoDecoder;
import com.tencent.tav.decoder.extractor.IExtractor;
import com.tencent.tav.decoder.factory.AVExtractorFactory;
import com.tencent.tav.decoder.logger.Logger;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes26.dex */
public class WinkAudioDecoder implements IAudioDecoder {
    private static final int MAX_RETRY_COUNT = 10;
    private static final int MAX_WAIT_TIME = 1000;
    private static final long SEEK_GAP = 10000000;
    public static final String TAG = "WinkAudioDecoder";
    private static final long WAIT_TRANSIENT_MS = 2;
    private static final ArrayList<String> nameList = new ArrayList<>();
    private MediaCodec.BufferInfo mBufferInfo;
    private CMSampleState mCurrentSampleState;
    private CMTime mCurrentStartTime;
    private AudioInfo mDecodeAudioInfo;
    private ByteBuffer mDecodeBuffer;
    private MediaCodec mDecoder;
    private CMTime mDuration;
    private IExtractor mExtractor;
    private boolean mExtractorDone;
    private boolean mIsReleased;
    private int mLastOutputBufferIndex;
    private long mLastVideoQueueTime;
    private MediaFormat mMediaFormat;
    private ByteBuffer mOutputBuffer;
    private ArrayList<PendingFrame> mPendingFrames;
    private boolean mStarted;
    private long mTimeOffset;
    private CMTimeRange mTimeRange;
    private int mTrackIndex;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class PendingFrame {
        public CMTime frameTime;
        public CMTime seekStartTime;
        public boolean isFirst = false;
        public long timeOffset = 0;

        public PendingFrame() {
            CMTime cMTime = CMTime.CMTimeZero;
            this.seekStartTime = cMTime;
            this.frameTime = cMTime;
        }
    }

    public WinkAudioDecoder(@NonNull IVideoDecoder.Params params) throws Exception {
        this(params.filePath);
    }

    private void clearDecoder() {
        Logger.v(TAG, "clearDecoder " + getSourcePath());
        releaseOutputBuffer();
        if (this.mPendingFrames.size() != 0 || this.mExtractorDone) {
            try {
                this.mDecoder.flush();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            this.mPendingFrames.clear();
        }
        this.mCurrentSampleState = new CMSampleState();
    }

    private synchronized boolean decoderConfigure(MediaFormat mediaFormat) {
        Logger.i(TAG, "decoderConfigure() called with: inputFormat = [" + mediaFormat + "]");
        int i3 = 0;
        while (true) {
            i3++;
            try {
                Logger.d(TAG, "createdDecoder---time---" + i3);
                if (i3 > 10) {
                    return false;
                }
                this.mDecoder.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 0);
                Logger.i(TAG, "decoderConfigure() called with: outputFormat = [" + this.mDecoder.getOutputFormat() + "]");
                return true;
            } catch (Exception e16) {
                Logger.e(TAG, "decoderConfigure: ", e16);
                if (!(e16 instanceof MediaCodec.CodecException) || (!((MediaCodec.CodecException) e16).isTransient() && !((MediaCodec.CodecException) e16).isRecoverable())) {
                    MediaCodecManager.releaseCodec(this.mDecoder);
                    throw e16;
                }
            }
        }
    }

    private synchronized int dequeueInputBuffer() {
        try {
            return this.mDecoder.dequeueInputBuffer(1000L);
        } catch (Error | Exception e16) {
            Logger.e(TAG, "dequeueInputBuffer", e16);
            if (e16 instanceof MediaCodec.CodecException) {
                Logger.e(TAG, "CodecException - isTransient = " + ((MediaCodec.CodecException) e16).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException) e16).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException) e16).getErrorCode());
                if (((MediaCodec.CodecException) e16).isTransient()) {
                    waitTime(2L);
                    return dequeueInputBuffer();
                }
            }
            throw e16;
        }
    }

    private synchronized int dequeueOutputBuffer() {
        try {
        } catch (Exception e16) {
            Logger.e(TAG, "dequeueOutputBuffer", e16);
            if (e16 instanceof MediaCodec.CodecException) {
                Logger.e(TAG, "CodecException - isTransient = " + ((MediaCodec.CodecException) e16).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException) e16).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException) e16).getErrorCode());
                if (((MediaCodec.CodecException) e16).isTransient()) {
                    waitTime(2L);
                    return dequeueOutputBuffer();
                }
            }
            throw e16;
        }
        return this.mDecoder.dequeueOutputBuffer(this.mBufferInfo, 1000L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x01d6, code lost:
    
        com.tencent.tav.decoder.logger.Logger.v(com.tencent.tav.decoder.WinkAudioDecoder.TAG, "doReadSample:[success] " + r18.mExtractorDone + " " + r7 + "  " + r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0204, code lost:
    
        if (r18.mExtractorDone == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x020a, code lost:
    
        if (r7 >= 0) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x020c, code lost:
    
        r0 = com.tencent.tav.coremedia.CMSampleState.fromError(-1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0213, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized CMSampleState doReadSample(CMTime cMTime, boolean z16) {
        boolean z17;
        Logger.v(TAG, "doReadSample - " + this.mExtractor.getSourcePath());
        CMSampleState fromError = CMSampleState.fromError(-2L);
        boolean z18 = false;
        if (this.mStarted && this.mTrackIndex != -1) {
            releaseOutputBuffer();
            long j3 = -2;
            int i3 = 0;
            while (true) {
                if (this.mPendingFrames.size() <= 0 && this.mExtractorDone) {
                    break;
                }
                try {
                    if (!this.mExtractorDone) {
                        readFromExtractor();
                    }
                    int dequeueOutputBuffer = dequeueOutputBuffer();
                    if (dequeueOutputBuffer == -2) {
                        MediaFormat outputFormat = this.mDecoder.getOutputFormat();
                        if (outputFormat.containsKey("pcm-encoding")) {
                            this.mDecodeAudioInfo.pcmEncoding = outputFormat.getInteger("pcm-encoding");
                        } else {
                            Logger.w(TAG, "doReadSample: decodedAudioFormat.containsKey(\"pcm-encoding\") is false");
                            this.mDecodeAudioInfo.pcmEncoding = 2;
                        }
                        if (outputFormat.containsKey("sample-rate")) {
                            this.mDecodeAudioInfo.sampleRate = outputFormat.getInteger("sample-rate");
                        }
                        if (outputFormat.containsKey("channel-count")) {
                            this.mDecodeAudioInfo.channelCount = outputFormat.getInteger("channel-count");
                        }
                    } else if (dequeueOutputBuffer >= 0 && this.mPendingFrames.size() > 0) {
                        MediaCodec.BufferInfo bufferInfo = this.mBufferInfo;
                        if (bufferInfo.flags == 4) {
                            if (bufferInfo.size > 0) {
                                this.mPendingFrames.remove(0);
                                this.mLastOutputBufferIndex = dequeueOutputBuffer;
                                ByteBuffer outputBuffer = getOutputBuffer(dequeueOutputBuffer);
                                if (outputBuffer != null) {
                                    outputBuffer.position(this.mBufferInfo.offset);
                                    MediaCodec.BufferInfo bufferInfo2 = this.mBufferInfo;
                                    outputBuffer.limit(bufferInfo2.offset + bufferInfo2.size);
                                    this.mDecodeBuffer = outputBuffer;
                                } else {
                                    releaseOutputBuffer(dequeueOutputBuffer, false);
                                    this.mDecodeBuffer = null;
                                }
                            }
                            Logger.i(TAG, "doReadSample:[finish] bufferInfo.flags == MediaCodec.BUFFER_FLAG_END_OF_STREAM");
                            return CMSampleState.fromError(-1L);
                        }
                        PendingFrame remove = this.mPendingFrames.remove(0);
                        j3 = this.mBufferInfo.presentationTimeUs - remove.timeOffset;
                        CMSampleState cMSampleState = new CMSampleState(new CMTime(j3, 1000000));
                        if (this.mPendingFrames.size() == 0 && this.mExtractorDone && remove.seekStartTime.getTimeUs() + 1000 >= this.mDuration.getTimeUs()) {
                            fromError = new CMSampleState(this.mDuration);
                        } else if (remove.seekStartTime.getTimeUs() > j3) {
                            releaseOutputBuffer(dequeueOutputBuffer, false);
                            fromError = CMSampleState.fromError(-2L);
                        } else {
                            fromError = cMSampleState;
                        }
                        if (this.mBufferInfo.size > 0) {
                            this.mLastOutputBufferIndex = dequeueOutputBuffer;
                            ByteBuffer outputBuffer2 = getOutputBuffer(dequeueOutputBuffer);
                            if (outputBuffer2 != null) {
                                outputBuffer2.position(this.mBufferInfo.offset);
                                MediaCodec.BufferInfo bufferInfo3 = this.mBufferInfo;
                                outputBuffer2.limit(bufferInfo3.offset + bufferInfo3.size);
                                this.mDecodeBuffer = outputBuffer2;
                            } else {
                                releaseOutputBuffer(dequeueOutputBuffer, false);
                                Logger.e(TAG, "doReadSample:[error] " + this.mBufferInfo.size + " byteBuffer==null");
                                return CMSampleState.fromError(-3L);
                            }
                        } else {
                            releaseOutputBuffer(dequeueOutputBuffer, false);
                            fromError = CMSampleState.fromError(-2L);
                        }
                    } else {
                        if (dequeueOutputBuffer >= 0) {
                            if (this.mBufferInfo.flags == 4) {
                                Logger.i(TAG, "doReadSample:[finish] bufferInfo.flags == MediaCodec.BUFFER_FLAG_END_OF_STREAM 2");
                                return CMSampleState.fromError(-1L);
                            }
                            releaseOutputBuffer(dequeueOutputBuffer, false);
                            fromError = CMSampleState.fromError(-2L);
                        }
                        i3++;
                        if (i3 > 1000) {
                            fromError = CMSampleState.fromError(-4L);
                            Logger.e(TAG, "doReadSample: [timeout] ");
                            break;
                        }
                    }
                } catch (Exception e16) {
                    Logger.e(TAG, "doReadSample: error", e16);
                    if ((e16 instanceof MediaCodec.CodecException) && retryOnReadSampleError((MediaCodec.CodecException) e16)) {
                        return CMSampleState.fromError(-3L, "catch exception, retry", e16);
                    }
                    return CMSampleState.fromError(-3L, "catch exception", e16);
                }
            }
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("doReadSample:[failed] !started || trackIndex == -1 ");
        if (!this.mStarted) {
            z17 = true;
        } else {
            z17 = false;
        }
        sb5.append(z17);
        sb5.append(" - ");
        if (this.mTrackIndex == -1) {
            z18 = true;
        }
        sb5.append(z18);
        Logger.e(TAG, sb5.toString());
        return CMSampleState.fromError(-100L);
    }

    private synchronized ByteBuffer getInputBuffer(int i3) {
        try {
            return DecoderUtils.getInputBuffer(this.mDecoder, i3);
        } catch (Error | Exception e16) {
            Logger.e(TAG, "getInputBuffer", e16);
            if (e16 instanceof MediaCodec.CodecException) {
                Logger.e(TAG, "CodecException - isTransient = " + ((MediaCodec.CodecException) e16).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException) e16).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException) e16).getErrorCode());
                if (((MediaCodec.CodecException) e16).isTransient()) {
                    waitTime(2L);
                    return getInputBuffer(i3);
                }
            }
            throw e16;
        }
    }

    private synchronized ByteBuffer getOutputBuffer(int i3) {
        try {
            return DecoderUtils.getOutputBuffer(this.mDecoder, i3);
        } catch (Error | Exception e16) {
            Logger.e(TAG, "getOutputBuffer", e16);
            if (e16 instanceof MediaCodec.CodecException) {
                Logger.e(TAG, "CodecException - isTransient = " + ((MediaCodec.CodecException) e16).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException) e16).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException) e16).getErrorCode());
                if (((MediaCodec.CodecException) e16).isTransient()) {
                    waitTime(2L);
                    return getOutputBuffer(i3);
                }
            }
            throw e16;
        }
    }

    private synchronized void queueInputBuffer(int i3, int i16, int i17, long j3, int i18) {
        try {
            this.mDecoder.queueInputBuffer(i3, i16, i17, j3, i18);
        } catch (Error | Exception e16) {
            Logger.e(TAG, "queueInputBuffer", e16);
            if (e16 instanceof MediaCodec.CodecException) {
                Logger.e(TAG, "CodecException - isTransient = " + ((MediaCodec.CodecException) e16).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException) e16).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException) e16).getErrorCode());
                if (((MediaCodec.CodecException) e16).isTransient()) {
                    waitTime(2L);
                    queueInputBuffer(i3, i16, i17, j3, i18);
                }
            }
            throw e16;
        }
    }

    private synchronized void readFromExtractor() {
        long sampleTime = this.mExtractor.getSampleTime();
        if (sampleTime < this.mTimeRange.getEndUs() && this.mExtractor.getSampleTrackIndex() != -1 && sampleTime != -1) {
            int dequeueInputBuffer = dequeueInputBuffer();
            if (dequeueInputBuffer >= 0) {
                int readSampleData = this.mExtractor.readSampleData(getInputBuffer(dequeueInputBuffer), 0);
                if (readSampleData >= 0) {
                    long startUs = (sampleTime - this.mTimeRange.getStartUs()) + this.mTimeOffset;
                    this.mLastVideoQueueTime = startUs;
                    queueInputBuffer(dequeueInputBuffer, 0, readSampleData, startUs, 0);
                    PendingFrame pendingFrame = new PendingFrame();
                    pendingFrame.timeOffset = this.mTimeOffset;
                    pendingFrame.frameTime = new CMTime((((float) sampleTime) * 1.0f) / ((float) TimeUnit.SECONDS.toMicros(1L)));
                    pendingFrame.seekStartTime = this.mCurrentStartTime.sub(this.mTimeRange.getStart());
                    if (this.mPendingFrames.size() == 0) {
                        pendingFrame.isFirst = true;
                    }
                    this.mPendingFrames.add(pendingFrame);
                }
                this.mExtractor.advance();
            }
        }
        int dequeueInputBuffer2 = dequeueInputBuffer();
        if (dequeueInputBuffer2 >= 0) {
            queueInputBuffer(dequeueInputBuffer2, 0, 0, 0L, 4);
            this.mExtractorDone = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void releaseOutputBuffer() {
        int i3 = this.mLastOutputBufferIndex;
        if (i3 != -1) {
            try {
                releaseOutputBuffer(i3, false);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            this.mLastOutputBufferIndex = -1;
        }
        this.mDecodeBuffer = null;
    }

    private synchronized void reset() {
        if (this.mIsReleased) {
            return;
        }
        Logger.d(TAG, "reset() called");
        try {
            this.mDecoder.reset();
            decoderConfigure(this.mMediaFormat);
            start();
        } catch (Exception e16) {
            Logger.e(TAG, "reset: ", e16);
        }
    }

    @RequiresApi(api = 21)
    private boolean retryOnReadSampleError(MediaCodec.CodecException codecException) {
        if (codecException.isRecoverable()) {
            releaseOutputBuffer();
            reset();
            this.mLastOutputBufferIndex = -1;
            this.mPendingFrames.clear();
            this.mExtractor.seekTo(this.mCurrentStartTime.getTimeUs() - this.mTimeRange.getStartUs(), 0);
            this.mExtractorDone = false;
        } else if (codecException.isTransient()) {
            Logger.e(TAG, "decoder status error. please retry next time.");
        } else {
            Logger.e(TAG, "doReadSample:[error] retry failed");
            return true;
        }
        return false;
    }

    private synchronized void seekExtractorTo(long j3) {
        this.mExtractor.seekTo(j3, 2);
        if (this.mExtractor.getSampleTime() > j3) {
            this.mExtractor.seekTo(j3, 0);
        }
        clearDecoder();
        this.mTimeOffset = this.mLastVideoQueueTime + 10000000;
    }

    private synchronized void waitTime(long j3) {
        try {
            wait(j3);
        } catch (InterruptedException e16) {
            e16.printStackTrace();
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        release(false);
    }

    public AudioInfo getAudioInfo() {
        return this.mDecodeAudioInfo;
    }

    @Override // com.tencent.tav.decoder.IDecoder
    public String getSourcePath() {
        return this.mExtractor.getSourcePath();
    }

    @Override // com.tencent.tav.decoder.IDecoder
    public synchronized boolean hasTrack() {
        boolean z16;
        if (this.mTrackIndex != -1) {
            z16 = true;
        } else {
            z16 = false;
        }
        return z16;
    }

    public boolean isStarted() {
        return this.mStarted;
    }

    public CMTime nextFrameTime() {
        CMTime cMTime;
        if (this.mPendingFrames.size() > 0) {
            cMTime = this.mPendingFrames.get(0).frameTime;
        } else {
            cMTime = CMTime.CMTimeInvalid;
        }
        Iterator<PendingFrame> it = this.mPendingFrames.iterator();
        while (it.hasNext()) {
            cMTime = CMTime.min(it.next().frameTime, cMTime);
        }
        return cMTime;
    }

    @Override // com.tencent.tav.decoder.IAudioDecoder
    public synchronized ByteBuffer outputBuffer() {
        ByteBuffer byteBuffer = this.mDecodeBuffer;
        if (byteBuffer == null) {
            return null;
        }
        ByteBuffer byteBuffer2 = this.mOutputBuffer;
        if (byteBuffer2 == null) {
            return byteBuffer;
        }
        return byteBuffer2;
    }

    @Override // com.tencent.tav.decoder.IDecoder
    public synchronized CMSampleState readSample(CMTime cMTime) {
        CMSampleState doReadSample;
        Logger.v(TAG, "readSample: " + cMTime + "  -  " + this.mExtractor.getSampleTime());
        doReadSample = doReadSample(cMTime, false);
        this.mCurrentSampleState = doReadSample;
        if (doReadSample.stateMatchingTo(-1, -4) || !this.mCurrentSampleState.getTime().smallThan(this.mDuration)) {
            clearDecoder();
        }
        Logger.v(TAG, "readSample: finish " + cMTime + "  -  " + this.mCurrentSampleState);
        return doReadSample;
    }

    @Override // com.tencent.tav.decoder.IAudioDecoder
    public synchronized void release() {
        release(true);
    }

    @Override // com.tencent.tav.decoder.IDecoder
    public synchronized void seekTo(CMTime cMTime) {
        Logger.v(TAG, "seekTo: " + cMTime + "  - " + this + "  " + this.mCurrentStartTime + "  " + this.mCurrentSampleState);
        if (this.mStarted && this.mTrackIndex != -1) {
            if (cMTime.getTimeUs() < 0) {
                cMTime = CMTime.CMTimeZero;
            }
            CMTime add = this.mTimeRange.getStart().add(cMTime);
            this.mCurrentStartTime = add;
            this.mExtractorDone = false;
            seekExtractorTo(add.getTimeUs());
            Logger.v(TAG, "seekTo: finish - " + this.mCurrentStartTime + "  " + this.mExtractor.getSampleTime());
            return;
        }
        Logger.e(TAG, "seekTo:failed [started " + this.mStarted + "] [trackIndex " + this.mTrackIndex + "]");
    }

    @Override // com.tencent.tav.decoder.IDecoder
    public synchronized void start(CMTimeRange cMTimeRange) {
        start(cMTimeRange, CMTime.CMTimeZero);
    }

    public WinkAudioDecoder(@NonNull String str) throws Exception {
        CMTime cMTime = CMTime.CMTimeZero;
        this.mDuration = cMTime;
        this.mStarted = false;
        this.mPendingFrames = new ArrayList<>();
        this.mTrackIndex = -1;
        this.mIsReleased = false;
        this.mCurrentSampleState = new CMSampleState(cMTime);
        this.mDecodeAudioInfo = new AudioInfo();
        this.mDecodeBuffer = null;
        this.mOutputBuffer = null;
        this.mLastOutputBufferIndex = -1;
        this.mCurrentStartTime = CMTime.CMTimeInvalid;
        this.mBufferInfo = new MediaCodec.BufferInfo();
        this.mExtractorDone = false;
        this.mTimeOffset = 0L;
        this.mLastVideoQueueTime = 0L;
        IExtractor createExtractor = AVExtractorFactory.getInstance().createExtractor();
        this.mExtractor = createExtractor;
        createExtractor.setDataSource(str);
        while (this.mExtractor.getSampleTrackIndex() != -1) {
            IExtractor iExtractor = this.mExtractor;
            iExtractor.unselectTrack(iExtractor.getSampleTrackIndex());
        }
        int firstTrackIndex = this.mExtractor.getFirstTrackIndex("audio/");
        this.mTrackIndex = firstTrackIndex;
        if (firstTrackIndex == -1) {
            this.mDecodeBuffer = null;
            return;
        }
        this.mExtractor.selectTrack(firstTrackIndex);
        this.mMediaFormat = this.mExtractor.getTrackFormat(this.mTrackIndex);
        this.mDuration = new CMTime((((float) this.mExtractor.getMediaDuration("audio/")) * 1.0f) / ((float) TimeUnit.SECONDS.toMicros(1L)));
        MediaCodec createDecoder = MediaCodecManager.createDecoder(this.mMediaFormat);
        this.mDecoder = createDecoder;
        nameList.add(createDecoder.toString());
        if (decoderConfigure(this.mMediaFormat)) {
            start();
            this.mDecodeAudioInfo.sampleRate = this.mMediaFormat.getInteger("sample-rate");
            this.mDecodeAudioInfo.channelCount = this.mMediaFormat.getInteger("channel-count");
            return;
        }
        throw new IllegalStateException("decoderConfigure failed!");
    }

    public synchronized void release(boolean z16) {
        if (this.mIsReleased) {
            return;
        }
        Logger.d(TAG, "release:start " + z16);
        if (z16) {
            this.mExtractor.release();
            this.mExtractor = null;
        }
        this.mStarted = false;
        this.mIsReleased = true;
        if (this.mDecoder != null) {
            ThreadPool.execute(new Runnable() { // from class: com.tencent.tav.decoder.WinkAudioDecoder.1
                @Override // java.lang.Runnable
                public void run() {
                    WinkAudioDecoder.this.releaseOutputBuffer();
                    try {
                        try {
                            WinkAudioDecoder.this.mDecoder.stop();
                            MediaCodecManager.releaseCodec(WinkAudioDecoder.this.mDecoder);
                            WinkAudioDecoder.nameList.remove(WinkAudioDecoder.this.mDecoder.toString());
                        } catch (Exception e16) {
                            Logger.e(WinkAudioDecoder.TAG, "release: ", e16);
                        }
                    } finally {
                        WinkAudioDecoder.this.mDecoder = null;
                    }
                }
            });
        }
        Logger.d(TAG, "release:end " + z16);
    }

    @Override // com.tencent.tav.decoder.IDecoder
    public synchronized void start(CMTimeRange cMTimeRange, CMTime cMTime) {
        Logger.d(TAG, "start:" + getSourcePath() + " [timeRange " + cMTimeRange + "] [start " + cMTime + "]");
        if (this.mTrackIndex == -1) {
            Logger.e(TAG, "start: trackIndex == -1");
            return;
        }
        clearDecoder();
        if (cMTimeRange == null) {
            this.mTimeRange = new CMTimeRange(CMTime.CMTimeZero, this.mDuration);
        } else {
            this.mTimeRange = new CMTimeRange(cMTimeRange.getStart(), cMTimeRange.getDuration());
        }
        this.mExtractorDone = false;
        this.mStarted = true;
        if (cMTime.getTimeUs() >= 0) {
            seekTo(cMTime);
        }
    }

    private synchronized void releaseOutputBuffer(int i3, boolean z16) {
        try {
            this.mDecoder.releaseOutputBuffer(i3, z16);
        } catch (Error | Exception e16) {
            Logger.e(TAG, "releaseOutputBuffer", e16);
            if (e16 instanceof MediaCodec.CodecException) {
                Logger.e(TAG, "CodecException - isTransient = " + ((MediaCodec.CodecException) e16).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException) e16).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException) e16).getErrorCode());
                if (((MediaCodec.CodecException) e16).isTransient()) {
                    waitTime(2L);
                    releaseOutputBuffer(i3, z16);
                }
            }
            throw e16;
        }
    }

    private synchronized void start() {
        try {
            this.mDecoder.start();
        } catch (Exception e16) {
            Logger.e(TAG, "start", e16);
            if (e16 instanceof MediaCodec.CodecException) {
                Logger.e(TAG, "CodecException - isTransient = " + ((MediaCodec.CodecException) e16).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException) e16).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException) e16).getErrorCode());
                if (((MediaCodec.CodecException) e16).isTransient()) {
                    waitTime(2L);
                    start();
                    return;
                } else if (((MediaCodec.CodecException) e16).isRecoverable()) {
                    reset();
                    return;
                }
            }
            release();
            throw e16;
        }
    }
}
