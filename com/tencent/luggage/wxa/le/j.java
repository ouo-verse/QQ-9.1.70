package com.tencent.luggage.wxa.le;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.luggage.wxa.xd.x;
import com.tencent.mobileqq.msf.core.auth.k;
import java.util.Arrays;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class j extends com.tencent.luggage.wxa.ne.a {

    /* renamed from: n, reason: collision with root package name */
    public final String f133334n;

    /* renamed from: o, reason: collision with root package name */
    public final String f133335o;

    /* renamed from: p, reason: collision with root package name */
    public final Integer f133336p;

    /* renamed from: q, reason: collision with root package name */
    public final int f133337q;

    /* renamed from: r, reason: collision with root package name */
    public final String f133338r;

    public j(String str, String str2, Integer num, int i3, String str3) {
        this.f133334n = str;
        this.f133335o = str2;
        this.f133336p = num;
        this.f133337q = i3;
        this.f133338r = str3;
    }

    public static int a(JSONObject jSONObject) {
        String optString = jSONObject.optString("writeType");
        if (TextUtils.isEmpty(optString)) {
            return 0;
        }
        optString.hashCode();
        if (!optString.equals(k.f247492f)) {
            if (!optString.equals("writeNoResponse")) {
                return 0;
            }
            return 2;
        }
        return 1;
    }

    @Override // com.tencent.luggage.wxa.ne.a, com.tencent.luggage.wxa.ke.e
    public void b(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i3) {
        com.tencent.luggage.wxa.ne.k kVar;
        String b16 = com.tencent.luggage.wxa.ne.f.b(i3);
        com.tencent.luggage.wxa.pe.a.c("MicroMsg.Ble.Action", "action:%s onCharacteristicWrite status:%s", this, b16);
        if (i3 == 0) {
            b(com.tencent.luggage.wxa.ne.k.f135745e);
        } else {
            if (x.f144890a.a()) {
                kVar = com.tencent.luggage.wxa.ne.k.c("status: " + b16);
            } else {
                kVar = com.tencent.luggage.wxa.ne.k.f135754n;
            }
            b(kVar);
        }
        d();
    }

    @Override // com.tencent.luggage.wxa.ne.a
    public void c() {
        BluetoothGattCharacteristic characteristic;
        int i3;
        com.tencent.luggage.wxa.ne.k kVar;
        BluetoothGatt a16 = this.f135710a.a();
        if (a16 == null) {
            com.tencent.luggage.wxa.pe.a.b("MicroMsg.Ble.Action", "action:%s, bluetoothGatt is null", this);
            b(com.tencent.luggage.wxa.ne.k.f135752l);
            d();
            return;
        }
        if (!com.tencent.luggage.wxa.pe.c.b(this.f133334n)) {
            com.tencent.luggage.wxa.pe.a.b("MicroMsg.Ble.Action", "action:%s, serviceId is illegal", this);
            b(com.tencent.luggage.wxa.ne.k.f135750j);
            d();
            return;
        }
        BluetoothGattService service = a16.getService(UUID.fromString(this.f133334n));
        if (service == null) {
            com.tencent.luggage.wxa.pe.a.b("MicroMsg.Ble.Action", "action:%s, gattService is null", this);
            b(com.tencent.luggage.wxa.ne.k.f135750j);
            d();
            return;
        }
        if (!com.tencent.luggage.wxa.pe.c.b(this.f133335o)) {
            com.tencent.luggage.wxa.pe.a.b("MicroMsg.Ble.Action", "action:%s, characteristicId is illegal", this);
            b(com.tencent.luggage.wxa.ne.k.f135751k);
            d();
            return;
        }
        UUID fromString = UUID.fromString(this.f133335o);
        Integer num = this.f133336p;
        if (num != null) {
            com.tencent.luggage.wxa.pe.a.c("MicroMsg.Ble.Action", "action:%s, handle: %d", this, num);
            Iterator<BluetoothGattCharacteristic> it = service.getCharacteristics().iterator();
            while (true) {
                if (it.hasNext()) {
                    characteristic = it.next();
                    if (fromString.equals(characteristic.getUuid()) && this.f133336p.intValue() == characteristic.getInstanceId()) {
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
            b(com.tencent.luggage.wxa.ne.k.f135751k);
            d();
            return;
        }
        boolean d16 = com.tencent.luggage.wxa.pe.c.d(characteristic.getProperties());
        boolean e16 = com.tencent.luggage.wxa.pe.c.e(characteristic.getProperties());
        com.tencent.luggage.wxa.pe.a.b("MicroMsg.Ble.Action", "action:%s, writeType: %d, supportWrite: %b, supportWriteNoResponse: %b", this, Integer.valueOf(this.f133337q), Boolean.valueOf(d16), Boolean.valueOf(e16));
        if (!d16 && !e16) {
            b(com.tencent.luggage.wxa.ne.k.f135753m);
            d();
            return;
        }
        int i16 = this.f133337q;
        if ((1 == i16 && !d16) || (2 == i16 && !e16)) {
            b(com.tencent.luggage.wxa.ne.k.f135766z);
            d();
            return;
        }
        int writeType = characteristic.getWriteType();
        int i17 = this.f133337q;
        if (i17 != 1) {
            if (i17 == 2) {
                characteristic.setWriteType(1);
            }
        } else {
            characteristic.setWriteType(2);
        }
        byte[] a17 = com.tencent.luggage.wxa.pe.c.a(Base64.decode(this.f133338r, 2));
        characteristic.setValue(a17);
        Object[] objArr = new Object[1];
        if (a17 != null) {
            i3 = a17.length;
        } else {
            i3 = 0;
        }
        objArr[0] = Integer.valueOf(i3);
        com.tencent.luggage.wxa.pe.a.d("MicroMsg.Ble.Action", "dataToWrite's length:%d", objArr);
        if (this.f135715f) {
            com.tencent.luggage.wxa.pe.a.c("MicroMsg.Ble.Action", "dataToWrite:%s", Arrays.toString(a17));
        }
        if (!a16.writeCharacteristic(characteristic)) {
            com.tencent.luggage.wxa.pe.a.b("MicroMsg.Ble.Action", "action:%s bluetoothGatt.writeCharacteristic fail", this);
            characteristic.setWriteType(writeType);
            if (x.f144890a.a()) {
                kVar = com.tencent.luggage.wxa.ne.k.c("writeCharacteristic fail");
            } else {
                kVar = com.tencent.luggage.wxa.ne.k.f135754n;
            }
            b(kVar);
            d();
            return;
        }
        characteristic.setWriteType(writeType);
    }

    @Override // com.tencent.luggage.wxa.ne.a
    public String e() {
        return "WriteCharacteristicAction";
    }

    @Override // com.tencent.luggage.wxa.ne.a
    public String toString() {
        return "WriteCharacteristicAction#" + this.f135722m + "{serviceId='" + this.f133334n + "', characteristicId='" + this.f133335o + "', value='" + this.f133338r + "', debug=" + this.f135715f + ", mainThread=" + this.f135716g + ", serial=" + this.f135717h + '}';
    }
}
