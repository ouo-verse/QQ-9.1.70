package com.tencent.thumbplayer.core.codec.capability;

import android.media.MediaCodecInfo;
import android.os.Build;
import android.util.Range;
import androidx.annotation.NonNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes26.dex */
public final class TPMediaDecoderInfo implements Serializable {
    public static final float DEFAULT_FRAMERATE = 30.0f;
    private static final int DEFAULT_MAX_BITRATE = 960000;
    private static final int DEFAULT_MAX_CHANNELNUM = 2;
    private static final int DEFAULT_MAX_HEIGHT = 720;
    private static final int DEFAULT_MAX_SAMPLERATE = 48000;
    private static final int DEFAULT_MAX_WIDTH = 1280;
    private static final int DEFAULT_MIN_BITRATE = 8000;
    private static final String TAG = "TPMediaDecoderInfo";
    private boolean mAdaptiveDec;
    private int[] mColorFormats;
    private String mDecMimeType;
    private String mDecName;
    private int mMaxBitRate;
    private int mMaxChannels;
    private float mMaxFrameRate;
    private int mMaxHeight;
    private float mMaxLumaFrameRate;
    private int mMaxLumaHeight;
    private int mMaxLumaWidth;
    private int mMaxSampleRate;
    private int mMaxSupportedInstances;
    private int mMaxWidth;
    private DecoderProfileLevel[] mProfileLevels;
    private boolean mSecureDec;
    private boolean mSoftwareAudioDec;
    private boolean mSoftwareVideoDec;
    private boolean mTunnelingDec;

    /* loaded from: classes26.dex */
    public final class DecoderProfileLevel implements Serializable {
        public int level;
        public int profile;

        public DecoderProfileLevel(int i3, int i16) {
            this.profile = i3;
            this.level = i16;
        }
    }

    public TPMediaDecoderInfo(String str, @NonNull MediaCodecInfo mediaCodecInfo) throws Exception {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        MediaCodecInfo.AudioCapabilities audioCapabilities;
        int[] iArr;
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        reset();
        this.mDecName = mediaCodecInfo.getName();
        this.mDecMimeType = str;
        MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
        if (isVideo() && isSoftwareOnly(mediaCodecInfo)) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mSoftwareVideoDec = z16;
        if (isAudio() && isSoftwareOnly(mediaCodecInfo)) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.mSoftwareAudioDec = z17;
        if (capabilitiesForType != null && isAdaptive(capabilitiesForType)) {
            z18 = true;
        } else {
            z18 = false;
        }
        this.mAdaptiveDec = z18;
        if (capabilitiesForType != null && isTunneling(capabilitiesForType)) {
            z19 = true;
        } else {
            z19 = false;
        }
        this.mTunnelingDec = z19;
        this.mSecureDec = capabilitiesForType != null && isSecure(capabilitiesForType);
        if (capabilitiesForType != null && (codecProfileLevelArr = capabilitiesForType.profileLevels) != null && codecProfileLevelArr.length > 0) {
            ArrayList arrayList = new ArrayList();
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : capabilitiesForType.profileLevels) {
                arrayList.add(new DecoderProfileLevel(codecProfileLevel.profile, codecProfileLevel.level));
            }
            this.mProfileLevels = (DecoderProfileLevel[]) arrayList.toArray(new DecoderProfileLevel[arrayList.size()]);
        } else {
            this.mProfileLevels = new DecoderProfileLevel[0];
        }
        if (capabilitiesForType != null && (iArr = capabilitiesForType.colorFormats) != null && iArr.length > 0) {
            this.mColorFormats = Arrays.copyOf(iArr, iArr.length);
        } else {
            this.mColorFormats = new int[0];
        }
        this.mMaxSupportedInstances = getMaxSupportedInstances(capabilitiesForType);
        if (str.contains("video") && capabilitiesForType != null) {
            MediaCodecInfo.VideoCapabilities videoCapabilities = capabilitiesForType.getVideoCapabilities();
            if (videoCapabilities != null) {
                this.mMaxWidth = getMaxWidth(videoCapabilities);
                this.mMaxHeight = getMaxHeight(videoCapabilities);
                this.mMaxLumaFrameRate = getMaxSupportedFrameRate(videoCapabilities);
                this.mMaxFrameRate = videoCapabilities.getSupportedFrameRates().getUpper().floatValue();
                return;
            }
            return;
        }
        if (str.contains("audio") && capabilitiesForType != null && (audioCapabilities = capabilitiesForType.getAudioCapabilities()) != null) {
            this.mMaxSampleRate = getMaxSampleRate(audioCapabilities);
            this.mMaxBitRate = getMaxBitRate(audioCapabilities);
            this.mMaxChannels = getMaxChannels(audioCapabilities);
        }
    }

    private int getMaxBitRate(MediaCodecInfo.AudioCapabilities audioCapabilities) {
        Range<Integer> range;
        if (audioCapabilities != null) {
            range = audioCapabilities.getBitrateRange();
        } else {
            range = new Range<>(8000, 960000);
        }
        return range.getUpper().intValue();
    }

    private int getMaxChannels(MediaCodecInfo.AudioCapabilities audioCapabilities) {
        if (audioCapabilities != null) {
            return audioCapabilities.getMaxInputChannelCount();
        }
        return 2;
    }

    private int getMaxHeight(MediaCodecInfo.VideoCapabilities videoCapabilities) {
        Range<Integer> range;
        if (videoCapabilities != null) {
            range = videoCapabilities.getSupportedHeights();
        } else {
            range = new Range<>(0, 720);
        }
        return range.getUpper().intValue();
    }

    private int getMaxSampleRate(MediaCodecInfo.AudioCapabilities audioCapabilities) {
        Range<Integer>[] rangeArr;
        if (audioCapabilities != null) {
            rangeArr = audioCapabilities.getSupportedSampleRateRanges();
        } else {
            rangeArr = null;
        }
        if (rangeArr != null && rangeArr.length >= 1) {
            return rangeArr[rangeArr.length - 1].getUpper().intValue();
        }
        return 48000;
    }

    private final float getMaxSupportedFrameRate(MediaCodecInfo.VideoCapabilities videoCapabilities) {
        if (videoCapabilities == null) {
            return 30.0f;
        }
        this.mMaxLumaWidth = videoCapabilities.getSupportedWidthsFor(this.mMaxHeight).getUpper().intValue();
        int intValue = videoCapabilities.getSupportedHeightsFor(this.mMaxWidth).getUpper().intValue();
        this.mMaxLumaHeight = intValue;
        return videoCapabilities.getSupportedFrameRatesFor(this.mMaxWidth, intValue).getUpper().floatValue();
    }

    private int getMaxSupportedInstances(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        if (codecCapabilities != null) {
            return codecCapabilities.getMaxSupportedInstances();
        }
        return Integer.MAX_VALUE;
    }

    private int getMaxWidth(MediaCodecInfo.VideoCapabilities videoCapabilities) {
        Range<Integer> range;
        if (videoCapabilities != null) {
            range = videoCapabilities.getSupportedWidths();
        } else {
            range = new Range<>(0, 1280);
        }
        return range.getUpper().intValue();
    }

    private boolean isAdaptive(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        if (codecCapabilities.isFeatureSupported("adaptive-playback")) {
            return true;
        }
        return false;
    }

    private boolean isSecure(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        if (codecCapabilities.isFeatureSupported("secure-playback")) {
            return true;
        }
        return false;
    }

    private boolean isSoftwareOnly(@NonNull MediaCodecInfo mediaCodecInfo) {
        String lowerCase;
        boolean isSoftwareOnly;
        if (Build.VERSION.SDK_INT >= 29) {
            isSoftwareOnly = mediaCodecInfo.isSoftwareOnly();
            return isSoftwareOnly;
        }
        String str = this.mDecName;
        if (str == null) {
            lowerCase = "";
        } else {
            lowerCase = str.toLowerCase();
        }
        if (!lowerCase.startsWith("omx.google.") && !lowerCase.startsWith("omx.ffmpeg.") && ((!lowerCase.startsWith("omx.sec.") || !lowerCase.contains(".sw.")) && !lowerCase.equals("omx.qcom.video.decoder.hevcswvdec") && ((!lowerCase.startsWith("omx.qti.video.decoder") || !lowerCase.contains("sw")) && !lowerCase.startsWith("c2.android.") && !lowerCase.startsWith("c2.google.")))) {
            return false;
        }
        return true;
    }

    private boolean isTunneling(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        if (codecCapabilities.isFeatureSupported("tunneled-playback")) {
            return true;
        }
        return false;
    }

    private void reset() {
        this.mDecName = "";
        this.mDecMimeType = "";
        this.mSoftwareVideoDec = false;
        this.mSoftwareAudioDec = false;
        this.mAdaptiveDec = false;
        this.mTunnelingDec = false;
        this.mSecureDec = false;
        this.mProfileLevels = null;
        this.mColorFormats = null;
        this.mMaxSupportedInstances = 0;
        this.mMaxLumaFrameRate = 30.0f;
        this.mMaxFrameRate = 30.0f;
        this.mMaxWidth = 1280;
        this.mMaxHeight = 720;
        this.mMaxLumaWidth = 1280;
        this.mMaxLumaHeight = 720;
        this.mMaxSampleRate = 48000;
        this.mMaxBitRate = 960000;
        this.mMaxChannels = 2;
    }

    public int[] getColorFormats() {
        return this.mColorFormats;
    }

    public int getDecoderLumaHeight() {
        return this.mMaxLumaHeight;
    }

    public int getDecoderLumaWidth() {
        return this.mMaxLumaWidth;
    }

    public float getDecoderMaxFrameRate() {
        return this.mMaxFrameRate;
    }

    public float getDecoderMaxFrameRateForMaxLuma() {
        return this.mMaxLumaFrameRate;
    }

    public int getDecoderMaxHeight() {
        return this.mMaxHeight;
    }

    public int getDecoderMaxWidth() {
        return this.mMaxWidth;
    }

    public String getDecoderMimeType() {
        return this.mDecMimeType;
    }

    public String getDecoderName() {
        return this.mDecName;
    }

    public int getMaxAudioBitRate() {
        return this.mMaxBitRate;
    }

    public int getMaxAudioChannels() {
        return this.mMaxChannels;
    }

    public int getMaxAudioSampleRate() {
        return this.mMaxSampleRate;
    }

    public DecoderProfileLevel getMaxProfileLevel() {
        DecoderProfileLevel decoderProfileLevel = new DecoderProfileLevel(0, 0);
        int i3 = 0;
        for (DecoderProfileLevel decoderProfileLevel2 : this.mProfileLevels) {
            int i16 = decoderProfileLevel2.level;
            if (i16 >= i3) {
                decoderProfileLevel = decoderProfileLevel2;
                i3 = i16;
            }
        }
        return decoderProfileLevel;
    }

    public DecoderProfileLevel[] getProfileLevels() {
        return this.mProfileLevels;
    }

    public boolean isAudio() {
        if (!this.mDecMimeType.isEmpty() && this.mDecMimeType.startsWith("audio/")) {
            return true;
        }
        return false;
    }

    public boolean isAudioSofwareDecoder() {
        return this.mSoftwareAudioDec;
    }

    public boolean isSecureDecoder() {
        return this.mSecureDec;
    }

    public boolean isVideo() {
        if (!this.mDecMimeType.isEmpty() && this.mDecMimeType.startsWith("video/")) {
            return true;
        }
        return false;
    }

    public boolean isVideoSofwareDecoder() {
        return this.mSoftwareVideoDec;
    }

    public int getMaxSupportedInstances() {
        return this.mMaxSupportedInstances;
    }
}
