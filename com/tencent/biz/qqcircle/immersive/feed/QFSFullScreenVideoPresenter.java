package com.tencent.biz.qqcircle.immersive.feed;

import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Pair;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.avbiz.Constants;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QCircleConfigChangeEvent;
import com.tencent.biz.qqcircle.events.QCircleFeedVideoCurrentTimeEvent;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.events.QCircleVideoRateEvent;
import com.tencent.biz.qqcircle.events.QFSVideoOnPlayEvent;
import com.tencent.biz.qqcircle.immersive.album.event.QFSFullScreenClickAlbumPanelShowEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSFullScreenCompletionEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSFullScreenSeekBarEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSSeekEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSFullClearEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSFullScreenCloseEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSFullScreenListScrollStateChangeEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSPRatePlayGuideEvent;
import com.tencent.biz.qqcircle.immersive.layer.biz.inside.album.QFSLayerAlbumViewModel;
import com.tencent.biz.qqcircle.immersive.model.bottombarrage.QFSFakeBarrageEvent;
import com.tencent.biz.qqcircle.immersive.personal.utils.QFSRecentlyWatchedRecorder;
import com.tencent.biz.qqcircle.immersive.utils.bi;
import com.tencent.biz.qqcircle.immersive.views.QFSPlusFollowView;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QFSFollowView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.video.event.RFWMediaFocusChangeEvent;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayErrorStatusListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerCompletionListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLooperListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSdkInitListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWPlayerReportInfo;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.widget.media.QUICombinationSeekBar;
import com.tencent.widget.media.QUIPlayStatusIconView;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StImage;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudMeta$StVideo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import qqcircle.QQCircleFeedBase$StReportInfoForClient;

/* loaded from: classes4.dex */
public class QFSFullScreenVideoPresenter extends com.tencent.biz.qqcircle.immersive.feed.d<FeedCloudMeta$StFeed> implements View.OnClickListener {
    protected FeedCloudMeta$StFeed A0;
    protected FeedCloudMeta$StFeed N;
    protected QUICombinationSeekBar P;
    protected View Q;
    private LinearLayout R;
    private TextView S;
    private TextView T;
    private FrameLayout U;
    protected RelativeLayout V;
    protected QUIPlayStatusIconView W;
    private QCircleAsyncTextView X;
    protected TextView Y;
    protected QCircleAvatarView Z;

    /* renamed from: a0, reason: collision with root package name */
    private RelativeLayout f85246a0;

    /* renamed from: b0, reason: collision with root package name */
    protected LinearLayout f85247b0;

    /* renamed from: c0, reason: collision with root package name */
    private QFSPlusFollowView f85248c0;

    /* renamed from: d0, reason: collision with root package name */
    protected View f85249d0;

    /* renamed from: e0, reason: collision with root package name */
    private TextView f85250e0;

    /* renamed from: f0, reason: collision with root package name */
    private View f85251f0;

    /* renamed from: g0, reason: collision with root package name */
    private View f85252g0;

    /* renamed from: h0, reason: collision with root package name */
    private View f85253h0;

    /* renamed from: i0, reason: collision with root package name */
    protected View f85254i0;

    /* renamed from: j0, reason: collision with root package name */
    private View f85255j0;

    /* renamed from: k0, reason: collision with root package name */
    protected int f85256k0;

    /* renamed from: l0, reason: collision with root package name */
    protected int f85257l0;

    /* renamed from: m0, reason: collision with root package name */
    protected int f85258m0;

    /* renamed from: q0, reason: collision with root package name */
    private Size f85262q0;

    /* renamed from: t0, reason: collision with root package name */
    private com.tencent.biz.qqcircle.immersive.feed.event.ag f85265t0;

    /* renamed from: u0, reason: collision with root package name */
    private com.tencent.biz.qqcircle.immersive.feed.event.an f85266u0;

    /* renamed from: v0, reason: collision with root package name */
    private Runnable f85267v0;

    /* renamed from: w0, reason: collision with root package name */
    protected FrameLayout f85268w0;

    /* renamed from: x0, reason: collision with root package name */
    private RFWFeedSelectInfo f85269x0;

    /* renamed from: z0, reason: collision with root package name */
    private Runnable f85271z0;

    /* renamed from: n0, reason: collision with root package name */
    protected boolean f85259n0 = true;

    /* renamed from: o0, reason: collision with root package name */
    protected boolean f85260o0 = false;

    /* renamed from: p0, reason: collision with root package name */
    private int f85261p0 = -1;

    /* renamed from: r0, reason: collision with root package name */
    protected int f85263r0 = 0;

    /* renamed from: s0, reason: collision with root package name */
    private String f85264s0 = "";

    /* renamed from: y0, reason: collision with root package name */
    private final com.tencent.biz.qqcircle.immersive.utils.x f85270y0 = new com.tencent.biz.qqcircle.immersive.utils.x();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements IRFWPlayerSeekListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f85275d;

        b(String str) {
            this.f85275d = str;
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public void onProgress(String str, int i3, int i16) {
            QFSFullScreenVideoPresenter.this.t2(i3, i16, this.f85275d);
            QFSFullScreenVideoPresenter.this.y3(i3, i16);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public void onSeekBarProgressChanged(SeekBar seekBar, int i3, boolean z16) {
            QFSFullScreenVideoPresenter.this.u2(seekBar, i3, z16);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            QFSFullScreenVideoPresenter.this.v2(seekBar);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            QFSFullScreenVideoPresenter.this.w2(seekBar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            float u16 = gb0.b.u(QFSFullScreenVideoPresenter.this.N);
            QFSVideoView qFSVideoView = QFSFullScreenVideoPresenter.this.I;
            if (qFSVideoView != null) {
                qFSVideoView.setPlayRate(u16);
            }
            String r16 = gb0.b.r(u16);
            if (u16 == 1.0f) {
                r16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f193624_p);
            }
            QFSFullScreenVideoPresenter.this.f85250e0.setText(r16);
            if (!TextUtils.isEmpty(r16)) {
                if ((u16 == 1.5f || u16 == 2.0f) && com.tencent.biz.qqcircle.utils.cb.c() && !com.tencent.biz.qqcircle.utils.cb.a()) {
                    QCircleToast.j(QCircleToast.f91644d, QCircleApplication.getAPP().getResources().getString(R.string.f193664_t, gb0.b.s(u16)), 0);
                    com.tencent.biz.qqcircle.utils.cb.h();
                    TextView textView = QFSFullScreenVideoPresenter.this.f85250e0;
                    QFSFullScreenVideoPresenter qFSFullScreenVideoPresenter = QFSFullScreenVideoPresenter.this;
                    com.tencent.biz.qqcircle.utils.cb.g(textView, QCircleDaTongConstant.ElementId.EM_XSJ_SPEED_GUIDE_TOAST, qFSFullScreenVideoPresenter.N, qFSFullScreenVideoPresenter.r0());
                } else {
                    if (u16 == 1.0f) {
                        r16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f193544_h);
                    }
                    QCircleToast.j(QCircleToast.f91644d, QCircleApplication.getAPP().getResources().getString(R.string.f193644_r, r16), 0);
                }
            }
            QCirclePluginGlobalInfo.k0(QFSFullScreenVideoPresenter.this.N.f398449id.get(), u16);
            SimpleEventBus.getInstance().dispatchEvent(new QCircleVideoRateEvent(QFSFullScreenVideoPresenter.this.N.f398449id.get(), u16));
            QFSFullScreenVideoPresenter.this.B2();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class f extends RFWPlayerIOC {
        f() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
        public RFWPlayerReportInfo<e30.b> getBusinessReportInfo() {
            QFSFullScreenVideoPresenter qFSFullScreenVideoPresenter = QFSFullScreenVideoPresenter.this;
            return gb0.b.m(qFSFullScreenVideoPresenter.E.o("KEY_RFW_VIDEO_FEED_POI", Integer.valueOf(qFSFullScreenVideoPresenter.f85018i)));
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
        public boolean isValid() {
            if (QFSFullScreenVideoPresenter.this.E0() && QFSFullScreenVideoPresenter.this.I != null) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class g implements IRFWPlayerCompletionListener {
        g() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerCompletionListener
        public void onCompletion(ISuperPlayer iSuperPlayer) {
            if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_use_loop_end_auto_scroll", true)) {
                QFSFullScreenVideoPresenter.this.s2();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class h implements IRFWPlayerSdkInitListener {
        h() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSdkInitListener
        public void onInitSuccess(RFWPlayer rFWPlayer) {
            QFSFullScreenVideoPresenter qFSFullScreenVideoPresenter = QFSFullScreenVideoPresenter.this;
            qFSFullScreenVideoPresenter.I.setProgressBar(qFSFullScreenVideoPresenter.P);
            QFSFullScreenVideoPresenter qFSFullScreenVideoPresenter2 = QFSFullScreenVideoPresenter.this;
            boolean z16 = true;
            qFSFullScreenVideoPresenter2.I.setLoadingView(qFSFullScreenVideoPresenter2.Q, 1);
            QFSVideoView qFSVideoView = QFSFullScreenVideoPresenter.this.I;
            if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_use_loop_end_auto_scroll", true) && QFSFullScreenVideoPresenter.this.c3()) {
                z16 = false;
            }
            qFSVideoView.setLoopBack(z16);
            QFSFullScreenVideoPresenter qFSFullScreenVideoPresenter3 = QFSFullScreenVideoPresenter.this;
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = qFSFullScreenVideoPresenter3.N;
            if (feedCloudMeta$StFeed != null) {
                qFSFullScreenVideoPresenter3.I.setPlayRate(QCirclePluginGlobalInfo.t(feedCloudMeta$StFeed.f398449id.get()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class i implements IRFWPlayerPrepareListener {
        i() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onFirstFrameRendered(RFWPlayer rFWPlayer) {
            QFSFullScreenVideoPresenter.this.r2();
            QFSFullScreenVideoPresenter.this.s3();
            QFSFullScreenVideoPresenter.this.l2(true);
            QFSFullScreenVideoPresenter.this.l1(rFWPlayer);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onVideoPrepared(RFWPlayer rFWPlayer) {
            QFSFullScreenVideoPresenter.this.x2(rFWPlayer.getRealPlayer());
            QFSFullScreenVideoPresenter.this.L3((int) rFWPlayer.getDurationMs());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void C2() {
        VideoReport.setElementId(this.P, "em_xsj_multimedia_progress_bar");
        VideoReport.setElementReuseIdentifier(this.P, ((FeedCloudMeta$StFeed) this.f85017h).f398449id.get());
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PARENT_EMID, QCircleDaTongConstant.ElementId.EM_XSJ_MULTIMEDIA);
        buildElementParams.put("xsj_feed_id", ((FeedCloudMeta$StFeed) this.f85017h).f398449id.get());
        VideoReport.setElementParams(this.P, buildElementParams);
        VideoReport.reportEvent("ev_xsj_abnormal_clck", this.P, buildElementParams);
    }

    private void D2(String str, String str2, RFWFeedSelectInfo rFWFeedSelectInfo) {
        if (d3() && !e1(this.I) && !TextUtils.equals("TYPE_SELECT_TRIGGER_FEED_REPLACE", str2)) {
            RFWLog.d("VFS-QFSFullScreenVideoPresenter", RFWLog.USR, "[executeFromSelected] current start player, return!!!, selectedTag: " + str);
            return;
        }
        QLog.d("VFS-QFSFullScreenVideoPresenter", 1, "[executeFromSelected] execute from selected tag: " + str);
        H3(false, rFWFeedSelectInfo);
        this.f85264s0 = str;
    }

    private void E3(View view, int i3) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.setMargins(i3, layoutParams2.topMargin, i3, layoutParams2.bottomMargin);
        } else if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams3.setMargins(i3, layoutParams3.topMargin, i3, layoutParams3.bottomMargin);
        }
        view.setLayoutParams(layoutParams);
    }

    private QFSLayerAlbumViewModel F2() {
        try {
            return (QFSLayerAlbumViewModel) A0(QFSLayerAlbumViewModel.class);
        } catch (Throwable th5) {
            QLog.e("VFS-QFSFullScreenVideoPresenter", 1, "[getAlbumViewModel] ex: ", th5);
            return null;
        }
    }

    private QCircleInitBean H2() {
        if (s0() == null) {
            return null;
        }
        return s0().getMInitBean();
    }

    private void I2() {
        f2();
    }

    private void J2(com.tencent.biz.qqcircle.immersive.feed.event.ac acVar) {
        String str;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.N;
        if (feedCloudMeta$StFeed == null) {
            str = null;
        } else {
            str = feedCloudMeta$StFeed.f398449id.get();
        }
        if (!TextUtils.equals(str, acVar.f86139a)) {
            QLog.d("VFS-QFSFullScreenVideoPresenter", 1, "[handlePauseOrStartVideoEvent] feed id not equals, end flow.");
        } else {
            v3(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J3(int i3) {
        String str;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.N;
        if (feedCloudMeta$StFeed == null) {
            str = null;
        } else {
            str = feedCloudMeta$StFeed.f398449id.get();
        }
        QLog.d("VFS-QFSFullScreenVideoPresenter", 1, "[updateSeekBarAction] event action: " + i3 + " | feedId: " + str);
        SimpleEventBus.getInstance().dispatchEvent(new QFSFullScreenSeekBarEvent(i3, str));
    }

    private void K2(com.tencent.biz.qqcircle.immersive.feed.event.aa aaVar) {
        TextView textView = this.f85250e0;
        if (textView == null) {
            return;
        }
        textView.setText(gb0.b.r(aaVar.a()));
    }

    private void K3(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        QUICombinationSeekBar qUICombinationSeekBar = this.P;
        if (qUICombinationSeekBar == null) {
            return;
        }
        qUICombinationSeekBar.setSeekBarListener(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L3(final int i3) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.de
            @Override // java.lang.Runnable
            public final void run() {
                QFSFullScreenVideoPresenter.this.r3(i3);
            }
        });
    }

    private void M2(QFSFakeBarrageEvent qFSFakeBarrageEvent) {
        if (TextUtils.equals(qFSFakeBarrageEvent.getFeedId(), j()) && qFSFakeBarrageEvent.getBarrage() != null && !TextUtils.isEmpty(qFSFakeBarrageEvent.getBarrage().content.get())) {
            k2(0);
        }
    }

    private void N2(QFSFullClearEvent qFSFullClearEvent) {
        String str;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.N;
        if (feedCloudMeta$StFeed == null) {
            str = null;
        } else {
            str = feedCloudMeta$StFeed.f398449id.get();
        }
        if (!TextUtils.equals(qFSFullClearEvent.getFeedId(), str)) {
            return;
        }
        T0(new com.tencent.biz.qqcircle.immersive.feed.event.j(qFSFullClearEvent.isClear()));
    }

    private void P2(@NonNull QFSFullScreenListScrollStateChangeEvent qFSFullScreenListScrollStateChangeEvent) {
        if (qFSFullScreenListScrollStateChangeEvent.getState() == 1) {
            C3(false);
            x3();
        }
    }

    private void Q2(@NonNull RFWMediaFocusChangeEvent rFWMediaFocusChangeEvent) {
        QFSVideoView qFSVideoView;
        if (TextUtils.equals(rFWMediaFocusChangeEvent.getConflictBusinessName(), Constants.Business.QQCIRCLE) && (qFSVideoView = this.I) != null && qFSVideoView.getSuperPlayer() != null && this.I.getSuperPlayer().isPlaying() && rFWMediaFocusChangeEvent.hasFocusConflict()) {
            k2(1);
            this.P.h(false);
        }
    }

    private void R2(com.tencent.biz.qqcircle.immersive.feed.event.ak akVar) {
        String str;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.N;
        if (feedCloudMeta$StFeed == null) {
            str = null;
        } else {
            str = feedCloudMeta$StFeed.f398449id.get();
        }
        if (!TextUtils.equals(str, akVar.b())) {
            QLog.d("VFS-QFSFullScreenVideoPresenter", 1, "[handlerTapClickEvent] tap click feed id not equals, end flow.");
        } else {
            T0(new com.tencent.biz.qqcircle.immersive.feed.event.j(true ^ this.f85260o0));
        }
    }

    private void S2(LinearLayout linearLayout) {
        if (linearLayout == null) {
            QLog.d("VFS-QFSFullScreenVideoPresenter", 1, "set animation error, authorLayout is null. ");
            return;
        }
        LayoutTransition layoutTransition = new LayoutTransition();
        layoutTransition.setDuration(400L);
        linearLayout.setLayoutTransition(layoutTransition);
    }

    private void U2() {
        String str;
        long videoCurrentPosition;
        QCircleInitBean H2 = H2();
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.N;
        String str2 = null;
        if (feedCloudMeta$StFeed == null) {
            str = null;
        } else {
            str = feedCloudMeta$StFeed.f398449id.get();
        }
        if (H2 != null && H2.getFeed() != null) {
            str2 = H2.getFeed().f398449id.get();
        }
        if (H2 == null) {
            videoCurrentPosition = 0;
        } else {
            videoCurrentPosition = H2.getVideoCurrentPosition();
        }
        if (TextUtils.equals(str, str2) && videoCurrentPosition > 0) {
            T0(new com.tencent.biz.qqcircle.immersive.feed.event.ah(videoCurrentPosition));
            H2.setVideoCurrentPosition(0L);
        }
    }

    private boolean V2() {
        if (QCirclePanelStateEvent.isSpecifiedPanelShowing(22) || QCirclePanelStateEvent.isSpecifiedPanelShowing(23) || QCirclePanelStateEvent.isSpecifiedPanelShowing(1) || QCirclePanelStateEvent.isSpecifiedPanelShowing(31)) {
            return true;
        }
        return false;
    }

    private boolean Y2() {
        if (s0() != null && s0().getHostFragment() != null && s0().getHostFragment().isDetached()) {
            return true;
        }
        return false;
    }

    private boolean Z2() {
        return QCirclePanelStateEvent.isSpecifiedPanelShowing(22);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c3() {
        if (com.tencent.biz.qqcircle.immersive.utils.ab.n(F2()) && W2()) {
            return false;
        }
        if (!com.tencent.biz.qqcircle.immersive.utils.ab.o(H2()) && !com.tencent.biz.qqcircle.immersive.utils.ab.u(H2())) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void d2() {
        boolean z16;
        LinearLayout linearLayout = this.f85247b0;
        if (linearLayout == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams.removeRule(1);
        layoutParams.removeRule(6);
        layoutParams.removeRule(8);
        T t16 = this.f85017h;
        if (t16 != 0 && !TextUtils.isEmpty(((FeedCloudMeta$StFeed) t16).content.get())) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            layoutParams.leftMargin = RFWApplication.getApplication().getResources().getDimensionPixelSize(R.dimen.d2g);
        } else {
            layoutParams.leftMargin = 0;
            layoutParams.addRule(1, R.id.f42391jn);
            layoutParams.addRule(6, R.id.f42391jn);
            layoutParams.addRule(8, R.id.f42391jn);
        }
        this.f85247b0.setLayoutParams(layoutParams);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void e2() {
        T t16;
        int i3;
        if (this.X != null && (t16 = this.f85017h) != 0 && !TextUtils.isEmpty(((FeedCloudMeta$StFeed) t16).content.get()) && this.f85246a0 != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.X.getLayoutParams();
            if (com.tencent.biz.qqcircle.immersive.utils.a.e()) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            layoutParams.rightMargin = DisplayUtil.dip2px(this.X.getContext(), 30.0f) + (i3 * DisplayUtil.dip2px(this.X.getContext(), 38.0f));
            this.X.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e3, reason: merged with bridge method [inline-methods] */
    public void o3(View view) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.N;
        if (feedCloudMeta$StFeed != null && feedCloudMeta$StFeed.poster != null) {
            QCircleInitBean qCircleInitBean = new QCircleInitBean();
            qCircleInitBean.setUser(this.N.poster.get());
            qCircleInitBean.setStartNewIntent(true);
            com.tencent.biz.qqcircle.launcher.c.d0(view.getContext(), qCircleInitBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void f3(final RFWPlayerOptions rFWPlayerOptions, final FeedCloudMeta$StFeed feedCloudMeta$StFeed, final int i3, final int i16, final int i17, final String str) {
        if (rFWPlayerOptions.isPlayerByDirectIP()) {
            QLog.d("VFS-QFSFullScreenVideoPresenter", 1, "error play by ip return");
            return;
        }
        String a16 = this.f85270y0.a(rFWPlayerOptions, i17);
        if (!TextUtils.isEmpty(a16)) {
            QLog.d("VFS-QFSFullScreenVideoPresenter", 1, "[addErrorListener] check error replay, flow return.");
            T t16 = this.f85017h;
            if (t16 != 0 && ((FeedCloudMeta$StFeed) t16).video != null && ((FeedCloudMeta$StFeed) t16).video.playUrl != null) {
                ((FeedCloudMeta$StFeed) t16).video.playUrl.set(a16);
            }
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.dc
                @Override // java.lang.Runnable
                public final void run() {
                    QFSFullScreenVideoPresenter.this.g3();
                }
            });
            return;
        }
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.dd
            @Override // java.lang.Runnable
            public final void run() {
                QFSFullScreenVideoPresenter.this.h3(rFWPlayerOptions, i3, i16, i17, str, feedCloudMeta$StFeed);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g3() {
        H3(true, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h3(RFWPlayerOptions rFWPlayerOptions, int i3, int i16, int i17, String str, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        T0(new com.tencent.biz.qqcircle.immersive.feed.event.s(rFWPlayerOptions, i3, i16, i17, str, feedCloudMeta$StFeed));
    }

    private void i2() {
        VideoReport.setElementId(this.f85252g0, QCircleDaTongConstant.ElementId.EM_XSJ_ALBUM_ENTRANCE);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_ID, com.tencent.biz.qqcircle.immersive.utils.ab.b(this.N));
        buildElementParams.put("xsj_feed_id", com.tencent.biz.qqcircle.utils.bj.g(this.N));
        VideoReport.setElementParams(this.f85252g0, buildElementParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i3() {
        H3(false, null);
    }

    private String j() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.N;
        if (feedCloudMeta$StFeed == null) {
            return "null";
        }
        return feedCloudMeta$StFeed.f398449id.get();
    }

    private void j2() {
        TextView textView = this.f85250e0;
        if (textView == null) {
            return;
        }
        textView.setText(gb0.b.r(QCirclePluginGlobalInfo.t(this.N.f398449id.get())));
        this.f85250e0.setOnClickListener(new e());
        B2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j3() {
        SimpleEventBus.getInstance().dispatchEvent(new QFSFullScreenCompletionEvent(this.N));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k3() {
        H3(false, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l3() {
        T0(new com.tencent.biz.qqcircle.immersive.feed.event.j(true));
    }

    private void m2() {
        QFSLayerAlbumViewModel F2;
        if (com.tencent.biz.qqcircle.immersive.utils.ab.l(this.N, H2()) && (F2 = F2()) != null && com.tencent.biz.qqcircle.immersive.utils.ab.m(F2, com.tencent.biz.qqcircle.utils.bj.g(this.N))) {
            if (com.tencent.biz.qqcircle.immersive.utils.ab.n(F2) && W2()) {
                RFWLog.d("VFS-QFSFullScreenVideoPresenter", RFWLog.USR, "[checkAlbumEndAndPrompt] current album list is single & feed is last data.");
            } else {
                QCircleToast.o(m0().getResources().getString(R.string.f1907342w), 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n2(ISuperPlayer iSuperPlayer) {
        if (iSuperPlayer != null && !com.tencent.biz.qqcircle.utils.cb.a() && iSuperPlayer.getDurationMs() >= 60000) {
            this.f85271z0 = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.QFSFullScreenVideoPresenter.6
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    SimpleEventBus.getInstance().dispatchEvent(new QFSPRatePlayGuideEvent(true, (FeedCloudMeta$StFeed) QFSFullScreenVideoPresenter.this.f85017h).setContextHashCode(QFSFullScreenVideoPresenter.this.m0().hashCode()));
                    QLog.d("VFS-QFSFullScreenVideoPresenter", 1, "dispatch rate guide event full");
                }
            };
            q2();
            RFWThreadManager.getUIHandler().postDelayed(this.f85271z0, 5000L);
            QLog.d("VFS-QFSFullScreenVideoPresenter", 1, "can dispatch rate guide event full:" + hashCode());
            return;
        }
        QLog.d("VFS-QFSFullScreenVideoPresenter", 1, "should not dispatch rate guide event full");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void n3(Pair pair) {
        String g16 = com.tencent.biz.qqcircle.utils.bj.g((FeedCloudMeta$StFeed) this.f85017h);
        QLog.d("VFS-QFSFullScreenVideoPresenter", 1, "[onClick] currentFeedId: " + g16);
        SimpleEventBus.getInstance().dispatchEvent(new QFSFullScreenCloseEvent(g16));
    }

    private void o2() {
        this.f85266u0 = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p2() {
        if (this.f85267v0 == null) {
            return;
        }
        RFWThreadManager.getUIHandler().removeCallbacks(this.f85267v0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p3() {
        if (a3()) {
            return;
        }
        if (Y2()) {
            QLog.e("VFS-QFSFullScreenVideoPresenter", 1, "[scrollToNextItem] current fragment is detached, end flow.");
            return;
        }
        m2();
        int i3 = this.f85018i + 1;
        RecyclerView recyclerView = (RecyclerView) this.f85249d0.getParent();
        QLog.d("VFS-QFSFullScreenVideoPresenter", 1, "[scrollToNextItem] nextPos: " + i3 + " | prePos: " + this.f85018i);
        if (recyclerView.getAdapter() != null && recyclerView.getAdapter().getItemCount() - 1 >= i3) {
            recyclerView.smoothScrollToPosition(i3);
            com.tencent.biz.qqcircle.immersive.utils.u.c(recyclerView);
        } else {
            H3(false, null);
        }
    }

    private void q2() {
        if (this.f85271z0 == null) {
            QLog.d("VFS-QFSFullScreenVideoPresenter", 1, "delete guide event full null:" + hashCode());
            return;
        }
        RFWThreadManager.getUIHandler().removeCallbacks(this.f85271z0);
        QLog.d("VFS-QFSFullScreenVideoPresenter", 1, "delete guide event full:" + hashCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r3(int i3) {
        QLog.d("VFS-QFSFullScreenVideoPresenter", 1, "[updateSeekOriginDuration] duration: " + i3);
        TextView textView = this.S;
        if (textView != null) {
            textView.setText(" / " + com.tencent.biz.qqcircle.utils.cv.c(i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s2() {
        RFWLog.d("VFS-QFSFullScreenVideoPresenter", RFWLog.CLR, "[onCompletion] current is auto scroll: ", Boolean.valueOf(G3()));
        if (QCirclePanelStateEvent.isAnyPanelShowing()) {
            QLog.d("VFS-QFSFullScreenVideoPresenter", 1, "[onCompletion] current show panel, restart play, feed id: " + com.tencent.biz.qqcircle.utils.bj.g(this.N));
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.cz
                @Override // java.lang.Runnable
                public final void run() {
                    QFSFullScreenVideoPresenter.this.i3();
                }
            });
            return;
        }
        if (com.tencent.biz.qqcircle.immersive.utils.ab.o(H2())) {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.da
                @Override // java.lang.Runnable
                public final void run() {
                    QFSFullScreenVideoPresenter.this.j3();
                }
            });
        } else if (G3()) {
            S0();
        } else {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.db
                @Override // java.lang.Runnable
                public final void run() {
                    QFSFullScreenVideoPresenter.this.k3();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t2(int i3, int i16, String str) {
        if (i16 == this.f85256k0 && this.f85257l0 == i3) {
            return;
        }
        this.f85256k0 = i16;
        this.f85257l0 = i3;
        this.P.setMax(i3);
        this.P.setProgress(i16);
        u3();
        I3(str, i16);
    }

    private void t3(long j3) {
        float f16;
        if (this.f85018i != 0 && com.tencent.biz.qqcircle.immersive.utils.ab.u(H2())) {
            if (j3 > 0) {
                f16 = (float) (j3 / 1000);
            } else {
                f16 = 0.0f;
            }
            if (Math.round(f16) > 0) {
                T0(new com.tencent.biz.qqcircle.immersive.feed.event.y(this.f85249d0.getContext().getResources().getString(R.string.f1907042t, com.tencent.biz.qqcircle.utils.cv.c((int) j3)), 2000L, 1, com.tencent.biz.qqcircle.utils.bj.g(this.N)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u2(SeekBar seekBar, int i3, boolean z16) {
        String str;
        TextView textView = this.T;
        if (textView != null && z16) {
            textView.setText(com.tencent.biz.qqcircle.utils.cv.c(i3) + " / ");
        }
        if (this.f85265t0 == null) {
            this.f85265t0 = new com.tencent.biz.qqcircle.immersive.feed.event.ag();
        }
        this.f85265t0.d(i3);
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.N;
        if (feedCloudMeta$StFeed == null) {
            str = "";
        } else {
            str = feedCloudMeta$StFeed.f398449id.get();
        }
        this.f85265t0.c(str);
        T0(this.f85265t0);
    }

    private void u3() {
        float f16;
        FeedCloudMeta$StFeed c16;
        int i3 = this.f85257l0 - this.f85256k0;
        if (i3 > 0) {
            f16 = i3 / 1000;
        } else {
            f16 = 0.0f;
        }
        int round = Math.round(f16);
        if (round <= 5 && round != this.f85261p0) {
            if (V2()) {
                QLog.d("VFS-QFSFullScreenVideoPresenter", 1, "isCommentOrAlbumPanelShowing : true");
                return;
            }
            boolean o16 = com.tencent.biz.qqcircle.immersive.utils.ab.o(H2());
            if (com.tencent.biz.qqcircle.immersive.utils.ab.u(H2()) && !o16 && !b3()) {
                T0(new com.tencent.biz.qqcircle.immersive.feed.event.y(this.f85249d0.getContext().getResources().getString(R.string.f1907242v, String.valueOf(round)), 1200L, 2, com.tencent.biz.qqcircle.utils.bj.g(this.N)));
            } else if (o16 && !Z2()) {
                String e16 = com.tencent.biz.qqcircle.immersive.utils.ab.e(this.N);
                long d16 = com.tencent.biz.qqcircle.immersive.utils.ab.d(this.N);
                if (!TextUtils.isEmpty(e16) && d16 != -1) {
                    if (Y2()) {
                        QLog.e("VFS-QFSFullScreenVideoPresenter", 1, "[notifyRemainPlayPrompt] current fragment is detached, end flow.");
                        return;
                    }
                    String g16 = com.tencent.biz.qqcircle.utils.bj.g(this.N);
                    QFSLayerAlbumViewModel F2 = F2();
                    if (F2 == null) {
                        c16 = null;
                    } else {
                        c16 = com.tencent.biz.qqcircle.immersive.utils.ab.c(F2, g16);
                    }
                    if (c16 == null) {
                        QLog.d("VFS-QFSFullScreenVideoPresenter", 1, "[notifyRemainPlayPrompt] next feed should not be null.");
                        return;
                    }
                    T0(new com.tencent.biz.qqcircle.immersive.feed.event.y(this.f85249d0.getContext().getResources().getString(R.string.f1907142u, String.valueOf(round), com.tencent.biz.qqcircle.immersive.utils.ab.e(c16), Long.valueOf(com.tencent.biz.qqcircle.immersive.utils.ab.d(c16))), 1200L, 3, g16));
                } else {
                    QLog.e("VFS-QFSFullScreenVideoPresenter", 1, "[notifyRemainPlayPrompt] current album param illegality.");
                    return;
                }
            }
            this.f85261p0 = round;
            QLog.d("VFS-QFSFullScreenVideoPresenter", 1, "[notifyRemainPlayPrompt] remainTimeSecond: " + round);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v2(SeekBar seekBar) {
        String str;
        if (seekBar == null) {
            QLog.e("VFS-QFSFullScreenVideoPresenter", 1, "[doOnStartSeekBarTrackingTouch] seek bar should not be null.");
            return;
        }
        C2();
        C3(true);
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.N;
        if (feedCloudMeta$StFeed == null) {
            str = "";
        } else {
            str = feedCloudMeta$StFeed.f398449id.get();
        }
        T0(new com.tencent.biz.qqcircle.immersive.feed.event.z(str, true));
        RFWLog.d("VFS-QFSFullScreenVideoPresenter", RFWLog.USR, "[doOnStartSeekBarTrackingTouch] seekBar.getProgress()=" + seekBar.getProgress() + " | feedId: " + str);
        J3(1);
        p2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void w2(SeekBar seekBar) {
        String str;
        if (seekBar == null) {
            QLog.e("VFS-QFSFullScreenVideoPresenter", 1, "[doOnStopSeekBarTrackingTouch] seek bar should not be null.");
            return;
        }
        C3(false);
        if (this.I.getSuperPlayer().isPausing()) {
            E2(true, null);
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.N;
        String str2 = "";
        if (feedCloudMeta$StFeed == null) {
            str = "";
        } else {
            str = feedCloudMeta$StFeed.f398449id.get();
        }
        com.tencent.biz.qqcircle.immersive.feed.event.z zVar = new com.tencent.biz.qqcircle.immersive.feed.event.z(str, false);
        zVar.a(seekBar.getProgress());
        RFWLog.d("VFS-QFSFullScreenVideoPresenter", RFWLog.USR, "[doOnStopSeekBarTrackingTouch] seekBar.getProgress()=" + seekBar.getProgress() + " | feedId: " + str);
        T0(zVar);
        T t16 = this.f85017h;
        if (t16 != 0) {
            str2 = ((FeedCloudMeta$StFeed) t16).f398449id.get();
        }
        QFSSeekEvent qFSSeekEvent = new QFSSeekEvent(str2, false);
        qFSSeekEvent.setStopTrackingTouchProgress(seekBar.getProgress());
        SimpleEventBus.getInstance().dispatchEvent(qFSSeekEvent);
        J3(2);
    }

    private void w3() {
        QUICombinationSeekBar qUICombinationSeekBar = this.P;
        if (qUICombinationSeekBar == null) {
            return;
        }
        qUICombinationSeekBar.setMax(0);
        this.P.setProgress(0);
    }

    private void x3() {
        QUICombinationSeekBar qUICombinationSeekBar = this.P;
        if (qUICombinationSeekBar == null) {
            return;
        }
        qUICombinationSeekBar.h(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y2() {
        if (this.I != null && this.N != null) {
            Map<String, ?> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.putAll(ua0.c.e(this.N));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(this.f85258m0 + 1));
            buildElementParams.put("xsj_custom_pgid", QCircleDaTongConstant.PageId.PG_XSJ_FULL_SCREEN_PAGE);
            try {
                QQCircleFeedBase$StReportInfoForClient qQCircleFeedBase$StReportInfoForClient = new QQCircleFeedBase$StReportInfoForClient();
                qQCircleFeedBase$StReportInfoForClient.mergeFrom(this.N.reportInfoForClient.get().toByteArray());
                if (!TextUtils.isEmpty(qQCircleFeedBase$StReportInfoForClient.datongJsonData.get())) {
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, qQCircleFeedBase$StReportInfoForClient.datongJsonData.get());
                }
            } catch (InvalidProtocolBufferMicroException unused) {
                QLog.w("VFS-QFSFullScreenVideoPresenter", 1, "QCircleWaterfallFeedItemView, transferInfo error");
            }
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PUBLISH_TIMESTAMP, Long.valueOf(this.N.createTime.get()));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PUBLISH_COVER_URL, this.N.cover.picUrl.get());
            buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
            VideoEntity build = new VideoEntity.Builder().setContentId(this.N.f398449id.get()).setPage((Object) QCircleDaTongConstant.PageId.PG_XSJ_FULL_SCREEN_PAGE).setContentType(2).setVideoDuration(this.N.video.duration.get()).setVideoView((View) this.I).addCustomParams(buildElementParams).ignoreReport(false).bizReady(true).build();
            ISuperPlayer superPlayer = this.I.getSuperPlayer();
            if (superPlayer != null) {
                VideoReport.bindVideoPlayerInfo(superPlayer, build);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y3(int i3, int i16) {
        String playOptionUrl;
        if (this.f85266u0 == null) {
            this.f85266u0 = new com.tencent.biz.qqcircle.immersive.feed.event.an();
        }
        this.f85266u0.j(i16);
        this.f85266u0.h(i3);
        this.f85266u0.i(this.f85263r0);
        com.tencent.biz.qqcircle.immersive.feed.event.an anVar = this.f85266u0;
        QFSVideoView qFSVideoView = this.I;
        if (qFSVideoView == null) {
            playOptionUrl = "";
        } else {
            playOptionUrl = qFSVideoView.getPlayOptionUrl();
        }
        anVar.g(playOptionUrl);
        T0(this.f85266u0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z2(View view, String str) {
        if (this.N != null && view != null && !TextUtils.isEmpty(str)) {
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.putAll(ua0.c.e(this.N));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(this.f85258m0 + 1));
            buildElementParams.put("xsj_target_qq", this.N.poster.f398463id.get());
            buildElementParams.put("xsj_action_type", "follow");
            buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ACTION_VIDEO_LOCATION, Long.valueOf(w20.a.j().b()));
            VideoReport.reportEvent(str, view, buildElementParams);
            return;
        }
        QLog.d("VFS-QFSFullScreenVideoPresenter", 1, "dtReportCustomReport : mFeedData , view or eventId is null. ");
    }

    protected void A2() {
        if (this.N != null && this.Z != null && this.Y != null) {
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.putAll(ua0.c.e(this.N));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(this.f85258m0 + 1));
            VideoReport.setElementId(this.Z, "em_xsj_author_avatar");
            VideoReport.setElementParams(this.Z, buildElementParams);
            VideoReport.setElementId(this.Y, "em_xsj_author_name");
            VideoReport.setElementParams(this.Y, buildElementParams);
        }
    }

    public void A3(int i3) {
        this.f85258m0 = i3;
    }

    protected void B2() {
        if (this.N != null && this.Z != null && this.Y != null) {
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.putAll(ua0.c.e(this.N));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(this.f85258m0 + 1));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FAST_FORWARD_TIMES, gb0.b.s(QCirclePluginGlobalInfo.t(this.N.f398449id.get())));
            VideoReport.setElementId(this.f85250e0, QCircleDaTongConstant.ElementId.EM_XSJ_FAST_FORWARD_BUTTON);
            VideoReport.setElementParams(this.f85250e0, buildElementParams);
        }
    }

    protected void B3(QFSPlusFollowView qFSPlusFollowView) {
        if (qFSPlusFollowView == null) {
            return;
        }
        qFSPlusFollowView.setItemReportListener(new c());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        super.C0(hVar);
        if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.t) {
            H3(((com.tencent.biz.qqcircle.immersive.feed.event.t) hVar).a(), null);
            return;
        }
        if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.ah) {
            z3(Long.valueOf(((com.tencent.biz.qqcircle.immersive.feed.event.ah) hVar).a()));
            return;
        }
        if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.j) {
            L2(((com.tencent.biz.qqcircle.immersive.feed.event.j) hVar).b());
            return;
        }
        if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.ak) {
            R2((com.tencent.biz.qqcircle.immersive.feed.event.ak) hVar);
        } else if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.ac) {
            J2((com.tencent.biz.qqcircle.immersive.feed.event.ac) hVar);
        } else if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.aa) {
            K2((com.tencent.biz.qqcircle.immersive.feed.event.aa) hVar);
        }
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    protected void C3(boolean z16) {
        if (this.R != null && this.V != null) {
            QLog.d("VFS-QFSFullScreenVideoPresenter", 1, "setTrackTouchView, trackState = " + z16);
            if (z16) {
                L2(this.f85260o0);
                this.R.setVisibility(0);
                this.V.setVisibility(8);
                this.U.setVisibility(0);
                this.f85250e0.setVisibility(8);
                this.f85251f0.setVisibility(8);
                this.f85253h0.setVisibility(8);
                return;
            }
            L2(this.f85260o0);
            this.f85251f0.setVisibility(0);
            this.f85250e0.setVisibility(0);
            this.R.setVisibility(8);
            this.f85253h0.setVisibility(0);
        }
    }

    protected void D3() {
        QUIPlayStatusIconView qUIPlayStatusIconView = this.W;
        if (qUIPlayStatusIconView != null) {
            qUIPlayStatusIconView.setOnClickListener(this);
        }
        LinearLayout linearLayout = this.f85247b0;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(this);
        }
        View view = this.f85255j0;
        if (view != null) {
            view.setOnClickListener(this);
        }
        QCircleAvatarView qCircleAvatarView = this.Z;
        if (qCircleAvatarView != null) {
            qCircleAvatarView.setOnClickListener(this);
        }
        TextView textView = this.Y;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        View view2 = this.f85252g0;
        if (view2 != null) {
            view2.setOnClickListener(this);
        }
    }

    protected void E2(boolean z16, RFWFeedSelectInfo rFWFeedSelectInfo) {
        QFSVideoView qFSVideoView;
        if (this.f85259n0 && (qFSVideoView = this.I) != null) {
            if (qFSVideoView.getSuperPlayer() == null) {
                H3(z16, rFWFeedSelectInfo);
                return;
            }
            if (this.I.isRelease()) {
                RFWLog.d("VFS-QFSFullScreenVideoPresenter", RFWLog.USR, "[executePlay] execute a new player released" + hashCode());
                H3(z16, rFWFeedSelectInfo);
                return;
            }
            if (this.I.getSuperPlayer().isPlaying()) {
                RFWLog.d("VFS-QFSFullScreenVideoPresenter", RFWLog.USR, "[executePlay] isPlaying when resume:" + hashCode());
                return;
            }
            if (this.I.getSuperPlayer().isPausing()) {
                k2(0);
                QUICombinationSeekBar qUICombinationSeekBar = this.P;
                if (qUICombinationSeekBar != null) {
                    qUICombinationSeekBar.h(true);
                    return;
                }
                return;
            }
            H3(z16, rFWFeedSelectInfo);
        }
    }

    protected void F3(View view, int i3, int i16, int i17) {
        ViewGroup.LayoutParams layoutParams;
        if (view == null) {
            layoutParams = null;
        } else {
            layoutParams = view.getLayoutParams();
        }
        if (!(layoutParams instanceof FrameLayout.LayoutParams)) {
            QLog.d("VFS-QFSFullScreenVideoPresenter", 1, "[setViewSize] params not is FrameLayout#LayoutParams, set size fail return.");
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.width = i3;
        layoutParams2.height = i16;
        layoutParams2.topMargin = i17;
        layoutParams2.rightMargin = 0;
        layoutParams2.gravity = 17;
        view.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public long G2() {
        FeedCloudMeta$StVideo feedCloudMeta$StVideo;
        int i3 = this.f85257l0;
        if (i3 <= 0) {
            T t16 = this.f85017h;
            if (t16 == 0) {
                feedCloudMeta$StVideo = null;
            } else {
                feedCloudMeta$StVideo = ((FeedCloudMeta$StFeed) t16).video;
            }
            if (feedCloudMeta$StVideo == null) {
                return 0L;
            }
            i3 = feedCloudMeta$StVideo.duration.get();
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean G3() {
        return com.tencent.biz.qqcircle.immersive.utils.ab.u(H2());
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void H3(boolean z16, RFWFeedSelectInfo rFWFeedSelectInfo) {
        long c16;
        String str;
        if (this.I != null && this.N != null) {
            n1();
            QFSVideoView.D = new WeakReference<>(this.I);
            QLog.d("VFS-QFSFullScreenVideoPresenter", 1, "startANewPlayer");
            boolean z17 = false;
            this.I.setData(this.N, 0);
            String N = com.tencent.biz.qqcircle.immersive.utils.r.N(this.N.video.playUrl.get());
            int i3 = this.f85256k0;
            if (i3 > 0) {
                c16 = i3;
            } else {
                c16 = com.tencent.biz.qqcircle.immersive.manager.f.f().c(this.N);
            }
            long G2 = G2();
            if (G2 - c16 <= 5000) {
                c16 = 0;
            }
            RFWPlayerOptions addAttachInfo = RFWPlayerOptions.obtain(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO()).setPlayUrl(this.N.video.playUrl.get()).setFileId(this.N.video.fileId.get()).setStVideo(gb0.b.k(this.N.video)).setStartOffset(c16).setFromType(4).setEnableDataCollect(true).addAttachInfo("ATTACH_INFO_KEY_POI", Integer.valueOf(this.f85018i));
            if (rFWFeedSelectInfo != null && rFWFeedSelectInfo.isScrollToNext()) {
                z17 = true;
            }
            RFWPlayerOptions addAttachInfo2 = addAttachInfo.addAttachInfo("ATTACH_INFO_KEY_SCROLL_NEXT", Boolean.valueOf(z17));
            if (rFWFeedSelectInfo != null) {
                str = rFWFeedSelectInfo.getSelectedType();
            } else {
                str = "";
            }
            RFWPlayerOptions addAttachInfo3 = addAttachInfo2.addAttachInfo("ATTACH_INFO_KEY_SELECTED_TYPE", str);
            U1(this.N, addAttachInfo3, N);
            addAttachInfo3.setPlayIOC(new f());
            this.I.loadPlayOptions(addAttachInfo3);
            QLog.d("VFS-QFSFullScreenVideoPresenter", 1, "[startANewPlayer] startOffset: " + c16 + " | duration: " + G2 + " | fileId: " + this.N.video.fileId.get());
            this.A0 = (FeedCloudMeta$StFeed) this.f85017h;
            t3(c16);
        }
    }

    protected void I3(String str, long j3) {
        if (com.tencent.biz.qqcircle.immersive.manager.f.f().g(G2())) {
            com.tencent.biz.qqcircle.immersive.manager.f.f().m(str, j3);
        }
    }

    protected void L2(boolean z16) {
        FrameLayout frameLayout = this.U;
        if (frameLayout != null && this.V != null) {
            if (z16) {
                frameLayout.setVisibility(8);
                this.V.setVisibility(8);
                this.f85246a0.setVisibility(8);
            } else {
                frameLayout.setVisibility(0);
                this.V.setVisibility(0);
                this.f85246a0.setVisibility(0);
            }
            this.f85260o0 = z16;
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.d, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.f85249d0 = view;
        this.f85268w0 = (FrameLayout) view.findViewById(R.id.f57192mn);
        QUICombinationSeekBar qUICombinationSeekBar = (QUICombinationSeekBar) view.findViewById(R.id.f42691kg);
        this.P = qUICombinationSeekBar;
        this.W = qUICombinationSeekBar.c();
        this.Q = view.findViewById(R.id.f42791kq);
        this.R = (LinearLayout) view.findViewById(R.id.f42511jz);
        this.S = (TextView) view.findViewById(R.id.f42771ko);
        this.T = (TextView) view.findViewById(R.id.f42761kn);
        this.U = (FrameLayout) view.findViewById(R.id.f42721kj);
        this.V = (RelativeLayout) view.findViewById(R.id.f42491jx);
        this.X = (QCircleAsyncTextView) view.findViewById(R.id.f42471jv);
        this.Y = (TextView) view.findViewById(R.id.f42381jm);
        this.Z = (QCircleAvatarView) view.findViewById(R.id.f42461ju);
        this.f85246a0 = (RelativeLayout) view.findViewById(R.id.f42701kh);
        this.f85247b0 = (LinearLayout) view.findViewById(R.id.f42371jl);
        this.f85248c0 = (QFSPlusFollowView) view.findViewById(R.id.f42361jk);
        this.f85251f0 = view.findViewById(R.id.f40611eu);
        this.f85255j0 = view.findViewById(R.id.f42391jn);
        this.f85252g0 = view.findViewById(R.id.f42451jt);
        this.f85254i0 = view.findViewById(R.id.f42781kp);
        D3();
        B3(this.f85248c0);
        S2(this.f85247b0);
        QCircleAsyncTextView qCircleAsyncTextView = this.X;
        if (qCircleAsyncTextView != null) {
            qCircleAsyncTextView.setSpecialClickAreaColor(R.color.f158017al3);
            this.X.setNeedSpecialAreaBold(true);
        }
        this.f85262q0 = com.tencent.biz.qqcircle.immersive.utils.n.a(view.getContext(), R.dimen.d2_);
        this.f85250e0 = (TextView) view.findViewById(R.id.f42631ka);
        this.f85253h0 = view.findViewById(R.id.f42501jy);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void Q0() {
        if (com.tencent.biz.qqcircle.immersive.utils.y.f(this.N)) {
            return;
        }
        com.tencent.biz.qqcircle.immersive.utils.bl.b(this.N);
        QFSRecentlyWatchedRecorder.i().n(this.E);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void S0() {
        x0().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.df
            @Override // java.lang.Runnable
            public final void run() {
                QFSFullScreenVideoPresenter.this.p3();
            }
        });
    }

    protected void T2() {
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        FeedCloudMeta$StUser feedCloudMeta$StUser2;
        PBStringField pBStringField;
        FeedCloudMeta$StUser feedCloudMeta$StUser3;
        PBStringField pBStringField2;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.N;
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        if (feedCloudMeta$StFeed.f398449id != null) {
            QLog.d("VFS-QFSFullScreenVideoPresenter", 1, "feed id = " + this.N.f398449id.get());
        }
        int i3 = 8;
        if (this.Y != null && (feedCloudMeta$StUser3 = this.N.poster) != null && (pBStringField2 = feedCloudMeta$StUser3.nick) != null && !TextUtils.isEmpty(pBStringField2.get())) {
            this.Y.setText(this.N.poster.nick.get());
        } else {
            TextView textView = this.Y;
            if (textView != null) {
                textView.setVisibility(8);
            }
        }
        d2();
        e2();
        if (this.X != null && (pBStringField = this.N.content) != null && !TextUtils.isEmpty(pBStringField.get())) {
            this.X.setVisibility(0);
            if (com.tencent.biz.qqcircle.immersive.utils.ab.l(this.N, H2())) {
                String string = m0().getResources().getString(R.string.f195754fg, Long.valueOf(com.tencent.biz.qqcircle.immersive.utils.ab.d(this.N)), this.N.content.get());
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
                int indexOf = string.indexOf("\uff5c");
                if (indexOf >= 1) {
                    int i16 = indexOf + 1;
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(m0().getResources().getColor(R.color.cli)), indexOf, i16, 33);
                    spannableStringBuilder.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER), indexOf, i16, 33);
                    spannableStringBuilder.setSpan(new AbsoluteSizeSpan(com.tencent.biz.qqcircle.utils.cx.a(14.0f)), indexOf, i16, 33);
                }
                this.X.setText((CharSequence) spannableStringBuilder, false);
            } else {
                QCircleAsyncTextView qCircleAsyncTextView = this.X;
                if (qCircleAsyncTextView != null) {
                    qCircleAsyncTextView.setText((CharSequence) this.N.content.get(), false);
                }
            }
        } else {
            QCircleAsyncTextView qCircleAsyncTextView2 = this.X;
            if (qCircleAsyncTextView2 != null) {
                qCircleAsyncTextView2.setVisibility(8);
            }
        }
        QCircleAvatarView qCircleAvatarView = this.Z;
        if (qCircleAvatarView != null && (feedCloudMeta$StUser2 = this.N.poster) != null) {
            qCircleAvatarView.setUser(feedCloudMeta$StUser2, this.f85262q0);
        }
        QFSPlusFollowView qFSPlusFollowView = this.f85248c0;
        if (qFSPlusFollowView != null && (feedCloudMeta$StUser = this.N.poster) != null) {
            qFSPlusFollowView.setUserData(feedCloudMeta$StUser.get(), this.N);
            this.f85248c0.setFollowedDismiss(true);
        }
        if (this.f85252g0 != null) {
            boolean l3 = com.tencent.biz.qqcircle.immersive.utils.ab.l(this.N, H2());
            View view = this.f85252g0;
            if (l3) {
                i3 = 0;
            }
            view.setVisibility(i3);
            i2();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void U1(FeedCloudMeta$StFeed feedCloudMeta$StFeed, RFWPlayerOptions rFWPlayerOptions, String str) {
        a2(rFWPlayerOptions);
        Z1(rFWPlayerOptions);
        c2(rFWPlayerOptions, str);
        X1(rFWPlayerOptions);
        W1(feedCloudMeta$StFeed, rFWPlayerOptions);
        V1(rFWPlayerOptions);
    }

    protected void V1(RFWPlayerOptions rFWPlayerOptions) {
        rFWPlayerOptions.getListenerSet().addCompletionListener(new g());
    }

    protected void W1(final FeedCloudMeta$StFeed feedCloudMeta$StFeed, @NonNull final RFWPlayerOptions rFWPlayerOptions) {
        rFWPlayerOptions.getListenerSet().addErrorStatusListener(new IRFWPlayErrorStatusListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.cy
            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayErrorStatusListener
            public final void onVideoPlayError(int i3, int i16, int i17, String str) {
                QFSFullScreenVideoPresenter.this.f3(rFWPlayerOptions, feedCloudMeta$StFeed, i3, i16, i17, str);
            }
        });
    }

    protected boolean W2() {
        View view = this.f85249d0;
        if (view == null || !(view.getParent() instanceof RecyclerView) || ((RecyclerView) this.f85249d0.getParent()).getAdapter() == null || this.f85018i == ((RecyclerView) this.f85249d0.getParent()).getAdapter().getItemCount() - 1) {
            return true;
        }
        return false;
    }

    protected void X1(@NonNull RFWPlayerOptions rFWPlayerOptions) {
        rFWPlayerOptions.getListenerSet().addLooperListeners(new a());
    }

    protected void Z1(@NonNull RFWPlayerOptions rFWPlayerOptions) {
        rFWPlayerOptions.getListenerSet().addPrepareListeners(new i());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.d
    protected void a() {
        if (this.I == null) {
            QLog.d("VFS-QFSFullScreenVideoPresenter", 1, "[releasePlayer] mPlayView == null.");
            return;
        }
        QLog.d("VFS-QFSFullScreenVideoPresenter", 1, "releasePlayer");
        VideoReport.unbindVideoPlayerInfo(this.I);
        this.I.release();
        l2(false);
    }

    protected void a2(@NonNull RFWPlayerOptions rFWPlayerOptions) {
        rFWPlayerOptions.getListenerSet().addSDKInitListeners(new h());
    }

    protected boolean a3() {
        View view = this.f85249d0;
        if (view != null && (view.getParent() instanceof RecyclerView) && ((RecyclerView) this.f85249d0.getParent()).getAdapter() != null && this.f85018i < ((RecyclerView) this.f85249d0.getParent()).getAdapter().getItemCount()) {
            return false;
        }
        return true;
    }

    protected boolean b3() {
        View view = this.f85249d0;
        if (view == null || !(view.getParent() instanceof RecyclerView) || ((RecyclerView) this.f85249d0.getParent()).getAdapter() == null || this.f85018i + 1 >= ((RecyclerView) this.f85249d0.getParent()).getAdapter().getItemCount()) {
            return true;
        }
        return false;
    }

    protected void c2(@NonNull RFWPlayerOptions rFWPlayerOptions, String str) {
        rFWPlayerOptions.getListenerSet().addSeekListeners(new b(str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected boolean d3() {
        T t16;
        if (this.A0 != null && (t16 = this.f85017h) != 0 && this.f85258m0 == this.f85018i) {
            try {
                if (((FeedCloudMeta$StFeed) t16).f398449id.get().equals(this.A0.f398449id.get()) && ((FeedCloudMeta$StFeed) this.f85017h).video.playUrl.get().equals(this.A0.video.playUrl.get())) {
                    RFWLog.d("VFS-QFSFullScreenVideoPresenter", RFWLog.USR, "fs_lifecycle , same video, playUrl = " + this.A0.video.playUrl.get());
                    return true;
                }
            } catch (Exception e16) {
                RFWLog.d("VFS-QFSFullScreenVideoPresenter", RFWLog.USR, "same video, exception = " + e16.getMessage());
            }
        }
        return false;
    }

    protected void f2() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.N;
        if (feedCloudMeta$StFeed != null && feedCloudMeta$StFeed.video.height.get() != 0 && this.N.video.width.get() != 0 && this.I != null) {
            if (this.N.cover.width.get() < this.N.cover.height.get()) {
                QLog.d("VFS-QFSFullScreenVideoPresenter", 1, "error cover url");
            }
            int e16 = com.tencent.biz.qqcircle.utils.cx.e(this.I.getContext());
            int c16 = com.tencent.biz.qqcircle.utils.cx.c(this.I.getContext());
            g2(this.N, c16);
            float f16 = e16 * 1.77f;
            float f17 = c16;
            if (f16 >= f17) {
                f16 = f17;
            }
            int i3 = (int) ((f17 - f16) / 2.0f);
            E3(this.R, i3);
            E3(this.V, i3);
            E3(this.U, i3);
            E3(this.f85246a0, i3);
            T0(new com.tencent.biz.qqcircle.immersive.feed.event.x(i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g2(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        int i16 = feedCloudMeta$StFeed.video.height.get();
        int i17 = feedCloudMeta$StFeed.video.width.get();
        int c16 = com.tencent.biz.qqcircle.utils.cx.c(this.I.getContext());
        int e16 = com.tencent.biz.qqcircle.utils.cx.e(this.I.getContext());
        float f16 = i17;
        float f17 = i16;
        int i18 = (int) ((c16 / f16) * f17);
        if (i18 > e16) {
            c16 = (int) ((e16 / f17) * f16);
            i18 = e16;
        }
        Rect b16 = com.tencent.biz.qqcircle.immersive.utils.bj.b(feedCloudMeta$StFeed, i3, e16, c16, i18);
        int i19 = b16.right;
        int i26 = b16.bottom;
        int i27 = b16.top;
        F3(this.I, i19, i26, i27);
        F3(this.J, i19, i26, i27);
        F3(this.f85254i0, i19, i26, i27);
        F3(this.f85268w0, i3, e16, 0);
        QLog.d("VFS-QFSFullScreenVideoPresenter", 1, "[adjustFullScreenViewSize] contentWidth: " + i3 + " | contentHeight: " + e16);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.d, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QFSFullScreenListScrollStateChangeEvent.class);
        eventClass.add(QFSFullClearEvent.class);
        eventClass.add(QCircleConfigChangeEvent.class);
        eventClass.add(RFWMediaFocusChangeEvent.class);
        eventClass.add(QFSFakeBarrageEvent.class);
        return eventClass;
    }

    protected void h2() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        FeedCloudMeta$StImage feedCloudMeta$StImage;
        if (super.h1()) {
            QLog.d("VFS-QFSFullScreenVideoPresenter", 1, "[bindCover] bind current frame bitmap.");
            return;
        }
        if (this.J != null && (feedCloudMeta$StFeed = this.N) != null && (feedCloudMeta$StImage = feedCloudMeta$StFeed.cover) != null && feedCloudMeta$StImage.picUrl != null) {
            q50.b.e().b(this.K);
            Option targetView = Option.obtain().setUrl(this.N.cover.picUrl.get()).setTargetView(this.J);
            this.K = targetView;
            targetView.setSupportRecycler(true);
            this.K.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
            QCircleFeedPicLoader.g().loadImage(this.K);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.d
    protected void i1(RFWFeedSelectInfo rFWFeedSelectInfo) {
        RFWFeedSelectInfo rFWFeedSelectInfo2 = this.f85269x0;
        if (rFWFeedSelectInfo2 == null) {
            QLog.d("VFS-QFSFullScreenVideoPresenter", 1, "[executeFromSelected] mQFSFeedSelectInfo == null.");
        } else {
            D2(rFWFeedSelectInfo2.getSelectedTag(), this.f85269x0.getSelectedType(), rFWFeedSelectInfo);
        }
    }

    protected void k2(final int i3) {
        QLog.d("VFS-QFSFullScreenVideoPresenter", 1, "change play status to = " + i3);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.QFSFullScreenVideoPresenter.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                QFSFullScreenVideoPresenter qFSFullScreenVideoPresenter = QFSFullScreenVideoPresenter.this;
                QUIPlayStatusIconView qUIPlayStatusIconView = qFSFullScreenVideoPresenter.W;
                if (qUIPlayStatusIconView != null && qFSFullScreenVideoPresenter.I != null) {
                    if (i3 == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    qUIPlayStatusIconView.a(z16);
                    if (i3 == 0) {
                        QFSFullScreenVideoPresenter.this.y2();
                        QFSFullScreenVideoPresenter.this.I.start();
                        QFSFullScreenVideoPresenter qFSFullScreenVideoPresenter2 = QFSFullScreenVideoPresenter.this;
                        qFSFullScreenVideoPresenter2.n2(qFSFullScreenVideoPresenter2.I.getSuperPlayer());
                        QFSFullScreenVideoPresenter.this.T0(new com.tencent.biz.qqcircle.immersive.feed.event.ap(false));
                        return;
                    }
                    VideoReport.unbindVideoPlayerInfo(QFSFullScreenVideoPresenter.this.I);
                    QFSFullScreenVideoPresenter.this.I.pause();
                    QFSFullScreenVideoPresenter.this.p2();
                    QFSFullScreenVideoPresenter.this.T0(new com.tencent.biz.qqcircle.immersive.feed.event.ap(true));
                }
            }
        });
    }

    protected void l2(final boolean z16) {
        QLog.d("VFS-QFSFullScreenVideoPresenter", 1, "change view status to = " + z16);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.QFSFullScreenVideoPresenter.5
            @Override // java.lang.Runnable
            public void run() {
                QFSFullScreenVideoPresenter qFSFullScreenVideoPresenter = QFSFullScreenVideoPresenter.this;
                ImageView imageView = qFSFullScreenVideoPresenter.J;
                if (imageView != null && qFSFullScreenVideoPresenter.P != null) {
                    if (z16) {
                        imageView.setVisibility(8);
                        QFSFullScreenVideoPresenter.this.P.setVisibility(0);
                        QFSFullScreenVideoPresenter.this.Q.setVisibility(8);
                    } else {
                        imageView.setVisibility(0);
                        QFSFullScreenVideoPresenter.this.P.setVisibility(8);
                        QFSFullScreenVideoPresenter.this.Q.setVisibility(0);
                    }
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(final View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null) {
            if (view.getId() == R.id.f42391jn) {
                QLog.d("VFS-QFSFullScreenVideoPresenter", 1, "[onClick] click full close btn.");
                com.tencent.biz.qqcircle.immersive.utils.bi.p(new bi.a() { // from class: com.tencent.biz.qqcircle.immersive.feed.cv
                    @Override // com.tencent.biz.qqcircle.immersive.utils.bi.a
                    public final void a(Pair pair) {
                        QFSFullScreenVideoPresenter.this.n3(pair);
                    }
                });
                e60.k.j().r(true);
            } else if (view.getId() == R.id.f66353ae) {
                v3(true);
            } else if (view.getId() != R.id.f42371jl && view.getId() != R.id.f42381jm && view.getId() != R.id.f42461ju) {
                if (view.getId() == R.id.f42451jt) {
                    QLog.d("VFS-QFSFullScreenVideoPresenter", 1, "[onClick] feedId: " + com.tencent.biz.qqcircle.utils.bj.g(this.N) + " | content: " + com.tencent.biz.qqcircle.utils.bj.e(this.N));
                    SimpleEventBus.getInstance().dispatchEvent(new QFSFullScreenClickAlbumPanelShowEvent(com.tencent.biz.qqcircle.utils.bj.g(this.N), true));
                    T0(new com.tencent.biz.qqcircle.immersive.feed.event.j(true, true));
                }
            } else {
                this.I.pause();
                SimpleEventBus.getInstance().dispatchEvent(new QFSFullScreenCloseEvent(com.tencent.biz.qqcircle.utils.bj.g((FeedCloudMeta$StFeed) this.f85017h)));
                RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.cx
                    @Override // java.lang.Runnable
                    public final void run() {
                        QFSFullScreenVideoPresenter.this.o3(view);
                    }
                }, 500L);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onDestroy() {
        super.onDestroy();
        QLog.d("VFS-QFSFullScreenVideoPresenter", 1, "onDestroyed");
        this.f85259n0 = false;
        a();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        o2();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.d, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
        if (rFWFeedSelectInfo == null) {
            return;
        }
        RFWLog.d("VFS-QFSFullScreenVideoPresenter", RFWLog.USR, "fs_lifecycle onSelected:" + rFWFeedSelectInfo + " | mPos:" + this.f85018i + " | hashCode:" + hashCode() + " | pageId:" + y0());
        if (rFWFeedSelectInfo.getPosition() != this.f85018i) {
            return;
        }
        f2();
        this.f85269x0 = rFWFeedSelectInfo;
        q2();
        i1(rFWFeedSelectInfo);
        L2(false);
        p2();
        x3();
        this.f85261p0 = -1;
        QFSVideoView qFSVideoView = this.I;
        if (qFSVideoView != null) {
            qFSVideoView.X0(Constants.Business.QQCIRCLE);
            this.I.U0();
        }
        QCircleToast.s(String.valueOf(hashCode()), true);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
        if (rFWFeedSelectInfo == null || rFWFeedSelectInfo.getPosition() != this.f85018i) {
            return;
        }
        RFWLog.d("VFS-QFSFullScreenVideoPresenter", RFWLog.USR, "onUnSelected:" + rFWFeedSelectInfo + " | mPos:" + this.f85018i + " | hashCode:" + hashCode() + " | pageId:" + y0());
        this.f85265t0 = null;
        p2();
        q2();
        x3();
        w3();
        a();
        this.f85256k0 = 0;
        this.f85269x0 = null;
        this.f85270y0.d();
        this.A0 = null;
        QCircleToast.s(String.valueOf(hashCode()), false);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onPaused(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onPaused(rFWFeedSelectInfo);
        k2(1);
        QCircleToast.s(String.valueOf(hashCode()), false);
        SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedVideoCurrentTimeEvent(this.f85256k0));
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.d, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QFSFullScreenListScrollStateChangeEvent) {
            P2((QFSFullScreenListScrollStateChangeEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSFullClearEvent) {
            N2((QFSFullClearEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QCircleConfigChangeEvent) {
            I2();
        } else if (simpleBaseEvent instanceof RFWMediaFocusChangeEvent) {
            Q2((RFWMediaFocusChangeEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSFakeBarrageEvent) {
            M2((QFSFakeBarrageEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onResumed(rFWFeedSelectInfo);
        if (rFWFeedSelectInfo == null || rFWFeedSelectInfo.getPosition() != this.f85018i) {
            return;
        }
        QLog.d("VFS-QFSFullScreenVideoPresenter", 1, "onResume selectInfo.getPosition: " + rFWFeedSelectInfo.getPosition() + ", mPos: " + this.f85018i);
        this.f85259n0 = true;
        E2(true, rFWFeedSelectInfo);
        QCircleToast.s(String.valueOf(hashCode()), true);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onStop(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onStop(rFWFeedSelectInfo);
        QLog.d("VFS-QFSFullScreenVideoPresenter", 1, DKHippyEvent.EVENT_STOP);
        k2(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r2() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.N;
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        SimpleEventBus.getInstance().dispatchEvent(new QFSVideoOnPlayEvent(feedCloudMeta$StFeed.f398449id.get(), hashCode()));
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: s1 */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        this.N = feedCloudMeta$StFeed;
        QLog.d("VFS-QFSFullScreenVideoPresenter", 1, "[onBindData] feed id: " + com.tencent.biz.qqcircle.utils.bj.g(feedCloudMeta$StFeed) + " | position: " + i3);
        T2();
        f2();
        h2();
        l2(false);
        A2();
        j2();
        A3(i3);
        K3(feedCloudMeta$StFeed);
        U2();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s3() {
        p2();
        this.f85267v0 = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.cw
            @Override // java.lang.Runnable
            public final void run() {
                QFSFullScreenVideoPresenter.this.l3();
            }
        };
        RFWThreadManager.getUIHandler().postDelayed(this.f85267v0, 3000L);
    }

    public void v3(boolean z16) {
        QFSVideoView qFSVideoView;
        if (this.f85259n0 && (qFSVideoView = this.I) != null) {
            if (qFSVideoView.getSuperPlayer() == null) {
                H3(true, null);
                return;
            }
            if (this.I.getSuperPlayer().isPlaying()) {
                k2(1);
                this.P.h(false);
                if (z16) {
                    T0(new com.tencent.biz.qqcircle.immersive.feed.event.am(true));
                    return;
                }
                return;
            }
            if (this.I.getSuperPlayer().isPausing()) {
                k2(0);
                this.P.h(true);
                if (z16) {
                    T0(new com.tencent.biz.qqcircle.immersive.feed.event.am(false));
                    return;
                }
                return;
            }
            H3(true, null);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "VFS-QFSFullScreenVideoPresenter";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x2(ISuperPlayer iSuperPlayer) {
        QLog.d("VFS-QFSFullScreenVideoPresenter", 1, "doOnVideoPrepare");
        k2(0);
        n2(iSuperPlayer);
    }

    public void z3(Long l3) {
        this.f85256k0 = l3.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements IRFWPlayerLooperListener {
        a() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLooperListener
        public void onVideoLoopEnd() {
            if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_use_loop_end_auto_scroll", true)) {
                QFSFullScreenVideoPresenter.this.f85263r0++;
            } else if (QFSFullScreenVideoPresenter.this.c3()) {
                QFSFullScreenVideoPresenter.this.s2();
            } else {
                QFSFullScreenVideoPresenter.this.f85263r0++;
            }
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLooperListener
        public void onVideoLoopStart() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements QFSFollowView.d {
        c() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public /* synthetic */ void b() {
            com.tencent.biz.qqcircle.widgets.aa.a(this);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public void onClick(int i3) {
            QFSFullScreenVideoPresenter qFSFullScreenVideoPresenter = QFSFullScreenVideoPresenter.this;
            qFSFullScreenVideoPresenter.z2(qFSFullScreenVideoPresenter.f85249d0, QCircleDaTongConstant.EventId.EV_XSJ_FOLLOW);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public void a() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public void c(int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d implements SeekBar.OnSeekBarChangeListener {
        d() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            QFSFullScreenVideoPresenter.this.J3(1);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            EventCollector.getInstance().onStopTrackingTouchBefore(seekBar);
            QFSFullScreenVideoPresenter.this.J3(2);
            EventCollector.getInstance().onStopTrackingTouch(seekBar);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i3, boolean z16) {
        }
    }
}
