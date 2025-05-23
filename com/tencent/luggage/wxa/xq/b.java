package com.tencent.luggage.wxa.xq;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.xweb.HttpAuthHandler;
import com.tencent.xweb.JsPromptResult;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.SslErrorHandler;
import com.tencent.xweb.WebChromeClient;
import com.tencent.xweb.WebReqBundleCreator;
import com.tencent.xweb.WebResourceError;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class b {

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a extends WebResourceError {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ android.webkit.WebResourceError f145359a;

        public a(android.webkit.WebResourceError webResourceError) {
            this.f145359a = webResourceError;
        }

        @Override // com.tencent.xweb.WebResourceError
        public CharSequence getDescription() {
            return this.f145359a.getDescription();
        }

        @Override // com.tencent.xweb.WebResourceError
        public int getErrorCode() {
            return this.f145359a.getErrorCode();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.xq.b$b, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C6929b implements SslErrorHandler {

        /* renamed from: a, reason: collision with root package name */
        public android.webkit.SslErrorHandler f145360a;

        public C6929b(android.webkit.SslErrorHandler sslErrorHandler) {
            this.f145360a = sslErrorHandler;
        }

        @Override // com.tencent.xweb.SslErrorHandler
        public void cancel() {
            this.f145360a.cancel();
        }

        @Override // com.tencent.xweb.SslErrorHandler
        public void proceed() {
            this.f145360a.proceed();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class c implements HttpAuthHandler {

        /* renamed from: a, reason: collision with root package name */
        public android.webkit.HttpAuthHandler f145361a;

        public c(android.webkit.HttpAuthHandler httpAuthHandler) {
            this.f145361a = httpAuthHandler;
        }

        @Override // com.tencent.xweb.HttpAuthHandler
        public void cancel() {
            this.f145361a.cancel();
        }

        @Override // com.tencent.xweb.HttpAuthHandler
        public void proceed(String str, String str2) {
            this.f145361a.proceed(str, str2);
        }

        @Override // com.tencent.xweb.HttpAuthHandler
        public boolean useHttpAuthUsernamePassword() {
            return this.f145361a.useHttpAuthUsernamePassword();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class d extends WebChromeClient.FileChooserParams {

        /* renamed from: a, reason: collision with root package name */
        public WebChromeClient.FileChooserParams f145362a;

        public d(WebChromeClient.FileChooserParams fileChooserParams) {
            this.f145362a = fileChooserParams;
        }

        @Override // com.tencent.xweb.WebChromeClient.FileChooserParams
        public Intent createIntent() {
            WebChromeClient.FileChooserParams fileChooserParams = this.f145362a;
            if (fileChooserParams != null) {
                return fileChooserParams.createIntent();
            }
            return null;
        }

        @Override // com.tencent.xweb.WebChromeClient.FileChooserParams
        public String[] getAcceptTypes() {
            WebChromeClient.FileChooserParams fileChooserParams = this.f145362a;
            if (fileChooserParams != null) {
                return fileChooserParams.getAcceptTypes();
            }
            return new String[0];
        }

        @Override // com.tencent.xweb.WebChromeClient.FileChooserParams
        public String getFilenameHint() {
            WebChromeClient.FileChooserParams fileChooserParams = this.f145362a;
            if (fileChooserParams != null) {
                return fileChooserParams.getFilenameHint();
            }
            return null;
        }

        @Override // com.tencent.xweb.WebChromeClient.FileChooserParams
        public int getMode() {
            WebChromeClient.FileChooserParams fileChooserParams = this.f145362a;
            if (fileChooserParams != null) {
                return fileChooserParams.getMode();
            }
            return 0;
        }

        @Override // com.tencent.xweb.WebChromeClient.FileChooserParams
        public CharSequence getTitle() {
            WebChromeClient.FileChooserParams fileChooserParams = this.f145362a;
            if (fileChooserParams != null) {
                return fileChooserParams.getTitle();
            }
            return null;
        }

        @Override // com.tencent.xweb.WebChromeClient.FileChooserParams
        public boolean isCaptureEnabled() {
            WebChromeClient.FileChooserParams fileChooserParams = this.f145362a;
            if (fileChooserParams != null) {
                return fileChooserParams.isCaptureEnabled();
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class f extends JsResult {

        /* renamed from: a, reason: collision with root package name */
        public android.webkit.JsResult f145364a;

        public f(android.webkit.JsResult jsResult) {
            this.f145364a = jsResult;
        }

        @Override // com.tencent.xweb.JsResult
        public void cancel() {
            android.webkit.JsResult jsResult = this.f145364a;
            if (jsResult != null) {
                jsResult.cancel();
            }
        }

        @Override // com.tencent.xweb.JsResult
        public void confirm() {
            android.webkit.JsResult jsResult = this.f145364a;
            if (jsResult != null) {
                jsResult.confirm();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class g implements WebResourceRequest {

        /* renamed from: a, reason: collision with root package name */
        public Uri f145365a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f145366b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f145367c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f145368d;

        /* renamed from: e, reason: collision with root package name */
        public String f145369e;

        /* renamed from: f, reason: collision with root package name */
        public Map f145370f;

        /* renamed from: g, reason: collision with root package name */
        public WebReqBundleCreator f145371g;

        public g(android.webkit.WebResourceRequest webResourceRequest) {
            boolean isRedirect;
            int i3 = Build.VERSION.SDK_INT;
            if (webResourceRequest != null) {
                this.f145365a = webResourceRequest.getUrl();
                this.f145366b = webResourceRequest.isForMainFrame();
                this.f145367c = webResourceRequest.hasGesture();
                this.f145369e = webResourceRequest.getMethod();
                if (i3 >= 24) {
                    isRedirect = webResourceRequest.isRedirect();
                    this.f145368d = isRedirect;
                }
                this.f145370f = webResourceRequest.getRequestHeaders();
                this.f145371g = new WebReqBundleCreator(this);
            }
        }

        public Bundle a() {
            WebReqBundleCreator webReqBundleCreator = this.f145371g;
            if (webReqBundleCreator == null) {
                return null;
            }
            return webReqBundleCreator.getBundle();
        }

        @Override // com.tencent.xweb.WebResourceRequest
        public String getMethod() {
            return this.f145369e;
        }

        @Override // com.tencent.xweb.WebResourceRequest
        public Map getRequestHeaders() {
            return this.f145370f;
        }

        @Override // com.tencent.xweb.WebResourceRequest
        public Uri getUrl() {
            return this.f145365a;
        }

        @Override // com.tencent.xweb.WebResourceRequest
        public boolean hasGesture() {
            return this.f145367c;
        }

        @Override // com.tencent.xweb.WebResourceRequest
        public boolean isForMainFrame() {
            return this.f145366b;
        }

        @Override // com.tencent.xweb.WebResourceRequest
        public boolean isRedirect() {
            return this.f145368d;
        }
    }

    public static WebResourceResponse a(android.webkit.WebResourceResponse webResourceResponse) {
        if (webResourceResponse == null) {
            return null;
        }
        return new WebResourceResponse(webResourceResponse.getMimeType(), webResourceResponse.getEncoding(), webResourceResponse.getStatusCode(), webResourceResponse.getReasonPhrase(), webResourceResponse.getResponseHeaders(), webResourceResponse.getData());
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class e extends JsPromptResult {

        /* renamed from: a, reason: collision with root package name */
        public android.webkit.JsPromptResult f145363a;

        public e(android.webkit.JsPromptResult jsPromptResult) {
            this.f145363a = jsPromptResult;
        }

        @Override // com.tencent.xweb.JsResult
        public void cancel() {
            android.webkit.JsPromptResult jsPromptResult = this.f145363a;
            if (jsPromptResult != null) {
                jsPromptResult.cancel();
            }
        }

        @Override // com.tencent.xweb.JsPromptResult
        public void confirm(String str) {
            android.webkit.JsPromptResult jsPromptResult = this.f145363a;
            if (jsPromptResult != null) {
                jsPromptResult.confirm(str);
            }
        }

        @Override // com.tencent.xweb.JsResult
        public void confirm() {
            android.webkit.JsPromptResult jsPromptResult = this.f145363a;
            if (jsPromptResult != null) {
                jsPromptResult.confirm();
            }
        }
    }

    public static WebResourceError a(android.webkit.WebResourceError webResourceError) {
        if (webResourceError == null) {
            return null;
        }
        return new a(webResourceError);
    }

    public static android.webkit.WebResourceResponse a(WebResourceResponse webResourceResponse) {
        if (webResourceResponse == null) {
            return null;
        }
        if (webResourceResponse.isCreateFromComplexConstruct()) {
            try {
                return new android.webkit.WebResourceResponse(webResourceResponse.getMimeType(), webResourceResponse.getEncoding(), webResourceResponse.getStatusCode(), webResourceResponse.getReasonPhrase(), webResourceResponse.getResponseHeaders(), webResourceResponse.getData());
            } catch (Throwable th5) {
                x0.a("SysWebDataTrans", "create webkit WebResourceResponse error", th5);
            }
        }
        android.webkit.WebResourceResponse webResourceResponse2 = new android.webkit.WebResourceResponse(webResourceResponse.getMimeType(), webResourceResponse.getEncoding(), webResourceResponse.getData());
        if (webResourceResponse.getStatusCode() > 100 && webResourceResponse.getReasonPhrase() != null && !webResourceResponse.getReasonPhrase().isEmpty()) {
            webResourceResponse2.setStatusCodeAndReasonPhrase(webResourceResponse.getStatusCode(), webResourceResponse.getReasonPhrase());
        }
        webResourceResponse2.setResponseHeaders(webResourceResponse.getResponseHeaders());
        return webResourceResponse2;
    }
}
