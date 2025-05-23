package com.vivo.push.b;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class w extends com.vivo.push.v {

    /* renamed from: a, reason: collision with root package name */
    private int f387608a;

    public w() {
        super(2011);
        this.f387608a = 0;
    }

    @Override // com.vivo.push.v
    public final boolean c() {
        return true;
    }

    public final int d() {
        return this.f387608a;
    }

    @Override // com.vivo.push.v
    public final String toString() {
        return "PushModeCommand";
    }

    @Override // com.vivo.push.v
    protected final void c(com.vivo.push.d dVar) {
        dVar.a("com.bbk.push.ikey.MODE_TYPE", this.f387608a);
    }

    @Override // com.vivo.push.v
    protected final void d(com.vivo.push.d dVar) {
        this.f387608a = dVar.b("com.bbk.push.ikey.MODE_TYPE", 0);
    }
}
