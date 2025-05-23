package com.tencent.luggage.wxa.g9;

import com.tencent.mm.audio.mix.decode.IDecodeCallback;
import com.tencent.mm.audio.mix.jni.AudioFFmpegDecodeJni;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d extends c {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements IDecodeCallback {
        public a() {
        }
    }

    public d(com.tencent.luggage.wxa.j9.d dVar, com.tencent.luggage.wxa.l9.c cVar) {
        super(dVar, cVar);
    }

    @Override // com.tencent.luggage.wxa.g9.n
    public void f() {
        com.tencent.luggage.wxa.f9.i iVar = this.f126625e;
        if (iVar != null) {
            iVar.release();
            this.f126625e = null;
        }
    }

    @Override // com.tencent.luggage.wxa.g9.c
    public void r() {
        com.tencent.luggage.wxa.c9.d e16 = e();
        e16.l();
        this.f126625e = new com.tencent.luggage.wxa.f9.f(e16, 44100, 2, 2, this.f126627g);
        if (AudioFFmpegDecodeJni.decode(44100, 2, 2, this.f126627g, new a()) != 0) {
            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderFFmpeg", "decode fail");
            return;
        }
        this.f126625e.a();
        e16.c();
        if (g()) {
            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderFFmpeg", "flushCache");
            this.f126625e.a();
        } else if (d()) {
            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderFFmpeg", "flushCache and readCacheAndPlay");
            this.f126625e.a();
            v();
        } else {
            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderFFmpeg", "writeCacheAndPlay");
            a(e16);
        }
    }
}
