package com.vivo.push.b;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class j extends s {

    /* renamed from: a, reason: collision with root package name */
    private int f387579a;

    /* renamed from: b, reason: collision with root package name */
    private int f387580b;

    public j() {
        super(12);
        this.f387579a = -1;
        this.f387580b = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", this.f387579a);
        dVar.a("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", this.f387580b);
    }

    public final int d() {
        return this.f387579a;
    }

    public final int e() {
        return this.f387580b;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final String toString() {
        return "OnChangePushStatusCommand";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.f387579a = dVar.b("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", this.f387579a);
        this.f387580b = dVar.b("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", this.f387580b);
    }
}
