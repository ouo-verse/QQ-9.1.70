package com.vivo.push.f;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes13.dex */
public final class x extends aa {
    /* JADX INFO: Access modifiers changed from: package-private */
    public x(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        Context context = this.f387838a;
        if (com.vivo.push.util.aa.c(context, context.getPackageName())) {
            e eVar = new e(vVar);
            eVar.a(((aa) this).f387661b);
            eVar.a(vVar);
        } else {
            d dVar = new d(vVar);
            dVar.a(((aa) this).f387661b);
            dVar.a(vVar);
        }
    }
}
