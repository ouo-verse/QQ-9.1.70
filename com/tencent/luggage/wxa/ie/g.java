package com.tencent.luggage.wxa.ie;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertiseSettings;
import android.bluetooth.le.BluetoothLeAdvertiser;
import android.os.ParcelUuid;
import android.util.Base64;
import com.tencent.hippy.qq.adapter.image.HippyImageInfo;
import com.tencent.luggage.wxa.ie.n;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.relation.common.nt.api.impl.RelationNTPushServiceImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class g extends com.tencent.luggage.wxa.xd.a {

    /* renamed from: a, reason: collision with root package name */
    public static final c f130111a = new c(null);

    @NotNull
    private static final String NAME = "startBLEPeripheralAdvertising";
    private static final int CTRL_INDEX = 725;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public int f130112a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f130113b;

        /* renamed from: c, reason: collision with root package name */
        public List f130114c;

        /* renamed from: d, reason: collision with root package name */
        public List f130115d;

        /* renamed from: e, reason: collision with root package name */
        public String f130116e;

        /* renamed from: f, reason: collision with root package name */
        public String f130117f;

        /* renamed from: g, reason: collision with root package name */
        public b f130118g;

        public a(int i3, boolean z16, List serviceUuids, List manufacturerData, String powerLevel, String deviceName, b bVar) {
            Intrinsics.checkNotNullParameter(serviceUuids, "serviceUuids");
            Intrinsics.checkNotNullParameter(manufacturerData, "manufacturerData");
            Intrinsics.checkNotNullParameter(powerLevel, "powerLevel");
            Intrinsics.checkNotNullParameter(deviceName, "deviceName");
            this.f130112a = i3;
            this.f130113b = z16;
            this.f130114c = serviceUuids;
            this.f130115d = manufacturerData;
            this.f130116e = powerLevel;
            this.f130117f = deviceName;
            this.f130118g = bVar;
        }

        public final void a(int i3) {
            this.f130112a = i3;
        }

        public final boolean b() {
            return this.f130113b;
        }

        public final String c() {
            return this.f130117f;
        }

        public final List d() {
            return this.f130115d;
        }

        public final String e() {
            return this.f130116e;
        }

        public final int f() {
            return this.f130112a;
        }

        public final List g() {
            return this.f130114c;
        }

        public final void a(boolean z16) {
            this.f130113b = z16;
        }

        public final void b(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.f130116e = str;
        }

        public final void a(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.f130117f = str;
        }

        public final b a() {
            return this.f130118g;
        }

        public final void a(b bVar) {
            this.f130118g = bVar;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {

        /* renamed from: e, reason: collision with root package name */
        public static final a f130119e = new a(null);

        /* renamed from: a, reason: collision with root package name */
        public final byte[] f130120a;

        /* renamed from: b, reason: collision with root package name */
        public final int f130121b;

        /* renamed from: c, reason: collision with root package name */
        public final int f130122c;

        /* renamed from: d, reason: collision with root package name */
        public final int f130123d;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final b a(JSONObject json) {
                String replace$default;
                Intrinsics.checkNotNullParameter(json, "json");
                c cVar = g.f130111a;
                String optString = json.optString("uuid");
                Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"uuid\")");
                replace$default = StringsKt__StringsJVMKt.replace$default(optString, "-", "", false, 4, (Object) null);
                return new b(cVar.a(replace$default), json.optInt("major"), json.optInt("minor"), json.optInt("measuredPower"));
            }
        }

        public b(byte[] uuid, int i3, int i16, int i17) {
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            this.f130120a = uuid;
            this.f130121b = i3;
            this.f130122c = i16;
            this.f130123d = i17;
        }

        public final int a() {
            return this.f130121b;
        }

        public final int b() {
            return this.f130123d;
        }

        public final int c() {
            return this.f130122c;
        }

        public final byte[] d() {
            return this.f130120a;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f130125b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f130126c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f130127d;

        public d(JSONObject jSONObject, int i3, com.tencent.luggage.wxa.xd.d dVar) {
            this.f130125b = jSONObject;
            this.f130126c = i3;
            this.f130127d = dVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            g.this.a(this.f130125b, this.f130126c, this.f130127d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e extends n.a.AbstractC6302a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f130129b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f130130c;

        public e(int i3, com.tencent.luggage.wxa.xd.d dVar) {
            this.f130129b = i3;
            this.f130130c = dVar;
        }

        @Override // com.tencent.luggage.wxa.ie.n.a.AbstractC6302a
        public void a() {
            g gVar = g.this;
            int i3 = this.f130129b;
            com.tencent.luggage.wxa.xd.d dVar = this.f130130c;
            com.tencent.luggage.wxa.af.c cVar = com.tencent.luggage.wxa.af.e.f121308d;
            int i16 = cVar.f121277a;
            String str = cVar.f121278b;
            Intrinsics.checkNotNull(str);
            com.tencent.luggage.wxa.pe.b.a(gVar, i3, dVar, i16, str, null, 16, null);
        }

        @Override // android.bluetooth.le.AdvertiseCallback
        public void onStartFailure(int i3) {
            String str;
            super.onStartFailure(i3);
            w.b("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", "Not broadcasting: " + i3);
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                str = "fail:Unhandled " + i3 + " error";
                            } else {
                                str = "fail:feature unsupported";
                            }
                        } else {
                            str = "fail:internal error";
                        }
                    } else {
                        str = "fail:already started";
                    }
                } else {
                    str = "fail:too many advertisers";
                }
            } else {
                str = "fail:data too large";
            }
            String str2 = str;
            w.b("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", "onStartFailure: error msg = " + str2);
            com.tencent.luggage.wxa.pe.b.a(g.this, this.f130129b, this.f130130c, 10008, str2, null, 16, null);
        }

        @Override // android.bluetooth.le.AdvertiseCallback
        public void onStartSuccess(AdvertiseSettings advertiseSettings) {
            super.onStartSuccess(advertiseSettings);
            com.tencent.luggage.wxa.pe.b.a(g.this, this.f130129b, this.f130130c, (HashMap) null, 4, (Object) null);
        }
    }

    public final AdvertiseSettings b(a aVar) {
        Pair c16 = c(aVar);
        int intValue = ((Number) c16.component1()).intValue();
        AdvertiseSettings build = new AdvertiseSettings.Builder().setAdvertiseMode(intValue).setTxPowerLevel(((Number) c16.component2()).intValue()).setTimeout(0).setConnectable(aVar.b()).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n            .s\u2026ble)\n            .build()");
        return build;
    }

    public final Pair c(a aVar) {
        String e16 = aVar.e();
        int hashCode = e16.hashCode();
        int i3 = 1;
        int i16 = 2;
        if (hashCode != -1078030475) {
            if (hashCode != 107348) {
                if (hashCode == 3202466) {
                    e16.equals("high");
                }
            } else if (e16.equals(HippyImageInfo.QUALITY_LOW)) {
                i16 = 0;
            }
            i3 = 3;
        } else {
            if (e16.equals("medium")) {
                i16 = 1;
                i3 = 2;
            }
            i3 = 3;
        }
        return new Pair(Integer.valueOf(i16), Integer.valueOf(i3));
    }

    public final AdvertiseData e() {
        AdvertiseData build = new AdvertiseData.Builder().setIncludeDeviceName(false).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n            .s\u2026lse)\n            .build()");
        return build;
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d env, JSONObject jSONObject, int i3) {
        Intrinsics.checkNotNullParameter(env, "env");
        if (!com.tencent.luggage.wxa.pe.c.a()) {
            com.tencent.luggage.wxa.pe.b.a(this, i3, env, 10001, "fail:not available", null, 16, null);
            w.d("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", "invoke: Ble is not available");
        } else {
            com.tencent.luggage.wxa.zp.h.f146825d.b(new d(jSONObject, i3, env), "MicroMsg.BLE.Peripheral");
        }
    }

    public final void a(JSONObject jSONObject, int i3, com.tencent.luggage.wxa.xd.d dVar) {
        AdvertiseData a16;
        a a17 = a(jSONObject);
        if (a17 == null) {
            w.b("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", "createBLEPeripheralServer data is invalid");
            com.tencent.luggage.wxa.pe.b.a(this, i3, dVar, 10013, "fail:invalid data", null, 16, null);
            return;
        }
        n b16 = o.f130152a.b(a17.f());
        if (b16 == null) {
            w.d("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", "invoke: retrieve a null server");
            com.tencent.luggage.wxa.pe.b.a(this, i3, dVar, 10020, "fail: no server", null, 16, null);
            return;
        }
        BluetoothAdapter e16 = com.tencent.luggage.wxa.pe.c.e();
        BluetoothLeAdvertiser bluetoothLeAdvertiser = e16 != null ? e16.getBluetoothLeAdvertiser() : null;
        if (e16 != null && bluetoothLeAdvertiser != null) {
            b16.a(dVar);
            b a18 = a17.a();
            if (a18 != null) {
                a16 = a(a18);
            } else {
                a16 = a(a17);
            }
            b16.a(b(a17), a16, e(), a17.c(), e16, bluetoothLeAdvertiser, new e(i3, dVar));
            return;
        }
        w.d("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", "invoke: adapter is null");
        com.tencent.luggage.wxa.pe.b.a(this, i3, dVar, 10001, "fail:not available", null, 16, null);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c {
        public c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final byte[] a(String s16) {
            Intrinsics.checkNotNullParameter(s16, "s");
            int length = s16.length();
            byte[] bArr = new byte[length / 2];
            for (int i3 = 0; i3 < length; i3 += 2) {
                bArr[i3 / 2] = (byte) ((a(s16.charAt(i3)) << 4) | a(s16.charAt(i3 + 1)));
            }
            return bArr;
        }

        public final int a(char c16) {
            if ('0' <= c16 && c16 < ':') {
                return c16 - '0';
            }
            char c17 = EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET;
            if (!('A' <= c16 && c16 < 'G')) {
                c17 = 'a';
                if (!('a' <= c16 && c16 < 'g')) {
                    throw new IllegalArgumentException("invalid hex char '" + c16 + '\'');
                }
            }
            return (c16 - c17) + 10;
        }
    }

    public final a a(JSONObject jSONObject) {
        boolean startsWith$default;
        int i3;
        int i16;
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a(-1, true, new ArrayList(), new ArrayList(), "medium", "", null);
        try {
            aVar.a(jSONObject.optInt("serverId"));
            String optString = jSONObject.optString("powerLevel", "medium");
            Intrinsics.checkNotNullExpressionValue(optString, "data.optString(\"powerLevel\", \"medium\")");
            aVar.b(optString);
            JSONObject optJSONObject = jSONObject.optJSONObject("advertiseRequest");
            Intrinsics.checkNotNull(optJSONObject);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("beacon");
            if (optJSONObject2 != null) {
                aVar.a(b.f130119e.a(optJSONObject2));
            } else {
                aVar.a(optJSONObject.optBoolean("connectable", true));
                String optString2 = optJSONObject.optString("deviceName", "");
                Intrinsics.checkNotNullExpressionValue(optString2, "jAdvertiseRequest.optString(\"deviceName\", \"\")");
                aVar.a(optString2);
                JSONArray optJSONArray = optJSONObject.optJSONArray("serviceUuids");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    String[] strArr = new String[length];
                    for (int i17 = 0; i17 < length; i17++) {
                        Object obj = optJSONArray.get(i17);
                        if (obj == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strArr[i17] = (String) obj;
                    }
                    ArrayList arrayList = new ArrayList(length);
                    for (int i18 = 0; i18 < length; i18++) {
                        arrayList.add(new ParcelUuid(com.tencent.luggage.wxa.qe.a.a(strArr[i18])));
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        aVar.g().add((ParcelUuid) it.next());
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("manufacturerData");
                if (optJSONArray2 != null) {
                    int length2 = optJSONArray2.length();
                    JSONObject[] jSONObjectArr = new JSONObject[length2];
                    for (int i19 = 0; i19 < length2; i19++) {
                        Object obj2 = optJSONArray2.get(i19);
                        if (obj2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                        }
                        jSONObjectArr[i19] = (JSONObject) obj2;
                    }
                    for (int i26 = 0; i26 < length2; i26++) {
                        JSONObject jSONObject2 = jSONObjectArr[i26];
                        String manufacturerIdString = jSONObject2.optString("manufacturerId");
                        Intrinsics.checkNotNullExpressionValue(manufacturerIdString, "manufacturerIdString");
                        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(manufacturerIdString, RelationNTPushServiceImpl.PRE_HEX_STRING, false, 2, null);
                        if (startsWith$default) {
                            manufacturerIdString = StringsKt__StringsJVMKt.replace$default(manufacturerIdString, RelationNTPushServiceImpl.PRE_HEX_STRING, "", false, 4, (Object) null);
                            i3 = 16;
                        } else {
                            i3 = 10;
                        }
                        try {
                            i16 = Integer.parseInt(manufacturerIdString, i3);
                        } catch (NumberFormatException unused) {
                            w.b("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", "NumberFormatException: input = " + manufacturerIdString);
                            i16 = 0;
                        }
                        aVar.d().add(new Pair(Integer.valueOf(i16), jSONObject2.optString("manufacturerSpecificData", "")));
                    }
                }
            }
            return aVar;
        } catch (Exception e16) {
            w.b("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", "parseData: error ", e16);
            return null;
        }
    }

    public final AdvertiseData a(b bVar) {
        AdvertiseData.Builder builder = new AdvertiseData.Builder();
        int a16 = bVar.a();
        int c16 = bVar.c();
        byte[] bArr = {(byte) 2, (byte) 21, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, (byte) (a16 >>> 8), (byte) a16, (byte) (c16 >>> 8), (byte) c16, (byte) bVar.b()};
        System.arraycopy(bVar.d(), 0, bArr, 2, 16);
        builder.setIncludeTxPowerLevel(false).setIncludeDeviceName(false).addManufacturerData(76, bArr);
        AdvertiseData build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    public final AdvertiseData a(a aVar) {
        boolean isBlank;
        isBlank = StringsKt__StringsJVMKt.isBlank(aVar.c());
        AdvertiseData.Builder includeDeviceName = new AdvertiseData.Builder().setIncludeDeviceName(!isBlank);
        for (Pair pair : aVar.d()) {
            includeDeviceName.addManufacturerData(((Number) pair.getFirst()).intValue(), com.tencent.luggage.wxa.pe.c.a(Base64.decode((String) pair.getSecond(), 2)));
        }
        Iterator it = aVar.g().iterator();
        while (it.hasNext()) {
            includeDeviceName.addServiceUuid((ParcelUuid) it.next());
        }
        AdvertiseData build = includeDeviceName.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }
}
