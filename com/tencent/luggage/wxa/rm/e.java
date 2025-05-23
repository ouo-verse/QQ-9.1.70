package com.tencent.luggage.wxa.rm;

import com.tencent.luggage.wxa.pm.b;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mobileqq.R;
import cooperation.qzone.webviewplugin.QZoneJsConstants;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e extends com.tencent.luggage.wxa.rm.a {
    private static final String F = "MicroMsg.Music.MusicPlayer";
    private static final int G = 100;
    private static final int H = 2000;
    private boolean A;
    private com.tencent.luggage.wxa.rb.c B;
    private boolean C;
    private b.InterfaceC6611b D = new b();
    public boolean E = false;

    /* renamed from: x, reason: collision with root package name */
    private com.tencent.luggage.wxa.rb.d f139868x;

    /* renamed from: y, reason: collision with root package name */
    private com.tencent.luggage.wxa.sm.b f139869y;

    /* renamed from: z, reason: collision with root package name */
    private com.tencent.luggage.wxa.pm.b f139870z;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements com.tencent.luggage.wxa.sm.f {

        /* renamed from: a, reason: collision with root package name */
        private long f139871a;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.rm.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC6692a implements Runnable {
            public RunnableC6692a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (System.currentTimeMillis() - a.this.f139871a > 10000) {
                    a.this.f139871a = System.currentTimeMillis();
                    com.tencent.luggage.wxa.y9.a.makeText(z.c(), z.c().getString(R.string.f169672iz), 0).show();
                }
            }
        }

        public a() {
        }

        @Override // com.tencent.luggage.wxa.sm.f
        public void b(com.tencent.luggage.wxa.rb.d dVar, boolean z16) {
            w.d(e.F, "setEvents, onStop");
            com.tencent.luggage.wxa.rb.d a16 = com.tencent.luggage.wxa.qm.k.f().a();
            if (a16 == null) {
                return;
            }
            if (a16.a(dVar)) {
                e.this.f();
            }
            e eVar = e.this;
            eVar.k(eVar.f139868x);
            if (z16) {
                e eVar2 = e.this;
                eVar2.b(eVar2.f139868x);
            }
        }

        @Override // com.tencent.luggage.wxa.sm.f
        public void a(com.tencent.luggage.wxa.rb.d dVar) {
            w.d(e.F, "setEvents, onStart");
            e.this.j(dVar);
        }

        @Override // com.tencent.luggage.wxa.sm.f
        public void a(com.tencent.luggage.wxa.rb.d dVar, int i3) {
            com.tencent.luggage.wxa.rb.d a16 = com.tencent.luggage.wxa.qm.k.f().a();
            if (a16 != null && a16.a(dVar) && e.this.f139869y != null && e.this.f139869y.e()) {
                int a17 = e.this.f139869y.a();
                int b16 = e.this.f139869y.b();
                if (a17 <= 0 || b16 <= 0) {
                    return;
                }
                float f16 = a17 / b16;
                if (e.this.f139870z != null) {
                    e.this.f139870z.b(f16);
                    if (e.this.f139870z != null && e.this.f139870z.c() && !e.this.f139870z.a(f16)) {
                        w.d(e.F, "download percent not enough can not play");
                        e.this.f();
                    }
                }
                e.this.a(a17, b16);
            }
        }

        @Override // com.tencent.luggage.wxa.sm.f
        public void a(com.tencent.luggage.wxa.rb.d dVar, boolean z16) {
            com.tencent.luggage.wxa.rb.d a16 = com.tencent.luggage.wxa.qm.k.f().a();
            if (a16 == null) {
                return;
            }
            w.d(e.F, "onError, needRetry:%b", Boolean.valueOf(z16));
            if (z16) {
                e.this.b(dVar, 20);
            } else {
                e.this.b(dVar, 21);
            }
            if (a16.a(dVar)) {
                w.d(e.F, "stop");
                e.this.f();
                if (z16) {
                    w.d(e.F, "retry system media player again");
                    e.this.a(a16, true);
                    e.this.f139870z = new com.tencent.luggage.wxa.pm.b(dVar, com.tencent.luggage.wxa.om.e.b(dVar.f139441c));
                    e.this.f139870z.a(e.this.D);
                    e.this.f139870z.e();
                    e.this.getClass();
                    return;
                }
                c0.a(new RunnableC6692a());
                e eVar = e.this;
                eVar.k(eVar.f139868x);
                return;
            }
            w.d(e.F, "send stop event");
            e eVar2 = e.this;
            eVar2.k(eVar2.f139868x);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements b.InterfaceC6611b {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f139875a;

            public a(int i3) {
                this.f139875a = i3;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.tencent.luggage.wxa.y9.a.makeText(z.c(), z.c().getString(R.string.f169682j0), 0).show();
                e eVar = e.this;
                eVar.b(eVar.f139868x, this.f139875a);
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.rm.e$b$b, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC6693b implements Runnable {
            public RunnableC6693b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.tencent.luggage.wxa.y9.a.makeText(z.c(), z.c().getString(R.string.f169682j0), 1).show();
            }
        }

        public b() {
        }

        @Override // com.tencent.luggage.wxa.pm.b.InterfaceC6611b
        public void a(int i3) {
            if (i3 == 1) {
                if (e.this.f139870z != null && !e.this.C && e.this.f139869y != null) {
                    e.this.f139869y.a(com.tencent.luggage.wxa.wm.b.a(e.this.f139870z.b().f139441c, e.this.f139870z.d()));
                    e.this.u();
                    return;
                }
                return;
            }
            if (i3 != -2 && i3 != 5 && i3 != 19) {
                if (i3 == -1 || i3 == 6 || i3 == 4) {
                    c0.a(new RunnableC6693b());
                    e eVar = e.this;
                    eVar.b(eVar.f139868x, i3);
                    return;
                }
                return;
            }
            c0.a(new a(i3));
        }
    }

    private void a(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        if (m(this.f139868x) && !r()) {
            w.b(F, "request focus error");
            return;
        }
        w.d(F, "startPlay");
        try {
            com.tencent.luggage.wxa.sm.b bVar = this.f139869y;
            if (bVar != null) {
                bVar.h();
            }
        } catch (Exception e16) {
            w.a(F, e16, "startPlay", new Object[0]);
        }
        this.C = true;
        this.A = false;
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public int g() {
        com.tencent.luggage.wxa.sm.b bVar = this.f139869y;
        if (bVar != null) {
            return bVar.a();
        }
        return -1;
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public int getDuration() {
        com.tencent.luggage.wxa.sm.b bVar = this.f139869y;
        if (bVar != null) {
            return bVar.b();
        }
        return -1;
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public boolean h() {
        if (this.C && this.E) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public boolean i() {
        com.tencent.luggage.wxa.sm.b bVar = this.f139869y;
        if (bVar != null) {
            try {
                return bVar.e();
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public void j() {
        w.d(F, "pauseAndAbandonFocus");
        pause();
        m();
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public boolean k() {
        return false;
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public int l() {
        com.tencent.luggage.wxa.pm.b bVar = this.f139870z;
        if (bVar != null) {
            return bVar.a();
        }
        return 0;
    }

    @Override // com.tencent.luggage.wxa.rm.a
    public void p() {
        com.tencent.luggage.wxa.k0.d.a(com.tencent.luggage.wxa.tm.b.a(com.tencent.luggage.wxa.qm.e.class));
        this.f139833o = com.tencent.luggage.wxa.qm.k.h();
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public void pause() {
        this.E = false;
        w.d(F, "pause");
        try {
            com.tencent.luggage.wxa.sm.b bVar = this.f139869y;
            if (bVar != null && bVar.e()) {
                this.f139869y.g();
                this.A = true;
                d(this.f139868x);
            }
        } catch (Exception e16) {
            w.a(F, e16, "pause", new Object[0]);
        }
    }

    public boolean t() {
        if (this.C && (this.A || this.f139829k)) {
            return true;
        }
        return false;
    }

    private void c(boolean z16) {
        try {
            com.tencent.luggage.wxa.sm.b bVar = this.f139869y;
            if (bVar != null && !bVar.e()) {
                w.d(F, "resume requestFocus:%b", Boolean.valueOf(z16));
                if (z16 && m(this.f139868x) && !r()) {
                    w.b(F, "request focus error");
                }
                this.f139869y.h();
                g(this.f139868x);
            } else {
                w.d(F, "music is playing");
            }
        } catch (Exception e16) {
            w.a(F, e16, "resume", new Object[0]);
        }
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public boolean b(int i3) {
        int duration;
        int l3;
        w.d(F, "seekToMusic pos:%d", Integer.valueOf(i3));
        try {
            duration = getDuration();
            l3 = l();
        } catch (Exception e16) {
            w.a(F, e16, "seekTo", new Object[0]);
        }
        if (duration >= 0 && i3 <= duration) {
            int i16 = (int) ((l3 / 100.0d) * duration);
            if (l3 != 100 && i3 > i16) {
                i3 = i16 - 2000;
                w.d(F, "on completed seekto, position is %d =", Integer.valueOf(i3));
            }
            com.tencent.luggage.wxa.sm.b bVar = this.f139869y;
            if (bVar != null && i3 >= 0) {
                bVar.a(i3);
                h(this.f139868x);
                return true;
            }
            return false;
        }
        w.b(F, "duration or position is illegal, stop");
        f();
        return false;
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public void e() {
        this.E = true;
        w.d(F, "passivePause");
        try {
            com.tencent.luggage.wxa.sm.b bVar = this.f139869y;
            if (bVar == null || !bVar.e()) {
                return;
            }
            this.f139869y.g();
            d(this.f139868x);
        } catch (Exception e16) {
            w.a(F, e16, "passivePause", new Object[0]);
        }
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public void f() {
        w.d(F, QZoneJsConstants.METHOD_RECORDER_STOP_PLAY);
        com.tencent.luggage.wxa.sm.b bVar = this.f139869y;
        if (bVar != null && (bVar instanceof c)) {
            a(bVar.c());
        }
        try {
            com.tencent.luggage.wxa.pm.b bVar2 = this.f139870z;
            if (bVar2 != null) {
                bVar2.f();
                this.f139870z = null;
            }
            com.tencent.luggage.wxa.sm.b bVar3 = this.f139869y;
            if (bVar3 != null) {
                bVar3.i();
                this.f139869y = null;
            }
        } catch (Exception e16) {
            w.a(F, e16, QZoneJsConstants.METHOD_RECORDER_STOP_PLAY, new Object[0]);
        }
        m();
        this.C = false;
        this.E = false;
    }

    @Override // com.tencent.luggage.wxa.rm.a, com.tencent.luggage.wxa.sm.d
    public void a(com.tencent.luggage.wxa.rb.d dVar) {
        super.a(dVar);
        w.d(F, "init and start download");
        f();
        if (dVar == null) {
            w.d(F, "music is null");
            return;
        }
        com.tencent.luggage.wxa.pm.b bVar = new com.tencent.luggage.wxa.pm.b(dVar, com.tencent.luggage.wxa.om.e.b(dVar.f139441c));
        this.f139870z = bVar;
        bVar.a(this.D);
        this.f139868x = dVar;
        a(dVar, false);
        w.d(F, "startPlay src:%s,  playUrl:%s", dVar.f139447i, dVar.T);
        this.f139870z.e();
        n();
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public boolean c() {
        return this.C;
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public com.tencent.luggage.wxa.rb.c b() {
        int i3;
        int duration = getDuration();
        int g16 = g();
        if (i()) {
            i3 = 1;
        } else {
            i3 = t() ? 0 : 2;
        }
        w.d(F, "get music status = %d", Integer.valueOf(i3));
        int l3 = l();
        if (duration <= 0) {
            l3 = 0;
        }
        com.tencent.luggage.wxa.rb.c cVar = this.B;
        if (cVar != null) {
            cVar.a(duration, g16, i3, l3);
        } else {
            this.B = new com.tencent.luggage.wxa.rb.c(duration, g16, i3, l3);
        }
        com.tencent.luggage.wxa.rb.c cVar2 = this.B;
        cVar2.f139437e = false;
        cVar2.f139438f = o();
        return this.B;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.tencent.luggage.wxa.rb.d dVar, boolean z16) {
        if (this.f139869y == null) {
            if (!z16 && com.tencent.luggage.wxa.aa.a.b(15)) {
                w.d(F, "use MMPlayer");
                this.f139869y = new c();
            } else {
                w.d(F, "use MMMediaPlayer");
                this.f139869y = new com.tencent.luggage.wxa.rm.b();
            }
            this.f139869y.a(dVar);
            this.f139869y.a(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.tencent.luggage.wxa.rb.d dVar, int i3) {
        if (dVar == null) {
            w.b(F, "currentMusic is null, don't idKeyReportMusicError");
            return;
        }
        w.d(F, "idKeyReportMusicError, action:%d", Integer.valueOf(i3));
        com.tencent.luggage.wxa.sm.b bVar = this.f139869y;
        if (bVar == null || !(bVar instanceof c)) {
            return;
        }
        ((c) bVar).k();
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public void a() {
        c(true);
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public void a(boolean z16) {
        c(z16);
    }
}
