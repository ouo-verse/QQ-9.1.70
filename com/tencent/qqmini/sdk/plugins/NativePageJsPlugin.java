package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.servlet.CheckBindingStateServlet;
import com.tencent.mobileqq.search.config.SearchConfig;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.GuildProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class NativePageJsPlugin extends BaseJsPlugin {
    private static final String CARD_TYPE_GUILD = "guild";
    private static final String TAG = "NativePageJsPlugin";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes23.dex */
    public class a implements AsyncResult {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RequestEvent f348205a;

        a(RequestEvent requestEvent) {
            this.f348205a = requestEvent;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
        public void onReceiveResult(boolean z16, JSONObject jSONObject) {
            String str;
            if (z16) {
                QMLog.d(NativePageJsPlugin.TAG, "jumpToJoinGuild success");
                this.f348205a.ok();
                return;
            }
            if (jSONObject == null || (str = jSONObject.optString("err_msg")) == null) {
                str = "join sign unknown exception";
            }
            QMLog.d(NativePageJsPlugin.TAG, "jumpToJoinGuild failed, msg is " + str);
            this.f348205a.fail(str);
        }
    }

    private String getAppId() {
        if (this.mMiniAppContext.getMiniAppInfo() != null) {
            return this.mMiniAppContext.getMiniAppInfo().appId;
        }
        return "";
    }

    private Activity getAttachedActivity() {
        return this.mMiniAppContext.getAttachActivity();
    }

    @JsEvent({"openNativePage"})
    public void openNativePage(final RequestEvent requestEvent) {
        int i3;
        final Activity attachedActivity = getAttachedActivity();
        if (attachedActivity == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            if (jSONObject.has("api_name")) {
                jSONObject.optString("api_name");
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                final String optString = optJSONObject.optString("card_type");
                final String optString2 = optJSONObject.optString("uin");
                if (optString.equals(SearchConfig.ENGINE_PUBLIC_ACCOUNT)) {
                    i3 = 1;
                } else if (optString.equals(VipFunCallConstants.KEY_GROUP)) {
                    i3 = 2;
                } else {
                    if ("guild".equals(optString)) {
                        requestJumpToJoinGuild(requestEvent, optString2);
                        return;
                    }
                    i3 = 0;
                }
                int i16 = i3;
                final String appId = getAppId();
                ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).checkBindingState(appId, optString2, i16, new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.NativePageJsPlugin.1
                    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                    public void onReceiveResult(boolean z16, JSONObject jSONObject2) {
                        try {
                            if (z16) {
                                JSONObject jSONObject3 = new JSONObject();
                                int optInt = jSONObject2.optInt(CheckBindingStateServlet.KEY_CHECK_STATE);
                                jSONObject3.put("bindingState", optInt);
                                if (optInt != 0) {
                                    ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).openNativePage(attachedActivity, appId, optString2, optString);
                                    requestEvent.ok(jSONObject3);
                                } else {
                                    requestEvent.fail(jSONObject2, "fail no permission");
                                }
                            } else {
                                QMLog.e(NativePageJsPlugin.TAG, "handleCheckBindingState fail, retCode: " + jSONObject2.optLong("retCode") + "; errMsg : " + jSONObject2.optString("errMsg"));
                                requestEvent.fail(jSONObject2, "null");
                            }
                        } catch (Throwable th5) {
                            QMLog.e(NativePageJsPlugin.TAG, "handleCheckBindingState exception: ", th5);
                            ApiUtil.wrapCallbackFail(requestEvent.event, null);
                        }
                    }
                });
                return;
            }
            requestEvent.fail("params error.");
        } catch (Exception e16) {
            QMLog.e(TAG, requestEvent.event + " error.", e16);
        }
    }

    public void requestJumpToJoinGuild(RequestEvent requestEvent, String str) {
        if (TextUtils.isEmpty(str)) {
            QMLog.e(TAG, "requestJumpToJoinGuild guildId is empty or null");
            requestEvent.fail("guildId is empty or null");
        } else {
            ((GuildProxy) ProxyManager.get(GuildProxy.class)).jumpToJoinGuild(getAppId(), str, new a(requestEvent), getAttachedActivity());
        }
    }
}
