package com.tencent.thumbplayer.api.localproxy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import com.tencent.thumbplayer.api.common.TPDownloadProgressInfo;
import com.tencent.thumbplayer.api.common.TPError;

/* loaded from: classes26.dex */
public interface ITPLocalProxy {

    /* loaded from: classes26.dex */
    public interface LocalProxyListener {
        void onDownloadError(TPError tPError);

        void onDownloadProgressUpdate(TPDownloadProgressInfo tPDownloadProgressInfo);

        void onDownloadSuccess();
    }

    String buildProxyUrl(@NonNull ITPMediaAsset iTPMediaAsset, @Nullable LocalProxyListener localProxyListener) throws IllegalStateException, IllegalArgumentException;

    void release();
}
