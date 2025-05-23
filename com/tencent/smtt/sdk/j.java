package com.tencent.smtt.sdk;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.smtt.export.external.interfaces.ClientCertRequest;
import com.tencent.smtt.export.external.interfaces.HttpAuthHandler;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceError;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.export.external.proxy.X5ProxyWebViewClient;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes23.dex */
public class j extends X5ProxyWebViewClient {

    /* renamed from: c, reason: collision with root package name */
    private static String f369380c;

    /* renamed from: a, reason: collision with root package name */
    private WebViewClient f369381a;

    /* renamed from: b, reason: collision with root package name */
    private WebView f369382b;

    public j(IX5WebViewClient iX5WebViewClient, WebView webView, WebViewClient webViewClient) {
        super(iX5WebViewClient);
        this.f369382b = webView;
        this.f369381a = webViewClient;
        webViewClient.mX5Client = this;
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient
    public void countPVContentCacheCallBack(String str) {
        this.f369382b.f369210a++;
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void doUpdateVisitedHistory(IX5WebViewBase iX5WebViewBase, String str, boolean z16) {
        this.f369382b.a(iX5WebViewBase);
        this.f369381a.doUpdateVisitedHistory(this.f369382b, str, z16);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onDetectedBlankScreen(IX5WebViewBase iX5WebViewBase, String str, int i3) {
        this.f369382b.a(iX5WebViewBase);
        this.f369381a.onDetectedBlankScreen(str, i3);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onFormResubmission(IX5WebViewBase iX5WebViewBase, Message message, Message message2) {
        this.f369382b.a(iX5WebViewBase);
        this.f369381a.onFormResubmission(this.f369382b, message, message2);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onLoadResource(IX5WebViewBase iX5WebViewBase, String str) {
        this.f369382b.a(iX5WebViewBase);
        this.f369381a.onLoadResource(this.f369382b, str);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onPageCommitVisible(IX5WebViewBase iX5WebViewBase, String str) {
        this.f369382b.a(iX5WebViewBase);
        this.f369381a.onPageCommitVisible(this.f369382b, str);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onPageFinished(IX5WebViewBase iX5WebViewBase, int i3, int i16, String str) {
        com.tencent.smtt.utils.q a16;
        TbsPrivacyAccess.rmPrivacyItemIfNeeded(iX5WebViewBase.getView().getContext().getApplicationContext());
        if (f369380c == null && (a16 = com.tencent.smtt.utils.q.a()) != null) {
            a16.a(false);
            f369380c = Boolean.toString(false);
        }
        this.f369382b.a(iX5WebViewBase);
        this.f369382b.f369210a++;
        this.f369381a.onPageFinished(this.f369382b, str);
        try {
            super.onPageFinished(iX5WebViewBase, i3, i16, str);
        } catch (Exception unused) {
        }
        WebView.c();
        if (!TbsShareManager.mHasQueried && this.f369382b.getContext() != null && TbsShareManager.isThirdPartyApp(this.f369382b.getContext()) && !QbSdk.d()) {
            TbsShareManager.mHasQueried = true;
            new BaseThread(new Runnable() { // from class: com.tencent.smtt.sdk.j.1
                @Override // java.lang.Runnable
                public void run() {
                    TbsDownloader.needDownload(j.this.f369382b.getContext(), false);
                }
            }).start();
        }
        if (this.f369382b.getContext() == null || TbsLogReport.getInstance(this.f369382b.getContext()).getShouldUploadEventReport()) {
            return;
        }
        TbsLogReport.getInstance(this.f369382b.getContext()).setShouldUploadEventReport(true);
        TbsLogReport.getInstance(this.f369382b.getContext()).dailyReport();
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onPageStarted(IX5WebViewBase iX5WebViewBase, int i3, int i16, String str, Bitmap bitmap) {
        this.f369382b.a(iX5WebViewBase);
        this.f369381a.onPageStarted(this.f369382b, str, bitmap);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onReceivedClientCertRequest(IX5WebViewBase iX5WebViewBase, ClientCertRequest clientCertRequest) {
        this.f369382b.a(iX5WebViewBase);
        this.f369381a.onReceivedClientCertRequest(this.f369382b, clientCertRequest);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onReceivedError(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        this.f369382b.a(iX5WebViewBase);
        this.f369381a.onReceivedError(this.f369382b, webResourceRequest, webResourceError);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onReceivedHttpAuthRequest(IX5WebViewBase iX5WebViewBase, HttpAuthHandler httpAuthHandler, String str, String str2) {
        this.f369382b.a(iX5WebViewBase);
        this.f369381a.onReceivedHttpAuthRequest(this.f369382b, httpAuthHandler, str, str2);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onReceivedHttpError(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        this.f369382b.a(iX5WebViewBase);
        this.f369381a.onReceivedHttpError(this.f369382b, webResourceRequest, webResourceResponse);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onReceivedLoginRequest(IX5WebViewBase iX5WebViewBase, String str, String str2, String str3) {
        this.f369382b.a(iX5WebViewBase);
        this.f369381a.onReceivedLoginRequest(this.f369382b, str, str2, str3);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onReceivedSslError(IX5WebViewBase iX5WebViewBase, SslErrorHandler sslErrorHandler, SslError sslError) {
        this.f369382b.a(iX5WebViewBase);
        this.f369381a.onReceivedSslError(this.f369382b, sslErrorHandler, sslError);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public boolean onRenderProcessGone(IX5WebViewBase iX5WebViewBase, final boolean z16, final int i3) {
        return this.f369381a.onRenderProcessGone(this.f369382b, new WebViewClient.RenderProcessGoneDetail() { // from class: com.tencent.smtt.sdk.j.2
            @Override // com.tencent.smtt.sdk.WebViewClient.RenderProcessGoneDetail
            public boolean didCrash() {
                return z16;
            }

            @Override // com.tencent.smtt.sdk.WebViewClient.RenderProcessGoneDetail
            public int rendererPriorityAtExit() {
                return i3;
            }
        });
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onScaleChanged(IX5WebViewBase iX5WebViewBase, float f16, float f17) {
        this.f369382b.a(iX5WebViewBase);
        this.f369381a.onScaleChanged(this.f369382b, f16, f17);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onTooManyRedirects(IX5WebViewBase iX5WebViewBase, Message message, Message message2) {
        this.f369382b.a(iX5WebViewBase);
        this.f369381a.onTooManyRedirects(this.f369382b, message, message2);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onUnhandledKeyEvent(IX5WebViewBase iX5WebViewBase, KeyEvent keyEvent) {
        this.f369382b.a(iX5WebViewBase);
        this.f369381a.onUnhandledKeyEvent(this.f369382b, keyEvent);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public WebResourceResponse shouldInterceptRequest(IX5WebViewBase iX5WebViewBase, String str) {
        this.f369382b.a(iX5WebViewBase);
        return this.f369381a.shouldInterceptRequest(this.f369382b, str);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public boolean shouldOverrideKeyEvent(IX5WebViewBase iX5WebViewBase, KeyEvent keyEvent) {
        this.f369382b.a(iX5WebViewBase);
        return this.f369381a.shouldOverrideKeyEvent(this.f369382b, keyEvent);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public boolean shouldOverrideUrlLoading(IX5WebViewBase iX5WebViewBase, String str) {
        if (str == null || this.f369382b.showDebugView(str)) {
            return true;
        }
        this.f369382b.a(iX5WebViewBase);
        boolean shouldOverrideUrlLoading = this.f369381a.shouldOverrideUrlLoading(this.f369382b, str);
        if (!shouldOverrideUrlLoading) {
            if (str.startsWith(HttpMsg.FILE_TEL)) {
                this.f369382b.getContext().startActivity(new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(WebView.SCHEME_TEL + str.substring(13))));
                return true;
            }
            if (str.startsWith(WebView.SCHEME_TEL)) {
                a(str);
                return true;
            }
        }
        return shouldOverrideUrlLoading;
    }

    public void a(String str) {
        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(str));
        intent.addFlags(268435456);
        try {
            if (this.f369382b.getContext() != null) {
                this.f369382b.getContext().startActivity(intent);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onPageStarted(IX5WebViewBase iX5WebViewBase, String str, Bitmap bitmap) {
        onPageStarted(iX5WebViewBase, 0, 0, str, bitmap);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onReceivedError(IX5WebViewBase iX5WebViewBase, int i3, String str, String str2) {
        if (i3 < -15) {
            if (i3 != -17) {
                return;
            } else {
                i3 = -1;
            }
        }
        this.f369382b.a(iX5WebViewBase);
        this.f369381a.onReceivedError(this.f369382b, i3, str, str2);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public WebResourceResponse shouldInterceptRequest(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest) {
        this.f369382b.a(iX5WebViewBase);
        return this.f369381a.shouldInterceptRequest(this.f369382b, webResourceRequest);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public WebResourceResponse shouldInterceptRequest(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest, Bundle bundle) {
        this.f369382b.a(iX5WebViewBase);
        return this.f369381a.shouldInterceptRequest(this.f369382b, webResourceRequest, bundle);
    }

    public void a(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(this.f369382b.b(), 0, 0, str, bitmap);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public boolean shouldOverrideUrlLoading(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest) {
        String uri = (webResourceRequest == null || webResourceRequest.getUrl() == null) ? null : webResourceRequest.getUrl().toString();
        if (uri == null || this.f369382b.showDebugView(uri)) {
            return true;
        }
        this.f369382b.a(iX5WebViewBase);
        boolean shouldOverrideUrlLoading = this.f369381a.shouldOverrideUrlLoading(this.f369382b, webResourceRequest);
        if (!shouldOverrideUrlLoading) {
            if (uri.startsWith(HttpMsg.FILE_TEL)) {
                this.f369382b.getContext().startActivity(new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(WebView.SCHEME_TEL + uri.substring(13))));
                return true;
            }
            if (uri.startsWith(WebView.SCHEME_TEL)) {
                a(uri);
                return true;
            }
        }
        return shouldOverrideUrlLoading;
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebViewClient, com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onPageFinished(IX5WebViewBase iX5WebViewBase, String str) {
        onPageFinished(iX5WebViewBase, 0, 0, str);
    }
}
