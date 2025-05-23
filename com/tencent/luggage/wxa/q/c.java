package com.tencent.luggage.wxa.q;

import com.tencent.luggage.wxa.q.l;
import java.io.EOFException;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c implements l {
    @Override // com.tencent.luggage.wxa.q.l
    public void a(long j3, int i3, int i16, int i17, l.a aVar) {
    }

    @Override // com.tencent.luggage.wxa.q.l
    public void a(com.tencent.luggage.wxa.m.j jVar) {
    }

    @Override // com.tencent.luggage.wxa.q.l
    public int a(e eVar, int i3, boolean z16) {
        int b16 = eVar.b(i3);
        if (b16 != -1) {
            return b16;
        }
        if (z16) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // com.tencent.luggage.wxa.q.l
    public void a(com.tencent.luggage.wxa.n0.l lVar, int i3) {
        lVar.f(i3);
    }
}
