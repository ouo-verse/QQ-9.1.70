package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class NewDeviceVerifyReq {
    public AppInfo appInfo;
    public UserInfo userInfo = new UserInfo();
    public String passwordMd5 = "";
    public byte[] verifyNewDeviceSig = new byte[0];

    public AppInfo getAppInfo() {
        return this.appInfo;
    }

    public String getPasswordMd5() {
        return this.passwordMd5;
    }

    public UserInfo getUserInfo() {
        return this.userInfo;
    }

    public byte[] getVerifyNewDeviceSig() {
        return this.verifyNewDeviceSig;
    }

    public String toString() {
        return "NewDeviceVerifyReq{userInfo=" + this.userInfo + ",passwordMd5=" + this.passwordMd5 + ",verifyNewDeviceSig=" + this.verifyNewDeviceSig + ",appInfo=" + this.appInfo + ",}";
    }
}
