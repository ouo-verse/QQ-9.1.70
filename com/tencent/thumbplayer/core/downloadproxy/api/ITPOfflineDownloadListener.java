package com.tencent.thumbplayer.core.downloadproxy.api;

import java.util.Map;

/* loaded from: classes26.dex */
public interface ITPOfflineDownloadListener {
    void onDownloadCdnUrlExpired(Map<String, String> map);

    void onDownloadCdnUrlInfoUpdate(String str, String str2, String str3, String str4);

    void onDownloadCdnUrlUpdate(String str);

    void onDownloadError(int i3, int i16, String str);

    void onDownloadFinish();

    void onDownloadProgressUpdate(int i3, int i16, long j3, long j16, String str);

    void onDownloadProtocolUpdate(String str, String str2);

    void onDownloadStatusUpdate(int i3);
}
