package com.tencent.qqlive.tvkplayer.qqliveasset.feature.live;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKLiveVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerInputParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerRuntimeParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKStrategyEnum;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKJsonUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.vinfo.api.TVKCGIRequestParam;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureBase;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureParamGroup;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKIllegalCGIResponseException;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public class TVKLivePlayBackFeature extends TVKLivePlayerFeatureBase {

    /* loaded from: classes23.dex */
    public static class TVKLivePlayBackFeatureParam implements ITVKFeatureBase.ITVKFeatureParam {
        private final long mLivePlayBackTimeSec;

        public TVKLivePlayBackFeatureParam(long j3) {
            this.mLivePlayBackTimeSec = j3 == 0 ? -1L : j3;
        }

        public long getLivePlayBackTimeSec() {
            return this.mLivePlayBackTimeSec;
        }
    }

    public TVKLivePlayBackFeature(TVKContext tVKContext) {
        super(tVKContext);
    }

    private long getLivePlayBackTimeSec(ITVKFeatureParamGroup iTVKFeatureParamGroup) {
        TVKLivePlayBackFeatureParam tVKLivePlayBackFeatureParam;
        if (iTVKFeatureParamGroup == null || (tVKLivePlayBackFeatureParam = (TVKLivePlayBackFeatureParam) iTVKFeatureParamGroup.getFeatureParamByClass(TVKLivePlayBackFeatureParam.class)) == null) {
            return -1L;
        }
        return tVKLivePlayBackFeatureParam.getLivePlayBackTimeSec();
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKLiveFeature
    public void buildLiveCGIParams(@NonNull TVKCGIRequestParam tVKCGIRequestParam, ITVKFeatureParamGroup iTVKFeatureParamGroup, @NonNull Map<String, String> map) {
        if (tVKCGIRequestParam.getVideoInfo().configMapContainsKey(TVKPlayerVideoInfo.PLAYER_CFG_KEY_LIVE_PLAYBACKTIME_MS)) {
            map.put("playbacktime", String.valueOf(TVKUtils.optLong(tVKCGIRequestParam.getVideoInfo().getConfigMapValue(TVKPlayerVideoInfo.PLAYER_CFG_KEY_LIVE_PLAYBACKTIME_MS, ""), 0L) / 1000));
            tVKCGIRequestParam.getVideoInfo().removeConfigMap(TVKPlayerVideoInfo.PLAYER_CFG_KEY_LIVE_PLAYBACKTIME_MS);
        } else {
            long livePlayBackTimeSec = getLivePlayBackTimeSec(iTVKFeatureParamGroup);
            if (livePlayBackTimeSec != -1) {
                map.put("playbacktime", String.valueOf(livePlayBackTimeSec));
            }
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public ITVKPlayerFeature.FeaturePlayerAndDecoderChoosePriority getPlayerAndDecoderChoosePriority() {
        return ITVKPlayerFeature.FeaturePlayerAndDecoderChoosePriority.PLAYER_AND_DECODER_CHOOSE_DEFAULT;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public TVKStrategyEnum.PlayerStrategy getPlayerChooseStrategy() {
        return TVKStrategyEnum.PlayerStrategy.PLAYER_STRATEGY_AUTO;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public TVKStrategyEnum.ProxyStrategy getProxyStrategy() {
        return TVKStrategyEnum.ProxyStrategy.PROXY_STRATEGY_AUTO;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public ITVKPlayerFeature.FeatureRetryPriority getRetryPriority() {
        return ITVKPlayerFeature.FeatureRetryPriority.RETRY_NONE;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public TVKStrategyEnum.VideoDecoderStrategy getVideoDecoderChooseStrategy() {
        return TVKStrategyEnum.VideoDecoderStrategy.VIDEO_DECODER_STRATEGY_AUTO;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public boolean isMatchFeature(TVKNetVideoInfo tVKNetVideoInfo) {
        if (!(tVKNetVideoInfo instanceof TVKLiveVideoInfo)) {
            return false;
        }
        return ((TVKLiveVideoInfo) tVKNetVideoInfo).isPlayback();
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public boolean isNeedDisableFeatureForRetry() {
        return false;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public boolean isSupportVideoPostProcess() {
        return true;
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKLiveFeature
    public void parseLiveCGIResponse(@NonNull TVKLiveVideoInfo tVKLiveVideoInfo, @NonNull JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject = jSONObject.optJSONObject("playback");
        if (optJSONObject != null && optJSONObject.length() != 0) {
            tVKLiveVideoInfo.setPlayBackStartSec(TVKJsonUtils.optLong(optJSONObject, "playbackstart", 0L));
            tVKLiveVideoInfo.setPlayBackTimeSec(TVKJsonUtils.optLong(optJSONObject, "playbacktime", 0L));
            tVKLiveVideoInfo.setSvrTick(tVKLiveVideoInfo.getServerTime());
        } else if (!tVKLiveVideoInfo.isPlayback()) {
        } else {
            throw new TVKIllegalCGIResponseException(5, "It is a playback request but no playback response was found. Interesting.");
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public void processOnCGISuccess(@NonNull TVKPlayerInputParam tVKPlayerInputParam, @NonNull TVKPlayerRuntimeParam tVKPlayerRuntimeParam) {
        tVKPlayerRuntimeParam.setLiveBackPlay(isMatchFeature(tVKPlayerRuntimeParam.getNetVideoInfo()));
        tVKPlayerRuntimeParam.setElapsedRealTimeOnGetCgiPlaybackUrlMs(SystemClock.elapsedRealtime());
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.live.TVKLivePlayerFeatureBase, com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureBase
    public void reset() {
        super.reset();
    }
}
