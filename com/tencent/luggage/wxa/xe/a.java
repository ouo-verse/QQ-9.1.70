package com.tencent.luggage.wxa.xe;

import com.tencent.luggage.wxa.af.c;
import com.tencent.luggage.wxa.af.e;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.d;
import com.tencent.luggage.wxa.xd.g1;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class a extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = -2;

    @NotNull
    public static final String NAME = "getInvokeCost";

    /* renamed from: a, reason: collision with root package name */
    public static final C6907a f144900a = new C6907a(null);

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.xe.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C6907a {
        public C6907a() {
        }

        public /* synthetic */ C6907a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(d dVar, JSONObject jSONObject, int i3) {
        JSONObject jSONObject2;
        if (dVar == null) {
            return;
        }
        g1 invokeCostManager = dVar.getInvokeCostManager();
        if (invokeCostManager == null || (jSONObject2 = invokeCostManager.b()) == null) {
            jSONObject2 = new JSONObject();
        }
        g1 invokeCostManager2 = dVar.getInvokeCostManager();
        if (invokeCostManager2 != null) {
            invokeCostManager2.a();
        }
        w.d("MicroMsg.JsApiGetInvokeCost", "invoke env:" + dVar + " data:" + jSONObject + " result:" + jSONObject2);
        c cVar = e.f121305a;
        HashMap hashMap = new HashMap(1);
        hashMap.put("data", jSONObject2);
        Unit unit = Unit.INSTANCE;
        dVar.a(i3, makeReturnJson(cVar, hashMap));
    }
}
