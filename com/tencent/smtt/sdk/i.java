package com.tencent.smtt.sdk;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.QuotaUpdater;
import com.tencent.smtt.export.external.proxy.X5ProxyWebChromeClient;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebStorage;
import com.tencent.smtt.sdk.WebView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes23.dex */
public class i extends X5ProxyWebChromeClient {

    /* renamed from: a, reason: collision with root package name */
    private WebView f369367a;

    /* renamed from: b, reason: collision with root package name */
    private WebChromeClient f369368b;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    class a implements WebStorage.QuotaUpdater {

        /* renamed from: a, reason: collision with root package name */
        QuotaUpdater f369378a;

        a(QuotaUpdater quotaUpdater) {
            this.f369378a = quotaUpdater;
        }

        @Override // com.tencent.smtt.sdk.WebStorage.QuotaUpdater
        public void updateQuota(long j3) {
            this.f369378a.updateQuota(j3);
        }
    }

    public i(IX5WebChromeClient iX5WebChromeClient, WebView webView, WebChromeClient webChromeClient) {
        super(iX5WebChromeClient);
        this.f369367a = webView;
        this.f369368b = webChromeClient;
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public Bitmap getDefaultVideoPoster() {
        return this.f369368b.getDefaultVideoPoster();
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onCloseWindow(IX5WebViewBase iX5WebViewBase) {
        this.f369367a.a(iX5WebViewBase);
        this.f369368b.onCloseWindow(this.f369367a);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onConsoleMessage(String str, int i3, String str2) {
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onCreateWindow(IX5WebViewBase iX5WebViewBase, boolean z16, boolean z17, final Message message) {
        WebView webView = this.f369367a;
        webView.getClass();
        final WebView.WebViewTransport webViewTransport = new WebView.WebViewTransport();
        Message obtain = Message.obtain(message.getTarget(), new Runnable() { // from class: com.tencent.smtt.sdk.i.1
            @Override // java.lang.Runnable
            public void run() {
                WebView webView2 = webViewTransport.getWebView();
                if (webView2 != null) {
                    ((IX5WebViewBase.WebViewTransport) message.obj).setWebView(webView2.b());
                }
                message.sendToTarget();
            }
        });
        obtain.obj = webViewTransport;
        return this.f369368b.onCreateWindow(this.f369367a, z16, z17, obtain);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onExceededDatabaseQuota(String str, String str2, long j3, long j16, long j17, QuotaUpdater quotaUpdater) {
        this.f369368b.onExceededDatabaseQuota(str, str2, j3, j16, j17, new a(quotaUpdater));
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        this.f369368b.onGeolocationPermissionsHidePrompt();
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissionsCallback geolocationPermissionsCallback) {
        this.f369368b.onGeolocationPermissionsShowPrompt(str, geolocationPermissionsCallback);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onHideCustomView() {
        this.f369368b.onHideCustomView();
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onJsAlert(IX5WebViewBase iX5WebViewBase, String str, String str2, JsResult jsResult) {
        this.f369367a.a(iX5WebViewBase);
        return this.f369368b.onJsAlert(this.f369367a, str, str2, jsResult);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onJsBeforeUnload(IX5WebViewBase iX5WebViewBase, String str, String str2, JsResult jsResult) {
        this.f369367a.a(iX5WebViewBase);
        return this.f369368b.onJsBeforeUnload(this.f369367a, str, str2, jsResult);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onJsConfirm(IX5WebViewBase iX5WebViewBase, String str, String str2, JsResult jsResult) {
        this.f369367a.a(iX5WebViewBase);
        return this.f369368b.onJsConfirm(this.f369367a, str, str2, jsResult);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onJsPrompt(IX5WebViewBase iX5WebViewBase, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        this.f369367a.a(iX5WebViewBase);
        return this.f369368b.onJsPrompt(this.f369367a, str, str2, str3, jsPromptResult);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onJsTimeout() {
        return this.f369368b.onJsTimeout();
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onProgressChanged(IX5WebViewBase iX5WebViewBase, int i3) {
        this.f369367a.a(iX5WebViewBase);
        this.f369368b.onProgressChanged(this.f369367a, i3);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onReachedMaxAppCacheSize(long j3, long j16, QuotaUpdater quotaUpdater) {
        this.f369368b.onReachedMaxAppCacheSize(j3, j16, new a(quotaUpdater));
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onReceivedIcon(IX5WebViewBase iX5WebViewBase, Bitmap bitmap) {
        this.f369367a.a(iX5WebViewBase);
        this.f369368b.onReceivedIcon(this.f369367a, bitmap);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onReceivedTitle(IX5WebViewBase iX5WebViewBase, String str) {
        this.f369367a.a(iX5WebViewBase);
        this.f369368b.onReceivedTitle(this.f369367a, str);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onReceivedTouchIconUrl(IX5WebViewBase iX5WebViewBase, String str, boolean z16) {
        this.f369367a.a(iX5WebViewBase);
        this.f369368b.onReceivedTouchIconUrl(this.f369367a, str, z16);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onRequestFocus(IX5WebViewBase iX5WebViewBase) {
        this.f369367a.a(iX5WebViewBase);
        this.f369368b.onRequestFocus(this.f369367a);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onShowCustomView(View view, IX5WebChromeClient.CustomViewCallback customViewCallback) {
        this.f369368b.onShowCustomView(view, customViewCallback);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onShowFileChooser(IX5WebViewBase iX5WebViewBase, final android.webkit.ValueCallback<Uri[]> valueCallback, final IX5WebChromeClient.FileChooserParams fileChooserParams) {
        ValueCallback<Uri[]> valueCallback2 = new ValueCallback<Uri[]>() { // from class: com.tencent.smtt.sdk.i.3
            @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceiveValue(Uri[] uriArr) {
                valueCallback.onReceiveValue(uriArr);
            }
        };
        WebChromeClient.FileChooserParams fileChooserParams2 = new WebChromeClient.FileChooserParams() { // from class: com.tencent.smtt.sdk.i.4
            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public Intent createIntent() {
                return fileChooserParams.createIntent();
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public String[] getAcceptTypes() {
                return fileChooserParams.getAcceptTypes();
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public String getFilenameHint() {
                return fileChooserParams.getFilenameHint();
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public int getMode() {
                return fileChooserParams.getMode();
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public CharSequence getTitle() {
                return fileChooserParams.getTitle();
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public boolean isCaptureEnabled() {
                return fileChooserParams.isCaptureEnabled();
            }
        };
        this.f369367a.a(iX5WebViewBase);
        return this.f369368b.onShowFileChooser(this.f369367a, valueCallback2, fileChooserParams2);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void openFileChooser(final android.webkit.ValueCallback<Uri[]> valueCallback, String str, String str2, boolean z16) {
        this.f369368b.openFileChooser(new ValueCallback<Uri>() { // from class: com.tencent.smtt.sdk.i.2
            @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceiveValue(Uri uri) {
                valueCallback.onReceiveValue(new Uri[]{uri});
            }
        }, str, str2);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return this.f369368b.onConsoleMessage(consoleMessage);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onShowCustomView(View view, int i3, IX5WebChromeClient.CustomViewCallback customViewCallback) {
        this.f369368b.onShowCustomView(view, i3, customViewCallback);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void getVisitedHistory(android.webkit.ValueCallback<String[]> valueCallback) {
    }
}
