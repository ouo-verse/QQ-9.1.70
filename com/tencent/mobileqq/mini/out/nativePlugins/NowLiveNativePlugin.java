package com.tencent.mobileqq.mini.out.nativePlugins;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.b;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.JSContext;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class NowLiveNativePlugin implements NativePlugin {
    private static final String ACTION_PRELOAD = "preload";
    public static final String PLUGIN_NAME = "nowlive";
    private static final String TAG = "NowLiveNativePlugin";
    private b mApiClient;
    final ITroopMemberApiClientApi.a mCallback = new ITroopMemberApiClientApi.a() { // from class: com.tencent.mobileqq.mini.out.nativePlugins.NowLiveNativePlugin.1
        @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.a
        public void callback(Bundle bundle) {
            int i3 = bundle.getInt("msg");
            if (i3 == 88) {
                NowLiveNativePlugin.this.mPluginState = bundle.getInt("state");
                if (QLog.isColorLevel()) {
                    QLog.d(NowLiveNativePlugin.TAG, 2, "TroopMemberApiClient.Callback | plugin state: " + NowLiveNativePlugin.this.mApiClient);
                    return;
                }
                return;
            }
            if (i3 == 89) {
                int i16 = bundle.getInt("errCode");
                String string = bundle.getString("desc");
                if (QLog.isColorLevel()) {
                    QLog.d(NowLiveNativePlugin.TAG, 2, "TroopMemberApiClient.Callback | errCode=" + i16 + ", desc=" + string);
                }
            }
        }
    };
    private int mPluginState;

    private void preload() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "NowLiveNativePlugin | preload()");
        }
        if (this.mApiClient == null) {
            b A = b.A();
            this.mApiClient = A;
            A.p();
            this.mApiClient.F0(this.mCallback);
        }
        this.mApiClient.h0(null);
    }

    @Override // com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin
    public void onDestroy() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "NowLiveNativePlugin | onDestroy()");
        }
        b bVar = this.mApiClient;
        if (bVar != null) {
            bVar.m0();
        }
    }

    @Override // com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin
    public void onInvoke(JSONObject jSONObject, JSContext jSContext) {
        if (jSContext != null && jSONObject != null) {
            try {
                String optString = jSONObject.optString("api_name");
                if (!TextUtils.equals(PLUGIN_NAME, optString)) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "onInvoke| the api name: " + optString);
                        return;
                    }
                    return;
                }
                String string = new JSONObject(jSONObject.getString("data")).getString("action");
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "onInvoke|" + string);
                }
                if (TextUtils.equals(string, "preload")) {
                    preload();
                    return;
                }
                return;
            } catch (Exception unused) {
                if (QLog.isColorLevel()) {
                    QLog.w(TAG, 2, "decode param error");
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onInvoke| jsContext or param is null.");
        }
    }
}
