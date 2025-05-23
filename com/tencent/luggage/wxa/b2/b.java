package com.tencent.luggage.wxa.b2;

import android.content.res.Configuration;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.mj.c;
import com.tencent.luggage.wxa.mj.i;
import com.tencent.luggage.wxa.oj.c;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b implements i, c {

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.b2.a f121826a;

    /* renamed from: b, reason: collision with root package name */
    public final v f121827b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f121826a.b();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.b2.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC6028b implements Runnable {
        public RunnableC6028b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f121826a.a();
        }
    }

    public b(v vVar) {
        this.f121826a = new com.tencent.luggage.wxa.b2.a(vVar);
        this.f121827b = vVar;
    }

    @Override // com.tencent.luggage.wxa.mj.i
    public void b() {
        this.f121827b.e(new a());
    }

    @Override // com.tencent.luggage.wxa.mj.i
    public boolean c() {
        if (this.f121826a.getCurrentState() == c.b.HIDDEN) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.mj.c
    public void onBackground() {
        this.f121826a.c();
    }

    @Override // com.tencent.luggage.wxa.mj.c
    public void onForeground() {
        this.f121826a.d();
    }

    @Override // com.tencent.luggage.wxa.mj.i
    public void a() {
        this.f121827b.e(new RunnableC6028b());
    }

    @Override // com.tencent.luggage.wxa.mj.c
    public void onDestroy() {
    }

    @Override // com.tencent.luggage.wxa.mj.c
    public void onConfigurationChanged(Configuration configuration) {
    }
}
