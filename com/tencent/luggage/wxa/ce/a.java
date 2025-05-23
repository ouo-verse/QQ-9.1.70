package com.tencent.luggage.wxa.ce;

import android.content.Context;
import com.tencent.luggage.wxa.ic.d;
import com.tencent.luggage.wxa.ml.q;
import com.tencent.luggage.wxa.rj.e;
import com.tencent.luggage.wxa.rj.g;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.uj.i;
import com.tencent.luggage.wxa.uj.k;
import com.tencent.luggage.wxa.uj.o;
import com.tencent.luggage.wxa.wj.c;
import java.util.ArrayList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface a extends g, q {

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ce.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6105a {

        /* renamed from: a, reason: collision with root package name */
        public static final C6105a f123472a = new C6105a();

        /* renamed from: b, reason: collision with root package name */
        public static final C6106a f123473b = new C6106a();

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.ce.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6106a implements b {
            @Override // com.tencent.luggage.wxa.ce.a.b
            public a a(d component) {
                c D;
                Intrinsics.checkNotNullParameter(component, "component");
                com.tencent.luggage.wxa.ic.g runtime = component.getRuntime();
                if (runtime == null || (D = runtime.n0()) == null) {
                    D = component.D();
                }
                Intrinsics.checkNotNull(D);
                Context context = component.getContext();
                if (context == null) {
                    context = z.c();
                }
                Intrinsics.checkNotNullExpressionValue(context, "component.context ?: MMA\u2026ationContext.getContext()");
                String appId = component.getAppId();
                Intrinsics.checkNotNullExpressionValue(appId, "component.appId");
                o oVar = new o(context, appId, D);
                if (d() && D.isLargeScreenWindow()) {
                    oVar.c(1);
                }
                return oVar;
            }

            @Override // com.tencent.luggage.wxa.ce.a.b
            public /* synthetic */ boolean d() {
                return g21.a.a(this);
            }
        }

        public static final a a(d component) {
            a a16;
            Intrinsics.checkNotNullParameter(component, "component");
            b bVar = (b) component.b(b.class);
            if (bVar == null || (a16 = bVar.a(component)) == null) {
                a a17 = f123473b.a(component);
                Intrinsics.checkNotNull(a17);
                return a17;
            }
            return a16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b extends com.tencent.luggage.wxa.h1.b {
        a a(d dVar);

        boolean d();
    }

    e a(d dVar, String str, com.tencent.luggage.wxa.uj.q qVar, k kVar, i.a aVar);

    void a(String str);

    void a(ArrayList arrayList);

    void a(Function0 function0);

    void a(Function1 function1);

    void b(String str);

    void b(Function0 function0);

    void b(Function1 function1);

    void b(boolean z16);

    void c(Function0 function0);

    void d(String str);

    void d(Function0 function0);

    void e(String str);

    void e(Function0 function0);

    void f(String str);
}
