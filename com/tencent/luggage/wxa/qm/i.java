package com.tencent.luggage.wxa.qm;

import android.os.Looper;
import com.tencent.luggage.wxa.p9.h;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class i implements d {

    /* renamed from: d, reason: collision with root package name */
    public Runnable f138943d = new a();

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.rm.e f138940a = new com.tencent.luggage.wxa.rm.e();

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.luggage.wxa.rm.f f138941b = new com.tencent.luggage.wxa.rm.f();

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.luggage.wxa.rm.g f138942c = new com.tencent.luggage.wxa.rm.g();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean c16 = i.this.b().c();
            boolean i3 = i.this.b().i();
            w.d("MicroMsg.Music.MusicBasePlayEngine", "stopMusicDelayRunnable, isStartPlayMusic:%b, isPlayingMusic:%b", Boolean.valueOf(c16), Boolean.valueOf(i3));
            if (c16 && !i3) {
                i.this.b().f();
            }
        }
    }

    public abstract com.tencent.luggage.wxa.rb.d a();

    public void a(com.tencent.luggage.wxa.rb.d dVar) {
        if (com.tencent.luggage.wxa.wm.c.a(dVar)) {
            w.d("MicroMsg.Music.MusicBasePlayEngine", "use musicPlayer");
            e();
            this.f138942c.a(dVar);
        } else if (com.tencent.luggage.wxa.wm.c.a(dVar.f139439a)) {
            w.d("MicroMsg.Music.MusicBasePlayEngine", "use qqMusicPlayer");
            e();
            if (!dVar.R && a(dVar.f139439a)) {
                dVar.R = true;
                w.d("MicroMsg.Music.MusicBasePlayEngine", "support useNetworkDataPlay, MusicType:%d", Integer.valueOf(dVar.f139439a));
            }
            this.f138941b.a(dVar);
        } else {
            w.d("MicroMsg.Music.MusicBasePlayEngine", "use musicPlayer");
            e();
            this.f138940a.a(dVar);
        }
        if (dVar.f139439a != 11) {
            c();
        }
    }

    public com.tencent.luggage.wxa.sm.d b() {
        com.tencent.luggage.wxa.rb.d a16 = a();
        if (com.tencent.luggage.wxa.wm.c.a(a16)) {
            return this.f138942c;
        }
        if (a16 != null && com.tencent.luggage.wxa.wm.c.a(a16.f139439a)) {
            return this.f138941b;
        }
        return this.f138940a;
    }

    public void c() {
        w.d("MicroMsg.Music.MusicBasePlayEngine", "sendPreemptedEvent");
        com.tencent.luggage.wxa.p9.h hVar = new com.tencent.luggage.wxa.p9.h();
        h.a aVar = hVar.f137468d;
        aVar.f137469a = 10;
        aVar.f137473e = com.tencent.luggage.wxa.sm.d.f140416h;
        aVar.f137476h = "not from app brand appid";
        aVar.f137474f = true;
        hVar.a(Looper.getMainLooper());
    }

    public void d() {
        this.f138940a.f();
        com.tencent.luggage.wxa.rm.f fVar = this.f138941b;
        if (fVar != null) {
            fVar.f();
        }
        com.tencent.luggage.wxa.rm.g gVar = this.f138942c;
        if (gVar != null) {
            gVar.f();
        }
        c0.b(this.f138943d);
    }

    public void e() {
        if (this.f138940a.i()) {
            this.f138940a.f();
        }
        if (this.f138941b.i()) {
            this.f138941b.f();
        }
        if (this.f138942c.i()) {
            this.f138942c.f();
        }
    }

    public void b(com.tencent.luggage.wxa.rb.d dVar) {
        if (this.f138940a.i()) {
            this.f138940a.n(dVar);
        }
        if (this.f138941b.i()) {
            this.f138941b.n(dVar);
        }
        if (this.f138942c.i()) {
            this.f138942c.n(dVar);
        }
    }

    public void b(int i3) {
        w.d("MicroMsg.Music.MusicBasePlayEngine", "stopMusicDelayIfPaused, delay_ms:%d", Integer.valueOf(i3));
        c0.b(this.f138943d);
        c0.a(this.f138943d, i3);
    }

    public void a(boolean z16) {
        if (this.f138940a.i()) {
            this.f138940a.b(z16);
        }
        if (this.f138941b.i()) {
            this.f138941b.b(z16);
        }
        if (this.f138942c.i()) {
            this.f138942c.b(z16);
        }
    }
}
