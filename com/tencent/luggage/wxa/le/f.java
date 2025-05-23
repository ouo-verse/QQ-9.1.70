package com.tencent.luggage.wxa.le;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import com.tencent.luggage.wxa.ne.k;
import com.tencent.luggage.wxa.xd.x;
import java.util.Iterator;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f extends com.tencent.luggage.wxa.ne.a {

    /* renamed from: n, reason: collision with root package name */
    public final String f133316n;

    /* renamed from: o, reason: collision with root package name */
    public final String f133317o;

    /* renamed from: p, reason: collision with root package name */
    public final Integer f133318p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f133319q;

    public f(String str, String str2, Integer num, boolean z16) {
        this.f133316n = str;
        this.f133317o = str2;
        this.f133318p = num;
        this.f133319q = z16;
    }

    @Override // com.tencent.luggage.wxa.ne.a, com.tencent.luggage.wxa.ke.e
    public void b(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i3) {
        com.tencent.luggage.wxa.pe.a.c("MicroMsg.Ble.Action", "action:%s onDescriptorWrite status:%s", this, com.tencent.luggage.wxa.ne.f.b(i3));
        d();
    }

    @Override // com.tencent.luggage.wxa.ne.a
    public void c() {
        BluetoothGattCharacteristic characteristic;
        byte[] bArr;
        k kVar;
        BluetoothGatt a16 = this.f135710a.a();
        if (a16 == null) {
            com.tencent.luggage.wxa.pe.a.b("MicroMsg.Ble.Action", "action:%s, bluetoothGatt is null", this);
            b(k.f135752l);
            d();
            return;
        }
        if (!com.tencent.luggage.wxa.pe.c.b(this.f133316n)) {
            com.tencent.luggage.wxa.pe.a.b("MicroMsg.Ble.Action", "action:%s, serviceId is illegal", this);
            b(k.f135750j);
            d();
            return;
        }
        BluetoothGattService service = a16.getService(UUID.fromString(this.f133316n));
        if (service == null) {
            com.tencent.luggage.wxa.pe.a.b("MicroMsg.Ble.Action", "action:%s, gattService is null", this);
            b(k.f135750j);
            d();
            return;
        }
        if (!com.tencent.luggage.wxa.pe.c.b(this.f133317o)) {
            com.tencent.luggage.wxa.pe.a.b("MicroMsg.Ble.Action", "action:%s, characteristicId is illegal", this);
            b(k.f135751k);
            d();
            return;
        }
        UUID fromString = UUID.fromString(this.f133317o);
        Integer num = this.f133318p;
        if (num != null) {
            com.tencent.luggage.wxa.pe.a.c("MicroMsg.Ble.Action", "action:%s, handle: %d", this, num);
            Iterator<BluetoothGattCharacteristic> it = service.getCharacteristics().iterator();
            while (true) {
                if (it.hasNext()) {
                    characteristic = it.next();
                    if (fromString.equals(characteristic.getUuid()) && this.f133318p.intValue() == characteristic.getInstanceId()) {
                        break;
                    }
                } else {
                    characteristic = null;
                    break;
                }
            }
        } else {
            characteristic = service.getCharacteristic(fromString);
        }
        if (characteristic == null) {
            com.tencent.luggage.wxa.pe.a.b("MicroMsg.Ble.Action", "action:%s, gattCharacteristic is null", this);
            b(k.f135751k);
            d();
            return;
        }
        if (!com.tencent.luggage.wxa.pe.c.b(characteristic.getProperties())) {
            com.tencent.luggage.wxa.pe.a.b("MicroMsg.Ble.Action", "action:%s, not support notify", this);
            b(k.f135753m);
            d();
            return;
        }
        if (!a16.setCharacteristicNotification(characteristic, this.f133319q)) {
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
        if (this.f133319q) {
            bArr = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
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
        return "NotifyCharacteristicAction";
    }

    @Override // com.tencent.luggage.wxa.ne.a
    public String toString() {
        return "NotifyCharacteristicAction#" + this.f135722m + "{serviceId='" + this.f133316n + "', characteristicId='" + this.f133317o + "', enable=" + this.f133319q + ", debug=" + this.f135715f + ", mainThread=" + this.f135716g + ", serial=" + this.f135717h + '}';
    }
}
