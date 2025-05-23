package com.google.android.exoplayer2.mediacodec;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;

/* compiled from: P */
@TargetApi(16)
/* loaded from: classes2.dex */
public final class MediaCodecInfo {
    public static final String TAG = "MediaCodecInfo";
    public final boolean adaptive;
    private final MediaCodecInfo.CodecCapabilities capabilities;
    private final String mimeType;
    public final String name;
    public final boolean secure;
    public final boolean tunneling;

    MediaCodecInfo(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z16, boolean z17) {
        boolean z18;
        boolean z19;
        this.name = (String) Assertions.checkNotNull(str);
        this.mimeType = str2;
        this.capabilities = codecCapabilities;
        boolean z26 = true;
        if (!z16 && codecCapabilities != null && isAdaptive(codecCapabilities)) {
            z18 = true;
        } else {
            z18 = false;
        }
        this.adaptive = z18;
        if (codecCapabilities != null && isTunneling(codecCapabilities)) {
            z19 = true;
        } else {
            z19 = false;
        }
        this.tunneling = z19;
        if (!z17 && (codecCapabilities == null || !isSecure(codecCapabilities))) {
            z26 = false;
        }
        this.secure = z26;
    }

    private static int adjustMaxInputChannelCount(String str, String str2, int i3) {
        int i16;
        if (i3 <= 1 && ((Util.SDK_INT < 26 || i3 <= 0) && !"audio/mpeg".equals(str2) && !"audio/3gpp".equals(str2) && !"audio/amr-wb".equals(str2) && !"audio/mp4a-latm".equals(str2) && !"audio/vorbis".equals(str2) && !"audio/opus".equals(str2) && !"audio/raw".equals(str2) && !"audio/flac".equals(str2) && !"audio/g711-alaw".equals(str2) && !"audio/g711-mlaw".equals(str2) && !"audio/gsm".equals(str2))) {
            if ("audio/ac3".equals(str2)) {
                i16 = 6;
            } else if ("audio/eac3".equals(str2)) {
                i16 = 16;
            } else {
                i16 = 30;
            }
            Log.w(TAG, "AssumedMaxChannelAdjustment: " + str + ", [" + i3 + " to " + i16 + "]");
            return i16;
        }
        return i3;
    }

    @TargetApi(21)
    private static boolean areSizeAndRateSupportedV21(MediaCodecInfo.VideoCapabilities videoCapabilities, int i3, int i16, double d16) {
        if (d16 != -1.0d && d16 > 0.0d) {
            return videoCapabilities.areSizeAndRateSupported(i3, i16, d16);
        }
        return videoCapabilities.isSizeSupported(i3, i16);
    }

    private static boolean isAdaptive(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        if (Util.SDK_INT >= 19 && isAdaptiveV19(codecCapabilities)) {
            return true;
        }
        return false;
    }

    @TargetApi(19)
    private static boolean isAdaptiveV19(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    private static boolean isSecure(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        if (Util.SDK_INT >= 21 && isSecureV21(codecCapabilities)) {
            return true;
        }
        return false;
    }

    @TargetApi(21)
    private static boolean isSecureV21(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    private static boolean isTunneling(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        if (Util.SDK_INT >= 21 && isTunnelingV21(codecCapabilities)) {
            return true;
        }
        return false;
    }

    @TargetApi(21)
    private static boolean isTunnelingV21(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("tunneled-playback");
    }

    private void logAssumedSupport(String str) {
        Log.d(TAG, "AssumedSupport [" + str + "] [" + this.name + ", " + this.mimeType + "] [" + Util.DEVICE_DEBUG_INFO + "]");
    }

    private void logNoSupport(String str) {
        Log.d(TAG, "NoSupport [" + str + "] [" + this.name + ", " + this.mimeType + "] [" + Util.DEVICE_DEBUG_INFO + "]");
    }

    public static MediaCodecInfo newInstance(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return new MediaCodecInfo(str, str2, codecCapabilities, false, false);
    }

    public static MediaCodecInfo newPassthroughInstance(String str) {
        return new MediaCodecInfo(str, null, null, false, false);
    }

    @TargetApi(21)
    public Point alignVideoSizeV21(int i3, int i16) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
        if (codecCapabilities == null) {
            logNoSupport("align.caps");
            return null;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            logNoSupport("align.vCaps");
            return null;
        }
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(Util.ceilDivide(i3, widthAlignment) * widthAlignment, Util.ceilDivide(i16, heightAlignment) * heightAlignment);
    }

    public MediaCodecInfo.CodecProfileLevel[] getProfileLevels() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
        if (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) {
            return new MediaCodecInfo.CodecProfileLevel[0];
        }
        return codecProfileLevelArr;
    }

    @TargetApi(21)
    public boolean isAudioChannelCountSupportedV21(int i3) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
        if (codecCapabilities == null) {
            logNoSupport("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            logNoSupport("channelCount.aCaps");
            return false;
        }
        if (adjustMaxInputChannelCount(this.name, this.mimeType, audioCapabilities.getMaxInputChannelCount()) < i3) {
            logNoSupport("channelCount.support, " + i3);
            return false;
        }
        return true;
    }

    @TargetApi(21)
    public boolean isAudioSampleRateSupportedV21(int i3) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
        if (codecCapabilities == null) {
            logNoSupport("sampleRate.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            logNoSupport("sampleRate.aCaps");
            return false;
        }
        if (!audioCapabilities.isSampleRateSupported(i3)) {
            logNoSupport("sampleRate.support, " + i3);
            return false;
        }
        return true;
    }

    public boolean isCodecSupported(String str) {
        String mediaMimeType;
        if (str == null || this.mimeType == null || (mediaMimeType = MimeTypes.getMediaMimeType(str)) == null) {
            return true;
        }
        if (!this.mimeType.equals(mediaMimeType)) {
            logNoSupport("codec.mime " + str + ", " + mediaMimeType);
            return false;
        }
        Pair<Integer, Integer> codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(str);
        if (codecProfileAndLevel == null) {
            return true;
        }
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : getProfileLevels()) {
            if (codecProfileLevel.profile == ((Integer) codecProfileAndLevel.first).intValue() && codecProfileLevel.level >= ((Integer) codecProfileAndLevel.second).intValue()) {
                return true;
            }
        }
        logNoSupport("codec.profileLevel, " + str + ", " + mediaMimeType);
        return false;
    }

    @TargetApi(21)
    public boolean isVideoSizeAndRateSupportedV21(int i3, int i16, double d16) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
        if (codecCapabilities == null) {
            logNoSupport("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            logNoSupport("sizeAndRate.vCaps");
            return false;
        }
        if (!areSizeAndRateSupportedV21(videoCapabilities, i3, i16, d16)) {
            if (i3 < i16 && areSizeAndRateSupportedV21(videoCapabilities, i16, i3, d16)) {
                logAssumedSupport("sizeAndRate.rotated, " + i3 + HippyTKDListViewAdapter.X + i16 + HippyTKDListViewAdapter.X + d16);
                return true;
            }
            logNoSupport("sizeAndRate.support, " + i3 + HippyTKDListViewAdapter.X + i16 + HippyTKDListViewAdapter.X + d16);
            return false;
        }
        return true;
    }

    public static MediaCodecInfo newInstance(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z16, boolean z17) {
        return new MediaCodecInfo(str, str2, codecCapabilities, z16, z17);
    }
}
