package com.tencent.gamematrix.gmcg.webrtc.gamepad.utils;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbInterface;
import android.view.InputDevice;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.keymapconfig.GlobalConfig;

/* compiled from: P */
/* loaded from: classes6.dex */
public class InputUtils {
    public static final int TV_KEYCDOE_DPAD_LEFT = 21;
    public static final int TV_KEYCODE_BACK = 4;
    public static final int TV_KEYCODE_DPAD_CENTER = 23;
    public static final int TV_KEYCODE_DPAD_DOWN = 20;
    public static final int TV_KEYCODE_DPAD_RIGHT = 22;
    public static final int TV_KEYCODE_DPAD_UP = 19;
    public static final int TV_KEYCODE_ENTER = 66;
    public static final int TV_KEYCODE_MENU = 82;
    public static final int TV_KEYCODE_VOLUMEDOWN = 25;
    public static final int TV_KEYCODE_VOLUMEUP = 24;

    public static String getDeviceName(int i3) {
        try {
            InputDevice device = InputDevice.getDevice(i3);
            if (device == null) {
                return "unknown";
            }
            String name = device.getName();
            if (name == null) {
                return "unknown";
            }
            return name;
        } catch (Exception e16) {
            e16.printStackTrace();
            return "unknown";
        }
    }

    public static int getDeviceProductId(int i3) {
        InputDevice device = InputDevice.getDevice(i3);
        if (device != null) {
            return device.getProductId();
        }
        return -1;
    }

    public static int getDeviceVendorId(int i3) {
        InputDevice device = InputDevice.getDevice(i3);
        if (device != null) {
            return device.getVendorId();
        }
        return -1;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:1:0x0000. Please report as an issue. */
    public static boolean isDpadKeyCode(int i3) {
        switch (i3) {
            default:
                switch (i3) {
                    case 268:
                    case 269:
                    case 270:
                    case 271:
                        break;
                    default:
                        return false;
                }
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                return true;
        }
    }

    public static boolean isMFGamepadController(UsbDevice usbDevice) {
        if (usbDevice == null || !isMFGamepadDevice(usbDevice.getVendorId(), usbDevice.getProductId())) {
            return false;
        }
        for (int i3 = 0; i3 < usbDevice.getInterfaceCount(); i3++) {
            if (isMFGamepadIface(usbDevice.getInterface(i3))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isMFGamepadDevice(int i3, int i16) {
        int[] iArr;
        int[] iArr2;
        boolean z16;
        int[] iArr3 = {4550, 10643};
        int[] iArr4 = {11, 16, 18, 28674};
        if (GlobalConfig.getInstance().isUseGamepadPidVidConfig()) {
            iArr = GlobalConfig.getInstance().getUsbVendorIds();
            iArr2 = GlobalConfig.getInstance().getUsbProductIds();
        } else {
            iArr = null;
            iArr2 = null;
        }
        if (iArr2 != null && iArr != null) {
            iArr3 = iArr;
            iArr4 = iArr2;
        }
        int length = iArr3.length;
        int i17 = 0;
        while (true) {
            if (i17 < length) {
                if (i3 == iArr3[i17]) {
                    z16 = true;
                    break;
                }
                i17++;
            } else {
                z16 = false;
                break;
            }
        }
        CGLog.i("[inputdevice] foundVendor = " + z16 + " productId = " + i16 + " vendor =" + i3);
        if (!z16) {
            return false;
        }
        for (int i18 : iArr4) {
            if (i16 == i18) {
                return true;
            }
        }
        return false;
    }

    public static boolean isMFGamepadIface(UsbInterface usbInterface) {
        int interfaceClass = usbInterface.getInterfaceClass();
        int interfaceProtocol = usbInterface.getInterfaceProtocol();
        if (interfaceClass == 255 || interfaceClass == 3) {
            if (interfaceProtocol != 0 && interfaceProtocol != 255) {
                return false;
            }
            return true;
        }
        return false;
    }

    public static boolean isTvKeyCode(int i3) {
        if (i3 != 4 && i3 != 66 && i3 != 82) {
            switch (i3) {
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    public static String makeInputEventMessage(int i3, int i16, int i17, String str) {
        String str2;
        String str3;
        String str4;
        if (i3 == 1) {
            str2 = "\u624b\u67c4\u8bbe\u5907";
        } else {
            str2 = "unknown event";
        }
        if (i16 == 1) {
            str3 = "\u4e8b\u4ef6\uff1a ";
        } else if (i16 == 2) {
            str3 = "\u9519\u8bef\uff1a ";
        } else {
            str3 = "unknown type";
        }
        if (i17 != 1) {
            if (i17 != 2) {
                if (i17 != 3) {
                    if (i17 != 100) {
                        if (i17 != 101) {
                            str4 = "unknown value";
                        } else {
                            str4 = "I/O\u9519\u8bef message: " + str;
                        }
                    } else {
                        str4 = "\u8bfb\u5199\u5f02\u5e38 message: " + str;
                    }
                } else {
                    str4 = "\u8bbe\u5907\u5173\u95ed";
                }
            } else {
                str4 = "\u8bbe\u5907\u8fde\u63a5 message: " + str;
            }
        } else {
            str4 = "\u8bbe\u5907\u6253\u5f00 message: " + str;
        }
        return str2 + str3 + str4;
    }
}
