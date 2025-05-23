package com.tencent.biz.richframework.video.rfw.view;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.RFWPlayerListenerDispatchUtils;
import com.tencent.biz.richframework.video.rfw.RFWVideoUtils;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.datacollect.RFWPlayerDataCollectManger;
import com.tencent.biz.richframework.video.rfw.player.exp.RFWPostAtFrontUtils;
import com.tencent.biz.richframework.video.rfw.player.init.RFWPlayerConfig;
import com.tencent.biz.richframework.video.rfw.player.init.RFWPlayerManger;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayErrorStatusListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerDownGradeListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLifeCycle;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPassivePauseListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSdkInitListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSecondBufferListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWSeekCompletionListener;
import com.tencent.biz.richframework.video.rfw.player.monitor.RFWPlayerMonitor;
import com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionH264ReSelectedProcess;
import com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionPreloadCheckProcess;
import com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionURLSelectedProcess;
import com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionsProcessManager;
import com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerPlayerDirectIPProcess;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerPreRenderHelper;
import com.tencent.biz.richframework.video.timer.IRFWVideoTimerListener;
import com.tencent.biz.richframework.video.timer.RFWVideoTimerManager;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.engineering.preload.inter.OnTaskListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.tvkplayer.view.TVKPlayerVideoView;
import com.tencent.richframework.sender.aspect.ThrottlingDelay;
import com.tencent.richframework.sender.util.EventControlUtils;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.view.ISPlayerVideoView;
import java.util.LinkedList;
import java.util.Map;
import uq3.o;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWVideoView extends BaseWidgetView implements Handler.Callback, SeekBar.OnSeekBarChangeListener, IRFWVideoTimerListener {
    private boolean mForbidReport;
    private Handler mHandler;
    private volatile boolean mHasLoadOptions;
    private volatile boolean mHasReleased;
    private boolean mIsDragSeekBar;
    protected RFWPlayerOptions mPlayOptions;
    private RFWPlayer mPlayer;
    protected RFWBasePlayerManager mPlayerManagerProxy;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface IAddViewCallBack {
        void onAddFinish();
    }

    public RFWVideoView(@NonNull Context context) {
        this(context, null);
    }

    private void addActionCollectCallBack(final RFWPlayerOptions rFWPlayerOptions) {
        rFWPlayerOptions.getListenerSet().addPrepareListeners(new IRFWPlayerPrepareListener() { // from class: com.tencent.biz.richframework.video.rfw.view.RFWVideoView.1
            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
            public void onFirstFrameRendered(RFWPlayer rFWPlayer) {
                RFWPlayerDataCollectManger g16 = RFWPlayerDataCollectManger.g();
                RFWPlayerOptions rFWPlayerOptions2 = rFWPlayerOptions;
                g16.onFirstRenderAction(rFWPlayer, rFWPlayerOptions2, rFWPlayerOptions2.tag());
            }

            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
            public void onVideoPrepared(RFWPlayer rFWPlayer) {
                RFWPlayerDataCollectManger.g().onVideoPrepareAction(rFWPlayerOptions.tag());
            }
        });
        rFWPlayerOptions.getListenerSet().addErrorStatusListener(new IRFWPlayErrorStatusListener() { // from class: com.tencent.biz.richframework.video.rfw.view.RFWVideoView.2
            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayErrorStatusListener
            public void onVideoPlayError(int i3, int i16, int i17, String str) {
                RFWPlayerDataCollectManger.g().onError(rFWPlayerOptions.tag(), String.valueOf(i17));
                RFWVideoView.this.mHasLoadOptions = false;
            }
        });
        rFWPlayerOptions.getListenerSet().addSeekCompletionListeners(new IRFWSeekCompletionListener() { // from class: com.tencent.biz.richframework.video.rfw.view.RFWVideoView.3
            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWSeekCompletionListener
            public void onSeekCompletion(ISuperPlayer iSuperPlayer) {
                RFWPlayerDataCollectManger.g().onSeekCompletion(rFWPlayerOptions.tag());
            }
        });
        rFWPlayerOptions.getListenerSet().addSeekListeners(new IRFWPlayerSeekListener() { // from class: com.tencent.biz.richframework.video.rfw.view.RFWVideoView.4
            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
            public /* synthetic */ void onProgress(String str, int i3, int i16) {
                re0.b.a(this, str, i3, i16);
            }

            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
            public /* synthetic */ void onSeekBarProgressChanged(SeekBar seekBar, int i3, boolean z16) {
                re0.b.b(this, seekBar, i3, z16);
            }

            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                RFWPlayerDataCollectManger.g().onStartTrackingTouch(rFWPlayerOptions.tag(), seekBar.getProgress());
            }

            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                RFWPlayerDataCollectManger.g().onStopTrackingTouch(rFWPlayerOptions.tag(), seekBar.getProgress());
            }
        });
        rFWPlayerOptions.getListenerSet().addSecondBufferListeners(new IRFWPlayerSecondBufferListener() { // from class: com.tencent.biz.richframework.video.rfw.view.RFWVideoView.5
            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSecondBufferListener
            public void onSecondBufferEnd() {
                RFWPlayerDataCollectManger.g().onSecondBufferEnd(rFWPlayerOptions.tag());
            }

            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSecondBufferListener
            public void onSecondBufferStart() {
                RFWPlayerDataCollectManger.g().onSecondBufferStart(rFWPlayerOptions.tag());
            }
        });
        rFWPlayerOptions.getListenerSet().addLifeCycleListeners(new IRFWPlayerLifeCycle() { // from class: com.tencent.biz.richframework.video.rfw.view.RFWVideoView.6
            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLifeCycle
            public /* synthetic */ void onDeInit(RFWPlayer rFWPlayer) {
                re0.a.a(this, rFWPlayer);
            }

            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLifeCycle
            public /* synthetic */ void onPause(RFWPlayer rFWPlayer) {
                re0.a.b(this, rFWPlayer);
            }

            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLifeCycle
            public void onRelease(RFWPlayer rFWPlayer) {
                RFWVideoView.this.mHasLoadOptions = false;
                RFWPlayerDataCollectManger.g().flush(rFWPlayerOptions.tag());
                QLog.d(RFWVideoView.this.getLogTag(), 1, "release:" + rFWPlayer.getRFWPlayerOptions().tag());
                RFWVideoView.this.onLifecycleRelease(rFWPlayer);
            }

            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLifeCycle
            public /* synthetic */ void onStart(RFWPlayer rFWPlayer) {
                re0.a.d(this, rFWPlayer);
            }

            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLifeCycle
            public /* synthetic */ void onStop(RFWPlayer rFWPlayer) {
                re0.a.e(this, rFWPlayer);
            }
        });
    }

    private void addCallBack(RFWPlayerOptions rFWPlayerOptions) {
        rFWPlayerOptions.getListenerSet().addSDKInitListeners(new IRFWPlayerSdkInitListener() { // from class: com.tencent.biz.richframework.video.rfw.view.RFWVideoView.7
            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSdkInitListener
            public void onInitSuccess(RFWPlayer rFWPlayer) {
                RFWLog.d(RFWVideoView.this.getLogTag(), RFWLog.USR, "onInitSuccess");
                RFWVideoView.this.addVideoView(null);
            }
        });
        rFWPlayerOptions.getListenerSet().addPrepareListeners(new IRFWPlayerPrepareListener() { // from class: com.tencent.biz.richframework.video.rfw.view.RFWVideoView.8
            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
            public void onFirstFrameRendered(RFWPlayer rFWPlayer) {
                RFWLog.d(RFWVideoView.this.getLogTag(), RFWLog.USR, "onFirstFrameRendered");
                RFWVideoView.this.firstFrameRenderCallBack();
            }

            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
            public void onVideoPrepared(RFWPlayer rFWPlayer) {
                RFWLog.d(RFWVideoView.this.getLogTag(), RFWLog.USR, "onVideoPrepared");
                RFWVideoView.this.onVideoPrepared(rFWPlayer.getRealPlayer());
                RFWVideoView.this.receiveVideoPrepared();
            }
        });
        rFWPlayerOptions.getListenerSet().addErrorStatusListener(new IRFWPlayErrorStatusListener() { // from class: com.tencent.biz.richframework.video.rfw.view.RFWVideoView.9
            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayErrorStatusListener
            public void onVideoPlayError(int i3, int i16, int i17, String str) {
                RFWVideoView.this.onVideoPlayError(i3, i16, i17, str);
            }
        });
        rFWPlayerOptions.getListenerSet().addDownGradeVideoListener(new IRFWPlayerDownGradeListener() { // from class: com.tencent.biz.richframework.video.rfw.view.RFWVideoView.10
            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerDownGradeListener
            public void onDowngradeVideoUrl() {
                RFWLog.d(RFWVideoView.this.getLogTag(), RFWLog.USR, "onDowngradeVideoUrl");
            }
        });
        rFWPlayerOptions.getListenerSet().addSecondBufferListeners(new IRFWPlayerSecondBufferListener() { // from class: com.tencent.biz.richframework.video.rfw.view.RFWVideoView.11
            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSecondBufferListener
            public void onSecondBufferEnd() {
                RFWVideoView.this.onSecondBufferEnd();
            }

            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSecondBufferListener
            public void onSecondBufferStart() {
                RFWVideoView.this.onSecondBufferStart();
            }
        });
        rFWPlayerOptions.getListenerSet().addPlayerPassivePauseListeners(new IRFWPlayerPassivePauseListener() { // from class: com.tencent.biz.richframework.video.rfw.view.RFWVideoView.12
            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPassivePauseListener
            public void onVideoPassivePause(int i3, int i16, long j3, long j16, long j17) {
                RFWVideoView.this.reportVideoPassivePause(i3, i16, j3, j16, j17);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void addSuperVideoViewToThis(IAddViewCallBack iAddViewCallBack, View view) {
        if (view instanceof ISPlayerVideoView) {
            ((ISPlayerVideoView) view).disableViewCallback();
        } else if (view instanceof TVKPlayerVideoView) {
            ((TVKPlayerVideoView) view).storeSurfaceTexture();
        }
        addViewToTarget(view);
        if (iAddViewCallBack != null) {
            iAddViewCallBack.onAddFinish();
        }
        RFWLog.d(getLogTag(), RFWLog.USR, "[addVideoView] player  ready");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void addViewToTarget(View view) {
        if (view == 0) {
            QLog.e("BaseVideoView", 1, "[addViewToTarget] current video view should not be null.");
            return;
        }
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            viewGroup.removeView(view);
            RFWLog.d(getLogTag(), RFWLog.USR, "[addViewToTarget] remove view group, viewGroup(" + viewGroup.hashCode() + "), currentVideoView:" + view.hashCode());
        }
        updateAndroid7ToViewLayerHardware();
        addView(view, 0, new FrameLayout.LayoutParams(-1, -1));
        if (view instanceof ISPlayerVideoView) {
            ((ISPlayerVideoView) view).enableViewCallback();
        } else if (view instanceof TVKPlayerVideoView) {
            ((TVKPlayerVideoView) view).resumeSurfaceTexture();
        }
        RFWLog.d(getLogTag(), RFWLog.USR, "[addViewToTarget] add view finish, container child count: " + getChildCount() + " | this:" + getViewPropParamValue(this) + " | currentVideoView: " + getViewPropParamValue(view));
    }

    private void callbackPreLoadInfo() {
        RFWPlayer rFWPlayer = this.mPlayer;
        if (rFWPlayer != null && rFWPlayer.getTvkInfoMap() != null) {
            for (Map.Entry<Integer, Object> entry : this.mPlayer.getTvkInfoMap().entrySet()) {
                if (entry != null) {
                    RFWPlayer rFWPlayer2 = this.mPlayer;
                    rFWPlayer2.onInfo(rFWPlayer2.getRealPlayer(), entry.getKey().intValue(), 0L, 0L, entry.getValue());
                }
            }
        }
    }

    private void checkPreloadPlayer(RFWPlayerOptions rFWPlayerOptions) {
        if (this.mHasReleased && o.t()) {
            RFWLog.d(getLogTag(), RFWLog.USR, "startVideo return, has released");
            return;
        }
        if (rFWPlayerOptions == null) {
            RFWLog.d(getLogTag(), RFWLog.USR, "startVideo error empty options");
            return;
        }
        this.mIsDragSeekBar = false;
        resetVariablesWhenChangeDataSource();
        addCallBack(this.mPlayOptions);
        if (checkReusePlayer(this.mPlayOptions)) {
            RFWLog.d(getLogTag(), RFWLog.USR, "ues same player");
            return;
        }
        if (rFWPlayerOptions.isLocalVideo()) {
            startByNewPlayer();
            RFWPlayerPreRenderHelper.getInstance().removeKey(this.mPlayOptions.getFileId());
            RFWLog.d(getLogTag(), RFWLog.USR, " local video play");
        } else if (rFWPlayerOptions.hasPreLoadPlayer() && PreLoader.exists(this.mPlayOptions.getFileId())) {
            startPreRenderPlay();
            RFWLog.d(getLogTag(), RFWLog.USR, "preRenderPlayer  hit pre render player");
        } else {
            startByNewPlayer();
        }
    }

    private boolean checkReusePlayer(RFWPlayerOptions rFWPlayerOptions) {
        if (rFWPlayerOptions != null && rFWPlayerOptions.getTVKPlayerOption() == null) {
            RFWPlayer reusePlayer = RFWPlayerReuseUtils.getReusePlayer(rFWPlayerOptions.getFileId());
            if (reusePlayer != null && reusePlayer.getRFWPlayerOptions() != null) {
                RFWLog.d(getLogTag(), RFWLog.USR, "find reuse player:" + reusePlayer.getRFWPlayerOptions().tag());
                ISuperPlayer realPlayer = reusePlayer.getRealPlayer();
                if (!reusePlayer.isRelease() && !reusePlayer.isError() && !reusePlayer.isDeInit() && realPlayer != null && realPlayer.isLoopBack()) {
                    if (!this.mPlayOptions.isMutualExclusion()) {
                        getPlayerProxy().removeReUsePlayer(String.valueOf(reusePlayer.hashCode()));
                    } else {
                        getPlayerProxy().putReusePlayer(this.mPlayOptions.tag(), reusePlayer);
                    }
                    this.mPlayer = reusePlayer;
                    replaceCallBack(reusePlayer.getRFWPlayerOptions());
                    RFWPlayerListenerDispatchUtils.onInitSuccess(this.mPlayOptions, this.mPlayer);
                    addVideoView(new IAddViewCallBack() { // from class: com.tencent.biz.richframework.video.rfw.view.c
                        @Override // com.tencent.biz.richframework.video.rfw.view.RFWVideoView.IAddViewCallBack
                        public final void onAddFinish() {
                            RFWVideoView.this.lambda$checkReusePlayer$2();
                        }
                    });
                    return true;
                }
                reusePlayer.release(RFWPlayer.RELEASE_BY_REUSE);
                RFWLog.d(getLogTag(), RFWLog.USR, "find reuse player error status:" + reusePlayer.getRFWPlayerOptions().tag());
                return false;
            }
            RFWLog.d(getLogTag(), RFWLog.USR, "find reuse player but is empty");
            return false;
        }
        RFWPlayerReuseUtils.getReusePlayer(getLogTag());
        return false;
    }

    private int getDynamicTimeInterval(int i3) {
        return Math.max(Math.min(i3 / 100, 340), 60);
    }

    private String getViewPropParamValue(View view) {
        boolean z16;
        if (view == null) {
            return "";
        }
        int hashCode = view.hashCode();
        boolean isHardwareAccelerated = view.isHardwareAccelerated();
        float alpha = view.getAlpha();
        boolean z17 = true;
        if (view.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (view.getParent() == null) {
            z17 = false;
        }
        return "[hashCode:" + hashCode + " | isHardwareAccelerated: " + isHardwareAccelerated + " | alpha: " + alpha + " | isVisible: " + z16 + " | hasParent: " + z17 + "]";
    }

    private void hotPlugSuperVideoView(final IAddViewCallBack iAddViewCallBack, final View view, final ViewGroup viewGroup) {
        RFWPostAtFrontUtils.post(getMainHandler(), new Runnable() { // from class: com.tencent.biz.richframework.video.rfw.view.e
            @Override // java.lang.Runnable
            public final void run() {
                RFWVideoView.this.lambda$hotPlugSuperVideoView$0(viewGroup, iAddViewCallBack, view);
            }
        });
    }

    private void initProgressBarListeners() {
        if (getProgressBar() != null) {
            getProgressBar().setSeekBarListener(this);
        }
    }

    private void keepScreenOnOff(final boolean z16) {
        getMainHandler().post(new Runnable() { // from class: com.tencent.biz.richframework.video.rfw.view.RFWVideoView.16
            @Override // java.lang.Runnable
            public void run() {
                RFWVideoView.this.setKeepScreenOn(z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$hotPlugSuperVideoView$0(ViewGroup viewGroup, IAddViewCallBack iAddViewCallBack, View view) {
        if (viewGroup == this && o.O0()) {
            if (iAddViewCallBack != null) {
                iAddViewCallBack.onAddFinish();
                return;
            }
            return;
        }
        if (view instanceof ISPlayerVideoView) {
            ((ISPlayerVideoView) view).disableViewCallback();
        } else if (view instanceof TVKPlayerVideoView) {
            ((TVKPlayerVideoView) view).storeSurfaceTexture();
        }
        viewGroup.removeView(view);
        addViewToTarget(view);
        if (iAddViewCallBack != null) {
            iAddViewCallBack.onAddFinish();
        }
        RFWLog.d(getLogTag(), RFWLog.USR, "post [addVideoView] player  ready");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadPlayOptions$1(RFWPlayerOptions rFWPlayerOptions, RFWPlayerOptions rFWPlayerOptions2, boolean z16) {
        this.mPlayOptions = rFWPlayerOptions;
        onProcessFinish(rFWPlayerOptions);
        checkPreloadPlayer(rFWPlayerOptions);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onVideoPlayError$3() {
        RFWPlayerOptions rFWPlayerOptions = this.mPlayOptions;
        if (rFWPlayerOptions != null && rFWPlayerOptions.isPlayerByDirectIP() && this.mPlayOptions.getRetryCount() == 0) {
            QLog.e(getLogTag(), 1, "video play error directIP retry ");
            this.mPlayOptions.inCreRetryCount();
            this.mPlayOptions.setEnableDirectIP(false);
            retry(this.mPlayOptions, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUlrInvalid() {
        LinkedList<String> linkedList = new LinkedList<>();
        this.mPlayOptions.setNeedExchangeUrl(true);
        linkedList.add(getExchangeUrlProcessKey());
        linkedList.add(RFWPlayerOptionURLSelectedProcess.DEFAULT_PROCESS_URL_SELECTED);
        linkedList.add(RFWPlayerOptionH264ReSelectedProcess.DEFAULT_PROCESS_URL_H264_RE_SELECTED);
        linkedList.add(RFWPlayerPlayerDirectIPProcess.DEFAULT_PROCESS_URL_DIRECT_IP);
        linkedList.add(getAddSceneProcessKey());
        RFWPlayerOptionsProcessManager.g().startProcess(linkedList, this.mPlayOptions, new RFWPlayerOptionsProcessManager.IProcessCallBack() { // from class: com.tencent.biz.richframework.video.rfw.view.RFWVideoView.14
            @Override // com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionsProcessManager.IProcessCallBack
            public void onFinish(RFWPlayerOptions rFWPlayerOptions, boolean z16) {
                QLog.d(RFWVideoView.this.getLogTag(), 1, "onUlrInvalid finish");
                RFWVideoView.this.startByNewPlayer();
            }
        });
    }

    private void printViewSize(View view, boolean z16) {
        if (view == null) {
            RFWLog.d(getLogTag(), RFWLog.USR, "printViewSize return, playView isEmpty," + z16);
            return;
        }
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        RFWLog.d(getLogTag(), RFWLog.USR, "printViewSize measured:" + measuredWidth + "|" + measuredHeight + "|" + z16);
        if (view.getLayoutParams() == null) {
            RFWLog.d(getLogTag(), RFWLog.USR, "layoutParams empty," + z16);
            return;
        }
        int i3 = view.getLayoutParams().width;
        int i16 = view.getLayoutParams().height;
        RFWLog.d(getLogTag(), RFWLog.USR, "printViewSize layoutParams:" + i3 + "|" + i16 + "|" + z16);
    }

    private void releaseTimer() {
        RFWVideoTimerManager.g().unRegisterTimerListener(this);
    }

    private void sendProgressChangeMessage(int i3, int i16) {
        Message obtain = Message.obtain();
        obtain.what = -1001;
        obtain.arg1 = i3;
        obtain.arg2 = i16;
        obtain.obj = Boolean.TRUE;
        getMainHandler().sendMessage(obtain);
    }

    private void setPlayerActive() {
        if (!uq3.c.c()) {
            RFWLog.d(getLogTag(), RFWLog.USR, "setPlayerActivity wns close");
            return;
        }
        RFWPlayer rFWPlayer = this.mPlayer;
        if (rFWPlayer != null && rFWPlayer.getRealPlayer() != null && !(this.mPlayer.getRealPlayer() instanceof yc4.a)) {
            this.mPlayer.setPlayerActive();
            RFWLog.d(getLogTag(), RFWLog.USR, "setPlayerActivity success");
        } else {
            RFWLog.d(getLogTag(), RFWLog.USR, "setPlayerActivity player error");
        }
    }

    @ThrottlingDelay(tag = "setSeekBar", timeInterval = 100)
    private void setSeekBarDuration(SeekBar seekBar) {
        int videoDuration;
        RFWLog.d(getLogTag(), RFWLog.DEV, "setSeekBarDuration");
        Message obtain = Message.obtain();
        obtain.what = -1001;
        int progress = seekBar.getProgress();
        RFWPlayer rFWPlayer = this.mPlayer;
        if (rFWPlayer == null) {
            videoDuration = 0;
        } else {
            videoDuration = rFWPlayer.getVideoDuration();
        }
        int max = Math.max(progress, 0);
        obtain.arg1 = Math.min(max, videoDuration);
        obtain.arg2 = videoDuration;
        obtain.obj = Boolean.FALSE;
        if (isNeedSeekWhenDragging()) {
            seek(max);
        }
        getMainHandler().sendMessage(obtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startByNewPlayer() {
        RFWPlayerOptions rFWPlayerOptions = this.mPlayOptions;
        if (rFWPlayerOptions == null) {
            return;
        }
        boolean z16 = false;
        if (!rFWPlayerOptions.isValid()) {
            RFWLog.d(getLogTag(), RFWLog.USR, "setVideoPath inValid may be not onScreen");
            return;
        }
        if (this.mPlayOptions.isMutualExclusion()) {
            this.mPlayer = getPlayerProxy().newAQCirclePlayer(this.mPlayOptions.tag());
            RFWLog.d(getLogTag(), RFWLog.USR, "new player instance MutualExclusion");
        } else {
            RFWPlayer rFWPlayer = this.mPlayer;
            if (rFWPlayer != null) {
                rFWPlayer.release(RFWPlayer.RELEASE_FROM_VIDEO_VIEW);
            }
            this.mPlayer = new RFWPlayer();
            RFWLog.d(getLogTag(), RFWLog.USR, "new player instance not MutualExclusion");
        }
        RFWPlayer rFWPlayer2 = this.mPlayer;
        if (!isForbiddenDefaultPerfReport() && this.mPlayOptions.isMutualExclusion()) {
            z16 = true;
        }
        rFWPlayer2.setEnablePerfReport(z16);
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_fluency_9055", true)) {
            this.mPlayOptions.setOffSetBySeek(true);
        }
        this.mPlayer.loadPlayOptions(this.mPlayOptions);
    }

    private void startPreRenderPlay() {
        RFWPlayerOptions rFWPlayerOptions = this.mPlayOptions;
        if (rFWPlayerOptions == null) {
            return;
        }
        PreLoader.addListener(rFWPlayerOptions.getFileId(), new OnTaskListener<RFWPlayerPreRenderHelper.QFSPlayerPreloadResult>() { // from class: com.tencent.biz.richframework.video.rfw.view.RFWVideoView.13
            private void releaseNotMutualExclusionPlayer() {
                RFWPlayer rFWPlayer = RFWVideoView.this.mPlayer;
                if (o.K0() && rFWPlayer != null) {
                    rFWPlayer.release(RFWPlayer.RELEASE_BY_REUSE);
                    QLog.d(RFWVideoView.this.getLogTag(), 1, "release old player");
                }
            }

            @Override // com.tencent.mobileqq.engineering.preload.inter.OnTaskListener
            public void onComplete(RFWPlayerPreRenderHelper.QFSPlayerPreloadResult... qFSPlayerPreloadResultArr) {
                RFWPlayerPreRenderHelper rFWPlayerPreRenderHelper = RFWPlayerPreRenderHelper.getInstance();
                RFWPlayerOptions rFWPlayerOptions2 = RFWVideoView.this.mPlayOptions;
                rFWPlayerPreRenderHelper.removeKey(rFWPlayerOptions2 == null ? "" : rFWPlayerOptions2.getFileId());
                if (qFSPlayerPreloadResultArr.length == 0) {
                    RFWVideoView.this.startByNewPlayer();
                    return;
                }
                RFWPlayerPreRenderHelper.QFSPlayerPreloadResult qFSPlayerPreloadResult = qFSPlayerPreloadResultArr[0];
                RFWPlayer player = qFSPlayerPreloadResult.getPlayer();
                RFWPlayerOptions rFWPlayerOptions3 = player.getRFWPlayerOptions();
                if (!RFWVideoView.this.mPlayOptions.isValid()) {
                    player.release(RFWPlayer.RELEASE_FROM_PRELOAD);
                    RFWLog.d(RFWVideoView.this.getLogTag(), RFWLog.USR, "preRenderPlayer setVideoPath inValid may be not onScreen");
                    return;
                }
                if (qFSPlayerPreloadResult.isPreloadError()) {
                    player.release(RFWPlayer.RELEASE_FROM_PRELOAD);
                    RFWLog.d(RFWVideoView.this.getLogTag(), RFWLog.USR, "renderPlayer is isPreloadError");
                    RFWVideoView.this.startByNewPlayer();
                    return;
                }
                if (RFWVideoUtils.checkVideoUrlIsNeedChange(rFWPlayerOptions3.getRealPlayUrl())) {
                    player.release(RFWPlayer.RELEASE_FROM_PRELOAD);
                    RFWLog.d(RFWVideoView.this.getLogTag(), RFWLog.USR, "preRenderPlayer url is timeOut " + rFWPlayerOptions3.tag());
                    RFWVideoView.this.onUlrInvalid();
                    return;
                }
                RFWVideoView.this.replaceCallBack(rFWPlayerOptions3);
                RFWLog.d(RFWVideoView.this.getLogTag(), RFWLog.USR, "preRenderPlayer replace callSet preloadTag:" + rFWPlayerOptions3.tag());
                if (!RFWVideoView.this.mPlayOptions.isMutualExclusion()) {
                    releaseNotMutualExclusionPlayer();
                    RFWVideoView.this.mPlayer = player;
                } else {
                    RFWVideoView.this.getPlayerProxy().putPlayer(RFWVideoView.this.mPlayOptions.tag(), player);
                    RFWVideoView rFWVideoView = RFWVideoView.this;
                    rFWVideoView.mPlayer = rFWVideoView.getPlayerProxy().getPlayer(RFWVideoView.this.mPlayOptions.tag());
                }
                if (RFWVideoView.this.mPlayOptions.getStartOffset() > 0 && rFWPlayerOptions3.getStartOffset() == 0) {
                    RFWVideoView.this.mPlayer.seek(RFWVideoView.this.mPlayOptions.getStartOffset());
                }
                RFWVideoView rFWVideoView2 = RFWVideoView.this;
                RFWPlayerListenerDispatchUtils.onInitSuccess(rFWVideoView2.mPlayOptions, rFWVideoView2.mPlayer);
                if (!qFSPlayerPreloadResult.isPromisedPlayer()) {
                    RFWVideoView.this.startPreloadUnPromisedPlayer();
                    return;
                }
                RFWVideoView rFWVideoView3 = RFWVideoView.this;
                rFWVideoView3.onPreRenderPlayerReplace(rFWVideoView3.mPlayOptions);
                RFWVideoView.this.lambda$checkReusePlayer$2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: startPreloadPromisedPlayer, reason: merged with bridge method [inline-methods] */
    public void lambda$checkReusePlayer$2() {
        RFWPlayer rFWPlayer = this.mPlayer;
        if (rFWPlayer == null) {
            return;
        }
        rFWPlayer.setEnablePerfReport(true);
        this.mPlayer.playerStartPlayState();
        if (this.mPlayer.isPrepared()) {
            callbackPreLoadInfo();
            RFWPlayer rFWPlayer2 = this.mPlayer;
            rFWPlayer2.onNetVideoInfo(rFWPlayer2.getTVKNetVideoInfo());
            RFWPlayer rFWPlayer3 = this.mPlayer;
            rFWPlayer3.onVideoPrepared(rFWPlayer3.getRealPlayer());
            RFWLog.d(getLogTag(), RFWLog.USR, "preRenderPlayer prepareReady");
        } else {
            setPlayerActive();
            RFWLog.d(getLogTag(), RFWLog.USR, "preRenderPlayer wait prepare by superPlay");
        }
        if (this.mPlayer.isFirstRenderCallback()) {
            this.mPlayer.onPlayerInfoFirstVideoFrameRendered();
            RFWLog.d(getLogTag(), RFWLog.USR, "preRenderPlayer isFirstRenderCallback ready");
        } else {
            RFWLog.d(getLogTag(), RFWLog.USR, "preRenderPlayer wait firstRenderCallbackepare by superPlay");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPreloadUnPromisedPlayer() {
        if (this.mPlayer.isDeInit()) {
            this.mPlayer.release(RFWPlayer.RELEASE_FROM_PRELOAD);
            startByNewPlayer();
            RFWLog.d(getLogTag(), RFWLog.USR, "unPromise preRenderPlayer  not prepareReady start new");
            return;
        }
        setPlayerActive();
        onPreRenderPlayerReplace(this.mPlayOptions);
        this.mPlayer.setEnablePerfReport(true);
        this.mPlayer.playerStartPlayState();
        if (this.mPlayer.isPrepared()) {
            callbackPreLoadInfo();
            RFWPlayer rFWPlayer = this.mPlayer;
            rFWPlayer.onNetVideoInfo(rFWPlayer.getTVKNetVideoInfo());
            RFWPlayer rFWPlayer2 = this.mPlayer;
            rFWPlayer2.onVideoPrepared(rFWPlayer2.getRealPlayer());
            RFWLog.d(getLogTag(), RFWLog.USR, "unPromise preRenderPlayer  prepareReady ready");
        }
        if (this.mPlayer.isFirstRenderCallback()) {
            this.mPlayer.onPlayerInfoFirstVideoFrameRendered();
            RFWLog.d(getLogTag(), RFWLog.USR, "unPromise preRenderPlayer  firstRendCallback");
        }
    }

    private void updateAllParentHardwareLayerTypeView(View view, int i3) {
        if (i3 >= 30) {
            return;
        }
        if (view.getLayerType() != 2) {
            QLog.d("BaseVideoView", 1, "[updateParentHardwareLayerTypeView] view: " + view + " \uff5c layerType: " + view.getLayerType());
            view.setLayerType(2, null);
        }
        Object parent = view.getParent();
        if (parent instanceof View) {
            updateAllParentHardwareLayerTypeView((View) parent, i3 + 1);
        }
    }

    private void updateAndroid7ToViewLayerHardware() {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 26 || i3 < 24 || isHardwareAccelerated() || !uq3.c.Y5()) {
            return;
        }
        try {
            updateAllParentHardwareLayerTypeView(this, 0);
            QLog.d("BaseVideoView", 1, "[updateAndroid7ToViewLayerHardware] start: " + isHardwareAccelerated() + " | layerType: " + getLayerType());
            setLayerType(2, null);
            QLog.d("BaseVideoView", 1, "[updateAndroid7ToViewLayerHardware] end: " + isHardwareAccelerated() + " | layerType: " + getLayerType());
        } catch (Throwable th5) {
            QLog.e("BaseVideoView", 1, "[updateAndroid7ToViewLayerHardware] error: ", th5);
        }
    }

    private void updateMonitorPosition(ISuperPlayer iSuperPlayer, long j3) {
        if (iSuperPlayer.isPlaying() || iSuperPlayer.isBuffering()) {
            RFWPlayerMonitor.g().updatePosition(this.mPlayer, this.mPlayOptions, j3);
        }
    }

    private void updateProgress(final int i3) {
        getMainHandler().post(new Runnable() { // from class: com.tencent.biz.richframework.video.rfw.view.RFWVideoView.15
            @Override // java.lang.Runnable
            public void run() {
                if (RFWVideoView.this.getProgressBar() != null) {
                    RFWVideoView.this.getProgressBar().a().setProgress(i3);
                }
                RFWPlayerOptions rFWPlayerOptions = RFWVideoView.this.mPlayOptions;
                if (rFWPlayerOptions != null) {
                    rFWPlayerOptions.setStartOffset(i3);
                }
            }
        });
    }

    private void updateProgressToPlayer(int i3, int i16) {
        RFWPlayer rFWPlayer = this.mPlayer;
        if (rFWPlayer == null) {
            return;
        }
        rFWPlayer.updateProgress(i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void addVideoView(IAddViewCallBack iAddViewCallBack) {
        if (isAudio() || getQCirclePlayer() == null) {
            return;
        }
        if (!getQCirclePlayer().isReady()) {
            RFWLog.w(getLogTag(), RFWLog.USR, "[addVideoView] player not ready");
            return;
        }
        View videoView = getQCirclePlayer().getVideoView();
        if (videoView == getChildAt(0) && o.O0()) {
            RFWLog.w(getLogTag(), RFWLog.USR, "[addVideoView] view has be added");
            if (videoView instanceof ISPlayerVideoView) {
                ((ISPlayerVideoView) videoView).enableViewCallback();
            } else if (videoView instanceof TVKPlayerVideoView) {
                ((TVKPlayerVideoView) videoView).resumeSurfaceTexture();
            }
            if (iAddViewCallBack != null) {
                iAddViewCallBack.onAddFinish();
                return;
            }
            return;
        }
        cleanOldISPlayer();
        ViewGroup viewGroup = (ViewGroup) videoView.getParent();
        if (viewGroup != null) {
            hotPlugSuperVideoView(iAddViewCallBack, videoView, viewGroup);
        } else {
            addSuperVideoViewToThis(iAddViewCallBack, videoView);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void bindData(Object obj, int i3) {
        this.mHasLoadOptions = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cleanOldISPlayer() {
        View childAt = getChildAt(0);
        if ((childAt instanceof ISPlayerVideoView) || (childAt instanceof TVKPlayerVideoView)) {
            removeView(childAt);
            RFWLog.d(getLogTag(), RFWLog.USR, "remove is player");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void firstFrameRenderCallBack() {
        if (!uq3.c.r5()) {
            return;
        }
        printViewSize(this, true);
        printViewSize((View) getParent(), false);
        if (getProgressBar() != null) {
            getProgressBar().d().setVisibility(0);
            getProgressBar().setSeekBarListener(this);
        }
    }

    protected String getAddSceneProcessKey() {
        return "";
    }

    protected String getExchangeUrlProcessKey() {
        return "";
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getLogTag() {
        if (this.mPlayOptions != null) {
            return "BaseVideoView_" + this.mPlayOptions.tag();
        }
        return "BaseVideoView";
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public Handler getMainHandler() {
        if (this.mHandler == null) {
            this.mHandler = new Handler(Looper.getMainLooper(), this);
        }
        return this.mHandler;
    }

    public boolean getOutPutMute() {
        if (getQCirclePlayer() == null) {
            return false;
        }
        if (!getQCirclePlayer().isReady()) {
            RFWLog.w(getLogTag(), RFWLog.USR, "[getOutPutMute] player not ready");
            return false;
        }
        return getQCirclePlayer().isOutputMute();
    }

    public String getPlayOptionUrl() {
        RFWPlayerOptions rFWPlayerOptions = this.mPlayOptions;
        if (rFWPlayerOptions == null) {
            return "";
        }
        return rFWPlayerOptions.getRealPlayUrl();
    }

    public float getPlayRate() {
        if (getQCirclePlayer() == null) {
            return 1.0f;
        }
        if (!getQCirclePlayer().isReady()) {
            RFWLog.w(getLogTag(), RFWLog.USR, "[getPlayRate error] player not ready");
            return 1.0f;
        }
        return getQCirclePlayer().getPlayRate();
    }

    protected RFWBasePlayerManager getPlayerProxy() {
        if (this.mPlayerManagerProxy == null) {
            this.mPlayerManagerProxy = new RFWPlayerManagerProxy(isAudio());
        }
        return this.mPlayerManagerProxy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LinkedList<String> getProcessOrder(int i3) {
        RFWPlayerConfig config = RFWPlayerManger.g(i3).getConfig();
        if (config != null && config.getProcessOrder() != null) {
            return config.getProcessOrder().getPlayFormalOrder();
        }
        RFWLog.d("BaseVideoView", RFWLog.USR, "getProcessOrder no order use default:" + i3);
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(RFWPlayerOptionPreloadCheckProcess.DEFAULT_PROCESS_PRELOAD_CHECK);
        if (i3 == 126 || i3 == 102) {
            linkedList.add(getExchangeUrlProcessKey());
        }
        linkedList.add(RFWPlayerOptionURLSelectedProcess.DEFAULT_PROCESS_URL_SELECTED);
        linkedList.add(RFWPlayerOptionH264ReSelectedProcess.DEFAULT_PROCESS_URL_H264_RE_SELECTED);
        linkedList.add(RFWPlayerPlayerDirectIPProcess.DEFAULT_PROCESS_URL_DIRECT_IP);
        return linkedList;
    }

    public com.tencent.widget.media.a getProgressBar() {
        return null;
    }

    public RFWPlayer getQCirclePlayer() {
        return this.mPlayer;
    }

    public ISuperPlayer getSuperPlayer() {
        if (getQCirclePlayer() == null) {
            return null;
        }
        if (!getQCirclePlayer().isReady()) {
            RFWLog.w(getLogTag(), RFWLog.USR, "[getSuperPlayer] player not ready");
            return null;
        }
        return getQCirclePlayer().getRealPlayer();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == -1001) {
            RFWPlayerListenerDispatchUtils.onProgress(this.mPlayOptions, "", message.arg2, message.arg1);
            updateProgressToPlayer(message.arg2, message.arg1);
            return false;
        }
        return false;
    }

    public boolean hasLoadOptions() {
        return this.mHasLoadOptions;
    }

    protected boolean isAudio() {
        return false;
    }

    public boolean isForbiddenDefaultPerfReport() {
        return this.mForbidReport;
    }

    public boolean isHitVideoCache() {
        RFWPlayer rFWPlayer = this.mPlayer;
        if (rFWPlayer == null) {
            return false;
        }
        return rFWPlayer.isHasHitCache();
    }

    protected boolean isNeedSeekWhenDragging() {
        return false;
    }

    public boolean isRelease() {
        if (getQCirclePlayer() == null) {
            return true;
        }
        return getQCirclePlayer().isRelease();
    }

    public void loadPlayOptions(final RFWPlayerOptions rFWPlayerOptions) {
        this.mHasLoadOptions = true;
        this.mHasReleased = false;
        addActionCollectCallBack(rFWPlayerOptions);
        RFWPlayerDataCollectManger.g().onStartNewPlayAction(rFWPlayerOptions);
        RFWPlayerOptionsProcessManager.g().startProcess(getProcessOrder(rFWPlayerOptions.getSceneId()), rFWPlayerOptions, new RFWPlayerOptionsProcessManager.IProcessCallBack() { // from class: com.tencent.biz.richframework.video.rfw.view.b
            @Override // com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionsProcessManager.IProcessCallBack
            public final void onFinish(RFWPlayerOptions rFWPlayerOptions2, boolean z16) {
                RFWVideoView.this.lambda$loadPlayOptions$1(rFWPlayerOptions, rFWPlayerOptions2, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
        } catch (Exception e16) {
            RFWLog.e("BaseVideoView", RFWLog.USR, e16);
        }
    }

    public void onPlayerBeReused(RFWPlayer rFWPlayer) {
        if (rFWPlayer == null || rFWPlayer.getRFWPlayerOptions() == null || rFWPlayer != this.mPlayer) {
            return;
        }
        String valueOf = String.valueOf(rFWPlayer.hashCode());
        getPlayerProxy().removeReUsePlayer(valueOf);
        this.mPlayer = null;
        RFWLog.d(getLogTag(), RFWLog.USR, "[cutOffPlayer] set play null:" + rFWPlayer.getRFWPlayerOptions().tag() + " ,playerHashCode:" + valueOf);
    }

    protected void onPreRenderPlayerReplace(RFWPlayerOptions rFWPlayerOptions) {
        float f16;
        RFWPlayerDataCollectManger g16 = RFWPlayerDataCollectManger.g();
        String tag = rFWPlayerOptions.tag();
        String preloadPlayerTag = rFWPlayerOptions.getPreloadPlayerTag();
        String realPlayUrl = rFWPlayerOptions.getRealPlayUrl();
        if (rFWPlayerOptions.getRealPlayBean() != null) {
            f16 = rFWPlayerOptions.getRealPlayBean().mRate;
        } else {
            f16 = 0.0f;
        }
        g16.onReplacePreloadAction(tag, preloadPlayerTag, realPlayUrl, f16);
    }

    protected void onProcessFinish(RFWPlayerOptions rFWPlayerOptions) {
        float f16;
        RFWPlayerDataCollectManger g16 = RFWPlayerDataCollectManger.g();
        String tag = rFWPlayerOptions.tag();
        String realPlayUrl = rFWPlayerOptions.getRealPlayUrl();
        if (rFWPlayerOptions.getRealPlayBean() != null) {
            f16 = rFWPlayerOptions.getRealPlayBean().mRate;
        } else {
            f16 = 0.0f;
        }
        g16.onOptionProcessFinishAction(tag, realPlayUrl, f16);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i3, boolean z16) {
        if (z16) {
            setSeekBarDuration(seekBar);
            RFWPlayerListenerDispatchUtils.onSeekBarProgressChanged(this.mPlayOptions, seekBar, i3, z16);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        if (getQCirclePlayer() == null) {
            return;
        }
        if (!getQCirclePlayer().isReady()) {
            RFWLog.w(getLogTag(), RFWLog.USR, "[onStartTrackingTouch] player not ready");
            return;
        }
        this.mIsDragSeekBar = true;
        RFWLog.w(getLogTag(), RFWLog.USR, "[onStartTrackingTouch]");
        getQCirclePlayer().onStartTrackingTouch(seekBar.getProgress(), seekBar.getMax());
        RFWPlayerListenerDispatchUtils.onStartTrackingTouch(this.mPlayOptions, seekBar);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        EventCollector.getInstance().onStopTrackingTouchBefore(seekBar);
        if (getQCirclePlayer() != null) {
            this.mIsDragSeekBar = false;
            RFWLog.w(getLogTag(), RFWLog.USR, "[onStopTrackingTouch]");
            if (!getQCirclePlayer().isReady()) {
                RFWLog.w(getLogTag(), RFWLog.USR, "[onStopTrackingTouch] player not ready");
            } else {
                getQCirclePlayer().onStopTrackingTouch(seekBar.getProgress(), seekBar.getMax());
                RFWPlayerListenerDispatchUtils.onStopTrackingTouch(this.mPlayOptions, seekBar);
                RFWVideoDurationHelper.g().recordDuration(getPlayOptionUrl(), seekBar.getProgress(), getQCirclePlayer().getDurationMs(), true, getPlayRate());
            }
        }
        EventCollector.getInstance().onStopTrackingTouch(seekBar);
    }

    public void onTimerCallback() {
        timeUpdateCallBack();
    }

    public void onVideoPlayError(int i3, int i16, int i17, String str) {
        QLog.e(getLogTag(), 1, "video play error, errorCode = " + i17);
        RFWPostAtFrontUtils.post(getMainHandler(), new Runnable() { // from class: com.tencent.biz.richframework.video.rfw.view.d
            @Override // java.lang.Runnable
            public final void run() {
                RFWVideoView.this.lambda$onVideoPlayError$3();
            }
        });
    }

    public void onVideoPrepared(ISuperPlayer iSuperPlayer) {
        boolean z16;
        if (getProgressBar() != null && this.mPlayer != null) {
            initProgressBarListeners();
            int videoDuration = this.mPlayer.getVideoDuration();
            getProgressBar().a().setMax(videoDuration);
            QLog.e(getLogTag(), 1, "onVideoPrepared init seekBar max = " + videoDuration);
            return;
        }
        String logTag = getLogTag();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onVideoPrepared init seekBar error : ");
        boolean z17 = false;
        if (getProgressBar() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        sb5.append("|");
        if (this.mPlayer == null) {
            z17 = true;
        }
        sb5.append(z17);
        QLog.e(logTag, 1, sb5.toString());
    }

    public void pause() {
        if (getQCirclePlayer() == null) {
            return;
        }
        if (!getQCirclePlayer().isReady()) {
            RFWLog.w(getLogTag(), RFWLog.USR, "[pause] player not ready");
            return;
        }
        getQCirclePlayer().pause();
        keepScreenOnOff(false);
        RFWLog.d(getLogTag(), RFWLog.USR, "pause success");
        RFWPlayerMonitor.g().resetPosition(this.mPlayOptions);
    }

    public void playTimer() {
        releaseTimer();
        RFWVideoTimerManager.g().registerTimerListener(this);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void release() {
        this.mHasLoadOptions = false;
        this.mHasReleased = true;
        getMainHandler().removeCallbacksAndMessages(null);
        if (getQCirclePlayer() == null) {
            QLog.e("BaseVideoView", 1, "[release] obtain current player is null, not release!!!");
            return;
        }
        getPlayerProxy().releasePlayer(this.mPlayOptions.tag());
        RFWPlayer rFWPlayer = this.mPlayer;
        if (rFWPlayer != null) {
            rFWPlayer.release(RFWPlayer.RELEASE_FROM_VIDEO_VIEW);
        }
        RFWPlayerMonitor.g().resetPosition(this.mPlayOptions);
        cleanOldISPlayer();
        releaseTimer();
        this.mIsDragSeekBar = false;
        if (getProgressBar() != null) {
            getProgressBar().a().setProgress(0);
            getProgressBar().setSeekBarListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void replaceCallBack(RFWPlayerOptions rFWPlayerOptions) {
        rFWPlayerOptions.replaceListenerSet(this.mPlayOptions.getListenerSet());
        rFWPlayerOptions.setPlayIOC(this.mPlayOptions.getIOC());
        rFWPlayerOptions.setIsFirstPlayer(this.mPlayOptions.isFirstPlayer());
        this.mPlayOptions.setPreLoadPlayerTag(rFWPlayerOptions.tag()).setPredictSpeed(rFWPlayerOptions.getPredictSpeed()).setRealPlayUrl(rFWPlayerOptions.getRealPlayUrl()).setPlayUrl(rFWPlayerOptions.getPlayUrl()).setRealPlayBean(rFWPlayerOptions.getRealPlayBean()).setVecUrlBean(rFWPlayerOptions.getVecUrlBean()).setSelectHitUrlCache(rFWPlayerOptions.hitSelectUrlCache()).setTargetIPURl(rFWPlayerOptions.getTargetIPURL()).setServerPlayBean(rFWPlayerOptions.getServerPlayBean());
    }

    protected void resetVariablesWhenChangeDataSource() {
        releaseTimer();
        getMainHandler().removeCallbacksAndMessages(null);
    }

    protected void retry(RFWPlayerOptions rFWPlayerOptions, boolean z16) {
        if (rFWPlayerOptions != null && rFWPlayerOptions.isValid()) {
            this.mPlayOptions = rFWPlayerOptions;
            RFWPlayer newAQCirclePlayer = getPlayerProxy().newAQCirclePlayer(rFWPlayerOptions.tag());
            this.mPlayer = newAQCirclePlayer;
            newAQCirclePlayer.setEnablePerfReport(z16);
            this.mPlayer.loadPlayOptions(rFWPlayerOptions);
            RFWLog.d(getLogTag(), RFWLog.USR, "retry new player instance");
            return;
        }
        RFWLog.d(getLogTag(), RFWLog.USR, "retry inValid may be not onScreen");
    }

    public void seek(long j3) {
        if (getQCirclePlayer() == null) {
            return;
        }
        if (!getQCirclePlayer().isReady()) {
            RFWLog.w(getLogTag(), RFWLog.USR, "[seek] player not ready");
        } else {
            getQCirclePlayer().seek(j3);
        }
    }

    public void setForbidReport(boolean z16) {
        this.mForbidReport = z16;
    }

    public void setLoopBack(boolean z16) {
        if (getQCirclePlayer() == null) {
            return;
        }
        if (!getQCirclePlayer().isReady()) {
            RFWLog.w(getLogTag(), RFWLog.USR, "[setLoopBack] player not ready");
        }
        getQCirclePlayer().setLoopback(z16);
    }

    public void setOutPutMute(boolean z16) {
        if (getQCirclePlayer() == null) {
            return;
        }
        if (!getQCirclePlayer().isReady()) {
            RFWLog.w(getLogTag(), RFWLog.USR, "[setOutPutMute] player not ready");
        } else {
            getQCirclePlayer().setOutputMute(z16);
        }
    }

    public void setPlayRate(float f16) {
        if (getQCirclePlayer() == null) {
            QLog.d("BaseVideoView", 1, "setPlayRate play null:" + f16 + "|" + hashCode());
            return;
        }
        if (!getQCirclePlayer().isReady()) {
            RFWLog.w(getLogTag(), RFWLog.USR, "[setPlayRate error] player not ready," + f16 + "|" + hashCode());
            return;
        }
        getQCirclePlayer().setPlayRate(f16);
    }

    public void start() {
        RFWPlayerPreRenderHelper.getInstance().releaseClickRender();
        if (getQCirclePlayer() == null) {
            return;
        }
        if (!getQCirclePlayer().isReady()) {
            RFWLog.w(getLogTag(), RFWLog.USR, "[start] player not ready");
            return;
        }
        if (!getQCirclePlayer().isPlaying()) {
            getQCirclePlayer().start();
            reportVideoStartPlay();
        }
        keepScreenOnOff(true);
        playTimer();
    }

    public void stop() {
        if (getQCirclePlayer() == null) {
            return;
        }
        getQCirclePlayer().stop();
        releaseTimer();
        RFWPlayerMonitor.g().resetPosition(this.mPlayOptions);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public void timeUpdateCallBack() {
        ISuperPlayer superPlayer = getSuperPlayer();
        if (superPlayer != null && !superPlayer.isPausing()) {
            if (EventControlUtils.throttlingAtOnce(getLogTag() + "timeUpdateCallBack", uq3.c.h2())) {
                long currentPositionMs = superPlayer.getCurrentPositionMs();
                updateMonitorPosition(superPlayer, currentPositionMs);
                if (!superPlayer.isPlaying()) {
                    return;
                }
                long durationMs = superPlayer.getDurationMs();
                int i3 = 0;
                if (durationMs == 0 && getProgressBar() != null) {
                    getProgressBar().a().setProgress(0);
                }
                if (!this.mIsDragSeekBar && currentPositionMs != 0) {
                    RFWVideoDurationHelper.g().recordDuration(getPlayOptionUrl(), currentPositionMs, durationMs, false, getPlayRate());
                    int i16 = (int) durationMs;
                    if (EventControlUtils.throttlingAtOnce(getLogTag() + "eventControl", getDynamicTimeInterval(i16))) {
                        sendProgressChangeMessage((int) currentPositionMs, i16);
                        if (getProgressBar() != null) {
                            i3 = (int) (getProgressBar().a().getMax() * ((((float) currentPositionMs) * 1.0f) / ((float) durationMs)));
                        }
                        updateProgress(i3);
                    }
                }
            }
        }
    }

    public RFWVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RFWVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mForbidReport = false;
        initProgressBarListeners();
    }

    public void setLoopBack(boolean z16, int i3, int i16) {
        if (getQCirclePlayer() == null) {
            return;
        }
        if (!getQCirclePlayer().isReady()) {
            RFWLog.w(getLogTag(), RFWLog.USR, "[setLoopBack] player not ready");
        }
        getQCirclePlayer().setLoopback(z16, i3, i16);
    }

    public void onSecondBufferEnd() {
    }

    public void onSecondBufferStart() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void receiveVideoPrepared() {
    }

    protected void reportVideoStartPlay() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onLifecycleRelease(RFWPlayer rFWPlayer) {
    }

    protected void reportVideoPassivePause(int i3, int i16, long j3, long j16, long j17) {
    }
}
