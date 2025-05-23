package com.tencent.luggage.wxa.ae;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.luggage.wxa.hn.gf;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.ml.j;
import com.tencent.luggage.wxa.ml.r;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.xo.e;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Charsets;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface h {

    /* renamed from: n, reason: collision with root package name */
    public static final b f121074n = b.f121075a;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ae.h$-CC, reason: invalid class name */
    /* loaded from: classes8.dex */
    public final /* synthetic */ class CC {
        public static Context a(h hVar, com.tencent.luggage.wxa.xd.d dVar) {
            com.tencent.luggage.wxa.xd.i iVar;
            Context context;
            com.tencent.luggage.wxa.ic.g runtime;
            Intrinsics.checkNotNullParameter(dVar, "<this>");
            Context context2 = dVar.getContext();
            if (context2 == null) {
                if (dVar instanceof com.tencent.luggage.wxa.xd.i) {
                    iVar = (com.tencent.luggage.wxa.xd.i) dVar;
                } else {
                    iVar = null;
                }
                if (iVar != null && (runtime = iVar.getRuntime()) != null) {
                    context = runtime.F();
                } else {
                    context = null;
                }
                if (context == null) {
                    Context c16 = z.c();
                    Intrinsics.checkNotNullExpressionValue(c16, "getContext()");
                    return c16;
                }
                return context;
            }
            return context2;
        }

        public static com.tencent.luggage.wxa.fn.c b(h hVar, String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            return new com.tencent.luggage.wxa.fn.c(bytes);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0036  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0034  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static gf c(h hVar, gf gfVar, com.tencent.luggage.wxa.xd.d service) {
            int i3;
            Intrinsics.checkNotNullParameter(gfVar, "<this>");
            Intrinsics.checkNotNullParameter(service, "service");
            int i16 = 0;
            if (service instanceof com.tencent.luggage.wxa.xd.i) {
                com.tencent.luggage.wxa.xd.i iVar = (com.tencent.luggage.wxa.xd.i) service;
                if (iVar.getRuntime() instanceof com.tencent.luggage.wxa.c5.e) {
                    com.tencent.luggage.wxa.ic.g runtime = iVar.getRuntime();
                    Intrinsics.checkNotNull(runtime, "null cannot be cast to non-null type com.tencent.luggage.sdk.runtime.AppBrandRuntimeLU");
                    i3 = ((com.tencent.luggage.wxa.c5.e) runtime).G1();
                    gfVar.f127719e = i3;
                    if (!(service instanceof com.tencent.luggage.wxa.ic.l)) {
                        i16 = 1;
                    } else if (service instanceof v) {
                        i16 = 2;
                    }
                    gfVar.f127720f = i16;
                    return gfVar;
                }
            }
            i3 = 0;
            gfVar.f127719e = i3;
            if (!(service instanceof com.tencent.luggage.wxa.ic.l)) {
            }
            gfVar.f127720f = i16;
            return gfVar;
        }

        public static void d(h hVar, Context context, Bitmap bitmap, String str, String str2, com.tencent.luggage.wxa.tj.d dialog) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            com.tencent.luggage.wxa.rn.a.a(new f(str, context, str2, bitmap, dialog));
        }

        public static void e(h hVar, com.tencent.luggage.wxa.xd.i iVar, com.tencent.luggage.wxa.ml.m dialog) {
            Intrinsics.checkNotNullParameter(iVar, "<this>");
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            com.tencent.luggage.wxa.ic.g runtime = iVar.getRuntime();
            if (runtime != null) {
                runtime.e(new g(iVar, dialog));
            }
        }

        public static void f(h hVar, com.tencent.luggage.wxa.xo.b bVar, com.tencent.luggage.wxa.xo.d pipeable) {
            Intrinsics.checkNotNullParameter(bVar, "<this>");
            Intrinsics.checkNotNullParameter(pipeable, "pipeable");
            pipeable.a(new d(bVar)).a(new e(bVar));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ b f121075a = new b();

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0026, code lost:
        
            if (r0.a() == true) goto L19;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final com.tencent.luggage.wxa.bj.c a(com.tencent.luggage.wxa.xd.d dVar) {
            com.tencent.luggage.wxa.xd.i iVar = dVar instanceof com.tencent.luggage.wxa.xd.i ? (com.tencent.luggage.wxa.xd.i) dVar : null;
            com.tencent.luggage.wxa.yi.g runtime = iVar != null ? iVar.getRuntime() : null;
            com.tencent.luggage.wxa.c5.e eVar = runtime instanceof com.tencent.luggage.wxa.c5.e ? (com.tencent.luggage.wxa.c5.e) runtime : null;
            boolean z16 = (eVar == null || (r0 = eVar.N1()) == null) ? false : true;
            if (z16) {
                return com.tencent.luggage.wxa.cj.a.f123531h.a((com.tencent.luggage.wxa.xd.i) dVar);
            }
            com.tencent.luggage.wxa.h1.b b16 = dVar.b(com.tencent.luggage.wxa.bj.c.class);
            Intrinsics.checkNotNull(b16);
            Intrinsics.checkNotNullExpressionValue(b16, "{\n                this.c\u2026ass.java)!!\n            }");
            return (com.tencent.luggage.wxa.bj.c) b16;
        }

        public final com.tencent.luggage.wxa.xo.d a(com.tencent.luggage.wxa.xd.d dVar, String url, com.tencent.luggage.wxa.fn.b request, Class clazz) {
            Intrinsics.checkNotNullParameter(dVar, "<this>");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            com.tencent.luggage.wxa.xo.d b16 = a(dVar).b(url, dVar.getAppId(), request, clazz);
            Intrinsics.checkNotNullExpressionValue(b16, "this.cgiService().syncPi\u2026is.appId, request, clazz)");
            return b16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends Exception {

        /* renamed from: a, reason: collision with root package name */
        public static final c f121076a = new c();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xo.b f121077a;

        public d(com.tencent.luggage.wxa.xo.b bVar) {
            this.f121077a = bVar;
        }

        @Override // com.tencent.luggage.wxa.xo.e.c
        public final void a(Object obj) {
            com.tencent.luggage.wxa.xo.h.a(this.f121077a, obj);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xo.b f121078a;

        public e(com.tencent.luggage.wxa.xo.b bVar) {
            this.f121078a = bVar;
        }

        @Override // com.tencent.luggage.wxa.xo.e.a
        public final void a(Object obj) {
            this.f121078a.a(obj);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f121079a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f121080b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f121081c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Bitmap f121082d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.tj.d f121083e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, Context context, String str2, Bitmap bitmap, com.tencent.luggage.wxa.tj.d dVar) {
            super(0);
            this.f121079a = str;
            this.f121080b = context;
            this.f121081c = str2;
            this.f121082d = bitmap;
            this.f121083e = dVar;
        }

        public final void a() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new j.a(0, this.f121079a, this.f121080b.getResources().getString(R.string.z2e), this.f121081c, this.f121082d, false, null, 0, 224, null));
            this.f121083e.a(arrayList);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.i f121084a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ml.m f121085b;

        public g(com.tencent.luggage.wxa.xd.i iVar, com.tencent.luggage.wxa.ml.m mVar) {
            this.f121084a = iVar;
            this.f121085b = mVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            r H;
            com.tencent.luggage.wxa.ic.g runtime = this.f121084a.getRuntime();
            if (runtime != null && (H = runtime.H()) != null) {
                H.a(this.f121085b);
            }
        }
    }

    Context a(com.tencent.luggage.wxa.xd.d dVar);

    com.tencent.luggage.wxa.fn.c a(String str);

    gf a(gf gfVar, com.tencent.luggage.wxa.xd.d dVar);

    void a(Context context, Bitmap bitmap, String str, String str2, com.tencent.luggage.wxa.tj.d dVar);

    void a(com.tencent.luggage.wxa.xd.i iVar, com.tencent.luggage.wxa.ml.m mVar);

    void a(com.tencent.luggage.wxa.xo.b bVar, com.tencent.luggage.wxa.xo.d dVar);
}
