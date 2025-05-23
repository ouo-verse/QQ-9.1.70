package com.tencent.luggage.wxa.cf;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.luggage.wxa.ap.j;
import com.tencent.luggage.wxa.oe.n;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.qqnt.kernel.nativeinterface.DigestErrCode;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f123474a = true;

    /* renamed from: b, reason: collision with root package name */
    public static Map f123475b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    public static BroadcastReceiver f123476c;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f123477d;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.cf.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6107a extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                w.d("MicroMsg.BeaconManager", "Receive intent failed");
                return;
            }
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null) {
                int state = defaultAdapter.getState();
                boolean z16 = true;
                w.d("MicroMsg.BeaconManager", "state:%d", Integer.valueOf(state));
                if (state != 12) {
                    z16 = false;
                }
                boolean z17 = a.f123477d;
                if ((z17 && !z16) || (!z17 && z16)) {
                    Iterator it = a.f123475b.values().iterator();
                    while (it.hasNext()) {
                        ((b) it.next()).a(z16);
                    }
                }
                a.f123477d = z16;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public BluetoothAdapter f123478a;

        /* renamed from: d, reason: collision with root package name */
        public InterfaceC6109b f123481d;

        /* renamed from: b, reason: collision with root package name */
        public Map f123479b = new ConcurrentHashMap();

        /* renamed from: c, reason: collision with root package name */
        public UUID[] f123480c = null;

        /* renamed from: e, reason: collision with root package name */
        public volatile boolean f123482e = false;

        /* renamed from: f, reason: collision with root package name */
        public long f123483f = 0;

        /* renamed from: g, reason: collision with root package name */
        public Map f123484g = new ConcurrentHashMap();

        /* renamed from: h, reason: collision with root package name */
        public BluetoothAdapter.LeScanCallback f123485h = new C6108a();

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.cf.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6108a implements BluetoothAdapter.LeScanCallback {
            public C6108a() {
            }

            public final void a(BluetoothDevice bluetoothDevice, int i3, byte[] bArr) {
                boolean z16;
                boolean z17;
                if (22 >= bArr.length) {
                    w.d("MicroMsg.BeaconManager", "handleManufacturerData, manufacturerData is too short");
                    return;
                }
                if ((bArr[0] & 255) == 2 && (bArr[1] & 255) == 21) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    byte[] bArr2 = new byte[16];
                    System.arraycopy(bArr, 2, bArr2, 0, 16);
                    String a16 = com.tencent.luggage.wxa.cf.b.a(bArr2, 16);
                    if (w0.c(a16)) {
                        w.b("MicroMsg.BeaconManager", "handleManufacturerData, hexString is null, err");
                        return;
                    }
                    String str = a16.substring(0, 8) + "-" + a16.substring(8, 12) + "-" + a16.substring(12, 16) + "-" + a16.substring(16, 20) + "-" + a16.substring(20, 32);
                    w.d("MicroMsg.BeaconManager", "handleManufacturerData, strUuid %s", str);
                    UUID fromString = UUID.fromString(str);
                    UUID[] uuidArr = b.this.f123480c;
                    int length = uuidArr.length;
                    int i16 = 0;
                    while (true) {
                        if (i16 < length) {
                            if (uuidArr[i16].equals(fromString)) {
                                z17 = true;
                                break;
                            }
                            i16++;
                        } else {
                            z17 = false;
                            break;
                        }
                    }
                    if (!z17) {
                        w.d("MicroMsg.BeaconManager", "handleManufacturerData, not found beacon!");
                        return;
                    }
                    int i17 = ((bArr[18] & 255) * 256) + (bArr[19] & 255);
                    int i18 = ((bArr[20] & 255) * 256) + (bArr[21] & 255);
                    double a17 = com.tencent.luggage.wxa.cf.b.a(bArr[22], i3);
                    String address = bluetoothDevice.getAddress();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("uuid", fromString);
                        jSONObject.put("major", i17);
                        jSONObject.put("minor", i18);
                        jSONObject.put("proximity", 0);
                        jSONObject.put("accuracy", a17);
                        jSONObject.put("rssi", i3);
                        b.this.f123479b.put(address, jSONObject);
                        b.this.f123484g.put(address, jSONObject);
                        w.a("MicroMsg.BeaconManager", "handleManufacturerData, found device ibeacon %s", jSONObject);
                    } catch (JSONException e16) {
                        w.b("MicroMsg.BeaconManager", "handleManufacturerData, put JSON data error : %s", e16);
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - b.this.f123483f > 500) {
                        if (b.this.f123481d != null) {
                            b.this.f123481d.a(b.this.f123484g);
                        }
                        b.this.f123483f = currentTimeMillis;
                        b.this.f123484g.clear();
                    }
                }
            }

            public final void b(BluetoothDevice bluetoothDevice, int i3, byte[] bArr) {
                boolean z16;
                boolean z17;
                w.d("MicroMsg.BeaconManager", "handleScanData, device: " + bluetoothDevice);
                int i16 = 2;
                while (true) {
                    if (i16 <= 5) {
                        if ((bArr[i16 + 2] & 255) == 2 && (bArr[i16 + 3] & 255) == 21) {
                            z16 = true;
                            break;
                        }
                        i16++;
                    } else {
                        z16 = false;
                        break;
                    }
                }
                if (z16) {
                    byte[] bArr2 = new byte[16];
                    System.arraycopy(bArr, i16 + 4, bArr2, 0, 16);
                    String a16 = com.tencent.luggage.wxa.cf.b.a(bArr2, 16);
                    if (w0.c(a16)) {
                        w.b("MicroMsg.BeaconManager", "hexString is null, err");
                        return;
                    }
                    String str = a16.substring(0, 8) + "-" + a16.substring(8, 12) + "-" + a16.substring(12, 16) + "-" + a16.substring(16, 20) + "-" + a16.substring(20, 32);
                    w.d("MicroMsg.BeaconManager", "strUuid %s", str);
                    UUID fromString = UUID.fromString(str);
                    UUID[] uuidArr = b.this.f123480c;
                    int length = uuidArr.length;
                    int i17 = 0;
                    while (true) {
                        if (i17 < length) {
                            if (uuidArr[i17].equals(fromString)) {
                                z17 = true;
                                break;
                            }
                            i17++;
                        } else {
                            z17 = false;
                            break;
                        }
                    }
                    if (!z17) {
                        w.d("MicroMsg.BeaconManager", "not found beacon!");
                        return;
                    }
                    int i18 = ((bArr[i16 + 20] & 255) * 256) + (bArr[i16 + 21] & 255);
                    int i19 = ((bArr[i16 + 22] & 255) * 256) + (bArr[i16 + 23] & 255);
                    double a17 = com.tencent.luggage.wxa.cf.b.a(bArr[i16 + 24], i3);
                    String address = bluetoothDevice.getAddress();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("uuid", fromString);
                        jSONObject.put("major", i18);
                        jSONObject.put("minor", i19);
                        jSONObject.put("proximity", 0);
                        jSONObject.put("accuracy", a17);
                        jSONObject.put("rssi", i3);
                        b.this.f123479b.put(address, jSONObject);
                        b.this.f123484g.put(address, jSONObject);
                        w.a("MicroMsg.BeaconManager", "found device ibeacon %s", jSONObject);
                    } catch (JSONException e16) {
                        w.b("MicroMsg.BeaconManager", "put JSON data error : %s", e16);
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - b.this.f123483f > 500) {
                        if (b.this.f123481d != null) {
                            b.this.f123481d.a(b.this.f123484g);
                        }
                        b.this.f123483f = currentTimeMillis;
                        b.this.f123484g.clear();
                    }
                }
            }

            public final void c(BluetoothDevice bluetoothDevice, int i3, byte[] bArr) {
                w.d("MicroMsg.BeaconManager", "handleScanDataV2, device: " + bluetoothDevice);
                n a16 = n.a(bArr);
                if (a16 == null) {
                    w.f("MicroMsg.BeaconManager", "handleScanDataV2, scanRecordCompat is null");
                    return;
                }
                LinkedHashMap c16 = a16.c();
                if (c16 == null) {
                    w.f("MicroMsg.BeaconManager", "handleScanDataV2, id2ManufacturerData is null");
                    return;
                }
                for (byte[] bArr2 : c16.values()) {
                    if (bArr2 == null) {
                        w.f("MicroMsg.BeaconManager", "handleScanDataV2, manufacturerData is null");
                        return;
                    }
                    a(bluetoothDevice, i3, bArr2);
                }
            }

            @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
            public void onLeScan(BluetoothDevice bluetoothDevice, int i3, byte[] bArr) {
                if (w0.b(bArr)) {
                    w.b("MicroMsg.BeaconManager", "valueByte is null or nil");
                } else if (a.f123474a) {
                    c(bluetoothDevice, i3, bArr);
                } else {
                    b(bluetoothDevice, i3, bArr);
                }
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.cf.a$b$b, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public interface InterfaceC6109b {
            void a(Map map);

            void a(boolean z16);
        }

        public b() {
            b();
        }

        public final void b() {
            BluetoothManager bluetoothManager = (BluetoothManager) z.c().getSystemService(QQPermissionConstants.Permission.BLUE_TOOTH_GROUP);
            if (bluetoothManager == null) {
                w.b("MicroMsg.BeaconManager", "bluetoothManager is null!");
                return;
            }
            BluetoothAdapter adapter = bluetoothManager.getAdapter();
            this.f123478a = adapter;
            if (adapter == null) {
                w.b("MicroMsg.BeaconManager", "bluetoothAdapter is null!");
            } else {
                a.f123477d = adapter.isEnabled();
            }
        }

        public final synchronized boolean c() {
            return this.f123482e;
        }

        public com.tencent.luggage.wxa.ap.b d() {
            w.d("MicroMsg.BeaconManager", "BeaconWorker:%d start", Integer.valueOf(hashCode()));
            boolean c16 = c();
            Integer valueOf = Integer.valueOf(DigestErrCode.SPACE_NOT_ENOUGH);
            if (c16) {
                w.d("MicroMsg.BeaconManager", "BeaconWorker:%d, already start", Integer.valueOf(hashCode()));
                return j.a(valueOf, "fail:already start");
            }
            if (com.tencent.luggage.wxa.aa.a.a(18)) {
                w.b("MicroMsg.BeaconManager", "API version is below 18!");
                return j.a(11000, "fail:not support");
            }
            BluetoothAdapter bluetoothAdapter = this.f123478a;
            if (bluetoothAdapter == null) {
                w.b("MicroMsg.BeaconManager", "bluetoothAdapter is null!");
                return j.a(11001, "fail:bluetooth service is unavailable");
            }
            if (!bluetoothAdapter.isEnabled()) {
                w.b("MicroMsg.BeaconManager", "bluetoothAdapter is not enabled!");
                return j.a(11001, "fail:bluetooth service is unavailable");
            }
            if (this.f123478a.isDiscovering()) {
                w.b("MicroMsg.BeaconManager", "bluetoothAdapter is Discovering!");
                return j.a(valueOf, "fail:already start");
            }
            this.f123479b.clear();
            w.d("MicroMsg.BeaconManager", "[BluetoothTrace] start scan");
            w.a("MicroMsg.BeaconManager", new Throwable(), "[BluetoothTrace] ble scan stacktrace", new Object[0]);
            boolean booleanValue = ((Boolean) com.tencent.luggage.wxa.ia.a.a(this.f123478a, new com.tencent.luggage.wxa.ja.a().a(this.f123485h).a(), "com/tencent/mm/plugin/appbrand/jsapi/ibeacon/BeaconManager$BeaconWorker", "start", "()Lcom/tencent/mm/vending/tuple/Tuple2;", "android/bluetooth/BluetoothAdapter", "startLeScan", "(Landroid/bluetooth/BluetoothAdapter$LeScanCallback;)Z")).booleanValue();
            w.d("MicroMsg.BeaconManager", "startLeScan:%b", Boolean.valueOf(booleanValue));
            if (!booleanValue) {
                return j.a(11005, "fail:system error");
            }
            this.f123482e = true;
            return j.a(0, "");
        }

        public boolean e() {
            w.d("MicroMsg.BeaconManager", "BeaconWorker:%d stop", Integer.valueOf(hashCode()));
            if (!c()) {
                w.d("MicroMsg.BeaconManager", "BeaconWorker:%d, already stop", Integer.valueOf(hashCode()));
                return false;
            }
            this.f123479b.clear();
            this.f123478a.stopLeScan(this.f123485h);
            this.f123482e = false;
            return true;
        }

        public Map a() {
            return this.f123479b;
        }

        public void a(UUID[] uuidArr) {
            this.f123480c = uuidArr;
        }

        public void a(InterfaceC6109b interfaceC6109b) {
            this.f123481d = interfaceC6109b;
        }

        public void a(boolean z16) {
            if (c() && !z16) {
                e();
            }
            InterfaceC6109b interfaceC6109b = this.f123481d;
            if (interfaceC6109b != null) {
                interfaceC6109b.a(z16);
            }
        }
    }

    public static void b(String str) {
        f123475b.remove(str);
        w.d("MicroMsg.BeaconManager", "remove Beacon appid:%s", str);
        if (f123475b.size() == 0 && f123476c != null) {
            w.d("MicroMsg.BeaconManager", "bluetoothStateListener uninit");
            z.c().unregisterReceiver(f123476c);
            f123476c = null;
        }
    }

    public static void a(String str, b bVar) {
        f123475b.put(str, bVar);
        if (f123476c == null) {
            w.d("MicroMsg.BeaconManager", "bluetoothStateListener init");
            f123476c = new C6107a();
            z.c().registerReceiver(f123476c, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
        }
    }

    public static b a(String str) {
        return (b) f123475b.get(str);
    }
}
