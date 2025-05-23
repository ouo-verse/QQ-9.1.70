package com.tencent.qqmini.sdk.auth;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.luggage.wxa.ff.e;
import com.tencent.luggage.wxa.ff.f;
import com.tencent.mm.plugin.appbrand.jsapi.live.c;
import com.tencent.mm.plugin.appbrand.jsapi.live.d;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst;
import com.tencent.qqmini.minigame.plugins.RaffleJsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.AppMode;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.SecondApiRightInfo;
import com.tencent.qqmini.sdk.plugins.OpenDataCommonJsPlugin;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public class AuthFilterList {
    private static final String CONFIG_SPLIT = ",";
    public static final int EVENT_BLACK = 0;
    public static final int EVENT_WHITE = 1;
    public static final int SECONDARY_API_BLACK = -1;
    public static final int SECONDARY_API_WHITE = 1;
    private static final String TAG = "AuthFilterList";
    private static String sCurAppWhiteListConfig;
    private static List<String> sAppWhiteList = new ArrayList();
    private static List<String> sEventLocalBlackList = new ArrayList();
    private static Map<String, Integer> sEventRemoteList = new HashMap();
    private static final List<String> sEventLocalFriendshipBlackList = new ArrayList();
    private static Map<String, Map<String, Integer>> sEventLocalSecondaryApiMap = new HashMap();
    private static HashMap<String, HashMap<String, Integer>> sEventRemoteSecondaryApiMap = new HashMap<>();

    static {
        initAppWhiteList();
        initEventLocalBlackList();
        initEventSecondaryApiList();
        initEventLocalFriendshipBlackList();
    }

    public static boolean apiAuthoritySilent(MiniAppInfo miniAppInfo) {
        QQCustomizedProxy qQCustomizedProxy = (QQCustomizedProxy) ProxyManager.get(QQCustomizedProxy.class);
        if (qQCustomizedProxy != null && qQCustomizedProxy.isCustomMiniGame(miniAppInfo)) {
            return true;
        }
        if (miniAppInfo != null) {
            AppMode appMode = miniAppInfo.appMode;
            if (appMode != null && appMode.unlimitedApiRight) {
                return true;
            }
            if (appMode != null && appMode.authoritySilent) {
                return true;
            }
        }
        return false;
    }

    private static void initAppWhiteList() {
        synchronized (sAppWhiteList) {
            String config = WnsConfig.getConfig("qqminiapp", WnsConfig.SECONDARY_MINI_APP_AUTH_WHITELIST, "1108292102");
            if (config != null && !config.equals(sCurAppWhiteListConfig)) {
                sAppWhiteList.clear();
                try {
                    String[] split = config.split(",");
                    if (split != null) {
                        for (String str : split) {
                            if (!StringUtil.isEmpty(str)) {
                                sAppWhiteList.add(str);
                            }
                        }
                    }
                } catch (Throwable th5) {
                    QMLog.e(TAG, "initAuthWhiteList error,", th5);
                }
                sCurAppWhiteListConfig = config;
            }
        }
    }

    private static void initEventLocalBlackList() {
        synchronized (sEventLocalBlackList) {
            sEventLocalBlackList.clear();
            sEventLocalBlackList.add("requestPayment");
            sEventLocalBlackList.add("requestQQPayment");
            sEventLocalBlackList.add(PluginConst.PayJsPluginConst.API_REQUEST_MIDAS_PAYMENT);
            sEventLocalBlackList.add(PluginConst.PayJsPluginConst.API_REQUEST_WX_PAYMENT);
            sEventLocalBlackList.add("requestPaymentToBank");
            sEventLocalBlackList.add("requestCloudGamePay");
            sEventLocalBlackList.add("getCloudGamePayOpenId");
            sEventLocalBlackList.add("reportSubmitForm");
            sEventLocalBlackList.add("insertHTMLWebView");
            sEventLocalBlackList.add("updateHTMLWebView");
            sEventLocalBlackList.add("removeHTMLWebView");
            sEventLocalBlackList.add("onWebInvokeAppService");
            sEventLocalBlackList.add("insertLivePusher");
            sEventLocalBlackList.add(d.NAME);
            sEventLocalBlackList.add(e.NAME);
            sEventLocalBlackList.add(c.NAME);
            sEventLocalBlackList.add("onLivePusherEvent");
            sEventLocalBlackList.add("onLivePusherNetStatus");
            sEventLocalBlackList.add("insertLivePlayer");
            sEventLocalBlackList.add(f.NAME);
            sEventLocalBlackList.add(com.tencent.luggage.wxa.ff.d.NAME);
            sEventLocalBlackList.add(com.tencent.luggage.wxa.ff.c.NAME);
            sEventLocalBlackList.add("onLivePlayerEvent");
            sEventLocalBlackList.add("onLivePlayerFullScreenChange");
            sEventLocalBlackList.add("onLivePlayerNetStatus");
            sEventLocalBlackList.add("insertXWebLivePlayer");
            sEventLocalBlackList.add("updateXWebLivePlayer");
            sEventLocalBlackList.add("removeXWebLivePlayer");
            sEventLocalBlackList.add("operateXWebLivePlayer");
            sEventLocalBlackList.add("insertXWebLivePusher");
            sEventLocalBlackList.add("updateXWebLivePusher");
            sEventLocalBlackList.add("removeXWebLivePusher");
            sEventLocalBlackList.add("operateXWebLivePusher");
            sEventLocalBlackList.add("shareAppPictureMessage");
            sEventLocalBlackList.add("shareAppPictureMessageDirectly");
            sEventLocalBlackList.add("getPhoneNumber");
            sEventLocalBlackList.add("wnsRequest");
            sEventLocalBlackList.add("getQua");
            sEventLocalBlackList.add("notifyNative");
            sEventLocalBlackList.add("openUrl");
            sEventLocalBlackList.add(PluginConst.DataJsPluginConst.PRIVATE_API_GET_NATIVE_USER_INFO_EXTRA);
            sEventLocalBlackList.add(PluginConst.SchemeJsPluginConst.API_OPEN_SCHEME);
            sEventLocalBlackList.add("Personalize");
            sEventLocalBlackList.add("invokeNativePlugin");
            sEventLocalBlackList.add("wnsRequest");
            sEventLocalBlackList.add("wnsGroupRequest");
            sEventLocalBlackList.add("wnsGuildRequest");
            sEventLocalBlackList.add(PluginConst.DataJsPluginConst.API_GET_GROUP_INFO_EXTRA);
            sEventLocalBlackList.add("downloadTbsX5");
            sEventLocalBlackList.add("startDownloadAppTask");
            sEventLocalBlackList.add("cancelDownloadAppTask");
            sEventLocalBlackList.add("queryDownloadAppTask");
            sEventLocalBlackList.add(PluginConst.OtherJsPluginConst.API_QUERY_APP_INFO);
            sEventLocalBlackList.add("installApp");
            sEventLocalBlackList.add("startApp");
            sEventLocalBlackList.add(WadlProxyConsts.REMOTE_CMD_SET_SPEED_BUFFER);
            sEventLocalBlackList.add(PluginConst.DataJsPluginConst.API_BOOKSHELF_INSERT);
            sEventLocalBlackList.add("queryBookshelf");
            sEventLocalBlackList.add("updateBookshelfReadTime");
            sEventLocalBlackList.add("navigateToBookshelf");
            sEventLocalBlackList.add("addRecentColorSign");
            sEventLocalBlackList.add("detectAbnormalLog");
            sEventLocalBlackList.add(RaffleJsPlugin.EVENT_START_RAFFLE);
            sEventLocalBlackList.add("preloadPackage");
            sEventLocalBlackList.add("getQimei36");
            sEventLocalBlackList.add("toggleSecureWindow");
            sEventLocalBlackList.add("updateCustomHTMLWebView");
            sEventLocalBlackList.add("insertCustomHTMLWebView");
            sEventLocalBlackList.add("customWebviewPostMessage");
            sEventLocalBlackList.add("switchFullScreen");
            sEventLocalBlackList.add("getUin");
            sEventLocalBlackList.add("getA2");
            sEventLocalBlackList.add("getSkey");
            sEventLocalBlackList.add("getPskey");
            sEventLocalBlackList.add("fastLogin");
            sEventLocalBlackList.add(com.tencent.luggage.wxa.q2.e.NAME);
            sEventLocalBlackList.add("shareGameStructMessage");
            sEventLocalBlackList.add("shareGamePicture");
            sEventLocalBlackList.add("httpToSsoRequest");
            sEventLocalBlackList.add("sendShareInfoToGroup");
            sEventLocalBlackList.add("isGroupMember");
        }
    }

    private static void initEventLocalFriendshipBlackList() {
        List<String> list = sEventLocalFriendshipBlackList;
        synchronized (list) {
            list.clear();
            list.add("setUserCloudStorage");
            list.add("removeUserCloudStorage");
            list.add("getUserInteractiveStorage");
            list.add("modifyFriendInteractiveStorage");
            list.add("shareMessageToFriend");
            list.add("setMessageToFriendQuery");
            list.add(OpenDataCommonJsPlugin.API_ON_INTERACTIVE_STORAGE_MODIFIED);
            list.add("getUserCloudStorage");
            list.add("getGroupCloudStorage");
            list.add("getFriendCloudStorage");
            list.add("getPotentialFriendList");
            list.add("getReactiveFriendList");
        }
    }

    private static void initEventSecondaryApiList() {
        synchronized (sEventLocalSecondaryApiMap) {
            sEventLocalSecondaryApiMap.clear();
            sEventLocalSecondaryApiMap.put(PluginConst.SchemeJsPluginConst.API_OPEN_SCHEME, new HashMap());
            sEventLocalSecondaryApiMap.put("Personalize", new HashMap());
            sEventLocalSecondaryApiMap.put("invokeNativePlugin", new HashMap());
            sEventLocalSecondaryApiMap.put("canUseComponent", new HashMap());
        }
    }

    public static boolean isAppInWhiteList(String str) {
        return sAppWhiteList.contains(str);
    }

    public static boolean isEventInFriendshipBlackList(String str) {
        return sEventLocalFriendshipBlackList.contains(str);
    }

    public static boolean isEventInLocalBlackList(String str) {
        return sEventLocalBlackList.contains(str);
    }

    public static boolean isEventInSecondaryApiList(String str) {
        if (!sEventLocalSecondaryApiMap.containsKey(str) && !sEventRemoteSecondaryApiMap.containsKey(str)) {
            return false;
        }
        return true;
    }

    public static boolean isEventNameRight(MiniAppInfo miniAppInfo, String str, String str2) {
        AppMode appMode;
        if (miniAppInfo != null && (appMode = miniAppInfo.appMode) != null && appMode.unlimitedApiRight) {
            return true;
        }
        QQCustomizedProxy qQCustomizedProxy = (QQCustomizedProxy) ProxyManager.get(QQCustomizedProxy.class);
        if (qQCustomizedProxy != null && qQCustomizedProxy.isCustomMiniGame(miniAppInfo)) {
            return true;
        }
        if (sEventRemoteList.containsKey(str)) {
            if (sEventRemoteList.get(str).intValue() == 0) {
                if (QMLog.isColorLevel()) {
                    QMLog.d("AuthFilterList_isEventNameRight", "false, \u4e00\u7ea7\u9ed1\u540d\u5355 : " + str);
                }
                return false;
            }
            if (sEventRemoteList.get(str).intValue() == 1) {
                if (QMLog.isColorLevel()) {
                    QMLog.d("AuthFilterList_isEventNameRight", "true, \u4e00\u7ea7\u767d\u540d\u5355 : " + str);
                }
                return true;
            }
        }
        if (isEventInSecondaryApiList(str)) {
            if (sEventRemoteSecondaryApiMap.get(str) != null && sEventRemoteSecondaryApiMap.get(str).containsKey(str2) && sEventRemoteSecondaryApiMap.get(str).get(str2).intValue() == -1) {
                if (QMLog.isColorLevel()) {
                    QMLog.d("AuthFilterList_isEventNameRight", "false, \u4e8c\u7ea7\u9ed1\u540d\u5355 : " + str + " " + str2);
                }
                return false;
            }
            if (sEventRemoteSecondaryApiMap.get(str) != null && sEventRemoteSecondaryApiMap.get(str).containsKey(str2) && sEventRemoteSecondaryApiMap.get(str).get(str2).intValue() == 1) {
                if (QMLog.isColorLevel()) {
                    QMLog.d("AuthFilterList_isEventNameRight", "true, \u4e8c\u7ea7\u767d\u540d\u5355 : " + str + " " + str2);
                }
                return true;
            }
            if (sEventLocalSecondaryApiMap.containsKey(str)) {
                if (QMLog.isColorLevel()) {
                    QMLog.d("AuthFilterList_isEventNameRight", "false, \u4e8c\u7ea7\u9ed8\u8ba4\u9ed1\u540d\u5355 : " + str + " " + str2);
                }
                return false;
            }
            if (QMLog.isColorLevel()) {
                QMLog.d("AuthFilterList_isEventNameRight", "true, \u4e8c\u7ea7\u767d\u540d\u5355\u6216\u672a\u914d\u7f6e : " + str + " " + str2);
            }
            return true;
        }
        if (!sEventLocalBlackList.contains(str)) {
            return true;
        }
        if (QMLog.isColorLevel()) {
            QMLog.d("AuthFilterList_isEventNameRight", "false, \u672c\u5730\u9ed1\u540d\u5355 : " + str);
        }
        return false;
    }

    public static void reset() {
        sEventRemoteList.clear();
        sEventLocalSecondaryApiMap.clear();
        sEventRemoteSecondaryApiMap.clear();
        initEventSecondaryApiList();
    }

    public static void updateEventRemoteList(List<String> list, List<String> list2) {
        synchronized (sEventRemoteList) {
            if (list != null) {
                try {
                    for (String str : list) {
                        if (!TextUtils.isEmpty(str)) {
                            sEventRemoteList.put(str, 0);
                        }
                    }
                } catch (Throwable th5) {
                    throw th5;
                }
            }
            if (list2 != null) {
                for (String str2 : list2) {
                    if (!TextUtils.isEmpty(str2)) {
                        sEventRemoteList.put(str2, 1);
                    }
                }
            }
        }
    }

    public static void updateEventSecondaryApiList(List<SecondApiRightInfo> list) {
        if (list == null) {
            return;
        }
        for (SecondApiRightInfo secondApiRightInfo : list) {
            if (secondApiRightInfo != null) {
                if (sEventRemoteSecondaryApiMap.containsKey(secondApiRightInfo.apiName)) {
                    if (QMLog.isColorLevel()) {
                        QMLog.d(TAG, "config apiName : " + secondApiRightInfo.apiName + ", secondName: " + secondApiRightInfo.secondName);
                    }
                    sEventRemoteSecondaryApiMap.get(secondApiRightInfo.apiName).put(secondApiRightInfo.secondName, Integer.valueOf(secondApiRightInfo.right));
                } else {
                    if (QMLog.isColorLevel()) {
                        QMLog.d(TAG, "init config apiName : " + secondApiRightInfo.apiName + ", secondName: " + secondApiRightInfo.secondName);
                    }
                    HashMap<String, Integer> hashMap = new HashMap<>();
                    hashMap.put(secondApiRightInfo.secondName, Integer.valueOf(secondApiRightInfo.right));
                    sEventRemoteSecondaryApiMap.put(secondApiRightInfo.apiName, hashMap);
                }
            }
        }
    }
}
