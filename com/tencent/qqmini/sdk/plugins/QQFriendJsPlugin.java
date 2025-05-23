package com.tencent.qqmini.sdk.plugins;

import android.content.Context;
import android.os.Bundle;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.qqmini.sdk.widget.MiniToast;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class QQFriendJsPlugin extends BaseJsPlugin {
    public static final String API_ADD_FRIEND = "addFriend";
    public static final String SETTING_ADD_FRIEND = "setting.addFriend";
    private static final String TAG = "QQFriendJsPlugin";
    private static String sVia = "";

    /* loaded from: classes23.dex */
    public interface IAddFriendCallBack {
        void onAddFriendCallBack(String str, boolean z16, String str2);
    }

    public static void doAddFriend(final Context context, final String str, final String str2, final IAddFriendCallBack iAddFriendCallBack) {
        if (context == null) {
            QMLog.e(TAG, "doAddFriend context is null ?!!");
        } else {
            final ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
            channelProxy.getUserSetting(str, str2, "setting.addFriend", null, new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.QQFriendJsPlugin.1
                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                    if (z16 && jSONObject != null) {
                        int optInt = jSONObject.optInt("authState", -1);
                        String optString = jSONObject.optString("settingItem", "");
                        if (optInt == 1 && "setting.addFriend".equals(optString)) {
                            try {
                                Bundle bundle = new Bundle();
                                bundle.putString("openId", str2);
                                bundle.putString("appId", str);
                                if (!channelProxy.startAddFriendActivity(context, str, str2, QQFriendJsPlugin.sVia)) {
                                    MiniToast.makeText(context, 0, "\u6682\u4e0d\u652f\u6301\u5728" + QUAUtil.getApplicationName(context) + "\u4e2d\u6dfb\u52a0\u597d\u53cb", 1);
                                    if (iAddFriendCallBack != null) {
                                        QMLog.e(QQFriendJsPlugin.TAG, "app not implement");
                                        iAddFriendCallBack.onAddFriendCallBack(QQFriendJsPlugin.API_ADD_FRIEND, false, "app not implement");
                                    }
                                }
                            } catch (NumberFormatException e16) {
                                QMLog.d(QQFriendJsPlugin.TAG, " doAddFriend() exception e = " + e16);
                            }
                            IAddFriendCallBack iAddFriendCallBack2 = iAddFriendCallBack;
                            if (iAddFriendCallBack2 != null) {
                                iAddFriendCallBack2.onAddFriendCallBack(QQFriendJsPlugin.API_ADD_FRIEND, true, null);
                                return;
                            }
                            return;
                        }
                        if (iAddFriendCallBack != null) {
                            QMLog.e(QQFriendJsPlugin.TAG, "getSettingByOpenId failed");
                            iAddFriendCallBack.onAddFriendCallBack(QQFriendJsPlugin.API_ADD_FRIEND, false, "auth deny");
                            return;
                        }
                        return;
                    }
                    if (iAddFriendCallBack != null) {
                        QMLog.e(QQFriendJsPlugin.TAG, "getUserSetting failed");
                        iAddFriendCallBack.onAddFriendCallBack(QQFriendJsPlugin.API_ADD_FRIEND, false, "network err");
                    }
                }
            });
        }
    }

    public static String getVia() {
        return sVia;
    }

    public static void setVia(String str) {
        sVia = str;
    }

    @JsEvent({API_ADD_FRIEND})
    public void addFriend(final RequestEvent requestEvent) {
        try {
            String optString = new JSONObject(requestEvent.jsonParams).optString("openid", "");
            IAddFriendCallBack iAddFriendCallBack = new IAddFriendCallBack() { // from class: com.tencent.qqmini.sdk.plugins.QQFriendJsPlugin.2
                @Override // com.tencent.qqmini.sdk.plugins.QQFriendJsPlugin.IAddFriendCallBack
                public void onAddFriendCallBack(String str, boolean z16, String str2) {
                    if (z16) {
                        requestEvent.ok();
                    } else {
                        requestEvent.fail(str2);
                    }
                }
            };
            setVia(getMiniAppInfo().via);
            doAddFriend(this.mMiniAppContext.getAttachActivity(), this.mApkgInfo.appId, optString, iAddFriendCallBack);
        } catch (Exception unused) {
            requestEvent.fail();
        }
    }
}
