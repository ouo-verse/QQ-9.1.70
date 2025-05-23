package com.tencent.gamematrix.gmcg.webrtc.gamepad.hidusb;

import android.hardware.usb.UsbDevice;
import androidx.annotation.MainThread;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.GamepadPerfInfo;

/* compiled from: P */
/* loaded from: classes6.dex */
public interface IHIDDeviceManageListener {
    void onGamepadPerfUpdate(GamepadPerfInfo gamepadPerfInfo);

    @MainThread
    void onHIDEventNotify(int i3, int i16, int i17, String str);

    void onInputEvent(HIDInputEvent hIDInputEvent);

    void onUsbDevicePermissionResult(UsbDevice usbDevice, boolean z16);
}
