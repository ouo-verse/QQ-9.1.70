package com.tencent.luggage.wxa.le;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.os.Looper;
import com.tencent.luggage.wxa.ne.k;
import com.tencent.luggage.wxa.xd.x;
import com.tencent.mtt.hippy.dom.node.TextNode;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends com.tencent.luggage.wxa.ne.a {

    /* renamed from: n, reason: collision with root package name */
    public String f133300n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f133301o;

    /* renamed from: p, reason: collision with root package name */
    public String f133302p = "LE";

    /* renamed from: q, reason: collision with root package name */
    public long f133303q = 0;

    /* renamed from: r, reason: collision with root package name */
    public String f133304r = null;

    /* renamed from: s, reason: collision with root package name */
    public boolean f133305s = true;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BluetoothGatt f133306a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f133307b;

        public a(BluetoothGatt bluetoothGatt, int i3) {
            this.f133306a = bluetoothGatt;
            this.f133307b = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Integer f16 = b.this.f();
            if (f16 != null) {
                com.tencent.luggage.wxa.pe.a.c("MicroMsg.Ble.ConnectAction", "Attempting to requestConnectionPriority, " + f16, new Object[0]);
                if (!this.f133306a.requestConnectionPriority(f16.intValue())) {
                    com.tencent.luggage.wxa.pe.a.d("MicroMsg.Ble.ConnectAction", "requestConnectionPriority fail", new Object[0]);
                }
            }
            b bVar = b.this;
            if (bVar.f133305s) {
                com.tencent.luggage.wxa.pe.a.c("MicroMsg.Ble.ConnectAction", "Attempting to start service discovery", new Object[0]);
                this.f133306a.discoverServices();
                return;
            }
            int i3 = this.f133307b;
            if (i3 == 0) {
                bVar.b(k.f135745e);
            } else {
                bVar.b(bVar.a(i3));
            }
            b.this.d();
            b.this.f135710a.c(this.f133306a, this.f133307b);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.le.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC6433b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f133309a;

        public RunnableC6433b(int i3) {
            this.f133309a = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.pe.a.c("MicroMsg.Ble.ConnectAction", "close", new Object[0]);
            b.this.f135710a.a(false);
            b bVar = b.this;
            bVar.b(bVar.a(this.f133309a));
            b.this.d();
        }
    }

    public b(String str) {
        this.f133300n = str;
    }

    @Override // com.tencent.luggage.wxa.ne.a
    public String e() {
        return "ConnectAction";
    }

    public final Integer f() {
        String str = this.f133304r;
        if (str == null) {
            return null;
        }
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1924829944:
                if (str.equals(TextNode.STRATEGY_BALANCED)) {
                    c16 = 0;
                    break;
                }
                break;
            case -1837176303:
                if (str.equals("lowPower")) {
                    c16 = 1;
                    break;
                }
                break;
            case 3202466:
                if (str.equals("high")) {
                    c16 = 2;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return 0;
            case 1:
                return 2;
            case 2:
                return 1;
            default:
                return null;
        }
    }

    @Override // com.tencent.luggage.wxa.ne.a
    public String toString() {
        return "ConnectAction#" + this.f135722m + "{deviceId='" + this.f133300n + "', debug=" + this.f135715f + ", mainThread=" + this.f135716g + ", serial=" + this.f135717h + '}';
    }

    @Override // com.tencent.luggage.wxa.ne.a, com.tencent.luggage.wxa.ke.e
    public void b(BluetoothGatt bluetoothGatt, int i3) {
        k kVar;
        String b16 = com.tencent.luggage.wxa.ne.f.b(i3);
        com.tencent.luggage.wxa.pe.a.c("MicroMsg.Ble.ConnectAction", "[onServicesDiscovered] status:%s", b16);
        this.f135710a.a(bluetoothGatt);
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
        this.f135710a.c(bluetoothGatt, i3);
    }

    @Override // com.tencent.luggage.wxa.ne.a
    public void c() {
        BluetoothGatt connectGatt;
        k kVar;
        BluetoothAdapter e16 = com.tencent.luggage.wxa.pe.c.e();
        if (e16 == null) {
            com.tencent.luggage.wxa.pe.a.b("MicroMsg.Ble.ConnectAction", "action:%s, bluetoothAdapter is null", this);
            b(k.f135749i);
            d();
            return;
        }
        String str = this.f133300n;
        if (str != null && BluetoothAdapter.checkBluetoothAddress(str)) {
            if (!com.tencent.luggage.wxa.pe.c.a()) {
                com.tencent.luggage.wxa.pe.a.b("MicroMsg.Ble.ConnectAction", "bluetooth is not enable.", new Object[0]);
                b(k.f135749i);
                d();
                return;
            }
            if (this.f135710a.a() != null) {
                com.tencent.luggage.wxa.pe.a.d("MicroMsg.Ble.ConnectAction", "already connect, please close", new Object[0]);
                b(k.f135760t);
                d();
                return;
            }
            BluetoothDevice remoteDevice = e16.getRemoteDevice(this.f133300n);
            if (remoteDevice != null) {
                com.tencent.luggage.wxa.pe.a.c("MicroMsg.Ble.ConnectAction", "autoConnect:%b transport:%s", Boolean.valueOf(this.f133301o), this.f133302p);
                String upperCase = this.f133302p.toUpperCase();
                upperCase.hashCode();
                char c16 = '\uffff';
                switch (upperCase.hashCode()) {
                    case 2425:
                        if (upperCase.equals("LE")) {
                            c16 = 0;
                            break;
                        }
                        break;
                    case 2020783:
                        if (upperCase.equals("AUTO")) {
                            c16 = 1;
                            break;
                        }
                        break;
                    case 63463747:
                        if (upperCase.equals("BREDR")) {
                            c16 = 2;
                            break;
                        }
                        break;
                }
                switch (c16) {
                    case 0:
                        connectGatt = remoteDevice.connectGatt(this.f135710a.c(), this.f133301o, new com.tencent.luggage.wxa.ke.a(this.f135710a), 2);
                        break;
                    case 1:
                        connectGatt = remoteDevice.connectGatt(this.f135710a.c(), this.f133301o, new com.tencent.luggage.wxa.ke.a(this.f135710a), 0);
                        break;
                    case 2:
                        connectGatt = remoteDevice.connectGatt(this.f135710a.c(), this.f133301o, new com.tencent.luggage.wxa.ke.a(this.f135710a), 1);
                        break;
                    default:
                        connectGatt = remoteDevice.connectGatt(this.f135710a.c(), this.f133301o, new com.tencent.luggage.wxa.ke.a(this.f135710a), 2);
                        break;
                }
                if (connectGatt != null) {
                    com.tencent.luggage.wxa.pe.a.c("MicroMsg.Ble.ConnectAction", "mBluetoothGatt:%s", connectGatt);
                    Object[] objArr = new Object[2];
                    objArr[0] = this.f133300n;
                    objArr[1] = Boolean.valueOf(Thread.currentThread() == Looper.getMainLooper().getThread());
                    com.tencent.luggage.wxa.pe.a.c("MicroMsg.Ble.ConnectAction", "create a new connection deviceId=%s mainthread:%b", objArr);
                    this.f135710a.a(connectGatt);
                    return;
                }
                Object[] objArr2 = new Object[2];
                objArr2[0] = this.f133300n;
                objArr2[1] = Boolean.valueOf(Thread.currentThread() == Looper.getMainLooper().getThread());
                com.tencent.luggage.wxa.pe.a.b("MicroMsg.Ble.ConnectAction", "Get Gatt fail!, deviceId=%s mainthread:%b", objArr2);
                if (x.f144890a.a()) {
                    kVar = k.a("gatt is null");
                } else {
                    kVar = k.f135747g;
                }
                b(kVar);
                d();
                return;
            }
            com.tencent.luggage.wxa.pe.a.b("MicroMsg.Ble.ConnectAction", "Device not found, deviceId=%s", this.f133300n);
            b(k.f135747g);
            d();
            return;
        }
        com.tencent.luggage.wxa.pe.a.d("MicroMsg.Ble.ConnectAction", "action:%s, unspecified deviceId", this);
        b(k.f135761u);
        d();
    }

    @Override // com.tencent.luggage.wxa.ne.a
    public void a(k kVar) {
        if (kVar.f135767a != 10012) {
            return;
        }
        this.f135710a.a(false);
    }

    public final k a(int i3) {
        return new k(10003, "fail:connection fail status:" + i3, com.tencent.luggage.wxa.af.b.W);
    }

    @Override // com.tencent.luggage.wxa.ne.a, com.tencent.luggage.wxa.ke.e
    public void c(BluetoothGatt bluetoothGatt, int i3, int i16) {
        Object[] objArr = new Object[3];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.toString() : "";
        objArr[1] = com.tencent.luggage.wxa.ne.f.b(i3);
        objArr[2] = i16 == 2 ? "CONNECTED" : "DISCONNECTED";
        com.tencent.luggage.wxa.pe.a.c("MicroMsg.Ble.ConnectAction", "[onConnectionStateChange]gatt:%s gattStatus:%s, newState:%s", objArr);
        this.f135710a.a(bluetoothGatt);
        if (i16 != 2) {
            if (i16 == 0) {
                this.f135713d.post(new RunnableC6433b(i3));
            }
        } else {
            if (bluetoothGatt == null) {
                com.tencent.luggage.wxa.pe.a.d("MicroMsg.Ble.ConnectAction", "[onConnectionStateChange] gatt is null", new Object[0]);
                return;
            }
            com.tencent.luggage.wxa.pe.a.c("MicroMsg.Ble.ConnectAction", "[onConnectionStateChange] discoverServicesDelayMills: " + this.f133303q, new Object[0]);
            this.f135713d.postDelayed(new a(bluetoothGatt, i3), this.f133303q);
        }
    }
}
