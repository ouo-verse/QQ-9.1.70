package com.tencent.luggage.wxa.ge;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.luggage.wxa.ge.b;
import com.tencent.luggage.wxa.ne.k;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static Map f126678a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public static BroadcastReceiver f126679b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f126680c;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ge.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6240a extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                w.d("MicroMsg.Ble.BleManager", "Receive intent failed");
                return;
            }
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null) {
                int state = defaultAdapter.getState();
                boolean z16 = true;
                w.a("MicroMsg.Ble.BleManager", "state:%d", Integer.valueOf(state));
                if (state != 12) {
                    z16 = false;
                }
                if ((a.f126680c && !z16) || (!a.f126680c && z16)) {
                    Iterator it = a.f126678a.values().iterator();
                    while (it.hasNext()) {
                        ((b) it.next()).b(z16);
                    }
                }
                boolean unused = a.f126680c = z16;
            }
        }
    }

    public static synchronized void c() {
        synchronized (a.class) {
            if (f126679b == null) {
                w.d("MicroMsg.Ble.BleManager", "bluetoothStateListener init");
                f126679b = new C6240a();
                z.c().registerReceiver(f126679b, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
                f126680c = com.tencent.luggage.wxa.pe.c.a();
            }
        }
    }

    public static synchronized void d() {
        synchronized (a.class) {
            if (f126679b != null) {
                w.d("MicroMsg.Ble.BleManager", "bluetoothStateListener uninit");
                z.c().unregisterReceiver(f126679b);
                f126679b = null;
            }
        }
    }

    public static synchronized b b(String str) {
        b bVar;
        synchronized (a.class) {
            bVar = (b) f126678a.get(str);
        }
        return bVar;
    }

    public static synchronized k a(String str, b.c cVar, com.tencent.luggage.wxa.ne.i iVar, com.tencent.luggage.wxa.ne.h hVar, com.tencent.luggage.wxa.ne.g gVar) {
        synchronized (a.class) {
            w.d("MicroMsg.Ble.BleManager", "open appId:%s", str);
            if (!com.tencent.luggage.wxa.pe.c.d()) {
                w.b("MicroMsg.Ble.BleManager", "api version is below 18");
                return k.f135755o;
            }
            if (!f126678a.containsKey(str)) {
                b bVar = new b(str);
                bVar.c();
                bVar.b(cVar);
                bVar.b(iVar);
                bVar.a(hVar);
                bVar.a(gVar);
                f126678a.put(str, bVar);
                com.tencent.luggage.wxa.ic.e.a(str, bVar);
                d.f126692a.a(str, bVar);
                c();
            } else {
                w.d("MicroMsg.Ble.BleManager", "already open appId:%s", str);
            }
            if (!com.tencent.luggage.wxa.pe.c.a()) {
                w.b("MicroMsg.Ble.BleManager", "bluetooth not enable, err");
                return k.f135749i;
            }
            return k.f135745e;
        }
    }

    public static synchronized k a(String str) {
        synchronized (a.class) {
            w.d("MicroMsg.Ble.BleManager", "close appId:%s", str);
            if (!f126678a.containsKey(str)) {
                return k.f135745e;
            }
            b bVar = (b) f126678a.remove(str);
            com.tencent.luggage.wxa.ic.e.b(str, bVar);
            d.f126692a.b(str, bVar);
            if (bVar == null) {
                w.d("MicroMsg.Ble.BleManager", "close, bleWorker is null");
            } else {
                bVar.g();
            }
            if (f126678a.size() == 0) {
                d();
            }
            return k.f135745e;
        }
    }
}
