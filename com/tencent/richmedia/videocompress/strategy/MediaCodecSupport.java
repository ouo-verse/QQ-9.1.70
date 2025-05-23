package com.tencent.richmedia.videocompress.strategy;

import android.content.Context;
import android.media.MediaCodecInfo;
import com.tencent.richmedia.videocompress.mediacodec.MediaCodecUtil;
import com.tencent.richmedia.videocompress.mediacodec.MediaCodecWrapper;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes25.dex */
public class MediaCodecSupport {
    public static String AVC_CODEC_MIME = "video/avc";
    public static final int COLOR_FormatYUV420Planar = 19;
    public static final int COLOR_FormatYUV420SemiPlanar = 21;
    public static final int COLOR_MTK_FormatYUV420Planar = 2130706944;
    public static final int COLOR_QCOM_FormatYUV420PackedSemiPlanar32m = 2141391876;
    public static String HEVC_CODEC_MIME = "video/hevc";
    public static final int SUPPORT_AVC_DEC = 1;
    public static final int SUPPORT_AVC_ENC = 2;
    public static final int SUPPORT_HEVC_DEC = 4;
    public static final int SUPPORT_HEVC_ENC = 8;
    public static final int SUPPORT_NONE = 0;
    private static final String TAG = "MediaCodecSupport";
    public static int mMediaCodecFeature = -1;

    private static boolean checkDecoderSupportColorFormat(int i3) {
        if (i3 != 19 && i3 != 21 && i3 != 2130706944 && i3 != 2141391876) {
            return false;
        }
        return true;
    }

    private static boolean checkEncoderSupportColorFormat(int i3) {
        if (i3 != 19 && i3 != 21) {
            return false;
        }
        return true;
    }

    public static int checkSupportMediaCodecFeature(Context context) {
        int i3 = mMediaCodecFeature;
        if (i3 >= 0) {
            return i3;
        }
        mMediaCodecFeature = 0;
        if (context == null) {
            return 0;
        }
        MediaCodecWrapper.invoke21Apis();
        if (!MediaCodecWrapper.invokeAPILevel21) {
            mMediaCodecFeature = 0;
            return 0;
        }
        if (isAVCDecSupportColorFormats()) {
            mMediaCodecFeature = 1;
        }
        if (isAVCEncSupportColorFormats()) {
            mMediaCodecFeature += 2;
        }
        return mMediaCodecFeature;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x000b, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean isAVCDecSupportColorFormats() {
        Iterator<MediaCodecInfo> it = MediaCodecUtil.getDecoderInfoList(AVC_CODEC_MIME, false).iterator();
        while (it.hasNext()) {
            MediaCodecInfo.CodecCapabilities codecCapabilities = MediaCodecUtil.getCodecCapabilities(it.next(), AVC_CODEC_MIME);
            if (codecCapabilities != null && codecCapabilities.colorFormats != null) {
                int i3 = 0;
                while (true) {
                    int[] iArr = codecCapabilities.colorFormats;
                    if (i3 < iArr.length) {
                        if (checkDecoderSupportColorFormat(iArr[i3])) {
                            return true;
                        }
                        i3++;
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x000a, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean isAVCEncSupportColorFormats() {
        Iterator<MediaCodecInfo> it = MediaCodecUtil.getEncoderInfoList(AVC_CODEC_MIME).iterator();
        while (true) {
            int i3 = 0;
            if (!it.hasNext()) {
                return false;
            }
            MediaCodecInfo.CodecCapabilities codecCapabilities = MediaCodecUtil.getCodecCapabilities(it.next(), AVC_CODEC_MIME);
            if (codecCapabilities != null) {
                while (true) {
                    int[] iArr = codecCapabilities.colorFormats;
                    if (i3 < iArr.length) {
                        if (checkEncoderSupportColorFormat(iArr[i3])) {
                            return true;
                        }
                        i3++;
                    }
                }
            }
        }
    }
}
