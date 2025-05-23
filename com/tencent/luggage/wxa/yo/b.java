package com.tencent.luggage.wxa.yo;

import android.os.Handler;
import android.os.Looper;

/* compiled from: P */
/* loaded from: classes9.dex */
public class b implements a {

    /* renamed from: a, reason: collision with root package name */
    public Handler f146043a;

    public b(Handler handler) {
        this.f146043a = handler;
    }

    @Override // com.tencent.luggage.wxa.yo.a
    public void a(Runnable runnable) {
        this.f146043a.post(runnable);
    }

    @Override // com.tencent.luggage.wxa.yo.a
    public void b() {
        this.f146043a.removeCallbacksAndMessages(null);
    }

    @Override // com.tencent.luggage.wxa.yo.a
    public void a(Runnable runnable, long j3) {
        this.f146043a.postDelayed(runnable, j3);
    }

    @Override // com.tencent.luggage.wxa.yo.a
    public Looper a() {
        return this.f146043a.getLooper();
    }
}
