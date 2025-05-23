package com.tencent.ilinkservice;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface IlinkImSessionInterface {
    int getDeviceShadow();

    void login();

    void setCallback(ImSessionCallback imSessionCallback);

    int updateDeviceShadow(byte[] bArr);
}
