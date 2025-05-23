package com.tencent.xweb;

import com.tencent.xweb.XWebDownloader;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface XWebDownloadListener {
    void onDownloadCancelled();

    void onDownloadCompleted(XWebDownloader.DownloadInfo downloadInfo);

    void onDownloadFailed(XWebDownloader.DownloadInfo downloadInfo);

    void onDownloadStarted(int i3);

    void onDownloadUpdated(int i3);
}
