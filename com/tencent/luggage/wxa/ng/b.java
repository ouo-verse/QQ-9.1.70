package com.tencent.luggage.wxa.ng;

import com.tencent.luggage.wxa.p004if.o;
import com.tencent.luggage.wxa.p004if.p;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b implements o {

    /* renamed from: b, reason: collision with root package name */
    public static final a f135811b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final Lazy f135812a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements o.a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // com.tencent.luggage.wxa.if.o.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a(Function0 hostProvider, p.a aVar) {
            Intrinsics.checkNotNullParameter(hostProvider, "hostProvider");
            return new b();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ng.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6513b extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final C6513b f135813a = new C6513b();

        public C6513b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxa.ng.a invoke() {
            return com.tencent.luggage.wxa.ng.a.b();
        }
    }

    public b() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(C6513b.f135813a);
        this.f135812a = lazy;
    }

    @Override // com.tencent.luggage.wxa.p004if.o
    public boolean a() {
        return c().a();
    }

    @Override // com.tencent.luggage.wxa.p004if.o
    public boolean b() {
        return c().c();
    }

    public final com.tencent.luggage.wxa.ng.a c() {
        return (com.tencent.luggage.wxa.ng.a) this.f135812a.getValue();
    }
}
