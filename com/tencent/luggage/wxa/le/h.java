package com.tencent.luggage.wxa.le;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import com.tencent.luggage.wxa.ne.k;
import com.tencent.luggage.wxa.xd.x;
import java.util.Iterator;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h extends com.tencent.luggage.wxa.ne.a {

    /* renamed from: n, reason: collision with root package name */
    public final String f133329n;

    /* renamed from: o, reason: collision with root package name */
    public final String f133330o;

    /* renamed from: p, reason: collision with root package name */
    public final Integer f133331p;

    public h(String str, String str2, Integer num) {
        this.f133329n = str;
        this.f133330o = str2;
        this.f133331p = num;
    }

    @Override // com.tencent.luggage.wxa.ne.a, com.tencent.luggage.wxa.ke.e
    public void a(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i3) {
        com.tencent.luggage.wxa.pe.a.c("MicroMsg.Ble.Action", "action:%s onCharacteristicRead status:%s", this, com.tencent.luggage.wxa.ne.f.b(i3));
        d();
    }

    @Override // com.tencent.luggage.wxa.ne.a
    public void c() {
        BluetoothGattCharacteristic characteristic;
        k kVar;
        BluetoothGatt a16 = this.f135710a.a();
        if (a16 == null) {
            com.tencent.luggage.wxa.pe.a.b("MicroMsg.Ble.Action", "action:%s, bluetoothGatt is null", this);
            b(k.f135752l);
            d();
            return;
        }
        if (!com.tencent.luggage.wxa.pe.c.b(this.f133329n)) {
            com.tencent.luggage.wxa.pe.a.b("MicroMsg.Ble.Action", "action:%s, serviceId is illegal", this);
            b(k.f135750j);
            d();
            return;
        }
        BluetoothGattService service = a16.getService(UUID.fromString(this.f133329n));
        if (service == null) {
            com.tencent.luggage.wxa.pe.a.b("MicroMsg.Ble.Action", "action:%s, gattService is null", this);
            b(k.f135750j);
            d();
            return;
        }
        if (!com.tencent.luggage.wxa.pe.c.b(this.f133330o)) {
            com.tencent.luggage.wxa.pe.a.b("MicroMsg.Ble.Action", "action:%s, characteristicId is illegal", this);
            b(k.f135751k);
            d();
            return;
        }
        UUID fromString = UUID.fromString(this.f133330o);
        Integer num = this.f133331p;
        if (num != null) {
            com.tencent.luggage.wxa.pe.a.c("MicroMsg.Ble.Action", "action:%s, handle: %d", this, num);
            Iterator<BluetoothGattCharacteristic> it = service.getCharacteristics().iterator();
            while (true) {
                if (it.hasNext()) {
                    characteristic = it.next();
                    if (fromString.equals(characteristic.getUuid()) && this.f133331p.intValue() == characteristic.getInstanceId()) {
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
        } else if (!com.tencent.luggage.wxa.pe.c.c(characteristic.getProperties())) {
            com.tencent.luggage.wxa.pe.a.b("MicroMsg.Ble.Action", "action:%s, not support read", this);
            b(k.f135753m);
            d();
        } else {
            if (!a16.readCharacteristic(characteristic)) {
                com.tencent.luggage.wxa.pe.a.b("MicroMsg.Ble.Action", "action:%s bluetoothGatt.readCharacteristic fail", this);
                if (x.f144890a.a()) {
                    kVar = k.c("readCharacteristic fail");
                } else {
                    kVar = k.f135754n;
                }
                b(kVar);
                d();
                return;
            }
            b(k.f135745e);
        }
    }

    @Override // com.tencent.luggage.wxa.ne.a
    public String e() {
        return "ReadCharacteristicAction";
    }

    @Override // com.tencent.luggage.wxa.ne.a
    public String toString() {
        return "ReadCharacteristicAction#" + this.f135722m + "{serviceId='" + this.f133329n + "', characteristicId='" + this.f133330o + "', debug=" + this.f135715f + ", mainThread=" + this.f135716g + ", serial=" + this.f135717h + '}';
    }
}
