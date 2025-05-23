package com.tencent.liteav.audio2.route;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbDevice;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.system.LiteavSystemInfo;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class a extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    final Context f118868a;

    /* renamed from: b, reason: collision with root package name */
    private final InterfaceC5950a f118869b;

    /* compiled from: P */
    /* renamed from: com.tencent.liteav.audio2.route.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC5950a {
        void onBluetoothConnectionChanged(boolean z16);

        void onBluetoothScoConnected(boolean z16);

        void onSystemVolumeChanged();

        void onUsbConnectionChanged(String str, boolean z16);

        void onWiredHeadsetConnectionChanged(boolean z16);
    }

    public a(Context context, InterfaceC5950a interfaceC5950a) {
        this.f118868a = context;
        this.f118869b = interfaceC5950a;
    }

    private static String a(int i3) {
        switch (i3) {
            case 10:
                return "STATE_OFF";
            case 11:
                return "STATE_TURNING_ON";
            case 12:
                return "STATE_ON";
            case 13:
                return "STATE_TURNING_OFF";
            default:
                return "unknown";
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        char c16;
        String str;
        boolean z16 = false;
        if (intent != null && context != null) {
            String action = intent.getAction();
            if (action == null) {
                return;
            }
            switch (action.hashCode()) {
                case -2114103349:
                    if (action.equals("android.hardware.usb.action.USB_DEVICE_ATTACHED")) {
                        c16 = 0;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -1940635523:
                    if (action.equals("android.media.VOLUME_CHANGED_ACTION")) {
                        c16 = 1;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -1676458352:
                    if (action.equals("android.intent.action.HEADSET_PLUG")) {
                        c16 = 2;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -1608292967:
                    if (action.equals("android.hardware.usb.action.USB_DEVICE_DETACHED")) {
                        c16 = 3;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -1530327060:
                    if (action.equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                        c16 = 4;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -1435586571:
                    if (action.equals("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED")) {
                        c16 = 5;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 545516589:
                    if (action.equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")) {
                        c16 = 6;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                default:
                    c16 = '\uffff';
                    break;
            }
            switch (c16) {
                case 0:
                case 3:
                    UsbDevice usbDevice = (UsbDevice) intent.getParcelableExtra("device");
                    if (usbDevice != null) {
                        if (LiteavSystemInfo.getSystemOSVersionInt() >= 21) {
                            Log.i("AudioEventBroadcastReceiver", "Usb device attached " + usbDevice.getProductName() + " manufacture " + usbDevice.getManufacturerName(), new Object[0]);
                        }
                        if (!AudioDeviceProperty.isUsbHeadsetDevice(usbDevice)) {
                            Log.i("AudioEventBroadcastReceiver", "The attached usb device doesn't seem to support audio, ignore it", new Object[0]);
                            return;
                        }
                        if ("android.hardware.usb.action.USB_DEVICE_ATTACHED".equals(intent.getAction())) {
                            this.f118869b.onUsbConnectionChanged(usbDevice.getProductName(), true);
                            return;
                        } else {
                            if ("android.hardware.usb.action.USB_DEVICE_DETACHED".equals(intent.getAction())) {
                                this.f118869b.onUsbConnectionChanged(usbDevice.getProductName(), false);
                                return;
                            }
                            Log.i("AudioEventBroadcastReceiver", "Unknown action, ignore it " + intent.getAction(), new Object[0]);
                            return;
                        }
                    }
                    return;
                case 1:
                    InterfaceC5950a interfaceC5950a = this.f118869b;
                    if (interfaceC5950a != null) {
                        interfaceC5950a.onSystemVolumeChanged();
                        return;
                    }
                    return;
                case 2:
                    int a16 = a(intent, "state", -1);
                    Log.i("AudioEventBroadcastReceiver", "Receive ACTION_HEADSET_PLUG, EXTRA_STATE:".concat(String.valueOf(a16)), new Object[0]);
                    if (a16 == -1) {
                        Log.e("AudioEventBroadcastReceiver", "Unknown headset state, ignore...", new Object[0]);
                        return;
                    }
                    InterfaceC5950a interfaceC5950a2 = this.f118869b;
                    if (a16 != 0) {
                        z16 = true;
                    }
                    interfaceC5950a2.onWiredHeadsetConnectionChanged(z16);
                    return;
                case 4:
                    int a17 = a(intent, "android.bluetooth.adapter.extra.STATE", 0);
                    Log.i("AudioEventBroadcastReceiver", "Receive ACTION_STATE_CHANGED, EXTRA_STATE:" + a(a17) + " EXTRA_PREVIOUS_STATE: " + a(a(intent, "android.bluetooth.adapter.extra.PREVIOUS_STATE", 0)), new Object[0]);
                    if (a17 == 10) {
                        this.f118869b.onBluetoothConnectionChanged(false);
                        return;
                    }
                    return;
                case 5:
                    int a18 = a(intent, "android.bluetooth.profile.extra.STATE", 10);
                    if (a18 == 12) {
                        Log.i("AudioEventBroadcastReceiver", "Receive bluetooth audio state changed to STATE_AUDIO_CONNECTED", new Object[0]);
                        this.f118869b.onBluetoothScoConnected(true);
                        return;
                    } else {
                        if (a18 == 10) {
                            Log.i("AudioEventBroadcastReceiver", "Receive bluetooth audio state changed to STATE_AUDIO_DISCONNECTED", new Object[0]);
                            this.f118869b.onBluetoothScoConnected(false);
                            return;
                        }
                        return;
                    }
                case 6:
                    int a19 = a(intent, "android.bluetooth.profile.extra.STATE", -1);
                    Object[] objArr = new Object[1];
                    if (a19 != 0) {
                        if (a19 != 1) {
                            if (a19 != 2) {
                                if (a19 != 3) {
                                    str = "unknown";
                                } else {
                                    str = "STATE_DISCONNECTING";
                                }
                            } else {
                                str = "STATE_CONNECTED";
                            }
                        } else {
                            str = "STATE_CONNECTING";
                        }
                    } else {
                        str = "STATE_DISCONNECTED";
                    }
                    objArr[0] = str;
                    Log.i("AudioEventBroadcastReceiver", "Receive bluetooth headset connection state changed: %s", objArr);
                    if (a19 != 0) {
                        if (a19 == 2) {
                            this.f118869b.onBluetoothConnectionChanged(true);
                            return;
                        }
                        return;
                    }
                    this.f118869b.onBluetoothConnectionChanged(false);
                    return;
                default:
                    Log.w("AudioEventBroadcastReceiver", "Ignore unknown Action:".concat(action), new Object[0]);
                    return;
            }
        }
        Log.e("AudioEventBroadcastReceiver", "Receive intent or context is null", new Object[0]);
    }

    private static int a(Intent intent, String str, int i3) {
        try {
            return intent.getIntExtra(str, i3);
        } catch (Exception e16) {
            Log.e("AudioEventBroadcastReceiver", "getIntentIntExtra ".concat(String.valueOf(e16)), new Object[0]);
            return i3;
        }
    }
}
