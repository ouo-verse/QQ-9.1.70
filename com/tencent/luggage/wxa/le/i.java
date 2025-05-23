package com.tencent.luggage.wxa.le;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import com.tencent.luggage.wxa.ne.k;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.x;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class i extends com.tencent.luggage.wxa.ne.a {

    /* renamed from: n, reason: collision with root package name */
    public final Integer f133332n;

    /* renamed from: o, reason: collision with root package name */
    public final String f133333o;

    public i(Integer num, String str) {
        this.f133332n = num;
        this.f133333o = str;
    }

    @Override // com.tencent.luggage.wxa.ne.a, com.tencent.luggage.wxa.ke.e
    public void a(BluetoothGatt gatt, int i3, int i16) {
        k kVar;
        Intrinsics.checkNotNullParameter(gatt, "gatt");
        super.a(gatt, i3, i16);
        String b16 = com.tencent.luggage.wxa.ne.f.b(i16);
        w.d("MicroMsg.Ble.Action", "onMtuChanged: mtu = %d, status = %s", Integer.valueOf(i3), b16);
        if (i16 == 0) {
            Integer num = this.f133332n;
            if (num != null && i3 == num.intValue()) {
                b(k.b(Integer.valueOf(i3)));
            } else {
                b(k.a(Integer.valueOf(i3)));
            }
        } else {
            if (x.f144890a.a()) {
                kVar = k.a("status: " + b16);
            } else {
                kVar = k.f135747g;
            }
            b(kVar);
        }
        d();
    }

    @Override // com.tencent.luggage.wxa.ne.a
    public void c() {
        k kVar;
        if (com.tencent.luggage.wxa.pe.c.e() == null) {
            com.tencent.luggage.wxa.pe.a.b("MicroMsg.Ble.Action", "action:%s, bluetoothAdapter is null", this);
            b(k.f135749i);
            d();
            return;
        }
        String str = this.f133333o;
        if (str != null && BluetoothAdapter.checkBluetoothAddress(str) && this.f133332n != null) {
            if (!com.tencent.luggage.wxa.pe.c.a()) {
                com.tencent.luggage.wxa.pe.a.b("MicroMsg.Ble.Action", "bluetooth is not enable.", new Object[0]);
                b(k.f135749i);
                d();
                return;
            }
            BluetoothGatt a16 = this.f135710a.a();
            if (a16 == null) {
                b(k.f135752l);
                d();
                return;
            }
            if (this.f133332n.intValue() > 512) {
                b(new k(10013, "fail:invalid data, DEFAULT_MAX_MTU = 512", com.tencent.luggage.wxa.af.e.f121315k));
                d();
                return;
            }
            if (this.f133332n.intValue() < 23) {
                b(new k(10013, "fail:invalid data, DEFAULT_MIN_MTU = 23", com.tencent.luggage.wxa.af.e.f121315k));
                d();
                return;
            }
            int d16 = this.f135710a.d();
            com.tencent.luggage.wxa.pe.a.c("MicroMsg.Ble.Action", "action:" + this + ", mtuSize: " + this.f133332n + ", curMtu: " + d16, new Object[0]);
            Integer num = this.f133332n;
            if (num != null && num.intValue() == d16) {
                b(k.b(Integer.valueOf(d16)));
                d();
                return;
            } else {
                if (!a16.requestMtu(this.f133332n.intValue())) {
                    if (x.f144890a.a()) {
                        kVar = k.c("requestMtu fail");
                    } else {
                        kVar = k.f135754n;
                    }
                    b(kVar);
                    d();
                    return;
                }
                return;
            }
        }
        com.tencent.luggage.wxa.pe.a.d("MicroMsg.Ble.Action", "action:%s, unspecified deviceId", this);
        b(k.f135761u);
        d();
    }

    @Override // com.tencent.luggage.wxa.ne.a
    public String e() {
        return "SetMtuAction";
    }
}
