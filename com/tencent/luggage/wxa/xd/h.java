package com.tencent.luggage.wxa.xd;

import com.tencent.luggage.wxa.xd.g;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes9.dex */
public class h implements g {

    /* renamed from: a, reason: collision with root package name */
    public final Set f144801a = Collections.newSetFromMap(new ConcurrentHashMap());

    /* renamed from: b, reason: collision with root package name */
    public final Set f144802b = Collections.newSetFromMap(new ConcurrentHashMap());

    /* renamed from: c, reason: collision with root package name */
    public final Set f144803c = Collections.newSetFromMap(new ConcurrentHashMap());

    /* renamed from: d, reason: collision with root package name */
    public final Set f144804d = Collections.newSetFromMap(new ConcurrentHashMap());

    /* renamed from: e, reason: collision with root package name */
    public final Set f144805e = Collections.newSetFromMap(new ConcurrentHashMap());

    /* renamed from: f, reason: collision with root package name */
    public final Set f144806f = Collections.newSetFromMap(new ConcurrentHashMap());

    /* renamed from: g, reason: collision with root package name */
    public final Set f144807g = Collections.newSetFromMap(new ConcurrentHashMap());

    /* renamed from: h, reason: collision with root package name */
    public final Set f144808h = Collections.newSetFromMap(new ConcurrentHashMap());

    /* renamed from: i, reason: collision with root package name */
    public boolean f144809i = true;

    /* renamed from: j, reason: collision with root package name */
    public final AtomicBoolean f144810j = new AtomicBoolean(false);

    public void a(g.f fVar) {
        if (fVar == null) {
            return;
        }
        if (this.f144810j.get()) {
            fVar.onReady();
        } else {
            this.f144801a.add(fVar);
        }
    }

    public void b() {
        Iterator it = this.f144806f.iterator();
        if (it.hasNext()) {
            com.tencent.luggage.wxa.k0.d.a(it.next());
            throw null;
        }
    }

    public void c() {
        Iterator it = this.f144802b.iterator();
        while (it.hasNext()) {
            ((g.b) it.next()).onBackground();
        }
        b(false);
    }

    public void e() {
        Iterator it = this.f144804d.iterator();
        while (it.hasNext()) {
            ((g.c) it.next()).onDestroy();
        }
    }

    public void f() {
        Iterator it = this.f144803c.iterator();
        while (it.hasNext()) {
            ((g.d) it.next()).onForeground();
        }
        b(true);
    }

    public void g() {
        this.f144810j.set(true);
        Iterator it = this.f144801a.iterator();
        while (it.hasNext()) {
            ((g.f) it.next()).onReady();
        }
    }

    public void h() {
        this.f144801a.clear();
        this.f144804d.clear();
        this.f144802b.clear();
        this.f144803c.clear();
        this.f144805e.clear();
        this.f144806f.clear();
        this.f144808h.clear();
        this.f144807g.clear();
    }

    @Override // com.tencent.luggage.wxa.xd.g
    public void a(g.b bVar) {
        this.f144802b.add(bVar);
    }

    public void b(g.f fVar) {
        this.f144801a.remove(fVar);
    }

    @Override // com.tencent.luggage.wxa.xd.g
    public void a(g.d dVar) {
        this.f144803c.remove(dVar);
    }

    @Override // com.tencent.luggage.wxa.xd.g
    public void b(g.b bVar) {
        this.f144802b.remove(bVar);
    }

    public boolean a() {
        Iterator it = this.f144805e.iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            if (((g.a) it.next()).a()) {
                z16 = true;
            }
        }
        return z16;
    }

    @Override // com.tencent.luggage.wxa.xd.g
    public void b(g.d dVar) {
        this.f144803c.add(dVar);
    }

    public void b(boolean z16) {
        boolean z17 = this.f144809i;
        if (z17 && !z16) {
            Iterator it = this.f144808h.iterator();
            if (it.hasNext()) {
                com.tencent.luggage.wxa.k0.d.a(it.next());
                throw null;
            }
        } else if (!z17 && z16) {
            Iterator it5 = this.f144807g.iterator();
            while (it5.hasNext()) {
                ((g.e) it5.next()).a();
            }
        }
        this.f144809i = z16;
    }

    public void a(g.a aVar) {
        this.f144805e.add(aVar);
    }

    public void a(g.e eVar) {
        this.f144807g.add(eVar);
    }

    @Override // com.tencent.luggage.wxa.xd.g
    public void a(g.c cVar) {
        this.f144804d.add(cVar);
    }

    public void b(g.e eVar) {
        this.f144807g.remove(eVar);
    }

    @Override // com.tencent.luggage.wxa.xd.g
    public void b(g.c cVar) {
        this.f144804d.remove(cVar);
    }
}
