package com.tencent.luggage.wxa.gq;

import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends b {

    /* renamed from: e, reason: collision with root package name */
    public long f126809e;

    public c(long j3, int i3, int i16) {
        super(i3, i16);
        this.f126809e = j3;
    }

    @Override // com.tencent.luggage.wxa.hq.b
    public long a(g gVar, TimeUnit timeUnit) {
        return timeUnit.convert(this.f126809e, TimeUnit.MILLISECONDS);
    }
}
