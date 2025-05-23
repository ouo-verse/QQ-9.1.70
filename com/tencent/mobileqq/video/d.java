package com.tencent.mobileqq.video;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.emosm.t;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes35.dex */
public class d extends WebViewPlugin {

    /* renamed from: d, reason: collision with root package name */
    public final String f312464d = "VideoApiPlugin";

    /* renamed from: e, reason: collision with root package name */
    protected t f312465e = new a();

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "video";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        String str4;
        if (QLog.isColorLevel()) {
            QLog.d("VideoApiPlugin", 2, "handleJsRequest, url=" + str);
        }
        if (!"video".equals(str2) || str == null || str3 == null) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            if (jSONObject.has("callback")) {
                str4 = jSONObject.getString("callback");
            } else {
                str4 = "";
            }
            if ("isInstalled".equals(str3)) {
                if (!((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded()) {
                    return true;
                }
                ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(com.tencent.mobileqq.emosm.a.a("ipc_video_isinstalled", str4, this.f312465e.key, new Bundle()));
                return true;
            }
            if ("installPlugin".equals(str3)) {
                if (!((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded()) {
                    return true;
                }
                ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(com.tencent.mobileqq.emosm.a.a("ipc_video_install_plugin", str4, this.f312465e.key, new Bundle()));
                return true;
            }
            if (!"playVideo".equals(str3)) {
                return true;
            }
            com.tencent.qqperf.monitor.crash.catchedexception.a.c(new RuntimeException(), "VipVideoPlayActivity \u5df2\u4e0b\u67b6");
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return true;
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("VideoApiPlugin", 2, "vip video api plugin on activity result requestCode=" + ((int) b16) + ",resultCode=" + i3);
        }
        super.onActivityResult(intent, b16, i3);
        com.tencent.qqperf.monitor.crash.catchedexception.a.c(new RuntimeException(), "VipVideoPlayActivity \u5df2\u4e0b\u67b6");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).registerObserver(this.f312465e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        super.onDestroy();
        ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).unRegisterObserver(this.f312465e);
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a extends t {
        a() {
        }

        @Override // com.tencent.mobileqq.emosm.t
        public void onResponse(Bundle bundle) {
            if (bundle == null || bundle.getInt("respkey", 0) != d.this.f312465e.key) {
                return;
            }
            String string = bundle.getString("cmd");
            String string2 = bundle.getString("callbackid");
            Bundle bundle2 = bundle.getBundle("response");
            try {
                if (TextUtils.equals(string, "ipc_video_isinstalled")) {
                    if (QLog.isColorLevel()) {
                        QLog.d("VideoApiPlugin", 2, "video remote response cmd=" + string);
                    }
                    d.this.callJs(string2, String.valueOf(bundle2.getBoolean("isInstalled")));
                    return;
                }
                if (TextUtils.equals(string, "ipc_video_install_plugin")) {
                    if (QLog.isColorLevel()) {
                        QLog.d("VideoApiPlugin", 2, "video remote response cmd=" + string);
                    }
                    int i3 = bundle2.getInt("status");
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("status", i3);
                    if (i3 == 1) {
                        jSONObject.put("result", 1);
                        jSONObject.put("progress", bundle2.getFloat("progress"));
                        jSONObject.put("msg", "install progress");
                    } else if (i3 == 2) {
                        jSONObject.put("result", bundle2.getInt("errCode"));
                        jSONObject.put("progress", e.f312468b);
                        jSONObject.put("msg", "install failed");
                    } else if (i3 == 3) {
                        jSONObject.put("result", 0);
                        jSONObject.put("progress", 100);
                        jSONObject.put("msg", "install finished");
                    }
                    d.this.callJs(string2, jSONObject.toString());
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }

        @Override // com.tencent.mobileqq.emosm.t
        public void onBindedToClient() {
        }

        @Override // com.tencent.mobileqq.emosm.t
        public void onDisconnectWithService() {
        }

        @Override // com.tencent.mobileqq.emosm.t
        public void onPushMsg(Bundle bundle) {
        }
    }
}
