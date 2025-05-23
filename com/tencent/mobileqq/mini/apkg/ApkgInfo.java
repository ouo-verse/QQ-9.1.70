package com.tencent.mobileqq.mini.apkg;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.mini.apkg.TabBarInfo;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandUtil;
import com.tencent.mobileqq.mini.network.http.MiniOkHttpClientFactory;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.util.ImageUtil;
import com.tencent.mobileqq.mini.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ApkgInfo extends ApkgBaseInfo {
    private static final String NAME_APP_SERVICE_JS = "app-service.js";
    private static final String NAME_CONFIG_JSON = "app-config.json";
    private static final String NAME_PAGE_FRAME_HTML = "page-frame.html";
    private static final String NAME_PAGE_FRAME_JS = "page-frame.js";
    private static final String NAME_WXSS_JS = "app-wxss.js";
    private static final String TAG = "ApkgInfo";
    public static final int URL_OPEN_TYPE_EXTERNAL = 1;
    public static final int URL_OPEN_TYPE_INTERNAL = 0;
    private Map<String, Bitmap> bitmapCache;
    public AppConfigInfo mAppConfigInfo;
    private Map<String, String> mPageJsMap;

    public ApkgInfo(String str, MiniAppConfig miniAppConfig) {
        super(str, miniAppConfig);
        this.mPageJsMap = new HashMap();
        this.bitmapCache = new HashMap();
    }

    public static ApkgInfo loadApkgInfoFromFolderPath(String str, String str2, MiniAppConfig miniAppConfig) {
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return null;
        }
        ApkgInfo apkgInfo = new ApkgInfo(str, miniAppConfig);
        apkgInfo.init(str2);
        NetworkTimeoutInfo networkTimeoutInfo = apkgInfo.mAppConfigInfo.networkTimeoutInfo;
        MiniOkHttpClientFactory.init(networkTimeoutInfo.request, networkTimeoutInfo.uploadFile, networkTimeoutInfo.downloadFile);
        return apkgInfo;
    }

    public Bitmap getBitmap(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Bitmap bitmap = this.bitmapCache.get(str);
        if (bitmap != null) {
            return bitmap;
        }
        Bitmap localBitmap = ImageUtil.getLocalBitmap(str);
        this.bitmapCache.put(str, localBitmap);
        return localBitmap;
    }

    public boolean getDebug() {
        AppConfigInfo appConfigInfo = this.mAppConfigInfo;
        if (appConfigInfo != null) {
            return appConfigInfo.debug;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.mini.apkg.ApkgBaseInfo
    public String getRootPath(String str) {
        return this.mAppConfigInfo.getRootPath(str);
    }

    @Override // com.tencent.mobileqq.mini.apkg.ApkgBaseInfo
    public String getWorkerPath(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return getApkgFolderPath() + File.separator + str2;
        }
        return new File(new File(getApkgFolderPath(), str), str2).getAbsolutePath();
    }

    @Override // com.tencent.mobileqq.mini.apkg.ApkgBaseInfo
    public void init(String str) {
        try {
            if (str != null) {
                this.mConfigStr = FileUtils.readFileToString(new File(getApkgFolderPath() + "/" + str, NAME_CONFIG_JSON));
            } else {
                this.mConfigStr = FileUtils.readFileToString(new File(getApkgFolderPath(), NAME_CONFIG_JSON));
            }
            updateConfigStr(this.mConfigStr);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public boolean isTabBarPage(String str) {
        String urlWithoutParams = AppBrandUtil.getUrlWithoutParams(str);
        TabBarInfo tabBarInfo = this.mAppConfigInfo.tabBarInfo;
        if (tabBarInfo == null) {
            return false;
        }
        Iterator<TabBarInfo.ButtonInfo> it = tabBarInfo.list.iterator();
        while (it.hasNext()) {
            if (it.next().pagePath.equals(urlWithoutParams)) {
                return true;
            }
        }
        return false;
    }

    public boolean isUrlFileExist(String str) {
        return !TextUtils.isEmpty(str) && new File(getFilePath(AppBrandUtil.getUrlWithoutParams(str))).exists();
    }

    @Override // com.tencent.mobileqq.mini.apkg.ApkgBaseInfo
    public boolean isUrlResReady(String str) {
        String rootPath = getRootPath(str);
        if (TextUtils.isEmpty(rootPath)) {
            return true;
        }
        String absolutePath = new File(ApkgManager.getApkgFolderPath(this.appConfig.config), rootPath).getAbsolutePath();
        boolean exists = new File(absolutePath).exists();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "isUrlResReady | subFolderPath :" + absolutePath + "isExist:" + exists);
        }
        return exists;
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

    public void updateConfigStr(String str) {
        MiniAppInfo miniAppInfo;
        LaunchParam launchParam;
        try {
            this.mConfigStr = str;
            JSONObject jSONObject = new JSONObject(this.mConfigStr);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("USER_DATA_PATH", MiniAppFileManager.WXFILE_PREFIX_USR);
            jSONObject.put(MosaicConstants$JsProperty.PROP_ENV, jSONObject2);
            String optString = jSONObject.optString("entryPagePath");
            MiniAppConfig miniAppConfig = this.appConfig;
            String str2 = null;
            if (miniAppConfig != null) {
                launchParam = miniAppConfig.launchParam;
                String str3 = launchParam != null ? launchParam.entryPath : null;
                miniAppInfo = miniAppConfig.config;
                if (miniAppInfo == null) {
                    miniAppInfo = null;
                }
                str2 = str3;
            } else {
                miniAppInfo = null;
                launchParam = null;
            }
            if (isUrlFileExist(str2)) {
                optString = str2;
            }
            jSONObject.put("appLaunchInfo", AppBrandUtil.getAppLaunchInfo(optString, launchParam, miniAppInfo));
            String jSONObject3 = jSONObject.toString();
            this.mConfigStr = jSONObject3;
            this.mAppConfigInfo = AppConfigInfo.parseAppConfig(jSONObject3, this);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }
}
