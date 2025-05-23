package com.tencent.qqmini.sdk.utils;

import android.text.TextUtils;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.DomainConfig;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.FastClickUtils;
import com.tencent.qqmini.sdk.widget.MiniToast;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes23.dex */
public class DomainUtil {
    private static final String CONFIG_SPLIT = ";";
    public static final int DOMAIN_TYPE_DOWNLOAD = 2;
    public static final int DOMAIN_TYPE_DUP = 5;
    public static final int DOMAIN_TYPE_REQUEST = 0;
    public static final int DOMAIN_TYPE_UPLOAD = 3;
    public static final int DOMAIN_TYPE_WEBSOCKET = 1;
    public static final int DOMAIN_TYPE_WEBVIEW = 4;
    private static final String TAG = "[mini] http.domainValid";
    private static ConcurrentHashMap<Integer, ArrayList<DomainConfig>> mCachedDomainConfigMap;
    private static String mCurWhiteListConfig;
    private static final String[] DOMAIN_NAME_LIST = {"Request", "Websocket", "Download", "Upload", QzoneCoverConst.CoverStringType.COVER_TYPE_WEBVIEW_COVER_PREFIX, "UDP"};
    private static ArrayList<String> sDominWhiteList = null;

    private static boolean checkAppConfig(MiniAppInfo miniAppInfo, String str, int i3, DomainConfig domainConfig) {
        if (domainConfig != null && !TextUtils.isEmpty(domainConfig.host) && miniAppInfo != null) {
            List<String> list = miniAppInfo.requestDomainList;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 == 5) {
                                list = miniAppInfo.udpIpList;
                            }
                        } else {
                            list = miniAppInfo.businessDomainList;
                        }
                    } else {
                        list = miniAppInfo.uploadFileDomainList;
                    }
                } else {
                    list = miniAppInfo.downloadFileDomainList;
                }
            } else {
                list = miniAppInfo.socketDomainList;
            }
            if (list != null) {
                for (String str2 : list) {
                    try {
                        if (!TextUtils.isEmpty(str2)) {
                            DomainConfig domainConfig2 = DomainConfig.getDomainConfig(str2.toLowerCase());
                            if (DomainConfig.isDomainConfigMatch(domainConfig2, domainConfig)) {
                                putDomainConfigToCache(domainConfig, i3);
                                return true;
                            }
                            QMLog.i(TAG, "request:" + domainConfig + ",allow:" + domainConfig2);
                        }
                    } catch (Throwable th5) {
                        QMLog.e(TAG, "check domainValid error, requestUrl:" + str, th5);
                    }
                }
                return false;
            }
            return false;
        }
        return false;
    }

    private static boolean checkIsReportDomain(String str) {
        if ((QUAUtil.isRdmBuild() || ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).isDebugVersion()) && str.startsWith(WnsConfig.getConfig("qqminiapp", "MiniAppRMDDomainWhiteList", "https://www.urlshare.cn/"))) {
            QMLog.d(TAG, "rdm mode, https://www.urlshare.cn/ is valid, current Url is: " + str);
            return true;
        }
        return false;
    }

    private static boolean checkProtocol(MiniAppInfo miniAppInfo, String str, final int i3, final String str2) {
        boolean z16;
        if (!needCheckProtocol(i3)) {
            return false;
        }
        if (i3 == 4) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (isValidPrefix(str2, z16)) {
            return false;
        }
        QMLog.e(TAG, DOMAIN_NAME_LIST[i3] + ":\u8bf7\u6c42\u57df\u540d\u4e0d\u5408\u6cd5\uff0c\u8bf7\u4f7f\u7528https\u6216wss\u534f\u8bae,reqeustUrl:" + str);
        if (!isOnlineVersion(miniAppInfo)) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.utils.DomainUtil.3
                @Override // java.lang.Runnable
                public void run() {
                    MiniToast.makeText(AppLoaderFactory.g().getContext(), DomainUtil.DOMAIN_NAME_LIST[i3] + "\u57df\u540d\u4e0d\u5408\u6cd5\uff0c\u9700\u4f7f\u7528https\u6216wss\u534f\u8bae:" + str2, 1).show();
                }
            });
        }
        return true;
    }

    @Nullable
    private static Boolean checkVersionAndDebug(MiniAppInfo miniAppInfo, String str, int i3, String str2) {
        if (!isOnlineVersion(miniAppInfo) && getEnableDebug(miniAppInfo.appId)) {
            if (!isValidPrefix(str2, true)) {
                QMLog.d(TAG, DOMAIN_NAME_LIST[i3] + "\u57df\u540d\u4e0d\u5408\u6cd5\uff0c\u9700\u4f7f\u7528https\u6216wss\u534f\u8bae:" + str);
                return Boolean.FALSE;
            }
            QMLog.d(TAG, "debug opened and not online version, skip:" + str);
            return Boolean.TRUE;
        }
        return null;
    }

    private static boolean checkWnsConfig(String str, int i3, DomainConfig domainConfig) {
        try {
            Iterator<String> it = getDomainWhiteList().iterator();
            while (it.hasNext()) {
                if (DomainConfig.isDomainMatchRfc2019(it.next(), domainConfig)) {
                    putDomainConfigToCache(domainConfig, i3);
                    return true;
                }
            }
            return false;
        } catch (Throwable th5) {
            QMLog.e(TAG, "check domainValid error, requestUrl:" + str, th5);
            return false;
        }
    }

    private static ArrayList<String> getDomainWhiteList() {
        String config;
        synchronized (DomainUtil.class) {
            if (sDominWhiteList == null && (config = WnsConfig.getConfig("qqminiapp", "defaultAllowedHostList", WnsConfig.DEFAULT_DOMAIN_WHITE_LIST)) != null && !config.equals(mCurWhiteListConfig)) {
                QMLog.i(TAG, "Default white domain:" + config);
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

    public static boolean getEnableDebug(String str) {
        return DebugUtil.getDebugEnabled(str);
    }

    private static boolean isDomainConfigCached(DomainConfig domainConfig, int i3) {
        ConcurrentHashMap<Integer, ArrayList<DomainConfig>> concurrentHashMap;
        ArrayList<DomainConfig> arrayList;
        if (domainConfig != null && (concurrentHashMap = mCachedDomainConfigMap) != null && (arrayList = concurrentHashMap.get(Integer.valueOf(i3))) != null) {
            try {
                if (arrayList.contains(domainConfig)) {
                    return true;
                }
            } catch (ArrayIndexOutOfBoundsException e16) {
                QMLog.e(TAG, "isDomainConfigCached: failed.", e16);
            }
        }
        return false;
    }

    public static boolean isDomainValid(MiniAppInfo miniAppInfo, boolean z16, String str, final int i3) {
        boolean z17;
        if (!TextUtils.isEmpty(str) && miniAppInfo != null) {
            if (z16) {
                QMLog.d(TAG, DOMAIN_NAME_LIST[i3] + ":\u57df\u540d\u68c0\u67e5 skipDomainCheckFromJs:" + str);
                return true;
            }
            if (miniAppInfo.isEngineTypeMiniGame()) {
                return isMiniGameValid(miniAppInfo, str, i3);
            }
            if (miniAppInfo.skipDomainCheck == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                QMLog.d(TAG, DOMAIN_NAME_LIST[i3] + ":\u57df\u540d\u68c0\u67e5 skip:" + str);
                return true;
            }
            String lowerCase = str.toLowerCase();
            Boolean checkVersionAndDebug = checkVersionAndDebug(miniAppInfo, str, i3, lowerCase);
            if (checkVersionAndDebug != null) {
                return checkVersionAndDebug.booleanValue();
            }
            if (checkIsReportDomain(str)) {
                return true;
            }
            if (checkProtocol(miniAppInfo, str, i3, lowerCase)) {
                return false;
            }
            final DomainConfig domainConfig = DomainConfig.getDomainConfig(lowerCase);
            if (isDomainConfigCached(domainConfig, i3) || checkAppConfig(miniAppInfo, str, i3, domainConfig) || checkWnsConfig(str, i3, domainConfig)) {
                return true;
            }
            if (!FastClickUtils.isFastDoubleClick(TAG, 500L)) {
                QMLog.e(TAG, DOMAIN_NAME_LIST[i3] + ":\u8bf7\u6c42\u57df\u540d\u4e0d\u5408\u6cd5\uff0c\u8bf7\u914d\u7f6e\uff0crequestUrl:" + str);
            }
            if (!isOnlineVersion(miniAppInfo)) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.utils.DomainUtil.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MiniToast.makeText(AppLoaderFactory.g().getContext(), DomainUtil.DOMAIN_NAME_LIST[i3] + "\u57df\u540d\u4e0d\u5408\u6cd5\uff0c\u8bf7\u914d\u7f6e\uff1a" + domainConfig, 1).show();
                    }
                });
            }
            return false;
        }
        QMLog.e(TAG, "url or appcconfig is null. url : " + str + "; appconfig : " + miniAppInfo);
        return false;
    }

    public static boolean isMiniGameValid(MiniAppInfo miniAppInfo, String str, final int i3) {
        if (miniAppInfo.skipDomainCheck == 1) {
            return true;
        }
        final String lowerCase = str.toLowerCase();
        if (checkProtocol(miniAppInfo, str, i3, lowerCase)) {
            return false;
        }
        DomainConfig domainConfig = DomainConfig.getDomainConfig(lowerCase);
        if (isDomainConfigCached(domainConfig, i3) || checkAppConfig(miniAppInfo, str, i3, domainConfig) || checkWnsConfig(str, i3, domainConfig)) {
            return true;
        }
        if (isNeedShowDomainInvalidToast(miniAppInfo)) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.utils.DomainUtil.2
                @Override // java.lang.Runnable
                public void run() {
                    MiniToast.makeText(AppLoaderFactory.g().getContext(), DomainUtil.DOMAIN_NAME_LIST[i3] + "\u57df\u540d\u4e0d\u5408\u6cd5\uff0c\u9700\u4f7f\u7528https\u6216wss\u534f\u8bae:" + lowerCase, 1).show();
                }
            });
        }
        MiniLog.consoleLog(miniAppInfo, DOMAIN_NAME_LIST[i3] + "\u57df\u540d\u4e0d\u5408\u6cd5\uff0c \u8bf7\u914d\u7f6e\uff1a" + domainConfig);
        if (miniAppInfo.verType != 4) {
            return false;
        }
        MiniLog.consoleLog(miniAppInfo, "\u57df\u540d\u4e0d\u5408\u6cd5\u5728\u8c03\u8bd5\u671f\u95f4\u653e\u5f00\u9650\u5236\uff0c\u8bf7\u5c3d\u5feb\u5728\u7ba1\u7406\u7aef\u914d\u7f6e\u767d\u540d\u5355\u3002");
        return true;
    }

    private static boolean isNeedShowDomainInvalidToast(MiniAppInfo miniAppInfo) {
        int i3;
        if (miniAppInfo.skipDomainCheck == 1 || (i3 = miniAppInfo.verType) == 3 || i3 == 4) {
            return false;
        }
        return true;
    }

    private static boolean isOnlineVersion(MiniAppInfo miniAppInfo) {
        if (miniAppInfo != null && miniAppInfo.verType == 3) {
            return true;
        }
        return false;
    }

    private static boolean isValidPrefix(String str, boolean z16) {
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("https://") || str.startsWith("wss://")) {
                return true;
            }
            if (z16) {
                if (str.startsWith("http://") || str.startsWith("ws://")) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    private static boolean needCheckProtocol(int i3) {
        if (i3 != 5) {
            return true;
        }
        return false;
    }

    private static void putDomainConfigToCache(DomainConfig domainConfig, int i3) {
        if (domainConfig == null) {
            return;
        }
        if (mCachedDomainConfigMap == null) {
            mCachedDomainConfigMap = new ConcurrentHashMap<>();
        }
        ArrayList<DomainConfig> arrayList = mCachedDomainConfigMap.get(Integer.valueOf(i3));
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            mCachedDomainConfigMap.put(Integer.valueOf(i3), arrayList);
        }
        if (!arrayList.contains(domainConfig)) {
            arrayList.add(domainConfig);
        }
    }
}
