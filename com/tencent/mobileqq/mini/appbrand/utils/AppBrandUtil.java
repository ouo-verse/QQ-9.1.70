package com.tencent.mobileqq.mini.appbrand.utils;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.util.JSONUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import common.config.service.QzoneConfig;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.text.Typography;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class AppBrandUtil {
    public static final String STATUS_BAR_HEIGHT = "status_bar_height";
    public static final String TAG = "AppBrandUtil";
    public static ArrayList<String> sConfigFilter;

    public static long currTime() {
        return System.currentTimeMillis();
    }

    public static JSONObject getAppLaunchInfo(String str, LaunchParam launchParam, MiniAppInfo miniAppInfo) {
        String str2;
        String str3;
        Object obj;
        int i3;
        JSONObject jSONObject = new JSONObject();
        if (launchParam != null) {
            try {
                int i16 = launchParam.scene;
                Object obj2 = launchParam.shareTicket;
                str2 = launchParam.fromMiniAppId;
                EntryModel entryModel = launchParam.entryModel;
                r2 = entryModel != null ? entryModel.getEntryHash() : null;
                str3 = launchParam.privateExtraData;
                obj = r2;
                r2 = obj2;
                i3 = i16;
            } catch (Throwable th5) {
                QLog.e("AppBrandUtil", 1, "getAppLaunchInfo error, ", th5);
            }
        } else {
            str2 = null;
            str3 = null;
            i3 = 9999;
            obj = null;
        }
        jSONObject.put("scene", getWikiScene(i3));
        jSONObject.put("path", getUrlWithoutParams(str));
        jSONObject.put("query", getQueryJson(str));
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("shareTicket", r2);
        jSONObject.put("shareInfo", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("appId", str2);
        if (i3 == 1037 || i3 == 1038) {
            String str4 = launchParam.navigateExtData;
            if (!TextUtils.isEmpty(str4)) {
                if (JSONUtil.isJson(str4)) {
                    jSONObject3.put(WadlProxyConsts.EXTRA_DATA, new JSONObject(str4));
                } else {
                    jSONObject3.put(WadlProxyConsts.EXTRA_DATA, str4);
                }
            }
        }
        if (!TextUtils.isEmpty(str3)) {
            if (JSONUtil.isJson(str3)) {
                jSONObject3.put("privateExtraData", new JSONObject(str3));
            } else {
                jSONObject3.put("privateExtraData", str3);
            }
        }
        jSONObject.put("referrerInfo", jSONObject3);
        jSONObject.put("entryDataHash", obj);
        if (miniAppInfo != null) {
            String str5 = miniAppInfo.extendData;
            if (!TextUtils.isEmpty(str5)) {
                if (JSONUtil.isJson(str5)) {
                    try {
                        jSONObject.put("extendData", new JSONObject(str5));
                    } catch (JSONException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("AppBrandUtil", 4, "dispatch extendData parse error", e16);
                        }
                    }
                } else {
                    jSONObject.put("extendData", str5);
                }
            }
        }
        return jSONObject;
    }

    public static ArrayList<String> getConfigFilter() {
        String[] split;
        if (sConfigFilter == null) {
            sConfigFilter = new ArrayList<>();
            String config = QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppOpenUrlFilter", QzoneConfig.DEFAULT_OPENURL_FILTER);
            if (!TextUtils.isEmpty(config) && (split = config.split("\\|")) != null && split.length > 0) {
                for (String str : split) {
                    if (str != null) {
                        sConfigFilter.add(str.trim());
                    }
                }
            }
        }
        return sConfigFilter;
    }

    public static JSONObject getQueryJson(String str) {
        String str2;
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str3 : Uri.parse("file:///" + str).getQueryParameterNames()) {
                String str4 = "[\\\\?&]";
                if (str3.startsWith("$")) {
                    str2 = str3.substring(1);
                    str4 = "[\\\\?&]\\$";
                } else {
                    str2 = str3;
                }
                String str5 = "";
                Matcher matcher = Pattern.compile(str4 + str2 + "=([^&#]*)").matcher(str);
                if (matcher.find()) {
                    str5 = matcher.group(1);
                }
                jSONObject.put(str3, str5);
            }
        } catch (Throwable th5) {
            QLog.e("AppBrandUtil", 1, "getQueryJson err:", th5);
        }
        return jSONObject;
    }

    public static Map<String, Object> getQueryMap(String str) {
        String str2;
        HashMap hashMap = new HashMap();
        try {
            for (String str3 : Uri.parse("file:///" + str).getQueryParameterNames()) {
                String str4 = "[\\\\?&]";
                if (str3.startsWith("$")) {
                    str2 = str3.substring(1);
                    str4 = "[\\\\?&]\\$";
                } else {
                    str2 = str3;
                }
                String str5 = "";
                Matcher matcher = Pattern.compile(str4 + str2 + "=([^&#]*)").matcher(str);
                if (matcher.find()) {
                    str5 = matcher.group(1);
                }
                hashMap.put(str3, str5);
            }
            return hashMap;
        } catch (Throwable th5) {
            try {
                QLog.e("AppBrandUtil", 1, "getQueryMap err:", th5);
            } catch (Throwable unused) {
            }
            return hashMap;
        }
    }

    public static int getStatusBarHeight(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        int dimensionPixelSize = identifier > 0 ? resources.getDimensionPixelSize(identifier) : 0;
        float f16 = resources.getDisplayMetrics().density;
        float f17 = f16 / resources.getDisplayMetrics().density;
        if (f17 <= 0.0f) {
            f17 = 1.0f;
        }
        if (dimensionPixelSize <= 0) {
            return Math.round(f17 * 25.0f * f16);
        }
        return (int) Math.ceil((dimensionPixelSize * f17) + 0.5f);
    }

    public static String getUrlWithoutParams(String str) {
        int indexOf;
        return (TextUtils.isEmpty(str) || (indexOf = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) == -1) ? str : str.substring(0, indexOf);
    }

    public static int getWikiScene(int i3) {
        String config = QzoneConfig.getInstance().getConfig("qqminiapp", "configSceneMap", "{}");
        QLog.d("AppBrandUtil", 2, "getWikiScene " + config + "  scene:" + i3);
        try {
            String optString = new JSONObject(config).optString(String.valueOf(i3));
            if (!TextUtils.isEmpty(optString)) {
                return Integer.parseInt(optString);
            }
        } catch (Exception unused) {
            QLog.e("AppBrandUtil", 2, "getWikiScene fail, " + config + "  scene:" + i3);
        }
        return i3;
    }

    public static boolean isMainThread() {
        return Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId();
    }

    public static boolean isOpenUrlFilter(String str) {
        ArrayList<String> configFilter;
        if (!TextUtils.isEmpty(str) && (configFilter = getConfigFilter()) != null) {
            Iterator<String> it = configFilter.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next != null && str.toLowerCase().startsWith(next.toLowerCase())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String jsonObject2HttpParameter(JSONObject jSONObject) {
        StringBuilder sb5 = new StringBuilder();
        if (jSONObject != null) {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                if (sb5.length() > 0) {
                    sb5.append(Typography.amp);
                }
                String str = (String) keys.next();
                String optString = jSONObject.optString(str);
                sb5.append(str);
                sb5.append('=');
                sb5.append(optString);
            }
        }
        return URLUtil.encodeUrl(sb5.toString());
    }

    public static void parseToJsonMap(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if ((key instanceof String) && (value instanceof Map)) {
                Map map2 = (Map) value;
                parseToJsonMap(map2);
                map.put(key, new JSONObject(map2));
            }
        }
    }

    public static String parseToLocalPath(String str) {
        String path = Uri.parse("file:///" + str).getPath();
        if (path != null && path.startsWith("/")) {
            path = path.substring(1);
        }
        return path != null ? path : "";
    }

    public static boolean needUpdate(MiniAppInfo miniAppInfo, MiniAppInfo miniAppInfo2) {
        int i3;
        if (miniAppInfo == null || miniAppInfo2 == null) {
            return false;
        }
        String str = miniAppInfo.versionId;
        if (str != null && !str.equals(miniAppInfo2.versionId) && (i3 = miniAppInfo.versionUpdateTime) > 0 && miniAppInfo2.versionUpdateTime > i3) {
            if (!QLog.isColorLevel()) {
                return true;
            }
            QLog.i("AppBrandUtil", 2, "needUpdate=true oldVersionUpdateTime=" + miniAppInfo.versionUpdateTime + " newVersionUpdateTime=" + miniAppInfo2.versionUpdateTime + " oldVersionId=" + miniAppInfo.versionId + " newVersionId=" + miniAppInfo2.versionId);
            return true;
        }
        if (!QLog.isColorLevel()) {
            return false;
        }
        QLog.i("AppBrandUtil", 2, "needUpdate=false oldVersionUpdateTime=" + miniAppInfo.versionUpdateTime + " newVersionUpdateTime=" + miniAppInfo2.versionUpdateTime + " oldVersionId=" + miniAppInfo.versionId + " newVersionId=" + miniAppInfo2.versionId);
        return false;
    }
}
