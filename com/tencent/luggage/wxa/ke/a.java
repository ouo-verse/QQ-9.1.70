package com.tencent.luggage.wxa.ke;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends BluetoothGattCallback {

    /* renamed from: a, reason: collision with root package name */
    public final e f131905a;

    public a(e eVar) {
        this.f131905a = eVar;
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.f131905a.a(bluetoothGatt, bluetoothGattCharacteristic);
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i3) {
        this.f131905a.a(bluetoothGatt, bluetoothGattCharacteristic, i3);
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i3) {
        this.f131905a.b(bluetoothGatt, bluetoothGattCharacteristic, i3);
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i3, int i16) {
        this.f131905a.c(bluetoothGatt, i3, i16);
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i3) {
        this.f131905a.a(bluetoothGatt, bluetoothGattDescriptor, i3);
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i3) {
        this.f131905a.b(bluetoothGatt, bluetoothGattDescriptor, i3);
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onMtuChanged(BluetoothGatt bluetoothGatt, int i3, int i16) {
        this.f131905a.a(bluetoothGatt, i3, i16);
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i3, int i16) {
        this.f131905a.b(bluetoothGatt, i3, i16);
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onReliableWriteCompleted(BluetoothGatt bluetoothGatt, int i3) {
        this.f131905a.a(bluetoothGatt, i3);
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i3) {
        this.f131905a.b(bluetoothGatt, i3);
    }
}
