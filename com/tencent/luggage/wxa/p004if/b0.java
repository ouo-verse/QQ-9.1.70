package com.tencent.luggage.wxa.p004if;

import com.tencent.luggage.wxa.ic.g;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.p004if.o;
import com.tencent.luggage.wxa.p004if.p;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.d;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b0 implements o {

    /* renamed from: e, reason: collision with root package name */
    public static final a f130171e = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final p.a f130172a;

    /* renamed from: b, reason: collision with root package name */
    public final String f130173b;

    /* renamed from: c, reason: collision with root package name */
    public final Lazy f130174c;

    /* renamed from: d, reason: collision with root package name */
    public volatile p.b f130175d;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements o.a {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.if.b0$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6303a extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Function0 f130176a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C6303a(Function0 function0) {
                super(0);
                this.f130176a = function0;
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final g invoke() {
                v vVar;
                d dVar = (d) this.f130176a.invoke();
                if (dVar == null) {
                    a aVar = b0.f130171e;
                    w.b("MicroMsg.AppBrand.WxaAudioFocusComponent", "runtimeProvider, hostComponent is null");
                    return null;
                }
                if (dVar instanceof v) {
                    vVar = (v) dVar;
                } else if (dVar instanceof l) {
                    vVar = ((l) dVar).J();
                } else {
                    vVar = null;
                }
                if (vVar == null) {
                    a aVar2 = b0.f130171e;
                    w.b("MicroMsg.AppBrand.WxaAudioFocusComponent", "runtimeProvider, pageView is null");
                    return null;
                }
                return vVar.getRuntime();
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // com.tencent.luggage.wxa.if.o.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b0 a(Function0 hostProvider, p.a aVar) {
            Intrinsics.checkNotNullParameter(hostProvider, "hostProvider");
            return new b0(new C6303a(hostProvider), aVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f130177a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b0 f130178b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Function0 function0, b0 b0Var) {
            super(0);
            this.f130177a = function0;
            this.f130178b = b0Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final p invoke() {
            g gVar = (g) this.f130177a.invoke();
            if (gVar == null) {
                w.b(this.f130178b.f130173b, "service#get, runtime is null ");
                return null;
            }
            return com.tencent.luggage.wxa.p004if.a.f130164b.a(gVar);
        }
    }

    public b0(Function0 runtimeProvider, p.a aVar) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(runtimeProvider, "runtimeProvider");
        this.f130172a = aVar;
        this.f130173b = "MicroMsg.AppBrand.WxaAudioFocusComponent#" + hashCode();
        lazy = LazyKt__LazyJVMKt.lazy(new b(runtimeProvider, this));
        this.f130174c = lazy;
    }

    @Override // com.tencent.luggage.wxa.p004if.o
    public boolean b() {
        if (d() == null) {
            w.b(this.f130173b, "requestFocus, service is null");
            return false;
        }
        p d16 = d();
        Intrinsics.checkNotNull(d16);
        p.b a16 = d16.a(c());
        boolean a17 = a16.a();
        w.d(this.f130173b, "requestFocus, gainFocus: " + a17);
        if (a17) {
            this.f130175d = a16;
        }
        return a17;
    }

    public p.a c() {
        return this.f130172a;
    }

    public final p d() {
        return (p) this.f130174c.getValue();
    }

    @Override // com.tencent.luggage.wxa.p004if.o
    public boolean a() {
        if (d() == null) {
            w.b(this.f130173b, "abandonFocus, service is null");
            return false;
        }
        p.b bVar = this.f130175d;
        if (bVar == null) {
            return false;
        }
        p d16 = d();
        Intrinsics.checkNotNull(d16);
        boolean a16 = d16.a(bVar);
        w.d(this.f130173b, "abandonFocus, abandoned: " + a16);
        if (a16) {
            this.f130175d = null;
        }
        return a16;
    }
}
