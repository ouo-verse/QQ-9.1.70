package com.tencent.qqmini.nativePlugins;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.out.nativePlugins.NowLiveNativePlugin;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import org.json.JSONObject;

/* compiled from: P */
@JsPlugin(secondary = true)
/* loaded from: classes34.dex */
public class v extends BaseJsPlugin {

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.biz.troop.b f347070d;

    /* renamed from: e, reason: collision with root package name */
    private int f347071e;

    /* renamed from: f, reason: collision with root package name */
    final ITroopMemberApiClientApi.a f347072f = new a();

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class a implements ITroopMemberApiClientApi.a {
        a() {
        }

        @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.a
        public void callback(Bundle bundle) {
            int i3 = bundle.getInt("msg");
            if (i3 == 88) {
                v.this.f347071e = bundle.getInt("state");
                if (QLog.isColorLevel()) {
                    QLog.d("NowLiveJsPlugin", 2, "TroopMemberApiClient.Callback | plugin state: " + v.this.f347070d);
                    return;
                }
                return;
            }
            if (i3 == 89) {
                int i16 = bundle.getInt("errCode");
                String string = bundle.getString("desc");
                if (QLog.isColorLevel()) {
                    QLog.d("NowLiveJsPlugin", 2, "TroopMemberApiClient.Callback | errCode=" + i16 + ", desc=" + string);
                }
            }
        }
    }

    private void d() {
        if (QLog.isColorLevel()) {
            QLog.d("NowLiveJsPlugin", 2, "NowLiveJsPlugin | preload()");
        }
        if (this.f347070d == null) {
            com.tencent.biz.troop.b A = com.tencent.biz.troop.b.A();
            this.f347070d = A;
            A.p();
            this.f347070d.F0(this.f347072f);
        }
        this.f347070d.h0(null);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onDestroy() {
        super.onDestroy();
        if (QLog.isColorLevel()) {
            QLog.d("NowLiveJsPlugin", 2, "NowLiveNativePlugin | onDestroy()");
        }
        com.tencent.biz.troop.b bVar = this.f347070d;
        if (bVar != null) {
            bVar.m0();
        }
    }

    @JsEvent({NowLiveNativePlugin.PLUGIN_NAME})
    public void onInvoke(RequestEvent requestEvent) {
        if (requestEvent != null && !TextUtils.isEmpty(requestEvent.jsonParams)) {
            try {
                JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
                String optString = jSONObject.optString("api_name");
                if (!TextUtils.equals(NowLiveNativePlugin.PLUGIN_NAME, optString)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("NowLiveJsPlugin", 2, "onInvoke() the api name: " + optString);
                        return;
                    }
                    return;
                }
                String string = new JSONObject(jSONObject.getString("data")).getString("action");
                if (QLog.isColorLevel()) {
                    QLog.d("NowLiveJsPlugin", 2, "onInvoke()" + string);
                }
                if (TextUtils.equals(string, "preload")) {
                    d();
                    return;
                }
                return;
            } catch (Exception unused) {
                if (QLog.isColorLevel()) {
                    QLog.w("NowLiveJsPlugin", 2, "decode param error");
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("NowLiveJsPlugin", 2, "onInvoke(): request event  is null.");
        }
    }
}
