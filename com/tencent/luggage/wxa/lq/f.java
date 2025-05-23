package com.tencent.luggage.wxa.lq;

import com.tencent.luggage.wxa.zp.h;
import java.util.concurrent.Future;

/* compiled from: P */
/* loaded from: classes8.dex */
public enum f implements a {
    INSTANCE;

    @Override // com.tencent.luggage.wxa.lq.a
    public Future a(Runnable runnable) {
        return h.f146825d.a(runnable);
    }

    @Override // com.tencent.luggage.wxa.lq.a
    public Future execute(Runnable runnable) {
        return h.f146825d.execute(runnable);
    }

    @Override // com.tencent.luggage.wxa.lq.a
    public Future a(Runnable runnable, long j3) {
        return h.f146825d.a(runnable, j3);
    }
}
