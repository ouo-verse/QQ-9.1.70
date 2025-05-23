package com.vivo.push.b;

/* compiled from: P */
/* loaded from: classes11.dex */
public abstract class v extends s {

    /* renamed from: a, reason: collision with root package name */
    private String f387606a;

    /* renamed from: b, reason: collision with root package name */
    private long f387607b;

    public v(int i3) {
        super(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.s, com.vivo.push.v
    public void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("OnVerifyCallBackCommand.EXTRA_SECURITY_CONTENT", this.f387606a);
        dVar.a("notify_id", this.f387607b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.s, com.vivo.push.v
    public void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.f387606a = dVar.a("OnVerifyCallBackCommand.EXTRA_SECURITY_CONTENT");
        this.f387607b = dVar.b("notify_id", -1L);
    }

    public final long f() {
        return this.f387607b;
    }

    public final String g() {
        return this.f387606a;
    }
}
