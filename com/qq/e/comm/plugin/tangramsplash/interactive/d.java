package com.qq.e.comm.plugin.tangramsplash.interactive;

import com.qq.e.comm.plugin.base.ad.model.r;
import com.qq.e.comm.plugin.tangramsplash.interactive.a;
import com.qq.e.comm.util.GDTLogger;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static volatile d f40220a;

    /* renamed from: b, reason: collision with root package name */
    private volatile a f40221b;

    public static d a() {
        if (f40220a == null) {
            synchronized (d.class) {
                if (f40220a == null) {
                    f40220a = new d();
                }
            }
        }
        return f40220a;
    }

    public synchronized void b() {
        a aVar = this.f40221b;
        if (aVar != null) {
            aVar.t();
        }
    }

    public synchronized void c() {
        a aVar = this.f40221b;
        if (aVar != null) {
            aVar.u();
        }
    }

    public synchronized void d() {
        a aVar = this.f40221b;
        if (aVar != null) {
            aVar.w();
        }
    }

    public synchronized void e() {
        a aVar = this.f40221b;
        if (aVar != null) {
            aVar.x();
        }
    }

    public synchronized void f() {
        if (this.f40221b != null) {
            GDTLogger.d("interactive ad clear wo called");
            this.f40221b.p();
            this.f40221b = null;
        }
    }

    public void g() {
        a aVar = this.f40221b;
        if (aVar != null) {
            GDTLogger.i("interactive ad clearFromOutSide");
            aVar.q();
        }
    }

    public synchronized void h() {
        if (this.f40221b != null) {
            GDTLogger.d("interactive userSkipped skipped");
            this.f40221b.r();
        }
    }

    public synchronized void i() {
        if (this.f40221b != null) {
            GDTLogger.d("interactive ad skipped");
            this.f40221b.s();
        }
    }

    public synchronized void a(r rVar, c cVar, b bVar, a.C0289a c0289a) {
        this.f40221b = a.a(rVar, cVar);
        if (this.f40221b != null) {
            this.f40221b.a(bVar);
            this.f40221b.a(c0289a);
            this.f40221b.c();
        }
    }
}
