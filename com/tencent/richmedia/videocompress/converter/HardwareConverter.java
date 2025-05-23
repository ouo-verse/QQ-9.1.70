package com.tencent.richmedia.videocompress.converter;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.media.MediaMuxer;
import android.os.Build;
import android.util.Pair;
import android.view.Surface;
import androidx.annotation.RequiresApi;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.richmedia.videocompress.VideoConverter;
import com.tencent.richmedia.videocompress.VideoConverterConfig;
import com.tencent.richmedia.videocompress.VideoConverterConstant;
import com.tencent.richmedia.videocompress.a;
import com.tencent.richmedia.videocompress.mediacodec.InputSurface;
import com.tencent.richmedia.videocompress.mediacodec.MediaCodecUtil;
import com.tencent.richmedia.videocompress.mediacodec.MediaCodecWrapper;
import com.tencent.richmedia.videocompress.mediacodec.OutputSurface;
import com.tencent.richmedia.videocompress.strategy.MediaCodecSupport;
import com.tencent.richmedia.videocompress.utils.ConvertLog;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
@RequiresApi(api = 18)
/* loaded from: classes25.dex */
public class HardwareConverter implements IHardwareConverter {
    private static final String AUDIO_PROCESS_DURATION = "audioProcessDuration";
    private static final boolean CALCULATE_DURATION = false;
    private static final int CANCEL = 1;
    private static final String DECODE_VIDEO_TO_ENCODE_DURATION = "decodeVideoToEncodeDuration";
    private static final String EXTRACTOR_VIDEO_DATA_TO_DECODER_DURATION = "extractorVideoDataToDecoderDuration";
    private static final int FAIL = 2;
    private static final int MAX_DECODE_TIME_OUT_COUNT = 20;
    private static final int MAX_SAMPLE_SIZE = 262144;
    private static final long MAX_VA_OFFSET = 0;
    private static final int OUTPUT_VIDEO_COLOR_FORMAT = 2130708361;
    private static final int SUCCESS = 0;
    private static final String TAG = "HardwareConverter";
    private static final boolean VERBOSE_MODE = false;
    private static final String VIDEO_PROCESS_DURATION = "videoProcessDuration";
    private static final String WRITE_ENCODE_VIDEO_DATA_DURATION = "writeEncodeVideoDataDuration";
    private static boolean sChangeOutputFrameRateDisabled = false;
    private boolean isInterrupted;
    private boolean mAccurateSeek;
    private MediaExtractor mAudioExtractor;
    private InputSurface mInputSurface;
    private MediaMuxer mMuxer;
    private OutputSurface mOutputSurface;
    private MediaCodecWrapper mVideoDecoder;
    private MediaCodecWrapper mVideoEncoder;
    private MediaExtractor mVideoExtractor;
    private final String originalVideoPath;
    private final VideoConverter.Processor processor;
    private String mOutPutVideoCodecMIMEType = MediaCodecSupport.AVC_CODEC_MIME;
    private int mSrcFrameRate = 0;
    private long mDurationUs = -1;
    private long mBeginTimeUs = -1;
    private long mEndTimeUs = -1;
    private long mFrameIntervalUs = 0;
    private boolean mCopyAudio = true;
    private boolean mCopyVideo = true;
    private final ConverterContext context = new ConverterContext();
    private final a durationCalculator = new a();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class ConverterContext {
        private boolean currentFrameSkipped;
        private int decodeTimeOutCount;
        private int decodedFrameCount;
        private long firstFrameTimestamp;
        private long lastAudioWriteTimestamp;
        private long lastVideoWriteTimestamp;
        private long nextEncodeFrameTimestamp;
        private MediaFormat outputAudioFormat;
        private int outputAudioTrack;
        private MediaFormat outputVideoFormat;
        private int outputVideoTrack;
        private int skippedFrameCount;

        ConverterContext() {
            this.firstFrameTimestamp = -1L;
            this.outputAudioTrack = -1;
            this.outputVideoTrack = -1;
            this.nextEncodeFrameTimestamp = 0L;
            this.skippedFrameCount = 0;
            this.decodedFrameCount = 0;
            this.currentFrameSkipped = false;
        }

        static /* synthetic */ long access$1014(ConverterContext converterContext, long j3) {
            long j16 = converterContext.nextEncodeFrameTimestamp + j3;
            converterContext.nextEncodeFrameTimestamp = j16;
            return j16;
        }

        static /* synthetic */ int access$1108(ConverterContext converterContext) {
            int i3 = converterContext.skippedFrameCount;
            converterContext.skippedFrameCount = i3 + 1;
            return i3;
        }

        static /* synthetic */ int access$808(ConverterContext converterContext) {
            int i3 = converterContext.decodeTimeOutCount;
            converterContext.decodeTimeOutCount = i3 + 1;
            return i3;
        }

        static /* synthetic */ int access$908(ConverterContext converterContext) {
            int i3 = converterContext.decodedFrameCount;
            converterContext.decodedFrameCount = i3 + 1;
            return i3;
        }
    }

    public HardwareConverter(String str, VideoConverter.Processor processor) {
        this.originalVideoPath = str;
        this.processor = processor;
    }

    private boolean addMuxerTrack() {
        boolean z16;
        boolean z17;
        if (this.mCopyAudio && this.context.outputAudioFormat == null) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (this.mCopyVideo && this.context.outputVideoFormat == null) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (!z16 || !z17) {
            return false;
        }
        if (this.mCopyAudio) {
            ConverterContext converterContext = this.context;
            converterContext.outputAudioTrack = this.mMuxer.addTrack(converterContext.outputAudioFormat);
            if (ConvertLog.isColorLevel()) {
                ConvertLog.d(TAG, 2, "muxer: adding audio track.");
            }
        }
        if (this.mCopyVideo) {
            ConverterContext converterContext2 = this.context;
            converterContext2.outputVideoTrack = this.mMuxer.addTrack(converterContext2.outputVideoFormat);
            if (ConvertLog.isColorLevel()) {
                ConvertLog.d(TAG, 2, "muxer: adding video track.");
            }
        }
        if (ConvertLog.isColorLevel()) {
            ConvertLog.d(TAG, 2, "muxer: starting");
        }
        this.mMuxer.start();
        return true;
    }

    private Pair<Integer, Exception> compressInner() {
        Pair<Integer, Exception> create;
        try {
            try {
                try {
                    this.processor.onProgress(0);
                    if (!prepareCodec(this.originalVideoPath, this.processor)) {
                        Exception exc = new Exception(VideoConverterConstant.KEY_NO_NEED_COMPRESS);
                        ConvertLog.e(TAG, 1, "Converter run error", exc);
                        Pair.create(2, exc);
                    }
                    doExtractDecodeEditEncodeMux();
                    if (this.isInterrupted) {
                        this.isInterrupted = false;
                        create = Pair.create(1, null);
                    } else {
                        this.processor.onProgress(10000);
                        create = Pair.create(0, null);
                    }
                    release();
                } catch (Exception e16) {
                    ConvertLog.e(TAG, 1, "Converter run error", e16);
                    create = Pair.create(2, e16);
                    release();
                }
                return create;
            } catch (Throwable th5) {
                try {
                    release();
                } catch (Exception e17) {
                    ConvertLog.e(TAG, 1, "release Hw Resource error", e17);
                    Pair.create(2, e17);
                }
                throw th5;
            }
        } catch (Exception e18) {
            ConvertLog.e(TAG, 1, "release Hw Resource error", e18);
            return Pair.create(2, e18);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean decodeVideoToEncode(boolean z16) throws Exception {
        boolean z17;
        boolean z18;
        boolean z19;
        MediaCodecWrapper.BufferData dequeueOutputBuffer = this.mVideoDecoder.dequeueOutputBuffer();
        if (dequeueOutputBuffer == null) {
            return z16;
        }
        MediaCodec.BufferInfo bufferInfo = dequeueOutputBuffer.info;
        int i3 = dequeueOutputBuffer.index;
        boolean z26 = false;
        if (i3 != -1) {
            this.context.decodeTimeOutCount = 0;
        }
        if (i3 == -1) {
            ConverterContext.access$808(this.context);
            if (this.context.decodeTimeOutCount <= 20) {
                return z16;
            }
            throw new Exception("TooManyDecodeTimeOut");
        }
        if (i3 == -3) {
            return z16;
        }
        if (i3 == -2) {
            return z16;
        }
        int i16 = bufferInfo.flags;
        if ((i16 & 2) != 0) {
            this.mVideoDecoder.releaseOutputBuffer(dequeueOutputBuffer.index);
            return z16;
        }
        if (this.mAccurateSeek && bufferInfo.presentationTimeUs < this.mBeginTimeUs) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (bufferInfo.size != 0 && !z17) {
            z18 = true;
        } else {
            z18 = false;
        }
        if ((i16 & 4) != 0) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (this.mFrameIntervalUs > 0) {
            ConverterContext.access$908(this.context);
            if (z19 || bufferInfo.presentationTimeUs >= this.context.nextEncodeFrameTimestamp) {
                this.context.currentFrameSkipped = false;
                long j3 = this.context.nextEncodeFrameTimestamp;
                long j16 = this.mFrameIntervalUs;
                long j17 = j3 + j16;
                long j18 = bufferInfo.presentationTimeUs;
                if (j17 < j18) {
                    this.context.nextEncodeFrameTimestamp = j18 + j16;
                } else {
                    ConverterContext.access$1014(this.context, j16);
                }
            } else {
                this.context.currentFrameSkipped = true;
                ConverterContext.access$1108(this.context);
                this.mVideoDecoder.getInnerMediaCodec().releaseOutputBuffer(i3, z26);
                if (z26) {
                    this.mOutputSurface.awaitNewImage();
                    this.mOutputSurface.drawImage();
                    this.mInputSurface.setPresentationTime(bufferInfo.presentationTimeUs * 1000);
                    this.mInputSurface.swapBuffers();
                    if (this.context.firstFrameTimestamp < 0) {
                        this.context.firstFrameTimestamp = bufferInfo.presentationTimeUs;
                    }
                }
                if (!z19) {
                    this.mVideoEncoder.getInnerMediaCodec().signalEndOfInputStream();
                    return true;
                }
                return z16;
            }
        }
        z26 = z18;
        this.mVideoDecoder.getInnerMediaCodec().releaseOutputBuffer(i3, z26);
        if (z26) {
        }
        if (!z19) {
        }
    }

    private void doExtractDecodeEditEncodeMux() throws Exception {
        ByteBuffer allocate = ByteBuffer.allocate(262144);
        boolean z16 = false;
        boolean z17 = false;
        boolean z18 = false;
        boolean z19 = false;
        boolean z26 = false;
        while (true) {
            if ((this.mCopyVideo && !z16) || (this.mCopyAudio && !z17)) {
                boolean interrupted = Thread.interrupted();
                this.isInterrupted = interrupted;
                boolean z27 = true;
                if (interrupted) {
                    ConvertLog.e(TAG, 1, "doExtractDecodeEditEncodeMux Interrupted");
                    return;
                }
                if (this.mCopyAudio && !z17 && (this.context.outputAudioFormat == null || z18)) {
                    if (this.context.outputAudioFormat != null) {
                        z17 = processAudio(allocate);
                    } else {
                        ConverterContext converterContext = this.context;
                        MediaExtractor mediaExtractor = this.mAudioExtractor;
                        converterContext.outputAudioFormat = mediaExtractor.getTrackFormat(mediaExtractor.getSampleTrackIndex());
                    }
                }
                if (this.context.lastVideoWriteTimestamp - this.context.lastAudioWriteTimestamp > 0 && !z17 && this.mCopyAudio) {
                    z27 = false;
                }
                if (this.mCopyVideo && z27 && (this.context.outputVideoFormat == null || z18)) {
                    if (!z19) {
                        z19 = extractorVideoDataToDecoder(z19);
                    }
                    if (!z26) {
                        z26 = decodeVideoToEncode(z26);
                    }
                    if (!z16 && (!this.context.currentFrameSkipped || z26)) {
                        z16 = writeEncodeVideoData();
                    }
                }
                if (!z18) {
                    z18 = addMuxerTrack();
                }
            } else {
                return;
            }
        }
    }

    private boolean extractorVideoDataToDecoder(boolean z16) {
        boolean z17;
        MediaCodecWrapper.BufferData inputBuffer;
        int sampleFlags;
        MediaCodecWrapper.BufferData inputBuffer2 = this.mVideoDecoder.getInputBuffer();
        if (inputBuffer2 != null && inputBuffer2.index != -1) {
            int readSampleData = this.mVideoExtractor.readSampleData(inputBuffer2.buffer, 0);
            long sampleTime = this.mVideoExtractor.getSampleTime();
            long j3 = this.mEndTimeUs;
            if (j3 > 0 && sampleTime >= j3) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (readSampleData >= 0) {
                MediaCodecWrapper mediaCodecWrapper = this.mVideoDecoder;
                int i3 = inputBuffer2.index;
                if (z17) {
                    sampleFlags = 4;
                } else {
                    sampleFlags = this.mVideoExtractor.getSampleFlags();
                }
                mediaCodecWrapper.queueInputBuffer(i3, readSampleData, sampleTime, sampleFlags);
            }
            boolean z18 = !this.mVideoExtractor.advance();
            if (!z17 && !z18) {
                return z18;
            }
            if (ConvertLog.isColorLevel()) {
                ConvertLog.d(TAG, 2, "video extractor: EOS, size = " + readSampleData);
            }
            int i16 = inputBuffer2.index;
            if (readSampleData >= 0 && ((inputBuffer = this.mVideoDecoder.getInputBuffer()) == null || (i16 = inputBuffer.index) == -1)) {
                if (ConvertLog.isColorLevel()) {
                    ConvertLog.d(TAG, 2, "no video decoder input buffer 1");
                }
                return true;
            }
            this.mVideoDecoder.queueInputBuffer(i16, 0, 0L, 4);
            if (!ConvertLog.isColorLevel()) {
                return true;
            }
            ConvertLog.d(TAG, 2, "videoDecoder.queueInputBuffer, MediaCodec.BUFFER_FLAG_END_OF_STREAM ");
            return true;
        }
        return z16;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long[] getVideoParam(MediaFormat mediaFormat, String str) {
        String str2;
        int parseInt;
        int integer = mediaFormat.getInteger("width");
        int integer2 = mediaFormat.getInteger("height");
        long j3 = mediaFormat.getLong("durationUs");
        int integer3 = mediaFormat.getInteger("frame-rate");
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(str);
            str2 = mediaMetadataRetriever.extractMetadata(24);
        } catch (IllegalArgumentException e16) {
            e16.printStackTrace();
            str2 = null;
        }
        String str3 = str2;
        if (str3 != null) {
            try {
                parseInt = Integer.parseInt(str3);
            } catch (NumberFormatException e17) {
                ConvertLog.e(TAG, 1, "Video rotation format error ", e17);
            }
            mediaMetadataRetriever.release();
            if (ConvertLog.isColorLevel()) {
                ConvertLog.d(TAG, 2, "Video size is ", Integer.valueOf(integer), HippyTKDListViewAdapter.X, Integer.valueOf(integer2), ", rotation: ", str3);
            }
            return new long[]{integer, integer2, parseInt, j3, integer3};
        }
        parseInt = 0;
        mediaMetadataRetriever.release();
        if (ConvertLog.isColorLevel()) {
        }
        return new long[]{integer, integer2, parseInt, j3, integer3};
    }

    private boolean isBitrateModeEnabled(int i3) {
        if (i3 == 0 && Build.VERSION.SDK_INT >= 27) {
            return false;
        }
        return true;
    }

    private boolean prepareCodec(String str, VideoConverter.Processor processor) throws IOException {
        int i3;
        int i16;
        MediaCodecInfo selectCodec = MediaCodecUtil.selectCodec(this.mOutPutVideoCodecMIMEType);
        if (selectCodec == null) {
            if (ConvertLog.isColorLevel()) {
                ConvertLog.e(TAG, 2, "Unable to find an appropriate codec for " + this.mOutPutVideoCodecMIMEType);
            }
            throw new IOException("Unable to find an appropriate codec for " + this.mOutPutVideoCodecMIMEType);
        }
        if (ConvertLog.isColorLevel()) {
            ConvertLog.d(TAG, 2, "Found video codec: " + selectCodec.getName());
        }
        MediaFormat trackFormat = this.mVideoExtractor.getTrackFormat(prepareExtractor(str));
        long[] videoParam = getVideoParam(trackFormat, str);
        int i17 = (int) videoParam[0];
        int i18 = (int) videoParam[1];
        int i19 = (int) videoParam[2];
        this.mDurationUs = videoParam[3];
        this.mSrcFrameRate = (int) videoParam[4];
        VideoConverterConfig encodeConfig = processor.getEncodeConfig(i17, i18);
        if (!encodeConfig.isNeedCompress) {
            if (ConvertLog.isColorLevel()) {
                ConvertLog.d(TAG, 2, "compressVideo error, isNeedCompress is false");
            }
            return false;
        }
        File file = new File(encodeConfig.output);
        if (file.exists()) {
            ConvertLog.i(TAG, 1, "compressVideo, output path exists, delete it, path is " + file.getAbsolutePath() + ", delete=" + file.delete());
        }
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            ConvertLog.i(TAG, 1, "compressVideo, output directory doesn't exist, path is " + file.getAbsolutePath() + ", mkdir=" + parentFile.mkdirs());
        }
        long j3 = encodeConfig.beginTime;
        if (j3 >= 0) {
            long j16 = encodeConfig.endTime;
            if (j16 > 0 && j16 - j3 >= 1000) {
                long j17 = j16 * 1000;
                this.mEndTimeUs = j17;
                long j18 = j3 * 1000;
                this.mBeginTimeUs = j18;
                this.mDurationUs = j17 - j18;
                this.mVideoExtractor.seekTo(j18, 2);
                this.mAudioExtractor.seekTo(this.mBeginTimeUs, 2);
            }
        }
        if (encodeConfig.isMute) {
            this.mCopyAudio = false;
        }
        if (!sChangeOutputFrameRateDisabled && (i3 = encodeConfig.videoFrameRate) > 0 && (i16 = this.mSrcFrameRate) > 0 && i16 > i3) {
            this.mFrameIntervalUs = (long) (1000000.0d / i3);
        }
        if (encodeConfig.accurateSeek) {
            this.mAccurateSeek = true;
        }
        if (this.mCopyVideo) {
            prepareVideoEncoder(encodeConfig, i17, i18, i19);
            OutputSurface outputSurface = new OutputSurface();
            this.mOutputSurface = outputSurface;
            this.mVideoDecoder = MediaCodecUtil.createVideoDecoder(trackFormat, outputSurface.getSurface());
        }
        MediaMuxer mediaMuxer = new MediaMuxer(encodeConfig.output, 0);
        this.mMuxer = mediaMuxer;
        if (this.mCopyVideo && encodeConfig.setRotation) {
            mediaMuxer.setOrientationHint(i19);
        }
        return true;
    }

    private int prepareExtractor(String str) throws IOException {
        MediaExtractor mediaExtractor = new MediaExtractor();
        this.mAudioExtractor = mediaExtractor;
        mediaExtractor.setDataSource(str);
        if (MediaCodecUtil.getAndSelectAudioTrackIndex(this.mAudioExtractor) < 0) {
            this.mCopyAudio = false;
        }
        MediaExtractor mediaExtractor2 = new MediaExtractor();
        this.mVideoExtractor = mediaExtractor2;
        mediaExtractor2.setDataSource(str);
        int andSelectVideoTrackIndex = MediaCodecUtil.getAndSelectVideoTrackIndex(this.mVideoExtractor);
        if (andSelectVideoTrackIndex >= 0) {
            return andSelectVideoTrackIndex;
        }
        throw new IOException("No video track found in " + str);
    }

    private void prepareVideoEncoder(VideoConverterConfig videoConverterConfig, int i3, int i16, int i17) {
        if (!videoConverterConfig.setRotation && (i17 == 90 || i17 == 270)) {
            i16 = i3;
            i3 = i16;
        }
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(this.mOutPutVideoCodecMIMEType, Math.round((i3 * videoConverterConfig.scaleRate) / 16.0f) * 16, Math.round((i16 * videoConverterConfig.scaleRate) / 16.0f) * 16);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger("bitrate", videoConverterConfig.videoBitRate);
        createVideoFormat.setFloat("frame-rate", videoConverterConfig.videoFrameRate);
        createVideoFormat.setInteger("i-frame-interval", videoConverterConfig.iFrameInterval);
        if (videoConverterConfig.setProfileLevel) {
            createVideoFormat.setInteger("profile", videoConverterConfig.profile);
            createVideoFormat.setInteger("level", videoConverterConfig.level);
        }
        videoConverterConfig.bitrateMode = 0;
        if (isBitrateModeEnabled(0)) {
            createVideoFormat.setInteger("bitrate-mode", videoConverterConfig.bitrateMode);
        }
        if (ConvertLog.isColorLevel()) {
            ConvertLog.d(TAG, 2, "video format: ", createVideoFormat);
        }
        AtomicReference atomicReference = new AtomicReference();
        this.mVideoEncoder = MediaCodecUtil.createVideoEncoder(createVideoFormat, atomicReference);
        InputSurface inputSurface = new InputSurface((Surface) atomicReference.get());
        this.mInputSurface = inputSurface;
        inputSurface.makeCurrent();
    }

    private boolean processAudio(ByteBuffer byteBuffer) {
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        int readSampleData = this.mAudioExtractor.readSampleData(byteBuffer, 0);
        bufferInfo.size = readSampleData;
        if (readSampleData < 0) {
            return true;
        }
        bufferInfo.presentationTimeUs = this.mAudioExtractor.getSampleTime();
        bufferInfo.flags = this.mAudioExtractor.getSampleFlags();
        this.mMuxer.writeSampleData(this.context.outputAudioTrack, byteBuffer, bufferInfo);
        boolean z16 = !this.mAudioExtractor.advance();
        this.context.lastAudioWriteTimestamp = bufferInfo.presentationTimeUs;
        long j3 = this.mEndTimeUs;
        if (j3 > 0 && bufferInfo.presentationTimeUs >= j3) {
            return true;
        }
        return z16;
    }

    public static void setChangeOutputFrameRateDisabled(boolean z16) {
        sChangeOutputFrameRateDisabled = z16;
    }

    private boolean writeEncodeVideoData() throws IOException {
        MediaCodecWrapper.BufferData dequeueOutputBuffer = this.mVideoEncoder.dequeueOutputBuffer();
        boolean z16 = false;
        if (dequeueOutputBuffer == null) {
            return false;
        }
        MediaCodec.BufferInfo bufferInfo = dequeueOutputBuffer.info;
        int i3 = dequeueOutputBuffer.index;
        if (i3 == -1 || i3 == -3) {
            return false;
        }
        if (i3 == -2) {
            if (this.context.outputVideoTrack < 0) {
                this.context.outputVideoFormat = this.mVideoEncoder.getInnerMediaCodec().getOutputFormat();
                return false;
            }
            throw new IOException("video encoder changed its output format again?");
        }
        if ((bufferInfo.flags & 2) != 0) {
            this.mVideoEncoder.releaseOutputBuffer(i3);
            return false;
        }
        if (bufferInfo.size != 0) {
            this.mMuxer.writeSampleData(this.context.outputVideoTrack, dequeueOutputBuffer.buffer, bufferInfo);
            this.context.lastVideoWriteTimestamp = bufferInfo.presentationTimeUs;
            this.processor.onProgress((int) ((((float) (bufferInfo.presentationTimeUs - this.context.firstFrameTimestamp)) / ((float) this.mDurationUs)) * 10000.0f));
        }
        if ((bufferInfo.flags & 4) != 0) {
            z16 = true;
        }
        this.mVideoEncoder.releaseOutputBuffer(dequeueOutputBuffer.index);
        return z16;
    }

    protected void release() {
        if (ConvertLog.isColorLevel()) {
            ConvertLog.d(TAG, 2, "shutting down encoder, decoder");
        }
        OutputSurface outputSurface = this.mOutputSurface;
        if (outputSurface != null) {
            outputSurface.release();
        }
        InputSurface inputSurface = this.mInputSurface;
        if (inputSurface != null) {
            inputSurface.release();
        }
        MediaCodecWrapper mediaCodecWrapper = this.mVideoEncoder;
        if (mediaCodecWrapper != null) {
            mediaCodecWrapper.stop();
            this.mVideoEncoder.release();
        }
        MediaCodecWrapper mediaCodecWrapper2 = this.mVideoDecoder;
        if (mediaCodecWrapper2 != null) {
            mediaCodecWrapper2.stop();
            this.mVideoDecoder.release();
        }
        MediaMuxer mediaMuxer = this.mMuxer;
        if (mediaMuxer != null) {
            mediaMuxer.release();
            this.mMuxer = null;
        }
        MediaExtractor mediaExtractor = this.mVideoExtractor;
        if (mediaExtractor != null) {
            mediaExtractor.release();
            this.mVideoExtractor = null;
        }
        MediaExtractor mediaExtractor2 = this.mAudioExtractor;
        if (mediaExtractor2 != null) {
            mediaExtractor2.release();
            this.mAudioExtractor = null;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Pair<Integer, Exception> compressInner = compressInner();
        if (compressInner == null) {
            this.processor.onFail(new Exception("error, can not confirm compress state"));
            return;
        }
        if (((Integer) compressInner.first).intValue() == 0) {
            this.processor.onSuccess();
        } else if (((Integer) compressInner.first).intValue() == 1) {
            this.processor.onCancel();
        } else if (((Integer) compressInner.first).intValue() == 2) {
            this.processor.onFail((Throwable) compressInner.second);
        }
    }

    @Override // com.tencent.richmedia.videocompress.converter.IHardwareConverter
    public void setOutPutVideoCodecMIMEType(String str) {
        this.mOutPutVideoCodecMIMEType = str;
    }
}
