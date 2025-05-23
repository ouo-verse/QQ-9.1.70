package com.tencent.midas.jsbridge;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.download.APMidasPluginDownloadUtils;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import java.lang.reflect.Method;

/* loaded from: classes9.dex */
public class APWebView {
    private static final String TAG = "APWebView";
    private IAPWebViewCallback callback;
    private Activity mContext;
    private WebView mWebview;
    private WebChromeClient mChromeClient = new WebChromeClient() { // from class: com.tencent.midas.jsbridge.APWebView.1
        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            APLog.e("inner onJsAlert message", str2);
            APLog.e(APWebView.TAG, " url = " + str);
            APLog.e(APWebView.TAG, " message = " + str2);
            if (APMidasPluginDownloadUtils.handlePureH5UpdateJsAlertLogic(APWebView.this.mContext, str2)) {
                APLog.d(APWebView.TAG, "onJsAlert is pure h5 update! Cancel alert!");
                jsResult.cancel();
                return true;
            }
            APLog.d(APWebView.TAG, "onJsAlert not pure h5 update!");
            if (APWebProtocol.hookH5Method(APWebView.this.mContext, APWebView.this.mWebview, str, str2, jsResult, APWebView.this.callback)) {
                APLog.d(APWebView.TAG, "hookH5Method is processed");
                jsResult.cancel();
                return true;
            }
            if (APMidasPayAPI.h5PayHook(APWebView.this.mContext, APWebView.this.mWebview, str, str2, jsResult) == 0) {
                APWebView.this.callback.WebChromeClientJsAlert(webView, str, str2, jsResult);
                jsResult.cancel();
                return true;
            }
            return super.onJsAlert(webView, str, str2, jsResult);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            return APWebView.this.callback.WebChromeClientJsPrompt(webView, str, str2, str3, jsPromptResult);
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i3) {
            JsInjector.getInstance().onProgressChanged(webView, i3);
            super.onProgressChanged(webView, i3);
        }
    };
    private WebViewClient mWebViewClient = new WebViewClient() { // from class: com.tencent.midas.jsbridge.APWebView.2
        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            APLog.d(APWebView.TAG, "onPageFinished!");
            APLog.i("APWebView url == ", str);
            APWebView.this.mWebview.setVisibility(0);
            APMidasPayAPI.InnerH5PayInit(APWebView.this.mContext, APWebView.this.mWebview);
            APWebView.this.callback.WebViewClientPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            JsInjector.getInstance().onPageStarted(webView);
            super.onPageStarted(webView, str, bitmap);
            APLog.d(APWebView.TAG, "onPageStarted!");
            APWebView.this.callback.WebViewClientPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i3, String str, String str2) {
            super.onReceivedError(webView, i3, str, str2);
            APLog.d(APWebView.TAG, "onReceivedError!");
            APWebView.this.callback.WebViewClientReceivedError(webView, i3, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            APLog.d(APWebView.TAG, "shouldOverrideUrlLoading url = " + str);
            if (!str.startsWith("http://unipay.sdk.android/?") && !str.startsWith("wsj://") && !str.startsWith("mqqapi://") && !str.startsWith("weixin://") && !str.startsWith("sms://")) {
                webView.loadUrl(str);
                APLog.d(APWebView.TAG, "shouldOverrideUrlLoading loadUrl = ");
            }
            if (!str.startsWith("mqqapi://") && !str.startsWith("weixin://") && !str.startsWith("sms://")) {
                return true;
            }
            Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(str));
            if (intent.resolveActivity(APWebView.this.mContext.getPackageManager()) != null) {
                webView.getContext().startActivity(intent);
                return true;
            }
            Toast.makeText(APWebView.this.mContext, "\u62b1\u6b49\uff0c\u4f60\u672a\u5b89\u88c5\u76f8\u5e94\u5ba2\u6237\u7aef", 1).show();
            APLog.w(APWebView.TAG, "shouldOverrideUrlLoading() intent.resolveActivity == Null ");
            return true;
        }
    };

    public APWebView(Activity activity, WebView webView, IAPWebViewCallback iAPWebViewCallback) {
        this.mWebview = null;
        this.mContext = null;
        this.callback = null;
        this.mContext = activity;
        this.mWebview = webView;
        this.callback = iAPWebViewCallback;
        InitWebView();
    }

    @SuppressLint({"NewApi"})
    private void InitWebView() {
        WebSettings settings = this.mWebview.getSettings();
        settings.setJavaScriptEnabled(true);
        int i3 = Build.VERSION.SDK_INT;
        APMidasPayAPI.env.equals("test");
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);
        if (i3 < 33) {
            settings.setAppCacheEnabled(true);
            settings.setAppCachePath(this.mContext.getApplicationContext().getDir("cache", 0).getPath());
        }
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
