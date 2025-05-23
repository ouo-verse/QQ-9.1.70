package com.tencent.luggage.wxa.ie;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.vas.config.business.qvip.QVipBubbleAnimationProcessor;
import java.util.HashMap;
import java.util.UUID;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class i extends com.tencent.luggage.wxa.xd.a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f130136a = new a(null);

    @NotNull
    private static final String NAME = "writeBLEPeripheralCharacteristicValue";
    private static final int CTRL_INDEX = QVipBubbleAnimationProcessor.CMD;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d env, JSONObject jSONObject, int i3) {
        Intrinsics.checkNotNullParameter(env, "env");
        if (!com.tencent.luggage.wxa.pe.c.a()) {
            com.tencent.luggage.wxa.pe.b.a(this, i3, env, 10001, "fail:not available", null, 16, null);
            w.d("MicroMsg.BLE.JsApiWriteBlePeripheralCharacteristicValue", "invoke: Ble is not available");
            return;
        }
        if (jSONObject != null && jSONObject.has("serverId")) {
            n b16 = o.f130152a.b(jSONObject.optInt("serverId"));
            if (b16 == null) {
                com.tencent.luggage.wxa.pe.b.a(this, i3, env, 10020, "fail: no server", null, 16, null);
                return;
            }
            if (b16.e() != p.CONNECTED) {
                com.tencent.luggage.wxa.pe.b.a(this, i3, env, 10000, "fail:not init", null, 16, null);
                return;
            }
            try {
                String optString = jSONObject.optString("serviceId", "");
                String optString2 = jSONObject.optString("characteristicId", "");
                boolean optBoolean = jSONObject.optBoolean("needNotify", false);
                int optInt = jSONObject.optInt("callbackId", -1);
                String base64Value = jSONObject.optString("value");
                w.d("MicroMsg.BLE.JsApiWriteBlePeripheralCharacteristicValue", "invoke: write = " + base64Value + " serviceId = %s, characteristicId = %s, needNotify = %s, jCallbackId = %s", optString, optString2, String.valueOf(optBoolean), String.valueOf(optInt));
                UUID a16 = com.tencent.luggage.wxa.qe.a.a(optString);
                Intrinsics.checkNotNullExpressionValue(a16, "fromString(serviceId)");
                UUID a17 = com.tencent.luggage.wxa.qe.a.a(optString2);
                Intrinsics.checkNotNullExpressionValue(a17, "fromString(characteristicId)");
                Intrinsics.checkNotNullExpressionValue(base64Value, "base64Value");
                b16.a(a16, a17, optBoolean, optInt, base64Value);
                com.tencent.luggage.wxa.pe.b.a(this, i3, env, (HashMap) null, 4, (Object) null);
                return;
            } catch (IllegalArgumentException e16) {
                w.b("MicroMsg.BLE.JsApiWriteBlePeripheralCharacteristicValue", "invoke: fail: " + e16);
                com.tencent.luggage.wxa.pe.b.a(this, i3, env, 10013, "fail:invalid data", null, 16, null);
                return;
            } catch (JSONException e17) {
                w.b("MicroMsg.BLE.JsApiWriteBlePeripheralCharacteristicValue", "invoke: fail: " + e17);
                com.tencent.luggage.wxa.pe.b.a(this, i3, env, 10013, "fail:invalid data", null, 16, null);
                return;
            }
        }
        com.tencent.luggage.wxa.pe.b.a(this, i3, env, 10013, "fail:invalid data", null, 16, null);
    }
}
