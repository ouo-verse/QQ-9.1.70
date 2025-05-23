package com.tencent.luggage.wxa.gq;

import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes8.dex */
public class i extends com.tencent.luggage.wxa.hq.a {

    /* renamed from: b, reason: collision with root package name */
    public volatile int f126826b;

    public i(int i3) {
        this.f126826b = i3;
    }

    @Override // com.tencent.luggage.wxa.hq.b
    public long a(g gVar, TimeUnit timeUnit) {
        return -1L;
    }

    @Override // com.tencent.luggage.wxa.hq.b
    public boolean c(g gVar) {
        if (this.f126826b >= gVar.b()) {
            return true;
        }
        return false;
    }
}
