package com.tencent.luggage.wxa.p004if;

import com.tencent.luggage.wxa.ic.e;
import kotlin.jvm.internal.Intrinsics;
import t21.a;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d implements r {

    /* renamed from: a, reason: collision with root package name */
    public static final d f130190a = new d();

    @Override // com.tencent.luggage.wxa.p004if.r
    public /* synthetic */ r a(r rVar) {
        return a.a(this, rVar);
    }

    public String toString() {
        return "AutoPauseIfNotNavigateStrategy";
    }

    @Override // com.tencent.luggage.wxa.p004if.r
    public boolean a(com.tencent.luggage.wxa.xd.d dVar, e.d appPauseType) {
        Intrinsics.checkNotNullParameter(appPauseType, "appPauseType");
        return e.d.HIDE != appPauseType;
    }
}
