package com.tencent.luggage.wxa.o1;

import android.app.Activity;
import com.tencent.luggage.wxa.c5.e;
import com.tencent.luggage.wxa.fd.i;
import com.tencent.luggage.wxa.i3.n;
import com.tencent.luggage.wxa.i3.t;
import com.tencent.luggage.wxa.ic.c0;
import com.tencent.luggage.wxa.ic.h;
import com.tencent.luggage.wxa.j4.d;
import com.tencent.luggage.wxa.v4.f;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f136081a = new c();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements f {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f136082a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i f136083b;

        public a(e eVar, i iVar) {
            this.f136082a = eVar;
            this.f136083b = iVar;
        }

        @Override // com.tencent.luggage.wxa.v4.f
        public final void a(c0 c0Var) {
            h.f129837a.a(this.f136082a, (d) this.f136083b, c0Var);
        }
    }

    public static final boolean a(e from, i iVar) {
        d dVar;
        boolean z16;
        Intrinsics.checkNotNullParameter(from, "from");
        if (!from.S().l()) {
            return false;
        }
        if (iVar instanceof d) {
            dVar = (d) iVar;
        } else {
            dVar = null;
        }
        if (dVar != null && dVar.l()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 || com.tencent.luggage.wxa.td.c.A.a()) {
            return false;
        }
        d dVar2 = (d) iVar;
        dVar2.f130801m0 = com.tencent.luggage.wxa.v4.e.a(new a(from, iVar));
        Activity L = from.L();
        com.tencent.luggage.wxa.d6.b bVar = new com.tencent.luggage.wxa.d6.b();
        bVar.f124086d = dVar2.f125808a;
        bVar.f124090h = dVar2.f125811d;
        bVar.f124089g = dVar2.f125813f;
        bVar.f124098p = true;
        String thirdPartyHostExtraData = from.S().f130793e0;
        if (thirdPartyHostExtraData != null) {
            Intrinsics.checkNotNullExpressionValue(thirdPartyHostExtraData, "thirdPartyHostExtraData");
            bVar.f124100r = new n(thirdPartyHostExtraData, true).c();
        }
        t.a(L, bVar, dVar2.i(), dVar2, true);
        return true;
    }
}
