package com.tencent.qqlive.tvkplayer.logic;

import android.content.Context;
import android.os.Looper;
import android.view.ViewGroup;
import com.tencent.qqlive.tvkplayer.ad.api.ITVKAdCommons;
import com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.api.render.ITVKDrawableContainer;
import com.tencent.qqlive.tvkplayer.logic.ITVKMediaPlayerPrivate;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;

/* loaded from: classes23.dex */
public class TVKStateKeeperPlayerManager extends TVKSyncPlayerManager {
    private static final int STATE_PAUSED = 2;
    private static final int STATE_PLAYING = 1;
    private static final int STATE_UNKNOWN = 0;
    private static final String TAG = "TVKStateKeeperPlayerManager";
    private volatile boolean mIsVideoPrepared;
    private final ITVKMediaPlayer.OnCompletionListener mOnCompletionListener;
    private final ITVKMediaPlayer.OnErrorListener mOnErrorListener;
    private final ITVKMediaPlayer.OnMidAdListener mOnMidAdListener;
    private final ITVKMediaPlayer.OnPostRollAdListener mOnPostRollAdListener;
    private final ITVKMediaPlayer.OnPreAdListener mOnPreAdListener;
    private final ITVKMediaPlayerPrivate mPlayerPrivate;
    private volatile int mPlayerState;

    /* loaded from: classes23.dex */
    private class StateKeeperListener implements ITVKMediaPlayerPrivate.ITVKStateKeeperListener {
        private static final String LOG_PREFIX_CALLBACK = "state keeper callback: ";

        StateKeeperListener() {
        }

        @Override // com.tencent.qqlive.tvkplayer.logic.ITVKMediaPlayerPrivate.ITVKStateKeeperListener
        public void onAdPlayComplete(int i3, Object obj) {
            TVKLogUtil.i(TVKStateKeeperPlayerManager.TAG, "state keeper callback: onAdPlayComplete, adType=" + ITVKAdCommons.adTypeString(i3) + " extra=" + obj);
            int i16 = 2;
            if (i3 != 2) {
                TVKStateKeeperPlayerManager.this.mPlayerState = 0;
            } else {
                boolean booleanValue = ((Boolean) obj).booleanValue();
                TVKStateKeeperPlayerManager tVKStateKeeperPlayerManager = TVKStateKeeperPlayerManager.this;
                if (!booleanValue) {
                    i16 = 1;
                }
                tVKStateKeeperPlayerManager.mPlayerState = i16;
            }
            TVKLogUtil.i(TVKStateKeeperPlayerManager.TAG, "onAdPlayComplete, adType=" + i3 + ", mPlayerState=" + TVKStateKeeperPlayerManager.this.mPlayerState);
        }

        @Override // com.tencent.qqlive.tvkplayer.logic.ITVKMediaPlayerPrivate.ITVKStateKeeperListener
        public void onAdPlayError(int i3, Object obj) {
            int i16 = 2;
            if (i3 != 2) {
                TVKStateKeeperPlayerManager.this.mPlayerState = 0;
            } else {
                boolean booleanValue = ((Boolean) obj).booleanValue();
                TVKStateKeeperPlayerManager tVKStateKeeperPlayerManager = TVKStateKeeperPlayerManager.this;
                if (!booleanValue) {
                    i16 = 1;
                }
                tVKStateKeeperPlayerManager.mPlayerState = i16;
            }
            TVKLogUtil.i(TVKStateKeeperPlayerManager.TAG, "onAdPlayError, adType=" + i3 + ", mPlayerState=" + TVKStateKeeperPlayerManager.this.mPlayerState);
        }

        @Override // com.tencent.qqlive.tvkplayer.logic.ITVKMediaPlayerPrivate.ITVKStateKeeperListener
        public void onAdRequestPauseVideo() {
            TVKLogUtil.i(TVKStateKeeperPlayerManager.TAG, "state keeper callback: onAdRequestPauseVideo");
            TVKStateKeeperPlayerManager.this.mPlayerState = 2;
        }

        @Override // com.tencent.qqlive.tvkplayer.logic.ITVKMediaPlayerPrivate.ITVKStateKeeperListener
        public void onAdRequestResumeVideo() {
            TVKLogUtil.i(TVKStateKeeperPlayerManager.TAG, "state keeper callback: onAdRequestResumeVideo");
            TVKStateKeeperPlayerManager.this.mPlayerState = 1;
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnVideoPreparedListener
        public void onVideoPrepared(ITVKMediaPlayer iTVKMediaPlayer) {
            TVKLogUtil.i(TVKStateKeeperPlayerManager.TAG, "state keeper callback: onVideoPrepared");
            TVKStateKeeperPlayerManager.this.mIsVideoPrepared = true;
        }
    }

    public TVKStateKeeperPlayerManager(Context context, ITVKDrawableContainer iTVKDrawableContainer, Looper looper) {
        super(context, iTVKDrawableContainer, looper);
        ITVKMediaPlayer.OnCompletionListener onCompletionListener = new ITVKMediaPlayer.OnCompletionListener() { // from class: com.tencent.qqlive.tvkplayer.logic.c
            @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnCompletionListener
            public final void onCompletion(ITVKMediaPlayer iTVKMediaPlayer) {
                TVKStateKeeperPlayerManager.this.lambda$new$0(iTVKMediaPlayer);
            }
        };
        this.mOnCompletionListener = onCompletionListener;
        ITVKMediaPlayer.OnErrorListener onErrorListener = new ITVKMediaPlayer.OnErrorListener() { // from class: com.tencent.qqlive.tvkplayer.logic.d
            @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnErrorListener
            public final boolean onError(ITVKMediaPlayer iTVKMediaPlayer, TVKError tVKError) {
                boolean lambda$new$1;
                lambda$new$1 = TVKStateKeeperPlayerManager.this.lambda$new$1(iTVKMediaPlayer, tVKError);
                return lambda$new$1;
            }
        };
        this.mOnErrorListener = onErrorListener;
        ITVKMediaPlayer.OnPreAdListener onPreAdListener = new ITVKMediaPlayer.OnPreAdListener() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKStateKeeperPlayerManager.1
            @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPreAdListener
            public void onPreAdFinish(ITVKMediaPlayer iTVKMediaPlayer) {
                TVKStateKeeperPlayerManager.this.mPlayerListeners.onPreAdFinish(iTVKMediaPlayer);
            }

            @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPreAdListener
            public void onPreAdPrepared(ITVKMediaPlayer iTVKMediaPlayer, long j3) {
                TVKLogUtil.i(TVKStateKeeperPlayerManager.TAG, "onPreAdPrepared");
                TVKStateKeeperPlayerManager.this.mPlayerState = 0;
                TVKStateKeeperPlayerManager.this.mPlayerListeners.onPreAdPrepared(iTVKMediaPlayer, j3);
            }

            @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPreAdListener
            public void onPreAdPreparing(ITVKMediaPlayer iTVKMediaPlayer) {
                TVKStateKeeperPlayerManager.this.mPlayerListeners.onPreAdPreparing(iTVKMediaPlayer);
            }
        };
        this.mOnPreAdListener = onPreAdListener;
        ITVKMediaPlayer.OnMidAdListener onMidAdListener = new ITVKMediaPlayer.OnMidAdListener() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKStateKeeperPlayerManager.2
            @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnMidAdListener
            public void onMidAdCountdown(ITVKMediaPlayer iTVKMediaPlayer, long j3) {
                TVKStateKeeperPlayerManager.this.mPlayerListeners.onMidAdCountdown(iTVKMediaPlayer, j3);
            }

            @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnMidAdListener
            public void onMidAdEndCountdown(ITVKMediaPlayer iTVKMediaPlayer, long j3) {
                TVKLogUtil.i(TVKStateKeeperPlayerManager.TAG, "onMidAdEndCountdown");
                TVKStateKeeperPlayerManager.this.mPlayerState = 0;
                TVKStateKeeperPlayerManager.this.mPlayerListeners.onMidAdEndCountdown(iTVKMediaPlayer, j3);
            }

            @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnMidAdListener
            public void onMidAdFinish(ITVKMediaPlayer iTVKMediaPlayer) {
                TVKStateKeeperPlayerManager.this.mPlayerListeners.onMidAdFinish(iTVKMediaPlayer);
            }

            @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnMidAdListener
            public void onMidAdStartCountdown(ITVKMediaPlayer iTVKMediaPlayer, long j3, long j16) {
                TVKStateKeeperPlayerManager.this.mPlayerListeners.onMidAdStartCountdown(iTVKMediaPlayer, j3, j16);
            }
        };
        this.mOnMidAdListener = onMidAdListener;
        ITVKMediaPlayer.OnPostRollAdListener onPostRollAdListener = new ITVKMediaPlayer.OnPostRollAdListener() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKStateKeeperPlayerManager.3
            @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPostRollAdListener
            public void onPostAdFinish(ITVKMediaPlayer iTVKMediaPlayer) {
                TVKStateKeeperPlayerManager.this.mPlayerListeners.onPostAdFinish(iTVKMediaPlayer);
            }

            @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPostRollAdListener
            public void onPostrollAdPrepared(ITVKMediaPlayer iTVKMediaPlayer, long j3) {
                TVKLogUtil.i(TVKStateKeeperPlayerManager.TAG, "onPostrollAdPrepared");
                TVKStateKeeperPlayerManager.this.mPlayerState = 0;
                TVKStateKeeperPlayerManager.this.mPlayerListeners.onPostrollAdPrepared(iTVKMediaPlayer, j3);
            }

            @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPostRollAdListener
            public void onPostrollAdPreparing(ITVKMediaPlayer iTVKMediaPlayer) {
                TVKStateKeeperPlayerManager.this.mPlayerListeners.onPostrollAdPreparing(iTVKMediaPlayer);
            }
        };
        this.mOnPostRollAdListener = onPostRollAdListener;
        ITVKMediaPlayerPrivate iTVKMediaPlayerPrivate = (ITVKMediaPlayerPrivate) this.mPlayer;
        this.mPlayerPrivate = iTVKMediaPlayerPrivate;
        iTVKMediaPlayerPrivate.setStateKeeperListener(new StateKeeperListener());
        this.mPlayer.setOnPreAdListener(onPreAdListener);
        this.mPlayer.setOnMidAdListener(onMidAdListener);
        this.mPlayer.setOnPostRollAdListener(onPostRollAdListener);
        this.mPlayer.setOnCompletionListener(onCompletionListener);
        this.mPlayer.setOnErrorListener(onErrorListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(ITVKMediaPlayer iTVKMediaPlayer) {
        TVKLogUtil.i(TAG, "onCompletion");
        resetFlag();
        this.mPlayerListeners.onCompletion(iTVKMediaPlayer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$1(ITVKMediaPlayer iTVKMediaPlayer, TVKError tVKError) {
        TVKLogUtil.i(TAG, "onError");
        resetFlag();
        this.mPlayerListeners.onError(iTVKMediaPlayer, tVKError);
        return false;
    }

    private void resetFlag() {
        TVKLogUtil.i(TAG, "resetFlag");
        this.mPlayerState = 0;
        this.mIsVideoPrepared = false;
    }

    private void setFlagCauseByPause() {
        if (this.mPlayerState == 1) {
            this.mPlayerState = 2;
            return;
        }
        TVKLogUtil.w(TAG, "setFlagCauseByPause, mPlayerState=" + this.mPlayerState);
    }

    @Override // com.tencent.qqlive.tvkplayer.logic.TVKSyncPlayerManager, com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public boolean isPaused() {
        if (this.mPlayerState == 2) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqlive.tvkplayer.logic.TVKSyncPlayerManager, com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public boolean isPlaying() {
        if (this.mPlayerPrivate.getAdState() == 6) {
            TVKLogUtil.i(TAG, "isPlaying, getAdState=AD_STATE_PLAYING, return true");
            return true;
        }
        if (this.mPlayerState == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqlive.tvkplayer.logic.TVKSyncPlayerManager, com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void onClickPause() {
        TVKLogUtil.i(TAG, "api call: onClickPause");
        super.onClickPause();
        setFlagCauseByPause();
    }

    @Override // com.tencent.qqlive.tvkplayer.logic.TVKSyncPlayerManager, com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void openMediaPlayer(Context context, TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo) {
        this.mPlayerPrivate.enablePlayerCallbackInterception(false);
        super.openMediaPlayer(context, tVKUserInfo, tVKPlayerVideoInfo);
    }

    @Override // com.tencent.qqlive.tvkplayer.logic.TVKSyncPlayerManager, com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void pause() {
        TVKLogUtil.i(TAG, "api call: pause");
        super.pause();
        setFlagCauseByPause();
    }

    @Override // com.tencent.qqlive.tvkplayer.logic.TVKSyncPlayerManager, com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void release() {
        TVKLogUtil.i(TAG, "api call: release");
        super.release();
        resetFlag();
    }

    @Override // com.tencent.qqlive.tvkplayer.logic.TVKSyncPlayerManager, com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void start() {
        TVKLogUtil.i(TAG, "api call: start, mIsVideoPrepared=" + this.mIsVideoPrepared + ", mPlayerState=" + this.mPlayerState);
        super.start();
        if (this.mPlayerState == 2) {
            this.mPlayerState = 1;
            return;
        }
        if (this.mPlayerPrivate.getAdState() == 5) {
            this.mPlayerState = 1;
            return;
        }
        if (this.mIsVideoPrepared) {
            this.mPlayerState = 1;
            return;
        }
        TVKLogUtil.w(TAG, "start, mPlayerState==" + this.mPlayerState + ", mPlayerPrivate.getAdState()=" + this.mPlayerPrivate.getAdState() + ", can not modify to playing");
    }

    @Override // com.tencent.qqlive.tvkplayer.logic.TVKSyncPlayerManager, com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void stop() {
        TVKLogUtil.i(TAG, "api call: stop");
        this.mPlayerPrivate.enablePlayerCallbackInterception(true);
        this.mPlayerPrivate.removePendingPlayerCallback();
        super.stop();
        resetFlag();
    }

    @Override // com.tencent.qqlive.tvkplayer.logic.TVKSyncPlayerManager, com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void onClickPause(ViewGroup viewGroup) {
        TVKLogUtil.i(TAG, "api call: onClickPause, parentViewGroup=" + viewGroup);
        super.onClickPause(viewGroup);
        setFlagCauseByPause();
    }
}
