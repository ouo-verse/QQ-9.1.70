package com.tencent.mobileqq.mini.apkg;

import android.text.TextUtils;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QUA;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes33.dex */
public abstract class ApkgBaseInfo {
    private static final String CONFIG_SPLIT = ";";
    public static final int DOMIAN_TYPE_DOWNLOAD = 2;
    public static final int DOMIAN_TYPE_REQUEST = 0;
    public static final int DOMIAN_TYPE_UDP = 5;
    public static final int DOMIAN_TYPE_UPLOAD = 3;
    public static final int DOMIAN_TYPE_WEBSOCKET = 1;
    public static final int DOMIAN_TYPE_WEBVIEW = 4;
    private static String mCurWhiteListConfig;
    public String apkgFolderPath;
    public String apkgName;
    public MiniAppConfig appConfig;
    public String appId;
    public String iconUrl;
    private ConcurrentHashMap<Integer, ArrayList<DomainConfig>> mCachedDomainConfigMap;
    public String mConfigStr;
    private volatile Set<String> mUdpIpWhiteSet;
    private static final String[] DOMAIN_NAME_LIST = {"Request", "Websocket", "Download", "Upload", QzoneCoverConst.CoverStringType.COVER_TYPE_WEBVIEW_COVER_PREFIX, "UDP"};
    private static ArrayList<String> sDominWhiteList = null;
    public static boolean isRdmBuild = QUA.getQUA3().toLowerCase().contains("rdm");

    public ApkgBaseInfo(String str, MiniAppConfig miniAppConfig) {
        this.apkgFolderPath = str;
        MiniAppInfo miniAppInfo = miniAppConfig.config;
        this.appId = miniAppInfo.appId;
        this.apkgName = miniAppInfo.name;
        this.iconUrl = miniAppInfo.iconUrl;
        this.appConfig = miniAppConfig;
    }

    private static ArrayList<String> getDomainWhiteList() {
        String config;
        synchronized (ApkgInfo.class) {
            if (sDominWhiteList == null && (config = QzoneConfig.getInstance().getConfig("qqminiapp", "defaultAllowedHostList", QzoneConfig.DEFAULT_DOMAIN_WHITE_LIST)) != null && !config.equals(mCurWhiteListConfig)) {
                QLog.i(GameLog.MINIHTTP_TAG, 1, "Default white domain:" + config);
                sDominWhiteList = new ArrayList<>();
                try {
                    String[] split = config.split(";");
                    if (split != null) {
                        for (String str : split) {
                            if (!TextUtils.isEmpty(str)) {
                                sDominWhiteList.add(str);
                            }
                        }
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
                mCurWhiteListConfig = config;
            }
        }
        return sDominWhiteList;
    }

    private boolean isOnlineVersion() {
        MiniAppInfo miniAppInfo;
        MiniAppConfig miniAppConfig = this.appConfig;
        return (miniAppConfig == null || (miniAppInfo = miniAppConfig.config) == null || miniAppInfo.verType != 3) ? false : true;
    }

    public String getApkgFolderPath() {
        return this.apkgFolderPath;
    }

    public boolean getEnableDebug() {
        return StorageUtil.getPreference().getBoolean(this.appId + "_debug", false);
    }

    public String getFilePath(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new File(getRootPath(), str).getAbsolutePath();
    }

    public String getRootPath() {
        return this.apkgFolderPath;
    }

    public abstract String getRootPath(String str);

    public abstract String getWorkerPath(String str, String str2);

    public abstract void init(String str);

    public boolean isDomainValid(boolean z16, String str, final int i3) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (z16) {
            QLog.d("[mini] http.domainValid", 1, DOMAIN_NAME_LIST[i3] + ":\u57df\u540d\u68c0\u67e5 skipDomainCheckFromJs:" + str);
            return true;
        }
        if (this.appConfig.config.skipDomainCheck == 1) {
            QLog.d("[mini] http.domainValid", 1, DOMAIN_NAME_LIST[i3] + ":\u57df\u540d\u68c0\u67e5 skip:" + str);
            return true;
        }
        final String lowerCase = str.toLowerCase();
        if (!isOnlineVersion() && getEnableDebug()) {
            if (!isValidPrefix(lowerCase, true)) {
                QLog.d("[mini] http.domainValid", 1, DOMAIN_NAME_LIST[i3] + "\u57df\u540d\u4e0d\u5408\u6cd5\uff0c\u9700\u4f7f\u7528https\u6216wss\u534f\u8bae:" + str);
                return false;
            }
            QLog.d("[mini] http.domainValid", 1, "debug opened and not online version, skip:" + str);
            return true;
        }
        if (isRdmBuild && str.startsWith(QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppRMDDomainWhiteList", "https://www.urlshare.cn/"))) {
            QLog.d("[mini] http.domainValid", 1, "rdm mode, https://www.urlshare.cn/ is valid, current Url is: " + str);
            return true;
        }
        if (!isValidPrefix(lowerCase, i3 == 4)) {
            StringBuilder sb5 = new StringBuilder();
            String[] strArr = DOMAIN_NAME_LIST;
            sb5.append(strArr[i3]);
            sb5.append(":\u8bf7\u6c42\u57df\u540d\u4e0d\u5408\u6cd5\uff0c\u8bf7\u4f7f\u7528https\u6216wss\u534f\u8bae,reqeustUrl:");
            sb5.append(str);
            QLog.e("[mini] http.domainValid", 1, sb5.toString());
            if (!isOnlineVersion()) {
                GameLog.vconsoleLog(strArr[i3] + "\u57df\u540d\u4e0d\u5408\u6cd5\uff0c\u9700\u4f7f\u7528https\u6216wss\u534f\u8bae:" + lowerCase);
                AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.mini.apkg.ApkgBaseInfo.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QQToast.makeText(BaseApplication.getContext(), ApkgBaseInfo.DOMAIN_NAME_LIST[i3] + HardCodeUtil.qqStr(R.string.jeq) + lowerCase, 1).show();
                    }
                });
            }
            return false;
        }
        final DomainConfig domainConfig = DomainConfig.getDomainConfig(lowerCase);
        if (isDomainConfigCached(domainConfig, i3)) {
            return true;
        }
        if (domainConfig != null && !TextUtils.isEmpty(domainConfig.host)) {
            MiniAppInfo miniAppInfo = this.appConfig.config;
            if (miniAppInfo != null) {
                List<String> list = miniAppInfo.requestDomainList;
                if (i3 == 1) {
                    list = miniAppInfo.socketDomainList;
                } else if (i3 == 2) {
                    list = miniAppInfo.downloadFileDomainList;
                } else if (i3 == 3) {
                    list = miniAppInfo.uploadFileDomainList;
                } else if (i3 == 4) {
                    list = miniAppInfo.businessDomainList;
                }
                if (list != null) {
                    for (String str2 : list) {
                        try {
                            if (!TextUtils.isEmpty(str2)) {
                                DomainConfig domainConfig2 = DomainConfig.getDomainConfig(str2.toLowerCase(), true);
                                if (DomainConfig.isDomainConfigMatch(domainConfig2, domainConfig)) {
                                    putDomainConfigToCache(domainConfig, i3);
                                    return true;
                                }
                                QLog.i("[mini] http.domainValid", 1, "request:" + domainConfig + ",allow:" + domainConfig2);
                            }
                        } catch (Throwable th5) {
                            QLog.e("[mini] http.domainValid", 1, "check domainValid error, requestUrl:" + str, th5);
                        }
                    }
                }
            }
            try {
                Iterator<String> it = getDomainWhiteList().iterator();
                while (it.hasNext()) {
                    if (DomainConfig.isDomainMatchRfc2019(it.next(), domainConfig)) {
                        putDomainConfigToCache(domainConfig, i3);
                        return true;
                    }
                }
            } catch (Throwable th6) {
                QLog.e("[mini] http.domainValid", 1, "check domainValid error, requestUrl:" + str, th6);
            }
        }
        StringBuilder sb6 = new StringBuilder();
        String[] strArr2 = DOMAIN_NAME_LIST;
        sb6.append(strArr2[i3]);
        sb6.append(":Invalid domain, please config requestUrl: ");
        sb6.append(str);
        GameLog.vconsoleLog(sb6.toString());
        QLog.e("[mini] http.domainValid", 1, strArr2[i3] + ":Invalid domain, please config requestUrl: " + str);
        if (!isOnlineVersion()) {
            GameLog.vconsoleLog(strArr2[i3] + " invalid domain, please config " + domainConfig);
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.mini.apkg.ApkgBaseInfo.2
                @Override // java.lang.Runnable
                public void run() {
                    QQToast.makeText(BaseApplication.getContext(), ApkgBaseInfo.DOMAIN_NAME_LIST[i3] + HardCodeUtil.qqStr(R.string.jep) + domainConfig, 1).show();
                }
            });
        }
        return false;
    }

    public boolean isEngineTypeMiniApp() {
        MiniAppInfo miniAppInfo;
        MiniAppConfig miniAppConfig = this.appConfig;
        if (miniAppConfig == null || (miniAppInfo = miniAppConfig.config) == null) {
            return false;
        }
        return miniAppInfo.isEngineTypeMiniApp();
    }

    public boolean isEngineTypeMiniGame() {
        MiniAppInfo miniAppInfo;
        MiniAppConfig miniAppConfig = this.appConfig;
        if (miniAppConfig == null || (miniAppInfo = miniAppConfig.config) == null) {
            return false;
        }
        return miniAppInfo.isEngineTypeMiniGame();
    }

    public boolean isUdpIpValid(final String str) {
        MiniAppInfo miniAppInfo;
        MiniAppConfig miniAppConfig = this.appConfig;
        if (miniAppConfig == null || (miniAppInfo = miniAppConfig.config) == null) {
            return false;
        }
        if (miniAppInfo.skipDomainCheck == 1) {
            QLog.d("[mini] http.udp", 1, "udp ip\u68c0\u67e5 skip: " + str);
            return true;
        }
        if (this.mUdpIpWhiteSet == null) {
            synchronized (this) {
                if (this.mUdpIpWhiteSet == null) {
                    this.mUdpIpWhiteSet = new HashSet(this.appConfig.config.udpIpList);
                }
            }
        }
        boolean contains = this.mUdpIpWhiteSet.contains(str);
        if (contains || isOnlineVersion() || !getEnableDebug()) {
            return contains;
        }
        QLog.d("[mini] http.udp", 1, "debug opened and not online version, skip:" + str);
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.mini.apkg.ApkgBaseInfo.3
            @Override // java.lang.Runnable
            public void run() {
                QQToast.makeText(BaseApplication.getContext(), ApkgBaseInfo.DOMAIN_NAME_LIST[5] + HardCodeUtil.qqStr(R.string.jep) + str, 1).show();
            }
        });
        return true;
    }

    public abstract boolean isUrlResReady(String str);

    public boolean isValidPrefix(String str, boolean z16) {
        return z16 ? !TextUtils.isEmpty(str) && (str.startsWith("https://") || str.startsWith("wss://") || str.startsWith("ws://") || str.startsWith("http://")) : !TextUtils.isEmpty(str) && (str.startsWith("https://") || str.startsWith("wss://"));
    }

    public String toString() {
        return "appId:" + this.appId + ", name:" + this.apkgName;
    }

    public static String normalize(String str) {
        if (str == null) {
            return str;
        }
        int indexOf = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        if (indexOf == -1) {
            indexOf = str.length();
        }
        return str.substring(0, indexOf);
    }

    private void putDomainConfigToCache(DomainConfig domainConfig, int i3) {
        if (domainConfig == null) {
            return;
        }
        if (this.mCachedDomainConfigMap == null) {
            this.mCachedDomainConfigMap = new ConcurrentHashMap<>();
        }
        ArrayList<DomainConfig> arrayList = this.mCachedDomainConfigMap.get(Integer.valueOf(i3));
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.mCachedDomainConfigMap.put(Integer.valueOf(i3), arrayList);
        }
        if (arrayList.contains(domainConfig)) {
            return;
        }
        arrayList.add(domainConfig);
    }

    private boolean isDomainConfigCached(DomainConfig domainConfig, int i3) {
        ConcurrentHashMap<Integer, ArrayList<DomainConfig>> concurrentHashMap;
        ArrayList<DomainConfig> arrayList;
        return (domainConfig == null || (concurrentHashMap = this.mCachedDomainConfigMap) == null || (arrayList = concurrentHashMap.get(Integer.valueOf(i3))) == null || !arrayList.contains(domainConfig)) ? false : true;
    }
}
