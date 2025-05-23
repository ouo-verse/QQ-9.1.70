package com.tencent.luggage.wxa.j9;

import com.tencent.mm.audio.mix.jni.SilkResampleJni;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public d f130886a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.luggage.wxa.g9.a f130887b;

    /* renamed from: d, reason: collision with root package name */
    public com.tencent.luggage.wxa.f9.g f130889d;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.luggage.wxa.e9.d f130890e;

    /* renamed from: f, reason: collision with root package name */
    public String f130891f;

    /* renamed from: c, reason: collision with root package name */
    public HashMap f130888c = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    public volatile boolean f130892g = false;

    public c(boolean z16) {
        d dVar = new d(z16);
        this.f130886a = dVar;
        com.tencent.luggage.wxa.g9.a aVar = new com.tencent.luggage.wxa.g9.a(dVar);
        this.f130887b = aVar;
        this.f130886a.a(aVar);
        this.f130889d = new com.tencent.luggage.wxa.f9.g(null);
        this.f130890e = new com.tencent.luggage.wxa.e9.d();
    }

    public static boolean q(String str) {
        return com.tencent.luggage.wxa.m9.a.e(str);
    }

    public final void a(com.tencent.luggage.wxa.qb.b bVar) {
        bVar.f138589z = true;
        int c16 = this.f130886a.c(bVar.f138564a);
        int i3 = this.f130886a.i();
        if (!this.f130892g) {
            if (c16 <= 2000) {
                bVar.f138589z = false;
            }
            if (c16 >= 5000) {
                bVar.f138589z = true;
            } else if (i3 <= 5) {
                bVar.f138589z = false;
            } else {
                bVar.f138589z = true;
            }
            if (bVar.f138566c.contains("scale_intro")) {
                bVar.f138589z = false;
            }
        }
        if (i3 > 5) {
            ArrayList h16 = this.f130886a.h();
            if (h16.contains(bVar.f138564a)) {
                h16.remove(bVar.f138564a);
            }
            if (h16.size() > 2) {
                com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixPlayer", "do stop paused audio size:%d", Integer.valueOf(h16.size()));
                Iterator it = h16.iterator();
                while (it.hasNext()) {
                    v((String) it.next());
                }
            }
        }
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixPlayer", "playingCount:%d, duration:%d, supportMixPlay:%b", Integer.valueOf(i3), Integer.valueOf(c16), Boolean.valueOf(bVar.f138589z));
    }

    public void b(com.tencent.luggage.wxa.qb.b bVar) {
        this.f130891f = bVar.f138577n;
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixPlayer", "preparePlay:%s", bVar.f138564a);
        com.tencent.luggage.wxa.d9.a.e().c(this.f130891f);
        if (g(bVar.f138566c) && bVar.f138570g) {
            a(bVar);
        }
        this.f130886a.a(bVar);
        this.f130887b.a(bVar);
    }

    public void c() {
        this.f130887b.a();
        this.f130886a.a();
    }

    public void d(com.tencent.luggage.wxa.qb.b bVar) {
        this.f130886a.d(bVar);
        this.f130887b.c(bVar);
    }

    public com.tencent.luggage.wxa.qb.d e(String str) {
        return this.f130886a.d(str);
    }

    public long f() {
        return com.tencent.luggage.wxa.d9.f.c().d();
    }

    public boolean g(String str) {
        if (this.f130888c.containsKey(str)) {
            return ((Boolean) this.f130888c.get(str)).booleanValue();
        }
        boolean d16 = com.tencent.luggage.wxa.d9.f.c().d(str);
        if (d16) {
            this.f130888c.put(str, Boolean.valueOf(d16));
        }
        return d16;
    }

    public long h() {
        return com.tencent.luggage.wxa.d9.e.a().c();
    }

    public boolean i(String str) {
        return this.f130886a.g(str);
    }

    public boolean j(String str) {
        return this.f130886a.i(str);
    }

    public void k() {
        this.f130887b.c();
        this.f130886a.p();
        this.f130889d.b(this.f130891f);
        d();
        com.tencent.luggage.wxa.d9.a.e().g();
    }

    public void l() {
        this.f130887b.d();
        this.f130886a.q();
        SilkResampleJni.clearResampleAll();
        com.tencent.luggage.wxa.i9.g.a();
        c();
        com.tencent.luggage.wxa.d9.c.a().c();
        com.tencent.luggage.wxa.d9.a.e().c();
    }

    public void m() {
        this.f130887b.e();
        this.f130886a.t();
    }

    public boolean n(String str) {
        return this.f130886a.m(str);
    }

    public boolean o(String str) {
        return this.f130886a.n(str);
    }

    public boolean p(String str) {
        return this.f130886a.o(str);
    }

    public void r(String str) {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixPlayer", "pause audioId:%s, audio state:%d", str, Integer.valueOf(this.f130886a.f(str)));
        this.f130886a.p(str);
        this.f130887b.e(str);
    }

    public void s(String str) {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixPlayer", "play audioId:%s, audio state:%d", str, Integer.valueOf(this.f130886a.f(str)));
        a(this.f130886a.a(str));
        this.f130886a.q(str);
        this.f130887b.g(str);
    }

    public void t(String str) {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixPlayer", "remove audioId:%s", str);
        this.f130886a.r(str);
        this.f130887b.f(str);
    }

    public void u(String str) {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixPlayer", "resume audioId:%s, audio state:%d", str, Integer.valueOf(this.f130886a.f(str)));
        a(this.f130886a.a(str));
        this.f130886a.s(str);
        this.f130887b.g(str);
    }

    public void v(String str) {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixPlayer", "stop audioId:%s, audio state:%d", str, Integer.valueOf(this.f130886a.f(str)));
        this.f130886a.t(str);
        this.f130887b.h(str);
    }

    public void e() {
        c(false);
        b(false);
        a(false);
    }

    public boolean f(String str) {
        com.tencent.luggage.wxa.qb.b b16 = b(str);
        if (b16 == null) {
            return false;
        }
        if (this.f130888c.containsKey(b16.f138566c)) {
            return ((Boolean) this.f130888c.get(b16.f138566c)).booleanValue();
        }
        boolean d16 = com.tencent.luggage.wxa.d9.f.c().d(b16.f138566c);
        if (d16) {
            this.f130888c.put(b16.f138566c, Boolean.valueOf(d16));
        }
        return d16;
    }

    public boolean h(String str) {
        return this.f130887b.b(str);
    }

    public boolean i() {
        long f16 = f();
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixPlayer", "cacheInMemoryTotalSize:%d, appId:%s", Long.valueOf(f16), this.f130891f);
        boolean z16 = f16 >= 50000000;
        if (z16) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioMixPlayer", "isLoadedCacheExceedMaxMemory, exceed max cache 50M!, appId:%s", this.f130891f);
        }
        return z16;
    }

    public void j() {
        c(true);
        b(true);
        a(true);
    }

    public void c(com.tencent.luggage.wxa.qb.b bVar) {
        this.f130886a.c(bVar);
        this.f130887b.b(bVar);
    }

    public int d(String str) {
        return this.f130886a.c(str);
    }

    public boolean m(String str) {
        return this.f130886a.l(str);
    }

    public void d() {
        com.tencent.luggage.wxa.d9.f.c().b();
    }

    public long c(String str) {
        return com.tencent.luggage.wxa.d9.f.c().a(str);
    }

    public long g() {
        return this.f130886a.f();
    }

    public void c(boolean z16) {
        this.f130887b.a(z16);
    }

    public boolean k(String str) {
        return this.f130886a.j(str);
    }

    public com.tencent.luggage.wxa.qb.b b(String str) {
        return this.f130886a.a(str);
    }

    public boolean l(String str) {
        return this.f130886a.k(str);
    }

    public void b() {
        this.f130890e.b(this.f130891f);
        this.f130888c.clear();
    }

    public void b(boolean z16) {
        this.f130886a.b(z16);
    }

    public boolean a(String str, int i3) {
        boolean a16;
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixPlayer", "seekTo audioId:%s, position:%d", str, Integer.valueOf(i3));
        boolean a17 = this.f130887b.a(str, i3);
        if (!a17) {
            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixPlayer", "seekTo fail audioId:%s", Integer.valueOf(i3));
            return false;
        }
        a(10, str);
        long e16 = this.f130886a.e(str);
        int f16 = this.f130886a.f(str);
        if (!f(str)) {
            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixPlayer", "seekTo cache is not exist");
        } else if (d(str) <= 2000) {
            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixPlayer", "seekTo duration is not support seek");
            if (!this.f130887b.d(str)) {
                a17 = this.f130887b.b(str, i3);
            }
        } else if (Math.abs(i3 - e16) <= 2000) {
            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixPlayer", "seekTo time is not support seek");
        } else if (f16 != 0 && f16 != 1 && f16 != 2) {
            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixPlayer", "seekTo state is not support seek");
        } else if (!this.f130887b.d(str)) {
            this.f130886a.a(str, i3, false);
            a17 = this.f130887b.b(str, i3);
        } else {
            a16 = this.f130886a.a(str, i3);
            a(6, str);
            return a16 && a17;
        }
        a16 = true;
        a(6, str);
        if (a16) {
            return false;
        }
    }

    public void a(b bVar) {
        this.f130886a.a(bVar);
    }

    public void a(int i3, String str) {
        this.f130886a.a(i3, str);
    }

    public void a(g gVar) {
        this.f130886a.a(gVar);
    }

    public void a() {
        this.f130890e.a(this.f130891f);
        this.f130888c.clear();
    }

    public void a(String str) {
        this.f130890e.a(this.f130891f, str);
    }

    public void a(boolean z16) {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixPlayer", "forceMixPlay:%b", Boolean.valueOf(z16));
        this.f130892g = z16;
    }
}
