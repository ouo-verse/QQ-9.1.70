package com.tencent.luggage.wxa.lm;

import android.os.Looper;
import com.tencent.luggage.wxa.p9.c;
import com.tencent.luggage.wxa.sm.d;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class j implements com.tencent.luggage.wxa.sm.d, k {

    /* renamed from: n, reason: collision with root package name */
    private static final String f133669n = "MicroMsg.Audio.BaseAudioPlayer";

    /* renamed from: k, reason: collision with root package name */
    protected boolean f133670k;

    /* renamed from: l, reason: collision with root package name */
    protected f f133671l = null;

    /* renamed from: m, reason: collision with root package name */
    protected d.a f133672m;

    public abstract void A();

    public abstract void B();

    @Override // com.tencent.luggage.wxa.sm.d
    public void a(com.tencent.luggage.wxa.rb.d dVar) {
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public com.tencent.luggage.wxa.rb.c b() {
        return null;
    }

    public void c(int i3) {
        w.d(f133669n, "onErrorEvent with errCode:%d", Integer.valueOf(i3));
        com.tencent.luggage.wxa.p9.c cVar = new com.tencent.luggage.wxa.p9.c();
        c.a aVar = cVar.f137441d;
        aVar.f137442a = 4;
        aVar.f137445d = "error";
        aVar.f137447f = com.tencent.luggage.wxa.sm.e.b(i3);
        cVar.f137441d.f137448g = com.tencent.luggage.wxa.sm.e.a(i3);
        cVar.f137441d.f137444c = n();
        cVar.f137441d.f137446e = m();
        cVar.a(Looper.getMainLooper());
        f fVar = this.f133671l;
        if (fVar != null) {
            fVar.e(n());
        }
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public boolean h() {
        return false;
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public boolean k() {
        return false;
    }

    public abstract String m();

    public abstract String n();

    public abstract com.tencent.luggage.wxa.qb.d o();

    public abstract boolean p();

    public void q() {
        w.d(f133669n, "onCompleteEvent");
        com.tencent.luggage.wxa.p9.c cVar = new com.tencent.luggage.wxa.p9.c();
        c.a aVar = cVar.f137441d;
        aVar.f137442a = 5;
        aVar.f137445d = "ended";
        aVar.f137444c = n();
        cVar.f137441d.f137446e = m();
        cVar.a(Looper.getMainLooper());
        f fVar = this.f133671l;
        if (fVar != null) {
            fVar.c(n());
        }
    }

    public void r() {
        w.d(f133669n, "onErrorEvent");
        c(-1);
    }

    public void s() {
        w.d(f133669n, "onPauseEvent");
        com.tencent.luggage.wxa.p9.c cVar = new com.tencent.luggage.wxa.p9.c();
        c.a aVar = cVar.f137441d;
        aVar.f137442a = 2;
        aVar.f137445d = "pause";
        aVar.f137444c = n();
        cVar.f137441d.f137446e = m();
        cVar.a(Looper.getMainLooper());
        f fVar = this.f133671l;
        if (fVar != null) {
            fVar.d(n());
        }
    }

    public void t() {
        w.d(f133669n, "onPrepareEvent");
        com.tencent.luggage.wxa.p9.c cVar = new com.tencent.luggage.wxa.p9.c();
        c.a aVar = cVar.f137441d;
        aVar.f137442a = 7;
        aVar.f137445d = "canplay";
        aVar.f137443b = getDuration();
        cVar.f137441d.f137444c = n();
        cVar.f137441d.f137446e = m();
        if (!i.o().t(n())) {
            cVar.a(Looper.getMainLooper());
        } else {
            w.d(f133669n, "removeSendPreparedEvent audioId:%s", n());
            i.o().B(n());
        }
    }

    public void u() {
        w.d(f133669n, "onPreparintEvent");
        com.tencent.luggage.wxa.p9.c cVar = new com.tencent.luggage.wxa.p9.c();
        c.a aVar = cVar.f137441d;
        aVar.f137442a = 9;
        aVar.f137445d = "waiting";
        aVar.f137444c = n();
        cVar.f137441d.f137446e = m();
        cVar.a(Looper.getMainLooper());
    }

    public void v() {
        w.d(f133669n, "onResumeEvent");
        com.tencent.luggage.wxa.p9.c cVar = new com.tencent.luggage.wxa.p9.c();
        c.a aVar = cVar.f137441d;
        aVar.f137442a = 1;
        aVar.f137445d = "play";
        aVar.f137444c = n();
        cVar.f137441d.f137446e = m();
        cVar.a(Looper.getMainLooper());
        f fVar = this.f133671l;
        if (fVar != null) {
            fVar.a(n());
        }
    }

    public void w() {
        w.d(f133669n, "onSeekToEvent");
        com.tencent.luggage.wxa.p9.c cVar = new com.tencent.luggage.wxa.p9.c();
        c.a aVar = cVar.f137441d;
        aVar.f137442a = 6;
        aVar.f137445d = "seeked";
        aVar.f137444c = n();
        cVar.f137441d.f137446e = m();
        cVar.a(Looper.getMainLooper());
    }

    public void x() {
        w.d(f133669n, "onSeekingEvent");
        com.tencent.luggage.wxa.p9.c cVar = new com.tencent.luggage.wxa.p9.c();
        c.a aVar = cVar.f137441d;
        aVar.f137442a = 10;
        aVar.f137445d = "seeking";
        aVar.f137444c = n();
        cVar.f137441d.f137446e = m();
        cVar.a(Looper.getMainLooper());
    }

    public void y() {
        w.d(f133669n, "onStartEvent %b", Boolean.valueOf(i()));
        com.tencent.luggage.wxa.p9.c cVar = new com.tencent.luggage.wxa.p9.c();
        c.a aVar = cVar.f137441d;
        aVar.f137442a = 0;
        aVar.f137445d = "play";
        aVar.f137444c = n();
        cVar.f137441d.f137446e = m();
        cVar.a(Looper.getMainLooper());
        f fVar = this.f133671l;
        if (fVar != null) {
            fVar.a(n());
        }
    }

    public void z() {
        w.d(f133669n, "onStopEvent");
        com.tencent.luggage.wxa.p9.c cVar = new com.tencent.luggage.wxa.p9.c();
        c.a aVar = cVar.f137441d;
        aVar.f137442a = 3;
        aVar.f137445d = "stop";
        aVar.f137444c = n();
        cVar.f137441d.f137446e = m();
        cVar.a(Looper.getMainLooper());
        f fVar = this.f133671l;
        if (fVar != null) {
            fVar.b(n());
        }
    }

    @Override // com.tencent.luggage.wxa.lm.k
    public void a(int i3) {
        if (i3 != 0) {
            if ((i3 == 1 || i3 == 2) && i()) {
                this.f133670k = true;
                pause();
                return;
            }
            return;
        }
        if (this.f133670k) {
            this.f133670k = false;
            a();
        }
    }

    public void a(f fVar) {
        this.f133671l = fVar;
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public void c(d.a aVar) {
        this.f133672m = aVar;
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public void e() {
    }
}
