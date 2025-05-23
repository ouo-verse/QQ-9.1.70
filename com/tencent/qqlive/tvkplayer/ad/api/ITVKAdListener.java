package com.tencent.qqlive.tvkplayer.ad.api;

import com.tencent.qqlive.tvkplayer.ad.api.ITVKAdCommons;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ITVKAdListener {
    void onAdCallPlayerOpen(int i3, ITVKAdCommons.AdExtraInfo adExtraInfo);

    void onAdCgiError(int i3, int i16, int i17, ITVKAdCommons.AdErrorInfo adErrorInfo);

    void onAdCountDown(int i3, long j3, long j16);

    void onAdCountDownComplete(int i3);

    void onAdCountDownStart(int i3, long j3, long j16);

    void onAdDetailInfo(int i3, Object obj);

    void onAdDownloaded(int i3);

    void onAdLoadFinish(int i3, ITVKAdCommons.AdExtraInfo adExtraInfo);

    void onAdOpen(int i3, ITVKAdCommons.AdExtraInfo adExtraInfo);

    void onAdPause(int i3, long j3);

    void onAdPlayComplete(int i3, long j3);

    void onAdPlayError(int i3, int i16, int i17, ITVKAdCommons.AdErrorInfo adErrorInfo);

    void onAdPlaying(int i3, long j3);

    void onAdPrepared(int i3, long j3, ITVKAdCommons.AdExtraInfo adExtraInfo);

    void onAdReceived(int i3, long j3, HashMap<Integer, Object> hashMap, ITVKAdCommons.AdExtraInfo adExtraInfo);

    void onAdRequest(int i3, String str, ITVKAdCommons.AdExtraInfo adExtraInfo);

    void onAdRequestPauseVideo(int i3);

    void onAdRequestResumeVideo(int i3);

    void onAdSendCgiRequest(int i3, ITVKAdCommons.AdExtraInfo adExtraInfo);

    void onClickSkip(int i3, int i16, boolean z16, boolean z17, int i17);

    Object onCustomCommand(String str, Object obj);

    void onExitFullScreenClick(int i3);

    void onFinishScrollAd(int i3);

    void onFullScreenClick(int i3);

    void onLandingViewClosed(int i3);

    void onLandingViewWillPresent(int i3);

    void onPlayerOpenAd(ITVKAdCommons.AdExtraInfo adExtraInfo);

    void onReturnClick(int i3, int i16);

    void onSwitchScrollAd(int i3, int i16, Object obj, Object obj2);

    void onVolumeChange(float f16);

    void onWarnerTipClick(int i3);
}
