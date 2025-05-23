package com.tencent.luggage.wxa.nf;

import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.yi.x;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d extends com.tencent.luggage.wxa.xd.a {
    private static final int CTRL_INDEX = -2;

    @NotNull
    private static final String NAME = "bindSocketToNetwork";

    /* renamed from: a, reason: collision with root package name */
    public static final a f135773a = new a(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements x.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f135774a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f135775b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d f135776c;

        public b(com.tencent.luggage.wxa.xd.d dVar, int i3, d dVar2) {
            this.f135774a = dVar;
            this.f135775b = i3;
            this.f135776c = dVar2;
        }

        @Override // com.tencent.luggage.wxa.yi.x.a
        public final void a(boolean z16) {
            com.tencent.luggage.wxa.af.c cVar;
            w.d("MicroMsg.JsApiBindSocketToNetwork", "invoke, success: " + z16);
            com.tencent.luggage.wxa.xd.d dVar = this.f135774a;
            int i3 = this.f135775b;
            d dVar2 = this.f135776c;
            if (z16) {
                cVar = com.tencent.luggage.wxa.af.e.f121305a;
            } else {
                cVar = com.tencent.luggage.wxa.af.e.f121309e;
            }
            dVar.a(i3, dVar2.makeReturnJson(cVar));
        }
    }

    public final boolean a(int i3) {
        if (i3 >= 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        if (dVar == null) {
            return;
        }
        if (jSONObject == null) {
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121315k));
            return;
        }
        w.d("MicroMsg.JsApiBindSocketToNetwork", "invoke, data: " + jSONObject);
        if (!Intrinsics.areEqual("wifi", jSONObject.optString(DKEngine.GlobalKey.NET_WORK_TYPE))) {
            w.b("MicroMsg.JsApiBindSocketToNetwork", "invoke, not bind to wifi is denied now");
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121315k));
            return;
        }
        int optInt = jSONObject.optInt("socketFd", -1);
        if (!a(optInt)) {
            w.b("MicroMsg.JsApiBindSocketToNetwork", "invoke, socketFd is invalid");
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121315k));
        } else {
            x.f145976a.a(optInt, new b(dVar, i3, this));
        }
    }
}
