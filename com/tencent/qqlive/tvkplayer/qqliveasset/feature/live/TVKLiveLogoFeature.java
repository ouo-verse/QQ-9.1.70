package com.tencent.qqlive.tvkplayer.qqliveasset.feature.live;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKDynamicsLogoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKLiveVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKLogoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerInputParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerRuntimeParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKStrategyEnum;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKJsonUtils;
import com.tencent.qqlive.tvkplayer.vinfo.api.TVKCGIRequestParam;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureParamGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKLiveLogoFeature extends TVKLivePlayerFeatureBase {
    public TVKLiveLogoFeature(TVKContext tVKContext) {
        super(tVKContext);
    }

    private void parseDynamicsLogoInfo(@NonNull TVKLiveVideoInfo tVKLiveVideoInfo, @NonNull JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray;
        JSONObject optJSONObject = jSONObject.optJSONObject("activelogo");
        if (optJSONObject == null) {
            return;
        }
        TVKDynamicsLogoInfo tVKDynamicsLogoInfo = new TVKDynamicsLogoInfo();
        tVKDynamicsLogoInfo.setRunMode(TVKJsonUtils.optInt(optJSONObject, "runmod", 0));
        tVKDynamicsLogoInfo.setDurationMs(TVKJsonUtils.optInt(optJSONObject, "duration", 0));
        tVKDynamicsLogoInfo.setStartTimeMs(TVKJsonUtils.optInt(optJSONObject, "start", 0));
        tVKDynamicsLogoInfo.setScale(TVKJsonUtils.optInt(optJSONObject, "rw", 0));
        tVKDynamicsLogoInfo.setRepeat(TVKJsonUtils.optInt(optJSONObject, "repeat", 0));
        tVKLiveVideoInfo.setDynamicLogo(tVKDynamicsLogoInfo);
        if (!optJSONObject.has("scenes") || (jSONArray = optJSONObject.getJSONArray("scenes")) == null) {
            return;
        }
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
            if (jSONObject2 != null) {
                tVKDynamicsLogoInfo.addScenes(parseLogoScenes(jSONObject2));
            }
        }
    }

    private void parseFloatWatermark(@NonNull TVKLiveVideoInfo tVKLiveVideoInfo, @NonNull JSONObject jSONObject) throws JSONException {
        JSONObject optJSONObject = jSONObject.optJSONObject("float_mark");
        if (optJSONObject == null) {
            return;
        }
        TVKNetVideoInfo.TVKFloatWaterMarkInfo tVKFloatWaterMarkInfo = new TVKNetVideoInfo.TVKFloatWaterMarkInfo();
        tVKFloatWaterMarkInfo.setFWFlag(TVKJsonUtils.optInt(optJSONObject, "fwflag", 0));
        tVKFloatWaterMarkInfo.setUKey(TVKJsonUtils.optString(optJSONObject, "uin", ""));
        tVKLiveVideoInfo.setFloatWaterMarkInfo(tVKFloatWaterMarkInfo);
    }

    private List<TVKLogoInfo> parseLogoPosInfo(@NonNull JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i3);
            if (jSONObject != null) {
                TVKLogoInfo tVKLogoInfo = new TVKLogoInfo();
                tVKLogoInfo.setId(TVKJsonUtils.optInt(jSONObject, "id", 0));
                tVKLogoInfo.setX(TVKJsonUtils.optInt(jSONObject, HippyTKDListViewAdapter.X, 0));
                tVKLogoInfo.setY(TVKJsonUtils.optInt(jSONObject, "y", 0));
                tVKLogoInfo.setWidth(TVKJsonUtils.optInt(jSONObject, "w", 0));
                tVKLogoInfo.setHeight(TVKJsonUtils.optInt(jSONObject, h.F, 0));
                tVKLogoInfo.setVideoMinSideSize(TVKJsonUtils.optInt(jSONObject, "rw", 0));
                tVKLogoInfo.setAlpha(TVKJsonUtils.optInt(jSONObject, "a", 0));
                tVKLogoInfo.setMd5(TVKJsonUtils.optString(jSONObject, "md5", ""));
                tVKLogoInfo.setLogoUrl(TVKJsonUtils.optString(jSONObject, "url", ""));
                arrayList.add(tVKLogoInfo);
            }
        }
        return arrayList;
    }

    private TVKDynamicsLogoInfo.Scenes parseLogoScenes(@NonNull JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray;
        TVKDynamicsLogoInfo.Scenes scenes = new TVKDynamicsLogoInfo.Scenes();
        scenes.setInTimeMs(TVKJsonUtils.optInt(jSONObject, "in", 0));
        scenes.setOutTimeMs(TVKJsonUtils.optInt(jSONObject, "out", 0));
        scenes.setStart(TVKJsonUtils.optInt(jSONObject, "start", 0));
        scenes.setEnd(TVKJsonUtils.optInt(jSONObject, "end", 0));
        if (jSONObject.has("wi") && (jSONArray = jSONObject.getJSONArray("wi")) != null) {
            scenes.setLogoInfoList(parseLogoPosInfo(jSONArray));
        }
        return scenes;
    }

    private void parseStaticLogoInfo(@NonNull TVKLiveVideoInfo tVKLiveVideoInfo, @NonNull JSONObject jSONObject) throws JSONException {
        JSONObject optJSONObject = jSONObject.optJSONObject("brandlogo");
        if (optJSONObject == null) {
            return;
        }
        String optString = TVKJsonUtils.optString(optJSONObject, "url", "");
        String optString2 = TVKJsonUtils.optString(optJSONObject, "md5", "");
        boolean z16 = true;
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
            TVKLogoInfo tVKLogoInfo = new TVKLogoInfo();
            tVKLogoInfo.setWidth(TVKJsonUtils.optInt(optJSONObject, "w", 0));
            tVKLogoInfo.setHeight(TVKJsonUtils.optInt(optJSONObject, h.F, 0));
            tVKLogoInfo.setX(TVKJsonUtils.optInt(optJSONObject, HippyTKDListViewAdapter.X, 0));
            tVKLogoInfo.setY(TVKJsonUtils.optInt(optJSONObject, "y", 0));
            tVKLogoInfo.setVideoMinSideSize(TVKJsonUtils.optInt(optJSONObject, "rw", 0));
            tVKLogoInfo.setAlpha(TVKJsonUtils.optInt(optJSONObject, "a", 100));
            tVKLogoInfo.setLogoHttpsUrl(TVKJsonUtils.optString(optJSONObject, "surl", ""));
            tVKLogoInfo.setLogoUrl(optString);
            tVKLogoInfo.setMd5(optString2);
            if (TVKJsonUtils.optInt(optJSONObject, "show", 0) != 1) {
                z16 = false;
            }
            tVKLogoInfo.setShow(z16);
            tVKLiveVideoInfo.addLogoInfo(tVKLogoInfo);
            return;
        }
        TVKNetVideoInfo.LogoPositionInfo logoPositionInfo = new TVKNetVideoInfo.LogoPositionInfo();
        logoPositionInfo.setLogoWidth(TVKJsonUtils.optInt(optJSONObject, "w", 0));
        logoPositionInfo.setLogoHeight(TVKJsonUtils.optInt(optJSONObject, h.F, 0));
        logoPositionInfo.setLogoX(TVKJsonUtils.optInt(optJSONObject, HippyTKDListViewAdapter.X, 0));
        logoPositionInfo.setLogoY(TVKJsonUtils.optInt(optJSONObject, "y", 0));
        if (TVKJsonUtils.optInt(optJSONObject, "show", 0) != 1) {
            z16 = false;
        }
        logoPositionInfo.setLogShow(z16);
        tVKLiveVideoInfo.setLogoPositionInfo(logoPositionInfo);
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
        if (tVKNetVideoInfo == null) {
            return false;
        }
        if (tVKNetVideoInfo.getLogoList().isEmpty() && tVKNetVideoInfo.getLogoPositionInfo() == null && tVKNetVideoInfo.getDynamicLogo() == null) {
            return false;
        }
        return true;
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
        parseStaticLogoInfo(tVKLiveVideoInfo, jSONObject);
        parseDynamicsLogoInfo(tVKLiveVideoInfo, jSONObject);
        parseFloatWatermark(tVKLiveVideoInfo, jSONObject);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public void processOnCGISuccess(@NonNull TVKPlayerInputParam tVKPlayerInputParam, @NonNull TVKPlayerRuntimeParam tVKPlayerRuntimeParam) {
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKLiveFeature
    public void buildLiveCGIParams(@NonNull TVKCGIRequestParam tVKCGIRequestParam, ITVKFeatureParamGroup iTVKFeatureParamGroup, @NonNull Map<String, String> map) {
    }
}
