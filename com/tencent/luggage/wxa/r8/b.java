package com.tencent.luggage.wxa.r8;

import com.tencent.luggage.wxa.w8.f;
import java.util.concurrent.Callable;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b implements a {

    /* renamed from: a, reason: collision with root package name */
    public a f139417a;

    public b(long j3, a aVar) {
        this.f139417a = aVar;
    }

    public void a(Runnable runnable) {
        a(runnable, false);
    }

    public void b(Runnable runnable) {
        if (this.f139417a.g()) {
            runnable.run();
        } else {
            this.f139417a.a(runnable, false);
        }
    }

    @Override // com.tencent.luggage.wxa.r8.a
    public boolean c() {
        return this.f139417a.c();
    }

    @Override // com.tencent.luggage.wxa.r8.a
    public String d() {
        return this.f139417a.d();
    }

    @Override // com.tencent.luggage.wxa.r8.a
    public boolean g() {
        return this.f139417a.g();
    }

    @Override // com.tencent.luggage.wxa.r8.a
    public void a(Runnable runnable, boolean z16) {
        if (this.f139417a.g()) {
            runnable.run();
        } else {
            this.f139417a.a(runnable, z16);
        }
    }

    @Override // com.tencent.luggage.wxa.r8.a
    public void b() {
        this.f139417a.b();
    }

    public Object a(Callable callable) {
        f fVar = new f(callable);
        b(fVar);
        return fVar.a();
    }
}
