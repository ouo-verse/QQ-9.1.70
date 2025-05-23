package com.tencent.qqlive.tvkplayer.ad.api;

import com.tencent.qqlive.tvkplayer.ad.api.ITVKAdCommons;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ITVKAdListenerHookCallback {
    void onAdCallPlayerOpen(int i3, ITVKAdCommons.AdExtraInfo adExtraInfo);

    void onAdCgiError(int i3, int i16, int i17, ITVKAdCommons.AdErrorInfo adErrorInfo);

    void onAdComplete(int i3, long j3);

    void onAdDebugTrackingInfo(int i3, Object obj);

    void onAdLoadFinish(int i3, ITVKAdCommons.AdExtraInfo adExtraInfo);

    void onAdOpen(int i3, ITVKAdCommons.AdExtraInfo adExtraInfo);

    void onAdPause(int i3, long j3);

    void onAdPlayError(int i3, int i16, int i17, ITVKAdCommons.AdErrorInfo adErrorInfo);

    void onAdPlaying(int i3, long j3);

    void onAdPrepared(int i3, long j3, ITVKAdCommons.AdExtraInfo adExtraInfo);

    void onAdReceived(int i3, long j3, HashMap<Integer, Object> hashMap, ITVKAdCommons.AdExtraInfo adExtraInfo);

    void onAdRequest(int i3, String str, ITVKAdCommons.AdExtraInfo adExtraInfo);

    void onAdSendCgiRequest(int i3, ITVKAdCommons.AdExtraInfo adExtraInfo);

    void onPlayerOpenAd(ITVKAdCommons.AdExtraInfo adExtraInfo);
}
