package com.tencent.tmdownloader;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface ITMAssistantDownloadClientListener {
    void onDownloadSDKTaskProgressChanged(TMAssistantDownloadClient tMAssistantDownloadClient, String str, long j3, long j16);

    void onDownloadSDKTaskStateChanged(TMAssistantDownloadClient tMAssistantDownloadClient, String str, int i3, int i16, String str2);

    void onDwonloadSDKServiceInvalid(TMAssistantDownloadClient tMAssistantDownloadClient);
}
