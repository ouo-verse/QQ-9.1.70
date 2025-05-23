package org.tencwebrtc;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.support.annotation.Nullable;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.tencwebrtc.EglBase;
import org.tencwebrtc.EglBase14;

/* compiled from: P */
/* loaded from: classes29.dex */
public class HardwareVideoEncoderFactory implements VideoEncoderFactory {
    private static final List<String> H264_HW_EXCEPTION_MODELS = Arrays.asList("SAMSUNG-SGH-I337", "Nexus 7", "Nexus 4");
    private static final int QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_L_MS = 15000;
    private static final int QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_M_MS = 20000;
    private static final int QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_N_MS = 15000;
    private static final String TAG = "HardwareVideoEncoderFactory";

    @Nullable
    private final Predicate<MediaCodecInfo> codecAllowedPredicate;
    private final boolean enableH264HighProfile;
    private final boolean enableIntelVp8Encoder;

    @Nullable
    private final EglBase14.Context sharedContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: org.tencwebrtc.HardwareVideoEncoderFactory$1, reason: invalid class name */
    /* loaded from: classes29.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$tencwebrtc$VideoCodecType;

        static {
            int[] iArr = new int[VideoCodecType.values().length];
            $SwitchMap$org$tencwebrtc$VideoCodecType = iArr;
            try {
                iArr[VideoCodecType.VP8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$tencwebrtc$VideoCodecType[VideoCodecType.VP9.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$tencwebrtc$VideoCodecType[VideoCodecType.H264.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$tencwebrtc$VideoCodecType[VideoCodecType.H265.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public HardwareVideoEncoderFactory(EglBase.Context context, boolean z16, boolean z17) {
        this(context, z16, z17, null);
    }

    private BitrateAdjuster createBitrateAdjuster(VideoCodecType videoCodecType, String str) {
        if (str.startsWith("OMX.Exynos.")) {
            if (videoCodecType == VideoCodecType.VP8) {
                return new DynamicBitrateAdjuster();
            }
            return new FramerateBitrateAdjuster();
        }
        return new BaseBitrateAdjuster();
    }

    @Nullable
    private MediaCodecInfo findCodecForType(VideoCodecType videoCodecType) {
        int i3 = 0;
        while (true) {
            MediaCodecInfo mediaCodecInfo = null;
            if (i3 >= MediaCodecList.getCodecCount()) {
                return null;
            }
            try {
                mediaCodecInfo = MediaCodecList.getCodecInfoAt(i3);
            } catch (IllegalArgumentException e16) {
                Logging.e(TAG, "Cannot retrieve encoder codec info", e16);
            }
            if (mediaCodecInfo != null && mediaCodecInfo.isEncoder() && isSupportedCodec(mediaCodecInfo, videoCodecType)) {
                return mediaCodecInfo;
            }
            i3++;
        }
    }

    private int getForcedKeyFrameIntervalMs(VideoCodecType videoCodecType, String str) {
        if (videoCodecType == VideoCodecType.VP8 && str.startsWith("OMX.qcom.")) {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 == 23) {
                return 20000;
            }
            if (i3 > 23) {
                return 15000;
            }
            return 0;
        }
        return 0;
    }

    private int getKeyFrameIntervalSec(VideoCodecType videoCodecType) {
        int i3 = AnonymousClass1.$SwitchMap$org$tencwebrtc$VideoCodecType[videoCodecType.ordinal()];
        if (i3 != 1 && i3 != 2) {
            if (i3 != 3 && i3 != 4) {
                throw new IllegalArgumentException("Unsupported VideoCodecType " + videoCodecType);
            }
            return 20;
        }
        return 100;
    }

    private boolean isH264HighProfileSupported(MediaCodecInfo mediaCodecInfo) {
        if (this.enableH264HighProfile && Build.VERSION.SDK_INT > 23 && mediaCodecInfo.getName().startsWith("OMX.Exynos.")) {
            return true;
        }
        return false;
    }

    private boolean isHardwareSupportedInCurrentSdk(MediaCodecInfo mediaCodecInfo, VideoCodecType videoCodecType) {
        int i3 = AnonymousClass1.$SwitchMap$org$tencwebrtc$VideoCodecType[videoCodecType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return false;
                    }
                    return isHardwareSupportedInCurrentSdkH265(mediaCodecInfo);
                }
                return isHardwareSupportedInCurrentSdkH264(mediaCodecInfo);
            }
            return isHardwareSupportedInCurrentSdkVp9(mediaCodecInfo);
        }
        return isHardwareSupportedInCurrentSdkVp8(mediaCodecInfo);
    }

    private boolean isHardwareSupportedInCurrentSdkH264(MediaCodecInfo mediaCodecInfo) {
        if (H264_HW_EXCEPTION_MODELS.contains(DeviceInfoMonitor.getModel())) {
            return false;
        }
        mediaCodecInfo.getName();
        return true;
    }

    private boolean isHardwareSupportedInCurrentSdkH265(MediaCodecInfo mediaCodecInfo) {
        mediaCodecInfo.getName();
        return true;
    }

    private boolean isHardwareSupportedInCurrentSdkVp8(MediaCodecInfo mediaCodecInfo) {
        String name = mediaCodecInfo.getName();
        if (name.startsWith("OMX.qcom.") || name.startsWith("OMX.Exynos.") || (name.startsWith("OMX.Intel.") && this.enableIntelVp8Encoder)) {
            return true;
        }
        return false;
    }

    private boolean isHardwareSupportedInCurrentSdkVp9(MediaCodecInfo mediaCodecInfo) {
        String name = mediaCodecInfo.getName();
        if ((name.startsWith("OMX.qcom.") || name.startsWith("OMX.Exynos.")) && Build.VERSION.SDK_INT >= 24) {
            return true;
        }
        return false;
    }

    private boolean isMediaCodecAllowed(MediaCodecInfo mediaCodecInfo) {
        Predicate<MediaCodecInfo> predicate = this.codecAllowedPredicate;
        if (predicate == null) {
            return true;
        }
        return predicate.test(mediaCodecInfo);
    }

    private boolean isSupportedCodec(MediaCodecInfo mediaCodecInfo, VideoCodecType videoCodecType) {
        if (!MediaCodecUtils.codecSupportsType(mediaCodecInfo, videoCodecType) || MediaCodecUtils.selectColorFormat(MediaCodecUtils.ENCODER_COLOR_FORMATS, mediaCodecInfo.getCapabilitiesForType(videoCodecType.mimeType())) == null || !isHardwareSupportedInCurrentSdk(mediaCodecInfo, videoCodecType) || !isMediaCodecAllowed(mediaCodecInfo)) {
            return false;
        }
        return true;
    }

    @Override // org.tencwebrtc.VideoEncoderFactory
    @Nullable
    public VideoEncoder createEncoder(VideoCodecInfo videoCodecInfo) {
        VideoCodecType valueOf = VideoCodecType.valueOf(videoCodecInfo.name);
        MediaCodecInfo findCodecForType = findCodecForType(valueOf);
        if (findCodecForType == null) {
            return null;
        }
        String name = findCodecForType.getName();
        String mimeType = valueOf.mimeType();
        Integer selectColorFormat = MediaCodecUtils.selectColorFormat(MediaCodecUtils.TEXTURE_COLOR_FORMATS, findCodecForType.getCapabilitiesForType(mimeType));
        Integer selectColorFormat2 = MediaCodecUtils.selectColorFormat(MediaCodecUtils.ENCODER_COLOR_FORMATS, findCodecForType.getCapabilitiesForType(mimeType));
        if (valueOf == VideoCodecType.H264) {
            boolean isSameH264Profile = H264Utils.isSameH264Profile(videoCodecInfo.params, MediaCodecUtils.getCodecProperties(valueOf, true));
            boolean isSameH264Profile2 = H264Utils.isSameH264Profile(videoCodecInfo.params, MediaCodecUtils.getCodecProperties(valueOf, false));
            if (!isSameH264Profile && !isSameH264Profile2) {
                return null;
            }
            if (isSameH264Profile && !isH264HighProfileSupported(findCodecForType)) {
                return null;
            }
        }
        return new HardwareVideoEncoder(new MediaCodecWrapperFactoryImpl(), name, valueOf, selectColorFormat, selectColorFormat2, videoCodecInfo.params, getKeyFrameIntervalSec(valueOf), getForcedKeyFrameIntervalMs(valueOf, name), createBitrateAdjuster(valueOf, name), this.sharedContext);
    }

    @Override // org.tencwebrtc.VideoEncoderFactory
    public VideoCodecInfo[] getSupportedCodecs() {
        ArrayList arrayList = new ArrayList();
        VideoCodecType[] videoCodecTypeArr = {VideoCodecType.H264, VideoCodecType.H265};
        for (int i3 = 0; i3 < 2; i3++) {
            VideoCodecType videoCodecType = videoCodecTypeArr[i3];
            MediaCodecInfo findCodecForType = findCodecForType(videoCodecType);
            if (findCodecForType != null) {
                String name = videoCodecType.name();
                if (videoCodecType == VideoCodecType.H264 && isH264HighProfileSupported(findCodecForType)) {
                    arrayList.add(new VideoCodecInfo(name, MediaCodecUtils.getCodecProperties(videoCodecType, true)));
                }
                arrayList.add(new VideoCodecInfo(name, MediaCodecUtils.getCodecProperties(videoCodecType, false)));
            }
        }
        return (VideoCodecInfo[]) arrayList.toArray(new VideoCodecInfo[arrayList.size()]);
    }

    public HardwareVideoEncoderFactory(EglBase.Context context, boolean z16, boolean z17, @Nullable Predicate<MediaCodecInfo> predicate) {
        if (context instanceof EglBase14.Context) {
            this.sharedContext = (EglBase14.Context) context;
        } else {
            Logging.w(TAG, "No shared EglBase.Context.  Encoders will not use texture mode.");
            this.sharedContext = null;
        }
        this.enableIntelVp8Encoder = z16;
        this.enableH264HighProfile = z17;
        this.codecAllowedPredicate = predicate;
    }

    @Deprecated
    public HardwareVideoEncoderFactory(boolean z16, boolean z17) {
        this(null, z16, z17);
    }
}
