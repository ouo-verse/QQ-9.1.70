package com.tencent.biz.qqcircle.immersive.feed.ad;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QCircleConfigChangeEvent;
import com.tencent.biz.qqcircle.events.QCircleFeedVideoControlEvent;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.views.QFSAudioView;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.widgets.QFSPagAnimView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayErrorStatusListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWPlayerReportInfo;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import com.tencent.mobileqq.auto.engine.lib.ASInject;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.libpag.PAGImage;

/* loaded from: classes4.dex */
public class QFSFeedChildAdPicPresenter extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {

    /* renamed from: b0, reason: collision with root package name */
    static Map<Class, h> f85368b0;
    private ImageView I;
    private QFSPagAnimView J;
    private String L;
    private String M;
    private int N;
    private GdtAd K = new GdtAd();
    private MediaPlayer P = null;
    private QFSAudioView Q = null;
    private ValueAnimator R = null;
    private boolean S = false;
    private boolean T = false;
    private volatile boolean U = false;
    private volatile boolean V = false;
    private volatile boolean W = false;
    private volatile boolean X = false;
    private volatile boolean Y = false;
    private int Z = 0;

    /* renamed from: a0, reason: collision with root package name */
    private int f85369a0 = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements IRFWPlayErrorStatusListener {
        a() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayErrorStatusListener
        public void onVideoPlayError(int i3, int i16, int i17, String str) {
            QLog.d("QFSFeedChildAdPicPresenter", 1, "[onVideoPlayError] errCode: " + i17);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements QFSPagAnimView.d {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.d
        public void a() {
            QLog.d("QFSFeedChildAdPicPresenter", 1, "pagImage replace success");
            QFSFeedChildAdPicPresenter.this.V = true;
            if (QFSFeedChildAdPicPresenter.this.Y) {
                QFSFeedChildAdPicPresenter.this.p2();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c extends QCirclePicStateListener {
        c() {
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            super.onStateChange(loadState, option);
            if (loadState.isFinishSuccess()) {
                QFSFeedChildAdPicPresenter.this.h2(option.getResultBitMap());
                QLog.d("QFSFeedChildAdPicPresenter", 1, "[loadPagImageFromPicLoader] Load Success");
            } else {
                QLog.d("QFSFeedChildAdPicPresenter", 1, "[loadPagImageFromPicLoader] Load Fail, seq=", Integer.valueOf(option.getSeq()), ", viewHash=", Integer.valueOf(QFSFeedChildAdPicPresenter.this.I.hashCode()), ", state=", loadState);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d implements MediaPlayer.OnPreparedListener {
        d() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            QLog.d("QFSFeedChildAdPicPresenter", 1, "startAudioPlayer onPrepared");
            if (QFSFeedChildAdPicPresenter.this.I1()) {
                QLog.e("QFSFeedChildAdPicPresenter", 1, "startAudioPlayer canNotPlayAudio");
            } else if (QFSFeedChildAdPicPresenter.this.P == null) {
                QLog.e("QFSFeedChildAdPicPresenter", 1, "startAudioPlayer mAudioPlayer is null");
            } else {
                QFSFeedChildAdPicPresenter.this.P.start();
                QLog.d("QFSFeedChildAdPicPresenter", 1, "startAudioPlayer playerMusic");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class f extends RFWPlayerIOC {
        f() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
        public RFWPlayerReportInfo<e30.b> getBusinessReportInfo() {
            return gb0.b.m(((QFSBaseFeedChildPresenter) QFSFeedChildAdPicPresenter.this).E.o("KEY_RFW_VIDEO_FEED_POI", Integer.valueOf(((QFSBaseFeedChildPresenter) QFSFeedChildAdPicPresenter.this).f85018i)));
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
        public boolean isValid() {
            return QFSFeedChildAdPicPresenter.this.S1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public interface h {
        void a(QFSFeedChildAdPicPresenter qFSFeedChildAdPicPresenter, SimpleBaseEvent simpleBaseEvent);
    }

    static {
        HashMap hashMap = new HashMap();
        f85368b0 = hashMap;
        hashMap.put(QCircleFeedVideoControlEvent.class, new h() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.ci
            @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdPicPresenter.h
            public final void a(QFSFeedChildAdPicPresenter qFSFeedChildAdPicPresenter, SimpleBaseEvent simpleBaseEvent) {
                QFSFeedChildAdPicPresenter.X1(qFSFeedChildAdPicPresenter, simpleBaseEvent);
            }
        });
        f85368b0.put(QCirclePanelStateEvent.class, new h() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.cj
            @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdPicPresenter.h
            public final void a(QFSFeedChildAdPicPresenter qFSFeedChildAdPicPresenter, SimpleBaseEvent simpleBaseEvent) {
                QFSFeedChildAdPicPresenter.Z1(qFSFeedChildAdPicPresenter, simpleBaseEvent);
            }
        });
        f85368b0.put(QCircleConfigChangeEvent.class, new h() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.ck
            @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdPicPresenter.h
            public final void a(QFSFeedChildAdPicPresenter qFSFeedChildAdPicPresenter, SimpleBaseEvent simpleBaseEvent) {
                qFSFeedChildAdPicPresenter.H1();
            }
        });
        f85368b0.put(QCirclePanelStateEvent.class, new h() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.cl
            @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdPicPresenter.h
            public final void a(QFSFeedChildAdPicPresenter qFSFeedChildAdPicPresenter, SimpleBaseEvent simpleBaseEvent) {
                QFSFeedChildAdPicPresenter.c2(qFSFeedChildAdPicPresenter, simpleBaseEvent);
            }
        });
    }

    private void G1(RFWPlayerOptions rFWPlayerOptions) {
        rFWPlayerOptions.setPlayIOC(new f());
        rFWPlayerOptions.getListenerSet().addPrepareListeners(new g());
        rFWPlayerOptions.getListenerSet().addErrorStatusListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H1() {
        x0().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.cm
            @Override // java.lang.Runnable
            public final void run() {
                QFSFeedChildAdPicPresenter.this.U1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean I1() {
        if (s0() != null && S1()) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean J1(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = (FeedCloudMeta$StFeed) this.f85017h;
        if (feedCloudMeta$StFeed == null) {
            QLog.d("QFSFeedChildAdPicPresenter", 1, "onBindData is null: " + i3);
            return true;
        }
        if (com.tencent.biz.qqcircle.immersive.utils.r.B0(feedCloudMeta$StFeed, feedCloudMeta$StFeed2) && i3 == this.f85018i) {
            return true;
        }
        return false;
    }

    private void K1() {
        if (this.S) {
            return;
        }
        this.S = true;
        try {
            Field declaredField = ValueAnimator.class.getDeclaredField("sDurationScale");
            declaredField.setAccessible(true);
            if (Float.compare(declaredField.getFloat(null), 0.0f) == 0) {
                QLog.d("QFSFeedChildAdPicPresenter", 1, "checkSystemAnimatorDuration Closed");
                this.T = true;
            } else {
                this.T = false;
            }
        } catch (Throwable th5) {
            QLog.d("QFSFeedChildAdPicPresenter", 1, "checkSystemAnimatorDurationClosed error:", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void L1() {
        QLog.d("QFSFeedChildAdPicPresenter", 1, "doOnPagAnimationEnd");
        if (!this.X) {
            T0(new com.tencent.biz.qqcircle.immersive.feed.event.e(this.K.getTraceId()));
            this.W = true;
        }
        this.U = false;
        q2(true);
        if (TextUtils.equals(af.v((FeedCloudMeta$StFeed) this.f85017h), "0")) {
            return;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 1);
        this.R = ofInt;
        ofInt.setInterpolator(new DecelerateInterpolator());
        this.R.setDuration(Integer.parseInt(af.v((FeedCloudMeta$StFeed) this.f85017h)) * 1000);
        this.R.addListener(new e());
        this.R.start();
    }

    private void M1(QCircleFeedVideoControlEvent qCircleFeedVideoControlEvent) {
        if (qCircleFeedVideoControlEvent.isPlay() && m0() != null && m0().hashCode() != qCircleFeedVideoControlEvent.getHashCode()) {
            QLog.d("QFSFeedChildAdPicPresenter", 1, "doPlayByEvent replayAnim");
            i2();
        }
    }

    private void N1() {
        if (this.Q != null && S1()) {
            if (this.Q.getSuperPlayer() == null) {
                QLog.d("QFSFeedChildAdPicPresenter", 1, "[executeAudioPlay] execute a new player: " + hashCode());
                l2();
                return;
            }
            if (!this.Q.isRelease() && !this.Q.getQCirclePlayer().isDeInit()) {
                if (this.Q.getSuperPlayer().isPlaying()) {
                    QLog.d("QFSFeedChildAdPicPresenter", RFWLog.USR, "[executeAudioPlay] isPlaying: " + hashCode());
                    return;
                }
                if (this.Q.getSuperPlayer().isPausing()) {
                    this.Q.start();
                    QLog.d("QFSFeedChildAdPicPresenter", RFWLog.USR, "[executeAudioPlay] startFromPause hashCode:" + hashCode());
                    return;
                }
                l2();
                QLog.d("QFSFeedChildAdPicPresenter", 1, "[executeAudioPlay] start a new Audio Player.");
                return;
            }
            QLog.d("QFSFeedChildAdPicPresenter", 1, "[executeAudioPlay] released, execute a new player: " + hashCode());
            l2();
            return;
        }
        QLog.d("QFSFeedChildAdPicPresenter", 1, "[executeAudioPlay] mAudioView null.");
    }

    private void O1(com.tencent.biz.qqcircle.immersive.feed.event.f fVar) {
        if (!TextUtils.equals(fVar.getMTraceId(), this.K.getTraceId())) {
            return;
        }
        QLog.d("QFSFeedChildAdPicPresenter", 1, "handleAdReplayEvent replayAnim");
        i2();
    }

    private void P1(@NonNull QCirclePanelStateEvent qCirclePanelStateEvent) {
        if (!TextUtils.equals(qCirclePanelStateEvent.getFeedId(), j())) {
            return;
        }
        QLog.d("QFSFeedChildAdPicPresenter", 1, "handleCommentOrShareStateChangeEvent replayAnim");
        i2();
    }

    private void Q1(QCirclePanelStateEvent qCirclePanelStateEvent) {
        if (qCirclePanelStateEvent.getPanelType() == 27) {
            r2(qCirclePanelStateEvent.isShowing());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void R1() {
        FeedCloudMeta$StFeed g16;
        int i3;
        if (this.J != null && !TextUtils.isEmpty(this.L)) {
            if (this.T) {
                s2(false);
                q2(true);
                QLog.d("QFSFeedChildAdPicPresenter", 1, "initPagAnimView return: system animator duration is 0");
                return;
            }
            s2(true);
            e30.b bVar = this.E;
            if (bVar == null) {
                g16 = null;
            } else {
                g16 = bVar.g();
            }
            if (af.h(g16, (FeedCloudMeta$StFeed) this.f85017h, this.K)) {
                i3 = 1;
            } else {
                i3 = -1;
            }
            this.J.setRepeatTimes(i3);
            this.J.R(this.L);
            this.J.setResUrl(this.M);
            this.J.setEditResMode(true);
            this.J.setPagViewScaleMode(1);
            H1();
            this.J.setPagAnimListener(new QFSPagAnimView.c() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdPicPresenter.1
                @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
                public void onAnimationCancel(QFSPagAnimView qFSPagAnimView) {
                    QLog.d("QFSFeedChildAdPicPresenter", 4, "onAnimationCancel");
                    QFSFeedChildAdPicPresenter.this.U = false;
                    QFSFeedChildAdPicPresenter.this.X = true;
                }

                @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
                public void onAnimationEnd(QFSPagAnimView qFSPagAnimView) {
                    QLog.d("QFSFeedChildAdPicPresenter", 4, "onAnimationEnd");
                    QFSFeedChildAdPicPresenter.this.L1();
                    QFSFeedChildAdPicPresenter.this.m2();
                }

                @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
                public void onAnimationRepeat(QFSPagAnimView qFSPagAnimView) {
                    QLog.d("QFSFeedChildAdPicPresenter", 4, "onAnimationRepeat");
                    QFSFeedChildAdPicPresenter.this.U = true;
                    RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdPicPresenter.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            QFSFeedChildAdPicPresenter.this.j2();
                        }
                    });
                }

                @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
                public void onAnimationStart(QFSPagAnimView qFSPagAnimView) {
                    QLog.d("QFSFeedChildAdPicPresenter", 4, "onAnimationStart");
                    QFSFeedChildAdPicPresenter.this.U = true;
                    QFSFeedChildAdPicPresenter.this.X = false;
                    RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdPicPresenter.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QFSFeedChildAdPicPresenter.this.j2();
                        }
                    });
                }

                @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
                public /* synthetic */ void onAnimationUpdate(QFSPagAnimView qFSPagAnimView) {
                    com.tencent.biz.qqcircle.widgets.bc.e(this, qFSPagAnimView);
                }

                @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
                public /* synthetic */ void onPagPlayError(QFSPagAnimView qFSPagAnimView, String str) {
                    com.tencent.biz.qqcircle.widgets.bc.f(this, qFSPagAnimView, str);
                }
            });
            this.J.setPagImageReplaceListener(new b());
            o2();
            return;
        }
        QLog.e("QFSFeedChildAdPicPresenter", 1, "startPagAnim error: mPagImage is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean S1() {
        HashMap<String, String> hashMap;
        boolean z16;
        boolean isOnThirdTab = ASInject.g().getAsEngineDelegate().isOnThirdTab(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE);
        if (s0() == null) {
            return false;
        }
        QCircleInitBean mInitBean = s0().getMInitBean();
        if (mInitBean != null) {
            hashMap = s0().getMInitBean().getSchemeAttrs();
        } else {
            hashMap = null;
        }
        if (hashMap != null && String.valueOf(11).equals(hashMap.get("key_jump_from"))) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean a16 = com.tencent.biz.qqcircle.utils.ae.a(mInitBean);
        QLog.d("QFSFeedChildAdPicPresenter", 1, "isFeedOnScreen:" + E0() + " isOnThirdTab:" + isOnThirdTab + " pageId:" + y0() + "| isFromBottom" + z16 + "| isShowSplash" + a16 + hashCode());
        if (!E0() || ((!isOnThirdTab && QCirclePluginUtil.isTabMode() && z16) || a16)) {
            return false;
        }
        return true;
    }

    private boolean T1() {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_ad_pic_check_pag_so_init", true)) {
            return true;
        }
        return com.tencent.biz.qqcircle.immersive.views.x.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U1() {
        View view = this.f85016f;
        if (view == null) {
            return;
        }
        this.Z = view.getMeasuredWidth();
        this.f85369a0 = this.f85016f.getMeasuredHeight() - DisplayUtil.dip2px(this.f85016f.getContext(), 56.0f);
        if (this.Z == 0) {
            this.Z = com.tencent.biz.qqcircle.utils.bz.i(this.f85016f.getContext());
            this.f85369a0 = DisplayUtil.getScreenHeight() - DisplayUtil.dip2px(this.f85016f.getContext(), 56.0f);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.J.getLayoutParams();
        if (this.N == 2) {
            int i3 = this.Z;
            if (i3 / this.f85369a0 > 0.5625f) {
                QLog.d("QFSFeedChildAdPicPresenter", 4, "containerWidth / containerHeight > 9 / 16");
                layoutParams.height = this.f85369a0;
                layoutParams.width = (int) ((r1 * 9) / 16.0f);
            } else {
                layoutParams.width = i3;
                layoutParams.height = (int) ((i3 * 16) / 9.0f);
            }
        } else {
            layoutParams.width = this.Z;
            layoutParams.height = (int) ((r1 * 9) / 16.0f);
        }
        this.J.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V1() {
        if (com.tencent.biz.qqcircle.immersive.views.x.c()) {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.cq
                @Override // java.lang.Runnable
                public final void run() {
                    QFSFeedChildAdPicPresenter.this.p2();
                }
            });
        } else {
            QLog.d("QFSFeedChildAdPicPresenter", 1, "checkPagSoRead: false.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W1() {
        View view = this.C;
        if (view != null && (view.getParent() instanceof RecyclerView) && ((RecyclerView) this.C.getParent()).getAdapter() != null) {
            int itemCount = ((RecyclerView) this.C.getParent()).getAdapter().getItemCount();
            int i3 = this.f85018i;
            if (itemCount > i3) {
                int i16 = i3 + 1;
                RecyclerView recyclerView = (RecyclerView) this.C.getParent();
                if (recyclerView.getAdapter() == null) {
                    QLog.e("QFSFeedChildAdPicPresenter", 1, "[scrollToNextItem] recyclerView.getAdapter is null");
                    return;
                }
                QLog.d("QFSFeedChildAdPicPresenter", 1, "[scrollToNextItem] nextPos: " + i16 + " | prePos: " + this.f85018i);
                if (recyclerView.getAdapter().getItemCount() - 1 >= i16) {
                    recyclerView.smoothScrollToPosition(i16);
                    com.tencent.biz.qqcircle.immersive.utils.u.c(recyclerView);
                    P0();
                    return;
                }
                i2();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void X1(QFSFeedChildAdPicPresenter qFSFeedChildAdPicPresenter, SimpleBaseEvent simpleBaseEvent) {
        qFSFeedChildAdPicPresenter.M1((QCircleFeedVideoControlEvent) simpleBaseEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Z1(QFSFeedChildAdPicPresenter qFSFeedChildAdPicPresenter, SimpleBaseEvent simpleBaseEvent) {
        qFSFeedChildAdPicPresenter.P1((QCirclePanelStateEvent) simpleBaseEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c2(QFSFeedChildAdPicPresenter qFSFeedChildAdPicPresenter, SimpleBaseEvent simpleBaseEvent) {
        qFSFeedChildAdPicPresenter.Q1((QCirclePanelStateEvent) simpleBaseEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d2() {
        if (TextUtils.isEmpty(this.L)) {
            return;
        }
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(this.L).setTargetView(this.I).setRequestWidth(DisplayUtil.getScreenWidth()).setRequestHeight(DisplayUtil.getScreenHeight()).setLoadingDrawableColor(0).setSupportRecycler(true), new c());
    }

    private void f2() {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_ad_pic_release_audio_player_in_sub_thread", false)) {
            this.P.release();
        } else {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdPicPresenter.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (QFSFeedChildAdPicPresenter.this.P == null) {
                            return;
                        }
                        QFSFeedChildAdPicPresenter.this.P.release();
                        QLog.d("QFSFeedChildAdPicPresenter", 1, "release AudioPlayer in sub.");
                    } catch (Throwable unused) {
                        QLog.e("QFSFeedChildAdPicPresenter", 1, "release AudioPlayer error");
                    }
                }
            });
        }
    }

    private void g2() {
        QFSAudioView qFSAudioView = this.Q;
        if (qFSAudioView != null) {
            qFSAudioView.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h2(Bitmap bitmap) {
        if (this.J == null) {
            QLog.e("QFSFeedChildAdPicPresenter", 1, "replacePagImage error: mPagAnimView is null");
            return;
        }
        if (bitmap == null) {
            QLog.e("QFSFeedChildAdPicPresenter", 1, "replacePagImage error: bitmap is null");
            return;
        }
        if (!T1()) {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.cp
                @Override // java.lang.Runnable
                public final void run() {
                    QFSFeedChildAdPicPresenter.this.V1();
                }
            });
            QLog.e("QFSFeedChildAdPicPresenter", 1, "replacePagImage error: so not ready.");
            return;
        }
        try {
            this.J.O(0, PAGImage.FromBitmap(bitmap));
            QLog.d("QFSFeedChildAdPicPresenter", 1, "replacePagImage success");
        } catch (Throwable th5) {
            QLog.e("QFSFeedChildAdPicPresenter", 1, "replacePagImage error:", th5);
        }
    }

    private void i2() {
        if (this.T) {
            QLog.d("QFSFeedChildAdPicPresenter", 1, "replayAnim return: system animator duration is 0");
            return;
        }
        ValueAnimator valueAnimator = this.R;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (this.U) {
            QLog.d("QFSFeedChildAdPicPresenter", 1, "replayAnim return mIsAnimPlaying");
            return;
        }
        QFSVideoView.D = null;
        n2();
        q2(false);
        p2();
        this.W = false;
        this.X = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String j() {
        T t16 = this.f85017h;
        if (t16 == 0) {
            return "";
        }
        return ((FeedCloudMeta$StFeed) t16).f398449id.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j2() {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_ad_pic_change_to_audio_view", true)) {
            N1();
            return;
        }
        QFSPagAnimView qFSPagAnimView = this.J;
        if (qFSPagAnimView == null) {
            QLog.e("QFSFeedChildAdPicPresenter", 1, "initAudioDataSource error: mPagAnimView is null");
            return;
        }
        ByteBuffer v3 = qFSPagAnimView.v(0);
        if (v3 == null) {
            QLog.e("QFSFeedChildAdPicPresenter", 1, "initAudioDataSource error: mPagAnimView PagAudioBytes is null");
            return;
        }
        if (TextUtils.isEmpty(this.M)) {
            QLog.e("QFSFeedChildAdPicPresenter", 1, "initAudioDataSource error: mPagResUrl is empty");
            return;
        }
        try {
            this.P = new ReportMediaPlayer();
            String h06 = af.h0(v3, this.M);
            QLog.d("QFSFeedChildAdPicPresenter", 4, "outputAudioFile:", h06);
            this.P.setDataSource(h06);
            this.P.setAudioStreamType(3);
            this.P.setOnPreparedListener(new d());
            this.P.prepareAsync();
        } catch (Throwable th5) {
            QLog.e("QFSFeedChildAdPicPresenter", 1, "initAudioDataSource error:", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k2() {
        if (this.J != null && S1()) {
            if (this.U) {
                QLog.d("QFSFeedChildAdPicPresenter", 1, "startPagAnim error: mPagAnimView is playing");
                return;
            }
            if (!this.V) {
                QLog.e("QFSFeedChildAdPicPresenter", 1, "startPagAnim mPagAnimRunnable error: PagImage not Ready");
                q2(true);
                return;
            } else {
                QLog.d("QFSFeedChildAdPicPresenter", 1, "startPagAnim success");
                s2(true);
                this.J.L();
                return;
            }
        }
        QLog.e("QFSFeedChildAdPicPresenter", 1, "startPagAnim error: mPagAnimView is null");
    }

    private void l2() {
        QFSPagAnimView qFSPagAnimView = this.J;
        if (qFSPagAnimView != null && this.Q != null) {
            ByteBuffer v3 = qFSPagAnimView.v(0);
            if (v3 == null) {
                QLog.e("QFSFeedChildAdPicPresenter", 1, "[startQFSAudioPlayer] error: PagAudioBytes is null");
                return;
            }
            if (TextUtils.isEmpty(this.M)) {
                QLog.e("QFSFeedChildAdPicPresenter", 1, "[startQFSAudioPlayer] error: mPagResUrl is empty");
                return;
            }
            String h06 = af.h0(v3, this.M);
            QLog.d("QFSFeedChildAdPicPresenter", 4, "outputAudioFile:", h06);
            RFWPlayerOptions startOffset = RFWPlayerOptions.obtain(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO()).setPlayUrl(h06).setIsVideo(false).setStartOffset(0L);
            G1(startOffset);
            this.Q.loadPlayOptions(startOffset);
            return;
        }
        QLog.e("QFSFeedChildAdPicPresenter", 1, "[startQFSAudioPlayer] error: mPagAnimView is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m2() {
        QFSAudioView qFSAudioView = this.Q;
        if (qFSAudioView != null) {
            qFSAudioView.stop();
        }
    }

    private void n2() {
        QFSPagAnimView qFSPagAnimView = this.J;
        if (qFSPagAnimView != null) {
            qFSPagAnimView.V();
        }
        MediaPlayer mediaPlayer = this.P;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.stop();
                f2();
            } catch (Throwable unused) {
                QLog.e("QFSFeedChildAdPicPresenter", 1, "stopPagAnim stop AudioPlayer error");
            }
        }
        m2();
        this.U = false;
    }

    private void o2() {
        if (TextUtils.isEmpty(this.M)) {
            QLog.e("QFSFeedChildAdPicPresenter", 1, "tryToLoadPagImage error: mPagResUrl is null");
        } else {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.cn
                @Override // java.lang.Runnable
                public final void run() {
                    QFSFeedChildAdPicPresenter.this.d2();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p2() {
        if (TextUtils.isEmpty(this.M)) {
            QLog.e("QFSFeedChildAdPicPresenter", 1, "tryToStartPagAnim error: mPagResUrl is null");
        } else {
            if (!this.V) {
                QLog.e("QFSFeedChildAdPicPresenter", 1, "tryToStartPagAnim mPagAnimRunnable error: PagImage not Ready, try again");
                o2();
                RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdPicPresenter.5
                    @Override // java.lang.Runnable
                    public void run() {
                        QFSFeedChildAdPicPresenter.this.k2();
                    }
                }, 500L);
                return;
            }
            k2();
        }
    }

    private void q2(boolean z16) {
        int i3;
        ImageView imageView = this.I;
        if (imageView == null) {
            return;
        }
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    private void r2(boolean z16) {
        if (!com.tencent.biz.qqcircle.immersive.utils.av.b()) {
            return;
        }
        t2(z16);
    }

    private void s2(boolean z16) {
        int i3;
        QFSPagAnimView qFSPagAnimView = this.J;
        if (qFSPagAnimView == null) {
            return;
        }
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        qFSPagAnimView.setVisibility(i3);
    }

    private void t2(boolean z16) {
        boolean z17;
        QFSAudioView qFSAudioView = this.Q;
        if (qFSAudioView != null && qFSAudioView.getQCirclePlayer() != null && this.Q.getQCirclePlayer().isPlaying()) {
            z17 = true;
        } else {
            z17 = false;
        }
        QLog.d("QFSFeedChildAdPicPresenter", 1, "[updateShowPanelPlayerControl] isShowing: " + z16 + " | isPlaying: " + z17);
        if (z17 && z16) {
            n2();
        } else if (!z17) {
            i2();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        MotionEvent a16;
        View view;
        super.C0(hVar);
        if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.ak) {
            if (af.T(this.K) && (a16 = ((com.tencent.biz.qqcircle.immersive.feed.event.ak) hVar).a()) != null && (view = this.f85016f) != null) {
                com.tencent.biz.qqcircle.immersive.utils.ad.a aVar = com.tencent.biz.qqcircle.immersive.utils.ad.a.f90082a;
                boolean a17 = aVar.a(this.K, 0, 0, view.getHeight(), a16.getY());
                boolean b16 = aVar.b(this.K, this.f85016f.getHeight(), a16.getY());
                if (a17 || b16) {
                    com.tencent.biz.qqcircle.immersive.utils.j.f90213a.K(this.K, this.f85016f, this.f85018i, r(), 5);
                    return;
                }
                return;
            }
            return;
        }
        if (!(hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.f) || !af.T(this.K)) {
            return;
        }
        O1((com.tencent.biz.qqcircle.immersive.feed.event.f) hVar);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void M0() {
        super.M0();
        this.Y = false;
        n2();
        q2(false);
        s2(false);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.f85016f = ((ViewStub) view.findViewById(R.id.f38461_1)).inflate();
        this.J = (QFSPagAnimView) view.findViewById(R.id.f33350w8);
        this.I = (ImageView) view.findViewById(R.id.f33360w9);
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_ad_pic_change_to_audio_view", true)) {
            this.Q = new QFSAudioView(m0());
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void S0() {
        QLog.d("QFSFeedChildAdPicPresenter", 1, "scrollToNextItem");
        x0().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.co
            @Override // java.lang.Runnable
            public final void run() {
                QFSFeedChildAdPicPresenter.this.W1();
            }
        });
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [feedcloud.FeedCloudMeta$StFeed, T] */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: e2, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        String str;
        if (J1(feedCloudMeta$StFeed, i3)) {
            return;
        }
        super.L0(feedCloudMeta$StFeed, i3);
        this.f85017h = u.c(this.E);
        this.f85018i = i3;
        GdtAd gdtAd = new GdtAd(u.e(this.E));
        this.K = gdtAd;
        if (!af.T(gdtAd)) {
            return;
        }
        this.N = this.K.getInnerShowType();
        if (this.K.getImageData() == null) {
            str = "";
        } else {
            str = this.K.getImageData().url;
        }
        this.L = str;
        this.M = af.H(this.K);
        this.U = false;
        this.W = false;
        this.V = false;
        K1();
        R1();
        U0(ae.b(feedCloudMeta$StFeed, i3));
        QLog.d("QFSFeedChildAdPicPresenter", 1, "onBindData feed id: ", j(), "mPos: ", Integer.valueOf(this.f85018i));
        QLog.d("QFSFeedChildAdPicPresenter", 4, "bind data mAdImageUrl:" + this.L);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QCircleFeedVideoControlEvent.class);
        eventClass.add(QCirclePanelStateEvent.class);
        eventClass.add(QCircleConfigChangeEvent.class);
        eventClass.add(QCirclePanelStateEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onDestroy() {
        super.onDestroy();
        g2();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        if (rFWFeedSelectInfo != null && rFWFeedSelectInfo.getPosition() == this.f85018i) {
            cc0.e.d(System.currentTimeMillis(), rFWFeedSelectInfo.getPosition());
            if (!af.T(this.K)) {
                QLog.d("QFSFeedChildAdPicPresenter", 4, "onFeedSelected current feed not is pic ad type");
                return;
            }
            GdtAd gdtAd = this.K;
            if (gdtAd != null && !TextUtils.isEmpty(gdtAd.getTraceId())) {
                v.c(this.K.getTraceId());
                v.b(this.K.getTraceId());
            }
            ValueAnimator valueAnimator = this.R;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            QLog.d("QFSFeedChildAdPicPresenter", 1, "onFeedSelected replayAnim");
            this.Y = true;
            i2();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onPaused(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onPaused(rFWFeedSelectInfo);
        n2();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        for (Class cls : f85368b0.keySet()) {
            if (simpleBaseEvent.getClass() == cls) {
                f85368b0.get(cls).a(this, simpleBaseEvent);
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onResumed(rFWFeedSelectInfo);
        if (rFWFeedSelectInfo != null && rFWFeedSelectInfo.getPosition() == this.f85018i) {
            if (!af.T(this.K)) {
                QLog.d("QFSFeedChildAdPicPresenter", 1, "onResumed current feed not is pic ad type.");
                return;
            }
            GdtAd gdtAd = this.K;
            if (gdtAd != null && !TextUtils.isEmpty(gdtAd.getTraceId())) {
                v.c(this.K.getTraceId());
            }
            ValueAnimator valueAnimator = this.R;
            if (valueAnimator != null) {
                valueAnimator.resume();
            }
            if (!this.W) {
                QLog.d("QFSFeedChildAdPicPresenter", 1, "onResumed replayAnim");
                i2();
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onStop(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onStop(rFWFeedSelectInfo);
        if (rFWFeedSelectInfo != null && rFWFeedSelectInfo.getPosition() == this.f85018i) {
            n2();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildAdPicPresenter";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class e extends com.tencent.mobileqq.widget.ak {
        e() {
        }

        @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QLog.d("QFSFeedChildAdPicPresenter", 1, "EndCardScrollNext scrollToNextItem");
            QFSFeedChildAdPicPresenter.this.S0();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class g implements IRFWPlayerPrepareListener {
        g() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onVideoPrepared(RFWPlayer rFWPlayer) {
            if (QFSFeedChildAdPicPresenter.this.Q != null && QFSFeedChildAdPicPresenter.this.S1()) {
                QFSFeedChildAdPicPresenter.this.Q.start();
            }
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onFirstFrameRendered(RFWPlayer rFWPlayer) {
        }
    }
}
