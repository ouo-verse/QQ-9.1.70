package com.tencent.luggage.wxa.p004if;

import com.tencent.luggage.wxa.ic.e;
import com.tencent.luggage.wxa.xd.d;
import kotlin.jvm.internal.Intrinsics;
import t21.a;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b implements r {

    /* renamed from: a, reason: collision with root package name */
    public final r f130169a;

    /* renamed from: b, reason: collision with root package name */
    public final r f130170b;

    public b(r left, r right) {
        Intrinsics.checkNotNullParameter(left, "left");
        Intrinsics.checkNotNullParameter(right, "right");
        this.f130169a = left;
        this.f130170b = right;
    }

    @Override // com.tencent.luggage.wxa.p004if.r
    public /* synthetic */ r a(r rVar) {
        return a.a(this, rVar);
    }

    public String toString() {
        return "AutoPauseCombinedStrategy(left=" + this.f130169a + ", right=" + this.f130170b + ')';
    }

    @Override // com.tencent.luggage.wxa.p004if.r
    public boolean a(d dVar, e.d appPauseType) {
        Intrinsics.checkNotNullParameter(appPauseType, "appPauseType");
        return this.f130169a.a(dVar, appPauseType) && this.f130170b.a(dVar, appPauseType);
    }
}
