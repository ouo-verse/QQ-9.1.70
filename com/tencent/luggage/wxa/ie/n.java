package com.tencent.luggage.wxa.ie;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertiseSettings;
import android.bluetooth.le.BluetoothLeAdvertiser;
import android.util.Base64;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.concurrent.TimersKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class n {

    /* renamed from: h, reason: collision with root package name */
    public static final a f130143h = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public BluetoothGattServer f130145b;

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.luggage.wxa.xd.d f130146c;

    /* renamed from: g, reason: collision with root package name */
    public com.tencent.luggage.wxa.ie.b f130150g;

    /* renamed from: a, reason: collision with root package name */
    public p f130144a = p.INIT;

    /* renamed from: d, reason: collision with root package name */
    public int f130147d = -1;

    /* renamed from: e, reason: collision with root package name */
    public final CopyOnWriteArrayList f130148e = new CopyOnWriteArrayList();

    /* renamed from: f, reason: collision with root package name */
    public final Map f130149f = new HashMap();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.ie.n$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static abstract class AbstractC6302a extends AdvertiseCallback {
            public abstract void a();
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends TimerTask {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f130151a;

        public b(Function1 function1) {
            this.f130151a = function1;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.f130151a.invoke(Boolean.FALSE);
            cancel();
        }
    }

    public final void a(p pVar) {
        Intrinsics.checkNotNullParameter(pVar, "<set-?>");
        this.f130144a = pVar;
    }

    public final com.tencent.luggage.wxa.xd.d b() {
        com.tencent.luggage.wxa.xd.d dVar = this.f130146c;
        if (dVar != null) {
            return dVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException(HippyQQConstants.URL_COMPONENT_NAME);
        return null;
    }

    public final BluetoothGattServer c() {
        BluetoothGattServer bluetoothGattServer = this.f130145b;
        if (bluetoothGattServer != null) {
            return bluetoothGattServer;
        }
        Intrinsics.throwUninitializedPropertyAccessException("gattServer");
        return null;
    }

    public final int d() {
        return this.f130147d;
    }

    public final p e() {
        return this.f130144a;
    }

    public final void f() {
        Map b16;
        this.f130149f.clear();
        try {
            if (this.f130145b != null) {
                c().close();
            }
        } catch (SecurityException unused) {
        }
        BluetoothAdapter e16 = com.tencent.luggage.wxa.pe.c.e();
        if (e16 != null) {
            a(e16);
        }
        com.tencent.luggage.wxa.ie.b bVar = this.f130150g;
        if (bVar != null && (b16 = bVar.b()) != null) {
            b16.clear();
        }
        this.f130150g = null;
        this.f130144a = p.DESTROYED;
    }

    public final void a(BluetoothGattServer bluetoothGattServer) {
        Intrinsics.checkNotNullParameter(bluetoothGattServer, "<set-?>");
        this.f130145b = bluetoothGattServer;
    }

    public final void a(com.tencent.luggage.wxa.xd.d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "<set-?>");
        this.f130146c = dVar;
    }

    public final void a(com.tencent.luggage.wxa.xd.d component, int i3) {
        BluetoothGattServer bluetoothGattServer;
        Intrinsics.checkNotNullParameter(component, "component");
        BluetoothManager f16 = com.tencent.luggage.wxa.pe.c.f();
        if (a() && f16 != null) {
            this.f130144a = p.CREATED;
            a(component);
            this.f130147d = i3;
            this.f130150g = new com.tencent.luggage.wxa.ie.b();
            try {
                bluetoothGattServer = f16.openGattServer(z.c(), this.f130150g);
            } catch (SecurityException e16) {
                w.b("MicroMsg.BLE.PeripheralBleServer", "openGattServer: " + e16.getMessage());
                bluetoothGattServer = null;
            }
            if (bluetoothGattServer == null) {
                this.f130144a = p.TROUBLESOME;
                return;
            }
            a(bluetoothGattServer);
            com.tencent.luggage.wxa.ie.b bVar = this.f130150g;
            Intrinsics.checkNotNull(bVar);
            bVar.a(this);
            return;
        }
        p pVar = p.INIT;
    }

    public final boolean a() {
        return com.tencent.luggage.wxa.pe.c.d() & true & com.tencent.luggage.wxa.pe.b.b() & com.tencent.luggage.wxa.pe.c.a();
    }

    public final void a(UUID uuid) {
        Function1 function1;
        Timer timer;
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Pair pair = (Pair) this.f130149f.get(uuid);
        if (pair != null && (timer = (Timer) pair.getSecond()) != null) {
            timer.cancel();
        }
        Pair pair2 = (Pair) this.f130149f.get(uuid);
        if (pair2 != null && (function1 = (Function1) pair2.getFirst()) != null) {
            function1.invoke(Boolean.TRUE);
        }
        this.f130149f.remove(uuid);
    }

    public final void a(BluetoothGattService service, Function1 addServiceCallback, Function0 permissionDeniedCallback) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(addServiceCallback, "addServiceCallback");
        Intrinsics.checkNotNullParameter(permissionDeniedCallback, "permissionDeniedCallback");
        if (!com.tencent.luggage.wxa.pe.b.a(QQPermissionConstants.Permission.BLUETOOTH_CONNECT)) {
            permissionDeniedCallback.invoke();
            return;
        }
        try {
            if (!c().addService(service)) {
                addServiceCallback.invoke(Boolean.FALSE);
            }
            Map map = this.f130149f;
            UUID uuid = service.getUuid();
            Intrinsics.checkNotNullExpressionValue(uuid, "service.uuid");
            Timer timer = TimersKt.timer(null, false);
            timer.schedule(new b(addServiceCallback), 3000L, Long.MAX_VALUE);
            map.put(uuid, new Pair(addServiceCallback, timer));
        } catch (SecurityException unused) {
            permissionDeniedCallback.invoke();
        }
    }

    public final void a(AdvertiseSettings settings, AdvertiseData advertiseData, AdvertiseData scanResponse, String deviceName, BluetoothAdapter adapter, BluetoothLeAdvertiser advertiser, a.AbstractC6302a advertiseCallback) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(settings, "settings");
        Intrinsics.checkNotNullParameter(advertiseData, "advertiseData");
        Intrinsics.checkNotNullParameter(scanResponse, "scanResponse");
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(advertiser, "advertiser");
        Intrinsics.checkNotNullParameter(advertiseCallback, "advertiseCallback");
        this.f130148e.add(advertiseCallback);
        if (com.tencent.luggage.wxa.pe.b.a(QQPermissionConstants.Permission.BLUETOOTH_CONNECT)) {
            try {
                isBlank = StringsKt__StringsJVMKt.isBlank(deviceName);
                if ((!isBlank) && !Intrinsics.areEqual(adapter.getName(), deviceName)) {
                    if (!adapter.setName(deviceName)) {
                        w.h("MicroMsg.BLE.PeripheralBleServer", "set BLE adapter name fail, may under wrong state! [%d]", Integer.valueOf(adapter.getState()));
                    }
                    for (int i3 = 0; i3 < 21; i3++) {
                        String name = adapter.getName();
                        w.d("MicroMsg.BLE.PeripheralBleServer", "round [%d] sys = [%s], want = [%s]", Integer.valueOf(i3), name, deviceName);
                        if (Intrinsics.areEqual(deviceName, name)) {
                            break;
                        }
                        try {
                            LockMethodProxy.sleep(50L);
                        } catch (InterruptedException e16) {
                            throw e16;
                        }
                    }
                }
            } catch (SecurityException e17) {
                w.b("MicroMsg.BLE.PeripheralBleServer", "startAdvertising: " + e17.getMessage());
            }
        } else {
            advertiseCallback.a();
            this.f130148e.remove(advertiseCallback);
        }
        if (com.tencent.luggage.wxa.pe.b.a(QQPermissionConstants.Permission.BLUETOOTH_ADVERTISE)) {
            try {
                advertiser.startAdvertising(settings, advertiseData, scanResponse, advertiseCallback);
                return;
            } catch (SecurityException e18) {
                w.b("MicroMsg.BLE.PeripheralBleServer", "startAdvertising: " + e18.getMessage());
                return;
            }
        }
        advertiseCallback.a();
        this.f130148e.remove(advertiseCallback);
    }

    public final void a(BluetoothAdapter adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        BluetoothLeAdvertiser bluetoothLeAdvertiser = adapter.getBluetoothLeAdvertiser();
        if (bluetoothLeAdvertiser == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (AdvertiseCallback advertiseCallback : this.f130148e) {
            try {
                bluetoothLeAdvertiser.stopAdvertising(advertiseCallback);
            } catch (SecurityException e16) {
                w.b("MicroMsg.BLE.PeripheralBleServer", "stopAdvertising: " + e16.getMessage());
            }
            arrayList.add(advertiseCallback);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.f130148e.remove((AdvertiseCallback) it.next());
        }
    }

    public final void a(UUID serviceId, UUID characteristicId, boolean z16, int i3, String base64Value) {
        Intrinsics.checkNotNullParameter(serviceId, "serviceId");
        Intrinsics.checkNotNullParameter(characteristicId, "characteristicId");
        Intrinsics.checkNotNullParameter(base64Value, "base64Value");
        if (com.tencent.luggage.wxa.pe.b.a(QQPermissionConstants.Permission.BLUETOOTH_CONNECT)) {
            try {
                BluetoothGattService service = c().getService(serviceId);
                if (service == null) {
                    w.d("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: server == null");
                    return;
                }
                BluetoothGattCharacteristic characteristic = service.getCharacteristic(characteristicId);
                if (characteristic == null) {
                    w.d("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: characteristic == null");
                    return;
                }
                characteristic.setValue(com.tencent.luggage.wxa.pe.c.a(Base64.decode(base64Value, 2)));
                if (z16) {
                    com.tencent.luggage.wxa.ie.b bVar = this.f130150g;
                    Intrinsics.checkNotNull(bVar);
                    Iterator it = bVar.a().iterator();
                    while (it.hasNext()) {
                        w.d("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: notifyCharacteristicChanged res = %s", String.valueOf(c().notifyCharacteristicChanged((BluetoothDevice) it.next(), characteristic, false)));
                    }
                } else {
                    com.tencent.luggage.wxa.ie.b bVar2 = this.f130150g;
                    Intrinsics.checkNotNull(bVar2);
                    Iterator it5 = bVar2.a().iterator();
                    while (it5.hasNext()) {
                        w.d("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: notifyCharacteristicChanged res = %s", String.valueOf(c().notifyCharacteristicChanged((BluetoothDevice) it5.next(), characteristic, true)));
                    }
                }
                com.tencent.luggage.wxa.ie.b bVar3 = this.f130150g;
                Intrinsics.checkNotNull(bVar3);
                m mVar = (m) bVar3.b().get(Integer.valueOf(i3));
                if (mVar == null) {
                    w.d("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: #" + i3 + " callbackId -> pendingResp is null");
                    return;
                }
                w.d("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: device = %s, requestId = %s", mVar.a().toString(), String.valueOf(mVar.c()));
                if (!c().sendResponse(mVar.a(), mVar.c(), 0, mVar.b(), characteristic.getValue())) {
                    w.b("MicroMsg.BLE.PeripheralBleServer", "sendPendingRespFail");
                }
                com.tencent.luggage.wxa.ie.b bVar4 = this.f130150g;
                Intrinsics.checkNotNull(bVar4);
                bVar4.b().remove(Integer.valueOf(i3));
            } catch (SecurityException e16) {
                w.b("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: " + e16.getMessage());
            }
        }
    }
}
