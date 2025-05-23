package com.tencent.luggage.wxa.yi;

import android.util.ArrayMap;

/* compiled from: P */
/* loaded from: classes9.dex */
public class m extends n {

    /* renamed from: b, reason: collision with root package name */
    public final ArrayMap f145922b = new ArrayMap(5);

    @Override // com.tencent.luggage.wxa.yi.k
    public i a(g gVar) {
        i iVar;
        g c16 = n.c(gVar);
        synchronized (this.f145922b) {
            iVar = (i) this.f145922b.get(c16);
        }
        return iVar;
    }

    @Override // com.tencent.luggage.wxa.yi.k
    public boolean b(g gVar) {
        i iVar;
        g c16 = n.c(gVar);
        synchronized (this.f145922b) {
            iVar = (i) this.f145922b.remove(c16);
        }
        if (iVar != null) {
            iVar.release();
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.yi.k
    public i a(g gVar, j jVar) {
        i iVar;
        g c16 = n.c(gVar);
        synchronized (this.f145922b) {
            iVar = (i) this.f145922b.get(c16);
            if (iVar == null) {
                iVar = jVar.a(c16);
                this.f145922b.put(c16, iVar);
            }
        }
        return iVar;
    }
}
