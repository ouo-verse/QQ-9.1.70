package com.tencent.thumbplayer.core.downloadproxy.api;

/* loaded from: classes26.dex */
public interface ITPDownloadListener {
    void deleteCacheFinished(String str);

    void didReleaseMemory(String str);

    void onDownloadInfoReportUpdate(String str);

    void onQuicQualityReportUpdate(String str);

    void willReleaseMemory(String str);
}
