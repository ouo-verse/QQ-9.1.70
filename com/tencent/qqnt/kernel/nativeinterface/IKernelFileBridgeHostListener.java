package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IKernelFileBridgeHostListener {
    void onAuthNeedSetPassword();

    void onAuthenticationFailed(FileBridgeAuthenticationType fileBridgeAuthenticationType);

    void onAuthenticationSuccess(FileBridgeAuthenticationType fileBridgeAuthenticationType);

    void onConnected(int i3, WiFiPhotoConnectionType wiFiPhotoConnectionType);

    void onDisconnected(int i3);

    void onLocalPasswordReset();

    void onReconnecting(int i3);

    void onRequestVisitMyPC(String str);
}
