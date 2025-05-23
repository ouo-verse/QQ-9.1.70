package com.tencent.luggage.wxa.f3;

import com.tencent.luggage.wxa.l6.i;
import com.tencent.luggage.wxa.ml.r;
import com.tencent.luggage.wxa.rc.o;
import com.tencent.luggage.wxa.rc.y;
import com.tencent.luggage.wxa.xd.k0;
import com.tencent.luggage.wxa.xd.l;
import com.tencent.luggage.wxa.xd.m;
import com.tencent.xweb.WebView;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b extends com.tencent.luggage.wxa.k6.b {

    /* renamed from: m, reason: collision with root package name */
    public final a f125254m;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b(a htmlWebView, com.tencent.luggage.wxa.m6.d urlCheckLogic) {
        super(r0, urlCheckLogic);
        Intrinsics.checkNotNullParameter(htmlWebView, "htmlWebView");
        Intrinsics.checkNotNullParameter(urlCheckLogic, "urlCheckLogic");
        WebView webView = htmlWebView.getWebView();
        Intrinsics.checkNotNull(webView);
        this.f125254m = htmlWebView;
    }

    @Override // com.tencent.luggage.wxa.k6.b, com.tencent.luggage.wxa.xd.d
    public void a(k0 k0Var, int[] iArr) {
        if (k0Var == null) {
            return;
        }
        if (k0Var instanceof i.b) {
            com.tencent.luggage.wxa.m4.b pageView = this.f125254m.getPageView();
            com.tencent.luggage.wxa.r4.d y06 = pageView != null ? pageView.y0() : null;
            if (y06 == null) {
                return;
            }
            ((i.b) k0Var).setContext(y06, this.f125254m.getPageView().getComponentId()).dispatch();
            return;
        }
        super.a(k0Var, iArr);
    }

    @Override // com.tencent.luggage.wxa.k6.b, com.tencent.luggage.wxa.xd.d
    public com.tencent.luggage.wxa.h1.b b(Class cls) {
        com.tencent.luggage.wxa.h1.b b16;
        com.tencent.luggage.wxa.m4.b pageView = this.f125254m.getPageView();
        return (pageView == null || (b16 = pageView.b(cls)) == null) ? com.tencent.luggage.wxa.h1.e.a(cls) : b16;
    }

    @Override // com.tencent.luggage.wxa.k6.b, com.tencent.luggage.wxa.xd.d
    public m c(Class clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        com.tencent.luggage.wxa.m4.b pageView = this.f125254m.getPageView();
        if (pageView != null) {
            return pageView.c(clazz);
        }
        return null;
    }

    @Override // com.tencent.luggage.wxa.k6.b
    public String g() {
        return this.f125254m.getCommitUrl();
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public String getAppId() {
        String appId = this.f125254m.getPageView().getAppId();
        Intrinsics.checkNotNullExpressionValue(appId, "htmlWebView.pageView.appId");
        return appId;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000d, code lost:
    
        if (r0.M0() == true) goto L8;
     */
    @Override // com.tencent.luggage.wxa.xd.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.tencent.luggage.wxa.qc.b getAppState() {
        boolean z16;
        com.tencent.luggage.wxa.m4.b pageView = this.f125254m.getPageView();
        if (pageView != null) {
            z16 = true;
        }
        z16 = false;
        if (z16) {
            return com.tencent.luggage.wxa.qc.b.FOREGROUND;
        }
        return com.tencent.luggage.wxa.qc.b.BACKGROUND;
    }

    @Override // com.tencent.luggage.wxa.k6.b, com.tencent.luggage.wxa.xd.d
    public int getComponentId() {
        return hashCode();
    }

    @Override // com.tencent.luggage.wxa.k6.b, com.tencent.luggage.wxa.xd.d
    public r getDialogContainer() {
        com.tencent.luggage.wxa.m4.b pageView = this.f125254m.getPageView();
        if (pageView != null) {
            return pageView.getDialogContainer();
        }
        return null;
    }

    @Override // com.tencent.luggage.wxa.k6.b, com.tencent.luggage.wxa.xd.d
    public com.tencent.luggage.wxa.rc.r getFileSystem() {
        com.tencent.luggage.wxa.rc.r rVar;
        com.tencent.luggage.wxa.m4.b pageView = this.f125254m.getPageView();
        if (pageView != null) {
            rVar = pageView.getFileSystem();
        } else {
            rVar = null;
        }
        if (rVar == null) {
            return null;
        }
        if (rVar instanceof y) {
            return ((y) rVar).a(o.class);
        }
        if (!(rVar instanceof o)) {
            return null;
        }
        return rVar;
    }

    @Override // com.tencent.luggage.wxa.k6.b
    public String h() {
        return this.f125254m.getCurrentURL();
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public boolean isRunning() {
        com.tencent.luggage.wxa.m4.b pageView = this.f125254m.getPageView();
        if (pageView != null && pageView.isRunning()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.k6.b
    public void b(String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.f125254m.f(title);
    }

    @Override // com.tencent.luggage.wxa.k6.b, com.tencent.luggage.wxa.xd.d
    public void a(Runnable runnable) {
        com.tencent.luggage.wxa.m4.b pageView = this.f125254m.getPageView();
        if (pageView != null) {
            pageView.a(runnable);
        }
    }

    @Override // com.tencent.luggage.wxa.k6.b, com.tencent.luggage.wxa.xd.d
    public l a(Class cls) {
        com.tencent.luggage.wxa.m4.b pageView = this.f125254m.getPageView();
        if (!(pageView instanceof com.tencent.luggage.wxa.xd.d)) {
            pageView = null;
        }
        if (pageView != null) {
            return pageView.a(cls);
        }
        return null;
    }
}
