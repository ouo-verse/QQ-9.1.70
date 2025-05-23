package com.tencent.mobileqq.mini.apkg;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.report.ReadInJoyMMapKvStorage;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandUtil;
import com.tencent.mobileqq.utils.StringUtil;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class AppConfigInfo {
    private static final boolean mEnableSubpakPathIntercapt;
    public String PackageToolVersion;
    public boolean darkmode;
    public boolean debug;
    public String entryPagePath;
    public PageInfo globalPageInfo;
    public NetworkTimeoutInfo networkTimeoutInfo;
    private Map<String, PageInfo> pagesInfo;
    public List<String> pagesPathList;
    public JSONObject permissionInfo;
    public TabBarInfo tabBarInfo;
    private Map<String, String> configStrs = new HashMap();
    public List<String> subPackRoots = new LinkedList();

    static {
        mEnableSubpakPathIntercapt = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.MINI_APP_SUBPKG_PATH_INTERCEPT, 0) == 1;
    }

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

    public static AppConfigInfo parseAppConfig(String str, ApkgInfo apkgInfo) {
        AppConfigInfo appConfigInfo = new AppConfigInfo();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                appConfigInfo.configStrs.put(str2, jSONObject.optString(str2));
            }
            appConfigInfo.debug = jSONObject.optBoolean("debug");
            appConfigInfo.entryPagePath = jSONObject.optString("entryPagePath");
            PageInfo pageInfo = PageInfo.getDefault();
            appConfigInfo.globalPageInfo = pageInfo;
            pageInfo.updateInfo(jSONObject.optJSONObject(ReadInJoyMMapKvStorage.NAME_DEFAULT));
            appConfigInfo.pagesInfo = parsePagesInfo(jSONObject.optJSONObject("page"), appConfigInfo.globalPageInfo);
            appConfigInfo.pagesPathList = parsePagesPathList(jSONObject.optJSONArray("pages"));
            appConfigInfo.networkTimeoutInfo = NetworkTimeoutInfo.parse(jSONObject.optJSONObject("networkTimeout"));
            appConfigInfo.tabBarInfo = TabBarInfo.parse(jSONObject.optJSONObject("tabBar"), apkgInfo);
            JSONArray optJSONArray = jSONObject.optJSONArray("subpackages");
            if (optJSONArray == null) {
                optJSONArray = jSONObject.optJSONArray("subPackages");
            }
            appConfigInfo.subPackRoots = getSubPackRoots(optJSONArray);
            appConfigInfo.PackageToolVersion = jSONObject.optString("PackageToolVersion");
            appConfigInfo.permissionInfo = jSONObject.optJSONObject(QCircleDaTongConstant.ElementParamValue.PERMISSION);
            appConfigInfo.darkmode = jSONObject.optBoolean(QCircleSkinHelper.SKIN_DARK_MODE_TAG);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        return appConfigInfo;
    }

    public static Map<String, PageInfo> parsePagesInfo(JSONObject jSONObject, PageInfo pageInfo) {
        HashMap hashMap = new HashMap();
        if (jSONObject != null) {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                PageInfo m201clone = pageInfo.m201clone();
                m201clone.updateInfo(jSONObject.optJSONObject(str));
                hashMap.put(str, m201clone);
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

    public PageInfo getPageInfo(String str) {
        PageInfo pageInfo = this.pagesInfo.get(AppBrandUtil.getUrlWithoutParams(str));
        return pageInfo == null ? this.globalPageInfo : pageInfo;
    }

    public String getPagesStr() {
        return this.configStrs.get("pages");
    }

    public String getRootPath(String str) {
        if (StringUtil.isEmpty(str)) {
            return "";
        }
        String urlWithoutParams = AppBrandUtil.getUrlWithoutParams(str);
        for (String str2 : this.subPackRoots) {
            String substring = str2.startsWith("/") ? str2.substring(1) : str2;
            if (mEnableSubpakPathIntercapt && substring.endsWith("/")) {
                substring = substring.substring(0, substring.length() - 1);
            }
            if ((urlWithoutParams.startsWith("/") ? urlWithoutParams.substring(1) : urlWithoutParams).startsWith(substring)) {
                return str2;
            }
        }
        return "";
    }
}
