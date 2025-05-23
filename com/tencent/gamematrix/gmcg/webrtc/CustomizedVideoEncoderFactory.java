package com.tencent.gamematrix.gmcg.webrtc;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import androidx.annotation.Nullable;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.tencwebrtc.EglBase;
import org.tencwebrtc.EglBase14;
import org.tencwebrtc.Predicate;
import org.tencwebrtc.VideoCodecInfo;
import org.tencwebrtc.VideoEncoder;
import org.tencwebrtc.VideoEncoderFactory;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CustomizedVideoEncoderFactory implements VideoEncoderFactory {
    static final String EXYNOS_PREFIX = "OMX.Exynos.";
    static final String INTEL_PREFIX = "OMX.Intel.";
    static final String NVIDIA_PREFIX = "OMX.Nvidia.";
    static final String QCOM_PREFIX = "OMX.qcom.";
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
    static final String[] SOFTWARE_IMPLEMENTATION_PREFIXES = {"OMX.google.", "OMX.SEC."};
    private static final List<String> H264_HW_EXCEPTION_MODELS = Arrays.asList("SAMSUNG-SGH-I337", "Nexus 7", "Nexus 4");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.gamematrix.gmcg.webrtc.CustomizedVideoEncoderFactory$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$gamematrix$gmcg$webrtc$CodecMimeType;

        static {
            int[] iArr = new int[CodecMimeType.values().length];
            $SwitchMap$com$tencent$gamematrix$gmcg$webrtc$CodecMimeType = iArr;
            try {
                iArr[CodecMimeType.VP8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$gamematrix$gmcg$webrtc$CodecMimeType[CodecMimeType.VP9.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$gamematrix$gmcg$webrtc$CodecMimeType[CodecMimeType.H264.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$tencent$gamematrix$gmcg$webrtc$CodecMimeType[CodecMimeType.H265.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public CustomizedVideoEncoderFactory(EglBase.Context context, boolean z16, boolean z17) {
        this(context, z16, z17, null);
    }

    private BitrateAdjuster createBitrateAdjuster(CodecMimeType codecMimeType, String str) {
        if (str.startsWith(EXYNOS_PREFIX)) {
            if (codecMimeType == CodecMimeType.VP8) {
                return new DynamicBitrateAdjuster();
            }
            return new FramerateBitrateAdjuster();
        }
        return new BaseBitrateAdjuster();
    }

    @Nullable
    private MediaCodecInfo findCodecForType(CodecMimeType codecMimeType) {
        int i3 = 0;
        while (true) {
            MediaCodecInfo mediaCodecInfo = null;
            if (i3 >= MediaCodecList.getCodecCount()) {
                return null;
            }
            try {
                mediaCodecInfo = MediaCodecList.getCodecInfoAt(i3);
            } catch (IllegalArgumentException e16) {
                CGLog.e("Cannot retrieve encoder codec info" + e16);
            }
            if (mediaCodecInfo != null && mediaCodecInfo.isEncoder() && isSupportedCodec(mediaCodecInfo, codecMimeType)) {
                return mediaCodecInfo;
            }
            i3++;
        }
    }

    private int getForcedKeyFrameIntervalMs(CodecMimeType codecMimeType, String str) {
        if (codecMimeType == CodecMimeType.VP8 && str.startsWith(QCOM_PREFIX)) {
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

    private int getKeyFrameIntervalSec(CodecMimeType codecMimeType) {
        int i3 = AnonymousClass1.$SwitchMap$com$tencent$gamematrix$gmcg$webrtc$CodecMimeType[codecMimeType.ordinal()];
        if (i3 != 1 && i3 != 2) {
            if (i3 != 3 && i3 != 4) {
                throw new IllegalArgumentException("Unsupported CodecMimeType " + codecMimeType);
            }
            return 20;
        }
        return 100;
    }

    private boolean isH264HighProfileSupported(MediaCodecInfo mediaCodecInfo) {
        if (this.enableH264HighProfile && Build.VERSION.SDK_INT > 23 && mediaCodecInfo.getName().startsWith(EXYNOS_PREFIX)) {
            return true;
        }
        return false;
    }

    private boolean isHardwareSupportedInCurrentSdk(MediaCodecInfo mediaCodecInfo, CodecMimeType codecMimeType) {
        int i3 = AnonymousClass1.$SwitchMap$com$tencent$gamematrix$gmcg$webrtc$CodecMimeType[codecMimeType.ordinal()];
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
        if (name.startsWith(QCOM_PREFIX) || name.startsWith(EXYNOS_PREFIX) || (name.startsWith(INTEL_PREFIX) && this.enableIntelVp8Encoder)) {
            return true;
        }
        return false;
    }

    private boolean isHardwareSupportedInCurrentSdkVp9(MediaCodecInfo mediaCodecInfo) {
        String name = mediaCodecInfo.getName();
        if ((name.startsWith(QCOM_PREFIX) || name.startsWith(EXYNOS_PREFIX)) && Build.VERSION.SDK_INT >= 24) {
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

    private boolean isSupportedCodec(MediaCodecInfo mediaCodecInfo, CodecMimeType codecMimeType) {
        if (!MediaCodecUtils.codecSupportsType(mediaCodecInfo, codecMimeType) || MediaCodecUtils.selectColorFormat(MediaCodecUtils.ENCODER_COLOR_FORMATS, mediaCodecInfo.getCapabilitiesForType(codecMimeType.mimeType())) == null || !isHardwareSupportedInCurrentSdk(mediaCodecInfo, codecMimeType) || !isMediaCodecAllowed(mediaCodecInfo)) {
            return false;
        }
        return true;
    }

    @Override // org.tencwebrtc.VideoEncoderFactory
    @Nullable
    public VideoEncoder createEncoder(VideoCodecInfo videoCodecInfo) {
        CodecMimeType valueOf = CodecMimeType.valueOf(videoCodecInfo.name);
        MediaCodecInfo findCodecForType = findCodecForType(valueOf);
        if (findCodecForType == null) {
            return null;
        }
        String name = findCodecForType.getName();
        String mimeType = valueOf.mimeType();
        return new CustomizedVideoEncoder(name, valueOf, MediaCodecUtils.selectColorFormat(MediaCodecUtils.TEXTURE_COLOR_FORMATS, findCodecForType.getCapabilitiesForType(mimeType)), MediaCodecUtils.selectColorFormat(MediaCodecUtils.ENCODER_COLOR_FORMATS, findCodecForType.getCapabilitiesForType(mimeType)), videoCodecInfo.params, getKeyFrameIntervalSec(valueOf), getForcedKeyFrameIntervalMs(valueOf, name), createBitrateAdjuster(valueOf, name), this.sharedContext);
    }

    @Override // org.tencwebrtc.VideoEncoderFactory
    public VideoCodecInfo[] getSupportedCodecs() {
        ArrayList arrayList = new ArrayList();
        CodecMimeType[] codecMimeTypeArr = {CodecMimeType.H264, CodecMimeType.VP8, CodecMimeType.VP9, CodecMimeType.H265};
        for (int i3 = 0; i3 < 4; i3++) {
            CodecMimeType codecMimeType = codecMimeTypeArr[i3];
            MediaCodecInfo findCodecForType = findCodecForType(codecMimeType);
            if (findCodecForType != null) {
                String name = codecMimeType.name();
                if (codecMimeType == CodecMimeType.H264 && isH264HighProfileSupported(findCodecForType)) {
                    arrayList.add(new VideoCodecInfo(name, MediaCodecUtils.getCodecProperties(codecMimeType, true)));
                }
                arrayList.add(new VideoCodecInfo(name, MediaCodecUtils.getCodecProperties(codecMimeType, false)));
            }
        }
        return (VideoCodecInfo[]) arrayList.toArray(new VideoCodecInfo[arrayList.size()]);
    }

    public CustomizedVideoEncoderFactory(EglBase.Context context, boolean z16, boolean z17, @Nullable Predicate<MediaCodecInfo> predicate) {
        if (context instanceof EglBase14.Context) {
            this.sharedContext = (EglBase14.Context) context;
        } else {
            CGLog.i("No shared EglBase.Context.  Encoders will not use texture mode.");
            this.sharedContext = null;
        }
        this.enableIntelVp8Encoder = z16;
        this.enableH264HighProfile = z17;
        this.codecAllowedPredicate = predicate;
    }

    @Deprecated
    public CustomizedVideoEncoderFactory(boolean z16, boolean z17) {
        this(null, z16, z17);
    }
}
