package com.tencent.luggage.wxa.oe;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import androidx.collection.SimpleArrayMap;
import com.tencent.luggage.wxa.tn.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final e f136375a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b implements BluetoothAdapter.LeScanCallback {

        /* renamed from: a, reason: collision with root package name */
        public final List f136377a;

        /* renamed from: b, reason: collision with root package name */
        public final WeakReference f136378b;

        public b(List list, l lVar) {
            this.f136377a = list;
            this.f136378b = new WeakReference(lVar);
        }

        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        public void onLeScan(BluetoothDevice bluetoothDevice, int i3, byte[] bArr) {
            l lVar = (l) this.f136378b.get();
            if (lVar == null) {
                return;
            }
            o oVar = new o(bluetoothDevice, n.a(bArr), i3, System.currentTimeMillis());
            List list = this.f136377a;
            if (list == null) {
                lVar.a(1, oVar);
                return;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (((m) it.next()).a(oVar)) {
                    lVar.a(1, oVar);
                    return;
                }
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.oe.d$d, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C6548d extends ScanCallback {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference f136380a;

        public C6548d(l lVar) {
            this.f136380a = new WeakReference(lVar);
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onBatchScanResults(List list) {
            l lVar = (l) this.f136380a.get();
            if (lVar == null) {
                return;
            }
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new o((ScanResult) it.next()));
            }
            lVar.a(arrayList);
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanFailed(int i3) {
            l lVar = (l) this.f136380a.get();
            if (lVar != null) {
                lVar.a(i3);
            }
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanResult(int i3, ScanResult scanResult) {
            l lVar = (l) this.f136380a.get();
            if (lVar != null) {
                lVar.a(i3, new o(scanResult));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface e {
        boolean a(BluetoothAdapter bluetoothAdapter, l lVar);

        boolean a(BluetoothAdapter bluetoothAdapter, List list, p pVar, l lVar);
    }

    static {
        if (!com.tencent.luggage.wxa.je.a.f130958o) {
            w.d("MicroMsg.ble.BleScannerCompat", "use 18");
            f136375a = new a();
        } else {
            w.d("MicroMsg.ble.BleScannerCompat", "use 21");
            f136375a = new c();
        }
    }

    public static boolean a(BluetoothAdapter bluetoothAdapter, List list, p pVar, l lVar) {
        w.d("MicroMsg.ble.BleScannerCompat", "scanMode: " + pVar.b());
        return f136375a.a(bluetoothAdapter, list, pVar, lVar);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a implements e {

        /* renamed from: a, reason: collision with root package name */
        public static final SimpleArrayMap f136376a = new SimpleArrayMap();

        @Override // com.tencent.luggage.wxa.oe.d.e
        public boolean a(BluetoothAdapter bluetoothAdapter, List list, p pVar, l lVar) {
            w.d("MicroMsg.ble.BleScannerCompat", "[BluetoothTrace] start scan");
            w.a("MicroMsg.ble.BleScannerCompat", new Throwable(), "[BluetoothTrace] ble scan stacktrace", new Object[0]);
            return ((Boolean) com.tencent.luggage.wxa.ia.a.a(bluetoothAdapter, new com.tencent.luggage.wxa.ja.a().a(a(list, lVar)).a(), "com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/BleScanerCompat$API18BluetoothLeScannerCompatImpl", "startScan", "(Landroid/bluetooth/BluetoothAdapter;Ljava/util/List;Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/ScanSettingsCompat;Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/ScanCallbackCompat;)Z", "android/bluetooth/BluetoothAdapter", "startLeScan", "(Landroid/bluetooth/BluetoothAdapter$LeScanCallback;)Z")).booleanValue();
        }

        @Override // com.tencent.luggage.wxa.oe.d.e
        public boolean a(BluetoothAdapter bluetoothAdapter, l lVar) {
            b bVar = (b) f136376a.remove(lVar);
            if (bVar == null) {
                return false;
            }
            bluetoothAdapter.stopLeScan(bVar);
            return true;
        }

        public final b a(List list, l lVar) {
            SimpleArrayMap simpleArrayMap = f136376a;
            b bVar = (b) simpleArrayMap.get(lVar);
            if (bVar != null) {
                return bVar;
            }
            b bVar2 = new b(list, lVar);
            simpleArrayMap.put(lVar, bVar2);
            return bVar2;
        }
    }

    public static boolean a(BluetoothAdapter bluetoothAdapter, l lVar) {
        return f136375a.a(bluetoothAdapter, lVar);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class c implements e {

        /* renamed from: a, reason: collision with root package name */
        public static final SimpleArrayMap f136379a = new SimpleArrayMap();

        @Override // com.tencent.luggage.wxa.oe.d.e
        public boolean a(BluetoothAdapter bluetoothAdapter, List list, p pVar, l lVar) {
            ArrayList arrayList;
            if (list != null) {
                arrayList = new ArrayList(list.size());
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(((m) it.next()).a());
                }
            } else {
                arrayList = null;
            }
            if (pVar != null) {
                ScanSettings c16 = pVar.c();
                if (bluetoothAdapter.getBluetoothLeScanner() == null) {
                    w.b("MicroMsg.ble.BleScannerCompat", "bluetoothscanner is null, return");
                    return false;
                }
                w.d("MicroMsg.ble.BleScannerCompat", "[BluetoothTrace] start scan");
                w.a("MicroMsg.ble.BleScannerCompat", new Throwable(), "[BluetoothTrace] ble scan stacktrace", new Object[0]);
                com.tencent.luggage.wxa.ia.a.a(bluetoothAdapter.getBluetoothLeScanner(), new com.tencent.luggage.wxa.ja.a().a(a(lVar)).a(c16).a(arrayList).a(), "com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/BleScanerCompat$API21BluetoothLeScannerCompatImpl", "startScan", "(Landroid/bluetooth/BluetoothAdapter;Ljava/util/List;Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/ScanSettingsCompat;Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/ScanCallbackCompat;)Z", "android/bluetooth/le/BluetoothLeScanner", "startScan", "(Ljava/util/List;Landroid/bluetooth/le/ScanSettings;Landroid/bluetooth/le/ScanCallback;)V");
                return true;
            }
            throw new IllegalStateException("Scan settings are null");
        }

        @Override // com.tencent.luggage.wxa.oe.d.e
        public boolean a(BluetoothAdapter bluetoothAdapter, l lVar) {
            C6548d c6548d = (C6548d) f136379a.remove(lVar);
            if (c6548d == null) {
                return false;
            }
            if (bluetoothAdapter.getBluetoothLeScanner() == null) {
                w.b("MicroMsg.ble.BleScannerCompat", "bluetoothscanner is null, return");
                return false;
            }
            bluetoothAdapter.getBluetoothLeScanner().stopScan(c6548d);
            return true;
        }

        public final C6548d a(l lVar) {
            SimpleArrayMap simpleArrayMap = f136379a;
            C6548d c6548d = (C6548d) simpleArrayMap.get(lVar);
            if (c6548d != null) {
                return c6548d;
            }
            C6548d c6548d2 = new C6548d(lVar);
            simpleArrayMap.put(lVar, c6548d2);
            return c6548d2;
        }
    }
}
