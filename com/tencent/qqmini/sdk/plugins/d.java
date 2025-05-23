package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

/* compiled from: P */
@JsPlugin
/* loaded from: classes23.dex */
public class d extends BaseJsPlugin {

    /* compiled from: P */
    /* loaded from: classes23.dex */
    class a implements AsyncResult {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RequestEvent f348264a;

        a(RequestEvent requestEvent) {
            this.f348264a = requestEvent;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
        public void onReceiveResult(boolean z16, JSONObject jSONObject) {
            d.c(z16, jSONObject, this.f348264a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(boolean z16, JSONObject jSONObject, RequestEvent requestEvent) {
        QMLog.d("SSOJsPlugin", "handleResult isSuccess:" + z16 + " result:" + jSONObject);
        if (z16 && jSONObject != null) {
            requestEvent.ok(jSONObject);
        } else if (jSONObject != null) {
            requestEvent.fail(jSONObject, "");
        } else {
            requestEvent.fail("result is null");
        }
    }

    private String getAppId() {
        if (this.mMiniAppContext.getMiniAppInfo() != null) {
            return this.mMiniAppContext.getMiniAppInfo().appId;
        }
        return "";
    }

    @JsEvent({"httpToSsoRequest"})
    public void httpToSsoRequest(RequestEvent requestEvent) {
        try {
            QMLog.i("SSOJsPlugin", "httpToSsoRequest req:" + requestEvent.jsonParams);
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            JSONObject optJSONObject = jSONObject.optJSONObject("header");
            String optString = jSONObject.optString("method");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("appid", getAppId());
            jSONObject2.put("method", optString);
            if (optJSONObject != null) {
                jSONObject2.put("header", optJSONObject);
            } else {
                jSONObject2.put("header", jSONObject.optString("header"));
            }
            String optString2 = jSONObject.optString("url");
            String optString3 = jSONObject.optString("data");
            String optString4 = jSONObject.optString("dataType");
            String optString5 = jSONObject.optString("responseType");
            jSONObject2.put("url", optString2);
            jSONObject2.put("body", optString3);
            jSONObject2.put("dataType", optString4);
            jSONObject2.put("responseType", optString5);
            QQCustomizedProxy qQCustomizedProxy = (QQCustomizedProxy) ProxyManager.get(QQCustomizedProxy.class);
            if (qQCustomizedProxy != null) {
                qQCustomizedProxy.httpToSsoRequest(jSONObject2, new a(requestEvent));
            }
        } catch (Exception e16) {
            QMLog.e("SSOJsPlugin", "httpToSsoRequest", e16);
        }
    }
}
