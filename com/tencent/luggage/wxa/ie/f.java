package com.tencent.luggage.wxa.ie;

import android.bluetooth.BluetoothGattService;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import java.util.HashMap;
import java.util.UUID;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f extends com.tencent.luggage.wxa.xd.a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f130110a = new a(null);

    @NotNull
    private static final String NAME = "removeBLEPeripheralService";
    private static final int CTRL_INDEX = 724;

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
            w.d("MicroMsg.BLE.JsApiRemoveBlePeripheralService", "invoke: Ble is not available");
            return;
        }
        if (jSONObject != null && jSONObject.has("serverId") && jSONObject.has("serviceId")) {
            n b16 = o.f130152a.b(jSONObject.optInt("serverId"));
            if (b16 == null) {
                w.d("MicroMsg.BLE.JsApiRemoveBlePeripheralService", "invoke: retrieve a null server");
                com.tencent.luggage.wxa.pe.b.a(this, i3, env, 10020, "fail: no server", null, 16, null);
                return;
            }
            try {
                UUID a16 = com.tencent.luggage.wxa.qe.a.a(jSONObject.optString("serviceId"));
                Intrinsics.checkNotNullExpressionValue(a16, "fromString(data.optString(PARAMS_SERVICE_ID))");
                BluetoothGattService service = b16.c().getService(a16);
                if (service == null) {
                    com.tencent.luggage.wxa.pe.b.a(this, i3, env, 10004, "fail:no service", null, 16, null);
                    return;
                }
                if (com.tencent.luggage.wxa.pe.b.a(QQPermissionConstants.Permission.BLUETOOTH_CONNECT)) {
                    try {
                        if (b16.c().removeService(service)) {
                            com.tencent.luggage.wxa.pe.b.a(this, i3, env, (HashMap) null, 4, (Object) null);
                        } else {
                            com.tencent.luggage.wxa.pe.b.a(this, i3, env, 10008, "fail: remove #" + a16 + " service fail", null, 16, null);
                        }
                        return;
                    } catch (SecurityException unused) {
                        com.tencent.luggage.wxa.af.c cVar = com.tencent.luggage.wxa.af.e.f121308d;
                        int i16 = cVar.f121277a;
                        String str = cVar.f121278b;
                        Intrinsics.checkNotNull(str);
                        com.tencent.luggage.wxa.pe.b.a(this, i3, env, i16, str, null, 16, null);
                        return;
                    }
                }
                com.tencent.luggage.wxa.af.c cVar2 = com.tencent.luggage.wxa.af.e.f121308d;
                int i17 = cVar2.f121277a;
                String str2 = cVar2.f121278b;
                Intrinsics.checkNotNull(str2);
                com.tencent.luggage.wxa.pe.b.a(this, i3, env, i17, str2, null, 16, null);
                return;
            } catch (Exception unused2) {
                com.tencent.luggage.wxa.pe.b.a(this, i3, env, 10013, "fail:invalid data", null, 16, null);
                return;
            }
        }
        w.b("MicroMsg.BLE.JsApiRemoveBlePeripheralService", "invoke data is invalid");
        com.tencent.luggage.wxa.pe.b.a(this, i3, env, 10013, "fail:invalid data", null, 16, null);
    }
}
