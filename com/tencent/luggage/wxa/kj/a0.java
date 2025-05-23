package com.tencent.luggage.wxa.kj;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.lang.StringUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a0 extends n {

    /* renamed from: h0, reason: collision with root package name */
    public v f132066h0;

    /* renamed from: i0, reason: collision with root package name */
    public String f132067i0;

    /* renamed from: j0, reason: collision with root package name */
    public final AtomicBoolean f132068j0;

    public a0(Context context, p pVar) {
        super(context, pVar);
        this.f132068j0 = new AtomicBoolean(false);
    }

    @Override // com.tencent.luggage.wxa.kj.n
    public void a(long j3, String str) {
        this.f132067i0 = str;
        this.f132068j0.set(true);
        this.f132066h0.a(j3, str, k1.REWRITE_ROUTE);
    }

    @Override // com.tencent.luggage.wxa.kj.n
    public void g() {
        super.g();
        this.f132066h0.e();
    }

    @Override // com.tencent.luggage.wxa.kj.n
    public v getCurrentPageView() {
        return this.f132066h0;
    }

    @Override // com.tencent.luggage.wxa.kj.n
    public String getCurrentUrl() {
        return this.f132067i0;
    }

    @Override // com.tencent.luggage.wxa.kj.n
    public View h() {
        if (this.f132066h0 == null) {
            v d16 = getContainer().d(com.tencent.luggage.wxa.h6.o.b(this.f132067i0));
            this.f132066h0 = d16;
            a(d16);
        }
        return this.f132066h0.getContentView();
    }

    @Override // com.tencent.luggage.wxa.kj.n
    public void s() {
        this.f132066h0.T0();
    }

    @Override // com.tencent.luggage.wxa.kj.n
    public void setInitialUrl(String str) {
        this.f132067i0 = str;
    }

    @Override // com.tencent.luggage.wxa.kj.n
    public void t() {
        super.t();
        this.f132066h0.V0();
    }

    @Override // com.tencent.luggage.wxa.kj.n
    public void u() {
        super.u();
        this.f132066h0.X0();
    }

    @Override // com.tencent.luggage.wxa.kj.n
    public void v() {
        super.v();
        this.f132066h0.a1();
    }

    @Override // com.tencent.luggage.wxa.kj.n
    public v a(int i3, boolean z16) {
        if (z16 && this.f132066h0.o1()) {
            if (this.f132066h0.a(i3)) {
                return this.f132066h0;
            }
            return null;
        }
        if (this.f132066h0.getComponentId() == i3) {
            return this.f132066h0;
        }
        return null;
    }

    @Override // com.tencent.luggage.wxa.kj.n
    public void a(long j3, String str, k1 k1Var) {
        com.tencent.luggage.wxa.er.a.b(TextUtils.isEmpty(this.f132067i0) || StringUtils.equals(this.f132067i0, str));
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandSinglePage", "AppBrandPageProfile| loadUrl, appId:%s, url:%s", getAppId(), str);
        this.f132067i0 = str;
        if (this.f132068j0.getAndSet(true)) {
            return;
        }
        this.f132066h0.a(j3, str, k1Var);
    }

    @Override // com.tencent.luggage.wxa.kj.n
    public void a(String str, v vVar) {
        this.f132067i0 = str;
        this.f132068j0.set(true);
    }

    @Override // com.tencent.luggage.wxa.kj.n
    public boolean a(String str) {
        return com.tencent.luggage.wxa.h6.o.b(this.f132067i0).equals(com.tencent.luggage.wxa.h6.o.b(str));
    }

    @Override // com.tencent.luggage.wxa.kj.n
    public void a(String str, String str2, int[] iArr) {
        if (a(iArr, this.f132066h0.getComponentId())) {
            this.f132066h0.a(str, str2);
        }
    }
}
