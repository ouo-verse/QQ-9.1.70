package com.tencent.luggage.wxa.ae;

import com.tencent.luggage.wxa.tn.w;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class j {

    /* renamed from: e, reason: collision with root package name */
    public static final a f121087e = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f121088a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f121089b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f121090c;

    /* renamed from: d, reason: collision with root package name */
    public final Lazy f121091d;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final b f121092a = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxa.zj.d invoke() {
            return (com.tencent.luggage.wxa.zj.d) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.d.class);
        }
    }

    public j(String scope) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.f121088a = scope;
        lazy = LazyKt__LazyJVMKt.lazy(b.f121092a);
        this.f121091d = lazy;
    }

    public final com.tencent.luggage.wxa.zj.d a() {
        Object value = this.f121091d.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-kvReporter>(...)");
        return (com.tencent.luggage.wxa.zj.d) value;
    }

    public final void b() {
        this.f121090c = true;
    }

    public final void c() {
        this.f121089b = true;
    }

    public final void a(boolean z16, int i3) {
        a().a(24877, this.f121088a, Integer.valueOf(this.f121089b ? 1 : 0), Integer.valueOf(z16 ? 1 : 0), Integer.valueOf(this.f121090c ? 1 : 0), Integer.valueOf(i3));
        w.d("MicroMsg.AuthorizeReport", "scope=" + this.f121088a + ", userUserAgreementVisible=" + this.f121089b + ", userUserAgreementChecked=" + z16 + ",  hadTriggerUserUserAgreementAlert=" + this.f121090c + ", action=" + i3);
    }
}
