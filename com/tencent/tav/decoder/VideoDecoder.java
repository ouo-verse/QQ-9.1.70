package com.tencent.tav.decoder;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.avcore.jni.codec.NativeCodec;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.IVideoDecoder;
import com.tencent.tav.decoder.VideoDecoderQuickSeekHelper;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.extractor.AssetExtractor;
import com.tencent.tav.extractor.ExtractorUtils;
import com.tencent.tav.report.ReadFrameReportSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes26.dex */
public class VideoDecoder implements IVideoDecoder {
    public static boolean FIX_DECODE_CROP_SIZE = true;
    private static final int MAX_WAIT_TIME = 1000;
    public final String TAG;
    private final MediaCodec.BufferInfo bufferInfo;
    private CMSampleState currentDecoderState;
    private CMSampleState currentStartState;
    private CMTime duration;
    private final HashMap<String, Object> extraInfo;

    @Nullable
    private AssetExtractor extractor;
    private boolean extractorDone;
    private long frameDurationUs;
    boolean isReleased;
    boolean lastFrameValid;
    private int lastOutputBufferIndex;
    private long mLastVideoQueueTime;
    private long mTimeOffset;
    private final MediaCodecWrapper mediaCodecWrapper;
    private MediaFormat mediaFormat;

    @Nullable
    private AssetExtractor mirrorExtractor;
    private Surface outputSurface;
    private CMTime pFrameTime;

    @NonNull
    private final IVideoDecoder.Params params;
    private final ArrayList<PendingFrame> pendingFrames;
    private CMTime preReadTime;
    private boolean readSampleFinish;
    private final ReadFrameReportSession reportSession;
    private VideoDecoderQuickSeekHelper seekHelper;
    private final String sourcePath;
    private boolean started;
    private CMTimeRange timeRange;
    private int trackIndex;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class PendingFrame {
        private CMTime seekStartTime;
        private long timeOffset;

        PendingFrame() {
            this.timeOffset = 0L;
            this.seekStartTime = CMTime.CMTimeZero;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class SampleTime {
        private CMSampleState sampleState;
        private long timeUs;

        SampleTime() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void fixCMTime() {
            if (!this.sampleState.getTime().smallThan(CMTime.CMTimeZero)) {
                return;
            }
            this.sampleState = new CMSampleState(CMTime.fromUs(VideoDecoder.this.frameDurationUs));
        }

        public String toString() {
            return "SampleTime{sampleState=" + this.sampleState + ", timeUs=" + this.timeUs + '}';
        }
    }

    public VideoDecoder(IVideoDecoder.Params params) throws Exception {
        String str = "VideoDecoder@" + Integer.toHexString(hashCode());
        this.TAG = str;
        this.frameDurationUs = 33333L;
        this.duration = CMTime.CMTimeZero;
        this.pFrameTime = new CMTime(20L, 600);
        this.trackIndex = -1;
        MediaCodecWrapper mediaCodecWrapper = new MediaCodecWrapper(this);
        this.mediaCodecWrapper = mediaCodecWrapper;
        this.bufferInfo = new MediaCodec.BufferInfo();
        this.currentDecoderState = new CMSampleState();
        this.preReadTime = CMTime.CMTimeInvalid;
        this.pendingFrames = new ArrayList<>();
        this.isReleased = false;
        this.started = false;
        this.lastFrameValid = false;
        this.lastOutputBufferIndex = -1;
        this.seekHelper = new VideoDecoderQuickSeekHelper.DefaultVideoDecoderQuickSeekHelper();
        this.reportSession = new ReadFrameReportSession();
        this.mTimeOffset = 10000000L;
        this.mLastVideoQueueTime = 0L;
        this.currentStartState = new CMSampleState();
        this.extractorDone = false;
        this.readSampleFinish = false;
        this.params = params;
        String str2 = params.filePath;
        this.sourcePath = str2;
        this.extraInfo = params.extraInfo;
        this.outputSurface = params.outputSurface;
        Logger.i(str, "VideoDecoder() called with: sourcePath = [" + str2 + "], outputSurface = [" + this.outputSurface + "]");
        if (!TextUtils.isEmpty(str2)) {
            long currentTimeMillis = System.currentTimeMillis();
            AssetExtractor initExtractor = initExtractor(str2);
            this.extractor = initExtractor;
            if (initExtractor == null) {
                return;
            }
            if (initExtractor.needMirror()) {
                createMirrorExtractor();
            }
            this.mediaFormat = this.extractor.getTrackFormat(this.trackIndex);
            this.duration = new CMTime((((float) this.extractor.getDuration()) * 1.0f) / ((float) TimeUnit.SECONDS.toMicros(1L)));
            if (this.mediaFormat.containsKey("frame-rate")) {
                int integer = this.mediaFormat.getInteger("frame-rate");
                this.pFrameTime = new CMTime(600 / integer, 600);
                this.frameDurationUs = 1000000 / integer;
            }
            if (mediaCodecWrapper.decoderConfigure(this.mediaFormat, this.outputSurface)) {
                mediaCodecWrapper.startDecoder(this.outputSurface, this.mediaFormat);
                Logger.d(str, "create VideoDecoder end " + (System.currentTimeMillis() - currentTimeMillis));
                return;
            }
            throw new IllegalStateException("decoderConfigure failed!");
        }
        throw new RuntimeException("sourcePath is empty: " + str2);
    }

    @NonNull
    private CMSampleState buildSampleStateError(Exception exc) {
        String str = "sourcePath:" + this.sourcePath;
        if (this.extraInfo != null) {
            str = str + ";decodeInfo:" + this.extraInfo.get(IDecoder.EXTRA_INFO_KEY_DECODE_INFO);
        }
        String str2 = str + ";CodecSize:" + MediaCodecManager.getCodecNames().size();
        if (this.mediaCodecWrapper.getMediaCodec() != null) {
            try {
                str2 = str2 + ";inputFormat=" + this.mediaCodecWrapper.getMediaCodec().getInputFormat().toString();
            } catch (Exception e16) {
                Logger.e(this.TAG, "buildSampleStateError: ", e16);
            }
            try {
                str2 = str2 + ";outputFormat=" + this.mediaCodecWrapper.getMediaCodec().getOutputFormat().toString();
            } catch (Exception e17) {
                Logger.e(this.TAG, "buildSampleStateError: ", e17);
            }
        }
        return CMSampleState.fromError(-3L, str2, exc);
    }

    private void clearDecoder() {
        Logger.d(this.TAG, "clearDecoder " + getSourcePath());
        releaseOutputBuffer();
        if (this.pendingFrames.size() != 0 || this.extractorDone) {
            try {
                this.mediaCodecWrapper.flushDecoder();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            this.pendingFrames.clear();
        }
        this.currentDecoderState = new CMSampleState();
    }

    private void createMirrorExtractor() {
        ThreadPool.execute(new Runnable() { // from class: com.tencent.tav.decoder.VideoDecoder.1
            @Override // java.lang.Runnable
            public void run() {
                long startUs;
                try {
                    long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
                    AssetExtractor assetExtractor = new AssetExtractor();
                    assetExtractor.setDataSource(VideoDecoder.this.sourcePath);
                    while (assetExtractor.getSampleTrackIndex() != -1) {
                        assetExtractor.unselectTrack(assetExtractor.getSampleTrackIndex());
                    }
                    assetExtractor.selectTrack(ExtractorUtils.getFirstTrackIndex(assetExtractor, "video/"));
                    if (VideoDecoder.this.timeRange == null) {
                        startUs = 0;
                    } else {
                        startUs = VideoDecoder.this.timeRange.getStartUs();
                    }
                    assetExtractor.seekTo(startUs, 0);
                    while (assetExtractor.getSampleTime() != -1) {
                        assetExtractor.advance();
                    }
                    VideoDecoder.this.mirrorExtractor = assetExtractor;
                    Logger.d(VideoDecoder.this.TAG, "Decoder: MirrorExtractor Init " + (SystemClock.currentThreadTimeMillis() - currentThreadTimeMillis));
                } catch (Exception e16) {
                    Logger.e(VideoDecoder.this.TAG, "createMirrorExtractor: ", e16);
                }
            }
        });
    }

    private void doFixCropSize() {
        MediaFormat outputFormat = this.mediaCodecWrapper.getMediaCodec().getOutputFormat();
        if (outputFormat != null && this.params.videoTexture != null) {
            if (outputFormat.containsKey("width")) {
                int integer = outputFormat.getInteger("width");
                if (outputFormat.containsKey(NativeCodec.LEFT) && outputFormat.containsKey(NativeCodec.RIGHT)) {
                    this.params.videoTexture.scaleX = (((outputFormat.getInteger(NativeCodec.RIGHT) + 1) - outputFormat.getInteger(NativeCodec.LEFT)) * 1.0f) / integer;
                }
            }
            if (outputFormat.containsKey("height")) {
                int integer2 = outputFormat.getInteger("height");
                if (outputFormat.containsKey(NativeCodec.TOP) && outputFormat.containsKey(NativeCodec.BOTTOM)) {
                    this.params.videoTexture.scaleY = (((outputFormat.getInteger(NativeCodec.BOTTOM) + 1) - outputFormat.getInteger(NativeCodec.TOP)) * 1.0f) / integer2;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x0284, code lost:
    
        r18.lastOutputBufferIndex = r6;
        r3 = r18.mediaCodecWrapper.getOnputBuffer(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x028c, code lost:
    
        if (r3 == null) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x028e, code lost:
    
        r3.position(r18.bufferInfo.offset);
        r4 = r18.bufferInfo;
        r3.limit(r4.offset + r4.size);
        r19.fixCMTime();
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x02a3, code lost:
    
        r18.mediaCodecWrapper.releaseOutputBuffer(r6, false);
        com.tencent.tav.decoder.logger.Logger.e(r18.TAG, "doReadFrames:[error] " + r18.bufferInfo.size + " byteBuffer==null");
        r19.sampleState = com.tencent.tav.coremedia.CMSampleState.fromError(-3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x02d3, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void doReadFrames(SampleTime sampleTime, CMTime cMTime, boolean z16) {
        boolean z17;
        byte b16;
        int i3;
        boolean z18;
        boolean z19;
        String str = this.TAG;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("doReadFrames() called with: sampleTime = [");
        sb5.append(sampleTime);
        sb5.append("], targetTime = [");
        CMTime cMTime2 = cMTime;
        sb5.append(cMTime2);
        sb5.append("], justCache = [");
        sb5.append(z16);
        sb5.append("]");
        Logger.v(str, sb5.toString());
        if (this.pendingFrames.size() == 0 && this.extractorDone) {
            Logger.i(this.TAG, "doReadFrames:[unRead]pendingFrames.size() == 0 && extractorDone");
        }
        boolean z26 = false;
        int i16 = 0;
        while (true) {
            if (this.pendingFrames.size() <= 0 && this.extractorDone) {
                break;
            }
            if (!this.extractorDone) {
                readFromExtractor();
            }
            long nanoTime = System.nanoTime();
            int dequeueOutputBuffer = this.mediaCodecWrapper.dequeueOutputBuffer(this.bufferInfo);
            this.reportSession.tickReadSample(System.nanoTime() - nanoTime);
            if (FIX_DECODE_CROP_SIZE) {
                tryFixCropSize();
            }
            MediaCodec.BufferInfo bufferInfo = this.bufferInfo;
            if ((bufferInfo.flags & 4) != 0) {
                if (bufferInfo.size > 0 && dequeueOutputBuffer >= 0 && this.pendingFrames.size() > 0) {
                    this.pendingFrames.remove(z26 ? 1 : 0);
                    this.mediaCodecWrapper.releaseOutputBuffer(dequeueOutputBuffer, true);
                }
                Logger.i(this.TAG, "doReadFrames:[finish] bufferInfo.flags == MediaCodec.BUFFER_FLAG_END_OF_STREAM");
                sampleTime.sampleState = CMSampleState.fromError(-1L);
                return;
            }
            if (dequeueOutputBuffer >= 0 && this.pendingFrames.size() > 0) {
                if (this.bufferInfo.size <= 0) {
                    this.mediaCodecWrapper.releaseOutputBuffer(dequeueOutputBuffer, z26);
                    Logger.e(this.TAG, "doReadFrames:[failed] bufferInfo.size == " + this.bufferInfo.size);
                    sampleTime.sampleState = CMSampleState.fromError(-2L);
                } else {
                    PendingFrame remove = this.pendingFrames.remove(z26 ? 1 : 0);
                    sampleTime.timeUs = this.bufferInfo.presentationTimeUs - remove.timeOffset;
                    sampleTime.sampleState = new CMSampleState(new CMTime((((float) sampleTime.timeUs) * 1.0f) / ((float) TimeUnit.SECONDS.toMicros(1L))));
                    if (this.pendingFrames.isEmpty() && this.extractorDone) {
                        b16 = true;
                    } else {
                        b16 = z26 ? 1 : 0;
                    }
                    if (cMTime2.getFlag() == 1) {
                        long nextFrameTime = getNextFrameTime(cMTime2);
                        if (this.outputSurface != null && this.seekHelper.isCanSkipCurDecoder(sampleTime.timeUs, nextFrameTime)) {
                            this.mediaCodecWrapper.releaseOutputBuffer(dequeueOutputBuffer, true);
                            sampleTime.sampleState = new CMSampleState(CMTime.fromUs(sampleTime.timeUs));
                            sampleTime.sampleState.setNewFrame(true);
                            sampleTime.fixCMTime();
                            return;
                        }
                        if (this.outputSurface != null && this.seekHelper.isCanQuicklyFinish(sampleTime.timeUs, nextFrameTime)) {
                            cMTime2 = this.timeRange.getStart();
                            Iterator<PendingFrame> it = this.pendingFrames.iterator();
                            while (it.hasNext()) {
                                it.next().seekStartTime = cMTime2;
                            }
                        }
                    }
                    if (b16 == false) {
                        i3 = i16;
                        if (remove.seekStartTime.getTimeUs() > sampleTime.timeUs + (this.frameDurationUs / 2)) {
                            this.mediaCodecWrapper.releaseOutputBuffer(dequeueOutputBuffer, false);
                            Logger.v(this.TAG, "doReadFrames:[failed] pendingFrame.seekStartTime.getTimeUs() > sampleTime.timeUs");
                            sampleTime.sampleState = CMSampleState.fromError(-2L);
                            i16 = i3;
                            z26 = false;
                        }
                    } else {
                        i3 = i16;
                    }
                    if (this.outputSurface == null || z16) {
                        break;
                    }
                    if (b16 != false) {
                        sampleTime.sampleState = new CMSampleState(this.duration);
                    }
                    if (cMTime2.getTimeUs() - sampleTime.sampleState.getTime().getTimeUs() <= this.frameDurationUs / 2) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (cMTime2.getTimeUs() >= this.duration.getTimeUs()) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    if (z18 || z19 || b16 == true) {
                        break;
                    }
                    this.mediaCodecWrapper.releaseOutputBuffer(dequeueOutputBuffer, false);
                    Logger.d(this.TAG, "doReadFrames:[failed] targetTime.getTimeUs() - sampleTime.cmTime.getTimeUs() == " + (cMTime2.getTimeUs() - sampleTime.sampleState.getTime().getTimeUs()) + " targetTime = " + cMTime2 + "  duration = " + this.duration + " pendingFrames.size() = " + this.pendingFrames.size() + " extractorDone = " + this.extractorDone);
                    sampleTime.sampleState = CMSampleState.fromError(-2L);
                    i16 = i3;
                    z26 = false;
                }
            } else {
                int i17 = i16;
                if (dequeueOutputBuffer >= 0) {
                    Logger.w(this.TAG, "doReadFrames:[failed] pendingFrames.size() == " + this.pendingFrames.size());
                    z17 = false;
                    this.mediaCodecWrapper.releaseOutputBuffer(dequeueOutputBuffer, false);
                    sampleTime.sampleState = CMSampleState.fromError(-2L);
                } else {
                    z17 = false;
                }
                int i18 = i17 + 1;
                if (i18 > 1000) {
                    Logger.e(this.TAG, "doReadFrames: [timeout] ");
                    sampleTime.sampleState = CMSampleState.fromError(-4L);
                    break;
                } else {
                    boolean z27 = z17;
                    i16 = i18;
                    z26 = z27;
                }
            }
        }
        if (this.extractorDone && sampleTime.timeUs < 0 && !z16) {
            Logger.i(this.TAG, "doReadFrames: extractorDone && sampleTime.timeUs < 0, sampleTime = " + sampleTime);
            sampleTime.sampleState = CMSampleState.fromError(-1L);
        }
    }

    private synchronized CMSampleState doReadSample(CMTime cMTime, boolean z16) {
        boolean z17;
        boolean z18 = true;
        if (cMTime.bigThan(this.timeRange.getDuration()) && !z16) {
            Logger.i(this.TAG, "doReadSample:[finish] targetTime.bigThan(timeRange.getDuration()) is" + cMTime.bigThan(this.timeRange.getDuration()) + "&& !justCache istrue");
            return CMSampleState.fromError(-1L);
        }
        if (this.extractorDone && this.pendingFrames.size() == 0 && this.timeRange.containsTime(cMTime) && !this.readSampleFinish) {
            Logger.w(this.TAG, "error state , and will go correct it ! ");
            seekTo(cMTime);
        }
        this.preReadTime = CMTime.CMTimeInvalid;
        if (this.started && this.trackIndex != -1) {
            releaseOutputBuffer();
            SampleTime sampleTime = new SampleTime();
            sampleTime.sampleState = CMSampleState.fromError(-2L);
            sampleTime.timeUs = -2L;
            try {
                doReadFrames(sampleTime, cMTime, z16);
                Logger.v(this.TAG, "doReadSample:[success] " + this.extractorDone + " " + sampleTime.timeUs + "  " + sampleTime.sampleState);
                return sampleTime.sampleState;
            } catch (Exception e16) {
                return onReadFramesException(e16);
            }
        }
        String str = this.TAG;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("doReadSample:[unStart]  !started || trackIndex == -1 ");
        if (!this.started) {
            z17 = true;
        } else {
            z17 = false;
        }
        sb5.append(z17);
        sb5.append(" - ");
        if (this.trackIndex != -1) {
            z18 = false;
        }
        sb5.append(z18);
        Logger.e(str, sb5.toString());
        return CMSampleState.fromError(-100L);
    }

    private long getNextFrameTime(CMTime cMTime) {
        AssetExtractor assetExtractor;
        if (this.seekHelper.isCareForSeekTime() && (assetExtractor = this.mirrorExtractor) != null) {
            assetExtractor.seekTo(cMTime.getTimeUs(), 1);
            return this.mirrorExtractor.getSampleTime();
        }
        return -1L;
    }

    private boolean hasPreReadAndFirstFrameSeek(CMTime cMTime) {
        if (cMTime == CMTime.CMTimeZero && this.preReadTime != CMTime.CMTimeInvalid && this.lastOutputBufferIndex != -1 && !this.currentDecoderState.isInvalid()) {
            return true;
        }
        return false;
    }

    private AssetExtractor initExtractor(String str) {
        Logger.d(this.TAG, "initExtractor() called with: sourcePath = [" + str + "]");
        AssetExtractor assetExtractor = new AssetExtractor();
        assetExtractor.setDataSource(str);
        while (assetExtractor.getSampleTrackIndex() != -1) {
            assetExtractor.unselectTrack(assetExtractor.getSampleTrackIndex());
        }
        int firstTrackIndex = ExtractorUtils.getFirstTrackIndex(assetExtractor, "video/");
        this.trackIndex = firstTrackIndex;
        if (firstTrackIndex == -1) {
            this.outputSurface = null;
            return null;
        }
        assetExtractor.selectTrack(firstTrackIndex);
        Logger.d(this.TAG, "initExtractor() end");
        return assetExtractor;
    }

    private boolean moreCloseCurrentThenSeek(CMTime cMTime) {
        if (this.mirrorExtractor == null) {
            return false;
        }
        long timeUs = this.currentDecoderState.getTime().getTimeUs();
        this.mirrorExtractor.seekTo(cMTime.getTimeUs(), 2);
        if (this.mirrorExtractor.getSampleTime() > cMTime.getTimeUs()) {
            this.mirrorExtractor.seekTo(cMTime.getTimeUs(), 0);
        }
        long sampleTime = this.mirrorExtractor.getSampleTime();
        if (sampleTime > timeUs || this.currentDecoderState.getTime().getTimeUs() < sampleTime || this.currentDecoderState.getTime().getTimeUs() >= cMTime.getTimeUs() + this.pFrameTime.getTimeUs() || timeUs > cMTime.getTimeUs()) {
            return false;
        }
        return true;
    }

    @NonNull
    private CMSampleState onReadFramesException(Exception exc) {
        Logger.e(this.TAG, "onReadFramesException: ", exc);
        this.reportSession.onDecodeError();
        if (!(exc instanceof MediaCodec.CodecException)) {
            return buildSampleStateError(exc);
        }
        MediaCodec.CodecException codecException = (MediaCodec.CodecException) exc;
        if (codecException.isRecoverable()) {
            releaseOutputBuffer();
            this.mediaCodecWrapper.reset(this.outputSurface, this.mediaFormat);
            this.lastOutputBufferIndex = -1;
            this.pendingFrames.clear();
            long timeUs = this.currentStartState.getTime().getTimeUs() - this.timeRange.getStartUs();
            AssetExtractor assetExtractor = this.extractor;
            if (assetExtractor != null) {
                assetExtractor.seekTo(timeUs, 0);
            } else {
                Logger.e(this.TAG, "onReadFramesException: extractor is null", new RuntimeException("\u5806\u6808"));
            }
            this.extractorDone = false;
            return CMSampleState.fromError(-3L);
        }
        if (codecException.isTransient()) {
            Logger.e(this.TAG, "doReadSample:[error] isTransient() is true");
        }
        Logger.e(this.TAG, "doReadSample:[error] retry failed");
        return buildSampleStateError(exc);
    }

    private synchronized void preReadSample() {
        this.lastFrameValid = false;
        CMSampleState doReadSample = doReadSample(CMTime.CMTimeInvalid, true);
        this.currentDecoderState = doReadSample;
        if (!doReadSample.getTime().smallThan(CMTime.CMTimeZero)) {
            this.currentDecoderState = this.currentStartState;
        }
        this.preReadTime = this.currentDecoderState.getTime();
        Logger.i(this.TAG, "preReadSample: " + getSourcePath() + " preReadTime = " + this.preReadTime + ", lastOutputBufferIndex = " + this.lastOutputBufferIndex);
    }

    private synchronized void readFromExtractor() {
        AssetExtractor assetExtractor = this.extractor;
        if (assetExtractor == null) {
            Logger.e(this.TAG, "readFromExtractor: extractor is null", new RuntimeException("\u5806\u6808"));
            return;
        }
        long sampleTime = assetExtractor.getSampleTime();
        if (sampleTime < this.timeRange.getEndUs() && this.extractor.getSampleTrackIndex() != -1 && sampleTime != -1) {
            readSampleData();
        }
        if (sampleTime >= this.timeRange.getEndUs()) {
            readSampleData();
        }
        int dequeueInputBuffer = this.mediaCodecWrapper.dequeueInputBuffer();
        if (dequeueInputBuffer >= 0) {
            this.mediaCodecWrapper.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
            this.extractorDone = true;
        }
    }

    private void readSampleData() {
        AssetExtractor assetExtractor = this.extractor;
        if (assetExtractor == null) {
            Logger.e(this.TAG, "readSampleData: extractor is null", new RuntimeException("\u5806\u6808"));
            return;
        }
        long sampleTime = assetExtractor.getSampleTime();
        int dequeueInputBuffer = this.mediaCodecWrapper.dequeueInputBuffer();
        if (dequeueInputBuffer >= 0) {
            int readSampleData = this.extractor.readSampleData(this.mediaCodecWrapper.getInputBuffer(dequeueInputBuffer), 0);
            if (readSampleData >= 0) {
                long startUs = (sampleTime - this.timeRange.getStartUs()) + this.mTimeOffset;
                this.mLastVideoQueueTime = startUs;
                this.mediaCodecWrapper.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, startUs, 0);
                PendingFrame pendingFrame = new PendingFrame();
                pendingFrame.timeOffset = this.mTimeOffset;
                pendingFrame.seekStartTime = this.currentStartState.getTime();
                this.pendingFrames.add(pendingFrame);
            }
            this.extractor.advance();
        }
    }

    private CMSampleState renderCacheBuffer() {
        Logger.v(this.TAG, "renderCacheBuffer: cache hit - " + this.currentDecoderState);
        try {
            this.mediaCodecWrapper.releaseOutputBuffer(this.lastOutputBufferIndex, true);
            this.lastOutputBufferIndex = -1;
            if (this.currentDecoderState.getTime().bigThan(this.timeRange.getEnd())) {
                this.currentDecoderState = CMSampleState.fromError(-1L);
                this.pendingFrames.clear();
                this.extractorDone = true;
            }
            return this.currentDecoderState;
        } catch (Exception e16) {
            Logger.e(this.TAG, "renderCacheBuffer: ", e16);
            return CMSampleState.fromError(-2L, "sourcePath:" + this.sourcePath, e16);
        }
    }

    private synchronized void seekExtractorTo(long j3) {
        AssetExtractor assetExtractor = this.extractor;
        if (assetExtractor == null) {
            Logger.e(this.TAG, "seekExtractorTo: extractor == null", new RuntimeException("\u5806\u6808"));
            return;
        }
        assetExtractor.seekTo(j3, 2);
        if (this.extractor.getSampleTime() > j3) {
            this.extractor.seekTo(j3, 0);
        }
        clearDecoder();
        this.mTimeOffset = this.mLastVideoQueueTime + 10000000;
    }

    private void tryFixCropSize() {
        try {
            doFixCropSize();
        } catch (Exception e16) {
            Logger.e(this.TAG, "tryFixCropSize: ", e16);
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        release(false);
    }

    public long getFrameDurationUs() {
        return this.frameDurationUs;
    }

    @Override // com.tencent.tav.decoder.IDecoder
    public String getSourcePath() {
        AssetExtractor assetExtractor = this.extractor;
        if (assetExtractor == null) {
            return null;
        }
        return assetExtractor.getSourcePath();
    }

    @Override // com.tencent.tav.decoder.IVideoDecoder
    public TextureInfo getTextureInfo() {
        return null;
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

    @Override // com.tencent.tav.decoder.IVideoDecoder
    public boolean isLastFrameValid() {
        return this.lastFrameValid;
    }

    public boolean isStarted() {
        return this.started;
    }

    @Override // com.tencent.tav.decoder.IVideoDecoder
    public synchronized Surface outputSurface() {
        return this.outputSurface;
    }

    @Override // com.tencent.tav.decoder.IDecoder
    public synchronized CMSampleState readSample(CMTime cMTime) {
        Object obj;
        boolean z16;
        boolean z17;
        CMSampleState doReadSample;
        String str = this.TAG;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("readSample: ");
        sb5.append(cMTime);
        sb5.append(", currentDecoderTime = ");
        sb5.append(this.currentDecoderState);
        sb5.append(",  extractor.getSampleTime() = ");
        AssetExtractor assetExtractor = this.extractor;
        if (assetExtractor != null) {
            obj = Long.valueOf(assetExtractor.getSampleTime());
        } else {
            obj = "null";
        }
        sb5.append(obj);
        sb5.append(", lastOutputBufferIndex = ");
        sb5.append(this.lastOutputBufferIndex);
        Logger.v(str, sb5.toString());
        this.lastFrameValid = false;
        if (outputSurface() != null && this.lastOutputBufferIndex != -1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.currentDecoderState.getTime().smallThan(cMTime) && (!this.extractorDone || !this.pendingFrames.isEmpty())) {
            z17 = false;
            if (!z16 && z17) {
                return renderCacheBuffer();
            }
            doReadSample = doReadSample(cMTime, false);
            if (this.currentDecoderState.isInvalid() && doReadSample.getTime().bigThan(this.timeRange.getDuration())) {
                this.currentDecoderState = CMSampleState.fromError(-1L);
                this.pendingFrames.clear();
                this.extractorDone = true;
                Logger.v(this.TAG, "readSample: finish " + cMTime + "  -  " + this.currentDecoderState);
                this.readSampleFinish = true;
                return this.currentDecoderState;
            }
            this.currentDecoderState = doReadSample;
            if (!doReadSample.stateMatchingTo(-1, -4) || !this.currentDecoderState.getTime().smallThan(this.duration)) {
                clearDecoder();
            }
            Logger.v(this.TAG, "readSample: finish flag = " + this.lastFrameValid + " - " + this.extractorDone + ", time = " + cMTime + "  -  " + this.currentDecoderState);
            this.seekHelper.setLastReadSampleTime(doReadSample.getTime().getTimeUs());
            return doReadSample;
        }
        z17 = true;
        if (!z16) {
        }
        doReadSample = doReadSample(cMTime, false);
        if (this.currentDecoderState.isInvalid()) {
        }
        this.currentDecoderState = doReadSample;
        if (!doReadSample.stateMatchingTo(-1, -4)) {
        }
        clearDecoder();
        Logger.v(this.TAG, "readSample: finish flag = " + this.lastFrameValid + " - " + this.extractorDone + ", time = " + cMTime + "  -  " + this.currentDecoderState);
        this.seekHelper.setLastReadSampleTime(doReadSample.getTime().getTimeUs());
        return doReadSample;
    }

    @Override // com.tencent.tav.decoder.IVideoDecoder
    public synchronized void release(boolean z16) {
        AssetExtractor assetExtractor;
        if (this.isReleased) {
            return;
        }
        Logger.i(this.TAG, "release:start " + z16);
        if (z16 && (assetExtractor = this.extractor) != null) {
            assetExtractor.dispose();
            this.extractor = null;
        }
        AssetExtractor assetExtractor2 = this.mirrorExtractor;
        if (assetExtractor2 != null) {
            assetExtractor2.dispose();
            this.mirrorExtractor = null;
        }
        this.started = false;
        this.isReleased = true;
        this.mediaCodecWrapper.release();
        this.reportSession.flush();
        Logger.i(this.TAG, "release:end " + z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void releaseOutputBuffer() {
        int i3 = this.lastOutputBufferIndex;
        if (i3 != -1) {
            try {
                this.mediaCodecWrapper.releaseOutputBuffer(i3, false);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            this.lastOutputBufferIndex = -1;
        }
    }

    @Override // com.tencent.tav.decoder.IDecoder
    public synchronized void seekTo(CMTime cMTime) {
        seekTo(cMTime, true);
    }

    public void setVideoDecoderSeekHelper(@NonNull VideoDecoderQuickSeekHelper videoDecoderQuickSeekHelper) {
        this.seekHelper = videoDecoderQuickSeekHelper;
    }

    @Override // com.tencent.tav.decoder.IDecoder
    public synchronized void start(CMTimeRange cMTimeRange) {
        start(cMTimeRange, CMTime.CMTimeZero);
    }

    @Override // com.tencent.tav.decoder.IVideoDecoder
    public synchronized void seekTo(CMTime cMTime, boolean z16) {
        Logger.v(this.TAG, "seekTo: " + cMTime + "  - " + this + "  " + this.currentStartState + "  " + this.currentDecoderState);
        if (this.started && this.trackIndex != -1) {
            CMTime cMTime2 = CMTime.CMTimeZero;
            if (cMTime.smallThan(cMTime2)) {
                cMTime = cMTime2;
            }
            CMTime add = this.timeRange.getStart().add(cMTime);
            if ((!z16 || !moreCloseCurrentThenSeek(cMTime)) && !cMTime.equalsTo(this.currentDecoderState.getTime()) && !hasPreReadAndFirstFrameSeek(cMTime)) {
                this.currentStartState = new CMSampleState(cMTime);
                seekExtractorTo(add.getTimeUs());
                this.extractorDone = false;
                String str = this.TAG;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("seekTo: finish - ");
                sb5.append(this.currentStartState);
                sb5.append("  ");
                AssetExtractor assetExtractor = this.extractor;
                sb5.append(assetExtractor != null ? Long.valueOf(assetExtractor.getSampleTime()) : "null");
                Logger.v(str, sb5.toString());
                return;
            }
            return;
        }
        Logger.e(this.TAG, "seekTo: [failed] !started || trackIndex == -1 ");
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
            seekTo(cMTime, false);
            preReadSample();
        }
    }
}
