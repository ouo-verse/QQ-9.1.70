package com.tencent.luggage.wxa.g9;

import android.text.TextUtils;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c implements n, com.tencent.luggage.wxa.j9.f {

    /* renamed from: a, reason: collision with root package name */
    public volatile com.tencent.luggage.wxa.j9.d f126621a;

    /* renamed from: b, reason: collision with root package name */
    public volatile com.tencent.luggage.wxa.l9.c f126622b;

    /* renamed from: c, reason: collision with root package name */
    public volatile com.tencent.luggage.wxa.qb.b f126623c;

    /* renamed from: d, reason: collision with root package name */
    public volatile String f126624d;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.luggage.wxa.f9.i f126625e;

    /* renamed from: g, reason: collision with root package name */
    public volatile String f126627g;

    /* renamed from: h, reason: collision with root package name */
    public volatile String f126628h;

    /* renamed from: r, reason: collision with root package name */
    public int f126638r;

    /* renamed from: f, reason: collision with root package name */
    public int f126626f = 0;

    /* renamed from: i, reason: collision with root package name */
    public AtomicBoolean f126629i = new AtomicBoolean(false);

    /* renamed from: j, reason: collision with root package name */
    public AtomicInteger f126630j = new AtomicInteger(0);

    /* renamed from: k, reason: collision with root package name */
    public AtomicBoolean f126631k = new AtomicBoolean(false);

    /* renamed from: l, reason: collision with root package name */
    public AtomicBoolean f126632l = new AtomicBoolean(false);

    /* renamed from: m, reason: collision with root package name */
    public AtomicBoolean f126633m = new AtomicBoolean(false);

    /* renamed from: n, reason: collision with root package name */
    public AtomicBoolean f126634n = new AtomicBoolean(false);

    /* renamed from: o, reason: collision with root package name */
    public AtomicBoolean f126635o = new AtomicBoolean(false);

    /* renamed from: p, reason: collision with root package name */
    public int f126636p = 0;

    /* renamed from: q, reason: collision with root package name */
    public int f126637q = 0;

    /* renamed from: s, reason: collision with root package name */
    public int f126639s = -1;

    /* renamed from: t, reason: collision with root package name */
    public Object f126640t = new Object();

    /* renamed from: u, reason: collision with root package name */
    public Object f126641u = new Object();

    public c(com.tencent.luggage.wxa.j9.d dVar, com.tencent.luggage.wxa.l9.c cVar) {
        this.f126621a = dVar;
        this.f126622b = cVar;
        this.f126623c = this.f126622b.c();
        this.f126624d = this.f126623c.f138564a;
        this.f126627g = this.f126623c.f138566c;
        this.f126638r = this.f126623c.f138567d;
        this.f126628h = this.f126623c.f138565b;
    }

    @Override // com.tencent.luggage.wxa.g9.n
    public void a(float f16, float f17) {
    }

    public void b(com.tencent.luggage.wxa.c9.e eVar) {
        int i3;
        if (this.f126629i.get() || eVar == null) {
            return;
        }
        long j3 = eVar.f123438e;
        if (j3 > 0 && (i3 = this.f126638r) > 0 && j3 < i3) {
            if (eVar.a()) {
                com.tencent.luggage.wxa.d9.d.a().a(eVar);
            }
        } else {
            if (this.f126621a == null || this.f126621a.g() == null) {
                return;
            }
            eVar.f123434a = l();
            a(eVar);
        }
    }

    @Override // com.tencent.luggage.wxa.g9.n
    public void c() {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderBase", "pauseOnBackground");
        pause();
    }

    @Override // com.tencent.luggage.wxa.g9.n
    public boolean d() {
        return this.f126631k.get();
    }

    @Override // com.tencent.luggage.wxa.g9.n
    public com.tencent.luggage.wxa.c9.d e() {
        return com.tencent.luggage.wxa.d9.f.c().b(this.f126627g);
    }

    @Override // com.tencent.luggage.wxa.g9.n
    public boolean g() {
        return this.f126632l.get();
    }

    @Override // com.tencent.luggage.wxa.g9.n
    public long getCurrentPosition() {
        return -1L;
    }

    @Override // com.tencent.luggage.wxa.j9.f
    public void h() {
        if (!this.f126634n.get() && !this.f126632l.get()) {
            this.f126634n.set(true);
            d(13);
        }
    }

    @Override // com.tencent.luggage.wxa.g9.n
    public void i() {
        boolean z16;
        if (this.f126621a.k() != null) {
            this.f126621a.k().a(b().f138572i);
        }
        this.f126627g = b().f138566c;
        if (TextUtils.isEmpty(this.f126627g)) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioDecoderBase", "source path is null");
            this.f126626f = TMAssistantDownloadErrorCode.DOWNLOAD_ERR_KNOWN_LENGTH_CHECK_ERROR;
            b(TMAssistantDownloadErrorCode.DOWNLOAD_ERR_KNOWN_LENGTH_CHECK_ERROR);
            return;
        }
        com.tencent.luggage.wxa.qb.b b16 = b();
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderBase", "decode sourcePath :%s, loop:%b", this.f126627g, Boolean.valueOf(b16.f138571h));
        if (this.f126629i.get()) {
            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderBase", "do preload audio");
            if (b16.B) {
                com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderBase", "preload begin");
                if (!com.tencent.luggage.wxa.d9.f.c().d(this.f126627g)) {
                    r();
                } else {
                    com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderBase", "audio is loaded complete!");
                }
                com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderBase", "preload end");
                d(15);
                return;
            }
            if (!p()) {
                d(3);
            }
            if (!com.tencent.luggage.wxa.d9.f.c().d(this.f126627g)) {
                r();
            } else {
                com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderBase", "audio is loaded complete!");
            }
            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderBase", "preload audio end");
            this.f126629i.set(false);
            com.tencent.luggage.wxa.c9.d e16 = e();
            if (g()) {
                com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderBase", "stopped, not to play");
                if (e16.h()) {
                    d(2);
                    return;
                }
                return;
            }
            if (n()) {
                com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderBase", "occurs error, not to play");
                return;
            } else if (!p() && !b16.f138570g) {
                com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderBase", "not to play");
                d(2);
                return;
            } else {
                com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderBase", "to play");
                d(2);
            }
        }
        d(4);
        do {
            if (!com.tencent.luggage.wxa.d9.f.c().d(this.f126627g)) {
                r();
            } else {
                v();
            }
            if (b16.f138571h && !g()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderBase", "loop again for audioId:%s", l());
                try {
                    LockMethodProxy.sleep(20L);
                } catch (Exception unused) {
                    com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioDecoderBase", "sleep exception");
                }
                this.f126638r = 0;
            }
        } while (z16);
        if (!g() && !n()) {
            if (!o()) {
                com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderBase", "not mix end, not set to play complete!");
                this.f126621a.g().b(l(), true);
            } else {
                d(7);
                this.f126621a.g().k(l());
            }
        } else {
            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderBase", "is stop or error, not set to play complete!");
            if (this.f126622b.equals(b().f138566c)) {
                this.f126621a.g().k(l());
                com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderBase", "removeAudio");
            } else {
                com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderBase", "change src only, don't removeAudio");
            }
        }
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderBase", "task end");
    }

    @Override // com.tencent.luggage.wxa.g9.n
    public void init() {
        this.f126638r = this.f126622b.c().f138568e;
        this.f126631k.set(false);
        this.f126632l.set(false);
        if (this.f126622b != null) {
            this.f126622b.a();
        }
        d(1);
    }

    @Override // com.tencent.luggage.wxa.g9.n
    public void j() {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderBase", "preload");
        this.f126629i.set(true);
        d(10);
    }

    @Override // com.tencent.luggage.wxa.g9.n
    public boolean k() {
        if (this.f126630j.get() != 8 && this.f126630j.get() != 7) {
            return false;
        }
        return true;
    }

    public String l() {
        com.tencent.luggage.wxa.qb.b b16 = b();
        if (b16 == null) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioDecoderBase", "param is null");
            return this.f126624d;
        }
        return b16.f138564a;
    }

    public String m() {
        return this.f126628h;
    }

    public boolean n() {
        if (this.f126630j.get() == 9) {
            return true;
        }
        return false;
    }

    public boolean o() {
        return this.f126621a.g().d(l());
    }

    public boolean p() {
        if (this.f126630j.get() == 4) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.g9.n
    public void pause() {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderBase", "pause");
        d(5);
        this.f126631k.set(true);
        this.f126634n.set(false);
    }

    public void q() {
        synchronized (this.f126641u) {
            try {
                this.f126641u.notify();
            } catch (Exception e16) {
                com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioDecoderBase", e16, "notifyDecode", new Object[0]);
            }
        }
    }

    public abstract void r();

    @Override // com.tencent.luggage.wxa.g9.n
    public void release() {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderBase", "release");
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderBase", "duration:%d", Long.valueOf(e().f()));
        s();
        f();
        if (this.f126622b != null) {
            this.f126622b.c().f138567d = 0;
            this.f126622b.disconnect();
        }
        this.f126629i.set(false);
        this.f126632l.set(true);
        this.f126631k.set(false);
        this.f126633m.set(false);
        this.f126621a = null;
    }

    public void s() {
        this.f126621a.g().l(l());
    }

    @Override // com.tencent.luggage.wxa.g9.n
    public void stop() {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderBase", "stop");
        a(0.0f, 0.0f);
        d(6);
        this.f126632l.set(true);
        this.f126631k.set(false);
        q();
        this.f126634n.set(false);
        this.f126635o.set(false);
    }

    public void v() {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderBase", "readCacheAndPlay");
        com.tencent.luggage.wxa.c9.d e16 = e();
        if (e16 == null) {
            return;
        }
        u();
        int m3 = e16.m();
        int i3 = 0;
        while (i3 < m3 && !g()) {
            w();
            synchronized (this.f126640t) {
                int i16 = this.f126639s;
                if (i16 >= 0 && i16 < m3) {
                    this.f126639s = -1;
                    com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderBase", "seek to pos:%s", Integer.valueOf(i16));
                    i3 = i16;
                }
            }
            com.tencent.luggage.wxa.c9.e a16 = e16.a(i3);
            if (a16 != null) {
                b(a16);
            }
            i3++;
        }
        t();
    }

    public void w() {
        synchronized (this.f126641u) {
            while (!g() && d()) {
                try {
                    com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderBase", "waitDecode");
                    LockMethodProxy.wait(this.f126641u);
                } catch (Exception e16) {
                    com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioDecoderBase", e16, "waitDecode", new Object[0]);
                }
            }
        }
    }

    @Override // com.tencent.luggage.wxa.g9.n
    public void a() {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderBase", "resume");
        d(4);
        synchronized (this.f126641u) {
            if (d()) {
                this.f126631k.set(false);
                try {
                    this.f126641u.notify();
                } catch (Exception e16) {
                    com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioDecoderBase", e16, "resume", new Object[0]);
                }
            }
        }
    }

    public void d(int i3) {
        a(i3, 0, "");
    }

    public void e(int i3) {
        if (i3 < 20 && this.f126633m.get() && !d() && !g()) {
            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderBase", "unLockWrite, queueSize:%d", Integer.valueOf(i3));
            q();
        }
    }

    public void c(int i3) {
        if (i3 < 50) {
            this.f126633m.set(false);
            return;
        }
        com.tencent.luggage.wxa.c9.d e16 = e();
        b();
        if (e16 != null && e16.h()) {
            this.f126633m.set(true);
            synchronized (this.f126641u) {
                try {
                    com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderBase", "lockWriteBuffer, writeSize:%d", Integer.valueOf(i3));
                    LockMethodProxy.wait(this.f126641u);
                } catch (Exception e17) {
                    com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioDecoderBase", e17, "lockWriteBuffer", new Object[0]);
                }
            }
            return;
        }
        this.f126633m.set(false);
    }

    @Override // com.tencent.luggage.wxa.j9.f
    public void b(int i3) {
        com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioDecoderBase", "onError, errType:%d", Integer.valueOf(i3));
        this.f126626f = i3;
        this.f126632l.set(true);
        a(9, i3, "");
    }

    @Override // com.tencent.luggage.wxa.g9.n
    public void a(int i3) {
        int i16 = this.f126638r;
        synchronized (this.f126640t) {
            this.f126638r = i3;
            this.f126639s = i3 / 20;
            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderBase", "seek preStartTime:%d, seek position:%d", Integer.valueOf(i16), Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.luggage.wxa.g9.n
    public com.tencent.luggage.wxa.qb.b b() {
        if (this.f126622b != null) {
            return this.f126622b.c();
        }
        return this.f126623c;
    }

    public void a(boolean z16) {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderBase", "onError needTry:%b", Boolean.valueOf(z16));
        this.f126632l.set(true);
        d(9);
        com.tencent.luggage.wxa.c9.d e16 = e();
        if (e16 == null || e16.h()) {
            return;
        }
        e16.k();
    }

    public void a(com.tencent.luggage.wxa.c9.d dVar) {
        if (this.f126625e == null) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioDecoderBase", "process is null");
            return;
        }
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderBase", "writeCacheAndPlay");
        u();
        while (true) {
            if (!g()) {
                w();
                com.tencent.luggage.wxa.c9.e a16 = this.f126625e.a(3536);
                if (dVar.m() > 0 && a16 == null) {
                    dVar.c();
                    break;
                }
                if (dVar.m() == 0 && a16 == null) {
                    dVar.l();
                    break;
                } else {
                    if (a16 == null) {
                        break;
                    }
                    if (!dVar.h()) {
                        dVar.b(a16);
                    }
                    b(a16);
                }
            } else {
                break;
            }
        }
        t();
    }

    public void t() {
    }

    public void u() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x004d, code lost:
    
        if (r8 == 15) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x005b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i3, int i16, String str) {
        int i17;
        String l3;
        if (this.f126621a == null) {
            return;
        }
        this.f126630j.set(i3);
        if (i3 != 0 && i3 != 1) {
            i17 = 9;
            int i18 = 3;
            if (i3 != 3) {
                int i19 = 7;
                int i26 = 2;
                if (i3 != 2) {
                    if (i3 == 4) {
                        i17 = 0;
                    } else {
                        if (i3 != 5) {
                            i26 = 6;
                            if (i3 != 6) {
                                if (i3 == 7) {
                                    i17 = 5;
                                } else if (i3 == 9) {
                                    i17 = 4;
                                } else {
                                    i17 = 11;
                                    if (i3 != 11) {
                                        i18 = 12;
                                        if (i3 == 12) {
                                            i17 = 10;
                                        } else {
                                            i19 = 13;
                                            if (i3 != 13) {
                                                if (i3 != 14) {
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            i17 = i18;
                        }
                        i17 = i26;
                    }
                }
                i17 = i19;
            }
            l3 = l();
            if (TextUtils.isEmpty(l3)) {
                com.tencent.luggage.wxa.j9.d dVar = this.f126621a;
                if (i17 == -1) {
                    return;
                }
                if (dVar != null && i17 == 4) {
                    dVar.a(i17, l3, i16, str);
                    return;
                } else {
                    if (dVar != null) {
                        dVar.a(i17, l3, m());
                        return;
                    }
                    return;
                }
            }
            return;
        }
        i17 = -1;
        l3 = l();
        if (TextUtils.isEmpty(l3)) {
        }
    }

    public void a(com.tencent.luggage.wxa.c9.e eVar) {
        if (this.f126622b.c().f138589z) {
            if (!this.f126635o.get()) {
                this.f126635o.set(true);
                d(14);
            }
            c(this.f126621a.g().a(l(), eVar, this));
        }
    }
}
