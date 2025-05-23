package com.tencent.thumbplayer.core.datatransport.resourceloader;

/* loaded from: classes26.dex */
public interface ITPDownloadProxyResourceLoaderListener {
    String getContentType(int i3, String str);

    String getDataFilePath(int i3, String str);

    long getDataTotalSize(int i3, String str);

    int onReadData(int i3, String str, long j3, long j16);

    int onStartReadData(int i3, String str, long j3, long j16);

    int onStopReadData(int i3, String str, int i16);
}
