package com.tencent.rfw.barrage.core;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import vz3.g;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private final vz3.g<com.tencent.rfw.barrage.data.a> f365029b;

    /* renamed from: c, reason: collision with root package name */
    private final vz3.c f365030c;

    /* renamed from: e, reason: collision with root package name */
    private volatile long f365032e = -1;

    /* renamed from: a, reason: collision with root package name */
    private final List<com.tencent.rfw.barrage.data.a> f365028a = new LinkedList();

    /* renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f365031d = new AtomicBoolean(false);

    /* compiled from: P */
    /* loaded from: classes25.dex */
    class a implements g.b<com.tencent.rfw.barrage.data.a> {
        a() {
        }

        @Override // vz3.g.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public int a(com.tencent.rfw.barrage.data.a aVar, long j3) {
            if (aVar == null) {
                return -1;
            }
            long H = aVar.H() - j3;
            if (H == 0) {
                return 0;
            }
            if (H <= 0) {
                return -1;
            }
            return 1;
        }
    }

    public b(vz3.c cVar, RFWBarrageComparator rFWBarrageComparator) {
        this.f365030c = cVar;
        this.f365029b = new vz3.g<>(rFWBarrageComparator, new a());
    }

    private void f() {
        while (!this.f365031d.compareAndSet(false, true)) {
            wz3.b.a("RFWBarrageDataSource", "lock is blocked");
            Thread.yield();
        }
    }

    private void h() {
        while (!this.f365031d.compareAndSet(true, false)) {
            wz3.b.c("RFWBarrageDataSource", "update end is blocked! this can not happend!");
            Thread.yield();
        }
    }

    private void i(List<com.tencent.rfw.barrage.data.a> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            com.tencent.rfw.barrage.data.a aVar = list.get(size);
            if (aVar != null && aVar.H() <= this.f365032e) {
                aVar.c();
            }
        }
    }

    public void a(com.tencent.rfw.barrage.data.a aVar) {
        f();
        vz3.g<com.tencent.rfw.barrage.data.a> gVar = this.f365029b;
        if (gVar != null) {
            gVar.b(aVar);
        }
        h();
    }

    public void b(com.tencent.rfw.barrage.data.a aVar) {
        f();
        wz3.b.f("RFWBarrageDataSource", "[addNow] barrage = " + aVar);
        vz3.g<com.tencent.rfw.barrage.data.a> gVar = this.f365029b;
        if (gVar != null) {
            gVar.a(aVar);
        }
        h();
    }

    public void c() {
        wz3.b.h("RFWBarrageDataSource", "[clear] clear barrage queue.");
        f();
        vz3.g<com.tencent.rfw.barrage.data.a> gVar = this.f365029b;
        if (gVar != null) {
            gVar.c();
        }
        h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.tencent.rfw.barrage.data.a> d() {
        if (this.f365029b == null) {
            return null;
        }
        f();
        this.f365029b.e(this.f365030c.a(), this.f365028a);
        i(this.f365028a);
        h();
        return this.f365028a;
    }

    public int e() {
        vz3.g<com.tencent.rfw.barrage.data.a> gVar = this.f365029b;
        if (gVar == null) {
            return 0;
        }
        return gVar.f();
    }

    public void g() {
        f();
        vz3.g<com.tencent.rfw.barrage.data.a> gVar = this.f365029b;
        if (gVar == null) {
            wz3.b.a("RFWBarrageDataSource", "[notifyConfigDirty] barrage sorted queue should not be null.");
            return;
        }
        com.tencent.rfw.barrage.data.a d16 = gVar.d();
        if (d16 == null) {
            this.f365032e = -1L;
        } else {
            this.f365032e = d16.H();
        }
        h();
    }
}
