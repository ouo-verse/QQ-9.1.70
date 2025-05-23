package com.tencent.xweb.pinus;

import android.annotation.TargetApi;
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
import com.tencent.xweb.pinus.sdk.HttpAuthHandlerInterface;
import com.tencent.xweb.pinus.sdk.JsResultInterface;
import com.tencent.xweb.pinus.sdk.SslErrorHandlerInterface;
import com.tencent.xweb.pinus.sdk.WebResourceErrorInterface;
import java.util.Map;

/* loaded from: classes27.dex */
public class PinusWebDataTrans {
    private static final String TAG = "PinusWebDataTrans";

    /* loaded from: classes27.dex */
    public static class PsWebFileChooserParamsImpl extends WebChromeClient.FileChooserParams {
        public WebChromeClient.FileChooserParams mParams;

        public PsWebFileChooserParamsImpl(WebChromeClient.FileChooserParams fileChooserParams) {
            this.mParams = fileChooserParams;
        }

        @Override // com.tencent.xweb.WebChromeClient.FileChooserParams
        @TargetApi(21)
        public Intent createIntent() {
            WebChromeClient.FileChooserParams fileChooserParams = this.mParams;
            if (fileChooserParams != null) {
                return fileChooserParams.createIntent();
            }
            return null;
        }

        @Override // com.tencent.xweb.WebChromeClient.FileChooserParams
        @TargetApi(21)
        public String[] getAcceptTypes() {
            WebChromeClient.FileChooserParams fileChooserParams = this.mParams;
            if (fileChooserParams != null) {
                return fileChooserParams.getAcceptTypes();
            }
            return new String[0];
        }

        @Override // com.tencent.xweb.WebChromeClient.FileChooserParams
        @TargetApi(21)
        public String getFilenameHint() {
            WebChromeClient.FileChooserParams fileChooserParams = this.mParams;
            if (fileChooserParams != null) {
                return fileChooserParams.getFilenameHint();
            }
            return null;
        }

        @Override // com.tencent.xweb.WebChromeClient.FileChooserParams
        @TargetApi(21)
        public int getMode() {
            WebChromeClient.FileChooserParams fileChooserParams = this.mParams;
            if (fileChooserParams != null) {
                return fileChooserParams.getMode();
            }
            return 0;
        }

        @Override // com.tencent.xweb.WebChromeClient.FileChooserParams
        @TargetApi(21)
        public CharSequence getTitle() {
            WebChromeClient.FileChooserParams fileChooserParams = this.mParams;
            if (fileChooserParams != null) {
                return fileChooserParams.getTitle();
            }
            return null;
        }

        @Override // com.tencent.xweb.WebChromeClient.FileChooserParams
        @TargetApi(21)
        public boolean isCaptureEnabled() {
            WebChromeClient.FileChooserParams fileChooserParams = this.mParams;
            if (fileChooserParams != null) {
                return fileChooserParams.isCaptureEnabled();
            }
            return false;
        }
    }

    /* loaded from: classes27.dex */
    public static class PsWebHttpAuthHandler implements HttpAuthHandler {
        HttpAuthHandlerInterface mHandler;

        public PsWebHttpAuthHandler(HttpAuthHandlerInterface httpAuthHandlerInterface) {
            this.mHandler = httpAuthHandlerInterface;
        }

        @Override // com.tencent.xweb.HttpAuthHandler
        public void cancel() {
            this.mHandler.cancel();
        }

        @Override // com.tencent.xweb.HttpAuthHandler
        public void proceed(String str, String str2) {
            this.mHandler.proceed(str, str2);
        }

        @Override // com.tencent.xweb.HttpAuthHandler
        public boolean useHttpAuthUsernamePassword() {
            return this.mHandler.useHttpAuthUsernamePassword();
        }
    }

    /* loaded from: classes27.dex */
    public static class PsWebJsResultImpl extends JsResult {
        public JsResultInterface mJsResult;

        public PsWebJsResultImpl(JsResultInterface jsResultInterface) {
            this.mJsResult = jsResultInterface;
        }

        @Override // com.tencent.xweb.JsResult
        public void cancel() {
            JsResultInterface jsResultInterface = this.mJsResult;
            if (jsResultInterface != null) {
                jsResultInterface.cancel();
            }
        }

        @Override // com.tencent.xweb.JsResult
        public void confirm() {
            JsResultInterface jsResultInterface = this.mJsResult;
            if (jsResultInterface != null) {
                jsResultInterface.confirm();
            }
        }
    }

    /* loaded from: classes27.dex */
    public static class SslErrorHandlerImp implements SslErrorHandler {
        SslErrorHandlerInterface mHandler;

        public SslErrorHandlerImp(SslErrorHandlerInterface sslErrorHandlerInterface) {
            this.mHandler = sslErrorHandlerInterface;
        }

        @Override // com.tencent.xweb.SslErrorHandler
        public void cancel() {
            this.mHandler.cancel();
        }

        @Override // com.tencent.xweb.SslErrorHandler
        public void proceed() {
            this.mHandler.proceed();
        }
    }

    /* loaded from: classes27.dex */
    public static class WebResourceRequestImpl implements WebResourceRequest {
        private boolean hasUserGesture;
        private boolean isMainFrame;
        private boolean isRedirect;
        private WebReqBundleCreator mBundleCreator;
        private String method;
        private Map<String, String> requestHeaders;
        private Uri url;

        public WebResourceRequestImpl(android.webkit.WebResourceRequest webResourceRequest) {
            boolean isRedirect;
            int i3 = Build.VERSION.SDK_INT;
            this.url = webResourceRequest.getUrl();
            this.isMainFrame = webResourceRequest.isForMainFrame();
            this.hasUserGesture = webResourceRequest.hasGesture();
            this.method = webResourceRequest.getMethod();
            if (i3 >= 24) {
                isRedirect = webResourceRequest.isRedirect();
                this.isRedirect = isRedirect;
            }
            this.requestHeaders = webResourceRequest.getRequestHeaders();
            this.mBundleCreator = new WebReqBundleCreator(this);
        }

        public Bundle getBundle() {
            WebReqBundleCreator webReqBundleCreator = this.mBundleCreator;
            if (webReqBundleCreator == null) {
                return null;
            }
            return webReqBundleCreator.getBundle();
        }

        @Override // com.tencent.xweb.WebResourceRequest
        public String getMethod() {
            return this.method;
        }

        @Override // com.tencent.xweb.WebResourceRequest
        public Map<String, String> getRequestHeaders() {
            return this.requestHeaders;
        }

        @Override // com.tencent.xweb.WebResourceRequest
        public Uri getUrl() {
            return this.url;
        }

        @Override // com.tencent.xweb.WebResourceRequest
        public boolean hasGesture() {
            return this.hasUserGesture;
        }

        @Override // com.tencent.xweb.WebResourceRequest
        public boolean isForMainFrame() {
            return this.isMainFrame;
        }

        @Override // com.tencent.xweb.WebResourceRequest
        public boolean isRedirect() {
            return this.isRedirect;
        }
    }

    public static WebResourceError createPSWebResourceError(final WebResourceErrorInterface webResourceErrorInterface) {
        if (webResourceErrorInterface == null) {
            return null;
        }
        return new WebResourceError() { // from class: com.tencent.xweb.pinus.PinusWebDataTrans.1
            @Override // com.tencent.xweb.WebResourceError
            public CharSequence getDescription() {
                return WebResourceErrorInterface.this.getDescription();
            }

            @Override // com.tencent.xweb.WebResourceError
            public int getErrorCode() {
                return WebResourceErrorInterface.this.getErrorCode();
            }
        };
    }

    public static WebResourceResponse createWCWebResponse(android.webkit.WebResourceResponse webResourceResponse) {
        if (webResourceResponse == null) {
            return null;
        }
        return new WebResourceResponse(webResourceResponse.getMimeType(), webResourceResponse.getEncoding(), webResourceResponse.getStatusCode(), webResourceResponse.getReasonPhrase(), webResourceResponse.getResponseHeaders(), webResourceResponse.getData());
    }

    public static android.webkit.WebResourceResponse createWebKitResponse(WebResourceResponse webResourceResponse) {
        if (webResourceResponse == null) {
            return null;
        }
        if (webResourceResponse.isCreateFromComplexConstruct()) {
            try {
                return new android.webkit.WebResourceResponse(webResourceResponse.getMimeType(), webResourceResponse.getEncoding(), webResourceResponse.getStatusCode(), webResourceResponse.getReasonPhrase(), webResourceResponse.getResponseHeaders(), webResourceResponse.getData());
            } catch (Throwable th5) {
                x0.c(TAG, "create webkit WebResourceResponse error:" + th5 + ", statusCode:" + webResourceResponse.getStatusCode());
            }
        }
        android.webkit.WebResourceResponse webResourceResponse2 = new android.webkit.WebResourceResponse(webResourceResponse.getMimeType(), webResourceResponse.getEncoding(), webResourceResponse.getData());
        if (webResourceResponse.getStatusCode() > 100 && webResourceResponse.getReasonPhrase() != null && !webResourceResponse.getReasonPhrase().isEmpty()) {
            webResourceResponse2.setStatusCodeAndReasonPhrase(webResourceResponse.getStatusCode(), webResourceResponse.getReasonPhrase());
        }
        webResourceResponse2.setResponseHeaders(webResourceResponse.getResponseHeaders());
        return webResourceResponse2;
    }

    /* loaded from: classes27.dex */
    public static class PsWebJsPromptResultImpl extends JsPromptResult {
        public JsResultInterface mJsResult;

        public PsWebJsPromptResultImpl(JsResultInterface jsResultInterface) {
            this.mJsResult = jsResultInterface;
        }

        @Override // com.tencent.xweb.JsResult
        public void cancel() {
            JsResultInterface jsResultInterface = this.mJsResult;
            if (jsResultInterface != null) {
                jsResultInterface.cancel();
            }
        }

        @Override // com.tencent.xweb.JsPromptResult
        public void confirm(String str) {
            JsResultInterface jsResultInterface = this.mJsResult;
            if (jsResultInterface != null) {
                jsResultInterface.confirm(str);
            }
        }

        @Override // com.tencent.xweb.JsResult
        public void confirm() {
            JsResultInterface jsResultInterface = this.mJsResult;
            if (jsResultInterface != null) {
                jsResultInterface.confirm();
            }
        }
    }
}
