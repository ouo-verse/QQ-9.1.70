package com.tencent.ad.tangram.views.canvas;

import android.support.annotation.Nullable;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.downloader.IAdDownloader;
import com.tencent.ad.tangram.views.canvas.components.appbutton.AdAppDownloadManager;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public interface AdCanvasDownloadListenerAdapter {
    @Nullable
    IAdDownloader.Callback getDownloadListener(AdAppDownloadManager adAppDownloadManager);

    void removeDownloadListener(AdAppDownloadManager adAppDownloadManager);

    void setDownloadListener(AdAppDownloadManager adAppDownloadManager);
}
