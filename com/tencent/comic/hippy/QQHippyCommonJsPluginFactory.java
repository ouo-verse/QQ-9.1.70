package com.tencent.comic.hippy;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.api.IJsApi;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes32.dex */
public class QQHippyCommonJsPluginFactory extends a {
    @Override // com.tencent.mobileqq.webview.swift.a
    public List<WebViewPlugin> getCommonJsPlugin() {
        ArrayList arrayList = new ArrayList();
        arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getWebSecurityPluginV2Plugin());
        arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getEventApiPlugin());
        arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getUIApiPlugin());
        arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getTogetherBusinessForWebPlugin());
        arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getQQApiPlugin());
        arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getOfflinePlugin());
        arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getWebViewJumpPlugin());
        arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getVasCommonJsPlugin());
        arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getQWalletPayJsPlugin());
        arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getPayJsPlugin());
        arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getQWalletCommonJsPlugin());
        arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getSSOWebviewPlugin());
        return arrayList;
    }
}
