package com.tencent.qqlive.tvkplayer.hook;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.os.ParcelFileDescriptor;
import com.tencent.qqlive.tvkplayer.ad.api.ITVKAdCommons;
import com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListenerHookCallback;
import com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKProperties;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.logic.TVKEventParamsInner;
import com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack;
import com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger;
import com.tencent.qqlive.tvkplayer.tools.log.TVKLogger;
import com.tencent.thumbplayer.api.common.TPDebugTrackingInfo;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: classes23.dex */
public class TVKPlayerHookCallback implements ITVKQQLiveAssetPlayerHookCallback, ITVKQQLiveAssetPlayerListenerHookCallback, ITVKAdListenerHookCallback {
    private static final String TAG = "TVKPlayerHookCallback";
    protected WeakReference<TVKPlayerManagerCallBack> mCallbackWeakReference;
    protected String mFlowId;
    protected final ITVKLogger mLogger;
    private TVKNetVideoInfo mNetVideoInfo;
    protected WeakReference<ITVKMediaPlayer> mPlayerManagerWeakReference;
    private long mStartPositionMs;

    public TVKPlayerHookCallback(TVKContext tVKContext, ITVKMediaPlayer iTVKMediaPlayer, TVKPlayerManagerCallBack tVKPlayerManagerCallBack) {
        this.mLogger = new TVKLogger(tVKContext, TAG);
        this.mPlayerManagerWeakReference = new WeakReference<>(iTVKMediaPlayer);
        this.mCallbackWeakReference = new WeakReference<>(tVKPlayerManagerCallBack);
    }

    private ITVKPlayerEventListener.AdType convertToEventAdType(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return ITVKPlayerEventListener.AdType.AD_TYPE_UNKNOWN;
                }
                return ITVKPlayerEventListener.AdType.AD_TYPE_POSTAD;
            }
            return ITVKPlayerEventListener.AdType.AD_TYPE_MIDAD;
        }
        return ITVKPlayerEventListener.AdType.AD_TYPE_PREAD;
    }

    private void onInfoAudioDecodeModeDidChange(int i3) {
        ITVKMediaPlayer iTVKMediaPlayer = this.mPlayerManagerWeakReference.get();
        if (iTVKMediaPlayer == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(TVKDaTongReport.KEY_AUDIO_DECODER_TYPE, String.valueOf(i3));
        pushPlayerEvent(ITVKPlayerEventListener.PlayerEvent.PLAYER_EVENT_ADD_EXTRA_REPORT_PARAM, new TVKEventParamsInner.Builder().flowId(this.mFlowId).currentPosMs(iTVKMediaPlayer.getCurrentPosition()).addExtraParam(ITVKPlayerEventListener.KEY_EXTRA_PARAM_MAP, hashMap).build());
    }

    private void onInfoDolbyVisionSoftRender() {
        ITVKMediaPlayer iTVKMediaPlayer = this.mPlayerManagerWeakReference.get();
        if (iTVKMediaPlayer == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(TVKDaTongReport.KEY_DOLBY_VISON_RENDER_TYPE, String.valueOf(1));
        pushPlayerEvent(ITVKPlayerEventListener.PlayerEvent.PLAYER_EVENT_ADD_EXTRA_REPORT_PARAM, new TVKEventParamsInner.Builder().flowId(this.mFlowId).currentPosMs(iTVKMediaPlayer.getCurrentPosition()).addExtraParam(ITVKPlayerEventListener.KEY_EXTRA_PARAM_MAP, hashMap).build());
    }

    private void pushAdPlayerEvent(ITVKPlayerEventListener.PlayerEvent playerEvent, long j3, int i3, long j16) {
        ITVKPlayerEventListener.AdType convertToEventAdType = convertToEventAdType(i3);
        if (convertToEventAdType == ITVKPlayerEventListener.AdType.AD_TYPE_UNKNOWN) {
            this.mLogger.info("pushAdPlayerEvent,  adType is not pread/midad/postad, not need push adplayerEvent", new Object[0]);
            return;
        }
        TVKEventParamsInner.Builder addExtraParam = new TVKEventParamsInner.Builder().flowId(this.mFlowId).currentPosMs(j3).addExtraParam("adtype", convertToEventAdType);
        if (playerEvent == ITVKPlayerEventListener.PlayerEvent.PLAYER_EVENT_AD_PREPARED) {
            addExtraParam.addExtraParam(ITVKPlayerEventListener.KEY_AD_DURATION, Long.valueOf(j16));
        }
        pushPlayerEvent(playerEvent, addExtraParam.build());
    }

    private void pushPlayerEvent(ITVKPlayerEventListener.PlayerEvent playerEvent, ITVKPlayerEventListener.EventParams eventParams) {
        ITVKPlayerEventListener.AdType adType;
        String str;
        long currentPos;
        ITVKMediaPlayer iTVKMediaPlayer = this.mPlayerManagerWeakReference.get();
        TVKPlayerManagerCallBack tVKPlayerManagerCallBack = this.mCallbackWeakReference.get();
        if (iTVKMediaPlayer != null && tVKPlayerManagerCallBack != null) {
            if (eventParams == null) {
                adType = ITVKPlayerEventListener.AdType.AD_TYPE_UNKNOWN;
            } else {
                adType = (ITVKPlayerEventListener.AdType) eventParams.getParamByKey("adtype", ITVKPlayerEventListener.AdType.AD_TYPE_UNKNOWN);
            }
            ITVKLogger iTVKLogger = this.mLogger;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("pushPlayerEvent, onPlayerEvent: ");
            sb5.append(playerEvent.name());
            if (adType == ITVKPlayerEventListener.AdType.AD_TYPE_UNKNOWN) {
                str = "";
            } else {
                str = ", adType: " + adType;
            }
            sb5.append(str);
            sb5.append(", curPosition: ");
            if (eventParams == null) {
                currentPos = 0;
            } else {
                currentPos = eventParams.getCurrentPos();
            }
            sb5.append(currentPos);
            iTVKLogger.info(sb5.toString(), new Object[0]);
            tVKPlayerManagerCallBack.onPlayerEvent(iTVKMediaPlayer, playerEvent, eventParams);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListenerHookCallback
    public void onAdComplete(int i3, long j3) {
        pushAdPlayerEvent(ITVKPlayerEventListener.PlayerEvent.PLAYER_EVENT_AD_COMPLETE, j3, i3, 0L);
    }

    @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListenerHookCallback
    public void onAdPause(int i3, long j3) {
        pushAdPlayerEvent(ITVKPlayerEventListener.PlayerEvent.PLAYER_EVENT_AD_PAUSED, j3, i3, 0L);
    }

    @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListenerHookCallback
    public void onAdPlayError(int i3, int i16, int i17, ITVKAdCommons.AdErrorInfo adErrorInfo) {
        pushAdPlayerEvent(ITVKPlayerEventListener.PlayerEvent.PLAYER_EVENT_AD_ERROR, adErrorInfo.playTime, i3, 0L);
    }

    @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListenerHookCallback
    public void onAdPlaying(int i3, long j3) {
        pushAdPlayerEvent(ITVKPlayerEventListener.PlayerEvent.PLAYER_EVENT_AD_PLAYING, j3, i3, 0L);
    }

    @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListenerHookCallback
    public void onAdPrepared(int i3, long j3, ITVKAdCommons.AdExtraInfo adExtraInfo) {
        pushAdPlayerEvent(ITVKPlayerEventListener.PlayerEvent.PLAYER_EVENT_AD_PREPARED, 0L, i3, j3);
    }

    @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListenerHookCallback
    public void onAdRequest(int i3, String str, ITVKAdCommons.AdExtraInfo adExtraInfo) {
        pushAdPlayerEvent(ITVKPlayerEventListener.PlayerEvent.PLAYER_EVENT_AD_PREPARING, 0L, i3, 0L);
    }

    @Override // com.tencent.qqlive.tvkplayer.hook.ITVKQQLiveAssetPlayerListenerHookCallback
    public void onCompletion() {
        ITVKMediaPlayer iTVKMediaPlayer = this.mPlayerManagerWeakReference.get();
        if (iTVKMediaPlayer == null) {
            return;
        }
        pushPlayerEvent(ITVKPlayerEventListener.PlayerEvent.PLAYER_EVENT_VIDEO_COMPLETE, new TVKEventParamsInner.Builder().flowId(this.mFlowId).currentPosMs(iTVKMediaPlayer.getDuration()).build());
    }

    @Override // com.tencent.qqlive.tvkplayer.hook.ITVKQQLiveAssetPlayerListenerHookCallback
    public void onError() {
        ITVKMediaPlayer iTVKMediaPlayer = this.mPlayerManagerWeakReference.get();
        if (iTVKMediaPlayer == null) {
            return;
        }
        pushPlayerEvent(ITVKPlayerEventListener.PlayerEvent.PLAYER_EVENT_VIDEO_ERROR, new TVKEventParamsInner.Builder().flowId(this.mFlowId).currentPosMs(iTVKMediaPlayer.getCurrentPosition()).build());
    }

    @Override // com.tencent.qqlive.tvkplayer.hook.ITVKQQLiveAssetPlayerListenerHookCallback
    public void onInfo(int i3, long j3, long j16, Object obj) {
        if (i3 != 105) {
            if (i3 != 111) {
                if (i3 != 114) {
                    if (i3 != 126) {
                        if (i3 == 601) {
                            onInfoDolbyVisionSoftRender();
                            return;
                        }
                        return;
                    }
                    onInfoAudioTrackSwitchEnd();
                    return;
                }
                onInfoAudioDecodeModeDidChange((int) j3);
                return;
            }
            if (j16 == 0) {
                onInfoSwitchDefinitionEnd();
                return;
            }
            return;
        }
        onInfoFirstVideoFrameRender();
    }

    @Override // com.tencent.qqlive.tvkplayer.hook.ITVKQQLiveAssetPlayerListenerHookCallback
    public void onInfoAudioTrackSwitchEnd() {
        ITVKMediaPlayer iTVKMediaPlayer = this.mPlayerManagerWeakReference.get();
        if (iTVKMediaPlayer == null) {
            return;
        }
        pushPlayerEvent(ITVKPlayerEventListener.PlayerEvent.PLAYER_EVENT_AUDIO_TRACK_SWITCH_END, new TVKEventParamsInner.Builder().flowId(this.mFlowId).currentPosMs(iTVKMediaPlayer.getCurrentPosition()).addExtraParam(ITVKPlayerEventListener.KEY_NET_VIDEO_INFO, this.mNetVideoInfo).build());
    }

    @Override // com.tencent.qqlive.tvkplayer.hook.ITVKQQLiveAssetPlayerListenerHookCallback
    public void onInfoFirstVideoFrameRender() {
        ITVKMediaPlayer iTVKMediaPlayer = this.mPlayerManagerWeakReference.get();
        if (iTVKMediaPlayer == null) {
            return;
        }
        pushPlayerEvent(ITVKPlayerEventListener.PlayerEvent.PLAYER_EVENT_FIRST_VIDEO_FRAME_RENDERED, new TVKEventParamsInner.Builder().flowId(this.mFlowId).currentPosMs(iTVKMediaPlayer.getCurrentPosition()).build());
    }

    @Override // com.tencent.qqlive.tvkplayer.hook.ITVKQQLiveAssetPlayerListenerHookCallback
    public void onInfoSwitchDefinitionEnd() {
        ITVKMediaPlayer iTVKMediaPlayer = this.mPlayerManagerWeakReference.get();
        if (iTVKMediaPlayer == null) {
            return;
        }
        pushPlayerEvent(ITVKPlayerEventListener.PlayerEvent.PLAYER_EVENT_SWITCH_DEFINITION_END, new TVKEventParamsInner.Builder().flowId(this.mFlowId).currentPosMs(iTVKMediaPlayer.getCurrentPosition()).addExtraParam(ITVKPlayerEventListener.KEY_NET_VIDEO_INFO, this.mNetVideoInfo).build());
    }

    @Override // com.tencent.qqlive.tvkplayer.hook.ITVKQQLiveAssetPlayerListenerHookCallback
    public void onNetVideoInfo(TVKNetVideoInfo tVKNetVideoInfo) {
        ITVKMediaPlayer iTVKMediaPlayer = this.mPlayerManagerWeakReference.get();
        if (iTVKMediaPlayer == null) {
            return;
        }
        this.mNetVideoInfo = tVKNetVideoInfo;
        pushPlayerEvent(ITVKPlayerEventListener.PlayerEvent.PLAYER_EVENT_CGI_RECEIVED, new TVKEventParamsInner.Builder().flowId(this.mFlowId).currentPosMs(iTVKMediaPlayer.getCurrentPosition()).addExtraParam(ITVKPlayerEventListener.KEY_NET_VIDEO_INFO, tVKNetVideoInfo).build());
    }

    @Override // com.tencent.qqlive.tvkplayer.hook.ITVKQQLiveAssetPlayerListenerHookCallback
    public void onPermissionTimeout() {
        ITVKMediaPlayer iTVKMediaPlayer = this.mPlayerManagerWeakReference.get();
        if (iTVKMediaPlayer == null) {
            return;
        }
        pushPlayerEvent(ITVKPlayerEventListener.PlayerEvent.PLAYER_EVENT_VIDEO_COMPLETE, new TVKEventParamsInner.Builder().flowId(this.mFlowId).currentPosMs(iTVKMediaPlayer.getCurrentPosition()).build());
    }

    @Override // com.tencent.qqlive.tvkplayer.hook.ITVKQQLiveAssetPlayerListenerHookCallback
    public void onVideoPrepared() {
        ITVKMediaPlayer iTVKMediaPlayer = this.mPlayerManagerWeakReference.get();
        if (iTVKMediaPlayer == null) {
            return;
        }
        pushPlayerEvent(ITVKPlayerEventListener.PlayerEvent.PLAYER_EVENT_VIDEO_PREPARED, new TVKEventParamsInner.Builder().flowId(this.mFlowId).currentPosMs(iTVKMediaPlayer.getCurrentPosition()).addExtraParam("videoDuration", Long.valueOf(iTVKMediaPlayer.getDuration())).build());
    }

    @Override // com.tencent.qqlive.tvkplayer.hook.ITVKQQLiveAssetPlayerHookCallback
    public void openMediaPlayer(Context context, TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo) {
        ITVKMediaPlayer iTVKMediaPlayer = this.mPlayerManagerWeakReference.get();
        if (iTVKMediaPlayer == null) {
            return;
        }
        pushPlayerEvent(ITVKPlayerEventListener.PlayerEvent.PLAYER_EVENT_OPEN_MEDIA, new TVKEventParamsInner.Builder().flowId(this.mFlowId).currentPosMs(iTVKMediaPlayer.getCurrentPosition()).addExtraParam(ITVKPlayerEventListener.KEY_TVKPLAYERVIDEOINFO, tVKPlayerVideoInfo).addExtraParam("definition", tVKPlayerVideoInfo.getDefinition()).addExtraParam(ITVKPlayerEventListener.KEY_USER_INFO, tVKUserInfo).addExtraParam(ITVKPlayerEventListener.KEY_START_POSITION_MILSEC, Long.valueOf(this.mStartPositionMs)).addExtraParam(ITVKPlayerEventListener.KEY_SKIP_END_MILSEC, Long.valueOf(tVKPlayerVideoInfo.getSkipEndPositionMs())).addExtraParam("url", "").build());
    }

    @Override // com.tencent.qqlive.tvkplayer.hook.ITVKQQLiveAssetPlayerHookCallback
    public void openMediaPlayerByUrl(Context context, String str, String str2, long j3, long j16, TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo) {
        ITVKMediaPlayer iTVKMediaPlayer = this.mPlayerManagerWeakReference.get();
        if (iTVKMediaPlayer == null) {
            return;
        }
        pushPlayerEvent(ITVKPlayerEventListener.PlayerEvent.PLAYER_EVENT_OPEN_MEDIA, new TVKEventParamsInner.Builder().flowId(this.mFlowId).currentPosMs(iTVKMediaPlayer.getCurrentPosition()).addExtraParam(ITVKPlayerEventListener.KEY_TVKPLAYERVIDEOINFO, tVKPlayerVideoInfo).addExtraParam("definition", "").addExtraParam(ITVKPlayerEventListener.KEY_USER_INFO, tVKUserInfo).addExtraParam(ITVKPlayerEventListener.KEY_START_POSITION_MILSEC, Long.valueOf(this.mStartPositionMs)).addExtraParam(ITVKPlayerEventListener.KEY_SKIP_END_MILSEC, Long.valueOf(j16)).addExtraParam("url", str).build());
    }

    @Override // com.tencent.qqlive.tvkplayer.hook.ITVKQQLiveAssetPlayerHookCallback
    public void pause() {
        ITVKMediaPlayer iTVKMediaPlayer = this.mPlayerManagerWeakReference.get();
        if (iTVKMediaPlayer == null) {
            return;
        }
        pushPlayerEvent(ITVKPlayerEventListener.PlayerEvent.PLAYER_EVENT_VIDEO_PAUSED, new TVKEventParamsInner.Builder().flowId(this.mFlowId).currentPosMs(iTVKMediaPlayer.getCurrentPosition()).build());
    }

    @Override // com.tencent.qqlive.tvkplayer.hook.ITVKQQLiveAssetPlayerHookCallback
    public void prepare() {
        pushPlayerEvent(ITVKPlayerEventListener.PlayerEvent.PLAYER_EVENT_VIDEO_PREPARING, new TVKEventParamsInner.Builder().flowId(this.mFlowId).currentPosMs(this.mStartPositionMs).build());
    }

    @Override // com.tencent.qqlive.tvkplayer.hook.ITVKQQLiveAssetPlayerHookCallback
    public void setFlowId(String str) {
        this.mFlowId = str;
    }

    @Override // com.tencent.qqlive.tvkplayer.hook.ITVKQQLiveAssetPlayerHookCallback
    public void start() {
        ITVKMediaPlayer iTVKMediaPlayer = this.mPlayerManagerWeakReference.get();
        if (iTVKMediaPlayer == null) {
            return;
        }
        pushPlayerEvent(ITVKPlayerEventListener.PlayerEvent.PLAYER_EVENT_VIDEO_PLAYING, new TVKEventParamsInner.Builder().flowId(this.mFlowId).currentPosMs(iTVKMediaPlayer.getCurrentPosition()).build());
    }

    @Override // com.tencent.qqlive.tvkplayer.hook.ITVKQQLiveAssetPlayerHookCallback
    public void stop() {
        ITVKMediaPlayer iTVKMediaPlayer = this.mPlayerManagerWeakReference.get();
        if (iTVKMediaPlayer == null) {
            return;
        }
        pushPlayerEvent(ITVKPlayerEventListener.PlayerEvent.PLAYER_EVENT_VIDEO_STOPED, new TVKEventParamsInner.Builder().flowId(this.mFlowId).currentPosMs(iTVKMediaPlayer.getCurrentPosition()).build());
    }

    @Override // com.tencent.qqlive.tvkplayer.hook.ITVKQQLiveAssetPlayerHookCallback
    public void updateReportParam(TVKProperties tVKProperties) {
        ITVKMediaPlayer iTVKMediaPlayer = this.mPlayerManagerWeakReference.get();
        if (iTVKMediaPlayer == null) {
            return;
        }
        pushPlayerEvent(ITVKPlayerEventListener.PlayerEvent.PLAYER_EVENT_UPDATE_REPORT_PARAM, new TVKEventParamsInner.Builder().flowId(this.mFlowId).currentPosMs(iTVKMediaPlayer.getCurrentPosition()).addExtraParam(ITVKPlayerEventListener.KEY_TVKPROPERTIES, tVKProperties).build());
    }

    public void updateStartPosition(long j3) {
        this.mStartPositionMs = j3;
    }

    @Override // com.tencent.qqlive.tvkplayer.hook.ITVKQQLiveAssetPlayerHookCallback
    public void startAd() {
    }

    @Override // com.tencent.qqlive.tvkplayer.hook.ITVKQQLiveAssetPlayerListenerHookCallback
    public void onDebugTrackingInfo(TPDebugTrackingInfo tPDebugTrackingInfo) {
    }

    @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListenerHookCallback
    public void onPlayerOpenAd(ITVKAdCommons.AdExtraInfo adExtraInfo) {
    }

    @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListenerHookCallback
    public void onAdCallPlayerOpen(int i3, ITVKAdCommons.AdExtraInfo adExtraInfo) {
    }

    @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListenerHookCallback
    public void onAdDebugTrackingInfo(int i3, Object obj) {
    }

    @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListenerHookCallback
    public void onAdLoadFinish(int i3, ITVKAdCommons.AdExtraInfo adExtraInfo) {
    }

    @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListenerHookCallback
    public void onAdOpen(int i3, ITVKAdCommons.AdExtraInfo adExtraInfo) {
    }

    @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListenerHookCallback
    public void onAdSendCgiRequest(int i3, ITVKAdCommons.AdExtraInfo adExtraInfo) {
    }

    @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListenerHookCallback
    public void onAdCgiError(int i3, int i16, int i17, ITVKAdCommons.AdErrorInfo adErrorInfo) {
    }

    @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListenerHookCallback
    public void onAdReceived(int i3, long j3, HashMap<Integer, Object> hashMap, ITVKAdCommons.AdExtraInfo adExtraInfo) {
    }

    @Override // com.tencent.qqlive.tvkplayer.hook.ITVKQQLiveAssetPlayerHookCallback
    public void openMediaPlayerByAfd(Context context, AssetFileDescriptor assetFileDescriptor, long j3, long j16) {
    }

    @Override // com.tencent.qqlive.tvkplayer.hook.ITVKQQLiveAssetPlayerHookCallback
    public void openMediaPlayerByPfd(Context context, ParcelFileDescriptor parcelFileDescriptor, long j3, long j16) {
    }
}
