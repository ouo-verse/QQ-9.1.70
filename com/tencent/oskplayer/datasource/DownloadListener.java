package com.tencent.oskplayer.datasource;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface DownloadListener {
    void onEnd(String str);

    void onError(String str, int i3);

    void onStart(String str);

    void onTransfer(String str, int i3);
}
