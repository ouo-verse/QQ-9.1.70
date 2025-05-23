package com.tencent.luggage.wxa.g9;

import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f extends e {
    public com.tencent.luggage.wxa.k9.a K;
    public Object L;

    public f(com.tencent.luggage.wxa.j9.d dVar, com.tencent.luggage.wxa.l9.c cVar) {
        super(dVar, cVar);
        this.L = new Object();
    }

    public final void A() {
        do {
            boolean z16 = this.f126631k.get();
            w();
            if (!this.f126632l.get()) {
                if (z16) {
                    com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "need resume if not stop");
                    this.K.g();
                }
                if (this.f126632l.get()) {
                    return;
                }
            } else {
                return;
            }
        } while (this.f126631k.get());
    }

    public void B() {
        com.tencent.luggage.wxa.k9.a aVar = this.K;
        if (aVar != null) {
            aVar.c();
            if (this.K instanceof com.tencent.luggage.wxa.k9.b) {
                A();
            }
        }
    }

    public void C() {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "releasePlayComponent");
        synchronized (this.L) {
            com.tencent.luggage.wxa.k9.a aVar = this.K;
            if (aVar != null) {
                aVar.d();
                this.K = null;
            }
        }
    }

    public void D() {
        synchronized (this.L) {
            com.tencent.luggage.wxa.k9.a aVar = this.K;
            if (aVar != null) {
                aVar.f();
            }
        }
    }

    @Override // com.tencent.luggage.wxa.g9.c, com.tencent.luggage.wxa.g9.n
    public void a(int i3) {
        super.a(i3);
        synchronized (this.L) {
            com.tencent.luggage.wxa.k9.a aVar = this.K;
            if (aVar != null) {
                aVar.a(i3);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.g9.c, com.tencent.luggage.wxa.g9.n
    public void c() {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "pauseOnBackground");
        d(5);
        this.f126632l.set(true);
        this.f126634n.set(false);
        q();
    }

    @Override // com.tencent.luggage.wxa.g9.e, com.tencent.luggage.wxa.g9.n
    public void f() {
        super.f();
        C();
    }

    @Override // com.tencent.luggage.wxa.g9.c, com.tencent.luggage.wxa.g9.n
    public long getCurrentPosition() {
        synchronized (this.L) {
            com.tencent.luggage.wxa.k9.a aVar = this.K;
            if (aVar != null) {
                return aVar.a();
            }
            return -1L;
        }
    }

    @Override // com.tencent.luggage.wxa.g9.c, com.tencent.luggage.wxa.g9.n
    public void pause() {
        super.pause();
        synchronized (this.L) {
            com.tencent.luggage.wxa.k9.a aVar = this.K;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    @Override // com.tencent.luggage.wxa.g9.c
    public void t() {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "playAfter");
        super.t();
        B();
    }

    @Override // com.tencent.luggage.wxa.g9.c
    public void u() {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "playBefore");
        super.u();
        D();
    }

    @Override // com.tencent.luggage.wxa.g9.c
    public void a(com.tencent.luggage.wxa.c9.e eVar) {
        if (e().i()) {
            this.f126636p = 44100;
            this.f126637q = 2;
        } else {
            this.f126636p = eVar.f123435b;
            this.f126637q = eVar.f123436c;
        }
        a(eVar.f123439f);
        if (eVar.a()) {
            com.tencent.luggage.wxa.d9.d.a().a(eVar);
        }
    }

    @Override // com.tencent.luggage.wxa.g9.e
    public void c(com.tencent.luggage.wxa.c9.d dVar) {
        com.tencent.luggage.wxa.f9.i iVar = this.f126625e;
        if (iVar != null) {
            iVar.b();
        }
        b(dVar);
        dVar.c();
    }

    @Override // com.tencent.luggage.wxa.g9.e
    public void a(com.tencent.luggage.wxa.c9.d dVar, ByteBuffer byteBuffer, int i3) {
        b(dVar, byteBuffer, i3);
    }

    public void a(byte[] bArr) {
        if (this.f126629i.get()) {
            return;
        }
        if (this.K == null) {
            com.tencent.luggage.wxa.c9.d e16 = e();
            if (e16.h() && e16.f() <= 2000) {
                this.K = new com.tencent.luggage.wxa.k9.b(this.f126636p, this.f126637q, e16, this);
            } else {
                this.K = new com.tencent.luggage.wxa.k9.c(this.f126636p, this.f126637q, e16, this);
            }
            this.K.a(this.f126623c.f138576m);
            this.K.a((float) this.f126623c.f138575l, (float) this.f126623c.f138575l);
        }
        com.tencent.luggage.wxa.k9.a aVar = this.K;
        if (aVar != null) {
            aVar.a(bArr);
        }
    }

    @Override // com.tencent.luggage.wxa.g9.c
    public void s() {
    }

    @Override // com.tencent.luggage.wxa.g9.c, com.tencent.luggage.wxa.g9.n
    public void a(float f16, float f17) {
        synchronized (this.L) {
            com.tencent.luggage.wxa.k9.a aVar = this.K;
            if (aVar != null) {
                aVar.a(f16, f17);
            }
        }
    }
}
