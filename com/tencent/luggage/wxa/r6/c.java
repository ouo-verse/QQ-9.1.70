package com.tencent.luggage.wxa.r6;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.luggage.wxa.o8.b;
import com.tencent.luggage.wxa.r6.i;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.u1.h;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public Handler f139275a;

    /* renamed from: b, reason: collision with root package name */
    public HandlerThread f139276b;

    /* renamed from: c, reason: collision with root package name */
    public final d f139277c;

    /* renamed from: d, reason: collision with root package name */
    public final RunnableC6678c f139278d;

    /* renamed from: e, reason: collision with root package name */
    public Map f139279e;

    /* renamed from: h, reason: collision with root package name */
    public g f139282h;

    /* renamed from: i, reason: collision with root package name */
    public int f139283i;

    /* renamed from: k, reason: collision with root package name */
    public com.tencent.luggage.wxa.qj.f f139285k;

    /* renamed from: f, reason: collision with root package name */
    public volatile int f139280f = 0;

    /* renamed from: g, reason: collision with root package name */
    public volatile String f139281g = "";

    /* renamed from: j, reason: collision with root package name */
    public boolean f139284j = true;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum b {
        Light,
        Full,
        NewLight,
        NewFull
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.r6.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC6678c implements Runnable {
        public RunnableC6678c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f139282h == null) {
                return;
            }
            if (c.this.f139284j) {
                w.d("AppBrandRuntimeQualityEventInspector", "NewCollectionTask:" + c.this.f139282h.f124304b);
                c.this.a();
            }
            c.this.f139275a.postDelayed(c.this.f139278d, 1000L);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public long f139292a;

        public d() {
            this.f139292a = 0L;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f139282h == null) {
                return;
            }
            if (c.this.f139284j) {
                c.this.c();
            }
            if (c.this.f139279e != null) {
                c.this.f139279e.clear();
            }
            c.this.f139275a.postDelayed(c.this.f139277c, this.f139292a);
        }
    }

    public c() {
        this.f139277c = new d();
        this.f139278d = new RunnableC6678c();
    }

    public void a(g gVar, int i3, b bVar) {
        if (this.f139282h == null) {
            this.f139282h = gVar;
        }
        if (this.f139275a == null) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("new-report-thread");
            this.f139276b = baseHandlerThread;
            baseHandlerThread.start();
            this.f139275a = new Handler(this.f139276b.getLooper());
        }
        this.f139283i = i3;
        this.f139277c.f139292a = i3 * 1000;
        Handler handler = this.f139275a;
        d dVar = this.f139277c;
        handler.postDelayed(dVar, dVar.f139292a);
        this.f139279e = new HashMap();
        this.f139275a.post(this.f139278d);
    }

    public int b() {
        com.tencent.luggage.wxa.qj.f fVar = this.f139285k;
        if (fVar == null) {
            return 0;
        }
        return fVar.a();
    }

    public final synchronized void c() {
        if (this.f139282h == null) {
            return;
        }
        w.d("AppBrandRuntimeQualityEventInspector", "newReport");
        new com.tencent.luggage.wxa.r6.d().a(this.f139282h, this.f139279e);
        w.d("AppBrandRuntimeQualityEventInspector", "newReport finish");
    }

    public void d() {
        this.f139284j = false;
    }

    public void e() {
        this.f139284j = true;
    }

    public static i a(g gVar, b bVar) {
        if (gVar == null) {
            return null;
        }
        com.tencent.luggage.wxa.c5.e eVar = gVar.f139355m;
        i.b bVar2 = new i.b();
        if (bVar == b.Full) {
            h.b b16 = com.tencent.luggage.wxa.u1.h.INST.b();
            bVar2.l(b16.f142077a);
            bVar2.m(b16.f142077a - gVar.c());
            bVar2.n(b16.f142078b);
            bVar2.d(b16.f142079c);
            bVar2.c(0);
            bVar2.j(b16.f142080d);
        } else {
            bVar2.l(-1);
            bVar2.m(-1);
            bVar2.n(-1);
            bVar2.d(-1);
            bVar2.c(-1);
            bVar2.j(-1);
        }
        bVar2.o(a(eVar));
        bVar2.p((int) (System.currentTimeMillis() - gVar.d()));
        if (gVar.f()) {
            a(bVar2, gVar);
        } else {
            bVar2.f(gVar.a().b());
        }
        return bVar2.a();
    }

    public static int a(com.tencent.luggage.wxa.ic.g gVar) {
        try {
            return gVar.e0().a();
        } catch (Exception unused) {
            return 0;
        }
    }

    public static void a(i.b bVar, g gVar) {
        com.tencent.magicbrush.b bVar2;
        com.tencent.luggage.wxa.c5.e eVar = gVar.f139355m;
        try {
            bVar2 = ((com.tencent.luggage.wxa.w1.b) ((com.tencent.luggage.wxa.r4.d) eVar.h0()).h(com.tencent.luggage.wxa.w1.b.class)).n();
        } catch (Exception e16) {
            w.a("AppBrandRuntimeQualityEventInspector", e16, "get QualityEvent of WAGame but fail. [%s]", eVar);
            bVar2 = null;
        }
        if (bVar2 == null) {
            w.b("AppBrandRuntimeQualityEventInspector", "buildWAGameQualityEvent find renderer.fps == null");
            return;
        }
        com.tencent.luggage.wxa.o8.a d16 = bVar2.g().d();
        bVar.f(Math.round(d16.f136199a));
        bVar.g(Math.round(d16.f136200b));
        bVar.a(bVar2.g().e());
        bVar.e(bVar2.g().f());
        bVar.t(bVar2.g().i());
        bVar.r(bVar2.g().h());
        bVar.a(gVar.e().f139356a);
        bVar.s(1);
        bVar.b(1);
        b.C6537b c16 = bVar2.g().c();
        bVar.h(c16.f136222a);
        bVar.i(c16.f136223b);
        bVar.k(c16.f136224c);
        bVar.a(c16.f136225d);
        bVar.q(Math.round(c16.f136226e * 10000.0f));
    }

    public final void a() {
        w.a("AppBrandRuntimeQualityEventInspector", "collectRuntimeQualityEvent build");
        i a16 = a(this.f139282h, b.Light);
        w.a("AppBrandRuntimeQualityEventInspector", "collectRuntimeQualityEvent addNewReportData");
        a(this.f139282h, a16);
        w.a("AppBrandRuntimeQualityEventInspector", String.valueOf(a16));
        if (this.f139279e.containsKey(Integer.valueOf(this.f139280f))) {
            if (this.f139279e.get(Integer.valueOf(this.f139280f)) != null) {
                w.a("AppBrandRuntimeQualityEventInspector", "add event to newReportMap scene");
                ((List) this.f139279e.get(Integer.valueOf(this.f139280f))).add(a16);
                return;
            }
            return;
        }
        if (this.f139279e.size() < 6) {
            w.a("AppBrandRuntimeQualityEventInspector", "add scene to newReportMap");
            this.f139279e.put(Integer.valueOf(this.f139280f), new ArrayList());
            ((List) this.f139279e.get(Integer.valueOf(this.f139280f))).add(a16);
        }
    }

    public final void a(g gVar, i iVar) {
        if (gVar != null && iVar != null) {
            iVar.b(gVar.f124303a);
            iVar.n(0);
            iVar.p(this.f139280f);
            iVar.j(0);
            iVar.e(0);
            iVar.f(0);
            iVar.a(this.f139281g);
            return;
        }
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(gVar == null);
        objArr[1] = Boolean.valueOf(iVar == null);
        w.d("AppBrandRuntimeQualityEventInspector", "addNewReportData:session null [%b], event null [%b]", objArr);
    }
}
