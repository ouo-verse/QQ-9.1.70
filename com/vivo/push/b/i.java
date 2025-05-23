package com.vivo.push.b;

import com.huawei.hms.support.api.entity.common.CommonConstant;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class i extends s {

    /* renamed from: a, reason: collision with root package name */
    private String f387575a;

    /* renamed from: b, reason: collision with root package name */
    private String f387576b;

    /* renamed from: c, reason: collision with root package name */
    private String f387577c;

    /* renamed from: d, reason: collision with root package name */
    private String f387578d;

    public i(int i3) {
        super(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("app_id", this.f387575a);
        dVar.a(CommonConstant.ReqAccessTokenParam.CLIENT_ID, this.f387576b);
        dVar.a("client_token", this.f387577c);
        dVar.a("client_token_validity_period", this.f387578d);
    }

    public final String d() {
        return this.f387575a;
    }

    public final String e() {
        return this.f387577c;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final String toString() {
        return "OnBindCommand";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.f387575a = dVar.a("app_id");
        this.f387576b = dVar.a(CommonConstant.ReqAccessTokenParam.CLIENT_ID);
        this.f387577c = dVar.a("client_token");
        this.f387578d = dVar.a("client_token_validity_period");
    }
}
