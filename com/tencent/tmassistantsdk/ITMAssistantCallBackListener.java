package com.tencent.tmassistantsdk;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface ITMAssistantCallBackListener {
    void onDownloadTaskProgressChanged(TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, long j3, long j16);

    void onDownloadTaskStateChanged(TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, int i3, int i16, String str);

    void onQQDownloaderInvalid();

    void onServiceFree();
}
