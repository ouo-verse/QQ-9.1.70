package com.tencent.luggage.wxa.o3;

import com.tencent.luggage.wxa.o3.e;
import com.tencent.luggage.wxa.o3.g;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c implements e {

    /* renamed from: a, reason: collision with root package name */
    public HashSet f136091a = new HashSet();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e.c f136092a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f136093b;

        public a(e.c cVar, c cVar2) {
            this.f136092a = cVar;
            this.f136093b = cVar2;
        }

        @Override // com.tencent.luggage.wxa.o3.e.c
        public void a(g err) {
            Intrinsics.checkNotNullParameter(err, "err");
            e.c cVar = this.f136092a;
            if (cVar != null) {
                cVar.a(err);
            }
        }

        @Override // com.tencent.luggage.wxa.o3.e.c
        public void a(j jVar) {
            if (jVar == null) {
                e.c cVar = this.f136092a;
                if (cVar != null) {
                    cVar.a(g.d.f136117j);
                    return;
                }
                return;
            }
            if (jVar.g() != null) {
                if (!(jVar.g().length() == 0)) {
                    this.f136093b.a(jVar);
                    this.f136093b.b(jVar);
                    e.c cVar2 = this.f136092a;
                    if (cVar2 != null) {
                        cVar2.a(l.f136139a.a());
                        return;
                    }
                    return;
                }
            }
            e.c cVar3 = this.f136092a;
            if (cVar3 != null) {
                cVar3.a(g.d.f136117j);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.o3.e
    public void a(e.b logic, e.c cVar) {
        Intrinsics.checkNotNullParameter(logic, "logic");
        logic.a(new a(cVar, this));
    }

    @Override // com.tencent.luggage.wxa.o3.e
    public void b() {
        g();
    }

    public final void g() {
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.f136091a);
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((e.a) it.next()).a();
        }
    }

    @Override // com.tencent.luggage.wxa.o3.e
    public void a(e.a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f136091a.remove(callback);
    }

    @Override // com.tencent.luggage.wxa.o3.e
    public void b(e.a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f136091a.add(callback);
    }

    public final void b(j jVar) {
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.f136091a);
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((e.a) it.next()).a(jVar);
        }
    }
}
