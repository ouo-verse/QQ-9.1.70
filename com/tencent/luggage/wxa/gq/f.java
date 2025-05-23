package com.tencent.luggage.wxa.gq;

import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f extends b {

    /* renamed from: e, reason: collision with root package name */
    public final float f126810e;

    /* renamed from: f, reason: collision with root package name */
    public final long f126811f;

    public f(long j3, float f16, int i3, int i16) {
        super(i3, i16);
        this.f126810e = f16;
        this.f126811f = j3;
    }

    @Override // com.tencent.luggage.wxa.hq.b
    public long a(g gVar, TimeUnit timeUnit) {
        int b16 = gVar.b("incrementCount", 1);
        long j3 = ((float) this.f126811f) + (b16 * this.f126810e);
        gVar.c("incrementCount", b16 + 1);
        return timeUnit.convert(j3, TimeUnit.MILLISECONDS);
    }
}
