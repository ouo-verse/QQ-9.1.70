package com.tencent.luggage.wxa.ei;

import com.tencent.luggage.wxa.ei.x;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a implements x {

    /* renamed from: a, reason: collision with root package name */
    public final Set f124864a = new LinkedHashSet();

    @Override // com.tencent.luggage.wxa.ei.x
    public void a(x.a aVar) {
        if (aVar == null) {
            return;
        }
        synchronized (this.f124864a) {
            this.f124864a.add(aVar);
        }
    }

    public final void b(String str) {
        LinkedList linkedList;
        synchronized (this.f124864a) {
            linkedList = new LinkedList(this.f124864a);
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((x.a) it.next()).a(str);
        }
    }

    @Override // com.tencent.luggage.wxa.ei.x
    public void b(x.a aVar) {
        if (aVar == null) {
            return;
        }
        synchronized (this.f124864a) {
            this.f124864a.remove(aVar);
        }
    }
}
