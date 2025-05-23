package com.tencent.qqmini.sdk.launcher.core.model;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.SpecialProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.PreLoadApkgToStrHelper;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.ApkgBaseInfo;
import com.tencent.qqmini.sdk.launcher.model.AppConfigInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.SubPkgInfo;
import com.tencent.qqmini.sdk.launcher.model.TabBarInfo;
import com.tencent.qqmini.sdk.launcher.utils.ApkgFileUtils;
import com.tencent.qqmini.sdk.launcher.utils.AppBrandUtil;
import com.tencent.qqmini.sdk.launcher.utils.FileUtils;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class ApkgInfo extends ApkgBaseInfo {
    public static final int DOMIAN_TYPE_DOWNLOAD = 2;
    public static final int DOMIAN_TYPE_REQUEST = 0;
    public static final int DOMIAN_TYPE_UPLOAD = 3;
    public static final int DOMIAN_TYPE_WEBSOCKET = 1;
    public static final int DOMIAN_TYPE_WEBVIEW = 4;
    private static final String NAME_APP_SERVICE_JS = "app-service.js";
    private static final String NAME_CONFIG_JSON = "app-config.json";
    public static final String NAME_MAIN_APKG = "mini.qapkg";
    private static final String NAME_PAGE_FRAME_HTML = "page-frame.html";
    private static final String NAME_PAGE_FRAME_JS = "page-frame.js";
    private static final String NAME_WXSS_JS = "app-wxss.js";
    private static final String SUFFIX_WXAPKG = ".qapkg";
    private static final String TAG = "ApkgInfo";
    public static final int URL_OPEN_TYPE_EXTERNAL = 1;
    public static final int URL_OPEN_TYPE_INTERNAL = 0;
    private HashMap<String, HashMap<String, ApkgFileUtils.WxapkgFile>> fileMap;
    private boolean isReadApkg;
    public AppConfigInfo mAppConfigInfo;
    public MiniAppInfo mMiniAppInfo;
    private Map<String, String> mPageJsMap;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class PageHtmlContent {
        public String htmlStr;
        public String jsStr;
    }

    public ApkgInfo() {
        this.fileMap = new HashMap<>();
        this.mPageJsMap = new HashMap();
    }

    public static boolean initNetwork(ApkgInfo apkgInfo) {
        if (apkgInfo != null) {
            try {
                AppConfigInfo appConfigInfo = apkgInfo.mAppConfigInfo;
                if (appConfigInfo != null && appConfigInfo.networkTimeoutInfo != null) {
                    SpecialProxy specialProxy = (SpecialProxy) AppLoaderFactory.g().getProxyManager().get(SpecialProxy.class);
                    if (specialProxy != null) {
                        Bundle bundle = new Bundle();
                        bundle.putParcelable(SpecialProxy.KEY_NETWORK_TIMEOUT_INFO, apkgInfo.mAppConfigInfo.networkTimeoutInfo);
                        specialProxy.sendEventToHost(2, bundle, null);
                        return true;
                    }
                    return true;
                }
            } catch (Throwable th5) {
                QMLog.e(TAG, "initNetwork failed", th5);
                return false;
            }
        }
        QMLog.e(TAG, "initNetwork param is wrong");
        return false;
    }

    public static ApkgInfo loadApkgInfoFromFolderPath(String str, String str2, MiniAppInfo miniAppInfo) throws Exception {
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            ApkgInfo apkgInfo = new ApkgInfo(str, miniAppInfo);
            apkgInfo.init(str2);
            QMLog.e(TAG, "loadApkgInfoFromFolderPath initNetwork");
            initNetwork(apkgInfo);
            return apkgInfo;
        }
        return null;
    }

    public static String normalize(String str) {
        if (str != null) {
            int indexOf = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            return str.substring(0, indexOf);
        }
        return str;
    }

    public File getApkgFile(String str) {
        String rootPath = getRootPath(str);
        if (TextUtils.isEmpty(rootPath)) {
            return new File(getApkgFolderPath(), NAME_MAIN_APKG);
        }
        String replaceAll = rootPath.replaceAll("/", "");
        if (this.mMiniAppInfo.isContainerInfo()) {
            return new File(getSubSavePath(getSubPkgInfo(this.mMiniAppInfo, rootPath)));
        }
        return new File(getApkgFolderPath(), replaceAll + ".qapkg");
    }

    public AppConfigInfo getAppConfigInfo() {
        return this.mAppConfigInfo;
    }

    public JSONObject getAppLaunchInfo() {
        if (TextUtils.isEmpty(this.mConfigStr)) {
            return null;
        }
        try {
            return new JSONObject(this.mConfigStr).getJSONObject("appLaunchInfo");
        } catch (Exception e16) {
            QMLog.e(TAG, "getAppLaunchInfo error:", e16);
            return null;
        }
    }

    public String getAppServiceJsContent() {
        try {
            return this.isReadApkg ? readApkgToString(NAME_APP_SERVICE_JS) : FileUtils.readFileToString(new File(getAppServiceJsPath()));
        } catch (IOException e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public String getAppServiceJsPath() {
        return getApkgFolderPath() + "/" + NAME_APP_SERVICE_JS;
    }

    public boolean getDebug() {
        AppConfigInfo appConfigInfo = this.mAppConfigInfo;
        if (appConfigInfo != null) {
            return appConfigInfo.debug;
        }
        return false;
    }

    public Map<String, HashMap<String, ApkgFileUtils.WxapkgFile>> getFileMap() {
        return this.fileMap;
    }

    public String getPageFrameHtmlUrl() {
        return "https://servicewechat.com/page-frame.html";
    }

    public String getPageFrameJSStr(String str) {
        String rootPath = this.mAppConfigInfo.getRootPath(str);
        if (TextUtils.isEmpty(rootPath)) {
            return "";
        }
        if (this.isReadApkg) {
            if (rootPath.endsWith("/")) {
                return readApkgToString(rootPath + NAME_PAGE_FRAME_JS);
            }
            return readApkgToString(rootPath + File.separator + NAME_PAGE_FRAME_JS);
        }
        File file = new File(new File(getApkgFolderPath(), rootPath), NAME_PAGE_FRAME_JS);
        if (!file.exists()) {
            return "";
        }
        return FileUtils.readFileToStr(file);
    }

    public PageHtmlContent getPageHtmlContent(String str) {
        String readFileToStr;
        PageHtmlContent pageHtmlContent = new PageHtmlContent();
        if (this.isReadApkg) {
            readFileToStr = readApkgToString(NAME_PAGE_FRAME_HTML);
            if (TextUtils.isEmpty(readFileToStr)) {
                pageHtmlContent.htmlStr = str;
                return pageHtmlContent;
            }
        } else {
            File file = new File(getApkgFolderPath(), NAME_PAGE_FRAME_HTML);
            if (!file.exists()) {
                pageHtmlContent.htmlStr = str;
                return pageHtmlContent;
            }
            readFileToStr = FileUtils.readFileToStr(file);
        }
        if (readFileToStr != null) {
            String substring = readFileToStr.substring(readFileToStr.indexOf("<script>") + 8, readFileToStr.indexOf("</script>"));
            pageHtmlContent.htmlStr = readFileToStr;
            pageHtmlContent.jsStr = substring;
        }
        return pageHtmlContent;
    }

    public String getPageJsStr(String str) {
        String readFileToString;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String normalize = normalize(str);
        String str2 = this.mPageJsMap.get(normalize);
        if (TextUtils.isEmpty(str2)) {
            try {
                if (this.isReadApkg) {
                    readFileToString = readApkgToString(normalize);
                } else {
                    readFileToString = FileUtils.readFileToString(new File(getApkgFolderPath(), normalize));
                }
                if (readFileToString != null) {
                    str2 = readFileToString.substring(readFileToString.indexOf("<script>") + 8, readFileToString.indexOf("</script>"));
                    this.mPageJsMap.put(normalize, str2);
                    return str2;
                }
                return str2;
            } catch (Throwable th5) {
                th5.printStackTrace();
                return str2;
            }
        }
        return str2;
    }

    @Override // com.tencent.qqmini.sdk.launcher.model.ApkgBaseInfo
    public String getRootPath(String str) {
        AppConfigInfo appConfigInfo = this.mAppConfigInfo;
        if (appConfigInfo != null) {
            return appConfigInfo.getRootPath(str);
        }
        return "";
    }

    public String getRootWxssJsContent() {
        if (this.isReadApkg) {
            return readApkgToString(NAME_WXSS_JS);
        }
        File file = new File(new File(getApkgFolderPath()), NAME_WXSS_JS);
        if (file.exists()) {
            return FileUtils.readFileToStr(file);
        }
        return "";
    }

    public SubPkgInfo getSubPkgInfo(MiniAppInfo miniAppInfo, String str) {
        List<SubPkgInfo> list = miniAppInfo.subpkgs;
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            for (SubPkgInfo subPkgInfo : list) {
                if (str.equals(subPkgInfo.subPkgName)) {
                    return subPkgInfo;
                }
            }
            return null;
        }
        return null;
    }

    public List<String> getSubPkgPath(MiniAppInfo miniAppInfo, SubPkgInfo subPkgInfo) {
        return null;
    }

    public String getSubSavePath(SubPkgInfo subPkgInfo) {
        if (subPkgInfo == null) {
            QMLog.e(TAG, "getSubSavePath param is wrong");
            return getApkgFolderPath() + "/.qapkg";
        }
        if (this.mMiniAppInfo.isContainerInfo() && !TextUtils.isEmpty(subPkgInfo.versionId)) {
            return getApkgFolderPath() + "/" + subPkgInfo.getPureSubPkgName() + "_" + subPkgInfo.versionId + ".qapkg";
        }
        return getApkgFolderPath() + "/" + subPkgInfo.getPureSubPkgName() + ".qapkg";
    }

    public String getSubTempSavePath(SubPkgInfo subPkgInfo) {
        if (this.mMiniAppInfo.isContainerInfo()) {
            return getApkgFolderPath() + "/" + subPkgInfo.getPureSubPkgName() + "_" + subPkgInfo.versionId + "_temp.qapkg";
        }
        return "";
    }

    public String getWorkerJsContent(String str, String str2) {
        if (this.isReadApkg) {
            if (TextUtils.isEmpty(str)) {
                return readApkgToString(str2);
            }
            if (str.endsWith("/")) {
                return readApkgToString(str + str2);
            }
            return readApkgToString(str + File.separator + str2);
        }
        return FileUtils.readFileToStr(new File(getWorkerPath(str, str2)));
    }

    @Override // com.tencent.qqmini.sdk.launcher.model.ApkgBaseInfo
    public String getWorkerPath(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return getApkgFolderPath() + File.separator + str2;
        }
        if (this.isReadApkg) {
            if (str.endsWith("/")) {
                return getApkgFolderPath() + File.separator + str + str2;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(getApkgFolderPath());
            String str3 = File.separator;
            sb5.append(str3);
            sb5.append(str);
            sb5.append(str3);
            sb5.append(str2);
            return sb5.toString();
        }
        return new File(new File(getApkgFolderPath(), str), str2).getAbsolutePath();
    }

    @Override // com.tencent.qqmini.sdk.launcher.model.ApkgBaseInfo
    public void init(String str) throws Exception {
        String readFileToString;
        String readFileToString2;
        if (str != null) {
            String str2 = getApkgFolderPath() + "/" + str;
            if (this.isReadApkg) {
                readFileToString2 = readApkgToString(str + File.separator + NAME_CONFIG_JSON);
            } else {
                readFileToString2 = FileUtils.readFileToString(new File(str2, NAME_CONFIG_JSON));
            }
            this.mConfigStr = readFileToString2;
        } else if (this.mMiniAppInfo.isContainerLoad() && !TextUtils.isEmpty(this.mMiniAppInfo.appJson)) {
            this.mConfigStr = this.mMiniAppInfo.appJson;
        } else {
            if (this.isReadApkg) {
                readFileToString = readApkgToString(NAME_CONFIG_JSON);
            } else {
                readFileToString = FileUtils.readFileToString(new File(getApkgFolderPath(), NAME_CONFIG_JSON));
            }
            this.mConfigStr = readFileToString;
        }
        this.mAppConfigInfo = parseConfig(this.mConfigStr);
    }

    public boolean isHomePage(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String urlWithoutParams = AppBrandUtil.getUrlWithoutParams(str);
        if (!isTabBarPage(urlWithoutParams) && !urlWithoutParams.equals(this.mAppConfigInfo.entryPagePath)) {
            return false;
        }
        return true;
    }

    public boolean isTabBarPage(String str) {
        TabBarInfo tabBarInfo;
        String urlWithoutParams = AppBrandUtil.getUrlWithoutParams(str);
        AppConfigInfo appConfigInfo = this.mAppConfigInfo;
        if (appConfigInfo != null) {
            tabBarInfo = appConfigInfo.tabBarInfo;
        } else {
            tabBarInfo = null;
        }
        if (tabBarInfo != null) {
            Iterator<TabBarInfo.ButtonInfo> it = tabBarInfo.list.iterator();
            while (it.hasNext()) {
                if (it.next().pagePath.equals(urlWithoutParams)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public boolean isUrlFileExist(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!this.isReadApkg) {
            if (!new File(getChildFileAbsolutePath(str)).exists()) {
                return false;
            }
            return true;
        }
        if (str.startsWith("/")) {
            str = str.substring(1);
        }
        File apkgFile = getApkgFile(str);
        if (apkgFile == null || !apkgFile.exists()) {
            return false;
        }
        String name = apkgFile.getName();
        String urlWithoutParams = AppBrandUtil.getUrlWithoutParams(str);
        if (!isUrlResReady(urlWithoutParams, this.mMiniAppInfo)) {
            return false;
        }
        if (!this.fileMap.containsKey(name)) {
            try {
                HashMap<String, ApkgFileUtils.WxapkgFile> fileMapFromApkg = ApkgFileUtils.getFileMapFromApkg(apkgFile);
                if (fileMapFromApkg == null) {
                    return false;
                }
                this.fileMap.put(name, fileMapFromApkg);
            } catch (Throwable th5) {
                th5.printStackTrace();
                QMLog.e(TAG, "getFileMapFromApkg err | url is " + urlWithoutParams, th5);
            }
        }
        HashMap<String, ApkgFileUtils.WxapkgFile> hashMap = this.fileMap.get(name);
        if (hashMap == null || !hashMap.containsKey(urlWithoutParams)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.model.ApkgBaseInfo
    public boolean isUrlResReady(String str, MiniAppInfo miniAppInfo) {
        boolean exists;
        String rootPath = getRootPath(str);
        if (TextUtils.isEmpty(rootPath)) {
            return true;
        }
        String absolutePath = new File(ApkgManager.getApkgFolderPath(miniAppInfo), rootPath).getAbsolutePath();
        String replaceAll = rootPath.replaceAll("/", "");
        if (this.isReadApkg) {
            exists = getApkgFile(str).exists();
        } else {
            exists = new File(absolutePath).exists();
        }
        QMLog.d(TAG, "isUrlResReady | subApkgPath :" + replaceAll + "isExist:" + exists);
        return exists;
    }

    public boolean isValidPrefix(String str, boolean z16) {
        if (z16) {
            if (!TextUtils.isEmpty(str) && (str.startsWith("https://") || str.startsWith("wss://") || str.startsWith("ws://") || str.startsWith("http://"))) {
                return true;
            }
            return false;
        }
        if (!TextUtils.isEmpty(str) && (str.startsWith("https://") || str.startsWith("wss://"))) {
            return true;
        }
        return false;
    }

    public AppConfigInfo parseConfig(String str) throws Exception {
        String str2;
        JSONObject jSONObject = new JSONObject(str);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("USER_DATA_PATH", MiniAppFileManager.WXFILE_PREFIX_USR);
        jSONObject.put(MosaicConstants$JsProperty.PROP_ENV, jSONObject2);
        String optString = jSONObject.optString("entryPagePath");
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        if (miniAppInfo != null) {
            str2 = miniAppInfo.launchParam.entryPath;
        } else {
            str2 = null;
        }
        if (!TextUtils.isEmpty(str2)) {
            optString = str2;
        }
        JSONObject appLaunchInfo = AppBrandUtil.getAppLaunchInfo(optString, this.mMiniAppInfo);
        QMLog.d(TAG, "appLaunchInfo : " + appLaunchInfo.toString());
        jSONObject.put("appLaunchInfo", appLaunchInfo);
        this.mConfigStr = jSONObject.toString();
        return AppConfigInfo.parseAppConfig(jSONObject);
    }

    public ByteArrayInputStream readApkgToStream(String str) {
        if (!isUrlFileExist(str)) {
            return null;
        }
        if (str.startsWith("/")) {
            str = str.substring(1);
        }
        File apkgFile = getApkgFile(str);
        String name = apkgFile.getName();
        ApkgFileUtils.WxapkgFile wxapkgFile = this.fileMap.get(name).get(AppBrandUtil.getUrlWithoutParams(str));
        return ApkgFileUtils.readApkgToStream(apkgFile, wxapkgFile.start, wxapkgFile.length);
    }

    public String readApkgToString(String str) {
        if (!isUrlFileExist(str)) {
            return null;
        }
        if (str.startsWith("/")) {
            str = str.substring(1);
        }
        File apkgFile = getApkgFile(str);
        ApkgFileUtils.WxapkgFile wxapkgFile = this.fileMap.get(apkgFile.getName()).get(AppBrandUtil.getUrlWithoutParams(str));
        int i3 = wxapkgFile.start;
        int i16 = wxapkgFile.length;
        String str2 = this.mMiniAppInfo.appId + "_" + apkgFile.getName() + "_" + i3 + "_" + i16;
        String apkgToStringFromMap = PreLoadApkgToStrHelper.getInstance().getApkgToStringFromMap(str2);
        if (TextUtils.isEmpty(apkgToStringFromMap)) {
            String readApkgToStr = ApkgFileUtils.readApkgToStr(apkgFile, i3, i16);
            PreLoadApkgToStrHelper.getInstance().putApkgToStringToMap(str2, readApkgToStr);
            QMLog.i(TAG, "putApkgToStringToMap:" + str2 + " not cache!");
            return readApkgToStr;
        }
        return apkgToStringFromMap;
    }

    public void setDebug(boolean z16) {
        if (z16 == this.mAppConfigInfo.debug) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.mConfigStr);
            jSONObject.put("debug", z16);
            FileUtils.writeFile(new File(getApkgFolderPath(), NAME_CONFIG_JSON).getAbsolutePath(), jSONObject.toString().replaceAll("\\\\", ""));
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public void updateAppLaunchInfo(JSONObject jSONObject) {
        if (TextUtils.isEmpty(this.mConfigStr)) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(this.mConfigStr);
            jSONObject2.put("appLaunchInfo", jSONObject);
            this.mConfigStr = jSONObject2.toString();
        } catch (Exception e16) {
            QMLog.e(TAG, "updateAppLaunchInfo error:", e16);
        }
    }

    public String getAppServiceJsPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return getApkgFolderPath() + "/" + NAME_APP_SERVICE_JS;
        }
        return new File(new File(getApkgFolderPath(), str), NAME_APP_SERVICE_JS).getAbsolutePath();
    }

    public ApkgInfo(String str, MiniAppInfo miniAppInfo) {
        super(str, miniAppInfo);
        this.fileMap = new HashMap<>();
        this.mPageJsMap = new HashMap();
        this.mMiniAppInfo = miniAppInfo;
        this.isReadApkg = !miniAppInfo.launchParam.isFlutterMode;
    }

    public String getAppServiceJsContent(String str) {
        if (this.isReadApkg) {
            if (TextUtils.isEmpty(str)) {
                return readApkgToString(NAME_MAIN_APKG);
            }
            if (str.endsWith("/")) {
                return readApkgToString(str + NAME_APP_SERVICE_JS);
            }
            return readApkgToString(str + File.separator + NAME_APP_SERVICE_JS);
        }
        return FileUtils.readFileToStr(new File(getAppServiceJsPath(str)));
    }
}
