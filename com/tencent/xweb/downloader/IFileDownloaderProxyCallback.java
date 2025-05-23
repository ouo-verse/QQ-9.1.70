package com.tencent.xweb.downloader;

import com.tencent.xweb.CalledByApi;

@CalledByApi
/* loaded from: classes27.dex */
public interface IFileDownloaderProxyCallback {
    void onTaskFailed(String str, int i3, boolean z16);

    void onTaskFinished(String str, String str2, boolean z16);

    void onTaskProgressChanged(String str, long j3, long j16);
}
