package com.tencent.thumbplayer.core.codec.tmediacodec.reuse;

import android.media.MediaFormat;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.thumbplayer.core.codec.tmediacodec.TCodecManager;
import com.tencent.thumbplayer.core.codec.tmediacodec.codec.AudioCodecWrapper;
import com.tencent.thumbplayer.core.codec.tmediacodec.codec.FormatWrapper;
import com.tencent.thumbplayer.core.codec.tmediacodec.codec.ReuseCodecWrapper;
import com.tencent.thumbplayer.core.codec.tmediacodec.codec.VideoCodecWrapper;
import com.tencent.thumbplayer.core.codec.tmediacodec.util.LogUtils;
import com.tencent.thumbplayer.core.codec.tmediacodec.util.TUtils;
import com.tencent.thumbplayer.core.utils.TPSystemInfo;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class ReuseHelper {
    public static final String TAG = "ReuseHelper";

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public enum AdaptationWorkaroundMode {
        ADAPTATION_WORKAROUND_MODE_NEVER,
        ADAPTATION_WORKAROUND_MODE_SAME_RESOLUTION,
        ADAPTATION_WORKAROUND_MODE_ALWAYS
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public enum ReuseType {
        KEEP_CODEC_RESULT_NO,
        KEEP_CODEC_RESULT_YES_WITH_FLUSH,
        KEEP_CODEC_RESULT_YES_WITH_RECONFIGURATION,
        KEEP_CODEC_RESULT_YES_WITHOUT_RECONFIGURATION
    }

    ReuseHelper() {
    }

    @NonNull
    public static AdaptationWorkaroundMode codecAdaptationWorkaroundMode(@NonNull String str) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 <= 25 && "OMX.Exynos.avc.dec.secure".equals(str) && (TPSystemInfo.getDeviceName().startsWith("SM-T585") || TPSystemInfo.getDeviceName().startsWith("SM-A510") || TPSystemInfo.getDeviceName().startsWith("SM-A520") || TPSystemInfo.getDeviceName().startsWith("SM-J700"))) {
            return AdaptationWorkaroundMode.ADAPTATION_WORKAROUND_MODE_ALWAYS;
        }
        if (i3 < 24 && ("OMX.Nvidia.h264.decode".equals(str) || "OMX.Nvidia.h264.decode.secure".equals(str))) {
            String str2 = Build.DEVICE;
            if ("flounder".equals(str2) || "flounder_lte".equals(str2) || "grouper".equals(str2) || "tilapia".equals(str2)) {
                return AdaptationWorkaroundMode.ADAPTATION_WORKAROUND_MODE_SAME_RESOLUTION;
            }
        }
        return AdaptationWorkaroundMode.ADAPTATION_WORKAROUND_MODE_NEVER;
    }

    public static void initFormatWrapper(@NonNull FormatWrapper formatWrapper, @NonNull MediaFormat mediaFormat) {
        ReusePolicy reusePolicy = TCodecManager.getInstance().getReusePolicy();
        int max = Math.max(reusePolicy.initWidth, formatWrapper.width);
        int max2 = Math.max(reusePolicy.initHeight, formatWrapper.height);
        if (reusePolicy.reConfigByRealFormat) {
            reusePolicy.initWidth = max;
            reusePolicy.initHeight = max2;
        }
        int max3 = Math.max(0, TUtils.getCodecMaxInputSize(formatWrapper.sampleMimeType, max, max2, false));
        if (LogUtils.isLogEnable()) {
            LogUtils.d("ReuseHelper", "initFormatWrapper initWidth:" + max + " initHeight:" + max2 + " initMaxInputSize:" + max3 + TokenParser.SP + "reusePolicy:" + reusePolicy);
        }
        formatWrapper.maxWidth = max;
        formatWrapper.maxHeight = max2;
        formatWrapper.maxInputSize = max3;
        mediaFormat.setInteger("max-input-size", Math.max(max3, 0));
        if (formatWrapper.isVideo()) {
            mediaFormat.setInteger("max-width", max);
            mediaFormat.setInteger("max-height", max2);
        }
    }

    public static boolean isSeamlessAdaptationSupported(@NonNull ReuseCodecWrapper reuseCodecWrapper, @NonNull FormatWrapper formatWrapper) {
        return isSeamlessAdaptationSupported(reuseCodecWrapper, formatWrapper, false);
    }

    public static boolean isSeamlessAdaptationSupported(@NonNull ReuseCodecWrapper reuseCodecWrapper, @NonNull FormatWrapper formatWrapper, boolean z16) {
        FormatWrapper formatWrapper2 = reuseCodecWrapper.mFormat;
        if (reuseCodecWrapper instanceof VideoCodecWrapper) {
            if (TextUtils.equals(formatWrapper2.sampleMimeType, formatWrapper.sampleMimeType) && formatWrapper2.rotationDegrees == formatWrapper.rotationDegrees) {
                return reuseCodecWrapper.mAdaptive || (formatWrapper2.width == formatWrapper.width && formatWrapper2.height == formatWrapper.height);
            }
            return false;
        }
        if (!(reuseCodecWrapper instanceof AudioCodecWrapper)) {
            return true;
        }
        if (TextUtils.equals("audio/mp4a-latm", formatWrapper2.sampleMimeType)) {
            TextUtils.equals(formatWrapper2.sampleMimeType, formatWrapper.sampleMimeType);
        }
        return false;
    }
}
