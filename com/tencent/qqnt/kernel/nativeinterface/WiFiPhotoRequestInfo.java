package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class WiFiPhotoRequestInfo {
    public String clientLoginLocation = "";
    public String clientDeviceName = "";
    public WiFiPhotoRequestType requestType = WiFiPhotoRequestType.values()[0];

    public String getClientDeviceName() {
        return this.clientDeviceName;
    }

    public String getClientLoginLocation() {
        return this.clientLoginLocation;
    }

    public WiFiPhotoRequestType getRequestType() {
        return this.requestType;
    }
}
