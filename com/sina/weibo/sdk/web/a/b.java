package com.sina.weibo.sdk.web.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.share.ShareResultActivity;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class b extends WebViewClient {
    protected com.sina.weibo.sdk.auth.b aD = com.sina.weibo.sdk.auth.b.f();
    protected Activity aE;
    protected com.sina.weibo.sdk.web.a aF;
    protected com.sina.weibo.sdk.web.b.b aG;
    protected WbAuthListener aH;

    public b(Activity activity, com.sina.weibo.sdk.web.a aVar, com.sina.weibo.sdk.web.b.b bVar) {
        this.aE = activity;
        this.aF = aVar;
        this.aG = bVar;
    }

    private void b(int i3, String str) {
        Bundle extras = this.aE.getIntent().getExtras();
        if (extras == null) {
            return;
        }
        Intent intent = new Intent(this.aE, (Class<?>) ShareResultActivity.class);
        intent.setAction("com.sina.weibo.sdk.action.ACTION_SDK_REQ_ACTIVITY");
        intent.putExtras(extras);
        intent.putExtra("_weibo_resp_errcode", i3);
        intent.putExtra("_weibo_resp_errstr", str);
        this.aE.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void j(String str) {
        b(0, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void k(String str) {
        b(2, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void l(String str) {
        b(1, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        JsInjector.getInstance().onPageStarted(webView);
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(23)
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        com.sina.weibo.sdk.web.a aVar = this.aF;
        if (aVar != null) {
            webResourceError.getErrorCode();
            webResourceError.getDescription().toString();
            webResourceRequest.getUrl().toString();
            aVar.s();
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }

    public boolean v() {
        return false;
    }

    public void t() {
    }

    public void m(String str) {
    }
}
