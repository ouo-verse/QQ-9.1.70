package com.tencent.luggage.wxa.hg;

import com.tencent.luggage.wxa.uk.c0;
import java.util.Map;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class m {

    /* renamed from: c, reason: collision with root package name */
    public static final a f127139c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.af.c f127140a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f127141b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final m a(com.tencent.luggage.wxa.r4.d env, com.tencent.luggage.wxa.af.c errors, Map resultPack) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(errors, "errors");
            Intrinsics.checkNotNullParameter(resultPack, "resultPack");
            if (c0.b.FAIL_SIZE_EXCEED_LIMIT == c0.a(env.getJsRuntime(), resultPack, (c0.a) env.a(c0.a.class))) {
                return new m(new com.tencent.luggage.wxa.af.c(com.tencent.luggage.wxa.af.e.f121307c.f121277a, "fail:convert native buffer parameter fail. native buffer exceed size limit."), resultPack);
            }
            return new m(errors, resultPack);
        }
    }

    public m(com.tencent.luggage.wxa.af.c errors, Map resultPack) {
        Intrinsics.checkNotNullParameter(errors, "errors");
        Intrinsics.checkNotNullParameter(resultPack, "resultPack");
        this.f127140a = errors;
        this.f127141b = resultPack;
    }

    public final com.tencent.luggage.wxa.af.c a() {
        return this.f127140a;
    }

    public final Map b() {
        return this.f127141b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        if (Intrinsics.areEqual(this.f127140a, mVar.f127140a) && Intrinsics.areEqual(this.f127141b, mVar.f127141b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f127140a.hashCode() * 31) + this.f127141b.hashCode();
    }

    public String toString() {
        return "SmCryptoOperateResult(errors=" + this.f127140a + ", resultPack=" + this.f127141b + ')';
    }

    public /* synthetic */ m(com.tencent.luggage.wxa.af.c cVar, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(cVar, (i3 & 2) != 0 ? MapsKt__MapsKt.emptyMap() : map);
    }
}
