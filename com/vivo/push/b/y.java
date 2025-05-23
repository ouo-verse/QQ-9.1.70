package com.vivo.push.b;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class y extends com.vivo.push.v {

    /* renamed from: a, reason: collision with root package name */
    private String f387611a;

    public y(String str) {
        super(2008);
        this.f387611a = str;
    }

    @Override // com.vivo.push.v
    protected final void c(com.vivo.push.d dVar) {
        dVar.a("package_name", this.f387611a);
    }

    @Override // com.vivo.push.v
    protected final void d(com.vivo.push.d dVar) {
        this.f387611a = dVar.a("package_name");
    }

    @Override // com.vivo.push.v
    public final String toString() {
        return "StopServiceCommand";
    }

    public y() {
        super(2008);
    }
}
