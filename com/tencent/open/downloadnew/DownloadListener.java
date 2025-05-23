package com.tencent.open.downloadnew;

import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface DownloadListener {
    void installSucceed(String str, String str2);

    void onDownloadCancel(DownloadInfo downloadInfo);

    void onDownloadError(DownloadInfo downloadInfo, int i3, String str, int i16);

    void onDownloadFinish(DownloadInfo downloadInfo);

    void onDownloadPause(DownloadInfo downloadInfo);

    void onDownloadUpdate(List<DownloadInfo> list);

    void onDownloadWait(DownloadInfo downloadInfo);

    void packageReplaced(String str, String str2);

    void uninstallSucceed(String str, String str2);
}
