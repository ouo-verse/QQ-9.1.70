package com.tencent.luggage.wxa.p004if;

import com.tencent.luggage.wxa.p004if.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class h implements r.a {

    /* renamed from: a, reason: collision with root package name */
    public final r f130203a;

    /* renamed from: b, reason: collision with root package name */
    public final r f130204b;

    public h(r ifNotNavigateStrategy, r ifNotOpenNativeStrategy) {
        Intrinsics.checkNotNullParameter(ifNotNavigateStrategy, "ifNotNavigateStrategy");
        Intrinsics.checkNotNullParameter(ifNotOpenNativeStrategy, "ifNotOpenNativeStrategy");
        this.f130203a = ifNotNavigateStrategy;
        this.f130204b = ifNotOpenNativeStrategy;
    }

    @Override // com.tencent.luggage.wxa.if.r.a
    public r a(boolean z16, boolean z17) {
        r rVar = c.f130179a;
        if (!z16) {
            rVar = rVar.a(this.f130203a);
        }
        if (!z17) {
            return rVar.a(this.f130204b);
        }
        return rVar;
    }

    public /* synthetic */ h(r rVar, r rVar2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? d.f130190a : rVar, (i3 & 2) != 0 ? f.f130200a : rVar2);
    }
}
