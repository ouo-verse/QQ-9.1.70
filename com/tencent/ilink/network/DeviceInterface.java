package com.tencent.ilink.network;

/* compiled from: P */
/* loaded from: classes7.dex */
public class DeviceInterface {
    private static final String TAG = "DeviceInterface";
    private static DeviceInterface instance;
    public DeviceCallbackInterface deviceCallback;

    public static native void SetLonglinkIplist(byte[] bArr);

    public static native void SetProxyInfo(byte[] bArr);

    public static native void SetShortlinkIplist(byte[] bArr);

    public static native void Start(byte[] bArr);

    public static native void Stop();

    public static DeviceInterface getInstance() {
        if (instance == null) {
            instance = new DeviceInterface();
        }
        return instance;
    }

    public static native boolean isAlreadyGetStrategy();

    public DeviceCallbackInterface getDeviceCallback() {
        return this.deviceCallback;
    }

    public void setDeviceCallback(DeviceCallbackInterface deviceCallbackInterface) {
        this.deviceCallback = deviceCallbackInterface;
    }
}
