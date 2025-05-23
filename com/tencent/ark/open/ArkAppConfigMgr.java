package com.tencent.ark.open;

import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.Logger;
import com.tencent.ark.data.ArkAppElement;
import com.tencent.ark.mmkv.IMMKV;
import com.tencent.ark.mmkv.MMKVManager;
import com.tencent.ark.mmkv.MMKVUtils;
import com.tencent.ark.open.ArkAppInfo;
import com.tencent.ark.open.appmanage.AppUpdateManager;
import com.tencent.ark.open.internal.ArkAppCGIMgr;
import com.tencent.ark.open.security.ArkAppUrlChecker;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ArkAppConfigMgr {
    private static final String ALLOW_FORWARD = "*";
    public static final int DOWNLOAD_ICON_FAIL = 2;
    public static final int DOWNLOAD_ICON_FILE_ERROR = -1;
    public static final int DOWNLOAD_ICON_PARAM_ERROR = -2;
    public static final int DOWNLOAD_ICON_SUCESS = 1;
    private static final String ICON_TEMP_FILE_SUFFIX = "_tmp";
    private static final String JSON_KEY_APP_GLOBAL_URL_BLACK = "black";
    private static final String JSON_KEY_APP_GLOBAL_URL_CONFIG = "app_global_url_config";
    private static final String JSON_KEY_APP_GLOBAL_URL_WHITE = "white";
    private static final String JSON_KEY_COLLECT = "collect";
    private static final String JSON_KEY_ENTRY = "entry";
    private static final String JSON_KEY_FLAG = "flag";
    private static final String JSON_KEY_FORWARD_VIEWS = "fwdViews";
    private static final String JSON_KEY_ICON = "icon";
    private static final String JSON_KEY_NAME = "name";
    private static final String JSON_KEY_NAV = "nav";
    private static final String JSON_KEY_REPLY = "reply";
    private static final String JSON_KEY_RES = "res";
    private static final String JSON_KEY_TYPE = "type";
    private static final String JSON_KEY_URLWHITELIST = "urlWhitelist";
    private static final String JSON_KEY_VER = "ver";
    private static final String TAG = "ArkApp.ArkAppConfigMgr";
    private static volatile ArkAppConfigMgr sInstance;
    private static final ArkEnvironmentManager ENV = ArkEnvironmentManager.getInstance();
    private static boolean sEnableAppConfig = true;
    public static final Object lock = new Object();
    public boolean mUrlCheckEnable = true;
    private ArrayList<String> mUrlDisableAppList = new ArrayList<>(4);
    private HashMap<String, ArkAppInfo.AppConfig> mAppConfigCache = new HashMap<>(8);
    private ArrayList<ArkAppInfo.ArkWhiteUrlItem> mGlobalWhiteList = null;
    private ArrayList<ArkAppInfo.ArkWhiteUrlItem> mGlobalBlackList = null;
    private HashMap<String, ArkAppUrlChecker> mAppUrlCheckerCache = new HashMap<>(8);
    private Map<String, DownloadIconTask> mDownloadIconTaskList = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class DownloadIconTask {
        public ArrayList<IDownloadIconCallback> callbackList;
        public String url;

        DownloadIconTask() {
            this.callbackList = new ArrayList<>();
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface IDownloadIconCallback {
        void onDownloadFinised(int i3, String str, String str2);
    }

    private void checkAppIcon(final String str, final String str2, final ArkAppInfo.AppConfig appConfig) {
        ArkDispatchTask.getInstance().postToArkThread(new Runnable() { // from class: com.tencent.ark.open.ArkAppConfigMgr.4
            @Override // java.lang.Runnable
            public void run() {
                if (appConfig != null && !TextUtils.isEmpty(str)) {
                    String format = String.format("%s/%s", ArkEnvironmentManager.getInstance().getAppIconDirectory(), str);
                    String appIconFilePath = ArkAppConfigMgr.this.getAppIconFilePath(str, str2);
                    File file = new File(format);
                    if (appIconFilePath != null) {
                        File file2 = new File(appIconFilePath);
                        if (!file.exists() || !file2.exists()) {
                            Logger.logI(ArkAppConfigMgr.TAG, "ArkSafe.checkAppIcon find local config need to download iconUrl:");
                            ArkAppConfigMgr.this.downloadAppIcon(str, str2, appConfig.iconUrl, null);
                        }
                    }
                }
            }
        });
    }

    public static String convertConfigToJsonString(ArkAppInfo.AppConfig appConfig) {
        if (appConfig == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ver", appConfig.ver);
            jSONObject.put("name", appConfig.name);
            jSONObject.put("icon", appConfig.iconUrl);
            jSONObject.put(JSON_KEY_ENTRY, appConfig.entry);
            jSONObject.put("flag", appConfig.flag);
            jSONObject.put("type", appConfig.type);
            if (appConfig.urlWhitelist != null) {
                JSONObject jSONObject2 = new JSONObject();
                ArrayList<ArkAppInfo.ArkWhiteUrlItem> arrayList = appConfig.urlWhitelist.resourceList;
                if (arrayList != null) {
                    JSONArray jSONArray = new JSONArray();
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        ArkAppInfo.ArkWhiteUrlItem arkWhiteUrlItem = arrayList.get(i3);
                        if (arkWhiteUrlItem != null) {
                            jSONArray.mo162put(arkWhiteUrlItem.toString());
                        }
                    }
                    jSONObject2.put("res", jSONArray);
                }
                ArrayList<ArkAppInfo.ArkWhiteUrlItem> arrayList2 = appConfig.urlWhitelist.navigationList;
                if (arrayList2 != null) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i16 = 0; i16 < arrayList2.size(); i16++) {
                        ArkAppInfo.ArkWhiteUrlItem arkWhiteUrlItem2 = arrayList2.get(i16);
                        if (arkWhiteUrlItem2 != null) {
                            jSONArray2.mo162put(arkWhiteUrlItem2.toString());
                        }
                    }
                    jSONObject2.put(JSON_KEY_NAV, jSONArray2);
                }
                jSONObject.put(JSON_KEY_URLWHITELIST, jSONObject2);
            }
            ArrayList<String> arrayList3 = appConfig.forwardViews;
            if (arrayList3 != null && arrayList3.size() > 0) {
                JSONArray jSONArray3 = new JSONArray();
                for (int i17 = 0; i17 < appConfig.forwardViews.size(); i17++) {
                    String str = appConfig.forwardViews.get(i17);
                    if (!TextUtils.isEmpty(str)) {
                        jSONArray3.mo162put(str);
                    }
                }
                jSONObject.put(JSON_KEY_FORWARD_VIEWS, jSONArray3);
            }
            jSONObject.put("reply", appConfig.replay);
            jSONObject.put("collect", appConfig.collect);
        } catch (JSONException e16) {
            Logger.logE(TAG, "ArkSafe.convert json exeption:", e16.toString());
        }
        return jSONObject.toString();
    }

    public static ArkAppInfo.AppConfig convertJsonToConfig(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ArkAppInfo.AppConfig appConfig = new ArkAppInfo.AppConfig();
        try {
            appConfig.ver = jSONObject.optLong("ver");
            appConfig.name = jSONObject.optString("name");
            appConfig.iconUrl = jSONObject.optString("icon");
            appConfig.entry = jSONObject.optLong(JSON_KEY_ENTRY);
            appConfig.flag = jSONObject.optInt("flag");
            appConfig.type = jSONObject.optInt("type");
            JSONObject optJSONObject = jSONObject.optJSONObject(JSON_KEY_URLWHITELIST);
            if (optJSONObject != null) {
                appConfig.urlWhitelist = new ArkAppInfo.AppUrlWhiteList();
                JSONArray optJSONArray = optJSONObject.optJSONArray("res");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        ArkAppInfo.ArkWhiteUrlItem convertWhiteUrlToItem = convertWhiteUrlToItem(optJSONArray.optString(i3));
                        if (convertWhiteUrlToItem != null) {
                            appConfig.urlWhitelist.resourceList.add(convertWhiteUrlToItem);
                        }
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray(JSON_KEY_NAV);
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    for (int i16 = 0; i16 < optJSONArray2.length(); i16++) {
                        ArkAppInfo.ArkWhiteUrlItem convertWhiteUrlToItem2 = convertWhiteUrlToItem(optJSONArray2.optString(i16));
                        if (convertWhiteUrlToItem2 != null) {
                            appConfig.urlWhitelist.navigationList.add(convertWhiteUrlToItem2);
                        }
                    }
                }
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray(JSON_KEY_FORWARD_VIEWS);
            if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                appConfig.forwardViews = new ArrayList<>(optJSONArray3.length());
                for (int i17 = 0; i17 < optJSONArray3.length(); i17++) {
                    String optString = optJSONArray3.optString(i17);
                    if (optString != null) {
                        appConfig.forwardViews.add(optString);
                    }
                }
            }
            appConfig.replay = jSONObject.optInt("reply");
            appConfig.collect = jSONObject.optInt("collect");
        } catch (Exception e16) {
            Logger.logI(TAG, "ArkSafe.convert json exception:", e16.toString());
        }
        return appConfig;
    }

    public static ArkAppInfo.ArkWhiteUrlItem convertWhiteUrlToItem(String str) {
        String substring;
        String substring2;
        if (!TextUtils.isEmpty(str)) {
            String removeSpecialChars = removeSpecialChars(str);
            ArkAppInfo.ArkWhiteUrlItem arkWhiteUrlItem = new ArkAppInfo.ArkWhiteUrlItem();
            int indexOf = removeSpecialChars.indexOf("/");
            if (indexOf == -1) {
                substring = removeSpecialChars;
            } else {
                substring = removeSpecialChars.substring(0, indexOf);
            }
            arkWhiteUrlItem.ruleDomain = substring;
            if (indexOf == -1) {
                substring2 = "";
            } else {
                substring2 = removeSpecialChars.substring(indexOf, removeSpecialChars.length());
            }
            arkWhiteUrlItem.rulePath = substring2;
            return arkWhiteUrlItem;
        }
        return null;
    }

    public static String getAppConfigCacheKey(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        return str + "_" + str2;
    }

    public static ArkAppConfigMgr getInstance() {
        if (sInstance == null) {
            synchronized (ArkAppConfigMgr.class) {
                if (sInstance == null) {
                    sInstance = new ArkAppConfigMgr();
                }
            }
        }
        return sInstance;
    }

    private ArkAppInfo.AppConfig getLocalAppConfig(String str, String str2) {
        String str3;
        String appConfigCacheKey = getAppConfigCacheKey(str, str2);
        ArkAppInfo.AppConfig appConfig = null;
        if (TextUtils.isEmpty(appConfigCacheKey)) {
            Logger.logI(TAG, "ArkSafe.getLocalAppConfig,key=null");
            return null;
        }
        synchronized (lock) {
            IMMKV arkMMKV = MMKVManager.getInstance().getArkMMKV();
            if (arkMMKV != null) {
                str3 = arkMMKV.getString(MMKVUtils.fixAppConfigKey(appConfigCacheKey), null);
            } else {
                str3 = null;
            }
            if (!TextUtils.isEmpty(str3)) {
                try {
                    appConfig = convertJsonToConfig(new JSONObject(str3));
                    this.mAppConfigCache.put(appConfigCacheKey, appConfig);
                    if (appConfig.urlWhitelist != null) {
                        this.mAppUrlCheckerCache.put(appConfigCacheKey, new ArkAppUrlChecker(appConfig.urlWhitelist, this.mGlobalWhiteList, this.mGlobalBlackList));
                    }
                } catch (JSONException e16) {
                    Logger.logI(TAG, "getAppConfig, exception:", e16.toString());
                }
            }
        }
        checkAppIcon(str, str2, appConfig);
        Logger.logI(TAG, "ArkSafe.getLocalAppConfig, key=", appConfigCacheKey, ", localCfg=", str3, ", env=", printEnvString());
        return appConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String printEnvString() {
        if (ArkEnvironmentManager.getInstance().isTestEnv()) {
            return "Test";
        }
        return "Product";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processConfigWhiteList(String str, String str2) {
        ArkAppInfo.AppConfig appConfig;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            appConfig = convertJsonToConfig(new JSONObject(str2));
        } catch (JSONException e16) {
            Logger.logE(TAG, "ArkSafe.getAppConfig exception:", e16.toString());
            appConfig = null;
        }
        if (appConfig != null) {
            this.mAppConfigCache.put(str, appConfig);
            if (appConfig.urlWhitelist != null) {
                this.mAppUrlCheckerCache.put(str, new ArkAppUrlChecker(appConfig.urlWhitelist, this.mGlobalWhiteList, this.mGlobalBlackList));
            }
        }
    }

    public static String removeSpecialChars(String str) {
        if (str == null) {
            return "";
        }
        String trim = str.trim();
        if (TextUtils.isEmpty(trim)) {
            return trim;
        }
        if (trim.contains(QzoneWebViewOfflinePlugin.STR_DEVIDER)) {
            int indexOf = trim.indexOf(QzoneWebViewOfflinePlugin.STR_DEVIDER) + 3;
            if (indexOf > trim.length()) {
                indexOf = trim.length();
            }
            return trim.substring(indexOf);
        }
        return trim;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:114:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0149 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x01c9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x019c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void saveAppIconToFile(String str, String str2, boolean z16, byte[] bArr, DownloadIconTask downloadIconTask) {
        String str3;
        String str4;
        String appIconFilePath;
        FileOutputStream fileOutputStream;
        int i3 = 0;
        if (!z16) {
            Logger.logI(TAG, "ArkSafe.saveAppIconToFile return for success=false");
            if (downloadIconTask != null) {
                synchronized (this.mDownloadIconTaskList) {
                    this.mDownloadIconTaskList.remove(downloadIconTask.url);
                }
                while (i3 < downloadIconTask.callbackList.size()) {
                    IDownloadIconCallback iDownloadIconCallback = downloadIconTask.callbackList.get(i3);
                    if (iDownloadIconCallback != null) {
                        iDownloadIconCallback.onDownloadFinised(2, str, "");
                    }
                    i3++;
                }
                return;
            }
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            File file = new File(String.format("%s/%s", ArkEnvironmentManager.getInstance().getAppIconDirectory(), str));
            if (!file.exists()) {
                file.mkdirs();
            }
            appIconFilePath = getAppIconFilePath(str, str2);
            try {
                str4 = appIconFilePath + ICON_TEMP_FILE_SUFFIX;
            } catch (Exception e16) {
                e = e16;
                str4 = null;
            } catch (Throwable th5) {
                th = th5;
                str4 = null;
            }
            try {
                fileOutputStream = new FileOutputStream(str4);
            } catch (Exception e17) {
                e = e17;
                Exception exc = e;
                str3 = appIconFilePath;
                e = exc;
                try {
                    Logger.logI(TAG, "ArkSafe.saveAppIconToFile, exception:", e.toString());
                    if (fileOutputStream2 != null) {
                    }
                    if (downloadIconTask != null) {
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                            if (ArkUtil.rename(str4, str3)) {
                                if (downloadIconTask != null) {
                                    synchronized (this.mDownloadIconTaskList) {
                                        this.mDownloadIconTaskList.remove(downloadIconTask.url);
                                    }
                                    for (int i16 = 0; i16 < downloadIconTask.callbackList.size(); i16++) {
                                        IDownloadIconCallback iDownloadIconCallback2 = downloadIconTask.callbackList.get(i16);
                                        if (iDownloadIconCallback2 != null) {
                                            iDownloadIconCallback2.onDownloadFinised(1, str, str3);
                                        }
                                    }
                                    return;
                                }
                                return;
                            }
                            Logger.logI(TAG, "ArkSafe.saveAppIconToFile, rename iconUrl file iconUrl fail");
                        } catch (Exception e18) {
                            Logger.logI(TAG, "ArkSafe.saveAppIconToFile, exception:", e18.toString());
                            if (downloadIconTask == null) {
                            }
                        }
                    }
                    if (downloadIconTask == null) {
                        synchronized (this.mDownloadIconTaskList) {
                            this.mDownloadIconTaskList.remove(downloadIconTask.url);
                        }
                        while (i3 < downloadIconTask.callbackList.size()) {
                            IDownloadIconCallback iDownloadIconCallback3 = downloadIconTask.callbackList.get(i3);
                            if (iDownloadIconCallback3 != null) {
                                iDownloadIconCallback3.onDownloadFinised(2, str, "");
                            }
                            i3++;
                        }
                        throw th;
                    }
                    throw th;
                }
            } catch (Throwable th7) {
                th = th7;
                Throwable th8 = th;
                str3 = appIconFilePath;
                th = th8;
                if (fileOutputStream2 != null) {
                }
                if (downloadIconTask == null) {
                }
            }
        } catch (Exception e19) {
            e = e19;
            str3 = null;
            str4 = null;
        } catch (Throwable th9) {
            th = th9;
            str3 = null;
            str4 = null;
        }
        try {
            fileOutputStream.write(bArr);
            Logger.logI(TAG, "ArkSafe.saveAppIconToFile success app=", str, ", tempFilePath=", str4);
            try {
                fileOutputStream.close();
            } catch (Exception e26) {
                Logger.logI(TAG, "ArkSafe.saveAppIconToFile, exception:", e26.toString());
            }
            if (ArkUtil.rename(str4, appIconFilePath)) {
                if (downloadIconTask != null) {
                    synchronized (this.mDownloadIconTaskList) {
                        this.mDownloadIconTaskList.remove(downloadIconTask.url);
                    }
                    for (int i17 = 0; i17 < downloadIconTask.callbackList.size(); i17++) {
                        IDownloadIconCallback iDownloadIconCallback4 = downloadIconTask.callbackList.get(i17);
                        if (iDownloadIconCallback4 != null) {
                            iDownloadIconCallback4.onDownloadFinised(1, str, appIconFilePath);
                        }
                    }
                    return;
                }
                return;
            }
            Logger.logI(TAG, "ArkSafe.saveAppIconToFile, rename iconUrl file iconUrl fail");
            if (downloadIconTask != null) {
                synchronized (this.mDownloadIconTaskList) {
                    this.mDownloadIconTaskList.remove(downloadIconTask.url);
                }
                while (i3 < downloadIconTask.callbackList.size()) {
                    IDownloadIconCallback iDownloadIconCallback5 = downloadIconTask.callbackList.get(i3);
                    if (iDownloadIconCallback5 != null) {
                        iDownloadIconCallback5.onDownloadFinised(2, str, "");
                    }
                    i3++;
                }
            }
        } catch (Exception e27) {
            str3 = appIconFilePath;
            e = e27;
            fileOutputStream2 = fileOutputStream;
            Logger.logI(TAG, "ArkSafe.saveAppIconToFile, exception:", e.toString());
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                    if (ArkUtil.rename(str4, str3)) {
                        if (downloadIconTask != null) {
                            synchronized (this.mDownloadIconTaskList) {
                                this.mDownloadIconTaskList.remove(downloadIconTask.url);
                            }
                            for (int i18 = 0; i18 < downloadIconTask.callbackList.size(); i18++) {
                                IDownloadIconCallback iDownloadIconCallback6 = downloadIconTask.callbackList.get(i18);
                                if (iDownloadIconCallback6 != null) {
                                    iDownloadIconCallback6.onDownloadFinised(1, str, str3);
                                }
                            }
                            return;
                        }
                        return;
                    }
                    Logger.logI(TAG, "ArkSafe.saveAppIconToFile, rename iconUrl file iconUrl fail");
                } catch (Exception e28) {
                    Logger.logI(TAG, "ArkSafe.saveAppIconToFile, exception:", e28.toString());
                    if (downloadIconTask != null) {
                        synchronized (this.mDownloadIconTaskList) {
                            this.mDownloadIconTaskList.remove(downloadIconTask.url);
                        }
                        while (i3 < downloadIconTask.callbackList.size()) {
                            IDownloadIconCallback iDownloadIconCallback7 = downloadIconTask.callbackList.get(i3);
                            if (iDownloadIconCallback7 != null) {
                                iDownloadIconCallback7.onDownloadFinised(2, str, "");
                            }
                            i3++;
                        }
                        return;
                    }
                    return;
                }
            }
            if (downloadIconTask != null) {
            }
        } catch (Throwable th10) {
            str3 = appIconFilePath;
            th = th10;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
            }
            if (downloadIconTask == null) {
            }
        }
    }

    public boolean canCollect(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            Logger.logE(TAG, "ArkSafe.canCollect appName is empty return false");
            return false;
        }
        ArkAppInfo.AppConfig appConfig = getAppConfig(str, str2);
        if (appConfig == null) {
            Logger.logE(TAG, "ArkSafe.canCollect app:", str, ", bizSrc = ", str2, ",config is null return true");
            return true;
        }
        Logger.logI(TAG, "ArkSafe.canCollect app:", str, ",bizSrc:", str2, " ,canCollect = ", Integer.valueOf(appConfig.collect));
        if (appConfig.collect != 1) {
            return false;
        }
        return true;
    }

    public boolean canForward(String str, String str2, String str3) {
        boolean z16;
        boolean z17;
        boolean z18;
        if (TextUtils.isEmpty(str)) {
            Logger.logI(TAG, "ArkSafe.canForward appname is empty return false");
            return false;
        }
        ArkAppInfo.AppConfig appConfig = getAppConfig(str, str2);
        if (appConfig == null) {
            Logger.logI(TAG, "ArkSafe.canForward app:", str, ",config is null return true");
            return true;
        }
        ArrayList<String> arrayList = appConfig.forwardViews;
        if (arrayList != null && arrayList.size() != 0) {
            int i3 = 0;
            while (true) {
                if (i3 < appConfig.forwardViews.size()) {
                    String str4 = appConfig.forwardViews.get(i3);
                    if ("*".equals(str4)) {
                        z17 = false;
                        z16 = true;
                        break;
                    }
                    if (!TextUtils.isEmpty(str4) && str4.equals(str3)) {
                        z16 = false;
                        z17 = true;
                        break;
                    }
                    i3++;
                } else {
                    z16 = false;
                    z17 = false;
                    break;
                }
            }
            if (z16 || z17) {
                z18 = true;
            } else {
                z18 = false;
            }
            Logger.logI(TAG, "ArkSafe.canForward app:", str, ",view:", str3, ",canForward=", Boolean.valueOf(z18), ",allowAll:", Boolean.valueOf(z16), ",findView:", Boolean.valueOf(z17));
            return z18;
        }
        Logger.logI(TAG, "ArkSafe.canForward app:", str, ",config.forward view is null return true");
        return true;
    }

    public boolean canReply(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            Logger.logE(TAG, "ArkSafe.canReply appName is empty return false");
            return false;
        }
        ArkAppInfo.AppConfig appConfig = getAppConfig(str, str2);
        if (appConfig == null) {
            Logger.logE(TAG, "ArkSafe.canReply app:", str, ", bizSrc = ", str2, ",config is null return true");
            return true;
        }
        if (appConfig.replay != 1) {
            return false;
        }
        return true;
    }

    public void cleanAllConfig() {
        ArkDispatchTask.getInstance().postToArkThread(new Runnable() { // from class: com.tencent.ark.open.ArkAppConfigMgr.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (ArkAppConfigMgr.lock) {
                    ArkAppConfigMgr.this.mAppConfigCache.clear();
                    IMMKV arkMMKV = MMKVManager.getInstance().getArkMMKV();
                    if (arkMMKV != null) {
                        arkMMKV.clear();
                    }
                    ArkUtil.delete(ArkEnvironmentManager.getInstance().getAppIconDirectory(), false);
                }
                Logger.logI(ArkAppConfigMgr.TAG, "ArkSafe.cleanAllConfig, env=", ArkAppConfigMgr.this.printEnvString());
            }
        });
    }

    public void downloadAppIcon(final String str, final String str2, String str3, IDownloadIconCallback iDownloadIconCallback) {
        DownloadIconTask downloadIconTask;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            synchronized (this.mDownloadIconTaskList) {
                downloadIconTask = this.mDownloadIconTaskList.get(str3);
            }
            if (downloadIconTask != null) {
                downloadIconTask.callbackList.add(iDownloadIconCallback);
                Logger.logI(TAG, "ArkSafe.downloadAppIcon all ready in request app=", str);
                return;
            }
            DownloadIconTask downloadIconTask2 = new DownloadIconTask();
            downloadIconTask2.url = str3;
            downloadIconTask2.callbackList.add(iDownloadIconCallback);
            synchronized (this.mDownloadIconTaskList) {
                this.mDownloadIconTaskList.put(str3, downloadIconTask2);
            }
            ArkAppCGIMgr.getInstance().downloadAppIcon(str3, downloadIconTask2, new ArkAppCGIMgr.ArkAppCGICallback() { // from class: com.tencent.ark.open.ArkAppConfigMgr.3
                @Override // com.tencent.ark.open.internal.ArkAppCGIMgr.ArkAppCGICallback
                public void onDownloadAppIcon(boolean z16, byte[] bArr, Object obj) {
                    Logger.logI(ArkAppConfigMgr.TAG, "ArkSafe.onDownloadAppIcon,app=", str, ",sucess=", Boolean.valueOf(z16));
                    if (obj instanceof DownloadIconTask) {
                        ArkAppConfigMgr.this.saveAppIconToFile(str, str2, z16, bArr, (DownloadIconTask) obj);
                    }
                }
            });
            return;
        }
        Logger.logI(TAG, "ArkSafe.downloadAppIcon, app is null");
    }

    public ArkAppInfo.AppConfig getAppConfig(String str, String str2) {
        ArkAppInfo.AppConfig appConfig = null;
        if (!sEnableAppConfig) {
            Logger.logI(TAG, "ArkSafe.getAppConfig ServerConfig disable");
            return null;
        }
        String appConfigCacheKey = getAppConfigCacheKey(str, str2);
        synchronized (lock) {
            if (this.mAppConfigCache.containsKey(appConfigCacheKey)) {
                appConfig = this.mAppConfigCache.get(appConfigCacheKey);
            }
        }
        if (appConfig == null) {
            return getLocalAppConfig(str, str2);
        }
        return appConfig;
    }

    public long getAppConfigVersion(String str, String str2) {
        long j3 = 0;
        if (!sEnableAppConfig) {
            Logger.logI(TAG, "ArkSafe.getAppConfigVersion ServerConfig disable");
            return 0L;
        }
        ArkAppInfo.AppConfig appConfig = getAppConfig(str, str2);
        if (appConfig != null) {
            j3 = appConfig.ver;
        }
        Logger.logI(TAG, "ArkSafe.getAppConfigVersion app=", str, ", bizSrc=", str2, ", cfgver=", Long.valueOf(j3), ", env=", printEnvString());
        return j3;
    }

    public String getAppIconFilePath(String str, String str2) {
        ArkAppInfo.AppConfig appConfig = getAppConfig(str, str2);
        if (appConfig == null) {
            return null;
        }
        return ArkEnvironmentManager.getInstance().getAppIconDirectory() + "/" + str + "/" + appConfig.ver;
    }

    public ArkAppUrlChecker getUrlChecker(String str, String str2) {
        ArkAppInfo.AppConfig appConfig;
        ArkAppUrlChecker arkAppUrlChecker = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String appConfigCacheKey = getAppConfigCacheKey(str, str2);
        synchronized (lock) {
            if (this.mAppUrlCheckerCache.containsKey(appConfigCacheKey)) {
                arkAppUrlChecker = this.mAppUrlCheckerCache.get(appConfigCacheKey);
            }
            if (arkAppUrlChecker == null && (appConfig = getAppConfig(str, str2)) != null && appConfig.urlWhitelist != null) {
                arkAppUrlChecker = new ArkAppUrlChecker(appConfig.urlWhitelist, this.mGlobalWhiteList, this.mGlobalBlackList);
                this.mAppUrlCheckerCache.put(appConfigCacheKey, arkAppUrlChecker);
            }
        }
        return arkAppUrlChecker;
    }

    public boolean hasUrlChecker(String str, String str2) {
        if (getUrlChecker(str, str2) != null) {
            return true;
        }
        return false;
    }

    public void initConfig() {
        Logger.logI(TAG, "ArkSafe.initConfig, env=", printEnvString());
        ArkDispatchTask.getInstance().postToArkThread(new Runnable() { // from class: com.tencent.ark.open.ArkAppConfigMgr.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (ArkAppConfigMgr.lock) {
                    ArkAppConfigMgr.this.mAppConfigCache.clear();
                    IMMKV arkMMKV = MMKVManager.getInstance().getArkMMKV();
                    if (arkMMKV == null) {
                        return;
                    }
                    Set<String> appConfigKeySet = MMKVUtils.getAppConfigKeySet(arkMMKV);
                    if (appConfigKeySet == null) {
                        return;
                    }
                    for (String str : appConfigKeySet) {
                        ArkAppConfigMgr.this.processConfigWhiteList(str, arkMMKV.getString(MMKVUtils.fixAppConfigKey(str), ""));
                    }
                }
            }
        });
    }

    public void initGlobalWhiteListAndUrlCheckStatus(boolean z16, ArrayList<String> arrayList, ConcurrentHashMap<String, ArrayList<String>> concurrentHashMap) {
        String str;
        ArkAppInfo.ArkWhiteUrlItem convertWhiteUrlToItem;
        ArkAppInfo.ArkWhiteUrlItem convertWhiteUrlToItem2;
        Object[] objArr = new Object[4];
        objArr[0] = "ArkSafe.initGlobalWhiteListAndUrlCheckStatus.isUrlCheckEnable = ";
        objArr[1] = Boolean.valueOf(z16);
        objArr[2] = ",urlDisableAppList= ";
        if (arrayList != null) {
            str = arrayList.toString();
        } else {
            str = "null";
        }
        objArr[3] = str;
        Logger.logI(TAG, objArr);
        setUrlCheckEnable(z16, arrayList);
        if (concurrentHashMap != null) {
            ArrayList<String> arrayList2 = concurrentHashMap.get("white");
            if (arrayList2 != null) {
                ArrayList<ArkAppInfo.ArkWhiteUrlItem> arrayList3 = new ArrayList<>();
                Iterator<String> it = arrayList2.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!TextUtils.isEmpty(next) && (convertWhiteUrlToItem2 = convertWhiteUrlToItem(next)) != null) {
                        arrayList3.add(convertWhiteUrlToItem2);
                    }
                }
                if (arrayList3.size() > 0) {
                    synchronized (lock) {
                        this.mGlobalWhiteList = arrayList3;
                    }
                    Logger.logI(TAG, String.format("ArkSafe.initGlobalWhiteList white list:%s", arrayList3.toString()));
                }
            }
            ArrayList<String> arrayList4 = concurrentHashMap.get("black");
            if (arrayList4 != null) {
                ArrayList<ArkAppInfo.ArkWhiteUrlItem> arrayList5 = new ArrayList<>();
                Iterator<String> it5 = arrayList4.iterator();
                while (it5.hasNext()) {
                    String next2 = it5.next();
                    if (!TextUtils.isEmpty(next2) && (convertWhiteUrlToItem = convertWhiteUrlToItem(next2)) != null) {
                        arrayList5.add(convertWhiteUrlToItem);
                    }
                }
                if (arrayList5.size() > 0) {
                    synchronized (lock) {
                        this.mGlobalBlackList = arrayList5;
                    }
                    Logger.logI(TAG, String.format("ArkSafe.initGlobalWhiteList black list:%s", arrayList5.toString()));
                }
            }
        } else {
            Logger.logD(TAG, String.format("ArkSafe.app global white and black is null", new Object[0]));
        }
        initConfig();
    }

    public boolean isUrlCheckEnable(String str) {
        boolean z16;
        boolean z17;
        synchronized (this.mUrlDisableAppList) {
            z16 = false;
            if (!TextUtils.isEmpty(str) && this.mUrlDisableAppList.size() > 0 && this.mUrlDisableAppList.contains(str)) {
                Logger.logI(TAG, "ArkSafe.app.checkUrl.enable=false,app=", str);
                z17 = false;
            } else {
                z17 = true;
            }
            if (this.mUrlCheckEnable && z17) {
                z16 = true;
            }
        }
        return z16;
    }

    public void saveAppConfig(String str, String str2, ArkAppInfo.AppConfig appConfig) {
        if (!sEnableAppConfig) {
            Logger.logI(TAG, "ArkSafe.saveAppConfig ServerConfig disable");
            return;
        }
        if (!TextUtils.isEmpty(str) && appConfig != null) {
            synchronized (lock) {
                String appConfigCacheKey = getAppConfigCacheKey(str, str2);
                this.mAppConfigCache.put(appConfigCacheKey, appConfig);
                if (appConfig.urlWhitelist != null) {
                    this.mAppUrlCheckerCache.put(appConfigCacheKey, new ArkAppUrlChecker(appConfig.urlWhitelist, this.mGlobalWhiteList, this.mGlobalBlackList));
                } else {
                    this.mAppUrlCheckerCache.remove(appConfigCacheKey);
                }
                String convertConfigToJsonString = convertConfigToJsonString(appConfig);
                IMMKV arkMMKV = MMKVManager.getInstance().getArkMMKV();
                if (arkMMKV != null) {
                    arkMMKV.putString(MMKVUtils.fixAppConfigKey(appConfigCacheKey), convertConfigToJsonString);
                    MMKVUtils.addAppConfigKey2Set(arkMMKV, appConfigCacheKey);
                }
            }
        }
    }

    public void setUrlCheckEnable(boolean z16, ArrayList<String> arrayList) {
        this.mUrlCheckEnable = z16;
        this.mUrlDisableAppList = arrayList;
        Logger.logI(TAG, "ArkSafe.setUrlCheckEnable global=", Boolean.valueOf(z16));
    }

    public void updateUrlCheckAndCleanAppUpdateTime(boolean z16, ArrayList<String> arrayList, List<ArkAppElement> list) {
        String str;
        Object[] objArr = new Object[4];
        objArr[0] = "ArkSafe.updateUrlCheckAndCleanAppUpdateTimeisUrlCheckEnable = ";
        objArr[1] = Boolean.valueOf(z16);
        objArr[2] = ",urlDisableAppList= ";
        if (arrayList != null) {
            str = arrayList.toString();
        } else {
            str = "null";
        }
        objArr[3] = str;
        Logger.logI(TAG, objArr);
        setUrlCheckEnable(z16, arrayList);
        if (list != null && list.size() > 0) {
            boolean z17 = false;
            for (ArkAppElement arkAppElement : list) {
                String str2 = arkAppElement.appName;
                String str3 = arkAppElement.bizSrc;
                if (!TextUtils.isEmpty(str2)) {
                    Logger.logI(TAG, "ArkSafe.updateUrlCheckAndCleanAppUpdateTime get config clean app=", str2, ", bizSrc = " + str3);
                    if (AppUpdateManager.isAppUpdateBefore(str2, str3)) {
                        Logger.logI(TAG, "ArkSafe.updateUrlCheckAndCleanAppUpdateTime force clean update time app =", str2, ", bizSrc = " + str3);
                        AppUpdateManager.putAppUpdateTime(str2, str3, 0L);
                        z17 = true;
                    }
                }
            }
            if (z17) {
                Logger.logI(TAG, "ArkSafe.updateUrlCheckAndCleanAppUpdateTime force clean global");
                AppUpdateManager.getInstance().clearGlobalUpdateTime();
            }
        }
    }
}
