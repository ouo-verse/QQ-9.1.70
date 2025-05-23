package com.tencent.luggage.wxa.y1;

import com.tencent.luggage.wxa.jg.d;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class a extends d {

    /* renamed from: e, reason: collision with root package name */
    public static final b f145411e = new b(null);

    /* renamed from: f, reason: collision with root package name */
    public static final Lazy f145412f;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.y1.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C6932a extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final C6932a f145413a = new C6932a();

        public C6932a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxa.y1.b invoke() {
            return new com.tencent.luggage.wxa.y1.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final com.tencent.luggage.wxa.y1.b a() {
            return (com.tencent.luggage.wxa.y1.b) a.f145412f.getValue();
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(C6932a.f145413a);
        f145412f = lazy;
    }

    @Override // com.tencent.luggage.wxa.jg.d, com.tencent.luggage.wxa.jg.c
    public Map a(String type, com.tencent.luggage.wxa.r4.d component) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(component, "component");
        b bVar = f145411e;
        Map a16 = Intrinsics.areEqual(bVar.a().a(), type) ? bVar.a().a(type, (com.tencent.luggage.wxa.ic.d) component) : null;
        return a16 == null ? super.a(type, (com.tencent.luggage.wxa.ic.d) component) : a16;
    }
}
