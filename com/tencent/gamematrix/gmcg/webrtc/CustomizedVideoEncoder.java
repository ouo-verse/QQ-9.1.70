package com.tencent.gamematrix.gmcg.webrtc;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.os.Bundle;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.tencent.avcore.jni.codec.MediaCodecConstants;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import org.tencwebrtc.EglBase;
import org.tencwebrtc.EglBase14;
import org.tencwebrtc.EncodedImage;
import org.tencwebrtc.GlRectDrawer;
import org.tencwebrtc.JavaI420Buffer;
import org.tencwebrtc.ThreadUtils;
import org.tencwebrtc.VideoCodecStatus;
import org.tencwebrtc.VideoEncoder;
import org.tencwebrtc.VideoFrame;
import org.tencwebrtc.VideoFrameDrawer;
import org.tencwebrtc.YuvHelper;
import org.tencwebrtc.ag;

/* compiled from: P */
@TargetApi(19)
/* loaded from: classes6.dex */
class CustomizedVideoEncoder implements VideoEncoder {
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
    private MediaCodec codec;
    private final String codecName;
    private final CodecMimeType codecType;

    @Nullable
    private ByteBuffer configBuffer;
    private final ThreadUtils.ThreadChecker encodeThreadChecker;
    private final long forcedKeyFrameNs;
    private int height;
    private final int keyFrameIntervalSec;
    private long lastKeyFrameNs;

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
    private final Object videoFrameLock;
    private int width;
    private final Integer yuvColorFormat;
    private final YuvFormat yuvFormat;
    private final GlRectDrawer textureDrawer = new GlRectDrawer();
    private final VideoFrameDrawer videoFrameDrawer = new VideoFrameDrawer();
    private final BlockingDeque<EncodedImage.Builder> outputBuilders = new LinkedBlockingDeque();
    private final BlockingDeque<VideoFrame> videoFrames = new LinkedBlockingDeque();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public enum YuvFormat {
        I420 { // from class: com.tencent.gamematrix.gmcg.webrtc.CustomizedVideoEncoder.YuvFormat.1
            @Override // com.tencent.gamematrix.gmcg.webrtc.CustomizedVideoEncoder.YuvFormat
            void fillBuffer(ByteBuffer byteBuffer, VideoFrame.Buffer buffer) {
                VideoFrame.I420Buffer i420 = buffer.toI420();
                YuvHelper.I420Copy(i420.getDataY(), i420.getStrideY(), i420.getDataU(), i420.getStrideU(), i420.getDataV(), i420.getStrideV(), byteBuffer, i420.getWidth(), i420.getHeight());
                i420.release();
            }
        },
        NV12 { // from class: com.tencent.gamematrix.gmcg.webrtc.CustomizedVideoEncoder.YuvFormat.2
            @Override // com.tencent.gamematrix.gmcg.webrtc.CustomizedVideoEncoder.YuvFormat
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

    public CustomizedVideoEncoder(String str, CodecMimeType codecMimeType, Integer num, Integer num2, Map<String, String> map, int i3, int i16, BitrateAdjuster bitrateAdjuster, EglBase14.Context context) {
        ThreadUtils.ThreadChecker threadChecker = new ThreadUtils.ThreadChecker();
        this.encodeThreadChecker = threadChecker;
        this.outputThreadChecker = new ThreadUtils.ThreadChecker();
        this.videoFrameLock = new Object();
        this.codecName = str;
        this.codecType = codecMimeType;
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
        return new BaseThread() { // from class: com.tencent.gamematrix.gmcg.webrtc.CustomizedVideoEncoder.1
            @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                while (CustomizedVideoEncoder.this.running) {
                    CustomizedVideoEncoder.this.deliverEncodedImage();
                }
                CustomizedVideoEncoder.this.releaseCodecOnOutputThread();
            }
        };
    }

    private VideoCodecStatus encodeByteBuffer(VideoFrame videoFrame, VideoFrame.Buffer buffer, int i3) {
        this.encodeThreadChecker.checkIsOnValidThread();
        long timestampNs = (videoFrame.getTimestampNs() + 500) / 1000;
        try {
            int dequeueInputBuffer = this.codec.dequeueInputBuffer(0L);
            if (dequeueInputBuffer == -1) {
                CGLog.i("Dropped frame, no input buffers available");
                return VideoCodecStatus.NO_OUTPUT;
            }
            try {
                fillInputBuffer(this.codec.getInputBuffers()[dequeueInputBuffer], buffer);
                try {
                    this.codec.queueInputBuffer(dequeueInputBuffer, 0, i3, timestampNs, 0);
                    return VideoCodecStatus.OK;
                } catch (IllegalStateException e16) {
                    CGLog.e("queueInputBuffer failed:" + e16);
                    return VideoCodecStatus.ERROR;
                }
            } catch (IllegalStateException e17) {
                CGLog.e("getInputBuffers failed:" + e17);
                return VideoCodecStatus.ERROR;
            }
        } catch (IllegalStateException e18) {
            CGLog.e("dequeueInputBuffer failed" + e18);
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
            CGLog.e("encodeTexture failed:" + e16);
            return VideoCodecStatus.ERROR;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00aa A[Catch: IllegalStateException -> 0x010d, TryCatch #0 {IllegalStateException -> 0x010d, blocks: (B:9:0x001e, B:11:0x005c, B:15:0x006d, B:23:0x0094, B:24:0x00aa, B:25:0x007c, B:28:0x0087, B:31:0x00ba, B:33:0x00d9, B:34:0x00f5), top: B:8:0x001e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private VideoCodecStatus initEncodeInternal() {
        Integer num;
        char c16;
        this.encodeThreadChecker.checkIsOnValidThread();
        this.lastKeyFrameNs = -1L;
        try {
            this.codec = MediaCodec.createByCodecName(this.codecName);
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
                if (this.codecType == CodecMimeType.H264) {
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
                                    CGLog.w("Unknown profile level id: " + str);
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
                CGLog.i("Format: " + createVideoFormat);
                this.codec.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                if (this.useSurfaceMode) {
                    this.textureEglBase = org.tencwebrtc.g.h(this.sharedContext, EglBase.CONFIG_RECORDABLE);
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
                CGLog.e("initEncodeInternal failed" + e16);
                release();
                return VideoCodecStatus.FALLBACK_SOFTWARE;
            }
        } catch (IOException | IllegalArgumentException unused) {
            CGLog.e("Cannot create media encoder " + this.codecName);
            return VideoCodecStatus.FALLBACK_SOFTWARE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseCodecOnOutputThread() {
        this.outputThreadChecker.checkIsOnValidThread();
        CGLog.i("Releasing MediaCodec on output thread");
        try {
            this.codec.stop();
        } catch (Exception e16) {
            CGLog.e("Media encoder stop failed" + e16);
        }
        try {
            this.codec.release();
        } catch (Exception e17) {
            CGLog.e("Media encoder release failed" + e17);
            this.shutdownException = e17;
        }
        this.configBuffer = null;
        CGLog.i("Release on output thread done");
    }

    private void requestKeyFrame(long j3) {
        this.encodeThreadChecker.checkIsOnValidThread();
        try {
            Bundle bundle = new Bundle();
            bundle.putInt(MediaCodecConstants.FORCE_I_FRAME, 0);
            this.codec.setParameters(bundle);
            this.lastKeyFrameNs = j3;
        } catch (IllegalStateException e16) {
            CGLog.e("requestKeyFrame failed:" + e16);
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
            CGLog.e("updateBitrate failed" + e16);
            return VideoCodecStatus.ERROR;
        }
    }

    @Override // org.tencwebrtc.VideoEncoder
    public /* synthetic */ long createNativeVideoEncoder() {
        return ag.a(this);
    }

    protected void deliverEncodedImage() {
        boolean z16;
        boolean z17;
        int size;
        EncodedImage.FrameType frameType;
        this.outputThreadChecker.checkIsOnValidThread();
        try {
            synchronized (this.videoFrameLock) {
                EncodedImage.Builder poll = this.outputBuilders.poll();
                VideoFrame poll2 = this.videoFrames.poll();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Loopback, deliverEncodedImage, builder==null? ");
                if (poll == null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb5.append(z16);
                sb5.append(", videoFrame==null? ");
                if (poll2 == null) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                sb5.append(z17);
                sb5.append(", videoFrame.size=");
                if (poll2 == null) {
                    size = 0;
                } else {
                    size = poll2.getSize();
                }
                sb5.append(size);
                CGLog.i(sb5.toString());
                if (poll != null && poll2 != null) {
                    int size2 = poll2.getSize();
                    CGLog.i("Loopback, before allocateDirect");
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(size2);
                    CGLog.i("Loopback, after allocateDirect");
                    JavaI420Buffer javaI420Buffer = (JavaI420Buffer) poll2.getBuffer();
                    ByteBuffer dataY = javaI420Buffer.getDataY();
                    dataY.position(0);
                    dataY.limit(size2);
                    byte[] bArr = new byte[size2];
                    dataY.get(bArr, 0, size2);
                    dataY.position(0);
                    allocateDirect.put(bArr, 0, size2);
                    if (poll2.getIsKeyFrame()) {
                        frameType = EncodedImage.FrameType.VideoFrameKey;
                    } else {
                        frameType = EncodedImage.FrameType.VideoFrameDelta;
                    }
                    CGLog.i("Loopback, deliverEncodedImage, before onEncodedFrame onEncodedFrame size=" + poll2.getSize() + " " + Integer.toHexString(bArr[0]) + " " + Integer.toHexString(bArr[1]) + " " + Integer.toHexString(bArr[2]) + " " + Integer.toHexString(bArr[3]) + " " + Integer.toHexString(bArr[4]) + " " + Integer.toHexString(bArr[5]) + " " + Integer.toHexString(bArr[6]));
                    poll.setBuffer(allocateDirect).setFrameType(frameType);
                    this.callback.onEncodedFrame(poll.createEncodedImage(), new VideoEncoder.CodecSpecificInfo());
                    CGLog.i("Loopback, deliverEncodedImage, onEncodedFrame size=" + poll2.getSize() + " " + Integer.toHexString(bArr[0]) + " " + Integer.toHexString(bArr[1]) + " " + Integer.toHexString(bArr[2]) + " " + Integer.toHexString(bArr[3]) + " " + Integer.toHexString(bArr[4]) + " " + Integer.toHexString(bArr[5]) + " " + Integer.toHexString(bArr[6]));
                    poll2.release();
                    CompressedVideoCapturer.bufferPool.returnBuffer(javaI420Buffer);
                }
            }
            try {
                LockMethodProxy.sleep(1L);
            } catch (InterruptedException e16) {
                e16.printStackTrace();
            }
            CGLog.i("Loopback, deliverEncodedImage, sleep 1ms");
        } catch (IllegalStateException e17) {
            CGLog.e("deliverOutput failed" + e17);
        }
    }

    @Override // org.tencwebrtc.VideoEncoder
    public VideoCodecStatus encode(VideoFrame videoFrame, VideoEncoder.EncodeInfo encodeInfo) {
        boolean z16;
        this.encodeThreadChecker.checkIsOnValidThread();
        CGLog.i("Loopback, encode, enter");
        EncodedImage.Builder rotation = EncodedImage.builder().setCaptureTimeNs(videoFrame.getTimestampNs()).setCompleteFrame(true).setEncodedWidth(videoFrame.getBuffer().getWidth()).setEncodedHeight(videoFrame.getBuffer().getHeight()).setRotation(videoFrame.getRotation());
        synchronized (this.videoFrameLock) {
            this.outputBuilders.offer(rotation);
            this.videoFrames.offer(videoFrame);
        }
        ByteBuffer dataY = ((JavaI420Buffer) videoFrame.getBuffer()).getDataY();
        dataY.position(0);
        byte[] bArr = new byte[dataY.remaining()];
        dataY.get(bArr);
        dataY.position(0);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Loopback, encode, builder==null? ");
        if (rotation == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        sb5.append(", videoFrame==null? ");
        sb5.append(false);
        sb5.append(", videoFrame.size=");
        sb5.append(videoFrame.getSize());
        sb5.append(" ");
        sb5.append(Integer.toHexString(bArr[0]));
        sb5.append(" ");
        sb5.append(Integer.toHexString(bArr[1]));
        sb5.append(" ");
        sb5.append(Integer.toHexString(bArr[2]));
        sb5.append(" ");
        sb5.append(Integer.toHexString(bArr[3]));
        sb5.append(" ");
        sb5.append(Integer.toHexString(bArr[4]));
        sb5.append(" ");
        sb5.append(Integer.toHexString(bArr[5]));
        sb5.append(" ");
        sb5.append(Integer.toHexString(bArr[6]));
        CGLog.i(sb5.toString());
        return VideoCodecStatus.OK;
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
            CodecMimeType codecMimeType = this.codecType;
            if (codecMimeType == CodecMimeType.VP8) {
                return new VideoEncoder.ScalingSettings(29, 95);
            }
            if (codecMimeType == CodecMimeType.H264) {
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
        CGLog.i("initEncode: " + this.width + " x " + this.height + ". @ " + settings.startBitrate + "kbps. Fps: " + settings.maxFramerate + " Use surface mode: " + this.useSurfaceMode);
        this.running = true;
        this.outputThreadChecker.detachThread();
        Thread createOutputThread = createOutputThread();
        this.outputThread = createOutputThread;
        createOutputThread.start();
        return VideoCodecStatus.OK;
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
                CGLog.e("Media encoder release timeout");
                videoCodecStatus = VideoCodecStatus.TIMEOUT;
            } else if (this.shutdownException != null) {
                CGLog.e("Media encoder release exception" + this.shutdownException);
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
        synchronized (this.videoFrameLock) {
            this.outputBuilders.clear();
            this.videoFrames.clear();
        }
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
