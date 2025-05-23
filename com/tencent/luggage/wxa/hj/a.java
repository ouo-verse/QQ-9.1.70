package com.tencent.luggage.wxa.hj;

import com.tencent.luggage.wxa.ei.q;
import com.tencent.luggage.wxa.ej.e;
import com.tencent.luggage.wxa.ic.g;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.ic.m;
import com.tencent.luggage.wxa.tn.w;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a extends e {

    /* renamed from: d, reason: collision with root package name */
    public m.c f127213d;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f127214e;

    public a(e.b bVar, l lVar) {
        super(bVar, lVar);
        this.f127214e = new AtomicBoolean(false);
    }

    @Override // com.tencent.luggage.wxa.ej.e
    public int a() {
        return 1;
    }

    @Override // com.tencent.luggage.wxa.ej.e
    public void b() {
        m.a().b(this.f124913a, this.f127213d);
    }

    @Override // com.tencent.luggage.wxa.ej.e
    public void c() {
        this.f127213d = new m.c() { // from class: q21.a
            @Override // com.tencent.luggage.wxa.ic.m.c
            public final void a() {
                com.tencent.luggage.wxa.hj.a.this.e();
            }
        };
        m.a().a(this.f124913a, this.f127213d);
    }

    public void e() {
        if (this.f127214e.get()) {
            return;
        }
        w.d("MicroMsg.ProxyAppBrandServiceOnRuntimeReadyListener", "AppBrandRuntimeProfile| onRuntimeReady %s, %s", this.f124913a.getAppId(), this.f124914b.a());
        q qVar = (q) this.f124914b.getJsRuntime().a(q.class);
        Runnable runnable = new Runnable() { // from class: q21.b
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.luggage.wxa.hj.a.this.d();
            }
        };
        if (qVar.g()) {
            runnable.run();
        } else {
            qVar.a(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        g runtime = this.f124913a.getRuntime();
        if (runtime == null || runtime.t0() || this.f127214e.getAndSet(true)) {
            return;
        }
        w.d("MicroMsg.ProxyAppBrandServiceOnRuntimeReadyListener", "AppBrandRuntimeProfile| start prepareDataForNode %s, %s", this.f124913a.getAppId(), this.f124914b.a());
        HashMap hashMap = new HashMap();
        a(hashMap, ((com.tencent.luggage.wxa.c5.e) runtime).B1());
        hashMap.put("state", Integer.valueOf(com.tencent.luggage.wxa.qc.b.FOREGROUND.ordinal()));
        hashMap.put("wxaData", com.tencent.luggage.wxa.fj.b.a(runtime));
        hashMap.put("envType", this.f124914b.a().toString());
        a(hashMap);
    }

    public final void a(Map map, com.tencent.luggage.wxa.rj.c cVar) {
        if (cVar == null) {
            w.f("MicroMsg.ProxyAppBrandServiceOnRuntimeReadyListener", "fillPermissionBytes controller null");
            return;
        }
        com.tencent.luggage.wxa.rj.b d16 = cVar.d();
        if (d16 != null) {
            b.a(map, d16.b(), d16.a());
        }
        b.a(map, cVar.e());
    }
}
