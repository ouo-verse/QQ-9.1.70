package com.tencent.tav.decoder;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.text.TextUtils;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.IVideoDecoder;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.extractor.AssetExtractor;
import com.tencent.tav.extractor.ExtractorUtils;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes26.dex */
public class AudioDecoder implements IAudioDecoder {
    private static final int MAX_RETRY_COUNT = 10;
    private static final int MAX_WAIT_TIME = 1000;
    private static final long WAIT_TRANSIENT_MS = 2;
    private static final ArrayList<String> nameList = new ArrayList<>();
    private final String TAG;
    private MediaCodec.BufferInfo bufferInfo;
    private CMSampleState currentSampleState;
    private CMTime currentStartTime;
    private AudioInfo decodeAudioInfo;
    private ByteBuffer decodeBuffer;
    private MediaCodec decoder;
    private CMTime duration;
    private AssetExtractor extractor;
    private boolean extractorDone;
    private boolean isReleased;
    private int lastOutputBufferIndex;
    private long mLastVideoQueueTime;
    private long mTimeOffset;
    private MediaFormat mediaFormat;

    @Nullable
    private AudioInfo outputAudioInfo;
    private ByteBuffer outputBuffer;
    private CMTime pFrameTime;
    private ArrayList<PendingFrame> pendingFrames;
    private boolean started;
    private CMTimeRange timeRange;
    public int trackIndex;

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

    public AudioDecoder(IVideoDecoder.Params params) throws Exception {
        this(params.filePath);
    }

    private void clearDecoder() {
        Logger.v(this.TAG, "clearDecoder " + getSourcePath());
        releaseOutputBuffer();
        if (this.pendingFrames.size() != 0 || this.extractorDone) {
            try {
                this.decoder.flush();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            this.pendingFrames.clear();
        }
        this.currentSampleState = new CMSampleState();
    }

    private synchronized boolean decoderConfigure(MediaFormat mediaFormat) {
        Logger.i(this.TAG, "decoderConfigure() called with: inputFormat = [" + mediaFormat + "]");
        int i3 = 0;
        while (true) {
            i3++;
            try {
                Logger.d(this.TAG, "createdDecoder---time---" + i3);
                if (i3 > 10) {
                    return false;
                }
                this.decoder.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 0);
                Logger.i(this.TAG, "decoderConfigure() called with: outputFormat = [" + this.decoder.getOutputFormat() + "]");
                return true;
            } catch (Exception e16) {
                Logger.e(this.TAG, "decoderConfigure: ", e16);
                if (!(e16 instanceof MediaCodec.CodecException) || (!((MediaCodec.CodecException) e16).isTransient() && !((MediaCodec.CodecException) e16).isRecoverable())) {
                    MediaCodecManager.releaseCodec(this.decoder);
                    throw e16;
                }
            }
        }
    }

    private synchronized int dequeueInputBuffer() {
        try {
            return this.decoder.dequeueInputBuffer(1000L);
        } catch (Error | Exception e16) {
            Logger.e(this.TAG, "dequeueInputBuffer", e16);
            if (e16 instanceof MediaCodec.CodecException) {
                Logger.e(this.TAG, "CodecException - isTransient = " + ((MediaCodec.CodecException) e16).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException) e16).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException) e16).getErrorCode());
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
            Logger.e(this.TAG, "dequeueOutputBuffer", e16);
            if (e16 instanceof MediaCodec.CodecException) {
                Logger.e(this.TAG, "CodecException - isTransient = " + ((MediaCodec.CodecException) e16).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException) e16).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException) e16).getErrorCode());
                if (((MediaCodec.CodecException) e16).isTransient()) {
                    waitTime(2L);
                    return dequeueOutputBuffer();
                }
            }
            throw e16;
        }
        return this.decoder.dequeueOutputBuffer(this.bufferInfo, 1000L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x01d0, code lost:
    
        com.tencent.tav.decoder.logger.Logger.v(r18.TAG, "doReadSample:[success] " + r18.extractorDone + " " + r7 + "  " + r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x01fd, code lost:
    
        if (r18.extractorDone == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0203, code lost:
    
        if (r7 >= 0) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0205, code lost:
    
        r0 = com.tencent.tav.coremedia.CMSampleState.fromError(-1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x020c, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized CMSampleState doReadSample(CMTime cMTime, boolean z16) {
        boolean z17;
        Logger.v(this.TAG, "doReadSample - " + this.extractor.getSourcePath());
        CMSampleState fromError = CMSampleState.fromError(-2L);
        boolean z18 = false;
        if (this.started && this.trackIndex != -1) {
            releaseOutputBuffer();
            long j3 = -2;
            int i3 = 0;
            while (true) {
                if (this.pendingFrames.size() <= 0 && this.extractorDone) {
                    break;
                }
                try {
                    if (!this.extractorDone) {
                        readFromExtractor();
                    }
                    int dequeueOutputBuffer = dequeueOutputBuffer();
                    if (dequeueOutputBuffer == -2) {
                        MediaFormat outputFormat = this.decoder.getOutputFormat();
                        if (outputFormat.containsKey("pcm-encoding")) {
                            this.decodeAudioInfo.pcmEncoding = outputFormat.getInteger("pcm-encoding");
                        } else {
                            Logger.w(this.TAG, "doReadSample: decodedAudioFormat.containsKey(\"pcm-encoding\") is false");
                            this.decodeAudioInfo.pcmEncoding = 2;
                        }
                        if (outputFormat.containsKey("sample-rate")) {
                            this.decodeAudioInfo.sampleRate = outputFormat.getInteger("sample-rate");
                        }
                        if (outputFormat.containsKey("channel-count")) {
                            this.decodeAudioInfo.channelCount = outputFormat.getInteger("channel-count");
                        }
                    } else if (dequeueOutputBuffer >= 0 && this.pendingFrames.size() > 0) {
                        MediaCodec.BufferInfo bufferInfo = this.bufferInfo;
                        if (bufferInfo.flags == 4) {
                            if (bufferInfo.size > 0) {
                                this.pendingFrames.remove(0);
                                this.lastOutputBufferIndex = dequeueOutputBuffer;
                                ByteBuffer outputBuffer = getOutputBuffer(dequeueOutputBuffer);
                                if (outputBuffer != null) {
                                    outputBuffer.position(this.bufferInfo.offset);
                                    MediaCodec.BufferInfo bufferInfo2 = this.bufferInfo;
                                    outputBuffer.limit(bufferInfo2.offset + bufferInfo2.size);
                                    this.decodeBuffer = outputBuffer;
                                } else {
                                    releaseOutputBuffer(dequeueOutputBuffer, false);
                                    this.decodeBuffer = null;
                                }
                            }
                            Logger.i(this.TAG, "doReadSample:[finish] bufferInfo.flags == MediaCodec.BUFFER_FLAG_END_OF_STREAM");
                            return CMSampleState.fromError(-1L);
                        }
                        PendingFrame remove = this.pendingFrames.remove(0);
                        j3 = this.bufferInfo.presentationTimeUs - remove.timeOffset;
                        CMSampleState cMSampleState = new CMSampleState(new CMTime(j3, 1000000));
                        if (this.pendingFrames.size() == 0 && this.extractorDone && remove.seekStartTime.getTimeUs() + 1000 >= this.duration.getTimeUs()) {
                            fromError = new CMSampleState(this.duration);
                        } else if (remove.seekStartTime.getTimeUs() > j3) {
                            releaseOutputBuffer(dequeueOutputBuffer, false);
                            fromError = CMSampleState.fromError(-2L);
                        } else {
                            fromError = cMSampleState;
                        }
                        if (this.bufferInfo.size > 0) {
                            this.lastOutputBufferIndex = dequeueOutputBuffer;
                            ByteBuffer outputBuffer2 = getOutputBuffer(dequeueOutputBuffer);
                            if (outputBuffer2 != null) {
                                outputBuffer2.position(this.bufferInfo.offset);
                                MediaCodec.BufferInfo bufferInfo3 = this.bufferInfo;
                                outputBuffer2.limit(bufferInfo3.offset + bufferInfo3.size);
                                this.decodeBuffer = outputBuffer2;
                            } else {
                                releaseOutputBuffer(dequeueOutputBuffer, false);
                                Logger.e(this.TAG, "doReadSample:[error] " + this.bufferInfo.size + " byteBuffer==null");
                                return CMSampleState.fromError(-3L);
                            }
                        } else {
                            releaseOutputBuffer(dequeueOutputBuffer, false);
                            fromError = CMSampleState.fromError(-2L);
                        }
                    } else {
                        if (dequeueOutputBuffer >= 0) {
                            if (this.bufferInfo.flags == 4) {
                                Logger.i(this.TAG, "doReadSample:[finish] bufferInfo.flags == MediaCodec.BUFFER_FLAG_END_OF_STREAM 2");
                                return CMSampleState.fromError(-1L);
                            }
                            releaseOutputBuffer(dequeueOutputBuffer, false);
                            fromError = CMSampleState.fromError(-2L);
                        }
                        i3++;
                        if (i3 > 1000) {
                            fromError = CMSampleState.fromError(-4L);
                            Logger.e(this.TAG, "doReadSample: [timeout] ");
                            break;
                        }
                    }
                } catch (Exception e16) {
                    Logger.e(this.TAG, "doReadSample: error", e16);
                    if ((e16 instanceof MediaCodec.CodecException) && retryOnReadSampleError((MediaCodec.CodecException) e16)) {
                        return CMSampleState.fromError(-3L, "catch exception, retry", e16);
                    }
                    return CMSampleState.fromError(-3L, "catch exception", e16);
                }
            }
        }
        String str = this.TAG;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("doReadSample:[failed] !started || trackIndex == -1 ");
        if (!this.started) {
            z17 = true;
        } else {
            z17 = false;
        }
        sb5.append(z17);
        sb5.append(" - ");
        if (this.trackIndex == -1) {
            z18 = true;
        }
        sb5.append(z18);
        Logger.e(str, sb5.toString());
        return CMSampleState.fromError(-100L);
    }

    private synchronized ByteBuffer getInputBuffer(int i3) {
        try {
            return DecoderUtils.getInputBuffer(this.decoder, i3);
        } catch (Error | Exception e16) {
            Logger.e(this.TAG, "getInputBuffer", e16);
            if (e16 instanceof MediaCodec.CodecException) {
                Logger.e(this.TAG, "CodecException - isTransient = " + ((MediaCodec.CodecException) e16).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException) e16).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException) e16).getErrorCode());
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
            return DecoderUtils.getOutputBuffer(this.decoder, i3);
        } catch (Error | Exception e16) {
            Logger.e(this.TAG, "getOutputBuffer", e16);
            if (e16 instanceof MediaCodec.CodecException) {
                Logger.e(this.TAG, "CodecException - isTransient = " + ((MediaCodec.CodecException) e16).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException) e16).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException) e16).getErrorCode());
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
            this.decoder.queueInputBuffer(i3, i16, i17, j3, i18);
        } catch (Error | Exception e16) {
            Logger.e(this.TAG, "queueInputBuffer", e16);
            if (e16 instanceof MediaCodec.CodecException) {
                Logger.e(this.TAG, "CodecException - isTransient = " + ((MediaCodec.CodecException) e16).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException) e16).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException) e16).getErrorCode());
                if (((MediaCodec.CodecException) e16).isTransient()) {
                    waitTime(2L);
                    queueInputBuffer(i3, i16, i17, j3, i18);
                }
            }
            throw e16;
        }
    }

    private synchronized void readFromExtractor() {
        long sampleTime = this.extractor.getSampleTime();
        if (sampleTime < this.timeRange.getEndUs() && this.extractor.getSampleTrackIndex() != -1 && sampleTime != -1) {
            int dequeueInputBuffer = dequeueInputBuffer();
            if (dequeueInputBuffer >= 0) {
                int readSampleData = this.extractor.readSampleData(getInputBuffer(dequeueInputBuffer), 0);
                if (readSampleData >= 0) {
                    long startUs = (sampleTime - this.timeRange.getStartUs()) + this.mTimeOffset;
                    this.mLastVideoQueueTime = startUs;
                    queueInputBuffer(dequeueInputBuffer, 0, readSampleData, startUs, 0);
                    PendingFrame pendingFrame = new PendingFrame();
                    pendingFrame.timeOffset = this.mTimeOffset;
                    pendingFrame.frameTime = new CMTime((((float) sampleTime) * 1.0f) / ((float) TimeUnit.SECONDS.toMicros(1L)));
                    pendingFrame.seekStartTime = this.currentStartTime.sub(this.timeRange.getStart());
                    if (this.pendingFrames.size() == 0) {
                        pendingFrame.isFirst = true;
                    }
                    this.pendingFrames.add(pendingFrame);
                }
                this.extractor.advance();
            }
        }
        int dequeueInputBuffer2 = dequeueInputBuffer();
        if (dequeueInputBuffer2 >= 0) {
            queueInputBuffer(dequeueInputBuffer2, 0, 0, 0L, 4);
            this.extractorDone = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void releaseOutputBuffer() {
        int i3 = this.lastOutputBufferIndex;
        if (i3 != -1) {
            try {
                releaseOutputBuffer(i3, false);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            this.lastOutputBufferIndex = -1;
        }
        this.decodeBuffer = null;
    }

    private synchronized void reset() {
        if (this.isReleased) {
            return;
        }
        Logger.d(this.TAG, "reset() called");
        try {
            this.decoder.reset();
            decoderConfigure(this.mediaFormat);
            start();
        } catch (Exception e16) {
            Logger.e(this.TAG, "reset: ", e16);
        }
    }

    @RequiresApi(api = 21)
    private boolean retryOnReadSampleError(MediaCodec.CodecException codecException) {
        if (codecException.isRecoverable()) {
            releaseOutputBuffer();
            reset();
            this.lastOutputBufferIndex = -1;
            this.pendingFrames.clear();
            this.extractor.seekTo(this.currentStartTime.getTimeUs() - this.timeRange.getStartUs(), 0);
            this.extractorDone = false;
        } else if (!codecException.isTransient()) {
            Logger.e(this.TAG, "doReadSample:[error] retry failed");
            return true;
        }
        return false;
    }

    private synchronized void seekExtractorTo(long j3) {
        this.extractor.seekTo(j3, 2);
        if (this.extractor.getSampleTime() > j3) {
            this.extractor.seekTo(j3, 0);
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
        AudioInfo audioInfo = this.outputAudioInfo;
        if (audioInfo != null) {
            return audioInfo;
        }
        return this.decodeAudioInfo;
    }

    @Override // com.tencent.tav.decoder.IDecoder
    public String getSourcePath() {
        AssetExtractor assetExtractor = this.extractor;
        if (assetExtractor == null) {
            return null;
        }
        return assetExtractor.getSourcePath();
    }

    @Override // com.tencent.tav.decoder.IDecoder
    public synchronized boolean hasTrack() {
        boolean z16;
        if (this.trackIndex != -1) {
            z16 = true;
        } else {
            z16 = false;
        }
        return z16;
    }

    public boolean isStarted() {
        return this.started;
    }

    public CMTime nextFrameTime() {
        CMTime cMTime;
        if (this.pendingFrames.size() > 0) {
            cMTime = this.pendingFrames.get(0).frameTime;
        } else {
            cMTime = CMTime.CMTimeInvalid;
        }
        Iterator<PendingFrame> it = this.pendingFrames.iterator();
        while (it.hasNext()) {
            cMTime = CMTime.min(it.next().frameTime, cMTime);
        }
        return cMTime;
    }

    @Override // com.tencent.tav.decoder.IAudioDecoder
    public synchronized ByteBuffer outputBuffer() {
        ByteBuffer byteBuffer = this.decodeBuffer;
        if (byteBuffer == null) {
            return null;
        }
        ByteBuffer byteBuffer2 = this.outputBuffer;
        if (byteBuffer2 == null) {
            return byteBuffer;
        }
        return byteBuffer2;
    }

    @Override // com.tencent.tav.decoder.IDecoder
    public synchronized CMSampleState readSample(CMTime cMTime) {
        CMSampleState doReadSample;
        Logger.v(this.TAG, "readSample: " + cMTime + "  -  " + this.extractor.getSampleTime());
        doReadSample = doReadSample(cMTime, false);
        this.currentSampleState = doReadSample;
        if (doReadSample.stateMatchingTo(-1, -4) || !this.currentSampleState.getTime().smallThan(this.duration)) {
            clearDecoder();
        }
        Logger.v(this.TAG, "readSample: finish " + cMTime + "  -  " + this.currentSampleState);
        return doReadSample;
    }

    @Override // com.tencent.tav.decoder.IAudioDecoder
    public synchronized void release() {
        release(true);
    }

    @Override // com.tencent.tav.decoder.IDecoder
    public synchronized void seekTo(CMTime cMTime) {
        Logger.v(this.TAG, "seekTo: " + cMTime + "  - " + this + "  " + this.currentStartTime + "  " + this.currentSampleState);
        if (this.started && this.trackIndex != -1) {
            if (cMTime.getTimeUs() < 0) {
                cMTime = CMTime.CMTimeZero;
            }
            CMTime add = this.timeRange.getStart().add(cMTime);
            this.currentStartTime = add;
            this.extractorDone = false;
            seekExtractorTo(add.getTimeUs());
            Logger.v(this.TAG, "seekTo: finish - " + this.currentStartTime + "  " + this.extractor.getSampleTime());
            return;
        }
        Logger.e(this.TAG, "seekTo:failed [started " + this.started + "] [trackIndex " + this.trackIndex + "]");
    }

    @Override // com.tencent.tav.decoder.IDecoder
    public synchronized void start(CMTimeRange cMTimeRange) {
        start(cMTimeRange, CMTime.CMTimeZero);
    }

    public AudioDecoder(String str) throws Exception {
        this.TAG = "AudioDecoder@" + Integer.toHexString(hashCode());
        CMTime cMTime = CMTime.CMTimeZero;
        this.duration = cMTime;
        this.started = false;
        this.pendingFrames = new ArrayList<>();
        this.trackIndex = -1;
        this.isReleased = false;
        this.currentSampleState = new CMSampleState(cMTime);
        this.decodeAudioInfo = new AudioInfo();
        this.outputAudioInfo = null;
        this.decodeBuffer = null;
        this.outputBuffer = null;
        this.pFrameTime = new CMTime(20L, 600);
        this.lastOutputBufferIndex = -1;
        this.currentStartTime = CMTime.CMTimeInvalid;
        this.bufferInfo = new MediaCodec.BufferInfo();
        this.extractorDone = false;
        this.mTimeOffset = 0L;
        this.mLastVideoQueueTime = 0L;
        if (!TextUtils.isEmpty(str)) {
            AssetExtractor assetExtractor = new AssetExtractor();
            this.extractor = assetExtractor;
            assetExtractor.setDataSource(str);
            while (this.extractor.getSampleTrackIndex() != -1) {
                AssetExtractor assetExtractor2 = this.extractor;
                assetExtractor2.unselectTrack(assetExtractor2.getSampleTrackIndex());
            }
            int firstTrackIndex = ExtractorUtils.getFirstTrackIndex(this.extractor, "audio/");
            this.trackIndex = firstTrackIndex;
            if (firstTrackIndex == -1) {
                this.decodeBuffer = null;
                return;
            }
            this.extractor.selectTrack(firstTrackIndex);
            this.mediaFormat = this.extractor.getTrackFormat(this.trackIndex);
            this.duration = new CMTime((((float) this.extractor.getAudioDuration()) * 1.0f) / ((float) TimeUnit.SECONDS.toMicros(1L)));
            if (this.mediaFormat.containsKey("frame-rate")) {
                this.pFrameTime = new CMTime(600 / this.mediaFormat.getInteger("frame-rate"), 600);
            }
            MediaCodec createDecoder = MediaCodecManager.createDecoder(this.mediaFormat);
            this.decoder = createDecoder;
            nameList.add(createDecoder.toString());
            if (decoderConfigure(this.mediaFormat)) {
                start();
                this.decodeAudioInfo.sampleRate = this.mediaFormat.getInteger("sample-rate");
                this.decodeAudioInfo.channelCount = this.mediaFormat.getInteger("channel-count");
                AudioInfo audioInfo = new AudioInfo();
                audioInfo.channelCount = 1;
                audioInfo.sampleRate = 44100;
                audioInfo.pcmEncoding = 2;
                return;
            }
            throw new IllegalStateException("decoderConfigure failed!");
        }
        throw new RuntimeException("sourcePath is empty: " + str);
    }

    public synchronized void release(boolean z16) {
        if (this.isReleased) {
            return;
        }
        Logger.d(this.TAG, "release:start " + z16);
        if (z16) {
            this.extractor.dispose();
            this.extractor = null;
        }
        this.started = false;
        this.isReleased = true;
        if (this.decoder != null) {
            ThreadPool.execute(new Runnable() { // from class: com.tencent.tav.decoder.AudioDecoder.1
                @Override // java.lang.Runnable
                public void run() {
                    AudioDecoder.this.releaseOutputBuffer();
                    try {
                        try {
                            AudioDecoder.this.decoder.stop();
                            MediaCodecManager.releaseCodec(AudioDecoder.this.decoder);
                            AudioDecoder.nameList.remove(AudioDecoder.this.decoder.toString());
                        } catch (Exception e16) {
                            Logger.e(AudioDecoder.this.TAG, "release: ", e16);
                        }
                    } finally {
                        AudioDecoder.this.decoder = null;
                    }
                }
            });
        }
        Logger.d(this.TAG, "release:end " + z16);
    }

    @Override // com.tencent.tav.decoder.IDecoder
    public synchronized void start(CMTimeRange cMTimeRange, CMTime cMTime) {
        Logger.d(this.TAG, "start:" + getSourcePath() + " [timeRange " + cMTimeRange + "] [start " + cMTime + "]");
        if (this.trackIndex == -1) {
            Logger.e(this.TAG, "start: trackIndex == -1");
            return;
        }
        clearDecoder();
        if (cMTimeRange == null) {
            this.timeRange = new CMTimeRange(CMTime.CMTimeZero, this.duration);
        } else {
            this.timeRange = new CMTimeRange(cMTimeRange.getStart(), cMTimeRange.getDuration());
        }
        this.extractorDone = false;
        this.started = true;
        if (cMTime.getTimeUs() >= 0) {
            seekTo(cMTime);
        }
    }

    private synchronized void releaseOutputBuffer(int i3, boolean z16) {
        try {
            this.decoder.releaseOutputBuffer(i3, z16);
        } catch (Error | Exception e16) {
            Logger.e(this.TAG, "releaseOutputBuffer", e16);
            if (e16 instanceof MediaCodec.CodecException) {
                Logger.e(this.TAG, "CodecException - isTransient = " + ((MediaCodec.CodecException) e16).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException) e16).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException) e16).getErrorCode());
                if (((MediaCodec.CodecException) e16).isTransient()) {
                    waitTime(2L);
                    releaseOutputBuffer(i3, z16);
                }
            }
            throw e16;
        }
    }

    private synchronized void start() throws Exception {
        try {
            this.decoder.start();
        } catch (Exception e16) {
            Logger.e(this.TAG, "start", e16);
            if (e16 instanceof MediaCodec.CodecException) {
                Logger.e(this.TAG, "CodecException - isTransient = " + ((MediaCodec.CodecException) e16).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException) e16).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException) e16).getErrorCode());
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
