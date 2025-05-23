package com.huawei.secure.android.common.webview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SafeBrowsingResponse;
import android.webkit.SslErrorHandler;
import android.webkit.URLUtil;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.huawei.secure.android.common.util.LogsUtil;
import com.huawei.secure.android.common.webview.WebViewLoadCallBack;
import com.tencent.qimei.webview.QmWebview;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import java.util.Arrays;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class SafeWebView extends QmWebview {

    /* renamed from: f, reason: collision with root package name */
    private static final String f38048f = "SafeWebView";

    /* renamed from: a, reason: collision with root package name */
    private String f38049a;

    /* renamed from: b, reason: collision with root package name */
    private String[] f38050b;

    /* renamed from: c, reason: collision with root package name */
    private String[] f38051c;

    /* renamed from: d, reason: collision with root package name */
    private String[] f38052d;

    /* renamed from: e, reason: collision with root package name */
    private WebViewLoadCallBack f38053e;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static class b implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        private final SslErrorHandler f38054a;

        b(SslErrorHandler sslErrorHandler) {
            this.f38054a = sslErrorHandler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            this.f38054a.cancel();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static class c implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        private final SslErrorHandler f38055a;

        c(SslErrorHandler sslErrorHandler) {
            this.f38055a = sslErrorHandler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            this.f38055a.proceed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public final class d extends WebViewClient {

        /* renamed from: a, reason: collision with root package name */
        private WebViewClient f38056a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f38057b;

        @Override // android.webkit.WebViewClient
        public void doUpdateVisitedHistory(WebView webView, String str, boolean z16) {
            WebViewClient webViewClient = this.f38056a;
            if (webViewClient != null) {
                webViewClient.doUpdateVisitedHistory(webView, str, z16);
            } else {
                super.doUpdateVisitedHistory(webView, str, z16);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onFormResubmission(WebView webView, Message message, Message message2) {
            WebViewClient webViewClient = this.f38056a;
            if (webViewClient != null) {
                webViewClient.onFormResubmission(webView, message, message2);
            } else {
                super.onFormResubmission(webView, message, message2);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            WebViewClient webViewClient = this.f38056a;
            if (webViewClient != null) {
                webViewClient.onLoadResource(webView, str);
            } else {
                super.onLoadResource(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(23)
        public void onPageCommitVisible(WebView webView, String str) {
            WebViewClient webViewClient = this.f38056a;
            if (webViewClient != null) {
                webViewClient.onPageCommitVisible(webView, str);
            } else {
                super.onPageCommitVisible(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            WebViewClient webViewClient = this.f38056a;
            if (webViewClient != null) {
                webViewClient.onPageFinished(webView, str);
            } else {
                super.onPageFinished(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            JsInjector.getInstance().onPageStarted(webView);
            WebViewClient webViewClient = this.f38056a;
            if (webViewClient != null && !this.f38057b) {
                webViewClient.onPageStarted(webView, str, bitmap);
            } else if (!SafeWebView.this.isWhiteListUrl(str)) {
                SafeWebView.this.onCheckError(webView, str);
            } else {
                super.onPageStarted(webView, str, bitmap);
            }
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(21)
        public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
            WebViewClient webViewClient = this.f38056a;
            if (webViewClient != null) {
                webViewClient.onReceivedClientCertRequest(webView, clientCertRequest);
            } else {
                super.onReceivedClientCertRequest(webView, clientCertRequest);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i3, String str, String str2) {
            WebViewClient webViewClient = this.f38056a;
            if (webViewClient != null) {
                webViewClient.onReceivedError(webView, i3, str, str2);
            } else {
                super.onReceivedError(webView, i3, str, str2);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            WebViewClient webViewClient = this.f38056a;
            if (webViewClient != null) {
                webViewClient.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
            } else {
                super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
            }
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(23)
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            WebViewClient webViewClient = this.f38056a;
            if (webViewClient != null) {
                webViewClient.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            } else {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(12)
        public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
            WebViewClient webViewClient = this.f38056a;
            if (webViewClient != null) {
                webViewClient.onReceivedLoginRequest(webView, str, str2, str3);
            } else {
                super.onReceivedLoginRequest(webView, str, str2, str3);
            }
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(8)
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            WebViewClient webViewClient = this.f38056a;
            if (webViewClient != null) {
                webViewClient.onReceivedSslError(webView, sslErrorHandler, sslError);
            } else {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            }
        }

        @Override // android.webkit.WebViewClient
        @SuppressLint({"NewApi"})
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            boolean onRenderProcessGone;
            WebViewClient webViewClient = this.f38056a;
            if (webViewClient != null) {
                onRenderProcessGone = webViewClient.onRenderProcessGone(webView, renderProcessGoneDetail);
                return onRenderProcessGone;
            }
            return super.onRenderProcessGone(webView, renderProcessGoneDetail);
        }

        @Override // android.webkit.WebViewClient
        @SuppressLint({"NewApi"})
        public void onSafeBrowsingHit(WebView webView, WebResourceRequest webResourceRequest, int i3, SafeBrowsingResponse safeBrowsingResponse) {
            WebViewClient webViewClient = this.f38056a;
            if (webViewClient != null) {
                webViewClient.onSafeBrowsingHit(webView, webResourceRequest, i3, safeBrowsingResponse);
            } else {
                super.onSafeBrowsingHit(webView, webResourceRequest, i3, safeBrowsingResponse);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onScaleChanged(WebView webView, float f16, float f17) {
            WebViewClient webViewClient = this.f38056a;
            if (webViewClient != null) {
                webViewClient.onScaleChanged(webView, f16, f17);
            } else {
                super.onScaleChanged(webView, f16, f17);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onTooManyRedirects(WebView webView, Message message, Message message2) {
            WebViewClient webViewClient = this.f38056a;
            if (webViewClient != null) {
                webViewClient.onTooManyRedirects(webView, message, message2);
            } else {
                super.onTooManyRedirects(webView, message, message2);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
            WebViewClient webViewClient = this.f38056a;
            if (webViewClient != null) {
                webViewClient.onUnhandledKeyEvent(webView, keyEvent);
            } else {
                super.onUnhandledKeyEvent(webView, keyEvent);
            }
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(21)
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            WebViewClient webViewClient = this.f38056a;
            if (webViewClient != null) {
                return webViewClient.shouldInterceptRequest(webView, webResourceRequest);
            }
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
            WebViewClient webViewClient = this.f38056a;
            if (webViewClient != null) {
                return webViewClient.shouldOverrideKeyEvent(webView, keyEvent);
            }
            return super.shouldOverrideKeyEvent(webView, keyEvent);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            WebViewClient webViewClient = this.f38056a;
            if (webViewClient != null) {
                return webViewClient.shouldOverrideUrlLoading(webView, str);
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        d(WebViewClient webViewClient, boolean z16) {
            this.f38056a = webViewClient;
            this.f38057b = z16;
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(23)
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            WebViewClient webViewClient = this.f38056a;
            if (webViewClient != null) {
                webViewClient.onReceivedError(webView, webResourceRequest, webResourceError);
            } else {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(11)
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            WebViewClient webViewClient = this.f38056a;
            if (webViewClient != null) {
                return webViewClient.shouldInterceptRequest(webView, str);
            }
            return super.shouldInterceptRequest(webView, str);
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(24)
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            boolean shouldOverrideUrlLoading;
            WebViewClient webViewClient = this.f38056a;
            if (webViewClient != null) {
                shouldOverrideUrlLoading = webViewClient.shouldOverrideUrlLoading(webView, webResourceRequest);
                return shouldOverrideUrlLoading;
            }
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }
    }

    public SafeWebView(Context context) {
        super(context);
        a();
    }

    private boolean a(String str) {
        return URLUtil.isHttpUrl(str);
    }

    public String getDefaultErrorPage() {
        return this.f38049a;
    }

    public WebViewLoadCallBack getWebViewLoadCallBack() {
        return this.f38053e;
    }

    @TargetApi(9)
    @Deprecated
    public String[] getWhitelist() {
        String[] strArr = this.f38050b;
        if (strArr == null) {
            return null;
        }
        return (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    public String[] getWhitelistNotMatchSubDomain() {
        String[] strArr = this.f38051c;
        if (strArr == null) {
            return null;
        }
        return (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    @Deprecated
    public String[] getWhitelistNotMathcSubDomain() {
        String[] strArr = this.f38051c;
        if (strArr == null) {
            return null;
        }
        return (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    @TargetApi(9)
    public String[] getWhitelistWithPath() {
        String[] strArr = this.f38052d;
        if (strArr == null) {
            return null;
        }
        return (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    @TargetApi(9)
    public boolean isWhiteListUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            LogsUtil.e(f38048f, "url is null");
            return false;
        }
        if (!URLUtil.isNetworkUrl(str)) {
            return true;
        }
        String[] whitelistWithPath = getWhitelistWithPath();
        String[] whitelistNotMatchSubDomain = getWhitelistNotMatchSubDomain();
        String[] whitelist = getWhitelist();
        if (whitelistWithPath != null && whitelistWithPath.length != 0) {
            return UriUtil.isUrlHostAndPathInWhitelist(str, whitelistWithPath);
        }
        if (whitelistNotMatchSubDomain != null && whitelistNotMatchSubDomain.length != 0) {
            return UriUtil.isUrlHostSameWhitelist(str, whitelistNotMatchSubDomain);
        }
        return UriUtil.isUrlHostInWhitelist(str, whitelist);
    }

    @Override // com.tencent.qimei.webview.QmWebview, com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.DtWebView, android.webkit.WebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (a(str)) {
            Log.e(f38048f, "loadDataWithBaseURL: http url , not safe");
            if (!TextUtils.isEmpty(this.f38049a)) {
                super.loadDataWithBaseURL(this.f38049a, str2, str3, str4, str5);
                return;
            } else {
                if (getWebViewLoadCallBack() != null) {
                    Log.e(f38048f, "WebViewLoadCallBack");
                    getWebViewLoadCallBack().onCheckError(str, WebViewLoadCallBack.ErrorCode.HTTP_URL);
                    return;
                }
                return;
            }
        }
        super.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @Override // com.tencent.qimei.webview.QmWebview, com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.DtWebView, android.webkit.WebView
    public void loadUrl(String str) {
        if (a(str)) {
            Log.e(f38048f, "loadUrl: http url , not safe");
            if (!TextUtils.isEmpty(this.f38049a)) {
                super.loadUrl(this.f38049a);
                return;
            } else {
                if (getWebViewLoadCallBack() != null) {
                    Log.e(f38048f, "WebViewLoadCallBack");
                    getWebViewLoadCallBack().onCheckError(str, WebViewLoadCallBack.ErrorCode.HTTP_URL);
                    return;
                }
                return;
            }
        }
        super.loadUrl(str);
    }

    public final void onCheckError(WebView webView, String str) {
        LogsUtil.e(f38048f, "onCheckError url is not in white list ", str);
        webView.stopLoading();
        String defaultErrorPage = getDefaultErrorPage();
        if (!TextUtils.isEmpty(defaultErrorPage)) {
            webView.loadUrl(defaultErrorPage);
        } else if (getWebViewLoadCallBack() != null) {
            Log.e(f38048f, "onPageStarted WebViewLoadCallBack");
            getWebViewLoadCallBack().onCheckError(str, WebViewLoadCallBack.ErrorCode.URL_NOT_IN_WHITE_LIST);
        }
    }

    @Override // android.webkit.WebView
    public void postUrl(String str, byte[] bArr) {
        if (a(str)) {
            Log.e(f38048f, "postUrl: http url , not safe");
            if (!TextUtils.isEmpty(this.f38049a)) {
                super.postUrl(this.f38049a, bArr);
                return;
            } else {
                if (getWebViewLoadCallBack() != null) {
                    Log.e(f38048f, "WebViewLoadCallBack");
                    getWebViewLoadCallBack().onCheckError(str, WebViewLoadCallBack.ErrorCode.HTTP_URL);
                    return;
                }
                return;
            }
        }
        super.postUrl(str, bArr);
    }

    public void setDefaultErrorPage(String str) {
        this.f38049a = str;
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(new d(webViewClient, true));
    }

    public void setWebViewLoadCallBack(WebViewLoadCallBack webViewLoadCallBack) {
        this.f38053e = webViewLoadCallBack;
    }

    @TargetApi(9)
    @Deprecated
    public void setWhitelist(String[] strArr) {
        String[] strArr2;
        if (strArr == null) {
            strArr2 = null;
        } else {
            strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
        }
        this.f38050b = strArr2;
    }

    public void setWhitelistNotMatchSubDomain(String[] strArr) {
        String[] strArr2;
        if (strArr == null) {
            strArr2 = null;
        } else {
            strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
        }
        this.f38051c = strArr2;
    }

    @Deprecated
    public void setWhitelistNotMathcSubDomain(String[] strArr) {
        String[] strArr2;
        if (strArr == null) {
            strArr2 = null;
        } else {
            strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
        }
        this.f38051c = strArr2;
    }

    @TargetApi(9)
    public void setWhitelistWithPath(String[] strArr) {
        String[] strArr2;
        if (strArr == null) {
            strArr2 = null;
        } else {
            strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
        }
        this.f38052d = strArr2;
    }

    @Deprecated
    protected final void showNoticeWhenSSLErrorOccurred(String str, String str2, String str3, String str4, SslErrorHandler sslErrorHandler) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        if (!TextUtils.isEmpty(str)) {
            builder.setTitle(str);
        }
        c cVar = new c(sslErrorHandler);
        b bVar = new b(sslErrorHandler);
        builder.setMessage(str2);
        builder.setPositiveButton(str3, cVar);
        builder.setNegativeButton(str4, bVar);
        builder.create().show();
    }

    private void a() {
        SafeWebSettings.initWebviewAndSettings(this);
        setWebViewClient(null);
    }

    public void setWebViewClient(WebViewClient webViewClient, boolean z16) {
        super.setWebViewClient(new d(webViewClient, z16));
    }

    public SafeWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public SafeWebView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a();
    }

    @TargetApi(21)
    public SafeWebView(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        a();
    }

    @Override // com.tencent.qimei.webview.QmWebview, com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.DtWebView, android.webkit.WebView
    public void loadUrl(String str, Map<String, String> map) {
        if (a(str)) {
            Log.e(f38048f, "loadUrl: http url , not safe");
            if (!TextUtils.isEmpty(this.f38049a)) {
                super.loadUrl(this.f38049a, map);
                return;
            } else {
                if (getWebViewLoadCallBack() != null) {
                    Log.e(f38048f, "WebViewLoadCallBack");
                    getWebViewLoadCallBack().onCheckError(str, WebViewLoadCallBack.ErrorCode.HTTP_URL);
                    return;
                }
                return;
            }
        }
        super.loadUrl(str, map);
    }
}
