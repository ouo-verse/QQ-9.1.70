package com.tencent.luggage.wxa.ie;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattServerCallback;
import android.bluetooth.BluetoothGattService;
import android.util.Base64;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b extends BluetoothGattServerCallback {

    /* renamed from: d, reason: collision with root package name */
    public static final a f130089d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final HashSet f130090a = new HashSet();

    /* renamed from: b, reason: collision with root package name */
    public final Map f130091b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    public n f130092c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final HashSet a() {
        return this.f130090a;
    }

    public final Map b() {
        return this.f130091b;
    }

    public final n c() {
        n nVar = this.f130092c;
        if (nVar != null) {
            return nVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("server");
        return null;
    }

    @Override // android.bluetooth.BluetoothGattServerCallback
    public void onCharacteristicReadRequest(BluetoothDevice device, int i3, int i16, BluetoothGattCharacteristic characteristic) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(characteristic, "characteristic");
        super.onCharacteristicReadRequest(device, i3, i16, characteristic);
        w.d("MicroMsg.BLE.GattServerCallbackImpl", "Device tried to read characteristic: " + characteristic.getUuid());
        w.d("MicroMsg.BLE.GattServerCallbackImpl", "Value: " + Arrays.toString(characteristic.getValue()));
        if (!com.tencent.luggage.wxa.pe.b.a(QQPermissionConstants.Permission.BLUETOOTH_CONNECT)) {
            w.b("MicroMsg.BLE.GattServerCallbackImpl", "onCharacteristicReadRequest: no permission");
            return;
        }
        if (a(device)) {
            return;
        }
        if (i16 != 0) {
            try {
                c().c().sendResponse(device, i3, 7, i16, characteristic.getValue());
                return;
            } catch (SecurityException unused) {
                w.b("MicroMsg.BLE.GattServerCallbackImpl", "onCharacteristicReadRequest: no permission");
                return;
            }
        }
        int a16 = com.tencent.luggage.wxa.pe.b.a();
        while (this.f130091b.containsKey(Integer.valueOf(a16))) {
            a16 = com.tencent.luggage.wxa.pe.b.a();
        }
        w.d("MicroMsg.BLE.GattServerCallbackImpl", "onCharacteristicReadRequest: callbackId = %d", Integer.valueOf(a16));
        com.tencent.luggage.wxa.xd.d b16 = c().b();
        String address = device.getAddress();
        Intrinsics.checkNotNullExpressionValue(address, "device.address");
        int d16 = c().d();
        String uuid = characteristic.getService().getUuid().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "characteristic.service.uuid.toString()");
        String uuid2 = characteristic.getUuid().toString();
        Intrinsics.checkNotNullExpressionValue(uuid2, "characteristic.uuid.toString()");
        if (com.tencent.luggage.wxa.ie.a.a(b16, address, d16, uuid, uuid2, a16)) {
            w.d("MicroMsg.BLE.GattServerCallbackImpl", "onCharacteristicReadRequest: pendingWriteReqList ret = " + ((m) this.f130091b.put(Integer.valueOf(a16), new m(device, i3, i16))) + " id = " + a16);
        }
    }

    @Override // android.bluetooth.BluetoothGattServerCallback
    public void onCharacteristicWriteRequest(BluetoothDevice device, int i3, BluetoothGattCharacteristic characteristic, boolean z16, boolean z17, int i16, byte[] value) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(characteristic, "characteristic");
        Intrinsics.checkNotNullParameter(value, "value");
        super.onCharacteristicWriteRequest(device, i3, characteristic, z16, z17, i16, value);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Characteristic Write request: ");
        String arrays = Arrays.toString(value);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        sb5.append(arrays);
        w.e("MicroMsg.BLE.GattServerCallbackImpl", sb5.toString());
        if (a(device)) {
            return;
        }
        if (!com.tencent.luggage.wxa.pe.b.a(QQPermissionConstants.Permission.BLUETOOTH_CONNECT)) {
            w.f("MicroMsg.BLE.GattServerCallbackImpl", "onCharacteristicWriteRequest: no permission");
            return;
        }
        if (i16 != 0) {
            try {
                c().c().sendResponse(device, i3, 7, i16, characteristic.getValue());
                return;
            } catch (SecurityException e16) {
                w.b("MicroMsg.BLE.GattServerCallbackImpl", "onCharacteristicWriteRequest: sendResponse failed:" + e16.getMessage());
                return;
            }
        }
        int a16 = com.tencent.luggage.wxa.pe.b.a();
        while (this.f130091b.containsKey(Integer.valueOf(a16))) {
            a16 = com.tencent.luggage.wxa.pe.b.a();
        }
        w.d("MicroMsg.BLE.GattServerCallbackImpl", "onCharacteristicWriteRequest: callbackId = %d", Integer.valueOf(a16));
        byte[] base64Value = Base64.encode(value, 2);
        com.tencent.luggage.wxa.xd.d b16 = c().b();
        String address = device.getAddress();
        Intrinsics.checkNotNullExpressionValue(address, "device.address");
        int d16 = c().d();
        String uuid = characteristic.getService().getUuid().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "characteristic.service.uuid.toString()");
        String uuid2 = characteristic.getUuid().toString();
        Intrinsics.checkNotNullExpressionValue(uuid2, "characteristic.uuid.toString()");
        Intrinsics.checkNotNullExpressionValue(base64Value, "base64Value");
        if (com.tencent.luggage.wxa.ie.a.a(b16, address, d16, uuid, uuid2, a16, new String(base64Value, Charsets.UTF_8))) {
            w.d("MicroMsg.BLE.GattServerCallbackImpl", "onCharacteristicWriteRequest: pendingWriteReqList res = " + ((m) this.f130091b.put(Integer.valueOf(a16), new m(device, i3, i16))) + ", id = " + a16);
        }
    }

    @Override // android.bluetooth.BluetoothGattServerCallback
    public void onConnectionStateChange(BluetoothDevice device, int i3, int i16) {
        Intrinsics.checkNotNullParameter(device, "device");
        super.onConnectionStateChange(device, i3, i16);
        if (i3 == 0) {
            if (i16 != 0) {
                if (i16 == 2) {
                    this.f130090a.add(device);
                    com.tencent.luggage.wxa.xd.d b16 = c().b();
                    String address = device.getAddress();
                    Intrinsics.checkNotNullExpressionValue(address, "device.address");
                    com.tencent.luggage.wxa.ie.a.a(b16, address, String.valueOf(c().d()), true);
                    c().a(p.CONNECTED);
                    w.e("MicroMsg.BLE.GattServerCallbackImpl", "Connected to device: " + device.getAddress());
                    return;
                }
                return;
            }
            this.f130090a.remove(device);
            com.tencent.luggage.wxa.xd.d b17 = c().b();
            String address2 = device.getAddress();
            Intrinsics.checkNotNullExpressionValue(address2, "device.address");
            com.tencent.luggage.wxa.ie.a.a(b17, address2, String.valueOf(c().d()), false);
            c().a(p.CREATED);
            w.e("MicroMsg.BLE.GattServerCallbackImpl", "Disconnected from device");
            return;
        }
        this.f130090a.remove(device);
        w.b("MicroMsg.BLE.GattServerCallbackImpl", "Error when connecting: " + i3);
    }

    @Override // android.bluetooth.BluetoothGattServerCallback
    public void onDescriptorReadRequest(BluetoothDevice bluetoothDevice, int i3, int i16, BluetoothGattDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        super.onDescriptorReadRequest(bluetoothDevice, i3, i16, descriptor);
        w.d("MicroMsg.BLE.GattServerCallbackImpl", "Device tried to read descriptor: " + descriptor.getUuid());
        w.d("MicroMsg.BLE.GattServerCallbackImpl", "Value: " + Arrays.toString(descriptor.getValue()));
        if (!com.tencent.luggage.wxa.pe.b.a(QQPermissionConstants.Permission.BLUETOOTH_CONNECT)) {
            w.f("MicroMsg.BLE.GattServerCallbackImpl", "onDescriptorReadRequest: no permission");
            return;
        }
        try {
            if (i16 != 0) {
                c().c().sendResponse(bluetoothDevice, i3, 7, i16, null);
            } else {
                c().c().sendResponse(bluetoothDevice, i3, 0, i16, descriptor.getValue());
            }
        } catch (SecurityException e16) {
            w.b("MicroMsg.BLE.GattServerCallbackImpl", "onDescriptorReadRequest: " + e16.getMessage());
        }
    }

    @Override // android.bluetooth.BluetoothGattServerCallback
    public void onDescriptorWriteRequest(BluetoothDevice bluetoothDevice, int i3, BluetoothGattDescriptor descriptor, boolean z16, boolean z17, int i16, byte[] value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(value, "value");
        super.onDescriptorWriteRequest(bluetoothDevice, i3, descriptor, z16, z17, i16, value);
        if (!com.tencent.luggage.wxa.pe.b.a(QQPermissionConstants.Permission.BLUETOOTH_CONNECT)) {
            w.f("MicroMsg.BLE.GattServerCallbackImpl", "onDescriptorWriteRequest: android.permission.BLUETOOTH_CONNECT is not granted");
            return;
        }
        try {
            w.e("MicroMsg.BLE.GattServerCallbackImpl", "Descriptor Write Request " + descriptor.getUuid() + TokenParser.SP + Arrays.toString(value));
            if (z17) {
                c().c().sendResponse(bluetoothDevice, i3, 0, 0, null);
            }
        } catch (SecurityException e16) {
            w.b("MicroMsg.BLE.GattServerCallbackImpl", "onDescriptorWriteRequest: " + e16.getMessage());
        }
    }

    @Override // android.bluetooth.BluetoothGattServerCallback
    public void onNotificationSent(BluetoothDevice bluetoothDevice, int i3) {
        super.onNotificationSent(bluetoothDevice, i3);
        w.e("MicroMsg.BLE.GattServerCallbackImpl", "Notification sent. Status: " + i3);
    }

    @Override // android.bluetooth.BluetoothGattServerCallback
    public void onServiceAdded(int i3, BluetoothGattService bluetoothGattService) {
        super.onServiceAdded(i3, bluetoothGattService);
        if (bluetoothGattService != null && bluetoothGattService.getUuid() != null) {
            w.d("MicroMsg.BLE.GattServerCallbackImpl", "onServiceAdded: " + bluetoothGattService.getUuid());
            n c16 = c();
            UUID uuid = bluetoothGattService.getUuid();
            Intrinsics.checkNotNullExpressionValue(uuid, "service.uuid");
            c16.a(uuid);
        }
    }

    public final void a(n nVar) {
        Intrinsics.checkNotNullParameter(nVar, "<set-?>");
        this.f130092c = nVar;
    }

    public final boolean a(BluetoothDevice bluetoothDevice) {
        int collectionSizeOrDefault;
        if (bluetoothDevice == null) {
            w.d("MicroMsg.BLE.GattServerCallbackImpl", "deviceNotExist: device == null");
            return true;
        }
        HashSet hashSet = this.f130090a;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(hashSet, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            arrayList.add(((BluetoothDevice) it.next()).getAddress());
        }
        if (arrayList.contains(bluetoothDevice.getAddress())) {
            return false;
        }
        w.d("MicroMsg.BLE.GattServerCallbackImpl", "deviceNotExist: is not contain device");
        return true;
    }
}
