package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes24.dex */
public interface IKernelWiFiPhotoClientListener {
    void onConnected(WiFiPhotoConnectionType wiFiPhotoConnectionType);

    void onDisconnection(int i3);

    void onDownloadFileCountUpdate(int i3, int i16, int i17);

    void onDownloadSpeedUpdate(long j3);

    void onDownloadTaskComplete(HashMap<String, ArrayList<String>> hashMap);

    void onFileDownloadComplete(String str, String str2, int i3, String str3, String str4, PhotoDetailInfo photoDetailInfo);

    void onFileDownloadProgress(String str, String str2, long j3, long j16);

    void onPeerRequestVisitAlbum();

    void onRequestResult(boolean z16, int i3, WiFiPhotoRequestType wiFiPhotoRequestType, WiFiPhotoAuthorizationInfo wiFiPhotoAuthorizationInfo);

    void onThumbDownloadComplete(String str, int i3, String str2, String str3);

    void onTimeoutCanceled();
}
