package org.tencwebrtc;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Surface;
import com.tencent.avcore.jni.codec.MediaCodecConstants;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import org.tencwebrtc.EglBase14;
import org.tencwebrtc.EncodedImage;
import org.tencwebrtc.ThreadUtils;
import org.tencwebrtc.VideoEncoder;
import org.tencwebrtc.VideoFrame;

/* compiled from: P */
@TargetApi(19)
/* loaded from: classes29.dex */
class HardwareVideoEncoder implements VideoEncoder {
    private static final int DEQUEUE_OUTPUT_BUFFER_TIMEOUT_US = 100000;
    private static final String KEY_BITRATE_MODE = "bitrate-mode";
    private static final int MAX_ENCODER_Q_SIZE = 2;
    private static final int MAX_VIDEO_FRAMERATE = 30;
    private static final int MEDIA_CODEC_RELEASE_TIMEOUT_MS = 5000;
    private static final String TAG = "HardwareVideoEncoder";
    private static final int VIDEO_AVC_LEVEL_3 = 256;
    private static final int VIDEO_AVC_PROFILE_HIGH = 8;
    private static final int VIDEO_ControlRateConstant = 2;
    private int adjustedBitrate;
    private boolean automaticResizeOn;
    private final BitrateAdjuster bitrateAdjuster;
    private VideoEncoder.Callback callback;

    @Nullable
    private MediaCodecWrapper codec;
    private final String codecName;
    private final VideoCodecType codecType;

    @Nullable
    private ByteBuffer configBuffer;
    private final ThreadUtils.ThreadChecker encodeThreadChecker;
    private final long forcedKeyFrameNs;
    private int height;
    private final int keyFrameIntervalSec;
    private long lastKeyFrameNs;
    private final MediaCodecWrapperFactory mediaCodecWrapperFactory;

    @Nullable
    private Thread outputThread;
    private final ThreadUtils.ThreadChecker outputThreadChecker;
    private final Map<String, String> params;
    private volatile boolean running;
    private final EglBase14.Context sharedContext;

    @Nullable
    private volatile Exception shutdownException;
    private final Integer surfaceColorFormat;

    @Nullable
    private EglBase14 textureEglBase;

    @Nullable
    private Surface textureInputSurface;
    private boolean useSurfaceMode;
    private int width;
    private final Integer yuvColorFormat;
    private final YuvFormat yuvFormat;
    private final GlRectDrawer textureDrawer = new GlRectDrawer();
    private final VideoFrameDrawer videoFrameDrawer = new VideoFrameDrawer();
    private final BlockingDeque<EncodedImage.Builder> outputBuilders = new LinkedBlockingDeque();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public enum YuvFormat {
        I420 { // from class: org.tencwebrtc.HardwareVideoEncoder.YuvFormat.1
            @Override // org.tencwebrtc.HardwareVideoEncoder.YuvFormat
            void fillBuffer(ByteBuffer byteBuffer, VideoFrame.Buffer buffer) {
                VideoFrame.I420Buffer i420 = buffer.toI420();
                YuvHelper.I420Copy(i420.getDataY(), i420.getStrideY(), i420.getDataU(), i420.getStrideU(), i420.getDataV(), i420.getStrideV(), byteBuffer, i420.getWidth(), i420.getHeight());
                i420.release();
            }
        },
        NV12 { // from class: org.tencwebrtc.HardwareVideoEncoder.YuvFormat.2
            @Override // org.tencwebrtc.HardwareVideoEncoder.YuvFormat
            void fillBuffer(ByteBuffer byteBuffer, VideoFrame.Buffer buffer) {
                VideoFrame.I420Buffer i420 = buffer.toI420();
                YuvHelper.I420ToNV12(i420.getDataY(), i420.getStrideY(), i420.getDataU(), i420.getStrideU(), i420.getDataV(), i420.getStrideV(), byteBuffer, i420.getWidth(), i420.getHeight());
                i420.release();
            }
        };

        abstract void fillBuffer(ByteBuffer byteBuffer, VideoFrame.Buffer buffer);

        static YuvFormat valueOf(int i3) {
            if (i3 == 19) {
                return I420;
            }
            if (i3 != 21 && i3 != 2141391872 && i3 != 2141391876) {
                throw new IllegalArgumentException("Unsupported colorFormat: " + i3);
            }
            return NV12;
        }
    }

    public HardwareVideoEncoder(MediaCodecWrapperFactory mediaCodecWrapperFactory, String str, VideoCodecType videoCodecType, Integer num, Integer num2, Map<String, String> map, int i3, int i16, BitrateAdjuster bitrateAdjuster, EglBase14.Context context) {
        ThreadUtils.ThreadChecker threadChecker = new ThreadUtils.ThreadChecker();
        this.encodeThreadChecker = threadChecker;
        this.outputThreadChecker = new ThreadUtils.ThreadChecker();
        this.mediaCodecWrapperFactory = mediaCodecWrapperFactory;
        this.codecName = str;
        this.codecType = videoCodecType;
        this.surfaceColorFormat = num;
        this.yuvColorFormat = num2;
        this.yuvFormat = YuvFormat.valueOf(num2.intValue());
        this.params = map;
        this.keyFrameIntervalSec = i3;
        this.forcedKeyFrameNs = TimeUnit.MILLISECONDS.toNanos(i16);
        this.bitrateAdjuster = bitrateAdjuster;
        this.sharedContext = context;
        threadChecker.detachThread();
    }

    private boolean canUseSurface() {
        if (this.sharedContext != null && this.surfaceColorFormat != null) {
            return true;
        }
        return false;
    }

    private Thread createOutputThread() {
        return new BaseThread() { // from class: org.tencwebrtc.HardwareVideoEncoder.1
            @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                while (HardwareVideoEncoder.this.running) {
                    HardwareVideoEncoder.this.deliverEncodedImage();
                }
                HardwareVideoEncoder.this.releaseCodecOnOutputThread();
            }
        };
    }

    private VideoCodecStatus encodeByteBuffer(VideoFrame videoFrame, VideoFrame.Buffer buffer, int i3) {
        this.encodeThreadChecker.checkIsOnValidThread();
        long timestampNs = (videoFrame.getTimestampNs() + 500) / 1000;
        try {
            int dequeueInputBuffer = this.codec.dequeueInputBuffer(0L);
            if (dequeueInputBuffer == -1) {
                Logging.d(TAG, "Dropped frame, no input buffers available");
                return VideoCodecStatus.NO_OUTPUT;
            }
            try {
                fillInputBuffer(this.codec.getInputBuffers()[dequeueInputBuffer], buffer);
                try {
                    this.codec.queueInputBuffer(dequeueInputBuffer, 0, i3, timestampNs, 0);
                    return VideoCodecStatus.OK;
                } catch (IllegalStateException e16) {
                    Logging.e(TAG, "queueInputBuffer failed", e16);
                    return VideoCodecStatus.ERROR;
                }
            } catch (IllegalStateException e17) {
                Logging.e(TAG, "getInputBuffers failed", e17);
                return VideoCodecStatus.ERROR;
            }
        } catch (IllegalStateException e18) {
            Logging.e(TAG, "dequeueInputBuffer failed", e18);
            return VideoCodecStatus.ERROR;
        }
    }

    private VideoCodecStatus encodeTextureBuffer(VideoFrame videoFrame) {
        this.encodeThreadChecker.checkIsOnValidThread();
        try {
            GLES20.glClear(16384);
            this.videoFrameDrawer.drawFrame(new VideoFrame(videoFrame.getBuffer(), 0, videoFrame.getTimestampNs()), this.textureDrawer, null);
            this.textureEglBase.swapBuffers(videoFrame.getTimestampNs());
            return VideoCodecStatus.OK;
        } catch (RuntimeException e16) {
            Logging.e(TAG, "encodeTexture failed", e16);
            return VideoCodecStatus.ERROR;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00af A[Catch: IllegalStateException -> 0x0112, TryCatch #0 {IllegalStateException -> 0x0112, blocks: (B:9:0x0023, B:11:0x0061, B:15:0x0072, B:23:0x0099, B:24:0x00af, B:25:0x0081, B:28:0x008c, B:31:0x00bf, B:33:0x00de, B:34:0x00fa), top: B:8:0x0023 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private VideoCodecStatus initEncodeInternal() {
        Integer num;
        char c16;
        this.encodeThreadChecker.checkIsOnValidThread();
        this.lastKeyFrameNs = -1L;
        try {
            this.codec = this.mediaCodecWrapperFactory.createByCodecName(this.codecName);
            if (this.useSurfaceMode) {
                num = this.surfaceColorFormat;
            } else {
                num = this.yuvColorFormat;
            }
            int intValue = num.intValue();
            try {
                MediaFormat createVideoFormat = MediaFormat.createVideoFormat(this.codecType.mimeType(), this.width, this.height);
                createVideoFormat.setInteger("bitrate", this.adjustedBitrate);
                createVideoFormat.setInteger(KEY_BITRATE_MODE, 2);
                createVideoFormat.setInteger("color-format", intValue);
                createVideoFormat.setInteger("frame-rate", this.bitrateAdjuster.getCodecConfigFramerate());
                createVideoFormat.setInteger("i-frame-interval", this.keyFrameIntervalSec);
                if (this.codecType == VideoCodecType.H264) {
                    String str = this.params.get("profile-level-id");
                    if (str == null) {
                        str = "42e01f";
                    }
                    int hashCode = str.hashCode();
                    if (hashCode != 1537948542) {
                        if (hashCode == 1595523974 && str.equals("640c1f")) {
                            c16 = 0;
                            if (c16 == 0) {
                                if (c16 != 1) {
                                    Logging.w(TAG, "Unknown profile level id: " + str);
                                }
                            } else {
                                createVideoFormat.setInteger("profile", 8);
                                createVideoFormat.setInteger("level", 256);
                            }
                        }
                        c16 = '\uffff';
                        if (c16 == 0) {
                        }
                    } else {
                        if (str.equals("42e01f")) {
                            c16 = 1;
                            if (c16 == 0) {
                            }
                        }
                        c16 = '\uffff';
                        if (c16 == 0) {
                        }
                    }
                }
                Logging.d(TAG, "Format: " + createVideoFormat);
                this.codec.configure(createVideoFormat, null, null, 1);
                if (this.useSurfaceMode) {
                    this.textureEglBase = g.h(this.sharedContext, EglBase.CONFIG_RECORDABLE);
                    Surface createInputSurface = this.codec.createInputSurface();
                    this.textureInputSurface = createInputSurface;
                    this.textureEglBase.createSurface(createInputSurface);
                    this.textureEglBase.makeCurrent();
                }
                this.codec.start();
                this.running = true;
                this.outputThreadChecker.detachThread();
                Thread createOutputThread = createOutputThread();
                this.outputThread = createOutputThread;
                createOutputThread.start();
                return VideoCodecStatus.OK;
            } catch (IllegalStateException e16) {
                Logging.e(TAG, "initEncodeInternal failed", e16);
                release();
                return VideoCodecStatus.FALLBACK_SOFTWARE;
            }
        } catch (IOException | IllegalArgumentException unused) {
            Logging.e(TAG, "Cannot create media encoder " + this.codecName);
            return VideoCodecStatus.FALLBACK_SOFTWARE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseCodecOnOutputThread() {
        this.outputThreadChecker.checkIsOnValidThread();
        Logging.d(TAG, "Releasing MediaCodec on output thread");
        try {
            this.codec.stop();
        } catch (Exception e16) {
            Logging.e(TAG, "Media encoder stop failed", e16);
        }
        try {
            this.codec.release();
        } catch (Exception e17) {
            Logging.e(TAG, "Media encoder release failed", e17);
            this.shutdownException = e17;
        }
        this.configBuffer = null;
        Logging.d(TAG, "Release on output thread done");
    }

    private void requestKeyFrame(long j3) {
        this.encodeThreadChecker.checkIsOnValidThread();
        try {
            Bundle bundle = new Bundle();
            bundle.putInt(MediaCodecConstants.FORCE_I_FRAME, 0);
            this.codec.setParameters(bundle);
            this.lastKeyFrameNs = j3;
        } catch (IllegalStateException e16) {
            Logging.e(TAG, "requestKeyFrame failed", e16);
        }
    }

    private VideoCodecStatus resetCodec(int i3, int i16, boolean z16) {
        this.encodeThreadChecker.checkIsOnValidThread();
        VideoCodecStatus release = release();
        if (release != VideoCodecStatus.OK) {
            return release;
        }
        this.width = i3;
        this.height = i16;
        this.useSurfaceMode = z16;
        return initEncodeInternal();
    }

    private boolean shouldForceKeyFrame(long j3) {
        this.encodeThreadChecker.checkIsOnValidThread();
        long j16 = this.forcedKeyFrameNs;
        if (j16 > 0 && j3 > this.lastKeyFrameNs + j16) {
            return true;
        }
        return false;
    }

    private VideoCodecStatus updateBitrate() {
        this.outputThreadChecker.checkIsOnValidThread();
        this.adjustedBitrate = this.bitrateAdjuster.getAdjustedBitrateBps();
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("video-bitrate", this.adjustedBitrate);
            this.codec.setParameters(bundle);
            return VideoCodecStatus.OK;
        } catch (IllegalStateException e16) {
            Logging.e(TAG, "updateBitrate failed", e16);
            return VideoCodecStatus.ERROR;
        }
    }

    @Override // org.tencwebrtc.VideoEncoder
    public /* synthetic */ long createNativeVideoEncoder() {
        return ag.a(this);
    }

    protected void deliverEncodedImage() {
        ByteBuffer slice;
        EncodedImage.FrameType frameType;
        VideoCodecType videoCodecType;
        this.outputThreadChecker.checkIsOnValidThread();
        try {
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            int dequeueOutputBuffer = this.codec.dequeueOutputBuffer(bufferInfo, JsonGrayBusiId.UI_RESERVE_100000_110000);
            if (dequeueOutputBuffer < 0) {
                return;
            }
            ByteBuffer byteBuffer = this.codec.getOutputBuffers()[dequeueOutputBuffer];
            byteBuffer.position(bufferInfo.offset);
            byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
            if ((bufferInfo.flags & 2) != 0) {
                Logging.d(TAG, "Config frame generated. Offset: " + bufferInfo.offset + ". Size: " + bufferInfo.size);
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bufferInfo.size);
                this.configBuffer = allocateDirect;
                allocateDirect.put(byteBuffer);
            } else {
                this.bitrateAdjuster.reportEncodedFrame(bufferInfo.size);
                if (this.adjustedBitrate != this.bitrateAdjuster.getAdjustedBitrateBps()) {
                    updateBitrate();
                }
                boolean z16 = true;
                if ((bufferInfo.flags & 1) == 0) {
                    z16 = false;
                }
                if (z16) {
                    Logging.d(TAG, "Sync frame generated");
                }
                if (z16 && ((videoCodecType = this.codecType) == VideoCodecType.H264 || videoCodecType == VideoCodecType.H265)) {
                    Logging.d(TAG, "Prepending config frame of size " + this.configBuffer.capacity() + " to output buffer with offset " + bufferInfo.offset + ", size " + bufferInfo.size);
                    slice = ByteBuffer.allocateDirect(bufferInfo.size + this.configBuffer.capacity());
                    this.configBuffer.rewind();
                    slice.put(this.configBuffer);
                    slice.put(byteBuffer);
                    slice.rewind();
                } else {
                    slice = byteBuffer.slice();
                }
                if (z16) {
                    frameType = EncodedImage.FrameType.VideoFrameKey;
                } else {
                    frameType = EncodedImage.FrameType.VideoFrameDelta;
                }
                EncodedImage.Builder poll = this.outputBuilders.poll();
                poll.setBuffer(slice).setFrameType(frameType);
                this.callback.onEncodedFrame(poll.createEncodedImage(), new VideoEncoder.CodecSpecificInfo());
            }
            this.codec.releaseOutputBuffer(dequeueOutputBuffer, false);
        } catch (IllegalStateException e16) {
            Logging.e(TAG, "deliverOutput failed", e16);
        }
    }

    @Override // org.tencwebrtc.VideoEncoder
    public VideoCodecStatus encode(VideoFrame videoFrame, VideoEncoder.EncodeInfo encodeInfo) {
        boolean z16;
        VideoCodecStatus resetCodec;
        VideoCodecStatus encodeByteBuffer;
        this.encodeThreadChecker.checkIsOnValidThread();
        if (this.codec == null) {
            return VideoCodecStatus.UNINITIALIZED;
        }
        VideoFrame.Buffer buffer = videoFrame.getBuffer();
        boolean z17 = buffer instanceof VideoFrame.TextureBuffer;
        int width = videoFrame.getBuffer().getWidth();
        int height = videoFrame.getBuffer().getHeight();
        if (canUseSurface() && z17) {
            z16 = true;
        } else {
            z16 = false;
        }
        if ((width != this.width || height != this.height || z16 != this.useSurfaceMode) && (resetCodec = resetCodec(width, height, z16)) != VideoCodecStatus.OK) {
            return resetCodec;
        }
        if (this.outputBuilders.size() > 2) {
            Logging.e(TAG, "Dropped frame, encoder queue full");
            return VideoCodecStatus.NO_OUTPUT;
        }
        boolean z18 = false;
        for (EncodedImage.FrameType frameType : encodeInfo.frameTypes) {
            if (frameType == EncodedImage.FrameType.VideoFrameKey) {
                z18 = true;
            }
        }
        if (z18 || shouldForceKeyFrame(videoFrame.getTimestampNs())) {
            requestKeyFrame(videoFrame.getTimestampNs());
        }
        int height2 = ((buffer.getHeight() * buffer.getWidth()) * 3) / 2;
        this.outputBuilders.offer(EncodedImage.builder().setCaptureTimeNs(videoFrame.getTimestampNs()).setCompleteFrame(true).setEncodedWidth(videoFrame.getBuffer().getWidth()).setEncodedHeight(videoFrame.getBuffer().getHeight()).setRotation(videoFrame.getRotation()));
        if (this.useSurfaceMode) {
            encodeByteBuffer = encodeTextureBuffer(videoFrame);
        } else {
            encodeByteBuffer = encodeByteBuffer(videoFrame, buffer, height2);
        }
        if (encodeByteBuffer != VideoCodecStatus.OK) {
            this.outputBuilders.pollLast();
        }
        return encodeByteBuffer;
    }

    protected void fillInputBuffer(ByteBuffer byteBuffer, VideoFrame.Buffer buffer) {
        this.yuvFormat.fillBuffer(byteBuffer, buffer);
    }

    @Override // org.tencwebrtc.VideoEncoder
    public String getImplementationName() {
        return "HWEncoder";
    }

    @Override // org.tencwebrtc.VideoEncoder
    public VideoEncoder.ScalingSettings getScalingSettings() {
        this.encodeThreadChecker.checkIsOnValidThread();
        if (this.automaticResizeOn) {
            VideoCodecType videoCodecType = this.codecType;
            if (videoCodecType == VideoCodecType.VP8) {
                return new VideoEncoder.ScalingSettings(29, 95);
            }
            if (videoCodecType == VideoCodecType.H264) {
                return new VideoEncoder.ScalingSettings(24, 37);
            }
        }
        return VideoEncoder.ScalingSettings.OFF;
    }

    @Override // org.tencwebrtc.VideoEncoder
    public VideoCodecStatus initEncode(VideoEncoder.Settings settings, VideoEncoder.Callback callback) {
        int i3;
        this.encodeThreadChecker.checkIsOnValidThread();
        this.callback = callback;
        this.automaticResizeOn = settings.automaticResizeOn;
        this.width = settings.width;
        this.height = settings.height;
        this.useSurfaceMode = canUseSurface();
        int i16 = settings.startBitrate;
        if (i16 != 0 && (i3 = settings.maxFramerate) != 0) {
            this.bitrateAdjuster.setTargets(i16 * 1000, i3);
        }
        this.adjustedBitrate = this.bitrateAdjuster.getAdjustedBitrateBps();
        Logging.d(TAG, "initEncode: " + this.width + " x " + this.height + ". @ " + settings.startBitrate + "kbps. Fps: " + settings.maxFramerate + " Use surface mode: " + this.useSurfaceMode);
        return initEncodeInternal();
    }

    @Override // org.tencwebrtc.VideoEncoder
    public /* synthetic */ boolean isHardwareEncoder() {
        return ag.b(this);
    }

    @Override // org.tencwebrtc.VideoEncoder
    public VideoCodecStatus release() {
        VideoCodecStatus videoCodecStatus;
        this.encodeThreadChecker.checkIsOnValidThread();
        if (this.outputThread == null) {
            videoCodecStatus = VideoCodecStatus.OK;
        } else {
            this.running = false;
            if (!ThreadUtils.joinUninterruptibly(this.outputThread, 5000L)) {
                Logging.e(TAG, "Media encoder release timeout");
                videoCodecStatus = VideoCodecStatus.TIMEOUT;
            } else if (this.shutdownException != null) {
                Logging.e(TAG, "Media encoder release exception", this.shutdownException);
                videoCodecStatus = VideoCodecStatus.ERROR;
            } else {
                videoCodecStatus = VideoCodecStatus.OK;
            }
        }
        this.textureDrawer.release();
        this.videoFrameDrawer.release();
        EglBase14 eglBase14 = this.textureEglBase;
        if (eglBase14 != null) {
            eglBase14.release();
            this.textureEglBase = null;
        }
        Surface surface = this.textureInputSurface;
        if (surface != null) {
            surface.release();
            this.textureInputSurface = null;
        }
        this.outputBuilders.clear();
        this.codec = null;
        this.outputThread = null;
        this.encodeThreadChecker.detachThread();
        return videoCodecStatus;
    }

    @Override // org.tencwebrtc.VideoEncoder
    public VideoCodecStatus setRateAllocation(VideoEncoder.BitrateAllocation bitrateAllocation, int i3) {
        this.encodeThreadChecker.checkIsOnValidThread();
        if (i3 > 30) {
            i3 = 30;
        }
        this.bitrateAdjuster.setTargets(bitrateAllocation.getSum(), i3);
        return VideoCodecStatus.OK;
    }
}
