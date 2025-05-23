package com.qzone.widget.particle;

/* compiled from: P */
/* loaded from: classes37.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private double f60941a = 0.01d;

    public void b(double d16) {
        this.f60941a = d16;
    }

    public void c(b bVar) {
        if (bVar.d() <= 0) {
            bVar.B((bVar.j() - bVar.h()) * this.f60941a);
            bVar.C((bVar.k() - bVar.i()) * this.f60941a);
            bVar.o(bVar.b() + bVar.l());
            bVar.p(bVar.c() + bVar.m());
            if (Math.abs(bVar.b() - bVar.j()) < Math.abs((bVar.h() - bVar.j()) / 2.0d) && Math.abs(bVar.c() - bVar.k()) < Math.abs((bVar.h() - bVar.k()) / 2.0d)) {
                bVar.r(false);
            }
            if (Math.abs(bVar.b() - bVar.j()) >= Math.abs(bVar.l()) || Math.abs(bVar.c() - bVar.k()) >= Math.abs(bVar.m())) {
                return;
            }
            d(bVar);
            return;
        }
        bVar.q(bVar.d() - 1);
    }

    public void a(b bVar, int i3, int i16) {
        bVar.v(i3);
        bVar.w(i16);
    }

    public void d(b bVar) {
        double g16 = bVar.g() + ((Math.random() - 0.5d) * 30.0d);
        bVar.x(g16);
        double f16 = bVar.f() + (((Math.random() * 0.6d) + 0.1d) * (bVar.e() - bVar.f()));
        bVar.y(f16);
        double random = Math.random() - 0.5d;
        if (Math.abs(random) < 0.3d) {
            random = random > 0.0d ? 0.3d : -0.3d;
        }
        bVar.z(bVar.h() + (random * 30.0d));
        bVar.A(bVar.f() + (((Math.random() * 0.6d) + 0.1d) * (bVar.e() - bVar.f())));
        bVar.o(g16);
        bVar.p(f16);
        bVar.n();
    }
}
