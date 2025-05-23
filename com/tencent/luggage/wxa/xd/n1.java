package com.tencent.luggage.wxa.xd;

import com.tencent.luggage.wxa.qc.c;
import com.tencent.luggage.wxa.yi.r;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class n1 {

    /* renamed from: a, reason: collision with root package name */
    public static final Map f144867a = new HashMap();

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements r.d {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.xd.n1$a$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C6906a implements c.InterfaceC6640c {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f144868a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f144869b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.nf.f f144870c;

            public C6906a(d dVar, String str, com.tencent.luggage.wxa.nf.f fVar) {
                this.f144868a = dVar;
                this.f144869b = str;
                this.f144870c = fVar;
            }

            @Override // com.tencent.luggage.wxa.qc.c.InterfaceC6640c
            public void a(String str, com.tencent.luggage.wxa.qc.b bVar) {
                com.tencent.luggage.wxa.nf.f.a(this.f144868a, str, bVar, this.f144869b, this.f144870c);
            }
        }

        @Override // com.tencent.luggage.wxa.yi.r.d
        public void a(d dVar, String str, com.tencent.luggage.wxa.nf.f fVar) {
            com.tencent.luggage.wxa.ic.g runtime;
            c.InterfaceC6640c interfaceC6640c = (c.InterfaceC6640c) n1.f144867a.get(str);
            if (interfaceC6640c != null && (runtime = ((i) dVar).getRuntime()) != null) {
                runtime.c0().b(interfaceC6640c);
            }
        }

        @Override // com.tencent.luggage.wxa.yi.r.d
        public void b(d dVar, String str, com.tencent.luggage.wxa.nf.f fVar) {
            C6906a c6906a = new C6906a(dVar, str, fVar);
            n1.f144867a.put(str, c6906a);
            ((i) dVar).getRuntime().c0().a(c6906a);
        }
    }

    public static void a() {
        com.tencent.luggage.wxa.nf.f.a(new a());
    }
}
