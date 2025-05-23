package com.tencent.luggage.wxa.p004if;

import com.tencent.luggage.wxa.ic.e;
import com.tencent.luggage.wxa.xd.d;
import kotlin.jvm.internal.Intrinsics;
import t21.a;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c implements r {

    /* renamed from: a, reason: collision with root package name */
    public static final c f130179a = new c();

    @Override // com.tencent.luggage.wxa.p004if.r
    public /* synthetic */ r a(r rVar) {
        return a.a(this, rVar);
    }

    public String toString() {
        return "AutoPauseDefaultStrategy";
    }

    @Override // com.tencent.luggage.wxa.p004if.r
    public boolean a(d dVar, e.d appPauseType) {
        Intrinsics.checkNotNullParameter(appPauseType, "appPauseType");
        return true;
    }
}
