package com.qzone.jbox2d.dynamics;

/* compiled from: P */
/* loaded from: classes39.dex */
public class c implements f7.d {

    /* renamed from: a, reason: collision with root package name */
    public g7.a f48200a;

    /* renamed from: b, reason: collision with root package name */
    public h7.d f48201b = null;

    /* renamed from: c, reason: collision with root package name */
    public int f48202c = 0;

    /* renamed from: d, reason: collision with root package name */
    public f7.a f48203d = new f7.a();

    /* renamed from: e, reason: collision with root package name */
    private final l f48204e;

    public c(l lVar, g7.a aVar) {
        this.f48200a = aVar;
        this.f48204e = lVar;
    }

    public void a() {
        h7.d g16;
        h7.d dVar = this.f48201b;
        while (dVar != null) {
            e d16 = dVar.d();
            e e16 = dVar.e();
            int b16 = dVar.b();
            int c16 = dVar.c();
            a f16 = d16.f();
            a f17 = e16.f();
            if ((dVar.f404468a & 8) == 8) {
                if (!f17.t(f16)) {
                    g16 = dVar.g();
                    b(dVar);
                } else {
                    f7.a aVar = this.f48203d;
                    if (aVar != null && !aVar.a(d16, e16)) {
                        g16 = dVar.g();
                        b(dVar);
                    } else {
                        dVar.f404468a &= -9;
                    }
                }
                dVar = g16;
            }
            boolean z16 = f16.o() && f16.f48160a != BodyType.STATIC;
            boolean z17 = f17.o() && f17.f48160a != BodyType.STATIC;
            if (!z16 && !z17) {
                dVar = dVar.g();
            } else {
                if (!this.f48200a.d(d16.f48214g[b16].f48232d, e16.f48214g[c16].f48232d)) {
                    g16 = dVar.g();
                    b(dVar);
                    dVar = g16;
                } else {
                    dVar.n(null);
                    dVar = dVar.g();
                }
            }
        }
    }

    @Override // f7.d
    public void addPair(Object obj, Object obj2) {
        h7.d j3;
        g gVar = (g) obj;
        g gVar2 = (g) obj2;
        e eVar = gVar.f48230b;
        e eVar2 = gVar2.f48230b;
        int i3 = gVar.f48231c;
        int i16 = gVar2.f48231c;
        a f16 = eVar.f();
        a f17 = eVar2.f();
        if (f16 == f17) {
            return;
        }
        for (h7.e e16 = f17.e(); e16 != null; e16 = e16.f404488d) {
            if (e16.f404485a == f16) {
                e d16 = e16.f404486b.d();
                e e17 = e16.f404486b.e();
                int b16 = e16.f404486b.b();
                int c16 = e16.f404486b.c();
                if (d16 == eVar && b16 == i3 && e17 == eVar2 && c16 == i16) {
                    return;
                }
                if (d16 == eVar2 && b16 == i16 && e17 == eVar && c16 == i3) {
                    return;
                }
            }
        }
        if (f17.t(f16)) {
            f7.a aVar = this.f48203d;
            if ((aVar == null || aVar.a(eVar, eVar2)) && (j3 = this.f48204e.j(eVar, i3, eVar2, i16)) != null) {
                e d17 = j3.d();
                e e18 = j3.e();
                j3.b();
                j3.c();
                a f18 = d17.f();
                a f19 = e18.f();
                j3.f404469b = null;
                h7.d dVar = this.f48201b;
                j3.f404470c = dVar;
                if (dVar != null) {
                    dVar.f404469b = j3;
                }
                this.f48201b = j3;
                h7.e eVar3 = j3.f404471d;
                eVar3.f404486b = j3;
                eVar3.f404485a = f19;
                eVar3.f404487c = null;
                h7.e eVar4 = f18.f48175p;
                eVar3.f404488d = eVar4;
                if (eVar4 != null) {
                    eVar4.f404487c = eVar3;
                }
                f18.f48175p = eVar3;
                h7.e eVar5 = j3.f404472e;
                eVar5.f404486b = j3;
                eVar5.f404485a = f18;
                eVar5.f404487c = null;
                h7.e eVar6 = f19.f48175p;
                eVar5.f404488d = eVar6;
                if (eVar6 != null) {
                    eVar6.f404487c = eVar5;
                }
                f19.f48175p = eVar5;
                if (!d17.k() && !e18.k()) {
                    f18.r(true);
                    f19.r(true);
                }
                this.f48202c++;
            }
        }
    }

    public void b(h7.d dVar) {
        e d16 = dVar.d();
        e e16 = dVar.e();
        a f16 = d16.f();
        a f17 = e16.f();
        h7.d dVar2 = dVar.f404469b;
        if (dVar2 != null) {
            dVar2.f404470c = dVar.f404470c;
        }
        h7.d dVar3 = dVar.f404470c;
        if (dVar3 != null) {
            dVar3.f404469b = dVar2;
        }
        if (dVar == this.f48201b) {
            this.f48201b = dVar3;
        }
        h7.e eVar = dVar.f404471d;
        h7.e eVar2 = eVar.f404487c;
        if (eVar2 != null) {
            eVar2.f404488d = eVar.f404488d;
        }
        h7.e eVar3 = eVar.f404488d;
        if (eVar3 != null) {
            eVar3.f404487c = eVar2;
        }
        if (eVar == f16.f48175p) {
            f16.f48175p = eVar3;
        }
        h7.e eVar4 = dVar.f404472e;
        h7.e eVar5 = eVar4.f404487c;
        if (eVar5 != null) {
            eVar5.f404488d = eVar4.f404488d;
        }
        h7.e eVar6 = eVar4.f404488d;
        if (eVar6 != null) {
            eVar6.f404487c = eVar5;
        }
        if (eVar4 == f17.f48175p) {
            f17.f48175p = eVar6;
        }
        this.f48204e.k(dVar);
        this.f48202c--;
    }

    public void c() {
        this.f48200a.e(this);
    }
}
