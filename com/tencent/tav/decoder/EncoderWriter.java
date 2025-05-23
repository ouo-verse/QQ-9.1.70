package com.tencent.tav.decoder;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.opengl.EGLContext;
import android.text.TextUtils;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.tav.core.AudioPacket;
import com.tencent.tav.core.CodecBufferUtils;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.core.ExportErrorStatus;
import com.tencent.tav.core.ExportRuntimeException;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.decoder.muxer.IMediaMuxer;
import com.tencent.tav.decoder.muxer.MediaMuxerFactory;
import com.tencent.tav.report.ExportReportSession;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: P */
/* loaded from: classes26.dex */
public class EncoderWriter {
    public static boolean ENABLE_CHANGE_AUDIO_BYTEBUFFER_POSITION = false;
    public static boolean FORCE_FAIL_ON_STOP_ERROR = false;
    public static final int OUTPUT_AUDIO_AAC_PROFILE = 2;
    public static final int OUTPUT_AUDIO_BIT_RATE = 128000;
    public static final int OUTPUT_AUDIO_CHANNEL_COUNT = 1;
    public static final String OUTPUT_AUDIO_MIME_TYPE = "audio/mp4a-latm";
    public static final int OUTPUT_AUDIO_SAMPLE_RATE_HZ = 44100;
    public static final int OUTPUT_VIDEO_BIT_RATE = 8000000;
    public static final int OUTPUT_VIDEO_COLOR_FORMAT = 2130708361;
    public static final int OUTPUT_VIDEO_FRAME_RATE = 30;
    public static final int OUTPUT_VIDEO_IFRAME_INTERVAL = 1;
    public static final String OUTPUT_VIDEO_MIME_TYPE = "video/avc";
    public static boolean PRE_DECODE_AUDIO = false;
    private static final String TAG = "EncoderWriter";
    public static boolean USE_NEW_AUDIO_ENCODE = true;
    private static final long WAIT_TRANSIENT_MS = 20;
    public static final long WRITER_FINISH = -1;
    private volatile MediaCodec.BufferInfo audioBufferInfo;
    private volatile MediaFormat audioEncodeFormat;
    private MediaCodec audioEncoder;
    private Lock audioEncoderLock;
    private boolean audioEncoderStarted;
    private long audioPresentationTimeUs;
    public MediaCodec.Callback callback;
    private boolean enOfAudioInputStream;
    private boolean enOfVideoInputStream;
    private ExportConfig encodeOption;
    private boolean hasAudioTrack;
    private boolean hasVideoTrack;
    private Surface inputSurface;
    private ReadWriteLock lock;
    private IMediaMuxer muxer;
    private volatile boolean muxerStarted;
    private volatile int outputAudioTrack;
    private volatile int outputVideoTrack;
    private boolean released;
    private ExportReportSession reportSession;
    private volatile MediaCodec.BufferInfo videoBufferInfo;
    private volatile MediaFormat videoEncodeFormat;
    private AssetWriterVideoEncoder videoEncoder;
    private Lock videoEncoderLock;
    private boolean videoEncoderStarted;

    /* compiled from: P */
    @Deprecated
    /* loaded from: classes26.dex */
    public static final class OutputConfig {
        public int VIDEO_BIT_RATE = 8000000;
        public int VIDEO_FRAME_RATE = 30;
        public int VIDEO_IFRAME_INTERVAL = 1;
        public int VIDEO_TARGET_WIDTH = 0;
        public int VIDEO_TARGET_HEIGHT = 0;
        public boolean HIGH_PROFILE = false;
        public String AUDIO_MIME_TYPE = "audio/mp4a-latm";
        public int AUDIO_BIT_RATE = EncoderWriter.OUTPUT_AUDIO_BIT_RATE;
        public int AUDIO_AAC_PROFILE = 2;
        public int AUDIO_CHANNEL_COUNT = 1;
        public int AUDIO_SAMPLE_RATE_HZ = 44100;
    }

    @RequiresApi(api = 18)
    public EncoderWriter(String str, AssetWriterVideoEncoder assetWriterVideoEncoder, MediaMuxerFactory.MediaMuxerCreator mediaMuxerCreator) throws IOException {
        this.hasVideoTrack = false;
        this.hasAudioTrack = false;
        this.enOfVideoInputStream = false;
        this.enOfAudioInputStream = false;
        this.videoEncoderLock = new ReentrantLock();
        this.audioEncoderLock = new ReentrantLock();
        this.lock = new ReentrantReadWriteLock();
        this.inputSurface = null;
        this.videoBufferInfo = new MediaCodec.BufferInfo();
        this.audioBufferInfo = new MediaCodec.BufferInfo();
        this.videoEncodeFormat = null;
        this.audioEncodeFormat = null;
        this.outputAudioTrack = -1;
        this.outputVideoTrack = -1;
        this.muxerStarted = false;
        this.videoEncoderStarted = false;
        this.audioEncoderStarted = false;
        this.released = false;
        assetWriterVideoEncoder = assetWriterVideoEncoder == null ? new MediaCodecAssetWriterVideoEncoder() : assetWriterVideoEncoder;
        IMediaMuxer createMediaMuxer = (mediaMuxerCreator == null ? MediaMuxerFactory.getMuxerCreator() : mediaMuxerCreator).createMediaMuxer(str, 0);
        this.muxer = createMediaMuxer;
        this.videoEncoder = assetWriterVideoEncoder;
        assetWriterVideoEncoder.setMediaMuxer(createMediaMuxer);
    }

    @RequiresApi(api = 18)
    private synchronized Surface createInputSurface() {
        if (this.inputSurface == null && this.hasVideoTrack) {
            this.inputSurface = this.videoEncoder.createInputSurface();
        }
        return this.inputSurface;
    }

    private void drainAudioEncoder(boolean z16, CMSampleBuffer cMSampleBuffer, TextureInfo textureInfo) {
        Logger.d(TAG, "drainAudioEncoder:  start");
        boolean z17 = !this.hasAudioTrack;
        long currentTimeMillis = System.currentTimeMillis();
        while (!z17 && this.hasAudioTrack) {
            z17 = outputAudioFrame(z16);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (currentTimeMillis2 > 2000) {
                this.hasAudioTrack = !z16;
                Logger.e(TAG, "drainEncoder: \u97f3\u9891\u5199\u5165\u5904\u7406\u65f6\u95f4\u8d85\u65f6\uff0c\u63d0\u524d\u7ed3\u675f\u5199\u5165, timeCons = " + currentTimeMillis2);
                z17 = true;
            }
            this.videoEncodeFormat = this.videoEncoder.getEncodeFormat();
            if (unStarted()) {
                synchronized (this) {
                    if (unStarted()) {
                        if (this.hasVideoTrack && (this.videoEncoder instanceof MediaCodecAssetWriterVideoEncoder)) {
                            this.outputVideoTrack = this.muxer.addTrack(this.videoEncodeFormat);
                        }
                        if (this.hasAudioTrack) {
                            this.outputAudioTrack = this.muxer.addTrack(this.audioEncodeFormat);
                        }
                        Logger.e(TAG, "muxer2.start():" + this.audioEncodeFormat);
                        this.muxer.start();
                        this.muxerStarted = true;
                    }
                }
            }
        }
        Logger.d(TAG, "drainAudioEncoder:  end");
    }

    @RequiresApi(api = 18)
    private void drainEncoder(boolean z16, CMSampleBuffer cMSampleBuffer, TextureInfo textureInfo) {
        boolean z17;
        boolean z18;
        Logger.d(TAG, "drainEncoder:  start");
        if (z16) {
            if (this.hasVideoTrack) {
                if (this.inputSurface == null) {
                    z17 = true;
                    z18 = this.hasAudioTrack;
                } else {
                    signalEndOfVideoStream();
                }
            }
            z17 = false;
            z18 = this.hasAudioTrack;
        } else {
            z17 = false;
            z18 = false;
        }
        boolean z19 = !this.hasVideoTrack;
        boolean z26 = !this.hasAudioTrack;
        long currentTimeMillis = System.currentTimeMillis();
        while (true) {
            if ((z19 || !this.hasVideoTrack) && (z26 || !this.hasAudioTrack)) {
                break;
            }
            if (z17) {
                signalEndOfVideoStream();
                z17 = false;
            }
            if (!z19) {
                z19 = writeVideoFrame(cMSampleBuffer, textureInfo, z16);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (currentTimeMillis2 > 2000) {
                    this.hasVideoTrack = !z16;
                    Logger.e(TAG, "drainEncoder: \u89c6\u9891\u5199\u5165\u5904\u7406\u65f6\u95f4\u8d85\u65f6\uff0c\u63d0\u524d\u7ed3\u675f\u5199\u5165\uff0c timeCons = " + currentTimeMillis2);
                    z19 = true;
                }
            }
            if (z18) {
                signalEndOfAudioStream();
                z18 = false;
            }
            if (!z26) {
                boolean outputAudioFrame = outputAudioFrame(z16);
                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                if (currentTimeMillis3 > 2000) {
                    this.hasAudioTrack = !z16;
                    Logger.e(TAG, "drainEncoder: \u97f3\u9891\u5199\u5165\u5904\u7406\u65f6\u95f4\u8d85\u65f6\uff0c\u63d0\u524d\u7ed3\u675f\u5199\u5165, timeCons = " + currentTimeMillis3);
                    z26 = true;
                } else {
                    z26 = outputAudioFrame;
                }
            }
            if (unStarted()) {
                synchronized (this) {
                    if (unStarted()) {
                        if (this.hasVideoTrack && (this.videoEncoder instanceof MediaCodecAssetWriterVideoEncoder)) {
                            this.outputVideoTrack = this.muxer.addTrack(this.videoEncodeFormat);
                        }
                        if (this.hasAudioTrack) {
                            this.outputAudioTrack = this.muxer.addTrack(this.audioEncodeFormat);
                        }
                        Logger.e(TAG, "muxer.start():" + this.audioEncodeFormat);
                        this.muxer.start();
                        this.muxerStarted = true;
                    }
                }
            }
        }
        Logger.d(TAG, "drainEncoder:  end");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0060 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0022 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void drainVideoEncoder(boolean z16, CMSampleBuffer cMSampleBuffer, TextureInfo textureInfo) {
        boolean z17;
        boolean z18;
        long currentTimeMillis;
        long currentTimeMillis2;
        Logger.d(TAG, "drainVideoEncoder:  start");
        if (z16 && this.hasVideoTrack) {
            if (this.inputSurface == null) {
                z17 = true;
                z18 = !this.hasVideoTrack;
                currentTimeMillis = System.currentTimeMillis();
                while (!z18 && this.hasVideoTrack) {
                    if (z17) {
                        signalEndOfVideoStream();
                        z17 = false;
                    }
                    z18 = writeVideoFrame(cMSampleBuffer, textureInfo, z16);
                    currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    if (currentTimeMillis2 > 2000) {
                        this.hasVideoTrack = !z16;
                        Logger.e(TAG, "drainEncoder: \u89c6\u9891\u5199\u5165\u5904\u7406\u65f6\u95f4\u8d85\u65f6\uff0c\u63d0\u524d\u7ed3\u675f\u5199\u5165\uff0c timeCons = " + currentTimeMillis2);
                        z18 = true;
                    }
                    if (!unStarted()) {
                        synchronized (this) {
                            if (unStarted()) {
                                if (this.hasVideoTrack && (this.videoEncoder instanceof MediaCodecAssetWriterVideoEncoder)) {
                                    this.outputVideoTrack = this.muxer.addTrack(this.videoEncodeFormat);
                                }
                                if (this.hasAudioTrack) {
                                    this.outputAudioTrack = this.muxer.addTrack(this.audioEncodeFormat);
                                }
                                Logger.e(TAG, "muxer1.start():" + this.audioEncodeFormat);
                                this.muxer.start();
                                this.muxerStarted = true;
                            }
                        }
                    }
                }
                Logger.d(TAG, "drainVideoEncoder:  end");
            }
            signalEndOfVideoStream();
        }
        z17 = false;
        z18 = !this.hasVideoTrack;
        currentTimeMillis = System.currentTimeMillis();
        while (!z18) {
            if (z17) {
            }
            z18 = writeVideoFrame(cMSampleBuffer, textureInfo, z16);
            currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (currentTimeMillis2 > 2000) {
            }
            if (!unStarted()) {
            }
        }
        Logger.d(TAG, "drainVideoEncoder:  end");
    }

    private void fixAudioFormat(MediaFormat mediaFormat) {
        fixStringKey(mediaFormat, "mime", "audio/mp4a-latm");
        fixIntegerKey(mediaFormat, "sample-rate", 44100);
        fixIntegerKey(mediaFormat, "channel-count", 1);
        fixIntegerKey(mediaFormat, "bitrate", OUTPUT_AUDIO_BIT_RATE);
        fixIntegerKey(mediaFormat, "aac-profile", 2);
        Logger.d(TAG, "fixAudioFormat() called with: format = [" + mediaFormat + "]");
    }

    private void fixIntegerKey(MediaFormat mediaFormat, String str, int i3) {
        if (!mediaFormat.containsKey(str) || mediaFormat.getInteger(str) <= 0) {
            Logger.w(TAG, "fixIntegerKey: \u7f3a\u5c11\u5173\u952e\u914d\u7f6e\uff1a" + str + ", \u4f7f\u7528\u9ed8\u8ba4\u503c\uff1a" + i3);
            mediaFormat.setInteger(str, i3);
        }
    }

    private void fixStringKey(MediaFormat mediaFormat, String str, String str2) {
        if (!mediaFormat.containsKey(str) || TextUtils.isEmpty(mediaFormat.getString(str))) {
            Logger.w(TAG, "fixStringKey: \u7f3a\u5c11\u5173\u952e\u914d\u7f6e\uff1a" + str + ", \u4f7f\u7528\u9ed8\u8ba4\u503c\uff1a" + str2);
            mediaFormat.setString(str, str2);
        }
    }

    private void fixVideoFormat(MediaFormat mediaFormat) {
        mediaFormat.setInteger("color-format", 2130708361);
        fixStringKey(mediaFormat, "mime", "video/avc");
        fixIntegerKey(mediaFormat, "bitrate", 8000000);
        fixIntegerKey(mediaFormat, "frame-rate", 30);
        fixIntegerKey(mediaFormat, "i-frame-interval", 1);
        Logger.d(TAG, "fixVideoFormat() called with: format = [" + mediaFormat + "]");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0068 A[Catch: all -> 0x0107, TryCatch #1 {all -> 0x0107, blocks: (B:3:0x000c, B:5:0x003f, B:13:0x0068, B:15:0x0090, B:18:0x0094, B:21:0x00cf, B:22:0x00d5, B:24:0x00db, B:29:0x00e8, B:31:0x004d, B:33:0x005f, B:34:0x0061), top: B:2:0x000c, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e8 A[Catch: all -> 0x0107, TRY_LEAVE, TryCatch #1 {all -> 0x0107, blocks: (B:3:0x000c, B:5:0x003f, B:13:0x0068, B:15:0x0090, B:18:0x0094, B:21:0x00cf, B:22:0x00d5, B:24:0x00db, B:29:0x00e8, B:31:0x004d, B:33:0x005f, B:34:0x0061), top: B:2:0x000c, inners: #0 }] */
    @RequiresApi(api = 18)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean outputAudioFrame(boolean z16) {
        boolean z17;
        ByteBuffer byteBuffer;
        MediaCodec.BufferInfo bufferInfo;
        int i3;
        Logger.d(TAG, "outputAudioFrame start");
        try {
            Logger.d(TAG, "outputAudioFrame start wait lock");
            this.audioEncoderLock.lock();
            Logger.d(TAG, "outputAudioFrame start get lock\uff0cmuxerStarted:" + this.muxerStarted + " audioEncodeFormat:" + this.audioEncodeFormat);
            boolean z18 = true;
            if (!this.muxerStarted && this.audioEncodeFormat != null) {
                i3 = -1;
                bufferInfo = null;
                z17 = !z16;
                byteBuffer = null;
                if (i3 < 0) {
                    Logger.d(TAG, "audioBufferInfo.size:" + bufferInfo.size + " muxerStarted:" + this.muxerStarted);
                    if (validAndCorrectBufferInfo(bufferInfo) && this.muxerStarted) {
                        try {
                            MediaCodec.BufferInfo bufferInfo2 = new MediaCodec.BufferInfo();
                            bufferInfo2.set(bufferInfo.offset, bufferInfo.size, bufferInfo.presentationTimeUs, bufferInfo.flags);
                            Logger.d(TAG, "muxer.writeSampleData time:" + bufferInfo.presentationTimeUs);
                            this.muxer.writeSampleData(this.outputAudioTrack, byteBuffer, bufferInfo2);
                            Logger.d(TAG, "muxer.writeSampleData end");
                            this.audioPresentationTimeUs = bufferInfo.presentationTimeUs;
                        } catch (Exception e16) {
                            Logger.e(TAG, "writeAudioFrame: ", e16);
                        }
                    }
                    if ((bufferInfo.flags & 4) != 0) {
                        Logger.i(TAG, "writeAudioFrame: BUFFER_FLAG_END_OF_STREAM");
                        this.audioPresentationTimeUs = -1L;
                        this.hasAudioTrack = false;
                        return z18;
                    }
                } else {
                    Logger.d(TAG, "outputAudioFrame encoderStatus:" + i3);
                }
                z18 = z17;
                return z18;
            }
            AudioPacket outputAudioPacket = outputAudioPacket(this.audioEncoder, z16);
            ByteBuffer byteBuffer2 = outputAudioPacket.audioBuffer;
            MediaCodec.BufferInfo bufferInfo3 = outputAudioPacket.audioBufferInfo;
            int i16 = outputAudioPacket.encoderBufferIndex;
            z17 = outputAudioPacket.audioDone;
            MediaFormat mediaFormat = outputAudioPacket.audioEncodeFormat;
            if (mediaFormat == null) {
                mediaFormat = this.audioEncodeFormat;
            }
            this.audioEncodeFormat = mediaFormat;
            byteBuffer = byteBuffer2;
            bufferInfo = bufferInfo3;
            i3 = i16;
            if (i3 < 0) {
            }
            z18 = z17;
            return z18;
        } finally {
            this.audioEncoderLock.unlock();
            Logger.d(TAG, "outputAudioFrame end");
        }
    }

    private AudioPacket outputAudioPacket(MediaCodec mediaCodec, boolean z16) {
        AudioPacket audioPacket = new AudioPacket();
        audioPacket.audioBufferInfo = new MediaCodec.BufferInfo();
        Logger.d(TAG, "outputAudioPacket.dequeueOutputBuffer start");
        audioPacket.encoderBufferIndex = CodecBufferUtils.dequeueOutputBuffer(mediaCodec, audioPacket.audioBufferInfo);
        Logger.d(TAG, "outputAudioPacket.dequeueOutputBuffer end, encoderBufferIndex = " + audioPacket.encoderBufferIndex);
        int i3 = audioPacket.encoderBufferIndex;
        if (i3 == -1) {
            if (!z16) {
                audioPacket.audioDone = true;
            }
        } else if (i3 == -2) {
            audioPacket.audioEncodeFormat = mediaCodec.getOutputFormat();
            Logger.e(TAG, "audioEncodeFormat:" + audioPacket.audioEncodeFormat);
        } else if (i3 >= 0) {
            audioPacket.audioEncodeFormat = mediaCodec.getOutputFormat();
            ByteBuffer outputBuffer = CodecBufferUtils.getOutputBuffer(mediaCodec, audioPacket.encoderBufferIndex);
            ByteBuffer allocate = ByteBuffer.allocate(outputBuffer.capacity());
            audioPacket.audioBuffer = allocate;
            allocate.put(outputBuffer);
            audioPacket.audioBuffer.position(0);
            CodecBufferUtils.releaseOutputBuffer(mediaCodec, audioPacket.encoderBufferIndex, false);
            if ((audioPacket.audioBufferInfo.flags & 2) != 0 && this.muxer.ignoreHeader()) {
                audioPacket.audioBufferInfo.size = 0;
            }
            audioPacket.audioBuffer.position(audioPacket.audioBufferInfo.offset);
            ByteBuffer byteBuffer = audioPacket.audioBuffer;
            MediaCodec.BufferInfo bufferInfo = audioPacket.audioBufferInfo;
            byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
        }
        return audioPacket;
    }

    private void prepareAudioEncoder(ExportConfig exportConfig) throws IOException {
        Logger.d(TAG, "AssetWriter prepareAudioEncoder " + this);
        MediaFormat audioFormat = exportConfig.getAudioFormat();
        fixAudioFormat(audioFormat);
        audioFormat.setByteBuffer("csd-0", ByteBuffer.wrap(new byte[]{0, 0}));
        try {
            Logger.i(TAG, "prepareAudioEncoder: format = " + audioFormat);
            MediaCodec createEncoder = MediaCodecManager.createEncoder(audioFormat);
            this.audioEncoder = createEncoder;
            createEncoder.configure(audioFormat, (Surface) null, (MediaCrypto) null, 1);
        } catch (Exception e16) {
            MediaCodecManager.releaseCodec(this.audioEncoder);
            throw new ExportRuntimeException(new ExportErrorStatus(-104, e16, audioFormat.toString()));
        }
    }

    private void prepareVideoEncoder(ExportConfig exportConfig) throws IOException {
        MediaFormat videoFormat = exportConfig.getVideoFormat();
        fixVideoFormat(videoFormat);
        this.videoEncoder.prepare(exportConfig, videoFormat);
    }

    private void signalEndOfAudioStream() {
        try {
            if (this.enOfAudioInputStream) {
                return;
            }
            Logger.d(TAG, "signalEndOfAudioStream: ");
            int dequeueInputBuffer = CodecBufferUtils.dequeueInputBuffer(this.audioEncoder);
            if (dequeueInputBuffer >= 0) {
                CodecBufferUtils.queueInputBuffer(this.audioEncoder, dequeueInputBuffer, 0, 0, 0L, 4);
                this.enOfAudioInputStream = true;
            }
        } catch (Throwable th5) {
            Logger.e(TAG, "signalEndOfAudioStream failed", th5);
            th5.printStackTrace();
        }
    }

    @RequiresApi(api = 18)
    private void signalEndOfVideoStream() {
        Logger.d(TAG, "signalEndOfVideoStream: ");
        if (this.inputSurface != null && !this.enOfVideoInputStream) {
            try {
                this.videoEncoder.signalEndOfInputStream();
                this.enOfVideoInputStream = true;
            } catch (Throwable th5) {
                Logger.e(TAG, "signalEndOfVideoStream failed", th5);
            }
        }
    }

    private boolean unStarted() {
        Logger.d(TAG, "unStarted:  muxerStarted:" + this.muxerStarted + " hasVideoTrack:" + this.hasVideoTrack + " videoEncodeFormat:" + this.videoEncodeFormat + " hasAudioTrack:" + this.hasAudioTrack + " audioEncodeFormat:" + this.audioEncodeFormat);
        if (!this.muxerStarted && ((!this.hasVideoTrack || this.videoEncodeFormat != null) && (!this.hasAudioTrack || this.audioEncodeFormat != null))) {
            return true;
        }
        return false;
    }

    private boolean validAndCorrectBufferInfo(MediaCodec.BufferInfo bufferInfo) {
        if (bufferInfo.size > 0) {
            return true;
        }
        return false;
    }

    @RequiresApi(api = 18)
    private boolean writeVideoFrame(CMSampleBuffer cMSampleBuffer, TextureInfo textureInfo, boolean z16) {
        Logger.d(TAG, "writeVideoFrame start");
        try {
            Logger.d(TAG, "writeVideoFrame start wait lock");
            this.videoEncoderLock.lock();
            Logger.d(TAG, "writeVideoFrame start get lock");
            boolean writeVideoSample = this.videoEncoder.writeVideoSample(cMSampleBuffer, textureInfo, z16);
            this.videoEncodeFormat = this.videoEncoder.getEncodeFormat();
            if (this.videoEncoder.isEncodeToEndOfStream()) {
                this.hasVideoTrack = false;
            }
            return writeVideoSample;
        } finally {
        }
    }

    public boolean audioTrackWritable() {
        boolean z16 = true;
        if (this.hasAudioTrack && (this.muxerStarted || this.audioEncodeFormat == null)) {
            return true;
        }
        synchronized (this) {
            if (!this.hasAudioTrack || (!this.muxerStarted && this.audioEncodeFormat != null)) {
                z16 = false;
            }
        }
        return z16;
    }

    @RequiresApi(api = 18)
    public RenderContext createRenderContext(int i3, int i16) {
        return new RenderContext(i3, i16, createInputSurface());
    }

    @RequiresApi(api = 18)
    public void endWriteAudioSample() {
        Logger.d(TAG, "endWriteAudioSample:" + this);
        try {
            this.lock.readLock().lock();
            if (!this.released && !this.enOfAudioInputStream) {
                Logger.d(TAG, "endWriteAudioSample: ");
                try {
                    int dequeueInputBuffer = CodecBufferUtils.dequeueInputBuffer(this.audioEncoder);
                    if (dequeueInputBuffer >= 0) {
                        CodecBufferUtils.queueInputBuffer(this.audioEncoder, dequeueInputBuffer, 0, 0, 0L, 4);
                        this.enOfAudioInputStream = true;
                    }
                } catch (Throwable th5) {
                    Logger.e(TAG, "endWriteAudioSample failed", th5);
                }
                if (USE_NEW_AUDIO_ENCODE) {
                    if (!this.encodeOption.getAudioEncodeAsync()) {
                        drainAudioEncoder(false, null, null);
                    }
                } else {
                    drainEncoder(false, null, null);
                }
            }
        } finally {
            this.lock.readLock().unlock();
        }
    }

    @RequiresApi(api = 18)
    public void endWriteVideoSample(CMSampleBuffer cMSampleBuffer, TextureInfo textureInfo) {
        Logger.d(TAG, "endWriteVideoSample: ");
        try {
            this.lock.readLock().lock();
            if (this.released || this.inputSurface == null || this.enOfVideoInputStream) {
                return;
            }
            try {
                this.videoEncoder.signalEndOfInputStream();
                this.enOfVideoInputStream = true;
            } catch (Throwable th5) {
                Logger.e(TAG, "endWriteVideoSample failed", th5);
            }
            if (USE_NEW_AUDIO_ENCODE) {
                drainVideoEncoder(false, cMSampleBuffer, textureInfo);
            } else {
                drainEncoder(false, cMSampleBuffer, textureInfo);
            }
        } finally {
            this.lock.readLock().unlock();
        }
    }

    public long getAudioPresentationTimeUs() {
        return this.audioPresentationTimeUs;
    }

    public IMediaMuxer getMuxer() {
        return this.muxer;
    }

    public int getOutHeight() {
        return (int) this.videoEncoder.getEncodeSize().height;
    }

    public int getOutWidth() {
        return (int) this.videoEncoder.getEncodeSize().width;
    }

    public MediaFormat getVideoEncodeFormat() {
        return this.videoEncodeFormat;
    }

    public AssetWriterVideoEncoder getVideoEncoder() {
        return this.videoEncoder;
    }

    public long getVideoPresentationTimeUs() {
        AssetWriterVideoEncoder assetWriterVideoEncoder = this.videoEncoder;
        if (assetWriterVideoEncoder == null) {
            return 0L;
        }
        return assetWriterVideoEncoder.getEncodePresentationTimeUs();
    }

    @RequiresApi(api = 18)
    public void inputAudioSample(long j3, ByteBuffer byteBuffer) {
        Object obj;
        try {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("inputAudioSample: ");
            sb5.append(j3);
            sb5.append("  ");
            if (byteBuffer != null) {
                obj = Integer.valueOf(byteBuffer.limit());
            } else {
                obj = "null";
            }
            sb5.append(obj);
            Logger.v(TAG, sb5.toString());
            this.lock.readLock().lock();
            if (byteBuffer != null && !this.released) {
                int position = byteBuffer.position();
                int limit = byteBuffer.limit();
                long j16 = 0;
                while (position < limit && !this.released) {
                    try {
                        this.audioEncoderLock.lock();
                        int dequeueInputBuffer = CodecBufferUtils.dequeueInputBuffer(this.audioEncoder);
                        if (dequeueInputBuffer >= 0) {
                            ByteBuffer inputBuffer = CodecBufferUtils.getInputBuffer(this.audioEncoder, dequeueInputBuffer);
                            Logger.v(TAG, "inputBuffer.size:" + inputBuffer.capacity());
                            int min = Math.min(limit - position, inputBuffer.capacity());
                            int i3 = position + min;
                            byteBuffer.limit(i3);
                            byteBuffer.position(position);
                            inputBuffer.put(byteBuffer);
                            CodecBufferUtils.queueInputBuffer(this.audioEncoder, dequeueInputBuffer, 0, min, j3 + j16, 0);
                            j16 += DecoderUtils.getAudioDuration(min, this.encodeOption.getAudioChannelCount(), this.encodeOption.getAudioSampleRateHz());
                            position = i3;
                        } else {
                            Logger.i(TAG, "dequeueInputBuffer inputBufferIndex:" + dequeueInputBuffer);
                        }
                        this.audioEncoderLock.unlock();
                        if (USE_NEW_AUDIO_ENCODE) {
                            drainAudioEncoder(false, null, null);
                        } else {
                            drainEncoder(false, null, null);
                        }
                    } catch (Throwable th5) {
                        this.audioEncoderLock.unlock();
                        throw th5;
                    }
                }
                byteBuffer.position(0);
                byteBuffer.limit(limit);
                this.lock.readLock().unlock();
                Logger.v(TAG, "inputAudioSample: " + j3 + " end ");
            }
        } catch (Throwable th6) {
            try {
                if (th6 instanceof ExportRuntimeException) {
                    throw th6;
                }
                throw new ExportRuntimeException(-122, th6);
            } finally {
                this.lock.readLock().unlock();
            }
        }
    }

    public boolean isVideoEncodeNeedVideoRenderOutputTexture() {
        return this.videoEncoder.isNeedVideoOutputTexture();
    }

    @RequiresApi(api = 18)
    public void release() {
        this.released = true;
        Logger.d(TAG, "AssetWriter release: " + this);
        try {
            this.lock.writeLock().lock();
            Logger.d(TAG, "AssetWriter release " + this);
            AssetWriterVideoEncoder assetWriterVideoEncoder = this.videoEncoder;
            if (assetWriterVideoEncoder != null) {
                try {
                    assetWriterVideoEncoder.stop();
                } catch (Exception e16) {
                    Logger.e(TAG, "release: videoEncoder.stop()", e16);
                    if (FORCE_FAIL_ON_STOP_ERROR) {
                        throw new ExportRuntimeException(new ExportErrorStatus(ExportErrorStatus.STOP_VIDEO_ENCODE, e16));
                    }
                }
                try {
                    this.videoEncoder.release();
                } catch (Exception e17) {
                    Logger.e(TAG, "release: videoEncoder.release()", e17);
                }
                this.videoEncoder = null;
            }
            MediaCodec mediaCodec = this.audioEncoder;
            if (mediaCodec != null) {
                try {
                    mediaCodec.stop();
                } catch (Exception e18) {
                    Logger.e(TAG, "release: audioEncoder.stop()", e18);
                    if (FORCE_FAIL_ON_STOP_ERROR) {
                        throw new ExportRuntimeException(new ExportErrorStatus(ExportErrorStatus.STOP_AUDIO_ENCODE, e18));
                    }
                }
                try {
                    MediaCodecManager.releaseCodec(this.audioEncoder);
                } catch (Exception e19) {
                    Logger.e(TAG, "release: audioEncoder.release()", e19);
                }
                this.audioEncoder = null;
            }
            if (this.muxer != null) {
                if (this.muxerStarted) {
                    this.muxerStarted = false;
                    try {
                        this.muxer.stop();
                    } catch (Exception e26) {
                        Logger.e(TAG, "release: muxer.stop()", e26);
                        if (FORCE_FAIL_ON_STOP_ERROR) {
                            throw new ExportRuntimeException(new ExportErrorStatus(ExportErrorStatus.STOP_MUXER, e26));
                        }
                    }
                }
                try {
                    this.muxer.release();
                } catch (Exception e27) {
                    Logger.e(TAG, "release: muxer.release()", e27);
                }
                this.muxer = null;
            }
            Surface surface = this.inputSurface;
            if (surface != null) {
                try {
                    surface.release();
                } catch (Exception e28) {
                    Logger.e(TAG, "release: _inputSurface.release()", e28);
                }
                this.inputSurface = null;
            }
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    public void setAudioOutputFromat(MediaFormat mediaFormat) {
        this.audioEncodeFormat = mediaFormat;
        Logger.i(TAG, "setAudioOutputFromat: " + mediaFormat);
    }

    public void setEncodeOption(@NonNull ExportConfig exportConfig) {
        if (exportConfig.getOutputWidth() > 0 && exportConfig.getOutputHeight() > 0) {
            this.encodeOption = exportConfig.m255clone();
            IMediaMuxer iMediaMuxer = this.muxer;
            if (iMediaMuxer != null) {
                iMediaMuxer.setExportConfig(exportConfig);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("width and height must > 0");
    }

    public void setReportSession(ExportReportSession exportReportSession) {
        this.reportSession = exportReportSession;
    }

    public void setVideoSampleRenderContext(RenderContext renderContext) {
        this.videoEncoder.setVideoSampleRenderContext(renderContext);
    }

    public synchronized void startAudioEncoder() throws Exception {
        try {
            this.audioEncoderLock.lock();
            Logger.d(TAG, "AssetWriter startAudioEncoder " + this);
            prepareAudioEncoder(this.encodeOption);
            this.hasAudioTrack = true;
            if (this.encodeOption.getAudioEncodeAsync()) {
                this.audioEncoder.setCallback(this.callback);
            }
            this.audioEncoder.start();
            this.audioEncoderStarted = true;
        } finally {
            this.audioEncoderLock.unlock();
        }
    }

    @RequiresApi(api = 18)
    public synchronized void startVideoEncoder() throws Exception {
        try {
            this.videoEncoderLock.lock();
            Logger.d(TAG, "AssetWriter startVideoEncoder " + this);
            prepareVideoEncoder(this.encodeOption);
            this.hasVideoTrack = true;
            createInputSurface();
            this.videoEncoder.start();
            this.videoEncoderStarted = true;
        } finally {
            this.videoEncoderLock.unlock();
        }
    }

    @RequiresApi(api = 18)
    public void stop() {
        Logger.d(TAG, "AssetWriter stop " + this);
        if (this.released) {
            return;
        }
        if (!this.videoEncoderStarted && !this.audioEncoderStarted) {
            return;
        }
        this.videoEncoderStarted = false;
        this.audioEncoderStarted = false;
        if (USE_NEW_AUDIO_ENCODE) {
            drainVideoEncoder(true, null, null);
            if (!this.encodeOption.getAudioEncodeAsync()) {
                drainAudioEncoder(true, null, null);
            }
        } else {
            drainEncoder(true, null, null);
        }
        release();
    }

    public boolean videoTrackWritable() {
        boolean z16 = true;
        if (this.hasVideoTrack && (this.muxerStarted || this.videoEncodeFormat == null)) {
            return true;
        }
        synchronized (this) {
            if (!this.hasVideoTrack || (!this.muxerStarted && this.videoEncodeFormat != null)) {
                z16 = false;
            }
        }
        return z16;
    }

    @RequiresApi(api = 18)
    public void writeVideoSample(CMSampleBuffer cMSampleBuffer, TextureInfo textureInfo) {
        Logger.d(TAG, "writeVideoSample");
        System.currentTimeMillis();
        try {
            this.lock.readLock().lock();
            if ((this.videoEncoder instanceof MediaCodecAssetWriterVideoEncoder) && this.inputSurface == null) {
                return;
            }
            if (USE_NEW_AUDIO_ENCODE) {
                drainVideoEncoder(false, cMSampleBuffer, textureInfo);
            } else {
                drainEncoder(false, cMSampleBuffer, textureInfo);
            }
        } finally {
            this.lock.readLock().unlock();
        }
    }

    @RequiresApi(api = 18)
    public RenderContext createRenderContext(int i3, int i16, EGLContext eGLContext) {
        return new RenderContext(i3, i16, createInputSurface(), eGLContext);
    }

    @RequiresApi(api = 18)
    public EncoderWriter(String str) throws IOException {
        this(str, null, null);
    }

    @RequiresApi(api = 21)
    public void outputAudioFrame(MediaCodec mediaCodec, int i3, MediaCodec.BufferInfo bufferInfo) {
        this.audioEncodeFormat = mediaCodec.getOutputFormat();
        if (i3 < 0) {
            mediaCodec.releaseOutputBuffer(i3, false);
            return;
        }
        if (unStarted()) {
            synchronized (this) {
                if (unStarted()) {
                    if (this.hasVideoTrack && (this.videoEncoder instanceof MediaCodecAssetWriterVideoEncoder)) {
                        this.outputVideoTrack = this.muxer.addTrack(this.videoEncodeFormat);
                    }
                    if (this.hasAudioTrack) {
                        this.outputAudioTrack = this.muxer.addTrack(this.audioEncodeFormat);
                    }
                    this.muxer.start();
                    this.muxerStarted = true;
                    Logger.e(TAG, "muxer.start(), audioEncodeFormat:" + this.audioEncodeFormat);
                }
            }
        }
        while (!this.muxerStarted) {
            try {
                if (this.released) {
                    Logger.e(TAG, "muxer.start() not, but released, so return");
                    return;
                } else {
                    Logger.e(TAG, "muxer.start() not");
                    LockMethodProxy.sleep(50L);
                }
            } catch (InterruptedException e16) {
                mediaCodec.releaseOutputBuffer(i3, false);
                throw new RuntimeException(e16);
            }
        }
        ByteBuffer outputBuffer = mediaCodec.getOutputBuffer(i3);
        if ((bufferInfo.flags & 2) != 0 && this.muxer.ignoreHeader()) {
            bufferInfo.size = 0;
            Logger.i(TAG, "outputAudioFrame: BUFFER_FLAG_CODEC_CONFIG");
        }
        if (outputBuffer != null && validAndCorrectBufferInfo(bufferInfo)) {
            ByteBuffer allocate = ByteBuffer.allocate(outputBuffer.capacity());
            allocate.put(outputBuffer);
            allocate.position(bufferInfo.offset);
            allocate.limit(bufferInfo.offset + bufferInfo.size);
            this.muxer.writeSampleData(this.outputAudioTrack, allocate, bufferInfo);
            this.audioPresentationTimeUs = bufferInfo.presentationTimeUs;
            outputBuffer.clear();
        } else {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("outputAudioFrame: outputBuffer is:");
            sb5.append(outputBuffer != null ? 0 : "null");
            Logger.i(TAG, sb5.toString());
        }
        mediaCodec.releaseOutputBuffer(i3, false);
        if ((bufferInfo.flags & 4) != 0) {
            Logger.i(TAG, "outputAudioFrame: BUFFER_FLAG_END_OF_STREAM");
            this.audioPresentationTimeUs = -1L;
            this.hasAudioTrack = false;
        }
    }
}
