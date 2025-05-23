package com.tencent.qqlive.tvkplayer.hook;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import com.tencent.qqlive.tvkplayer.ad.api.ITVKAdCommons;
import com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer;
import com.tencent.qqlive.tvkplayer.api.ITVKReportEventListener;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.context.TVKReportEventParamsInner;
import com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack;
import com.tencent.thumbplayer.api.common.TPDebugTrackingInfo;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKReportHookCallback extends TVKPlayerHookCallback {
    private long mAdCompleteCurrentTime;
    private long mAdPrepareErrorDurationMs;
    private boolean mHasAd;
    private boolean mIsAdCGIed;
    private boolean mIsAdComplete;
    private boolean mIsAdPrepared;
    private boolean mIsAdPreparedError;
    private boolean mIsFirstStart;
    private long mOpenCurrentTime;
    private long mOpenCurrentTime1970Ms;
    private long mPreparedCurrentTime;
    private long mPreparingCurrentTime;
    private long mStartCurrentTime;
    private long mStartCurrentTime1970Ms;

    public TVKReportHookCallback(TVKContext tVKContext, ITVKMediaPlayer iTVKMediaPlayer, TVKPlayerManagerCallBack tVKPlayerManagerCallBack) {
        super(tVKContext, iTVKMediaPlayer, tVKPlayerManagerCallBack);
        this.mOpenCurrentTime = -1L;
        this.mPreparingCurrentTime = -1L;
        this.mPreparedCurrentTime = -1L;
        this.mAdCompleteCurrentTime = -1L;
        this.mStartCurrentTime = -1L;
        this.mHasAd = false;
        this.mIsAdCGIed = false;
        this.mIsFirstStart = true;
        this.mIsAdPrepared = false;
        this.mIsAdComplete = false;
        this.mIsAdPreparedError = false;
        this.mAdPrepareErrorDurationMs = 0L;
        this.mOpenCurrentTime1970Ms = -1L;
        this.mStartCurrentTime1970Ms = -1L;
    }

    private void handleAdCgiEndEvent(long j3) {
        if (this.mHasAd) {
            this.mPreparingCurrentTime = SystemClock.elapsedRealtime();
        }
        this.mIsAdCGIed = true;
        pushPlayerEvent(ITVKReportEventListener.ReportEvent.TVK_REPORT_EVENT_PRE_AD_CGIED, new TVKReportEventParamsInner.Builder().flowId(this.mFlowId).setTimeSince1970Ms(j3).addReportMapParam(ITVKReportEventListener.KEY_HAS_AD, Integer.valueOf(this.mHasAd ? 1 : 0)).addReportMapParam(ITVKReportEventListener.KEY_AD_CGI_DURATION_MS, Long.valueOf(SystemClock.elapsedRealtime() - this.mOpenCurrentTime)).build());
    }

    private void handlePreAdPreparedError(long j3) {
        this.mIsAdPreparedError = true;
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.mOpenCurrentTime;
        this.mAdPrepareErrorDurationMs = SystemClock.elapsedRealtime() - this.mPreparingCurrentTime;
        pushPlayerEvent(ITVKReportEventListener.ReportEvent.TVK_REPORT_EVENT_PRE_AD_PREPARED_ERROR, new TVKReportEventParamsInner.Builder().flowId(this.mFlowId).setTimeSince1970Ms(j3).addReportMapParam(ITVKReportEventListener.KEY_HAS_AD, Integer.valueOf(this.mHasAd ? 1 : 0)).addReportMapParam(ITVKReportEventListener.KEY_OPEN_TO_AD_PREPARE_ERROR_DURATION_MS, Long.valueOf(elapsedRealtime)).addReportMapParam(ITVKReportEventListener.KEY_AD_PREPARE_ERROR_DURATION_MS, Long.valueOf(this.mAdPrepareErrorDurationMs)).build());
    }

    private void handlePreparedEvent(long j3) {
        this.mPreparedCurrentTime = SystemClock.elapsedRealtime();
        pushPlayerEvent(ITVKReportEventListener.ReportEvent.TVK_REPORT_EVENT_PREPARED, new TVKReportEventParamsInner.Builder().flowId(this.mFlowId).setTimeSince1970Ms(j3).addReportMapParam(ITVKReportEventListener.KEY_HAS_AD, Integer.valueOf(this.mHasAd ? 1 : 0)).addReportMapParam(ITVKReportEventListener.KEY_MEDIA_TYPE, Integer.valueOf(!this.mHasAd ? 1 : 0)).addReportMapParam(ITVKReportEventListener.KEY_OPEN_TO_PREPARED_DURATION_MS, Long.valueOf(SystemClock.elapsedRealtime() - this.mOpenCurrentTime)).addReportMapParam(ITVKReportEventListener.KEY_PREPARED_DURATION_MS, Long.valueOf(SystemClock.elapsedRealtime() - this.mPreparingCurrentTime)).addReportMapParam(ITVKReportEventListener.KEY_AD_PREPARE_ERROR_DURATION_MS, Long.valueOf(this.mAdPrepareErrorDurationMs)).build());
    }

    private void handleRealPlayingEvent(TPDebugTrackingInfo tPDebugTrackingInfo) {
        if (tPDebugTrackingInfo.getTrackingInfoID() != 0) {
            return;
        }
        pushPlayerEvent(ITVKReportEventListener.ReportEvent.TVK_REPORT_EVENT_REAL_PLAYING, new TVKReportEventParamsInner.Builder().flowId(this.mFlowId).setTimeSince1970Ms(tPDebugTrackingInfo.getTimeSince1970Ms()).addReportMapParam(ITVKReportEventListener.KEY_HAS_AD, Integer.valueOf(this.mHasAd ? 1 : 0)).addReportMapParam(ITVKReportEventListener.KEY_MEDIA_TYPE, Integer.valueOf(!this.mHasAd ? 1 : 0)).addReportMapParam(ITVKReportEventListener.KEY_OPEN_TO_REAL_PLAY_DURATION_MS, Long.valueOf(tPDebugTrackingInfo.getTimeSince1970Ms() - this.mOpenCurrentTime1970Ms)).addReportMapParam(ITVKReportEventListener.KEY_REAL_PLAY_DURATION_MS, Long.valueOf(tPDebugTrackingInfo.getTimeSince1970Ms() - this.mStartCurrentTime1970Ms)).build());
    }

    private void handleStartEvent() {
        if (this.mIsFirstStart) {
            this.mIsFirstStart = false;
            this.mStartCurrentTime = SystemClock.elapsedRealtime();
            this.mStartCurrentTime1970Ms = System.currentTimeMillis();
            pushPlayerEvent(ITVKReportEventListener.ReportEvent.TVK_REPORT_EVENT_PLAYING, new TVKReportEventParamsInner.Builder().flowId(this.mFlowId).addReportMapParam(ITVKReportEventListener.KEY_HAS_AD, Integer.valueOf(this.mHasAd ? 1 : 0)).addReportMapParam(ITVKReportEventListener.KEY_MEDIA_TYPE, Integer.valueOf(!this.mHasAd ? 1 : 0)).addReportMapParam(ITVKReportEventListener.KEY_OPEN_TO_START_DURATION_MS, Long.valueOf(SystemClock.elapsedRealtime() - this.mOpenCurrentTime)).addReportMapParam(ITVKReportEventListener.KEY_START_DURATION_MS, Long.valueOf(SystemClock.elapsedRealtime() - this.mPreparedCurrentTime)).build());
        }
    }

    private void handleTransitionEvent() {
        pushPlayerEvent(ITVKReportEventListener.ReportEvent.TVK_REPORT_EVENT_TRANSITION, new TVKReportEventParamsInner.Builder().flowId(this.mFlowId).addReportMapParam(ITVKReportEventListener.KEY_HAS_AD, Integer.valueOf(this.mHasAd ? 1 : 0)).addReportMapParam(ITVKReportEventListener.KEY_AD_COMPLETE_TO_VIDEO_REAL_PLAY_DURATION_MS, Long.valueOf(SystemClock.elapsedRealtime() - this.mAdCompleteCurrentTime)).build());
    }

    private void printEvent(ITVKReportEventListener.ReportEvent reportEvent, ITVKReportEventListener.ReportEventParams reportEventParams) {
        this.mLogger.info("onReportPushEvent: event: " + reportEvent.name(), new Object[0]);
        this.mLogger.info("onReportPushEvent: param=" + reportEventParams.toString(), new Object[0]);
    }

    private void pushPlayerEvent(ITVKReportEventListener.ReportEvent reportEvent, ITVKReportEventListener.ReportEventParams reportEventParams) {
        ITVKMediaPlayer iTVKMediaPlayer = this.mPlayerManagerWeakReference.get();
        TVKPlayerManagerCallBack tVKPlayerManagerCallBack = this.mCallbackWeakReference.get();
        if (iTVKMediaPlayer != null && tVKPlayerManagerCallBack != null) {
            tVKPlayerManagerCallBack.onReportEvent(iTVKMediaPlayer, reportEvent, reportEventParams);
            printEvent(reportEvent, reportEventParams);
        }
    }

    private void resetParam() {
        this.mOpenCurrentTime = -1L;
        this.mPreparingCurrentTime = -1L;
        this.mPreparedCurrentTime = -1L;
        this.mAdCompleteCurrentTime = -1L;
        this.mStartCurrentTime = -1L;
        this.mHasAd = false;
        this.mIsAdCGIed = false;
        this.mIsFirstStart = true;
        this.mIsAdPrepared = false;
        this.mIsAdComplete = false;
        this.mIsAdPreparedError = false;
        this.mAdPrepareErrorDurationMs = 0L;
        this.mOpenCurrentTime1970Ms = -1L;
        this.mStartCurrentTime1970Ms = -1L;
    }

    @Override // com.tencent.qqlive.tvkplayer.hook.TVKPlayerHookCallback, com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListenerHookCallback
    public void onAdCallPlayerOpen(int i3, ITVKAdCommons.AdExtraInfo adExtraInfo) {
        super.onAdCallPlayerOpen(i3, adExtraInfo);
        if (i3 == 1) {
            pushPlayerEvent(ITVKReportEventListener.ReportEvent.TVK_REPORT_EVENT_PRE_AD_CALL_PLAYER_OPEN, new TVKReportEventParamsInner.Builder().flowId(this.mFlowId).setTimeSince1970Ms(adExtraInfo.currentTimeSince1970Ms).build());
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.hook.TVKPlayerHookCallback, com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListenerHookCallback
    public void onAdCgiError(int i3, int i16, int i17, ITVKAdCommons.AdErrorInfo adErrorInfo) {
        super.onAdCgiError(i3, i16, i17, adErrorInfo);
        this.mLogger.info("pushPlayerEvent, onReportPushEvent: onAdError errType=" + i16, new Object[0]);
        if (i3 == 1) {
            if (i16 == 1 || i16 == 2) {
                this.mHasAd = false;
                handleAdCgiEndEvent(adErrorInfo.currentTimeSince1970Ms);
            }
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.hook.TVKPlayerHookCallback, com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListenerHookCallback
    public void onAdComplete(int i3, long j3) {
        super.onAdComplete(i3, j3);
        this.mIsAdComplete = true;
        this.mLogger.info("pushPlayerEvent, onReportPushEvent: onAdComplete", new Object[0]);
        this.mAdCompleteCurrentTime = SystemClock.elapsedRealtime();
    }

    @Override // com.tencent.qqlive.tvkplayer.hook.TVKPlayerHookCallback, com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListenerHookCallback
    public void onAdDebugTrackingInfo(int i3, Object obj) {
        super.onAdDebugTrackingInfo(i3, obj);
        if (i3 == 1) {
            try {
                if (this.mHasAd) {
                    handleRealPlayingEvent((TPDebugTrackingInfo) obj);
                }
            } catch (Exception e16) {
                this.mLogger.error("onAdDetailInfo exception " + e16.getMessage(), new Object[0]);
            }
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.hook.TVKPlayerHookCallback, com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListenerHookCallback
    public void onAdLoadFinish(int i3, ITVKAdCommons.AdExtraInfo adExtraInfo) {
        super.onAdLoadFinish(i3, adExtraInfo);
        if (i3 == 1) {
            pushPlayerEvent(ITVKReportEventListener.ReportEvent.TVK_REPORT_EVENT_PRE_AD_CGI_RESPONSE_RECEIVED, new TVKReportEventParamsInner.Builder().flowId(this.mFlowId).setTimeSince1970Ms(adExtraInfo.currentTimeSince1970Ms).build());
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.hook.TVKPlayerHookCallback, com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListenerHookCallback
    public void onAdOpen(int i3, ITVKAdCommons.AdExtraInfo adExtraInfo) {
        super.onAdOpen(i3, adExtraInfo);
        if (i3 == 1) {
            pushPlayerEvent(ITVKReportEventListener.ReportEvent.TVK_REPORT_EVENT_PRE_AD_OPEN, new TVKReportEventParamsInner.Builder().flowId(this.mFlowId).setTimeSince1970Ms(adExtraInfo.currentTimeSince1970Ms).build());
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.hook.TVKPlayerHookCallback, com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListenerHookCallback
    public void onAdPlayError(int i3, int i16, int i17, ITVKAdCommons.AdErrorInfo adErrorInfo) {
        super.onAdPlayError(i3, i16, i17, adErrorInfo);
        this.mLogger.info("pushPlayerEvent, onReportPushEvent: onAdPlayError errType=" + i16, new Object[0]);
        if (i3 == 1 && i16 == 4 && !this.mIsAdPrepared) {
            handlePreAdPreparedError(adErrorInfo.currentTimeSince1970Ms);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.hook.TVKPlayerHookCallback, com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListenerHookCallback
    public void onAdPrepared(int i3, long j3, ITVKAdCommons.AdExtraInfo adExtraInfo) {
        super.onAdPrepared(i3, j3, adExtraInfo);
        if (i3 == 1) {
            this.mIsAdPrepared = true;
            if (this.mHasAd) {
                handlePreparedEvent(adExtraInfo.currentTimeSince1970Ms);
            }
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.hook.TVKPlayerHookCallback, com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListenerHookCallback
    public void onAdReceived(int i3, long j3, HashMap<Integer, Object> hashMap, ITVKAdCommons.AdExtraInfo adExtraInfo) {
        super.onAdReceived(i3, j3, hashMap, adExtraInfo);
        if (i3 == 1) {
            this.mHasAd = true;
            handleAdCgiEndEvent(adExtraInfo.currentTimeSince1970Ms);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.hook.TVKPlayerHookCallback, com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListenerHookCallback
    public void onAdRequest(int i3, String str, ITVKAdCommons.AdExtraInfo adExtraInfo) {
        super.onAdRequest(i3, str, adExtraInfo);
        if (i3 == 1) {
            pushPlayerEvent(ITVKReportEventListener.ReportEvent.TVK_REPORT_EVENT_PRE_AD_REQUEST_BEGIN, new TVKReportEventParamsInner.Builder().flowId(this.mFlowId).setTimeSince1970Ms(adExtraInfo.currentTimeSince1970Ms).addReportMapParam(ITVKReportEventListener.KEY_OPEN_TO_AD_REQUEST_BEGIN_DURATION_MS, Long.valueOf(SystemClock.elapsedRealtime() - this.mOpenCurrentTime)).build());
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.hook.TVKPlayerHookCallback, com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListenerHookCallback
    public void onAdSendCgiRequest(int i3, ITVKAdCommons.AdExtraInfo adExtraInfo) {
        super.onAdSendCgiRequest(i3, adExtraInfo);
        if (i3 == 1) {
            pushPlayerEvent(ITVKReportEventListener.ReportEvent.TVK_REPORT_EVENT_PRE_AD_SEND_CGI_REQUEST, new TVKReportEventParamsInner.Builder().flowId(this.mFlowId).setTimeSince1970Ms(adExtraInfo.currentTimeSince1970Ms).build());
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.hook.TVKPlayerHookCallback, com.tencent.qqlive.tvkplayer.hook.ITVKQQLiveAssetPlayerListenerHookCallback
    public void onDebugTrackingInfo(TPDebugTrackingInfo tPDebugTrackingInfo) {
        super.onDebugTrackingInfo(tPDebugTrackingInfo);
        if (tPDebugTrackingInfo.getTrackingInfoID() != 0) {
            return;
        }
        boolean z16 = this.mHasAd;
        if (!z16 || (z16 && this.mIsAdPreparedError)) {
            handleRealPlayingEvent(tPDebugTrackingInfo);
        }
        if (this.mIsAdComplete) {
            handleTransitionEvent();
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.hook.TVKPlayerHookCallback, com.tencent.qqlive.tvkplayer.hook.ITVKQQLiveAssetPlayerListenerHookCallback
    public void onNetVideoInfo(TVKNetVideoInfo tVKNetVideoInfo) {
        super.onNetVideoInfo(tVKNetVideoInfo);
        pushPlayerEvent(ITVKReportEventListener.ReportEvent.TVK_REPORT_EVENT_VIDEO_CGIED, new TVKReportEventParamsInner.Builder().flowId(this.mFlowId).addReportMapParam(ITVKReportEventListener.KEY_VIDEO_CGI_DURATION_MS, Long.valueOf(SystemClock.elapsedRealtime() - this.mOpenCurrentTime)).addReportMapParam(ITVKReportEventListener.KEY_IS_AD_CGIED, Integer.valueOf(this.mIsAdCGIed ? 1 : 0)).build());
    }

    @Override // com.tencent.qqlive.tvkplayer.hook.TVKPlayerHookCallback, com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListenerHookCallback
    public void onPlayerOpenAd(ITVKAdCommons.AdExtraInfo adExtraInfo) {
        super.onPlayerOpenAd(adExtraInfo);
        pushPlayerEvent(ITVKReportEventListener.ReportEvent.TVK_REPORT_EVENT_PLAYER_OPEN_AD, new TVKReportEventParamsInner.Builder().flowId(this.mFlowId).setTimeSince1970Ms(adExtraInfo.currentTimeSince1970Ms).build());
    }

    @Override // com.tencent.qqlive.tvkplayer.hook.TVKPlayerHookCallback, com.tencent.qqlive.tvkplayer.hook.ITVKQQLiveAssetPlayerListenerHookCallback
    public void onVideoPrepared() {
        super.onVideoPrepared();
        this.mLogger.info("pushPlayerEvent, onReportPushEvent: video onPrepared", new Object[0]);
        boolean z16 = this.mHasAd;
        if (!z16 || (z16 && this.mIsAdPreparedError)) {
            handlePreparedEvent(System.currentTimeMillis());
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.hook.TVKPlayerHookCallback, com.tencent.qqlive.tvkplayer.hook.ITVKQQLiveAssetPlayerHookCallback
    public void openMediaPlayer(Context context, TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo) {
        super.openMediaPlayer(context, tVKUserInfo, tVKPlayerVideoInfo);
        resetParam();
        this.mOpenCurrentTime = SystemClock.elapsedRealtime();
        this.mOpenCurrentTime1970Ms = System.currentTimeMillis();
    }

    @Override // com.tencent.qqlive.tvkplayer.hook.TVKPlayerHookCallback, com.tencent.qqlive.tvkplayer.hook.ITVKQQLiveAssetPlayerHookCallback
    public void openMediaPlayerByAfd(Context context, AssetFileDescriptor assetFileDescriptor, long j3, long j16) {
        super.openMediaPlayerByAfd(context, assetFileDescriptor, j3, j16);
        resetParam();
        this.mOpenCurrentTime = SystemClock.elapsedRealtime();
        this.mOpenCurrentTime1970Ms = System.currentTimeMillis();
    }

    @Override // com.tencent.qqlive.tvkplayer.hook.TVKPlayerHookCallback, com.tencent.qqlive.tvkplayer.hook.ITVKQQLiveAssetPlayerHookCallback
    public void openMediaPlayerByPfd(Context context, ParcelFileDescriptor parcelFileDescriptor, long j3, long j16) {
        super.openMediaPlayerByPfd(context, parcelFileDescriptor, j3, j16);
        resetParam();
        this.mOpenCurrentTime = SystemClock.elapsedRealtime();
        this.mOpenCurrentTime1970Ms = System.currentTimeMillis();
    }

    @Override // com.tencent.qqlive.tvkplayer.hook.TVKPlayerHookCallback, com.tencent.qqlive.tvkplayer.hook.ITVKQQLiveAssetPlayerHookCallback
    public void openMediaPlayerByUrl(Context context, String str, String str2, long j3, long j16, TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo) {
        super.openMediaPlayerByUrl(context, str, str2, j3, j16, tVKUserInfo, tVKPlayerVideoInfo);
        resetParam();
        this.mOpenCurrentTime = SystemClock.elapsedRealtime();
        this.mOpenCurrentTime1970Ms = System.currentTimeMillis();
    }

    @Override // com.tencent.qqlive.tvkplayer.hook.TVKPlayerHookCallback, com.tencent.qqlive.tvkplayer.hook.ITVKQQLiveAssetPlayerHookCallback
    public void prepare() {
        super.prepare();
        if (!this.mHasAd) {
            this.mPreparingCurrentTime = SystemClock.elapsedRealtime();
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.hook.TVKPlayerHookCallback, com.tencent.qqlive.tvkplayer.hook.ITVKQQLiveAssetPlayerHookCallback
    public void start() {
        super.start();
        handleStartEvent();
    }

    @Override // com.tencent.qqlive.tvkplayer.hook.TVKPlayerHookCallback, com.tencent.qqlive.tvkplayer.hook.ITVKQQLiveAssetPlayerHookCallback
    public void startAd() {
        super.startAd();
        handleStartEvent();
    }
}
