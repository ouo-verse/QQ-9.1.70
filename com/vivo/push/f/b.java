package com.vivo.push.f;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes13.dex */
public final class b extends com.vivo.push.s {
    /* JADX INFO: Access modifiers changed from: package-private */
    public b(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        boolean b16;
        com.vivo.push.model.b a16 = com.vivo.push.util.aa.a(this.f387838a, com.vivo.push.restructure.a.a().f());
        try {
            if (((com.vivo.push.b.d) vVar).d()) {
                b16 = j.a(this.f387838a);
            } else {
                b16 = j.b(this.f387838a);
            }
            if (b16) {
                com.vivo.push.model.b a17 = com.vivo.push.util.aa.a(this.f387838a, com.vivo.push.restructure.a.a().f());
                if (a16 != null && a17 != null && a17.a() != null && a17.a().equals(a16.a())) {
                    return;
                }
                if (a16 != null && a16.a() != null) {
                    com.vivo.push.a.a.a(this.f387838a, a16.a(), new com.vivo.push.b.y(a16.a()));
                }
                if (a17 != null && a17.a() != null) {
                    com.vivo.push.b.f fVar = new com.vivo.push.b.f();
                    com.vivo.push.restructure.a.a();
                    fVar.d();
                    com.vivo.push.a.a.a(this.f387838a, a17.a(), fVar);
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
