package com.tencent.qqlive.tvkplayer.vinfo.common;

import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import com.tencent.ads.data.AdParam;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginCookieKey;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVideoInfoFromType;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUrlBuilder;
import com.tencent.qqlive.tvkplayer.vinfo.api.TVKCGIRequestParam;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureParamGroup;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKLiveFeature;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKVodFeature;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.xweb.FileReaderHelper;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* loaded from: classes23.dex */
public class TVKCGIParamsBuildHelper {
    private static final String TAG = "TVKCGIParamsBuildHelper";
    private static Map<String, String> mGetVInfoKeyMap;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("vinfo_key_toushe", TVKCommonParamEnum.REQ_PARAM_KEY_TOUSHE);
        hashMap.put("vinfo_key_from_platform", TVKCommonParamEnum.REQ_PARAM_KEY_FROM_PLATFORM);
        hashMap.put("vinfo_key_sptest", TVKCommonParamEnum.REQ_PARAM_KEY_SPTEST);
        hashMap.put("vinfo_key_spvideo", TVKCommonParamEnum.REQ_PARAM_KEY_SPVIDEO);
        hashMap.put("vinfo_key_spaudio", "spaudio");
        mGetVInfoKeyMap = Collections.unmodifiableMap(hashMap);
    }

    public static Map<String, String> buildLiveCGIExtraParamsWithFeature(@NonNull TVKCGIRequestParam tVKCGIRequestParam, List<ITVKLiveFeature> list, ITVKFeatureParamGroup iTVKFeatureParamGroup) {
        HashMap hashMap = new HashMap();
        Map<String, String> extraRequestParamsMap = tVKCGIRequestParam.getVideoInfo().getExtraRequestParamsMap();
        if (extraRequestParamsMap != null && !extraRequestParamsMap.isEmpty()) {
            hashMap.putAll(extraRequestParamsMap);
        }
        buildVideoInfoConfigMapToExtraMap(tVKCGIRequestParam.getVideoInfo(), hashMap, true);
        if (list != null && !list.isEmpty()) {
            for (ITVKLiveFeature iTVKLiveFeature : list) {
                if (iTVKLiveFeature.isEnable()) {
                    iTVKLiveFeature.buildLiveCGIParams(tVKCGIRequestParam, iTVKFeatureParamGroup, hashMap);
                } else {
                    TVKLogUtil.i(TAG, "LIVE CGI: " + iTVKLiveFeature.getClass().getName() + " runtimeEnable is false");
                }
            }
        }
        return hashMap;
    }

    public static void buildOpenApi(Map<String, String> map, TVKUserInfo tVKUserInfo) {
        if (tVKUserInfo != null && !TextUtils.isEmpty(tVKUserInfo.getAccessToken())) {
            map.put("openid", tVKUserInfo.getOpenId());
            map.put(QAdLoginDefine$LoginCookieKey.WX_ACCESS_TOKEN, tVKUserInfo.getAccessToken());
            map.put(AdParam.PF, tVKUserInfo.getPf());
            map.put(AdParam.CONSUMERID, tVKUserInfo.getOauthConsumeKey());
        }
    }

    private static void buildVideoInfoConfigMapToExtraMap(TVKPlayerVideoInfo tVKPlayerVideoInfo, Map<String, String> map, boolean z16) {
        if (tVKPlayerVideoInfo == null) {
            return;
        }
        Map<String, String> configMap = tVKPlayerVideoInfo.getConfigMap();
        if (configMap.isEmpty()) {
            return;
        }
        Iterator<Map.Entry<String, String>> it = configMap.entrySet().iterator();
        while (it.hasNext()) {
            String key = it.next().getKey();
            if (key.equals("vinfo_key_drm")) {
                if (z16) {
                    map.put("livedrm", configMap.get(key));
                } else {
                    map.put(TVKCommonParamEnum.REQ_PARAM_KEY_DRM, configMap.get(key));
                }
            } else if (mGetVInfoKeyMap.containsKey(key)) {
                map.put(mGetVInfoKeyMap.get(key), configMap.get(key));
                tVKPlayerVideoInfo.addExtraRequestParamsMap(mGetVInfoKeyMap.get(key), configMap.get(key));
            }
        }
    }

    public static Map<String, String> buildVodCGIExtraParams(@NonNull TVKCGIRequestParam tVKCGIRequestParam) {
        HashMap hashMap = new HashMap();
        Map<String, String> extraRequestParamsMap = tVKCGIRequestParam.getVideoInfo().getExtraRequestParamsMap();
        if (extraRequestParamsMap != null && !extraRequestParamsMap.isEmpty()) {
            hashMap.putAll(extraRequestParamsMap);
        }
        buildVideoInfoConfigMapToExtraMap(tVKCGIRequestParam.getVideoInfo(), hashMap, false);
        return hashMap;
    }

    public static Map<String, String> buildVodCGIFeatureParams(@NonNull TVKCGIRequestParam tVKCGIRequestParam, List<ITVKVodFeature> list, ITVKFeatureParamGroup iTVKFeatureParamGroup) {
        HashMap hashMap = new HashMap();
        if (list != null && !list.isEmpty()) {
            for (ITVKVodFeature iTVKVodFeature : list) {
                if (iTVKVodFeature.isEnable()) {
                    iTVKVodFeature.buildVodCGIParams(tVKCGIRequestParam, iTVKFeatureParamGroup, hashMap);
                } else {
                    TVKLogUtil.i(TAG, "VOD CGI: " + iTVKVodFeature.getClass().getName() + " runtimeEnable is false");
                }
            }
        }
        return hashMap;
    }

    public static Map<String, String> buildVodExtTag2Param(TVKNetVideoInfo tVKNetVideoInfo) {
        int defnId;
        String str;
        if (!(tVKNetVideoInfo instanceof TVKVodVideoInfo)) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("lnk", tVKNetVideoInfo.getLnk());
        if (tVKNetVideoInfo.getCurDefinition() == null) {
            defnId = 0;
        } else {
            defnId = tVKNetVideoInfo.getCurDefinition().getDefnId();
        }
        hashMap.put(TPReportKeys.Common.COMMON_MEDIA_FORMAT, String.valueOf(defnId));
        hashMap.put("_t", String.valueOf(new Random().nextLong()));
        if (tVKNetVideoInfo.getFromType() == TVKVideoInfoFromType.FROM_TYPE_DL_PROXY) {
            str = "0";
        } else {
            str = "1";
        }
        hashMap.put(FileReaderHelper.OPEN_FILE_FROM_FORCE, str);
        String buildUrl = new TVKUrlBuilder().addParam(hashMap).buildUrl();
        HashMap hashMap2 = new HashMap();
        hashMap2.put(TVKCommonParamEnum.REQ_PARAM_KEY_VKEY_EXTTAG2, Base64.encodeToString(buildUrl.getBytes(), 2));
        return hashMap2;
    }
}
