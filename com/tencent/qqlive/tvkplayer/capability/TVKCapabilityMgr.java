package com.tencent.qqlive.tvkplayer.capability;

import com.tencent.qqlive.tvkplayer.api.ITVKCustomizedCapability;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.thumbplayer.api.capability.TPDrmCapability;
import com.tencent.thumbplayer.api.exception.TPLoadLibraryException;
import com.tencent.thumbplayer.core.datatransport.api.TPDataTransportMgr;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKCapabilityMgr {
    private static final String TAG = "TVKCapabilityMgr";
    private ITVKCustomizedCapability mCustomizedCapability;
    private TVKDefaultCapability mDefaultCapability;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    private static class SingletonHolder {
        private static final TVKCapabilityMgr sInstance = new TVKCapabilityMgr();

        SingletonHolder() {
        }
    }

    private static int convertPlayerLevelToCgiLevel(int i3) {
        int i16 = TVKCommonParamEnum.CGI_LEVEL_CODEC_SUPPORT_NONE;
        if (i3 >= 3) {
            i16 |= TVKCommonParamEnum.CGI_LEVEL_CODEC_SUPPORT_SD;
        }
        if (i3 >= 4) {
            i16 |= TVKCommonParamEnum.CGI_LEVEL_CODEC_SUPPORT_HD;
        }
        if (i3 >= 5) {
            i16 |= TVKCommonParamEnum.CGI_LEVEL_CODEC_SUPPORT_SHD;
        }
        if (i3 >= 6) {
            return i16 | TVKCommonParamEnum.CGI_LEVEL_CODEC_SUPPORT_FHD;
        }
        return i16;
    }

    private static int convertPlayerLevelToLiveCgiLevel(int i3) {
        int i16 = TVKCommonParamEnum.LIVE_CGI_LEVEL_CODEC_SUPPORT_NONE;
        if (i3 >= 3) {
            i16 |= TVKCommonParamEnum.LIVE_CGI_LEVEL_CODEC_SUPPORT_SD_FPS30 | TVKCommonParamEnum.LIVE_CGI_LEVEL_CODEC_SUPPORT_SD_FPS60;
        }
        if (i3 >= 4) {
            i16 |= TVKCommonParamEnum.LIVE_CGI_LEVEL_CODEC_SUPPORT_HD_FPS30 | TVKCommonParamEnum.LIVE_CGI_LEVEL_CODEC_SUPPORT_HD_FPS60;
        }
        if (i3 >= 5) {
            i16 |= TVKCommonParamEnum.LIVE_CGI_LEVEL_CODEC_SUPPORT_SHD_FPS30 | TVKCommonParamEnum.LIVE_CGI_LEVEL_CODEC_SUPPORT_SHD_FPS60;
        }
        if (i3 >= 6) {
            return i16 | TVKCommonParamEnum.LIVE_CGI_LEVEL_CODEC_SUPPORT_FHD_FPS30 | TVKCommonParamEnum.LIVE_CGI_LEVEL_CODEC_SUPPORT_FHD_FPS60;
        }
        return i16;
    }

    public static TVKCapabilityMgr getInstance() {
        return SingletonHolder.sInstance;
    }

    private static int getIntersectionLevel(int i3, int i16) {
        if (i16 < 0) {
            return i3;
        }
        return i3 & i16;
    }

    public int convertPlayerLevelToCgiLevelForHevc(int i3) {
        switch (i3) {
            case 2:
                return 6;
            case 3:
                return 11;
            case 4:
                return 16;
            case 5:
                return 21;
            case 6:
                return 26;
            case 7:
                return 28;
            case 8:
                return 33;
            default:
                return 1;
        }
    }

    public int getVideoCodecCgiLevel(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 4) {
                    if (i3 != 5) {
                        return convertPlayerLevelToCgiLevel(1);
                    }
                    return convertPlayerLevelToCgiLevel(getVideoCodecPlayerLevel(i3, TVKMediaPlayerConfig.PlayerConfig.enable_av1));
                }
                return getIntersectionLevel(convertPlayerLevelToCgiLevel(getVideoCodecPlayerLevel(i3, TVKMediaPlayerConfig.PlayerConfig.enable_vvc)), TVKMediaPlayerConfig.PlayerConfig.vvc_level);
            }
            return convertPlayerLevelToCgiLevel(getVideoCodecPlayerLevel(i3, TVKMediaPlayerConfig.PlayerConfig.enable_avs3));
        }
        return convertPlayerLevelToCgiLevelForHevc(getVideoCodecPlayerLevel(i3, TVKMediaPlayerConfig.PlayerConfig.enable_hevc));
    }

    public int getVideoCodecLiveCgiLevel(int i3) {
        if (i3 != 1) {
            if (i3 != 4) {
                return 0;
            }
            return getIntersectionLevel(convertPlayerLevelToLiveCgiLevel(getVideoCodecPlayerLevel(i3, TVKMediaPlayerConfig.PlayerConfig.enable_live_vvc)), TVKMediaPlayerConfig.PlayerConfig.vvc_level);
        }
        return convertPlayerLevelToCgiLevelForHevc(getVideoCodecPlayerLevel(i3, TVKMediaPlayerConfig.PlayerConfig.enable_hevc));
    }

    public int getVideoCodecPlayerLevel(int i3, boolean z16) {
        Integer num;
        Integer num2;
        ITVKCustomizedCapability iTVKCustomizedCapability = this.mCustomizedCapability;
        if (iTVKCustomizedCapability != null && (num2 = iTVKCustomizedCapability.getVideoCodecCapabilityMap().get(Integer.valueOf(i3))) != null) {
            return num2.intValue();
        }
        if (z16 && (num = this.mDefaultCapability.getVideoCodecCapabilityMap().get(Integer.valueOf(i3))) != null) {
            return num.intValue();
        }
        return 1;
    }

    public boolean isSupportAudioEffect(int i3, boolean z16) {
        Integer num;
        Integer num2;
        ITVKCustomizedCapability iTVKCustomizedCapability = this.mCustomizedCapability;
        if (iTVKCustomizedCapability != null && (num2 = iTVKCustomizedCapability.getAudioEffectCapabilityMap().get(Integer.valueOf(i3))) != null) {
            if (num2.intValue() != 1) {
                return false;
            }
            return true;
        }
        if (!z16 || (num = this.mDefaultCapability.getAudioEffectCapabilityMap().get(Integer.valueOf(i3))) == null || num.intValue() != 1) {
            return false;
        }
        return true;
    }

    public boolean isSupportDolbyVisionSoftRender() {
        return this.mDefaultCapability.isSupportDolbyVisionSoftRender();
    }

    public boolean isSupportDrm(int i3, boolean z16) {
        Integer num;
        ITVKCustomizedCapability iTVKCustomizedCapability = this.mCustomizedCapability;
        if (iTVKCustomizedCapability != null && (num = iTVKCustomizedCapability.getDrmCapabilityMap().get(Integer.valueOf(i3))) != null) {
            return num.intValue() == 1;
        }
        if (z16) {
            return isSupportDrm(i3);
        }
        return false;
    }

    public boolean isSupportHighQualityVideo(int i3, boolean z16) {
        Integer num;
        Integer num2;
        ITVKCustomizedCapability iTVKCustomizedCapability = this.mCustomizedCapability;
        if (iTVKCustomizedCapability != null && (num2 = iTVKCustomizedCapability.getHighQualityVideoCapabilityMap().get(Integer.valueOf(i3))) != null) {
            if (num2.intValue() != 1) {
                return false;
            }
            return true;
        }
        if (!z16 || (num = this.mDefaultCapability.getHighQualityVideoCapabilityMap().get(Integer.valueOf(i3))) == null || num.intValue() != 1) {
            return false;
        }
        return true;
    }

    public void reset() {
        this.mDefaultCapability.reset();
    }

    public void resetHQVideoCapability() {
        this.mDefaultCapability.resetHQVideoCapability();
    }

    public void setCustomizedCapability(ITVKCustomizedCapability iTVKCustomizedCapability) {
        this.mCustomizedCapability = iTVKCustomizedCapability;
    }

    TVKCapabilityMgr() {
        this.mDefaultCapability = null;
        this.mCustomizedCapability = null;
        this.mDefaultCapability = new TVKDefaultCapability();
    }

    private boolean isSupportDrm(int i3) {
        try {
            if (i3 == 3) {
                return TVKMediaPlayerConfig.PlayerConfig.qqlive_asset_player_use_proxy && TPDataTransportMgr.isNativeInit();
            }
            if (i3 == 4) {
                return 1 == TPDrmCapability.getDrmCapability(0);
            }
            if (i3 == 5 && 1 == TPDrmCapability.getDrmCapability(3)) {
                return true;
            }
            return false;
        } catch (TPLoadLibraryException e16) {
            TVKLogUtil.e(TAG, "isSupportDrm, getDrmCapability has exception: " + e16);
            return false;
        }
    }
}
