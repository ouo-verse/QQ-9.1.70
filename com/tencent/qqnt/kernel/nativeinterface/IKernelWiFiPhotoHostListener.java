package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public interface IKernelWiFiPhotoHostListener {
    void onAutoReconnecting(int i3);

    void onCanceled(Integer num);

    void onConnected(WiFiPhotoConnectionType wiFiPhotoConnectionType);

    void onDisconnection(int i3);

    void onRequestAlbumFullAccess();

    void onRequestVisitAlbum(int i3, WiFiPhotoRequestInfo wiFiPhotoRequestInfo);
}
