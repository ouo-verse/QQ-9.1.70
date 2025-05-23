package com.tencent.luggage.wxa.ni;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e implements com.tencent.luggage.wxa.hd.b {

    /* renamed from: a, reason: collision with root package name */
    public final List f135840a;

    public e(com.tencent.luggage.wxa.ic.g gVar) {
        LinkedList linkedList = new LinkedList();
        this.f135840a = linkedList;
        linkedList.add(new g(gVar));
        linkedList.add(new b());
        linkedList.add(new c(gVar));
        linkedList.add(new a(gVar));
    }

    @Override // com.tencent.luggage.wxa.hd.b
    public boolean a(com.tencent.luggage.wxa.xd.d dVar, String str) {
        if (dVar != null && str != null && str.length() != 0) {
            Iterator it = this.f135840a.iterator();
            while (it.hasNext()) {
                if (((com.tencent.luggage.wxa.hd.b) it.next()).a(dVar, str)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.hd.b
    public String c(com.tencent.luggage.wxa.xd.d dVar, String str) {
        if (dVar != null && str != null && str.length() != 0) {
            for (com.tencent.luggage.wxa.hd.b bVar : this.f135840a) {
                if (bVar.a(dVar, str)) {
                    return bVar.c(dVar, str);
                }
            }
        }
        return str;
    }
}
