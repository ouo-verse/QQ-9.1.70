package com.tencent.qqlive.tvkplayer.qqliveasset.player;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.asset.TVKAssetUtils;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.common.TVKPositionTransformUtils;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerInputParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerRuntimeParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger;
import com.tencent.qqlive.tvkplayer.tools.log.TVKLogger;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import com.tencent.thumbplayer.core.datatransport.api.TPDataTransportEnum;
import java.util.Map;

/* loaded from: classes23.dex */
public class TVKPlayerRealTimeInfoProcessor {
    private static final int KEY_SKIP_END_POSITION_MS = 2;
    private static final int KEY_SKIP_START_POSITION_MS = 1;
    private static final String MODULE_NAME = "TVKQQLiveAssetPlayer";
    private static final int VALUE_PRELOAD_ACTIVE = 1;
    private static final int VALUE_PRELOAD_NOT_ACTIVE = 0;

    @NonNull
    private final TVKQQLiveAssetPlayerContext mAssetPlayerContext;

    @NonNull
    private final TVKPlayerInputParam mInputParam;

    @NonNull
    private final ITVKLogger mLogger;

    @NonNull
    private final TVKPlayerRuntimeParam mRunTimeParam;

    public TVKPlayerRealTimeInfoProcessor(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext) {
        this.mAssetPlayerContext = tVKQQLiveAssetPlayerContext;
        this.mRunTimeParam = tVKQQLiveAssetPlayerContext.getRuntimeParam();
        this.mInputParam = tVKQQLiveAssetPlayerContext.getInputParam();
        this.mLogger = new TVKLogger(tVKQQLiveAssetPlayerContext, MODULE_NAME);
    }

    private void handleAdaptiveMode(Object obj) {
        if (!(obj instanceof Integer)) {
            this.mLogger.warn("real time info : PLAYER_REALTIME_INFO_TYPE_ADAPTIVE_MODE, value type invalid:" + obj, new Object[0]);
            return;
        }
        Integer num = (Integer) obj;
        this.mLogger.info("real time info : PLAYER_REALTIME_INFO_TYPE_ADAPTIVE_MODE, value: " + num, new Object[0]);
        this.mAssetPlayerContext.getInputParam().setAdaptiveMode(num);
        this.mAssetPlayerContext.getPlayer().addOptionalParam(TPOptionalParam.buildInt(TPDataTransportEnum.TASK_OPTIONAL_CONFIG_PARAM_INT_ADAPTIVE_MODE, num.intValue()));
    }

    private void handleBackgroundPlay(Object obj) {
        if (!(obj instanceof Boolean)) {
            this.mLogger.warn("real time info : PLAYER_REALTIME_INFO_TYPE_BACKGROUND_PLAY, value type invalid:" + obj, new Object[0]);
            return;
        }
        this.mLogger.info("real time info : PLAYER_REALTIME_INFO_TYPE_BACKGROUND_PLAY , value : " + obj, new Object[0]);
        this.mInputParam.setEnableBackgroundPlay(((Boolean) obj).booleanValue());
    }

    private void handleMediaLabVRViewportChanged(Object obj) {
        if (!(obj instanceof String)) {
            this.mLogger.warn("real time info : PLAYER_REALTIME_INFO_TYPE_MEDIA_LAB_VR_VIEWPORT_CHANGED, value type invalid:" + obj, new Object[0]);
            return;
        }
        this.mAssetPlayerContext.getPlayer().addOptionalParam(TPOptionalParam.buildString(TPOptionalID.OPTIONAL_ID_GLOBAL_STRING_MEDIALABVR_VIEWPORT, (String) obj));
    }

    private void handlePreload(Object obj) {
        if (!(obj instanceof Integer)) {
            this.mLogger.warn("real time info : PLAYER_REALTIME_INFO_TYPE_IS_PRELOAD, value type invalid:" + obj, new Object[0]);
            return;
        }
        int intValue = ((Integer) obj).intValue();
        this.mLogger.info("real time info : PLAYER_REALTIME_INFO_TYPE_IS_PRELOAD, value : " + intValue, new Object[0]);
        if (intValue == 0) {
            this.mAssetPlayerContext.getPlayer().addOptionalParam(TPOptionalParam.buildInt(TPDataTransportEnum.TASK_OPTIONAL_CONFIG_PARAM_INT_RUNNING_STATE, 1));
        } else if (intValue == 1) {
            this.mAssetPlayerContext.getPlayer().addOptionalParam(TPOptionalParam.buildInt(TPDataTransportEnum.TASK_OPTIONAL_CONFIG_PARAM_INT_RUNNING_STATE, 0));
        } else {
            this.mLogger.info("real time info : PLAYER_REALTIME_INFO_TYPE_IS_PRELOAD, invalid value", new Object[0]);
        }
    }

    private void handleSkipPosition(Object obj) {
        if (!(obj instanceof Map)) {
            this.mLogger.warn("real time info : PLAYER_REALTIME_INFO_TYPE_SKIP_POS, value type invalid:" + obj, new Object[0]);
            return;
        }
        this.mLogger.info("real time info : PLAYER_REALTIME_INFO_TYPE_SKIP_POS , value : " + obj, new Object[0]);
        for (Map.Entry entry : ((Map) obj).entrySet()) {
            if ((entry.getKey() instanceof Integer) || (entry.getValue() instanceof Long)) {
                int intValue = ((Integer) entry.getKey()).intValue();
                if (intValue == 1) {
                    setSkipStartPositionOptional(((Long) entry.getValue()).longValue());
                } else if (intValue == 2) {
                    setSkipEndPositionOptional(((Long) entry.getValue()).longValue());
                }
            }
        }
    }

    private boolean isStartPositionOutOfPreviewRange(long j3) {
        TVKNetVideoInfo netVideoInfo;
        if (!TVKAssetUtils.isVodAsset(this.mRunTimeParam.getTVKAsset()) || !this.mRunTimeParam.isPreview() || (netVideoInfo = this.mRunTimeParam.getNetVideoInfo()) == null) {
            return false;
        }
        long previewStartPositionSec = netVideoInfo.getPreviewStartPositionSec() * 1000;
        long previewStartPositionSec2 = (netVideoInfo.getPreviewStartPositionSec() + netVideoInfo.getPreviewDurationSec()) * 1000;
        if (j3 >= previewStartPositionSec && j3 < previewStartPositionSec2) {
            return false;
        }
        return true;
    }

    private void setSkipEndPositionOptional(long j3) {
        if (TVKAssetUtils.isVodAsset(this.mRunTimeParam.getTVKAsset()) && this.mRunTimeParam.isPreview()) {
            this.mLogger.warn("previewing vod asset, skipEndPositionMs setting is ignored", new Object[0]);
            return;
        }
        long adjustSkipEndPositionForEmbeddedAd = TVKPositionTransformUtils.adjustSkipEndPositionForEmbeddedAd(j3, this.mRunTimeParam.getNetVideoInfo());
        this.mRunTimeParam.setSkipEndPositionMs(adjustSkipEndPositionForEmbeddedAd);
        this.mAssetPlayerContext.getPlayer().addOptionalParam(TPOptionalParam.buildLong(TPOptionalID.OPTIONAL_ID_GLOBAL_LONG_SKIP_END_TIME_MS, adjustSkipEndPositionForEmbeddedAd));
    }

    private void setSkipStartPositionOptional(long j3) {
        long adjustSkipStartPositionForEmbeddedAd = TVKPositionTransformUtils.adjustSkipStartPositionForEmbeddedAd(j3, this.mRunTimeParam.getNetVideoInfo());
        if (isStartPositionOutOfPreviewRange(adjustSkipStartPositionForEmbeddedAd) && this.mInputParam.getPlayerVideoInfo() != null && !TextUtils.equals(this.mInputParam.getPlayerVideoInfo().getConfigMapValue(TVKPlayerVideoInfo.PLAYER_CFG_KEY_DISABLE_START_POSITION_CORRECTION, ""), "true")) {
            adjustSkipStartPositionForEmbeddedAd = this.mRunTimeParam.getNetVideoInfo().getPreviewStartPositionSec() * 1000;
            this.mLogger.warn("start position out of preview range. Corrected to preview start position", new Object[0]);
        }
        this.mRunTimeParam.setStartPositionMs(adjustSkipStartPositionForEmbeddedAd);
        this.mAssetPlayerContext.getPlayer().addOptionalParam(TPOptionalParam.buildLong(TPOptionalID.OPTIONAL_ID_BEFORE_LONG_START_PLAYING_TIME_MS, adjustSkipStartPositionForEmbeddedAd));
    }

    public void onRealTimeInfoChange(int i3, Object obj) throws IllegalArgumentException {
        if (i3 != 1) {
            if (i3 != 6) {
                if (i3 != 10) {
                    if (i3 != 14) {
                        if (i3 == 16) {
                            handleAdaptiveMode(obj);
                            return;
                        }
                        return;
                    }
                    handleMediaLabVRViewportChanged(obj);
                    return;
                }
                handleBackgroundPlay(obj);
                return;
            }
            handleSkipPosition(obj);
            return;
        }
        handlePreload(obj);
    }
}
