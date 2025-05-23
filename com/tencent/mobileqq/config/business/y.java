package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.AppBoxPlugin;
import com.tencent.qqmini.sdk.plugins.QQFriendJsPlugin;
import com.tencent.qqmini.sdk.plugins.ShareJsPlugin;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes10.dex */
public class y implements IConfigData {

    /* renamed from: d, reason: collision with root package name */
    private List<String> f202852d = new ArrayList(Arrays.asList("requestPayment", "updateHTMLWebView", "insertHTMLWebView", "removeHTMLWebView", "openUrl", "notifyNative", "launchApplication", PluginConst.DataJsPluginConst.PRIVATE_API_GET_NATIVE_USER_INFO_EXTRA, "updateShareMenu", com.tencent.luggage.wxa.gg.c.NAME, com.tencent.luggage.wxa.gg.a.NAME, "getShareInfo", PluginConst.PayJsPluginConst.API_REQUEST_MIDAS_PAYMENT, com.tencent.luggage.wxa.c3.e.NAME, "reportSubmitForm", "navigateToMiniProgram", ShareJsPlugin.API_OPEN_QZONE_PUBLISH, PluginConst.PayJsPluginConst.API_REQUEST_STAR_CURRENCY, PluginConst.PayJsPluginConst.API_RECHARGE_AND_CONSUME, PluginConst.DataJsPluginConst.API_GET_GROUP_INFO, "saveAppToDesktop", "getQQRunData", PluginConst.SubscribeJsPluginConst.API_SUBSCRIBE_APP_MSG, PluginConst.PayJsPluginConst.API_CONSUME_STAR_CURRENTY, com.tencent.luggage.wxa.c3.d.NAME, QQFriendJsPlugin.API_ADD_FRIEND, com.tencent.luggage.wxa.p2.a.NAME, "openCustomerServiceConversation", AppBoxPlugin.API_OPERATE_APP_BOX, "openScheme^mqqapi://card/show_pslcard", "openGroupProfile", "insertLivePlayer", "insertLivePusher", PluginConst.VoIPPluginConst.API_JOIN_IP_CHAT, "insertMap", PluginConst.DataJsPluginConst.API_GET_GROUP_INFO_EXTRA, "showMiniAIOEntrance", "updatableMessage", "getPhoneNumber", "addColorSign", "startDownloadAppTask", "onDownloadAppSucceed", "onDownloadAppFailed", "onDownloadAppProgress", "cancelDownloadAppTask", "queryDownloadAppTask", "installApp", "startApp", "setUserCloudStorage", "removeUserCloudStorage", "getUserCloudStorage", "getFriendCloudStorage", "getGroupCloudStorage", "button_postMessage", "addGroupApp"));

    public static y b(String str) {
        y yVar = new y();
        try {
            yVar.f202852d.clear();
            if (!TextUtils.isEmpty(str)) {
                JSONArray jSONArray = new JSONArray(str);
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    yVar.f202852d.add(jSONArray.getString(i3));
                }
            }
        } catch (Throwable th5) {
            QLog.e("MiniAppApiReportConfigParser", 2, "parse, failed!", th5);
        }
        return yVar;
    }

    public List<String> a() {
        return this.f202852d;
    }

    public String toString() {
        TextUtils.join(",", a());
        return super.toString();
    }
}
