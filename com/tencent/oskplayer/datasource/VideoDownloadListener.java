package com.tencent.oskplayer.datasource;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface VideoDownloadListener {
    void onCancel(String str);

    void onError(String str, int i3);

    boolean onProgress(String str, long j3, long j16);

    void onStart(String str);

    void onSuccess(String str, String str2);
}
