package com.qzone.reborn.feedx.video.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import com.qzone.reborn.feedx.video.QZonePlayer;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.sender.aspect.ThrottlingDelay;
import com.tencent.richframework.sender.util.EventControlUtils;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.view.ISPlayerVideoView;
import java.lang.ref.WeakReference;
import lh.e;
import lh.f;
import lh.g;
import lh.i;

/* compiled from: P */
/* loaded from: classes37.dex */
public abstract class QZoneBaseVideoView<T> extends QZoneBaseWidgetView<T> implements Handler.Callback, SeekBar.OnSeekBarChangeListener, i {
    private kh.c C;
    private c D;
    private b E;
    private a F;
    private d G;
    private volatile boolean H;

    /* renamed from: e, reason: collision with root package name */
    protected com.qzone.reborn.feedx.video.c f55847e;

    /* renamed from: f, reason: collision with root package name */
    private Handler f55848f;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f55849h;

    /* renamed from: i, reason: collision with root package name */
    private QZonePlayer f55850i;

    /* renamed from: m, reason: collision with root package name */
    private mh.c f55851m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static class a implements lh.b {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QZoneBaseVideoView> f55856a;

        public a(QZoneBaseVideoView qZoneBaseVideoView) {
            this.f55856a = new WeakReference<>(qZoneBaseVideoView);
        }

        @Override // lh.b
        public void onVideoPlayError(int i3, int i16, int i17, String str) {
            QZoneBaseVideoView u06 = QZoneBaseVideoView.u0(this.f55856a);
            if (u06 == null) {
                return;
            }
            u06.onVideoPlayError(i3, i16, i17, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static class b implements e {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QZoneBaseVideoView> f55857a;

        public b(QZoneBaseVideoView qZoneBaseVideoView) {
            this.f55857a = new WeakReference<>(qZoneBaseVideoView);
        }

        @Override // lh.e
        public void a(QZonePlayer qZonePlayer) {
            QZoneBaseVideoView u06 = QZoneBaseVideoView.u0(this.f55857a);
            if (u06 == null) {
                return;
            }
            RFWLog.d(u06.getLogTag(), RFWLog.USR, "onVideoPrepared");
            u06.onVideoPrepared(qZonePlayer.i());
        }

        @Override // lh.e
        public void b(QZonePlayer qZonePlayer) {
            QZoneBaseVideoView u06 = QZoneBaseVideoView.u0(this.f55857a);
            if (u06 == null) {
                return;
            }
            RFWLog.d(u06.getLogTag(), RFWLog.USR, "onFirstFrameRendered");
            u06.firstFrameRenderCallBack();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static class c implements f {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QZoneBaseVideoView> f55858a;

        public c(QZoneBaseVideoView qZoneBaseVideoView) {
            this.f55858a = new WeakReference<>(qZoneBaseVideoView);
        }

        @Override // lh.f
        public void a(QZonePlayer qZonePlayer) {
            QZoneBaseVideoView u06 = QZoneBaseVideoView.u0(this.f55858a);
            if (u06 == null) {
                return;
            }
            RFWLog.d(u06.getLogTag(), RFWLog.USR, "onInitSuccess");
            u06.s0();
            u06.r0(qZonePlayer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static class d implements g {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QZoneBaseVideoView> f55859a;

        public d(QZoneBaseVideoView qZoneBaseVideoView) {
            this.f55859a = new WeakReference<>(qZoneBaseVideoView);
        }
    }

    public QZoneBaseVideoView(Context context) {
        this(context, null);
    }

    private int getDynamicTimeInterval(int i3) {
        return Math.max(Math.min(i3 / 100, 340), 60);
    }

    private void initProgressBarListeners() {
        if (w0() != null) {
            w0().setOnSeekBarChangeListener(this);
        }
    }

    private void keepScreenOnOff(final boolean z16) {
        getMainHandler().post(new Runnable() { // from class: com.qzone.reborn.feedx.video.view.QZoneBaseVideoView.3
            @Override // java.lang.Runnable
            public void run() {
                QZoneBaseVideoView.this.setKeepScreenOn(z16);
            }
        });
    }

    private void q0(com.qzone.reborn.feedx.video.c cVar) {
        this.D = new c(this);
        cVar.b().f(this.D);
        this.E = new b(this);
        cVar.b().e(this.E);
        this.F = new a(this);
        cVar.b().b(this.F);
        this.G = new d(this);
        cVar.b().g(this.G);
    }

    private void releaseTimer() {
        mh.e.d().j(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void s0() {
        if (isAudio() || x0() == null) {
            return;
        }
        if (!x0().r()) {
            RFWLog.w(getLogTag(), RFWLog.USR, "[addVideoView] player not ready");
            return;
        }
        cleanOldISPlayer();
        final View m3 = x0().m();
        final ViewGroup viewGroup = (ViewGroup) m3.getParent();
        if (viewGroup != null) {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.feedx.video.view.QZoneBaseVideoView.1
                @Override // java.lang.Runnable
                public void run() {
                    ((ISPlayerVideoView) m3).disableViewCallback();
                    viewGroup.removeView(m3);
                    QZoneBaseVideoView.this.addViewToTarget(m3);
                    RFWLog.d(QZoneBaseVideoView.this.getLogTag(), RFWLog.USR, "post [addVideoView] player  ready");
                }
            });
            return;
        }
        ((ISPlayerVideoView) m3).disableViewCallback();
        addViewToTarget(m3);
        RFWLog.d(getLogTag(), RFWLog.USR, "[addVideoView] player  ready");
    }

    private void sendProgressChangeMessage(int i3, int i16) {
        Message obtain = Message.obtain();
        obtain.what = -1001;
        obtain.arg1 = i3;
        obtain.arg2 = i16;
        obtain.obj = Boolean.TRUE;
        getMainHandler().sendMessage(obtain);
    }

    @ThrottlingDelay(tag = "setSeekBar", timeInterval = 100)
    private void setSeekBarDuration(SeekBar seekBar) {
        RFWLog.d(getLogTag(), RFWLog.DEV, "setSeekBarDuration");
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

    private void updateMonitorPosition(ISuperPlayer iSuperPlayer, long j3) {
        if (iSuperPlayer.isPlaying()) {
            return;
        }
        iSuperPlayer.isBuffering();
    }

    private void updateProgress(final int i3) {
        getMainHandler().post(new Runnable() { // from class: com.qzone.reborn.feedx.video.view.QZoneBaseVideoView.2
            @Override // java.lang.Runnable
            public void run() {
                if (QZoneBaseVideoView.this.w0() != null) {
                    QZoneBaseVideoView.this.w0().setProgress(i3);
                }
                com.qzone.reborn.feedx.video.c cVar = QZoneBaseVideoView.this.f55847e;
                if (cVar != null) {
                    cVar.q(i3);
                }
            }
        });
    }

    private mh.c v0() {
        if (this.f55851m == null) {
            this.f55851m = new mh.c(isAudio());
        }
        return this.f55851m;
    }

    private QZonePlayer x0() {
        return this.f55850i;
    }

    protected abstract void B0(long j3, long j16);

    /* JADX INFO: Access modifiers changed from: protected */
    public String getLogTag() {
        if (this.f55847e != null) {
            return "QZoneBaseVideoView_" + this.f55847e.s();
        }
        return "QZoneBaseVideoView";
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public Handler getMainHandler() {
        if (this.f55848f == null) {
            this.f55848f = new Handler(Looper.getMainLooper(), this);
        }
        return this.f55848f;
    }

    public boolean getOutPutMute() {
        if (x0() == null) {
            return false;
        }
        if (!x0().r()) {
            RFWLog.w(getLogTag(), RFWLog.USR, "[getOutPutMute] player not ready");
            return false;
        }
        return x0().p();
    }

    public ISuperPlayer getSuperPlayer() {
        if (x0() == null) {
            return null;
        }
        if (!x0().r()) {
            RFWLog.w(getLogTag(), RFWLog.USR, "[getSuperPlayer] player not ready");
            return null;
        }
        return x0().i();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != -1001) {
            return false;
        }
        nh.b.d(this.f55847e, "", message.arg2, message.arg1);
        return false;
    }

    protected boolean isAudio() {
        return false;
    }

    protected boolean isForbiddenDefaultPerfReport() {
        return false;
    }

    protected boolean isNeedSeekWhenDragging() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        if (x0() == null) {
            return;
        }
        if (!x0().r()) {
            RFWLog.w(getLogTag(), RFWLog.USR, "[onStartTrackingTouch] player not ready");
            return;
        }
        x0().D();
        B0(x0().g(), x0().l());
        nh.b.f(this.f55847e, seekBar);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        EventCollector.getInstance().onStopTrackingTouchBefore(seekBar);
        if (x0() != null) {
            if (!x0().r()) {
                RFWLog.w(getLogTag(), RFWLog.USR, "[onStopTrackingTouch] player not ready");
            } else {
                x0().E(seekBar.getProgress(), seekBar.getMax());
                nh.b.g(this.f55847e, seekBar);
            }
        }
        EventCollector.getInstance().onStopTrackingTouch(seekBar);
    }

    @Override // lh.i
    public void onTimerCallback() {
        timeUpdateCallBack();
    }

    public void onVideoPrepared(ISuperPlayer iSuperPlayer) {
        if (w0() == null || this.f55850i == null) {
            return;
        }
        initProgressBarListeners();
        w0().setMax(this.f55850i.k());
    }

    public void playTimer() {
        releaseTimer();
        mh.e.d().i(this);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void release() {
        if (x0() == null) {
            return;
        }
        v0().f(this.f55847e.s());
        cleanOldISPlayer();
        releaseTimer();
        if (w0() != null) {
            w0().setProgress(0);
            w0().setOnSeekBarChangeListener(null);
        }
        getMainHandler().removeCallbacksAndMessages(null);
    }

    protected abstract void reportVideoStartPlay();

    protected void resetVariablesWhenChangeDataSource() {
        releaseTimer();
        getMainHandler().removeCallbacksAndMessages(null);
        this.H = false;
    }

    public void seek(long j3) {
        if (x0() == null) {
            return;
        }
        if (!x0().r()) {
            RFWLog.w(getLogTag(), RFWLog.USR, "[seek] player not ready");
        } else {
            x0().M(j3);
        }
    }

    public void setDynamicPlayerInterceptor(kh.c cVar) {
        this.C = cVar;
    }

    public void setInterrupt(boolean z16) {
        this.f55849h = z16;
    }

    public void setLoopBack(boolean z16) {
        if (x0() == null) {
            return;
        }
        if (!x0().r()) {
            RFWLog.w(getLogTag(), RFWLog.USR, "[setLoopBack] player not ready");
        }
        x0().O(z16);
    }

    public void setOutPutMute(boolean z16) {
        if (x0() == null) {
            return;
        }
        if (!x0().r()) {
            RFWLog.w(getLogTag(), RFWLog.USR, "[setOutPutMute] player not ready");
        } else {
            x0().Q(z16);
        }
    }

    public void setPlayRate(float f16) {
        if (x0() == null) {
            return;
        }
        if (!x0().r()) {
            RFWLog.w(getLogTag(), RFWLog.USR, "[setPlayRate error] player not ready");
        } else {
            x0().R(f16);
        }
    }

    public void start() {
        if (x0() == null) {
            return;
        }
        if (!x0().r()) {
            RFWLog.w(getLogTag(), RFWLog.USR, "[start] player not ready");
            return;
        }
        if (x0().o()) {
            RFWLog.w(getLogTag(), RFWLog.USR, "[start] isExchangeUrl");
            return;
        }
        if (x0().q()) {
            return;
        }
        setInterrupt(false);
        x0().S();
        playTimer();
        reportVideoStartPlay();
        keepScreenOnOff(true);
    }

    protected void startByNewPlayer() {
        com.qzone.reborn.feedx.video.c cVar = this.f55847e;
        if (cVar != null && !cVar.k()) {
            RFWLog.d(getLogTag(), RFWLog.USR, "setVideoPath inValid may be not onScreen");
            return;
        }
        if (this.f55847e != null) {
            this.f55850i = v0().d(this.f55847e.s());
        }
        this.f55850i.N(!isForbiddenDefaultPerfReport());
        this.f55850i.s(this.f55847e);
        RFWLog.d(getLogTag(), RFWLog.USR, "new player instance");
    }

    protected void timeUpdateCallBack() {
        ISuperPlayer superPlayer = getSuperPlayer();
        if (superPlayer == null || superPlayer.isPausing()) {
            return;
        }
        long currentPositionMs = superPlayer.getCurrentPositionMs();
        updateMonitorPosition(superPlayer, currentPositionMs);
        if (superPlayer.isPlaying()) {
            long durationMs = superPlayer.getDurationMs();
            if (durationMs == 0 && w0() != null) {
                w0().setProgress(0);
            }
            if (currentPositionMs == 0 || !superPlayer.isPlaying()) {
                return;
            }
            int i3 = (int) durationMs;
            if (EventControlUtils.throttlingAtOnce(getLogTag() + "eventControl", getDynamicTimeInterval(i3))) {
                sendProgressChangeMessage((int) currentPositionMs, i3);
                updateProgress(w0() != null ? (int) (w0().getMax() * ((((float) currentPositionMs) * 1.0f) / ((float) durationMs))) : 0);
            }
        }
    }

    public abstract SeekBar w0();

    public boolean y0() {
        return this.H;
    }

    public boolean z0() {
        QZonePlayer x06 = x0();
        if (x06 != null) {
            return x06.q();
        }
        return false;
    }

    public QZoneBaseVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void addViewToTarget(View view) {
        ((ISPlayerVideoView) view).enableViewCallback();
        addView(view, 0, new FrameLayout.LayoutParams(-1, -1));
    }

    private void cleanOldISPlayer() {
        View childAt = getChildAt(0);
        if (childAt instanceof ISPlayerVideoView) {
            removeView(childAt);
            RFWLog.d(getLogTag(), RFWLog.USR, "remove is player");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void firstFrameRenderCallBack() {
        this.H = true;
    }

    public QZoneBaseVideoView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        initProgressBarListeners();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static QZoneBaseVideoView u0(WeakReference<QZoneBaseVideoView> weakReference) {
        if (weakReference == null) {
            QLog.e("QZoneBaseVideoView", 1, "getBaseVideoView  weakReference == null");
            return null;
        }
        QZoneBaseVideoView qZoneBaseVideoView = weakReference.get();
        if (qZoneBaseVideoView != null) {
            return qZoneBaseVideoView;
        }
        QLog.e("QZoneBaseVideoView", 1, "getBaseVideoView  widgetView == null");
        return null;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i3, boolean z16) {
        if (z16) {
            setSeekBarDuration(seekBar);
            nh.b.e(this.f55847e, seekBar, i3, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0(QZonePlayer qZonePlayer) {
        kh.c cVar;
        if (qZonePlayer == null || (cVar = this.C) == null) {
            return;
        }
        qZonePlayer.d(cVar);
    }

    public void A0(com.qzone.reborn.feedx.video.c cVar) {
        if (cVar == null) {
            RFWLog.d(getLogTag(), RFWLog.USR, "startVideo error empty options");
            return;
        }
        resetVariablesWhenChangeDataSource();
        this.f55847e = cVar;
        q0(cVar);
        if (cVar.j()) {
            startByNewPlayer();
            RFWLog.d(getLogTag(), RFWLog.USR, " local video play");
        } else if (cVar.i()) {
            RFWLog.d(getLogTag(), RFWLog.USR, "preRenderPlayer  hit pre render player");
        } else {
            startByNewPlayer();
        }
    }

    public void setLoopBack(boolean z16, int i3, int i16) {
        if (x0() == null) {
            return;
        }
        if (!x0().r()) {
            RFWLog.w(getLogTag(), RFWLog.USR, "[setLoopBack] player not ready");
        }
        x0().P(z16, i3, i16);
    }

    public void onVideoPlayError(int i3, int i16, int i17, String str) {
    }
}
