package com.tencent.qqmini.sdk.launcher.utils;

import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qqmini.miniapp.core.EventListener;
import com.tencent.qqmini.sdk.launcher.annotation.BindClass;
import com.tencent.qqmini.sdk.launcher.dynamic.MiniAppDexLoader;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import com.tencent.qqmini.sdk.launcher.model.FileMaterialInfo;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class AppBrandUtil {
    public static final String TAG = "AppBrandUtil";

    public static Object bindField(Object obj, String str) {
        try {
            return bindField(obj, obj.getClass().getDeclaredField(str));
        } catch (Exception e16) {
            QMLog.e("AppBrandUtil", "Failed to bindFiled " + obj + " " + str, e16);
            return null;
        }
    }

    public static long currTime() {
        return System.currentTimeMillis();
    }

    public static JSONObject getAppLaunchInfo(String str, MiniAppInfo miniAppInfo) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("path", getUrlWithoutParams(str));
            jSONObject.put("query", getQueryJson(str));
            jSONObject.put("scene", getWikiScene(getScene(miniAppInfo)));
            jSONObject.put("shareTicket", getShareTicket(miniAppInfo));
            jSONObject.put("referrerInfo", getReferrerInfo(miniAppInfo));
            String extendData = getExtendData(miniAppInfo);
            if (!TextUtils.isEmpty(extendData)) {
                if (isJson(extendData)) {
                    try {
                        jSONObject.put("extendData", new JSONObject(extendData));
                    } catch (JSONException e16) {
                        QMLog.e("AppBrandUtil", "dispatch extendData parse error", e16);
                    }
                } else {
                    jSONObject.put("extendData", extendData);
                }
            }
            jSONObject.put("entryDataHash", getEntryDataHash(miniAppInfo));
            JSONArray forwardMaterialsInfo = getForwardMaterialsInfo(miniAppInfo);
            if (forwardMaterialsInfo != null && forwardMaterialsInfo.length() > 0) {
                jSONObject.put("forwardMaterials", forwardMaterialsInfo);
            }
        } catch (Throwable th5) {
            QMLog.e("AppBrandUtil", "getAppLaunchInfo error, ", th5);
        }
        return jSONObject;
    }

    private static String getEntryDataHash(MiniAppInfo miniAppInfo) {
        LaunchParam launchParam;
        EntryModel entryModel;
        if (miniAppInfo != null && (launchParam = miniAppInfo.launchParam) != null && (entryModel = launchParam.entryModel) != null) {
            return entryModel.getEntryHash();
        }
        return null;
    }

    private static String getExtendData(MiniAppInfo miniAppInfo) {
        if (miniAppInfo != null) {
            return miniAppInfo.extendData;
        }
        return null;
    }

    private static JSONArray getForwardMaterialsInfo(MiniAppInfo miniAppInfo) throws JSONException {
        JSONArray jSONArray = null;
        if (miniAppInfo == null) {
            return null;
        }
        List<FileMaterialInfo> list = miniAppInfo.launchParam.fileMaterialInfoList;
        if (list != null && !list.isEmpty()) {
            jSONArray = new JSONArray();
            for (FileMaterialInfo fileMaterialInfo : list) {
                String tmpPath = fileMaterialInfo.getTmpPath();
                if (!TextUtils.isEmpty(tmpPath)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("type", fileMaterialInfo.getMimeType());
                    jSONObject.put("name", fileMaterialInfo.getName());
                    jSONObject.put("path", tmpPath);
                    jSONObject.put("size", fileMaterialInfo.getSize());
                    jSONArray.mo162put(jSONObject);
                }
            }
        }
        return jSONArray;
    }

    public static JSONObject getPageLoadInfo(String str, String str2, MiniAppInfo miniAppInfo) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("path", getUrlWithoutParams(str));
            jSONObject.put("query", getQueryJson(str));
            jSONObject.put("openType", str2);
            if (EventListener.APPLAUNCH.equals(str2)) {
                jSONObject.put("scene", getScene(miniAppInfo));
                jSONObject.put("shareTicket", getShareTicket(miniAppInfo));
                jSONObject.put("referrerInfo", getReferrerInfo(miniAppInfo));
                String extendData = getExtendData(miniAppInfo);
                if (!TextUtils.isEmpty(extendData)) {
                    if (isJson(extendData)) {
                        try {
                            jSONObject.put("extendData", new JSONObject(extendData));
                        } catch (JSONException e16) {
                            QMLog.e("AppBrandUtil", "dispatch extendData parse error", e16);
                        }
                    } else {
                        jSONObject.put("extendData", extendData);
                    }
                }
            }
        } catch (Throwable th5) {
            QMLog.e("AppBrandUtil", "getPageShowInfo error, ", th5);
        }
        QMLog.i("AppBrandUtil", "getPageLoadInfo : " + jSONObject.toString());
        return jSONObject;
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
            QMLog.e("AppBrandUtil", "getQueryJson err:", th5);
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
        } catch (Throwable unused) {
        }
        return hashMap;
    }

    private static JSONObject getReferrerInfo(MiniAppInfo miniAppInfo) {
        if (miniAppInfo != null && miniAppInfo.launchParam != null) {
            JSONObject jSONObject = new JSONObject();
            LaunchParam launchParam = miniAppInfo.launchParam;
            int i3 = launchParam.scene;
            try {
                jSONObject.put("appId", launchParam.fromMiniAppId);
                if (i3 == 1037 || i3 == 1038) {
                    String str = miniAppInfo.launchParam.navigateExtData;
                    if (!TextUtils.isEmpty(str)) {
                        if (isJson(str)) {
                            jSONObject.put(WadlProxyConsts.EXTRA_DATA, new JSONObject(str));
                        } else {
                            jSONObject.put(WadlProxyConsts.EXTRA_DATA, str);
                        }
                    }
                }
            } catch (Throwable th5) {
                QMLog.e("getReferrerInfo", "error,", th5);
            }
            return jSONObject;
        }
        return null;
    }

    private static int getScene(MiniAppInfo miniAppInfo) {
        LaunchParam launchParam;
        if (miniAppInfo != null && (launchParam = miniAppInfo.launchParam) != null) {
            return launchParam.scene;
        }
        return 9999;
    }

    private static String getShareTicket(MiniAppInfo miniAppInfo) {
        LaunchParam launchParam;
        if (miniAppInfo != null && (launchParam = miniAppInfo.launchParam) != null) {
            return launchParam.shareTicket;
        }
        return null;
    }

    public static String getUrlWithoutParams(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int indexOf = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        if (indexOf != -1) {
            return str.substring(0, indexOf);
        }
        return str;
    }

    public static boolean isJson(String str) {
        try {
            new JSONObject(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isMainThread() {
        if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
            return true;
        }
        return false;
    }

    public static boolean needUpdate(MiniAppInfo miniAppInfo, MiniAppInfo miniAppInfo2) {
        int i3;
        if (miniAppInfo != null && miniAppInfo2 != null) {
            String str = miniAppInfo.versionId;
            if (str != null && !str.equals(miniAppInfo2.versionId) && (i3 = miniAppInfo.versionUpdateTime) > 0 && miniAppInfo2.versionUpdateTime > i3) {
                QMLog.i("AppBrandUtil", "needUpdate=true oldVersionUpdateTime=" + miniAppInfo.versionUpdateTime + " newVersionUpdateTime=" + miniAppInfo2.versionUpdateTime + " oldVersionId=" + miniAppInfo.versionId + " newVersionId=" + miniAppInfo2.versionId);
                return true;
            }
            QMLog.i("AppBrandUtil", "needUpdate=false oldVersionUpdateTime=" + miniAppInfo.versionUpdateTime + " newVersionUpdateTime=" + miniAppInfo2.versionUpdateTime + " oldVersionId=" + miniAppInfo.versionId + " newVersionId=" + miniAppInfo2.versionId);
            return false;
        }
        return false;
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
        if (path != null) {
            return path;
        }
        return "";
    }

    public static Object bindField(Object obj, Field field) {
        try {
            field.setAccessible(true);
            Object obj2 = field.get(obj);
            if (obj2 != null) {
                return obj2;
            }
            if (!field.isAnnotationPresent(BindClass.class)) {
                return null;
            }
            Object create = MiniAppDexLoader.g().create(((BindClass) field.getAnnotation(BindClass.class)).className());
            field.set(obj, create);
            return create;
        } catch (Exception e16) {
            QMLog.e("AppBrandUtil", "Failed to bindField " + obj + " " + field, e16);
            return null;
        }
    }

    public static int getWikiScene(int i3) {
        return i3;
    }
}
