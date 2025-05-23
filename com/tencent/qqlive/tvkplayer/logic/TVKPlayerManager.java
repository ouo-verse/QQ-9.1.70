package com.tencent.qqlive.tvkplayer.logic;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.ad.api.ITVKAdCommons;
import com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListener;
import com.tencent.qqlive.tvkplayer.ad.api.ITVKAdManager;
import com.tencent.qqlive.tvkplayer.ad.api.TVKAdFactory;
import com.tencent.qqlive.tvkplayer.ad.api.TVKAdManagerEmpty;
import com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.qqlive.tvkplayer.api.ITVKReportEventListener;
import com.tencent.qqlive.tvkplayer.api.TVKAudioFrameBuffer;
import com.tencent.qqlive.tvkplayer.api.TVKDownloadProgressInfo;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKProperties;
import com.tencent.qqlive.tvkplayer.api.TVKTrackInfo;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.api.TVKVideoFrameBuffer;
import com.tencent.qqlive.tvkplayer.api.asset.TVKOnlineVodXmlAsset;
import com.tencent.qqlive.tvkplayer.api.postprocess.ITVKAudioFxProcessor;
import com.tencent.qqlive.tvkplayer.api.postprocess.ITVKPostProcessor;
import com.tencent.qqlive.tvkplayer.api.postprocess.ITVKVideoFxProcessor;
import com.tencent.qqlive.tvkplayer.api.render.ITVKDrawableContainer;
import com.tencent.qqlive.tvkplayer.api.render.ITVKVideoViewBase;
import com.tencent.qqlive.tvkplayer.api.richmedia.sync.ITVKRichMediaSynchronizer;
import com.tencent.qqlive.tvkplayer.api.subtitle.ITVKSubtitleRendererController;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.context.TVKDebugTrackingEventReporter;
import com.tencent.qqlive.tvkplayer.event.ITVKEventObserver;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import com.tencent.qqlive.tvkplayer.event.TVKEventParams;
import com.tencent.qqlive.tvkplayer.hook.TVKHookManager;
import com.tencent.qqlive.tvkplayer.hook.TVKPlayerHookCallback;
import com.tencent.qqlive.tvkplayer.hook.TVKReportHookCallback;
import com.tencent.qqlive.tvkplayer.logic.ITVKMediaPlayerPrivate;
import com.tencent.qqlive.tvkplayer.logic.TVKThreadAnnotations;
import com.tencent.qqlive.tvkplayer.logo.api.TVKLogoPluginFactory;
import com.tencent.qqlive.tvkplayer.plugin.TVKPluginManager;
import com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer;
import com.tencent.qqlive.tvkplayer.qqliveasset.api.TVKAssetPlayerFactory;
import com.tencent.qqlive.tvkplayer.qqliveasset.common.TVKBasicPlayInfoCollector;
import com.tencent.qqlive.tvkplayer.qqliveasset.common.TVKTrackUtils;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKAssetPlayerMsgMap;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import com.tencent.qqlive.tvkplayer.qqliveasset.state.ITVKPlayerState;
import com.tencent.qqlive.tvkplayer.report.api.ITVKReportFactory;
import com.tencent.qqlive.tvkplayer.report.api.TVKReportFactoryCreator;
import com.tencent.qqlive.tvkplayer.security.api.TVKSecurityPluginFactory;
import com.tencent.qqlive.tvkplayer.tools.auth.TVKAppKeyManager;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKCommParams;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKVersion;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger;
import com.tencent.qqlive.tvkplayer.tools.log.TVKLogger;
import com.tencent.qqlive.tvkplayer.tools.log.TVKMainStepTag;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonErrorCodeUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKGlobalEventNotifier;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLooperHungDetector;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKThreadPool;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKThreadPrioritySetter;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer;
import com.tencent.thumbplayer.api.common.TPDebugTrackingInfo;
import com.tencent.thumbplayer.api.common.TPDownloadProgressInfo;
import com.tencent.thumbplayer.api.common.TPProgramInfo;
import com.tencent.thumbplayer.api.common.TPSubtitleData;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportMessageInfo;
import com.tencent.thumbplayer.core.datatransport.api.TPDataTransportMgr;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes23.dex */
public class TVKPlayerManager implements ITVKMediaPlayer, ITVKMediaPlayerPrivate, ITVKEventObserver {
    private static final String API_AD_CALL_BACK_LOG_PREFIX = "ad manager callback : ";
    private static final String API_CALL_BACK_LOG_PREFIX = "asset player callback : ";
    private static final String API_CALL_LOG_PREFIX = "api call : ";
    private static final String METHOD_SIGNATURE_ADD_TRACK = "addTrack(int, String, String): void";
    private static final String METHOD_SIGNATURE_DESELECT_TRACK = "deselectTrack(int): void";
    private static final String METHOD_SIGNATURE_ON_CLICK_PAUSE1 = "onClickPause(): void";
    private static final String METHOD_SIGNATURE_ON_CLICK_PAUSE2 = "onClickPause(ViewGroup): void";
    private static final String METHOD_SIGNATURE_ON_SKIP_AD_RESULT = "onSkipAdResult(boolean): void";
    private static final String METHOD_SIGNATURE_PAUSE = "pause(): void";
    private static final String METHOD_SIGNATURE_RELEASE = "release(): void";
    private static final String METHOD_SIGNATURE_SELECT_TRACK = "selectTrack(int): void";
    private static final String METHOD_SIGNATURE_SET_LOOPBACK = "setLoopback(boolean): void";
    private static final String METHOD_SIGNATURE_SET_LOOPBACK_WITH_POSITION = "setLoopback(boolean, long, long): void";
    private static final String METHOD_SIGNATURE_SET_OUTPUT_MUTE = "setOutputMute(boolean): boolean";
    private static final String METHOD_SIGNATURE_SKIP_AD = "skipAd(): void";
    private static final String METHOD_SIGNATURE_START = "start(): void";
    private static final String METHOD_SIGNATURE_STOP = "stop(): void";
    private static final String METHOD_SIGNATURE_UPDATE_VIDEO_VIEW = "updatePlayerVideoView(ITVKDrawableContainer): void";

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f345787d = 0;
    private static final AtomicInteger sNumberOfUnreleasedPlayers = new AtomicInteger(0);
    private boolean mAdIsDownloadDone;
    private ITVKAdListener mAdListener;

    @NonNull
    private ITVKAdManager mAdManager;
    private ITVKQQLiveAssetPlayer mAssetPlayer;
    private ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener mAssetPlayerListener;
    private ITVKPlayerState mAssetPlayerState;
    private TVKBasicPlayInfoCollector mBasicInfoCollector;
    private volatile long mCurrentPositionMs;
    private volatile ITVKDrawableContainer mDrawableContainer;
    private final EventHandler mEventHandler;
    private String mFlowId;
    private TVKGlobalEventChangeListener mGlobalEventChangeListener;
    private final HandlerThread mHandlerThread;
    private boolean mHasPostPrepared;
    private boolean mHasPostPreparing;
    private volatile String mHlsTagInfo;
    private TVKPlayerHookCallback mHookCallback;
    private boolean mIsBuffering;
    private boolean mIsOnePlayerNeedRestore;
    private boolean mIsPauseBeforeMidAdPlay;
    private boolean mIsPauseBySdkInternalAD;
    private boolean mIsPermissionTimeOut;
    private TVKListenerManager mLisMgr;

    @NonNull
    private final ITVKLogger mLogger;
    private final Looper mLooper;
    private TVKNetVideoInfo mNetVideoInfo;
    private final AtomicLong mPlayTimeMs;
    private TVKPlayerManagerCallBack mPlayerManagerCallBack;
    private TVKPlayerVideoInfo mPlayerVideoInfo;
    private final TVKPluginManager mPluginManager;
    private long mSkipEndPositionMs;
    private int mStartPauseFinishCount;
    private long mStartPositionMs;
    private ITVKMediaPlayerPrivate.ITVKStateKeeperListener mStateKeeperListener;

    @NonNull
    private final TVKContext mTVKContext;
    private ScheduledFuture<?> mTimerTask;
    private TVKUserInfo mUserInfo;

    /* loaded from: classes23.dex */
    private class EventHandler extends Handler {
        public EventHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 10347) {
                TVKPlayerManager.this.mPlayerManagerCallBack.onInfo(TVKPlayerManager.this, 99, message.obj);
            }
        }
    }

    /* loaded from: classes23.dex */
    private class TVKAdInnerListener implements ITVKAdListener {
        TVKAdInnerListener() {
        }

        private void handleOnAdError(int i3, int i16, int i17, ITVKAdCommons.AdErrorInfo adErrorInfo) {
            if (i3 == 1) {
                TVKPlayerManager.this.handlePreAdError(i3, i16, i17, adErrorInfo);
                return;
            }
            if (i3 == 2) {
                if (i16 == 3 || i16 == 4) {
                    resumeVideoAfterMidAdFinished();
                }
                TVKPlayerManager.this.mPlayerManagerCallBack.onMidAdFinish(TVKPlayerManager.this);
                return;
            }
            if (i3 == 3) {
                if (TVKPlayerManager.this.mAssetPlayerState.state() != ITVKPlayerState.STATE.COMPLETE) {
                    TVKPlayerManager.this.mLogger.info("AdEvent : postAd complete , but asset player state is :" + TVKPlayerManager.this.mAssetPlayerState.state() + ", must be something wrong, do nothing here.", new Object[0]);
                    return;
                }
                TVKPlayerManager.this.mPlayerManagerCallBack.onPostAdFinish(TVKPlayerManager.this);
                boolean z16 = TVKPlayerManager.this.mIsPermissionTimeOut;
                TVKPlayerManager.this.exitPlaying();
                if (z16) {
                    TVKPlayerManager.this.notifyPermissionTimeOut();
                } else {
                    TVKPlayerManager.this.notifyOnCompletion();
                }
            }
        }

        private void onMidAdComplete() {
            resumeVideoAfterMidAdFinished();
            TVKPlayerManager.this.mPlayerManagerCallBack.onMidAdFinish(TVKPlayerManager.this);
        }

        private void onMidAdPrepared() {
            if (TVKMediaPlayerConfig.PlayerConfig.is_one_player_instance) {
                TVKPlayerManager.this.mLogger.info(TVKPlayerManager.API_AD_CALL_BACK_LOG_PREFIX + ITVKAdCommons.adTypeString(2) + ", AdEvent : mid ad onAdPrepared , one player instance do nothing ", new Object[0]);
            } else if (TVKPlayerManager.this.mAssetPlayer.isPaused()) {
                TVKPlayerManager.this.mLogger.info(TVKPlayerManager.API_AD_CALL_BACK_LOG_PREFIX + ITVKAdCommons.adTypeString(2) + ", AdEvent : mid ad counting down complete , player is paused , do nothing", new Object[0]);
                TVKPlayerManager.this.mIsPauseBeforeMidAdPlay = true;
            } else {
                TVKPlayerManager.this.mLogger.info(TVKPlayerManager.API_AD_CALL_BACK_LOG_PREFIX + ITVKAdCommons.adTypeString(2) + ", AdEvent : mid ad counting down complete", new Object[0]);
                TVKPlayerManager.this.mIsPauseBeforeMidAdPlay = false;
                TVKPlayerManager.this.mAssetPlayer.pause();
                TVKPlayerManager.this.pushEvent(TVKEventId.PLAYER_STATE_PAUSE, null);
            }
            TVKPlayerManager.this.pushEvent(TVKEventId.PLAYER_STATE_MIDAD_START, null);
            TVKPlayerManager.this.mPlayerManagerCallBack.onMidAdEndCountdown(TVKPlayerManager.this, 0L);
        }

        private void onPostAdComplete() {
            if (TVKPlayerManager.this.mAssetPlayerState.state() != ITVKPlayerState.STATE.COMPLETE) {
                TVKPlayerManager.this.mLogger.warn("AdEvent : postAd complete , but asset player state is :" + TVKPlayerManager.this.mAssetPlayerState.state() + ", must something wrong, do nothing here.", new Object[0]);
                return;
            }
            TVKPlayerManager.this.mPlayerManagerCallBack.onPostAdFinish(TVKPlayerManager.this);
            boolean z16 = TVKPlayerManager.this.mIsPermissionTimeOut;
            TVKPlayerManager.this.exitPlaying();
            if (z16) {
                TVKPlayerManager.this.notifyPermissionTimeOut();
            } else {
                TVKPlayerManager.this.notifyOnCompletion();
            }
        }

        private void onPostAdPrepared(long j3) {
            TVKPlayerManager.this.mLogger.info(TVKPlayerManager.API_AD_CALL_BACK_LOG_PREFIX + ITVKAdCommons.adTypeString(3) + ", AdEvent :  mIsPermissionTimeOut:" + TVKPlayerManager.this.mIsPermissionTimeOut + ", asset player state:" + TVKPlayerManager.this.mAssetPlayerState, new Object[0]);
            if (TVKPlayerManager.this.mAssetPlayerState.state() == ITVKPlayerState.STATE.COMPLETE || TVKPlayerManager.this.mIsPermissionTimeOut) {
                TVKPlayerManager.this.pushEvent(TVKEventId.PLAYER_STATE_POSTAD_LOADING_PREPARING, 0, 0, "", null);
                if (TVKPlayerManager.this.mLisMgr.hasOnPostrollAdPrepared()) {
                    TVKPlayerManager.this.mPlayerManagerCallBack.onPostrollAdPrepared(TVKPlayerManager.this, j3);
                } else {
                    TVKPlayerManager.this.mAdManager.startAd();
                }
                TVKPlayerManager.this.pushEvent(TVKEventId.PLAYER_STATE_POSTROLLAD_START, null);
            }
        }

        private void onPreAdComplete(long j3) {
            TVKEventParams.AdPlayFinishParam adPlayFinishParam = new TVKEventParams.AdPlayFinishParam();
            adPlayFinishParam.mAdType = 1;
            adPlayFinishParam.mPlayedTimeMs = j3;
            TVKPlayerManager.this.pushEvent(TVKEventId.PLAYER_STATE_AD_LOADING_PLAY_END, adPlayFinishParam);
            TVKPlayerManager.this.mPlayerManagerCallBack.onPreAdFinish(TVKPlayerManager.this);
            TVKPlayerManager.this.notifyVideoPreparedAfterPreAdFinish();
        }

        private void onPreAdPrepared(long j3) {
            TVKPlayerManager.this.pushEvent(10501, null);
            if (!TVKPlayerManager.this.mLisMgr.hasOnPreAdListener()) {
                TVKPlayerManager.this.mLogger.info(TVKPlayerManager.API_AD_CALL_BACK_LOG_PREFIX + ITVKAdCommons.adTypeString(1) + ", AdEvent : preAd prepared , no pre ad listener , start pre ad directly", new Object[0]);
                TVKPlayerManager.this.pushEvent(TVKEventId.PLAYER_STATE_AD_LOADING_PLAY_START, null);
                TVKPlayerManager.this.mAdManager.startAd();
                return;
            }
            TVKPlayerManager.this.mPlayerManagerCallBack.onPreAdPrepared(TVKPlayerManager.this, j3);
        }

        private void resumeVideoAfterMidAdFinished() {
            if (TVKMediaPlayerConfig.PlayerConfig.is_one_player_instance) {
                TVKPlayerManager.this.mAssetPlayer.prepare();
            } else {
                if (!TVKPlayerManager.this.mIsPauseBeforeMidAdPlay) {
                    TVKPlayerManager.this.mAssetPlayer.updatePlayerVideoView(TVKPlayerManager.this.mDrawableContainer);
                    TVKPlayerManager.this.mAssetPlayer.start();
                    TVKPlayerManager.this.pushEvent(TVKEventId.PLAYER_STATE_START_PLAY, new TVKEventParams.StartPlayParam());
                }
                TVKPlayerManager.this.mIsPauseBeforeMidAdPlay = false;
            }
            TVKPlayerManager.this.pushEvent(TVKEventId.PLAYER_STATE_MIDAD_STOP, null);
        }

        @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListener
        public void onAdCallPlayerOpen(int i3, ITVKAdCommons.AdExtraInfo adExtraInfo) {
            TVKPlayerManager.this.mLogger.info(TVKPlayerManager.API_AD_CALL_BACK_LOG_PREFIX + ITVKAdCommons.adTypeString(i3) + ", AdEvent: onAdCallPlayerOpen", new Object[0]);
        }

        @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListener
        public void onAdCgiError(int i3, int i16, int i17, ITVKAdCommons.AdErrorInfo adErrorInfo) {
            TVKPlayerManager.this.mLogger.info(TVKPlayerManager.API_AD_CALL_BACK_LOG_PREFIX + ITVKAdCommons.adTypeString(i3) + ", AdEvent : onAdError=" + i16 + ", asset player state: " + TVKPlayerManager.this.mAssetPlayerState, new Object[0]);
            handleOnAdError(i3, i16, i17, adErrorInfo);
        }

        @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListener
        public void onAdCountDown(int i3, long j3, long j16) {
            TVKPlayerManager.this.mLogger.info(TVKPlayerManager.API_AD_CALL_BACK_LOG_PREFIX + ITVKAdCommons.adTypeString(i3) + ", AdEvent : onAdCountDown", new Object[0]);
            TVKPlayerManager.this.mPlayerManagerCallBack.onMidAdCountdown(TVKPlayerManager.this, j3);
        }

        @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListener
        public void onAdCountDownComplete(int i3) {
            TVKPlayerManager.this.mLogger.info(TVKPlayerManager.API_AD_CALL_BACK_LOG_PREFIX + ITVKAdCommons.adTypeString(i3) + ", AdEvent : onAdCountDownComplete", new Object[0]);
            if (TVKMediaPlayerConfig.PlayerConfig.is_one_player_instance) {
                if (!TVKPlayerManager.this.mAssetPlayer.isPaused()) {
                    TVKPlayerManager.this.mIsPauseBeforeMidAdPlay = false;
                    TVKPlayerManager.this.mLogger.info(", AdEvent : mid ad received , player is playing", new Object[0]);
                } else {
                    TVKPlayerManager.this.mLogger.info(", AdEvent : mid ad received , player is paused", new Object[0]);
                    TVKPlayerManager.this.mIsPauseBeforeMidAdPlay = true;
                }
                TVKPlayerManager.this.mLogger.info("AdEvent : mid ad received, one player instance, call stop ", new Object[0]);
                TVKPlayerManager.this.mAssetPlayer.stop();
                TVKPlayerManager.this.mIsOnePlayerNeedRestore = true;
            }
            TVKPlayerManager.this.pushEvent(TVKEventId.PLAYER_STATE_MIDAD_END_COUNTDOWN, null);
        }

        @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListener
        public void onAdCountDownStart(int i3, long j3, long j16) {
            TVKPlayerManager.this.mLogger.info(TVKPlayerManager.API_AD_CALL_BACK_LOG_PREFIX + ITVKAdCommons.adTypeString(i3) + ", AdEvent : onAdCountDownStart", new Object[0]);
            TVKPlayerManager.this.pushEvent(TVKEventId.PLAYER_STATE_MIDAD_START_COUNTDOWN, null);
            TVKPlayerManager.this.mPlayerManagerCallBack.onMidAdStartCountdown(TVKPlayerManager.this, j3, j16);
        }

        @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListener
        public void onAdDetailInfo(int i3, Object obj) {
            TVKPlayerManager.this.mLogger.info(TVKPlayerManager.API_AD_CALL_BACK_LOG_PREFIX + ITVKAdCommons.adTypeString(i3) + ", AdEvent : onAdPlayInfo ,onDetailInfo", new Object[0]);
        }

        @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListener
        public void onAdDownloaded(int i3) {
            TVKPlayerManager.this.mLogger.info(TVKPlayerManager.API_AD_CALL_BACK_LOG_PREFIX + ITVKAdCommons.adTypeString(i3) + ", AdEvent : onAdDownloaded, asset player state: " + TVKPlayerManager.this.mAssetPlayerState, new Object[0]);
            if (i3 == 1) {
                TVKPlayerManager.this.mLogger.info(", AdEvent : preAd download done , asset player state : " + TVKPlayerManager.this.mAssetPlayerState, new Object[0]);
                TVKPlayerManager.this.mAdIsDownloadDone = true;
                if (TVKPlayerManager.this.mAssetPlayerState.state() == ITVKPlayerState.STATE.CGIED) {
                    TVKPlayerManager.this.prepareAssetPlayerWhenPreAdDownloaded();
                }
            }
        }

        @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListener
        public void onAdLoadFinish(int i3, ITVKAdCommons.AdExtraInfo adExtraInfo) {
            TVKPlayerManager.this.mLogger.info(TVKPlayerManager.API_AD_CALL_BACK_LOG_PREFIX + ITVKAdCommons.adTypeString(i3) + ", AdEvent: onAdLoadFinish", new Object[0]);
        }

        @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListener
        public void onAdOpen(int i3, ITVKAdCommons.AdExtraInfo adExtraInfo) {
            TVKPlayerManager.this.mLogger.info(TVKPlayerManager.API_AD_CALL_BACK_LOG_PREFIX + ITVKAdCommons.adTypeString(i3) + ", AdEvent: onAdOpen", new Object[0]);
        }

        @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListener
        public void onAdPause(int i3, long j3) {
            TVKPlayerManager.this.mLogger.info(TVKPlayerManager.API_AD_CALL_BACK_LOG_PREFIX + ITVKAdCommons.adTypeString(i3) + ", AdEvent : onAdPause, playTimeMs:" + j3 + ", asset player state: " + TVKPlayerManager.this.mAssetPlayerState, new Object[0]);
        }

        @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListener
        public void onAdPlayComplete(int i3, long j3) {
            Boolean bool;
            TVKPlayerManager.this.mLogger.info(TVKPlayerManager.API_AD_CALL_BACK_LOG_PREFIX + ITVKAdCommons.adTypeString(i3) + ", AdEvent : onAdComplete, asset player state: " + TVKPlayerManager.this.mAssetPlayerState, new Object[0]);
            if (TVKPlayerManager.this.mStateKeeperListener != null) {
                if (i3 == 2) {
                    bool = Boolean.valueOf(TVKPlayerManager.this.mIsPauseBeforeMidAdPlay);
                } else {
                    bool = null;
                }
                TVKPlayerManager.this.mStateKeeperListener.onAdPlayComplete(i3, bool);
            }
            if (i3 == 1) {
                onPreAdComplete(j3);
            } else if (i3 == 2) {
                onMidAdComplete();
            } else if (i3 == 3) {
                onPostAdComplete();
            }
        }

        @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListener
        public void onAdPlayError(int i3, int i16, int i17, ITVKAdCommons.AdErrorInfo adErrorInfo) {
            Boolean bool;
            TVKPlayerManager.this.mLogger.info(TVKPlayerManager.API_AD_CALL_BACK_LOG_PREFIX + ITVKAdCommons.adTypeString(i3) + ", AdEvent : onAdPlayError=" + i16 + ", asset player state: " + TVKPlayerManager.this.mAssetPlayerState, new Object[0]);
            if (TVKPlayerManager.this.mStateKeeperListener != null) {
                if (i3 == 2) {
                    bool = Boolean.valueOf(TVKPlayerManager.this.mIsPauseBeforeMidAdPlay);
                } else {
                    bool = null;
                }
                TVKPlayerManager.this.mStateKeeperListener.onAdPlayError(i3, bool);
            }
            handleOnAdError(i3, i16, i17, adErrorInfo);
        }

        @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListener
        public void onAdPlaying(int i3, long j3) {
            TVKPlayerManager.this.mLogger.info(TVKPlayerManager.API_AD_CALL_BACK_LOG_PREFIX + ITVKAdCommons.adTypeString(i3) + ", AdEvent : onAdPlaying, playTimeMs:" + j3 + ", asset player state: " + TVKPlayerManager.this.mAssetPlayerState, new Object[0]);
        }

        @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListener
        public void onAdPrepared(int i3, long j3, ITVKAdCommons.AdExtraInfo adExtraInfo) {
            TVKPlayerManager.this.mLogger.info(TVKPlayerManager.API_AD_CALL_BACK_LOG_PREFIX + ITVKAdCommons.adTypeString(i3) + ", AdEvent : onAdPrepared, duration: " + j3 + ", asset player state: " + TVKPlayerManager.this.mAssetPlayerState, new Object[0]);
            if (i3 == 1) {
                onPreAdPrepared(j3);
            } else if (i3 == 2) {
                onMidAdPrepared();
            } else if (i3 == 3) {
                onPostAdPrepared(j3);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListener
        public void onAdReceived(int i3, long j3, HashMap<Integer, Object> hashMap, ITVKAdCommons.AdExtraInfo adExtraInfo) {
            TVKPlayerManager.this.mLogger.info(TVKPlayerManager.API_AD_CALL_BACK_LOG_PREFIX + ITVKAdCommons.adTypeString(i3) + ", AdEvent : onAdReceived, asset player state: " + TVKPlayerManager.this.mAssetPlayerState, new Object[0]);
            ArrayList<TVKEventParams.AdCgiResponseInfo> arrayList = new ArrayList<>();
            Iterator<Map.Entry<Integer, Object>> it = hashMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                int intValue = ((Integer) entry.getKey()).intValue();
                if (entry instanceof HashMap) {
                    HashMap hashMap2 = (HashMap) entry;
                    TVKEventParams.AdCgiResponseInfo adCgiResponseInfo = new TVKEventParams.AdCgiResponseInfo();
                    if (hashMap2.get("vid") != null) {
                        adCgiResponseInfo.mVid = (String) hashMap2.get("vid");
                    }
                    adCgiResponseInfo.mDuration = TVKUtils.optInt((String) hashMap2.get("duration"), 0);
                    adCgiResponseInfo.mFormat = (String) hashMap2.get("format");
                    adCgiResponseInfo.mIndex = intValue;
                    arrayList.add(adCgiResponseInfo);
                }
            }
            TVKEventParams.AdCgiResponseParam adCgiResponseParam = new TVKEventParams.AdCgiResponseParam();
            adCgiResponseParam.adCgiResponseInfos = arrayList;
            adCgiResponseParam.mAdDurationMs = j3;
            adCgiResponseParam.mAdType = i3;
            TVKPlayerManager.this.pushEvent(10302, adCgiResponseParam);
            TVKPlayerManager.this.pushEvent(10500, null);
            if (i3 == 1) {
                TVKPlayerManager.this.mPlayerManagerCallBack.onInfo(TVKPlayerManager.this, 49, hashMap);
            }
        }

        @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListener
        public void onAdRequest(int i3, String str, ITVKAdCommons.AdExtraInfo adExtraInfo) {
            TVKPlayerManager.this.mLogger.info(TVKPlayerManager.API_AD_CALL_BACK_LOG_PREFIX + ITVKAdCommons.adTypeString(i3) + ", AdEvent : requesting, asset player state: " + TVKPlayerManager.this.mAssetPlayerState, new Object[0]);
            if (i3 == 1) {
                TVKPlayerManager.this.pushEvent(10300, str);
                TVKPlayerManager.this.mPlayerManagerCallBack.onPreAdPreparing(TVKPlayerManager.this);
            }
        }

        @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListener
        public void onAdRequestPauseVideo(int i3) {
            TVKPlayerManager.this.mLogger.info("AdEvent : onPauseAdApplied ... , manager state : " + TVKPlayerManager.this.mAssetPlayerState.state(), new Object[0]);
            if (TVKPlayerManager.this.mAssetPlayerState.state() == ITVKPlayerState.STATE.STARTED) {
                try {
                    TVKPlayerManager.this.pause();
                    if (TVKPlayerManager.this.mStateKeeperListener != null) {
                        TVKPlayerManager.this.mStateKeeperListener.onAdRequestPauseVideo();
                    }
                } catch (Exception e16) {
                    TVKPlayerManager.this.mLogger.info("AdEvent : onPauseAdApplied" + e16.toString(), new Object[0]);
                }
            }
        }

        @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListener
        public void onAdRequestResumeVideo(int i3) {
            TVKPlayerManager.this.mLogger.info("AdEvent : onResumeAdApplied ... , manager state : " + TVKPlayerManager.this.mAssetPlayerState.state(), new Object[0]);
            if (TVKPlayerManager.this.mAssetPlayerState.state() == ITVKPlayerState.STATE.PAUSED) {
                try {
                    TVKPlayerManager.this.start();
                    if (TVKPlayerManager.this.mStateKeeperListener != null) {
                        TVKPlayerManager.this.mStateKeeperListener.onAdRequestResumeVideo();
                    }
                } catch (Exception e16) {
                    TVKPlayerManager.this.mLogger.info("AdEvent : onResumeAdApplied" + e16.toString(), new Object[0]);
                }
            }
        }

        @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListener
        public void onAdSendCgiRequest(int i3, ITVKAdCommons.AdExtraInfo adExtraInfo) {
            TVKPlayerManager.this.mLogger.info(TVKPlayerManager.API_AD_CALL_BACK_LOG_PREFIX + ITVKAdCommons.adTypeString(i3) + ", AdEvent: onAdSendCgiRequest", new Object[0]);
        }

        @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListener
        public void onClickSkip(int i3, int i16, boolean z16, boolean z17, int i17) {
            TVKPlayerManager.this.mLogger.info(TVKPlayerManager.API_AD_CALL_BACK_LOG_PREFIX + ITVKAdCommons.adTypeString(i3) + ", AdEvent : preAd click skip , direct : " + z16 + " warner : " + z17 + ", asset player state: " + TVKPlayerManager.this.mAssetPlayerState, new Object[0]);
            if (z16) {
                if (i3 == 1) {
                    TVKPlayerManager.this.mPlayerManagerCallBack.onPreAdFinish(TVKPlayerManager.this);
                    TVKPlayerManager.this.notifyVideoPreparedAfterPreAdFinish();
                    return;
                }
                if (i3 == 2) {
                    resumeVideoAfterMidAdFinished();
                    TVKPlayerManager.this.mPlayerManagerCallBack.onMidAdFinish(TVKPlayerManager.this);
                    return;
                } else {
                    if (i3 == 3) {
                        TVKPlayerManager.this.mPlayerManagerCallBack.onPostAdFinish(TVKPlayerManager.this);
                        boolean z18 = TVKPlayerManager.this.mIsPermissionTimeOut;
                        TVKPlayerManager.this.exitPlaying();
                        if (z18) {
                            TVKPlayerManager.this.notifyPermissionTimeOut();
                            return;
                        } else {
                            TVKPlayerManager.this.notifyOnCompletion();
                            return;
                        }
                    }
                    return;
                }
            }
            TVKPlayerManager.this.mPlayerManagerCallBack.onAdSkipClick(TVKPlayerManager.this, z17, i17);
        }

        @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListener
        public Object onCustomCommand(String str, Object obj) {
            TVKPlayerManager.this.mLogger.info("ad manager callback : AdEvent : onCustomCommand, asset player state: " + TVKPlayerManager.this.mAssetPlayerState, new Object[0]);
            return TVKPlayerManager.this.mPlayerManagerCallBack.onAdCustomCommand(TVKPlayerManager.this, str, obj);
        }

        @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListener
        public void onExitFullScreenClick(int i3) {
            TVKPlayerManager.this.mLogger.info(TVKPlayerManager.API_AD_CALL_BACK_LOG_PREFIX + ITVKAdCommons.adTypeString(i3) + ", AdEvent : onExitFullScreenClick, asset player state: " + TVKPlayerManager.this.mAssetPlayerState, new Object[0]);
            TVKPlayerManager.this.mPlayerManagerCallBack.onAdExitFullScreenClick(TVKPlayerManager.this);
        }

        @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListener
        public void onFinishScrollAd(int i3) {
            TVKPlayerManager.this.mLogger.info(TVKPlayerManager.API_AD_CALL_BACK_LOG_PREFIX + ITVKAdCommons.adTypeString(i3) + ", AdEvent : onFinishScrollAd, asset player state: " + TVKPlayerManager.this.mAssetPlayerState, new Object[0]);
            TVKPlayerManager.this.mPlayerManagerCallBack.onFinishAd(TVKPlayerManager.this, i3);
        }

        @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListener
        public void onFullScreenClick(int i3) {
            TVKPlayerManager.this.mLogger.info(TVKPlayerManager.API_AD_CALL_BACK_LOG_PREFIX + ITVKAdCommons.adTypeString(i3) + ", AdEvent : onFullScreenClick, asset player state: " + TVKPlayerManager.this.mAssetPlayerState, new Object[0]);
            TVKPlayerManager.this.mPlayerManagerCallBack.onAdFullScreenClick(TVKPlayerManager.this);
        }

        @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListener
        public void onLandingViewClosed(int i3) {
            TVKPlayerManager.this.mLogger.info(TVKPlayerManager.API_AD_CALL_BACK_LOG_PREFIX + ITVKAdCommons.adTypeString(i3) + ", AdEvent : onLandingViewClosed, asset player state: " + TVKPlayerManager.this.mAssetPlayerState, new Object[0]);
            if (ITVKAdCommons.isVideoAd(i3)) {
                TVKPlayerManager.this.mLogger.info(TVKPlayerManager.API_AD_CALL_BACK_LOG_PREFIX + ITVKAdCommons.adTypeString(i3) + ", AdEvent : onLandingViewClosed. video ad is active", new Object[0]);
                TVKPlayerManager.this.mPlayerManagerCallBack.onLandingViewClosed(TVKPlayerManager.this);
                return;
            }
            if (TVKPlayerManager.this.mAssetPlayerState.is(ITVKPlayerState.STATE.PREPARED, ITVKPlayerState.STATE.STARTED, ITVKPlayerState.STATE.PAUSED) && TVKPlayerManager.this.mIsPauseBySdkInternalAD) {
                TVKPlayerManager.this.mIsPauseBySdkInternalAD = false;
                TVKPlayerManager.this.mAssetPlayer.start();
                TVKPlayerManager.this.pushEvent(TVKEventId.PLAYER_STATE_START_PLAY, new TVKEventParams.StartPlayParam());
            }
        }

        @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListener
        public void onLandingViewWillPresent(int i3) {
            TVKPlayerManager.this.mLogger.info(TVKPlayerManager.API_AD_CALL_BACK_LOG_PREFIX + ITVKAdCommons.adTypeString(i3) + ", AdEvent : onLandingViewWillPresent, asset player state: " + TVKPlayerManager.this.mAssetPlayerState, new Object[0]);
            if (ITVKAdCommons.isVideoAd(i3)) {
                TVKPlayerManager.this.mLogger.info(TVKPlayerManager.API_AD_CALL_BACK_LOG_PREFIX + ITVKAdCommons.adTypeString(i3) + ", AdEvent : onLandingViewWillPresent. video ad is active", new Object[0]);
                TVKPlayerManager.this.mPlayerManagerCallBack.onLandingViewWillPresent(TVKPlayerManager.this);
                return;
            }
            ITVKPlayerState iTVKPlayerState = TVKPlayerManager.this.mAssetPlayerState;
            ITVKPlayerState.STATE state = ITVKPlayerState.STATE.STARTED;
            if (iTVKPlayerState.is(state, ITVKPlayerState.STATE.PAUSED) && TVKPlayerManager.this.mAssetPlayerState.state() == state) {
                TVKPlayerManager.this.mIsPauseBySdkInternalAD = true;
                TVKPlayerManager.this.mAssetPlayer.pause();
                TVKPlayerManager.this.pushEvent(TVKEventId.PLAYER_STATE_PAUSE, null);
            }
        }

        @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListener
        public void onPlayerOpenAd(ITVKAdCommons.AdExtraInfo adExtraInfo) {
            TVKPlayerManager.this.mLogger.info("ad manager callback : AdEvent: onPlayerOpenAd", new Object[0]);
        }

        @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListener
        public void onReturnClick(int i3, int i16) {
            TVKPlayerManager.this.mLogger.info(TVKPlayerManager.API_AD_CALL_BACK_LOG_PREFIX + ITVKAdCommons.adTypeString(i3) + ", AdEvent : onReturnClick, asset player state: " + TVKPlayerManager.this.mAssetPlayerState, new Object[0]);
            TVKPlayerManager.this.mPlayerManagerCallBack.onAdReturnClick(TVKPlayerManager.this);
        }

        @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListener
        public void onSwitchScrollAd(final int i3, int i16, final Object obj, final Object obj2) {
            TVKPlayerManager.this.mLogger.info(TVKPlayerManager.API_AD_CALL_BACK_LOG_PREFIX + ITVKAdCommons.adTypeString(i3) + ", AdEvent : onSwitchScrollAd, asset player state: " + TVKPlayerManager.this.mAssetPlayerState, new Object[0]);
            TVKPlayerManager.this.pushEvent(TVKEventId.PLAYER_STATE_CLIP_START, obj);
            TVKThreadPool.getInstance().postRunnableOnMainThread(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKPlayerManager.TVKAdInnerListener.1
                @Override // java.lang.Runnable
                public void run() {
                    TVKPlayerManager.this.mPlayerManagerCallBack.onSwitchAd(TVKPlayerManager.this, i3, obj, obj2);
                }
            });
        }

        @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListener
        public void onVolumeChange(float f16) {
            TVKPlayerManager.this.mLogger.info("AdEvent : onVolumeChange ... , manager state : " + TVKPlayerManager.this.mAssetPlayerState.state(), new Object[0]);
            TVKPlayerManager.this.mPlayerManagerCallBack.onVolumeChange(TVKPlayerManager.this, f16);
        }

        @Override // com.tencent.qqlive.tvkplayer.ad.api.ITVKAdListener
        public void onWarnerTipClick(int i3) {
            TVKPlayerManager.this.mLogger.info(TVKPlayerManager.API_AD_CALL_BACK_LOG_PREFIX + ITVKAdCommons.adTypeString(i3) + ", AdEvent : onWarnerTipClick, asset player state: " + TVKPlayerManager.this.mAssetPlayerState, new Object[0]);
            TVKPlayerManager.this.mPlayerManagerCallBack.onAdWarnerTipClick(TVKPlayerManager.this);
        }
    }

    /* loaded from: classes23.dex */
    private class TVKGlobalEventChangeListener implements TVKGlobalEventNotifier.OnGlobalEventChangeListener {
        TVKGlobalEventChangeListener() {
        }

        @Override // com.tencent.qqlive.tvkplayer.tools.utils.TVKGlobalEventNotifier.OnGlobalEventChangeListener
        public void onEvent(int i3, int i16, int i17, Object obj) {
            TVKPlayerManager.this.mLogger.info("GlobalEvent change eventId: " + i3 + ", arg1: " + i16 + ", arg2: " + i17 + ", object:" + obj, new Object[0]);
            switch (i3) {
                case 100001:
                    TVKPlayerManager.this.mLogger.info("App is OnBackground", new Object[0]);
                    TVKPlayerManager.this.pushEvent(TVKEventId.PLAYER_STATE_ENTER_BACKGROUND, 0);
                    return;
                case 100002:
                    TVKPlayerManager.this.mLogger.info("App is OnForeground", new Object[0]);
                    TVKPlayerManager.this.pushEvent(TVKEventId.PLAYER_STATE_ENTER_FOREGROUND, 0);
                    return;
                default:
                    return;
            }
        }
    }

    public TVKPlayerManager(Context context, ITVKDrawableContainer iTVKDrawableContainer) {
        this(context, iTVKDrawableContainer, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnErrorCB(TVKError tVKError) {
        this.mLogger.error("callOnErrorCB = " + tVKError.toString(), new Object[0]);
        TVKEventParams.AdPlayFinishParam adPlayFinishParam = new TVKEventParams.AdPlayFinishParam();
        adPlayFinishParam.mPlayedTimeMs = this.mAdManager.getCurrentPosition();
        adPlayFinishParam.mAdType = this.mAdManager.getAdType();
        pushEvent(TVKEventId.PLAYER_STATE_PLAYER_ERROR, new TVKEventParams.PlayErrorParam(tVKError, adPlayFinishParam));
        this.mBasicInfoCollector.setError(tVKError);
        exitPlaying();
        this.mPlayerManagerCallBack.onError(this, tVKError);
    }

    private void changeAdManagerWhenOpenMediaPlayer(TVKPlayerVideoInfo tVKPlayerVideoInfo) {
        ITVKVideoViewBase iTVKVideoViewBase;
        if (tVKPlayerVideoInfo == null) {
            return;
        }
        if (TVKMediaPlayerConfig.PlayerConfig.is_ad_on && !"true".equalsIgnoreCase(tVKPlayerVideoInfo.getConfigMapValue("ad_close", "false"))) {
            ITVKAdManager iTVKAdManager = this.mAdManager;
            if (iTVKAdManager instanceof TVKAdManagerEmpty) {
                this.mPluginManager.unloadPlugin(iTVKAdManager);
                this.mAdManager.reset();
                this.mAdManager.release();
                TVKContext tVKContext = this.mTVKContext;
                if (isVideoView(this.mDrawableContainer)) {
                    iTVKVideoViewBase = (ITVKVideoViewBase) this.mDrawableContainer;
                } else {
                    iTVKVideoViewBase = null;
                }
                ITVKAdManager createAdManager = TVKAdFactory.createAdManager(tVKContext, iTVKVideoViewBase, this.mAdListener, this.mLooper);
                this.mAdManager = createAdManager;
                this.mPluginManager.loadPlugin(createAdManager);
                return;
            }
            return;
        }
        ITVKAdManager iTVKAdManager2 = this.mAdManager;
        if (!(iTVKAdManager2 instanceof TVKAdManagerEmpty)) {
            this.mPluginManager.unloadPlugin(iTVKAdManager2);
            this.mAdManager.reset();
            this.mAdManager.release();
            ITVKAdManager createAdManagerEmpty = TVKAdFactory.createAdManagerEmpty(this.mTVKContext);
            this.mAdManager = createAdManagerEmpty;
            this.mPluginManager.loadPlugin(createAdManagerEmpty);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void exitPlaying() {
        this.mLogger.info(this.mBasicInfoCollector.toString(), new Object[0]);
        resetAll();
        TVKThreadPrioritySetter.reset();
    }

    private void exposeAbTestInfoWhenOpenMediaPlayer() {
        if (!TextUtils.isEmpty(TVKCommParams.getTabPolicyId()) && !TextUtils.isEmpty(TVKCommParams.getTabExpName())) {
            HashMap hashMap = new HashMap();
            hashMap.put(TVKCommParams.getTabExpName(), Integer.valueOf(TVKUtils.optInt(TVKCommParams.getTabPolicyId(), 0)));
            handleAbTestInfo(new TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams(212, 0L, 0L, hashMap));
        }
    }

    private void generateFlowId() {
        TVKPlayerVideoInfo tVKPlayerVideoInfo = this.mPlayerVideoInfo;
        if (tVKPlayerVideoInfo != null && tVKPlayerVideoInfo.getAsset() != null && this.mPlayerVideoInfo.getAsset().getAssetType() == 65536) {
            String flowId = ((TVKOnlineVodXmlAsset) this.mPlayerVideoInfo.getAsset()).getFlowId();
            if (TextUtils.isEmpty(flowId)) {
                flowId = TVKUtils.generateFlowId();
            }
            this.mFlowId = flowId;
        } else {
            this.mFlowId = TVKUtils.generateFlowId();
        }
        this.mPlayerManagerCallBack.onInfo(this, 50, this.mFlowId);
        this.mBasicInfoCollector.setFlowID(this.mFlowId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {212})
    public void handleAbTestInfo(TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams tVKAssetPlayerMsgParams) {
        this.mLogger.info("Handling AB test info: " + tVKAssetPlayerMsgParams.extra.toString(), new Object[0]);
        this.mPlayerManagerCallBack.onInfo(this, 84, tVKAssetPlayerMsgParams.extra);
        TVKEventParams.AbTestParam abTestParam = new TVKEventParams.AbTestParam();
        abTestParam.abTestInfo = (Map) tVKAssetPlayerMsgParams.extra;
        pushEvent(TVKEventId.PLAYER_STATE_AB_TEST_EXPOSED, abTestParam);
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {114})
    private void handleAudioDecoderMode(TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams tVKAssetPlayerMsgParams) {
        pushEvent(TVKEventId.PLAYER_STATE_AUDIO_DECODE_MODE, Integer.valueOf((int) tVKAssetPlayerMsgParams.arg1));
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {126})
    private void handleAudioTrackSwitchDone(TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams tVKAssetPlayerMsgParams) {
        String str = (String) tVKAssetPlayerMsgParams.extra;
        this.mLogger.info("PLAYER_BASE_SWITCH_AUDIOTRACK_DONE, audio track : " + str, new Object[0]);
        TVKEventParams.SwitchAudioTrackDoneParam switchAudioTrackDoneParam = new TVKEventParams.SwitchAudioTrackDoneParam();
        switchAudioTrackDoneParam.audioTrack = str;
        pushEvent(TVKEventId.PLAYER_STATE_SWITCH_AUDIO_TRACK_DONE, switchAudioTrackDoneParam);
        this.mPlayerManagerCallBack.onInfo(this, 60, str);
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {524})
    private void handleAudioTrackSwitchStart(TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams tVKAssetPlayerMsgParams) {
        pushEvent(TVKEventId.PLAYER_STATE_SWITCH_AUDIO_TRACK_USER_SWITCH_START, null);
        this.mPlayerManagerCallBack.onInfo(this, 59, (String) tVKAssetPlayerMsgParams.extra);
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {TVKQQLiveAssetPlayerMsg.PLAYER_INFO_CGI_REQUEST})
    private void handleCGIRequest() {
        pushEvent(10200, new TVKEventParams.GetVInfoRequestParam());
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {TVKQQLiveAssetPlayerMsg.PLAYER_INFO_CGI_RESPONSE})
    private void handleCGIResponse(TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams tVKAssetPlayerMsgParams) {
        Object obj = tVKAssetPlayerMsgParams.extra;
        if (obj instanceof TVKEventParams.GetVInfoResponseParam) {
            TVKEventParams.GetVInfoResponseParam getVInfoResponseParam = (TVKEventParams.GetVInfoResponseParam) obj;
            getVInfoResponseParam.playerVideoInfo = this.mPlayerVideoInfo;
            pushEvent(10201, getVInfoResponseParam);
        } else {
            this.mLogger.error("should not happen, param.extra=" + tVKAssetPlayerMsgParams.extra, new Object[0]);
        }
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {204})
    private void handleCdnInfoUpdate(TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams tVKAssetPlayerMsgParams) {
        TVKEventParams.SwitchCDNEventParam switchCDNEventParam = new TVKEventParams.SwitchCDNEventParam();
        Object obj = tVKAssetPlayerMsgParams.extra;
        if (obj instanceof TPDataTransportMessageInfo) {
            TPDataTransportMessageInfo tPDataTransportMessageInfo = (TPDataTransportMessageInfo) obj;
            switchCDNEventParam.url = (String) tPDataTransportMessageInfo.obj1;
            switchCDNEventParam.cdnIp = (String) tPDataTransportMessageInfo.obj2;
            switchCDNEventParam.cdnUIp = (String) tPDataTransportMessageInfo.obj3;
            switchCDNEventParam.errorStr = (String) tPDataTransportMessageInfo.obj4;
        }
        pushEvent(TVKEventId.PLAYER_STATE_PLAY_CDN_INFO_UPDATE, switchCDNEventParam);
    }

    @TVKAssetPlayerMsgMap.DealWithMsg
    private void handleCommonMsg(TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams tVKAssetPlayerMsgParams) {
        int convertToPlayerMsg = TVKAssetPlayerMsgMap.convertToPlayerMsg(tVKAssetPlayerMsgParams.what);
        if (convertToPlayerMsg != 20) {
            this.mPlayerManagerCallBack.onInfo(this, convertToPlayerMsg, tVKAssetPlayerMsgParams.extra);
        }
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {TVKQQLiveAssetPlayerMsg.PLAYER_INFO_DETECTED_MULTI_NETWORK_CARD_AND_LOW_SPEED})
    private void handleDetectedMultiNetworkCardAndLowSpeed(TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams tVKAssetPlayerMsgParams) {
        this.mLogger.info("download proxy notify detected multi-network card, and now in low speed", new Object[0]);
        this.mPlayerManagerCallBack.onInfo(this, 89, null);
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {207})
    private void handleDownloadProgressUpdate(TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams tVKAssetPlayerMsgParams) {
        TVKDownloadProgressInfo tVKDownloadProgressInfo = new TVKDownloadProgressInfo();
        Object obj = tVKAssetPlayerMsgParams.extra;
        if (obj instanceof TPDownloadProgressInfo) {
            TPDownloadProgressInfo tPDownloadProgressInfo = (TPDownloadProgressInfo) obj;
            tVKDownloadProgressInfo.setDownloadSpeedbps(tPDownloadProgressInfo.getDownloadSpeedbps());
            tVKDownloadProgressInfo.setDownloadBytes(tPDownloadProgressInfo.getDownloadBytes());
            tVKDownloadProgressInfo.setFileTotalBytes(tPDownloadProgressInfo.getFileTotalBytes());
            tVKDownloadProgressInfo.setAvailablePositionMs(tPDownloadProgressInfo.getAvailablePositionMs());
            tVKDownloadProgressInfo.setExtraInfo(tPDownloadProgressInfo.getExtraInfo());
        }
        pushEvent(TVKEventId.PLAYER_STATE_DOWNLOAD_PROGRESS_UPDATE, tVKDownloadProgressInfo);
        this.mPlayerManagerCallBack.onInfo(this, 97, tVKDownloadProgressInfo);
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {206})
    private void handleDownloadStatusUpdate(TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams tVKAssetPlayerMsgParams) {
        Object obj = tVKAssetPlayerMsgParams.extra;
        if (obj instanceof TPDataTransportMessageInfo) {
            pushEvent(TVKEventId.PLAYER_STATE_DOWNLOAD_STATUS_CHANGED, ((TPDataTransportMessageInfo) obj).obj1);
        }
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {103})
    private void handleFirstVideoDecoderStart() {
        pushEvent(TVKEventId.PLAYER_STATE_FIRST_VIDEO_DECODER_START, null);
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {105})
    private void handleFirstVideoRenderEnd() {
        pushEvent(TVKEventId.PLAYER_STATE_FIRST_VIDEO_FRAME_START, null);
        this.mPlayerManagerCallBack.onInfo(this, 62, null);
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {217})
    private void handleHdrInfoChanged(TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams tVKAssetPlayerMsgParams) {
        pushEvent(TVKEventId.PLAYER_STATE_HDR_INFO_CHANGED, (int) tVKAssetPlayerMsgParams.arg1, (int) tVKAssetPlayerMsgParams.arg2, "", null);
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {213})
    private void handleHighDropRateInfo(TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams tVKAssetPlayerMsgParams) {
        this.mPlayerManagerCallBack.onInfo(this, 92, Float.valueOf(((Float) tVKAssetPlayerMsgParams.extra).floatValue()));
        pushEvent(TVKEventId.PLAYER_STATE_VIDEO_HIGH_FRAME_DROP_RATE_ALERT, 0, 0, null, tVKAssetPlayerMsgParams.extra);
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {210})
    private void handleIsUseProxy(TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams tVKAssetPlayerMsgParams) {
        pushEvent(TVKEventId.PLAYER_STATE_IS_USE_PROXY, Integer.valueOf((int) tVKAssetPlayerMsgParams.arg1));
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {214})
    private void handleLowFrameRateInfo(TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams tVKAssetPlayerMsgParams) {
        this.mPlayerManagerCallBack.onInfo(this, 91, Float.valueOf(((Float) tVKAssetPlayerMsgParams.extra).floatValue()));
        pushEvent(TVKEventId.PLAYER_STATE_VIDEO_LOW_FRAME_RATE_ALERT, 0, 0, null, tVKAssetPlayerMsgParams.extra);
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {216})
    private void handleMediaLabVRLatencyInfo(TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams tVKAssetPlayerMsgParams) {
        pushEvent(TVKEventId.PLAYER_STATE_MEDIA_LAB_VR_LATENCY_INFO, (int) tVKAssetPlayerMsgParams.arg1, (int) tVKAssetPlayerMsgParams.arg2, null, null);
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {TVKQQLiveAssetPlayerMsg.PLAYER_INFO_MULTI_NETWORK_CARD_STATUS_CHANGE})
    private void handleMultiNetworkCardStateChange(TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams tVKAssetPlayerMsgParams) {
        this.mLogger.info("download proxy use multi-network card state: " + tVKAssetPlayerMsgParams.extra, new Object[0]);
        Object obj = tVKAssetPlayerMsgParams.extra;
        if (obj instanceof TPDataTransportMessageInfo) {
            this.mPlayerManagerCallBack.onInfo(this, 90, ((TPDataTransportMessageInfo) obj).obj1);
        }
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {512})
    private void handleOnAdaptiveSwitchDefDone() {
        pushEvent(TVKEventId.PLAYER_STATE_SWITCHDEF_DONE, null);
        this.mPlayerManagerCallBack.onInfo(this, 67, null);
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {511})
    private void handleOnAdaptiveSwitchDefStart(TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams tVKAssetPlayerMsgParams) {
        int i3 = (int) tVKAssetPlayerMsgParams.arg1;
        TVKEventParams.SwitchDefinitionParam switchDefinitionParam = new TVKEventParams.SwitchDefinitionParam();
        switchDefinitionParam.isAuto = true;
        switchDefinitionParam.switchDefinitionType = i3;
        pushEvent(TVKEventId.PLAYER_STATE_SWITCHDEF_START, switchDefinitionParam);
        this.mPlayerManagerCallBack.onInfo(this, 66, tVKAssetPlayerMsgParams.extra);
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {124})
    private void handleOnCreatePlayerEnd(TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams tVKAssetPlayerMsgParams) {
        TVKEventParams.CreatePlayerDoneParam createPlayerDoneParam = new TVKEventParams.CreatePlayerDoneParam();
        createPlayerDoneParam.mPlayerType = (int) tVKAssetPlayerMsgParams.arg1;
        createPlayerDoneParam.mErrorCode = "";
        createPlayerDoneParam.mReason = "";
        pushEvent(10101, createPlayerDoneParam);
        this.mPlayerManagerCallBack.onInfo(this, 31, Integer.valueOf((int) tVKAssetPlayerMsgParams.arg1));
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {113})
    private void handleOnEndBuffer() {
        this.mIsBuffering = false;
        pushEvent(TVKEventId.PLAYER_STATE_END_BUFFERING, null);
        this.mPlayerManagerCallBack.onInfo(this, 22, null);
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {534})
    private void handleOnReadyToAdaptiveSwitchDef() {
        pushEvent(TVKEventId.PLAYER_STATE_SWITCHDEF_LOADING_PREPARE, null);
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {523})
    private void handleOnReadyToSwitchDef() {
        pushEvent(TVKEventId.PLAYER_STATE_SWITCHDEF_LOADING_PREPARE, null);
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {112})
    private void handleOnStartBuffer(TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams tVKAssetPlayerMsgParams) {
        this.mIsBuffering = true;
        pushEvent(TVKEventId.PLAYER_STATE_START_BUFFERING, (int) tVKAssetPlayerMsgParams.arg1, (int) tVKAssetPlayerMsgParams.arg2, "", new TVKEventParams.StartBufferingParam());
        this.mPlayerManagerCallBack.onInfo(this, 21, null);
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {111})
    private void handleOnSwitchDefDone(TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams tVKAssetPlayerMsgParams) {
        pushEvent(TVKEventId.PLAYER_STATE_SWITCHDEF_DONE, null);
        if (tVKAssetPlayerMsgParams.arg2 != 0) {
            return;
        }
        this.mPlayerManagerCallBack.onInfo(this, 43, null);
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {522})
    private void handleOnSwitchDefStart(TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams tVKAssetPlayerMsgParams) {
        int i3 = (int) tVKAssetPlayerMsgParams.arg1;
        TVKEventParams.SwitchDefinitionParam switchDefinitionParam = new TVKEventParams.SwitchDefinitionParam();
        int i16 = 0;
        switchDefinitionParam.isAuto = false;
        switchDefinitionParam.switchDefinitionType = i3;
        pushEvent(TVKEventId.PLAYER_STATE_SWITCHDEF_START, switchDefinitionParam);
        if (tVKAssetPlayerMsgParams.arg2 != 0) {
            return;
        }
        if (i3 != 2) {
            i16 = 1;
        }
        this.mPlayerManagerCallBack.onInfo(this, 46, Integer.valueOf(i16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePreAdError(int i3, int i16, int i17, ITVKAdCommons.AdErrorInfo adErrorInfo) {
        if (i16 != 1 && i16 != 2) {
            if (i16 == 3 || i16 == 4) {
                TVKEventParams.AdPlayFinishParam adPlayFinishParam = new TVKEventParams.AdPlayFinishParam();
                adPlayFinishParam.mAdType = i3;
                adPlayFinishParam.mPlayedTimeMs = adErrorInfo.playTime;
                adPlayFinishParam.errorCode = String.valueOf(i17);
                pushEvent(TVKEventId.PLAYER_STATE_AD_LOADING_PLAY_END, adPlayFinishParam);
            }
        } else {
            this.mPlayerManagerCallBack.onInfo(this, 49, Integer.valueOf(i17));
            if (adErrorInfo.vipNoAd) {
                this.mLogger.info("start, notify ui skip ad for vip", new Object[0]);
                this.mPlayerManagerCallBack.onInfo(this, 25, 0);
            }
            TVKEventParams.AdCgiResponseParam adCgiResponseParam = new TVKEventParams.AdCgiResponseParam();
            adCgiResponseParam.mAdType = i3;
            adCgiResponseParam.mErrorCode = String.valueOf(i17);
            pushEvent(10302, adCgiResponseParam);
        }
        this.mPlayerManagerCallBack.onPreAdFinish(this);
        notifyVideoPreparedAfterPreAdFinish();
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {123})
    private void handlePrivateHlsM3u8TAG(TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams tVKAssetPlayerMsgParams) {
        String str = (String) tVKAssetPlayerMsgParams.extra;
        pushEvent(TVKEventId.PLAYER_STATE_PRIVATE_HLS_M3U8_TAG, str);
        if (!TextUtils.isEmpty(str) && str.startsWith("EXT-X-PROGRAM-DATE-TIME")) {
            this.mHlsTagInfo = str;
        }
        this.mPlayerManagerCallBack.onInfo(this, 53, str);
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {205})
    private void handleProtocolUpdate(TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams tVKAssetPlayerMsgParams) {
        TVKEventParams.DownLoadProtocolInfo downLoadProtocolInfo = new TVKEventParams.DownLoadProtocolInfo();
        Object obj = tVKAssetPlayerMsgParams.extra;
        if (obj instanceof TPDataTransportMessageInfo) {
            TPDataTransportMessageInfo tPDataTransportMessageInfo = (TPDataTransportMessageInfo) obj;
            downLoadProtocolInfo.protocolName = (String) tPDataTransportMessageInfo.obj1;
            downLoadProtocolInfo.protocolVersion = (String) tPDataTransportMessageInfo.obj2;
        }
        pushEvent(TVKEventId.PLAYER_STATE_DOWNLOAD_PROTOCOL_UPDATE, downLoadProtocolInfo);
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {TVKQQLiveAssetPlayerMsg.PLAYER_INFO_PROXY_AUTHENTICATION_FAILED})
    private void handleProxyAuthenticationFailed(TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams tVKAssetPlayerMsgParams) {
        pushEvent(TVKEventId.PLAYER_STATE_PROXY_AUTHENTICATION_FAILED, null);
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {135})
    private void handleRenderTimeout(TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams tVKAssetPlayerMsgParams) {
        pushEvent(TVKEventId.PLAYER_STATE_RENDER_TIMEOUT, (int) tVKAssetPlayerMsgParams.arg1, (int) tVKAssetPlayerMsgParams.arg2, "", null);
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {525})
    private void handleSetAudioTrackUrlToPlayer(TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams tVKAssetPlayerMsgParams) {
        pushEvent(TVKEventId.PLAYER_STATE_SWITCH_AUDIO_TRACK_PLAYER_CORE_SWITCH_START, TVKTrackUtils.getAudioTrackFromTrackInfo((String) tVKAssetPlayerMsgParams.extra, getTrackInfo()));
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {115})
    private void handleSetDecoderMode(TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams tVKAssetPlayerMsgParams) {
        int i3 = (int) tVKAssetPlayerMsgParams.arg1;
        pushEvent(TVKEventId.PLAYER_STATE_SET_DECODE_MODE, Integer.valueOf(i3));
        if (this.mLisMgr != null) {
            this.mPlayerManagerCallBack.onInfo(this, 24, Integer.valueOf(i3));
        }
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {128})
    private void handleSubtitleSelEnd(TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams tVKAssetPlayerMsgParams) {
        this.mPlayerManagerCallBack.onInfo(this, 65, tVKAssetPlayerMsgParams.extra);
        TVKEventParams.SubtitleLoadEndParam subtitleLoadEndParam = new TVKEventParams.SubtitleLoadEndParam();
        subtitleLoadEndParam.errorCode = String.valueOf(tVKAssetPlayerMsgParams.arg1);
        pushEvent(TVKEventId.PLAYER_STATE_SUBTITLE_SWITCH_END, subtitleLoadEndParam);
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {127})
    private void handleSubtitleSelStart(TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams tVKAssetPlayerMsgParams) {
        String str = (String) tVKAssetPlayerMsgParams.extra;
        this.mPlayerManagerCallBack.onInfo(this, 64, str);
        TVKNetVideoInfo.SubTitle subTitle = null;
        if (TextUtils.isEmpty(str)) {
            pushEvent(TVKEventId.PLAYER_STATE_SUBTITLE_SWITCH_START, null);
            return;
        }
        TVKNetVideoInfo tVKNetVideoInfo = this.mNetVideoInfo;
        if (tVKNetVideoInfo != null && tVKNetVideoInfo.getSubTitleList() != null) {
            Iterator<TVKNetVideoInfo.SubTitle> it = this.mNetVideoInfo.getSubTitleList().iterator();
            while (it.hasNext()) {
                TVKNetVideoInfo.SubTitle next = it.next();
                if ((next.getLang() != null && next.getLang().equalsIgnoreCase(str)) || (next.getName() != null && next.getName().equalsIgnoreCase(str))) {
                    subTitle = next;
                    break;
                }
            }
        } else {
            this.mLogger.warn("netvideoinfo is null or not has subtitle list", new Object[0]);
        }
        if (subTitle == null) {
            subTitle = TVKTrackUtils.getSubtitleFromTrackInfos(str, getTrackInfo());
        }
        pushEvent(TVKEventId.PLAYER_STATE_SUBTITLE_SWITCH_START, subTitle);
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {508})
    private void handleSwitchPlayerEnd() {
        pushEvent(TVKEventId.PLAYER_STATE_SWITCH_PLAYER_END, null);
        this.mPlayerManagerCallBack.onInfo(this, 47, null);
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {200})
    private void handleSwitchPlayerStart(TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams tVKAssetPlayerMsgParams) {
        pushEvent(TVKEventId.PLAYER_STATE_SWITCH_PLAYER_START, null);
        this.mPlayerManagerCallBack.onInfo(this, 29, tVKAssetPlayerMsgParams.extra);
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {TVKQQLiveAssetPlayerMsg.PLAYER_INFO_UPDATE_ADAPTIVE_DEFINITION_STATE})
    private void handleUpdateAdaptiveDefinitionState(TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams tVKAssetPlayerMsgParams) {
        pushEvent(TVKEventId.PLAYER_STATE_UPDATE_ADAPTIVE_DEFINITION, (Boolean) tVKAssetPlayerMsgParams.extra);
    }

    @TVKAssetPlayerMsgMap.DealWithMsg(msg = {132})
    private void handleVideoSeiInfo(TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams tVKAssetPlayerMsgParams) {
        pushEvent(TVKEventId.PLAYER_STATE_SEI_INFO, tVKAssetPlayerMsgParams.extra);
        this.mPlayerManagerCallBack.onInfo(this, 82, tVKAssetPlayerMsgParams.extra);
    }

    private void initAssetPlayer(Looper looper) {
        this.mLisMgr = new TVKListenerManager();
        TVKPlayerManagerCallBack tVKPlayerManagerCallBack = new TVKPlayerManagerCallBack(this.mTVKContext, this, this.mLisMgr, looper);
        this.mPlayerManagerCallBack = tVKPlayerManagerCallBack;
        this.mTVKContext.setDebugTrackingEventReporter(new TVKDebugTrackingEventReporter(this, tVKPlayerManagerCallBack));
        TVKReportHookCallback tVKReportHookCallback = new TVKReportHookCallback(this.mTVKContext, this, this.mPlayerManagerCallBack);
        this.mHookCallback = tVKReportHookCallback;
        TVKHookManager.hookQQLiveAssetPlayer(this, looper, tVKReportHookCallback);
        this.mAssetPlayerState = TVKAssetPlayerFactory.createPlayerState();
        TVKPlayerListener tVKPlayerListener = new TVKPlayerListener();
        this.mAssetPlayerListener = tVKPlayerListener;
        TVKHookManager.hookQQLiveAssetPlayerListener(this, tVKPlayerListener, this.mHookCallback);
        if (this.mAssetPlayer == null) {
            this.mAssetPlayer = TVKAssetPlayerFactory.createAssetPlayer(this.mTVKContext, this.mDrawableContainer, this.mLooper, looper);
        }
        this.mAssetPlayer.setAssetPlayerListener(this.mAssetPlayerListener);
    }

    private void initConfigAndPluginAsync() {
        new Handler(this.mLooper).post(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKPlayerManager.1
            @Override // java.lang.Runnable
            public void run() {
                TVKPlayerManager.this.initPlugin();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initPlugin() {
        ViewGroup viewGroup;
        if (TVKReportFactoryCreator.getReportFactory() != null) {
            this.mPluginManager.loadPlugin(TVKReportFactoryCreator.getReportFactory().createQualityReport(this.mTVKContext, ITVKReportFactory.QualityReportType.QUALITY_REPORT_FEITIAN));
            this.mPluginManager.loadPlugin(TVKReportFactoryCreator.getReportFactory().createQualityReport(this.mTVKContext, ITVKReportFactory.QualityReportType.QUALITY_REPORT_LIVE_PERIOD));
            this.mPluginManager.loadPlugin(TVKReportFactoryCreator.getReportFactory().createQualityReport(this.mTVKContext, ITVKReportFactory.QualityReportType.QUALITY_REPORT_MEDIALABVR));
        }
        TVKPluginManager tVKPluginManager = this.mPluginManager;
        TVKContext tVKContext = this.mTVKContext;
        ViewGroup viewGroup2 = null;
        if (isVideoView(this.mDrawableContainer)) {
            viewGroup = (ViewGroup) this.mDrawableContainer;
        } else {
            viewGroup = null;
        }
        tVKPluginManager.loadPlugin(TVKLogoPluginFactory.createLogoPlugin(tVKContext, viewGroup));
        this.mPluginManager.loadPlugin(TVKSecurityPluginFactory.createSecurityPlugin(this.mTVKContext));
        TVKPluginManager tVKPluginManager2 = this.mPluginManager;
        TVKContext tVKContext2 = this.mTVKContext;
        if (isVideoView(this.mDrawableContainer)) {
            viewGroup2 = (ViewGroup) this.mDrawableContainer;
        }
        tVKPluginManager2.loadPlugin(TVKLogoPluginFactory.createOverlayLogoPlugin(tVKContext2, viewGroup2));
    }

    private boolean invalidCallSeekTo() {
        return !this.mAssetPlayerState.is(ITVKPlayerState.STATE.CGIED, ITVKPlayerState.STATE.PREPARING, ITVKPlayerState.STATE.PREPARED, ITVKPlayerState.STATE.STARTED, ITVKPlayerState.STATE.PAUSED, ITVKPlayerState.STATE.COMPLETE);
    }

    private boolean invalidCallSwitchDefinition() {
        return !this.mAssetPlayerState.is(ITVKPlayerState.STATE.CGING, ITVKPlayerState.STATE.CGIED, ITVKPlayerState.STATE.PREPARING, ITVKPlayerState.STATE.PREPARED, ITVKPlayerState.STATE.STARTED, ITVKPlayerState.STATE.PAUSED, ITVKPlayerState.STATE.COMPLETE);
    }

    private boolean isUseSurfaceView() {
        ITVKVideoViewBase iTVKVideoViewBase;
        if (!isVideoView(this.mDrawableContainer) || (iTVKVideoViewBase = (ITVKVideoViewBase) this.mDrawableContainer) == null || iTVKVideoViewBase.getCurrentDisplayView() == null || !(iTVKVideoViewBase.getCurrentDisplayView() instanceof SurfaceView)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isVideoView(ITVKDrawableContainer iTVKDrawableContainer) {
        return iTVKDrawableContainer instanceof ITVKVideoViewBase;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(String str) {
        this.mLogger.error(str, new Object[0]);
        if (!TVKMediaPlayerConfig.PlayerConfig.report_worker_thread_looper_hung_detail_info) {
            str = "";
        }
        pushEvent(TVKEventId.PLAYER_STATE_WORKER_THREAD_HUNG, str);
        this.mPlayerManagerCallBack.onInfo(this, 100, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyOnCompletion() {
        this.mPlayerManagerCallBack.onCompletion(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyPermissionTimeOut() {
        if (this.mLisMgr.hasOnPermissionTimeoutLis()) {
            this.mPlayerManagerCallBack.onPermissionTimeout(this);
        } else {
            notifyOnCompletion();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyVideoPreparedAfterPreAdFinish() {
        this.mLogger.info("notifyVideoPreparedAfterPreAdFinish, state=" + this.mAssetPlayerState, new Object[0]);
        if (this.mAssetPlayerState.is(ITVKPlayerState.STATE.CGIED)) {
            this.mLogger.info("playVideoAfterPreAdFinish, cgied state, start prepared main video", new Object[0]);
            prepareAssetPlayer();
            return;
        }
        if (this.mAssetPlayerState.is(ITVKPlayerState.STATE.CGING)) {
            this.mLogger.info("notifyVideoPreparedAfterPreAdFinish, cging state, wait for assetPlayer cgied notify, continue", new Object[0]);
            return;
        }
        if (this.mAssetPlayerState.is(ITVKPlayerState.STATE.PREPARING)) {
            this.mLogger.info("notifyVideoPreparedAfterPreAdFinish, player state is preparing, ready to play, mHasPostPreparing:" + this.mHasPostPreparing, new Object[0]);
            if (!this.mHasPostPreparing) {
                this.mLogger.info("post video preparing", new Object[0]);
                this.mHasPostPreparing = true;
                this.mPlayerManagerCallBack.onVideoPreparing(this);
                return;
            }
            return;
        }
        if (this.mAssetPlayerState.is(ITVKPlayerState.STATE.PREPARED, ITVKPlayerState.STATE.STARTED, ITVKPlayerState.STATE.PAUSED)) {
            this.mLogger.info("notifyVideoPreparedAfterPreAdFinish, player state is one of prepared/started/paused, video valid, mHasPostPrepared:" + this.mHasPostPrepared, new Object[0]);
            if (!this.mHasPostPrepared) {
                this.mLogger.info("post video prepared", new Object[0]);
                this.mHasPostPrepared = true;
                ITVKMediaPlayerPrivate.ITVKStateKeeperListener iTVKStateKeeperListener = this.mStateKeeperListener;
                if (iTVKStateKeeperListener != null) {
                    iTVKStateKeeperListener.onVideoPrepared(this);
                }
                this.mPlayerManagerCallBack.onVideoPrepared(this);
                return;
            }
            return;
        }
        if (this.mAssetPlayerState.is(ITVKPlayerState.STATE.IDLE)) {
            this.mLogger.info("notifyVideoPreparedAfterPreAdFinish, asset player might already reset, ignore it!", new Object[0]);
            return;
        }
        this.mLogger.error("notifyVideoPreparedAfterPreAdFinish, should not enter this state:" + this.mAssetPlayerState, new Object[0]);
    }

    private void pauseWithIsAllowShowPauseAd(boolean z16, ViewGroup viewGroup) {
        printState();
        updateUserInfoActivelyForAd();
        int adState = this.mAdManager.getAdState();
        if (adState != 6 && adState != 7) {
            if (this.mAssetPlayerState.is(ITVKPlayerState.STATE.STARTED, ITVKPlayerState.STATE.COMPLETE)) {
                this.mLogger.info("pause video", new Object[0]);
                this.mCurrentPositionMs = this.mAssetPlayer.getCurrentPosition();
                this.mAssetPlayer.pause();
                pushEvent(TVKEventId.PLAYER_STATE_PAUSE, z16 ? 1 : 0, 0, "", viewGroup);
                return;
            }
            this.mLogger.warn("api call : pauseWithIsAllowShowPauseAd, invalid api call", new Object[0]);
            return;
        }
        this.mAdManager.pauseAd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void prepareAssetPlayer() {
        pushEvent(10100, null);
        this.mAssetPlayer.prepare();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void prepareAssetPlayerWhenPreAdDownloaded() {
        TVKPlayerVideoInfo tVKPlayerVideoInfo = this.mPlayerVideoInfo;
        if (tVKPlayerVideoInfo != null && tVKPlayerVideoInfo.getAsset() != null) {
            if (this.mPlayerVideoInfo.isLivePlay()) {
                this.mLogger.info("live play don't prepare asset player in advance when preAd downloaded", new Object[0]);
            } else if (TVKMediaPlayerConfig.PlayerConfig.is_allow_prepare_player_when_pre_ad_downloaded && !TVKMediaPlayerConfig.PlayerConfig.is_one_player_instance) {
                this.mLogger.info("start prepare asset player in advance when preAd downloaded", new Object[0]);
                prepareAssetPlayer();
            }
        }
    }

    private void printState() {
        this.mLogger.info("assetPlayer state:" + this.mAssetPlayerState + "; ad type:" + ITVKAdCommons.adTypeString(this.mAdManager.getAdType()) + ", ad state:" + ITVKAdCommons.adStateString(this.mAdManager.getAdState()), new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pushEvent(int i3, int i16, int i17, String str, Object obj) {
        try {
            this.mTVKContext.getEventSender().sendEvent(i3, i16, i17, str, obj);
        } catch (Exception e16) {
            this.mLogger.printException(e16);
        }
    }

    private void pushOpenEvent(String str, String str2) {
        TVKEventParams.OpenMediaParam openMediaParam = new TVKEventParams.OpenMediaParam();
        openMediaParam.mPlayerVideoInfo = this.mPlayerVideoInfo;
        openMediaParam.mDefinition = str2;
        openMediaParam.mUserInfo = this.mUserInfo;
        openMediaParam.mFlowId = this.mFlowId;
        openMediaParam.mSkipEndPositionMs = this.mSkipEndPositionMs;
        openMediaParam.mSkipStartPositionMs = this.mStartPositionMs;
        openMediaParam.mSourceUrl = str;
        pushEvent(10005, openMediaParam);
    }

    private void pushSeekEvent(int i3) {
        TVKEventParams.StartSeekParam startSeekParam = new TVKEventParams.StartSeekParam();
        startSeekParam.mSeekFromPositionMs = this.mCurrentPositionMs;
        startSeekParam.mSeekToPositionMs = i3;
        pushEvent(TVKEventId.PLAYER_STATE_START_SEEK, startSeekParam);
    }

    private void resetAll() {
        this.mAdManager.reset();
        pushEvent(12001, this.mDrawableContainer);
        this.mAdIsDownloadDone = false;
        stopPositionTimer();
        this.mNetVideoInfo = null;
        this.mIsPermissionTimeOut = false;
        this.mCurrentPositionMs = 0L;
        this.mPlayTimeMs.set(0L);
        this.mIsBuffering = false;
        this.mHasPostPreparing = false;
        this.mHasPostPrepared = false;
        this.mBasicInfoCollector.reset();
    }

    private void resetForOpenMedia() {
        this.mHasPostPreparing = false;
        this.mHasPostPrepared = false;
    }

    private void setUpCommonParams() {
        String str;
        TVKUserInfo tVKUserInfo = this.mUserInfo;
        if (tVKUserInfo != null) {
            TVKCommParams.setQQ(tVKUserInfo.getUin());
            TVKCommParams.setIsVIP(this.mUserInfo.isVip());
        } else {
            TVKCommParams.setQQ("");
            TVKCommParams.setIsVIP(false);
        }
        if (TVKCommParams.isVip()) {
            str = "1";
        } else {
            str = "0";
        }
        TPDataTransportMgr.setGlobalOptionalConfigParam("qq_is_vip", str);
        this.mAssetPlayer.setFlowId(this.mFlowId);
    }

    private void startPositionTimer() {
        stopPositionTimer();
        this.mLogger.info("startPositionTimer", new Object[0]);
        this.mTimerTask = TVKThreadPool.getInstance().obtainScheduledExecutorService().scheduleAtFixedRate(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.logic.b
            @Override // java.lang.Runnable
            public final void run() {
                TVKPlayerManager.this.timingTask();
            }
        }, 0L, TVKMediaPlayerConfig.PlayerConfig.position_polling_time_interval_ms, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPositionTimer() {
        if (this.mTimerTask != null) {
            this.mLogger.info("stopPositionTimer", new Object[0]);
            this.mTimerTask.cancel(true);
            this.mTimerTask = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void timingTask() {
        long currentPosition = this.mAssetPlayer.getCurrentPosition();
        updatePlayTime(TVKMediaPlayerConfig.PlayerConfig.position_polling_time_interval_ms, currentPosition);
        this.mCurrentPositionMs = currentPosition;
        pushEvent(16000, TVKMediaPlayerConfig.PlayerConfig.position_polling_time_interval_ms, 0, null, Long.valueOf(this.mCurrentPositionMs));
    }

    private void updatePlayTime(int i3, long j3) {
        TVKPlayerVideoInfo tVKPlayerVideoInfo = this.mPlayerVideoInfo;
        if (tVKPlayerVideoInfo != null && tVKPlayerVideoInfo.getAsset() != null) {
            if (this.mPlayerVideoInfo.isLivePlay()) {
                if (this.mAssetPlayer.isPlaying() && !this.mIsBuffering) {
                    this.mPlayTimeMs.addAndGet(i3);
                    return;
                }
                return;
            }
            if (j3 != this.mCurrentPositionMs) {
                this.mPlayTimeMs.addAndGet(i3);
            }
        }
    }

    private void updateUserInfoActivelyForAd() {
        TVKUserInfo onGetUserInfo = this.mLisMgr.onGetUserInfo(this, this.mUserInfo);
        if (onGetUserInfo == null) {
            return;
        }
        this.mUserInfo = onGetUserInfo;
        this.mAdManager.updateUserInfo(onGetUserInfo);
    }

    @Override // com.tencent.qqlive.tvkplayer.logic.ITVKMediaPlayerPrivate
    @TVKThreadAnnotations.ThreadSwitch
    public void addOptionalParam(TPOptionalParam<?> tPOptionalParam) {
        ITVKQQLiveAssetPlayer iTVKQQLiveAssetPlayer = this.mAssetPlayer;
        if (iTVKQQLiveAssetPlayer instanceof ITVKMediaPlayerPrivate) {
            ((ITVKMediaPlayerPrivate) iTVKQQLiveAssetPlayer).addOptionalParam(tPOptionalParam);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void addPlayerEventListener(ITVKPlayerEventListener iTVKPlayerEventListener) {
        this.mLisMgr.addPlayerEventListener(iTVKPlayerEventListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void addReportEventListener(ITVKReportEventListener iTVKReportEventListener) {
        this.mLisMgr.addReportEventListener(iTVKReportEventListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @TVKThreadAnnotations.ThreadSwitch
    public void addTrack(int i3, String str, String str2) throws IllegalArgumentException {
        this.mLogger.info("api call : addTrack", new Object[0]);
        this.mAssetPlayer.addTrackInfo(i3, str, str2);
        if (i3 == 3) {
            pushEvent(TVKEventId.PLAYER_ADD_SUBTITLE_TRACK, null);
        }
    }

    @Override // com.tencent.thumbplayer.api.dtreport.IDtReport
    public void bindVideoPlayerInfo(Object obj) {
        ITVKQQLiveAssetPlayer iTVKQQLiveAssetPlayer = this.mAssetPlayer;
        if (iTVKQQLiveAssetPlayer != null) {
            iTVKQQLiveAssetPlayer.bindVideoPlayerInfo(obj);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @TVKThreadAnnotations.ThreadSwitch(letCallerThreadWait = true)
    public int captureImageInTime(int i3, int i16) throws IllegalStateException, IllegalArgumentException, IllegalAccessException {
        this.mLogger.info("api call : captureImageInTime, width:" + i3 + ", height:" + i16, new Object[0]);
        return this.mAssetPlayer.captureImageInTime(i3, i16);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @TVKThreadAnnotations.ThreadSwitch
    public void connectPostProcessor(ITVKPostProcessor iTVKPostProcessor) throws IllegalStateException {
        this.mLogger.info("api call : connectPostProcessor", new Object[0]);
        this.mAssetPlayer.connectPostProcessor(iTVKPostProcessor);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @TVKThreadAnnotations.ThreadSwitch(letCallerThreadWait = true)
    public void deselectTrack(int i3) throws IllegalArgumentException, IllegalStateException {
        this.mLogger.info("api call : deselectTrack, track index:" + i3, new Object[0]);
        this.mAssetPlayer.deselectTrack(i3);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @TVKThreadAnnotations.ThreadSwitch
    public void disconnectPostProcessor(ITVKPostProcessor iTVKPostProcessor) throws IllegalStateException {
        this.mLogger.info("api call : disconnectPostProcessor", new Object[0]);
        this.mAssetPlayer.disconnectPostProcessor(iTVKPostProcessor);
    }

    @Override // com.tencent.qqlive.tvkplayer.logic.ITVKMediaPlayerPrivate
    public void enablePlayerCallbackInterception(boolean z16) {
        this.mPlayerManagerCallBack.enableCallbackInterception(z16);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public long getAdCurrentPosition() {
        return this.mAdManager.getCurrentPosition();
    }

    @Override // com.tencent.qqlive.tvkplayer.logic.ITVKMediaPlayerPrivate
    public int getAdState() {
        return this.mAdManager.getAdState();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public Object getAdStatus() {
        return this.mAdManager.getAdStatus();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public ITVKAudioFxProcessor getAudioFxProcessor() {
        this.mLogger.info("api call : getAudioFxProcessor", new Object[0]);
        return this.mAssetPlayer.getAudioFxProcessor();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public long getAvailablePositionMs() {
        return this.mAssetPlayer.getAvailablePositionMs();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public int getBufferPercent() {
        return this.mAssetPlayer.getBufferPercent();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public TVKNetVideoInfo getCurNetVideoInfo() {
        return this.mAssetPlayer.getCurNetVideoInfo();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public long getCurrentPosition() {
        return this.mCurrentPositionMs;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public int getDownloadSpeed(int i3) {
        return this.mAssetPlayer.getDownloadSpeed(i3);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public long getDuration() {
        return this.mAssetPlayer.getDuration();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public String getHlsTagInfo(String str) {
        return TVKUtils.getSafeString(this.mHlsTagInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Looper getLooper() {
        return this.mLooper;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @TVKThreadAnnotations.ThreadSwitch(letCallerThreadWait = true, waitApiSignatures = {METHOD_SIGNATURE_SET_OUTPUT_MUTE})
    public boolean getOutputMute() {
        return this.mAssetPlayer.getOutputMute();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public long getPlayedTime() {
        return this.mPlayTimeMs.get();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public TPProgramInfo[] getProgramInfo() {
        return this.mAssetPlayer.getProgramInfo();
    }

    @Override // com.tencent.qqlive.tvkplayer.logic.ITVKMediaPlayerPrivate
    public String getProperty(String str) throws IllegalStateException {
        ITVKQQLiveAssetPlayer iTVKQQLiveAssetPlayer = this.mAssetPlayer;
        if (iTVKQQLiveAssetPlayer instanceof ITVKMediaPlayerPrivate) {
            return ((ITVKMediaPlayerPrivate) iTVKQQLiveAssetPlayer).getProperty(str);
        }
        return "";
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @Nullable
    @TVKThreadAnnotations.ThreadSwitch(letCallerThreadWait = true, waitApiSignatures = {METHOD_SIGNATURE_STOP, METHOD_SIGNATURE_RELEASE})
    public ITVKRichMediaSynchronizer getRichMediaSynchronizer() {
        return this.mAssetPlayer.getRichMediaSynchronizer();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @TVKThreadAnnotations.ThreadSwitch(letCallerThreadWait = true, waitApiSignatures = {METHOD_SIGNATURE_SELECT_TRACK, METHOD_SIGNATURE_DESELECT_TRACK})
    public int getSelectedTrack(int i3) {
        this.mLogger.info("api call : getSelectedTrack, track type:" + i3, new Object[0]);
        return this.mAssetPlayer.getSelectedTrack(i3);
    }

    public synchronized int getStartPauseSem() {
        return this.mStartPauseFinishCount;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @TVKThreadAnnotations.ThreadSwitch(letCallerThreadWait = true)
    public String getStreamDumpInfo() {
        this.mLogger.info("api call : getStreamDumpInfo", new Object[0]);
        return this.mAssetPlayer.getStreamDumpInfo();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public ITVKSubtitleRendererController getSubtitleRendererController() {
        return this.mAssetPlayer.getSubtitleRendererController();
    }

    @Override // com.tencent.qqlive.tvkplayer.logic.ITVKMediaPlayerPrivate
    public ITVKTPPlayer getTVKTPPlayer() {
        ITVKQQLiveAssetPlayer iTVKQQLiveAssetPlayer = this.mAssetPlayer;
        if (iTVKQQLiveAssetPlayer instanceof ITVKMediaPlayerPrivate) {
            return ((ITVKMediaPlayerPrivate) iTVKQQLiveAssetPlayer).getTVKTPPlayer();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getTag() {
        return this.mLogger.getTag();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @TVKThreadAnnotations.ThreadSwitch(letCallerThreadWait = true, waitApiSignatures = {METHOD_SIGNATURE_ADD_TRACK, METHOD_SIGNATURE_SELECT_TRACK, METHOD_SIGNATURE_DESELECT_TRACK})
    public TVKTrackInfo[] getTrackInfo() {
        this.mLogger.info("api call : getTrackInfo", new Object[0]);
        return this.mAssetPlayer.getTrackInfo();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public ITVKVideoFxProcessor getVideoFxProcessor() {
        this.mLogger.info("api call : getVideoFxProcessor", new Object[0]);
        return this.mAssetPlayer.getVideoFxProcessor();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public int getVideoHeight() {
        return this.mAssetPlayer.getVideoHeight();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public int getVideoRotation() {
        try {
            return this.mAssetPlayer.getVideoRotation();
        } catch (IllegalStateException e16) {
            this.mLogger.printException(e16);
            return 0;
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @TVKThreadAnnotations.ThreadSwitch(letCallerThreadWait = true, waitApiSignatures = {METHOD_SIGNATURE_UPDATE_VIDEO_VIEW})
    public ITVKVideoViewBase getVideoView() {
        if (isVideoView(this.mDrawableContainer)) {
            return (ITVKVideoViewBase) this.mDrawableContainer;
        }
        return null;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public int getVideoWidth() {
        return this.mAssetPlayer.getVideoWidth();
    }

    public synchronized void increaseStartPauseSem() {
        this.mStartPauseFinishCount++;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @TVKThreadAnnotations.ThreadSwitch(letCallerThreadWait = true, waitApiSignatures = {METHOD_SIGNATURE_SET_LOOPBACK, METHOD_SIGNATURE_SET_LOOPBACK_WITH_POSITION})
    public boolean isLoopBack() {
        return this.mAssetPlayer.isLoopBack();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @TVKThreadAnnotations.ThreadSwitch(letCallerThreadWait = true, waitApiSignatures = {METHOD_SIGNATURE_START, METHOD_SIGNATURE_PAUSE, METHOD_SIGNATURE_STOP, METHOD_SIGNATURE_RELEASE, METHOD_SIGNATURE_ON_CLICK_PAUSE1, METHOD_SIGNATURE_ON_CLICK_PAUSE2, METHOD_SIGNATURE_SKIP_AD, METHOD_SIGNATURE_ON_SKIP_AD_RESULT})
    public boolean isPaused() {
        if (!this.mAssetPlayer.isPaused() && !this.mAdManager.isPaused()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @TVKThreadAnnotations.ThreadSwitch(letCallerThreadWait = true, waitApiSignatures = {METHOD_SIGNATURE_START, METHOD_SIGNATURE_PAUSE, METHOD_SIGNATURE_STOP, METHOD_SIGNATURE_RELEASE, METHOD_SIGNATURE_ON_CLICK_PAUSE1, METHOD_SIGNATURE_ON_CLICK_PAUSE2, METHOD_SIGNATURE_SKIP_AD, METHOD_SIGNATURE_ON_SKIP_AD_RESULT})
    public boolean isPlaying() {
        if (!this.mAdManager.isPlaying() && !this.mAssetPlayer.isPlaying()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @TVKThreadAnnotations.ThreadSwitch
    public void onClickPause() {
        onClickPause(null);
    }

    @Override // com.tencent.qqlive.tvkplayer.event.ITVKEventObserver
    public void onEvent(int i3, int i16, int i17, String str, Object obj) {
        Message obtain = Message.obtain();
        obtain.what = i3;
        obtain.arg1 = i16;
        obtain.arg2 = i17;
        obtain.obj = obj;
        this.mEventHandler.sendMessage(obtain);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public boolean onKeyEvent(KeyEvent keyEvent) {
        this.mLogger.info("api call : onKeyEvent", new Object[0]);
        return this.mAdManager.onKeyEvent(keyEvent);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @TVKThreadAnnotations.ThreadSwitch
    public void onRealTimeInfoChange(int i3, Object obj) throws IllegalArgumentException {
        this.mLogger.info("api call : onRealTimeInfoChange, infoKey:" + i3, new Object[0]);
        this.mAdManager.onRealTimeInfoChange(i3, obj);
        this.mAssetPlayer.onRealTimeInfoChange(i3, obj);
        pushEvent(TVKEventId.PLAYER_STATE_REAL_TIME_INFO_CHANGE, i3, 0, "", obj);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @TVKThreadAnnotations.ThreadSwitch
    public void onSkipAdResult(boolean z16) {
        this.mLogger.info("api call : onSkipAdResult:" + z16, new Object[0]);
        this.mAdManager.skipAd();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public boolean onTouchEvent(View view, MotionEvent motionEvent) {
        return this.mAdManager.onTouchEvent(view, motionEvent);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @TVKThreadAnnotations.ThreadSwitch
    public void openMediaPlayer(Context context, TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo) {
        long j3;
        String str;
        long j16;
        this.mLogger.info("TVKPlayerManager open. Currently unreleased player(s)=" + sNumberOfUnreleasedPlayers.get(), new Object[0]);
        this.mTVKContext.increaseSequence();
        this.mBasicInfoCollector.setUserInfo(tVKUserInfo);
        this.mLogger.info(this.mBasicInfoCollector.toString(), new Object[0]);
        if (tVKPlayerVideoInfo != null) {
            j3 = tVKPlayerVideoInfo.getSkipStartPositionMs();
            j16 = tVKPlayerVideoInfo.getSkipEndPositionMs();
            str = tVKPlayerVideoInfo.getDefinition();
        } else {
            j3 = 0;
            str = "";
            j16 = 0;
        }
        this.mLogger.info(TVKMainStepTag.MAIN_STEP_TAG_OPEN_MEDIA_PLAYER, "api call : openMediaPlayer, definition:" + str + ", startPositionMilsec:" + j3 + ", skipEndMilsec:" + j16, new Object[0]);
        if (!TVKAppKeyManager.isAuthorized()) {
            this.mLogger.error("OpenMediaPlayer fail, because unAuthorized or authorized failed:" + TVKAppKeyManager.getKeyStateDescription(), new Object[0]);
            TVKError tVKError = new TVKError(TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.AUTH_FAILED_ERR);
            tVKError.setPositionMs((int) j3);
            callOnErrorCB(tVKError);
            return;
        }
        if (!this.mAssetPlayerState.is(ITVKPlayerState.STATE.IDLE, ITVKPlayerState.STATE.STOPPED)) {
            this.mLogger.warn("OpenMediaPlayer player state invalid:" + this.mAssetPlayerState, new Object[0]);
            return;
        }
        TVKThreadPrioritySetter.set(TVKMediaPlayerConfig.PlayerConfig.tvk_thread_priority_after_modification);
        resetForOpenMedia();
        this.mTVKContext.updateContext(context.getApplicationContext());
        this.mStartPositionMs = j3;
        this.mHookCallback.updateStartPosition(j3);
        this.mSkipEndPositionMs = j16;
        if (tVKUserInfo == null) {
            tVKUserInfo = new TVKUserInfo();
        }
        this.mUserInfo = tVKUserInfo;
        this.mPlayerVideoInfo = tVKPlayerVideoInfo;
        generateFlowId();
        setUpCommonParams();
        changeAdManagerWhenOpenMediaPlayer(this.mPlayerVideoInfo);
        pushOpenEvent("", str);
        exposeAbTestInfoWhenOpenMediaPlayer();
        this.mPlayerManagerCallBack.onInfo(this, 33, Long.valueOf(System.currentTimeMillis()));
        this.mAssetPlayer.openMediaPlayer(context, this.mUserInfo, this.mPlayerVideoInfo);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @TVKThreadAnnotations.ThreadSwitch
    public void pause() {
        this.mLogger.info("api call : pause", new Object[0]);
        pauseWithIsAllowShowPauseAd(false, null);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @TVKThreadAnnotations.ThreadSwitch
    public void pauseDownload() {
        this.mLogger.info("api call : pauseDownload", new Object[0]);
        this.mAssetPlayer.pauseDownload();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @TVKThreadAnnotations.ThreadSwitch
    public void refreshPlayer() {
        this.mLogger.info("api call : refreshPlayer", new Object[0]);
        this.mAssetPlayer.refreshPlayer();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @TVKThreadAnnotations.ThreadSwitch
    public void refreshPlayerWithReopen() {
        this.mLogger.info("api call : refreshPlayerWithReopen", new Object[0]);
        this.mAssetPlayer.refreshPlayerWithReopen();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @TVKThreadAnnotations.ThreadSwitch
    public void release() {
        AtomicInteger atomicInteger = sNumberOfUnreleasedPlayers;
        atomicInteger.decrementAndGet();
        this.mLogger.info("TVKPlayerManager release. Currently unreleased player(s)=" + atomicInteger.get(), new Object[0]);
        this.mLogger.info("api call : release", new Object[0]);
        printState();
        if (this.mAssetPlayerState.is(ITVKPlayerState.STATE.RELEASED)) {
            this.mLogger.warn("api call : release, invalid api call, return", new Object[0]);
            return;
        }
        stop();
        pushEvent(11000, null);
        this.mPluginManager.unloadAllPlugins();
        this.mAdManager.release();
        this.mAssetPlayer.release();
        this.mLisMgr.release();
        TVKGlobalEventNotifier.getInstance().removeEventListener(this.mGlobalEventChangeListener);
        this.mTVKContext.getEventSender().unregisterObserver(this);
        TVKThreadPool.getInstance().recycle(this.mHandlerThread, null);
    }

    @Override // com.tencent.qqlive.tvkplayer.logic.ITVKMediaPlayerPrivate
    public void removePendingPlayerCallback() {
        this.mPlayerManagerCallBack.removePendingCallback();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void removePlayerEventListener(ITVKPlayerEventListener iTVKPlayerEventListener) {
        this.mLisMgr.removePlayerEventListener(iTVKPlayerEventListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void removeReportEventListener(ITVKReportEventListener iTVKReportEventListener) {
        this.mLisMgr.removeReportEventListener(iTVKReportEventListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @TVKThreadAnnotations.ThreadSwitch
    public void resumeDownload() {
        this.mLogger.info("api call : resumeDownload", new Object[0]);
        this.mAssetPlayer.resumeDownload();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @TVKThreadAnnotations.ThreadSwitch
    public void saveReport() {
        this.mLogger.info("api call : saveReport", new Object[0]);
        pushEvent(10016, null);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @TVKThreadAnnotations.ThreadSwitch
    public void seekForLive(long j3) {
        this.mLogger.info("api call : seekForLive:" + j3, new Object[0]);
        printState();
        if (!this.mAssetPlayerState.is(ITVKPlayerState.STATE.CGIED, ITVKPlayerState.STATE.PREPARING, ITVKPlayerState.STATE.PREPARED, ITVKPlayerState.STATE.STARTED, ITVKPlayerState.STATE.PAUSED)) {
            this.mLogger.warn("api call : seekForLive, invalid api call, return", new Object[0]);
        } else {
            this.mAssetPlayer.seekForLive(j3);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @TVKThreadAnnotations.ThreadSwitch
    public void seekTo(int i3) {
        this.mLogger.info("api call : seekTo:" + i3, new Object[0]);
        printState();
        if (invalidCallSeekTo()) {
            this.mLogger.warn("api call : seekTo, invalid api call, return", new Object[0]);
        } else {
            pushSeekEvent(i3);
            this.mAssetPlayer.seekTo(i3);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @TVKThreadAnnotations.ThreadSwitch
    public void seekToAccuratePos(int i3) {
        this.mLogger.info("api call : seekToAccuratePos:" + i3, new Object[0]);
        printState();
        if (invalidCallSeekTo()) {
            this.mLogger.warn("api call : seekToAccuratePos, invalid api call, return", new Object[0]);
        } else {
            pushSeekEvent(i3);
            this.mAssetPlayer.seekToAccuratePos(i3);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @TVKThreadAnnotations.ThreadSwitch
    public void seekToAccuratePosFast(int i3) {
        this.mLogger.info("api call : seekToAccuratePosFast:" + i3, new Object[0]);
        printState();
        if (invalidCallSeekTo()) {
            this.mLogger.warn("api call : seekToAccuratePosFast, invalid api call, return", new Object[0]);
        } else {
            pushSeekEvent(i3);
            this.mAssetPlayer.seekToAccuratePosFast(i3);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void selectProgram(int i3, long j3) {
        this.mAssetPlayer.selectProgram(i3, j3);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @TVKThreadAnnotations.ThreadSwitch(letCallerThreadWait = true)
    public void selectTrack(int i3) throws IllegalArgumentException, IllegalStateException {
        this.mLogger.info("api call : selectTrack, track index:" + i3, new Object[0]);
        this.mAssetPlayer.selectTrack(i3);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @TVKThreadAnnotations.ThreadSwitch
    public void setAlignment(int i3) {
        this.mLogger.info("api call : setAlignment, type:" + i3, new Object[0]);
        this.mAssetPlayer.setAlignment(i3);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @TVKThreadAnnotations.ThreadSwitch
    public void setAudioGainRatio(float f16) {
        this.mLogger.info("api call : setAudioGainRatio:" + f16, new Object[0]);
        printState();
        if (this.mAssetPlayerState.is(ITVKPlayerState.STATE.ERROR, ITVKPlayerState.STATE.RELEASED)) {
            this.mLogger.warn("api call : setAudioGainRatio, invalid api call, return", new Object[0]);
        } else {
            this.mAdManager.setAudioGainRatio(f16);
            this.mAssetPlayer.setAudioGainRatio(f16);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @TVKThreadAnnotations.ThreadSwitch
    public void setDisplayOffset(float f16, float f17) {
        this.mLogger.info("api call : setDisplayOffset, offsetX:" + f16 + ", offsetY=" + f17, new Object[0]);
        this.mAssetPlayer.setDisplayOffset(f16, f17);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @TVKThreadAnnotations.ThreadSwitch
    public void setDisplayScale(float f16) {
        this.mLogger.info("api call : setDisplayScale, scale:" + f16, new Object[0]);
        this.mAssetPlayer.setDisplayScale(f16);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @TVKThreadAnnotations.ThreadSwitch
    public void setLoopback(boolean z16) {
        this.mLogger.info("api call : setLoopback:" + z16, new Object[0]);
        this.mAssetPlayer.setLoopback(z16);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setNextLoopVideoInfo(TVKPlayerVideoInfo tVKPlayerVideoInfo, String str) {
        this.mLogger.info("api call : setNextLoopVideoInfo, lastDefinition:" + str, new Object[0]);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setNextPlayerVideoInfo(TVKPlayerVideoInfo tVKPlayerVideoInfo) {
        this.mLogger.info("api call : setNextPlayerVideoInfo", new Object[0]);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnAdClickedListener(ITVKMediaPlayer.OnAdClickedListener onAdClickedListener) {
        this.mLisMgr.setOnAdClickedListener(onAdClickedListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnAdCustomCommandListener(ITVKMediaPlayer.OnAdCustomCommandListener onAdCustomCommandListener) {
        this.mLisMgr.setOnAdCustomCommandListener(onAdCustomCommandListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnAudioFrameOutListener(ITVKMediaPlayer.OnAudioFrameOutListener onAudioFrameOutListener) {
        this.mLisMgr.setOnAudioPcmDataListener(onAudioFrameOutListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnCaptureImageListener(ITVKMediaPlayer.OnCaptureImageListener onCaptureImageListener) {
        this.mLisMgr.setOnCaptureImageListener(onCaptureImageListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnCompletionListener(ITVKMediaPlayer.OnCompletionListener onCompletionListener) {
        this.mLisMgr.setOnCompletionListener(onCompletionListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnErrorListener(ITVKMediaPlayer.OnErrorListener onErrorListener) {
        this.mLisMgr.setOnErrorListener(onErrorListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnGetUserInfoListener(ITVKMediaPlayer.OnGetUserInfoListener onGetUserInfoListener) {
        this.mLisMgr.setOnGetUserInfoListener(onGetUserInfoListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnInfoListener(ITVKMediaPlayer.OnInfoListener onInfoListener) {
        this.mLisMgr.setOnInfoListener(onInfoListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnLogoPositionListener(ITVKMediaPlayer.OnLogoPositionListener onLogoPositionListener) {
        this.mLisMgr.setOnLogoPositionListener(onLogoPositionListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnLoopbackChangedListener(ITVKMediaPlayer.OnLoopBackChangedListener onLoopBackChangedListener) {
        this.mLisMgr.setOnLoopbackChangedListener(onLoopBackChangedListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnMidAdListener(ITVKMediaPlayer.OnMidAdListener onMidAdListener) {
        this.mLisMgr.setOnMidAdListener(onMidAdListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnNetVideoInfoListener(ITVKMediaPlayer.OnNetVideoInfoListener onNetVideoInfoListener) {
        this.mLisMgr.setOnNetVideoInfoListener(onNetVideoInfoListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnPermissionTimeoutListener(ITVKMediaPlayer.OnPermissionTimeoutListener onPermissionTimeoutListener) {
        this.mLisMgr.setOnPermissionTimeoutListener(onPermissionTimeoutListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnPostRollAdListener(ITVKMediaPlayer.OnPostRollAdListener onPostRollAdListener) {
        this.mLisMgr.setOnPostRollAdListener(onPostRollAdListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnPreAdListener(ITVKMediaPlayer.OnPreAdListener onPreAdListener) {
        this.mLisMgr.setOnPreAdListener(onPreAdListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnScrollAdListener(ITVKMediaPlayer.OnScrollAdListener onScrollAdListener) {
        this.mLisMgr.setOnScrollAdListener(onScrollAdListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnSeekCompleteListener(ITVKMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.mLisMgr.setOnSeekCompleteListener(onSeekCompleteListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnVideoFrameOutListener(ITVKMediaPlayer.OnVideoFrameOutListener onVideoFrameOutListener) {
        this.mLisMgr.setOnVideoOutputFrameListener(onVideoFrameOutListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnVideoPreparedListener(ITVKMediaPlayer.OnVideoPreparedListener onVideoPreparedListener) {
        this.mLisMgr.setOnVideoPreparedListener(onVideoPreparedListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnVideoPreparingListener(ITVKMediaPlayer.OnVideoPreparingListener onVideoPreparingListener) {
        this.mLisMgr.setOnVideoPreparingListener(onVideoPreparingListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnVideoSizeChangedListener(ITVKMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.mLisMgr.setOnVideoSizeChangedListener(onVideoSizeChangedListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @TVKThreadAnnotations.ThreadSwitch(letCallerThreadWait = true)
    public boolean setOutputMute(boolean z16) {
        this.mLogger.info("api call : setOutputMute:" + z16, new Object[0]);
        this.mAdManager.setOutputMute(z16);
        return this.mAssetPlayer.setOutputMute(z16);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @TVKThreadAnnotations.ThreadSwitch
    public void setPlaySpeedRatio(float f16) {
        this.mLogger.info("api call : setPlaySpeedRatio, speedRatio:" + f16, new Object[0]);
        this.mAssetPlayer.setPlaySpeedRatio(f16);
        pushEvent(TVKEventId.PLAYER_STATE_SPEED_RATIO_CHANGED, Float.valueOf(f16));
    }

    @Override // com.tencent.qqlive.tvkplayer.logic.ITVKMediaPlayerPrivate
    public void setStateKeeperListener(ITVKMediaPlayerPrivate.ITVKStateKeeperListener iTVKStateKeeperListener) {
        this.mStateKeeperListener = iTVKStateKeeperListener;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setSurface(Surface surface) {
        this.mAssetPlayer.setSurface(surface);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @TVKThreadAnnotations.ThreadSwitch
    public void setXYaxis(int i3) {
        this.mLogger.info("api call : setXYaxis, type:" + i3, new Object[0]);
        this.mAssetPlayer.setXYaxis(i3);
        pushEvent(13001, Integer.valueOf(i3));
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @TVKThreadAnnotations.ThreadSwitch
    public void skipAd() {
        this.mLogger.info("api call : skipAd", new Object[0]);
        this.mAdManager.skipAd();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @TVKThreadAnnotations.ThreadSwitch
    public void start() {
        this.mLogger.info("api call : start", new Object[0]);
        printState();
        updateUserInfoActivelyForAd();
        int adState = this.mAdManager.getAdState();
        if (adState != 5 && adState != 6 && adState != 7) {
            ITVKPlayerState iTVKPlayerState = this.mAssetPlayerState;
            ITVKPlayerState.STATE state = ITVKPlayerState.STATE.PREPARED;
            if (iTVKPlayerState.is(state, ITVKPlayerState.STATE.STARTED, ITVKPlayerState.STATE.PAUSED, ITVKPlayerState.STATE.COMPLETE)) {
                this.mLogger.info("start video", new Object[0]);
                boolean is5 = this.mAssetPlayerState.is(state);
                this.mAssetPlayer.start();
                if (is5) {
                    startPositionTimer();
                }
                TVKEventParams.StartPlayParam startPlayParam = new TVKEventParams.StartPlayParam();
                startPlayParam.isFirstStart = is5;
                pushEvent(TVKEventId.PLAYER_STATE_START_PLAY, startPlayParam);
                return;
            }
            this.mLogger.warn("api call : start, invalid api call", new Object[0]);
            return;
        }
        this.mLogger.info("start ad", new Object[0]);
        this.mAssetPlayer.startAd();
        ITVKAdCommons.AdResult startAd = this.mAdManager.startAd();
        if (startAd.suc()) {
            this.mLogger.info("start ad success", new Object[0]);
            if (startAd.type() == 1) {
                pushEvent(TVKEventId.PLAYER_STATE_AD_LOADING_PLAY_START, null);
                return;
            }
            return;
        }
        this.mLogger.warn("start ad failed", new Object[0]);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @TVKThreadAnnotations.ThreadSwitch
    public void stop() {
        this.mLogger.info("api call : stop", new Object[0]);
        printState();
        if (this.mAssetPlayerState.is(ITVKPlayerState.STATE.IDLE, ITVKPlayerState.STATE.ERROR, ITVKPlayerState.STATE.RELEASED)) {
            this.mLogger.warn("api call : stop, invalid state: " + this.mAssetPlayerState, new Object[0]);
            return;
        }
        this.mAdManager.closeAd(1);
        TVKEventParams.StopPlayParam stopPlayParam = new TVKEventParams.StopPlayParam();
        TVKEventParams.AdPlayFinishParam adPlayFinishParam = new TVKEventParams.AdPlayFinishParam();
        stopPlayParam.adPlayFinishParam = adPlayFinishParam;
        adPlayFinishParam.mAdType = this.mAdManager.getAdType();
        stopPlayParam.adPlayFinishParam.mPlayedTimeMs = this.mAdManager.getCurrentPosition();
        pushEvent(TVKEventId.PLAYER_STATE_STOP, stopPlayParam);
        this.mAssetPlayer.stop();
        exitPlaying();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @TVKThreadAnnotations.ThreadSwitch(letCallerThreadWait = true)
    public void switchDefinition(String str) throws IllegalStateException, IllegalArgumentException {
        this.mLogger.info("api call : switchDefinition:" + str, new Object[0]);
        printState();
        if (!invalidCallSwitchDefinition()) {
            this.mAssetPlayer.switchDefinition(str);
            this.mAdManager.updateDefinition(str);
        } else {
            this.mLogger.warn("api call : switchDefinition, invalid api call", new Object[0]);
            throw new IllegalStateException("api call : switchDefinition, invalid api call");
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @TVKThreadAnnotations.ThreadSwitch(letCallerThreadWait = true)
    public void switchDefinitionWithReopen(TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo) throws IllegalStateException, IllegalArgumentException {
        String str;
        if (tVKPlayerVideoInfo != null) {
            str = tVKPlayerVideoInfo.getDefinition();
        } else {
            str = "";
        }
        this.mLogger.info("api call : switchDefinitionWithReopen, videoInfo, definition:" + str, new Object[0]);
        printState();
        if (!invalidCallSwitchDefinition()) {
            this.mUserInfo = tVKUserInfo;
            this.mPlayerVideoInfo = tVKPlayerVideoInfo;
            this.mAssetPlayer.switchDefinitionWithReopen(tVKUserInfo, tVKPlayerVideoInfo);
            this.mAdManager.updateUserInfo(tVKUserInfo);
            this.mAdManager.updateDefinition(str);
            return;
        }
        this.mLogger.warn("api call : switchDefinitionWithReopen, invalid api call", new Object[0]);
        throw new IllegalStateException("api call : switchDefinitionWithReopen, invalid api call");
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @TVKThreadAnnotations.ThreadSwitch
    public void updatePlayerVideoView(ITVKDrawableContainer iTVKDrawableContainer) {
        ITVKVideoViewBase iTVKVideoViewBase;
        this.mLogger.info("api call : updatePlayerVideoView", new Object[0]);
        if (this.mDrawableContainer == iTVKDrawableContainer) {
            this.mLogger.warn("api call : updatePlayerVideoView, same video view, return", new Object[0]);
            return;
        }
        this.mDrawableContainer = iTVKDrawableContainer;
        ITVKAdManager iTVKAdManager = this.mAdManager;
        ViewGroup viewGroup = null;
        if (isVideoView(this.mDrawableContainer)) {
            iTVKVideoViewBase = (ITVKVideoViewBase) this.mDrawableContainer;
        } else {
            iTVKVideoViewBase = null;
        }
        iTVKAdManager.updatePlayerView(iTVKVideoViewBase);
        this.mAssetPlayer.updatePlayerVideoView(this.mDrawableContainer);
        TVKEventParams.UpdateVideoViewEventParam updateVideoViewEventParam = new TVKEventParams.UpdateVideoViewEventParam();
        if (isVideoView(this.mDrawableContainer)) {
            viewGroup = (ViewGroup) this.mDrawableContainer;
        }
        updateVideoViewEventParam.viewGroup = viewGroup;
        updateVideoViewEventParam.isUseSurfaceView = isUseSurfaceView();
        pushEvent(TVKEventId.PLAYER_STATE_UPDATE_VIEW, updateVideoViewEventParam);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @TVKThreadAnnotations.ThreadSwitch
    public void updateReportParam(TVKProperties tVKProperties) {
        this.mLogger.info("api call : updateReportParam", new Object[0]);
        TVKPlayerVideoInfo tVKPlayerVideoInfo = this.mPlayerVideoInfo;
        if (tVKPlayerVideoInfo != null) {
            tVKPlayerVideoInfo.setReportInfoProperties(tVKProperties);
            pushEvent(TVKEventId.PLAYER_STATE_UPDATE_REPORT_PARAM, null);
            this.mAssetPlayer.updateReportParam(tVKProperties);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @TVKThreadAnnotations.ThreadSwitch
    public void updateUserInfo(TVKUserInfo tVKUserInfo) {
        this.mLogger.info("api call : updateUserInfo", new Object[0]);
        this.mUserInfo = tVKUserInfo;
        this.mAdManager.updateUserInfo(tVKUserInfo);
        this.mAssetPlayer.updateUserInfo(tVKUserInfo);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @TVKThreadAnnotations.ThreadSwitch
    public void updateVrReportParam(TVKProperties tVKProperties) {
        this.mLogger.info("api call : updateVrReportParam", new Object[0]);
    }

    public TVKPlayerManager(Context context, ITVKDrawableContainer iTVKDrawableContainer, Looper looper) {
        TVKPluginManager tVKPluginManager = new TVKPluginManager();
        this.mPluginManager = tVKPluginManager;
        this.mAdIsDownloadDone = false;
        this.mIsPauseBeforeMidAdPlay = false;
        this.mIsPermissionTimeOut = false;
        this.mTimerTask = null;
        this.mIsOnePlayerNeedRestore = false;
        this.mHasPostPreparing = false;
        this.mHasPostPrepared = false;
        this.mIsPauseBySdkInternalAD = false;
        this.mNetVideoInfo = null;
        this.mHlsTagInfo = null;
        this.mPlayTimeMs = new AtomicLong(0L);
        this.mIsBuffering = false;
        this.mBasicInfoCollector = new TVKBasicPlayInfoCollector();
        TVKEventParams.InitPlayerParam initPlayerParam = new TVKEventParams.InitPlayerParam();
        initPlayerParam.initPlayerStartTimeMs = SystemClock.elapsedRealtime();
        AtomicInteger atomicInteger = sNumberOfUnreleasedPlayers;
        atomicInteger.incrementAndGet();
        TVKContext tVKContext = new TVKContext(context);
        this.mTVKContext = tVKContext;
        TVKLogger tVKLogger = new TVKLogger(tVKContext, "PlayerManager");
        this.mLogger = tVKLogger;
        tVKLogger.info("TVKPlayerManager create. Currently unreleased player(s)=" + atomicInteger.get(), new Object[0]);
        tVKLogger.info("api call : Create TVKPlayerManager: " + tVKContext.getInstanceID() + ", version: " + TVKVersion.getPlayerVersion(), new Object[0]);
        this.mDrawableContainer = iTVKDrawableContainer;
        this.mGlobalEventChangeListener = new TVKGlobalEventChangeListener();
        TVKGlobalEventNotifier.getInstance().addEventListener(this.mGlobalEventChangeListener);
        HandlerThread obtainHandleThread = TVKThreadPool.getInstance().obtainHandleThread(ITVKQQLiveAssetPlayer.TVK_PLAYER_THREAD_NAME, TVKMediaPlayerConfig.PlayerConfig.default_tvk_work_thread_priority);
        this.mHandlerThread = obtainHandleThread;
        Looper looper2 = obtainHandleThread.getLooper();
        this.mLooper = looper2;
        this.mEventHandler = new EventHandler(looper2);
        initConfigAndPluginAsync();
        initPlayerParam.initAssetPlayerStartTimeMs = SystemClock.elapsedRealtime();
        initAssetPlayer(looper);
        initPlayerParam.initAssetPlayerEndTimeMs = SystemClock.elapsedRealtime();
        TVKAdInnerListener tVKAdInnerListener = new TVKAdInnerListener();
        this.mAdListener = tVKAdInnerListener;
        TVKHookManager.hookAdListener(this, tVKAdInnerListener, this.mHookCallback);
        ITVKAdManager createAdManager = TVKAdFactory.createAdManager(tVKContext, isVideoView(this.mDrawableContainer) ? (ITVKVideoViewBase) this.mDrawableContainer : null, this.mAdListener, looper2);
        this.mAdManager = createAdManager;
        tVKPluginManager.loadPlugin(createAdManager);
        ITVKReportFactory reportFactory = TVKReportFactoryCreator.getReportFactory();
        if (reportFactory != null) {
            tVKPluginManager.loadPlugin(reportFactory.createQualityReport(tVKContext, ITVKReportFactory.QualityReportType.QUALITY_REPORT_DA_V));
        }
        tVKContext.getEventSender().registerObserver(this);
        if (TVKMediaPlayerConfig.PlayerConfig.enable_worker_thread_looper_hung_detection) {
            tVKLogger.info("register looper of worker thread " + obtainHandleThread + " to detector", new Object[0]);
            TVKLooperHungDetector.registerLooper(looper2, TVKMediaPlayerConfig.PlayerConfig.worker_thread_looper_hung_timeout_ms, new TVKLooperHungDetector.IOnLooperStunkCallback() { // from class: com.tencent.qqlive.tvkplayer.logic.a
                @Override // com.tencent.qqlive.tvkplayer.tools.utils.TVKLooperHungDetector.IOnLooperStunkCallback
                public final void onLooperStunk(String str) {
                    TVKPlayerManager.this.lambda$new$0(str);
                }
            });
        }
        initPlayerParam.initPlayerEndTimeMs = SystemClock.elapsedRealtime();
        pushEvent(10000, initPlayerParam);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @TVKThreadAnnotations.ThreadSwitch
    public void onClickPause(ViewGroup viewGroup) {
        ITVKLogger iTVKLogger = this.mLogger;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("api call : onClickPause, (parentViewGroup == null):");
        sb5.append(viewGroup == null);
        iTVKLogger.info(sb5.toString(), new Object[0]);
        pauseWithIsAllowShowPauseAd(true, viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pushEvent(int i3, Object obj) {
        pushEvent(i3, 0, 0, "", obj);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @TVKThreadAnnotations.ThreadSwitch
    public void setDisplayScale(float f16, float f17, float f18) {
        this.mLogger.info("api call : setDisplayScale, scale=" + f16 + ", anchorX:" + f17 + ", anchorY:" + f18, new Object[0]);
        this.mAssetPlayer.setDisplayScale(f16, f17, f18);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @TVKThreadAnnotations.ThreadSwitch
    public void setLoopback(boolean z16, long j3, long j16) {
        this.mLogger.info("api call : setLoopback:" + z16 + ", loopStartPositionMs:" + j3 + ", loopEndPositionMs:" + j16, new Object[0]);
        this.mAssetPlayer.setLoopback(z16, j3, j16);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void addTrack(int i3, String str, TVKPlayerVideoInfo tVKPlayerVideoInfo) throws IllegalArgumentException {
        this.mLogger.info("api call : addTrack , do nothing here", new Object[0]);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @TVKThreadAnnotations.ThreadSwitch(letCallerThreadWait = true)
    public void switchDefinition(TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo) throws IllegalStateException, IllegalArgumentException {
        String definition = tVKPlayerVideoInfo != null ? tVKPlayerVideoInfo.getDefinition() : "";
        this.mLogger.info("api call : switchDefinitionWithUserInfo, videoInfo, definition:" + definition, new Object[0]);
        printState();
        if (!invalidCallSwitchDefinition()) {
            this.mUserInfo = tVKUserInfo;
            this.mPlayerVideoInfo = tVKPlayerVideoInfo;
            this.mAssetPlayer.switchDefinition(tVKUserInfo, tVKPlayerVideoInfo);
            this.mAdManager.updateUserInfo(tVKUserInfo);
            this.mAdManager.updateDefinition(definition);
            return;
        }
        this.mLogger.warn("api call : switchDefinitionWithUserInfo, invalid api call", new Object[0]);
        throw new IllegalStateException("api call : switchDefinitionWithUserInfo, invalid api call");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class TVKPlayerListener implements ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener {
        TVKPlayerListener() {
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
        public long getAdvRemainTimeMs() {
            return TVKPlayerManager.this.mAdManager.getRemainTime(TVKPlayerManager.this.mAdManager.getAdType());
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
        public void onAudioFrameOut(TVKAudioFrameBuffer tVKAudioFrameBuffer) {
            TVKPlayerManager.this.mLogger.info("asset player callback : onAudioFrameOut", new Object[0]);
            TVKPlayerManager.this.mPlayerManagerCallBack.onAudioFrameOut(tVKAudioFrameBuffer);
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
        public void onCaptureImageFailed(int i3, int i16) {
            TVKPlayerManager.this.mLogger.info("asset player callback : onCaptureImageFailed", new Object[0]);
            TVKPlayerManager.this.mPlayerManagerCallBack.onCaptureImageFailed(TVKPlayerManager.this, i3, i16);
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
        public void onCaptureImageSucceed(int i3, int i16, int i17, Bitmap bitmap) {
            TVKPlayerManager.this.mLogger.info("asset player callback : onCaptureImageSucceed", new Object[0]);
            TVKPlayerManager.this.mPlayerManagerCallBack.onCaptureImageSucceed(TVKPlayerManager.this, i3, i16, i17, bitmap);
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
        public void onCompletion() {
            TVKPlayerManager.this.mLogger.info("asset player callback : onCompletion", new Object[0]);
            TVKPlayerManager.this.stopPositionTimer();
            TVKPlayerManager.this.pushEvent(TVKEventId.PLAYER_STATE_PLAY_COMPLETE, null);
            if (TVKPlayerManager.this.mAdManager.getAdType() != 3 || !ITVKAdCommons.isVideoAdActive(TVKPlayerManager.this.mAdManager.getAdState())) {
                TVKPlayerManager.this.exitPlaying();
                TVKPlayerManager.this.notifyOnCompletion();
            } else {
                TVKPlayerManager.this.mLogger.info("onCompletion, postroll ad is activated, wait callback", new Object[0]);
            }
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
        public void onDebugTrackingInfo(TPDebugTrackingInfo tPDebugTrackingInfo) {
            TVKPlayerManager.this.mLogger.info("asset player callback : onDebugTrackingInfo, type:" + tPDebugTrackingInfo.getTrackingInfoID(), new Object[0]);
            TVKPlayerManager.this.pushEvent(TVKEventId.PLAYER_STATE_DEBUG_TRACKING_INFO, tPDebugTrackingInfo);
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
        public boolean onError(TVKError tVKError) {
            TVKPlayerManager.this.mLogger.error("asset player callback : onError " + tVKError.toString(), new Object[0]);
            TVKPlayerManager.this.callOnErrorCB(tVKError);
            return false;
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
        public TVKUserInfo onGetUserInfo() {
            TVKPlayerManager.this.mLogger.info("asset player callback : onGetUserInfo", new Object[0]);
            TVKListenerManager tVKListenerManager = TVKPlayerManager.this.mLisMgr;
            TVKPlayerManager tVKPlayerManager = TVKPlayerManager.this;
            return tVKListenerManager.onGetUserInfo(tVKPlayerManager, tVKPlayerManager.mUserInfo);
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
        public boolean onInfo(int i3, long j3, long j16, Object obj) {
            if (i3 != 206 && i3 != 207 && i3 != 132) {
                TVKPlayerManager.this.mLogger.info("asset player callback : onInfo:" + TVKQQLiveAssetPlayerMsg.stringDefine(i3) + ", arg1:" + j3 + ", arg2:" + j16 + ", extra:" + obj, new Object[0]);
            }
            if (i3 == 536) {
                TVKPlayerManager.this.pushEvent(TVKEventId.PLAYER_STATE_PLAY_REOPEN_START, null);
            } else if (i3 == 537) {
                TVKPlayerManager.this.pushEvent(TVKEventId.PLAYER_STATE_PLAY_REOPEN_END, null);
            }
            if (!TVKAssetPlayerMsgMap.getMethodAndInvoke(TVKPlayerManager.class, i3, TVKPlayerManager.this, new TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams(i3, j3, j16, obj))) {
                TVKPlayerManager.this.mLogger.error("asset player callback : onInfo: " + TVKQQLiveAssetPlayerMsg.stringDefine(i3) + " not match deal method", new Object[0]);
            }
            return false;
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
        public void onLoopBackChanged() {
            TVKPlayerManager.this.mLogger.info("asset player callback : onLoopBackChanged", new Object[0]);
            TVKPlayerManager.this.mPlayerManagerCallBack.onLoopBackChanged(TVKPlayerManager.this);
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
        public void onNetVideoInfo(@NonNull TVKNetVideoInfo tVKNetVideoInfo) {
            TVKPlayerManager.this.mLogger.info("asset player callback : onNetVideoInfo", new Object[0]);
            if (!tVKNetVideoInfo.getAbTestInfo().isEmpty()) {
                TVKPlayerManager.this.handleAbTestInfo(new TVKQQLiveAssetPlayerMsg.TVKAssetPlayerMsgParams(212, 0L, 0L, tVKNetVideoInfo.getAbTestInfo()));
            }
            TVKPlayerManager.this.mNetVideoInfo = tVKNetVideoInfo;
            TVKPlayerManager.this.mPlayerManagerCallBack.onNetVideoInfo(TVKPlayerManager.this, tVKNetVideoInfo);
            TVKPlayerManager.this.mBasicInfoCollector.setNetVideoInfo(tVKNetVideoInfo);
            TVKPlayerManager.this.mLogger.info(TVKPlayerManager.this.mBasicInfoCollector.toString(), new Object[0]);
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
        public void onOriginalLogoPosition(int i3, int i16, int i17, int i18, boolean z16) {
            TVKPlayerManager.this.mLogger.info("asset player callback : onOriginalLogoPosition", new Object[0]);
            TVKPlayerManager.this.mPlayerManagerCallBack.onOriginalLogoPosition(TVKPlayerManager.this, i3, i16, i17, i18, z16);
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
        public void onPermissionTimeout() {
            TVKPlayerManager.this.mLogger.info("asset player callback : onPermissionTimeout", new Object[0]);
            TVKPlayerManager.this.mIsPermissionTimeOut = true;
            TVKPlayerManager.this.stopPositionTimer();
            TVKPlayerManager.this.pushEvent(TVKEventId.PLAYER_STATE_PLAY_COMPLETE, null);
            if (TVKPlayerManager.this.mAdManager.getAdType() != 3 || !ITVKAdCommons.isVideoAdActive(TVKPlayerManager.this.mAdManager.getAdState())) {
                TVKPlayerManager.this.exitPlaying();
                TVKPlayerManager.this.notifyPermissionTimeOut();
            } else {
                TVKPlayerManager.this.mLogger.info("onPermissionTimeout, postroll ad is activated, wait callback", new Object[0]);
            }
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
        public void onSeekComplete() {
            TVKPlayerManager.this.mLogger.info("asset player callback : onSeekComplete", new Object[0]);
            long currentPosition = TVKPlayerManager.this.mAssetPlayer.getCurrentPosition();
            TVKPlayerManager.this.mCurrentPositionMs = currentPosition;
            TVKPlayerManager.this.pushEvent(TVKEventId.PLAYER_STATE_SEEK_COMPLETE, Long.valueOf(currentPosition));
            TVKPlayerManager.this.mPlayerManagerCallBack.onSeekComplete(TVKPlayerManager.this);
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
        public void onStateChange(ITVKPlayerState iTVKPlayerState) {
            TVKPlayerManager.this.mLogger.info("asset player callback : asset player state change, state: " + iTVKPlayerState, new Object[0]);
            TVKPlayerManager.this.mAssetPlayerState = iTVKPlayerState;
            if (TVKPlayerManager.this.mAssetPlayerState.state() == ITVKPlayerState.STATE.CGING) {
                TVKPlayerManager.this.pushEvent(10006, null);
            } else if (TVKPlayerManager.this.mAssetPlayerState.state() == ITVKPlayerState.STATE.CGIED) {
                TVKPlayerManager.this.pushEvent(10007, null);
            }
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
        public void onVideoCGIed(TVKNetVideoInfo tVKNetVideoInfo) {
            TVKPlayerManager.this.mLogger.info("asset player callback : onVideoCGIed", new Object[0]);
            TVKPlayerManager.this.mPlayerManagerCallBack.onInfo(TVKPlayerManager.this, 34, Long.valueOf(System.currentTimeMillis()));
            if (tVKNetVideoInfo != null) {
                TVKPlayerManager.this.mPlayerManagerCallBack.onInfo(TVKPlayerManager.this, 26, Integer.valueOf(tVKNetVideoInfo.getDurationSec()));
                if (tVKNetVideoInfo instanceof TVKVodVideoInfo) {
                    TVKVodVideoInfo tVKVodVideoInfo = (TVKVodVideoInfo) tVKNetVideoInfo;
                    TVKPlayerManager.this.mPlayerManagerCallBack.onInfo(TVKPlayerManager.this, 51, String.valueOf(tVKVodVideoInfo.getFirstCdnId()));
                    TVKPlayerManager.this.mPlayerManagerCallBack.onInfo(TVKPlayerManager.this, 52, tVKVodVideoInfo.getFirstCdnHlsPlayUrl());
                    if (TextUtils.isEmpty(tVKVodVideoInfo.getVodLogoActionUrl())) {
                        TVKPlayerManager.this.mPlayerManagerCallBack.onInfo(TVKPlayerManager.this, 57, null);
                    }
                }
            }
            if (TVKPlayerManager.this.mAdManager.getAdType() != 1 || !ITVKAdCommons.isVideoAdActive(TVKPlayerManager.this.mAdManager.getAdState())) {
                TVKPlayerManager.this.prepareAssetPlayer();
                return;
            }
            TVKPlayerManager.this.mLogger.info("ad is processing , wait ad processing finish, continue", new Object[0]);
            if (TVKPlayerManager.this.mAdIsDownloadDone) {
                TVKPlayerManager.this.mLogger.info("ad is download done, prepare asset player", new Object[0]);
                TVKPlayerManager.this.prepareAssetPlayerWhenPreAdDownloaded();
            }
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
        public void onVideoFrameOut(TVKVideoFrameBuffer tVKVideoFrameBuffer) {
            TVKPlayerManager.this.mLogger.info("asset player callback : onVideoFrameOut", new Object[0]);
            TVKPlayerManager.this.mPlayerManagerCallBack.onVideoFrameOut(tVKVideoFrameBuffer);
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
        public void onVideoPrepared() {
            TVKPlayerManager.this.mLogger.info("asset player callback : onVideoPrepared", new Object[0]);
            TVKThreadPrioritySetter.reset();
            if (TVKPlayerManager.this.mIsOnePlayerNeedRestore && TVKMediaPlayerConfig.PlayerConfig.is_one_player_instance) {
                if (TVKPlayerManager.this.mIsPauseBeforeMidAdPlay) {
                    TVKPlayerManager.this.mAssetPlayer.pause();
                } else {
                    TVKPlayerManager.this.mAssetPlayer.start();
                }
                TVKPlayerManager.this.mLogger.info("asset player callback : onVideoPrepared event need not handle ", new Object[0]);
                TVKPlayerManager.this.mIsOnePlayerNeedRestore = false;
                return;
            }
            TVKEventParams.OnPreparedParam onPreparedParam = new TVKEventParams.OnPreparedParam();
            onPreparedParam.durationMs = TVKPlayerManager.this.mAssetPlayer.getDuration();
            TVKPlayerManager.this.pushEvent(10102, onPreparedParam);
            if (TVKPlayerManager.this.mAdManager.getAdType() != 1 || !ITVKAdCommons.isVideoAdActive(TVKPlayerManager.this.mAdManager.getAdState())) {
                TVKPlayerManager.this.mHasPostPrepared = true;
                if (TVKPlayerManager.this.mStateKeeperListener != null) {
                    TVKPlayerManager.this.mStateKeeperListener.onVideoPrepared(TVKPlayerManager.this);
                }
                TVKPlayerManager.this.mPlayerManagerCallBack.onVideoPrepared(TVKPlayerManager.this);
                return;
            }
            TVKPlayerManager.this.mLogger.info("ad is still processing, hold on video prepared notification", new Object[0]);
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
        public void onVideoPreparing() {
            TVKPlayerManager.this.mLogger.info("asset player callback : onVideoPreparing", new Object[0]);
            if (TVKPlayerManager.this.mIsOnePlayerNeedRestore && TVKMediaPlayerConfig.PlayerConfig.is_one_player_instance) {
                TVKPlayerManager.this.mLogger.info("asset player callback : onVideoPreparing event need not handle", new Object[0]);
            } else if (TVKPlayerManager.this.mAdManager.getAdType() != 1 || !ITVKAdCommons.isVideoAdActive(TVKPlayerManager.this.mAdManager.getAdState())) {
                TVKPlayerManager.this.mHasPostPreparing = true;
                TVKPlayerManager.this.mPlayerManagerCallBack.onVideoPreparing(TVKPlayerManager.this);
            } else {
                TVKPlayerManager.this.mLogger.info("ad is still processing, hold on  video preparing notification", new Object[0]);
            }
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
        public void onVideoSizeChanged(int i3, int i16) {
            ITVKDrawableContainer iTVKDrawableContainer;
            TVKPlayerManager.this.mLogger.info("asset player callback : onVideoSizeChanged, width:" + i3 + ", height:" + i16, new Object[0]);
            if (i3 > 0 && i16 > 0) {
                TVKPlayerManager tVKPlayerManager = TVKPlayerManager.this;
                if (tVKPlayerManager.isVideoView(tVKPlayerManager.mDrawableContainer)) {
                    iTVKDrawableContainer = TVKPlayerManager.this.mDrawableContainer;
                } else {
                    iTVKDrawableContainer = null;
                }
                tVKPlayerManager.pushEvent(TVKEventId.PLAYER_STATE_VIDEO_SIZE_CHANGE, i3, i16, "", iTVKDrawableContainer);
            }
            TVKPlayerManager.this.mPlayerManagerCallBack.onVideoSizeChanged(TVKPlayerManager.this, i3, i16);
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
        public void onSubtitleDataOut(TPSubtitleData tPSubtitleData) {
        }
    }
}
