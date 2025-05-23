package com.tencent.luggage.wxa.i9;

import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e implements i {

    /* renamed from: a, reason: collision with root package name */
    public h f129647a;

    /* renamed from: b, reason: collision with root package name */
    public int f129648b = 4;

    @Override // com.tencent.luggage.wxa.i9.i
    public com.tencent.luggage.wxa.c9.b a(List list) {
        if (this.f129647a == null) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioMixer", "mixAlgorithm must be init, please call init() first");
            return null;
        }
        com.tencent.luggage.wxa.c9.b b16 = com.tencent.luggage.wxa.d9.b.a().b();
        if (this.f129647a.a(b16, list)) {
            return b16;
        }
        com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioMixer", "mix audio fail");
        return null;
    }

    @Override // com.tencent.luggage.wxa.i9.i
    public void init() {
        if (this.f129647a == null) {
            this.f129647a = a();
        }
    }

    @Override // com.tencent.luggage.wxa.i9.i
    public void release() {
        h hVar = this.f129647a;
        if (hVar != null) {
            hVar.release();
        }
    }

    public h a() {
        return c.a(this.f129648b);
    }
}
