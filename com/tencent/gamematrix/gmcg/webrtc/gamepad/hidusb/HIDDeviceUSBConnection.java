package com.tencent.gamematrix.gmcg.webrtc.gamepad.hidusb;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbManager;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.utils.InputUtils;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes6.dex */
public class HIDDeviceUSBConnection {
    private static final String TAG = "usbdevice ";
    private int mDeviceId;
    private int mInterfaceIndex;
    private byte[] mOutBuffer;
    private UsbDevice mUsbDevice;
    private UsbManager mUsbManager;
    private UsbDeviceConnection mConnection = null;
    private UsbEndpoint mInputEndpoint = null;
    private UsbEndpoint mOutputEndpoint = null;

    public HIDDeviceUSBConnection(UsbManager usbManager, UsbDevice usbDevice, int i3) {
        this.mUsbManager = usbManager;
        this.mUsbDevice = usbDevice;
        this.mInterfaceIndex = i3;
        initCmdBuffer();
    }

    public void close() {
        UsbDevice usbDevice;
        CGLog.i("usbdevice close device!");
        if (this.mConnection != null && (usbDevice = this.mUsbDevice) != null) {
            CGLog.i("usbdevice release interface=" + this.mInterfaceIndex + " res=" + this.mConnection.releaseInterface(usbDevice.getInterface(this.mInterfaceIndex)));
            this.mConnection.close();
            CGLog.i("usbdevice connection closed!");
            this.mConnection = null;
        }
        this.mConnection = null;
    }

    public int getMaxPacketSize() {
        UsbEndpoint usbEndpoint = this.mInputEndpoint;
        if (usbEndpoint != null) {
            return usbEndpoint.getMaxPacketSize();
        }
        return 0;
    }

    public UsbDevice getUsbDevice() {
        return this.mUsbDevice;
    }

    public void initCmdBuffer() {
        byte[] bArr = new byte[32];
        this.mOutBuffer = bArr;
        Arrays.fill(bArr, (byte) 0);
        byte[] bArr2 = this.mOutBuffer;
        bArr2[0] = 1;
        bArr2[1] = 0;
        bArr2[4] = 0;
        bArr2[5] = 3;
        bArr2[6] = 101;
        bArr2[7] = 0;
        bArr2[8] = 0;
        bArr2[9] = 0;
        bArr2[10] = 1;
        bArr2[11] = 0;
        bArr2[12] = 0;
        bArr2[13] = 0;
        bArr2[14] = 0;
        bArr2[15] = 0;
        bArr2[16] = 0;
        bArr2[17] = 0;
        bArr2[18] = 0;
        bArr2[19] = 0;
        bArr2[20] = 0;
        bArr2[21] = 0;
        bArr2[22] = 0;
        bArr2[23] = 0;
        bArr2[24] = 0;
    }

    public boolean open() {
        UsbDevice usbDevice;
        if (this.mUsbManager != null && (usbDevice = this.mUsbDevice) != null) {
            UsbInterface usbInterface = usbDevice.getInterface(this.mInterfaceIndex);
            if (!InputUtils.isMFGamepadIface(usbInterface)) {
                return false;
            }
            UsbDeviceConnection openDevice = this.mUsbManager.openDevice(this.mUsbDevice);
            this.mConnection = openDevice;
            if (openDevice == null) {
                CGLog.d("usbdevice open device failed! the user didn't gave me permissions or the device is not present");
                return false;
            }
            if (!openDevice.claimInterface(usbInterface, true)) {
                CGLog.d("usbdevice claimInterface failed!");
                close();
                return false;
            }
            for (int i3 = 0; i3 < usbInterface.getEndpointCount(); i3++) {
                UsbEndpoint endpoint = usbInterface.getEndpoint(i3);
                int direction = endpoint.getDirection();
                if (128 == direction) {
                    this.mInputEndpoint = endpoint;
                } else if (direction == 0) {
                    this.mOutputEndpoint = endpoint;
                }
            }
            if (this.mInputEndpoint != null && this.mOutputEndpoint != null) {
                CGLog.i("usbdevice device is opened!");
                return true;
            }
            CGLog.d("usbdevice endpoint is null!");
            close();
            return false;
        }
        CGLog.d("usbdevice usbdevice is null");
        return false;
    }

    public int readData(byte[] bArr, int i3, int i16) {
        UsbDeviceConnection usbDeviceConnection;
        UsbEndpoint usbEndpoint = this.mInputEndpoint;
        if (usbEndpoint != null && (usbDeviceConnection = this.mConnection) != null) {
            return usbDeviceConnection.bulkTransfer(usbEndpoint, bArr, i3, i16);
        }
        return -1;
    }

    public boolean sendCmdButtonMode(byte b16) {
        byte[] bArr = this.mOutBuffer;
        if (bArr != null) {
            bArr[23] = b16;
            return sendOutputReport(bArr);
        }
        return false;
    }

    public int sendDataToDevice(byte[] bArr, int i3) {
        UsbDeviceConnection usbDeviceConnection;
        UsbEndpoint usbEndpoint = this.mOutputEndpoint;
        if (usbEndpoint != null && (usbDeviceConnection = this.mConnection) != null) {
            return usbDeviceConnection.bulkTransfer(usbEndpoint, bArr, bArr.length, i3);
        }
        return -1;
    }

    public boolean sendKeepAlive() {
        byte[] bArr = this.mOutBuffer;
        if (bArr == null) {
            return true;
        }
        bArr[10] = (byte) (1 | bArr[10]);
        return sendOutputReport(bArr);
    }

    public boolean sendOutputReport(byte[] bArr) {
        if (bArr != null) {
            int i3 = this.mDeviceId;
            bArr[1] = (byte) (i3 & 255);
            bArr[2] = (byte) ((i3 >> 8) & 255);
            int bulkTransfer = this.mConnection.bulkTransfer(this.mOutputEndpoint, bArr, bArr.length, 100);
            if (bulkTransfer != bArr.length) {
                CGLog.i("usbdevice send report data length=" + bulkTransfer + " on device " + this.mUsbDevice.getDeviceName());
                return false;
            }
        }
        return true;
    }

    public int writeAlive(int i3, byte b16) {
        return 0;
    }
}
