package com.tencent.mobileqq.guild.feed.video;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.video.RFWPlayer;
import com.tencent.biz.richframework.video.RFWProgressLoadingView;
import com.tencent.mobileqq.guild.feed.video.GuildExchangeUrlManger;
import com.tencent.mobileqq.guild.feed.widget.GuildBaseWidgetView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideo;
import com.tencent.richframework.video.IPlayerStateCallback;
import com.tencent.richframework.video.timer.IPlayerTimerCallback;
import com.tencent.richframework.video.timer.RFWVideoTimerManager;
import com.tencent.superplayer.api.ISuperPlayer;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedListBaseVideoView<T> extends GuildBaseWidgetView<T> implements Handler.Callback, IPlayerStateCallback, IPlayerTimerCallback {
    private int C;
    private boolean D;
    GProStVideo E;
    private Handler F;
    private boolean G;

    /* renamed from: d, reason: collision with root package name */
    private RFWPlayer f223970d;

    /* renamed from: e, reason: collision with root package name */
    private RFWProgressLoadingView f223971e;

    /* renamed from: f, reason: collision with root package name */
    private b f223972f;

    /* renamed from: h, reason: collision with root package name */
    protected c f223973h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f223974i;

    /* renamed from: m, reason: collision with root package name */
    private String f223975m;

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class a implements GuildExchangeUrlManger.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f223976a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GProStVideo f223977b;

        a(int i3, GProStVideo gProStVideo) {
            this.f223976a = i3;
            this.f223977b = gProStVideo;
        }

        @Override // com.tencent.mobileqq.guild.feed.video.GuildExchangeUrlManger.b
        public void a(long j3, String str) {
            QLog.d("GuildFeedListBaseVideoView", 1, "[onChangeError] pos = " + GuildFeedListBaseVideoView.this.C + ", errorCode = " + j3 + ", msg = " + str);
            if (!VSNetworkHelper.isTimeOutRetCode((int) j3)) {
                GuildFeedListBaseVideoView.this.u0(this.f223977b, this.f223976a);
            }
        }

        @Override // com.tencent.mobileqq.guild.feed.video.GuildExchangeUrlManger.b
        public void b(GProStVideo gProStVideo, boolean z16) {
            QLog.d("GuildFeedListBaseVideoView", 4, "[onChangeSuccess] pos = " + GuildFeedListBaseVideoView.this.C);
            GuildFeedListBaseVideoView.this.u0(gProStVideo, this.f223976a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public interface b {
        void onInitSuccess();
    }

    public GuildFeedListBaseVideoView(@NonNull Context context) {
        super(context);
        this.D = false;
        this.G = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("guild_feed_video_view_remove_enable_122791655", true);
    }

    private void m0() {
        if (o0() == null) {
            return;
        }
        if (!o0().isReady()) {
            QLog.w("GuildFeedListBaseVideoView", 1, "[addVideoView] player not ready");
            return;
        }
        View videoView = o0().getVideoView();
        q0();
        addView(videoView, 0, new FrameLayout.LayoutParams(-1, -1));
        QLog.i("GuildFeedListBaseVideoView", 1, "[addVideoView] pos = " + this.C + ", hashCode = " + hashCode());
    }

    private void n0(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.d("GuildFeedListBaseVideoView", 1, "generateUniqueKey():playUrl is empty");
            return;
        }
        this.f223975m = hashCode() + "_" + str;
    }

    private void playTimer() {
        releaseTimer();
        RFWVideoTimerManager.g().registerTimerListener(this);
    }

    private void q0() {
        removeAllViews();
    }

    private void releaseTimer() {
        RFWVideoTimerManager.g().unRegisterTimerListener(this);
    }

    private void resetVariablesWhenChangeDataSource() {
        releaseTimer();
        getMainHandler().removeCallbacksAndMessages(null);
        getMainHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.video.GuildFeedListBaseVideoView.3
            @Override // java.lang.Runnable
            public void run() {
                GuildFeedListBaseVideoView.this.s0();
            }
        });
    }

    private void setVideoPath(String str, String str2, int i3) {
        n0(str2);
        resetVariablesWhenChangeDataSource();
        this.f223970d = d.a().d(this.f223975m);
        if (o0() == null) {
            QLog.e("GuildFeedListBaseVideoView", 1, "[setVideoPath] newRFWPlayer error for get null, pos = " + this.C);
            return;
        }
        p0();
        o0().setVideoPath(str, str2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(GProStVideo gProStVideo, int i3) {
        QLog.d("GuildFeedListBaseVideoView", 4, "[setVideoPathAfterExchange] pos = " + this.C);
        this.E = gProStVideo;
        setVideoPath(gProStVideo.fileId, gProStVideo.playUrl, i3);
    }

    private void v0() {
        if (getSuperPlayer() == null) {
            return;
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            getSuperPlayer().setXYaxis(2);
            requestLayout();
        } else {
            getMainHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.video.GuildFeedListBaseVideoView.2
                @Override // java.lang.Runnable
                public void run() {
                    GuildFeedListBaseVideoView.this.getSuperPlayer().setXYaxis(2);
                    GuildFeedListBaseVideoView.this.requestLayout();
                }
            });
        }
    }

    public synchronized void a() {
        q0();
        if (o0() == null) {
            QLog.e("GuildFeedListBaseVideoView", 1, "[releasePlayer] 01, player is null, pos = " + this.C + ", hashCode = " + hashCode());
            d.a().g(this.f223975m);
            return;
        }
        QLog.e("GuildFeedListBaseVideoView", 1, "[releasePlayer] 02, pos = " + this.C + ", hashCode = " + hashCode());
        d.a().g(this.f223975m);
        releaseTimer();
        o0().release();
        this.D = false;
        getMainHandler().removeCallbacksAndMessages(null);
    }

    @Override // com.tencent.mobileqq.guild.feed.widget.GuildBaseWidgetView, com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object obj, int i3) {
        this.C = i3;
    }

    protected void firstFrameRenderCallBack() {
        RFWProgressLoadingView rFWProgressLoadingView = this.f223971e;
        if (rFWProgressLoadingView != null) {
            rFWProgressLoadingView.hideAnimation();
        }
        c cVar = this.f223973h;
        if (cVar != null) {
            cVar.a();
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.widget.GuildBaseWidgetView, com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public Handler getMainHandler() {
        if (this.F == null) {
            this.F = new Handler(Looper.getMainLooper(), this);
        }
        return this.F;
    }

    public boolean getOutPutMute() {
        if (o0() == null) {
            return false;
        }
        if (!o0().isReady()) {
            QLog.w("GuildFeedListBaseVideoView", 1, "[getOutPutMute] player not ready");
            return false;
        }
        return o0().isOutputMute();
    }

    public ISuperPlayer getSuperPlayer() {
        if (o0() == null) {
            return null;
        }
        if (!o0().isReady()) {
            QLog.w("GuildFeedListBaseVideoView", 1, "[getSuperPlayer] player not ready");
            return null;
        }
        return o0().getRealPlayer();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        c cVar;
        int i3 = message.what;
        if (i3 != -1002) {
            if (i3 == -1001 && (cVar = this.f223973h) != null) {
                cVar.b("", message.arg2, message.arg1);
                return false;
            }
            return false;
        }
        c cVar2 = this.f223973h;
        if (cVar2 != null) {
            cVar2.f();
            return false;
        }
        return false;
    }

    public boolean isPlaying() {
        return this.D;
    }

    public RFWPlayer o0() {
        return this.f223970d;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f223974i = true;
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public /* synthetic */ void onBufferEnd() {
        com.tencent.richframework.video.a.a(this);
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public /* synthetic */ void onBufferStart() {
        com.tencent.richframework.video.a.b(this);
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public /* synthetic */ void onCompletion() {
        com.tencent.richframework.video.a.c(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        QLog.w("GuildFeedListBaseVideoView", 1, "[onDetachedFromWindow] pos= " + this.C);
        getMainHandler().removeCallbacksAndMessages(null);
        this.f223974i = false;
        a();
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
        QLog.i("GuildFeedListBaseVideoView", 4, "[onInitSuccess] pos = " + this.C);
        b bVar = this.f223972f;
        if (bVar != null) {
            bVar.onInitSuccess();
        }
        m0();
        if (this.f223974i) {
            r0();
        }
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public /* synthetic */ void onRelease() {
        com.tencent.richframework.video.a.g(this);
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public /* synthetic */ void onSeekComplete() {
        com.tencent.richframework.video.a.h(this);
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public void onTimerCallback() {
        ISuperPlayer superPlayer = getSuperPlayer();
        if (superPlayer == null) {
            return;
        }
        double currentPositionMs = superPlayer.getCurrentPositionMs();
        float durationMs = (float) superPlayer.getDurationMs();
        if (currentPositionMs == 0.0d || o0().isPausing()) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = -1001;
        obtain.arg1 = (int) currentPositionMs;
        obtain.arg2 = (int) durationMs;
        obtain.obj = Boolean.TRUE;
        getMainHandler().sendMessage(obtain);
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public void onVideoLoopStart() {
        getMainHandler().sendEmptyMessage(-1002);
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public /* synthetic */ void onVideoPassivePause(int i3, int i16, long j3, long j16) {
        com.tencent.richframework.video.a.l(this, i3, i16, j3, j16);
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public void onVideoPlayError(int i3, int i16, int i17, String str) {
        QLog.e("GuildFeedListBaseVideoView", 1, "[onVideoPlayError] module = " + i3 + ", errorType = " + i16 + ", code = " + i17 + ", extraInfo = " + str);
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public void onVideoPrepared() {
        if (o0() != null && o0().getRealPlayer() != null) {
            ISuperPlayer realPlayer = o0().getRealPlayer();
            v0();
            c cVar = this.f223973h;
            if (cVar != null) {
                cVar.g(realPlayer);
            }
        }
    }

    public void p0() {
        if (o0() == null) {
            QLog.e("GuildFeedListBaseVideoView", 1, "[initPlayer] error for player is null, pos = " + this.C);
            return;
        }
        o0().cleanSoPlayTimeRangList();
        o0().init(this, null, 122);
        QLog.i("GuildFeedListBaseVideoView", 1, "[initPlayer] pos = " + this.C + ", hashCode = " + hashCode());
    }

    public void r0() {
        if (o0() == null) {
            QLog.w("GuildFeedListBaseVideoView", 1, "[replay] fail player is null, pos= " + this.C);
            return;
        }
        if (!o0().isReady()) {
            QLog.w("GuildFeedListBaseVideoView", 1, "[replay] player not ready, pos= " + this.C);
            return;
        }
        o0().replay();
        this.D = true;
    }

    protected void s0() {
        QLog.d("GuildFeedListBaseVideoView", 4, "[resetUI] set visible");
        RFWProgressLoadingView rFWProgressLoadingView = this.f223971e;
        if (rFWProgressLoadingView != null) {
            rFWProgressLoadingView.showAnimation();
        }
    }

    public void setBaseVideoViewListenerSets(c cVar) {
        this.f223973h = cVar;
    }

    public void setInitListener(b bVar) {
        this.f223972f = bVar;
    }

    public void setLoadingView(View view, int i3) {
        RFWProgressLoadingView rFWProgressLoadingView = this.f223971e;
        if (rFWProgressLoadingView != null) {
            rFWProgressLoadingView.setLoadingView(view);
            this.f223971e.setScreenOrientation(i3);
        }
    }

    public void setLoopBack(boolean z16) {
        if (o0() == null) {
            return;
        }
        if (!o0().isReady()) {
            QLog.w("GuildFeedListBaseVideoView", 1, "[setLoopBack] player not ready");
        }
        o0().setLoopback(z16);
    }

    public void setOutPutMute(boolean z16) {
        if (o0() == null) {
            return;
        }
        if (!o0().isReady()) {
            QLog.w("GuildFeedListBaseVideoView", 1, "[setOutPutMute] player not ready");
        } else {
            o0().setOutputMute(z16);
        }
    }

    public void setVideoWithExchangeUrl(GProStVideo gProStVideo, int i3) {
        QLog.d("GuildFeedListBaseVideoView", 4, "[setVideoWithExchangeUrl] pos = " + this.C);
        GuildExchangeUrlManger.f().e(getContext().hashCode(), gProStVideo, new a(i3, gProStVideo));
    }

    public void start() {
        if (o0() == null) {
            QLog.w("GuildFeedListBaseVideoView", 1, "[start] fail player is null, pos= " + this.C);
            return;
        }
        if (!o0().isReady()) {
            QLog.w("GuildFeedListBaseVideoView", 1, "[start] player not ready");
            return;
        }
        if (!o0().isPlaying()) {
            QLog.d("GuildFeedListBaseVideoView", 1, "[start] pos=" + this.C + ", tag = RFWPlayer_" + o0().hashCode());
            o0().start();
            this.D = true;
            playTimer();
        }
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public /* synthetic */ void updateDownloadState(long j3, long j16, long j17) {
        com.tencent.richframework.video.a.o(this, j3, j16, j17);
    }

    public GuildFeedListBaseVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GuildFeedListBaseVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.D = false;
        this.G = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("guild_feed_video_view_remove_enable_122791655", true);
        this.f223971e = new RFWProgressLoadingView(context);
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public void onVideoLoopEnd() {
    }
}
