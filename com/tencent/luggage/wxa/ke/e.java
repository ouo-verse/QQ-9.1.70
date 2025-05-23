package com.tencent.luggage.wxa.ke;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface e {
    void a(BluetoothGatt bluetoothGatt, int i3);

    void a(BluetoothGatt bluetoothGatt, int i3, int i16);

    void a(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic);

    void a(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i3);

    void a(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i3);

    void b(BluetoothGatt bluetoothGatt, int i3);

    void b(BluetoothGatt bluetoothGatt, int i3, int i16);

    void b(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i3);

    void b(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i3);

    void c(BluetoothGatt bluetoothGatt, int i3, int i16);
}
