package com.tencent.gamematrix.gmcg.webrtc.gamepad.hidusb;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.utils.InputUtils;

/* compiled from: P */
/* loaded from: classes6.dex */
public class HIDDeviceUSB implements HIDDevice {
    static final int RW_ENDPOINT_COUNT = 2;
    private static final String TAG = "usbdevice ";
    private HIDDeviceManage mHIDDeviceManage;
    private HIDDeviceUSBConnection mHidUsbConnection;
    private UsbDevice mUsbDevice;

    public HIDDeviceUSB(HIDDeviceManage hIDDeviceManage, UsbDevice usbDevice) {
        this.mHIDDeviceManage = hIDDeviceManage;
        this.mUsbDevice = usbDevice;
    }

    public boolean connect() {
        UsbDevice usbDevice;
        HIDDeviceUSBConnection hIDDeviceUSBConnection = this.mHidUsbConnection;
        if (hIDDeviceUSBConnection != null) {
            hIDDeviceUSBConnection.close();
            this.mHidUsbConnection = null;
        }
        if (this.mHIDDeviceManage != null && (usbDevice = this.mUsbDevice) != null && InputUtils.isMFGamepadDevice(usbDevice.getVendorId(), this.mUsbDevice.getProductId())) {
            int readWriteIfaceIndex = getReadWriteIfaceIndex(this.mUsbDevice);
            CGLog.d("usbdevice interface index=" + readWriteIfaceIndex);
            HIDDeviceUSBConnection hIDDeviceUSBConnection2 = new HIDDeviceUSBConnection(this.mHIDDeviceManage.getUsbManager(), this.mUsbDevice, readWriteIfaceIndex);
            this.mHidUsbConnection = hIDDeviceUSBConnection2;
            if (!hIDDeviceUSBConnection2.open() && !this.mHidUsbConnection.open()) {
                this.mHidUsbConnection = null;
            } else {
                return true;
            }
        }
        return false;
    }

    public void disconnect() {
        HIDDeviceUSBConnection hIDDeviceUSBConnection = this.mHidUsbConnection;
        if (hIDDeviceUSBConnection != null) {
            hIDDeviceUSBConnection.close();
            this.mHidUsbConnection = null;
        }
    }

    public HIDDeviceUSBConnection getConnection() {
        return this.mHidUsbConnection;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.hidusb.HIDDevice
    public String getManufacturerName() {
        String manufacturerName = this.mUsbDevice.getManufacturerName();
        if (manufacturerName == null) {
            return String.format("%x", Integer.valueOf(getVendorId()));
        }
        return manufacturerName;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.hidusb.HIDDevice
    public int getProductId() {
        return this.mUsbDevice.getProductId();
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.hidusb.HIDDevice
    public String getProductName() {
        String productName = this.mUsbDevice.getProductName();
        if (productName == null) {
            return String.format("%x", Integer.valueOf(getProductId()));
        }
        return productName;
    }

    public int getReadWriteIfaceIndex(UsbDevice usbDevice) {
        int i3;
        if (usbDevice == null) {
            return -1;
        }
        for (int i16 = 0; i16 < usbDevice.getInterfaceCount(); i16++) {
            UsbInterface usbInterface = this.mUsbDevice.getInterface(i16);
            if (InputUtils.isMFGamepadIface(usbInterface) && usbInterface.getEndpointCount() == 2) {
                i3 = 0;
                for (int i17 = 0; i17 < usbInterface.getEndpointCount(); i17++) {
                    UsbEndpoint endpoint = usbInterface.getEndpoint(i17);
                    int direction = endpoint.getDirection();
                    int maxPacketSize = endpoint.getMaxPacketSize();
                    if ((128 == direction && maxPacketSize == 32) || (direction == 0 && maxPacketSize == 32)) {
                        i3++;
                    }
                }
            } else {
                i3 = 0;
            }
            if (i3 == 2) {
                return i16;
            }
        }
        return -1;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.hidusb.HIDDevice
    public String getSerialNumber() {
        String serialNumber = this.mUsbDevice.getSerialNumber();
        if (serialNumber == null) {
            return "";
        }
        return serialNumber;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.hidusb.HIDDevice
    public UsbDevice getUsbDevice() {
        return this.mUsbDevice;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.hidusb.HIDDevice
    public int getVendorId() {
        return this.mUsbDevice.getVendorId();
    }
}
