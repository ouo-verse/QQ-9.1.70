package com.tencent.luggage.wxa.ya;

import com.tencent.luggage.wxa.tn.w;
import java.lang.reflect.Modifier;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes9.dex */
public class d {

    /* renamed from: c, reason: collision with root package name */
    public static final d f145497c = new d();

    /* renamed from: a, reason: collision with root package name */
    public ConcurrentHashMap f145498a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    public a f145499b = null;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface a {
        void a(Class cls, com.tencent.luggage.wxa.ya.a aVar);

        void a(Class cls, c cVar);

        void b(Class cls, c cVar);
    }

    public void a(a aVar) {
        this.f145499b = aVar;
    }

    public final com.tencent.luggage.wxa.ya.a b(Class cls) {
        boolean z16;
        com.tencent.luggage.wxa.ya.a aVar;
        c cVar = (c) this.f145498a.get(cls);
        if (!cls.isInterface() && Modifier.isAbstract(cls.getModifiers())) {
            w.f("MicroMsg.ServiceHub", "Did you call service by using the service implementation class ?? Use interface class instead!! Carl is warning u!");
            z16 = true;
        } else {
            z16 = false;
        }
        if (cVar != null) {
            aVar = cVar.get();
        } else {
            w.b("MicroMsg.ServiceHub", "Service(%s) not found!!! ", cls);
            if (z16) {
                w.b("MicroMsg.ServiceHub", "This error must cause by using implementation class to call service! Use interface instead! Understand?");
            }
            aVar = null;
        }
        a aVar2 = this.f145499b;
        if (aVar2 != null) {
            aVar2.a(cls, aVar);
        }
        return aVar;
    }

    public void c(Class cls) {
        c cVar = (c) this.f145498a.remove(cls);
        if (cVar instanceof b) {
            ((b) cVar).G();
        }
        a aVar = this.f145499b;
        if (aVar != null) {
            aVar.b(cls, cVar);
        }
    }

    public com.tencent.luggage.wxa.ya.a a(Class cls) {
        return b(cls);
    }

    public void a(Class cls, com.tencent.luggage.wxa.ya.a aVar) {
        a(cls, new e(aVar));
    }

    public void a(Class cls, c cVar) {
        this.f145498a.put(cls, cVar);
        if (cVar instanceof b) {
            ((b) cVar).e();
        }
        a aVar = this.f145499b;
        if (aVar != null) {
            aVar.a(cls, cVar);
        }
        w.d("MicroMsg.ServiceHub", "register service %s %s", cls, cVar);
    }
}
