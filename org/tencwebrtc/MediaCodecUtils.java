package org.tencwebrtc;

import android.media.MediaCodecInfo;
import android.support.annotation.Nullable;
import com.tencent.avcore.jni.codec.HWColorFormat;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes29.dex */
class MediaCodecUtils {
    static final int COLOR_QCOM_FORMATYUV420PackedSemiPlanar32m = 2141391876;
    static final int COLOR_QCOM_FORMATYVU420PackedSemiPlanar16m4ka = 2141391874;
    static final int COLOR_QCOM_FORMATYVU420PackedSemiPlanar32m4ka = 2141391873;
    static final int COLOR_QCOM_FORMATYVU420PackedSemiPlanar64x32Tile2m8ka = 2141391875;
    static final String EXYNOS_PREFIX = "OMX.Exynos.";
    static final String INTEL_PREFIX = "OMX.Intel.";
    static final String NVIDIA_PREFIX = "OMX.Nvidia.";
    static final String QCOM_PREFIX = "OMX.qcom.";
    private static final String TAG = "MediaCodecUtils";
    static final String[] SOFTWARE_IMPLEMENTATION_PREFIXES = {"OMX.google.", "OMX.SEC."};
    static final int[] DECODER_COLOR_FORMATS = {19, 21, HWColorFormat.COLOR_QCOM_FormatYVU420SemiPlanar, 2141391873, 2141391874, 2141391875, 2141391876};
    static final int[] ENCODER_COLOR_FORMATS = {19, 21, HWColorFormat.COLOR_QCOM_FormatYVU420SemiPlanar, 2141391876};
    static final int[] TEXTURE_COLOR_FORMATS = getTextureColorFormats();

    /* compiled from: P */
    /* renamed from: org.tencwebrtc.MediaCodecUtils$1, reason: invalid class name */
    /* loaded from: classes29.dex */
    static /* synthetic */ class AnonymousClass1 {
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
                $SwitchMap$org$tencwebrtc$VideoCodecType[VideoCodecType.H265.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$tencwebrtc$VideoCodecType[VideoCodecType.H264.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    MediaCodecUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean codecSupportsType(MediaCodecInfo mediaCodecInfo, VideoCodecType videoCodecType) {
        for (String str : mediaCodecInfo.getSupportedTypes()) {
            if (videoCodecType.mimeType().equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, String> getCodecProperties(VideoCodecType videoCodecType, boolean z16) {
        int i3 = AnonymousClass1.$SwitchMap$org$tencwebrtc$VideoCodecType[videoCodecType.ordinal()];
        if (i3 != 1 && i3 != 2 && i3 != 3) {
            if (i3 == 4) {
                return H264Utils.getDefaultH264Params(z16);
            }
            throw new IllegalArgumentException("Unsupported codec: " + videoCodecType);
        }
        return new HashMap();
    }

    private static int[] getTextureColorFormats() {
        return new int[]{2130708361};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Integer selectColorFormat(int[] iArr, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        for (int i3 : iArr) {
            for (int i16 : codecCapabilities.colorFormats) {
                if (i16 == i3) {
                    return Integer.valueOf(i16);
                }
            }
        }
        return null;
    }
}
