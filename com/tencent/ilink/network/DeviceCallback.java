package com.tencent.ilink.network;

/* compiled from: P */
/* loaded from: classes7.dex */
public class DeviceCallback {
    public static void OnFinishGetStrategy() {
        if (DeviceInterface.getInstance().getDeviceCallback() != null) {
            DeviceInterface.getInstance().getDeviceCallback().OnFinishGetStrategy();
        }
    }

    public static void OnLonglinkConnected() {
        if (DeviceInterface.getInstance().getDeviceCallback() != null) {
            DeviceInterface.getInstance().getDeviceCallback().OnLonglinkConnected();
        }
    }

    public static void OnLonglinkDisconnected() {
        if (DeviceInterface.getInstance().getDeviceCallback() != null) {
            DeviceInterface.getInstance().getDeviceCallback().OnLonglinkDisconnected();
        }
    }

    public static void OnSessionTimeout() {
        if (DeviceInterface.getInstance().getDeviceCallback() != null) {
            DeviceInterface.getInstance().getDeviceCallback().OnSessionTimeout();
        }
    }
}
