package com.tencent.luggage.wxa.ke;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Base64;
import com.tencent.luggage.wxa.ne.f;
import com.tencent.luggage.wxa.ne.g;
import com.tencent.luggage.wxa.ne.h;
import com.tencent.luggage.wxa.ne.i;
import com.tencent.luggage.wxa.tn.w0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d implements e {

    /* renamed from: b, reason: collision with root package name */
    public final Context f131923b;

    /* renamed from: c, reason: collision with root package name */
    public String f131924c;

    /* renamed from: d, reason: collision with root package name */
    public volatile b f131925d;

    /* renamed from: e, reason: collision with root package name */
    public volatile BluetoothGatt f131926e;

    /* renamed from: f, reason: collision with root package name */
    public List f131927f;

    /* renamed from: g, reason: collision with root package name */
    public volatile Map f131928g;

    /* renamed from: k, reason: collision with root package name */
    public final c f131932k;

    /* renamed from: a, reason: collision with root package name */
    public final String f131922a = "MicroMsg.Ble.BleConnectWorker#" + hashCode();

    /* renamed from: h, reason: collision with root package name */
    public volatile i f131929h = null;

    /* renamed from: i, reason: collision with root package name */
    public volatile h f131930i = null;

    /* renamed from: j, reason: collision with root package name */
    public volatile g f131931j = null;

    /* renamed from: l, reason: collision with root package name */
    public volatile int f131933l = -1;

    /* renamed from: m, reason: collision with root package name */
    public BroadcastReceiver f131934m = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            if (Objects.equals(action, "android.bluetooth.device.action.ACL_CONNECTED")) {
                if (bluetoothDevice != null) {
                    com.tencent.luggage.wxa.pe.a.a("MicroMsg.Ble.BleConnectWorker", "onConnectStateReceiver, ACTION_ACL_CONNECTED, deviceId = %s", bluetoothDevice.getAddress());
                }
            } else if (Objects.equals(action, "android.bluetooth.device.action.ACL_DISCONNECTED") && bluetoothDevice != null) {
                String address = bluetoothDevice.getAddress();
                com.tencent.luggage.wxa.pe.a.a("MicroMsg.Ble.BleConnectWorker", "onConnectStateReceiver, ACTION_ACL_DISCONNECTED, deviceId = %s", address);
                if (Objects.equals(address, d.this.f131924c)) {
                    d dVar = d.this;
                    dVar.c(dVar.f131926e, 0, 0);
                }
            }
        }
    }

    public d(Context context, String str, c cVar) {
        this.f131923b = context;
        this.f131924c = str;
        this.f131932k = cVar;
    }

    public final synchronized b b() {
        b bVar;
        bVar = this.f131925d;
        if (bVar == null) {
            bVar = new b();
            bVar.a();
            this.f131925d = bVar;
        }
        return bVar;
    }

    public Context c() {
        return this.f131923b;
    }

    public int d() {
        return this.f131933l;
    }

    public synchronized List e() {
        boolean z16;
        BluetoothGatt bluetoothGatt = this.f131926e;
        if (bluetoothGatt == null) {
            com.tencent.luggage.wxa.pe.a.b(this.f131922a, "[getServices] bluetoothGatt is null, err", new Object[0]);
            return null;
        }
        if (w0.c(this.f131924c)) {
            com.tencent.luggage.wxa.pe.a.b(this.f131922a, "[getServices] deviceId is null, err", new Object[0]);
            return null;
        }
        if (this.f131927f == null) {
            List<BluetoothGattService> services = bluetoothGatt.getServices();
            if (services == null) {
                com.tencent.luggage.wxa.pe.a.d(this.f131922a, "[getServices] bluetoothGattServices is null, err", new Object[0]);
                return null;
            }
            this.f131927f = new ArrayList();
            ArrayList arrayList = new ArrayList();
            for (BluetoothGattService bluetoothGattService : services) {
                com.tencent.luggage.wxa.ne.e eVar = new com.tencent.luggage.wxa.ne.e();
                eVar.f135742a = bluetoothGattService.getUuid().toString().toUpperCase();
                if (bluetoothGattService.getType() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                eVar.f135743b = z16;
                if (!eVar.f135742a.equals("00001800-0000-1000-8000-00805F9B34FB") && !eVar.f135742a.equals("00001801-0000-1000-8000-00805F9B34FB")) {
                    this.f131927f.add(eVar);
                }
                arrayList.add(eVar);
            }
            if (arrayList.size() > 0) {
                this.f131927f.addAll(arrayList);
            }
        } else {
            com.tencent.luggage.wxa.pe.a.c(this.f131922a, "[getServices] use cache", new Object[0]);
        }
        return new ArrayList(this.f131927f);
    }

    public synchronized List f() {
        boolean z16;
        BluetoothGatt bluetoothGatt = this.f131926e;
        if (bluetoothGatt == null) {
            com.tencent.luggage.wxa.pe.a.b(this.f131922a, "[getServicesNoCache] bluetoothGatt is null, err", new Object[0]);
            return null;
        }
        if (w0.c(this.f131924c)) {
            com.tencent.luggage.wxa.pe.a.b(this.f131922a, "[getServicesNoCache] deviceId is null, err", new Object[0]);
            return null;
        }
        List<BluetoothGattService> services = bluetoothGatt.getServices();
        if (services == null) {
            com.tencent.luggage.wxa.pe.a.d(this.f131922a, "[getServicesNoCache] bluetoothGattServices is null, err", new Object[0]);
            return null;
        }
        this.f131927f = new ArrayList();
        ArrayList arrayList = new ArrayList();
        for (BluetoothGattService bluetoothGattService : services) {
            com.tencent.luggage.wxa.ne.e eVar = new com.tencent.luggage.wxa.ne.e();
            eVar.f135742a = bluetoothGattService.getUuid().toString().toUpperCase();
            if (bluetoothGattService.getType() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            eVar.f135743b = z16;
            if (!eVar.f135742a.equals("00001800-0000-1000-8000-00805F9B34FB") && !eVar.f135742a.equals("00001801-0000-1000-8000-00805F9B34FB")) {
                this.f131927f.add(eVar);
            }
            arrayList.add(eVar);
        }
        if (arrayList.size() > 0) {
            this.f131927f.addAll(arrayList);
        }
        return new ArrayList(this.f131927f);
    }

    public synchronized void g() {
        com.tencent.luggage.wxa.pe.a.c(this.f131922a, "init deviceId:%s", this.f131924c);
        if (this.f131923b != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
            intentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
            this.f131923b.registerReceiver(this.f131934m, intentFilter);
        }
        this.f131925d = b();
        this.f131928g = new ConcurrentHashMap();
    }

    public synchronized void h() {
        com.tencent.luggage.wxa.pe.a.c(this.f131922a, "uninit deviceId:%s", this.f131924c);
        Context context = this.f131923b;
        if (context != null) {
            context.unregisterReceiver(this.f131934m);
        }
        b(true);
        b bVar = this.f131925d;
        if (bVar != null) {
            bVar.c();
            this.f131925d = null;
        }
        List list = this.f131927f;
        if (list != null) {
            list.clear();
            this.f131927f = null;
        }
        Map map = this.f131928g;
        if (map != null) {
            map.clear();
            this.f131928g = null;
        }
        this.f131929h = null;
        this.f131930i = null;
        this.f131931j = null;
    }

    public void a(BluetoothGatt bluetoothGatt) {
        this.f131926e = bluetoothGatt;
    }

    @Override // com.tencent.luggage.wxa.ke.e
    public void c(BluetoothGatt bluetoothGatt, int i3, int i16) {
        String str = this.f131922a;
        Object[] objArr = new Object[3];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.getDevice().getAddress() : "";
        objArr[1] = f.b(i3);
        objArr[2] = i16 == 2 ? "CONNECTED" : "DISCONNECTED";
        com.tencent.luggage.wxa.pe.a.c(str, "[onConnectionStateChange]gatt deviceId:%s gattStatus:%s, newState:%s", objArr);
        b bVar = this.f131925d;
        if (bVar == null) {
            return;
        }
        bVar.c(bluetoothGatt, i3, i16);
        if (i3 != 0) {
            a(true);
        } else if (i16 != 2 && i16 == 0) {
            a(true);
        }
    }

    public BluetoothGatt a() {
        return this.f131926e;
    }

    public synchronized void a(boolean z16) {
        com.tencent.luggage.wxa.pe.a.c(this.f131922a, "closeMyself deviceId:%s", this.f131924c);
        b(z16);
        b bVar = this.f131925d;
        if (bVar != null) {
            bVar.c();
            this.f131925d = null;
        }
        List list = this.f131927f;
        if (list != null) {
            list.clear();
            this.f131927f = null;
        }
        Map map = this.f131928g;
        if (map != null) {
            map.clear();
            this.f131928g = null;
        }
        this.f131932k.b(this.f131924c);
    }

    public final synchronized void b(boolean z16) {
        BluetoothGatt bluetoothGatt = this.f131926e;
        if (bluetoothGatt != null) {
            com.tencent.luggage.wxa.pe.a.c(this.f131922a, "deviceId:%s innerCloseMyself", this.f131924c);
            if (z16) {
                a(this.f131924c, false);
            }
            if (com.tencent.luggage.wxa.je.a.a().f130968i) {
                com.tencent.luggage.wxa.pe.a.c(this.f131922a, "deviceId:%s refreshGattCache", this.f131924c);
                com.tencent.luggage.wxa.pe.c.a(this.f131926e);
            }
            try {
                bluetoothGatt.disconnect();
                bluetoothGatt.close();
                this.f131926e = null;
            } catch (Exception unused) {
            }
        }
    }

    public void c(BluetoothGatt bluetoothGatt, int i3) {
        if (bluetoothGatt != null && i3 == 0) {
            a(bluetoothGatt.getDevice().getAddress(), true);
        }
    }

    @Override // com.tencent.luggage.wxa.ke.e
    public void b(BluetoothGatt bluetoothGatt, int i3) {
        String str = this.f131922a;
        Object[] objArr = new Object[2];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.getDevice().getAddress() : "";
        objArr[1] = f.b(i3);
        com.tencent.luggage.wxa.pe.a.c(str, "[onServicesDiscovered]gatt deviceId:%s status:%s", objArr);
        b bVar = this.f131925d;
        if (bVar == null) {
            return;
        }
        bVar.b(bluetoothGatt, i3);
    }

    public void a(i iVar) {
        this.f131929h = iVar;
    }

    public void a(h hVar) {
        this.f131930i = hVar;
    }

    public void a(g gVar) {
        this.f131931j = gVar;
    }

    public void a(com.tencent.luggage.wxa.ne.a aVar, com.tencent.luggage.wxa.ne.b bVar) {
        com.tencent.luggage.wxa.pe.a.c(this.f131922a, "deviceId:%s aciton:%s", this.f131924c, aVar);
        b bVar2 = this.f131925d;
        if (bVar2 == null) {
            return;
        }
        aVar.a(this);
        aVar.a(bVar2);
        aVar.a(bVar);
        bVar2.a(aVar);
    }

    @Override // com.tencent.luggage.wxa.ke.e
    public void b(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i3) {
        String str = this.f131922a;
        Object[] objArr = new Object[4];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.getDevice().getAddress() : "";
        objArr[1] = bluetoothGattCharacteristic != null ? bluetoothGattCharacteristic.getUuid().toString().toUpperCase() : "";
        objArr[2] = bluetoothGattCharacteristic != null ? Arrays.asList(bluetoothGattCharacteristic.getValue()) : "";
        objArr[3] = f.b(i3);
        com.tencent.luggage.wxa.pe.a.c(str, "[onCharacteristicWrite]gatt deviceId:%s characteristicId:%s value:%s, status:%s", objArr);
        b bVar = this.f131925d;
        if (bVar == null) {
            return;
        }
        bVar.b(bluetoothGatt, bluetoothGattCharacteristic, i3);
    }

    public List a(String str) {
        BluetoothGatt bluetoothGatt = this.f131926e;
        if (bluetoothGatt == null) {
            com.tencent.luggage.wxa.pe.a.b(this.f131922a, "[getCharacteristics] bluetoothGatt is null, err", new Object[0]);
            return null;
        }
        if (w0.c(str)) {
            com.tencent.luggage.wxa.pe.a.b(this.f131922a, "[getCharacteristics] serviceId is null, err", new Object[0]);
            return null;
        }
        if (!com.tencent.luggage.wxa.pe.c.b(str)) {
            com.tencent.luggage.wxa.pe.a.b(this.f131922a, "[getCharacteristics] serviceId is illegal, err", new Object[0]);
            return null;
        }
        Map map = this.f131928g;
        if (map == null) {
            com.tencent.luggage.wxa.pe.a.b(this.f131922a, "[getCharacteristics] bluetoothCharacteristics is null, err", new Object[0]);
            return null;
        }
        List list = (List) map.get(str);
        if (list == null) {
            BluetoothGattService service = bluetoothGatt.getService(UUID.fromString(str));
            if (service == null) {
                com.tencent.luggage.wxa.pe.a.d(this.f131922a, "[getCharacteristics] bluetoothGattServices is null, err", new Object[0]);
                return null;
            }
            List<BluetoothGattCharacteristic> characteristics = service.getCharacteristics();
            if (characteristics == null) {
                com.tencent.luggage.wxa.pe.a.d(this.f131922a, "[getCharacteristics] characteristics is null, err", new Object[0]);
                return null;
            }
            list = new ArrayList();
            for (BluetoothGattCharacteristic bluetoothGattCharacteristic : characteristics) {
                com.tencent.luggage.wxa.ne.c cVar = new com.tencent.luggage.wxa.ne.c();
                cVar.f135726a = bluetoothGattCharacteristic.getUuid().toString().toUpperCase();
                int properties = bluetoothGattCharacteristic.getProperties();
                cVar.f135727b = com.tencent.luggage.wxa.pe.c.c(properties);
                cVar.f135728c = com.tencent.luggage.wxa.pe.c.d(properties);
                cVar.f135729d = com.tencent.luggage.wxa.pe.c.e(properties);
                cVar.f135730e = com.tencent.luggage.wxa.pe.c.b(properties);
                cVar.f135731f = com.tencent.luggage.wxa.pe.c.a(properties);
                cVar.f135732g = bluetoothGattCharacteristic.getInstanceId();
                list.add(cVar);
            }
            map.put(str, list);
        } else {
            com.tencent.luggage.wxa.pe.a.c(this.f131922a, "[getCharacteristics] use cache", new Object[0]);
        }
        if (this.f131926e == null) {
            return null;
        }
        return list;
    }

    @Override // com.tencent.luggage.wxa.ke.e
    public void b(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i3) {
        String str = this.f131922a;
        Object[] objArr = new Object[2];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.getDevice().getAddress() : "";
        objArr[1] = bluetoothGattDescriptor != null ? bluetoothGattDescriptor.getUuid().toString().toUpperCase() : "";
        com.tencent.luggage.wxa.pe.a.c(str, "[onDescriptorWrite]gatt deviceId:%s descriptorId:%s", objArr);
        b bVar = this.f131925d;
        if (bVar == null) {
            return;
        }
        bVar.b(bluetoothGatt, bluetoothGattDescriptor, i3);
    }

    @Override // com.tencent.luggage.wxa.ke.e
    public void b(BluetoothGatt bluetoothGatt, int i3, int i16) {
        String str = this.f131922a;
        Object[] objArr = new Object[3];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.getDevice().getAddress() : "";
        objArr[1] = Integer.valueOf(i3);
        objArr[2] = f.b(i16);
        com.tencent.luggage.wxa.pe.a.c(str, "[onReadRemoteRssi]gatt deviceId:%s rssi:%d status:%s", objArr);
        b bVar = this.f131925d;
        if (bVar == null) {
            return;
        }
        bVar.b(bluetoothGatt, i3, i16);
    }

    public com.tencent.luggage.wxa.ne.c a(String str, String str2, Integer num) {
        BluetoothGattCharacteristic characteristic;
        BluetoothGatt bluetoothGatt = this.f131926e;
        if (bluetoothGatt == null) {
            com.tencent.luggage.wxa.pe.a.b(this.f131922a, "[getCharacteristic] bluetoothGatt is null, err", new Object[0]);
            return null;
        }
        if (!w0.c(str) && !w0.c(str2)) {
            if (!com.tencent.luggage.wxa.pe.c.b(str)) {
                com.tencent.luggage.wxa.pe.a.b(this.f131922a, "[getCharacteristics] serviceId is illegal, err", new Object[0]);
                return null;
            }
            if (!com.tencent.luggage.wxa.pe.c.b(str2)) {
                com.tencent.luggage.wxa.pe.a.b(this.f131922a, "[getCharacteristics] characteristicId is illegal, err", new Object[0]);
                return null;
            }
            BluetoothGattService service = bluetoothGatt.getService(UUID.fromString(str));
            if (service == null) {
                com.tencent.luggage.wxa.pe.a.d(this.f131922a, "[getCharacteristic] bluetoothGattServices is null, err", new Object[0]);
                return null;
            }
            UUID fromString = UUID.fromString(str2);
            if (num != null) {
                com.tencent.luggage.wxa.pe.a.c("MicroMsg.Ble.BleConnectWorker", "[getCharacteristic] handle: %d", num);
                Iterator<BluetoothGattCharacteristic> it = service.getCharacteristics().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        characteristic = null;
                        break;
                    }
                    characteristic = it.next();
                    if (fromString.equals(characteristic.getUuid()) && num.intValue() == characteristic.getInstanceId()) {
                        break;
                    }
                }
            } else {
                characteristic = service.getCharacteristic(fromString);
            }
            if (characteristic == null) {
                com.tencent.luggage.wxa.pe.a.d(this.f131922a, "[getCharacteristic] characteristics is null, err", new Object[0]);
                return null;
            }
            com.tencent.luggage.wxa.ne.c cVar = new com.tencent.luggage.wxa.ne.c();
            cVar.f135726a = characteristic.getUuid().toString().toUpperCase();
            int properties = characteristic.getProperties();
            cVar.f135727b = com.tencent.luggage.wxa.pe.c.c(properties);
            cVar.f135728c = com.tencent.luggage.wxa.pe.c.d(properties);
            cVar.f135729d = com.tencent.luggage.wxa.pe.c.e(properties);
            cVar.f135730e = com.tencent.luggage.wxa.pe.c.b(properties);
            cVar.f135731f = com.tencent.luggage.wxa.pe.c.a(properties);
            cVar.f135732g = characteristic.getInstanceId();
            com.tencent.luggage.wxa.pe.a.c("MicroMsg.Ble.BleConnectWorker", "[getCharacteristic] handle: %d, instanceId: %d", num, Integer.valueOf(characteristic.getInstanceId()));
            if (this.f131926e == null) {
                return null;
            }
            return cVar;
        }
        com.tencent.luggage.wxa.pe.a.b(this.f131922a, "[getCharacteristic] serviceId is null, err", new Object[0]);
        return null;
    }

    public final void a(String str, boolean z16) {
        i iVar = this.f131929h;
        if (iVar == null) {
            com.tencent.luggage.wxa.pe.a.d(this.f131922a, "notifyConnectionStateChange, onBleConnectionStateChange is null", new Object[0]);
        } else {
            iVar.a(str, z16);
        }
    }

    @Override // com.tencent.luggage.wxa.ke.e
    public void a(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i3) {
        String str = this.f131922a;
        Object[] objArr = new Object[3];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.getDevice().getAddress() : "";
        objArr[1] = bluetoothGattCharacteristic != null ? bluetoothGattCharacteristic.getUuid().toString().toUpperCase() : "";
        objArr[2] = f.b(i3);
        com.tencent.luggage.wxa.pe.a.c(str, "[onCharacteristicRead]gatt deviceId:%s characteristicId:%s status:%s", objArr);
        b bVar = this.f131925d;
        if (bVar == null) {
            return;
        }
        bVar.a(bluetoothGatt, bluetoothGattCharacteristic, i3);
        if (bluetoothGatt == null || bluetoothGattCharacteristic == null || i3 != 0) {
            return;
        }
        h hVar = this.f131930i;
        if (hVar == null) {
            com.tencent.luggage.wxa.pe.a.d(this.f131922a, "[change] onBleCharacteristicValueChange is null", new Object[0]);
            return;
        }
        String str2 = new String(Base64.encode(bluetoothGattCharacteristic.getValue(), 2));
        String address = bluetoothGatt.getDevice().getAddress();
        String upperCase = bluetoothGattCharacteristic.getService().getUuid().toString().toUpperCase();
        String upperCase2 = bluetoothGattCharacteristic.getUuid().toString().toUpperCase();
        com.tencent.luggage.wxa.pe.a.c(this.f131922a, "[read]deviceId %s, serviceId %s, characteristicId %s, value %s", address, upperCase, upperCase2, str2);
        hVar.a(address, upperCase, upperCase2, str2);
    }

    @Override // com.tencent.luggage.wxa.ke.e
    public void a(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        String str = this.f131922a;
        Object[] objArr = new Object[2];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.getDevice().getAddress() : "";
        objArr[1] = bluetoothGattCharacteristic != null ? bluetoothGattCharacteristic.getUuid().toString().toUpperCase() : "";
        com.tencent.luggage.wxa.pe.a.c(str, "[onCharacteristicChanged]gatt deviceId:%s characteristicId:%s", objArr);
        b bVar = this.f131925d;
        if (bVar == null) {
            return;
        }
        bVar.a(bluetoothGatt, bluetoothGattCharacteristic);
        if (bluetoothGatt == null || bluetoothGattCharacteristic == null) {
            return;
        }
        h hVar = this.f131930i;
        if (hVar == null) {
            com.tencent.luggage.wxa.pe.a.d(this.f131922a, "[change] onBleCharacteristicValueChange is null", new Object[0]);
            return;
        }
        String str2 = new String(Base64.encode(bluetoothGattCharacteristic.getValue(), 2));
        String address = bluetoothGatt.getDevice().getAddress();
        String upperCase = bluetoothGattCharacteristic.getService().getUuid().toString().toUpperCase();
        String upperCase2 = bluetoothGattCharacteristic.getUuid().toString().toUpperCase();
        com.tencent.luggage.wxa.pe.a.c(this.f131922a, "[change]deviceId %s, serviceId %s, characteristicId %s, value %s", address, upperCase, upperCase2, str2);
        hVar.a(address, upperCase, upperCase2, str2);
    }

    @Override // com.tencent.luggage.wxa.ke.e
    public void a(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i3) {
        String str = this.f131922a;
        Object[] objArr = new Object[2];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.getDevice().getAddress() : "";
        objArr[1] = bluetoothGattDescriptor != null ? bluetoothGattDescriptor.getUuid().toString().toUpperCase() : "";
        com.tencent.luggage.wxa.pe.a.c(str, "[onDescriptorRead]gatt deviceId:%s descriptorId:%s", objArr);
        b bVar = this.f131925d;
        if (bVar == null) {
            return;
        }
        bVar.a(bluetoothGatt, bluetoothGattDescriptor, i3);
    }

    @Override // com.tencent.luggage.wxa.ke.e
    public void a(BluetoothGatt bluetoothGatt, int i3) {
        String str = this.f131922a;
        Object[] objArr = new Object[2];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.getDevice().getAddress() : "";
        objArr[1] = f.b(i3);
        com.tencent.luggage.wxa.pe.a.c(str, "[onReliableWriteCompleted]gatt deviceId:%s status:%s", objArr);
        b bVar = this.f131925d;
        if (bVar == null) {
            return;
        }
        bVar.a(bluetoothGatt, i3);
    }

    @Override // com.tencent.luggage.wxa.ke.e
    public void a(BluetoothGatt bluetoothGatt, int i3, int i16) {
        String str = this.f131922a;
        Object[] objArr = new Object[3];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.getDevice().getAddress() : "";
        objArr[1] = Integer.valueOf(i3);
        objArr[2] = f.b(i16);
        com.tencent.luggage.wxa.pe.a.c(str, "[onMtuChanged]gatt deviceId:%s mtu:%d status:%s", objArr);
        if (bluetoothGatt == null) {
            return;
        }
        if (i16 == 0) {
            this.f131933l = i3;
            a(bluetoothGatt.getDevice().getAddress(), i3);
        }
        b bVar = this.f131925d;
        if (bVar == null) {
            return;
        }
        bVar.a(bluetoothGatt, i3, i16);
    }

    public final void a(String str, int i3) {
        g gVar = this.f131931j;
        if (gVar != null) {
            gVar.a(str, i3);
        }
    }
}
