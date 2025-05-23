package com.tencent.qqmini.sdk.plugins;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@JsPlugin
/* loaded from: classes23.dex */
public class e extends BaseJsPlugin {

    /* compiled from: P */
    /* loaded from: classes23.dex */
    class a implements MiniAppProxy.GetA2InfoCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RequestEvent f348266a;

        a(RequestEvent requestEvent) {
            this.f348266a = requestEvent;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy.GetA2InfoCallback
        public void onFail(int i3, String str) {
            this.f348266a.fail("getA2 exception errorCode:" + i3 + " errorMsg:" + str);
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy.GetA2InfoCallback
        public void onSuccess(String str, String str2, String str3) {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                try {
                    jSONObject.put("data", str);
                } catch (JSONException e16) {
                    QMLog.e("ContainerSecretPlugin", "getA2:" + e16);
                    this.f348266a.fail("getA2 exception:" + e16);
                }
                this.f348266a.ok(jSONObject);
                return;
            }
            this.f348266a.fail("getA2 exception : a2String is null or empty!");
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    class b implements MiniAppProxy.GetStringCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RequestEvent f348268a;

        b(RequestEvent requestEvent) {
            this.f348268a = requestEvent;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy.GetStringCallback
        public void onResult(String str) {
            if (str != null) {
                QMLog.d("ContainerSecretPlugin", "get pskey from sever, length = " + str.length());
                e.this.c(str, this.f348268a);
                return;
            }
            this.f348268a.fail("fail to get pskey");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, RequestEvent requestEvent) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("data", str);
            requestEvent.ok(jSONObject);
        } catch (JSONException e16) {
            QMLog.e("ContainerSecretPlugin", "setResultData:" + e16);
            requestEvent.fail("setResultData exception:" + e16);
        }
    }

    @JsEvent({"getA2"})
    public void getA2(RequestEvent requestEvent) {
        MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
        miniAppProxy.getA2(miniAppProxy.getUin(), new a(requestEvent));
    }

    @JsEvent({"getPskey"})
    public void getPSkey(RequestEvent requestEvent) {
        String str;
        MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
        String str2 = null;
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            str = miniAppProxy.getUin();
            try {
                str2 = jSONObject.optString("domain");
            } catch (JSONException e16) {
                e = e16;
                QMLog.e("ContainerSecretPlugin", "getPSkey exception:" + e);
                if (TextUtils.isEmpty(str)) {
                }
                requestEvent.fail("param illegal");
                QMLog.e("ContainerSecretPlugin", "getPSkey param illegal:" + requestEvent.jsonParams);
            }
        } catch (JSONException e17) {
            e = e17;
            str = null;
        }
        if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            QMLog.i("ContainerSecretPlugin", "get pskey from sever, start");
            miniAppProxy.getPskey(str2, new b(requestEvent));
            return;
        }
        requestEvent.fail("param illegal");
        QMLog.e("ContainerSecretPlugin", "getPSkey param illegal:" + requestEvent.jsonParams);
    }

    @JsEvent({"getSkey"})
    public void getSkey(RequestEvent requestEvent) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("data", "");
            requestEvent.ok(jSONObject);
        } catch (JSONException e16) {
            QMLog.e("ContainerSecretPlugin", "getSkey:" + e16);
            requestEvent.fail("native exception:" + e16);
        }
    }

    @JsEvent({"getUin"})
    public void getUin(RequestEvent requestEvent) {
        String uin = ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getUin();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("data", uin);
            requestEvent.ok(jSONObject);
        } catch (JSONException e16) {
            QMLog.e("ContainerSecretPlugin", "getUin:" + e16);
            requestEvent.fail("native exception:" + e16);
        }
    }
}
