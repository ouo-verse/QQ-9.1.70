package com.vivo.push.b;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class m extends s {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<String> f387583a;

    public m() {
        super(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("tags_list", this.f387583a);
    }

    public final ArrayList<String> d() {
        return this.f387583a;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final String toString() {
        return "OnListTagCommand";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.f387583a = dVar.c("tags_list");
    }
}
