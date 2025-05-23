package com.tencent.smtt.sdk;

import android.R;
import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebStorage;
import com.tencent.smtt.sdk.WebView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes23.dex */
public class SystemWebChromeClient extends android.webkit.WebChromeClient {

    /* renamed from: a, reason: collision with root package name */
    protected WebChromeClient f369032a;

    /* renamed from: b, reason: collision with root package name */
    private WebView f369033b;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    class b implements IX5WebChromeClient.CustomViewCallback {

        /* renamed from: a, reason: collision with root package name */
        WebChromeClient.CustomViewCallback f369053a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(WebChromeClient.CustomViewCallback customViewCallback) {
            this.f369053a = customViewCallback;
        }

        @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback
        public void onCustomViewHidden() {
            this.f369053a.onCustomViewHidden();
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    class c implements GeolocationPermissionsCallback {

        /* renamed from: a, reason: collision with root package name */
        GeolocationPermissions.Callback f369055a;

        c(GeolocationPermissions.Callback callback) {
            this.f369055a = callback;
        }

        @Override // com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback
        public void invoke(String str, boolean z16, boolean z17) {
            this.f369055a.invoke(str, z16, z17);
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    private class d implements JsPromptResult {

        /* renamed from: a, reason: collision with root package name */
        android.webkit.JsPromptResult f369057a;

        d(android.webkit.JsPromptResult jsPromptResult) {
            this.f369057a = jsPromptResult;
        }

        @Override // com.tencent.smtt.export.external.interfaces.JsResult
        public void cancel() {
            this.f369057a.cancel();
        }

        @Override // com.tencent.smtt.export.external.interfaces.JsResult
        public void confirm() {
            this.f369057a.confirm();
        }

        @Override // com.tencent.smtt.export.external.interfaces.JsPromptResult
        public void confirm(String str) {
            this.f369057a.confirm(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    private class e implements JsResult {

        /* renamed from: a, reason: collision with root package name */
        android.webkit.JsResult f369059a;

        e(android.webkit.JsResult jsResult) {
            this.f369059a = jsResult;
        }

        @Override // com.tencent.smtt.export.external.interfaces.JsResult
        public void cancel() {
            this.f369059a.cancel();
        }

        @Override // com.tencent.smtt.export.external.interfaces.JsResult
        public void confirm() {
            this.f369059a.confirm();
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    class f implements WebStorage.QuotaUpdater {

        /* renamed from: a, reason: collision with root package name */
        WebStorage.QuotaUpdater f369061a;

        f(WebStorage.QuotaUpdater quotaUpdater) {
            this.f369061a = quotaUpdater;
        }

        @Override // com.tencent.smtt.sdk.WebStorage.QuotaUpdater
        public void updateQuota(long j3) {
            this.f369061a.updateQuota(j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SystemWebChromeClient(WebView webView, WebChromeClient webChromeClient) {
        this.f369033b = webView;
        this.f369032a = webChromeClient;
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(7)
    public Bitmap getDefaultVideoPoster() {
        Bitmap defaultVideoPoster = this.f369032a.getDefaultVideoPoster();
        if (defaultVideoPoster == null) {
            try {
                if (Build.VERSION.SDK_INT >= 24) {
                    return BitmapFactory.decodeResource(this.f369033b.getResources(), R.drawable.ic_media_play);
                }
                return defaultVideoPoster;
            } catch (Exception unused) {
                return defaultVideoPoster;
            }
        }
        return defaultVideoPoster;
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(7)
    public View getVideoLoadingProgressView() {
        return this.f369032a.getVideoLoadingProgressView();
    }

    @Override // android.webkit.WebChromeClient
    public void getVisitedHistory(final android.webkit.ValueCallback<String[]> valueCallback) {
        this.f369032a.getVisitedHistory(new ValueCallback<String[]>() { // from class: com.tencent.smtt.sdk.SystemWebChromeClient.1
            @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceiveValue(String[] strArr) {
                valueCallback.onReceiveValue(strArr);
            }
        });
    }

    @Override // android.webkit.WebChromeClient
    public void onCloseWindow(android.webkit.WebView webView) {
        this.f369033b.a(webView);
        this.f369032a.onCloseWindow(this.f369033b);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return this.f369032a.onConsoleMessage(new a(consoleMessage));
    }

    @Override // android.webkit.WebChromeClient
    public boolean onCreateWindow(android.webkit.WebView webView, boolean z16, boolean z17, final Message message) {
        WebView webView2 = this.f369033b;
        webView2.getClass();
        final WebView.WebViewTransport webViewTransport = new WebView.WebViewTransport();
        Message obtain = Message.obtain(message.getTarget(), new Runnable() { // from class: com.tencent.smtt.sdk.SystemWebChromeClient.2
            @Override // java.lang.Runnable
            public void run() {
                WebView webView3 = webViewTransport.getWebView();
                if (webView3 != null) {
                    ((WebView.WebViewTransport) message.obj).setWebView(webView3.a());
                }
                message.sendToTarget();
            }
        });
        obtain.obj = webViewTransport;
        return this.f369032a.onCreateWindow(this.f369033b, z16, z17, obtain);
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(5)
    @Deprecated
    public void onExceededDatabaseQuota(String str, String str2, long j3, long j16, long j17, WebStorage.QuotaUpdater quotaUpdater) {
        this.f369032a.onExceededDatabaseQuota(str, str2, j3, j16, j17, new f(quotaUpdater));
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(5)
    public void onGeolocationPermissionsHidePrompt() {
        this.f369032a.onGeolocationPermissionsHidePrompt();
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(5)
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        this.f369032a.onGeolocationPermissionsShowPrompt(str, new c(callback));
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(android.webkit.WebView webView, String str, String str2, android.webkit.JsResult jsResult) {
        this.f369033b.a(webView);
        return this.f369032a.onJsAlert(this.f369033b, str, str2, new e(jsResult));
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(android.webkit.WebView webView, String str, String str2, android.webkit.JsResult jsResult) {
        this.f369033b.a(webView);
        return this.f369032a.onJsBeforeUnload(this.f369033b, str, str2, new e(jsResult));
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(android.webkit.WebView webView, String str, String str2, android.webkit.JsResult jsResult) {
        this.f369033b.a(webView);
        return this.f369032a.onJsConfirm(this.f369033b, str, str2, new e(jsResult));
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(android.webkit.WebView webView, String str, String str2, String str3, android.webkit.JsPromptResult jsPromptResult) {
        this.f369033b.a(webView);
        return this.f369032a.onJsPrompt(this.f369033b, str, str2, str3, new d(jsPromptResult));
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(7)
    public boolean onJsTimeout() {
        return this.f369032a.onJsTimeout();
    }

    @Override // android.webkit.WebChromeClient
    public void onPermissionRequest(final PermissionRequest permissionRequest) {
        this.f369032a.onPermissionRequest(new com.tencent.smtt.export.external.interfaces.PermissionRequest() { // from class: com.tencent.smtt.sdk.SystemWebChromeClient.6
            @Override // com.tencent.smtt.export.external.interfaces.PermissionRequest
            public void deny() {
                permissionRequest.deny();
            }

            @Override // com.tencent.smtt.export.external.interfaces.PermissionRequest
            public Uri getOrigin() {
                return permissionRequest.getOrigin();
            }

            @Override // com.tencent.smtt.export.external.interfaces.PermissionRequest
            public String[] getResources() {
                return permissionRequest.getResources();
            }

            @Override // com.tencent.smtt.export.external.interfaces.PermissionRequest
            public void grant(String[] strArr) {
                permissionRequest.grant(strArr);
            }
        });
    }

    @Override // android.webkit.WebChromeClient
    public void onPermissionRequestCanceled(final PermissionRequest permissionRequest) {
        this.f369032a.onPermissionRequestCanceled(new com.tencent.smtt.export.external.interfaces.PermissionRequest() { // from class: com.tencent.smtt.sdk.SystemWebChromeClient.7
            @Override // com.tencent.smtt.export.external.interfaces.PermissionRequest
            public void deny() {
                permissionRequest.deny();
            }

            @Override // com.tencent.smtt.export.external.interfaces.PermissionRequest
            public Uri getOrigin() {
                return permissionRequest.getOrigin();
            }

            @Override // com.tencent.smtt.export.external.interfaces.PermissionRequest
            public String[] getResources() {
                return permissionRequest.getResources();
            }

            @Override // com.tencent.smtt.export.external.interfaces.PermissionRequest
            public void grant(String[] strArr) {
                permissionRequest.grant(strArr);
            }
        });
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(android.webkit.WebView webView, int i3) {
        JsInjector.getInstance().onProgressChanged(webView, i3);
        this.f369033b.a(webView);
        this.f369032a.onProgressChanged(this.f369033b, i3);
    }

    @TargetApi(7)
    @Deprecated
    public void onReachedMaxAppCacheSize(long j3, long j16, WebStorage.QuotaUpdater quotaUpdater) {
        this.f369032a.onReachedMaxAppCacheSize(j3, j16, new f(quotaUpdater));
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedIcon(android.webkit.WebView webView, Bitmap bitmap) {
        this.f369033b.a(webView);
        this.f369032a.onReceivedIcon(this.f369033b, bitmap);
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(android.webkit.WebView webView, String str) {
        this.f369033b.a(webView);
        this.f369032a.onReceivedTitle(this.f369033b, str);
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(7)
    public void onReceivedTouchIconUrl(android.webkit.WebView webView, String str, boolean z16) {
        this.f369033b.a(webView);
        this.f369032a.onReceivedTouchIconUrl(this.f369033b, str, z16);
    }

    @Override // android.webkit.WebChromeClient
    public void onRequestFocus(android.webkit.WebView webView) {
        this.f369033b.a(webView);
        this.f369032a.onRequestFocus(this.f369033b);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(android.webkit.WebView webView, final android.webkit.ValueCallback<Uri[]> valueCallback, final WebChromeClient.FileChooserParams fileChooserParams) {
        ValueCallback<Uri[]> valueCallback2 = new ValueCallback<Uri[]>() { // from class: com.tencent.smtt.sdk.SystemWebChromeClient.4
            @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceiveValue(Uri[] uriArr) {
                valueCallback.onReceiveValue(uriArr);
            }
        };
        WebChromeClient.FileChooserParams fileChooserParams2 = new WebChromeClient.FileChooserParams() { // from class: com.tencent.smtt.sdk.SystemWebChromeClient.5
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
        this.f369033b.a(webView);
        return this.f369032a.onShowFileChooser(this.f369033b, valueCallback2, fileChooserParams2);
    }

    public void openFileChooser(android.webkit.ValueCallback<Uri> valueCallback) {
        openFileChooser(valueCallback, null, null);
    }

    @Override // android.webkit.WebChromeClient
    public void onConsoleMessage(String str, int i3, String str2) {
        this.f369032a.onConsoleMessage(new a(str, str2, i3));
    }

    public void openFileChooser(android.webkit.ValueCallback<Uri> valueCallback, String str) {
        openFileChooser(valueCallback, str, null);
    }

    public void openFileChooser(final android.webkit.ValueCallback<Uri> valueCallback, String str, String str2) {
        this.f369032a.openFileChooser(new ValueCallback<Uri>() { // from class: com.tencent.smtt.sdk.SystemWebChromeClient.3
            @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceiveValue(Uri uri) {
                valueCallback.onReceiveValue(uri);
            }
        }, str, str2);
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    private static class a implements com.tencent.smtt.export.external.interfaces.ConsoleMessage {

        /* renamed from: a, reason: collision with root package name */
        private ConsoleMessage.MessageLevel f369049a;

        /* renamed from: b, reason: collision with root package name */
        private String f369050b;

        /* renamed from: c, reason: collision with root package name */
        private String f369051c;

        /* renamed from: d, reason: collision with root package name */
        private int f369052d;

        a(android.webkit.ConsoleMessage consoleMessage) {
            this.f369049a = ConsoleMessage.MessageLevel.valueOf(consoleMessage.messageLevel().name());
            this.f369050b = consoleMessage.message();
            this.f369051c = consoleMessage.sourceId();
            this.f369052d = consoleMessage.lineNumber();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ConsoleMessage
        public int lineNumber() {
            return this.f369052d;
        }

        @Override // com.tencent.smtt.export.external.interfaces.ConsoleMessage
        public String message() {
            return this.f369050b;
        }

        @Override // com.tencent.smtt.export.external.interfaces.ConsoleMessage
        public ConsoleMessage.MessageLevel messageLevel() {
            return this.f369049a;
        }

        @Override // com.tencent.smtt.export.external.interfaces.ConsoleMessage
        public String sourceId() {
            return this.f369051c;
        }

        a(String str, String str2, int i3) {
            this.f369049a = ConsoleMessage.MessageLevel.LOG;
            this.f369050b = str;
            this.f369051c = str2;
            this.f369052d = i3;
        }
    }

    public void setupAutoFill(Message message) {
    }
}
