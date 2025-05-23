package com.tencent.luggage.wxa.le;

import android.bluetooth.BluetoothGatt;
import com.tencent.luggage.wxa.ne.k;
import com.tencent.luggage.wxa.xd.x;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d extends com.tencent.luggage.wxa.ne.a {

    /* renamed from: n, reason: collision with root package name */
    public final String f133312n = "MicroMsg.Ble.Action#" + hashCode();

    @Override // com.tencent.luggage.wxa.ne.a, com.tencent.luggage.wxa.ke.e
    public void b(BluetoothGatt bluetoothGatt, int i3, int i16) {
        k kVar;
        k kVar2;
        super.b(bluetoothGatt, i3, i16);
        String b16 = com.tencent.luggage.wxa.ne.f.b(i16);
        com.tencent.luggage.wxa.pe.a.c(this.f133312n, "onReadRemoteRssi, rssi: %d, statusDesc: %s", Integer.valueOf(i3), b16);
        if (i16 != 0) {
            if (x.f144890a.a()) {
                kVar2 = k.a("status: " + b16);
            } else {
                kVar2 = k.f135747g;
            }
            b(kVar2);
            d();
            return;
        }
        if (!Intrinsics.areEqual(this.f135710a.a(), bluetoothGatt)) {
            com.tencent.luggage.wxa.pe.a.d(this.f133312n, "bluetoothGatt is not match", new Object[0]);
            if (x.f144890a.a()) {
                kVar = new k(com.tencent.luggage.wxa.af.e.f121309e);
            } else {
                kVar = k.f135747g;
            }
            b(kVar);
            d();
            return;
        }
        b(k.b(Integer.valueOf(i3)));
        d();
    }

    @Override // com.tencent.luggage.wxa.ne.a
    public void c() {
        k kVar;
        if (!com.tencent.luggage.wxa.pe.c.a()) {
            com.tencent.luggage.wxa.pe.a.d(this.f133312n, "Bluetooth is not enable.", new Object[0]);
            b(k.f135749i);
            d();
            return;
        }
        BluetoothGatt a16 = this.f135710a.a();
        if (a16 == null) {
            com.tencent.luggage.wxa.pe.a.d(this.f133312n, "bluetoothGatt is null", new Object[0]);
            b(k.f135752l);
            d();
        } else if (!a16.readRemoteRssi()) {
            if (x.f144890a.a()) {
                kVar = k.c("readRemoteRssi fail");
            } else {
                kVar = k.f135754n;
            }
            b(kVar);
            d();
        }
    }

    @Override // com.tencent.luggage.wxa.ne.a
    public String e() {
        return "GetBLEDeviceRSSIAction";
    }
}
