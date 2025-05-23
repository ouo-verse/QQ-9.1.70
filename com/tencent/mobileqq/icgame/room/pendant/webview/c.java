package com.tencent.mobileqq.icgame.room.pendant.webview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.util.m;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c extends AbsWebView implements m {

    /* renamed from: a, reason: collision with root package name */
    private b f237683a;

    /* renamed from: b, reason: collision with root package name */
    private a f237684b;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface a {
        void onPageFinished(WebView webView, String str);
    }

    public c(Context context, Activity activity, AppRuntime appRuntime, TouchWebView touchWebView) {
        super(context, activity, appRuntime);
        this.mWebview = touchWebView;
        b bVar = new b();
        this.f237683a = bVar;
        TouchWebView touchWebView2 = this.mWebview;
        if (touchWebView2 instanceof PendantWebView) {
            bVar.v((PendantWebView) touchWebView2);
        }
        buildBaseWebView(null);
    }

    public void a(a aVar) {
        this.f237684b = aVar;
    }

    @Override // com.tencent.mobileqq.webview.AbsWebView
    public void bindJavaScript(ArrayList<WebViewPlugin> arrayList) {
        super.bindJavaScript(arrayList);
        arrayList.add(this.f237683a);
    }

    @Override // com.tencent.mobileqq.webview.AbsWebView
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        a aVar = this.f237684b;
        if (aVar != null) {
            aVar.onPageFinished(webView, str);
        }
    }

    @Override // com.tencent.mobileqq.webview.AbsWebView
    public void onWebViewReady() {
        super.onWebViewReady();
        QLog.i("ICGamePendantWebBuilder", 1, "onWebViewReady");
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public void buildBottomBar() {
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public void buildData() {
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public void buildLayout() {
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public void buildTitleBar() {
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public void preInitWebviewPlugin() {
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public void buildContentView(Bundle bundle) {
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public void buildWebView(AppRuntime appRuntime) {
    }
}
