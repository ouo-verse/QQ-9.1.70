package com.vivo.push.f;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes13.dex */
public final class h extends aa {
    /* JADX INFO: Access modifiers changed from: package-private */
    public h(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        com.vivo.push.b.i iVar = (com.vivo.push.b.i) vVar;
        String e16 = iVar.e();
        com.vivo.push.util.u.d("OnBindTask", "doTask,\u8ba2\u9605APP\u7ed3\u679c = " + iVar.i() + " clientToken= " + e16);
        com.vivo.push.m.a().a(iVar.h(), iVar.i(), e16);
        com.vivo.push.t.b(new i(this, e16, iVar));
    }
}
