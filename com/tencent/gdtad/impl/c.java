package com.tencent.gdtad.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.inject.IGdtWebView;
import com.tencent.gdtad.inject.IGdtWebViewListener;
import com.tencent.mobileqq.webview.m;
import com.tencent.smtt.sdk.WebView;

/* compiled from: P */
/* loaded from: classes6.dex */
public class c implements IGdtWebView {

    /* renamed from: a, reason: collision with root package name */
    public zm0.c f109215a;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a extends zm0.c {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IGdtWebViewListener f109216b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, Activity activity, Intent intent, AppInterface appInterface, IGdtWebViewListener iGdtWebViewListener) {
            super(context, activity, intent, appInterface);
            this.f109216b = iGdtWebViewListener;
        }

        @Override // com.tencent.mobileqq.webview.AbsWebView
        public void onPageFinished(WebView webView, String str) {
            IGdtWebViewListener iGdtWebViewListener = this.f109216b;
            if (iGdtWebViewListener != null) {
                iGdtWebViewListener.onPageFinished(webView, str);
            }
            super.onPageFinished(webView, str);
        }

        @Override // com.tencent.mobileqq.webview.AbsWebView
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            IGdtWebViewListener iGdtWebViewListener = this.f109216b;
            if (iGdtWebViewListener != null) {
                iGdtWebViewListener.onPageStarted(webView, str, bitmap);
            }
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // com.tencent.mobileqq.webview.AbsWebView
        public void onProgressChanged(WebView webView, int i3) {
            IGdtWebViewListener iGdtWebViewListener = this.f109216b;
            if (iGdtWebViewListener != null) {
                iGdtWebViewListener.onProgressChanged(webView, i3);
            }
            super.onProgressChanged(webView, i3);
        }

        @Override // com.tencent.mobileqq.webview.AbsWebView
        public void onReceivedError(WebView webView, int i3, String str, String str2) {
            IGdtWebViewListener iGdtWebViewListener = this.f109216b;
            if (iGdtWebViewListener != null) {
                iGdtWebViewListener.onReceivedError(webView, i3, str, str2);
            }
            super.onReceivedError(webView, i3, str, str2);
        }

        @Override // com.tencent.mobileqq.webview.AbsWebView
        public void onReceivedTitle(WebView webView, String str) {
            IGdtWebViewListener iGdtWebViewListener = this.f109216b;
            if (iGdtWebViewListener != null) {
                iGdtWebViewListener.onReceivedTitle(webView, str);
            }
            super.onReceivedTitle(webView, str);
        }

        @Override // com.tencent.mobileqq.webview.AbsWebView
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            IGdtWebViewListener iGdtWebViewListener = this.f109216b;
            if (iGdtWebViewListener != null && iGdtWebViewListener.shouldOverrideUrlLoading(webView, str)) {
                return true;
            }
            return a(webView, str);
        }
    }

    @Override // com.tencent.gdtad.inject.IGdtWebView
    public void init(Context context, Activity activity, Intent intent, AppInterface appInterface, @Nullable IGdtWebViewListener iGdtWebViewListener) {
        this.f109215a = new a(context, activity, intent, appInterface, iGdtWebViewListener);
    }

    @Override // com.tencent.gdtad.inject.IGdtWebView
    public void onConstruct(Bundle bundle, AppInterface appInterface, Intent intent) {
        zm0.c cVar = this.f109215a;
        if (cVar != null) {
            new m(cVar).a(bundle, appInterface, intent);
        }
    }

    @Override // com.tencent.gdtad.inject.IGdtWebView
    public void onCreate(Bundle bundle) {
        zm0.c cVar = this.f109215a;
        if (cVar != null) {
            cVar.onCreate(bundle);
        }
    }

    @Override // com.tencent.gdtad.inject.IGdtWebView
    public void onDestroy() {
        zm0.c cVar = this.f109215a;
        if (cVar != null) {
            cVar.onDestroy();
        }
    }

    @Override // com.tencent.gdtad.inject.IGdtWebView
    public void onPause() {
        zm0.c cVar = this.f109215a;
        if (cVar != null) {
            cVar.onPause();
        }
    }

    @Override // com.tencent.gdtad.inject.IGdtWebView
    public void onResume() {
        zm0.c cVar = this.f109215a;
        if (cVar != null) {
            cVar.onResume();
        }
    }

    @Override // com.tencent.gdtad.inject.IGdtWebView
    public void setWebView(WebView webView) {
        zm0.c cVar = this.f109215a;
        if (cVar != null) {
            cVar.setWebView((TouchWebView) webView);
        }
    }
}
