package com.tencent.luggage.wxa.le;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import com.tencent.luggage.wxa.ne.k;
import com.tencent.luggage.wxa.xd.x;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e extends com.tencent.luggage.wxa.ne.a {

    /* renamed from: n, reason: collision with root package name */
    public final String f133313n;

    /* renamed from: o, reason: collision with root package name */
    public final String f133314o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f133315p;

    public e(String str, String str2, boolean z16) {
        this.f133313n = str;
        this.f133314o = str2;
        this.f133315p = z16;
    }

    @Override // com.tencent.luggage.wxa.ne.a, com.tencent.luggage.wxa.ke.e
    public void b(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i3) {
        com.tencent.luggage.wxa.pe.a.c("MicroMsg.Ble.Action", "action:%s onDescriptorWrite status:%s", this, com.tencent.luggage.wxa.ne.f.b(i3));
        d();
    }

    @Override // com.tencent.luggage.wxa.ne.a
    public void c() {
        byte[] bArr;
        k kVar;
        BluetoothGatt a16 = this.f135710a.a();
        if (a16 == null) {
            com.tencent.luggage.wxa.pe.a.b("MicroMsg.Ble.Action", "action:%s, bluetoothGatt is null", this);
            b(k.f135752l);
            d();
            return;
        }
        BluetoothGattService service = a16.getService(UUID.fromString(this.f133313n));
        if (service == null) {
            com.tencent.luggage.wxa.pe.a.b("MicroMsg.Ble.Action", "action:%s, gattService is null", this);
            b(k.f135750j);
            d();
            return;
        }
        if (!com.tencent.luggage.wxa.pe.c.b(this.f133314o)) {
            com.tencent.luggage.wxa.pe.a.b("MicroMsg.Ble.Action", "action:%s, characteristicId is illegal", this);
            b(k.f135751k);
            d();
            return;
        }
        BluetoothGattCharacteristic characteristic = service.getCharacteristic(UUID.fromString(this.f133314o));
        if (characteristic == null) {
            com.tencent.luggage.wxa.pe.a.b("MicroMsg.Ble.Action", "action:%s, gattCharacteristic is null", this);
            b(k.f135751k);
            d();
            return;
        }
        if (!com.tencent.luggage.wxa.pe.c.a(characteristic.getProperties())) {
            com.tencent.luggage.wxa.pe.a.b("MicroMsg.Ble.Action", "action:%s, not support indicate", this);
            b(k.f135753m);
            d();
            return;
        }
        if (!a16.setCharacteristicNotification(characteristic, this.f133315p)) {
            com.tencent.luggage.wxa.pe.a.b("MicroMsg.Ble.Action", "action:%s bluetoothGatt.setCharacteristicNotification fail", this);
            if (x.f144890a.a()) {
                kVar = k.c("setCharacteristicNotification fail");
            } else {
                kVar = k.f135754n;
            }
            b(kVar);
            d();
            return;
        }
        BluetoothGattDescriptor descriptor = characteristic.getDescriptor(com.tencent.luggage.wxa.me.a.f134464a);
        if (descriptor == null) {
            com.tencent.luggage.wxa.pe.a.b("MicroMsg.Ble.Action", "action:%s gattCharacteristic.getDescriptor fail", this);
            b(k.f135756p);
            d();
            return;
        }
        if (this.f133315p) {
            bArr = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
        } else {
            bArr = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        }
        if (!descriptor.setValue(bArr)) {
            com.tencent.luggage.wxa.pe.a.b("MicroMsg.Ble.Action", "action:%s gattDescriptor.setValue fail", this);
            b(k.f135757q);
            d();
        } else {
            if (!a16.writeDescriptor(descriptor)) {
                com.tencent.luggage.wxa.pe.a.b("MicroMsg.Ble.Action", "action:%s bluetoothGatt.writeDescriptor fail", this);
                b(k.f135758r);
                d();
                return;
            }
            b(k.f135745e);
        }
    }

    @Override // com.tencent.luggage.wxa.ne.a
    public String e() {
        return "IndicateCharacteristicAction";
    }

    @Override // com.tencent.luggage.wxa.ne.a
    public String toString() {
        return "IndicateCharacteristicAction#" + this.f135722m + "{serviceId='" + this.f133313n + "', characteristicId='" + this.f133314o + "', enable=" + this.f133315p + ", debug=" + this.f135715f + ", mainThread=" + this.f135716g + ", serial=" + this.f135717h + '}';
    }
}
