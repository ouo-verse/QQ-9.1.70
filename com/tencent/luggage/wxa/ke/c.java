package com.tencent.luggage.wxa.ke;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import com.tencent.luggage.wxa.ne.g;
import com.tencent.luggage.wxa.ne.h;
import com.tencent.luggage.wxa.ne.i;
import com.tencent.luggage.wxa.tn.w0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public final Context f131914a;

    /* renamed from: b, reason: collision with root package name */
    public Map f131915b;

    /* renamed from: c, reason: collision with root package name */
    public volatile i f131916c = null;

    /* renamed from: d, reason: collision with root package name */
    public volatile h f131917d = null;

    /* renamed from: e, reason: collision with root package name */
    public volatile g f131918e = null;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements h {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.ne.h
        public void a(String str, String str2, String str3, String str4) {
            h hVar = c.this.f131917d;
            if (hVar != null) {
                hVar.a(str, str2, str3, str4);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements i {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.ne.i
        public void a(String str, boolean z16) {
            i iVar = c.this.f131916c;
            if (iVar != null) {
                iVar.a(str, z16);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ke.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC6378c {

        /* renamed from: a, reason: collision with root package name */
        public static final InterfaceC6378c f131921a = new a();

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.ke.c$c$a */
        /* loaded from: classes8.dex */
        public class a implements InterfaceC6378c {
            @Override // com.tencent.luggage.wxa.ke.c.InterfaceC6378c
            public boolean a(BluetoothDevice bluetoothDevice) {
                return true;
            }
        }

        boolean a(BluetoothDevice bluetoothDevice);
    }

    public c(Context context) {
        this.f131914a = context;
    }

    public synchronized void c() {
        com.tencent.luggage.wxa.pe.a.c("MicroMsg.Ble.BleConnectMgr", "init", new Object[0]);
        if (this.f131915b == null) {
            this.f131915b = new ConcurrentHashMap();
        }
        this.f131915b.clear();
    }

    public synchronized void d() {
        com.tencent.luggage.wxa.pe.a.c("MicroMsg.Ble.BleConnectMgr", "uninit", new Object[0]);
        Map map = this.f131915b;
        if (map != null) {
            Iterator it = map.values().iterator();
            while (it.hasNext()) {
                ((d) it.next()).h();
            }
            this.f131915b.clear();
            this.f131915b = null;
        }
        this.f131916c = null;
        this.f131917d = null;
        this.f131918e = null;
    }

    public final synchronized d a(String str) {
        Map map = this.f131915b;
        if (map == null) {
            com.tencent.luggage.wxa.pe.a.d("MicroMsg.Ble.BleConnectMgr", "getWorker, connectWorkers is null", new Object[0]);
            return null;
        }
        d dVar = (d) map.get(str);
        if (dVar == null) {
            dVar = new d(this.f131914a, str, this);
            dVar.g();
            dVar.a(new a());
            dVar.a(new b());
            dVar.a(this.f131918e);
            this.f131915b.put(str, dVar);
        }
        return dVar;
    }

    public void b(String str) {
        Map map = this.f131915b;
        if (map == null) {
            com.tencent.luggage.wxa.pe.a.d("MicroMsg.Ble.BleConnectMgr", "removeWorker, connectWorkers is null", new Object[0]);
        } else {
            map.remove(str);
        }
    }

    public final List b() {
        return a(InterfaceC6378c.f131921a);
    }

    public final List b(List list) {
        if (list != null && !list.isEmpty()) {
            return a(list);
        }
        return a(InterfaceC6378c.f131921a);
    }

    public void a(i iVar) {
        this.f131916c = iVar;
    }

    public void a(h hVar) {
        this.f131917d = hVar;
    }

    public void a(g gVar) {
        this.f131918e = gVar;
    }

    public void a(String str, com.tencent.luggage.wxa.ne.a aVar, com.tencent.luggage.wxa.ne.b bVar) {
        d a16 = a(str);
        if (a16 != null) {
            a16.a(aVar, bVar);
        }
    }

    public List a(String str, boolean z16) {
        Map map = this.f131915b;
        if (map == null) {
            com.tencent.luggage.wxa.pe.a.d("MicroMsg.Ble.BleConnectMgr", "getServices, connectWorkers is null", new Object[0]);
            return null;
        }
        d dVar = (d) map.get(str);
        if (dVar == null) {
            com.tencent.luggage.wxa.pe.a.d("MicroMsg.Ble.BleConnectMgr", "getServices, connectWorker is null", new Object[0]);
            return null;
        }
        if (z16) {
            return dVar.e();
        }
        return dVar.f();
    }

    public List a(String str, String str2) {
        Map map = this.f131915b;
        if (map == null) {
            com.tencent.luggage.wxa.pe.a.d("MicroMsg.Ble.BleConnectMgr", "getCharacteristics, connectWorkers is null", new Object[0]);
            return null;
        }
        d dVar = (d) map.get(str);
        if (dVar == null) {
            com.tencent.luggage.wxa.pe.a.d("MicroMsg.Ble.BleConnectMgr", "getCharacteristics, connectWorker is null", new Object[0]);
            return null;
        }
        return dVar.a(str2);
    }

    public com.tencent.luggage.wxa.ne.c a(String str, String str2, String str3, Integer num) {
        Map map = this.f131915b;
        if (map == null) {
            com.tencent.luggage.wxa.pe.a.d("MicroMsg.Ble.BleConnectMgr", "getCharacteristic, connectWorkers is null", new Object[0]);
            return null;
        }
        d dVar = (d) map.get(str);
        if (dVar == null) {
            com.tencent.luggage.wxa.pe.a.d("MicroMsg.Ble.BleConnectMgr", "getCharacteristic, connectWorker is null", new Object[0]);
            return null;
        }
        return dVar.a(str2, str3, num);
    }

    public List a(boolean z16) {
        if (z16) {
            return a();
        }
        return b();
    }

    public final List a() {
        ArrayList arrayList = new ArrayList();
        Map map = this.f131915b;
        if (map == null) {
            com.tencent.luggage.wxa.pe.a.d("MicroMsg.Ble.BleConnectMgr", "getConnectedBleDevices, connectWorkers is null", new Object[0]);
            return arrayList;
        }
        for (d dVar : map.values()) {
            BluetoothGatt a16 = dVar.a();
            if (a16 != null) {
                arrayList.add(new com.tencent.luggage.wxa.ne.d(w0.d(a16.getDevice().getName()), dVar.f131924c));
            }
        }
        return arrayList;
    }

    public List a(List list, boolean z16) {
        if (z16) {
            return a(list);
        }
        return b(list);
    }

    public final List a(List list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Map map = this.f131915b;
            if (map == null) {
                com.tencent.luggage.wxa.pe.a.d("MicroMsg.Ble.BleConnectMgr", "getConnectedBleDevices, connectWorkers is null", new Object[0]);
                return arrayList;
            }
            for (d dVar : map.values()) {
                BluetoothGatt a16 = dVar.a();
                if (a16 != null) {
                    List<com.tencent.luggage.wxa.ne.e> e16 = dVar.e();
                    if (e16 != null && !e16.isEmpty()) {
                        ArrayList arrayList2 = new ArrayList(e16.size());
                        for (com.tencent.luggage.wxa.ne.e eVar : e16) {
                            if (eVar.f135743b) {
                                arrayList2.add(eVar.f135742a);
                            }
                        }
                        if (a(list, arrayList2)) {
                            arrayList.add(new com.tencent.luggage.wxa.ne.d(w0.d(a16.getDevice().getName()), dVar.f131924c));
                        }
                    } else {
                        com.tencent.luggage.wxa.pe.a.d("MicroMsg.Ble.BleConnectMgr", "getConnectedBleDevices, services is empty", new Object[0]);
                    }
                }
            }
            return arrayList;
        }
        return a();
    }

    public static boolean a(List list, List list2) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Iterator it5 = list2.iterator();
            while (it5.hasNext()) {
                if (Objects.equals(str, (String) it5.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final List a(InterfaceC6378c interfaceC6378c) {
        ArrayList arrayList = new ArrayList();
        BluetoothManager f16 = com.tencent.luggage.wxa.pe.c.f();
        if (f16 == null) {
            com.tencent.luggage.wxa.pe.a.d("MicroMsg.Ble.BleConnectMgr", "getConnectedBleDevicesSysImpl, bluetoothManager is null", new Object[0]);
            return arrayList;
        }
        for (BluetoothDevice bluetoothDevice : f16.getConnectedDevices(7)) {
            if (interfaceC6378c.a(bluetoothDevice)) {
                arrayList.add(new com.tencent.luggage.wxa.ne.d(bluetoothDevice.getName(), bluetoothDevice.getAddress()));
            }
        }
        return arrayList;
    }
}
