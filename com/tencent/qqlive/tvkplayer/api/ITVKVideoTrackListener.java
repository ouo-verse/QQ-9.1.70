package com.tencent.qqlive.tvkplayer.api;

import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ITVKVideoTrackListener {
    void onVideoTrackError(TVKVideoTrackInfo tVKVideoTrackInfo, TVKError tVKError);

    void onVideoTrackNetInfo(TVKVideoTrackInfo tVKVideoTrackInfo, TVKNetVideoInfo tVKNetVideoInfo);

    void onVideoTrackShowingEnd(TVKVideoTrackInfo tVKVideoTrackInfo);

    void onVideoTrackShowingStart(TVKVideoTrackInfo tVKVideoTrackInfo);

    void onVideoTrackSizeChange(TVKVideoTrackInfo tVKVideoTrackInfo, int i3, int i16);
}
