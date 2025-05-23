package com.tencent.thumbplayer.api.preload;

import androidx.annotation.NonNull;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import com.tencent.thumbplayer.api.common.TPDownloadProgressInfo;
import com.tencent.thumbplayer.api.common.TPError;

/* loaded from: classes26.dex */
public interface ITPPreloader {
    public static final int INVALID_PRELOAD_ID = -1;

    /* loaded from: classes26.dex */
    public interface ITPPreloadListener {
        void onPreloadError(int i3, TPError tPError);

        void onPreloadProgressUpdate(int i3, TPDownloadProgressInfo tPDownloadProgressInfo);

        void onPreloadSuccess(int i3);
    }

    void setPreloadListener(@NonNull ITPPreloadListener iTPPreloadListener);

    int start(@NonNull ITPMediaAsset iTPMediaAsset);

    void stop(int i3);
}
