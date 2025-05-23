package com.tencent.qqlive.tvkplayer.capability;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.ITVKCustomizedCapability;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerMsg;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKCommParams;
import com.tencent.qqlive.tvkplayer.tools.config.TVKDVMAConfig;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.tpplayer.tools.TVKPlayerStrategy;
import com.tencent.qqlive.tvkplayer.tpplayer.tools.TVKTPCapability;
import com.tencent.thumbplayer.api.capability.TPAudioCapabilityQueryParams;
import com.tencent.thumbplayer.api.capability.TPDecoderCapability;
import com.tencent.thumbplayer.api.common.TPAudioCodecType;
import com.tencent.thumbplayer.api.common.TPChannelLayout;
import com.tencent.thumbplayer.api.exception.TPLoadLibraryException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKDefaultCapability implements ITVKCustomizedCapability {
    private static final String TAG = "TVKDefaultCapability";
    private static volatile Map<Integer, Integer> mAudioEffectCapabilityMap = null;
    private static volatile Map<Integer, Integer> mDrmCapabilityMap = null;
    private static volatile Map<Integer, Integer> mHQVideoCapabilityMap = null;
    private static boolean mNeedResetAudioEffectCapabilityMap = false;
    private static boolean mNeedResetDrmCapabilityMap = false;
    private static boolean mNeedResetHQVideoCapabilityMap = false;
    private static boolean mNeedResetVideoCodecCapabilityMap = false;
    private static volatile Map<Integer, Integer> mVideoCodecCapabilityMap;
    private static final Object mDrmCapabilityMapLock = new Object();
    private static final Object mHQVideoCapabilityMapLock = new Object();
    private static final Object mAudioEffectCapabilityMapLock = new Object();
    private static final Object mVideoCodecCapabilityMapLock = new Object();

    private void addHdrCapabilityWithConditions(Map<Integer, Integer> map) {
        map.put(8, Integer.valueOf(isHdrSupported(8) ? 1 : 0));
        map.put(9, Integer.valueOf(isHdrSupported(9) ? 1 : 0));
        map.put(10, Integer.valueOf(isHdrSupported(10) ? 1 : 0));
        map.put(11, Integer.valueOf(isHdrSupported(11) ? 1 : 0));
        map.put(12, Integer.valueOf(isHdrSupported(12) ? 1 : 0));
        map.put(13, Integer.valueOf(isHdrSupported(13) ? 1 : 0));
    }

    private int getDecLevel(int i3, boolean z16, int i16, int i17) {
        int i18;
        int i19 = 1;
        try {
            i18 = TVKTPCapability.getDecLevel(i3, 101);
            if (!z16) {
                try {
                    if (TVKPlayerStrategy.isEnabledMediaCodec()) {
                        i19 = TVKTPCapability.getDecLevel(i3, 102);
                    }
                } catch (Throwable th5) {
                    th = th5;
                    TVKLogUtil.e(TAG, th, "[getDecLevel] there is a exception: ");
                    TVKLogUtil.i(TAG, "[getDecLevel] codecId=" + i3 + ", forceSoftwareDecoder=" + z16 + ", lowerLimit=" + i16 + ", upperLimit" + i17 + ", ffmpegCodecLevel=" + i18 + ", mediaCodecLevel=" + i19);
                    return Math.min(Math.max(Math.max(i18, i19), i16), i17);
                }
            }
        } catch (Throwable th6) {
            th = th6;
            i18 = 1;
        }
        TVKLogUtil.i(TAG, "[getDecLevel] codecId=" + i3 + ", forceSoftwareDecoder=" + z16 + ", lowerLimit=" + i16 + ", upperLimit" + i17 + ", ffmpegCodecLevel=" + i18 + ", mediaCodecLevel=" + i19);
        return Math.min(Math.max(Math.max(i18, i19), i16), i17);
    }

    private int getHevcLevel() {
        if (TVKTPCapability.isModelInHevcBlackList()) {
            return 1;
        }
        return getDecLevel(172, TVKPlayerMsg.PLAYER_CHOICE_SELF_SOFT.equals(TVKMediaPlayerConfig.PlayerConfig.hevc_player), 1, TVKMediaPlayerConfig.PlayerConfig.capability_upper_level_hevc);
    }

    private boolean isHdrSupported(int i3) {
        return TVKTPCapability.isHdrSupported(i3);
    }

    private boolean isSupportCuvaHdr() {
        if (TVKPlayerStrategy.isEnabledHWDec(TVKCommParams.getApplicationContext()) && TVKTPCapability.isSupportCuvaHdr()) {
            return true;
        }
        return false;
    }

    private boolean isSupportDolbyVision() {
        if (!TVKTPCapability.isSupportDolbyVision() && !TVKDVMAConfig.isSupportDolbyVisionSoftRender()) {
            return false;
        }
        return true;
    }

    private boolean isSupportHdr10() {
        boolean z16;
        boolean z17;
        boolean z18;
        if (TVKUtils.isModelInList(TVKMediaPlayerConfig.PlayerConfig.hdr_video_decode_white_list)) {
            return true;
        }
        if (TVKTPCapability.isHdr10SupportedByDisplay(TVKCommParams.getApplicationContext()) && !TVKUtils.isModelInList(TVKMediaPlayerConfig.PlayerConfig.hdr_video_decode_black_list)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && !TVKUtils.isManufacturerInList(TVKMediaPlayerConfig.PlayerConfig.hdr_video_decode_manufacturer_black_list)) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 && TVKTPCapability.isSupportHDR10()) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18 && TVKPlayerStrategy.isEnabledHWDec(TVKCommParams.getApplicationContext())) {
            return true;
        }
        return false;
    }

    private boolean isSupportHdrEnhance() {
        if (TVKUtils.isModelInList(TVKMediaPlayerConfig.PlayerConfig.hdr_enhance_video_decode_white_list) || !TVKUtils.isModelInList(TVKMediaPlayerConfig.PlayerConfig.hdr_enhance_video_decode_black_list)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKCustomizedCapability
    @NonNull
    public Map<Integer, Integer> getAudioEffectCapabilityMap() {
        int i3;
        int i16;
        int i17;
        int i18;
        synchronized (mAudioEffectCapabilityMapLock) {
            if (mAudioEffectCapabilityMap != null && !mNeedResetAudioEffectCapabilityMap) {
                return mAudioEffectCapabilityMap;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(1, 1);
            boolean isSupportDolbyAudio = TVKTPCapability.isSupportDolbyAudio();
            int i19 = 0;
            if (isSupportDolbyAudio) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            hashMap.put(2, Integer.valueOf(i3));
            if (isSupportDolbyAudio) {
                i16 = 1;
            } else {
                i16 = 0;
            }
            hashMap.put(3, Integer.valueOf(i16));
            if (isSupportDolbyAudio) {
                i17 = 1;
            } else {
                i17 = 0;
            }
            hashMap.put(4, Integer.valueOf(i17));
            hashMap.put(5, 0);
            hashMap.put(6, 0);
            try {
                i18 = TPDecoderCapability.getAudioDecoderCapability(new TPAudioCapabilityQueryParams(5002, 1, 48000, 1551L, 0)) | TPDecoderCapability.getAudioDecoderCapability(new TPAudioCapabilityQueryParams(5002, 2, 48000, 1551L, 0));
            } catch (TPLoadLibraryException e16) {
                e = e16;
                i18 = 0;
            }
            try {
                i19 = TPDecoderCapability.getAudioDecoderCapability(new TPAudioCapabilityQueryParams(TPAudioCodecType.TP_AUDIO_CODEC_TYPE_AVS3, 1, 48000, TPChannelLayout.TP_CH_LAYOUT_5POINT1POINT4, 0));
            } catch (TPLoadLibraryException e17) {
                e = e17;
                TVKLogUtil.e(TAG, e, "getAudioDecoderCapability has exception, not support audio vivid 5.1.4");
                hashMap.put(8, Integer.valueOf(i18));
                hashMap.put(7, Integer.valueOf(i19));
                mAudioEffectCapabilityMap = hashMap;
                mNeedResetAudioEffectCapabilityMap = true;
                return mAudioEffectCapabilityMap;
            }
            hashMap.put(8, Integer.valueOf(i18));
            hashMap.put(7, Integer.valueOf(i19));
            mAudioEffectCapabilityMap = hashMap;
            mNeedResetAudioEffectCapabilityMap = true;
            return mAudioEffectCapabilityMap;
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKCustomizedCapability
    @NonNull
    public Map<Integer, Integer> getDrmCapabilityMap() {
        synchronized (mDrmCapabilityMapLock) {
            if (mDrmCapabilityMap != null && !mNeedResetDrmCapabilityMap) {
                return mDrmCapabilityMap;
            }
            mDrmCapabilityMap = Collections.emptyMap();
            mNeedResetDrmCapabilityMap = false;
            return mDrmCapabilityMap;
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKCustomizedCapability
    @NonNull
    public Map<Integer, Integer> getHighQualityVideoCapabilityMap() {
        int i3;
        int i16;
        int i17;
        synchronized (mHQVideoCapabilityMapLock) {
            if (mHQVideoCapabilityMap != null && !mNeedResetHQVideoCapabilityMap) {
                return mHQVideoCapabilityMap;
            }
            HashMap hashMap = new HashMap();
            int i18 = 1;
            if (isSupportHdr10()) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            hashMap.put(1, Integer.valueOf(i3));
            if (isSupportHdrEnhance()) {
                i16 = 1;
            } else {
                i16 = 0;
            }
            hashMap.put(2, Integer.valueOf(i16));
            if (isSupportCuvaHdr()) {
                i17 = 1;
            } else {
                i17 = 0;
            }
            hashMap.put(3, Integer.valueOf(i17));
            if (!isSupportDolbyVision()) {
                i18 = 0;
            }
            hashMap.put(6, Integer.valueOf(i18));
            hashMap.put(4, 0);
            hashMap.put(5, 0);
            addHdrCapabilityWithConditions(hashMap);
            mHQVideoCapabilityMap = hashMap;
            mNeedResetHQVideoCapabilityMap = false;
            return mHQVideoCapabilityMap;
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKCustomizedCapability
    @NonNull
    public Map<Integer, Integer> getVideoCodecCapabilityMap() {
        synchronized (mVideoCodecCapabilityMapLock) {
            if (mVideoCodecCapabilityMap != null && !mNeedResetVideoCodecCapabilityMap) {
                return mVideoCodecCapabilityMap;
            }
            HashMap hashMap = new HashMap();
            boolean z16 = true;
            hashMap.put(1, Integer.valueOf(getHevcLevel()));
            hashMap.put(4, Integer.valueOf(getDecLevel(193, TVKPlayerMsg.PLAYER_CHOICE_SELF_SOFT.equals(TVKMediaPlayerConfig.PlayerConfig.vvc_player), 1, 8)));
            hashMap.put(2, Integer.valueOf(getDecLevel(192, false, 1, 8)));
            if (TVKMediaPlayerConfig.PlayerConfig.enable_av1_hardware_decoder) {
                z16 = false;
            }
            hashMap.put(5, Integer.valueOf(getDecLevel(1029, z16, TVKMediaPlayerConfig.PlayerConfig.capability_lower_level_av1, TVKMediaPlayerConfig.PlayerConfig.capability_upper_level_av1)));
            mVideoCodecCapabilityMap = hashMap;
            mNeedResetVideoCodecCapabilityMap = false;
            return mVideoCodecCapabilityMap;
        }
    }

    public boolean isSupportDolbyVisionSoftRender() {
        return TVKDVMAConfig.isSupportDolbyVisionSoftRender();
    }

    public void reset() {
        synchronized (mDrmCapabilityMapLock) {
            mNeedResetDrmCapabilityMap = true;
        }
        synchronized (mHQVideoCapabilityMapLock) {
            mNeedResetHQVideoCapabilityMap = true;
        }
        synchronized (mAudioEffectCapabilityMapLock) {
            mNeedResetAudioEffectCapabilityMap = true;
        }
        synchronized (mVideoCodecCapabilityMapLock) {
            mNeedResetVideoCodecCapabilityMap = true;
        }
    }

    public void resetHQVideoCapability() {
        synchronized (mHQVideoCapabilityMapLock) {
            mNeedResetHQVideoCapabilityMap = true;
        }
    }
}
