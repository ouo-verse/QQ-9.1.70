package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class AuthJsPlugin extends BaseJsPlugin {
    private static final String TAG = "AuthJsPlugin";
    private ChannelProxy mChannelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);

    @JsEvent(isSync = false, value = {"login"})
    public void login(final RequestEvent requestEvent) {
        QMLog.d(TAG, "call API_LOGIN callbackId:" + requestEvent.callbackId + " PackageToolVersion:" + this.mApkgInfo.mAppConfigInfo.packageToolVersion);
        this.mChannelProxy.login(this.mApkgInfo.appId, new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.AuthJsPlugin.1
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                if (z16) {
                    QMLog.d(AuthJsPlugin.TAG, "call API_LOGIN  code:" + jSONObject.toString());
                    requestEvent.ok(jSONObject);
                    return;
                }
                QMLog.e(AuthJsPlugin.TAG, "call API_LOGIN failed:" + jSONObject);
                if (jSONObject != null) {
                    requestEvent.fail(jSONObject, jSONObject.optString("errMsg", ""));
                } else {
                    requestEvent.fail();
                }
            }
        });
    }

    @JsEvent(isSync = false, value = {"refreshSession"})
    public void refreshSession(final RequestEvent requestEvent) {
        this.mChannelProxy.checkSession(this.mApkgInfo.appId, new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.AuthJsPlugin.2
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                if (z16) {
                    QMLog.d(AuthJsPlugin.TAG, "call API_REFRESH_SESSION success.");
                    requestEvent.ok(jSONObject);
                } else {
                    QMLog.d(AuthJsPlugin.TAG, "call API_REFRESH_SESSION success.");
                    requestEvent.fail();
                }
            }
        });
    }
}
