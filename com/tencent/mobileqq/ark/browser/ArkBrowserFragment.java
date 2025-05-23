package com.tencent.mobileqq.ark.browser;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import b91.b;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.IDoraemonService;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArkBrowserFragment extends WebViewFragment {
    public String C = null;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements SwiftBrowserShareMenuHandler.e {
        a() {
        }

        @Override // com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler.e
        public void a(String str) {
            ArkBrowserFragment arkBrowserFragment = ArkBrowserFragment.this;
            arkBrowserFragment.C = str;
            CustomWebView webView = arkBrowserFragment.getWebView();
            if (webView != null) {
                webView.callJs("NativeApi.lightappGetShareData();");
            }
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        b bVar;
        super.doOnActivityResult(i3, i16, intent);
        WebViewPluginEngine pluginEngine = this.webView.getPluginEngine();
        String currentUrl = getCurrentUrl();
        if (TextUtils.isEmpty(DoraemonUtil.h(currentUrl))) {
            return;
        }
        DoraemonAPIManager doraemonAPIModuleByUrl = ((IDoraemonService) QRoute.api(IDoraemonService.class)).getDoraemonAPIModuleByUrl(pluginEngine.k(), currentUrl);
        if (doraemonAPIModuleByUrl != null && (bVar = (b) doraemonAPIModuleByUrl.i(b.class, false)) != null) {
            bVar.u(intent, (byte) i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getUIStyleHandler().f314512m.f314620c &= -5;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.r
    public void showActionSheet() {
        SwiftBrowserShareMenuHandler swiftBrowserShareMenuHandler = (SwiftBrowserShareMenuHandler) this.mComponentsProvider.a(4);
        if (swiftBrowserShareMenuHandler != null) {
            swiftBrowserShareMenuHandler.i(new a());
            swiftBrowserShareMenuHandler.S((Share) getShare(), getUIStyle().f314620c);
        }
    }
}
