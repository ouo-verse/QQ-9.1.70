package com.tencent.ilinkservice;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface ImSessionCallback {
    void onDeviceShadowUpdate(byte[] bArr);

    void onGetDeviceShadow(int i3, int i16, byte[] bArr);

    void onLoginComplete(int i3);

    void onUpdateDeviceShadow(int i3, int i16, byte[] bArr);
}
