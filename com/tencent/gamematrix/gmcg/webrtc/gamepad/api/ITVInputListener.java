package com.tencent.gamematrix.gmcg.webrtc.gamepad.api;

import android.hardware.usb.UsbDevice;
import androidx.annotation.MainThread;

/* compiled from: P */
/* loaded from: classes6.dex */
public interface ITVInputListener {
    boolean isGamepad(int i3);

    boolean isTvController(int i3);

    void onGamepadPerfUpdate(GamepadPerfInfo gamepadPerfInfo);

    @MainThread
    void onInputDeviceChanged(int i3, int i16, IGameController iGameController);

    @MainThread
    void onInputEventNotify(int i3, int i16, int i17);

    void onUsbDevicePermissionResult(UsbDevice usbDevice, boolean z16);
}
