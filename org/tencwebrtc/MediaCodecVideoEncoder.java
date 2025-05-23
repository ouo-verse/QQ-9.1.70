package org.tencwebrtc;

import android.annotation.TargetApi;
import android.graphics.Matrix;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Surface;
import com.tencent.avcore.jni.codec.HWColorFormat;
import com.tencent.avcore.jni.codec.MediaCodecConstants;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.tencwebrtc.EglBase;
import org.tencwebrtc.EglBase14;
import org.tencwebrtc.VideoFrame;

/* compiled from: P */
@TargetApi(19)
@Deprecated
/* loaded from: classes29.dex */
public class MediaCodecVideoEncoder {
    private static final int BITRATE_ADJUSTMENT_FPS = 30;
    private static final double BITRATE_CORRECTION_MAX_SCALE = 4.0d;
    private static final double BITRATE_CORRECTION_SEC = 3.0d;
    private static final int BITRATE_CORRECTION_STEPS = 20;
    private static final int COLOR_QCOM_FORMATYUV420PackedSemiPlanar32m = 2141391876;
    private static final int DEQUEUE_TIMEOUT = 0;
    private static final String[] H264_HW_EXCEPTION_MODELS;
    private static final String H264_MIME_TYPE = "video/avc";
    private static final int MAXIMUM_INITIAL_FPS = 30;
    private static final int MEDIA_CODEC_RELEASE_TIMEOUT_MS = 5000;
    private static final long QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_L_MS = 15000;
    private static final long QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_M_MS = 20000;
    private static final long QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_N_MS = 15000;
    private static final String TAG = "MediaCodecVideoEncoder";
    private static final int VIDEO_AVCLevel3 = 256;
    private static final int VIDEO_AVCProfileHigh = 8;
    private static final int VIDEO_ControlRateConstant = 2;
    private static final String VP8_MIME_TYPE = "video/x-vnd.on2.vp8";
    private static final String VP9_MIME_TYPE = "video/x-vnd.on2.vp9";
    private static int codecErrors;

    @Nullable
    private static MediaCodecVideoEncoderErrorCallback errorCallback;
    private static final MediaCodecProperties exynosH264HighProfileHwProperties;
    private static final MediaCodecProperties exynosH264HwProperties;
    private static final MediaCodecProperties exynosVp8HwProperties;
    private static final MediaCodecProperties exynosVp9HwProperties;
    private static final MediaCodecProperties[] h264HighProfileHwList;
    private static Set<String> hwEncoderDisabledTypes = new HashSet();
    private static final MediaCodecProperties intelVp8HwProperties;
    private static final MediaCodecProperties mediatekH264HwProperties;
    private static final MediaCodecProperties qcomH264HwProperties;
    private static final MediaCodecProperties qcomVp8HwProperties;
    private static final MediaCodecProperties qcomVp9HwProperties;

    @Nullable
    private static MediaCodecVideoEncoder runningInstance;

    @Nullable
    private static EglBase staticEglBase;
    private static final int[] supportedColorList;
    private static final int[] supportedSurfaceColorList;
    private static final MediaCodecProperties[] vp9HwList;
    private double bitrateAccumulator;
    private double bitrateAccumulatorMax;
    private int bitrateAdjustmentScaleExp;
    private BitrateAdjustmentType bitrateAdjustmentType = BitrateAdjustmentType.NO_ADJUSTMENT;
    private double bitrateObservationTimeMs;
    private int colorFormat;

    @Nullable
    private ByteBuffer configData;

    @Nullable
    private GlRectDrawer drawer;

    @Nullable
    private EglBase14 eglBase;
    private long forcedKeyFrameMs;
    private int height;

    @Nullable
    private Surface inputSurface;
    private long lastKeyFrameMs;

    @Nullable
    private MediaCodec mediaCodec;

    @Nullable
    private Thread mediaCodecThread;
    private ByteBuffer[] outputBuffers;
    private int profile;
    private int targetBitrateBps;
    private int targetFps;
    private VideoCodecType type;
    private int width;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: org.tencwebrtc.MediaCodecVideoEncoder$1CaughtException, reason: invalid class name */
    /* loaded from: classes29.dex */
    public class C1CaughtException {

        /* renamed from: e, reason: collision with root package name */
        Exception f423845e;

        C1CaughtException() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public enum BitrateAdjustmentType {
        NO_ADJUSTMENT,
        FRAMERATE_ADJUSTMENT,
        DYNAMIC_ADJUSTMENT
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class EncoderProperties {
        public final BitrateAdjustmentType bitrateAdjustmentType;
        public final String codecName;
        public final int colorFormat;

        public EncoderProperties(String str, int i3, BitrateAdjustmentType bitrateAdjustmentType) {
            this.codecName = str;
            this.colorFormat = i3;
            this.bitrateAdjustmentType = bitrateAdjustmentType;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public enum H264Profile {
        CONSTRAINED_BASELINE(0),
        BASELINE(1),
        MAIN(2),
        CONSTRAINED_HIGH(3),
        HIGH(4);

        private final int value;

        H264Profile(int i3) {
            this.value = i3;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static class HwEncoderFactory implements VideoEncoderFactory {
        private final VideoCodecInfo[] supportedHardwareCodecs = getSupportedHardwareCodecs();

        HwEncoderFactory() {
        }

        private static VideoCodecInfo[] getSupportedHardwareCodecs() {
            ArrayList arrayList = new ArrayList();
            if (MediaCodecVideoEncoder.isVp8HwSupported()) {
                Logging.d(MediaCodecVideoEncoder.TAG, "VP8 HW Encoder supported.");
                arrayList.add(new VideoCodecInfo("VP8", new HashMap()));
            }
            if (MediaCodecVideoEncoder.isVp9HwSupported()) {
                Logging.d(MediaCodecVideoEncoder.TAG, "VP9 HW Encoder supported.");
                arrayList.add(new VideoCodecInfo("VP9", new HashMap()));
            }
            if (MediaCodecVideoDecoder.isH264HighProfileHwSupported()) {
                Logging.d(MediaCodecVideoEncoder.TAG, "H.264 High Profile HW Encoder supported.");
                arrayList.add(H264Utils.DEFAULT_H264_HIGH_PROFILE_CODEC);
            }
            if (MediaCodecVideoEncoder.isH264HwSupported()) {
                Logging.d(MediaCodecVideoEncoder.TAG, "H.264 HW Encoder supported.");
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

        @Override // org.tencwebrtc.VideoEncoderFactory
        @Nullable
        public VideoEncoder createEncoder(final VideoCodecInfo videoCodecInfo) {
            if (!isCodecSupported(this.supportedHardwareCodecs, videoCodecInfo)) {
                Logging.d(MediaCodecVideoEncoder.TAG, "No HW video encoder for codec " + videoCodecInfo.name);
                return null;
            }
            Logging.d(MediaCodecVideoEncoder.TAG, "Create HW video encoder for " + videoCodecInfo.name);
            return new WrappedNativeVideoEncoder() { // from class: org.tencwebrtc.MediaCodecVideoEncoder.HwEncoderFactory.1
                @Override // org.tencwebrtc.WrappedNativeVideoEncoder, org.tencwebrtc.VideoEncoder
                public long createNativeVideoEncoder() {
                    return MediaCodecVideoEncoder.nativeCreateEncoder(videoCodecInfo, MediaCodecVideoEncoder.staticEglBase instanceof EglBase14);
                }

                @Override // org.tencwebrtc.WrappedNativeVideoEncoder, org.tencwebrtc.VideoEncoder
                public boolean isHardwareEncoder() {
                    return true;
                }
            };
        }

        @Override // org.tencwebrtc.VideoEncoderFactory
        public VideoCodecInfo[] getSupportedCodecs() {
            return this.supportedHardwareCodecs;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class MediaCodecProperties {
        public final BitrateAdjustmentType bitrateAdjustmentType;
        public final String codecPrefix;
        public final int minSdk;

        MediaCodecProperties(String str, int i3, BitrateAdjustmentType bitrateAdjustmentType) {
            this.codecPrefix = str;
            this.minSdk = i3;
            this.bitrateAdjustmentType = bitrateAdjustmentType;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface MediaCodecVideoEncoderErrorCallback {
        void onMediaCodecVideoEncoderCriticalError(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static class OutputBufferInfo {
        public final ByteBuffer buffer;
        public final int index;
        public final boolean isKeyFrame;
        public final long presentationTimestampUs;

        public OutputBufferInfo(int i3, ByteBuffer byteBuffer, boolean z16, long j3) {
            this.index = i3;
            this.buffer = byteBuffer;
            this.isKeyFrame = z16;
            this.presentationTimestampUs = j3;
        }

        @CalledByNative("OutputBufferInfo")
        ByteBuffer getBuffer() {
            return this.buffer;
        }

        @CalledByNative("OutputBufferInfo")
        int getIndex() {
            return this.index;
        }

        @CalledByNative("OutputBufferInfo")
        long getPresentationTimestampUs() {
            return this.presentationTimestampUs;
        }

        @CalledByNative("OutputBufferInfo")
        boolean isKeyFrame() {
            return this.isKeyFrame;
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

    static {
        BitrateAdjustmentType bitrateAdjustmentType = BitrateAdjustmentType.NO_ADJUSTMENT;
        qcomVp8HwProperties = new MediaCodecProperties("OMX.qcom.", 19, bitrateAdjustmentType);
        exynosVp8HwProperties = new MediaCodecProperties("OMX.Exynos.", 23, BitrateAdjustmentType.DYNAMIC_ADJUSTMENT);
        intelVp8HwProperties = new MediaCodecProperties("OMX.Intel.", 21, bitrateAdjustmentType);
        MediaCodecProperties mediaCodecProperties = new MediaCodecProperties("OMX.qcom.", 24, bitrateAdjustmentType);
        qcomVp9HwProperties = mediaCodecProperties;
        BitrateAdjustmentType bitrateAdjustmentType2 = BitrateAdjustmentType.FRAMERATE_ADJUSTMENT;
        MediaCodecProperties mediaCodecProperties2 = new MediaCodecProperties("OMX.Exynos.", 24, bitrateAdjustmentType2);
        exynosVp9HwProperties = mediaCodecProperties2;
        vp9HwList = new MediaCodecProperties[]{mediaCodecProperties, mediaCodecProperties2};
        qcomH264HwProperties = new MediaCodecProperties("OMX.qcom.", 19, bitrateAdjustmentType);
        exynosH264HwProperties = new MediaCodecProperties("OMX.Exynos.", 21, bitrateAdjustmentType2);
        mediatekH264HwProperties = new MediaCodecProperties("OMX.MTK.", 27, bitrateAdjustmentType2);
        MediaCodecProperties mediaCodecProperties3 = new MediaCodecProperties("OMX.Exynos.", 23, bitrateAdjustmentType2);
        exynosH264HighProfileHwProperties = mediaCodecProperties3;
        h264HighProfileHwList = new MediaCodecProperties[]{mediaCodecProperties3};
        H264_HW_EXCEPTION_MODELS = new String[]{"SAMSUNG-SGH-I337", "Nexus 7", "Nexus 4"};
        supportedColorList = new int[]{19, 21, HWColorFormat.COLOR_QCOM_FormatYVU420SemiPlanar, 2141391876};
        supportedSurfaceColorList = new int[]{2130708361};
    }

    @CalledByNative
    MediaCodecVideoEncoder() {
    }

    private void checkOnMediaCodecThread() {
        if (this.mediaCodecThread.getId() == Thread.currentThread().getId()) {
            return;
        }
        throw new RuntimeException("MediaCodecVideoEncoder previously operated on " + this.mediaCodecThread + " but is now called on " + Thread.currentThread());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static MediaCodec createByCodecName(String str) {
        try {
            return MediaCodec.createByCodecName(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static VideoEncoderFactory createFactory() {
        return new DefaultVideoEncoderFactory(new HwEncoderFactory());
    }

    public static void disableH264HwCodec() {
        Logging.w(TAG, "H.264 encoding is disabled by application.");
        hwEncoderDisabledTypes.add("video/avc");
    }

    public static void disableVp8HwCodec() {
        Logging.w(TAG, "VP8 encoding is disabled by application.");
        hwEncoderDisabledTypes.add("video/x-vnd.on2.vp8");
    }

    public static void disableVp9HwCodec() {
        Logging.w(TAG, "VP9 encoding is disabled by application.");
        hwEncoderDisabledTypes.add("video/x-vnd.on2.vp9");
    }

    public static void disposeEglContext() {
        EglBase eglBase = staticEglBase;
        if (eglBase != null) {
            eglBase.release();
            staticEglBase = null;
        }
    }

    @Nullable
    private static EncoderProperties findHwEncoder(String str, MediaCodecProperties[] mediaCodecPropertiesArr, int[] iArr) {
        MediaCodecInfo mediaCodecInfo;
        String str2;
        boolean z16;
        if (str.equals("video/avc") && Arrays.asList(H264_HW_EXCEPTION_MODELS).contains(DeviceInfoMonitor.getModel())) {
            Logging.w(TAG, "Model: " + DeviceInfoMonitor.getModel() + " has black listed H.264 encoder.");
            return null;
        }
        for (int i3 = 0; i3 < MediaCodecList.getCodecCount(); i3++) {
            try {
                mediaCodecInfo = MediaCodecList.getCodecInfoAt(i3);
            } catch (IllegalArgumentException e16) {
                Logging.e(TAG, "Cannot retrieve encoder codec info", e16);
                mediaCodecInfo = null;
            }
            if (mediaCodecInfo != null && mediaCodecInfo.isEncoder()) {
                String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
                int length = supportedTypes.length;
                int i16 = 0;
                while (true) {
                    if (i16 < length) {
                        if (supportedTypes[i16].equals(str)) {
                            str2 = mediaCodecInfo.getName();
                            break;
                        }
                        i16++;
                    } else {
                        str2 = null;
                        break;
                    }
                }
                if (str2 == null) {
                    continue;
                } else {
                    Logging.v(TAG, "Found candidate encoder " + str2);
                    BitrateAdjustmentType bitrateAdjustmentType = BitrateAdjustmentType.NO_ADJUSTMENT;
                    int length2 = mediaCodecPropertiesArr.length;
                    int i17 = 0;
                    while (true) {
                        if (i17 < length2) {
                            MediaCodecProperties mediaCodecProperties = mediaCodecPropertiesArr[i17];
                            if (str2.startsWith(mediaCodecProperties.codecPrefix)) {
                                int i18 = Build.VERSION.SDK_INT;
                                if (i18 < mediaCodecProperties.minSdk) {
                                    Logging.w(TAG, "Codec " + str2 + " is disabled due to SDK version " + i18);
                                } else {
                                    BitrateAdjustmentType bitrateAdjustmentType2 = mediaCodecProperties.bitrateAdjustmentType;
                                    if (bitrateAdjustmentType2 != BitrateAdjustmentType.NO_ADJUSTMENT) {
                                        Logging.w(TAG, "Codec " + str2 + " requires bitrate adjustment: " + bitrateAdjustmentType2);
                                        bitrateAdjustmentType = bitrateAdjustmentType2;
                                    }
                                    z16 = true;
                                }
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
                            for (int i19 : capabilitiesForType.colorFormats) {
                                Logging.v(TAG, "   Color: 0x" + Integer.toHexString(i19));
                            }
                            for (int i26 : iArr) {
                                for (int i27 : capabilitiesForType.colorFormats) {
                                    if (i27 == i26) {
                                        Logging.d(TAG, "Found target encoder for mime " + str + ProgressTracer.SEPARATOR + str2 + ". Color: 0x" + Integer.toHexString(i27) + ". Bitrate adjustment: " + bitrateAdjustmentType);
                                        return new EncoderProperties(str2, i27, bitrateAdjustmentType);
                                    }
                                }
                            }
                        } catch (IllegalArgumentException e17) {
                            Logging.e(TAG, "Cannot retrieve encoder capabilities", e17);
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return null;
    }

    private double getBitrateScale(int i3) {
        return Math.pow(BITRATE_CORRECTION_MAX_SCALE, i3 / 20.0d);
    }

    @Nullable
    static EglBase.Context getEglContext() {
        EglBase eglBase = staticEglBase;
        if (eglBase == null) {
            return null;
        }
        return eglBase.getEglBaseContext();
    }

    private static final MediaCodecProperties[] h264HwList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(qcomH264HwProperties);
        arrayList.add(exynosH264HwProperties);
        if (PeerConnectionFactory.fieldTrialsFindFullName("WebRTC-MediaTekH264").equals(PeerConnectionFactory.TRIAL_ENABLED)) {
            arrayList.add(mediatekH264HwProperties);
        }
        return (MediaCodecProperties[]) arrayList.toArray(new MediaCodecProperties[arrayList.size()]);
    }

    public static boolean isH264HighProfileHwSupported() {
        if (!hwEncoderDisabledTypes.contains("video/avc") && findHwEncoder("video/avc", h264HighProfileHwList, supportedColorList) != null) {
            return true;
        }
        return false;
    }

    public static boolean isH264HwSupported() {
        if (!hwEncoderDisabledTypes.contains("video/avc") && findHwEncoder("video/avc", h264HwList(), supportedColorList) != null) {
            return true;
        }
        return false;
    }

    public static boolean isH264HwSupportedUsingTextures() {
        if (!hwEncoderDisabledTypes.contains("video/avc") && findHwEncoder("video/avc", h264HwList(), supportedSurfaceColorList) != null) {
            return true;
        }
        return false;
    }

    @CalledByNative
    static boolean isTextureBuffer(VideoFrame.Buffer buffer) {
        return buffer instanceof VideoFrame.TextureBuffer;
    }

    public static boolean isVp8HwSupported() {
        if (!hwEncoderDisabledTypes.contains("video/x-vnd.on2.vp8") && findHwEncoder("video/x-vnd.on2.vp8", vp8HwList(), supportedColorList) != null) {
            return true;
        }
        return false;
    }

    public static boolean isVp8HwSupportedUsingTextures() {
        if (!hwEncoderDisabledTypes.contains("video/x-vnd.on2.vp8") && findHwEncoder("video/x-vnd.on2.vp8", vp8HwList(), supportedSurfaceColorList) != null) {
            return true;
        }
        return false;
    }

    public static boolean isVp9HwSupported() {
        if (!hwEncoderDisabledTypes.contains("video/x-vnd.on2.vp9") && findHwEncoder("video/x-vnd.on2.vp9", vp9HwList, supportedColorList) != null) {
            return true;
        }
        return false;
    }

    public static boolean isVp9HwSupportedUsingTextures() {
        if (!hwEncoderDisabledTypes.contains("video/x-vnd.on2.vp9") && findHwEncoder("video/x-vnd.on2.vp9", vp9HwList, supportedSurfaceColorList) != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native long nativeCreateEncoder(VideoCodecInfo videoCodecInfo, boolean z16);

    private static native void nativeFillInputBuffer(long j3, int i3, ByteBuffer byteBuffer, int i16, ByteBuffer byteBuffer2, int i17, ByteBuffer byteBuffer3, int i18);

    public static void printStackTrace() {
        Thread thread;
        MediaCodecVideoEncoder mediaCodecVideoEncoder = runningInstance;
        if (mediaCodecVideoEncoder != null && (thread = mediaCodecVideoEncoder.mediaCodecThread) != null) {
            StackTraceElement[] stackTrace = thread.getStackTrace();
            if (stackTrace.length > 0) {
                Logging.d(TAG, "MediaCodecVideoEncoder stacks trace:");
                for (StackTraceElement stackTraceElement : stackTrace) {
                    Logging.d(TAG, stackTraceElement.toString());
                }
            }
        }
    }

    private void reportEncodedFrame(int i3) {
        int i16 = this.targetFps;
        if (i16 != 0 && this.bitrateAdjustmentType == BitrateAdjustmentType.DYNAMIC_ADJUSTMENT) {
            double d16 = this.bitrateAccumulator + (i3 - (this.targetBitrateBps / (i16 * 8.0d)));
            this.bitrateAccumulator = d16;
            this.bitrateObservationTimeMs += 1000.0d / i16;
            double d17 = this.bitrateAccumulatorMax * 3.0d;
            double min = Math.min(d16, d17);
            this.bitrateAccumulator = min;
            this.bitrateAccumulator = Math.max(min, -d17);
            if (this.bitrateObservationTimeMs > 3000.0d) {
                Logging.d(TAG, "Acc: " + ((int) this.bitrateAccumulator) + ". Max: " + ((int) this.bitrateAccumulatorMax) + ". ExpScale: " + this.bitrateAdjustmentScaleExp);
                double d18 = this.bitrateAccumulator;
                double d19 = this.bitrateAccumulatorMax;
                boolean z16 = true;
                if (d18 > d19) {
                    this.bitrateAdjustmentScaleExp -= (int) ((d18 / d19) + 0.5d);
                    this.bitrateAccumulator = d19;
                } else if (d18 < (-d19)) {
                    this.bitrateAdjustmentScaleExp += (int) (((-d18) / d19) + 0.5d);
                    this.bitrateAccumulator = -d19;
                } else {
                    z16 = false;
                }
                if (z16) {
                    int min2 = Math.min(this.bitrateAdjustmentScaleExp, 20);
                    this.bitrateAdjustmentScaleExp = min2;
                    this.bitrateAdjustmentScaleExp = Math.max(min2, -20);
                    Logging.d(TAG, "Adjusting bitrate scale to " + this.bitrateAdjustmentScaleExp + ". Value: " + getBitrateScale(this.bitrateAdjustmentScaleExp));
                    setRates(this.targetBitrateBps / 1000, this.targetFps);
                }
                this.bitrateObservationTimeMs = 0.0d;
            }
        }
    }

    public static void setEglContext(EglBase.Context context) {
        if (staticEglBase != null) {
            Logging.w(TAG, "Egl context already set.");
            staticEglBase.release();
        }
        staticEglBase = g.b(context);
    }

    public static void setErrorCallback(MediaCodecVideoEncoderErrorCallback mediaCodecVideoEncoderErrorCallback) {
        Logging.d(TAG, "Set error callback");
        errorCallback = mediaCodecVideoEncoderErrorCallback;
    }

    @CalledByNativeUnchecked
    private boolean setRates(int i3, int i16) {
        checkOnMediaCodecThread();
        int i17 = i3 * 1000;
        BitrateAdjustmentType bitrateAdjustmentType = this.bitrateAdjustmentType;
        BitrateAdjustmentType bitrateAdjustmentType2 = BitrateAdjustmentType.DYNAMIC_ADJUSTMENT;
        if (bitrateAdjustmentType == bitrateAdjustmentType2) {
            double d16 = i17;
            this.bitrateAccumulatorMax = d16 / 8.0d;
            int i18 = this.targetBitrateBps;
            if (i18 > 0 && i17 < i18) {
                this.bitrateAccumulator = (this.bitrateAccumulator * d16) / i18;
            }
        }
        this.targetBitrateBps = i17;
        this.targetFps = i16;
        if (bitrateAdjustmentType == BitrateAdjustmentType.FRAMERATE_ADJUSTMENT && i16 > 0) {
            i17 = (i17 * 30) / i16;
            Logging.v(TAG, "setRates: " + i3 + " -> " + (i17 / 1000) + " kbps. Fps: " + this.targetFps);
        } else if (bitrateAdjustmentType == bitrateAdjustmentType2) {
            Logging.v(TAG, "setRates: " + i3 + " kbps. Fps: " + this.targetFps + ". ExpScale: " + this.bitrateAdjustmentScaleExp);
            int i19 = this.bitrateAdjustmentScaleExp;
            if (i19 != 0) {
                i17 = (int) (i17 * getBitrateScale(i19));
            }
        } else {
            Logging.v(TAG, "setRates: " + i3 + " kbps. Fps: " + this.targetFps);
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("video-bitrate", i17);
            this.mediaCodec.setParameters(bundle);
            return true;
        } catch (IllegalStateException e16) {
            Logging.e(TAG, "setRates failed", e16);
            return false;
        }
    }

    @Nullable
    public static EncoderProperties vp8HwEncoderProperties() {
        if (hwEncoderDisabledTypes.contains("video/x-vnd.on2.vp8")) {
            return null;
        }
        return findHwEncoder("video/x-vnd.on2.vp8", vp8HwList(), supportedColorList);
    }

    private static MediaCodecProperties[] vp8HwList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(qcomVp8HwProperties);
        arrayList.add(exynosVp8HwProperties);
        if (PeerConnectionFactory.fieldTrialsFindFullName("WebRTC-IntelVP8").equals(PeerConnectionFactory.TRIAL_ENABLED)) {
            arrayList.add(intelVp8HwProperties);
        }
        return (MediaCodecProperties[]) arrayList.toArray(new MediaCodecProperties[arrayList.size()]);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void checkKeyFrameRequired(boolean z16, long j3) {
        boolean z17;
        long j16 = (j3 + 500) / 1000;
        if (this.lastKeyFrameMs < 0) {
            this.lastKeyFrameMs = j16;
        }
        if (!z16) {
            long j17 = this.forcedKeyFrameMs;
            if (j17 > 0 && j16 > this.lastKeyFrameMs + j17) {
                z17 = true;
                if (!z16 || z17) {
                    if (!z16) {
                        Logging.d(TAG, "Sync frame request");
                    } else {
                        Logging.d(TAG, "Sync frame forced");
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt(MediaCodecConstants.FORCE_I_FRAME, 0);
                    this.mediaCodec.setParameters(bundle);
                    this.lastKeyFrameMs = j16;
                }
                return;
            }
        }
        z17 = false;
        if (!z16) {
        }
        if (!z16) {
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt(MediaCodecConstants.FORCE_I_FRAME, 0);
        this.mediaCodec.setParameters(bundle2);
        this.lastKeyFrameMs = j16;
    }

    @CalledByNativeUnchecked
    int dequeueInputBuffer() {
        checkOnMediaCodecThread();
        try {
            return this.mediaCodec.dequeueInputBuffer(0L);
        } catch (IllegalStateException e16) {
            Logging.e(TAG, "dequeueIntputBuffer failed", e16);
            return -2;
        }
    }

    @CalledByNativeUnchecked
    @Nullable
    OutputBufferInfo dequeueOutputBuffer() {
        boolean z16;
        checkOnMediaCodecThread();
        try {
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            int dequeueOutputBuffer = this.mediaCodec.dequeueOutputBuffer(bufferInfo, 0L);
            boolean z17 = true;
            if (dequeueOutputBuffer >= 0) {
                if ((bufferInfo.flags & 2) != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    Logging.d(TAG, "Config frame generated. Offset: " + bufferInfo.offset + ". Size: " + bufferInfo.size);
                    this.configData = ByteBuffer.allocateDirect(bufferInfo.size);
                    this.outputBuffers[dequeueOutputBuffer].position(bufferInfo.offset);
                    this.outputBuffers[dequeueOutputBuffer].limit(bufferInfo.offset + bufferInfo.size);
                    this.configData.put(this.outputBuffers[dequeueOutputBuffer]);
                    String str = "";
                    int i3 = 0;
                    while (true) {
                        int i16 = bufferInfo.size;
                        if (i16 >= 8) {
                            i16 = 8;
                        }
                        if (i3 >= i16) {
                            break;
                        }
                        str = str + Integer.toHexString(this.configData.get(i3) & 255) + " ";
                        i3++;
                    }
                    Logging.d(TAG, str);
                    this.mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                    dequeueOutputBuffer = this.mediaCodec.dequeueOutputBuffer(bufferInfo, 0L);
                }
            }
            int i17 = dequeueOutputBuffer;
            if (i17 >= 0) {
                ByteBuffer duplicate = this.outputBuffers[i17].duplicate();
                duplicate.position(bufferInfo.offset);
                duplicate.limit(bufferInfo.offset + bufferInfo.size);
                reportEncodedFrame(bufferInfo.size);
                if ((bufferInfo.flags & 1) == 0) {
                    z17 = false;
                }
                if (z17) {
                    Logging.d(TAG, "Sync frame generated");
                }
                if (z17 && this.type == VideoCodecType.VIDEO_CODEC_H264) {
                    Logging.d(TAG, "Appending config frame of size " + this.configData.capacity() + " to output buffer with offset " + bufferInfo.offset + ", size " + bufferInfo.size);
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.configData.capacity() + bufferInfo.size);
                    this.configData.rewind();
                    allocateDirect.put(this.configData);
                    allocateDirect.put(duplicate);
                    allocateDirect.position(0);
                    return new OutputBufferInfo(i17, allocateDirect, z17, bufferInfo.presentationTimeUs);
                }
                return new OutputBufferInfo(i17, duplicate.slice(), z17, bufferInfo.presentationTimeUs);
            }
            if (i17 == -3) {
                this.outputBuffers = this.mediaCodec.getOutputBuffers();
                return dequeueOutputBuffer();
            }
            if (i17 == -2) {
                return dequeueOutputBuffer();
            }
            if (i17 == -1) {
                return null;
            }
            throw new RuntimeException("dequeueOutputBuffer: " + i17);
        } catch (IllegalStateException e16) {
            Logging.e(TAG, "dequeueOutputBuffer failed", e16);
            return new OutputBufferInfo(-1, null, false, -1L);
        }
    }

    @CalledByNativeUnchecked
    boolean encodeBuffer(boolean z16, int i3, int i16, long j3) {
        checkOnMediaCodecThread();
        try {
            checkKeyFrameRequired(z16, j3);
            this.mediaCodec.queueInputBuffer(i3, 0, i16, j3, 0);
            return true;
        } catch (IllegalStateException e16) {
            Logging.e(TAG, "encodeBuffer failed", e16);
            return false;
        }
    }

    @CalledByNativeUnchecked
    boolean encodeFrame(long j3, boolean z16, VideoFrame videoFrame, int i3, long j16) {
        checkOnMediaCodecThread();
        try {
            checkKeyFrameRequired(z16, j16);
            VideoFrame.Buffer buffer = videoFrame.getBuffer();
            if (buffer instanceof VideoFrame.TextureBuffer) {
                VideoFrame.TextureBuffer textureBuffer = (VideoFrame.TextureBuffer) buffer;
                this.eglBase.makeCurrent();
                GLES20.glClear(16384);
                GlRectDrawer glRectDrawer = this.drawer;
                Matrix matrix = new Matrix();
                int i16 = this.width;
                int i17 = this.height;
                VideoFrameDrawer.drawTexture(glRectDrawer, textureBuffer, matrix, i16, i17, 0, 0, i16, i17);
                this.eglBase.swapBuffers(TimeUnit.MICROSECONDS.toNanos(j16));
            } else {
                VideoFrame.I420Buffer i420 = buffer.toI420();
                int i18 = (this.height + 1) / 2;
                ByteBuffer dataY = i420.getDataY();
                ByteBuffer dataU = i420.getDataU();
                ByteBuffer dataV = i420.getDataV();
                int strideY = i420.getStrideY();
                int strideU = i420.getStrideU();
                int strideV = i420.getStrideV();
                if (dataY.capacity() >= this.height * strideY) {
                    if (dataU.capacity() >= strideU * i18) {
                        if (dataV.capacity() >= i18 * strideV) {
                            nativeFillInputBuffer(j3, i3, dataY, strideY, dataU, strideU, dataV, strideV);
                            i420.release();
                            this.mediaCodec.queueInputBuffer(i3, 0, ((this.width * this.height) * 3) / 2, j16, 0);
                        } else {
                            throw new RuntimeException("V-plane buffer size too small.");
                        }
                    } else {
                        throw new RuntimeException("U-plane buffer size too small.");
                    }
                } else {
                    throw new RuntimeException("Y-plane buffer size too small.");
                }
            }
            return true;
        } catch (RuntimeException e16) {
            Logging.e(TAG, "encodeFrame failed", e16);
            return false;
        }
    }

    @CalledByNative
    int getColorFormat() {
        return this.colorFormat;
    }

    @CalledByNativeUnchecked
    ByteBuffer[] getInputBuffers() {
        ByteBuffer[] inputBuffers = this.mediaCodec.getInputBuffers();
        Logging.d(TAG, "Input buffers: " + inputBuffers.length);
        return inputBuffers;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x022d  */
    @CalledByNativeUnchecked
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    boolean initEncode(VideoCodecType videoCodecType, int i3, int i16, int i17, int i18, int i19, boolean z16) {
        String str;
        boolean z17;
        int i26;
        boolean z18;
        EncoderProperties encoderProperties;
        Logging.d(TAG, "Java initEncode: " + videoCodecType + ". Profile: " + i3 + ProgressTracer.SEPARATOR + i16 + " x " + i17 + ". @ " + i18 + " kbps. Fps: " + i19 + ". Encode from texture : " + z16);
        this.profile = i3;
        this.width = i16;
        this.height = i17;
        if (this.mediaCodecThread == null) {
            VideoCodecType videoCodecType2 = VideoCodecType.VIDEO_CODEC_VP8;
            if (videoCodecType == videoCodecType2) {
                str = "video/x-vnd.on2.vp8";
                encoderProperties = findHwEncoder("video/x-vnd.on2.vp8", vp8HwList(), z16 ? supportedSurfaceColorList : supportedColorList);
            } else if (videoCodecType == VideoCodecType.VIDEO_CODEC_VP9) {
                str = "video/x-vnd.on2.vp9";
                encoderProperties = findHwEncoder("video/x-vnd.on2.vp9", vp9HwList, z16 ? supportedSurfaceColorList : supportedColorList);
            } else if (videoCodecType == VideoCodecType.VIDEO_CODEC_H264) {
                str = "video/avc";
                EncoderProperties findHwEncoder = findHwEncoder("video/avc", h264HwList(), z16 ? supportedSurfaceColorList : supportedColorList);
                if (i3 == H264Profile.CONSTRAINED_HIGH.getValue()) {
                    if (findHwEncoder("video/avc", h264HighProfileHwList, z16 ? supportedSurfaceColorList : supportedColorList) != null) {
                        Logging.d(TAG, "High profile H.264 encoder supported.");
                        z17 = true;
                        i26 = 20;
                        z18 = z17;
                        encoderProperties = findHwEncoder;
                        if (encoderProperties != null) {
                            runningInstance = this;
                            this.colorFormat = encoderProperties.colorFormat;
                            BitrateAdjustmentType bitrateAdjustmentType = encoderProperties.bitrateAdjustmentType;
                            this.bitrateAdjustmentType = bitrateAdjustmentType;
                            int min = bitrateAdjustmentType != BitrateAdjustmentType.FRAMERATE_ADJUSTMENT ? Math.min(i19, 30) : 30;
                            this.forcedKeyFrameMs = 0L;
                            this.lastKeyFrameMs = -1L;
                            if (videoCodecType == videoCodecType2 && encoderProperties.codecName.startsWith(qcomVp8HwProperties.codecPrefix)) {
                                int i27 = Build.VERSION.SDK_INT;
                                if (i27 == 23) {
                                    this.forcedKeyFrameMs = QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_M_MS;
                                } else if (i27 > 23) {
                                    this.forcedKeyFrameMs = 15000L;
                                }
                            }
                            Logging.d(TAG, "Color format: " + this.colorFormat + ". Bitrate adjustment: " + this.bitrateAdjustmentType + ". Key frame interval: " + this.forcedKeyFrameMs + " . Initial fps: " + min);
                            int i28 = i18 * 1000;
                            this.targetBitrateBps = i28;
                            this.targetFps = min;
                            this.bitrateAccumulatorMax = ((double) i28) / 8.0d;
                            this.bitrateAccumulator = 0.0d;
                            this.bitrateObservationTimeMs = 0.0d;
                            this.bitrateAdjustmentScaleExp = 0;
                            this.mediaCodecThread = Thread.currentThread();
                            try {
                                MediaFormat createVideoFormat = MediaFormat.createVideoFormat(str, i16, i17);
                                createVideoFormat.setInteger("bitrate", this.targetBitrateBps);
                                createVideoFormat.setInteger("bitrate-mode", 2);
                                createVideoFormat.setInteger("color-format", encoderProperties.colorFormat);
                                createVideoFormat.setInteger("frame-rate", this.targetFps);
                                createVideoFormat.setInteger("i-frame-interval", i26);
                                if (z18) {
                                    createVideoFormat.setInteger("profile", 8);
                                    createVideoFormat.setInteger("level", 256);
                                }
                                Logging.d(TAG, "  Format: " + createVideoFormat);
                                MediaCodec createByCodecName = createByCodecName(encoderProperties.codecName);
                                this.mediaCodec = createByCodecName;
                                this.type = videoCodecType;
                                if (createByCodecName == null) {
                                    Logging.e(TAG, "Can not create media encoder");
                                    release();
                                    return false;
                                }
                                createByCodecName.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                                if (z16) {
                                    this.eglBase = g.h((EglBase14.Context) getEglContext(), EglBase.CONFIG_RECORDABLE);
                                    Surface createInputSurface = this.mediaCodec.createInputSurface();
                                    this.inputSurface = createInputSurface;
                                    this.eglBase.createSurface(createInputSurface);
                                    this.drawer = new GlRectDrawer();
                                }
                                this.mediaCodec.start();
                                this.outputBuffers = this.mediaCodec.getOutputBuffers();
                                Logging.d(TAG, "Output buffers: " + this.outputBuffers.length);
                                return true;
                            } catch (IllegalStateException e16) {
                                Logging.e(TAG, "initEncode failed", e16);
                                release();
                                return false;
                            }
                        }
                        throw new RuntimeException("Can not find HW encoder for " + videoCodecType);
                    }
                    Logging.d(TAG, "High profile H.264 encoder requested, but not supported. Use baseline.");
                }
                z17 = false;
                i26 = 20;
                z18 = z17;
                encoderProperties = findHwEncoder;
                if (encoderProperties != null) {
                }
            } else {
                throw new RuntimeException("initEncode: Non-supported codec " + videoCodecType);
            }
            i26 = 100;
            z18 = false;
            if (encoderProperties != null) {
            }
        } else {
            throw new RuntimeException("Forgot to release()?");
        }
    }

    @CalledByNativeUnchecked
    void release() {
        Logging.d(TAG, "Java releaseEncoder");
        checkOnMediaCodecThread();
        final C1CaughtException c1CaughtException = new C1CaughtException();
        boolean z16 = false;
        if (this.mediaCodec != null) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            new BaseThread(new Runnable() { // from class: org.tencwebrtc.MediaCodecVideoEncoder.1
                @Override // java.lang.Runnable
                public void run() {
                    Logging.d(MediaCodecVideoEncoder.TAG, "Java releaseEncoder on release thread");
                    try {
                        MediaCodecVideoEncoder.this.mediaCodec.stop();
                    } catch (Exception e16) {
                        Logging.e(MediaCodecVideoEncoder.TAG, "Media encoder stop failed", e16);
                    }
                    try {
                        MediaCodecVideoEncoder.this.mediaCodec.release();
                    } catch (Exception e17) {
                        Logging.e(MediaCodecVideoEncoder.TAG, "Media encoder release failed", e17);
                        c1CaughtException.f423845e = e17;
                    }
                    Logging.d(MediaCodecVideoEncoder.TAG, "Java releaseEncoder on release thread done");
                    countDownLatch.countDown();
                }
            }).start();
            if (!ThreadUtils.awaitUninterruptibly(countDownLatch, 5000L)) {
                Logging.e(TAG, "Media encoder release timeout");
                z16 = true;
            }
            this.mediaCodec = null;
        }
        this.mediaCodecThread = null;
        GlRectDrawer glRectDrawer = this.drawer;
        if (glRectDrawer != null) {
            glRectDrawer.release();
            this.drawer = null;
        }
        EglBase14 eglBase14 = this.eglBase;
        if (eglBase14 != null) {
            eglBase14.release();
            this.eglBase = null;
        }
        Surface surface = this.inputSurface;
        if (surface != null) {
            surface.release();
            this.inputSurface = null;
        }
        runningInstance = null;
        if (z16) {
            codecErrors++;
            if (errorCallback != null) {
                Logging.e(TAG, "Invoke codec error callback. Errors: " + codecErrors);
                errorCallback.onMediaCodecVideoEncoderCriticalError(codecErrors);
            }
            throw new RuntimeException("Media encoder release timeout.");
        }
        if (c1CaughtException.f423845e == null) {
            Logging.d(TAG, "Java releaseEncoder done");
        } else {
            RuntimeException runtimeException = new RuntimeException(c1CaughtException.f423845e);
            runtimeException.setStackTrace(ThreadUtils.concatStackTraces(c1CaughtException.f423845e.getStackTrace(), runtimeException.getStackTrace()));
            throw runtimeException;
        }
    }

    @CalledByNativeUnchecked
    boolean releaseOutputBuffer(int i3) {
        checkOnMediaCodecThread();
        try {
            this.mediaCodec.releaseOutputBuffer(i3, false);
            return true;
        } catch (IllegalStateException e16) {
            Logging.e(TAG, "releaseOutputBuffer failed", e16);
            return false;
        }
    }
}
