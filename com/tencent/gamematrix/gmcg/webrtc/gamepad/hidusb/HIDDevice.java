package com.tencent.gamematrix.gmcg.webrtc.gamepad.hidusb;

import android.hardware.usb.UsbDevice;

/* compiled from: P */
/* loaded from: classes6.dex */
public interface HIDDevice {
    String getManufacturerName();

    int getProductId();

    String getProductName();

    String getSerialNumber();

    UsbDevice getUsbDevice();

    int getVendorId();
}
