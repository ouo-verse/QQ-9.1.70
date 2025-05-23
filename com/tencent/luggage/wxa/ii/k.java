package com.tencent.luggage.wxa.ii;

import com.tencent.luggage.wxa.hn.k1;
import com.tencent.luggage.wxa.mc.g0;
import com.tenpay.proxy.dlg.location.QbAddrData;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface k {

    /* renamed from: a, reason: collision with root package name */
    public static final b f130516a = b.f130529a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum a {
        OK(0),
        FAILED(101),
        LOCAL_FILE_NOT_FOUND(102),
        PKG_INTEGRITY_FAILED(104),
        PKG_INVALID(105),
        SEVER_FILE_NOT_FOUND(106),
        DISK_FULL(110),
        PKG_RECORD_NULL(111),
        PKG_RECORD_INVALID(112),
        ENV_ERR(200);


        /* renamed from: a, reason: collision with root package name */
        public final int f130528a;

        a(int i3) {
            this.f130528a = i3;
        }

        public final int b() {
            return this.f130528a;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface c {
        void a(d dVar, int i3, String str);

        void a(d dVar, e eVar);

        void b(d dVar, e eVar);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements Comparable {

        /* renamed from: a, reason: collision with root package name */
        public final String f130533a;

        /* renamed from: b, reason: collision with root package name */
        public final String f130534b;

        /* renamed from: c, reason: collision with root package name */
        public final int f130535c;

        /* renamed from: d, reason: collision with root package name */
        public final int f130536d;

        /* renamed from: e, reason: collision with root package name */
        public final g f130537e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f130538f;

        /* renamed from: g, reason: collision with root package name */
        public final String f130539g;

        /* renamed from: h, reason: collision with root package name */
        public final Lazy f130540h;

        /* renamed from: i, reason: collision with root package name */
        public final Lazy f130541i;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends Lambda implements Function0 {
            public a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final com.tencent.luggage.wxa.mc.r invoke() {
                return new com.tencent.luggage.wxa.mc.r(d.this.a(), d.this.d(), d.this.e());
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b extends Lambda implements Function0 {
            public b() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final String invoke() {
                boolean z16;
                String str = d.this.f130539g;
                if (str != null && str.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    return d.this.f130539g;
                }
                return d.this.c().toString() + "|ver:" + d.this.g();
            }
        }

        public d(String appId, String str, int i3, int i16, g version, boolean z16, String str2) {
            Lazy lazy;
            Lazy lazy2;
            Intrinsics.checkNotNullParameter(appId, "appId");
            Intrinsics.checkNotNullParameter(version, "version");
            this.f130533a = appId;
            this.f130534b = str;
            this.f130535c = i3;
            this.f130536d = i16;
            this.f130537e = version;
            this.f130538f = z16;
            this.f130539g = str2;
            lazy = LazyKt__LazyJVMKt.lazy(new a());
            this.f130540h = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new b());
            this.f130541i = lazy2;
        }

        public final boolean b() {
            return this.f130538f;
        }

        public final com.tencent.luggage.wxa.mc.r c() {
            return (com.tencent.luggage.wxa.mc.r) this.f130540h.getValue();
        }

        public final String d() {
            return this.f130534b;
        }

        public final int e() {
            return this.f130535c;
        }

        public boolean equals(Object obj) {
            Class<?> cls;
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                cls = obj.getClass();
            } else {
                cls = null;
            }
            if (!Intrinsics.areEqual(d.class, cls)) {
                return false;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.launching.ICommonPkgFetcher.Request");
            return Intrinsics.areEqual(toString(), ((d) obj).toString());
        }

        public final String f() {
            return (String) this.f130541i.getValue();
        }

        public final g g() {
            return this.f130537e;
        }

        public final int h() {
            return this.f130536d;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            int hashCode2 = this.f130533a.hashCode() * 31;
            String str = this.f130534b;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int hashCode3 = (((((((hashCode2 + hashCode) * 31) + this.f130535c) * 31) + this.f130536d) * 31) + this.f130537e.hashCode()) * 31;
            boolean z16 = this.f130538f;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            int i17 = (hashCode3 + i16) * 31;
            String str2 = this.f130539g;
            if (str2 != null) {
                i3 = str2.hashCode();
            }
            return i17 + i3;
        }

        public String toString() {
            return "Request{ appId=" + this.f130533a + ", module_name=" + this.f130534b + ", package_type=" + this.f130535c + ", version_type=" + this.f130536d + " app_version=" + this.f130537e + " forceNoEncrypt=" + this.f130538f + '}';
        }

        public final String a() {
            return this.f130533a;
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x005f, code lost:
        
            if (((com.tencent.luggage.wxa.ii.k.g.c) r3.f130537e).a() == ((com.tencent.luggage.wxa.ii.k.g.c) r4.f130537e).a()) goto L18;
         */
        @Override // java.lang.Comparable
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int compareTo(d other) {
            Intrinsics.checkNotNullParameter(other, "other");
            if (Intrinsics.areEqual(this.f130533a, other.f130533a) && Intrinsics.areEqual(this.f130534b, other.f130534b) && this.f130535c == other.f130535c && this.f130536d == other.f130536d && Intrinsics.areEqual(this.f130537e.getClass(), other.f130537e.getClass()) && this.f130538f == other.f130538f) {
                if (this.f130537e instanceof g.c) {
                    g gVar = other.f130537e;
                    Intrinsics.checkNotNull(gVar, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.launching.ICommonPkgFetcher.VERSION.SPECIFIED");
                }
                return 0;
            }
            return toString().compareTo(other.toString());
        }

        public /* synthetic */ d(String str, String str2, int i3, int i16, g gVar, boolean z16, String str3, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, i3, i16, gVar, z16, (i17 & 64) != 0 ? null : str3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public final com.tencent.luggage.wxa.mc.j f130544a;

        /* renamed from: b, reason: collision with root package name */
        public final f f130545b;

        public e(com.tencent.luggage.wxa.mc.j pkgInfo, f source) {
            Intrinsics.checkNotNullParameter(pkgInfo, "pkgInfo");
            Intrinsics.checkNotNullParameter(source, "source");
            this.f130544a = pkgInfo;
            this.f130545b = source;
        }

        public final com.tencent.luggage.wxa.mc.j a() {
            return this.f130544a;
        }

        public final f b() {
            return this.f130545b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            if (Intrinsics.areEqual(this.f130544a, eVar.f130544a) && this.f130545b == eVar.f130545b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.f130544a.hashCode() * 31) + this.f130545b.hashCode();
        }

        public String toString() {
            return "Response(pkgInfo=" + this.f130544a + ", source=" + this.f130545b + ')';
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum f {
        CACHED,
        REMOTE
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static abstract class g {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends g {

            /* renamed from: a, reason: collision with root package name */
            public final String f130549a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String desc) {
                super(null);
                Intrinsics.checkNotNullParameter(desc, "desc");
                this.f130549a = desc;
            }

            public final String a() {
                return this.f130549a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof a) && Intrinsics.areEqual(this.f130549a, ((a) obj).f130549a)) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return this.f130549a.hashCode();
            }

            public String toString() {
                return "DESC(" + this.f130549a + ')';
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b extends g {

            /* renamed from: a, reason: collision with root package name */
            public final int f130550a;

            /* renamed from: b, reason: collision with root package name */
            public final boolean f130551b;

            public b(int i3, boolean z16) {
                super(null);
                this.f130550a = i3;
                this.f130551b = z16;
            }

            public final boolean a() {
                return this.f130551b;
            }

            public final int b() {
                return this.f130550a;
            }

            public final b c() {
                return new b(this.f130550a, true);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof b)) {
                    return false;
                }
                b bVar = (b) obj;
                if (this.f130550a == bVar.f130550a && this.f130551b == bVar.f130551b) {
                    return true;
                }
                return false;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                int i3 = this.f130550a * 31;
                boolean z16 = this.f130551b;
                int i16 = z16;
                if (z16 != 0) {
                    i16 = 1;
                }
                return i3 + i16;
            }

            public String toString() {
                return "LATEST(" + this.f130550a + "|forceUpdate:" + this.f130551b + ')';
            }

            public /* synthetic */ b(int i3, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
                this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? false : z16);
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class c extends g {

            /* renamed from: a, reason: collision with root package name */
            public final int f130552a;

            /* renamed from: b, reason: collision with root package name */
            public final long f130553b;

            public c(int i3, long j3) {
                super(null);
                this.f130552a = i3;
                this.f130553b = j3;
            }

            public final int a() {
                return this.f130552a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof c)) {
                    return false;
                }
                c cVar = (c) obj;
                if (this.f130552a == cVar.f130552a && this.f130553b == cVar.f130553b) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return (this.f130552a * 31) + androidx.fragment.app.a.a(this.f130553b);
            }

            public String toString() {
                StringBuilder sb5;
                if (this.f130553b >= 0) {
                    sb5 = new StringBuilder();
                    sb5.append("VERSION(");
                    sb5.append(this.f130552a);
                    sb5.append(QbAddrData.DATA_SPLITER);
                    sb5.append(this.f130553b);
                } else {
                    sb5 = new StringBuilder();
                    sb5.append("VERSION(");
                    sb5.append(this.f130552a);
                }
                sb5.append(')');
                return sb5.toString();
            }

            public /* synthetic */ c(int i3, long j3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
                this(i3, (i16 & 2) != 0 ? -1L : j3);
            }
        }

        public g() {
        }

        public /* synthetic */ g(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    long a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ b f130529a = new b();

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends Lambda implements Function1 {

            /* renamed from: a, reason: collision with root package name */
            public static final a f130530a = new a();

            public a() {
                super(1);
            }

            public final void a(g0 g0Var) {
                Intrinsics.checkNotNullParameter(g0Var, "<anonymous parameter 0>");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((g0) obj);
                return Unit.INSTANCE;
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.ii.k$b$b, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class RunnableC6314b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f130531a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.ii.e f130532b;

            public RunnableC6314b(d dVar, com.tencent.luggage.wxa.ii.e eVar) {
                this.f130531a = dVar;
                this.f130532b = eVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.luggage.wxa.tn.w.d("Luggage.ICommonPkgFetcher", "CommonPkgFetcher start request:" + this.f130531a + " requestId:" + this.f130531a.f());
                this.f130532b.e();
            }
        }

        public final k a(d request, Function1 onSuccess, Function2 onError, Function1 onProgress, l cgiExecutor, int i3, k1 cgiCommRequestSource, c cVar) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
            Intrinsics.checkNotNullParameter(onError, "onError");
            Intrinsics.checkNotNullParameter(onProgress, "onProgress");
            Intrinsics.checkNotNullParameter(cgiExecutor, "cgiExecutor");
            Intrinsics.checkNotNullParameter(cgiCommRequestSource, "cgiCommRequestSource");
            com.tencent.luggage.wxa.ii.e eVar = new com.tencent.luggage.wxa.ii.e(request, onSuccess, onError, onProgress, cgiExecutor, i3, cgiCommRequestSource, cVar);
            com.tencent.luggage.wxa.zp.h.f146825d.d(new RunnableC6314b(request, eVar), request.f());
            return eVar;
        }
    }
}
