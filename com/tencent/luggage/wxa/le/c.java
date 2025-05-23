package com.tencent.luggage.wxa.le;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import com.tencent.luggage.wxa.ne.k;
import com.tencent.luggage.wxa.xd.x;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c extends com.tencent.luggage.wxa.ne.a {

    /* renamed from: n, reason: collision with root package name */
    public final String f133311n;

    public c(String deviceId) {
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        this.f133311n = deviceId;
    }

    @Override // com.tencent.luggage.wxa.ne.a, com.tencent.luggage.wxa.ke.e
    public void b(BluetoothGatt bluetoothGatt, int i3) {
        k kVar;
        String b16 = com.tencent.luggage.wxa.ne.f.b(i3);
        com.tencent.luggage.wxa.pe.a.c("MicroMsg.Ble.Action", "[onServicesDiscovered] status:%s", b16);
        if (i3 == 0) {
            b(k.f135745e);
        } else {
            if (x.f144890a.a()) {
                kVar = k.b("status: " + b16);
            } else {
                kVar = k.f135762v;
            }
            b(kVar);
        }
        d();
    }

    @Override // com.tencent.luggage.wxa.ne.a
    public void c() {
        k kVar;
        if (com.tencent.luggage.wxa.pe.c.e() == null) {
            com.tencent.luggage.wxa.pe.a.d("MicroMsg.Ble.Action", "action:%s, bluetoothAdapter is null", this);
            b(k.f135749i);
            d();
            return;
        }
        if (!com.tencent.luggage.wxa.pe.c.a()) {
            com.tencent.luggage.wxa.pe.a.d("MicroMsg.Ble.Action", "action:%s, bluetooth is not enable", this);
            b(k.f135749i);
            d();
            return;
        }
        if (!BluetoothAdapter.checkBluetoothAddress(this.f133311n)) {
            com.tencent.luggage.wxa.pe.a.d("MicroMsg.Ble.Action", "action:%s, unspecified deviceId", this);
            b(k.f135761u);
            d();
            return;
        }
        BluetoothGatt a16 = this.f135710a.a();
        if (a16 == null) {
            com.tencent.luggage.wxa.pe.a.d("MicroMsg.Ble.Action", "action:%s, gattService is null", this);
            b(k.f135752l);
            d();
        } else if (!a16.discoverServices()) {
            com.tencent.luggage.wxa.pe.a.d("MicroMsg.Ble.Action", "action:%s, discoverServices fail", this);
            if (x.f144890a.a()) {
                kVar = k.c("discoverServices fail");
            } else {
                kVar = k.f135754n;
            }
            b(kVar);
            d();
        }
    }

    @Override // com.tencent.luggage.wxa.ne.a
    public String e() {
        return "DiscoverServicesAction";
    }
}
