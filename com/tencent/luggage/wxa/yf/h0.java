package com.tencent.luggage.wxa.yf;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class h0 extends com.tencent.luggage.wxa.xd.a {
    private static final int CTRL_INDEX = 1066;

    @NotNull
    private static final String NAME = "setVisualEffectOnCapture";

    /* renamed from: a, reason: collision with root package name */
    public static final a f145695a = new a(null);

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.uk.j0 f145696a;

        public b(com.tencent.luggage.wxa.uk.j0 j0Var) {
            this.f145696a = j0Var;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f145696a.c();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.uk.j0 f145697a;

        public c(com.tencent.luggage.wxa.uk.j0 j0Var) {
            this.f145697a = j0Var;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f145697a.a();
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.ic.d dVar, JSONObject jSONObject, int i3) {
        String str;
        if (dVar == null) {
            return;
        }
        if (jSONObject != null) {
            str = jSONObject.optString("visualEffect", "none");
        } else {
            str = null;
        }
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.JsApiSetVisualEffectOnCapture", "invoke, visualEffect: " + str);
        com.tencent.luggage.wxa.uk.j0 a16 = com.tencent.luggage.wxa.uk.j0.f142737e.a(dVar);
        if (a16 == null) {
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121309e));
            return;
        }
        if (Intrinsics.areEqual(str, "hidden")) {
            com.tencent.luggage.wxa.zp.h.f146825d.a(new b(a16));
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a));
        } else if (Intrinsics.areEqual(str, "none")) {
            com.tencent.luggage.wxa.zp.h.f146825d.a(new c(a16));
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a));
        } else {
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121315k));
        }
    }
}
