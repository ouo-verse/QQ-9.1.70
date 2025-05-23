package com.tencent.luggage.wxa.p7;

import com.tencent.luggage.wxa.ka.o;
import com.tencent.luggage.wxa.ka.r;
import com.tencent.luggage.wxa.p7.c;
import com.tencent.luggage.wxa.tn.f0;
import com.tencent.luggage.wxa.tn.z;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class k extends com.tencent.luggage.wxa.xn.d implements com.tencent.luggage.wxa.sc.b {

    /* renamed from: c, reason: collision with root package name */
    public static final k f137393c = new k();

    /* renamed from: d, reason: collision with root package name */
    public static final Lazy f137394d;

    /* renamed from: e, reason: collision with root package name */
    public static Function2 f137395e;

    /* renamed from: f, reason: collision with root package name */
    public static Function2 f137396f;

    /* renamed from: g, reason: collision with root package name */
    public static Function0 f137397g;

    /* renamed from: h, reason: collision with root package name */
    public static Function1 f137398h;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/luggage/wxa/p7/d;", "data", "Lcom/tencent/luggage/wxa/va/b;", "kotlin.jvm.PlatformType", "a", "(Lcom/tencent/luggage/wxa/p7/d;)Lcom/tencent/luggage/wxa/va/b;"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes8.dex */
    public static final class a<InputType, ResultType> implements r {

        /* renamed from: a, reason: collision with root package name */
        public static final a f137399a = new a();

        @Override // com.tencent.luggage.wxa.ka.r
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxa.va.b invoke(com.tencent.luggage.wxa.p7.d dVar) {
            return new com.tencent.luggage.wxa.va.b(com.tencent.luggage.wxa.p7.e.f137382a.a(dVar));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends Lambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        public static final b f137400a = new b();

        public b() {
            super(2);
        }

        public final Boolean a(String username, int i3) {
            Intrinsics.checkNotNullParameter(username, "username");
            h hVar = (h) com.tencent.luggage.wxa.c6.b.a(h.class);
            if (hVar == null) {
                return Boolean.FALSE;
            }
            if (!hVar.b(com.tencent.luggage.wxa.p7.g.a(username, i3), new String[0])) {
                return Boolean.valueOf(hVar.a(com.tencent.luggage.wxa.p7.g.a(username, i3)));
            }
            return Boolean.FALSE;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a((String) obj, ((Number) obj2).intValue());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final c f137401a = new c();

        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final f0 invoke() {
            return f0.e("wxaCollectionConfig.cfg");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d extends Lambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        public static final d f137402a = new d();

        public d() {
            super(2);
        }

        public final Boolean a(String username, int i3) {
            Intrinsics.checkNotNullParameter(username, "username");
            h hVar = (h) com.tencent.luggage.wxa.c6.b.a(h.class);
            if (hVar == null) {
                return Boolean.FALSE;
            }
            return Boolean.valueOf(hVar.a(com.tencent.luggage.wxa.p7.g.a(username, i3), new String[0]));
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a((String) obj, ((Number) obj2).intValue());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final e f137403a = new e();

        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke() {
            return Integer.valueOf(k.f137393c.e().getInt("current_collection_count ", 0));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/luggage/wxa/p7/d;", "data", "Lcom/tencent/luggage/wxa/va/a;", "kotlin.jvm.PlatformType", "a", "(Lcom/tencent/luggage/wxa/p7/d;)Lcom/tencent/luggage/wxa/va/a;"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes8.dex */
    public static final class f<InputType, ResultType> implements r {

        /* renamed from: a, reason: collision with root package name */
        public static final f f137404a = new f();

        @Override // com.tencent.luggage.wxa.ka.r
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxa.va.a invoke(com.tencent.luggage.wxa.p7.d dVar) {
            return new com.tencent.luggage.wxa.va.a(com.tencent.luggage.wxa.p7.f.f137383a.a(dVar));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public static final g f137405a = new g();

        public g() {
            super(1);
        }

        public final void a(int i3) {
            k.f137393c.e().putInt("current_collection_count ", i3);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((Number) obj).intValue());
            return Unit.INSTANCE;
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(c.f137401a);
        f137394d = lazy;
        f137395e = b.f137400a;
        f137396f = d.f137402a;
        f137397g = e.f137403a;
        f137398h = g.f137405a;
    }

    @Override // com.tencent.luggage.wxa.sc.b
    public int C() {
        return 50;
    }

    @Override // com.tencent.luggage.wxa.sc.b
    public int b(String str, int i3) {
        boolean z16;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return -1;
        }
        try {
            com.tencent.luggage.wxa.va.b bVar = (com.tencent.luggage.wxa.va.b) o.a(z.g(), new com.tencent.luggage.wxa.p7.d(str, i3), a.f137399a.getClass());
            if (bVar == null) {
                return -1;
            }
            return bVar.f143313a;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public Function2 d() {
        return f137395e;
    }

    public final f0 e() {
        return (f0) f137394d.getValue();
    }

    public Function2 h() {
        return f137396f;
    }

    public Function0 j() {
        return f137397g;
    }

    public Function1 l() {
        return f137398h;
    }

    @Override // com.tencent.luggage.wxa.sc.b
    public boolean a(String str, int i3) {
        if (str != null && z.d(z.g())) {
            return ((com.tencent.luggage.wxa.va.a) o.a(z.g(), new c.a(str, i3), com.tencent.luggage.wxa.p7.c.class)).f143312a;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.sc.b
    public boolean d(String str, int i3) {
        if (str == null || str.length() == 0) {
            return false;
        }
        try {
            com.tencent.luggage.wxa.va.a aVar = (com.tencent.luggage.wxa.va.a) o.a(z.g(), new com.tencent.luggage.wxa.p7.d(str, i3), f.f137404a.getClass());
            if (aVar != null) {
                return aVar.f143312a;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }
}
