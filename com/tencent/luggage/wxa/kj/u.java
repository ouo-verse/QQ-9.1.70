package com.tencent.luggage.wxa.kj;

import com.tencent.luggage.wxa.qc.c;
import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public static final u f132423a = new u();

    /* renamed from: b, reason: collision with root package name */
    public static boolean f132424b = true;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends HashSet implements com.tencent.luggage.wxa.xd.m {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.kj.u$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6394a implements c.InterfaceC6640c {
            public C6394a() {
            }

            @Override // com.tencent.luggage.wxa.qc.c.InterfaceC6640c
            public final void a(String str, com.tencent.luggage.wxa.qc.b bVar) {
                if (bVar == com.tencent.luggage.wxa.qc.b.DESTROYED) {
                    a.this.clear();
                }
            }
        }

        public a(com.tencent.luggage.wxa.ic.g runtime) {
            Intrinsics.checkNotNullParameter(runtime, "runtime");
            com.tencent.luggage.wxa.qc.c c06 = runtime.c0();
            if (c06 != null) {
                c06.a(new C6394a());
            }
        }

        public /* bridge */ boolean a(v vVar) {
            return super.contains(vVar);
        }

        public /* bridge */ int b() {
            return super.size();
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final /* bridge */ boolean contains(Object obj) {
            if (!(obj instanceof v)) {
                return false;
            }
            return a((v) obj);
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final /* bridge */ boolean remove(Object obj) {
            if (!(obj instanceof v)) {
                return false;
            }
            return b((v) obj);
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final /* bridge */ int size() {
            return b();
        }

        public /* bridge */ boolean b(v vVar) {
            return super.remove(vVar);
        }
    }

    public static final void a(v page) {
        Intrinsics.checkNotNullParameter(page, "page");
        if (page.getRuntime() == null) {
            return;
        }
        try {
            u uVar = f132423a;
            com.tencent.luggage.wxa.ic.g runtime = page.getRuntime();
            Intrinsics.checkNotNullExpressionValue(runtime, "page.runtime");
            uVar.a(runtime).remove(page);
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.f("Luggage.AppBrandPageTrimLogic[wxa_reload]", "onPageReload " + e16);
        }
    }

    public final a a(com.tencent.luggage.wxa.ic.g gVar) {
        a aVar = (a) gVar.c(a.class);
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a(gVar);
        gVar.a((com.tencent.luggage.wxa.xd.m) aVar2);
        return aVar2;
    }
}
