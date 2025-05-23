package com.vivo.push.f;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes13.dex */
public final class aj extends com.vivo.push.s {
    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        com.vivo.push.b.c cVar = (com.vivo.push.b.c) vVar;
        com.vivo.push.model.b a16 = com.vivo.push.util.aa.a(this.f387838a, com.vivo.push.restructure.a.a().f());
        if (a16 == null) {
            com.vivo.push.m.a().a(cVar.f(), 1005, new Object[0]);
            return;
        }
        String a17 = a16.a();
        if (a16.c()) {
            com.vivo.push.m.a().a(cVar.f(), 1004, new Object[0]);
            vVar = new com.vivo.push.b.e();
        } else {
            int a18 = com.vivo.push.util.y.a(cVar);
            if (a18 != 0) {
                com.vivo.push.m.a().a(cVar.f(), a18, new Object[0]);
                return;
            }
        }
        com.vivo.push.a.a.a(this.f387838a, a17, vVar);
    }
}
