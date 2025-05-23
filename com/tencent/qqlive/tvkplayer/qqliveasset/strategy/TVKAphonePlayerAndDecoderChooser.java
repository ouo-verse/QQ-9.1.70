package com.tencent.qqlive.tvkplayer.qqliveasset.strategy;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerMsg;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import com.tencent.qqlive.tvkplayer.api.asset.TVKAssetUtils;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerInputParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerRuntimeParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.TVKPlayerFeatureUtils;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeatureGroup;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKStrategyEnum;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKCommParams;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.tpplayer.tools.TVKPlayerStrategy;
import com.tencent.thumbplayer.api.manager.TPMgr;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes23.dex */
public class TVKAphonePlayerAndDecoderChooser implements ITVKPlayerAndDecoderChooser {
    private static final String PLAYER_VIDEO_CAPTURE = "video_capture";
    private static final String TAG = "TVKPlayer[TVKAphonePlayerAndDecoderChooser]";

    @NonNull
    private final TVKPlayerInputParam mInputParam;

    @NonNull
    private final ITVKPlayerFeatureGroup mPlayerFeatureGroup;

    @NonNull
    private final TVKPlayerRuntimeParam mRuntimeParam;
    private final ArrayList<ITVKPlayerChooser> mPlayerChooserList = new ArrayList<>();
    private final ArrayList<ITVKVideoDecoderChooser> mVideoDecoderChooserList = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes23.dex */
    public interface ITVKPlayerChooser {
        TVKStrategyEnum.PlayerStrategy getPlayer();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes23.dex */
    public interface ITVKVideoDecoderChooser {
        TVKStrategyEnum.VideoDecoderStrategy getVideoDecoder(TVKStrategyEnum.PlayerStrategy playerStrategy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public static class PlayerChooserForAppForce implements ITVKPlayerChooser {

        @NonNull
        private final TVKPlayerInputParam mInputParam;

        public PlayerChooserForAppForce(@NonNull TVKPlayerInputParam tVKPlayerInputParam) {
            this.mInputParam = tVKPlayerInputParam;
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKAphonePlayerAndDecoderChooser.ITVKPlayerChooser
        public TVKStrategyEnum.PlayerStrategy getPlayer() {
            int i3 = 0;
            if (this.mInputParam.getPlayerVideoInfo() != null) {
                i3 = TVKUtils.optInt(this.mInputParam.getPlayerVideoInfo().getConfigMapValue("player_forcetype", String.valueOf(0)), 0);
            }
            if (i3 != 1) {
                if (i3 != 2 && i3 != 3) {
                    return TVKStrategyEnum.PlayerStrategy.PLAYER_STRATEGY_AUTO;
                }
                return TVKStrategyEnum.PlayerStrategy.PLAYER_STRATEGY_SELF_ONLY;
            }
            return TVKStrategyEnum.PlayerStrategy.PLAYER_STRATEGY_SYSTEM_ONLY;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public static class PlayerChooserForConfig implements ITVKPlayerChooser {

        @NonNull
        private final TVKPlayerInputParam mInputParam;

        @NonNull
        private final TVKPlayerRuntimeParam mRuntimeParam;

        public PlayerChooserForConfig(@NonNull TVKPlayerInputParam tVKPlayerInputParam, @NonNull TVKPlayerRuntimeParam tVKPlayerRuntimeParam) {
            this.mInputParam = tVKPlayerInputParam;
            this.mRuntimeParam = tVKPlayerRuntimeParam;
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKAphonePlayerAndDecoderChooser.ITVKPlayerChooser
        public TVKStrategyEnum.PlayerStrategy getPlayer() {
            String playerConfig = TVKAphonePlayerAndDecoderChooser.getPlayerConfig(this.mRuntimeParam.getTVKAsset());
            if (TVKPlayerMsg.PLAYER_CHOICE_SYSTEM.equalsIgnoreCase(playerConfig)) {
                return TVKStrategyEnum.PlayerStrategy.PLAYER_STRATEGY_SYSTEM_ONLY;
            }
            if (TVKPlayerMsg.PLAYER_CHOICE_SELF_SOFT.equalsIgnoreCase(playerConfig)) {
                return TVKStrategyEnum.PlayerStrategy.PLAYER_STRATEGY_SELF_ONLY;
            }
            if ("self".equalsIgnoreCase(playerConfig)) {
                return TVKStrategyEnum.PlayerStrategy.PLAYER_STRATEGY_SELF_ONLY;
            }
            return TVKStrategyEnum.PlayerStrategy.PLAYER_STRATEGY_AUTO;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public static class PlayerChooserForFeature implements ITVKPlayerChooser {

        @NonNull
        private final ITVKPlayerFeatureGroup mPlayerFeatureGroup;

        @NonNull
        private final TVKPlayerRuntimeParam mRuntimeParam;

        public PlayerChooserForFeature(@NonNull TVKPlayerRuntimeParam tVKPlayerRuntimeParam, @NonNull ITVKPlayerFeatureGroup iTVKPlayerFeatureGroup) {
            this.mRuntimeParam = tVKPlayerRuntimeParam;
            this.mPlayerFeatureGroup = iTVKPlayerFeatureGroup;
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKAphonePlayerAndDecoderChooser.ITVKPlayerChooser
        public TVKStrategyEnum.PlayerStrategy getPlayer() {
            List<ITVKPlayerFeature> playerAndDecoderChooseList = TVKAphonePlayerAndDecoderChooser.getPlayerAndDecoderChooseList(this.mRuntimeParam.getNetVideoInfo(), this.mPlayerFeatureGroup);
            if (playerAndDecoderChooseList.isEmpty()) {
                return TVKStrategyEnum.PlayerStrategy.PLAYER_STRATEGY_AUTO;
            }
            TVKStrategyEnum.PlayerStrategy playerStrategy = TVKStrategyEnum.PlayerStrategy.PLAYER_STRATEGY_AUTO;
            for (ITVKPlayerFeature iTVKPlayerFeature : playerAndDecoderChooseList) {
                TVKStrategyEnum.PlayerStrategy playerChooseStrategy = TVKPlayerFeatureUtils.getPlayerChooseStrategy(iTVKPlayerFeature, this.mRuntimeParam.getNetVideoInfo());
                if (playerChooseStrategy != TVKStrategyEnum.PlayerStrategy.PLAYER_STRATEGY_AUTO) {
                    TVKLogUtil.i(TVKAphonePlayerAndDecoderChooser.TAG, "choosePlayerStrategy feature " + iTVKPlayerFeature.getClass().getName() + ", return " + playerChooseStrategy);
                    return playerChooseStrategy;
                }
                playerStrategy = playerChooseStrategy;
            }
            return playerStrategy;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public static class PlayerChooserForSpecialScene implements ITVKPlayerChooser {

        @NonNull
        private final TVKPlayerInputParam mInputParam;

        public PlayerChooserForSpecialScene(@NonNull TVKPlayerInputParam tVKPlayerInputParam) {
            this.mInputParam = tVKPlayerInputParam;
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKAphonePlayerAndDecoderChooser.ITVKPlayerChooser
        public TVKStrategyEnum.PlayerStrategy getPlayer() {
            if (TVKAphonePlayerAndDecoderChooser.isVideoCapture(this.mInputParam.getPlayerVideoInfo())) {
                return TVKStrategyEnum.PlayerStrategy.PLAYER_STRATEGY_SELF_ONLY;
            }
            return TVKStrategyEnum.PlayerStrategy.PLAYER_STRATEGY_AUTO;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public static class PlayerChooserForThumbPlayerUnavailable implements ITVKPlayerChooser {
        PlayerChooserForThumbPlayerUnavailable() {
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKAphonePlayerAndDecoderChooser.ITVKPlayerChooser
        public TVKStrategyEnum.PlayerStrategy getPlayer() {
            if (!TPMgr.isSelfDevPlayerAvailable()) {
                TVKLogUtil.i(TVKAphonePlayerAndDecoderChooser.TAG, "choosePlayerStrategy isThumbPlayerEnable is false, return system only");
                return TVKStrategyEnum.PlayerStrategy.PLAYER_STRATEGY_SYSTEM_ONLY;
            }
            return TVKStrategyEnum.PlayerStrategy.PLAYER_STRATEGY_AUTO;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public static class VideoDecoderChooserForAppForce implements ITVKVideoDecoderChooser {

        @NonNull
        private final TVKPlayerInputParam mInputParam;

        public VideoDecoderChooserForAppForce(@NonNull TVKPlayerInputParam tVKPlayerInputParam) {
            this.mInputParam = tVKPlayerInputParam;
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKAphonePlayerAndDecoderChooser.ITVKVideoDecoderChooser
        public TVKStrategyEnum.VideoDecoderStrategy getVideoDecoder(TVKStrategyEnum.PlayerStrategy playerStrategy) {
            int i3 = 0;
            if (this.mInputParam.getPlayerVideoInfo() != null) {
                i3 = TVKUtils.optInt(this.mInputParam.getPlayerVideoInfo().getConfigMapValue("player_forcetype", String.valueOf(0)), 0);
            }
            if (i3 != 1 && i3 != 2) {
                if (i3 != 3) {
                    return TVKStrategyEnum.VideoDecoderStrategy.VIDEO_DECODER_STRATEGY_AUTO;
                }
                return TVKStrategyEnum.VideoDecoderStrategy.VIDEO_DECODER_STRATEGY_SOFT_ONLY;
            }
            return TVKStrategyEnum.VideoDecoderStrategy.VIDEO_DECODER_STRATEGY_MEDIACODEC_FIRST;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public static class VideoDecoderChooserForConfig implements ITVKVideoDecoderChooser {

        @NonNull
        private final TVKPlayerInputParam mInputParam;

        @NonNull
        private final TVKPlayerRuntimeParam mRuntimeParam;

        public VideoDecoderChooserForConfig(@NonNull TVKPlayerInputParam tVKPlayerInputParam, @NonNull TVKPlayerRuntimeParam tVKPlayerRuntimeParam) {
            this.mInputParam = tVKPlayerInputParam;
            this.mRuntimeParam = tVKPlayerRuntimeParam;
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKAphonePlayerAndDecoderChooser.ITVKVideoDecoderChooser
        public TVKStrategyEnum.VideoDecoderStrategy getVideoDecoder(TVKStrategyEnum.PlayerStrategy playerStrategy) {
            String playerConfig = TVKAphonePlayerAndDecoderChooser.getPlayerConfig(this.mRuntimeParam.getTVKAsset());
            if ("self".equalsIgnoreCase(playerConfig)) {
                return TVKStrategyEnum.VideoDecoderStrategy.VIDEO_DECODER_STRATEGY_MEDIACODEC_FIRST;
            }
            if (TVKPlayerMsg.PLAYER_CHOICE_SELF_SOFT.equalsIgnoreCase(playerConfig)) {
                return TVKStrategyEnum.VideoDecoderStrategy.VIDEO_DECODER_STRATEGY_SOFT_ONLY;
            }
            if (TVKPlayerMsg.PLAYER_CHOICE_SYSTEM.equalsIgnoreCase(playerConfig)) {
                return TVKStrategyEnum.VideoDecoderStrategy.VIDEO_DECODER_STRATEGY_MEDIACODEC_FIRST;
            }
            return TVKStrategyEnum.VideoDecoderStrategy.VIDEO_DECODER_STRATEGY_AUTO;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public static class VideoDecoderChooserForFeature implements ITVKVideoDecoderChooser {

        @NonNull
        private final ITVKPlayerFeatureGroup mPlayerFeatureGroup;

        @NonNull
        private final TVKPlayerRuntimeParam mRuntimeParam;

        public VideoDecoderChooserForFeature(@NonNull TVKPlayerRuntimeParam tVKPlayerRuntimeParam, @NonNull ITVKPlayerFeatureGroup iTVKPlayerFeatureGroup) {
            this.mRuntimeParam = tVKPlayerRuntimeParam;
            this.mPlayerFeatureGroup = iTVKPlayerFeatureGroup;
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKAphonePlayerAndDecoderChooser.ITVKVideoDecoderChooser
        public TVKStrategyEnum.VideoDecoderStrategy getVideoDecoder(TVKStrategyEnum.PlayerStrategy playerStrategy) {
            List<ITVKPlayerFeature> playerAndDecoderChooseList = TVKAphonePlayerAndDecoderChooser.getPlayerAndDecoderChooseList(this.mRuntimeParam.getNetVideoInfo(), this.mPlayerFeatureGroup);
            if (playerAndDecoderChooseList.isEmpty()) {
                return TVKStrategyEnum.VideoDecoderStrategy.VIDEO_DECODER_STRATEGY_AUTO;
            }
            TVKStrategyEnum.VideoDecoderStrategy videoDecoderStrategy = TVKStrategyEnum.VideoDecoderStrategy.VIDEO_DECODER_STRATEGY_AUTO;
            for (ITVKPlayerFeature iTVKPlayerFeature : playerAndDecoderChooseList) {
                TVKStrategyEnum.VideoDecoderStrategy videoDecoderChooseStrategy = TVKPlayerFeatureUtils.getVideoDecoderChooseStrategy(iTVKPlayerFeature, this.mRuntimeParam.getNetVideoInfo());
                if (videoDecoderChooseStrategy != TVKStrategyEnum.VideoDecoderStrategy.VIDEO_DECODER_STRATEGY_AUTO) {
                    TVKLogUtil.i(TVKAphonePlayerAndDecoderChooser.TAG, "chooseDecoderStrategy feature " + iTVKPlayerFeature.getClass().getName() + ", return " + videoDecoderChooseStrategy);
                    return videoDecoderChooseStrategy;
                }
                videoDecoderStrategy = videoDecoderChooseStrategy;
            }
            return videoDecoderStrategy;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public static class VideoDecoderChooserForSpecialScene implements ITVKVideoDecoderChooser {

        @NonNull
        private final TVKPlayerInputParam mInputParam;

        public VideoDecoderChooserForSpecialScene(@NonNull TVKPlayerInputParam tVKPlayerInputParam) {
            this.mInputParam = tVKPlayerInputParam;
        }

        private TVKStrategyEnum.VideoDecoderStrategy getAppConfigDecoder(Context context) {
            if (TVKPlayerStrategy.isEnabledHWDec(context) && TVKMediaPlayerConfig.PlayerConfig.is_use_mediacodec) {
                return TVKStrategyEnum.VideoDecoderStrategy.VIDEO_DECODER_STRATEGY_AUTO;
            }
            return TVKStrategyEnum.VideoDecoderStrategy.VIDEO_DECODER_STRATEGY_SOFT_ONLY;
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKAphonePlayerAndDecoderChooser.ITVKVideoDecoderChooser
        public TVKStrategyEnum.VideoDecoderStrategy getVideoDecoder(TVKStrategyEnum.PlayerStrategy playerStrategy) {
            if (TVKAphonePlayerAndDecoderChooser.isVideoCapture(this.mInputParam.getPlayerVideoInfo())) {
                TVKLogUtil.i(TVKAphonePlayerAndDecoderChooser.TAG, "chooseDecoderStrategy getPlayModeDecoder, return soft only");
                return TVKStrategyEnum.VideoDecoderStrategy.VIDEO_DECODER_STRATEGY_SOFT_ONLY;
            }
            TVKStrategyEnum.VideoDecoderStrategy appConfigDecoder = getAppConfigDecoder(TVKCommParams.getApplicationContext());
            TVKStrategyEnum.VideoDecoderStrategy videoDecoderStrategy = TVKStrategyEnum.VideoDecoderStrategy.VIDEO_DECODER_STRATEGY_AUTO;
            if (appConfigDecoder != videoDecoderStrategy) {
                TVKLogUtil.i(TVKAphonePlayerAndDecoderChooser.TAG, "chooseDecoderStrategy getAppConfigDecoder, return " + appConfigDecoder);
                return appConfigDecoder;
            }
            return videoDecoderStrategy;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public static class VideoDecoderChooserWithPlayer implements ITVKVideoDecoderChooser {
        VideoDecoderChooserWithPlayer() {
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKAphonePlayerAndDecoderChooser.ITVKVideoDecoderChooser
        public TVKStrategyEnum.VideoDecoderStrategy getVideoDecoder(TVKStrategyEnum.PlayerStrategy playerStrategy) {
            if (playerStrategy == TVKStrategyEnum.PlayerStrategy.PLAYER_STRATEGY_SYSTEM_ONLY) {
                TVKLogUtil.i(TVKAphonePlayerAndDecoderChooser.TAG, "chooseDecoderStrategy system only, return hard first");
                return TVKStrategyEnum.VideoDecoderStrategy.VIDEO_DECODER_STRATEGY_MEDIACODEC_FIRST;
            }
            return TVKStrategyEnum.VideoDecoderStrategy.VIDEO_DECODER_STRATEGY_AUTO;
        }
    }

    public TVKAphonePlayerAndDecoderChooser(@NonNull TVKPlayerInputParam tVKPlayerInputParam, @NonNull TVKPlayerRuntimeParam tVKPlayerRuntimeParam, @NonNull ITVKPlayerFeatureGroup iTVKPlayerFeatureGroup) {
        this.mInputParam = tVKPlayerInputParam;
        this.mRuntimeParam = tVKPlayerRuntimeParam;
        this.mPlayerFeatureGroup = iTVKPlayerFeatureGroup;
        initPlayerChooserList();
        initVideoDecoderChooserList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<ITVKPlayerFeature> getPlayerAndDecoderChooseList(TVKNetVideoInfo tVKNetVideoInfo, ITVKPlayerFeatureGroup iTVKPlayerFeatureGroup) {
        if (iTVKPlayerFeatureGroup != null && tVKNetVideoInfo != null) {
            if (tVKNetVideoInfo instanceof TVKVodVideoInfo) {
                return iTVKPlayerFeatureGroup.getVodPlayerAndDecoderChooseFeatureList();
            }
            return iTVKPlayerFeatureGroup.getLivePlayerAndDecoderChooseFeatureList();
        }
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getPlayerConfig(ITVKAsset iTVKAsset) {
        if (iTVKAsset == null) {
            return "";
        }
        if (TVKAssetUtils.isLiveAsset(iTVKAsset)) {
            return TVKMediaPlayerConfig.PlayerConfig.live_player;
        }
        if (!TVKAssetUtils.isVodAsset(iTVKAsset)) {
            return "";
        }
        return TVKMediaPlayerConfig.PlayerConfig.vod_player;
    }

    private void initPlayerChooserList() {
        this.mPlayerChooserList.add(new PlayerChooserForThumbPlayerUnavailable());
        this.mPlayerChooserList.add(new PlayerChooserForSpecialScene(this.mInputParam));
        this.mPlayerChooserList.add(new PlayerChooserForFeature(this.mRuntimeParam, this.mPlayerFeatureGroup));
        this.mPlayerChooserList.add(new PlayerChooserForAppForce(this.mInputParam));
        this.mPlayerChooserList.add(new PlayerChooserForConfig(this.mInputParam, this.mRuntimeParam));
    }

    private void initVideoDecoderChooserList() {
        this.mVideoDecoderChooserList.add(new VideoDecoderChooserWithPlayer());
        this.mVideoDecoderChooserList.add(new VideoDecoderChooserForSpecialScene(this.mInputParam));
        this.mVideoDecoderChooserList.add(new VideoDecoderChooserForFeature(this.mRuntimeParam, this.mPlayerFeatureGroup));
        this.mVideoDecoderChooserList.add(new VideoDecoderChooserForAppForce(this.mInputParam));
        this.mVideoDecoderChooserList.add(new VideoDecoderChooserForConfig(this.mInputParam, this.mRuntimeParam));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isVideoCapture(TVKPlayerVideoInfo tVKPlayerVideoInfo) {
        if (tVKPlayerVideoInfo != null && PLAYER_VIDEO_CAPTURE.equals(tVKPlayerVideoInfo.getConfigMapValue("playmode", ""))) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.strategy.ITVKPlayerAndDecoderChooser
    public TVKStrategyEnum.PlayerStrategy choosePlayerStrategy() {
        TVKStrategyEnum.PlayerStrategy playerStrategy = TVKStrategyEnum.PlayerStrategy.PLAYER_STRATEGY_AUTO;
        Iterator<ITVKPlayerChooser> it = this.mPlayerChooserList.iterator();
        while (it.hasNext()) {
            playerStrategy = it.next().getPlayer();
            if (playerStrategy != TVKStrategyEnum.PlayerStrategy.PLAYER_STRATEGY_AUTO) {
                TVKLogUtil.i(TAG, "choosePlayerStrategy, return:" + playerStrategy);
                return playerStrategy;
            }
        }
        TVKLogUtil.i(TAG, "choosePlayerStrategy nothing, return auto");
        return playerStrategy;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.strategy.ITVKPlayerAndDecoderChooser
    public TVKStrategyEnum.VideoDecoderStrategy chooseVideoDecoderStrategy(TVKStrategyEnum.PlayerStrategy playerStrategy) {
        int i3;
        TVKStrategyEnum.VideoDecoderStrategy videoDecoderStrategy = TVKStrategyEnum.VideoDecoderStrategy.VIDEO_DECODER_STRATEGY_AUTO;
        Iterator<ITVKVideoDecoderChooser> it = this.mVideoDecoderChooserList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            videoDecoderStrategy = it.next().getVideoDecoder(playerStrategy);
            if (videoDecoderStrategy != TVKStrategyEnum.VideoDecoderStrategy.VIDEO_DECODER_STRATEGY_AUTO) {
                TVKLogUtil.i(TAG, "chooseDecoderStrategy, return:" + videoDecoderStrategy);
                break;
            }
        }
        boolean hasHaTurnOffForTimeout = TVKPlayerStrategy.hasHaTurnOffForTimeout();
        int mediaCodecInitContinuousTimeoutCount = TVKPlayerStrategy.getMediaCodecInitContinuousTimeoutCount();
        if (!hasHaTurnOffForTimeout) {
            i3 = TVKPlayerStrategy.getMaxMediaCodecInitTimeoutCount();
        } else {
            i3 = TVKMediaPlayerConfig.PlayerConfig.ha_max_init_timeout_count_for_has_turn_off;
        }
        if (videoDecoderStrategy != TVKStrategyEnum.VideoDecoderStrategy.VIDEO_DECODER_STRATEGY_MEDIACODEC_ONLY && i3 > 0 && mediaCodecInitContinuousTimeoutCount >= i3) {
            TVKLogUtil.i(TAG, "chooseDecoderStrategy, mediacodec init timeout count beyond " + i3 + " and return soft only");
            return TVKStrategyEnum.VideoDecoderStrategy.VIDEO_DECODER_STRATEGY_SOFT_ONLY;
        }
        return videoDecoderStrategy;
    }
}
