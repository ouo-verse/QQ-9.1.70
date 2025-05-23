package com.tencent.ad.tangram.downloader;

import android.support.annotation.NonNull;
import android.util.Pair;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface AdDownloaderAdapter extends IAdDownloader {
    @NonNull
    IAdDownloader getDownloader();

    int getProgress(Object obj);

    boolean isCurrentPkgTask(Pair<String, String> pair, Object obj);
}
