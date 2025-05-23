package com.tencent.luggage.wxa.vo;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c implements b, a {

    /* renamed from: a, reason: collision with root package name */
    public List f143716a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public boolean f143717b = true;

    @Override // com.tencent.luggage.wxa.vo.b
    public synchronized void b(a aVar) {
        if (!this.f143717b) {
            com.tencent.luggage.wxa.er.a.a(aVar);
            aVar.g();
        } else {
            this.f143716a.add(new WeakReference(aVar));
        }
    }

    @Override // com.tencent.luggage.wxa.vo.a
    public synchronized void g() {
        if (!this.f143717b) {
            return;
        }
        Iterator it = this.f143716a.iterator();
        while (it.hasNext()) {
            a aVar = (a) ((WeakReference) it.next()).get();
            if (aVar != null) {
                aVar.g();
            }
        }
        this.f143716a.clear();
        this.f143717b = false;
    }
}
