package com.tencent.luggage.wxa.ie;

import com.tencent.bugly.common.constants.Constants;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.k0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {
    public static final void a(com.tencent.luggage.wxa.xd.d component, String deviceID, String serverID, boolean z16) {
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(deviceID, "deviceID");
        Intrinsics.checkNotNullParameter(serverID, "serverID");
        w.d("MicroMsg.BLE.BlePeripheralPublishEventFuns", "jOnBLEPeripheralConnectionStateChanged: connected = " + z16 + ", deviceID = " + deviceID + ", serverID = " + serverID);
        try {
            j jVar = new j();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Constants.SP_DEVICE_ID, deviceID);
            jSONObject.put("serverId", serverID);
            jSONObject.put("connected", z16);
            a(jVar, jSONObject, component);
        } catch (JSONException e16) {
            w.b("MicroMsg.BLE.BlePeripheralPublishEventFuns", "BlePeripheralPublishEventFuns fail", e16);
        }
    }

    public static final boolean a(com.tencent.luggage.wxa.xd.d component, String deviceId, int i3, String serviceUUID, String characteristicUUID, int i16, String base64Value) {
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(serviceUUID, "serviceUUID");
        Intrinsics.checkNotNullParameter(characteristicUUID, "characteristicUUID");
        Intrinsics.checkNotNullParameter(base64Value, "base64Value");
        w.d("MicroMsg.BLE.BlePeripheralPublishEventFuns", "jOnCharacteristicWriteRequest: serverID = " + i3 + ", serviceUUID = " + serviceUUID + ", characteristicUUID = " + characteristicUUID + ", callbackId = " + i16);
        try {
            l lVar = new l();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("serverId", i3);
            jSONObject.put("serviceId", serviceUUID);
            jSONObject.put("characteristicId", characteristicUUID);
            jSONObject.put("callbackId", i16);
            jSONObject.put("value", base64Value);
            jSONObject.put(Constants.SP_DEVICE_ID, deviceId);
            a(lVar, jSONObject, component);
            return true;
        } catch (JSONException e16) {
            w.b("MicroMsg.BLE.BlePeripheralPublishEventFuns", "BlePeripheralPublishEventFuns fail", e16);
            return false;
        }
    }

    public static final boolean a(com.tencent.luggage.wxa.xd.d component, String deviceId, int i3, String serviceUUID, String characteristicUUID, int i16) {
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(serviceUUID, "serviceUUID");
        Intrinsics.checkNotNullParameter(characteristicUUID, "characteristicUUID");
        w.d("MicroMsg.BLE.BlePeripheralPublishEventFuns", "jOnCharacteristicReadRequest: serverID = " + i3 + ", serviceUUID = " + serviceUUID + ",\" +\n        \" characteristicUUID = " + characteristicUUID + ", callbackId = " + i16);
        try {
            k kVar = new k();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("serverId", i3);
            jSONObject.put("serviceId", serviceUUID);
            jSONObject.put("characteristicId", characteristicUUID);
            jSONObject.put("callbackId", i16);
            jSONObject.put(Constants.SP_DEVICE_ID, deviceId);
            a(kVar, jSONObject, component);
            return true;
        } catch (JSONException e16) {
            w.b("MicroMsg.BLE.BlePeripheralPublishEventFuns", "OnCharacteristicReadRequest: fail", e16);
            return false;
        }
    }

    public static final void a(k0 k0Var, JSONObject jSONObject, com.tencent.luggage.wxa.xd.d dVar) {
        k0Var.setData(jSONObject.toString());
        k0Var.setContext(dVar);
        k0Var.dispatch();
    }
}
