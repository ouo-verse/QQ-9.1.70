package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IKernelFileBridgeClientListener {
    void onAuthenticationSuccess(FileBridgeAuthenticationType fileBridgeAuthenticationType);

    void onConnected(WiFiPhotoConnectionType wiFiPhotoConnectionType);

    void onDisconnected(int i3);

    void onFileDownloadComplete(String str, int i3, String str2);

    void onFileDownloadProgress(String str, long j3, long j16);

    void onFileDownloadSpeed(String str, long j3);

    void onFileDownloadStateChange(String str, FileBridgeDownloadState fileBridgeDownloadState);

    void onNeedHostSetPassword();

    void onNeedShowDownloadCompleteToast();

    void onNeedUserInputPassword();

    void onReconnecting();

    void onSearchFolderForFiles(long j3, int i3, ArrayList<FileBridgeNodeInfo> arrayList);

    void onStateChange(FileBridgeClientState fileBridgeClientState);

    void onThumbDownloadComplete(String str, int i3, String str2);
}
