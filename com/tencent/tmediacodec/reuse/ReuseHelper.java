package com.tencent.tmediacodec.reuse;

import android.media.MediaFormat;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.tmediacodec.TCodecManager;
import com.tencent.tmediacodec.codec.AudioCodecWrapper;
import com.tencent.tmediacodec.codec.FormatWrapper;
import com.tencent.tmediacodec.codec.ReuseCodecWrapper;
import com.tencent.tmediacodec.codec.VideoCodecWrapper;
import com.tencent.tmediacodec.util.LogUtils;
import com.tencent.tmediacodec.util.TUtils;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class ReuseHelper {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "ReuseHelper";

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static final class AdaptationWorkaroundMode {
        private static final /* synthetic */ AdaptationWorkaroundMode[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final AdaptationWorkaroundMode ADAPTATION_WORKAROUND_MODE_ALWAYS;
        public static final AdaptationWorkaroundMode ADAPTATION_WORKAROUND_MODE_NEVER;
        public static final AdaptationWorkaroundMode ADAPTATION_WORKAROUND_MODE_SAME_RESOLUTION;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61670);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            AdaptationWorkaroundMode adaptationWorkaroundMode = new AdaptationWorkaroundMode("ADAPTATION_WORKAROUND_MODE_NEVER", 0);
            ADAPTATION_WORKAROUND_MODE_NEVER = adaptationWorkaroundMode;
            AdaptationWorkaroundMode adaptationWorkaroundMode2 = new AdaptationWorkaroundMode("ADAPTATION_WORKAROUND_MODE_SAME_RESOLUTION", 1);
            ADAPTATION_WORKAROUND_MODE_SAME_RESOLUTION = adaptationWorkaroundMode2;
            AdaptationWorkaroundMode adaptationWorkaroundMode3 = new AdaptationWorkaroundMode("ADAPTATION_WORKAROUND_MODE_ALWAYS", 2);
            ADAPTATION_WORKAROUND_MODE_ALWAYS = adaptationWorkaroundMode3;
            $VALUES = new AdaptationWorkaroundMode[]{adaptationWorkaroundMode, adaptationWorkaroundMode2, adaptationWorkaroundMode3};
        }

        AdaptationWorkaroundMode(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static AdaptationWorkaroundMode valueOf(String str) {
            return (AdaptationWorkaroundMode) Enum.valueOf(AdaptationWorkaroundMode.class, str);
        }

        public static AdaptationWorkaroundMode[] values() {
            return (AdaptationWorkaroundMode[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static final class ReuseType {
        private static final /* synthetic */ ReuseType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final ReuseType KEEP_CODEC_RESULT_NO;
        public static final ReuseType KEEP_CODEC_RESULT_YES_WITHOUT_RECONFIGURATION;
        public static final ReuseType KEEP_CODEC_RESULT_YES_WITH_FLUSH;
        public static final ReuseType KEEP_CODEC_RESULT_YES_WITH_RECONFIGURATION;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61676);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            ReuseType reuseType = new ReuseType("KEEP_CODEC_RESULT_NO", 0);
            KEEP_CODEC_RESULT_NO = reuseType;
            ReuseType reuseType2 = new ReuseType("KEEP_CODEC_RESULT_YES_WITH_FLUSH", 1);
            KEEP_CODEC_RESULT_YES_WITH_FLUSH = reuseType2;
            ReuseType reuseType3 = new ReuseType("KEEP_CODEC_RESULT_YES_WITH_RECONFIGURATION", 2);
            KEEP_CODEC_RESULT_YES_WITH_RECONFIGURATION = reuseType3;
            ReuseType reuseType4 = new ReuseType("KEEP_CODEC_RESULT_YES_WITHOUT_RECONFIGURATION", 3);
            KEEP_CODEC_RESULT_YES_WITHOUT_RECONFIGURATION = reuseType4;
            $VALUES = new ReuseType[]{reuseType, reuseType2, reuseType3, reuseType4};
        }

        ReuseType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static ReuseType valueOf(String str) {
            return (ReuseType) Enum.valueOf(ReuseType.class, str);
        }

        public static ReuseType[] values() {
            return (ReuseType[]) $VALUES.clone();
        }
    }

    ReuseHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NonNull
    public static AdaptationWorkaroundMode codecAdaptationWorkaroundMode(@NonNull String str) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 <= 25 && "OMX.Exynos.avc.dec.secure".equals(str) && (DeviceInfoMonitor.getModel().startsWith("SM-T585") || DeviceInfoMonitor.getModel().startsWith("SM-A510") || DeviceInfoMonitor.getModel().startsWith("SM-A520") || DeviceInfoMonitor.getModel().startsWith("SM-J700"))) {
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
        FormatWrapper formatWrapper2 = reuseCodecWrapper.format;
        if (reuseCodecWrapper instanceof VideoCodecWrapper) {
            if (TextUtils.equals(formatWrapper2.sampleMimeType, formatWrapper.sampleMimeType) && formatWrapper2.rotationDegrees == formatWrapper.rotationDegrees) {
                return reuseCodecWrapper.adaptive || (formatWrapper2.width == formatWrapper.width && formatWrapper2.height == formatWrapper.height);
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
