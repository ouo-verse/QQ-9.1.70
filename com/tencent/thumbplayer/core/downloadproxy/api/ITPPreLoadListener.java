package com.tencent.thumbplayer.core.downloadproxy.api;

/* loaded from: classes26.dex */
public interface ITPPreLoadListener {
    void onPcdnDownloadFailed(String str);

    void onPrepareDownloadProgressUpdate(int i3, int i16, long j3, long j16, String str);

    void onPrepareError(int i3, int i16, String str);

    void onPrepareOK();
}
