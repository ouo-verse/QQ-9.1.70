package com.tencent.luggage.wxa.ie;

import android.bluetooth.BluetoothAdapter;
import com.tencent.luggage.wxa.tn.w;
import java.util.HashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class h extends com.tencent.luggage.wxa.xd.a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f130131a = new a(null);

    @NotNull
    private static final String NAME = "stopBLEPeripheralAdvertising";
    private static final int CTRL_INDEX = 726;

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
    public static final class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f130132a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f130133b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f130134c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f130135d;

        public b(JSONObject jSONObject, h hVar, int i3, com.tencent.luggage.wxa.xd.d dVar) {
            this.f130132a = jSONObject;
            this.f130133b = hVar;
            this.f130134c = i3;
            this.f130135d = dVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            n b16 = o.f130152a.b(this.f130132a.optInt("serverId"));
            if (b16 == null) {
                com.tencent.luggage.wxa.pe.b.a(this.f130133b, this.f130134c, this.f130135d, 10020, "fail: no server", null, 16, null);
                return;
            }
            BluetoothAdapter e16 = com.tencent.luggage.wxa.pe.c.e();
            if (e16 == null) {
                w.d("MicroMsg.BLE.JsApiStopBlePeripheralAdvertising", "invoke: adapter is null");
                com.tencent.luggage.wxa.pe.b.a(this.f130133b, this.f130134c, this.f130135d, 10001, "fail:not available", null, 16, null);
            } else {
                b16.a(e16);
                com.tencent.luggage.wxa.pe.b.a(this.f130133b, this.f130134c, this.f130135d, (HashMap) null, 4, (Object) null);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d env, JSONObject jSONObject, int i3) {
        Intrinsics.checkNotNullParameter(env, "env");
        if (jSONObject != null && jSONObject.has("serverId")) {
            com.tencent.luggage.wxa.zp.h.f146825d.b(new b(jSONObject, this, i3, env), "MicroMsg.BLE.Peripheral");
        } else {
            w.b("MicroMsg.BLE.JsApiStopBlePeripheralAdvertising", "createBLEPeripheralServer data is invalid");
            com.tencent.luggage.wxa.pe.b.a(this, i3, env, 10013, "fail:invalid data", null, 16, null);
        }
    }
}
