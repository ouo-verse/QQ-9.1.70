package com.tencent.luggage.wxa.yo;

import android.os.Handler;
import android.os.Looper;

/* compiled from: P */
/* loaded from: classes9.dex */
public class g extends d {

    /* renamed from: d, reason: collision with root package name */
    public a f146057d;

    /* renamed from: e, reason: collision with root package name */
    public Looper f146058e;

    /* renamed from: f, reason: collision with root package name */
    public String f146059f;

    public g(Looper looper, a aVar, String str) {
        this.f146058e = looper;
        this.f146057d = aVar;
        this.f146059f = str;
    }

    @Override // com.tencent.luggage.wxa.yo.d
    public void a() {
        this.f146057d.b();
    }

    public Looper b() {
        return this.f146058e;
    }

    @Override // com.tencent.luggage.wxa.yo.d
    public void a(Runnable runnable) {
        this.f146057d.a(runnable);
    }

    @Override // com.tencent.luggage.wxa.yo.d
    public void a(Runnable runnable, long j3) {
        if (j3 >= 0) {
            this.f146057d.a(runnable, j3);
        } else {
            this.f146057d.a(runnable);
        }
    }

    public g(Handler handler, String str) {
        this(new b(handler), str);
    }

    public g(a aVar, String str) {
        this(aVar.a(), aVar, str);
    }

    public g(Looper looper, String str) {
        this(new Handler(looper), str);
    }
}
