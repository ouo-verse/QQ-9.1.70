package com.tencent.luggage.wxa.tj;

import android.content.Context;
import android.view.View;
import com.tencent.luggage.wxa.hn.m9;
import com.tencent.luggage.wxa.ml.q;
import com.tencent.luggage.wxa.rj.r;
import com.tencent.luggage.wxa.rj.s;
import com.tencent.luggage.wxa.tn.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface d extends com.tencent.luggage.wxa.rj.g, q {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f141476a = new a();

        /* renamed from: b, reason: collision with root package name */
        public static final C6765a f141477b = new C6765a();

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.tj.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6765a implements b {

            /* renamed from: a, reason: collision with root package name */
            public final String f141478a = "scope.bluetooth";

            /* renamed from: b, reason: collision with root package name */
            public final String f141479b = "scope.bluetoothBackground";

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.tj.d$a$a$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public static final class C6766a implements r {

                /* renamed from: a, reason: collision with root package name */
                public final String f141480a;

                /* renamed from: b, reason: collision with root package name */
                public final String f141481b;

                public C6766a(C6765a c6765a, boolean z16) {
                    String str;
                    this.f141480a = c6765a.f141478a;
                    if (z16) {
                        str = c6765a.f141479b;
                    } else {
                        str = null;
                    }
                    this.f141481b = str;
                }

                @Override // com.tencent.luggage.wxa.rj.r
                public String a() {
                    return this.f141481b;
                }

                @Override // com.tencent.luggage.wxa.rj.r
                public String b() {
                    return this.f141480a;
                }
            }

            @Override // com.tencent.luggage.wxa.tj.d.b
            public /* synthetic */ boolean d() {
                return e41.b.a(this);
            }

            @Override // com.tencent.luggage.wxa.tj.d.b
            public d a(com.tencent.luggage.wxa.ic.d component, c listener, List list) {
                com.tencent.luggage.wxa.wj.c D;
                com.tencent.luggage.wxa.ml.d dVar;
                r a16;
                Intrinsics.checkNotNullParameter(component, "component");
                Intrinsics.checkNotNullParameter(listener, "listener");
                com.tencent.luggage.wxa.ic.g runtime = component.getRuntime();
                if (runtime == null || (D = runtime.n0()) == null) {
                    D = component.D();
                }
                Intrinsics.checkNotNull(D);
                Context context = component.getContext();
                if (context == null) {
                    context = z.c();
                }
                if (list != null && (a16 = a(list)) != null) {
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    dVar = new s(context, D, listener, a16);
                } else {
                    Context context2 = component.getContext();
                    if (context2 == null) {
                        context2 = z.c();
                    }
                    Intrinsics.checkNotNullExpressionValue(context2, "component.context ?: MMA\u2026ationContext.getContext()");
                    dVar = new com.tencent.luggage.wxa.ml.d(context2, D, listener);
                }
                if (d() && D.isLargeScreenWindow()) {
                    dVar.d(1);
                }
                return dVar;
            }

            public final r a(List list) {
                Object obj;
                Object obj2;
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (Intrinsics.areEqual(this.f141478a, ((m9) obj).f128168d)) {
                        break;
                    }
                }
                boolean z16 = obj != null;
                Iterator it5 = list.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    obj2 = it5.next();
                    if (Intrinsics.areEqual(this.f141479b, ((m9) obj2).f128168d)) {
                        break;
                    }
                }
                boolean z17 = obj2 != null;
                if (z16) {
                    return new C6766a(this, z17);
                }
                return null;
            }
        }

        public static final d a(com.tencent.luggage.wxa.ic.d component, c listener, List list) {
            d a16;
            Intrinsics.checkNotNullParameter(component, "component");
            Intrinsics.checkNotNullParameter(listener, "listener");
            b bVar = (b) component.b(b.class);
            if (bVar == null || (a16 = bVar.a(component, listener, list)) == null) {
                d a17 = f141477b.a(component, listener, list);
                Intrinsics.checkNotNull(a17);
                return a17;
            }
            return a16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b extends com.tencent.luggage.wxa.h1.b {
        d a(com.tencent.luggage.wxa.ic.d dVar, c cVar, List list);

        boolean d();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface c {
        void a(int i3, ArrayList arrayList, int i16, boolean z16);
    }

    void a(int i3);

    void a(View.OnClickListener onClickListener);

    void a(String str);

    void a(List list);

    void a(boolean z16);

    void b(String str);

    void g(String str);

    void h(String str);

    void i(String str);

    void j(String str);

    void k(String str);

    void l(String str);
}
