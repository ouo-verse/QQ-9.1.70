package com.tencent.luggage.wxa.xe;

import com.tencent.luggage.wxa.af.e;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.d;
import com.tencent.luggage.wxa.xd.g1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class b extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = -2;

    @NotNull
    public static final String NAME = "stopCollectInvokeCost";

    /* renamed from: a, reason: collision with root package name */
    public static final a f144901a = new a(null);

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(d dVar, JSONObject jSONObject, int i3) {
        if (dVar == null) {
            return;
        }
        w.d("MicroMsg.JsApiStopCollectInvokeCost", "env.invokeCostManager:" + dVar.getInvokeCostManager() + " invoke data:" + jSONObject + " stop");
        g1 invokeCostManager = dVar.getInvokeCostManager();
        if (invokeCostManager != null) {
            invokeCostManager.e();
        }
        dVar.a(i3, makeReturnJson(e.f121305a));
    }
}
