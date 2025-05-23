package com.tencent.gamematrix.gmcg.webrtc;

import android.media.MediaCodecInfo;
import androidx.annotation.Nullable;
import com.tencent.avcore.jni.codec.HWColorFormat;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public class MediaCodecUtils {
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
    public static final int[] DECODER_COLOR_FORMATS = {19, 21, HWColorFormat.COLOR_QCOM_FormatYVU420SemiPlanar, 2141391873, 2141391874, 2141391875, 2141391876};
    static final int[] ENCODER_COLOR_FORMATS = {19, 21, HWColorFormat.COLOR_QCOM_FormatYVU420SemiPlanar, 2141391876};
    static final int[] TEXTURE_COLOR_FORMATS = getTextureColorFormats();

    /* compiled from: P */
    /* renamed from: com.tencent.gamematrix.gmcg.webrtc.MediaCodecUtils$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {
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
                $SwitchMap$com$tencent$gamematrix$gmcg$webrtc$CodecMimeType[CodecMimeType.H265.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$tencent$gamematrix$gmcg$webrtc$CodecMimeType[CodecMimeType.H264.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    MediaCodecUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean codecSupportsType(MediaCodecInfo mediaCodecInfo, CodecMimeType codecMimeType) {
        for (String str : mediaCodecInfo.getSupportedTypes()) {
            CGLog.i("mimeType:" + str + ", target mime:" + codecMimeType.mimeType());
            if (codecMimeType.mimeType().equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, String> getCodecProperties(CodecMimeType codecMimeType, boolean z16) {
        int i3 = AnonymousClass1.$SwitchMap$com$tencent$gamematrix$gmcg$webrtc$CodecMimeType[codecMimeType.ordinal()];
        if (i3 != 1 && i3 != 2 && i3 != 3) {
            if (i3 == 4) {
                return H264Utils.getDefaultH264Params(z16);
            }
            throw new IllegalArgumentException("Unsupported codec: " + codecMimeType);
        }
        return new HashMap();
    }

    private static int[] getTextureColorFormats() {
        return new int[]{2130708361};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Integer selectColorFormat(int[] iArr, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        CGLog.i("selectColorFormat supportedColorFormats=" + Arrays.toString(iArr) + ",capabilities=" + Arrays.toString(codecCapabilities.colorFormats));
        int length = iArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            int i16 = iArr[i3];
            for (int i17 : codecCapabilities.colorFormats) {
                CGLog.i("webrtcSupportedColorFormat=" + i16 + ",AndroidCodecColorFormat=" + i17);
                if (i17 == i16) {
                    return Integer.valueOf(i17);
                }
            }
        }
        return 21;
    }
}
