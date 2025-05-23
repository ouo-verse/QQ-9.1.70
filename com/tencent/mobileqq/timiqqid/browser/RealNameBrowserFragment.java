package com.tencent.mobileqq.timiqqid.browser;

import android.net.Uri;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.interfaces.PermissionRequest;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;

/* compiled from: P */
/* loaded from: classes18.dex */
public class RealNameBrowserFragment extends WebViewFragment {
    private WebChromeClient C = new a();

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a extends WebChromeClient {
        a() {
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onPermissionRequest(PermissionRequest permissionRequest) {
            if ("https://miniprogram-kyc.tencentcloudapi.com/".equals(permissionRequest.getOrigin().toString())) {
                permissionRequest.grant(permissionRequest.getResources());
                permissionRequest.getOrigin();
            }
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onProgressChanged(WebView webView, int i3) {
            JsInjector.getInstance().onProgressChanged(webView, i3);
            super.onProgressChanged(webView, i3);
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            com.tencent.mobileqq.timiqqid.helper.a.a().d(webView, valueCallback, RealNameBrowserFragment.this.getActivity(), fileChooserParams);
            return true;
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            com.tencent.mobileqq.timiqqid.helper.a.a().e(valueCallback, str, RealNameBrowserFragment.this.getActivity());
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webview.swift.WebViewProvider
    public void setWebView(TouchWebView touchWebView) {
        super.setWebView(touchWebView);
        touchWebView.setWebChromeClient(this.C);
        com.tencent.mobileqq.timiqqid.helper.a.a().f(touchWebView, getAppRuntime().getApplicationContext());
    }
}
