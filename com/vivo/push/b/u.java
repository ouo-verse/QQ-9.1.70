package com.vivo.push.b;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class u extends v {

    /* renamed from: a, reason: collision with root package name */
    private long f387604a;

    /* renamed from: b, reason: collision with root package name */
    private int f387605b;

    public u() {
        super(20);
        this.f387604a = -1L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("undo_msg_v1", this.f387604a);
        dVar.a("undo_msg_type_v1", this.f387605b);
    }

    public final long d() {
        return this.f387604a;
    }

    public final String e() {
        long j3 = this.f387604a;
        if (j3 != -1) {
            return String.valueOf(j3);
        }
        return null;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final String toString() {
        return "OnUndoMsgCommand";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.f387604a = dVar.b("undo_msg_v1", this.f387604a);
        this.f387605b = dVar.b("undo_msg_type_v1", 0);
    }
}
