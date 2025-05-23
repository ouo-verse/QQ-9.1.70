package com.tencent.luggage.wxa.b7;

import com.tencent.luggage.wxa.c3.j;
import com.tencent.luggage.wxa.ic.d;
import com.tencent.luggage.wxa.q7.q;
import com.tencent.luggage.wxa.v3.h;
import com.tencent.luggage.wxaapi.WxaAppCustomActionSheetDelegate;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b extends h {
    public static final int CTRL_INDEX = 800;

    @NotNull
    public static final String NAME = "addToFavorites";

    /* renamed from: b, reason: collision with root package name */
    public static final a f121896b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final j f121897a = new j();

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
    /* renamed from: com.tencent.luggage.wxa.b7.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6035b implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f121898b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f121899c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f121900d;

        public C6035b(d dVar, JSONObject jSONObject, int i3) {
            this.f121898b = dVar;
            this.f121899c = jSONObject;
            this.f121900d = i3;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String call(Void r46) {
            return h.a(this.f121898b, b.NAME, this.f121899c, this.f121900d).toString();
        }
    }

    @Override // com.tencent.luggage.wxa.v3.h, com.tencent.luggage.wxa.xd.a
    /* renamed from: a */
    public void invoke(d dVar, JSONObject jSONObject, int i3) {
        if (q.f138021a.a(WxaAppCustomActionSheetDelegate.ActionType.onAddToFavorites, this, dVar, jSONObject, i3)) {
            return;
        }
        super.invoke(dVar, jSONObject, i3);
    }

    @Override // com.tencent.luggage.wxa.v3.h
    public com.tencent.luggage.wxa.xo.d c(d dVar, JSONObject jSONObject, int i3) {
        if (dVar == null) {
            com.tencent.luggage.wxa.xo.d c16 = super.c(dVar, jSONObject, i3);
            Intrinsics.checkNotNullExpressionValue(c16, "super.processParams(env, args, callbackId)");
            return c16;
        }
        if (jSONObject == null) {
            com.tencent.luggage.wxa.xo.d c17 = super.c(dVar, jSONObject, i3);
            Intrinsics.checkNotNullExpressionValue(c17, "super.processParams(env, args, callbackId)");
            return c17;
        }
        com.tencent.luggage.wxa.xo.d b16 = this.f121897a.b(dVar, jSONObject).b(new C6035b(dVar, jSONObject, i3));
        Intrinsics.checkNotNullExpressionValue(b16, "env: AppBrandComponentWx\u2026.toString()\n            }");
        return b16;
    }
}
