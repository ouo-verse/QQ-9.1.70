package com.tencent.luggage.wxa.h4;

import com.tencent.luggage.wxa.e5.g;
import com.tencent.luggage.wxa.i1.a;
import com.tencent.luggage.wxa.tk.n;
import com.tencent.luggage.wxa.xd.d0;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b extends c {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a.d f126858a;

        public a(a.d dVar) {
            this.f126858a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.super.a(this.f126858a);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.h4.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC6254b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a.d f126860a;

        public RunnableC6254b(a.d dVar) {
            this.f126860a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f126860a.a(d0.class, new com.tencent.luggage.wxa.l4.c());
            this.f126860a.a(n.a.class, new com.tencent.luggage.wxa.i4.a());
        }
    }

    @Override // com.tencent.luggage.wxa.h4.c, com.tencent.luggage.wxa.j1.a, com.tencent.luggage.wxa.i1.a.c
    public void a(a.d dVar) {
        g.a("NanoSdkLuggageInitDelegate", new a(dVar));
        g.a("FullSdkLuggageInitDelegate", new RunnableC6254b(dVar));
    }
}
