package com.tencent.qqlive.tvkplayer.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;

/* loaded from: classes23.dex */
public interface ITVKDownloadProxyUrlBuilder {

    /* loaded from: classes23.dex */
    public interface ProxyListener {
        void onDownloadError(TVKError tVKError);

        void onDownloadProgressUpdate(TVKDownloadProgressInfo tVKDownloadProgressInfo);

        void onDownloadSuccess();
    }

    @NonNull
    String buildDownloadProxyUrl(TVKNetVideoInfo tVKNetVideoInfo, @Nullable ProxyListener proxyListener) throws IllegalStateException, IllegalArgumentException;

    void stop();
}
