package com.tencent.luggage.wxa.p004if;

import com.tencent.luggage.wxa.ic.e;
import com.tencent.luggage.wxa.ic.g;
import com.tencent.luggage.wxa.qc.b;
import com.tencent.luggage.wxa.qc.c;
import com.tencent.luggage.wxa.xd.d;
import kotlin.jvm.internal.Intrinsics;
import t21.a;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e implements r {

    /* renamed from: a, reason: collision with root package name */
    public static final e f130198a = new e();

    @Override // com.tencent.luggage.wxa.p004if.r
    public /* synthetic */ r a(r rVar) {
        return a.a(this, rVar);
    }

    public String toString() {
        return "AutoPauseIfNotNavigateStrategyLU";
    }

    @Override // com.tencent.luggage.wxa.p004if.r
    public boolean a(d dVar, e.d appPauseType) {
        g runtime;
        c c06;
        Intrinsics.checkNotNullParameter(appPauseType, "appPauseType");
        if (!d.f130190a.a(dVar, appPauseType)) {
            b bVar = b.FOREGROUND;
            b bVar2 = null;
            com.tencent.luggage.wxa.ic.d dVar2 = dVar instanceof com.tencent.luggage.wxa.ic.d ? (com.tencent.luggage.wxa.ic.d) dVar : null;
            if (dVar2 != null && (runtime = dVar2.getRuntime()) != null && (c06 = runtime.c0()) != null) {
                bVar2 = c06.b();
            }
            if (bVar == bVar2) {
                return false;
            }
        }
        return true;
    }
}
