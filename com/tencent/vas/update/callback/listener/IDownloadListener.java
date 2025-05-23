package com.tencent.vas.update.callback.listener;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface IDownloadListener {
    void onCompleted(String str, int i3, int i16, String str2);

    void onDownloadStart(String str);

    void onProgress(String str, long j3, long j16, int i3);
}
