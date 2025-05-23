package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Build;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.interfaces.ClientCertRequest;
import com.tencent.smtt.export.external.interfaces.HttpAuthHandler;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.InputStream;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@SuppressLint({"NewApi", "Override"})
/* loaded from: classes23.dex */
public class SystemWebViewClient extends android.webkit.WebViewClient {

    /* renamed from: c, reason: collision with root package name */
    private static String f369063c;

    /* renamed from: a, reason: collision with root package name */
    private WebViewClient f369064a;

    /* renamed from: b, reason: collision with root package name */
    private WebView f369065b;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    private static class a extends ClientCertRequest {

        /* renamed from: a, reason: collision with root package name */
        private android.webkit.ClientCertRequest f369071a;

        public a(android.webkit.ClientCertRequest clientCertRequest) {
            this.f369071a = clientCertRequest;
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public void cancel() {
            this.f369071a.cancel();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public String getHost() {
            return this.f369071a.getHost();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public String[] getKeyTypes() {
            return this.f369071a.getKeyTypes();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public int getPort() {
            return this.f369071a.getPort();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public Principal[] getPrincipals() {
            return this.f369071a.getPrincipals();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public void ignore() {
            this.f369071a.ignore();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public void proceed(PrivateKey privateKey, X509Certificate[] x509CertificateArr) {
            this.f369071a.proceed(privateKey, x509CertificateArr);
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    private static class b implements HttpAuthHandler {

        /* renamed from: a, reason: collision with root package name */
        private android.webkit.HttpAuthHandler f369072a;

        b(android.webkit.HttpAuthHandler httpAuthHandler) {
            this.f369072a = httpAuthHandler;
        }

        @Override // com.tencent.smtt.export.external.interfaces.HttpAuthHandler
        public void cancel() {
            this.f369072a.cancel();
        }

        @Override // com.tencent.smtt.export.external.interfaces.HttpAuthHandler
        public void proceed(String str, String str2) {
            this.f369072a.proceed(str, str2);
        }

        @Override // com.tencent.smtt.export.external.interfaces.HttpAuthHandler
        public boolean useHttpAuthUsernamePassword() {
            return this.f369072a.useHttpAuthUsernamePassword();
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    private static class c implements SslErrorHandler {

        /* renamed from: a, reason: collision with root package name */
        android.webkit.SslErrorHandler f369073a;

        c(android.webkit.SslErrorHandler sslErrorHandler) {
            this.f369073a = sslErrorHandler;
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslErrorHandler
        public void cancel() {
            this.f369073a.cancel();
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslErrorHandler
        public void proceed() {
            this.f369073a.proceed();
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    private static class d implements SslError {

        /* renamed from: a, reason: collision with root package name */
        android.net.http.SslError f369074a;

        d(android.net.http.SslError sslError) {
            this.f369074a = sslError;
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslError
        public boolean addError(int i3) {
            return this.f369074a.addError(i3);
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslError
        public SslCertificate getCertificate() {
            return this.f369074a.getCertificate();
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslError
        public int getPrimaryError() {
            return this.f369074a.getPrimaryError();
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslError
        public String getUrl() {
            return this.f369074a.getUrl();
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslError
        public boolean hasError(int i3) {
            return this.f369074a.hasError(i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    static class e implements WebResourceRequest {

        /* renamed from: a, reason: collision with root package name */
        private String f369075a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f369076b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f369077c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f369078d;

        /* renamed from: e, reason: collision with root package name */
        private String f369079e;

        /* renamed from: f, reason: collision with root package name */
        private Map<String, String> f369080f;

        public e(String str, boolean z16, boolean z17, boolean z18, String str2, Map<String, String> map) {
            this.f369075a = str;
            this.f369076b = z16;
            this.f369077c = z17;
            this.f369078d = z18;
            this.f369079e = str2;
            this.f369080f = map;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public String getMethod() {
            return this.f369079e;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public Map<String, String> getRequestHeaders() {
            return this.f369080f;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public Uri getUrl() {
            return Uri.parse(this.f369075a);
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean hasGesture() {
            return this.f369078d;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean isForMainFrame() {
            return this.f369076b;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean isRedirect() {
            return this.f369077c;
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    private static class f implements WebResourceRequest {

        /* renamed from: a, reason: collision with root package name */
        android.webkit.WebResourceRequest f369081a;

        f(android.webkit.WebResourceRequest webResourceRequest) {
            this.f369081a = webResourceRequest;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public String getMethod() {
            return this.f369081a.getMethod();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public Map<String, String> getRequestHeaders() {
            return this.f369081a.getRequestHeaders();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public Uri getUrl() {
            return this.f369081a.getUrl();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean hasGesture() {
            return this.f369081a.hasGesture();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean isForMainFrame() {
            return this.f369081a.isForMainFrame();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean isRedirect() {
            if (Build.VERSION.SDK_INT >= 24) {
                Object a16 = com.tencent.smtt.utils.k.a(this.f369081a, "isRedirect");
                if (a16 instanceof Boolean) {
                    return ((Boolean) a16).booleanValue();
                }
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    private static class g extends WebResourceResponse {

        /* renamed from: a, reason: collision with root package name */
        android.webkit.WebResourceResponse f369082a;

        public g(android.webkit.WebResourceResponse webResourceResponse) {
            this.f369082a = webResourceResponse;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public InputStream getData() {
            return this.f369082a.getData();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public String getEncoding() {
            return this.f369082a.getEncoding();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public String getMimeType() {
            return this.f369082a.getMimeType();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public String getReasonPhrase() {
            return this.f369082a.getReasonPhrase();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public Map<String, String> getResponseHeaders() {
            return this.f369082a.getResponseHeaders();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public int getStatusCode() {
            return this.f369082a.getStatusCode();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public void setData(InputStream inputStream) {
            this.f369082a.setData(inputStream);
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public void setEncoding(String str) {
            this.f369082a.setEncoding(str);
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public void setMimeType(String str) {
            this.f369082a.setMimeType(str);
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public void setResponseHeaders(Map<String, String> map) {
            this.f369082a.setResponseHeaders(map);
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public void setStatusCodeAndReasonPhrase(int i3, String str) {
            this.f369082a.setStatusCodeAndReasonPhrase(i3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SystemWebViewClient(WebView webView, WebViewClient webViewClient) {
        this.f369065b = webView;
        this.f369064a = webViewClient;
    }

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(android.webkit.WebView webView, String str, boolean z16) {
        this.f369065b.a(webView);
        this.f369064a.doUpdateVisitedHistory(this.f369065b, str, z16);
    }

    @Override // android.webkit.WebViewClient
    public void onFormResubmission(android.webkit.WebView webView, Message message, Message message2) {
        this.f369065b.a(webView);
        this.f369064a.onFormResubmission(this.f369065b, message, message2);
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(android.webkit.WebView webView, String str) {
        this.f369065b.a(webView);
        this.f369064a.onLoadResource(this.f369065b, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageCommitVisible(android.webkit.WebView webView, String str) {
        this.f369065b.a(webView);
        this.f369064a.onPageCommitVisible(this.f369065b, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(android.webkit.WebView webView, String str) {
        com.tencent.smtt.utils.q a16;
        TbsPrivacyAccess.rmPrivacyItemIfNeeded(webView.getContext().getApplicationContext());
        if (f369063c == null && (a16 = com.tencent.smtt.utils.q.a()) != null) {
            a16.a(true);
            f369063c = Boolean.toString(true);
        }
        this.f369065b.a(webView);
        this.f369065b.f369210a++;
        this.f369064a.onPageFinished(this.f369065b, str);
        WebView.c();
        if (!TbsShareManager.mHasQueried && this.f369065b.getContext() != null && TbsShareManager.isThirdPartyApp(this.f369065b.getContext()) && !QbSdk.d()) {
            TbsShareManager.mHasQueried = true;
            new BaseThread(new Runnable() { // from class: com.tencent.smtt.sdk.SystemWebViewClient.1
                @Override // java.lang.Runnable
                public void run() {
                    TbsDownloader.needDownload(SystemWebViewClient.this.f369065b.getContext(), false);
                }
            }).start();
        }
        if (this.f369065b.getContext() != null && !TbsLogReport.getInstance(this.f369065b.getContext()).getShouldUploadEventReport()) {
            TbsLogReport.getInstance(this.f369065b.getContext()).setShouldUploadEventReport(true);
            TbsLogReport.getInstance(this.f369065b.getContext()).dailyReport();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(android.webkit.WebView webView, String str, Bitmap bitmap) {
        JsInjector.getInstance().onPageStarted(webView);
        this.f369065b.a(webView);
        this.f369064a.onPageStarted(this.f369065b, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedClientCertRequest(android.webkit.WebView webView, android.webkit.ClientCertRequest clientCertRequest) {
        this.f369065b.a(webView);
        this.f369064a.onReceivedClientCertRequest(this.f369065b, new a(clientCertRequest));
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(android.webkit.WebView webView, int i3, String str, String str2) {
        this.f369065b.a(webView);
        this.f369064a.onReceivedError(this.f369065b, i3, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(android.webkit.WebView webView, android.webkit.HttpAuthHandler httpAuthHandler, String str, String str2) {
        this.f369065b.a(webView);
        this.f369064a.onReceivedHttpAuthRequest(this.f369065b, new b(httpAuthHandler), str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest, android.webkit.WebResourceResponse webResourceResponse) {
        this.f369065b.a(webView);
        this.f369064a.onReceivedHttpError(this.f369065b, new f(webResourceRequest), new g(webResourceResponse));
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(12)
    public void onReceivedLoginRequest(android.webkit.WebView webView, String str, String str2, String str3) {
        this.f369065b.a(webView);
        this.f369064a.onReceivedLoginRequest(this.f369065b, str, str2, str3);
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(8)
    public void onReceivedSslError(android.webkit.WebView webView, android.webkit.SslErrorHandler sslErrorHandler, android.net.http.SslError sslError) {
        this.f369065b.a(webView);
        this.f369064a.onReceivedSslError(this.f369065b, new c(sslErrorHandler), new d(sslError));
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(android.webkit.WebView webView, final RenderProcessGoneDetail renderProcessGoneDetail) {
        this.f369065b.a(webView);
        return this.f369064a.onRenderProcessGone(this.f369065b, new WebViewClient.RenderProcessGoneDetail() { // from class: com.tencent.smtt.sdk.SystemWebViewClient.3
            @Override // com.tencent.smtt.sdk.WebViewClient.RenderProcessGoneDetail
            public boolean didCrash() {
                boolean didCrash;
                didCrash = renderProcessGoneDetail.didCrash();
                return didCrash;
            }

            @Override // com.tencent.smtt.sdk.WebViewClient.RenderProcessGoneDetail
            public int rendererPriorityAtExit() {
                int rendererPriorityAtExit;
                rendererPriorityAtExit = renderProcessGoneDetail.rendererPriorityAtExit();
                return rendererPriorityAtExit;
            }
        });
    }

    @Override // android.webkit.WebViewClient
    public void onScaleChanged(android.webkit.WebView webView, float f16, float f17) {
        this.f369065b.a(webView);
        this.f369064a.onScaleChanged(this.f369065b, f16, f17);
    }

    @Override // android.webkit.WebViewClient
    public void onTooManyRedirects(android.webkit.WebView webView, Message message, Message message2) {
        this.f369065b.a(webView);
        this.f369064a.onTooManyRedirects(this.f369065b, message, message2);
    }

    @Override // android.webkit.WebViewClient
    public void onUnhandledKeyEvent(android.webkit.WebView webView, KeyEvent keyEvent) {
        this.f369065b.a(webView);
        this.f369064a.onUnhandledKeyEvent(this.f369065b, keyEvent);
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(11)
    public android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView webView, String str) {
        WebResourceResponse shouldInterceptRequest = this.f369064a.shouldInterceptRequest(this.f369065b, str);
        if (shouldInterceptRequest == null) {
            return null;
        }
        return new android.webkit.WebResourceResponse(shouldInterceptRequest.getMimeType(), shouldInterceptRequest.getEncoding(), shouldInterceptRequest.getData());
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(android.webkit.WebView webView, KeyEvent keyEvent) {
        this.f369065b.a(webView);
        return this.f369064a.shouldOverrideKeyEvent(this.f369065b, keyEvent);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(android.webkit.WebView webView, String str) {
        if (str == null || this.f369065b.showDebugView(str)) {
            return true;
        }
        this.f369065b.a(webView);
        return this.f369064a.shouldOverrideUrlLoading(this.f369065b, str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest, final WebResourceError webResourceError) {
        this.f369065b.a(webView);
        this.f369064a.onReceivedError(this.f369065b, webResourceRequest != null ? new f(webResourceRequest) : null, webResourceError != null ? new com.tencent.smtt.export.external.interfaces.WebResourceError() { // from class: com.tencent.smtt.sdk.SystemWebViewClient.2
            @Override // com.tencent.smtt.export.external.interfaces.WebResourceError
            public CharSequence getDescription() {
                return webResourceError.getDescription();
            }

            @Override // com.tencent.smtt.export.external.interfaces.WebResourceError
            public int getErrorCode() {
                return webResourceError.getErrorCode();
            }
        } : null);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0046 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0047  */
    @Override // android.webkit.WebViewClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest) {
        boolean z16;
        WebResourceResponse shouldInterceptRequest;
        int i3 = Build.VERSION.SDK_INT;
        if (webResourceRequest == null) {
            return null;
        }
        if (i3 >= 24) {
            Object a16 = com.tencent.smtt.utils.k.a(webResourceRequest, "isRedirect");
            if (a16 instanceof Boolean) {
                z16 = ((Boolean) a16).booleanValue();
                shouldInterceptRequest = this.f369064a.shouldInterceptRequest(this.f369065b, new e(webResourceRequest.getUrl().toString(), webResourceRequest.isForMainFrame(), z16, webResourceRequest.hasGesture(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders()));
                if (shouldInterceptRequest != null) {
                    return null;
                }
                android.webkit.WebResourceResponse webResourceResponse = new android.webkit.WebResourceResponse(shouldInterceptRequest.getMimeType(), shouldInterceptRequest.getEncoding(), shouldInterceptRequest.getData());
                webResourceResponse.setResponseHeaders(shouldInterceptRequest.getResponseHeaders());
                int statusCode = shouldInterceptRequest.getStatusCode();
                String reasonPhrase = shouldInterceptRequest.getReasonPhrase();
                if (statusCode != webResourceResponse.getStatusCode() || (reasonPhrase != null && !reasonPhrase.equals(webResourceResponse.getReasonPhrase()))) {
                    webResourceResponse.setStatusCodeAndReasonPhrase(statusCode, reasonPhrase);
                }
                return webResourceResponse;
            }
        }
        z16 = false;
        shouldInterceptRequest = this.f369064a.shouldInterceptRequest(this.f369065b, new e(webResourceRequest.getUrl().toString(), webResourceRequest.isForMainFrame(), z16, webResourceRequest.hasGesture(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders()));
        if (shouldInterceptRequest != null) {
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest) {
        boolean z16;
        String uri = (webResourceRequest == null || webResourceRequest.getUrl() == null) ? null : webResourceRequest.getUrl().toString();
        if (uri == null || this.f369065b.showDebugView(uri)) {
            return true;
        }
        this.f369065b.a(webView);
        if (Build.VERSION.SDK_INT >= 24) {
            Object a16 = com.tencent.smtt.utils.k.a(webResourceRequest, "isRedirect");
            if (a16 instanceof Boolean) {
                z16 = ((Boolean) a16).booleanValue();
                return this.f369064a.shouldOverrideUrlLoading(this.f369065b, new e(webResourceRequest.getUrl().toString(), webResourceRequest.isForMainFrame(), z16, webResourceRequest.hasGesture(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders()));
            }
        }
        z16 = false;
        return this.f369064a.shouldOverrideUrlLoading(this.f369065b, new e(webResourceRequest.getUrl().toString(), webResourceRequest.isForMainFrame(), z16, webResourceRequest.hasGesture(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders()));
    }
}
