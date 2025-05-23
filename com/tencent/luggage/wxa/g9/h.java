package com.tencent.luggage.wxa.g9;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class h {
    public static n a(com.tencent.luggage.wxa.j9.d dVar, com.tencent.luggage.wxa.l9.c cVar, int i3, boolean z16) {
        n dVar2;
        if (i3 != 2) {
            if (i3 != 3) {
                if (cVar != null && cVar.c().f138589z) {
                    dVar2 = new e(dVar, cVar);
                } else {
                    dVar2 = new f(dVar, cVar);
                }
            } else {
                dVar2 = new g(dVar, cVar);
            }
        } else {
            dVar2 = new d(dVar, cVar);
        }
        dVar2.init();
        if (z16) {
            dVar2.j();
        }
        return dVar2;
    }
}
