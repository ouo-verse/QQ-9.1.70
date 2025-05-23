package com.tencent.midas.jsbridge;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.Toast;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.download.APMidasPluginDownloadUtils;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.lang.reflect.Method;

/* loaded from: classes9.dex */
public class APX5WebView {
    private static final String TAG = "APX5WebView";
    private IAPX5WebViewCallback callback;
    private Activity mContext;
    private WebView mWebview;
    private WebChromeClient mChromeClient = new WebChromeClient() { // from class: com.tencent.midas.jsbridge.APX5WebView.1
        @Override // com.tencent.smtt.sdk.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            APLog.e("inner onJsAlert message", str2);
            APLog.e(APX5WebView.TAG, " url = " + str);
            APLog.e(APX5WebView.TAG, " message = " + str2);
            if (APMidasPluginDownloadUtils.handlePureH5UpdateJsAlertLogic(APX5WebView.this.mContext, str2)) {
                APLog.d(APX5WebView.TAG, "onJsAlert is pure h5 update! Cancel alert!");
                jsResult.cancel();
                return true;
            }
            APLog.d(APX5WebView.TAG, "onJsAlert not pure h5 update!");
            if (APWebProtocol.hookH5Method(APX5WebView.this.mContext, APX5WebView.this.mWebview, str, str2, jsResult, APX5WebView.this.callback)) {
                APLog.d(APX5WebView.TAG, "hookH5Method is processed");
                jsResult.cancel();
                return true;
            }
            if (APMidasPayAPI.h5PayHookX5(APX5WebView.this.mContext, APX5WebView.this.mWebview, str, str2, jsResult) == 0) {
                APX5WebView.this.callback.WebChromeClientJsAlert(webView, str, str2, jsResult);
                jsResult.cancel();
                return true;
            }
            return super.onJsAlert(webView, str, str2, jsResult);
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            return APX5WebView.this.callback.WebChromeClientJsPrompt(webView, str, str2, str3, jsPromptResult);
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onProgressChanged(WebView webView, int i3) {
            JsInjector.getInstance().onProgressChanged(webView, i3);
            super.onProgressChanged(webView, i3);
        }
    };
    private WebViewClient mWebViewClient = new WebViewClient() { // from class: com.tencent.midas.jsbridge.APX5WebView.2
        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            APLog.d(APX5WebView.TAG, "onPageFinished!");
            APLog.i("APWebView url == ", str);
            APX5WebView.this.mWebview.setVisibility(0);
            APMidasPayAPI.InnerH5PayInitX5(APX5WebView.this.mContext, APX5WebView.this.mWebview);
            APX5WebView.this.callback.WebViewClientPageFinished(webView, str);
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            JsInjector.getInstance().onPageStarted(webView);
            super.onPageStarted(webView, str, bitmap);
            APLog.d(APX5WebView.TAG, "onPageStarted!");
            APX5WebView.this.callback.WebViewClientPageStarted(webView, str, bitmap);
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onReceivedError(WebView webView, int i3, String str, String str2) {
            super.onReceivedError(webView, i3, str, str2);
            APLog.d(APX5WebView.TAG, "onReceivedError!");
            APX5WebView.this.callback.WebViewClientReceivedError(webView, i3, str, str2);
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            APLog.d(APX5WebView.TAG, "shouldOverrideUrlLoading url = " + str);
            if (!str.startsWith("http://unipay.sdk.android/?") && !str.startsWith("wsj://") && !str.startsWith("mqqapi://") && !str.startsWith("weixin://") && !str.startsWith("sms://")) {
                webView.loadUrl(str);
                APLog.d(APX5WebView.TAG, "shouldOverrideUrlLoading loadUrl = ");
            }
            if (!str.startsWith("mqqapi://") && !str.startsWith("weixin://") && !str.startsWith("sms://")) {
                return true;
            }
            Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(str));
            if (intent.resolveActivity(APX5WebView.this.mContext.getPackageManager()) != null) {
                webView.getContext().startActivity(intent);
                return true;
            }
            Toast.makeText(APX5WebView.this.mContext, "\u62b1\u6b49\uff0c\u4f60\u672a\u5b89\u88c5\u76f8\u5e94\u5ba2\u6237\u7aef", 1).show();
            APLog.w(APX5WebView.TAG, "shouldOverrideUrlLoading() intent.resolveActivity == Null ");
            return true;
        }
    };

    public APX5WebView(Activity activity, WebView webView, IAPX5WebViewCallback iAPX5WebViewCallback) {
        this.mWebview = null;
        this.mContext = null;
        this.callback = null;
        this.mContext = activity;
        this.mWebview = webView;
        this.callback = iAPX5WebViewCallback;
        InitWebView();
    }

    @SuppressLint({"NewApi"})
    private void InitWebView() {
        WebSettings settings = this.mWebview.getSettings();
        settings.setJavaScriptEnabled(true);
        APMidasPayAPI.env.equals("test");
        settings.setDomStorageEnabled(true);
        settings.setAppCachePath(this.mContext.getApplicationContext().getDir("cache", 0).getPath());
        settings.setAllowFileAccess(true);
        settings.setAppCacheEnabled(true);
        settings.setCacheMode(-1);
        try {
            settings.setSavePassword(false);
        } catch (Exception unused) {
        }
        this.mWebview.setScrollBarStyle(0);
        this.mWebview.setWebChromeClient(this.mChromeClient);
        this.mWebview.setWebViewClient(this.mWebViewClient);
        removeInterface();
    }

    private void removeInterface() {
        try {
            Method method = this.mWebview.getClass().getMethod("removeJavascriptInterface", String.class);
            if (method != null) {
                method.invoke(this.mWebview, "searchBoxJavaBridge_");
                method.invoke(this.mWebview, "accessibility");
                method.invoke(this.mWebview, "accessibilityTraversal");
            }
        } catch (Exception e16) {
            APLog.i("removeJavascriptInterface", e16.toString());
        }
    }

    public WebView getWebView() {
        return this.mWebview;
    }

    public void loadUrl(String str) {
        this.mWebview.loadUrl(str);
    }
}
