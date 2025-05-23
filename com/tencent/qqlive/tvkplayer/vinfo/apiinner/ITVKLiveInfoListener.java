package com.tencent.qqlive.tvkplayer.vinfo.apiinner;

import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKLiveVideoInfo;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ITVKLiveInfoListener {
    void onFailure(int i3, TVKError tVKError);

    void onSuccess(int i3, TVKLiveVideoInfo tVKLiveVideoInfo);
}
