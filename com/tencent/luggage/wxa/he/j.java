package com.tencent.luggage.wxa.he;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import com.tencent.bugly.common.constants.Constants;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class j extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 1059;

    @NotNull
    public static final String NAME = "isBluetoothDevicePaired";

    /* renamed from: a, reason: collision with root package name */
    public static final a f127052a = new a(null);

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
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        boolean z16;
        Map<String, ? extends Object> mutableMapOf;
        if (dVar == null) {
            return;
        }
        if (jSONObject == null) {
            com.tencent.luggage.wxa.pe.a.d("MicroMsg.AppBrand.JsApiIsBluetoothDevicePaired", "invoke, data is null", new Object[0]);
            dVar.a(i3, makeReturnJson("fail:invalid data", com.tencent.luggage.wxa.af.e.f121315k));
            return;
        }
        if (!jSONObject.has(Constants.SP_DEVICE_ID)) {
            com.tencent.luggage.wxa.pe.a.d("MicroMsg.AppBrand.JsApiIsBluetoothDevicePaired", "invoke, do not have key: deviceId", new Object[0]);
            dVar.a(i3, makeReturnJson("fail:invalid data", com.tencent.luggage.wxa.af.e.f121315k));
            return;
        }
        String optString = jSONObject.optString(Constants.SP_DEVICE_ID);
        com.tencent.luggage.wxa.pe.a.c("MicroMsg.AppBrand.JsApiIsBluetoothDevicePaired", "invoke, deviceId: " + optString, new Object[0]);
        if (!BluetoothAdapter.checkBluetoothAddress(optString)) {
            com.tencent.luggage.wxa.pe.a.d("MicroMsg.AppBrand.JsApiIsBluetoothDevicePaired", "invoke, deviceId is illegal", new Object[0]);
            dVar.a(i3, makeReturnJson("fail:invalid data", com.tencent.luggage.wxa.af.e.f121315k));
            return;
        }
        BluetoothAdapter e16 = com.tencent.luggage.wxa.pe.c.e();
        if (e16 != null && e16.isEnabled()) {
            Set<BluetoothDevice> bondedDevices = e16.getBondedDevices();
            Object obj = null;
            if (bondedDevices != null) {
                Iterator<T> it = bondedDevices.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (Intrinsics.areEqual(optString, ((BluetoothDevice) next).getAddress())) {
                        obj = next;
                        break;
                    }
                }
                obj = (BluetoothDevice) obj;
            }
            if (obj != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            com.tencent.luggage.wxa.pe.a.c("MicroMsg.AppBrand.JsApiIsBluetoothDevicePaired", "invoke, isPaired: " + z16, new Object[0]);
            com.tencent.luggage.wxa.af.c cVar = com.tencent.luggage.wxa.af.e.f121305a;
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("isPaired", Boolean.valueOf(z16)));
            dVar.a(i3, makeReturnJson(cVar, mutableMapOf));
            return;
        }
        com.tencent.luggage.wxa.pe.a.d("MicroMsg.AppBrand.JsApiIsBluetoothDevicePaired", "invoke, bluetoothAdapter is null or disabled", new Object[0]);
        dVar.a(i3, makeReturnJson("fail:not available", com.tencent.luggage.wxa.af.b.f121227b));
    }
}
