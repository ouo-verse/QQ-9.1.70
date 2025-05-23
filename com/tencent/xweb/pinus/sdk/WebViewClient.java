package com.tencent.xweb.pinus.sdk;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import androidx.annotation.Nullable;
import com.tencent.xweb.RenderProcessGoneDetail;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes27.dex */
public class WebViewClient {
    public static final int ERROR_AUTHENTICATION = -4;
    public static final int ERROR_BAD_URL = -12;
    public static final int ERROR_CONNECT = -6;
    public static final int ERROR_FAILED_SSL_HANDSHAKE = -11;
    public static final int ERROR_FILE = -13;
    public static final int ERROR_FILE_NOT_FOUND = -14;
    public static final int ERROR_HOST_LOOKUP = -2;
    public static final int ERROR_IO = -7;
    public static final int ERROR_PROXY_AUTHENTICATION = -5;
    public static final int ERROR_REDIRECT_LOOP = -9;
    public static final int ERROR_TIMEOUT = -8;
    public static final int ERROR_TOO_MANY_REQUESTS = -15;
    public static final int ERROR_UNKNOWN = -1;
    public static final int ERROR_UNSAFE_RESOURCE = -16;
    public static final int ERROR_UNSUPPORTED_AUTH_SCHEME = -3;
    public static final int ERROR_UNSUPPORTED_SCHEME = -10;
    public static final int SAFE_BROWSING_THREAT_BILLING = 4;
    public static final int SAFE_BROWSING_THREAT_MALWARE = 1;
    public static final int SAFE_BROWSING_THREAT_PHISHING = 2;
    public static final int SAFE_BROWSING_THREAT_UNKNOWN = 0;
    public static final int SAFE_BROWSING_THREAT_UNWANTED_SOFTWARE = 3;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes27.dex */
    public @interface SafeBrowsingThreat {
    }

    private void onReceivedError2(WebView webView, WebResourceRequest webResourceRequest, Object obj) {
        onReceivedError(webView, webResourceRequest, new WebResourceErrorInterfaceImpl(obj));
    }

    private void onReceivedHttpAuthRequestInner(WebView webView, Object obj, String str, String str2) {
        onReceivedHttpAuthRequest(webView, new HttpAuthHandlerInterfaceImpl(obj), str, str2);
    }

    private void onReceivedSslErrorInner(WebView webView, Object obj, SslError sslError) {
        onReceivedSslError(webView, new SslErrorHandlerInterfaceImpl(obj), sslError);
    }

    public void onFormResubmission(WebView webView, Message message, Message message2) {
        message.sendToTarget();
    }

    public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
        clientCertRequest.cancel();
    }

    public void onReceivedError(WebView webView, int i3, String str, String str2) {
    }

    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandlerInterface httpAuthHandlerInterface, String str, String str2) {
        httpAuthHandlerInterface.cancel();
    }

    public void onReceivedSslError(WebView webView, SslErrorHandlerInterface sslErrorHandlerInterface, SslError sslError) {
        sslErrorHandlerInterface.cancel();
    }

    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return true;
    }

    public boolean onRenderProcessGoneInner(WebView webView, final boolean z16, final int i3) {
        return onRenderProcessGone(webView, new RenderProcessGoneDetail() { // from class: com.tencent.xweb.pinus.sdk.WebViewClient.1
            @Override // com.tencent.xweb.RenderProcessGoneDetail
            public boolean didCrash() {
                return z16;
            }

            @Override // com.tencent.xweb.RenderProcessGoneDetail
            public int rendererPriorityAtExit() {
                return i3;
            }
        });
    }

    @Deprecated
    public void onTooManyRedirects(WebView webView, Message message, Message message2) {
        message.sendToTarget();
    }

    public void onUnhandledInputEvent(WebView webView, InputEvent inputEvent) {
        if (inputEvent instanceof KeyEvent) {
            onUnhandledKeyEvent(webView, (KeyEvent) inputEvent);
        }
    }

    @Nullable
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return null;
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        return false;
    }

    @Deprecated
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return false;
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceErrorInterface webResourceErrorInterface) {
    }

    @Nullable
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        return shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
    }

    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return shouldOverrideUrlLoading(webView, webResourceRequest.getUrl().toString());
    }

    public void onLoadResource(WebView webView, String str) {
    }

    public void onPageCommitVisible(WebView webView, String str) {
    }

    public void onPageFinished(WebView webView, String str) {
    }

    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
    }

    public void doUpdateVisitedHistory(WebView webView, String str, boolean z16) {
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
    }

    public void onScaleChanged(WebView webView, float f16, float f17) {
    }

    public void onReceivedLoginRequest(WebView webView, String str, @Nullable String str2, String str3) {
    }
}
