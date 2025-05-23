package com.tencent.qqlive.tvkplayer.hook;

import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.thumbplayer.api.common.TPDebugTrackingInfo;

/* loaded from: classes23.dex */
public interface ITVKQQLiveAssetPlayerListenerHookCallback {
    void onCompletion();

    void onDebugTrackingInfo(TPDebugTrackingInfo tPDebugTrackingInfo);

    void onError();

    void onInfo(int i3, long j3, long j16, Object obj);

    void onInfoAudioTrackSwitchEnd();

    void onInfoFirstVideoFrameRender();

    void onInfoSwitchDefinitionEnd();

    void onNetVideoInfo(TVKNetVideoInfo tVKNetVideoInfo);

    void onPermissionTimeout();

    void onVideoPrepared();
}
