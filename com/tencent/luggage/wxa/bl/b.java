package com.tencent.luggage.wxa.bl;

import com.tencent.luggage.wxa.fl.d;
import com.tencent.luggage.wxa.gl.e;
import com.tencent.luggage.wxa.gl.h;
import com.tencent.luggage.wxa.gl.i;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b implements d {

    /* renamed from: a, reason: collision with root package name */
    public boolean f123039a;

    @Override // com.tencent.luggage.wxa.bl.d
    public void a(a aVar, com.tencent.luggage.wxa.gl.a aVar2) {
    }

    public void b(boolean z16) {
        this.f123039a = z16;
    }

    public boolean e() {
        return this.f123039a;
    }

    @Override // com.tencent.luggage.wxa.bl.d
    public void a(a aVar, com.tencent.luggage.wxa.gl.a aVar2, h hVar) {
    }

    @Override // com.tencent.luggage.wxa.bl.d
    public i a(a aVar, com.tencent.luggage.wxa.dl.a aVar2, com.tencent.luggage.wxa.gl.a aVar3) {
        return new e();
    }

    @Override // com.tencent.luggage.wxa.bl.d
    public void a(a aVar, com.tencent.luggage.wxa.fl.d dVar) {
        com.tencent.luggage.wxa.fl.e eVar = new com.tencent.luggage.wxa.fl.e(dVar);
        eVar.a(d.a.PONG);
        aVar.a(eVar);
    }

    @Override // com.tencent.luggage.wxa.bl.d
    public void c(a aVar, com.tencent.luggage.wxa.fl.d dVar) {
    }
}
