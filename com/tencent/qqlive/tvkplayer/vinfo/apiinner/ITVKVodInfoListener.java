package com.tencent.qqlive.tvkplayer.vinfo.apiinner;

import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ITVKVodInfoListener {
    void onFailure(int i3, TVKError tVKError);

    void onSuccess(int i3, TVKVodVideoInfo tVKVodVideoInfo);
}
