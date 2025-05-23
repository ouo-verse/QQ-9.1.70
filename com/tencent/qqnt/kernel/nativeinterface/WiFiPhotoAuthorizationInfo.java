package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class WiFiPhotoAuthorizationInfo {
    public String userData;
    public String deviceName = "";
    public AuthorizationStatus authorizationStatus = AuthorizationStatus.values()[0];

    public AuthorizationStatus getAuthorizationStatus() {
        return this.authorizationStatus;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public String getUserData() {
        return this.userData;
    }
}
