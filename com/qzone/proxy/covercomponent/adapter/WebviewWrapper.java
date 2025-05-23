package com.qzone.proxy.covercomponent.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.qzone.misc.web.webview.QzoneWebViewPluginManager;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewplugin.WebSoPlugin;
import com.tencent.mobileqq.webview.m;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.smtt.sdk.WebView;
import cooperation.qzone.CloseGuard;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewwrapper.IWebviewListener;
import cooperation.qzone.webviewwrapper.IWebviewWrapper;
import s7.a;
import s7.b;

/* compiled from: P */
/* loaded from: classes39.dex */
public class WebviewWrapper implements IWebviewWrapper {
    private static final String TAG = "WebviewWrapper";
    protected Context mContext;
    protected b mWebViewBuilder;
    protected TouchWebView mWebview;
    protected a qzoneShowJSPlugin;
    private final CloseGuard guard = CloseGuard.get();
    protected long mWebviewStartTime = System.currentTimeMillis();

    public WebviewWrapper(Context context) {
        this.mContext = context;
        preInit();
    }

    private void recordWebPageStartTime(String str) {
        a aVar = this.qzoneShowJSPlugin;
        if (aVar != null) {
            aVar.f433405i = str;
            aVar.f433403f = System.currentTimeMillis();
        }
    }

    @Override // cooperation.qzone.webviewwrapper.IWebviewWrapper
    public void callJs(String str) {
        TouchWebView touchWebView = this.mWebview;
        if (touchWebView != null) {
            touchWebView.callJs(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            CloseGuard closeGuard = this.guard;
            if (closeGuard != null) {
                closeGuard.warnIfOpen();
            }
        } finally {
            super.finalize();
        }
    }

    @Override // cooperation.qzone.webviewwrapper.IWebviewWrapper
    public WebView getWebview() {
        return this.mWebview;
    }

    @Override // cooperation.qzone.webviewwrapper.IWebviewWrapper
    public void onDestroy() {
        this.guard.close();
        onDetach();
        b bVar = this.mWebViewBuilder;
        if (bVar != null) {
            bVar.onDestroy();
        }
        this.mWebview = null;
        this.mContext = null;
    }

    @Override // cooperation.qzone.webviewwrapper.IWebviewWrapper
    public void onDetach() {
        ViewParent parent;
        TouchWebView touchWebView = this.mWebview;
        if (touchWebView == null || (parent = touchWebView.getParent()) == null || !(parent instanceof ViewGroup)) {
            return;
        }
        ((ViewGroup) parent).removeAllViewsInLayout();
    }

    @Override // cooperation.qzone.webviewwrapper.IWebviewWrapper
    public void onInit(Activity activity, Intent intent, String str, final IWebviewListener iWebviewListener) {
        this.guard.open(MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        this.mWebViewBuilder = new b(this.mContext, activity, intent, QzoneWebViewPluginManager.getInstance().getRuntime(), true);
        this.mWebview.setVisibility(4);
        this.mWebViewBuilder.setWebView(this.mWebview);
        this.mWebViewBuilder.a(new b.InterfaceC11212b() { // from class: com.qzone.proxy.covercomponent.adapter.WebviewWrapper.1
            @Override // s7.b.InterfaceC11212b
            public void onPageFinished() {
                if (WebviewWrapper.this.mWebview.getVisibility() != 0) {
                    WebviewWrapper.this.mWebview.setVisibility(0);
                    IWebviewListener iWebviewListener2 = iWebviewListener;
                    if (iWebviewListener2 != null) {
                        iWebviewListener2.onPageFinished();
                    }
                }
                a aVar = WebviewWrapper.this.qzoneShowJSPlugin;
                if (aVar != null) {
                    long j3 = aVar.f433404h;
                    if (j3 <= 0 || j3 < aVar.f433401d) {
                        aVar.f433404h = System.currentTimeMillis();
                    }
                }
            }
        });
        new m(this.mWebViewBuilder).a(null, QzoneWebViewPluginManager.getInstance().getRuntime(), null);
        WebViewPluginEngine pluginEngine = this.mWebview.getPluginEngine();
        if (pluginEngine != null) {
            a aVar = (a) pluginEngine.m("QzoneShow");
            this.qzoneShowJSPlugin = aVar;
            if (aVar != null) {
                aVar.f433401d = this.mWebviewStartTime;
                aVar.f433402e = System.currentTimeMillis();
                this.qzoneShowJSPlugin.q(str);
            }
        }
    }

    @Override // cooperation.qzone.webviewwrapper.IWebviewWrapper
    public void onPause() {
        b bVar = this.mWebViewBuilder;
        if (bVar != null) {
            bVar.onPause();
        }
    }

    @Override // cooperation.qzone.webviewwrapper.IWebviewWrapper
    public void onResume() {
        b bVar = this.mWebViewBuilder;
        if (bVar != null) {
            bVar.onResume();
        }
    }

    @Override // cooperation.qzone.webviewwrapper.IWebviewWrapper
    public void preInit() {
        if (this.mWebview == null) {
            this.mWebview = new TouchWebView(this.mContext);
        }
    }

    @Override // cooperation.qzone.webviewwrapper.IWebviewWrapper
    public void setOnWebviewTouchListener(View.OnTouchListener onTouchListener) {
        TouchWebView touchWebView = this.mWebview;
        if (touchWebView != null) {
            touchWebView.setOnTouchListener(onTouchListener);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    @Override // cooperation.qzone.webviewwrapper.IWebviewWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onWebViewReady(Intent intent, boolean z16) {
        a aVar;
        a aVar2;
        a aVar3;
        a aVar4;
        if (intent == null || this.mWebview == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(QzoneCoverConst.WebViewConst.KEY_WNS_PROXY_HTTP_DATA);
        String stringExtra2 = intent.getStringExtra("url");
        if (TextUtils.isEmpty(stringExtra) && TextUtils.isEmpty(stringExtra2)) {
            return;
        }
        boolean isEmpty = TextUtils.isEmpty(stringExtra);
        if (!z16 && isEmpty) {
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("key_wns_cache_hit", false);
        if (QZLog.isColorLevel()) {
            QZLog.d(TAG, 2, "CoverQzoneShowWebView load Url: " + stringExtra2 + ", wns proxy html hit caches:" + booleanExtra);
        }
        if (booleanExtra) {
            if (!z16 || (aVar4 = this.qzoneShowJSPlugin) == null) {
                return;
            }
            aVar4.f433406m = true;
            return;
        }
        if (z16 && isEmpty) {
            a aVar5 = this.qzoneShowJSPlugin;
            if (aVar5 != null && !aVar5.f433406m) {
                recordWebPageStartTime(stringExtra2);
                this.qzoneShowJSPlugin.f433406m = true;
            }
            this.mWebview.loadUrl(stringExtra2);
            if (QZLog.isColorLevel()) {
                QZLog.d(TAG, 2, "CoverQzoneShowWebView load Url: " + stringExtra2 + ", wns proxy html return failed!");
                return;
            }
            return;
        }
        boolean isEmpty2 = TextUtils.isEmpty(this.mWebview.getUrl());
        if (!z16 && (aVar3 = this.qzoneShowJSPlugin) != null && aVar3.f433403f <= 0) {
            recordWebPageStartTime(stringExtra2);
        }
        if (!isEmpty2) {
            try {
                if (intent.getBooleanExtra("need_force_refresh", false)) {
                }
            } catch (Exception e16) {
                QZLog.e(TAG, "onWebViewReady error", e16);
            }
            if (z16 && (aVar = this.qzoneShowJSPlugin) != null) {
                aVar.f433406m = true;
            }
            if (QZLog.isColorLevel()) {
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("CoverQzoneShowWebView load Url: ");
            sb5.append(stringExtra2);
            sb5.append(", htmlBody(true), currentUrl(");
            sb5.append(!isEmpty2);
            sb5.append(")");
            QZLog.d(TAG, 2, sb5.toString());
            return;
        }
        if (z16 && (aVar2 = this.qzoneShowJSPlugin) != null && !aVar2.f433406m) {
            recordWebPageStartTime(stringExtra2);
        }
        WebSoPlugin.z(this.mWebview, stringExtra2, stringExtra);
        if (z16) {
            aVar.f433406m = true;
        }
        if (QZLog.isColorLevel()) {
        }
    }
}
