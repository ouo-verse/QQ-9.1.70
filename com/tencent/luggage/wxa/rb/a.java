package com.tencent.luggage.wxa.rb;

import com.tencent.luggage.wxa.p9.g;
import com.tencent.luggage.wxa.tn.c0;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.rb.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC6681a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            g gVar = new g();
            gVar.f137457d.f137459a = 1;
            gVar.c();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            g gVar = new g();
            gVar.f137457d.f137459a = 2;
            gVar.c();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            g gVar = new g();
            gVar.f137457d.f137459a = -1;
            gVar.c();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.rb.d f139432a;

        public d(com.tencent.luggage.wxa.rb.d dVar) {
            this.f139432a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = new g();
            g.a aVar = gVar.f137457d;
            aVar.f137459a = 0;
            aVar.f137460b = this.f139432a;
            gVar.c();
        }
    }

    public static void a(com.tencent.luggage.wxa.rb.d dVar) {
        c0.a(new d(dVar));
    }

    public static com.tencent.luggage.wxa.rb.d b() {
        g gVar = new g();
        gVar.f137457d.f137459a = -2;
        gVar.c();
        return gVar.f137458e.f137465a;
    }

    public static boolean c() {
        g gVar = new g();
        gVar.f137457d.f137459a = -3;
        gVar.c();
        return gVar.f137458e.f137466b;
    }

    public static boolean d() {
        g gVar = new g();
        gVar.f137457d.f137459a = 9;
        gVar.c();
        return gVar.f137458e.f137466b;
    }

    public static final void e() {
        c0.a(new RunnableC6681a());
    }

    public static final void f() {
        c0.a(new b());
    }

    public static final void g() {
        c0.a(new c());
    }

    public static boolean a(int i3) {
        g gVar = new g();
        g.a aVar = gVar.f137457d;
        aVar.f137459a = 7;
        aVar.f137464f = i3;
        gVar.c();
        return gVar.f137458e.f137466b;
    }

    public static void b(com.tencent.luggage.wxa.rb.d dVar) {
        g gVar = new g();
        g.a aVar = gVar.f137457d;
        aVar.f137459a = 16;
        aVar.f137460b = dVar;
        gVar.c();
    }

    public static com.tencent.luggage.wxa.rb.c a() {
        g gVar = new g();
        gVar.f137457d.f137459a = 8;
        gVar.c();
        return gVar.f137458e.f137467c;
    }
}
