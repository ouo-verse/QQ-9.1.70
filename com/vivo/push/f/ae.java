package com.vivo.push.f;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes13.dex */
public final class ae extends aa {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        com.vivo.push.b.i iVar = (com.vivo.push.b.i) vVar;
        com.vivo.push.util.u.c("OnUnBindTask", "doTask,\u89e3\u8ba2\u9605APP\u7ed3\u679c = " + iVar.i() + " clientToken= " + iVar.e());
        com.vivo.push.m.a().a(iVar.h(), iVar.i(), new Object[0]);
        com.vivo.push.t.b(new af(this, iVar));
    }
}
