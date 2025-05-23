package com.tencent.biz.webviewplugin;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.debug.api.ISSOEnvPluginApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

/* compiled from: P */
/* loaded from: classes32.dex */
public class af extends WebViewPlugin {

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements eb1.a {
        a() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b implements eb1.a {
        b() {
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "ssoEnv";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (!"ssoEnv".equals(str2)) {
            return super.handleJsRequest(jsBridgeListener, str, str2, str3, strArr);
        }
        try {
            AppInterface appInterface = (AppInterface) this.mRuntime.c();
            if ("getconfig".equals(str3)) {
                ((ISSOEnvPluginApi) QRoute.api(ISSOEnvPluginApi.class)).handleGetConfig(appInterface, new a(), strArr);
            } else if ("setconfig".equals(str3)) {
                ((ISSOEnvPluginApi) QRoute.api(ISSOEnvPluginApi.class)).handleSetConfig(appInterface, new b(), strArr);
            } else {
                return super.handleJsRequest(jsBridgeListener, str, str2, str3, strArr);
            }
            return true;
        } catch (Exception e16) {
            com.tencent.qqcamerakit.common.e.b("SSOEnvPlugin", 1, "[handleJsRequest] error=", e16);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        super.onDestroy();
        com.tencent.qqcamerakit.common.e.a("SSOEnvPlugin", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onWebViewCreated(CustomWebView customWebView) {
        super.onWebViewCreated(customWebView);
        if (com.tencent.qqcamerakit.common.e.f()) {
            com.tencent.qqcamerakit.common.e.a("SSOEnvPlugin", 2, "onWebViewCreated");
        }
    }
}
