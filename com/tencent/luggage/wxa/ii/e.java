package com.tencent.luggage.wxa.ii;

import android.util.Pair;
import com.tencent.luggage.wxa.hn.k1;
import com.tencent.luggage.wxa.hn.u2;
import com.tencent.luggage.wxa.ii.k;
import com.tencent.luggage.wxa.ii.l;
import com.tencent.luggage.wxa.mc.a0;
import com.tencent.luggage.wxa.mc.d0;
import com.tencent.luggage.wxa.mc.e;
import com.tencent.luggage.wxa.mc.e0;
import com.tencent.luggage.wxa.mc.f0;
import com.tencent.luggage.wxa.mc.g0;
import com.tencent.luggage.wxa.mc.h0;
import com.tencent.luggage.wxa.mc.i0;
import com.tencent.luggage.wxa.mc.j0;
import com.tencent.luggage.wxa.mc.l0;
import com.tencent.luggage.wxa.mc.m0;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xo.e;
import com.tencent.luggage.wxa.y7.c;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;
import com.tenpay.proxy.dlg.location.QbAddrData;
import java.io.FileNotFoundException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt__MathJVMKt;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e implements k {

    /* renamed from: p, reason: collision with root package name */
    public static final b f130461p = new b(null);

    /* renamed from: q, reason: collision with root package name */
    public static final g0 f130462q = new g0(0, 0, 0);

    /* renamed from: b, reason: collision with root package name */
    public final k.d f130463b;

    /* renamed from: c, reason: collision with root package name */
    public final Function1 f130464c;

    /* renamed from: d, reason: collision with root package name */
    public final l f130465d;

    /* renamed from: e, reason: collision with root package name */
    public final int f130466e;

    /* renamed from: f, reason: collision with root package name */
    public final k1 f130467f;

    /* renamed from: g, reason: collision with root package name */
    public final k.c f130468g;

    /* renamed from: h, reason: collision with root package name */
    public final Function1 f130469h;

    /* renamed from: i, reason: collision with root package name */
    public final Function2 f130470i;

    /* renamed from: j, reason: collision with root package name */
    public final com.tencent.luggage.wxa.mc.r f130471j;

    /* renamed from: k, reason: collision with root package name */
    public final Lazy f130472k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f130473l;

    /* renamed from: m, reason: collision with root package name */
    public g0 f130474m;

    /* renamed from: n, reason: collision with root package name */
    public long f130475n;

    /* renamed from: o, reason: collision with root package name */
    public long f130476o;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class a {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.ii.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class RunnableC6309a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ l.a f130478a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ u2[] f130479b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ a f130480c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ e f130481d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.mc.d f130482e;

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.ii.e$a$a$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public static final class C6310a implements com.tencent.luggage.wxa.uo.b {

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ u2[] f130483b;

                /* renamed from: c, reason: collision with root package name */
                public final /* synthetic */ e f130484c;

                /* renamed from: d, reason: collision with root package name */
                public final /* synthetic */ l.a f130485d;

                /* renamed from: e, reason: collision with root package name */
                public final /* synthetic */ com.tencent.luggage.wxa.mc.d f130486e;

                /* renamed from: f, reason: collision with root package name */
                public final /* synthetic */ a f130487f;

                /* compiled from: P */
                /* renamed from: com.tencent.luggage.wxa.ii.e$a$a$a$a, reason: collision with other inner class name */
                /* loaded from: classes8.dex */
                public static final class C6311a implements com.tencent.luggage.wxa.y7.b {

                    /* renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ e f130488a;

                    public C6311a(e eVar) {
                        this.f130488a = eVar;
                    }

                    @Override // com.tencent.luggage.wxa.y7.b
                    public void a(com.tencent.mm.plugin.appbrand.appcache.a pkgInfo) {
                        Intrinsics.checkNotNullParameter(pkgInfo, "pkgInfo");
                        Function1 function1 = this.f130488a.f130469h;
                        c cVar = c.f130491a;
                        k.d dVar = this.f130488a.f130463b;
                        String pkgFilePath = pkgInfo.getPkgFilePath();
                        Intrinsics.checkNotNull(pkgFilePath);
                        function1.invoke(cVar.a(dVar, pkgFilePath, pkgInfo.checksumMd5(), pkgInfo.getPkgAppVersion(), k.f.REMOTE));
                    }

                    @Override // com.tencent.luggage.wxa.y7.b
                    public void onError(Throwable t16) {
                        k.a aVar;
                        Intrinsics.checkNotNullParameter(t16, "t");
                        Function2 function2 = this.f130488a.f130470i;
                        if (t16 instanceof c.b) {
                            aVar = k.a.PKG_INTEGRITY_FAILED;
                        } else if (t16 instanceof c.C6944c) {
                            aVar = k.a.SEVER_FILE_NOT_FOUND;
                        } else {
                            aVar = k.a.FAILED;
                        }
                        function2.invoke(aVar, t16);
                    }
                }

                /* compiled from: P */
                /* renamed from: com.tencent.luggage.wxa.ii.e$a$a$a$b */
                /* loaded from: classes8.dex */
                public static final class b extends Lambda implements Function1 {

                    /* renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ a f130489a;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public b(a aVar) {
                        super(1);
                        this.f130489a = aVar;
                    }

                    public final void a(g0 it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        this.f130489a.a(it);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        a((g0) obj);
                        return Unit.INSTANCE;
                    }
                }

                public C6310a(u2[] u2VarArr, e eVar, l.a aVar, com.tencent.luggage.wxa.mc.d dVar, a aVar2) {
                    this.f130483b = u2VarArr;
                    this.f130484c = eVar;
                    this.f130485d = aVar;
                    this.f130486e = dVar;
                    this.f130487f = aVar2;
                }

                public final void a(Void r112) {
                    boolean z16;
                    u2 u2Var = this.f130483b[0];
                    Intrinsics.checkNotNull(u2Var);
                    String str = u2Var.f128793e;
                    if (str != null && str.length() != 0) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (z16) {
                        this.f130484c.f130470i.invoke(k.a.FAILED, new RuntimeException("invalid url"));
                        return;
                    }
                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.CommonPkgFetcher", "Downloader.fallbackLegacy with " + this.f130485d);
                    com.tencent.luggage.wxa.y7.c cVar = com.tencent.luggage.wxa.y7.c.f145448a;
                    com.tencent.luggage.wxa.mc.r rVar = this.f130484c.f130471j;
                    com.tencent.luggage.wxa.mc.d dVar = this.f130486e;
                    com.tencent.luggage.wxa.mc.o d16 = this.f130484c.d();
                    u2 u2Var2 = this.f130483b[0];
                    Intrinsics.checkNotNull(u2Var2);
                    String str2 = u2Var2.f128793e;
                    Intrinsics.checkNotNullExpressionValue(str2, "urls[LEGACY]!!.url");
                    cVar.a(rVar, dVar, d16, str2, new C6311a(this.f130484c), new b(this.f130487f), this.f130484c.f130473l);
                }

                @Override // com.tencent.luggage.wxa.uo.b
                public /* bridge */ /* synthetic */ Object call(Object obj) {
                    a((Void) obj);
                    return Unit.INSTANCE;
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.ii.e$a$a$b */
            /* loaded from: classes8.dex */
            public static final class b implements e.c {

                /* renamed from: a, reason: collision with root package name */
                public static final b f130490a = new b();

                @Override // com.tencent.luggage.wxa.xo.e.c
                public final void a(Unit unit) {
                }
            }

            public RunnableC6309a(l.a aVar, u2[] u2VarArr, a aVar2, e eVar, com.tencent.luggage.wxa.mc.d dVar) {
                this.f130478a = aVar;
                this.f130479b = u2VarArr;
                this.f130480c = aVar2;
                this.f130481d = eVar;
                this.f130482e = dVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Object orNull;
                if (this.f130478a.f()) {
                    orNull = ArraysKt___ArraysKt.getOrNull(this.f130479b, 0);
                    if (((u2) orNull) == null) {
                        l.a aVar = this.f130478a;
                        e eVar = this.f130481d;
                        com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.CommonPkgFetcher", "Downloader.start, get invalid app_version using needLatestVersion, request=" + aVar);
                        eVar.f130470i.invoke(k.a.FAILED, new RuntimeException("invalid cgi response"));
                        return;
                    }
                } else {
                    this.f130478a.b();
                }
                com.tencent.luggage.wxa.xo.h.c().b(new C6310a(this.f130479b, this.f130481d, this.f130478a, this.f130482e, this.f130480c)).a(b.f130490a);
            }
        }

        public a() {
        }

        public final void a(l.a request, com.tencent.luggage.wxa.mc.d record, u2[] urls) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(record, "record");
            Intrinsics.checkNotNullParameter(urls, "urls");
            a(e.f130462q);
            com.tencent.luggage.wxa.yo.d.f146045b.a(new RunnableC6309a(request, urls, this, e.this, record));
        }

        public final void a(g0 g0Var) {
            long roundToLong;
            int roundToInt;
            e.this.f130464c.invoke(g0Var);
            long c16 = w0.c();
            long j3 = g0Var.f134301b - e.this.f130474m.f134301b;
            long j16 = c16 - e.this.f130475n;
            if (j16 <= 0) {
                return;
            }
            e eVar = e.this;
            roundToLong = MathKt__MathJVMKt.roundToLong((((float) j3) / ((float) j16)) * 1000);
            eVar.f130476o = roundToLong;
            if (com.tencent.luggage.wxa.tn.w.d() <= 0) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onPkgUpdateProgress speed:");
                sb5.append(e.this.f130476o);
                sb5.append("B/s, ");
                roundToInt = MathKt__MathJVMKt.roundToInt((((float) e.this.f130476o) / 1024.0f) / 1024.0f);
                sb5.append(roundToInt);
                sb5.append("M/s");
                com.tencent.luggage.wxa.tn.w.e("MicroMsg.AppBrand.CommonPkgFetcher", sb5.toString());
            }
            e.this.f130474m = g0Var;
            e.this.f130475n = c16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final com.tencent.luggage.wxa.mc.d b(com.tencent.luggage.wxa.mc.o oVar, com.tencent.luggage.wxa.mc.r rVar, int i3, k.g gVar) {
            com.tencent.luggage.wxa.mc.d i0Var;
            if (oVar instanceof l0) {
                i0Var = new h0();
            } else if (oVar instanceof j0) {
                i0Var = new h0();
            } else if (oVar instanceof e0) {
                i0Var = new i0();
            } else {
                if (!(oVar instanceof d0)) {
                    throw new IllegalStateException(("Unrecognized storage class:" + oVar.getClass().getName()).toString());
                }
                i0Var = new i0();
            }
            i0Var.f138305b = rVar.toString();
            i0Var.f138319p = i3;
            if (gVar instanceof k.g.c) {
                i0Var.f138307d = ((k.g.c) gVar).a();
            } else if (gVar instanceof k.g.a) {
                ((i0) i0Var).Z = ((k.g.a) gVar).a();
            }
            return i0Var;
        }

        public final com.tencent.luggage.wxa.mc.o a(k.d dVar) {
            boolean contains;
            if (dVar.g() instanceof k.g.a) {
                return d0.f134272a;
            }
            int[] PLUGINCODE_PACKAGE_TYPES = com.tencent.luggage.wxa.ip.a.f130734d;
            Intrinsics.checkNotNullExpressionValue(PLUGINCODE_PACKAGE_TYPES, "PLUGINCODE_PACKAGE_TYPES");
            contains = ArraysKt___ArraysKt.contains(PLUGINCODE_PACKAGE_TYPES, dVar.e());
            if (contains && e.a.a(dVar.h())) {
                return d0.f134272a;
            }
            j0 a16 = j0.a();
            Intrinsics.checkNotNullExpressionValue(a16, "instance()");
            return a16;
        }

        public final com.tencent.luggage.wxa.mc.d a(com.tencent.luggage.wxa.mc.o oVar, com.tencent.luggage.wxa.mc.r rVar, int i3, k.g gVar) {
            if ((gVar instanceof k.g.c) && e.a.b(i3)) {
                return (com.tencent.luggage.wxa.mc.d) oVar.a(rVar.toString(), ((k.g.c) gVar).a(), i3, new String[0]);
            }
            if (gVar instanceof k.g.a) {
                return (com.tencent.luggage.wxa.mc.d) oVar.a(rVar.toString(), i3, ((k.g.a) gVar).a(), new String[0]);
            }
            return (com.tencent.luggage.wxa.mc.d) oVar.a(rVar.toString(), i3, new String[0]);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d extends Lambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function2 f130492a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f130493b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Function2 function2, e eVar) {
            super(2);
            this.f130492a = function2;
            this.f130493b = eVar;
        }

        public final void a(k.a err, Throwable ex5) {
            Intrinsics.checkNotNullParameter(err, "err");
            Intrinsics.checkNotNullParameter(ex5, "ex");
            this.f130492a.invoke(err, ex5);
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.CommonPkgFetcher", "onError(" + err + ", " + ex5 + "), request:" + this.f130493b.f130463b);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((k.a) obj, (Throwable) obj2);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ii.e$e, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6312e extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f130494a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f130495b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C6312e(Function1 function1, e eVar) {
            super(1);
            this.f130494a = function1;
            this.f130495b = eVar;
        }

        public final void a(k.e it) {
            Intrinsics.checkNotNullParameter(it, "it");
            this.f130494a.invoke(it);
            if (it.b() == k.f.CACHED) {
                k.c cVar = this.f130495b.f130468g;
                if (cVar != null) {
                    cVar.a(this.f130495b.f130463b, it);
                }
            } else {
                k.c cVar2 = this.f130495b.f130468g;
                if (cVar2 != null) {
                    cVar2.b(this.f130495b.f130463b, it);
                }
            }
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.CommonPkgFetcher", "onSuccess(" + it + "), request:" + this.f130495b.f130463b);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((k.e) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f extends Lambda implements Function0 {
        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxa.mc.o invoke() {
            return e.f130461p.a(e.this.f130463b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g extends Lambda implements Function1 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l.a f130498b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(l.a aVar) {
            super(1);
            this.f130498b = aVar;
        }

        public final void a(u2[] urls) {
            k.g g16;
            j0 j0Var;
            Intrinsics.checkNotNullParameter(urls, "urls");
            boolean z16 = false;
            u2 u2Var = urls[0];
            if (u2Var == null) {
                e eVar = e.this;
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.CommonPkgFetcher", "cgiExecutor.onSuccess get NULL normal item with " + eVar.f130463b);
                eVar.f130470i.invoke(k.a.FAILED, new RuntimeException("get invalid url"));
                return;
            }
            if (this.f130498b.f() && (j0Var = (j0) e.this.d()) != null) {
                j0Var.b(u2Var.f128799k.f128593d, u2Var.f128796h, u2Var.f128800l);
            }
            e eVar2 = e.this;
            if (eVar2.f130463b.g() instanceof k.g.b) {
                g16 = new k.g.c(u2Var.f128796h, 0L, 2, null);
            } else {
                g16 = eVar2.f130463b.g();
            }
            com.tencent.luggage.wxa.mc.d a16 = e.f130461p.a(eVar2.d(), eVar2.f130471j, eVar2.f130463b.h(), g16);
            if (a16 == null) {
                a16 = e.f130461p.b(eVar2.d(), eVar2.f130471j, eVar2.f130463b.h(), g16);
            }
            String str = a16.f138309f;
            String str2 = a16.f138311h;
            if (str == null || str.length() == 0) {
                z16 = true;
            }
            if (z16) {
                a16.f138309f = u2Var.f128794f;
            }
            a16.f138311h = u2Var.f128794f;
            a16.f138307d = u2Var.f128796h;
            a16.f138321r = u2Var.f128793e;
            a16.f138317n = w0.d();
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.CommonPkgFetcher", "cgiExecutor.onSuccess, updated(" + m0.a(e.this.d(), a16) + ") md5(" + str + QbAddrData.DATA_SPLITER + str2 + ")->(" + a16.f138309f + QbAddrData.DATA_SPLITER + a16.f138311h + ") with key(" + a16.f138305b + "), versionType(" + a16.f138319p + "), version(" + a16.f138307d + ')');
            if (this.f130498b.f()) {
                Pair a17 = f0.f134289a.a(a16.f138305b, a16.f138319p, a16.f138307d);
                f0.a aVar = (f0.a) com.tencent.luggage.wxa.ii.f.a(a17);
                com.tencent.mm.plugin.appbrand.appcache.a aVar2 = (com.tencent.mm.plugin.appbrand.appcache.a) com.tencent.luggage.wxa.ii.f.b(a17);
                if (aVar2 != null) {
                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.CommonPkgFetcher", "cgiExecutor.onSuccess, latest request already cached, request=" + e.this.f130463b);
                    Function1 function1 = e.this.f130469h;
                    c cVar = c.f130491a;
                    k.d dVar = e.this.f130463b;
                    String str3 = aVar2.pkgPath;
                    Intrinsics.checkNotNullExpressionValue(str3, "pkg.pkgPath");
                    function1.invoke(cVar.a(dVar, str3, aVar2.md5, a16.f138307d, k.f.CACHED));
                    return;
                }
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.CommonPkgFetcher", "cgiExecutor.onSuccess, latest request find cached pkg with error:" + aVar + " request:" + e.this.f130463b);
                if (aVar == f0.a.ENV_ERR || aVar == f0.a.APP_MANIFEST_NULL) {
                    e.this.f130470i.invoke(k.a.ENV_ERR, new RuntimeException("find cached pkg failed"));
                    return;
                }
            }
            k.e a18 = c.f130491a.a(e.this.d(), e.this.f130463b, a16);
            if (a18 == null) {
                k.c cVar2 = e.this.f130468g;
                if (cVar2 != null) {
                    cVar2.a(e.this.f130463b, u2Var.f128796h, u2Var.f128800l);
                }
                new a().a(this.f130498b, a16, urls);
                return;
            }
            e.this.f130469h.invoke(a18);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((u2[]) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class h extends Lambda implements Function1 {
        public h() {
            super(1);
        }

        public final void a(Throwable ex5) {
            Intrinsics.checkNotNullParameter(ex5, "ex");
            e.this.f130470i.invoke(k.a.FAILED, ex5);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return Unit.INSTANCE;
        }
    }

    public e(k.d request, Function1 onSuccess, Function2 onError, Function1 onProgress, l cgiExecutor, int i3, k1 cgiCommRequestSource, k.c cVar) {
        Lazy lazy;
        boolean contains;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onProgress, "onProgress");
        Intrinsics.checkNotNullParameter(cgiExecutor, "cgiExecutor");
        Intrinsics.checkNotNullParameter(cgiCommRequestSource, "cgiCommRequestSource");
        this.f130463b = request;
        this.f130464c = onProgress;
        this.f130465d = cgiExecutor;
        this.f130466e = i3;
        this.f130467f = cgiCommRequestSource;
        this.f130468g = cVar;
        this.f130469h = new C6312e(onSuccess, this);
        this.f130470i = new d(onError, this);
        this.f130471j = request.c();
        lazy = LazyKt__LazyJVMKt.lazy(new f());
        this.f130472k = lazy;
        contains = ArraysKt___ArraysKt.contains(new Integer[]{101, 102}, Integer.valueOf(cgiCommRequestSource.f127978f));
        this.f130473l = contains;
        this.f130474m = f130462q;
    }

    public final com.tencent.luggage.wxa.mc.o d() {
        return (com.tencent.luggage.wxa.mc.o) this.f130472k.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01b7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e() {
        boolean z16;
        String str;
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.CommonPkgFetcher", "before QUERY_FACTORY " + this.f130463b);
        com.tencent.luggage.wxa.mc.d a16 = f130461p.a(d(), this.f130471j, this.f130463b.h(), this.f130463b.g());
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.CommonPkgFetcher", "after QUERY_FACTORY " + this.f130463b);
        if (a16 == null) {
            if (((this.f130463b.g() instanceof k.g.b) && e.a.b(this.f130463b.h())) || (this.f130471j.a() && e.a.b(this.f130463b.h())) || (this.f130471j.a() && e.a.a(this.f130463b.h()) && (this.f130463b.g() instanceof k.g.a))) {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.CommonPkgFetcher", "no record, will download with request " + this.f130463b);
                f();
                return;
            }
        }
        if (a16 == null) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.CommonPkgFetcher", "missing record, request " + this.f130463b);
            this.f130470i.invoke(k.a.PKG_RECORD_NULL, new RuntimeException("missing record"));
            return;
        }
        String str2 = a16.f138309f;
        if (str2 == null || str2.length() == 0) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.CommonPkgFetcher", "record.md5 is EMPTY, will download with request " + this.f130463b);
        } else {
            String str3 = a16.f138315l;
            if (str3 == null || str3.length() == 0) {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.CommonPkgFetcher", "record.path is EMPTY, will download with request " + this.f130463b);
            } else if ((this.f130463b.g() instanceof k.g.b) && ((k.g.b) this.f130463b.g()).a()) {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.CommonPkgFetcher", "LATEST(forceUpdate) requested, will download with request " + this.f130463b);
            } else {
                if (!(this.f130463b.g() instanceof k.g.b) || ((k.g.b) this.f130463b.g()).b() <= a16.f138307d) {
                    z16 = false;
                    if (!z16) {
                        f();
                        return;
                    }
                    try {
                        str = com.tencent.mm.plugin.appbrand.appcache.a.b(a16.f138315l);
                    } catch (FileNotFoundException unused) {
                        str = null;
                    }
                    if (Intrinsics.areEqual(a16.f138309f, str)) {
                        if (!(str == null || str.length() == 0)) {
                            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.CommonPkgFetcher", "start(), pkg cached with LegacyMd5, invoke onSuccess, request=" + this.f130463b);
                            Function1 function1 = this.f130469h;
                            c cVar = c.f130491a;
                            k.d dVar = this.f130463b;
                            String str4 = a16.f138315l;
                            Intrinsics.checkNotNullExpressionValue(str4, "record.field_pkgPath");
                            function1.invoke(cVar.a(dVar, str4, a16.f138309f, a16.f138307d, k.f.CACHED));
                            return;
                        }
                    }
                    if (Intrinsics.areEqual(a16.f138311h, str)) {
                        if (!(str == null || str.length() == 0)) {
                            if (this.f130463b.b() && a0.a(a16.f138315l) > 0) {
                                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.CommonPkgFetcher", "start(), pkg cached with NewMd5, but forceNoEncrypt, waitForDownload instead, request=" + this.f130463b);
                                f();
                                return;
                            }
                            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.CommonPkgFetcher", "start(), pkg cached with NewMd5, invoke onSuccess, request=" + this.f130463b);
                            Function1 function12 = this.f130469h;
                            c cVar2 = c.f130491a;
                            k.d dVar2 = this.f130463b;
                            String str5 = a16.f138315l;
                            Intrinsics.checkNotNullExpressionValue(str5, "record.field_pkgPath");
                            function12.invoke(cVar2.a(dVar2, str5, a16.f138311h, a16.f138307d, k.f.CACHED));
                            return;
                        }
                    }
                    if (com.tencent.luggage.wxa.cp.x.d(a16.f138315l)) {
                        com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.CommonPkgFetcher", "start(), check existed pkg fileMd5(" + str + ")!=recordMd5(" + a16.f138309f + QbAddrData.DATA_SPLITER + a16.f138311h + "), request=" + this.f130463b);
                    }
                    k.e a17 = c.f130491a.a(d(), this.f130463b, a16);
                    if (a17 != null) {
                        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.CommonPkgFetcher", "start(), pkg cached by reuse logic, request=" + this.f130463b);
                        this.f130469h.invoke(a17);
                        return;
                    }
                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.CommonPkgFetcher", "start(), no cached pkg, will download with request " + this.f130463b);
                    f();
                    return;
                }
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.CommonPkgFetcher", "LATEST(version:" + ((k.g.b) this.f130463b.g()).b() + " requested, > record.version(" + a16.f138307d + "))");
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f() {
        boolean contains;
        String str;
        k.g g16;
        boolean contains2;
        boolean contains3;
        l.a aVar = new l.a();
        aVar.a(this.f130463b.a());
        int e16 = this.f130463b.e();
        int[] WEAPP_CODE_PKG_INTEGRATED_PACKAGE_TYPES = com.tencent.luggage.wxa.ip.a.f130735e;
        Intrinsics.checkNotNullExpressionValue(WEAPP_CODE_PKG_INTEGRATED_PACKAGE_TYPES, "WEAPP_CODE_PKG_INTEGRATED_PACKAGE_TYPES");
        contains = ArraysKt___ArraysKt.contains(WEAPP_CODE_PKG_INTEGRATED_PACKAGE_TYPES, e16);
        if (!contains) {
            int[] PLUGINCODE_PACKAGE_TYPES = com.tencent.luggage.wxa.ip.a.f130734d;
            Intrinsics.checkNotNullExpressionValue(PLUGINCODE_PACKAGE_TYPES, "PLUGINCODE_PACKAGE_TYPES");
            contains3 = ArraysKt___ArraysKt.contains(PLUGINCODE_PACKAGE_TYPES, e16);
            if (!contains3) {
                str = this.f130463b.d();
                aVar.b(str);
                aVar.b(this.f130463b.e());
                aVar.d(this.f130463b.h());
                if (e.a.b(this.f130463b.h())) {
                    int[] PLUGINCODE_PACKAGE_TYPES2 = com.tencent.luggage.wxa.ip.a.f130734d;
                    Intrinsics.checkNotNullExpressionValue(PLUGINCODE_PACKAGE_TYPES2, "PLUGINCODE_PACKAGE_TYPES");
                    contains2 = ArraysKt___ArraysKt.contains(PLUGINCODE_PACKAGE_TYPES2, this.f130463b.e());
                    if (contains2 && !aVar.f() && (this.f130463b.g() instanceof k.g.c)) {
                        ((k.g.c) this.f130463b.g()).a();
                    }
                }
                aVar.c(!this.f130463b.b() ? 1 : 0);
                g16 = this.f130463b.g();
                if (!(g16 instanceof k.g.c)) {
                    aVar.a(((k.g.c) g16).a());
                } else if (g16 instanceof k.g.b) {
                    aVar.a(((k.g.b) g16).b());
                    aVar.a(true);
                } else if (g16 instanceof k.g.a) {
                    aVar.a(0);
                    aVar.c(((k.g.a) g16).a());
                }
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.CommonPkgFetcher", "waitForDownloadUrl " + aVar);
                this.f130465d.a(aVar, new g(aVar), new h(), this.f130466e, this.f130467f);
            }
        }
        str = null;
        aVar.b(str);
        aVar.b(this.f130463b.e());
        aVar.d(this.f130463b.h());
        if (e.a.b(this.f130463b.h())) {
        }
        aVar.c(!this.f130463b.b() ? 1 : 0);
        g16 = this.f130463b.g();
        if (!(g16 instanceof k.g.c)) {
        }
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.CommonPkgFetcher", "waitForDownloadUrl " + aVar);
        this.f130465d.a(aVar, new g(aVar), new h(), this.f130466e, this.f130467f);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public static final c f130491a = new c();

        public final k.e a(com.tencent.luggage.wxa.mc.o storage, k.d request, com.tencent.luggage.wxa.mc.d record) {
            Intrinsics.checkNotNullParameter(storage, "storage");
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(record, "record");
            request.c();
            if (!(request.g() instanceof k.g.c) || !(record instanceof h0) || !com.tencent.luggage.wxa.mc.y.f134408a.a((h0) record)) {
                return null;
            }
            String str = record.f138315l;
            Intrinsics.checkNotNullExpressionValue(str, "record.field_pkgPath");
            return a(request, str, null, ((k.g.c) request.g()).a(), k.f.CACHED);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final k.e a(k.d request, String wxaPkgFilePath, String str, int i3, k.f source) {
            boolean contains;
            ModulePkgInfo modulePkgInfo;
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(wxaPkgFilePath, "wxaPkgFilePath");
            Intrinsics.checkNotNullParameter(source, "source");
            int[] PLUGINCODE_PACKAGE_TYPES = com.tencent.luggage.wxa.ip.a.f130734d;
            Intrinsics.checkNotNullExpressionValue(PLUGINCODE_PACKAGE_TYPES, "PLUGINCODE_PACKAGE_TYPES");
            contains = ArraysKt___ArraysKt.contains(PLUGINCODE_PACKAGE_TYPES, request.e());
            if (contains) {
                WxaPluginPkgInfo wxaPluginPkgInfo = new WxaPluginPkgInfo();
                wxaPluginPkgInfo.pkgPath = wxaPkgFilePath;
                wxaPluginPkgInfo.provider = request.a();
                wxaPluginPkgInfo.version = i3;
                if (str == null || str.length() == 0) {
                    str = f0.f134289a.a(wxaPkgFilePath);
                }
                wxaPluginPkgInfo.md5 = str;
                wxaPluginPkgInfo.stringVersion = j0.a().a(wxaPluginPkgInfo.provider, wxaPluginPkgInfo.version);
                modulePkgInfo = wxaPluginPkgInfo;
            } else {
                ModulePkgInfo modulePkgInfo2 = new ModulePkgInfo();
                modulePkgInfo2.pkgPath = wxaPkgFilePath;
                modulePkgInfo2.name = request.d();
                if (str == null || str.length() == 0) {
                    str = f0.f134289a.a(wxaPkgFilePath);
                }
                modulePkgInfo2.md5 = str;
                modulePkgInfo2.pkgVersion = i3;
                modulePkgInfo = modulePkgInfo2;
            }
            return new k.e(modulePkgInfo, source);
        }
    }

    @Override // com.tencent.luggage.wxa.ii.k
    public long a() {
        return this.f130476o;
    }
}
