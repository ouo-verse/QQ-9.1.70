package com.tencent.qqlive.tvkplayer.vinfo.vod;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ads.data.AdParam;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import com.tencent.qqlive.tvkplayer.api.asset.TVKAssetUtils;
import com.tencent.qqlive.tvkplayer.api.asset.TVKOfflineVodVidAsset;
import com.tencent.qqlive.tvkplayer.api.asset.TVKOnlineSimulatedLiveAsset;
import com.tencent.qqlive.tvkplayer.api.asset.TVKOnlineVodQuickPlayAsset;
import com.tencent.qqlive.tvkplayer.api.asset.TVKOnlineVodVidAsset;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKCommParams;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKVersion;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.config.TVKUrlConfig;
import com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger;
import com.tencent.qqlive.tvkplayer.tools.log.TVKLogger;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKNetworkUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKSimulatedLivePrevidGenerator;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKVcSystemInfo;
import com.tencent.qqlive.tvkplayer.vinfo.api.TVKCGIRequestParam;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureGroup;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureParamGroup;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKVodFeature;
import com.tencent.qqlive.tvkplayer.vinfo.checktime.TVKServerTimeGetter;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.RSAUtils;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKCGIParamsBuildHelper;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKCKeyGenerator;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKCkeyParam;
import com.tencent.thumbplayer.core.datatransport.api.TPDataTransportMgr;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKVodRequestBuilder {
    private static final long CKEY_UPDATE_INTERVAL_SEC = 1;
    private static final int CLIP_NOT_SUPPORT_SEGMENT = 4;
    private static final int CLIP_SUPPORT_SEGMENT = 0;
    private static final int DTYPE_FORMAT_HLS = 3;
    private static final int DTYPE_FORMAT_MP4 = 1;
    private static final String MODULE_NAME = "TVKVodRequestBuilder";
    private static final int SPGZIP_SUPPORT_ZIP = 1;
    private final TVKCkeyParam mCkeyParam;
    private final Map<String, String> mExtraParamsMap;
    private final List<ITVKVodFeature> mFeatureList;
    private final ITVKFeatureParamGroup mFeatureParamGroup;
    private final Map<String, String> mFinalRequestParamMap = new HashMap();
    private long mLastBuildCkeyTimeSec = -1;
    private final ITVKLogger mLogger;

    @NonNull
    private final TVKCGIRequestParam mRequestParam;
    private final int mRequestType;
    private final TVKUserInfo mUserInfo;
    private final TVKPlayerVideoInfo mVideoInfo;
    private final ITVKAsset mVodVidAsset;

    public TVKVodRequestBuilder(@NonNull TVKContext tVKContext, @NonNull TVKCGIRequestParam tVKCGIRequestParam, ITVKFeatureGroup iTVKFeatureGroup, ITVKFeatureParamGroup iTVKFeatureParamGroup, int i3) throws IllegalArgumentException {
        List<ITVKVodFeature> vodFeatureList;
        int i16;
        checkRequestParamValidation(tVKCGIRequestParam);
        this.mLogger = new TVKLogger(tVKContext, MODULE_NAME);
        this.mRequestParam = tVKCGIRequestParam;
        this.mFeatureParamGroup = iTVKFeatureParamGroup;
        if (iTVKFeatureGroup == null) {
            vodFeatureList = null;
        } else {
            vodFeatureList = iTVKFeatureGroup.getVodFeatureList();
        }
        this.mFeatureList = vodFeatureList;
        this.mRequestType = i3;
        this.mVideoInfo = tVKCGIRequestParam.getVideoInfo();
        this.mVodVidAsset = tVKCGIRequestParam.getAsset();
        this.mUserInfo = tVKCGIRequestParam.getUserInfo();
        this.mExtraParamsMap = tVKCGIRequestParam.getVideoInfo().getExtraRequestParamsMap();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ea", TVKMediaPlayerConfig.PlayerConfig.vod_cgi_ea_set);
            if (TVKMediaPlayerConfig.PlayerConfig.enable_polling_report) {
                i16 = 1;
            } else {
                i16 = 0;
            }
            jSONObject.put("spa", i16);
            jSONObject.put("sdrp", TVKUtils.optInt(TPDataTransportMgr.getGlobalAccessibleNativeInfo(8), 0));
            jSONObject.put("ssk", TPDataTransportMgr.getGlobalAccessibleNativeInfo(10));
        } catch (JSONException unused) {
        }
        this.mCkeyParam = new TVKCkeyParam.Builder(this.mRequestType, generateVinfoRequestAssetIdForCKey()).platform(TVKVersion.getPlatform()).sdtfrom(TVKVersion.getSdtfrom()).appVer(TVKVcSystemInfo.getAppVersionName(TVKCommParams.getApplicationContext())).extraParamsMap(this.mExtraParamsMap).extraJson(jSONObject).build();
    }

    private void buildAllFeatureParamsMap(Map<String, String> map) {
        Map<String, String> buildVodCGIFeatureParams = TVKCGIParamsBuildHelper.buildVodCGIFeatureParams(this.mRequestParam, this.mFeatureList, this.mFeatureParamGroup);
        if (!buildVodCGIFeatureParams.isEmpty()) {
            map.putAll(buildVodCGIFeatureParams);
        }
    }

    private void buildClipAndDtypeParams(Map<String, String> map) {
        if (TVKMediaPlayerConfig.PlayerConfig.is_use_cgi_gzip_for_vod) {
            map.put("spgzip", String.valueOf(1));
        }
        if (this.mRequestParam.getStreamFormatId() != 0 && this.mRequestParam.getStreamFormatId() != 3 && this.mRequestParam.getStreamFormatId() != 8) {
            if (this.mRequestParam.getStreamFormatId() != 4 && this.mRequestParam.getStreamFormatId() != 5 && this.mRequestParam.getStreamFormatId() != 1) {
                map.put(AdParam.DTYPE, String.valueOf(this.mRequestParam.getStreamFormatId()));
            } else {
                map.put(AdParam.DTYPE, String.valueOf(1));
            }
        } else {
            map.put(AdParam.DTYPE, String.valueOf(3));
        }
        map.put("clip", String.valueOf(4));
    }

    private void buildExtraParamsMap(Map<String, String> map) {
        Map<String, String> buildVodCGIExtraParams = TVKCGIParamsBuildHelper.buildVodCGIExtraParams(this.mRequestParam);
        if (!buildVodCGIExtraParams.isEmpty()) {
            map.putAll(buildVodCGIExtraParams);
        }
    }

    private void buildFreeFlowMap(Map<String, String> map) {
        String[] strArr;
        String upc = getUpc();
        if (TextUtils.isEmpty(upc)) {
            return;
        }
        Map<String, String> freeNetFlowRequestMap = TVKCommParams.getFreeNetFlowRequestMap();
        if (freeNetFlowRequestMap != null) {
            map.putAll(freeNetFlowRequestMap);
            return;
        }
        if (upc.contains(ContainerUtils.FIELD_DELIMITER)) {
            strArr = upc.split(ContainerUtils.FIELD_DELIMITER);
        } else {
            strArr = new String[]{upc};
        }
        for (String str : strArr) {
            String[] split = str.split(ContainerUtils.KEY_VALUE_DELIMITER);
            if (split.length == 2) {
                map.put(split[0], split[1]);
            } else if (split.length == 1) {
                map.put(split[0], "");
            }
        }
    }

    private void checkRequestParamValidation(TVKCGIRequestParam tVKCGIRequestParam) throws IllegalArgumentException {
        if (tVKCGIRequestParam != null) {
            if (isVideoInfoValid(tVKCGIRequestParam.getVideoInfo(), tVKCGIRequestParam.getAsset())) {
                if (tVKCGIRequestParam.getUserInfo() != null) {
                    return;
                } else {
                    throw new IllegalArgumentException("userInfo is invalid.");
                }
            }
            throw new IllegalArgumentException("videoInfo is invalid.");
        }
        throw new IllegalArgumentException("requestParam is invalid.");
    }

    private String generateVinfoRequestAssetIdForCKey() {
        if (this.mVodVidAsset.getAssetType() == 524288) {
            return RSAUtils.getNewVid(((TVKOnlineVodQuickPlayAsset) this.mVodVidAsset).getPrevid());
        }
        if (this.mVodVidAsset.getAssetType() == 1048576) {
            return RSAUtils.getNewVid(TVKSimulatedLivePrevidGenerator.generate((TVKOnlineSimulatedLiveAsset) this.mVodVidAsset));
        }
        String vidFromAsset = getVidFromAsset(this.mVodVidAsset);
        if (!TextUtils.isEmpty(vidFromAsset)) {
            return vidFromAsset;
        }
        String cidFromAsset = getCidFromAsset(this.mVodVidAsset);
        if (TextUtils.isEmpty(cidFromAsset)) {
            return "";
        }
        return cidFromAsset;
    }

    private String getCidFromAsset(ITVKAsset iTVKAsset) {
        if (iTVKAsset.getAssetType() == 131072) {
            return ((TVKOnlineVodVidAsset) iTVKAsset).getCid();
        }
        if (iTVKAsset.getAssetType() == 262144) {
            return ((TVKOfflineVodVidAsset) iTVKAsset).getCid();
        }
        if (iTVKAsset.getAssetType() == 524288) {
            return ((TVKOnlineVodQuickPlayAsset) iTVKAsset).getCid();
        }
        return "";
    }

    private String getPath(TVKVodVideoInfo tVKVodVideoInfo) {
        if (tVKVodVideoInfo != null && tVKVodVideoInfo.getUrlList().size() != 0) {
            return tVKVodVideoInfo.getUrlList().get(0).getPath();
        }
        return "";
    }

    private String getSpip(TVKVodVideoInfo tVKVodVideoInfo) {
        if (tVKVodVideoInfo != null && tVKVodVideoInfo.getUrlList().size() != 0) {
            return tVKVodVideoInfo.getUrlList().get(0).getSpip();
        }
        return "";
    }

    private String getSpport(TVKVodVideoInfo tVKVodVideoInfo) {
        if (tVKVodVideoInfo != null && tVKVodVideoInfo.getUrlList().size() != 0) {
            return tVKVodVideoInfo.getUrlList().get(0).getSpport();
        }
        return "";
    }

    private String getUpc() {
        if (TVKNetworkUtils.isNetworkTypeMobile()) {
            return TVKCommParams.getOriginalUpc();
        }
        return "";
    }

    private String getVidFromAsset(ITVKAsset iTVKAsset) {
        if (iTVKAsset.getAssetType() == 131072) {
            return ((TVKOnlineVodVidAsset) iTVKAsset).getVid();
        }
        if (iTVKAsset.getAssetType() == 262144) {
            return ((TVKOfflineVodVidAsset) iTVKAsset).getVid();
        }
        return "";
    }

    private int getVt(TVKVodVideoInfo tVKVodVideoInfo) {
        if (tVKVodVideoInfo == null || tVKVodVideoInfo.getUrlList().size() == 0) {
            return 0;
        }
        return tVKVodVideoInfo.getUrlList().get(0).getVt();
    }

    private boolean isVideoInfoValid(TVKPlayerVideoInfo tVKPlayerVideoInfo, ITVKAsset iTVKAsset) {
        if (tVKPlayerVideoInfo == null || !TVKAssetUtils.isValidAsset(iTVKAsset)) {
            return false;
        }
        int assetType = iTVKAsset.getAssetType();
        if (assetType != 131072 && assetType != 262144 && assetType != 524288 && assetType != 1048576) {
            return false;
        }
        return true;
    }

    private boolean shouldUseIpv4Host() {
        if (this.mRequestType == 3) {
            return true;
        }
        return false;
    }

    public Map<String, String> buildBatchVinfoRequestHeaders() {
        Map<String, String> buildVinfoRequestHeader = buildVinfoRequestHeader();
        buildVinfoRequestHeader.put("Content-Type", "application/json");
        return buildVinfoRequestHeader;
    }

    public String buildBatchVinfoRequestHost() {
        if (shouldUseIpv4Host()) {
            return TVKUrlConfig.getServiceUrl(TVKUrlConfig.SERVICE_NAME_BATCH_VINFO_CGI_HOST);
        }
        return TVKUrlConfig.getServiceUrl(TVKUrlConfig.SERVICE_NAME_BATCH_VINFO_DUALSTACK_CGI_HOST);
    }

    @NonNull
    public List<String> buildVinfoRequestBakHosts() {
        ArrayList arrayList = new ArrayList();
        if (this.mRequestParam.getRequestSource() == 0) {
            arrayList.add(TVKNetworkUtils.getHostnameFromUrl(TVKUrlConfig.getServiceUrl(TVKUrlConfig.SERVICE_NAME_VINFO_CGI_DUALSTACK_HOST)));
            arrayList.add(TVKNetworkUtils.getHostnameFromUrl(TVKUrlConfig.getServiceUrl(TVKUrlConfig.SERVICE_NAME_VINFO_CGI_V4ONLY_HOST)));
            arrayList.add(TVKNetworkUtils.getHostnameFromUrl(TVKUrlConfig.getServiceUrl(TVKUrlConfig.SERVICE_NAME_VINFO_CGI_DUALSTACK_HOST_BK)));
        }
        return arrayList;
    }

    public Map<String, String> buildVinfoRequestHeader() {
        HashMap hashMap = new HashMap();
        hashMap.put(TVKCommonParamEnum.RequestHeaders.USER_AGENT, "qqlive");
        if (TVKMediaPlayerConfig.PlayerConfig.is_use_cgi_gzip_for_vod) {
            hashMap.put(TVKCommonParamEnum.RequestHeaders.ACCEPT_ENCODING, "gzip");
        }
        hashMap.put(TVKCommonParamEnum.RequestHeaders.HOST, TVKNetworkUtils.getHostnameFromUrl(buildVinfoRequestHost()));
        if (!TextUtils.isEmpty(this.mUserInfo.getLoginCookie())) {
            hashMap.put(TVKCommonParamEnum.RequestHeaders.COOKIE, this.mUserInfo.getLoginCookie());
        }
        hashMap.putAll(this.mVideoInfo.getExtraVinfoRequestHeadersMap());
        return hashMap;
    }

    public String buildVinfoRequestHost() {
        if (shouldUseIpv4Host()) {
            return TVKUrlConfig.getServiceUrl(TVKUrlConfig.SERVICE_NAME_VINFO_CGI_V4ONLY_HOST);
        }
        return TVKUrlConfig.getServiceUrl(TVKUrlConfig.SERVICE_NAME_VINFO_CGI_DUALSTACK_HOST);
    }

    public Map<String, String> buildVinfoRequestParams(boolean z16) {
        String str;
        long calculateCurrentServerTimeSec = TVKServerTimeGetter.getInstance().calculateCurrentServerTimeSec();
        String str2 = "1";
        if (!this.mFinalRequestParamMap.isEmpty()) {
            this.mLogger.info("buildVinfoRequestParams, return cache mFinalRequestParamMap", new Object[0]);
            Map<String, String> map = this.mFinalRequestParamMap;
            if (!z16) {
                str2 = "0";
            }
            map.put(TVKCommonParamEnum.REQ_PARAM_KEY_RETRY, str2);
            this.mFinalRequestParamMap.put(TVKCommonParamEnum.REQ_PARAM_KEY_IPSTACK, String.valueOf(TVKNetworkUtils.getIPStackType()));
            this.mFinalRequestParamMap.put("newnettype", String.valueOf(TVKNetworkUtils.getNetworkType()));
            if (Math.abs(calculateCurrentServerTimeSec - this.mLastBuildCkeyTimeSec) >= 1) {
                this.mFinalRequestParamMap.put("cKey", TVKCKeyGenerator.genCkey(this.mCkeyParam, calculateCurrentServerTimeSec, this.mLogger));
                this.mLastBuildCkeyTimeSec = calculateCurrentServerTimeSec;
            }
            return this.mFinalRequestParamMap;
        }
        HashMap hashMap = new HashMap();
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put(TVKCommonParamEnum.REQ_PARAM_KEY_RETRY, str);
        hashMap.put(AdParam.OTYPE, "xml");
        hashMap.put("flowid", this.mRequestParam.getFlowId());
        hashMap.put("vid", getVidFromAsset(this.mVodVidAsset));
        hashMap.put("cKey", TVKCKeyGenerator.genCkey(this.mCkeyParam, calculateCurrentServerTimeSec, this.mLogger));
        this.mLastBuildCkeyTimeSec = calculateCurrentServerTimeSec;
        hashMap.put("charge", String.valueOf(this.mVideoInfo.isNeedCharge() ? 1 : 0));
        hashMap.put("platform", TVKVersion.getPlatform());
        hashMap.put("sdtfrom", TVKVersion.getSdtfrom());
        if (!this.mRequestParam.isUserSwitchDefinitionOrAudioTrack()) {
            str2 = "0";
        }
        hashMap.put("defnswitch", str2);
        hashMap.put("defn", this.mRequestParam.getDefinition());
        hashMap.put(TVKCommonParamEnum.REQ_PARAM_KEY_IPSTACK, String.valueOf(TVKNetworkUtils.getIPStackType()));
        hashMap.put("device", String.valueOf(33));
        hashMap.put("newnettype", String.valueOf(TVKNetworkUtils.getNetworkType()));
        hashMap.put(AdParam.APPVER, TVKVcSystemInfo.getAppVersionName(TVKCommParams.getApplicationContext()));
        if (!TextUtils.isEmpty(this.mUserInfo.getWxOpenID())) {
            hashMap.put("openid", this.mUserInfo.getWxOpenID());
        }
        hashMap.put(AdParam.ENCRYPTVER, TVKCKeyGenerator.getEncryptVer());
        hashMap.put("abuserid", TVKCommParams.getAbUserId());
        hashMap.put("viptype", String.valueOf(this.mUserInfo.getVipType().ordinal()));
        hashMap.put("screeninfo", TVKVcSystemInfo.getScreenWidth(TVKCommParams.getApplicationContext()) + "*" + TVKVcSystemInfo.getScreenHeight(TVKCommParams.getApplicationContext()));
        TVKCGIParamsBuildHelper.buildOpenApi(hashMap, this.mUserInfo);
        buildClipAndDtypeParams(hashMap);
        buildFreeFlowMap(hashMap);
        buildExtraParamsMap(hashMap);
        buildAllFeatureParamsMap(hashMap);
        this.mFinalRequestParamMap.clear();
        this.mFinalRequestParamMap.putAll(hashMap);
        return this.mFinalRequestParamMap;
    }

    public String getDefinition() {
        return this.mRequestParam.getDefinition();
    }

    public int getRequestSource() {
        return this.mRequestParam.getRequestSource();
    }

    public int getRequestType() {
        return this.mRequestType;
    }

    public boolean isFirstBootFromOtherApp() {
        return "true".equals(this.mVideoInfo.getConfigMapValue(TVKPlayerVideoInfo.PLAYER_CFG_KEY_FIRST_BOOT_FROM_OTHER_APP, "false"));
    }
}
