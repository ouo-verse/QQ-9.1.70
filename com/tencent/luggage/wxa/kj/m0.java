package com.tencent.luggage.wxa.kj;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import java.net.URL;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public class m0 implements o0 {

    /* renamed from: a, reason: collision with root package name */
    public ViewGroup f132244a;

    /* renamed from: b, reason: collision with root package name */
    public ViewGroup f132245b;

    @Override // com.tencent.luggage.wxa.kj.o0
    public boolean A() {
        return false;
    }

    @Override // com.tencent.luggage.wxa.ei.j
    public com.tencent.luggage.wxa.ei.k a(Class cls) {
        return null;
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void c(Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }

    @Override // com.tencent.luggage.wxa.kj.o0, com.tencent.luggage.wxa.ei.j
    public void destroy() {
        this.f132244a = null;
        this.f132245b = null;
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public int getContentHeight() {
        return 0;
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public View getContentView() {
        return this.f132245b;
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public com.tencent.luggage.wxa.wj.d getFullscreenImpl() {
        return null;
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public int getHeight() {
        return 0;
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public /* synthetic */ v getPageView() {
        return b31.l.a(this);
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public String getUserAgentString() {
        return "MiniGame";
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public int getWebScrollX() {
        return 0;
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public int getWebScrollY() {
        return 0;
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public int getWidth() {
        return 0;
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public View getWrapperView() {
        return this.f132244a;
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public /* synthetic */ void setAppBrandWebViewClient(b0 b0Var) {
        b31.l.b(this, b0Var);
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public /* synthetic */ void setDisableContextMenuItems(int i3) {
        b31.l.c(this, i3);
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public boolean x() {
        return false;
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void a(int i3, int i16) {
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void a(int i3, long j3) {
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void a(String str, String str2) {
    }

    @Override // com.tencent.luggage.wxa.ei.j
    public void a(URL url, String str, ValueCallback valueCallback) {
    }

    @Override // com.tencent.luggage.wxa.ei.j
    public void a(URL url, String str, String str2, int i3, String str3, ValueCallback valueCallback) {
    }

    @Override // com.tencent.luggage.wxa.hp.a
    public boolean a(Canvas canvas) {
        return false;
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void a(Context context) {
        if (this.f132244a == null) {
            this.f132244a = new FrameLayout(context);
        }
        if (this.f132245b == null) {
            this.f132245b = new FrameLayout(context);
        }
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void onBackground() {
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void onForeground() {
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void z() {
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void setAppBrandInfo(Map map) {
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void setBackgroundColor(int i3) {
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void setFullscreenImpl(com.tencent.luggage.wxa.wj.d dVar) {
    }

    @Override // com.tencent.luggage.wxa.ei.j
    public void setJsExceptionHandler(com.tencent.luggage.wxa.ei.i iVar) {
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void setOnScrollChangedListener(f0 f0Var) {
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void setOnTrimListener(e0 e0Var) {
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void setVerticalScrollBarEnabled(boolean z16) {
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void setWebViewLayoutListener(d0 d0Var) {
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void setXWebKeyboardImpl(h0 h0Var) {
    }

    @Override // com.tencent.luggage.wxa.ei.j
    public void addJavascriptInterface(Object obj, String str) {
    }

    @Override // com.tencent.luggage.wxa.ei.p
    public void evaluateJavascript(String str, ValueCallback valueCallback) {
    }
}
