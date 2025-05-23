package com.tencent.luggage.wxa.f7;

import com.tencent.luggage.wxa.n3.t;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.uk.o;
import com.tencent.luggage.wxa.x3.h;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f125455a = new f();

    /* renamed from: b, reason: collision with root package name */
    public static final Lazy f125456b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f125457a = new a();

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.f7.f$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6201a implements com.tencent.luggage.wxa.x3.g {

            /* renamed from: a, reason: collision with root package name */
            public h.c f125458a;

            @Override // com.tencent.luggage.wxa.x3.g
            public com.tencent.luggage.wxa.x3.h a() {
                t Z = com.tencent.luggage.wxa.x7.a.f144602d.Z();
                t tVar = null;
                if (Z == null) {
                    return null;
                }
                h.c cVar = this.f125458a;
                if (cVar != null) {
                    tVar = cVar.b();
                }
                if (Intrinsics.areEqual(tVar, Z)) {
                    return this.f125458a;
                }
                com.tencent.luggage.wxa.x3.h a16 = com.tencent.luggage.wxa.x3.h.f144573a.a(Z);
                Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.luggage.reporter.SmcKVReportSessionInterface.SessionAdapter");
                this.f125458a = (h.c) a16;
                return a16;
            }
        }

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxa.x3.a invoke() {
            boolean z16;
            boolean contains$default;
            String processName = z.i();
            Intrinsics.checkNotNullExpressionValue(processName, "processName");
            if (processName.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 && !z.m()) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) processName, (CharSequence) ":wxa_container", false, 2, (Object) null);
                if (contains$default) {
                    String g16 = z.g();
                    Intrinsics.checkNotNullExpressionValue(g16, "getMainProcessName()");
                    return new com.tencent.luggage.wxa.x3.f(g16);
                }
                return (com.tencent.luggage.wxa.x3.a) o.a("SmcReporter.Dummy", com.tencent.luggage.wxa.x3.a.class);
            }
            return new com.tencent.luggage.wxa.x3.e(new C6201a());
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(a.f125457a);
        f125456b = lazy;
    }

    public final com.tencent.luggage.wxa.x3.a a() {
        Object value = f125456b.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-REPORTER>(...)");
        return (com.tencent.luggage.wxa.x3.a) value;
    }
}
