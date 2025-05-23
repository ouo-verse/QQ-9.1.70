package com.tencent.qqlive.tvkplayer.qqliveasset.strategy;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerMsg;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.asset.TVKOnlineSimulatedLiveAsset;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.thumbplayer.api.manager.TPMgr;

/* compiled from: P */
/* loaded from: classes23.dex */
public final class TVKFormatIDChooser {
    private static final String PLAY_MODE_CACHE_EXTEND_VIDEO = "cache_extend_video";
    private static final String PLAY_MODE_CACHE_VIDEO = "cache_video";

    public static int chooseFormatID(@NonNull TVKPlayerVideoInfo tVKPlayerVideoInfo) {
        if (tVKPlayerVideoInfo.isLivePlay()) {
            return 0;
        }
        return getVodFormatID(tVKPlayerVideoInfo);
    }

    private static int getFormatIDByClipType(@NonNull TVKPlayerVideoInfo tVKPlayerVideoInfo) {
        boolean z16;
        boolean z17 = TVKMediaPlayerConfig.PlayerConfig.is_cache_video_fenpian;
        if (!PLAY_MODE_CACHE_EXTEND_VIDEO.equalsIgnoreCase(tVKPlayerVideoInfo.getConfigMapValue("playmode", "")) && !PLAY_MODE_CACHE_VIDEO.equalsIgnoreCase(tVKPlayerVideoInfo.getConfigMapValue("playmode", ""))) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 || z17) {
            return 0;
        }
        return 1;
    }

    private static int getFormatIDByPlayerTypeForce(String str) {
        boolean z16;
        boolean equalsIgnoreCase = TVKPlayerMsg.PLAYER_CHOICE_SYSTEM.equalsIgnoreCase(TVKMediaPlayerConfig.PlayerConfig.vod_player);
        if (TPMgr.isSelfDevPlayerAvailable() && !equalsIgnoreCase) {
            z16 = false;
        } else {
            z16 = true;
        }
        boolean equalsIgnoreCase2 = TVKMediaPlayerConfig.PlayerConfig.FORMAT_ID_HLS.equalsIgnoreCase(str);
        if (!z16) {
            return 0;
        }
        if (!equalsIgnoreCase2) {
            return 1;
        }
        return 3;
    }

    private static int getFormatIDByVodFormatConfig(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (TVKMediaPlayerConfig.PlayerConfig.FORMAT_ID_HLS.equalsIgnoreCase(str)) {
            return 3;
        }
        if ("mp4".equalsIgnoreCase(str)) {
            return 1;
        }
        if (TVKMediaPlayerConfig.PlayerConfig.FORMAT_MP4_5MIN.equalsIgnoreCase(str)) {
            return 4;
        }
        if (!TVKMediaPlayerConfig.PlayerConfig.FORMAT_MP4_20MIN.equalsIgnoreCase(str)) {
            return 0;
        }
        return 5;
    }

    private static int getVodFormatID(@NonNull TVKPlayerVideoInfo tVKPlayerVideoInfo) {
        if (tVKPlayerVideoInfo.getAsset() instanceof TVKOnlineSimulatedLiveAsset) {
            return 3;
        }
        String str = TVKMediaPlayerConfig.PlayerConfig.vod_fmt;
        int formatIDByPlayerTypeForce = getFormatIDByPlayerTypeForce(str);
        if (formatIDByPlayerTypeForce != 0) {
            return formatIDByPlayerTypeForce;
        }
        int formatIDByClipType = getFormatIDByClipType(tVKPlayerVideoInfo);
        if (formatIDByClipType != 0) {
            return formatIDByClipType;
        }
        return getFormatIDByVodFormatConfig(str);
    }
}
