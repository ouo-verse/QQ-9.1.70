package com.tencent.liteav.videobase.common;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.util.Range;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;

/* compiled from: P */
@JNINamespace("liteav::video")
/* loaded from: classes7.dex */
public class MediaCodecAbility {
    private static final String TAG = "MediaCodecAbility";

    public static int getMediaCodecDecoderSupportLowResolution() {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        if (LiteavSystemInfo.getSystemOSVersionInt() < 21) {
            return 0;
        }
        try {
            MediaCodecInfo.CodecCapabilities capabilitiesForType = MediaCodec.createDecoderByType("video/avc").getCodecInfo().getCapabilitiesForType("video/avc");
            if (capabilitiesForType == null || (videoCapabilities = capabilitiesForType.getVideoCapabilities()) == null) {
                return 0;
            }
            Range<Integer> supportedWidths = videoCapabilities.getSupportedWidths();
            Range<Integer> supportedHeights = videoCapabilities.getSupportedHeights();
            if (supportedWidths != null && supportedHeights != null) {
                return Math.max(supportedWidths.getLower().intValue(), supportedHeights.getLower().intValue());
            }
            return 0;
        } catch (Throwable th5) {
            LiteavLog.e(TAG, "get low resolution error:".concat(String.valueOf(th5)));
            return 0;
        }
    }

    public static boolean isDecoderSupportHevc() {
        boolean z16 = false;
        if (LiteavSystemInfo.getSystemOSVersionInt() < 21) {
            return false;
        }
        try {
            boolean z17 = false;
            for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(0).getCodecInfos()) {
                try {
                    String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
                    if (!mediaCodecInfo.isEncoder()) {
                        int length = supportedTypes.length;
                        int i3 = 0;
                        while (true) {
                            if (i3 >= length) {
                                break;
                            }
                            if (supportedTypes[i3].contains("video/hevc")) {
                                z17 = true;
                                LiteavLog.i(TAG, "got hevc decoder:%s", mediaCodecInfo.getName());
                                break;
                            }
                            i3++;
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    z16 = z17;
                    LiteavLog.e(TAG, "get hevc decode error:".concat(String.valueOf(th)));
                    return z16;
                }
            }
            return z17;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static boolean isEncoderSupportHevc() {
        if (LiteavSystemInfo.getSystemOSVersionInt() < 21) {
            return false;
        }
        try {
            for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(1).getCodecInfos()) {
                if (mediaCodecInfo.isEncoder()) {
                    for (String str : mediaCodecInfo.getSupportedTypes()) {
                        if (str.contains("video/hevc")) {
                            LiteavLog.i(TAG, "get hevc encoder");
                            return true;
                        }
                    }
                }
            }
        } catch (Throwable th5) {
            LiteavLog.w(TAG, "failed to get hevc encoder:".concat(String.valueOf(th5)));
        }
        LiteavLog.w(TAG, "not got hevc encoder");
        return false;
    }

    public static boolean isMediaCodecDecodeSupportSWHevc() {
        if (LiteavSystemInfo.getSystemOSVersionInt() < 21) {
            return false;
        }
        try {
            for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(0).getCodecInfos()) {
                String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
                if (!mediaCodecInfo.isEncoder()) {
                    for (String str : supportedTypes) {
                        if (str.contains("video/hevc") && isSoftOnlyDecoder(mediaCodecInfo)) {
                            LiteavLog.i(TAG, "got soft only hevc decoder:%s", mediaCodecInfo.getName());
                            return true;
                        }
                    }
                }
            }
        } catch (Throwable th5) {
            LiteavLog.e(TAG, "get hevc decode error:".concat(String.valueOf(th5)));
        }
        return false;
    }

    public static boolean isSoftOnlyDecoder(MediaCodecInfo mediaCodecInfo) {
        boolean isSoftwareOnly;
        if (LiteavSystemInfo.getSystemOSVersionInt() > 29) {
            isSoftwareOnly = mediaCodecInfo.isSoftwareOnly();
            return isSoftwareOnly;
        }
        if (!mediaCodecInfo.getName().contains("android") && !mediaCodecInfo.getName().contains("google")) {
            return false;
        }
        return true;
    }
}
