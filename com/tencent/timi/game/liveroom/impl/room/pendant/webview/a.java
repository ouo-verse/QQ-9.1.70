package com.tencent.timi.game.liveroom.impl.room.pendant.webview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a extends AbsWebView implements com.tencent.mobileqq.webview.util.m {

    /* renamed from: a, reason: collision with root package name */
    private QQLiveJsPendantPlugin f378222a;

    /* renamed from: b, reason: collision with root package name */
    private InterfaceC9948a f378223b;

    /* compiled from: P */
    /* renamed from: com.tencent.timi.game.liveroom.impl.room.pendant.webview.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public interface InterfaceC9948a {
        void onPageFinished(WebView webView, String str);
    }

    public a(Context context, Activity activity, AppRuntime appRuntime, TouchWebView touchWebView) {
        super(context, activity, appRuntime);
        this.mWebview = touchWebView;
        QQLiveJsPendantPlugin qQLiveJsPendantPlugin = new QQLiveJsPendantPlugin();
        this.f378222a = qQLiveJsPendantPlugin;
        TouchWebView touchWebView2 = this.mWebview;
        if (touchWebView2 instanceof PendantWebView) {
            qQLiveJsPendantPlugin.f0((PendantWebView) touchWebView2);
        }
        buildBaseWebView(null);
    }

    public void a(InterfaceC9948a interfaceC9948a) {
        this.f378223b = interfaceC9948a;
    }

    @Override // com.tencent.mobileqq.webview.AbsWebView
    public void bindJavaScript(ArrayList<WebViewPlugin> arrayList) {
        super.bindJavaScript(arrayList);
        arrayList.add(this.f378222a);
    }

    @Override // com.tencent.mobileqq.webview.AbsWebView
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        InterfaceC9948a interfaceC9948a = this.f378223b;
        if (interfaceC9948a != null) {
            interfaceC9948a.onPageFinished(webView, str);
        }
    }

    @Override // com.tencent.mobileqq.webview.AbsWebView
    public void onWebViewReady() {
        super.onWebViewReady();
        QLog.i("PendantWebBuilder", 1, "onWebViewReady");
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
