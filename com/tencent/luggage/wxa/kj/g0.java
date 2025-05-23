package com.tencent.luggage.wxa.kj;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.webkit.ValueCallback;
import java.net.URL;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class g0 implements o0 {

    /* renamed from: a, reason: collision with root package name */
    public final o0 f132207a;

    public g0(o0 webview) {
        Intrinsics.checkNotNullParameter(webview, "webview");
        this.f132207a = webview;
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public boolean A() {
        return this.f132207a.A();
    }

    public final o0 C() {
        return this.f132207a;
    }

    @Override // com.tencent.luggage.wxa.hp.a
    public boolean a(Canvas p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        return this.f132207a.a(p06);
    }

    @Override // com.tencent.luggage.wxa.ei.j
    public void addJavascriptInterface(Object obj, String str) {
        this.f132207a.addJavascriptInterface(obj, str);
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void c(Runnable runnable) {
        this.f132207a.c(runnable);
    }

    @Override // com.tencent.luggage.wxa.kj.o0, com.tencent.luggage.wxa.ei.j
    public void destroy() {
        this.f132207a.destroy();
    }

    @Override // com.tencent.luggage.wxa.ei.p
    public void evaluateJavascript(String str, ValueCallback valueCallback) {
        this.f132207a.evaluateJavascript(str, valueCallback);
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public int getContentHeight() {
        return this.f132207a.getContentHeight();
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public View getContentView() {
        return this.f132207a.getContentView();
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public com.tencent.luggage.wxa.wj.d getFullscreenImpl() {
        return this.f132207a.getFullscreenImpl();
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public int getHeight() {
        return this.f132207a.getHeight();
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public /* synthetic */ v getPageView() {
        return b31.l.a(this);
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public String getUserAgentString() {
        return this.f132207a.getUserAgentString();
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public int getWebScrollX() {
        return this.f132207a.getWebScrollX();
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public int getWebScrollY() {
        return this.f132207a.getWebScrollY();
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public int getWidth() {
        return this.f132207a.getWidth();
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public View getWrapperView() {
        return this.f132207a.getWrapperView();
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void onBackground() {
        this.f132207a.onBackground();
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void onForeground() {
        this.f132207a.onForeground();
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public /* synthetic */ void setAppBrandWebViewClient(b0 b0Var) {
        b31.l.b(this, b0Var);
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void setBackgroundColor(int i3) {
        this.f132207a.setBackgroundColor(i3);
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public /* synthetic */ void setDisableContextMenuItems(int i3) {
        b31.l.c(this, i3);
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void setFullscreenImpl(com.tencent.luggage.wxa.wj.d dVar) {
        this.f132207a.setFullscreenImpl(dVar);
    }

    @Override // com.tencent.luggage.wxa.ei.j
    public void setJsExceptionHandler(com.tencent.luggage.wxa.ei.i iVar) {
        this.f132207a.setJsExceptionHandler(iVar);
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void setOnScrollChangedListener(f0 f0Var) {
        this.f132207a.setOnScrollChangedListener(f0Var);
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void setVerticalScrollBarEnabled(boolean z16) {
        this.f132207a.setVerticalScrollBarEnabled(z16);
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void setWebViewLayoutListener(d0 d0Var) {
        this.f132207a.setWebViewLayoutListener(d0Var);
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void setXWebKeyboardImpl(h0 h0Var) {
        this.f132207a.setXWebKeyboardImpl(h0Var);
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public boolean x() {
        return this.f132207a.x();
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void z() {
        this.f132207a.z();
    }

    @Override // com.tencent.luggage.wxa.ei.j
    public void a(URL url, String str, String str2, int i3, String str3, ValueCallback valueCallback) {
        this.f132207a.a(url, str, str2, i3, str3, valueCallback);
    }

    @Override // com.tencent.luggage.wxa.ei.j
    public com.tencent.luggage.wxa.ei.k a(Class cls) {
        return this.f132207a.a(cls);
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void a(String str, String str2) {
        this.f132207a.a(str, str2);
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void a(Context context) {
        this.f132207a.a(context);
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void a(int i3, int i16) {
        this.f132207a.a(i3, i16);
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void a(int i3, long j3) {
        this.f132207a.a(i3, j3);
    }
}
