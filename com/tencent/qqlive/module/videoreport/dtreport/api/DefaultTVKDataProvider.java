package com.tencent.qqlive.module.videoreport.dtreport.api;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import com.tencent.qqlive.module.videoreport.utils.PlayerDTReportUtils;
import com.tencent.qqlive.module.videoreport.utils.b;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKProperties;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.json.JSONObject;

/* loaded from: classes22.dex */
public class DefaultTVKDataProvider implements IDTTVKDataProvider {
    public static final String IS_BIZ_REPORT_READY = "is_biz_report_ready";
    public static final String IS_BIZ_REPORT_READY_VALUE_0 = "0";
    public static final String IS_BIZ_REPORT_READY_VALUE_1 = "1";
    public static final String KEY_FML_CID = "fml_cid";
    public static final String KEY_FML_VID = "fml_vid";
    public static final String KEY_PAY_STATUS = "pay_status";
    public static final String KEY_PAY_TYPE = "pay_type";
    public static final String KEY_PLAY_SOURCE = "play_source";
    public static final String KEY_PLAY_VID = "play_vid";
    public static final String KEY_VODF = "vodf";
    private static final String TAG = "video.DefaultTVKDataProvider";

    @Nullable
    private Map<String, Object> extraBizParams(@Nullable TVKProperties tVKProperties) {
        Properties properties;
        if (tVKProperties == null || (properties = tVKProperties.getProperties()) == null) {
            return null;
        }
        Map<String, Object> fromGenericMap = fromGenericMap(properties);
        if (fromGenericMap == null) {
            fromGenericMap = new HashMap<>();
        }
        Object remove = fromGenericMap.remove("udf_kv");
        if (remove instanceof Map) {
            transfer((Map) remove, fromGenericMap);
        }
        logD("saveBizParams: " + new JSONObject(fromGenericMap));
        return fromGenericMap;
    }

    @Nullable
    private Map<String, Object> extraOpenParams(@Nullable TVKPlayerVideoInfo tVKPlayerVideoInfo, String str) {
        if (tVKPlayerVideoInfo == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        putString(hashMap, KEY_FML_VID, b.c(tVKPlayerVideoInfo));
        putString(hashMap, KEY_FML_CID, b.a(tVKPlayerVideoInfo));
        putString(hashMap, KEY_PLAY_SOURCE, Integer.valueOf(PlayerDTReportUtils.getPlaySource(tVKPlayerVideoInfo)));
        logD("saveOpenParams: " + new JSONObject(hashMap));
        return hashMap;
    }

    @Nullable
    private Map<String, Object> extraStartParams(TVKNetVideoInfo tVKNetVideoInfo, boolean z16) {
        if (tVKNetVideoInfo == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        String vid = tVKNetVideoInfo.getVid();
        putString(hashMap, KEY_FML_VID, vid);
        Object obj = "";
        if (z16) {
            vid = "";
        }
        putString(hashMap, KEY_PLAY_VID, vid);
        putString(hashMap, KEY_PAY_TYPE, Integer.valueOf(PlayerDTReportUtils.getPayType(tVKNetVideoInfo)));
        TVKNetVideoInfo.DefnInfo curDefinition = tVKNetVideoInfo.getCurDefinition();
        if (curDefinition != null) {
            obj = Integer.valueOf(curDefinition.getDefnId());
        }
        putString(hashMap, KEY_VODF, obj);
        putString(hashMap, KEY_PAY_STATUS, Integer.valueOf(tVKNetVideoInfo.getMediaVideoState()));
        logD("saveStartParams: " + new JSONObject(hashMap));
        return hashMap;
    }

    @Nullable
    private Map<String, Object> fromGenericMap(@Nullable Map<?, ?> map) {
        if (map == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        transfer(map, hashMap);
        return hashMap;
    }

    private void logD(String str) {
        Log.d(TAG, hashCode() + "." + str);
    }

    private void putString(Map<String, Object> map, String str, Object obj) {
        String obj2;
        if (obj == null) {
            obj2 = null;
        } else {
            obj2 = obj.toString();
        }
        map.put(str, BaseUtils.emptyAs(obj2, ""));
    }

    private void transfer(@NonNull Map<?, ?> map, @NonNull Map<String, Object> map2) {
        String obj;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object key = entry.getKey();
            if (key == null) {
                obj = null;
            } else {
                obj = key.toString();
            }
            if (!TextUtils.isEmpty(obj)) {
                Object value = entry.getValue();
                if (value instanceof Properties) {
                    value = fromGenericMap((Properties) value);
                }
                map2.put(obj, value);
            }
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.api.IDTTVKDataProvider
    public boolean active(TVKPlayerVideoInfo tVKPlayerVideoInfo) {
        return true;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.api.IDTTVKDataProvider
    public Map<String, Object> formatBizParams(TVKProperties tVKProperties) {
        return extraBizParams(tVKProperties);
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.api.IDTTVKDataProvider
    public Map<String, Object> formatOpenParams(TVKPlayerVideoInfo tVKPlayerVideoInfo, String str) {
        return extraOpenParams(tVKPlayerVideoInfo, str);
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.api.IDTTVKDataProvider
    public Map<String, Object> formatStartParams(TVKNetVideoInfo tVKNetVideoInfo, boolean z16) {
        return extraStartParams(tVKNetVideoInfo, z16);
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.api.IDTTVKDataProvider
    public String getContentId(TVKPlayerVideoInfo tVKPlayerVideoInfo) {
        return b.b(tVKPlayerVideoInfo);
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.api.IDTTVKDataProvider
    public boolean isBizReady(TVKProperties tVKProperties) {
        Properties properties;
        if (tVKProperties == null || (properties = tVKProperties.getProperties()) == null) {
            return true;
        }
        return !"0".equals(properties.getProperty(IS_BIZ_REPORT_READY));
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.api.IDTTVKDataProvider
    public int getContentType(TVKPlayerVideoInfo tVKPlayerVideoInfo, int i3) {
        return i3;
    }
}
