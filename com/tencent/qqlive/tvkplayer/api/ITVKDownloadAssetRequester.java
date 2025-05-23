package com.tencent.qqlive.tvkplayer.api;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ITVKDownloadAssetRequester {

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface ITVKDownloadAssetListener {
        void onFailure(int i3, TVKError tVKError);

        void onSuccess(int i3, TVKVodVideoInfo tVKVodVideoInfo);
    }

    int requestDownloadAsset(@NonNull TVKUserInfo tVKUserInfo, @NonNull TVKPlayerVideoInfo tVKPlayerVideoInfo, @NonNull String str, int i3) throws IllegalArgumentException;

    void setDownloadAssetListener(ITVKDownloadAssetListener iTVKDownloadAssetListener);
}
