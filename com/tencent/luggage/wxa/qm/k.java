package com.tencent.luggage.wxa.qm;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public class k extends i {

    /* renamed from: g, reason: collision with root package name */
    public static k f138945g;

    /* renamed from: e, reason: collision with root package name */
    public b f138946e;

    /* renamed from: f, reason: collision with root package name */
    public com.tencent.luggage.wxa.wm.a f138947f;

    public k(b bVar) {
        this.f138946e = bVar;
    }

    public static synchronized void a(b bVar) {
        synchronized (k.class) {
            if (f138945g != null) {
                w.b("MicroMsg.Music.MusicPlayerManager", "music player mgr is init, don't it again");
                f138945g.f138946e = bVar;
            } else {
                f138945g = new k(bVar);
            }
        }
    }

    public static k f() {
        k kVar = f138945g;
        if (kVar != null) {
            if (kVar.f138946e == null) {
                kVar.f138946e = new j();
            }
            ((com.tencent.luggage.wxa.km.b) com.tencent.luggage.wxa.eo.g.a(com.tencent.luggage.wxa.km.b.class)).c();
            return f138945g;
        }
        throw new NullPointerException("must init MusicPlayerManager with your impl logic first!!!");
    }

    public static com.tencent.luggage.wxa.wm.a g() {
        if (f().f138947f == null) {
            f().f138947f = new com.tencent.luggage.wxa.wm.a();
        }
        return f().f138947f;
    }

    public static b h() {
        return f().f138946e;
    }

    public static boolean i() {
        if (f138945g != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.qm.i
    public com.tencent.luggage.wxa.sm.d b() {
        return super.b();
    }

    public final void c(com.tencent.luggage.wxa.rb.d dVar) {
        com.tencent.luggage.wxa.wm.d.a(dVar);
        if (this.f138946e.g(dVar)) {
            a(dVar);
        } else {
            e();
            w.b("MicroMsg.Music.MusicPlayerManager", "prepare is fail, not to play or wait for callback onStart");
        }
    }

    public void d(com.tencent.luggage.wxa.rb.d dVar) {
        if (dVar == null) {
            w.d("MicroMsg.Music.MusicPlayerManager", "musicWrapper is null");
        } else {
            w.d("MicroMsg.Music.MusicPlayerManager", "startMusicInList");
            c(this.f138946e.i(dVar));
        }
    }

    public void e(com.tencent.luggage.wxa.rb.d dVar) {
        if (dVar != null) {
            w.d("MicroMsg.Music.MusicPlayerManager", "MusicType %d", Integer.valueOf(dVar.f139439a));
        }
        w.d("MicroMsg.Music.MusicPlayerManager", "startPlayNewMusic");
        c(this.f138946e.m(dVar));
    }

    @Override // com.tencent.luggage.wxa.qm.i
    public void b(int i3) {
        super.b(i3);
    }

    @Override // com.tencent.luggage.wxa.qm.i
    public void b(com.tencent.luggage.wxa.rb.d dVar) {
        super.b(dVar);
        this.f138946e.h(dVar);
    }

    public void a(List list, int i3) {
        com.tencent.luggage.wxa.rb.c a16;
        w.d("MicroMsg.Music.MusicPlayerManager", "startPlayNewMusicList");
        com.tencent.luggage.wxa.rb.d a17 = a();
        com.tencent.luggage.wxa.rb.d a18 = this.f138946e.a(list, i3);
        if (a17 != null && a18 != null && w0.a(a17.f139441c, a18.f139441c) && (a16 = com.tencent.luggage.wxa.rb.a.a()) != null && "play".equals(a16.f139438f)) {
            b(a18);
        } else {
            c(a18);
        }
    }

    @Override // com.tencent.luggage.wxa.qm.i
    public void d() {
        super.d();
    }

    public void f(com.tencent.luggage.wxa.rb.d dVar) {
        this.f138946e.c(dVar);
    }

    @Override // com.tencent.luggage.wxa.qm.i
    public void a(boolean z16) {
        super.a(z16);
    }

    public void a(List list, boolean z16) {
        this.f138946e.a(list, z16);
    }

    @Override // com.tencent.luggage.wxa.qm.i
    public com.tencent.luggage.wxa.rb.d a() {
        return this.f138946e.c();
    }

    @Override // com.tencent.luggage.wxa.qm.d
    public boolean a(int i3) {
        return this.f138946e.a(i3);
    }
}
