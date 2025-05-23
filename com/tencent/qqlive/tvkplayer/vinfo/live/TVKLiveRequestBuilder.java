package com.tencent.qqlive.tvkplayer.vinfo.live;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import com.tencent.qqlive.tvkplayer.api.asset.TVKAssetUtils;
import com.tencent.qqlive.tvkplayer.api.asset.TVKLivePidAsset;
import com.tencent.qqlive.tvkplayer.api.asset.TVKLiveSidAsset;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKCommParams;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKVersion;
import com.tencent.qqlive.tvkplayer.tools.config.TVKUrlConfig;
import com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger;
import com.tencent.qqlive.tvkplayer.tools.log.TVKLogger;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKNetworkUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKVcSystemInfo;
import com.tencent.qqlive.tvkplayer.vinfo.api.TVKCGIRequestParam;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureGroup;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureParamGroup;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKLiveFeature;
import com.tencent.qqlive.tvkplayer.vinfo.checktime.TVKServerTimeGetter;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKCGIParamsBuildHelper;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKCKeyGenerator;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKCkeyParam;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKLiveRequestBuilder {
    private static final String BANDWIDTH_INVALID = "0";
    private static final String CMD_GETLIVEINFO = "2";
    private static final String CMD_PREVIEW = "1";
    private static final String DEFINITION_AUTO = "auto";
    private static final String FPS_AUTO = "auto";
    private static final String MODULE_NAME = "TVKLiveRequestBuilder";
    private final Map<String, String> mExtraParamsMap;
    private final List<ITVKLiveFeature> mFeatureList;
    private final ITVKFeatureParamGroup mFeatureParamGroup;
    private final boolean mIsFirstBootFromOtherApp;
    private final boolean mIsInCompatibilityMode;
    private TVKLivePidAsset mLivePidAsset;
    private TVKLiveSidAsset mLiveSidAsset;
    private final ITVKLogger mLogger;
    private final TVKCGIRequestParam mRequestParam;
    private final int mRequestType;
    private final TVKUserInfo mUserInfo;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    private static class CompatibilityModeParam {
        private final String mPid;
        private final String mSid;

        public CompatibilityModeParam(String str, String str2) {
            this.mSid = TextUtils.isEmpty(str) ? "" : str;
            this.mPid = TextUtils.isEmpty(str2) ? "" : str2;
        }

        public String getPid() {
            return this.mPid;
        }

        public String getSid() {
            return this.mSid;
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class RequestParamKey {
        public static final String AB_USER_ID = "abuserid";
        public static final String ANCHORID = "anchorid";
        public static final String APPID = "appid";
        public static final String APP_VERSION = "appver";
        public static final String APP_VERSION_NEW = "appversion";
        public static final String BANDWIDTH = "bandwidth";
        public static final String CAP_LEVEL = "caplv";
        public static final String CHID = "chid";
        public static final String CKEY = "ckey";
        public static final String CKEY_TIMESTAMP = "tm";
        public static final String CMD = "cmd";
        public static final String DEFINITION = "defn";
        public static final String ENCRYPTION_VERSION = "encrypt_ver";
        public static final String FLOWID = "flowid";
        public static final String FORMAT_SUPPORT = "format_support";
        public static final String FPS = "ufps";
        public static final String GUID = "guid";
        public static final String HDR_LEVEL = "hdrlv";
        public static final String HEVC_LEVEL = "hevclv";
        public static final String HTTPS = "sphttps";
        public static final String LIVE_DRM = "livedrm";
        public static final String NETWORK = "net_type";
        public static final String PID = "pid";
        public static final String PLATFORM = "platform";
        public static final String PLAYBACK_TIME = "playbacktime";
        public static final String PLAYER_SCENE = "player_scene";
        public static final String QIMEI36 = "qimei";
        public static final String RANDOM_NUMBER = "randnum";
        public static final String ROOMID = "roomid";
        public static final String SID = "cnlid";
        public static final String SPAUDIO = "spaudio";
        public static final String SP_VVC = "spvvc";
    }

    public TVKLiveRequestBuilder(@NonNull TVKContext tVKContext, TVKCGIRequestParam tVKCGIRequestParam, ITVKFeatureGroup iTVKFeatureGroup, ITVKFeatureParamGroup iTVKFeatureParamGroup, int i3) throws IllegalArgumentException {
        List<ITVKLiveFeature> liveFeatureList;
        checkRequestParamValidation(tVKCGIRequestParam);
        this.mLogger = new TVKLogger(tVKContext, MODULE_NAME);
        this.mRequestParam = tVKCGIRequestParam;
        this.mFeatureParamGroup = iTVKFeatureParamGroup;
        if (iTVKFeatureGroup == null) {
            liveFeatureList = null;
        } else {
            liveFeatureList = iTVKFeatureGroup.getLiveFeatureList();
        }
        this.mFeatureList = liveFeatureList;
        this.mRequestType = i3;
        ITVKAsset asset = tVKCGIRequestParam.getAsset();
        if (asset.getAssetType() == 256) {
            this.mIsInCompatibilityMode = false;
            this.mLivePidAsset = (TVKLivePidAsset) asset;
        } else {
            this.mIsInCompatibilityMode = true;
            this.mLiveSidAsset = (TVKLiveSidAsset) asset;
        }
        this.mUserInfo = tVKCGIRequestParam.getUserInfo();
        this.mExtraParamsMap = tVKCGIRequestParam.getVideoInfo().getExtraRequestParamsMap();
        this.mIsFirstBootFromOtherApp = "true".equalsIgnoreCase(tVKCGIRequestParam.getVideoInfo().getConfigMapValue(TVKPlayerVideoInfo.PLAYER_CFG_KEY_FIRST_BOOT_FROM_OTHER_APP, "false"));
    }

    private Map<String, String> buildFreeNetFlowRequestMap() {
        Map<String, String> freeNetFlowRequestMap = TVKCommParams.getFreeNetFlowRequestMap();
        if (freeNetFlowRequestMap == null || TextUtils.isEmpty(TVKCommParams.getOriginalUpc()) || !TVKNetworkUtils.isNetworkTypeMobile()) {
            return Collections.emptyMap();
        }
        return freeNetFlowRequestMap;
    }

    private void checkRequestParamValidation(TVKCGIRequestParam tVKCGIRequestParam) throws IllegalArgumentException {
        if (tVKCGIRequestParam != null) {
            if (isVideoInfoValid(tVKCGIRequestParam.getVideoInfo(), tVKCGIRequestParam.getAsset())) {
                if (tVKCGIRequestParam.getUserInfo() != null) {
                    return;
                } else {
                    throw new IllegalArgumentException("Invalid user info.");
                }
            }
            throw new IllegalArgumentException("Invalid video info.");
        }
        throw new IllegalArgumentException("Invalid request param.");
    }

    private String generateAssetIdForCKey() {
        if (this.mIsInCompatibilityMode) {
            return this.mLiveSidAsset.getSid();
        }
        if (TextUtils.isEmpty(this.mLivePidAsset.getChid())) {
            return this.mLivePidAsset.getPid();
        }
        return this.mLivePidAsset.getChid();
    }

    private String generatePlayerScene() {
        int i3 = 1;
        if (this.mRequestParam.getRequestSource() != 1) {
            i3 = 0;
        }
        return String.valueOf(i3);
    }

    private boolean isVideoInfoValid(TVKPlayerVideoInfo tVKPlayerVideoInfo, ITVKAsset iTVKAsset) {
        if (tVKPlayerVideoInfo != null && TVKAssetUtils.isValidAsset(iTVKAsset) && TVKAssetUtils.isLiveAsset(iTVKAsset)) {
            return true;
        }
        return false;
    }

    private boolean shouldUseIpv4Host() {
        if (this.mRequestType == 3) {
            return true;
        }
        return false;
    }

    public List<String> buildRequestBakHosts() {
        ArrayList arrayList = new ArrayList();
        if (this.mRequestParam.getRequestSource() == 0) {
            arrayList.add(TVKNetworkUtils.getHostnameFromUrl(TVKUrlConfig.getServiceUrl(TVKUrlConfig.SERVICE_NAME_LIVE_DUALSTACK_CGI_HOST)));
            arrayList.add(TVKNetworkUtils.getHostnameFromUrl(TVKUrlConfig.getServiceUrl(TVKUrlConfig.SERVICE_NAME_LIVE_IPV4_CGI_HOST)));
            arrayList.add(TVKNetworkUtils.getHostnameFromUrl(TVKUrlConfig.getServiceUrl(TVKUrlConfig.SERVICE_NAME_LIVE_IPV4_CGI_HOST_BK)));
        }
        return arrayList;
    }

    public Map<String, String> buildRequestHeader() {
        HashMap hashMap = new HashMap();
        hashMap.put(TVKCommonParamEnum.RequestHeaders.USER_AGENT, "qqlive");
        if (!TextUtils.isEmpty(this.mUserInfo.getLoginCookie())) {
            hashMap.put(TVKCommonParamEnum.RequestHeaders.COOKIE, this.mUserInfo.getLoginCookie());
        }
        hashMap.putAll(this.mRequestParam.getVideoInfo().getExtraVinfoRequestHeadersMap());
        return hashMap;
    }

    public String buildRequestHost() {
        if (shouldUseIpv4Host()) {
            return TVKUrlConfig.getServiceUrl(TVKUrlConfig.SERVICE_NAME_LIVE_IPV4_CGI_HOST);
        }
        return TVKUrlConfig.getServiceUrl(TVKUrlConfig.SERVICE_NAME_LIVE_DUALSTACK_CGI_HOST);
    }

    public Map<String, String> buildRequestParams() {
        String str;
        String definition;
        HashMap hashMap = new HashMap();
        hashMap.put("flowid", this.mRequestParam.getFlowId());
        hashMap.put(RequestParamKey.QIMEI36, TVKCommParams.getQimei36());
        if (this.mRequestType == 4) {
            str = "1";
        } else {
            str = "2";
        }
        hashMap.put("cmd", str);
        if (this.mIsInCompatibilityMode) {
            hashMap.put(RequestParamKey.SID, this.mLiveSidAsset.getSid());
            hashMap.put("pid", this.mLiveSidAsset.getPid());
        } else {
            hashMap.put("roomid", this.mLivePidAsset.getRoomid());
            hashMap.put("anchorid", this.mLivePidAsset.getAnchorid());
            hashMap.put("pid", this.mLivePidAsset.getPid());
            hashMap.put("chid", this.mLivePidAsset.getChid());
            hashMap.put("appid", this.mLivePidAsset.getLiveAppid());
        }
        if (TextUtils.isEmpty(this.mRequestParam.getDefinition())) {
            definition = "auto";
        } else {
            definition = this.mRequestParam.getDefinition();
        }
        hashMap.put("defn", definition);
        hashMap.put(RequestParamKey.FPS, "auto");
        TVKCkeyParam build = new TVKCkeyParam.Builder(this.mRequestType, generateAssetIdForCKey()).platform(TVKVersion.getPlatform()).sdtfrom(TVKVersion.getSdtfrom()).appVer(TVKVersion.getPlayerVersion()).extraParamsMap(this.mExtraParamsMap).extraJson(null).build();
        long calculateCurrentServerTimeSec = TVKServerTimeGetter.getInstance().calculateCurrentServerTimeSec();
        hashMap.put(RequestParamKey.CKEY, TVKCKeyGenerator.genCkey(build, calculateCurrentServerTimeSec, this.mLogger));
        hashMap.put(RequestParamKey.CKEY_TIMESTAMP, String.valueOf(calculateCurrentServerTimeSec));
        hashMap.put("appver", TVKVersion.getPlayerVersion());
        hashMap.put("appversion", TVKVcSystemInfo.getAppVersionName(TVKCommParams.getApplicationContext()));
        hashMap.put(RequestParamKey.ENCRYPTION_VERSION, TVKCKeyGenerator.getEncryptVer());
        hashMap.put("guid", TVKCommParams.getStaGuid());
        hashMap.put("platform", TVKVersion.getPlatform());
        hashMap.put("net_type", String.valueOf(TVKNetworkUtils.getNetworkType()));
        hashMap.put(RequestParamKey.BANDWIDTH, "0");
        hashMap.put(RequestParamKey.PLAYER_SCENE, generatePlayerScene());
        hashMap.put("abuserid", TVKCommParams.getAbUserId());
        hashMap.put(RequestParamKey.RANDOM_NUMBER, String.valueOf(Math.random()));
        hashMap.putAll(buildFreeNetFlowRequestMap());
        hashMap.putAll(TVKCGIParamsBuildHelper.buildLiveCGIExtraParamsWithFeature(this.mRequestParam, this.mFeatureList, this.mFeatureParamGroup));
        return hashMap;
    }

    public int getRequestSource() {
        return this.mRequestParam.getRequestSource();
    }

    public boolean isFirstBootFromOtherApp() {
        return this.mIsFirstBootFromOtherApp;
    }
}
