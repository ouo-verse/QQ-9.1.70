package org.tencwebrtc;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.view.Surface;
import com.tencent.avcore.jni.codec.HWColorFormat;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.tencwebrtc.EglBase;
import org.tencwebrtc.VideoFrame;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public class MediaCodecVideoDecoder {
    private static final int COLOR_QCOM_FORMATYUV420PackedSemiPlanar32m = 2141391876;
    private static final int COLOR_QCOM_FORMATYVU420PackedSemiPlanar16m4ka = 2141391874;
    private static final int COLOR_QCOM_FORMATYVU420PackedSemiPlanar32m4ka = 2141391873;
    private static final int COLOR_QCOM_FORMATYVU420PackedSemiPlanar64x32Tile2m8ka = 2141391875;
    private static final int DEQUEUE_INPUT_TIMEOUT = 500000;
    private static final String FORMAT_KEY_CROP_BOTTOM = "crop-bottom";
    private static final String FORMAT_KEY_CROP_LEFT = "crop-left";
    private static final String FORMAT_KEY_CROP_RIGHT = "crop-right";
    private static final String FORMAT_KEY_CROP_TOP = "crop-top";
    private static final String FORMAT_KEY_SLICE_HEIGHT = "slice-height";
    private static final String FORMAT_KEY_STRIDE = "stride";
    private static final String H264_MIME_TYPE = "video/avc";
    private static final long MAX_DECODE_TIME_MS = 200;
    private static final int MAX_QUEUED_OUTPUTBUFFERS = 3;
    private static final int MEDIA_CODEC_RELEASE_TIMEOUT_MS = 5000;
    private static final String TAG = "MediaCodecVideoDecoder";
    private static final String VP8_MIME_TYPE = "video/x-vnd.on2.vp8";
    private static final String VP9_MIME_TYPE = "video/x-vnd.on2.vp9";
    private static int codecErrors = 0;

    @Nullable
    private static EglBase eglBase = null;

    @Nullable
    private static MediaCodecVideoDecoderErrorCallback errorCallback = null;

    @Nullable
    private static MediaCodecVideoDecoder runningInstance = null;
    private static final String supportedMediaTekH264HighProfileHwCodecPrefix = "OMX.MTK.";
    private int colorFormat;
    private final Queue<TimeStamps> decodeStartTimeMs = new ArrayDeque();
    private final Queue<DecodedOutputBuffer> dequeuedSurfaceOutputBuffers = new ArrayDeque();
    private int droppedFrames;
    private boolean hasDecodedFirstFrame;
    private int height;
    private ByteBuffer[] inputBuffers;

    @Nullable
    private MediaCodec mediaCodec;

    @Nullable
    private Thread mediaCodecThread;
    private ByteBuffer[] outputBuffers;
    private int sliceHeight;
    private int stride;

    @Nullable
    private Surface surface;

    @Nullable
    private TextureListener textureListener;
    private int width;
    private static Set<String> hwDecoderDisabledTypes = new HashSet();
    private static final String supportedQcomH264HighProfileHwCodecPrefix = "OMX.qcom.";
    private static final String supportedExynosH264HighProfileHwCodecPrefix = "OMX.Exynos.";
    private static final String[] supportedVp9HwCodecPrefixes = {supportedQcomH264HighProfileHwCodecPrefix, supportedExynosH264HighProfileHwCodecPrefix};
    private static final List<Integer> supportedColorList = Arrays.asList(19, 21, Integer.valueOf(HWColorFormat.COLOR_QCOM_FormatYVU420SemiPlanar), 2141391873, 2141391874, 2141391875, 2141391876);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class DecodedOutputBuffer {
        private final long decodeTimeMs;
        private final long endDecodeTimeMs;
        private final int index;
        private final long ntpTimeStampMs;
        private final int offset;
        private final long presentationTimeStampMs;
        private final int size;
        private final long timeStampMs;

        public DecodedOutputBuffer(int i3, int i16, int i17, long j3, long j16, long j17, long j18, long j19) {
            this.index = i3;
            this.offset = i16;
            this.size = i17;
            this.presentationTimeStampMs = j3;
            this.timeStampMs = j16;
            this.ntpTimeStampMs = j17;
            this.decodeTimeMs = j18;
            this.endDecodeTimeMs = j19;
        }

        @CalledByNative("DecodedOutputBuffer")
        long getDecodeTimeMs() {
            return this.decodeTimeMs;
        }

        @CalledByNative("DecodedOutputBuffer")
        int getIndex() {
            return this.index;
        }

        @CalledByNative("DecodedOutputBuffer")
        long getNtpTimestampMs() {
            return this.ntpTimeStampMs;
        }

        @CalledByNative("DecodedOutputBuffer")
        int getOffset() {
            return this.offset;
        }

        @CalledByNative("DecodedOutputBuffer")
        long getPresentationTimestampMs() {
            return this.presentationTimeStampMs;
        }

        @CalledByNative("DecodedOutputBuffer")
        int getSize() {
            return this.size;
        }

        @CalledByNative("DecodedOutputBuffer")
        long getTimestampMs() {
            return this.timeStampMs;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class DecodedTextureBuffer {
        private final long decodeTimeMs;
        private final long frameDelayMs;
        private final long ntpTimeStampMs;
        private final long presentationTimeStampMs;
        private final long timeStampMs;
        private final VideoFrame.Buffer videoFrameBuffer;

        public DecodedTextureBuffer(VideoFrame.Buffer buffer, long j3, long j16, long j17, long j18, long j19) {
            this.videoFrameBuffer = buffer;
            this.presentationTimeStampMs = j3;
            this.timeStampMs = j16;
            this.ntpTimeStampMs = j17;
            this.decodeTimeMs = j18;
            this.frameDelayMs = j19;
        }

        @CalledByNative("DecodedTextureBuffer")
        long getDecodeTimeMs() {
            return this.decodeTimeMs;
        }

        @CalledByNative("DecodedTextureBuffer")
        long getFrameDelayMs() {
            return this.frameDelayMs;
        }

        @CalledByNative("DecodedTextureBuffer")
        long getNtpTimestampMs() {
            return this.ntpTimeStampMs;
        }

        @CalledByNative("DecodedTextureBuffer")
        long getPresentationTimestampMs() {
            return this.presentationTimeStampMs;
        }

        @CalledByNative("DecodedTextureBuffer")
        long getTimeStampMs() {
            return this.timeStampMs;
        }

        @CalledByNative("DecodedTextureBuffer")
        VideoFrame.Buffer getVideoFrameBuffer() {
            return this.videoFrameBuffer;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class DecoderProperties {
        public final String codecName;
        public final int colorFormat;

        public DecoderProperties(String str, int i3) {
            this.codecName = str;
            this.colorFormat = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static class HwDecoderFactory implements VideoDecoderFactory {
        private final VideoCodecInfo[] supportedHardwareCodecs = getSupportedHardwareCodecs();

        HwDecoderFactory() {
        }

        private static VideoCodecInfo[] getSupportedHardwareCodecs() {
            ArrayList arrayList = new ArrayList();
            if (MediaCodecVideoDecoder.isVp8HwSupported()) {
                Logging.d(MediaCodecVideoDecoder.TAG, "VP8 HW Decoder supported.");
                arrayList.add(new VideoCodecInfo("VP8", new HashMap()));
            }
            if (MediaCodecVideoDecoder.isVp9HwSupported()) {
                Logging.d(MediaCodecVideoDecoder.TAG, "VP9 HW Decoder supported.");
                arrayList.add(new VideoCodecInfo("VP9", new HashMap()));
            }
            if (MediaCodecVideoDecoder.isH264HighProfileHwSupported()) {
                Logging.d(MediaCodecVideoDecoder.TAG, "H.264 High Profile HW Decoder supported.");
                arrayList.add(H264Utils.DEFAULT_H264_HIGH_PROFILE_CODEC);
            }
            if (MediaCodecVideoDecoder.isH264HwSupported()) {
                Logging.d(MediaCodecVideoDecoder.TAG, "H.264 HW Decoder supported.");
                arrayList.add(H264Utils.DEFAULT_H264_BASELINE_PROFILE_CODEC);
            }
            return (VideoCodecInfo[]) arrayList.toArray(new VideoCodecInfo[arrayList.size()]);
        }

        private static boolean isCodecSupported(VideoCodecInfo[] videoCodecInfoArr, VideoCodecInfo videoCodecInfo) {
            for (VideoCodecInfo videoCodecInfo2 : videoCodecInfoArr) {
                if (isSameCodec(videoCodecInfo2, videoCodecInfo)) {
                    return true;
                }
            }
            return false;
        }

        private static boolean isSameCodec(VideoCodecInfo videoCodecInfo, VideoCodecInfo videoCodecInfo2) {
            if (!videoCodecInfo.name.equalsIgnoreCase(videoCodecInfo2.name)) {
                return false;
            }
            if (videoCodecInfo.name.equalsIgnoreCase("H264")) {
                return H264Utils.isSameH264Profile(videoCodecInfo.params, videoCodecInfo2.params);
            }
            return true;
        }

        @Override // org.tencwebrtc.VideoDecoderFactory
        public /* synthetic */ VideoDecoder createDecoder(String str) {
            return ae.a(this, str);
        }

        @Override // org.tencwebrtc.VideoDecoderFactory
        public VideoCodecInfo[] getSupportedCodecs() {
            return this.supportedHardwareCodecs;
        }

        @Override // org.tencwebrtc.VideoDecoderFactory
        @Nullable
        public VideoDecoder createDecoder(final VideoCodecInfo videoCodecInfo) {
            if (!isCodecSupported(this.supportedHardwareCodecs, videoCodecInfo)) {
                Logging.d(MediaCodecVideoDecoder.TAG, "No HW video decoder for codec " + videoCodecInfo.name);
                return null;
            }
            Logging.d(MediaCodecVideoDecoder.TAG, "Create HW video decoder for " + videoCodecInfo.name);
            return new WrappedNativeVideoDecoder() { // from class: org.tencwebrtc.MediaCodecVideoDecoder.HwDecoderFactory.1
                @Override // org.tencwebrtc.WrappedNativeVideoDecoder, org.tencwebrtc.VideoDecoder
                public long createNativeVideoDecoder() {
                    return MediaCodecVideoDecoder.nativeCreateDecoder(videoCodecInfo.name, MediaCodecVideoDecoder.useSurface());
                }
            };
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface MediaCodecVideoDecoderErrorCallback {
        void onMediaCodecVideoDecoderCriticalError(int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public class TextureListener implements VideoSink {

        @Nullable
        private DecodedOutputBuffer bufferToRender;
        private final Object newFrameLock = new Object();

        @Nullable
        private DecodedTextureBuffer renderedBuffer;
        private final SurfaceTextureHelper surfaceTextureHelper;

        public TextureListener(SurfaceTextureHelper surfaceTextureHelper) {
            this.surfaceTextureHelper = surfaceTextureHelper;
            surfaceTextureHelper.startListening(this);
        }

        public void addBufferToRender(DecodedOutputBuffer decodedOutputBuffer) {
            if (this.bufferToRender == null) {
                this.bufferToRender = decodedOutputBuffer;
            } else {
                Logging.e(MediaCodecVideoDecoder.TAG, "Unexpected addBufferToRender() called while waiting for a texture.");
                throw new IllegalStateException("Waiting for a texture.");
            }
        }

        @Nullable
        public DecodedTextureBuffer dequeueTextureBuffer(int i3) {
            DecodedTextureBuffer decodedTextureBuffer;
            synchronized (this.newFrameLock) {
                if (this.renderedBuffer == null && i3 > 0 && isWaitingForTexture()) {
                    try {
                        this.newFrameLock.wait(i3);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
                decodedTextureBuffer = this.renderedBuffer;
                this.renderedBuffer = null;
            }
            return decodedTextureBuffer;
        }

        public boolean isWaitingForTexture() {
            boolean z16;
            synchronized (this.newFrameLock) {
                if (this.bufferToRender != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
            }
            return z16;
        }

        @Override // org.tencwebrtc.VideoSink
        public void onFrame(VideoFrame videoFrame) {
            synchronized (this.newFrameLock) {
                if (this.renderedBuffer == null) {
                    VideoFrame.Buffer buffer = videoFrame.getBuffer();
                    buffer.retain();
                    this.renderedBuffer = new DecodedTextureBuffer(buffer, this.bufferToRender.presentationTimeStampMs, this.bufferToRender.timeStampMs, this.bufferToRender.ntpTimeStampMs, this.bufferToRender.decodeTimeMs, SystemClock.elapsedRealtime() - this.bufferToRender.endDecodeTimeMs);
                    this.bufferToRender = null;
                    this.newFrameLock.notifyAll();
                } else {
                    Logging.e(MediaCodecVideoDecoder.TAG, "Unexpected onFrame() called while already holding a texture.");
                    throw new IllegalStateException("Already holding a texture.");
                }
            }
        }

        public void release() {
            this.surfaceTextureHelper.stopListening();
            synchronized (this.newFrameLock) {
                DecodedTextureBuffer decodedTextureBuffer = this.renderedBuffer;
                if (decodedTextureBuffer != null) {
                    decodedTextureBuffer.getVideoFrameBuffer().release();
                    this.renderedBuffer = null;
                }
            }
            this.surfaceTextureHelper.dispose();
        }

        public void setSize(int i3, int i16) {
            this.surfaceTextureHelper.setTextureSize(i3, i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class TimeStamps {
        private final long decodeStartTimeMs;
        private final long ntpTimeStampMs;
        private final long timeStampMs;

        public TimeStamps(long j3, long j16, long j17) {
            this.decodeStartTimeMs = j3;
            this.timeStampMs = j16;
            this.ntpTimeStampMs = j17;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public enum VideoCodecType {
        VIDEO_CODEC_UNKNOWN,
        VIDEO_CODEC_VP8,
        VIDEO_CODEC_VP9,
        VIDEO_CODEC_H264;

        @CalledByNative("VideoCodecType")
        static VideoCodecType fromNativeIndex(int i3) {
            return values()[i3];
        }
    }

    @CalledByNative
    MediaCodecVideoDecoder() {
    }

    private void MaybeRenderDecodedTextureBuffer() {
        if (!this.dequeuedSurfaceOutputBuffers.isEmpty() && !this.textureListener.isWaitingForTexture()) {
            DecodedOutputBuffer remove = this.dequeuedSurfaceOutputBuffers.remove();
            this.textureListener.addBufferToRender(remove);
            this.mediaCodec.releaseOutputBuffer(remove.index, true);
        }
    }

    private void checkOnMediaCodecThread() throws IllegalStateException {
        if (this.mediaCodecThread.getId() == Thread.currentThread().getId()) {
            return;
        }
        throw new IllegalStateException("MediaCodecVideoDecoder previously operated on " + this.mediaCodecThread + " but is now called on " + Thread.currentThread());
    }

    public static VideoDecoderFactory createFactory() {
        return new DefaultVideoDecoderFactory(new HwDecoderFactory());
    }

    @CalledByNativeUnchecked
    private int dequeueInputBuffer() {
        checkOnMediaCodecThread();
        try {
            return this.mediaCodec.dequeueInputBuffer(500000L);
        } catch (IllegalStateException e16) {
            Logging.e(TAG, "dequeueIntputBuffer failed", e16);
            return -2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x013e, code lost:
    
        throw new java.lang.RuntimeException("Unexpected size change. Configured " + r22.width + "*" + r22.height + ". New " + r8 + "*" + r7);
     */
    @CalledByNativeUnchecked
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private DecodedOutputBuffer dequeueOutputBuffer(int i3) {
        long j3;
        int integer;
        int integer2;
        checkOnMediaCodecThread();
        if (this.decodeStartTimeMs.isEmpty()) {
            return null;
        }
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        while (true) {
            int dequeueOutputBuffer = this.mediaCodec.dequeueOutputBuffer(bufferInfo, TimeUnit.MILLISECONDS.toMicros(i3));
            if (dequeueOutputBuffer != -3) {
                if (dequeueOutputBuffer != -2) {
                    if (dequeueOutputBuffer == -1) {
                        return null;
                    }
                    this.hasDecodedFirstFrame = true;
                    TimeStamps remove = this.decodeStartTimeMs.remove();
                    long elapsedRealtime = SystemClock.elapsedRealtime() - remove.decodeStartTimeMs;
                    if (elapsedRealtime > MAX_DECODE_TIME_MS) {
                        Logging.e(TAG, "Very high decode time: " + elapsedRealtime + "ms. Q size: " + this.decodeStartTimeMs.size() + ". Might be caused by resuming H264 decoding after a pause.");
                        j3 = 200L;
                    } else {
                        j3 = elapsedRealtime;
                    }
                    return new DecodedOutputBuffer(dequeueOutputBuffer, bufferInfo.offset, bufferInfo.size, TimeUnit.MICROSECONDS.toMillis(bufferInfo.presentationTimeUs), remove.timeStampMs, remove.ntpTimeStampMs, j3, SystemClock.elapsedRealtime());
                }
                MediaFormat outputFormat = this.mediaCodec.getOutputFormat();
                Logging.d(TAG, "Decoder format changed: " + outputFormat.toString());
                if (outputFormat.containsKey("crop-left") && outputFormat.containsKey("crop-right") && outputFormat.containsKey("crop-bottom") && outputFormat.containsKey("crop-top")) {
                    integer = (outputFormat.getInteger("crop-right") + 1) - outputFormat.getInteger("crop-left");
                    integer2 = (outputFormat.getInteger("crop-bottom") + 1) - outputFormat.getInteger("crop-top");
                } else {
                    integer = outputFormat.getInteger("width");
                    integer2 = outputFormat.getInteger("height");
                }
                if (!this.hasDecodedFirstFrame || (integer == this.width && integer2 == this.height)) {
                    this.width = integer;
                    this.height = integer2;
                    TextureListener textureListener = this.textureListener;
                    if (textureListener != null) {
                        textureListener.setSize(integer, integer2);
                    }
                    if (!useSurface() && outputFormat.containsKey("color-format")) {
                        this.colorFormat = outputFormat.getInteger("color-format");
                        Logging.d(TAG, "Color: 0x" + Integer.toHexString(this.colorFormat));
                        if (!supportedColorList.contains(Integer.valueOf(this.colorFormat))) {
                            throw new IllegalStateException("Non supported color format: " + this.colorFormat);
                        }
                    }
                    if (outputFormat.containsKey("stride")) {
                        this.stride = outputFormat.getInteger("stride");
                    }
                    if (outputFormat.containsKey("slice-height")) {
                        this.sliceHeight = outputFormat.getInteger("slice-height");
                    }
                    Logging.d(TAG, "Frame stride and slice height: " + this.stride + " x " + this.sliceHeight);
                    this.stride = Math.max(this.width, this.stride);
                    this.sliceHeight = Math.max(this.height, this.sliceHeight);
                }
            } else {
                this.outputBuffers = this.mediaCodec.getOutputBuffers();
                Logging.d(TAG, "Decoder output buffers changed: " + this.outputBuffers.length);
                if (this.hasDecodedFirstFrame) {
                    throw new RuntimeException("Unexpected output buffer change event.");
                }
            }
        }
    }

    @CalledByNativeUnchecked
    @Nullable
    private DecodedTextureBuffer dequeueTextureBuffer(int i3) {
        checkOnMediaCodecThread();
        if (useSurface()) {
            DecodedOutputBuffer dequeueOutputBuffer = dequeueOutputBuffer(i3);
            if (dequeueOutputBuffer != null) {
                this.dequeuedSurfaceOutputBuffers.add(dequeueOutputBuffer);
            }
            MaybeRenderDecodedTextureBuffer();
            DecodedTextureBuffer dequeueTextureBuffer = this.textureListener.dequeueTextureBuffer(i3);
            if (dequeueTextureBuffer != null) {
                MaybeRenderDecodedTextureBuffer();
                return dequeueTextureBuffer;
            }
            if (this.dequeuedSurfaceOutputBuffers.size() < Math.min(3, this.outputBuffers.length) && (i3 <= 0 || this.dequeuedSurfaceOutputBuffers.isEmpty())) {
                return null;
            }
            this.droppedFrames++;
            DecodedOutputBuffer remove = this.dequeuedSurfaceOutputBuffers.remove();
            if (i3 > 0) {
                Logging.w(TAG, "Draining decoder. Dropping frame with TS: " + remove.presentationTimeStampMs + ". Total number of dropped frames: " + this.droppedFrames);
            } else {
                Logging.w(TAG, "Too many output buffers " + this.dequeuedSurfaceOutputBuffers.size() + ". Dropping frame with TS: " + remove.presentationTimeStampMs + ". Total number of dropped frames: " + this.droppedFrames);
            }
            this.mediaCodec.releaseOutputBuffer(remove.index, false);
            return new DecodedTextureBuffer(null, remove.presentationTimeStampMs, remove.timeStampMs, remove.ntpTimeStampMs, remove.decodeTimeMs, SystemClock.elapsedRealtime() - remove.endDecodeTimeMs);
        }
        throw new IllegalStateException("dequeueTexture() called for byte buffer decoding.");
    }

    public static void disableH264HwCodec() {
        Logging.w(TAG, "H.264 decoding is disabled by application.");
        hwDecoderDisabledTypes.add("video/avc");
    }

    public static void disableVp8HwCodec() {
        Logging.w(TAG, "VP8 decoding is disabled by application.");
        hwDecoderDisabledTypes.add("video/x-vnd.on2.vp8");
    }

    public static void disableVp9HwCodec() {
        Logging.w(TAG, "VP9 decoding is disabled by application.");
        hwDecoderDisabledTypes.add("video/x-vnd.on2.vp9");
    }

    public static void disposeEglContext() {
        EglBase eglBase2 = eglBase;
        if (eglBase2 != null) {
            eglBase2.release();
            eglBase = null;
        }
    }

    @Nullable
    private static DecoderProperties findDecoder(String str, String[] strArr) {
        MediaCodecInfo mediaCodecInfo;
        boolean z16;
        Logging.d(TAG, "Trying to find HW decoder for mime " + str);
        int i3 = 0;
        while (true) {
            String str2 = null;
            if (i3 < MediaCodecList.getCodecCount()) {
                try {
                    mediaCodecInfo = MediaCodecList.getCodecInfoAt(i3);
                } catch (IllegalArgumentException e16) {
                    Logging.e(TAG, "Cannot retrieve decoder codec info", e16);
                    mediaCodecInfo = null;
                }
                if (mediaCodecInfo != null && !mediaCodecInfo.isEncoder()) {
                    String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
                    int length = supportedTypes.length;
                    int i16 = 0;
                    while (true) {
                        if (i16 >= length) {
                            break;
                        }
                        if (supportedTypes[i16].equals(str)) {
                            str2 = mediaCodecInfo.getName();
                            break;
                        }
                        i16++;
                    }
                    if (str2 == null) {
                        continue;
                    } else {
                        Logging.d(TAG, "Found candidate decoder " + str2);
                        int length2 = strArr.length;
                        int i17 = 0;
                        while (true) {
                            if (i17 < length2) {
                                if (str2.startsWith(strArr[i17])) {
                                    z16 = true;
                                    break;
                                }
                                i17++;
                            } else {
                                z16 = false;
                                break;
                            }
                        }
                        if (z16) {
                            try {
                                MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
                                for (int i18 : capabilitiesForType.colorFormats) {
                                    Logging.v(TAG, "   Color: 0x" + Integer.toHexString(i18));
                                }
                                Iterator<Integer> it = supportedColorList.iterator();
                                while (it.hasNext()) {
                                    int intValue = it.next().intValue();
                                    for (int i19 : capabilitiesForType.colorFormats) {
                                        if (i19 == intValue) {
                                            Logging.d(TAG, "Found target decoder " + str2 + ". Color: 0x" + Integer.toHexString(i19));
                                            return new DecoderProperties(str2, i19);
                                        }
                                    }
                                }
                            } catch (IllegalArgumentException e17) {
                                Logging.e(TAG, "Cannot retrieve decoder capabilities", e17);
                            }
                        } else {
                            continue;
                        }
                    }
                }
                i3++;
            } else {
                Logging.d(TAG, "No HW decoder found for mime " + str);
                return null;
            }
        }
    }

    @CalledByNativeUnchecked
    private boolean initDecode(VideoCodecType videoCodecType, int i3, int i16) {
        String[] supportedH264HwCodecPrefixes;
        String str;
        SurfaceTextureHelper create;
        if (this.mediaCodecThread == null) {
            if (videoCodecType == VideoCodecType.VIDEO_CODEC_VP8) {
                supportedH264HwCodecPrefixes = supportedVp8HwCodecPrefixes();
                str = "video/x-vnd.on2.vp8";
            } else if (videoCodecType == VideoCodecType.VIDEO_CODEC_VP9) {
                supportedH264HwCodecPrefixes = supportedVp9HwCodecPrefixes;
                str = "video/x-vnd.on2.vp9";
            } else if (videoCodecType == VideoCodecType.VIDEO_CODEC_H264) {
                supportedH264HwCodecPrefixes = supportedH264HwCodecPrefixes();
                str = "video/avc";
            } else {
                throw new RuntimeException("initDecode: Non-supported codec " + videoCodecType);
            }
            DecoderProperties findDecoder = findDecoder(str, supportedH264HwCodecPrefixes);
            if (findDecoder != null) {
                Logging.d(TAG, "Java initDecode: " + videoCodecType + ProgressTracer.SEPARATOR + i3 + " x " + i16 + ". Color: 0x" + Integer.toHexString(findDecoder.colorFormat) + ". Use Surface: " + useSurface());
                runningInstance = this;
                this.mediaCodecThread = Thread.currentThread();
                try {
                    this.width = i3;
                    this.height = i16;
                    this.stride = i3;
                    this.sliceHeight = i16;
                    if (useSurface() && (create = SurfaceTextureHelper.create("Decoder SurfaceTextureHelper", eglBase.getEglBaseContext())) != null) {
                        TextureListener textureListener = new TextureListener(create);
                        this.textureListener = textureListener;
                        textureListener.setSize(i3, i16);
                        this.surface = new Surface(create.getSurfaceTexture());
                    }
                    MediaFormat createVideoFormat = MediaFormat.createVideoFormat(str, i3, i16);
                    if (!useSurface()) {
                        createVideoFormat.setInteger("color-format", findDecoder.colorFormat);
                    }
                    Logging.d(TAG, "  Format: " + createVideoFormat);
                    MediaCodec createByCodecName = MediaCodecVideoEncoder.createByCodecName(findDecoder.codecName);
                    this.mediaCodec = createByCodecName;
                    if (createByCodecName == null) {
                        Logging.e(TAG, "Can not create media decoder");
                        return false;
                    }
                    createByCodecName.configure(createVideoFormat, this.surface, (MediaCrypto) null, 0);
                    this.mediaCodec.start();
                    this.colorFormat = findDecoder.colorFormat;
                    this.outputBuffers = this.mediaCodec.getOutputBuffers();
                    this.inputBuffers = this.mediaCodec.getInputBuffers();
                    this.decodeStartTimeMs.clear();
                    this.hasDecodedFirstFrame = false;
                    this.dequeuedSurfaceOutputBuffers.clear();
                    this.droppedFrames = 0;
                    Logging.d(TAG, "Input buffers: " + this.inputBuffers.length + ". Output buffers: " + this.outputBuffers.length);
                    return true;
                } catch (IllegalStateException e16) {
                    Logging.e(TAG, "initDecode failed", e16);
                    return false;
                }
            }
            throw new RuntimeException("Cannot find HW decoder for " + videoCodecType);
        }
        throw new RuntimeException("initDecode: Forgot to release()?");
    }

    public static boolean isH264HighProfileHwSupported() {
        if (hwDecoderDisabledTypes.contains("video/avc")) {
            return false;
        }
        int i3 = Build.VERSION.SDK_INT;
        if (findDecoder("video/avc", new String[]{supportedQcomH264HighProfileHwCodecPrefix}) != null || findDecoder("video/avc", new String[]{supportedExynosH264HighProfileHwCodecPrefix}) != null) {
            return true;
        }
        if (!PeerConnectionFactory.fieldTrialsFindFullName("WebRTC-MediaTekH264").equals(PeerConnectionFactory.TRIAL_ENABLED) || i3 < 27 || findDecoder("video/avc", new String[]{supportedMediaTekH264HighProfileHwCodecPrefix}) == null) {
            return false;
        }
        return true;
    }

    public static boolean isH264HwSupported() {
        if (!hwDecoderDisabledTypes.contains("video/avc") && findDecoder("video/avc", supportedH264HwCodecPrefixes()) != null) {
            return true;
        }
        return false;
    }

    public static boolean isVp8HwSupported() {
        if (!hwDecoderDisabledTypes.contains("video/x-vnd.on2.vp8") && findDecoder("video/x-vnd.on2.vp8", supportedVp8HwCodecPrefixes()) != null) {
            return true;
        }
        return false;
    }

    public static boolean isVp9HwSupported() {
        if (!hwDecoderDisabledTypes.contains("video/x-vnd.on2.vp9") && findDecoder("video/x-vnd.on2.vp9", supportedVp9HwCodecPrefixes) != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native long nativeCreateDecoder(String str, boolean z16);

    public static void printStackTrace() {
        Thread thread;
        MediaCodecVideoDecoder mediaCodecVideoDecoder = runningInstance;
        if (mediaCodecVideoDecoder != null && (thread = mediaCodecVideoDecoder.mediaCodecThread) != null) {
            StackTraceElement[] stackTrace = thread.getStackTrace();
            if (stackTrace.length > 0) {
                Logging.d(TAG, "MediaCodecVideoDecoder stacks trace:");
                for (StackTraceElement stackTraceElement : stackTrace) {
                    Logging.d(TAG, stackTraceElement.toString());
                }
            }
        }
    }

    @CalledByNativeUnchecked
    private boolean queueInputBuffer(int i3, int i16, long j3, long j16, long j17) {
        checkOnMediaCodecThread();
        try {
            this.inputBuffers[i3].position(0);
            this.inputBuffers[i3].limit(i16);
            this.decodeStartTimeMs.add(new TimeStamps(SystemClock.elapsedRealtime(), j16, j17));
            this.mediaCodec.queueInputBuffer(i3, 0, i16, j3, 0);
            return true;
        } catch (IllegalStateException e16) {
            Logging.e(TAG, "decode failed", e16);
            return false;
        }
    }

    @CalledByNativeUnchecked
    private void release() {
        Logging.d(TAG, "Java releaseDecoder. Total number of dropped frames: " + this.droppedFrames);
        checkOnMediaCodecThread();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        new BaseThread(new Runnable() { // from class: org.tencwebrtc.MediaCodecVideoDecoder.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Logging.d(MediaCodecVideoDecoder.TAG, "Java releaseDecoder on release thread");
                    MediaCodecVideoDecoder.this.mediaCodec.stop();
                    MediaCodecVideoDecoder.this.mediaCodec.release();
                    Logging.d(MediaCodecVideoDecoder.TAG, "Java releaseDecoder on release thread done");
                } catch (Exception e16) {
                    Logging.e(MediaCodecVideoDecoder.TAG, "Media decoder release failed", e16);
                }
                countDownLatch.countDown();
            }
        }).start();
        if (!ThreadUtils.awaitUninterruptibly(countDownLatch, 5000L)) {
            Logging.e(TAG, "Media decoder release timeout");
            codecErrors++;
            if (errorCallback != null) {
                Logging.e(TAG, "Invoke codec error callback. Errors: " + codecErrors);
                errorCallback.onMediaCodecVideoDecoderCriticalError(codecErrors);
            }
        }
        this.mediaCodec = null;
        this.mediaCodecThread = null;
        runningInstance = null;
        if (useSurface()) {
            this.surface.release();
            this.surface = null;
            this.textureListener.release();
        }
        Logging.d(TAG, "Java releaseDecoder done");
    }

    @CalledByNativeUnchecked
    private void reset(int i3, int i16) {
        if (this.mediaCodecThread != null && this.mediaCodec != null) {
            Logging.d(TAG, "Java reset: " + i3 + " x " + i16);
            this.mediaCodec.flush();
            this.width = i3;
            this.height = i16;
            TextureListener textureListener = this.textureListener;
            if (textureListener != null) {
                textureListener.setSize(i3, i16);
            }
            this.decodeStartTimeMs.clear();
            this.dequeuedSurfaceOutputBuffers.clear();
            this.hasDecodedFirstFrame = false;
            this.droppedFrames = 0;
            return;
        }
        throw new RuntimeException("Incorrect reset call for non-initialized decoder.");
    }

    @CalledByNativeUnchecked
    private void returnDecodedOutputBuffer(int i3) throws IllegalStateException, MediaCodec.CodecException {
        checkOnMediaCodecThread();
        if (!useSurface()) {
            this.mediaCodec.releaseOutputBuffer(i3, false);
            return;
        }
        throw new IllegalStateException("returnDecodedOutputBuffer() called for surface decoding.");
    }

    public static void setEglContext(EglBase.Context context) {
        if (eglBase != null) {
            Logging.w(TAG, "Egl context already set.");
            eglBase.release();
        }
        eglBase = g.b(context);
    }

    public static void setErrorCallback(MediaCodecVideoDecoderErrorCallback mediaCodecVideoDecoderErrorCallback) {
        Logging.d(TAG, "Set error callback");
        errorCallback = mediaCodecVideoDecoderErrorCallback;
    }

    private static final String[] supportedH264HwCodecPrefixes() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(supportedQcomH264HighProfileHwCodecPrefix);
        arrayList.add("OMX.Intel.");
        arrayList.add(supportedExynosH264HighProfileHwCodecPrefix);
        if (PeerConnectionFactory.fieldTrialsFindFullName("WebRTC-MediaTekH264").equals(PeerConnectionFactory.TRIAL_ENABLED) && Build.VERSION.SDK_INT >= 27) {
            arrayList.add(supportedMediaTekH264HighProfileHwCodecPrefix);
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private static final String[] supportedVp8HwCodecPrefixes() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(supportedQcomH264HighProfileHwCodecPrefix);
        arrayList.add("OMX.Nvidia.");
        arrayList.add(supportedExynosH264HighProfileHwCodecPrefix);
        arrayList.add("OMX.Intel.");
        if (PeerConnectionFactory.fieldTrialsFindFullName("WebRTC-MediaTekVP8").equals(PeerConnectionFactory.TRIAL_ENABLED) && Build.VERSION.SDK_INT >= 24) {
            arrayList.add(supportedMediaTekH264HighProfileHwCodecPrefix);
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    static boolean useSurface() {
        if (eglBase != null) {
            return true;
        }
        return false;
    }

    @CalledByNative
    int getColorFormat() {
        return this.colorFormat;
    }

    @CalledByNative
    int getHeight() {
        return this.height;
    }

    @CalledByNative
    ByteBuffer[] getInputBuffers() {
        return this.inputBuffers;
    }

    @CalledByNative
    ByteBuffer[] getOutputBuffers() {
        return this.outputBuffers;
    }

    @CalledByNative
    int getSliceHeight() {
        return this.sliceHeight;
    }

    @CalledByNative
    int getStride() {
        return this.stride;
    }

    @CalledByNative
    int getWidth() {
        return this.width;
    }
}
