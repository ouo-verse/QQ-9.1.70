package com.tencent.mobileqq.guild.feed.video;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.video.RFWPlayer;
import com.tencent.biz.richframework.video.RFWPlayerManager;
import com.tencent.biz.richframework.video.RFWProgressLoadingView;
import com.tencent.mobileqq.guild.feed.video.GuildExchangeUrlManger;
import com.tencent.mobileqq.guild.feed.widget.GuildBaseWidgetView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideo;
import com.tencent.richframework.video.IPlayerStateCallback;
import com.tencent.richframework.video.timer.IPlayerTimerCallback;
import com.tencent.richframework.video.timer.RFWVideoTimerManager;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.view.ISPlayerVideoView;

/* compiled from: P */
/* loaded from: classes13.dex */
public abstract class GuildBaseVideoView extends GuildBaseWidgetView implements Handler.Callback, SeekBar.OnSeekBarChangeListener, IPlayerStateCallback, IPlayerTimerCallback {
    protected com.tencent.mobileqq.guild.feed.video.c C;
    private boolean D;
    private RFWPlayer E;
    private volatile String F;
    private RFWProgressLoadingView G;
    private GProStVideo H;
    private int I;
    private int J;
    private boolean K;
    private b L;

    /* renamed from: d, reason: collision with root package name */
    private Handler f223947d;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f223948e;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f223949f;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f223950h;

    /* renamed from: i, reason: collision with root package name */
    protected c f223951i;

    /* renamed from: m, reason: collision with root package name */
    protected ImageView f223952m;

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class a implements GuildExchangeUrlManger.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f223954a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GProStVideo f223955b;

        a(int i3, GProStVideo gProStVideo) {
            this.f223954a = i3;
            this.f223955b = gProStVideo;
        }

        @Override // com.tencent.mobileqq.guild.feed.video.GuildExchangeUrlManger.b
        public void a(long j3, String str) {
            if (!VSNetworkHelper.isTimeOutRetCode((int) j3)) {
                GuildBaseVideoView.this.B0(this.f223955b, this.f223954a);
            }
        }

        @Override // com.tencent.mobileqq.guild.feed.video.GuildExchangeUrlManger.b
        public void b(GProStVideo gProStVideo, boolean z16) {
            GuildBaseVideoView.this.B0(gProStVideo, this.f223954a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public interface b {
        void onInitSuccess();
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        long f223957a;

        /* renamed from: b, reason: collision with root package name */
        long f223958b;

        /* renamed from: c, reason: collision with root package name */
        long f223959c;

        /* renamed from: d, reason: collision with root package name */
        long f223960d;

        public c a(long j3) {
            this.f223960d = j3;
            return this;
        }

        public c b(long j3) {
            this.f223957a = j3;
            return this;
        }

        public c c(long j3) {
            this.f223958b = j3;
            return this;
        }

        public c d(long j3) {
            this.f223959c = j3;
            return this;
        }
    }

    public GuildBaseVideoView(@NonNull Context context) {
        this(context, null);
    }

    private void A0(SeekBar seekBar, boolean z16) {
        if (seekBar == null) {
            return;
        }
        seekBar.setEnabled(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0(GProStVideo gProStVideo, int i3) {
        this.H = gProStVideo;
        this.I = i3;
        setVideoPath(gProStVideo.fileId, gProStVideo.playUrl, i3);
    }

    private void cleanOldISPlayer() {
        View childAt = getChildAt(0);
        if (childAt instanceof ISPlayerVideoView) {
            removeView(childAt);
            QLog.d("FSBaseVideoView", 1, "remove is player");
        }
    }

    private void initProgressBarListeners() {
        if (p0() != null) {
            p0().setOnSeekBarChangeListener(this);
        }
    }

    private void keepScreenOnOff(final boolean z16) {
        getMainHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.video.b
            @Override // java.lang.Runnable
            public final void run() {
                GuildBaseVideoView.this.s0(z16);
            }
        });
    }

    private void m0() {
        if (o0() == null) {
            return;
        }
        if (!o0().isReady()) {
            QLog.w("FSBaseVideoView", 1, "[addVideoView] player not ready");
            return;
        }
        cleanOldISPlayer();
        addView(o0().getVideoView(), 0, new FrameLayout.LayoutParams(-1, -1));
        QLog.w("FSBaseVideoView", 1, "[addVideoView] player  ready");
    }

    private void n0(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.d("FSBaseVideoView", 1, "generateUniqueKey():playUrl is empty");
            return;
        }
        this.F = hashCode() + "_" + str;
    }

    private void releaseTimer() {
        RFWVideoTimerManager.g().unRegisterTimerListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0(boolean z16) {
        Context context = getContext();
        if (!(context instanceof Activity)) {
            QLog.w("FSBaseVideoView", 1, "[keepScreenOnOff] getContext is null or not a activity type");
            return;
        }
        Window window = ((Activity) context).getWindow();
        if (window == null) {
            QLog.w("FSBaseVideoView", 1, "[keepScreenOnOff] getWindow is null");
        } else if (z16) {
            window.addFlags(128);
        } else {
            window.clearFlags(128);
        }
    }

    private void setSeekBarDuration(SeekBar seekBar) {
        QLog.d("FSBaseVideoView", 4, "setSeekBarDuration");
        Message obtain = Message.obtain();
        obtain.what = -1001;
        obtain.arg1 = seekBar.getProgress();
        obtain.arg2 = (int) getSuperPlayer().getDurationMs();
        obtain.obj = Boolean.FALSE;
        if (isNeedSeekWhenDragging()) {
            seek(seekBar.getProgress());
        }
        getMainHandler().sendMessage(obtain);
    }

    private void y0() {
        c cVar = this.f223951i;
        if (cVar != null) {
            x0(cVar.f223957a, cVar.f223958b, cVar.f223959c, cVar.f223960d);
            this.f223951i = null;
        }
    }

    protected void firstFrameRenderCallBack() {
        RFWProgressLoadingView rFWProgressLoadingView = this.G;
        if (rFWProgressLoadingView != null) {
            rFWProgressLoadingView.hideAnimation();
        }
        if (p0() != null) {
            p0().setVisibility(0);
            p0().setOnSeekBarChangeListener(this);
            A0(p0(), this.K);
        }
        ImageView imageView = this.f223952m;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        com.tencent.mobileqq.guild.feed.video.c cVar = this.C;
        if (cVar != null) {
            cVar.a();
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public Handler getMainHandler() {
        if (this.f223947d == null) {
            this.f223947d = new Handler(Looper.getMainLooper(), this);
        }
        return this.f223947d;
    }

    public ISuperPlayer getSuperPlayer() {
        if (o0() == null) {
            return null;
        }
        if (!o0().isReady()) {
            QLog.w("FSBaseVideoView", 1, "[getSuperPlayer] player not ready");
            return null;
        }
        return o0().getRealPlayer();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        com.tencent.mobileqq.guild.feed.video.c cVar;
        if (message.what == -1001 && (cVar = this.C) != null) {
            cVar.b("", message.arg2, message.arg1);
            return false;
        }
        return false;
    }

    protected boolean isNeedSeekWhenDragging() {
        return true;
    }

    public RFWPlayer o0() {
        return this.E;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.D = false;
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public /* synthetic */ void onBufferEnd() {
        com.tencent.richframework.video.a.a(this);
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public /* synthetic */ void onBufferStart() {
        com.tencent.richframework.video.a.b(this);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getMainHandler().removeCallbacksAndMessages(null);
        this.D = true;
        release();
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public /* synthetic */ void onDownloadAllFinish() {
        com.tencent.richframework.video.a.d(this);
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public void onFirstFrameRendered() {
        firstFrameRenderCallBack();
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public void onInitSuccess(boolean z16) {
        b bVar = this.L;
        if (bVar != null) {
            bVar.onInitSuccess();
        }
        m0();
        if (!this.D) {
            u0();
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i3, boolean z16) {
        if (this.f223950h) {
            setSeekBarDuration(seekBar);
            com.tencent.mobileqq.guild.feed.video.c cVar = this.C;
            if (cVar != null) {
                cVar.c(seekBar, i3, z16);
            }
        }
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public /* synthetic */ void onRelease() {
        com.tencent.richframework.video.a.g(this);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        if (o0() == null) {
            return;
        }
        this.f223950h = true;
        if (!o0().isReady()) {
            QLog.w("FSBaseVideoView", 1, "[onStartTrackingTouch] player not ready");
            return;
        }
        c cVar = new c();
        this.f223951i = cVar;
        cVar.b(o0().getPlayTime());
        this.f223951i.c(o0().getVideoSoloPlayTime());
        this.f223951i.d(seekBar.getProgress());
        o0().onStartTrackingTouch();
        com.tencent.mobileqq.guild.feed.video.c cVar2 = this.C;
        if (cVar2 != null) {
            cVar2.d(seekBar);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        EventCollector.getInstance().onStopTrackingTouchBefore(seekBar);
        if (o0() != null) {
            this.f223950h = false;
            if (!o0().isReady()) {
                QLog.w("FSBaseVideoView", 1, "[onStopTrackingTouch] player not ready");
            } else {
                c cVar = this.f223951i;
                if (cVar != null) {
                    cVar.a(seekBar.getProgress());
                }
                y0();
                o0().onStopTrackingTouch(seekBar.getProgress(), seekBar.getMax());
                com.tencent.mobileqq.guild.feed.video.c cVar2 = this.C;
                if (cVar2 != null) {
                    cVar2.e(seekBar);
                }
            }
        }
        EventCollector.getInstance().onStopTrackingTouch(seekBar);
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public void onTimerCallback() {
        timeUpdateCallBack();
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public /* synthetic */ void onVideoLoopEnd() {
        com.tencent.richframework.video.a.j(this);
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public /* synthetic */ void onVideoLoopStart() {
        com.tencent.richframework.video.a.k(this);
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public void onVideoPassivePause(int i3, int i16, long j3, long j16) {
        v0(i3, i16, j3, j16);
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public /* synthetic */ void onVideoPlayError(int i3, int i16, int i17, String str) {
        com.tencent.richframework.video.a.m(this, i3, i16, i17, str);
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public void onVideoPrepared() {
        if (o0() != null && o0().getRealPlayer() != null) {
            ISuperPlayer realPlayer = o0().getRealPlayer();
            if (p0() != null) {
                initProgressBarListeners();
                p0().setMax((int) realPlayer.getDurationMs());
            }
            com.tencent.mobileqq.guild.feed.video.c cVar = this.C;
            if (cVar != null) {
                cVar.g(realPlayer);
            }
        }
    }

    public abstract SeekBar p0();

    public void pause() {
        if (o0() == null) {
            return;
        }
        if (!o0().isReady()) {
            QLog.w("FSBaseVideoView", 1, "[pause] player not ready");
        } else if (o0().isPlaying()) {
            o0().pause();
            this.f223948e = true;
            w0(o0().getPlayTime(), o0().getVideoSoloPlayTime());
            keepScreenOnOff(false);
        }
    }

    public void playTimer() {
        releaseTimer();
        RFWVideoTimerManager.g().registerTimerListener(this);
    }

    public void q0() {
        if (o0() == null) {
            return;
        }
        o0().cleanSoPlayTimeRangList();
        o0().init(this, null, 122);
    }

    public boolean r0() {
        return this.f223948e;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void release() {
        if (o0() == null) {
            return;
        }
        RFWPlayerManager.g().releasePlayer(this.F);
        cleanOldISPlayer();
        releaseTimer();
        this.f223948e = false;
        if (p0() != null) {
            p0().setProgress(0);
            p0().setOnSeekBarChangeListener(null);
        }
        this.f223952m = null;
        getMainHandler().removeCallbacksAndMessages(null);
    }

    protected abstract void reportVideoStartPlay();

    protected void resetVariablesWhenChangeDataSource() {
        releaseTimer();
        getMainHandler().removeCallbacksAndMessages(null);
        getMainHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.video.GuildBaseVideoView.2
            @Override // java.lang.Runnable
            public void run() {
                GuildBaseVideoView.this.z0();
            }
        });
    }

    public void seek(long j3) {
        if (o0() == null) {
            return;
        }
        if (!o0().isReady()) {
            QLog.w("FSBaseVideoView", 1, "[seek] player not ready");
        } else {
            o0().seek(j3);
        }
    }

    public void setBaseVideoViewListenerSets(com.tencent.mobileqq.guild.feed.video.c cVar) {
        this.C = cVar;
    }

    public void setHasPaused(boolean z16) {
        this.f223948e = z16;
    }

    public void setInitListener(b bVar) {
        this.L = bVar;
    }

    public void setInterrupt(boolean z16) {
        this.f223949f = z16;
    }

    public void setLoadingView(View view) {
        if (view != null) {
            this.G.setLoadingView(view);
        }
    }

    public void setLoopBack(boolean z16) {
        if (o0() == null) {
            return;
        }
        if (!o0().isReady()) {
            QLog.w("FSBaseVideoView", 1, "[setLoopBack] player not ready");
        }
        o0().setLoopback(z16);
    }

    public void setOutPutMute(boolean z16) {
        if (o0() == null) {
            return;
        }
        if (!o0().isReady()) {
            QLog.w("FSBaseVideoView", 1, "[setOutPutMute] player not ready");
        } else {
            o0().setOutputMute(z16);
        }
    }

    public void setPlayRate(float f16) {
        if (o0() == null) {
            return;
        }
        o0().setPlayRate(f16);
    }

    public void setSupportSeek(boolean z16) {
        A0(p0(), z16);
        this.K = z16;
    }

    public void setVideoCover(ImageView imageView) {
        this.f223952m = imageView;
    }

    public void setVideoPath(String str, String str2, int i3) {
        n0(str2);
        resetVariablesWhenChangeDataSource();
        this.E = RFWPlayerManager.g().obtainNewPlayer(this.F);
        if (o0() == null) {
            return;
        }
        q0();
        o0().setVideoPath(str, str2, i3);
    }

    public void setVideoWithExchangeUrl(GProStVideo gProStVideo, int i3) {
        GuildExchangeUrlManger.f().e(getContext().hashCode(), gProStVideo, new a(i3, gProStVideo));
    }

    public void start() {
        if (o0() == null) {
            return;
        }
        if (!o0().isReady()) {
            QLog.w("FSBaseVideoView", 1, "[start] player not ready");
            return;
        }
        if (!o0().isPlaying()) {
            setInterrupt(false);
            o0().start();
            this.f223948e = false;
            playTimer();
            reportVideoStartPlay();
            keepScreenOnOff(true);
        }
    }

    @CallSuper
    protected void timeUpdateCallBack() {
        ISuperPlayer superPlayer = getSuperPlayer();
        if (superPlayer == null) {
            return;
        }
        double currentPositionMs = superPlayer.getCurrentPositionMs();
        float durationMs = (float) superPlayer.getDurationMs();
        final int i3 = 0;
        if (durationMs == 0.0f && p0() != null) {
            p0().setProgress(0);
        }
        if (this.f223950h || currentPositionMs == 0.0d || o0().isPausing()) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = -1001;
        obtain.arg1 = (int) currentPositionMs;
        obtain.arg2 = (int) durationMs;
        obtain.obj = Boolean.TRUE;
        getMainHandler().sendMessage(obtain);
        if (p0() != null) {
            i3 = (int) (p0().getMax() * (currentPositionMs / durationMs));
        }
        if (this.J != i3) {
            getMainHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.video.GuildBaseVideoView.3
                @Override // java.lang.Runnable
                public void run() {
                    if (GuildBaseVideoView.this.p0() != null) {
                        GuildBaseVideoView.this.p0().setProgress(i3);
                    }
                }
            });
            this.J = i3;
        }
    }

    public void u0() {
        if (o0() == null) {
            return;
        }
        if (!o0().isReady()) {
            QLog.w("FSBaseVideoView", 1, "[replay] player not ready");
        } else {
            o0().replay();
            this.f223948e = false;
        }
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public /* synthetic */ void updateDownloadState(long j3, long j16, long j17) {
        com.tencent.richframework.video.a.o(this, j3, j16, j17);
    }

    protected abstract void v0(int i3, int i16, long j3, long j16);

    protected abstract void w0(long j3, long j16);

    protected abstract void x0(long j3, long j16, long j17, long j18);

    protected void z0() {
        ImageView imageView = this.f223952m;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        if (p0() != null) {
            p0().setVisibility(8);
        }
        RFWProgressLoadingView rFWProgressLoadingView = this.G;
        if (rFWProgressLoadingView != null) {
            rFWProgressLoadingView.showAnimation();
        }
    }

    public GuildBaseVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setLoadingView(View view, int i3) {
        if (view != null) {
            this.G.setLoadingView(view);
            this.G.setScreenOrientation(i3);
        }
    }

    public GuildBaseVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.J = 0;
        this.K = true;
        initProgressBarListeners();
        this.G = new RFWProgressLoadingView(context);
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public void onCompletion() {
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public void onSeekComplete() {
    }
}
