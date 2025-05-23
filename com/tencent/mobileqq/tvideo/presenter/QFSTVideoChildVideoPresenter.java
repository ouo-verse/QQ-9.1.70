package com.tencent.mobileqq.tvideo.presenter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.util.Consumer;
import androidx.recyclerview.widget.RecyclerView;
import ay2.e;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.events.QCircleConfigChangeEvent;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSVideoFeedPlayEvent;
import com.tencent.biz.qqcircle.immersive.model.bottombarrage.QFSVideoPauseEvent;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC;
import com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerUpperData;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWOnTvkPermissionTimeOutListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayErrorStatusListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerCompletionListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLooperListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerOnInfoListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSdkInitListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSecondBufferListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWTVKOnNetVideoInfoListener;
import com.tencent.biz.richframework.video.rfw.player.monitor.RFWPlayerMonitor;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWPlayerReportInfo;
import com.tencent.common.config.AppSetting;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.event.QCircleSeekAreaEvent;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.thread.QAdThreadManager;
import com.tencent.mobileqq.tvideo.authpay.a;
import com.tencent.mobileqq.tvideo.channel.event.QFSTVideoScreenChangedEvent;
import com.tencent.mobileqq.tvideo.channel.event.QFSTVideoScreenTouchEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoAuthPayPanelEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoAuthPayReloadEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoFeedsItemSelectedEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoFloatingWindowEntranceVisibleEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoFloatingWindowEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoFloatingWindowPlayEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoFloatingWindowStatusEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoMidAdCountDownStartEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoNetworkChangedEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoOnPlayEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoPlayOrPauseEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoRewardAdClickEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoScrollToNextEvent;
import com.tencent.mobileqq.tvideo.floatingwindow.TVideoFloatingWindowController;
import com.tencent.mobileqq.tvideo.like.TVideoLikeAnimationView;
import com.tencent.mobileqq.tvideo.player.TVideoQFSVideoView;
import com.tencent.mobileqq.tvideo.presenter.QFSTVideoChildVideoPresenter;
import com.tencent.mobileqq.tvideo.recorder.TVideoPlayRecorder;
import com.tencent.mobileqq.tvideo.temporaryauth.d;
import com.tencent.mobileqq.tvideo.view.PlayerTipsView;
import com.tencent.mobileqq.tvideo.view.TVideoLoadingView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.screen.ScreenUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.view.TVKPlayerVideoView;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.view.ISPlayerVideoView;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import feedcloud.FeedCloudMeta$StFeed;
import hu2.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.Foreground;
import tvideo.TVideoTemporaryAuth$AuthorizePlayData;
import tvideo.Video;
import tvideo.VideoBaseInfo;
import vx2.Definition;
import vx2.FeedItemPlayRate;
import vx2.PlayerTips;
import xx2.b;

/* loaded from: classes19.dex */
public class QFSTVideoChildVideoPresenter extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements e.c {
    private TVideoQFSVideoView J;
    private TVideoLoadingView K;
    private LinearLayout L;
    private ImageView M;
    private ViewGroup N;
    private ConstraintLayout.LayoutParams P;
    private int Q;
    private int R;
    private FeedCloudMeta$StFeed S;
    private Video T;
    private int U;
    private boolean V;
    private QFSVideoFeedPlayEvent W;
    private hu2.b X;
    private ViewGroup Y;
    private View Z;

    /* renamed from: a0, reason: collision with root package name */
    private ImageView f304626a0;

    /* renamed from: b0, reason: collision with root package name */
    private xx2.b f304627b0;

    /* renamed from: c0, reason: collision with root package name */
    private TVideoLikeAnimationView f304628c0;

    /* renamed from: d0, reason: collision with root package name */
    private ViewGroup f304629d0;

    /* renamed from: e0, reason: collision with root package name */
    private jy2.j f304630e0;

    /* renamed from: h0, reason: collision with root package name */
    private String f304633h0;

    /* renamed from: i0, reason: collision with root package name */
    private ay2.e f304634i0;

    /* renamed from: j0, reason: collision with root package name */
    private View f304635j0;

    /* renamed from: k0, reason: collision with root package name */
    private View f304636k0;

    /* renamed from: m0, reason: collision with root package name */
    private com.tencent.mobileqq.tvideo.authpay.a f304638m0;

    /* renamed from: n0, reason: collision with root package name */
    private ViewGroup f304639n0;

    /* renamed from: o0, reason: collision with root package name */
    private ViewGroup f304640o0;

    /* renamed from: p0, reason: collision with root package name */
    private ViewGroup f304641p0;

    /* renamed from: q0, reason: collision with root package name */
    private TextView f304642q0;

    /* renamed from: r0, reason: collision with root package name */
    private ay2.f f304643r0;

    /* renamed from: s0, reason: collision with root package name */
    private TVideoFloatingWindowController f304644s0;

    /* renamed from: t0, reason: collision with root package name */
    private zx2.c f304645t0;

    /* renamed from: u0, reason: collision with root package name */
    private boolean f304646u0;

    /* renamed from: v0, reason: collision with root package name */
    private boolean f304647v0;

    /* renamed from: x0, reason: collision with root package name */
    private long f304649x0;

    /* renamed from: y0, reason: collision with root package name */
    private long f304650y0;

    /* renamed from: z0, reason: collision with root package name */
    private volatile boolean f304651z0;
    private final ArrayList<View> I = new ArrayList<>();

    /* renamed from: f0, reason: collision with root package name */
    private boolean f304631f0 = false;

    /* renamed from: g0, reason: collision with root package name */
    private volatile Boolean f304632g0 = Boolean.FALSE;

    /* renamed from: l0, reason: collision with root package name */
    private com.tencent.biz.qqcircle.immersive.feed.event.an f304637l0 = null;

    /* renamed from: w0, reason: collision with root package name */
    private boolean f304648w0 = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class a implements b.d {
        a() {
        }

        @Override // xx2.b.d
        public void a(Float f16, Float f17) {
            if (!ScreenUtils.isLandscape() && jy2.g.T(QFSTVideoChildVideoPresenter.this.T)) {
                QFSTVideoChildVideoPresenter.this.f304628c0.f(f16.floatValue(), f17.floatValue());
            } else {
                QFSTVideoChildVideoPresenter qFSTVideoChildVideoPresenter = QFSTVideoChildVideoPresenter.this;
                qFSTVideoChildVideoPresenter.R3(qFSTVideoChildVideoPresenter.j());
            }
        }

        @Override // xx2.b.d
        public void onSingleTap() {
            if (QFSTVideoChildVideoPresenter.this.l3()) {
                cy2.b.e().i(QFSTVideoChildVideoPresenter.this.f304635j0, QFSTVideoChildVideoPresenter.this.f304636k0, QFSTVideoChildVideoPresenter.this.f304648w0);
                cy2.b.e().o();
            } else {
                QFSTVideoChildVideoPresenter qFSTVideoChildVideoPresenter = QFSTVideoChildVideoPresenter.this;
                qFSTVideoChildVideoPresenter.R3(qFSTVideoChildVideoPresenter.j());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class b implements IRFWOnTvkPermissionTimeOutListener {
        b() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWOnTvkPermissionTimeOutListener
        public void onPermissionTimeout() {
            int i3;
            if (QFSTVideoChildVideoPresenter.this.f304634i0 != null) {
                i3 = QFSTVideoChildVideoPresenter.this.f304634i0.x();
            } else {
                i3 = 0;
            }
            QLog.d("QFSTVideoChildVideoPresenter", 1, jy2.g.g(QFSTVideoChildVideoPresenter.this.T) + " authpay onPermissionTimeout mCurrentPosition = " + QFSTVideoChildVideoPresenter.this.Q + " mSeekStopProgress = " + i3);
            QFSTVideoChildVideoPresenter.this.f304646u0 = true;
            if (QFSTVideoChildVideoPresenter.this.n3(8)) {
                QFSTVideoChildVideoPresenter.this.O3(null, true);
            } else {
                QFSTVideoChildVideoPresenter.this.I2();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class c implements IRFWPlayerSecondBufferListener {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            QFSTVideoChildVideoPresenter.this.l4();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d() {
            QFSTVideoChildVideoPresenter.this.j4();
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSecondBufferListener
        public void onSecondBufferEnd() {
            QFSTVideoChildVideoPresenter.this.x0().post(new Runnable() { // from class: com.tencent.mobileqq.tvideo.presenter.y
                @Override // java.lang.Runnable
                public final void run() {
                    QFSTVideoChildVideoPresenter.c.this.c();
                }
            });
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSecondBufferListener
        public void onSecondBufferStart() {
            QFSTVideoChildVideoPresenter.this.x0().post(new Runnable() { // from class: com.tencent.mobileqq.tvideo.presenter.x
                @Override // java.lang.Runnable
                public final void run() {
                    QFSTVideoChildVideoPresenter.c.this.d();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class d extends RFWPlayerIOC {
        d() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QCircleReportBean getReportBean() {
            return QFSTVideoChildVideoPresenter.this.getReportBean();
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
        public RFWPlayerReportInfo<e30.b> getBusinessReportInfo() {
            return gb0.b.m(((QFSBaseFeedChildPresenter) QFSTVideoChildVideoPresenter.this).E.o("KEY_RFW_VIDEO_FEED_POI", Integer.valueOf(((QFSBaseFeedChildPresenter) QFSTVideoChildVideoPresenter.this).f85018i)));
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
        /* renamed from: getPlayerUpperData */
        public RFWPlayerUpperData getUpperData() {
            Context context;
            RFWPlayerUpperData mayNeedSpr = new RFWPlayerUpperData().setDtCustomPgId(QFSTVideoChildVideoPresenter.this.q0()).setMayNeedSpr(true);
            if (QFSTVideoChildVideoPresenter.this.J != null) {
                context = QFSTVideoChildVideoPresenter.this.J.getContext();
            } else {
                context = null;
            }
            return mayNeedSpr.setContext(context);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
        public boolean isValid() {
            if (QFSTVideoChildVideoPresenter.this.J0() && QFSTVideoChildVideoPresenter.this.J != null) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class e implements IRFWPlayerPrepareListener {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(RFWPlayer rFWPlayer) {
            QFSTVideoChildVideoPresenter.this.f304634i0.W((int) rFWPlayer.getRealPlayer().getDurationMs());
            QFSTVideoChildVideoPresenter.this.l4();
            QFSTVideoChildVideoPresenter.this.g3();
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onFirstFrameRendered(RFWPlayer rFWPlayer) {
            QFSTVideoChildVideoPresenter.this.B2();
            gy2.a.b(8);
            QCircleFolderFunnelCollect.record(QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_FIRST_RENDER);
            RFWPlayerMonitor.g().cancelFirstFrameRenderedColorLog();
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onVideoPrepared(final RFWPlayer rFWPlayer) {
            gy2.a.b(6);
            QCircleFolderFunnelCollect.record(QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_PREPARED);
            QLog.d("QFSTVideoChildVideoPresenter", 1, "onVideoPrepared");
            QFSTVideoChildVideoPresenter.this.D2(rFWPlayer.getRealPlayer());
            QFSTVideoChildVideoPresenter.this.x0().post(new Runnable() { // from class: com.tencent.mobileqq.tvideo.presenter.z
                @Override // java.lang.Runnable
                public final void run() {
                    QFSTVideoChildVideoPresenter.e.this.b(rFWPlayer);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class f implements IRFWPlayerLooperListener {
        f() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLooperListener
        public void onVideoLoopEnd() {
            QLog.d("QFSTVideoChildVideoPresenter", 1, jy2.g.g(QFSTVideoChildVideoPresenter.this.T) + "onVideoLoopEnd ");
            QFSTVideoChildVideoPresenter qFSTVideoChildVideoPresenter = QFSTVideoChildVideoPresenter.this;
            qFSTVideoChildVideoPresenter.R = qFSTVideoChildVideoPresenter.R + 1;
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLooperListener
        public void onVideoLoopStart() {
            QLog.d("QFSTVideoChildVideoPresenter", 1, jy2.g.g(QFSTVideoChildVideoPresenter.this.T) + "onVideoLoopStart ");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class h implements a.f {
        h() {
        }

        @Override // com.tencent.mobileqq.tvideo.authpay.a.f
        public void a(boolean z16) {
            QLog.d("QFSTVideoChildVideoPresenter", 1, jy2.g.g(QFSTVideoChildVideoPresenter.this.T) + " authpay webview  onVisible = " + z16);
            if (z16) {
                QFSTVideoChildVideoPresenter.this.L3();
            }
        }

        @Override // com.tencent.mobileqq.tvideo.authpay.a.f
        public void onAuthSuccess() {
            QLog.d("QFSTVideoChildVideoPresenter", 1, jy2.g.g(QFSTVideoChildVideoPresenter.this.T) + " authpay webview  onAuthSuccess ");
        }
    }

    private void A2() {
        x0().post(new Runnable() { // from class: com.tencent.mobileqq.tvideo.presenter.s
            @Override // java.lang.Runnable
            public final void run() {
                QFSTVideoChildVideoPresenter.this.x3();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A3() {
        b4(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void B2() {
        T t16 = this.f85017h;
        if (t16 == 0) {
            return;
        }
        SimpleEventBus.getInstance().dispatchEvent(new QFSTVideoOnPlayEvent(((FeedCloudMeta$StFeed) t16).f398449id.get(), hashCode()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B3(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QFSTVideoScrollToNextEvent qFSTVideoScrollToNextEvent = new QFSTVideoScrollToNextEvent();
        qFSTVideoScrollToNextEvent.setNextPos(this.f85018i + 1);
        SimpleEventBus.getInstance().dispatchEvent(qFSTVideoScrollToNextEvent);
        EventCollector.getInstance().onViewClicked(view);
    }

    private void C2(QFSTVideoScreenChangedEvent qFSTVideoScreenChangedEvent) {
        ay2.e eVar = this.f304634i0;
        if (eVar != null) {
            eVar.O(qFSTVideoScreenChangedEvent.getUiState());
        }
        ay2.f fVar = this.f304643r0;
        if (fVar != null) {
            fVar.b(E0(), qFSTVideoScreenChangedEvent.getUiState());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void C3(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        jy2.g.Q((Activity) view.getContext(), 1);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void D2(ISuperPlayer iSuperPlayer) {
        VideoBaseInfo videoBaseInfo;
        if (this.J != null && this.f85017h != 0 && iSuperPlayer != null && J0() && this.J.getQCirclePlayer() != null && !this.f304651z0) {
            QLog.d("QFSTVideoChildVideoPresenter", 1, "doOnVideoPrepare");
            Video video = this.T;
            if (video != null && (videoBaseInfo = video.video_base_info) != null) {
                TVideoPlayRecorder.f304757a.c(iSuperPlayer, videoBaseInfo.vid);
            }
            KeyEvent.Callback videoView = this.J.getQCirclePlayer().getVideoView();
            if (videoView instanceof TVKPlayerVideoView) {
                ((TVKPlayerVideoView) videoView).setXYaxis(0);
            } else if (videoView instanceof ISPlayerVideoView) {
                ((ISPlayerVideoView) videoView).setXYaxis(0);
            }
            F2(iSuperPlayer.getCurTVKNetVideoInfo(), iSuperPlayer.getDurationMs());
            gy2.a.b(7);
            QCircleFolderFunnelCollect.record(QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_START_PLAY);
            k4(true);
            this.f304634i0.s(iSuperPlayer);
            N3();
            com.tencent.biz.qqcircle.immersive.feed.event.ap apVar = new com.tencent.biz.qqcircle.immersive.feed.event.ap(false);
            apVar.e(true);
            apVar.d(((FeedCloudMeta$StFeed) this.f85017h).f398449id.get());
            T0(apVar);
            b4(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D3(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        m4();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void E2(boolean z16) {
        VideoReport.unbindVideoPlayerInfo(this.J);
        hu2.b bVar = this.X;
        if (bVar != null) {
            bVar.o();
        }
        if (this.J.getSuperPlayer().isPausing()) {
            return;
        }
        this.J.pause();
        T0(new com.tencent.biz.qqcircle.immersive.feed.event.ap(true));
        if (z16) {
            this.f304634i0.N();
        }
        cy2.b.e().A(false);
        SimpleEventBus.getInstance().dispatchEvent(new QFSVideoPauseEvent(((FeedCloudMeta$StFeed) this.f85017h).f398449id.get(), true, this.Q));
        u4("pause");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E3(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.J != null) {
            m4();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void F2(TVKNetVideoInfo tVKNetVideoInfo, long j3) {
        if (this.J != null && this.f85017h != 0) {
            gy2.b bVar = new gy2.b();
            bVar.l((FeedCloudMeta$StFeed) this.f85017h);
            bVar.n(this.T);
            bVar.m(tVKNetVideoInfo);
            bVar.i(this.f304633h0);
            bVar.h((int) j3);
            bVar.k(this.f85018i);
            com.tencent.mobileqq.tvideo.authpay.a aVar = this.f304638m0;
            if (aVar != null) {
                bVar.j(aVar.n());
            }
            QLog.d("QFSTVideoChildVideoPresenter", 1, "dtReportBindVideoData");
            gy2.c.e(bVar, this.J);
        }
    }

    private void G2() {
        if (y2() || (o3() && !e1(this.J))) {
            RFWLog.d("QFSTVideoChildVideoPresenter", RFWLog.USR, "executeFromSelected return");
        }
        RFWLog.d("QFSTVideoChildVideoPresenter", RFWLog.USR, "executeFromSelected");
        i4();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G3() {
        View view = this.C;
        if (view != null && (view.getParent() instanceof RecyclerView) && ((RecyclerView) this.C.getParent()).getAdapter() != null && ((RecyclerView) this.C.getParent()).getAdapter().getItemCount() > this.f85018i) {
            this.Q = 100;
            QFSTVideoScrollToNextEvent qFSTVideoScrollToNextEvent = new QFSTVideoScrollToNextEvent();
            qFSTVideoScrollToNextEvent.setNextPos(this.f85018i + 1);
            SimpleEventBus.getInstance().dispatchEvent(qFSTVideoScrollToNextEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H2() {
        if (y2() || k3()) {
            return;
        }
        hu2.b bVar = this.X;
        if (bVar != null && bVar.getIsPlayingAd()) {
            RFWLog.i("QFSTVideoChildVideoPresenter", RFWLog.USR, "executePlay isPlayingAd" + hashCode());
            return;
        }
        if (this.J.getSuperPlayer() == null) {
            RFWLog.d("QFSTVideoChildVideoPresenter", RFWLog.USR, "execute a new player" + hashCode());
            i4();
            return;
        }
        if (!this.J.isRelease() && !this.J.getQCirclePlayer().isDeInit()) {
            if (this.J.getSuperPlayer().isPlaying()) {
                RFWLog.d("QFSTVideoChildVideoPresenter", RFWLog.USR, "isPlaying when resume:" + hashCode());
                x0().post(new Runnable() { // from class: com.tencent.mobileqq.tvideo.presenter.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        QFSTVideoChildVideoPresenter.this.y3();
                    }
                });
                return;
            }
            if (this.J.getSuperPlayer().isPausing()) {
                n();
                this.f304634i0.a0();
                RFWLog.d("QFSTVideoChildVideoPresenter", RFWLog.USR, "startFromPause hashCode:" + hashCode());
                return;
            }
            Object b16 = this.E.b("tvideo_auth_pay_show_panel_web");
            if ((b16 instanceof Boolean) && ((Boolean) b16).booleanValue()) {
                RFWLog.d("QFSTVideoChildVideoPresenter", RFWLog.USR, "isPanelWebSHow = " + b16);
                return;
            }
            i4();
            return;
        }
        RFWLog.d("QFSTVideoChildVideoPresenter", RFWLog.USR, "execute a new player released" + hashCode());
        i4();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean H3(boolean z16, View view, MotionEvent motionEvent) {
        f4(motionEvent);
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I2() {
        int i3;
        ay2.e eVar = this.f304634i0;
        if (eVar != null) {
            i3 = eVar.x();
        } else {
            i3 = 0;
        }
        int max = Math.max(this.Q, i3);
        this.Q = max;
        this.Q = Math.max(max, jy2.g.j(this.T));
        r4();
        com.tencent.mobileqq.tvideo.authpay.a aVar = this.f304638m0;
        if (aVar != null) {
            aVar.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I3() {
        if (!j3()) {
            Y3(false);
        }
    }

    private long J2() {
        if (jy2.g.J(this.T)) {
            return 0L;
        }
        Object b16 = this.E.b("tvideo_feed_play_progress");
        if (b16 instanceof Long) {
            Long l3 = (Long) b16;
            if (l3.longValue() > 0) {
                return l3.longValue();
            }
        }
        return jy2.c.f411160a.b(this.T);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J3() {
        jy2.i.f411173a.c(this.f304629d0, "\u5df2\u6682\u505c");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K2, reason: merged with bridge method [inline-methods] */
    public void F3(TVKNetVideoInfo tVKNetVideoInfo, boolean z16, TVideoTemporaryAuth$AuthorizePlayData tVideoTemporaryAuth$AuthorizePlayData) {
        if (!E0()) {
            return;
        }
        if (com.tencent.mobileqq.tvideo.temporaryauth.d.e(tVideoTemporaryAuth$AuthorizePlayData, jy2.g.s(this.T))) {
            X3();
        } else if (z16) {
            I2();
        } else {
            P3(tVKNetVideoInfo);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean K3(TVKNetVideoInfo tVKNetVideoInfo) {
        if (tVKNetVideoInfo == null || jy2.g.z((FeedCloudMeta$StFeed) this.f85017h) || !n3(tVKNetVideoInfo.getSt())) {
            return false;
        }
        O3(tVKNetVideoInfo, false);
        return true;
    }

    private void L2(QCircleConfigChangeEvent qCircleConfigChangeEvent) {
        Configuration configuration;
        if (m0() != Foreground.getTopActivity() || (configuration = qCircleConfigChangeEvent.configuration) == null) {
            return;
        }
        w2(configuration.orientation);
        if (J0()) {
            TVideoFloatingWindowController tVideoFloatingWindowController = this.f304644s0;
            if (tVideoFloatingWindowController == null || !tVideoFloatingWindowController.h()) {
                n();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L3() {
        this.f304641p0.setVisibility(0);
        this.E.o("tvideo_auth_pay_show_panel_web", Boolean.TRUE);
        QFSTVideoAuthPayPanelEvent qFSTVideoAuthPayPanelEvent = new QFSTVideoAuthPayPanelEvent();
        qFSTVideoAuthPayPanelEvent.setShow(true);
        SimpleEventBus.getInstance().dispatchEvent(qFSTVideoAuthPayPanelEvent);
        this.f304634i0.w().setEnabled(false);
        this.f304627b0.w(true);
        u4("pay_block");
        c4(this.f304641p0, "pay_block");
        VideoReport.reportEvent("imp", this.f304641p0, null);
        b4(false);
        zt2.k.f();
    }

    private void M2() {
        TVideoFloatingWindowController tVideoFloatingWindowController = this.f304644s0;
        if (tVideoFloatingWindowController != null && tVideoFloatingWindowController.h()) {
            this.f304644s0.b();
            this.f304644s0 = null;
        }
    }

    private void N2(QFSTVideoFloatingWindowEvent qFSTVideoFloatingWindowEvent) {
        TVideoQFSVideoView tVideoQFSVideoView;
        if ((qFSTVideoFloatingWindowEvent.isEnterFloatingWindow() && m0() != Foreground.getTopActivity()) || (tVideoQFSVideoView = this.J) == null) {
            return;
        }
        if (this.f304644s0 == null) {
            this.f304644s0 = new TVideoFloatingWindowController(tVideoQFSVideoView, new Consumer() { // from class: com.tencent.mobileqq.tvideo.presenter.v
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    QFSTVideoChildVideoPresenter.this.z3((Boolean) obj);
                }
            }, this.T, r0());
        }
        this.f304644s0.d(qFSTVideoFloatingWindowEvent);
    }

    private void N3() {
        long j3;
        String str;
        String str2;
        VideoBaseInfo videoBaseInfo;
        T3();
        c4(this.Y, "middle_ad");
        QLog.d("QFSTVideoChildVideoPresenter", 1, "onVideoStart");
        this.X = new hu2.b(m0(), this.Y, this.J, new g());
        Video video = this.T;
        if (video != null && (videoBaseInfo = video.video_base_info) != null) {
            String str3 = videoBaseInfo.cid;
            String str4 = videoBaseInfo.vid;
            j3 = videoBaseInfo.skip_end;
            str = str3;
            str2 = str4;
        } else {
            j3 = 0;
            str = "";
            str2 = str;
        }
        this.X.q(new b.MidAdInfo(str, str2, hy2.a.f406605a.a(), j3, this.f304634i0.y(), this.f304633h0, this.U));
        cy2.b.e().A(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O3(final TVKNetVideoInfo tVKNetVideoInfo, final boolean z16) {
        QLog.d("QFSTVideoChildVideoPresenter", 1, " temporaryauthpay " + jy2.g.g(this.T) + " openTemporaryAuth");
        com.tencent.mobileqq.tvideo.temporaryauth.d.i(jy2.g.s(this.T), new d.b() { // from class: com.tencent.mobileqq.tvideo.presenter.m
            @Override // com.tencent.mobileqq.tvideo.temporaryauth.d.b
            public final void a(TVideoTemporaryAuth$AuthorizePlayData tVideoTemporaryAuth$AuthorizePlayData) {
                QFSTVideoChildVideoPresenter.this.F3(tVKNetVideoInfo, z16, tVideoTemporaryAuth$AuthorizePlayData);
            }
        });
    }

    private void P2(QFSTVideoFloatingWindowPlayEvent qFSTVideoFloatingWindowPlayEvent) {
        TVideoFloatingWindowController tVideoFloatingWindowController = this.f304644s0;
        if (tVideoFloatingWindowController != null) {
            tVideoFloatingWindowController.e(qFSTVideoFloatingWindowPlayEvent);
        }
    }

    private void P3(TVKNetVideoInfo tVKNetVideoInfo) {
        if (tVKNetVideoInfo != null && E0()) {
            long previewDurationSec = tVKNetVideoInfo.getPreviewDurationSec();
            this.f304649x0 = 1000 * previewDurationSec;
            if (!TextUtils.isEmpty(jy2.g.k(this.T))) {
                this.f304649x0 += this.f304650y0;
            }
            QLog.d("QFSTVideoChildVideoPresenter", 1, " authpay  previewDurationSec = " + previewDurationSec + " ; previewEndMil = " + this.f304649x0);
            QLog.d("QFSTVideoChildVideoPresenter", 1, " temporaryauthpay parseNetVideoInfo " + jy2.g.g(this.T) + " mState = " + tVKNetVideoInfo.getSt());
            com.tencent.mobileqq.tvideo.authpay.a aVar = this.f304638m0;
            if (aVar != null) {
                aVar.v(Long.valueOf(previewDurationSec));
            }
            List<TVKNetVideoInfo.DefnInfo> definitionList = tVKNetVideoInfo.getDefinitionList();
            TVKNetVideoInfo.DefnInfo curDefinition = tVKNetVideoInfo.getCurDefinition();
            if (curDefinition != null && curDefinition.getDefn() != null && curDefinition.getFnName() != null) {
                Definition definition = new Definition(curDefinition.getDefn(), curDefinition.getFnName());
                ArrayList arrayList = new ArrayList();
                for (TVKNetVideoInfo.DefnInfo defnInfo : definitionList) {
                    if (defnInfo != null && defnInfo.getDefn() != null && defnInfo.getFnName() != null) {
                        arrayList.add(new Definition(defnInfo.getDefn(), defnInfo.getFnName()));
                    }
                }
                T0(new wx2.d(definition, arrayList));
            }
        }
    }

    private void Q2(QFSTVideoFloatingWindowStatusEvent qFSTVideoFloatingWindowStatusEvent) {
        TVideoFloatingWindowController tVideoFloatingWindowController = this.f304644s0;
        if (tVideoFloatingWindowController != null) {
            tVideoFloatingWindowController.f(qFSTVideoFloatingWindowStatusEvent);
        }
    }

    private void Q3(QFSTVideoPlayOrPauseEvent qFSTVideoPlayOrPauseEvent) {
        if (qFSTVideoPlayOrPauseEvent != null && E0()) {
            if (qFSTVideoPlayOrPauseEvent.isPause()) {
                S3(true);
                this.f304634i0.R();
            } else if (qFSTVideoPlayOrPauseEvent.isPlay()) {
                n();
                this.f304634i0.a0();
            }
        }
    }

    private void R2(int i3) {
        QLog.d("QFSTVideoChildVideoPresenter", 1, "handleMidAdCountDownStartEvent: adType " + i3);
        x0().post(new Runnable() { // from class: com.tencent.mobileqq.tvideo.presenter.g
            @Override // java.lang.Runnable
            public final void run() {
                QFSTVideoChildVideoPresenter.this.A3();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void R3(String str) {
        TVideoQFSVideoView tVideoQFSVideoView;
        T t16 = this.f85017h;
        if (t16 != 0 && ((FeedCloudMeta$StFeed) t16).f398449id.get().equals(str) && (tVideoQFSVideoView = this.J) != null && tVideoQFSVideoView.getSuperPlayer() != null) {
            m4();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S2(boolean z16) {
        this.f304631f0 = z16;
        if (z16) {
            if (l3() && cy2.b.e().k()) {
                this.Z.setVisibility(0);
            } else {
                this.Z.setVisibility(8);
            }
            Z2();
            u4("middle_ad");
            VideoReport.reportEvent("imp", this.Y, gy2.c.g());
            Y3(true);
            b4(false);
            this.f304634i0.w().setEnabled(false);
            return;
        }
        this.Z.setVisibility(8);
        u4(QzoneWebMusicJsPlugin.EVENT_PLAYING);
        Y3(false);
        b4(true);
        this.f304634i0.w().setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S3(boolean z16) {
        TVideoQFSVideoView tVideoQFSVideoView = this.J;
        if (tVideoQFSVideoView != null && tVideoQFSVideoView.getSuperPlayer() != null) {
            E2(z16);
            RFWLog.d(getTAG(), RFWLog.USR, "pause success");
        }
    }

    private void T2(QFSTVideoNetworkChangedEvent qFSTVideoNetworkChangedEvent) {
        QLog.d("QFSTVideoChildVideoPresenter", 1, "handleNetworkChangedEvent,isFeedSelected=" + this.f304632g0);
        if (qFSTVideoNetworkChangedEvent.getIsMobileNetwork() && this.f304632g0.booleanValue()) {
            A2();
        }
    }

    private void T3() {
        hu2.b bVar = this.X;
        if (bVar != null) {
            bVar.u();
            this.X = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void U2(QFSTVideoOnPlayEvent qFSTVideoOnPlayEvent) {
        String feedId = qFSTVideoOnPlayEvent.getFeedId();
        int playHashCode = qFSTVideoOnPlayEvent.getPlayHashCode();
        T t16 = this.f85017h;
        if (t16 != 0) {
            if (!((FeedCloudMeta$StFeed) t16).f398449id.get().equals(feedId) || playHashCode != hashCode()) {
                TVideoFloatingWindowController tVideoFloatingWindowController = this.f304644s0;
                if (tVideoFloatingWindowController != null && tVideoFloatingWindowController.h()) {
                    return;
                }
                a();
            }
        }
    }

    private void U3() {
        l4();
        this.f304634i0.X(0);
    }

    private void V2(QFSTVideoRewardAdClickEvent qFSTVideoRewardAdClickEvent) {
        hu2.b bVar = this.X;
        if (bVar != null) {
            bVar.g(qFSTVideoRewardAdClickEvent);
        }
    }

    private void V3() {
        TVideoQFSVideoView tVideoQFSVideoView = this.J;
        if (tVideoQFSVideoView != null) {
            tVideoQFSVideoView.setReportBean(getReportBean());
        }
        LinearLayout linearLayout = this.L;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        this.f304634i0.T();
    }

    private void W2(int i3) {
        cy2.b.e().w(i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void W3(int i3, int i16) {
        String str;
        t40.a s06 = s0();
        if (s06 == null) {
            return;
        }
        if (this.W == null) {
            this.W = new QFSVideoFeedPlayEvent();
        }
        QFSVideoFeedPlayEvent qFSVideoFeedPlayEvent = this.W;
        qFSVideoFeedPlayEvent.indexInFeed = this.f85018i;
        qFSVideoFeedPlayEvent.progress = i16;
        qFSVideoFeedPlayEvent.duration = i3;
        qFSVideoFeedPlayEvent.loopCount = this.R;
        qFSVideoFeedPlayEvent.globalKey = s06.getViewModelKey();
        QFSVideoFeedPlayEvent qFSVideoFeedPlayEvent2 = this.W;
        T t16 = this.f85017h;
        String str2 = "";
        if (t16 == 0) {
            str = "";
        } else {
            str = ((FeedCloudMeta$StFeed) t16).video.playUrl.get();
        }
        qFSVideoFeedPlayEvent2.playUrl = str;
        QFSVideoFeedPlayEvent qFSVideoFeedPlayEvent3 = this.W;
        T t17 = this.f85017h;
        if (t17 != 0) {
            str2 = ((FeedCloudMeta$StFeed) t17).f398449id.get();
        }
        qFSVideoFeedPlayEvent3.feedId = str2;
        SimpleEventBus.getInstance().dispatchEvent(this.W);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X3() {
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.tvideo.presenter.QFSTVideoChildVideoPresenter.8
            @Override // java.lang.Runnable
            public void run() {
                QLog.d("QFSTVideoChildVideoPresenter", 1, " temporaryauthpay " + jy2.g.g(QFSTVideoChildVideoPresenter.this.T) + "reloadEvent");
                QFSTVideoAuthPayReloadEvent qFSTVideoAuthPayReloadEvent = new QFSTVideoAuthPayReloadEvent();
                qFSTVideoAuthPayReloadEvent.setIgnorePos(true);
                SimpleEventBus.getInstance().dispatchEvent(qFSTVideoAuthPayReloadEvent);
            }
        }, 200L);
    }

    private void Y2(QCircleSeekAreaEvent qCircleSeekAreaEvent) {
        if (J0() && this.J != null) {
            this.f304634i0.d0(qCircleSeekAreaEvent.getEvent());
        }
    }

    private void Y3(final boolean z16) {
        View view = this.C;
        if (view != null && (view.getParent() instanceof RecyclerView)) {
            this.f304647v0 = z16;
            ((RecyclerView) this.C.getParent()).setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.tvideo.presenter.e
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    boolean H3;
                    H3 = QFSTVideoChildVideoPresenter.this.H3(z16, view2, motionEvent);
                    return H3;
                }
            });
            if (z16) {
                pw2.g.b(new Runnable() { // from class: com.tencent.mobileqq.tvideo.presenter.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        QFSTVideoChildVideoPresenter.this.I3();
                    }
                }, 5000L);
            }
        }
    }

    private void Z2() {
        Iterator<View> it = this.I.iterator();
        while (it.hasNext()) {
            it.next().setVisibility(8);
        }
    }

    private void a() {
        T3();
        TVideoQFSVideoView tVideoQFSVideoView = this.J;
        if (tVideoQFSVideoView == null) {
            return;
        }
        VideoReport.unbindVideoPlayerInfo(tVideoQFSVideoView);
        this.J.release();
        U3();
    }

    private void a3(boolean z16) {
        View view = this.f85016f;
        int i3 = 0;
        if (view == null) {
            RFWLog.d("QFSTVideoChildVideoPresenter", RFWLog.USR, "[hideVideoContainer] container should not be null.");
            return;
        }
        if (!z16) {
            i3 = 8;
        }
        view.setVisibility(i3);
    }

    private void a4(Float f16) {
        VideoBaseInfo videoBaseInfo;
        Video video = this.T;
        if (video != null && (videoBaseInfo = video.video_base_info) != null) {
            com.tencent.mobileqq.tvideo.viewmodel.j.f304840b = new FeedItemPlayRate(videoBaseInfo.cid, videoBaseInfo.vid, this.f85018i, f16.floatValue());
        }
    }

    private void b3() {
        QLog.d("QFSTVideoChildVideoPresenter", 1, "initAuthPayTask");
        jx2.f fVar = new jx2.f();
        fVar.g(this.f304639n0);
        fVar.f(this.f304640o0);
        fVar.e(this.f304641p0);
        fVar.h(this.f85018i);
        c4(this.f304641p0, "pay_block");
        if (this.f304638m0 == null) {
            this.f304638m0 = new com.tencent.mobileqq.tvideo.authpay.a();
        }
        this.f304638m0.o(fVar, new h());
    }

    private void b4(boolean z16) {
        boolean z17 = true;
        QLog.d("QFSTVideoChildVideoPresenter", 1, "setFloatingWindowVisible:" + z16);
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        if (!z16 || AppSetting.t(m0())) {
            z17 = false;
        }
        simpleEventBus.dispatchEvent(new QFSTVideoFloatingWindowEntranceVisibleEvent(z17));
    }

    private void c3() {
        this.f304639n0 = (ViewGroup) this.C.findViewById(R.id.f112666oj);
        this.f304640o0 = (ViewGroup) this.C.findViewById(R.id.f112686ol);
        this.f304641p0 = (ViewGroup) this.C.findViewById(R.id.f112676ok);
        TextView textView = (TextView) this.C.findViewById(R.id.sxp);
        this.f304642q0 = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.tvideo.presenter.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSTVideoChildVideoPresenter.this.B3(view);
            }
        });
    }

    private Map<String, Object> c4(View view, String str) {
        int i3;
        HashMap hashMap = new HashMap();
        hashMap.put("poster_type", str);
        com.tencent.mobileqq.tvideo.authpay.a aVar = this.f304638m0;
        if (aVar != null && aVar.n() && com.tencent.mobileqq.tvideo.temporaryauth.d.d()) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        hashMap.put("is_exp_user", Integer.valueOf(i3));
        gy2.c.x(view, hashMap);
        return hashMap;
    }

    private void d3() {
        this.Q = 0;
        this.R = 0;
        this.f304630e0 = null;
        this.f304634i0.A();
    }

    private void d4(RFWPlayerOptions rFWPlayerOptions) {
        rFWPlayerOptions.setPlayIOC(new d());
    }

    private void e3() {
        this.f304645t0 = new zx2.c(this.f85016f, this.f304627b0, this.N, this.f304634i0);
    }

    private void e4() {
        if (l3()) {
            x0().post(new Runnable() { // from class: com.tencent.mobileqq.tvideo.presenter.t
                @Override // java.lang.Runnable
                public final void run() {
                    QFSTVideoChildVideoPresenter.this.J3();
                }
            });
        }
    }

    private void f3(View view) {
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.v2c);
        this.f304628c0 = (TVideoLikeAnimationView) view.findViewById(R.id.uko);
        this.f304627b0 = new xx2.b(frameLayout, this.N, this.f304634i0.w(), new a());
    }

    private void f4(MotionEvent motionEvent) {
        if (motionEvent != null && this.f304647v0 && motionEvent.getAction() == 2 && this.f304647v0) {
            this.f304647v0 = false;
            QLog.d("QFSTVideoChildVideoPresenter", 1, "showMidAdScrollToast showMidAdToast ");
            QQToast.makeText(m0(), "\u5e7f\u544a\u64ad\u653e5s\u540e\u5373\u53ef\u6ed1\u52a8\u5207\u6362\u5267\u96c6\u54e6", 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g3() {
        long j3;
        Video video;
        VideoBaseInfo videoBaseInfo;
        TVideoQFSVideoView tVideoQFSVideoView = this.J;
        if (tVideoQFSVideoView != null && tVideoQFSVideoView.getSuperPlayer() != null) {
            long durationMs = this.J.getSuperPlayer().getDurationMs();
            if (hy2.a.f406605a.b() && (video = this.T) != null && (videoBaseInfo = video.video_base_info) != null) {
                j3 = videoBaseInfo.skip_end;
            } else {
                j3 = 0;
            }
            this.f304630e0 = new jy2.j(durationMs - j3);
        }
    }

    private void g4(String str) {
        ay2.f fVar = this.f304643r0;
        if (fVar != null) {
            fVar.c(str);
        }
    }

    private void h3() {
        View findViewById = this.C.findViewById(R.id.f45631se);
        View findViewById2 = this.C.findViewById(R.id.f45541s6);
        View findViewById3 = this.C.findViewById(R.id.f112756os);
        this.I.clear();
        this.I.add(findViewById);
        this.I.add(findViewById2);
        this.I.add(findViewById3);
    }

    private void h4(List<PlayerTips> list, boolean z16) {
        ay2.f fVar = this.f304643r0;
        if (fVar != null) {
            fVar.d(list, z16);
        }
    }

    private void i3() {
        FeedItemPlayRate feedItemPlayRate;
        Video video = this.T;
        if (video == null || video.video_base_info == null || (feedItemPlayRate = com.tencent.mobileqq.tvideo.viewmodel.j.f304840b) == null) {
            return;
        }
        if (jy2.g.H(feedItemPlayRate, video, this.f85018i)) {
            this.J.setPlayRate(feedItemPlayRate.getPlayRate());
        } else {
            com.tencent.mobileqq.tvideo.viewmodel.j.f304840b = null;
        }
    }

    private boolean j3() {
        if (!(m0() instanceof Activity)) {
            return true;
        }
        return ((Activity) m0()).isFinishing();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void j4() {
        this.K.setVisibility(0);
        this.K.l();
    }

    private boolean k3() {
        ViewGroup viewGroup = this.f304641p0;
        if (viewGroup != null && viewGroup.getVisibility() == 0) {
            RFWLog.i("QFSTVideoChildVideoPresenter", RFWLog.USR, "mAuthPayPanel visible " + hashCode());
            return true;
        }
        return false;
    }

    private void k4(boolean z16) {
        this.J.start();
        if (z16) {
            this.J.seek(J2());
        }
        T0(new com.tencent.biz.qqcircle.immersive.feed.event.ap(false));
        jy2.i.f411173a.a(this.f304629d0);
        u4(QzoneWebMusicJsPlugin.EVENT_PLAYING);
    }

    private void l2(RFWPlayerOptions rFWPlayerOptions, String str) {
        if (rFWPlayerOptions == null) {
            return;
        }
        d4(rFWPlayerOptions);
        t2(rFWPlayerOptions);
        s2(rFWPlayerOptions);
        m2(rFWPlayerOptions);
        o2(rFWPlayerOptions);
        n2(rFWPlayerOptions);
        u2(rFWPlayerOptions);
        p2(rFWPlayerOptions);
        q2(rFWPlayerOptions);
        r2(rFWPlayerOptions);
        this.f304634i0.m(rFWPlayerOptions, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l3() {
        if (2 == m0().getResources().getConfiguration().orientation) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void l4() {
        this.K.setVisibility(8);
        this.K.m();
    }

    private void m2(RFWPlayerOptions rFWPlayerOptions) {
        rFWPlayerOptions.getListenerSet().addCompletionListener(new IRFWPlayerCompletionListener() { // from class: com.tencent.mobileqq.tvideo.presenter.i
            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerCompletionListener
            public final void onCompletion(ISuperPlayer iSuperPlayer) {
                QFSTVideoChildVideoPresenter.this.r3(iSuperPlayer);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m4() {
        TVideoQFSVideoView tVideoQFSVideoView = this.J;
        if (tVideoQFSVideoView != null && tVideoQFSVideoView.getSuperPlayer() != null) {
            if (k3()) {
                RFWLog.i("QFSTVideoChildVideoPresenter", RFWLog.USR, "togglePauseStatus  isAuthPanelShow");
                return;
            }
            if (this.J.getSuperPlayer().isPlaying()) {
                S3(true);
                this.f304634i0.R();
                gy2.c.v("pause", this.M);
            } else if (this.J.getSuperPlayer().isPausing()) {
                n();
                this.f304634i0.a0();
                gy2.c.v("start", this.M);
            }
        }
    }

    private void n2(@NonNull final RFWPlayerOptions rFWPlayerOptions) {
        rFWPlayerOptions.getListenerSet().addErrorStatusListener(new IRFWPlayErrorStatusListener() { // from class: com.tencent.mobileqq.tvideo.presenter.j
            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayErrorStatusListener
            public final void onVideoPlayError(int i3, int i16, int i17, String str) {
                QFSTVideoChildVideoPresenter.this.t3(rFWPlayerOptions, i3, i16, i17, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n3(int i3) {
        com.tencent.mobileqq.tvideo.authpay.a aVar;
        if (com.tencent.mobileqq.tvideo.temporaryauth.d.f(i3, jy2.g.s(this.T)) && (aVar = this.f304638m0) != null && aVar.n()) {
            return true;
        }
        return false;
    }

    private void n4() {
        this.f304646u0 = false;
        this.f304641p0.setVisibility(8);
        this.E.o("tvideo_auth_pay_show_panel_web", Boolean.FALSE);
    }

    private void o2(RFWPlayerOptions rFWPlayerOptions) {
        rFWPlayerOptions.getListenerSet().addLooperListeners(new f());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean o3() {
        T t16;
        if (this.S != null && (t16 = this.f85017h) != 0 && this.U == this.f85018i) {
            try {
                if (((FeedCloudMeta$StFeed) t16).f398449id.get().equals(this.S.f398449id.get()) && ((FeedCloudMeta$StFeed) this.f85017h).video.playUrl.get().equals(this.S.video.playUrl.get())) {
                    RFWLog.d("QFSTVideoChildVideoPresenter", RFWLog.USR, "fs_lifecycle , same video, playUrl = " + this.S.video.playUrl.get());
                    return true;
                }
            } catch (Exception e16) {
                RFWLog.d("QFSTVideoChildVideoPresenter", RFWLog.USR, "same video, exception = " + e16.getMessage());
            }
        }
        return false;
    }

    private void o4(String str) {
        this.f304633h0 = str;
        com.tencent.mobileqq.tvideo.authpay.a aVar = this.f304638m0;
        if (aVar != null) {
            aVar.u(str);
        }
    }

    private void p2(RFWPlayerOptions rFWPlayerOptions) {
        rFWPlayerOptions.getListenerSet().addTVKNetVideoInfoListener(new IRFWTVKOnNetVideoInfoListener() { // from class: com.tencent.mobileqq.tvideo.presenter.h
            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWTVKOnNetVideoInfoListener
            public final void onNetVideoInfo(TVKNetVideoInfo tVKNetVideoInfo) {
                QFSTVideoChildVideoPresenter.this.u3(tVKNetVideoInfo);
            }
        });
    }

    private boolean p3() {
        boolean a16 = this.J.a1();
        QLog.d("QFSTVideoChildVideoPresenter", 1, "isUsingSurfaceView = " + a16);
        return a16;
    }

    private void p4(boolean z16) {
        if (this.J == null) {
            return;
        }
        this.V = z16;
        RFWLog.d("QFSTVideoChildVideoPresenter", RFWLog.CLR, "[updateAutoScroll] mIsLoopBack: ", Boolean.valueOf(z16), " | shouldAutoScroll: ", Boolean.TRUE);
        this.J.setLoopBack(this.V);
    }

    private void q2(RFWPlayerOptions rFWPlayerOptions) {
        rFWPlayerOptions.getListenerSet().addInfoListener(new IRFWPlayerOnInfoListener() { // from class: com.tencent.mobileqq.tvideo.presenter.k
            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerOnInfoListener
            public final void onInfo(int i3, long j3, long j16, Object obj) {
                QFSTVideoChildVideoPresenter.this.v3(i3, j3, j16, obj);
            }
        });
    }

    private void q4(QFSTVideoAuthPayPanelEvent qFSTVideoAuthPayPanelEvent) {
        if (qFSTVideoAuthPayPanelEvent.isShow() && k3()) {
            if (ScreenUtils.isLandscape()) {
                this.f304642q0.setVisibility(0);
            } else {
                this.f304642q0.setVisibility(8);
            }
        }
    }

    private void r2(RFWPlayerOptions rFWPlayerOptions) {
        rFWPlayerOptions.getListenerSet().addTvkPermissionTimeOutListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r3(ISuperPlayer iSuperPlayer) {
        RFWLog.d("QFSTVideoChildVideoPresenter", RFWLog.CLR, "[onCompletion] current is auto scroll: ", Boolean.TRUE);
        T0(new wx2.i());
    }

    private void r4() {
        this.E.o("tvideo_feed_play_progress", Long.valueOf(this.Q));
        QLog.d("QFSTVideoChildVideoPresenter", 1, jy2.g.g(this.T) + " authpay updatePlayProgress mCurrentPosition " + this.Q);
    }

    private void s2(RFWPlayerOptions rFWPlayerOptions) {
        rFWPlayerOptions.getListenerSet().addPrepareListeners(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void s3(RFWPlayerOptions rFWPlayerOptions, int i3, int i16, int i17, String str) {
        ay2.e eVar = this.f304634i0;
        if (eVar != null) {
            eVar.J();
        }
        T0(new com.tencent.biz.qqcircle.immersive.feed.event.s(rFWPlayerOptions, i3, i16, i17, str, (FeedCloudMeta$StFeed) this.f85017h));
        b4(false);
    }

    private void s4(TVideoQFSVideoView tVideoQFSVideoView) {
        if (tVideoQFSVideoView == null) {
            return;
        }
        QLog.d("QFSTVideoChildVideoPresenter", 1, "updatePlayerVideoView use SufaceView");
        tVideoQFSVideoView.b1(SuperPlayerFactory.createPlayerVideoView(RFWApplication.getApplication(), false, 1));
    }

    private void t2(RFWPlayerOptions rFWPlayerOptions) {
        rFWPlayerOptions.getListenerSet().addSDKInitListeners(new IRFWPlayerSdkInitListener() { // from class: com.tencent.mobileqq.tvideo.presenter.l
            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSdkInitListener
            public final void onInitSuccess(RFWPlayer rFWPlayer) {
                QFSTVideoChildVideoPresenter.this.w3(rFWPlayer);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t3(final RFWPlayerOptions rFWPlayerOptions, final int i3, final int i16, final int i17, final String str) {
        if (rFWPlayerOptions.isPlayerByDirectIP()) {
            QLog.d("QFSTVideoChildVideoPresenter", 1, "error play by ip return");
        } else {
            u4("error_play");
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.tvideo.presenter.n
                @Override // java.lang.Runnable
                public final void run() {
                    QFSTVideoChildVideoPresenter.this.s3(rFWPlayerOptions, i3, i16, i17, str);
                }
            });
        }
    }

    private void u2(RFWPlayerOptions rFWPlayerOptions) {
        rFWPlayerOptions.getListenerSet().addSecondBufferListeners(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u3(TVKNetVideoInfo tVKNetVideoInfo) {
        QLog.d("QFSTVideoChildVideoPresenter", 1, " temporaryauthpay TVKNetVideoInfoListener");
        if (!K3(tVKNetVideoInfo)) {
            P3(tVKNetVideoInfo);
        }
    }

    private void u4(String str) {
        VideoBaseInfo videoBaseInfo;
        Video video = this.T;
        if (video != null && (videoBaseInfo = video.video_base_info) != null) {
            gy2.c.E(videoBaseInfo.cid, videoBaseInfo.vid, this.Q, str);
        }
    }

    private void v2(Video video) {
        zx2.c cVar = this.f304645t0;
        if (cVar != null) {
            cVar.a(video);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v3(int i3, long j3, long j16, Object obj) {
        QLog.d("QFSTVideoChildVideoPresenter", 1, "addOnInfoListener what = " + i3 + " extra = " + obj);
        if (i3 == 111) {
            g4("\u6e05\u6670\u5ea6\u5207\u6362\u6210\u529f");
            return;
        }
        if (ad4.a.f25920s == i3) {
            g4("\u6e05\u6670\u5ea6\u5207\u6362\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
            return;
        }
        if (1021 == i3) {
            QLog.d("QFSTVideoChildVideoPresenter", 1, "flowid what = " + i3 + " extra = " + obj);
            o4((String) obj);
            return;
        }
        if (i3 == ad4.a.V) {
            QLog.d("QFSTVideoChildVideoPresenter", 1, "set view secure failed");
            if (!p3()) {
                QLog.d("QFSTVideoChildVideoPresenter", 1, "updatePlayerVideoView");
                s4(this.J);
            }
        }
    }

    private void w2(int i3) {
        this.f304634i0.n(i3);
        this.f304627b0.u(this.f304634i0.w());
        if (i3 == 2) {
            this.N.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
            if (this.f304631f0 && cy2.b.e().k()) {
                this.Z.setVisibility(0);
            } else {
                this.Z.setVisibility(8);
            }
            this.f304642q0.setVisibility(this.f304641p0.getVisibility());
            return;
        }
        this.N.setLayoutParams(this.P);
        this.Z.setVisibility(8);
        Z2();
        this.f304642q0.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void w3(RFWPlayer rFWPlayer) {
        this.J.setOutPutMute(false);
        this.J.setLoopBack(this.V);
        T t16 = this.f85017h;
        if (t16 != 0) {
            this.J.setPlayRate(QCirclePluginGlobalInfo.t(((FeedCloudMeta$StFeed) t16).f398449id.get()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void x2() {
        QLog.d("QFSTVideoChildVideoPresenter", 1, "bindAuthPayData");
        com.tencent.mobileqq.tvideo.authpay.a aVar = this.f304638m0;
        if (aVar != null) {
            aVar.x(jy2.g.f(this.T));
            this.f304638m0.t(this.f85018i);
            if (!jy2.g.F((FeedCloudMeta$StFeed) this.f85017h)) {
                this.f304638m0.q();
            }
            this.f304638m0.z();
            this.f304638m0.y();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x3() {
        ViewGroup viewGroup;
        try {
            if (!com.tencent.mobileqq.tvideo.viewmodel.j.f304841c && com.tencent.mobileqq.tvideo.viewmodel.j.f304839a && (viewGroup = this.f304629d0) != null) {
                com.tencent.mobileqq.tvideo.viewmodel.j.f304841c = true;
                jy2.i.f411173a.c(viewGroup, "\u6b63\u5728\u4f7f\u7528\u6d41\u91cf\u64ad\u653e");
            }
        } catch (Exception e16) {
            QLog.e("QFSTVideoChildVideoPresenter", 1, "handleNetworkChangedEvent exception=" + e16);
        }
    }

    private boolean y2() {
        if (s0() != null && this.J != null && J0()) {
            return false;
        }
        RFWLog.d("QFSTVideoChildVideoPresenter", RFWLog.USR, "canNotPlay");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y3() {
        b4(true);
    }

    private boolean z2(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        if (feedCloudMeta$StFeed != null) {
            return false;
        }
        RFWLog.d("QFSTVideoChildVideoPresenter", RFWLog.USR, "onBindData is null: " + i3);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z3(Boolean bool) {
        if (bool == null) {
            return;
        }
        if (bool.booleanValue()) {
            n();
        } else {
            S3(false);
        }
    }

    @Override // ay2.e.c
    public void C(com.tencent.biz.qqcircle.immersive.feed.event.ag agVar) {
        String str;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.S;
        if (feedCloudMeta$StFeed == null) {
            str = "";
        } else {
            str = feedCloudMeta$StFeed.f398449id.get();
        }
        agVar.c(str);
        T0(agVar);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        super.C0(hVar);
        if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.t) {
            RFWLog.d("QFSTVideoChildVideoPresenter", RFWLog.USR, "onError retry:" + hashCode());
            i4();
            return;
        }
        if (hVar instanceof wx2.h) {
            TVideoQFSVideoView tVideoQFSVideoView = this.J;
            if (tVideoQFSVideoView != null) {
                wx2.h hVar2 = (wx2.h) hVar;
                tVideoQFSVideoView.setPlayRate(hVar2.getSpeed());
                g4("\u5df2\u5207\u6362\u4e3a" + hVar2.getSpeed() + "\u500d\u901f\u64ad\u653e");
                a4(Float.valueOf(hVar2.getSpeed()));
                return;
            }
            return;
        }
        if (hVar instanceof wx2.g) {
            if (this.J != null) {
                HashMap hashMap = new HashMap();
                hashMap.put(1, 0L);
                hashMap.put(2, 0L);
                if (((wx2.g) hVar).getSkipHeadTail()) {
                    Video video = this.T;
                    if (video != null && video.video_base_info != null) {
                        hashMap.put(2, Long.valueOf(this.T.video_base_info.skip_end));
                    }
                    g4("\u5df2\u8bbe\u7f6e\u8df3\u8fc7\u7247\u5934\u7247\u5c3e");
                } else {
                    g4("\u5df2\u8bbe\u7f6e\u4e0d\u8df3\u8fc7\u7247\u5934\u7247\u5c3e");
                }
                this.J.Y0(6, hashMap);
                g3();
                return;
            }
            return;
        }
        if (hVar instanceof wx2.b) {
            TVideoQFSVideoView tVideoQFSVideoView2 = this.J;
            if (tVideoQFSVideoView2 != null) {
                wx2.b bVar = (wx2.b) hVar;
                tVideoQFSVideoView2.Z0(bVar.getDefinition().getDefinitionId(), 0);
                ArrayList arrayList = new ArrayList();
                arrayList.add(new PlayerTips("\u6b63\u5728\u5207\u6362", R.color.f158017al3));
                arrayList.add(new PlayerTips(bVar.getDefinition().getShowName(), R.color.cwm));
                arrayList.add(new PlayerTips("\u6e05\u6670\u5ea6\uff0c\u8bf7\u7a0d\u5019", R.color.f158017al3));
                h4(arrayList, true);
                hy2.a.f406605a.c(bVar.getDefinition().getDefinitionId());
                return;
            }
            return;
        }
        if (hVar instanceof wx2.a) {
            S0();
            return;
        }
        if (hVar instanceof wx2.f) {
            g4(((wx2.f) hVar).getTips());
            return;
        }
        if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.ap) {
            hu2.b bVar2 = this.X;
            if (bVar2 != null) {
                bVar2.x(!((com.tencent.biz.qqcircle.immersive.feed.event.ap) hVar).b());
            }
            if (((com.tencent.biz.qqcircle.immersive.feed.event.ap) hVar).b()) {
                e4();
                return;
            }
            return;
        }
        if ((hVar instanceof wx2.e) && ((wx2.e) hVar).getIsPanelShow()) {
            cy2.b.e().u();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public boolean D0(e40.p pVar) {
        super.D0(pVar);
        return this.f304634i0.C(pVar);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void M0() {
        super.M0();
        RFWLog.d("QFSTVideoChildVideoPresenter", RFWLog.USR, "[onDetachedFromWindow] mPos:" + this.f85018i + " | hashCode:" + hashCode() + " | pageId:" + y0());
        this.f304634i0.I();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: M3, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        if (z2(feedCloudMeta$StFeed, i3)) {
            return;
        }
        super.L0(feedCloudMeta$StFeed, i3);
        this.f304628c0.setFeed((FeedCloudMeta$StFeed) this.f85017h, this.f85018i);
        this.T = jy2.g.q(feedCloudMeta$StFeed);
        a3(true);
        V3();
        d3();
        x2();
        cy2.b.e().n(this.f304635j0, this.f304636k0);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    @SuppressLint({"SourceLockedOrientationActivity"})
    public void N0(@NonNull View view) {
        super.N0(view);
        this.f304648w0 = "page_ugqqoa_play".equals(r0());
        this.f85016f = view;
        this.f304634i0 = new ay2.e(m0(), this, this.f304648w0);
        this.M = (ImageView) this.f85016f.findViewById(R.id.va5);
        this.J = (TVideoQFSVideoView) this.f85016f.findViewById(R.id.f74163vi);
        this.Y = (ViewGroup) this.f85016f.findViewById(R.id.z6h);
        View findViewById = this.f85016f.findViewById(R.id.z6d);
        this.Z = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.tvideo.presenter.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QFSTVideoChildVideoPresenter.C3(view2);
            }
        });
        this.J.setAlpha(0.99f);
        this.J.setContentDescription("\u64ad\u653e\uff0c\u6682\u505c\u6309\u94ae");
        this.J.setImportantForAccessibility(1);
        this.K = (TVideoLoadingView) view.findViewById(R.id.f112716oo);
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.f41551hd);
        this.N = viewGroup;
        this.P = (ConstraintLayout.LayoutParams) viewGroup.getLayoutParams();
        this.L = (LinearLayout) view.findViewById(R.id.f46311u9);
        this.f304629d0 = (ViewGroup) view.findViewById(R.id.f112776ou);
        this.M.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.tvideo.presenter.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QFSTVideoChildVideoPresenter.this.D3(view2);
            }
        });
        ImageView imageView = (ImageView) this.C.findViewById(R.id.f56812lm);
        this.f304626a0 = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.tvideo.presenter.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QFSTVideoChildVideoPresenter.this.E3(view2);
            }
        });
        this.f304643r0 = new ay2.f((PlayerTipsView) view.findViewById(R.id.f25960c9));
        this.f304635j0 = view.findViewById(R.id.f100085rj);
        this.f304636k0 = view.findViewById(R.id.t_f);
        this.f304634i0.M(view, this.f304635j0);
        h3();
        f3(view);
        gy2.c.z(this.f304626a0);
        gy2.c.z(this.M);
        c3();
        b3();
        e3();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void S0() {
        TVideoFloatingWindowController tVideoFloatingWindowController = this.f304644s0;
        if (tVideoFloatingWindowController != null && tVideoFloatingWindowController.h()) {
            RFWLog.i("QFSTVideoChildVideoPresenter", RFWLog.USR, "stop scrollToNextItem, in floatingWindowMode");
        } else {
            x0().post(new Runnable() { // from class: com.tencent.mobileqq.tvideo.presenter.w
                @Override // java.lang.Runnable
                public final void run() {
                    QFSTVideoChildVideoPresenter.this.G3();
                }
            });
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public boolean f1() {
        return e1(this.J);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QCircleConfigChangeEvent.class);
        eventClass.add(QFSTVideoOnPlayEvent.class);
        eventClass.add(QCircleSeekAreaEvent.class);
        eventClass.add(QFSTVideoNetworkChangedEvent.class);
        eventClass.add(QFSTVideoScreenTouchEvent.class);
        eventClass.add(QFSTVideoScreenChangedEvent.class);
        eventClass.add(QFSTVideoAuthPayPanelEvent.class);
        eventClass.add(QFSTVideoFloatingWindowEvent.class);
        eventClass.add(QFSTVideoFloatingWindowPlayEvent.class);
        eventClass.add(QFSTVideoFloatingWindowStatusEvent.class);
        eventClass.add(QFSTVideoMidAdCountDownStartEvent.class);
        eventClass.add(QFSTVideoRewardAdClickEvent.class);
        eventClass.add(QFSTVideoPlayOrPauseEvent.class);
        return eventClass;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void i4() {
        this.f304650y0 = J2();
        QLog.d("QFSTVideoChildVideoPresenter", 1, jy2.g.g(this.T) + "authpay startANewPlayer skipStartMilSec = " + this.f304650y0);
        gy2.a.b(5);
        QCircleFolderFunnelCollect.record(QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_AUTO_PLAY);
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = (FeedCloudMeta$StFeed) this.f85017h;
        this.J.setData(feedCloudMeta$StFeed, this.f85018i);
        QFSVideoView.D = new WeakReference<>(this.J);
        String N = com.tencent.biz.qqcircle.immersive.utils.r.N(feedCloudMeta$StFeed.video.playUrl.get());
        RFWPlayerOptions tVKPlayerOption = RFWPlayerOptions.obtain(QCircleHostConstants._SceneID.TENCENT_VIDEO_PLAYER()).setFileId(((FeedCloudMeta$StFeed) this.f85017h).video.fileId.get()).setFromType(8).setTVKPlayerOption(jy2.g.o((FeedCloudMeta$StFeed) this.f85017h, this.T, this.f304650y0));
        l2(tVKPlayerOption, N);
        RFWLog.d("QFSTVideoChildVideoPresenter_" + tVKPlayerOption.tag(), RFWLog.USR, "fs_lifecycle  startANewPlayer:" + com.tencent.biz.qqcircle.immersive.utils.ac.f90062a.a(feedCloudMeta$StFeed.content.get()));
        j4();
        this.J.loadPlayOptions(tVKPlayerOption);
        p4(false);
        this.S = (FeedCloudMeta$StFeed) this.f85017h;
        this.U = this.f85018i;
        QCircleFolderFunnelCollect.record(QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_SET_VIDEO_PATH);
        ay2.e eVar = this.f304634i0;
        if (eVar != null) {
            eVar.U();
        }
        RFWPlayerMonitor.g().startPlayColorLog();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ay2.e.c
    public String j() {
        T t16 = this.f85017h;
        if (t16 == 0) {
            return "";
        }
        return ((FeedCloudMeta$StFeed) t16).f398449id.get();
    }

    @Override // ay2.e.c
    public void n() {
        TVideoQFSVideoView tVideoQFSVideoView = this.J;
        if (tVideoQFSVideoView != null && tVideoQFSVideoView.getSuperPlayer() != null) {
            if (k3()) {
                RFWLog.i("QFSTVideoChildVideoPresenter", RFWLog.USR, "startFromPause  isAuthPanelShow");
                return;
            }
            hu2.b bVar = this.X;
            if (bVar != null && bVar.getIsPlayingAd()) {
                RFWLog.i("QFSTVideoChildVideoPresenter", RFWLog.USR, "startFromPause  isPlayingAd");
                return;
            }
            if (!this.J.getSuperPlayer().isPlaying()) {
                RFWLog.d("QFSTVideoChildVideoPresenter", 1, "[adtest startFromPause] current player is pause, try start play.");
                F2(this.J.getSuperPlayer().getCurTVKNetVideoInfo(), this.f304634i0.y());
                k4(false);
                hu2.b bVar2 = this.X;
                if (bVar2 != null) {
                    bVar2.p();
                }
                B2();
                this.f304634i0.P();
                cy2.b.e().A(true);
                b4(true);
                return;
            }
            return;
        }
        RFWLog.d("QFSTVideoChildVideoPresenter", 1, "[startFromPause] current play view or player is null, end flow.");
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onDestroy() {
        super.onDestroy();
        RFWLog.d("QFSTVideoChildVideoPresenter", RFWLog.USR, "fs_lifecycle onDestroy: | process:" + this.Q + " | mPos:" + this.f85018i + " | hashCode:" + hashCode() + " | playView is null | pageId:" + y0());
        com.tencent.mobileqq.tvideo.authpay.a aVar = this.f304638m0;
        if (aVar != null) {
            aVar.j();
        }
        a();
        this.S = null;
        this.U = 0;
        M2();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        this.f304627b0.w(false);
        this.f304634i0.K(rFWFeedSelectInfo);
        cy2.b.e().q(this.f304635j0, this.f304636k0, this.f304648w0);
        this.f304632g0 = Boolean.TRUE;
        A2();
        this.T = jy2.g.q((FeedCloudMeta$StFeed) this.f85017h);
        if (rFWFeedSelectInfo == null) {
            return;
        }
        RFWLog.d("QFSTVideoChildVideoPresenter", RFWLog.USR, "fs_lifecycle onSelected:" + rFWFeedSelectInfo + " | mPos:" + this.f85018i + " | hashCode:" + hashCode() + " | pageId:" + y0());
        if (rFWFeedSelectInfo.getPosition() != this.f85018i) {
            return;
        }
        G2();
        com.tencent.biz.qqcircle.immersive.manager.f.f().i();
        w2(((Activity) m0()).getResources().getConfiguration().orientation);
        v2(this.T);
        this.Z.setVisibility(8);
        this.f304642q0.setVisibility(8);
        i3();
        t4();
        SimpleEventBus.getInstance().dispatchEvent(new QFSTVideoFeedsItemSelectedEvent((FeedCloudMeta$StFeed) this.f85017h, this.T, this.f85018i));
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        this.f304632g0 = Boolean.FALSE;
        if (rFWFeedSelectInfo == null || rFWFeedSelectInfo.getPosition() != this.f85018i) {
            return;
        }
        if (this.f304634i0.z() && !jy2.g.J(this.T)) {
            r4();
        }
        RFWLog.d("QFSTVideoChildVideoPresenter", RFWLog.USR, "onUnSelected:" + rFWFeedSelectInfo + " | mPos:" + this.f85018i + " | hashCode:" + hashCode() + " | pageId:" + y0());
        this.S = null;
        this.U = 0;
        this.R = 0;
        a();
        this.f304634i0.L(rFWFeedSelectInfo);
        n4();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onPaused(RFWFeedSelectInfo rFWFeedSelectInfo) {
        hu2.b bVar;
        this.f304651z0 = true;
        super.onPaused(rFWFeedSelectInfo);
        RFWLog.d("QFSTVideoChildVideoPresenter", RFWLog.USR, "fs_lifecycle onPaused:" + rFWFeedSelectInfo + " | mPos:" + this.f85018i + APLogFileUtil.SEPARATOR_LOG + hashCode());
        TVideoFloatingWindowController tVideoFloatingWindowController = this.f304644s0;
        if (tVideoFloatingWindowController != null && tVideoFloatingWindowController.h()) {
            RFWLog.d("QFSTVideoChildVideoPresenter", RFWLog.USR, "fs_lifecycle onPaused, but in floatingWindow");
            return;
        }
        S3(false);
        if (!k3() && (bVar = this.X) != null) {
            bVar.k();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onPosUpdate(int i3) {
        super.onPosUpdate(i3);
        this.U = i3;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QFSTVideoPlayOrPauseEvent) {
            Q3((QFSTVideoPlayOrPauseEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QCircleConfigChangeEvent) {
            L2((QCircleConfigChangeEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSTVideoOnPlayEvent) {
            U2((QFSTVideoOnPlayEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QCircleSeekAreaEvent) {
            Y2((QCircleSeekAreaEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSTVideoNetworkChangedEvent) {
            T2((QFSTVideoNetworkChangedEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSTVideoScreenTouchEvent) {
            W2(((QFSTVideoScreenTouchEvent) simpleBaseEvent).getAction());
            return;
        }
        if (simpleBaseEvent instanceof QFSTVideoScreenChangedEvent) {
            C2((QFSTVideoScreenChangedEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSTVideoAuthPayPanelEvent) {
            q4((QFSTVideoAuthPayPanelEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSTVideoFloatingWindowEvent) {
            N2((QFSTVideoFloatingWindowEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSTVideoFloatingWindowPlayEvent) {
            P2((QFSTVideoFloatingWindowPlayEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSTVideoMidAdCountDownStartEvent) {
            R2(((QFSTVideoMidAdCountDownStartEvent) simpleBaseEvent).adType);
        } else if (simpleBaseEvent instanceof QFSTVideoFloatingWindowStatusEvent) {
            Q2((QFSTVideoFloatingWindowStatusEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSTVideoRewardAdClickEvent) {
            V2((QFSTVideoRewardAdClickEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(RFWFeedSelectInfo rFWFeedSelectInfo) {
        hu2.b bVar;
        this.f304651z0 = false;
        super.onResumed(rFWFeedSelectInfo);
        if (!k3() && (bVar = this.X) != null) {
            bVar.m();
        }
        if (this.J == null) {
            RFWLog.d("QFSTVideoChildVideoPresenter", RFWLog.USR, "onResumed:" + rFWFeedSelectInfo + " | mPos:" + this.f85018i + APLogFileUtil.SEPARATOR_LOG + hashCode() + "|playView is null");
            return;
        }
        if (rFWFeedSelectInfo == null) {
            return;
        }
        if (this.f85018i == rFWFeedSelectInfo.getPosition()) {
            p4(false);
            H2();
        }
        RFWLog.d("QFSTVideoChildVideoPresenter", RFWLog.USR, "fs_lifecycle onResumed:" + rFWFeedSelectInfo + " | mPos:" + this.f85018i + " | hashCode:" + hashCode() + " | pageId:" + y0());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onStop(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onStop(rFWFeedSelectInfo);
        RFWLog.d("QFSTVideoChildVideoPresenter", RFWLog.USR, "fs_lifecycle onStop:" + rFWFeedSelectInfo + " |  | mPos:" + this.f85018i + " | hashCode:" + hashCode() + " | playView is null | pageId:" + y0());
        TVideoFloatingWindowController tVideoFloatingWindowController = this.f304644s0;
        if (tVideoFloatingWindowController != null && tVideoFloatingWindowController.h()) {
            RFWLog.d("QFSTVideoChildVideoPresenter", RFWLog.USR, "fs_lifecycle onStop, but in floatingWindow");
        } else {
            S3(false);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerItemViewScrollerStatus
    public void onViewHolderDetachedFromWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        super.onViewHolderDetachedFromWindow(viewHolder);
        RFWLog.d("QFSTVideoChildVideoPresenter", RFWLog.USR, "fs_lifecycle onViewHolderDetachedFromWindow: | mPos:" + this.f85018i + " | holder.pos:" + viewHolder.getAdapterPosition() + " | hashCode:" + hashCode() + " | pageId:" + y0());
        a();
        this.S = null;
        this.U = 0;
    }

    @MainThread
    public void t4() {
        TVideoQFSVideoView tVideoQFSVideoView = this.J;
        if (tVideoQFSVideoView != null && tVideoQFSVideoView.getSuperPlayer() != null) {
            this.f304634i0.c0();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSTVideoChildVideoPresenter";
    }

    @Override // ay2.e.c
    public boolean y(int i3, int i16, String str) {
        String playOptionUrl;
        QLog.d("QFSTVideoChildVideoPresenter", 4, "doOnProgress,duration=" + i3 + " position = " + i16 + ", previewEndMil =" + this.f304649x0);
        if (i16 == this.Q) {
            return true;
        }
        hu2.b bVar = this.X;
        if (bVar != null) {
            bVar.l(i16);
        }
        this.Q = i16;
        if (this.f304637l0 == null) {
            this.f304637l0 = new com.tencent.biz.qqcircle.immersive.feed.event.an();
        }
        this.f304637l0.h(i3);
        this.f304637l0.j(i16);
        this.f304637l0.i(this.R);
        com.tencent.biz.qqcircle.immersive.feed.event.an anVar = this.f304637l0;
        TVideoQFSVideoView tVideoQFSVideoView = this.J;
        if (tVideoQFSVideoView == null) {
            playOptionUrl = "";
        } else {
            playOptionUrl = tVideoQFSVideoView.getPlayOptionUrl();
        }
        anVar.g(playOptionUrl);
        T0(this.f304637l0);
        W3(i3, i16);
        jy2.j jVar = this.f304630e0;
        if (jVar != null && jVar.a(this.J.H0())) {
            T0(new wx2.c());
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class g implements b.c {
        g() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j() {
            QQToast.makeText(QFSTVideoChildVideoPresenter.this.m0(), "\u8ba2\u5355\u8bf7\u6c42\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5", 0).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k(boolean z16) {
            QFSTVideoChildVideoPresenter.this.S2(z16);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void l() {
            QQToast.makeText(QFSTVideoChildVideoPresenter.this.m0(), "\u89e3\u9501\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5", 0).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void m(String str) {
            QQToast.makeText(QFSTVideoChildVideoPresenter.this.m0(), str, 0).show();
            if (QFSTVideoChildVideoPresenter.this.f304646u0) {
                QFSTVideoChildVideoPresenter.this.X3();
                return;
            }
            QFSTVideoChildVideoPresenter.this.f304641p0.setVisibility(8);
            QFSTVideoAuthPayPanelEvent qFSTVideoAuthPayPanelEvent = new QFSTVideoAuthPayPanelEvent();
            qFSTVideoAuthPayPanelEvent.setShow(false);
            SimpleEventBus.getInstance().dispatchEvent(qFSTVideoAuthPayPanelEvent);
            QFSTVideoChildVideoPresenter.this.f304634i0.w().setEnabled(true);
            QFSTVideoChildVideoPresenter.this.f304627b0.w(false);
            QFSTVideoChildVideoPresenter.this.H2();
        }

        @Override // hu2.b.c
        public void a() {
            QFSTVideoChildVideoPresenter.this.x0().post(new Runnable() { // from class: com.tencent.mobileqq.tvideo.presenter.aa
                @Override // java.lang.Runnable
                public final void run() {
                    QFSTVideoChildVideoPresenter.g.this.l();
                }
            });
        }

        @Override // hu2.b.c
        public void c(@NonNull final String str) {
            QLog.d("QFSTVideoChildVideoPresenter", 1, "onMultiAdUnlockSuccess " + QFSTVideoChildVideoPresenter.this.f304646u0);
            QAdThreadManager.INSTANCE.execOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.tvideo.presenter.ab
                @Override // java.lang.Runnable
                public final void run() {
                    QFSTVideoChildVideoPresenter.g.this.m(str);
                }
            });
        }

        @Override // hu2.b.c
        public void d(final boolean z16) {
            QFSTVideoChildVideoPresenter.this.x0().post(new Runnable() { // from class: com.tencent.mobileqq.tvideo.presenter.ad
                @Override // java.lang.Runnable
                public final void run() {
                    QFSTVideoChildVideoPresenter.g.this.k(z16);
                }
            });
        }

        @Override // hu2.b.c
        public void e(boolean z16, @Nullable Long l3) {
            if (z16) {
                QFSTVideoChildVideoPresenter.this.S3(false);
                QFSTVideoChildVideoPresenter.this.I2();
            }
        }

        @Override // hu2.b.c
        public void onFailed() {
            QFSTVideoChildVideoPresenter.this.x0().post(new Runnable() { // from class: com.tencent.mobileqq.tvideo.presenter.ac
                @Override // java.lang.Runnable
                public final void run() {
                    QFSTVideoChildVideoPresenter.g.this.j();
                }
            });
        }

        @Override // hu2.b.c
        public void onWarnerTipClick(int i3) {
            QFSTVideoChildVideoPresenter.this.m4();
        }

        @Override // hu2.b.c
        public void b() {
        }
    }
}
