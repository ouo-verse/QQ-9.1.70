package com.qzone.jbox2d.dynamics;

import com.qzone.jbox2d.common.Sweep;
import com.qzone.jbox2d.common.Vec2;
import h7.h;
import h7.p;

/* compiled from: P */
/* loaded from: classes39.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public a[] f48233a;

    /* renamed from: b, reason: collision with root package name */
    public h7.d[] f48234b;

    /* renamed from: c, reason: collision with root package name */
    public i7.a[] f48235c;

    /* renamed from: d, reason: collision with root package name */
    public h7.n[] f48236d;

    /* renamed from: e, reason: collision with root package name */
    public p[] f48237e;

    /* renamed from: f, reason: collision with root package name */
    public int f48238f;

    /* renamed from: g, reason: collision with root package name */
    public int f48239g;

    /* renamed from: h, reason: collision with root package name */
    public int f48240h;

    /* renamed from: i, reason: collision with root package name */
    public int f48241i;

    /* renamed from: j, reason: collision with root package name */
    public int f48242j;

    /* renamed from: k, reason: collision with root package name */
    public int f48243k;

    /* renamed from: l, reason: collision with root package name */
    private final h7.h f48244l = new h7.h();

    /* renamed from: m, reason: collision with root package name */
    private final com.qzone.jbox2d.common.e f48245m = new com.qzone.jbox2d.common.e();

    /* renamed from: n, reason: collision with root package name */
    private final j f48246n = new j();

    /* renamed from: o, reason: collision with root package name */
    private final h.a f48247o = new h.a();

    /* renamed from: p, reason: collision with root package name */
    private final h7.h f48248p = new h7.h();

    /* renamed from: q, reason: collision with root package name */
    private final h.a f48249q = new h.a();

    /* renamed from: r, reason: collision with root package name */
    private final f7.b f48250r = new f7.b();

    public void a(a aVar) {
        int i3 = this.f48238f;
        aVar.f48162c = i3;
        this.f48233a[i3] = aVar;
        this.f48238f = i3 + 1;
    }

    public void b(h7.d dVar) {
        h7.d[] dVarArr = this.f48234b;
        int i3 = this.f48240h;
        this.f48240h = i3 + 1;
        dVarArr[i3] = dVar;
    }

    public void d(int i3, int i16, int i17, f7.c cVar) {
        this.f48241i = i3;
        this.f48242j = i16;
        this.f48243k = i17;
        this.f48238f = 0;
        this.f48240h = 0;
        this.f48239g = 0;
        a[] aVarArr = this.f48233a;
        if (aVarArr == null || i3 > aVarArr.length) {
            this.f48233a = new a[i3];
        }
        i7.a[] aVarArr2 = this.f48235c;
        if (aVarArr2 == null || i17 > aVarArr2.length) {
            this.f48235c = new i7.a[i17];
        }
        h7.d[] dVarArr = this.f48234b;
        if (dVarArr == null || i16 > dVarArr.length) {
            this.f48234b = new h7.d[i16];
        }
        p[] pVarArr = this.f48237e;
        if (pVarArr == null || i3 > pVarArr.length) {
            if (pVarArr == null) {
                pVarArr = new p[0];
            }
            p[] pVarArr2 = new p[i3];
            this.f48237e = pVarArr2;
            System.arraycopy(pVarArr, 0, pVarArr2, 0, pVarArr.length);
            int length = pVarArr.length;
            while (true) {
                p[] pVarArr3 = this.f48237e;
                if (length >= pVarArr3.length) {
                    break;
                }
                pVarArr3[length] = new p();
                length++;
            }
        }
        h7.n[] nVarArr = this.f48236d;
        if (nVarArr != null && this.f48241i <= nVarArr.length) {
            return;
        }
        if (nVarArr == null) {
            nVarArr = new h7.n[0];
        }
        h7.n[] nVarArr2 = new h7.n[this.f48241i];
        this.f48236d = nVarArr2;
        System.arraycopy(nVarArr, 0, nVarArr2, 0, nVarArr.length);
        int length2 = nVarArr.length;
        while (true) {
            h7.n[] nVarArr3 = this.f48236d;
            if (length2 >= nVarArr3.length) {
                return;
            }
            nVarArr3[length2] = new h7.n();
            length2++;
        }
    }

    public void c() {
        this.f48238f = 0;
        this.f48240h = 0;
        this.f48239g = 0;
    }

    public void g(k kVar, int i3, int i16) {
        for (int i17 = 0; i17 < this.f48238f; i17++) {
            h7.n nVar = this.f48236d[i17];
            Vec2 vec2 = nVar.f404544a;
            a aVar = this.f48233a[i17];
            Sweep sweep = aVar.f48165f;
            Vec2 vec22 = sweep.f48114c;
            vec2.f48119x = vec22.f48119x;
            vec2.f48120y = vec22.f48120y;
            nVar.f404545b = sweep.f48112a;
            p pVar = this.f48237e[i17];
            Vec2 vec23 = pVar.f404550a;
            Vec2 vec24 = aVar.f48166g;
            vec23.f48119x = vec24.f48119x;
            vec23.f48120y = vec24.f48120y;
            pVar.f404551b = aVar.f48167h;
        }
        h.a aVar2 = this.f48249q;
        aVar2.f404518b = this.f48234b;
        aVar2.f404519c = this.f48240h;
        aVar2.f404517a = kVar;
        aVar2.f404520d = this.f48236d;
        aVar2.f404521e = this.f48237e;
        this.f48248p.a(aVar2);
        for (int i18 = 0; i18 < kVar.f48273e && !this.f48248p.d(i3, i16); i18++) {
        }
        a[] aVarArr = this.f48233a;
        Sweep sweep2 = aVarArr[i3].f48165f;
        Vec2 vec25 = sweep2.f48115c0;
        h7.n[] nVarArr = this.f48236d;
        h7.n nVar2 = nVarArr[i3];
        Vec2 vec26 = nVar2.f404544a;
        vec25.f48119x = vec26.f48119x;
        vec25.f48120y = vec26.f48120y;
        sweep2.f48113a0 = nVar2.f404545b;
        aVarArr[i16].f48165f.f48115c0.set(nVarArr[i16].f404544a);
        this.f48233a[i16].f48165f.f48113a0 = this.f48236d[i16].f404545b;
        this.f48248p.b();
        for (int i19 = 0; i19 < kVar.f48272d; i19++) {
            this.f48248p.e();
        }
        float f16 = kVar.f48269a;
        for (int i26 = 0; i26 < this.f48238f; i26++) {
            h7.n nVar3 = this.f48236d[i26];
            Vec2 vec27 = nVar3.f404544a;
            float f17 = nVar3.f404545b;
            p pVar2 = this.f48237e[i26];
            Vec2 vec28 = pVar2.f404550a;
            float f18 = pVar2.f404551b;
            float f19 = vec28.f48119x * f16;
            float f26 = vec28.f48120y * f16;
            float f27 = (f19 * f19) + (f26 * f26);
            if (f27 > com.qzone.jbox2d.common.d.f48154v) {
                vec28.mulLocal(com.qzone.jbox2d.common.d.f48153u / com.qzone.jbox2d.common.b.p(f27));
            }
            float f28 = f16 * f18;
            if (f28 * f28 > com.qzone.jbox2d.common.d.f48156x) {
                f18 *= com.qzone.jbox2d.common.d.f48155w / com.qzone.jbox2d.common.b.a(f28);
            }
            float f29 = vec27.f48119x + (vec28.f48119x * f16);
            vec27.f48119x = f29;
            float f36 = vec27.f48120y + (vec28.f48120y * f16);
            vec27.f48120y = f36;
            float f37 = f17 + (f16 * f18);
            h7.n nVar4 = this.f48236d[i26];
            Vec2 vec29 = nVar4.f404544a;
            vec29.f48119x = f29;
            vec29.f48120y = f36;
            nVar4.f404545b = f37;
            p pVar3 = this.f48237e[i26];
            Vec2 vec210 = pVar3.f404550a;
            vec210.f48119x = vec28.f48119x;
            vec210.f48120y = vec28.f48120y;
            pVar3.f404551b = f18;
            a aVar3 = this.f48233a[i26];
            Sweep sweep3 = aVar3.f48165f;
            Vec2 vec211 = sweep3.f48114c;
            vec211.f48119x = vec27.f48119x;
            vec211.f48120y = vec27.f48120y;
            sweep3.f48112a = f37;
            Vec2 vec212 = aVar3.f48166g;
            vec212.f48119x = vec28.f48119x;
            vec212.f48120y = vec28.f48120y;
            aVar3.f48167h = f18;
            aVar3.v();
        }
        e(this.f48248p.f404510e);
    }

    public void f(i iVar, k kVar, Vec2 vec2, boolean z16) {
        boolean z17;
        float f16 = kVar.f48269a;
        for (int i3 = 0; i3 < this.f48238f; i3++) {
            a aVar = this.f48233a[i3];
            Sweep sweep = aVar.f48165f;
            Vec2 vec22 = sweep.f48114c;
            float f17 = sweep.f48112a;
            Vec2 vec23 = aVar.f48166g;
            float f18 = aVar.f48167h;
            sweep.f48115c0.set(vec22);
            sweep.f48113a0 = sweep.f48112a;
            if (aVar.f48160a == BodyType.DYNAMIC) {
                float f19 = vec23.f48119x;
                float f26 = aVar.f48182w;
                float f27 = vec2.f48119x * f26;
                float f28 = aVar.f48177r;
                Vec2 vec24 = aVar.f48168i;
                float f29 = f19 + ((f27 + (vec24.f48119x * f28)) * f16);
                vec23.f48119x = f29;
                float f36 = vec23.f48120y + (((f26 * vec2.f48120y) + (f28 * vec24.f48120y)) * f16);
                float f37 = f18 + (aVar.f48179t * f16 * aVar.f48169j);
                float f38 = aVar.f48180u;
                vec23.f48119x = f29 * (1.0f / ((f16 * f38) + 1.0f));
                vec23.f48120y = f36 * (1.0f / ((f38 * f16) + 1.0f));
                f18 = f37 * (1.0f / ((aVar.f48181v * f16) + 1.0f));
            }
            h7.n nVar = this.f48236d[i3];
            Vec2 vec25 = nVar.f404544a;
            vec25.f48119x = vec22.f48119x;
            vec25.f48120y = vec22.f48120y;
            nVar.f404545b = f17;
            p pVar = this.f48237e[i3];
            Vec2 vec26 = pVar.f404550a;
            vec26.f48119x = vec23.f48119x;
            vec26.f48120y = vec23.f48120y;
            pVar.f404551b = f18;
        }
        this.f48245m.b();
        j jVar = this.f48246n;
        jVar.f48266a = kVar;
        h7.n[] nVarArr = this.f48236d;
        jVar.f48267b = nVarArr;
        p[] pVarArr = this.f48237e;
        jVar.f48268c = pVarArr;
        h.a aVar2 = this.f48247o;
        aVar2.f404517a = kVar;
        aVar2.f404518b = this.f48234b;
        aVar2.f404519c = this.f48240h;
        aVar2.f404520d = nVarArr;
        aVar2.f404521e = pVarArr;
        this.f48244l.a(aVar2);
        this.f48244l.b();
        if (kVar.f48274f) {
            this.f48244l.g();
        }
        for (int i16 = 0; i16 < this.f48239g; i16++) {
            this.f48235c[i16].a(this.f48246n);
        }
        iVar.f48256f.a(this.f48245m.a());
        this.f48245m.b();
        for (int i17 = 0; i17 < kVar.f48272d; i17++) {
            for (int i18 = 0; i18 < this.f48239g; i18++) {
                this.f48235c[i18].c(this.f48246n);
            }
            this.f48244l.e();
        }
        this.f48244l.f();
        iVar.f48257g.a(this.f48245m.a());
        for (int i19 = 0; i19 < this.f48238f; i19++) {
            h7.n nVar2 = this.f48236d[i19];
            Vec2 vec27 = nVar2.f404544a;
            float f39 = nVar2.f404545b;
            p pVar2 = this.f48237e[i19];
            Vec2 vec28 = pVar2.f404550a;
            float f46 = pVar2.f404551b;
            float f47 = vec28.f48119x * f16;
            float f48 = vec28.f48120y * f16;
            float f49 = (f47 * f47) + (f48 * f48);
            if (f49 > com.qzone.jbox2d.common.d.f48154v) {
                float p16 = com.qzone.jbox2d.common.d.f48153u / com.qzone.jbox2d.common.b.p(f49);
                vec28.f48119x *= p16;
                vec28.f48120y *= p16;
            }
            float f56 = f16 * f46;
            if (f56 * f56 > com.qzone.jbox2d.common.d.f48156x) {
                f46 *= com.qzone.jbox2d.common.d.f48155w / com.qzone.jbox2d.common.b.a(f56);
            }
            vec27.f48119x += vec28.f48119x * f16;
            vec27.f48120y += vec28.f48120y * f16;
            this.f48236d[i19].f404545b = f39 + (f16 * f46);
            this.f48237e[i19].f404551b = f46;
        }
        this.f48245m.b();
        int i26 = 0;
        while (true) {
            if (i26 >= kVar.f48273e) {
                z17 = false;
                break;
            }
            boolean c16 = this.f48244l.c();
            z17 = true;
            boolean z18 = true;
            for (int i27 = 0; i27 < this.f48239g; i27++) {
                z18 = z18 && this.f48235c[i27].b(this.f48246n);
            }
            if (c16 && z18) {
                break;
            } else {
                i26++;
            }
        }
        for (int i28 = 0; i28 < this.f48238f; i28++) {
            a aVar3 = this.f48233a[i28];
            Sweep sweep2 = aVar3.f48165f;
            Vec2 vec29 = sweep2.f48114c;
            h7.n nVar3 = this.f48236d[i28];
            Vec2 vec210 = nVar3.f404544a;
            vec29.f48119x = vec210.f48119x;
            vec29.f48120y = vec210.f48120y;
            sweep2.f48112a = nVar3.f404545b;
            Vec2 vec211 = aVar3.f48166g;
            p pVar3 = this.f48237e[i28];
            Vec2 vec212 = pVar3.f404550a;
            vec211.f48119x = vec212.f48119x;
            vec211.f48120y = vec212.f48120y;
            aVar3.f48167h = pVar3.f404551b;
            aVar3.v();
        }
        iVar.f48258h.a(this.f48245m.a());
        e(this.f48244l.f404510e);
        if (z16) {
            float f57 = com.qzone.jbox2d.common.d.B;
            float f58 = f57 * f57;
            float f59 = com.qzone.jbox2d.common.d.C;
            float f65 = f59 * f59;
            float f66 = Float.MAX_VALUE;
            for (int i29 = 0; i29 < this.f48238f; i29++) {
                a aVar4 = this.f48233a[i29];
                if (aVar4.l() != BodyType.STATIC) {
                    if ((aVar4.f48161b & 4) != 0) {
                        float f67 = aVar4.f48167h;
                        if (f67 * f67 <= f65) {
                            Vec2 vec213 = aVar4.f48166g;
                            if (Vec2.dot(vec213, vec213) <= f58) {
                                float f68 = aVar4.f48183x + f16;
                                aVar4.f48183x = f68;
                                f66 = com.qzone.jbox2d.common.b.l(f66, f68);
                            }
                        }
                    }
                    f66 = 0.0f;
                    aVar4.f48183x = 0.0f;
                }
            }
            if (f66 < com.qzone.jbox2d.common.d.A || !z17) {
                return;
            }
            for (int i36 = 0; i36 < this.f48238f; i36++) {
                this.f48233a[i36].r(false);
            }
        }
    }

    public void e(h7.i[] iVarArr) {
    }
}
