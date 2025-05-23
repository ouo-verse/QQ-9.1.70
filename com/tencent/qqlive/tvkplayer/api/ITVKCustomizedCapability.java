package com.tencent.qqlive.tvkplayer.api;

import androidx.annotation.NonNull;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ITVKCustomizedCapability {
    public static final int CAP_AUDIO_AAC_5_1 = 8;
    public static final int CAP_AUDIO_DOLBY_2 = 4;
    public static final int CAP_AUDIO_DOLBY_ATMOS = 3;
    public static final int CAP_AUDIO_DOLBY_SURROUND = 2;
    public static final int CAP_AUDIO_DTS_HD = 5;
    public static final int CAP_AUDIO_DTS_X = 6;
    public static final int CAP_AUDIO_ONLY = 1;
    public static final int CAP_AUDIO_VIVID_5_1_4 = 7;
    public static final int CAP_CODEC_AV1 = 5;
    public static final int CAP_CODEC_AVS3 = 2;
    public static final int CAP_CODEC_HEVC = 1;
    public static final int CAP_CODEC_VVC = 4;
    public static final int CAP_DRM_TYPE_CHINADRM_2_0 = 5;
    public static final int CAP_DRM_TYPE_COMMON = 1;
    public static final int CAP_DRM_TYPE_HLS_ENC_CHACHA20 = 3;
    public static final int CAP_DRM_TYPE_UNITEND = 2;
    public static final int CAP_DRM_TYPE_WIDEVINE = 4;
    public static final int CAP_NOT_SUPPORT = 0;
    public static final int CAP_PLAYER_LEVEL_FHD = 6;
    public static final int CAP_PLAYER_LEVEL_HD = 4;
    public static final int CAP_PLAYER_LEVEL_MIN = 1;
    public static final int CAP_PLAYER_LEVEL_MSD = 2;
    public static final int CAP_PLAYER_LEVEL_R4K = 8;
    public static final int CAP_PLAYER_LEVEL_SD = 3;
    public static final int CAP_PLAYER_LEVEL_SHD = 5;
    public static final int CAP_PLAYER_LEVEL_UHD = 7;
    public static final int CAP_SUPPORT = 1;
    public static final int CAP_VIDEO_DOLBY_VISION_FFMP4 = 4;
    public static final int CAP_VIDEO_DOLBY_VISION_SDR_PLUS = 5;
    public static final int CAP_VIDEO_DOLBY_VISION_TS = 6;
    public static final int CAP_VIDEO_FHD_120FPS_HEVC_HDR_VIVID = 10;
    public static final int CAP_VIDEO_FHD_30FPS_HEVC_HDR_VIVID = 8;
    public static final int CAP_VIDEO_FHD_60FPS_HEVC_HDR_VIVID = 9;
    public static final int CAP_VIDEO_HDR10 = 1;
    public static final int CAP_VIDEO_HDR_ENHANCE = 2;
    public static final int CAP_VIDEO_HDR_VIVID = 3;
    public static final int CAP_VIDEO_IMAX = 7;
    public static final int CAP_VIDEO_UHD_120FPS_HEVC_HDR_VIVID = 13;
    public static final int CAP_VIDEO_UHD_30FPS_HEVC_HDR_VIVID = 11;
    public static final int CAP_VIDEO_UHD_60FPS_HEVC_HDR_VIVID = 12;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface AudioEffect {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface DrmType {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface HighQualityVideo {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface PlayerLevel {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface VideoCodec {
    }

    @NonNull
    Map<Integer, Integer> getAudioEffectCapabilityMap();

    @NonNull
    Map<Integer, Integer> getDrmCapabilityMap();

    @NonNull
    Map<Integer, Integer> getHighQualityVideoCapabilityMap();

    @NonNull
    Map<Integer, Integer> getVideoCodecCapabilityMap();
}
