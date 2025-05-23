package com.tencent.shadow.core.runtime;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SafeBrowsingResponse;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.pts.utils.PTSFileUtil;
import com.tencent.qimei.webview.QmWebview;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.qqlive.module.videoreport.inject.webview.webclient.ReportWebViewClient;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes25.dex */
public class ShadowWebView extends QmWebview {
    private final String ANDROID_ASSET_PREFIX;
    private final String REPLACE_ASSET_PREFIX;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class WarpWebViewClient extends WebViewClient {
        private Context mContext;
        private WebViewClient mWebViewClient;

        public WarpWebViewClient(WebViewClient webViewClient, Context context) {
            this.mWebViewClient = webViewClient;
            this.mContext = context;
        }

        private WebResourceResponse getInterceptResponse(String str) {
            String str2;
            if (str.startsWith("http://android.asset/")) {
                String substring = str.substring(21);
                if (substring.contains(".css")) {
                    str2 = "text/css";
                } else if (substring.contains(PTSFileUtil.JS_FORMAT)) {
                    str2 = "application/x-javascript";
                } else if (!substring.contains(".jpg") && !substring.contains(QzoneEmotionUtils.SIGN_ICON_URL_END) && !substring.contains(".png") && !substring.contains(".jpeg")) {
                    str2 = "text/html";
                } else {
                    str2 = "image/*";
                }
                try {
                    return new WebResourceResponse(str2, "utf-8", this.mContext.getAssets().open(substring));
                } catch (IOException unused) {
                    return null;
                }
            }
            return null;
        }

        @Override // android.webkit.WebViewClient
        public void doUpdateVisitedHistory(WebView webView, String str, boolean z16) {
            this.mWebViewClient.doUpdateVisitedHistory(webView, str, z16);
        }

        @Override // android.webkit.WebViewClient
        public void onFormResubmission(WebView webView, Message message, Message message2) {
            this.mWebViewClient.onFormResubmission(webView, message, message2);
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            this.mWebViewClient.onLoadResource(webView, str);
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(23)
        public void onPageCommitVisible(WebView webView, String str) {
            this.mWebViewClient.onPageCommitVisible(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            this.mWebViewClient.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            JsInjector.getInstance().onPageStarted(webView);
            this.mWebViewClient.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(21)
        public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
            this.mWebViewClient.onReceivedClientCertRequest(webView, clientCertRequest);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i3, String str, String str2) {
            this.mWebViewClient.onReceivedError(webView, i3, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            this.mWebViewClient.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(23)
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            this.mWebViewClient.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
            this.mWebViewClient.onReceivedLoginRequest(webView, str, str2, str3);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            this.mWebViewClient.onReceivedSslError(webView, sslErrorHandler, sslError);
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(26)
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            boolean onRenderProcessGone;
            onRenderProcessGone = this.mWebViewClient.onRenderProcessGone(webView, renderProcessGoneDetail);
            return onRenderProcessGone;
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(27)
        public void onSafeBrowsingHit(WebView webView, WebResourceRequest webResourceRequest, int i3, SafeBrowsingResponse safeBrowsingResponse) {
            this.mWebViewClient.onSafeBrowsingHit(webView, webResourceRequest, i3, safeBrowsingResponse);
        }

        @Override // android.webkit.WebViewClient
        public void onScaleChanged(WebView webView, float f16, float f17) {
            this.mWebViewClient.onScaleChanged(webView, f16, f17);
        }

        @Override // android.webkit.WebViewClient
        public void onTooManyRedirects(WebView webView, Message message, Message message2) {
            this.mWebViewClient.onTooManyRedirects(webView, message, message2);
        }

        @Override // android.webkit.WebViewClient
        public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
            this.mWebViewClient.onUnhandledKeyEvent(webView, keyEvent);
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            WebResourceResponse interceptResponse = getInterceptResponse(str);
            return interceptResponse != null ? interceptResponse : this.mWebViewClient.shouldInterceptRequest(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
            return this.mWebViewClient.shouldOverrideKeyEvent(webView, keyEvent);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return this.mWebViewClient.shouldOverrideUrlLoading(webView, str);
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(23)
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            this.mWebViewClient.onReceivedError(webView, webResourceRequest, webResourceError);
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(24)
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            boolean shouldOverrideUrlLoading;
            shouldOverrideUrlLoading = this.mWebViewClient.shouldOverrideUrlLoading(webView, webResourceRequest);
            return shouldOverrideUrlLoading;
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(21)
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            WebResourceResponse interceptResponse = getInterceptResponse(webResourceRequest.getUrl().toString());
            return interceptResponse != null ? interceptResponse : this.mWebViewClient.shouldInterceptRequest(webView, webResourceRequest);
        }
    }

    public ShadowWebView(Context context) {
        super(context);
        this.ANDROID_ASSET_PREFIX = "file:///android_asset/";
        this.REPLACE_ASSET_PREFIX = "http://android.asset/";
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setWebViewClient(new ReportWebViewClient());
    }

    @Override // com.tencent.qimei.webview.QmWebview, com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.DtWebView, android.webkit.WebView
    public void loadUrl(String str) {
        if (str.startsWith("file:///android_asset/")) {
            str = str.replace("file:///android_asset/", "http://android.asset/");
        }
        super.loadUrl(str);
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(new WarpWebViewClient(webViewClient, this.mContext));
    }

    public ShadowWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ANDROID_ASSET_PREFIX = "file:///android_asset/";
        this.REPLACE_ASSET_PREFIX = "http://android.asset/";
        init(context);
    }

    public ShadowWebView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.ANDROID_ASSET_PREFIX = "file:///android_asset/";
        this.REPLACE_ASSET_PREFIX = "http://android.asset/";
        init(context);
    }

    @TargetApi(21)
    public ShadowWebView(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        this.ANDROID_ASSET_PREFIX = "file:///android_asset/";
        this.REPLACE_ASSET_PREFIX = "http://android.asset/";
        init(context);
    }

    public ShadowWebView(Context context, AttributeSet attributeSet, int i3, boolean z16) {
        super(context, attributeSet, i3, z16);
        this.ANDROID_ASSET_PREFIX = "file:///android_asset/";
        this.REPLACE_ASSET_PREFIX = "http://android.asset/";
        init(context);
    }
}
