package com.tencent.luggage.wxa.i1;

import com.tencent.luggage.wxa.h1.e;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static c f129193a;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.i1.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6270a implements d {
        @Override // com.tencent.luggage.wxa.i1.a.d
        public void a(Class cls, com.tencent.luggage.wxa.h1.b bVar) {
            e.a(cls, bVar);
        }

        @Override // com.tencent.luggage.wxa.i1.a.d
        public void a(Class cls, com.tencent.luggage.wxa.h1.d dVar) {
            e.a(cls, dVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b extends d {
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface c {
        void a(b bVar);

        void a(d dVar);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface d {
        void a(Class cls, com.tencent.luggage.wxa.h1.b bVar);

        void a(Class cls, com.tencent.luggage.wxa.h1.d dVar);
    }

    public static void a(c cVar) {
        if (f129193a != null) {
            w.b("Luggage.LuggageBoot", "do not setup more than once.");
        } else if (cVar == null) {
            w.f("Luggage.LuggageBoot", "setup failed, delegate is null");
        } else {
            f129193a = cVar;
            cVar.a(new C6270a());
        }
    }

    public static void a(b bVar) {
        if (bVar == null) {
            w.f("Luggage.LuggageBoot", "init component failed, initializer is null");
            return;
        }
        c cVar = f129193a;
        if (cVar == null) {
            return;
        }
        cVar.a(bVar);
    }
}
