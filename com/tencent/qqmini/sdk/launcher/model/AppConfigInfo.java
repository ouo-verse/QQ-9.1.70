package com.tencent.qqmini.sdk.launcher.model;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.report.ReadInJoyMMapKvStorage;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class AppConfigInfo {
    private static final boolean mEnableSubpakPathIntercapt = false;
    public boolean darkmode;
    public boolean debug;
    public String entryPagePath;
    public PageInfo globalPageInfo;
    public NetworkTimeoutInfo networkTimeoutInfo;
    public String packageToolVersion;
    private Map<String, PageInfo> pagesInfo;
    public List<String> pagesPathList;
    public JSONObject permissionInfo;
    public TabBarInfo tabBarInfo;
    public List<String> subPackRoots = new LinkedList();
    private Map<String, String> configStrs = new HashMap();

    private static List<String> getSubPackRoots(JSONArray jSONArray) {
        LinkedList linkedList = new LinkedList();
        if (jSONArray != null) {
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("root");
                    if (!TextUtils.isEmpty(optString)) {
                        linkedList.add(optString);
                    }
                }
            }
        }
        return linkedList;
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

    public static AppConfigInfo parseAppConfig(String str) {
        try {
            return parseAppConfig(new JSONObject(str));
        } catch (Throwable th5) {
            th5.printStackTrace();
            return new AppConfigInfo();
        }
    }

    public static Map<String, PageInfo> parsePagesInfo(JSONObject jSONObject, PageInfo pageInfo) {
        HashMap hashMap = new HashMap();
        if (jSONObject != null) {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                PageInfo m243clone = pageInfo.m243clone();
                if (m243clone != null) {
                    m243clone.updateInfo(jSONObject.optJSONObject(str));
                }
                hashMap.put(str, m243clone);
            }
        }
        return hashMap;
    }

    public static List<String> parsePagesPathList(JSONArray jSONArray) {
        LinkedList linkedList = new LinkedList();
        if (jSONArray != null) {
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                String optString = jSONArray.optString(i3);
                if (!TextUtils.isEmpty(optString)) {
                    linkedList.add(optString);
                }
            }
        }
        return linkedList;
    }

    public String getCustomConfigTitleAlign() {
        String str = this.configStrs.get("titleBar");
        if (str != null) {
            try {
                return new JSONObject(str).optString("titleAlign");
            } catch (JSONException e16) {
                QMLog.e("AppConfigInfo", e16.getMessage());
            }
        }
        return "left";
    }

    public PageInfo getPageInfo(String str) {
        PageInfo pageInfo = this.pagesInfo.get(getUrlWithoutParams(str));
        if (pageInfo == null) {
            return this.globalPageInfo;
        }
        return pageInfo;
    }

    public String getPagesStr() {
        return this.configStrs.get("pages");
    }

    public String getRootPath(String str) {
        String str2;
        String str3;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String urlWithoutParams = getUrlWithoutParams(str);
        for (String str4 : this.subPackRoots) {
            if (str4.startsWith("/")) {
                str2 = str4.substring(1);
            } else {
                str2 = str4;
            }
            if (urlWithoutParams.startsWith("/")) {
                str3 = urlWithoutParams.substring(1);
            } else {
                str3 = urlWithoutParams;
            }
            if (str3.startsWith(str2)) {
                return str4;
            }
        }
        return "";
    }

    public static AppConfigInfo parseAppConfig(JSONObject jSONObject) {
        AppConfigInfo appConfigInfo = new AppConfigInfo();
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                appConfigInfo.configStrs.put(str, jSONObject.optString(str));
            }
            appConfigInfo.debug = jSONObject.optBoolean("debug");
            appConfigInfo.entryPagePath = jSONObject.optString("entryPagePath");
            PageInfo pageInfo = PageInfo.getDefault();
            appConfigInfo.globalPageInfo = pageInfo;
            pageInfo.updateInfo(jSONObject.optJSONObject(ReadInJoyMMapKvStorage.NAME_DEFAULT));
            appConfigInfo.pagesInfo = parsePagesInfo(jSONObject.optJSONObject("page"), appConfigInfo.globalPageInfo);
            appConfigInfo.pagesPathList = parsePagesPathList(jSONObject.optJSONArray("pages"));
            appConfigInfo.networkTimeoutInfo = NetworkTimeoutInfo.parse(jSONObject.optJSONObject("networkTimeout"));
            appConfigInfo.tabBarInfo = TabBarInfo.parse(jSONObject.optJSONObject("tabBar"));
            JSONArray optJSONArray = jSONObject.optJSONArray("subpackages");
            if (optJSONArray == null) {
                optJSONArray = jSONObject.optJSONArray("subPackages");
            }
            appConfigInfo.subPackRoots = getSubPackRoots(optJSONArray);
            appConfigInfo.packageToolVersion = jSONObject.optString("PackageToolVersion");
            appConfigInfo.permissionInfo = jSONObject.optJSONObject(QCircleDaTongConstant.ElementParamValue.PERMISSION);
            appConfigInfo.darkmode = jSONObject.optBoolean(QCircleSkinHelper.SKIN_DARK_MODE_TAG);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        return appConfigInfo;
    }
}
