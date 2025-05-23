package com.tencent.luggage.wxa.i3;

import android.content.Context;
import com.tencent.luggage.ui.WxaLaunchProxyActivity;
import com.tencent.luggage.wxa.tn.h0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class t {

    /* renamed from: a */
    public static final t f129355a = new t();

    /* renamed from: b */
    public static final String f129356b = "Luggage.WxaLaunchLogic";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Lambda implements Function0 {

        /* renamed from: a */
        public final /* synthetic */ Context f129357a;

        /* renamed from: b */
        public final /* synthetic */ com.tencent.luggage.wxa.l3.j f129358b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, com.tencent.luggage.wxa.l3.j jVar) {
            super(0);
            this.f129357a = context;
            this.f129358b = jVar;
        }

        public final void a() {
            Context context = this.f129357a;
            if (context == null) {
                context = com.tencent.luggage.wxa.tn.z.c();
            }
            Context nonNullContext = context;
            com.tencent.luggage.wxa.l3.h a16 = t.f129355a.a();
            Intrinsics.checkNotNullExpressionValue(nonNullContext, "nonNullContext");
            com.tencent.luggage.wxa.z4.f.a(a16, nonNullContext, this.f129358b, (com.tencent.luggage.wxa.tk.i) null, (Function1) null, 12, (Object) null);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    public static final void a(Context context, com.tencent.luggage.wxa.d6.b action) {
        Intrinsics.checkNotNullParameter(action, "action");
        a(context, action, null, null, false, 28, null);
    }

    public final com.tencent.luggage.wxa.l3.h a() {
        return com.tencent.luggage.wxa.l3.h.f132999i.a();
    }

    public static /* synthetic */ void a(Context context, com.tencent.luggage.wxa.d6.b bVar, com.tencent.luggage.wxa.bk.e eVar, com.tencent.luggage.wxa.j4.d dVar, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            eVar = null;
        }
        if ((i3 & 8) != 0) {
            dVar = null;
        }
        if ((i3 & 16) != 0) {
            z16 = false;
        }
        a(context, bVar, eVar, dVar, z16);
    }

    public static final void a(Context context, com.tencent.luggage.wxa.d6.b action, com.tencent.luggage.wxa.bk.e eVar, com.tencent.luggage.wxa.j4.d dVar, boolean z16) {
        com.tencent.luggage.wxa.l3.j jVar;
        String e16;
        Intrinsics.checkNotNullParameter(action, "action");
        if (dVar == null) {
            com.tencent.luggage.wxa.j4.d a16 = com.tencent.luggage.wxa.j4.o.f130858a.a();
            a16.f125808a = action.f124086d;
            a16.f125811d = action.f124090h;
            a16.f130795g0 = action.f124098p;
            a16.f130793e0 = action.f124100r;
            if (com.tencent.luggage.wxa.tn.z.m() && (e16 = f129355a.a().e(a16.f125808a, a16.d())) != null) {
                a16.a(e16);
            }
            jVar = new com.tencent.luggage.wxa.l3.j(action, a16, eVar, null, null, null, z16, false, 184, null);
        } else {
            jVar = new com.tencent.luggage.wxa.l3.j(action, dVar, eVar, null, null, null, z16, true, 56, null);
        }
        a(context, jVar);
    }

    public static final void a(Context context, com.tencent.luggage.wxa.l3.j startParams) {
        Intrinsics.checkNotNullParameter(startParams, "startParams");
        if (!com.tencent.luggage.wxa.q6.a.f137864a.c(startParams.a())) {
            com.tencent.luggage.wxa.gi.b.b(com.tencent.luggage.wxa.ik.a.class, startParams.a());
            com.tencent.luggage.wxa.gi.b.a(com.tencent.luggage.wxa.ik.a.class, startParams.a(), "Network:" + h0.e(com.tencent.luggage.wxa.tn.z.c()));
        }
        if (com.tencent.luggage.wxa.tn.z.m()) {
            com.tencent.luggage.wxa.rn.a.a(new a(context, startParams));
        } else {
            WxaLaunchProxyActivity.INSTANCE.a(context, startParams);
        }
    }
}
