package com.tencent.luggage.wxa.ie;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.util.Base64;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.raft.codegenmeta.utils.Constants;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c extends com.tencent.luggage.wxa.xd.a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f130093a = new a(null);

    @NotNull
    private static final String NAME = "addBLEPeripheralService";
    private static final int CTRL_INDEX = LpReportInfoConfig.ACTION_TYPE_AIO_SYNC_QZONE;

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
    public static final class b extends Lambda implements Function1 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f130095b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f130096c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i3, com.tencent.luggage.wxa.xd.d dVar) {
            super(1);
            this.f130095b = i3;
            this.f130096c = dVar;
        }

        public final void a(boolean z16) {
            if (z16) {
                com.tencent.luggage.wxa.pe.b.a(c.this, this.f130095b, this.f130096c, (HashMap) null, 4, (Object) null);
            } else {
                com.tencent.luggage.wxa.pe.b.a(c.this, this.f130095b, this.f130096c, 10008, "fail:system error, add service fail", null, 16, null);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((Boolean) obj).booleanValue());
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ie.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6301c extends Lambda implements Function0 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f130098b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f130099c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C6301c(int i3, com.tencent.luggage.wxa.xd.d dVar) {
            super(0);
            this.f130098b = i3;
            this.f130099c = dVar;
        }

        public final void a() {
            c cVar = c.this;
            int i3 = this.f130098b;
            com.tencent.luggage.wxa.xd.d dVar = this.f130099c;
            com.tencent.luggage.wxa.af.c cVar2 = com.tencent.luggage.wxa.af.e.f121308d;
            int i16 = cVar2.f121277a;
            String str = cVar2.f121278b;
            Intrinsics.checkNotNull(str);
            com.tencent.luggage.wxa.pe.b.a(cVar, i3, dVar, i16, str, null, 16, null);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12, types: [int] */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r8v4, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r8v6, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v5, types: [int] */
    /* JADX WARN: Type inference failed for: r9v9 */
    public final BluetoothGattService a(JSONObject jSONObject) {
        int i3;
        String str = "value";
        if (jSONObject == null) {
            return null;
        }
        ?? r95 = 0;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("service");
            BluetoothGattService bluetoothGattService = new BluetoothGattService(com.tencent.luggage.wxa.qe.a.a(optJSONObject.optString("uuid")), 0);
            JSONArray optJSONArray = optJSONObject.optJSONArray("characteristics");
            if (optJSONArray == null) {
                return bluetoothGattService;
            }
            int length = optJSONArray.length();
            JSONObject[] jSONObjectArr = new JSONObject[length];
            for (int i16 = 0; i16 < length; i16++) {
                Object obj = optJSONArray.get(i16);
                if (obj != null) {
                    jSONObjectArr[i16] = (JSONObject) obj;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                }
            }
            ArrayList arrayList = new ArrayList(length);
            int i17 = 0;
            while (i17 < length) {
                JSONObject jSONObject2 = jSONObjectArr[i17];
                String optString = jSONObject2.optString("uuid");
                ?? optJSONObject2 = jSONObject2.optJSONObject(Constants.Service.PROPERTIES);
                boolean optBoolean = optJSONObject2.optBoolean(com.tencent.mobileqq.msf.core.auth.k.f247492f, r95);
                boolean optBoolean2 = optJSONObject2.optBoolean(com.tencent.mobileqq.msf.core.auth.k.f247491e, r95);
                int i18 = length;
                boolean optBoolean3 = optJSONObject2.optBoolean("notify", r95);
                JSONObject[] jSONObjectArr2 = jSONObjectArr;
                boolean optBoolean4 = optJSONObject2.optBoolean("indicate", r95);
                BluetoothGattService bluetoothGattService2 = bluetoothGattService;
                boolean optBoolean5 = optJSONObject2.optBoolean("writeNoResponse", r95);
                if (optBoolean) {
                    i3 = 8;
                } else {
                    i3 = r95;
                }
                if (optBoolean2) {
                    i3 |= 2;
                }
                if (optBoolean3) {
                    i3 |= 16;
                }
                if (optBoolean4) {
                    i3 |= 32;
                }
                if (optBoolean5) {
                    i3 |= 4;
                }
                ?? optJSONObject3 = jSONObject2.optJSONObject(QCircleDaTongConstant.ElementParamValue.PERMISSION);
                boolean optBoolean6 = optJSONObject3.optBoolean("readable", r95);
                boolean optBoolean7 = optJSONObject3.optBoolean("writeable", r95);
                int i19 = i17;
                boolean optBoolean8 = optJSONObject3.optBoolean("readEncryptionRequired", r95);
                ArrayList arrayList2 = arrayList;
                boolean optBoolean9 = optJSONObject3.optBoolean("writeEncryptionRequired", r95);
                ?? r102 = optBoolean6;
                if (optBoolean7) {
                    r102 = (optBoolean6 ? 1 : 0) | 16;
                }
                if (optBoolean9) {
                    r102 = (r102 == true ? 1 : 0) | 32 | 64;
                }
                if (optBoolean8) {
                    r102 = (r102 == true ? 1 : 0) | 2 | 4;
                }
                BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(com.tencent.luggage.wxa.qe.a.a(optString), i3, r102);
                String optString2 = jSONObject2.optString(str);
                byte[] a16 = com.tencent.luggage.wxa.pe.c.a(Base64.decode(optString2, 2));
                w.d("MicroMsg.BLE.JsApiAddBlePeripheralService", "parseData characteristic : base64 = " + optString2 + ", hex = " + a16);
                bluetoothGattCharacteristic.setValue(a16);
                JSONArray optJSONArray2 = jSONObject2.optJSONArray("descriptors");
                if (optJSONArray2 != null) {
                    Intrinsics.checkNotNullExpressionValue(optJSONArray2, "optJSONArray(\"descriptors\")");
                    int length2 = optJSONArray2.length();
                    JSONObject[] jSONObjectArr3 = new JSONObject[length2];
                    for (int i26 = r95; i26 < length2; i26++) {
                        Object obj2 = optJSONArray2.get(i26);
                        if (obj2 != null) {
                            jSONObjectArr3[i26] = (JSONObject) obj2;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                        }
                    }
                    int i27 = r95;
                    while (i27 < length2) {
                        JSONObject jSONObject3 = jSONObjectArr3[i27];
                        String optString3 = jSONObject3.optString("uuid");
                        JSONObject optJSONObject4 = jSONObject3.optJSONObject(QCircleDaTongConstant.ElementParamValue.PERMISSION);
                        String optString4 = jSONObject3.optString(str);
                        boolean optBoolean10 = optJSONObject4.optBoolean(com.tencent.mobileqq.msf.core.auth.k.f247492f);
                        ?? optBoolean11 = optJSONObject4.optBoolean(com.tencent.mobileqq.msf.core.auth.k.f247491e);
                        if (optBoolean10) {
                            optBoolean11 = (optBoolean11 == true ? 1 : 0) | 16;
                        }
                        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(com.tencent.luggage.wxa.qe.a.a(optString3), optBoolean11);
                        byte[] a17 = com.tencent.luggage.wxa.pe.c.a(Base64.decode(optString4, 2));
                        w.d("MicroMsg.BLE.JsApiAddBlePeripheralService", "parseData descriptor: base64 = " + optString4 + ", hex = " + a17);
                        bluetoothGattDescriptor.setValue(a17);
                        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
                        i27++;
                        str = str;
                    }
                }
                arrayList2.add(bluetoothGattCharacteristic);
                i17 = i19 + 1;
                length = i18;
                arrayList = arrayList2;
                jSONObjectArr = jSONObjectArr2;
                bluetoothGattService = bluetoothGattService2;
                str = str;
                r95 = 0;
            }
            BluetoothGattService bluetoothGattService3 = bluetoothGattService;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                BluetoothGattService bluetoothGattService4 = bluetoothGattService3;
                bluetoothGattService4.addCharacteristic((BluetoothGattCharacteristic) it.next());
                bluetoothGattService3 = bluetoothGattService4;
            }
            return bluetoothGattService3;
        } catch (Exception e16) {
            w.b("MicroMsg.BLE.JsApiAddBlePeripheralService", "parseData: fail", e16);
            return null;
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d env, JSONObject jSONObject, int i3) {
        Intrinsics.checkNotNullParameter(env, "env");
        if (!com.tencent.luggage.wxa.pe.c.a()) {
            com.tencent.luggage.wxa.pe.b.a(this, i3, env, 10001, "fail:not available", null, 16, null);
            w.d("MicroMsg.BLE.JsApiAddBlePeripheralService", "invoke: Ble is not open");
            return;
        }
        BluetoothGattService a16 = a(jSONObject);
        if (a16 == null) {
            w.b("MicroMsg.BLE.JsApiAddBlePeripheralService", "createBLEPeripheralService data is invalid");
            com.tencent.luggage.wxa.pe.b.a(this, i3, env, 10013, "fail:invalid data", null, 16, null);
            return;
        }
        Intrinsics.checkNotNull(jSONObject);
        int optInt = jSONObject.optInt("serverId");
        n b16 = o.f130152a.b(optInt);
        if (b16 == null) {
            w.d("MicroMsg.BLE.JsApiAddBlePeripheralService", "invoke: retrieve a null server by #" + optInt);
            com.tencent.luggage.wxa.pe.b.a(this, i3, env, 10020, "fail: no server", null, 16, null);
            return;
        }
        b16.a(a16, new b(i3, env), new C6301c(i3, env));
    }
}
