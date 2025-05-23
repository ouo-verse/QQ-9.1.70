package com.tencent.qqlive.tvkplayer.logic;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.qqlive.tvkplayer.api.ITVKReportEventListener;
import com.tencent.qqlive.tvkplayer.api.TVKAudioFrameBuffer;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.TVKVideoFrameBuffer;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.context.TVKReportEventParamsInner;
import com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger;
import com.tencent.qqlive.tvkplayer.tools.log.TVKLogger;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes23.dex */
public class TVKPlayerManagerCallBack implements ITVKMediaPlayer.OnPreAdListener, ITVKMediaPlayer.OnMidAdListener, ITVKMediaPlayer.OnPostRollAdListener, ITVKMediaPlayer.OnAdClickedListener, ITVKMediaPlayer.OnScrollAdListener, ITVKMediaPlayer.OnAdCustomCommandListener, ITVKMediaPlayer.OnVideoPreparingListener, ITVKMediaPlayer.OnVideoPreparedListener, ITVKMediaPlayer.OnNetVideoInfoListener, ITVKMediaPlayer.OnCompletionListener, ITVKMediaPlayer.OnLoopBackChangedListener, ITVKMediaPlayer.OnPermissionTimeoutListener, ITVKMediaPlayer.OnSeekCompleteListener, ITVKMediaPlayer.OnCaptureImageListener, ITVKMediaPlayer.OnErrorListener, ITVKMediaPlayer.OnInfoListener, ITVKMediaPlayer.OnLogoPositionListener, ITVKMediaPlayer.OnVideoSizeChangedListener, ITVKMediaPlayer.OnVideoFrameOutListener, ITVKMediaPlayer.OnAudioFrameOutListener, ITVKPlayerEventListener, ITVKReportEventListener {
    private static final Set<Integer> MESSAGE_TO_BE_INTERCEPTED_SET = buildMessageToBeInterceptedSet();
    private static final String MODULE_NAME = "TVKPlayerManagerCallBack";
    private static final int ON_AD_EXIT_FULL_SCREEN_CLICK = 32;
    private static final int ON_AD_FULL_SCREEN_CLICK = 31;
    private static final int ON_AD_RETURN_CLICK = 29;
    private static final int ON_AD_SKIP_CLICK = 30;
    private static final int ON_AD_VOLUME_CHANGE = 43;
    private static final int ON_AD_WARNER_TIP_CLICK = 33;
    private static final int ON_CAPTURE_IMAGE_FAILED = 28;
    private static final int ON_CAPTURE_IMAGE_SUCCEED = 27;
    private static final int ON_COMPLETION = 23;
    private static final int ON_ENTER_VIP_TIP_CLICK = 34;
    private static final int ON_ERROR = 21;
    private static final int ON_FINISH_AD = 38;
    private static final int ON_INFO = 22;
    private static final int ON_INFO_NO_INTERCEPT = 46;
    private static final int ON_LANDING_VIEW_CLOSED = 35;
    private static final int ON_LANDING_VIEW_FAIL = 37;
    private static final int ON_LANDING_VIEW_WILL_PRESENT = 36;
    private static final int ON_LOOP_BACK_CHANGED = 24;
    private static final int ON_MID_AD_COUNTDOWN = 6;
    private static final int ON_MID_AD_END_COUNTDOWN = 7;
    private static final int ON_MID_AD_PLAY_COMPLETED = 8;
    private static final int ON_MID_AD_START_COUNTDOWN = 5;
    private static final int ON_NET_VIDEO_INFO = 20;
    private static final int ON_ORIGINAL_LOGO_POSITION = 41;
    private static final int ON_PERMISSION_TIMEOUT = 25;
    private static final int ON_PLAYER_EVENT = 44;
    private static final int ON_POSTROLL_AD_PREPARED = 12;
    private static final int ON_POSTROLL_AD_PREPARING = 11;
    private static final int ON_POST_AD_PLAY_COMPLETED = 13;
    private static final int ON_PRE_AD_PLAY_COMPLETED = 4;
    private static final int ON_PRE_AD_PREPARED = 2;
    private static final int ON_PRE_AD_PREPARING = 1;
    private static final int ON_REPORT_EVENT = 45;
    private static final int ON_SEEK_COMPLETE = 26;
    private static final int ON_SWITCH_AD = 39;
    private static final int ON_VIDEO_PREPARED = 19;
    private static final int ON_VIDEO_PREPARING = 18;
    private static final int ON_VIDEO_SIZE_CHANGED = 42;
    private final CallBackEventHandler mCallBackEventHandler;
    private final ITVKLogger mLogger;
    private final WeakReference<TVKListenerManager> mTVKListenerManagerWeakReference;
    private final WeakReference<ITVKMediaPlayer> mTVKPlayerManagerWeakReference;
    private final Map<Integer, MessageExecutor> mMessageHandler = new HashMap();
    private boolean mIsIntercepting = false;

    /* loaded from: classes23.dex */
    private class CallBackEventHandler extends Handler {
        CallBackEventHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            MessageExecutor messageExecutor = (MessageExecutor) TVKPlayerManagerCallBack.this.mMessageHandler.get(Integer.valueOf(message.what));
            if (messageExecutor != null) {
                messageExecutor.execute(message);
            }
        }

        public void sendEmptyMessageWithStateCheck(int i3) {
            if (TVKPlayerManagerCallBack.this.mIsIntercepting && TVKPlayerManagerCallBack.MESSAGE_TO_BE_INTERCEPTED_SET.contains(Integer.valueOf(i3))) {
                TVKPlayerManagerCallBack.this.mLogger.info("Message intercepted: " + i3, new Object[0]);
                return;
            }
            sendEmptyMessage(i3);
        }

        public void sendMessageWithStateCheck(Message message) {
            if (TVKPlayerManagerCallBack.this.mIsIntercepting && TVKPlayerManagerCallBack.MESSAGE_TO_BE_INTERCEPTED_SET.contains(Integer.valueOf(message.what))) {
                TVKPlayerManagerCallBack.this.mLogger.info("Message intercepted: " + message.what, new Object[0]);
                return;
            }
            sendMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes23.dex */
    public interface MessageExecutor {
        void execute(Message message);
    }

    /* loaded from: classes23.dex */
    private static class OnCaptureImageSucceedParams {
        Bitmap bitmap;
        int height;

        /* renamed from: id, reason: collision with root package name */
        int f345788id;
        int width;

        OnCaptureImageSucceedParams() {
        }
    }

    /* loaded from: classes23.dex */
    private static class OnOriginalLogoPositionParams {
        int heigth;
        boolean isShow;
        int width;
        int xAxis;
        int yAxis;

        OnOriginalLogoPositionParams() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public static class OnPlayerAdSkipClickParams {
        boolean isCopyRightForWarner;
        int skipType;

        OnPlayerAdSkipClickParams() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public static class OnPlayerEventParams {
        ITVKPlayerEventListener.EventParams eventParams;
        ITVKPlayerEventListener.PlayerEvent playerEvent;

        OnPlayerEventParams() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public static class OnReportEventParams {
        ITVKReportEventListener.ReportEvent reportEvent;
        ITVKReportEventListener.ReportEventParams reportEventParams;

        OnReportEventParams() {
        }
    }

    /* loaded from: classes23.dex */
    private static class OnSwitchAdParams {
        int adtype;
        Object item;
        Object linkageView;

        OnSwitchAdParams() {
        }
    }

    public TVKPlayerManagerCallBack(@NonNull TVKContext tVKContext, ITVKMediaPlayer iTVKMediaPlayer, TVKListenerManager tVKListenerManager, Looper looper) {
        TVKLogger tVKLogger = new TVKLogger(tVKContext, MODULE_NAME);
        this.mLogger = tVKLogger;
        this.mTVKPlayerManagerWeakReference = new WeakReference<>(iTVKMediaPlayer);
        this.mTVKListenerManagerWeakReference = new WeakReference<>(tVKListenerManager);
        if (looper != null) {
            tVKLogger.info("Call back to specified thread:  " + looper.getThread().getName(), new Object[0]);
            this.mCallBackEventHandler = new CallBackEventHandler(looper);
        } else {
            Looper myLooper = Looper.myLooper();
            if (myLooper != null) {
                tVKLogger.info("Call back to current thread:  " + myLooper.getThread().getName(), new Object[0]);
                this.mCallBackEventHandler = new CallBackEventHandler(myLooper);
            } else {
                tVKLogger.info("Call back to main thread", new Object[0]);
                this.mCallBackEventHandler = new CallBackEventHandler(Looper.getMainLooper());
            }
        }
        msgFunctionInit();
    }

    private static Set<Integer> buildMessageToBeInterceptedSet() {
        HashSet hashSet = new HashSet();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(4);
        hashSet.add(18);
        hashSet.add(22);
        hashSet.add(21);
        hashSet.add(20);
        hashSet.add(19);
        hashSet.add(24);
        hashSet.add(25);
        hashSet.add(26);
        hashSet.add(27);
        hashSet.add(28);
        hashSet.add(29);
        hashSet.add(30);
        hashSet.add(31);
        hashSet.add(32);
        hashSet.add(33);
        hashSet.add(34);
        hashSet.add(35);
        hashSet.add(36);
        hashSet.add(37);
        hashSet.add(39);
        hashSet.add(38);
        hashSet.add(41);
        hashSet.add(42);
        hashSet.add(43);
        hashSet.add(5);
        hashSet.add(6);
        hashSet.add(7);
        hashSet.add(8);
        hashSet.add(11);
        hashSet.add(12);
        hashSet.add(13);
        hashSet.add(23);
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnADVolumeChange(float f16) {
        ITVKMediaPlayer iTVKMediaPlayer = this.mTVKPlayerManagerWeakReference.get();
        TVKListenerManager tVKListenerManager = this.mTVKListenerManagerWeakReference.get();
        if (iTVKMediaPlayer != null && tVKListenerManager != null) {
            tVKListenerManager.onVolumeChange(iTVKMediaPlayer, f16);
        }
    }

    private Object handleOnAdCustomCommand(String str, Object obj) {
        ITVKMediaPlayer iTVKMediaPlayer = this.mTVKPlayerManagerWeakReference.get();
        TVKListenerManager tVKListenerManager = this.mTVKListenerManagerWeakReference.get();
        if (iTVKMediaPlayer != null && tVKListenerManager != null) {
            return tVKListenerManager.onAdCustomCommand(iTVKMediaPlayer, str, obj);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnAdExitFullScreenClick() {
        ITVKMediaPlayer iTVKMediaPlayer = this.mTVKPlayerManagerWeakReference.get();
        TVKListenerManager tVKListenerManager = this.mTVKListenerManagerWeakReference.get();
        if (iTVKMediaPlayer != null && tVKListenerManager != null) {
            tVKListenerManager.onAdExitFullScreenClick(iTVKMediaPlayer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnAdFullScreenClick() {
        ITVKMediaPlayer iTVKMediaPlayer = this.mTVKPlayerManagerWeakReference.get();
        TVKListenerManager tVKListenerManager = this.mTVKListenerManagerWeakReference.get();
        if (iTVKMediaPlayer != null && tVKListenerManager != null) {
            tVKListenerManager.onAdFullScreenClick(iTVKMediaPlayer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnAdReturnClick() {
        ITVKMediaPlayer iTVKMediaPlayer = this.mTVKPlayerManagerWeakReference.get();
        TVKListenerManager tVKListenerManager = this.mTVKListenerManagerWeakReference.get();
        if (iTVKMediaPlayer != null && tVKListenerManager != null) {
            tVKListenerManager.onAdReturnClick(iTVKMediaPlayer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnAdSkipClick(OnPlayerAdSkipClickParams onPlayerAdSkipClickParams) {
        ITVKMediaPlayer iTVKMediaPlayer = this.mTVKPlayerManagerWeakReference.get();
        TVKListenerManager tVKListenerManager = this.mTVKListenerManagerWeakReference.get();
        if (iTVKMediaPlayer != null && tVKListenerManager != null) {
            tVKListenerManager.onAdSkipClick(iTVKMediaPlayer, onPlayerAdSkipClickParams.isCopyRightForWarner, onPlayerAdSkipClickParams.skipType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnAdWarnerTipClick() {
        ITVKMediaPlayer iTVKMediaPlayer = this.mTVKPlayerManagerWeakReference.get();
        TVKListenerManager tVKListenerManager = this.mTVKListenerManagerWeakReference.get();
        if (iTVKMediaPlayer != null && tVKListenerManager != null) {
            tVKListenerManager.onAdWarnerTipClick(iTVKMediaPlayer);
        }
    }

    private void handleOnAudioFrameOut(TVKAudioFrameBuffer tVKAudioFrameBuffer) {
        ITVKMediaPlayer iTVKMediaPlayer = this.mTVKPlayerManagerWeakReference.get();
        TVKListenerManager tVKListenerManager = this.mTVKListenerManagerWeakReference.get();
        if (iTVKMediaPlayer != null && tVKListenerManager != null) {
            tVKListenerManager.onAudioFrameOut(tVKAudioFrameBuffer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnCaptureImageFailed(int i3, int i16) {
        ITVKMediaPlayer iTVKMediaPlayer = this.mTVKPlayerManagerWeakReference.get();
        TVKListenerManager tVKListenerManager = this.mTVKListenerManagerWeakReference.get();
        if (iTVKMediaPlayer != null && tVKListenerManager != null) {
            tVKListenerManager.onCaptureImageFailed(iTVKMediaPlayer, i3, i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnCaptureImageSucceed(int i3, int i16, int i17, Bitmap bitmap) {
        ITVKMediaPlayer iTVKMediaPlayer = this.mTVKPlayerManagerWeakReference.get();
        TVKListenerManager tVKListenerManager = this.mTVKListenerManagerWeakReference.get();
        if (iTVKMediaPlayer != null && tVKListenerManager != null) {
            tVKListenerManager.onCaptureImageSucceed(iTVKMediaPlayer, i3, i16, i17, bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnCompletion() {
        ITVKMediaPlayer iTVKMediaPlayer = this.mTVKPlayerManagerWeakReference.get();
        TVKListenerManager tVKListenerManager = this.mTVKListenerManagerWeakReference.get();
        if (iTVKMediaPlayer != null && tVKListenerManager != null) {
            tVKListenerManager.onCompletion(iTVKMediaPlayer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnEnterVipTipClick() {
        ITVKMediaPlayer iTVKMediaPlayer = this.mTVKPlayerManagerWeakReference.get();
        TVKListenerManager tVKListenerManager = this.mTVKListenerManagerWeakReference.get();
        if (iTVKMediaPlayer != null && tVKListenerManager != null) {
            tVKListenerManager.onEnterVipTipClick(iTVKMediaPlayer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleOnError(TVKError tVKError) {
        ITVKMediaPlayer iTVKMediaPlayer = this.mTVKPlayerManagerWeakReference.get();
        TVKListenerManager tVKListenerManager = this.mTVKListenerManagerWeakReference.get();
        if (iTVKMediaPlayer != null && tVKListenerManager != null) {
            return tVKListenerManager.onError(iTVKMediaPlayer, tVKError);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnFinishAd(int i3) {
        ITVKMediaPlayer iTVKMediaPlayer = this.mTVKPlayerManagerWeakReference.get();
        TVKListenerManager tVKListenerManager = this.mTVKListenerManagerWeakReference.get();
        if (iTVKMediaPlayer != null && tVKListenerManager != null) {
            tVKListenerManager.onFinishAd(iTVKMediaPlayer, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleOnInfo(int i3, Object obj) {
        ITVKMediaPlayer iTVKMediaPlayer = this.mTVKPlayerManagerWeakReference.get();
        TVKListenerManager tVKListenerManager = this.mTVKListenerManagerWeakReference.get();
        if (iTVKMediaPlayer != null && tVKListenerManager != null) {
            return tVKListenerManager.onInfo(iTVKMediaPlayer, i3, obj);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnLandingViewClosed() {
        ITVKMediaPlayer iTVKMediaPlayer = this.mTVKPlayerManagerWeakReference.get();
        TVKListenerManager tVKListenerManager = this.mTVKListenerManagerWeakReference.get();
        if (iTVKMediaPlayer != null && tVKListenerManager != null) {
            tVKListenerManager.onLandingViewClosed(iTVKMediaPlayer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnLandingViewFail() {
        ITVKMediaPlayer iTVKMediaPlayer = this.mTVKPlayerManagerWeakReference.get();
        TVKListenerManager tVKListenerManager = this.mTVKListenerManagerWeakReference.get();
        if (iTVKMediaPlayer != null && tVKListenerManager != null) {
            tVKListenerManager.onLandingViewFail(iTVKMediaPlayer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnLandingViewWillPresent() {
        ITVKMediaPlayer iTVKMediaPlayer = this.mTVKPlayerManagerWeakReference.get();
        TVKListenerManager tVKListenerManager = this.mTVKListenerManagerWeakReference.get();
        if (iTVKMediaPlayer != null && tVKListenerManager != null) {
            tVKListenerManager.onLandingViewWillPresent(iTVKMediaPlayer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnLoopBackChanged() {
        ITVKMediaPlayer iTVKMediaPlayer = this.mTVKPlayerManagerWeakReference.get();
        TVKListenerManager tVKListenerManager = this.mTVKListenerManagerWeakReference.get();
        if (iTVKMediaPlayer != null && tVKListenerManager != null) {
            tVKListenerManager.onLoopBackChanged(iTVKMediaPlayer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnMidAdCountdown(long j3) {
        ITVKMediaPlayer iTVKMediaPlayer = this.mTVKPlayerManagerWeakReference.get();
        TVKListenerManager tVKListenerManager = this.mTVKListenerManagerWeakReference.get();
        if (iTVKMediaPlayer != null && tVKListenerManager != null) {
            tVKListenerManager.onMidAdCountdown(iTVKMediaPlayer, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnMidAdEndCountdown(long j3) {
        ITVKMediaPlayer iTVKMediaPlayer = this.mTVKPlayerManagerWeakReference.get();
        TVKListenerManager tVKListenerManager = this.mTVKListenerManagerWeakReference.get();
        if (iTVKMediaPlayer != null && tVKListenerManager != null) {
            tVKListenerManager.onMidAdEndCountdown(iTVKMediaPlayer, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnMidAdPlayCompleted() {
        ITVKMediaPlayer iTVKMediaPlayer = this.mTVKPlayerManagerWeakReference.get();
        TVKListenerManager tVKListenerManager = this.mTVKListenerManagerWeakReference.get();
        if (iTVKMediaPlayer != null && tVKListenerManager != null) {
            tVKListenerManager.onMidAdFinish(iTVKMediaPlayer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnMidAdStartCountdown(long j3, long j16) {
        ITVKMediaPlayer iTVKMediaPlayer = this.mTVKPlayerManagerWeakReference.get();
        TVKListenerManager tVKListenerManager = this.mTVKListenerManagerWeakReference.get();
        if (iTVKMediaPlayer != null && tVKListenerManager != null) {
            tVKListenerManager.onMidAdStartCountdown(iTVKMediaPlayer, j3, j16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnNetVideoInfo(TVKNetVideoInfo tVKNetVideoInfo) {
        ITVKMediaPlayer iTVKMediaPlayer = this.mTVKPlayerManagerWeakReference.get();
        TVKListenerManager tVKListenerManager = this.mTVKListenerManagerWeakReference.get();
        if (iTVKMediaPlayer != null && tVKListenerManager != null) {
            tVKListenerManager.onNetVideoInfo(iTVKMediaPlayer, tVKNetVideoInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnOriginalLogoPosition(int i3, int i16, int i17, int i18, boolean z16) {
        ITVKMediaPlayer iTVKMediaPlayer = this.mTVKPlayerManagerWeakReference.get();
        TVKListenerManager tVKListenerManager = this.mTVKListenerManagerWeakReference.get();
        if (iTVKMediaPlayer != null && tVKListenerManager != null) {
            tVKListenerManager.onOriginalLogoPosition(iTVKMediaPlayer, i3, i16, i17, i18, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnPermissionTimeout() {
        ITVKMediaPlayer iTVKMediaPlayer = this.mTVKPlayerManagerWeakReference.get();
        TVKListenerManager tVKListenerManager = this.mTVKListenerManagerWeakReference.get();
        if (iTVKMediaPlayer != null && tVKListenerManager != null) {
            tVKListenerManager.onPermissionTimeout(iTVKMediaPlayer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnPlayerEvent(OnPlayerEventParams onPlayerEventParams) {
        ITVKMediaPlayer iTVKMediaPlayer = this.mTVKPlayerManagerWeakReference.get();
        TVKListenerManager tVKListenerManager = this.mTVKListenerManagerWeakReference.get();
        if (iTVKMediaPlayer != null && tVKListenerManager != null) {
            tVKListenerManager.onPlayerEvent(iTVKMediaPlayer, onPlayerEventParams.playerEvent, onPlayerEventParams.eventParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnPostAdPlayCompleted() {
        ITVKMediaPlayer iTVKMediaPlayer = this.mTVKPlayerManagerWeakReference.get();
        TVKListenerManager tVKListenerManager = this.mTVKListenerManagerWeakReference.get();
        if (iTVKMediaPlayer != null && tVKListenerManager != null) {
            tVKListenerManager.onPostAdFinish(iTVKMediaPlayer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnPostrollAdPrepared(long j3) {
        ITVKMediaPlayer iTVKMediaPlayer = this.mTVKPlayerManagerWeakReference.get();
        TVKListenerManager tVKListenerManager = this.mTVKListenerManagerWeakReference.get();
        if (iTVKMediaPlayer != null && tVKListenerManager != null) {
            tVKListenerManager.onPostrollAdPrepared(iTVKMediaPlayer, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnPostrollAdPreparing() {
        ITVKMediaPlayer iTVKMediaPlayer = this.mTVKPlayerManagerWeakReference.get();
        TVKListenerManager tVKListenerManager = this.mTVKListenerManagerWeakReference.get();
        if (iTVKMediaPlayer != null && tVKListenerManager != null) {
            tVKListenerManager.onPostrollAdPreparing(iTVKMediaPlayer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnPreAdPlayCompleted() {
        ITVKMediaPlayer iTVKMediaPlayer = this.mTVKPlayerManagerWeakReference.get();
        TVKListenerManager tVKListenerManager = this.mTVKListenerManagerWeakReference.get();
        if (iTVKMediaPlayer != null && tVKListenerManager != null) {
            tVKListenerManager.onPreAdFinish(iTVKMediaPlayer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnPreAdPrepared(long j3) {
        ITVKMediaPlayer iTVKMediaPlayer = this.mTVKPlayerManagerWeakReference.get();
        TVKListenerManager tVKListenerManager = this.mTVKListenerManagerWeakReference.get();
        if (iTVKMediaPlayer != null && tVKListenerManager != null) {
            tVKListenerManager.onPreAdPrepared(iTVKMediaPlayer, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnPreAdPreparing() {
        ITVKMediaPlayer iTVKMediaPlayer = this.mTVKPlayerManagerWeakReference.get();
        TVKListenerManager tVKListenerManager = this.mTVKListenerManagerWeakReference.get();
        if (iTVKMediaPlayer != null && tVKListenerManager != null) {
            tVKListenerManager.onPreAdPreparing(iTVKMediaPlayer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnReportEvent(OnReportEventParams onReportEventParams) {
        ITVKMediaPlayer iTVKMediaPlayer = this.mTVKPlayerManagerWeakReference.get();
        TVKListenerManager tVKListenerManager = this.mTVKListenerManagerWeakReference.get();
        if (iTVKMediaPlayer != null && tVKListenerManager != null) {
            tVKListenerManager.onReportEvent(iTVKMediaPlayer, onReportEventParams.reportEvent, onReportEventParams.reportEventParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnSeekComplete() {
        ITVKMediaPlayer iTVKMediaPlayer = this.mTVKPlayerManagerWeakReference.get();
        TVKListenerManager tVKListenerManager = this.mTVKListenerManagerWeakReference.get();
        if (iTVKMediaPlayer != null && tVKListenerManager != null) {
            tVKListenerManager.onSeekComplete(iTVKMediaPlayer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnSwitchAd(int i3, Object obj, Object obj2) {
        ITVKMediaPlayer iTVKMediaPlayer = this.mTVKPlayerManagerWeakReference.get();
        TVKListenerManager tVKListenerManager = this.mTVKListenerManagerWeakReference.get();
        if (iTVKMediaPlayer != null && tVKListenerManager != null) {
            tVKListenerManager.onSwitchAd(iTVKMediaPlayer, i3, obj, obj2);
        }
    }

    private void handleOnVideoOutputFrame(TVKVideoFrameBuffer tVKVideoFrameBuffer) {
        ITVKMediaPlayer iTVKMediaPlayer = this.mTVKPlayerManagerWeakReference.get();
        TVKListenerManager tVKListenerManager = this.mTVKListenerManagerWeakReference.get();
        if (iTVKMediaPlayer != null && tVKListenerManager != null) {
            tVKListenerManager.onVideoFrameOut(tVKVideoFrameBuffer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnVideoPrepared() {
        ITVKMediaPlayer iTVKMediaPlayer = this.mTVKPlayerManagerWeakReference.get();
        TVKListenerManager tVKListenerManager = this.mTVKListenerManagerWeakReference.get();
        this.mLogger.info("handleOnVideoPrepared: mediaPlayer = " + iTVKMediaPlayer + "; listenerManager = " + tVKListenerManager, new Object[0]);
        if (iTVKMediaPlayer != null && tVKListenerManager != null) {
            tVKListenerManager.onReportEvent(iTVKMediaPlayer, ITVKReportEventListener.ReportEvent.TVK_REPORT_EVENT_PLAYER_ON_PREPARED_CHANGED_THREAD_TO_APP_THREAD, new TVKReportEventParamsInner.Builder().build());
            tVKListenerManager.onVideoPrepared(iTVKMediaPlayer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnVideoPreparing() {
        ITVKMediaPlayer iTVKMediaPlayer = this.mTVKPlayerManagerWeakReference.get();
        TVKListenerManager tVKListenerManager = this.mTVKListenerManagerWeakReference.get();
        this.mLogger.info("handleOnVideoPreparing: mediaPlayer = " + iTVKMediaPlayer + "; listenerManager = " + tVKListenerManager, new Object[0]);
        if (iTVKMediaPlayer != null && tVKListenerManager != null) {
            tVKListenerManager.onVideoPreparing(iTVKMediaPlayer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnVideoSizeChanged(int i3, int i16) {
        ITVKMediaPlayer iTVKMediaPlayer = this.mTVKPlayerManagerWeakReference.get();
        TVKListenerManager tVKListenerManager = this.mTVKListenerManagerWeakReference.get();
        if (iTVKMediaPlayer != null && tVKListenerManager != null) {
            tVKListenerManager.onVideoSizeChanged(iTVKMediaPlayer, i3, i16);
        }
    }

    private void msgFunctionInit() {
        this.mMessageHandler.put(1, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.1
            @Override // com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.MessageExecutor
            public void execute(Message message) {
                TVKPlayerManagerCallBack.this.handleOnPreAdPreparing();
            }
        });
        this.mMessageHandler.put(2, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.2
            @Override // com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.MessageExecutor
            public void execute(Message message) {
                TVKPlayerManagerCallBack.this.handleOnPreAdPrepared(((Long) message.obj).longValue());
            }
        });
        this.mMessageHandler.put(4, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.3
            @Override // com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.MessageExecutor
            public void execute(Message message) {
                TVKPlayerManagerCallBack.this.handleOnPreAdPlayCompleted();
            }
        });
        this.mMessageHandler.put(5, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.4
            @Override // com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.MessageExecutor
            public void execute(Message message) {
                TVKPlayerManagerCallBack.this.handleOnMidAdStartCountdown(message.arg1, message.arg2);
            }
        });
        this.mMessageHandler.put(6, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.5
            @Override // com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.MessageExecutor
            public void execute(Message message) {
                TVKPlayerManagerCallBack.this.handleOnMidAdCountdown(((Long) message.obj).longValue());
            }
        });
        this.mMessageHandler.put(7, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.6
            @Override // com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.MessageExecutor
            public void execute(Message message) {
                TVKPlayerManagerCallBack.this.handleOnMidAdEndCountdown(((Long) message.obj).longValue());
            }
        });
        this.mMessageHandler.put(8, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.7
            @Override // com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.MessageExecutor
            public void execute(Message message) {
                TVKPlayerManagerCallBack.this.handleOnMidAdPlayCompleted();
            }
        });
        this.mMessageHandler.put(11, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.8
            @Override // com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.MessageExecutor
            public void execute(Message message) {
                TVKPlayerManagerCallBack.this.handleOnPostrollAdPreparing();
            }
        });
        this.mMessageHandler.put(12, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.9
            @Override // com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.MessageExecutor
            public void execute(Message message) {
                TVKPlayerManagerCallBack.this.handleOnPostrollAdPrepared(((Long) message.obj).longValue());
            }
        });
        this.mMessageHandler.put(13, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.10
            @Override // com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.MessageExecutor
            public void execute(Message message) {
                TVKPlayerManagerCallBack.this.handleOnPostAdPlayCompleted();
            }
        });
        this.mMessageHandler.put(18, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.11
            @Override // com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.MessageExecutor
            public void execute(Message message) {
                TVKPlayerManagerCallBack.this.handleOnVideoPreparing();
            }
        });
        this.mMessageHandler.put(19, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.12
            @Override // com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.MessageExecutor
            public void execute(Message message) {
                TVKPlayerManagerCallBack.this.handleOnVideoPrepared();
            }
        });
        this.mMessageHandler.put(20, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.13
            @Override // com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.MessageExecutor
            public void execute(Message message) {
                TVKPlayerManagerCallBack.this.handleOnNetVideoInfo((TVKNetVideoInfo) message.obj);
            }
        });
        this.mMessageHandler.put(21, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.14
            @Override // com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.MessageExecutor
            public void execute(Message message) {
                TVKPlayerManagerCallBack.this.handleOnError((TVKError) message.obj);
            }
        });
        this.mMessageHandler.put(22, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.15
            @Override // com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.MessageExecutor
            public void execute(Message message) {
                TVKPlayerManagerCallBack.this.handleOnInfo(message.arg1, message.obj);
            }
        });
        this.mMessageHandler.put(23, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.16
            @Override // com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.MessageExecutor
            public void execute(Message message) {
                TVKPlayerManagerCallBack.this.handleOnCompletion();
            }
        });
        this.mMessageHandler.put(24, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.17
            @Override // com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.MessageExecutor
            public void execute(Message message) {
                TVKPlayerManagerCallBack.this.handleOnLoopBackChanged();
            }
        });
        this.mMessageHandler.put(25, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.18
            @Override // com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.MessageExecutor
            public void execute(Message message) {
                TVKPlayerManagerCallBack.this.handleOnPermissionTimeout();
            }
        });
        this.mMessageHandler.put(26, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.19
            @Override // com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.MessageExecutor
            public void execute(Message message) {
                TVKPlayerManagerCallBack.this.handleOnSeekComplete();
            }
        });
        this.mMessageHandler.put(27, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.20
            @Override // com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.MessageExecutor
            public void execute(Message message) {
                OnCaptureImageSucceedParams onCaptureImageSucceedParams = (OnCaptureImageSucceedParams) message.obj;
                TVKPlayerManagerCallBack.this.handleOnCaptureImageSucceed(onCaptureImageSucceedParams.f345788id, onCaptureImageSucceedParams.width, onCaptureImageSucceedParams.height, onCaptureImageSucceedParams.bitmap);
            }
        });
        this.mMessageHandler.put(28, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.21
            @Override // com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.MessageExecutor
            public void execute(Message message) {
                TVKPlayerManagerCallBack.this.handleOnCaptureImageFailed(message.arg1, message.arg2);
            }
        });
        this.mMessageHandler.put(29, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.22
            @Override // com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.MessageExecutor
            public void execute(Message message) {
                TVKPlayerManagerCallBack.this.handleOnAdReturnClick();
            }
        });
        this.mMessageHandler.put(30, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.23
            @Override // com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.MessageExecutor
            public void execute(Message message) {
                TVKPlayerManagerCallBack.this.handleOnAdSkipClick((OnPlayerAdSkipClickParams) message.obj);
            }
        });
        this.mMessageHandler.put(31, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.24
            @Override // com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.MessageExecutor
            public void execute(Message message) {
                TVKPlayerManagerCallBack.this.handleOnAdFullScreenClick();
            }
        });
        this.mMessageHandler.put(32, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.25
            @Override // com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.MessageExecutor
            public void execute(Message message) {
                TVKPlayerManagerCallBack.this.handleOnAdExitFullScreenClick();
            }
        });
        this.mMessageHandler.put(33, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.26
            @Override // com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.MessageExecutor
            public void execute(Message message) {
                TVKPlayerManagerCallBack.this.handleOnAdWarnerTipClick();
            }
        });
        this.mMessageHandler.put(34, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.27
            @Override // com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.MessageExecutor
            public void execute(Message message) {
                TVKPlayerManagerCallBack.this.handleOnEnterVipTipClick();
            }
        });
        this.mMessageHandler.put(35, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.28
            @Override // com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.MessageExecutor
            public void execute(Message message) {
                TVKPlayerManagerCallBack.this.handleOnLandingViewClosed();
            }
        });
        this.mMessageHandler.put(36, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.29
            @Override // com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.MessageExecutor
            public void execute(Message message) {
                TVKPlayerManagerCallBack.this.handleOnLandingViewWillPresent();
            }
        });
        this.mMessageHandler.put(37, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.30
            @Override // com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.MessageExecutor
            public void execute(Message message) {
                TVKPlayerManagerCallBack.this.handleOnLandingViewFail();
            }
        });
        this.mMessageHandler.put(38, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.31
            @Override // com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.MessageExecutor
            public void execute(Message message) {
                TVKPlayerManagerCallBack.this.handleOnFinishAd(message.arg1);
            }
        });
        this.mMessageHandler.put(39, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.32
            @Override // com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.MessageExecutor
            public void execute(Message message) {
                OnSwitchAdParams onSwitchAdParams = (OnSwitchAdParams) message.obj;
                TVKPlayerManagerCallBack.this.handleOnSwitchAd(onSwitchAdParams.adtype, onSwitchAdParams.item, onSwitchAdParams.linkageView);
            }
        });
        this.mMessageHandler.put(41, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.33
            @Override // com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.MessageExecutor
            public void execute(Message message) {
                OnOriginalLogoPositionParams onOriginalLogoPositionParams = (OnOriginalLogoPositionParams) message.obj;
                TVKPlayerManagerCallBack.this.handleOnOriginalLogoPosition(onOriginalLogoPositionParams.xAxis, onOriginalLogoPositionParams.yAxis, onOriginalLogoPositionParams.heigth, onOriginalLogoPositionParams.width, onOriginalLogoPositionParams.isShow);
            }
        });
        this.mMessageHandler.put(42, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.34
            @Override // com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.MessageExecutor
            public void execute(Message message) {
                TVKPlayerManagerCallBack.this.handleOnVideoSizeChanged(message.arg1, message.arg2);
            }
        });
        this.mMessageHandler.put(43, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.35
            @Override // com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.MessageExecutor
            public void execute(Message message) {
                TVKPlayerManagerCallBack.this.handleOnADVolumeChange(((Float) message.obj).floatValue());
            }
        });
        this.mMessageHandler.put(44, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.36
            @Override // com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.MessageExecutor
            public void execute(Message message) {
                TVKPlayerManagerCallBack.this.handleOnPlayerEvent((OnPlayerEventParams) message.obj);
            }
        });
        this.mMessageHandler.put(45, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.37
            @Override // com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.MessageExecutor
            public void execute(Message message) {
                TVKPlayerManagerCallBack.this.handleOnReportEvent((OnReportEventParams) message.obj);
            }
        });
        this.mMessageHandler.put(46, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.38
            @Override // com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerCallBack.MessageExecutor
            public void execute(Message message) {
                TVKPlayerManagerCallBack.this.handleOnInfo(message.arg1, message.obj);
            }
        });
    }

    public void enableCallbackInterception(boolean z16) {
        this.mIsIntercepting = z16;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdCustomCommandListener
    public Object onAdCustomCommand(ITVKMediaPlayer iTVKMediaPlayer, String str, Object obj) {
        return handleOnAdCustomCommand(str, obj);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
    public void onAdExitFullScreenClick(ITVKMediaPlayer iTVKMediaPlayer) {
        this.mCallBackEventHandler.sendEmptyMessageWithStateCheck(32);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
    public void onAdFullScreenClick(ITVKMediaPlayer iTVKMediaPlayer) {
        this.mCallBackEventHandler.sendEmptyMessageWithStateCheck(31);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
    public void onAdReturnClick(ITVKMediaPlayer iTVKMediaPlayer) {
        this.mCallBackEventHandler.sendEmptyMessageWithStateCheck(29);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
    public void onAdSkipClick(ITVKMediaPlayer iTVKMediaPlayer, boolean z16, int i3) {
        OnPlayerAdSkipClickParams onPlayerAdSkipClickParams = new OnPlayerAdSkipClickParams();
        onPlayerAdSkipClickParams.isCopyRightForWarner = z16;
        onPlayerAdSkipClickParams.skipType = i3;
        this.mCallBackEventHandler.sendMessageWithStateCheck(Message.obtain(this.mCallBackEventHandler, 30, 0, 0, onPlayerAdSkipClickParams));
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
    public void onAdWarnerTipClick(ITVKMediaPlayer iTVKMediaPlayer) {
        this.mCallBackEventHandler.sendEmptyMessageWithStateCheck(33);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAudioFrameOutListener
    public void onAudioFrameOut(TVKAudioFrameBuffer tVKAudioFrameBuffer) {
        handleOnAudioFrameOut(tVKAudioFrameBuffer);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnCaptureImageListener
    public void onCaptureImageFailed(ITVKMediaPlayer iTVKMediaPlayer, int i3, int i16) {
        this.mCallBackEventHandler.sendMessageWithStateCheck(Message.obtain(this.mCallBackEventHandler, 28, i3, i16));
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnCaptureImageListener
    public void onCaptureImageSucceed(ITVKMediaPlayer iTVKMediaPlayer, int i3, int i16, int i17, Bitmap bitmap) {
        OnCaptureImageSucceedParams onCaptureImageSucceedParams = new OnCaptureImageSucceedParams();
        onCaptureImageSucceedParams.f345788id = i3;
        onCaptureImageSucceedParams.width = i16;
        onCaptureImageSucceedParams.height = i17;
        onCaptureImageSucceedParams.bitmap = bitmap;
        this.mCallBackEventHandler.sendMessageWithStateCheck(Message.obtain(this.mCallBackEventHandler, 27, 0, 0, onCaptureImageSucceedParams));
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnCompletionListener
    public void onCompletion(ITVKMediaPlayer iTVKMediaPlayer) {
        this.mCallBackEventHandler.sendMessageWithStateCheck(Message.obtain(this.mCallBackEventHandler, 23, 0, 0, null));
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
    public void onEnterVipTipClick(ITVKMediaPlayer iTVKMediaPlayer) {
        this.mCallBackEventHandler.sendEmptyMessageWithStateCheck(34);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnErrorListener
    public boolean onError(ITVKMediaPlayer iTVKMediaPlayer, TVKError tVKError) {
        this.mCallBackEventHandler.sendMessageWithStateCheck(Message.obtain(this.mCallBackEventHandler, 21, tVKError));
        return true;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnScrollAdListener
    public void onFinishAd(ITVKMediaPlayer iTVKMediaPlayer, int i3) {
        this.mCallBackEventHandler.sendMessageWithStateCheck(Message.obtain(this.mCallBackEventHandler, 38, i3, 0));
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnInfoListener
    public boolean onInfo(ITVKMediaPlayer iTVKMediaPlayer, int i3, Object obj) {
        Message obtain;
        if (i3 != 93 && i3 != 99) {
            obtain = Message.obtain(this.mCallBackEventHandler, 22, i3, 0, obj);
        } else {
            obtain = Message.obtain(this.mCallBackEventHandler, 46, i3, 0, obj);
        }
        this.mCallBackEventHandler.sendMessageWithStateCheck(obtain);
        return true;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
    public void onLandingViewClosed(ITVKMediaPlayer iTVKMediaPlayer) {
        this.mCallBackEventHandler.sendEmptyMessageWithStateCheck(35);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
    public void onLandingViewFail(ITVKMediaPlayer iTVKMediaPlayer) {
        this.mCallBackEventHandler.sendEmptyMessageWithStateCheck(37);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
    public void onLandingViewWillPresent(ITVKMediaPlayer iTVKMediaPlayer) {
        this.mCallBackEventHandler.sendEmptyMessageWithStateCheck(36);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnLoopBackChangedListener
    public void onLoopBackChanged(ITVKMediaPlayer iTVKMediaPlayer) {
        this.mCallBackEventHandler.sendMessageWithStateCheck(Message.obtain(this.mCallBackEventHandler, 24, 0, 0, null));
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnMidAdListener
    public void onMidAdCountdown(ITVKMediaPlayer iTVKMediaPlayer, long j3) {
        this.mCallBackEventHandler.sendMessageWithStateCheck(Message.obtain(this.mCallBackEventHandler, 6, Long.valueOf(j3)));
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnMidAdListener
    public void onMidAdEndCountdown(ITVKMediaPlayer iTVKMediaPlayer, long j3) {
        this.mCallBackEventHandler.sendMessageWithStateCheck(Message.obtain(this.mCallBackEventHandler, 7, Long.valueOf(j3)));
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnMidAdListener
    public void onMidAdFinish(ITVKMediaPlayer iTVKMediaPlayer) {
        this.mCallBackEventHandler.sendEmptyMessageWithStateCheck(8);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnMidAdListener
    public void onMidAdStartCountdown(ITVKMediaPlayer iTVKMediaPlayer, long j3, long j16) {
        this.mCallBackEventHandler.sendMessageWithStateCheck(Message.obtain(this.mCallBackEventHandler, 5, (int) j3, (int) j16));
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnNetVideoInfoListener
    public void onNetVideoInfo(ITVKMediaPlayer iTVKMediaPlayer, TVKNetVideoInfo tVKNetVideoInfo) {
        this.mCallBackEventHandler.sendMessageWithStateCheck(Message.obtain(this.mCallBackEventHandler, 20, tVKNetVideoInfo));
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnLogoPositionListener
    public void onOriginalLogoPosition(ITVKMediaPlayer iTVKMediaPlayer, int i3, int i16, int i17, int i18, boolean z16) {
        OnOriginalLogoPositionParams onOriginalLogoPositionParams = new OnOriginalLogoPositionParams();
        onOriginalLogoPositionParams.xAxis = i3;
        onOriginalLogoPositionParams.yAxis = i16;
        onOriginalLogoPositionParams.heigth = i17;
        onOriginalLogoPositionParams.width = i18;
        onOriginalLogoPositionParams.isShow = z16;
        this.mCallBackEventHandler.sendMessageWithStateCheck(Message.obtain(this.mCallBackEventHandler, 41, onOriginalLogoPositionParams));
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPermissionTimeoutListener
    public void onPermissionTimeout(ITVKMediaPlayer iTVKMediaPlayer) {
        this.mCallBackEventHandler.sendEmptyMessageWithStateCheck(25);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener
    public void onPlayerEvent(ITVKMediaPlayer iTVKMediaPlayer, ITVKPlayerEventListener.PlayerEvent playerEvent, ITVKPlayerEventListener.EventParams eventParams) {
        OnPlayerEventParams onPlayerEventParams = new OnPlayerEventParams();
        onPlayerEventParams.playerEvent = playerEvent;
        onPlayerEventParams.eventParams = eventParams;
        this.mCallBackEventHandler.sendMessageWithStateCheck(Message.obtain(this.mCallBackEventHandler, 44, onPlayerEventParams));
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPostRollAdListener
    public void onPostAdFinish(ITVKMediaPlayer iTVKMediaPlayer) {
        this.mCallBackEventHandler.sendEmptyMessageWithStateCheck(13);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPostRollAdListener
    public void onPostrollAdPrepared(ITVKMediaPlayer iTVKMediaPlayer, long j3) {
        this.mCallBackEventHandler.sendMessageWithStateCheck(Message.obtain(this.mCallBackEventHandler, 12, Long.valueOf(j3)));
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPostRollAdListener
    public void onPostrollAdPreparing(ITVKMediaPlayer iTVKMediaPlayer) {
        this.mCallBackEventHandler.sendEmptyMessageWithStateCheck(11);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPreAdListener
    public void onPreAdFinish(ITVKMediaPlayer iTVKMediaPlayer) {
        this.mCallBackEventHandler.sendEmptyMessageWithStateCheck(4);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPreAdListener
    public void onPreAdPrepared(ITVKMediaPlayer iTVKMediaPlayer, long j3) {
        this.mCallBackEventHandler.sendMessageWithStateCheck(Message.obtain(this.mCallBackEventHandler, 2, Long.valueOf(j3)));
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPreAdListener
    public void onPreAdPreparing(ITVKMediaPlayer iTVKMediaPlayer) {
        this.mCallBackEventHandler.sendEmptyMessageWithStateCheck(1);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKReportEventListener
    public void onReportEvent(ITVKMediaPlayer iTVKMediaPlayer, ITVKReportEventListener.ReportEvent reportEvent, ITVKReportEventListener.ReportEventParams reportEventParams) {
        OnReportEventParams onReportEventParams = new OnReportEventParams();
        onReportEventParams.reportEvent = reportEvent;
        onReportEventParams.reportEventParams = reportEventParams;
        this.mCallBackEventHandler.sendMessageWithStateCheck(Message.obtain(this.mCallBackEventHandler, 45, onReportEventParams));
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(ITVKMediaPlayer iTVKMediaPlayer) {
        this.mCallBackEventHandler.sendEmptyMessageWithStateCheck(26);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnScrollAdListener
    public void onSwitchAd(ITVKMediaPlayer iTVKMediaPlayer, int i3, Object obj, Object obj2) {
        OnSwitchAdParams onSwitchAdParams = new OnSwitchAdParams();
        onSwitchAdParams.adtype = i3;
        onSwitchAdParams.item = obj;
        onSwitchAdParams.linkageView = obj2;
        this.mCallBackEventHandler.sendMessageWithStateCheck(Message.obtain(this.mCallBackEventHandler, 39, onSwitchAdParams));
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnVideoFrameOutListener
    public void onVideoFrameOut(TVKVideoFrameBuffer tVKVideoFrameBuffer) {
        handleOnVideoOutputFrame(tVKVideoFrameBuffer);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnVideoPreparedListener
    public void onVideoPrepared(ITVKMediaPlayer iTVKMediaPlayer) {
        this.mCallBackEventHandler.sendMessageWithStateCheck(Message.obtain(this.mCallBackEventHandler, 19));
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnVideoPreparingListener
    public void onVideoPreparing(ITVKMediaPlayer iTVKMediaPlayer) {
        this.mCallBackEventHandler.sendEmptyMessageWithStateCheck(18);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(ITVKMediaPlayer iTVKMediaPlayer, int i3, int i16) {
        this.mCallBackEventHandler.sendMessageWithStateCheck(Message.obtain(this.mCallBackEventHandler, 42, i3, i16));
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
    public void onVolumeChange(ITVKMediaPlayer iTVKMediaPlayer, float f16) {
        this.mCallBackEventHandler.sendMessageWithStateCheck(Message.obtain(this.mCallBackEventHandler, 43, Float.valueOf(f16)));
    }

    public void removePendingCallback() {
        Iterator<Integer> it = MESSAGE_TO_BE_INTERCEPTED_SET.iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            if (this.mCallBackEventHandler.hasMessages(intValue)) {
                this.mLogger.info("Removing pending message(s): " + intValue, new Object[0]);
                this.mCallBackEventHandler.removeMessages(intValue);
            }
        }
    }
}
