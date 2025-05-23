package com.tencent.qqlive.tvkplayer.vinfo.live;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.qzone.module.covercomponent.model.CoverDBCacheData;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qqlive.module.videoreport.dtreport.api.DefaultTVKDataProvider;
import com.tencent.qqlive.module.videoreport.dtreport.stdevent.PlayParamConst;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKLiveVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKJsonUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureGroup;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKLiveFeature;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKIllegalCGIResponseException;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public class TVKLiveInfoParser {
    private final List<ITVKLiveFeature> mFeatureList;

    public TVKLiveInfoParser(ITVKFeatureGroup iTVKFeatureGroup) {
        List<ITVKLiveFeature> liveFeatureList;
        if (iTVKFeatureGroup == null) {
            liveFeatureList = null;
        } else {
            liveFeatureList = iTVKFeatureGroup.getLiveFeatureList();
        }
        this.mFeatureList = liveFeatureList;
    }

    private TVKNetVideoInfo.DefnInfo getCurrentDefinitionInfo(@NonNull String str, @NonNull TVKLiveVideoInfo tVKLiveVideoInfo) {
        for (TVKNetVideoInfo.DefnInfo defnInfo : tVKLiveVideoInfo.getDefinitionList()) {
            if (TextUtils.equals(defnInfo.getDefn(), str)) {
                return defnInfo;
            }
        }
        return new TVKNetVideoInfo.DefnInfo();
    }

    private JSONObject getCurrentPlayResult(@NonNull String str, @NonNull JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray("play_list");
        if (optJSONArray == null) {
            return new JSONObject();
        }
        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
            JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
            if (TextUtils.equals(TVKJsonUtils.optString(jSONObject2, "defn", ""), str)) {
                return jSONObject2;
            }
        }
        return new JSONObject();
    }

    private void parseAudioTracks(@NonNull JSONObject jSONObject, @NonNull TVKNetVideoInfo.DefnInfo defnInfo) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray("tracks");
        if (optJSONArray == null) {
            defnInfo.setLiveAudioTracks(Collections.emptyList());
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
            arrayList.add(optJSONArray.getString(i3));
        }
        defnInfo.setLiveAudioTracks(arrayList);
    }

    private void parseByLiveFeatures(@NonNull JSONObject jSONObject, @NonNull TVKLiveVideoInfo tVKLiveVideoInfo) throws Exception {
        List<ITVKLiveFeature> list = this.mFeatureList;
        if (list == null) {
            return;
        }
        Iterator<ITVKLiveFeature> it = list.iterator();
        while (it.hasNext()) {
            try {
                it.next().parseLiveCGIResponse(tVKLiveVideoInfo, jSONObject);
            } catch (TVKIllegalCGIResponseException e16) {
                if (tVKLiveVideoInfo.getRetCode() == 0) {
                    throw e16;
                }
            }
        }
    }

    private void parseCodecParam(@NonNull JSONObject jSONObject, @NonNull TVKLiveVideoInfo tVKLiveVideoInfo) {
        JSONObject optJSONObject = jSONObject.optJSONObject("codec_param");
        if (optJSONObject == null) {
            return;
        }
        tVKLiveVideoInfo.setStream(TVKJsonUtils.optInt(optJSONObject, "stream", 0));
        tVKLiveVideoInfo.setHeightenType(TVKJsonUtils.optInt(optJSONObject, "heighten_type", 0));
        TVKNetVideoInfo.DefnInfo curDefinition = tVKLiveVideoInfo.getCurDefinition();
        curDefinition.setVideoBandwidth(TVKJsonUtils.optLong(optJSONObject, "bitrate", 0L));
        int optInt = TVKJsonUtils.optInt(optJSONObject, "acode", 0);
        int optInt2 = TVKJsonUtils.optInt(optJSONObject, "vcode", 0);
        tVKLiveVideoInfo.setaCode(optInt);
        tVKLiveVideoInfo.setvCode(optInt2);
        curDefinition.setAudioCodec(optInt);
        curDefinition.setVideoCodec(optInt2);
    }

    private void parseCryptParam(@NonNull JSONObject jSONObject, @NonNull TVKLiveVideoInfo tVKLiveVideoInfo) {
        JSONObject optJSONObject = jSONObject.optJSONObject("crypt_param");
        if (optJSONObject == null) {
            return;
        }
        tVKLiveVideoInfo.getCurDefinition().setDrm(TVKJsonUtils.optInt(optJSONObject, "drmtype", 0));
        tVKLiveVideoInfo.setCryptParamJsonString(optJSONObject.toString());
    }

    private void parseFastForward(@NonNull JSONObject jSONObject, @NonNull TVKLiveVideoInfo tVKLiveVideoInfo) {
        JSONObject optJSONObject = jSONObject.optJSONObject(QCircleDaTongConstant.ElementParamValue.FAST_FORWARD);
        if (optJSONObject == null) {
            return;
        }
        tVKLiveVideoInfo.setReduceLatencyAction(TVKJsonUtils.optInt(optJSONObject, "type", 0));
        tVKLiveVideoInfo.setSpeedUpRate(TVKJsonUtils.optFloat(optJSONObject, "speed", 1.0f));
        tVKLiveVideoInfo.setStartReduceLatencyBufferSizeSec(TVKJsonUtils.optFloat(optJSONObject, "start_fast_foward", 0.0f));
        tVKLiveVideoInfo.setStopReduceLatencyBufferSizeSec(TVKJsonUtils.optFloat(optJSONObject, "stop_fast_foward", 0.0f));
    }

    private void parseFormatList(@NonNull JSONObject jSONObject, @NonNull TVKLiveVideoInfo tVKLiveVideoInfo) throws JSONException {
        boolean z16;
        JSONArray optJSONArray = jSONObject.optJSONArray("format_list");
        if (optJSONArray == null) {
            return;
        }
        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
            JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
            TVKNetVideoInfo.DefnInfo defnInfo = new TVKNetVideoInfo.DefnInfo();
            defnInfo.setDefnId(TVKJsonUtils.optInt(jSONObject2, "sid", 0));
            defnInfo.setDefn(TVKJsonUtils.optString(jSONObject2, "defn", ""));
            defnInfo.setFnName(TVKJsonUtils.optString(jSONObject2, "defn_name", ""));
            defnInfo.setDefnRate(TVKJsonUtils.optString(jSONObject2, "defn_rate", ""));
            defnInfo.setDefnName(defnInfo.getFnName() + " " + defnInfo.getDefnRate());
            if (TVKJsonUtils.optInt(jSONObject2, "vip", 0) != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            defnInfo.setVipOnly(z16);
            defnInfo.setVfps(TVKJsonUtils.optInt(jSONObject2, "fps", 0));
            defnInfo.setGroup(TVKJsonUtils.optString(jSONObject2, VipFunCallConstants.KEY_GROUP, ""));
            JSONObject optJSONObject = jSONObject2.optJSONObject("tvminfo");
            if (optJSONObject != null) {
                defnInfo.setVideoSuperResolutionType(TVKJsonUtils.optInt(optJSONObject, "tvmsr_v2", 0));
                defnInfo.setTVMSRReasonCode(TVKJsonUtils.optInt(optJSONObject, "tvmsr_reason_code", 0));
                defnInfo.setSuperResolutionNeedVip(TVKJsonUtils.optInt(optJSONObject, "tvmsrlmt", 0));
            }
            parseAudioTracks(jSONObject2, defnInfo);
            tVKLiveVideoInfo.addDefinition(defnInfo);
        }
    }

    private void parsePlayResult(@NonNull JSONObject jSONObject, @NonNull TVKLiveVideoInfo tVKLiveVideoInfo) throws JSONException {
        String optString = TVKJsonUtils.optString(jSONObject, "suggest_defn", "");
        tVKLiveVideoInfo.setCurDefinition(getCurrentDefinitionInfo(optString, tVKLiveVideoInfo));
        JSONObject currentPlayResult = getCurrentPlayResult(optString, jSONObject);
        tVKLiveVideoInfo.setVid(TVKJsonUtils.optString(currentPlayResult, "sid", ""));
        boolean z16 = true;
        tVKLiveVideoInfo.setFp2p(TVKJsonUtils.optInt(currentPlayResult, "usep2p", 1));
        if (TVKJsonUtils.optInt(currentPlayResult, "isfree", 0) == 0) {
            z16 = false;
        }
        tVKLiveVideoInfo.setFreeNetFlowUrl(z16);
        tVKLiveVideoInfo.setCdnOrigin(TVKJsonUtils.optInt(currentPlayResult, TtmlNode.ATTR_TTS_ORIGIN, 0));
        parseUrls(currentPlayResult, tVKLiveVideoInfo);
        parseCodecParam(currentPlayResult, tVKLiveVideoInfo);
        parseCryptParam(currentPlayResult, tVKLiveVideoInfo);
    }

    private void parseUrls(@NonNull JSONObject jSONObject, @NonNull TVKLiveVideoInfo tVKLiveVideoInfo) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray(CoverDBCacheData.URLS);
        if (optJSONArray != null && optJSONArray.length() != 0) {
            String string = optJSONArray.getString(0);
            tVKLiveVideoInfo.setPlayUrl(string);
            tVKLiveVideoInfo.setOriginalPlayUrl(string);
            String[] strArr = new String[optJSONArray.length() - 1];
            for (int i3 = 1; i3 < optJSONArray.length(); i3++) {
                strArr[i3 - 1] = optJSONArray.getString(i3);
            }
            tVKLiveVideoInfo.setBackPlayUrl(strArr);
        }
    }

    @NonNull
    public TVKLiveVideoInfo parseLiveInfo(String str) throws ParseException, JSONException, Exception {
        if (!TextUtils.isEmpty(str)) {
            TVKLiveVideoInfo tVKLiveVideoInfo = new TVKLiveVideoInfo();
            tVKLiveVideoInfo.setXml(str);
            JSONObject jSONObject = new JSONObject(str);
            tVKLiveVideoInfo.setRetCode(jSONObject.getInt("retcode"));
            tVKLiveVideoInfo.setIretDetailCode(TVKJsonUtils.optInt(jSONObject, "iretdetailcode", 0));
            tVKLiveVideoInfo.setErrInfo(TVKJsonUtils.optString(jSONObject, HippyReporter.EXTRA_KEY_REPORT_ERRMSG, ""));
            tVKLiveVideoInfo.setLivePid(TVKJsonUtils.optString(jSONObject, "pid", ""));
            tVKLiveVideoInfo.setLiveChid(TVKJsonUtils.optString(jSONObject, "chid", ""));
            tVKLiveVideoInfo.setPaymentStatus(TVKJsonUtils.optInt(jSONObject, TPReportKeys.LiveExKeys.LIVE_EX_IS_USER_PAY, 0));
            tVKLiveVideoInfo.setPaymentType(TVKJsonUtils.optInt(jSONObject, DefaultTVKDataProvider.KEY_PAY_TYPE, 0));
            tVKLiveVideoInfo.setExpectDelaySec(TVKJsonUtils.optInt(jSONObject, "expect_delay", 0));
            tVKLiveVideoInfo.setServerTime(TVKJsonUtils.optLong(jSONObject, "svrtick", 0L));
            tVKLiveVideoInfo.setSubErrType(TVKJsonUtils.optInt(jSONObject, "type", 0));
            tVKLiveVideoInfo.setRand(TVKJsonUtils.optString(jSONObject, "rand", ""));
            tVKLiveVideoInfo.setStreamSecret(TVKJsonUtils.optInt(jSONObject, "stream_secret", 0));
            tVKLiveVideoInfo.setAbTestInfo(TVKUtils.convertRawAbTestInfoToMap(TVKJsonUtils.optString(jSONObject, "abtest", "")));
            tVKLiveVideoInfo.setSignature(TVKJsonUtils.optString(jSONObject, "signature", ""));
            tVKLiveVideoInfo.setBizExt(TVKJsonUtils.optString(jSONObject, "biz_ext", ""));
            tVKLiveVideoInfo.setCdnHttpHeaders(TVKJsonUtils.convertJsonObjectToHashMap(jSONObject.optJSONObject("trans_headers")));
            tVKLiveVideoInfo.setPlayType(TVKJsonUtils.optInt(jSONObject, PlayParamConst.ParamKey.PLAY_TYPE, 0));
            tVKLiveVideoInfo.setMediaVideoType(TVKJsonUtils.optInt(jSONObject, "vr", 0));
            parseFastForward(jSONObject, tVKLiveVideoInfo);
            parseFormatList(jSONObject, tVKLiveVideoInfo);
            parsePlayResult(jSONObject, tVKLiveVideoInfo);
            parseByLiveFeatures(jSONObject, tVKLiveVideoInfo);
            return tVKLiveVideoInfo;
        }
        throw new ParseException("Empty JSON string.", 0);
    }
}
