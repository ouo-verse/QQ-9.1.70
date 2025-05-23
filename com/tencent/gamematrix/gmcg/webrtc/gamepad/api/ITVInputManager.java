package com.tencent.gamematrix.gmcg.webrtc.gamepad.api;

import android.hardware.usb.UsbDevice;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.GamepadController;
import java.util.Vector;

/* compiled from: P */
/* loaded from: classes6.dex */
public interface ITVInputManager extends IGamepadHidEvent {
    int checkAndOpenMFGamepad();

    void closeMFGamepad();

    Vector<IGameController> getGameControllers(int i3);

    String getInputEventMessage(int i3, int i16, int i17);

    boolean hasInputDeviceConnected(int i3);

    boolean hasMFGamepadConnected();

    boolean isOnlyMFGamepadConnected();

    void onGamepadOnlineNotification(int i3, int i16);

    boolean openMFGamepad();

    void registerAppClientInputListener(ITVInputListener iTVInputListener);

    void requestUsbPermission(UsbDevice usbDevice);

    void setClientConfig(boolean z16);

    void setGamepadController(GamepadController gamepadController);

    void unregisterAppClientInputListener(ITVInputListener iTVInputListener);
}
