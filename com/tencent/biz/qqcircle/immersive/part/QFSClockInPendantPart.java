package com.tencent.biz.qqcircle.immersive.part;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.events.QFSUpdateClockStateEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSFeedPositionChangeEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSHeaderRefreshEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSVideoLoopStartEvent;
import com.tencent.biz.qqcircle.immersive.views.QFSCircleProgressView;
import com.tencent.biz.qqcircle.requests.QCircleDoBrowseReportRequest;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory;
import com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.order.IOrderElement;
import com.tencent.biz.richframework.video.rfw.view.RFWVideoDurationHelper;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.auto.engine.event.ASEngineTabStatusEvent;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import com.tencent.mobileqq.qcircle.api.animation.QCircleAnimationHelper;
import com.tencent.mobileqq.qcircle.api.data.QFSClockInBean;
import com.tencent.mobileqq.qcircle.api.event.QFSClockInPendantChangeEvent;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudWrite$StDoBrowseReportRsp;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes4.dex */
public class QFSClockInPendantPart extends u implements SimpleEventReceiver, View.OnClickListener, IOrderElement {
    private TextView C;
    private TextView D;
    private TextView E;
    private View F;
    private boolean G;
    private int H;
    private QFSClockInBean I;
    private long J;
    private boolean K;
    private boolean L;
    private int M;
    private boolean N;
    private boolean P;
    private boolean Q = false;
    private final RFWVideoDurationHelper.VideoDurationUpdateListener R = new a();
    private final Runnable S = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSClockInPendantPart.2
        @Override // java.lang.Runnable
        public void run() {
            if (QFSClockInPendantPart.this.F == null) {
                return;
            }
            QFSClockInPendantPart.this.F.setVisibility(8);
        }
    };

    /* renamed from: d, reason: collision with root package name */
    private View f87328d;

    /* renamed from: e, reason: collision with root package name */
    private QFSCircleProgressView f87329e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f87330f;

    /* renamed from: h, reason: collision with root package name */
    private View f87331h;

    /* renamed from: i, reason: collision with root package name */
    private View f87332i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f87333m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.biz.qqcircle.immersive.part.QFSClockInPendantPart$6, reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass6 implements AnimationDrawableFactory.CreateResultListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QFSClockInBean f87334d;

        AnonymousClass6(QFSClockInBean qFSClockInBean) {
            this.f87334d = qFSClockInBean;
        }

        @Override // com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.CreateResultListener
        public void onCreateResult(boolean z16, final QQAnimationDrawable qQAnimationDrawable) {
            if (!z16) {
                return;
            }
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSClockInPendantPart.6.1
                @Override // java.lang.Runnable
                public void run() {
                    if (QFSClockInPendantPart.this.f87330f == null) {
                        return;
                    }
                    qQAnimationDrawable.setOneShot(true);
                    qQAnimationDrawable.setDuration(1000L);
                    qQAnimationDrawable.setListener(new a());
                    QFSClockInPendantPart.this.f87331h.setVisibility(0);
                    QFSClockInPendantPart.this.D.setText("");
                    QFSClockInPendantPart.this.f87329e.setVisibility(8);
                    QFSClockInPendantPart.this.f87332i.setVisibility(8);
                    QFSClockInPendantPart.this.f87330f.setImageDrawable(qQAnimationDrawable);
                    qQAnimationDrawable.start();
                    AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                    QFSClockInPendantPart.this.oa(anonymousClass6.f87334d.getSignedText());
                    QFSClockInPendantPart qFSClockInPendantPart = QFSClockInPendantPart.this;
                    qFSClockInPendantPart.M = qFSClockInPendantPart.H;
                }

                /* renamed from: com.tencent.biz.qqcircle.immersive.part.QFSClockInPendantPart$6$1$a */
                /* loaded from: classes4.dex */
                class a implements QQAnimationDrawable.QQAnimationListener {
                    a() {
                    }

                    @Override // com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable.QQAnimationListener
                    public void onStop() {
                        AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                        QFSClockInPendantPart.this.va(anonymousClass6.f87334d);
                    }

                    @Override // com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable.QQAnimationListener
                    public void onStart() {
                    }

                    @Override // com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable.QQAnimationListener
                    public void onPlay(int i3) {
                    }
                }
            });
        }
    }

    /* loaded from: classes4.dex */
    class a implements RFWVideoDurationHelper.VideoDurationUpdateListener {
        a() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.view.RFWVideoDurationHelper.VideoDurationUpdateListener
        public void onDurationUpdate(long j3) {
            if (QFSClockInPendantPart.this.f87329e != null && QFSClockInPendantPart.this.I != null && QFSClockInPendantPart.this.I.getDuration() != 0) {
                long j16 = QFSClockInPendantPart.this.J + j3;
                uq3.k.a().n("sp_key_clock_in_duration", j16);
                float duration = (((float) j16) * 100.0f) / QFSClockInPendantPart.this.I.getDuration();
                if (duration < 0.0f) {
                    duration = 0.0f;
                }
                if (duration >= 100.0f) {
                    QFSClockInPendantPart.this.f87329e.setProgress(100.0f);
                    RFWVideoDurationHelper.g().disable();
                    QFSClockInPendantPart.this.qa();
                    return;
                }
                QFSClockInPendantPart.this.f87329e.setProgress(duration);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b extends QCirclePicStateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QFSClockInBean f87343d;

        b(QFSClockInBean qFSClockInBean) {
            this.f87343d = qFSClockInBean;
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            super.onStateChange(loadState, option);
            if (loadState == LoadState.STATE_SUCCESS && this.f87343d.getDuration() != 0) {
                QFSClockInPendantPart.this.L = true;
                QFSClockInPendantPart.this.f87332i.setVisibility(8);
                QFSClockInPendantPart.this.f87331h.setVisibility(0);
                QFSClockInPendantPart.this.f87329e.setVisibility(0);
                QFSClockInPendantPart.this.D.setText("");
                String clockedText = this.f87343d.getClockedText();
                if (!TextUtils.isEmpty(clockedText) && !TextUtils.equals(clockedText, uq3.k.a().h("sp_key_clock_in_first_bubble_text", ""))) {
                    uq3.k.a().p("sp_key_clock_in_first_bubble_text", clockedText);
                    QFSClockInPendantPart.this.oa(clockedText);
                }
                QFSClockInPendantPart.this.J = uq3.k.a().f("sp_key_clock_in_duration", 0L);
                QFSClockInPendantPart.this.f87329e.setProgress(Math.min((((float) QFSClockInPendantPart.this.J) * 100.0f) / this.f87343d.getDuration(), 100.0f));
                RFWVideoDurationHelper.g().registerVideoDurationUpdateListener(QFSClockInPendantPart.this.R);
                RFWVideoDurationHelper.g().enable();
                QFSClockInPendantPart.this.W9();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c extends QCirclePicStateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QFSClockInBean f87345d;

        c(QFSClockInBean qFSClockInBean) {
            this.f87345d = qFSClockInBean;
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            super.onStateChange(loadState, option);
            if (loadState == LoadState.STATE_SUCCESS) {
                QFSClockInPendantPart.this.f87331h.setVisibility(0);
                QFSClockInPendantPart.this.f87329e.setVisibility(8);
                QFSClockInPendantPart.this.f87332i.setVisibility(8);
                QFSClockInPendantPart.this.D.setText(this.f87345d.getExpandClockText());
                QFSClockInPendantPart qFSClockInPendantPart = QFSClockInPendantPart.this;
                qFSClockInPendantPart.M = qFSClockInPendantPart.H;
                QFSClockInPendantPart.this.W9();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class e implements VSDispatchObserver.OnVSRspCallBack<FeedCloudWrite$StDoBrowseReportRsp> {
        e() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudWrite$StDoBrowseReportRsp feedCloudWrite$StDoBrowseReportRsp) {
            QLog.d("QFSClockInPendantPart", 1, "reportTaskProcess isSuccess:" + z16 + ", retCode:" + j3);
            QFSClockInPendantPart.this.G = false;
            if (!z16 || j3 != 0) {
                QFSClockInPendantPart.this.N = true;
            } else {
                QFSClockInPendantPart.this.N = false;
                QFSClockInPendantPart.this.P = true;
            }
        }
    }

    private void V9() {
        View view;
        if (this.I != null && (view = this.f87328d) != null && view.getVisibility() != 8) {
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_SIGNIN_PENDANT);
            buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_SIGNIN_PENDANT_STATUS, Integer.valueOf(Z9()));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_SIGNIN_DAYS, Integer.valueOf(this.I.getDayCount()));
            VideoReport.reportEvent("ev_xsj_abnormal_clck", buildElementParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W9() {
        View view;
        if (this.I != null && (view = this.f87328d) != null && view.getVisibility() != 8) {
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_SIGNIN_PENDANT);
            buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_SIGNIN_PENDANT_STATUS, Integer.valueOf(Z9()));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_SIGNIN_DAYS, Integer.valueOf(this.I.getDayCount()));
            VideoReport.reportEvent("ev_xsj_abnormal_imp", buildElementParams);
        }
    }

    private String X9() {
        QFSClockInBean qFSClockInBean = this.I;
        if (qFSClockInBean != null && qFSClockInBean.getStatus() == 4 && !this.I.isLastDay()) {
            return this.I.getCollapseClockText();
        }
        return "";
    }

    private String Y9() {
        QFSClockInBean qFSClockInBean = this.I;
        if (qFSClockInBean == null) {
            return "";
        }
        if (qFSClockInBean.getStatus() == 4) {
            return this.I.getBackPlateNumberUrl();
        }
        if (this.I.getStatus() == 3 && this.I.isLastDay()) {
            return this.I.getBackPlateFinishedUrl();
        }
        if (this.I.getStatus() != 3 || this.I.isLastDay()) {
            return "";
        }
        return this.I.getBackPlateSignedUrl();
    }

    private int Z9() {
        QFSClockInBean qFSClockInBean = this.I;
        if (qFSClockInBean == null) {
            return 0;
        }
        if (qFSClockInBean.getStatus() == 2 || this.I.getStatus() == 1) {
            return 1;
        }
        if (this.I.getStatus() == 4) {
            if (!this.K) {
                return 3;
            }
            return 6;
        }
        if (this.I.getStatus() != 3) {
            return 0;
        }
        if (this.I.isLastDay()) {
            if (!this.K) {
                return 4;
            }
            return 7;
        }
        if (!this.K) {
            return 2;
        }
        return 5;
    }

    private void aa() {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSClockInPendantPart.3
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.biz.qqcircle.immersive.manager.e.a().notifyGroupActivate(QFSClockInPendantPart.this);
            }
        });
    }

    private void ba() {
        if (fb0.a.a("handleClockInWrapperClick") || this.I == null) {
            return;
        }
        com.tencent.biz.qqcircle.launcher.c.g(getContext(), this.I.getJumpUrl());
        ra();
        V9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ca() {
        this.f87331h.setTranslationX(0.0f);
        this.f87329e.setVisibility(8);
        this.f87331h.setVisibility(8);
        this.f87332i.setVisibility(0);
        this.D.setText("");
        this.C.setText(X9());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f87332i, "translationX", -com.tencent.biz.qqcircle.utils.cx.a(36.0f), 0.0f);
        ofFloat.setDuration(160L);
        ofFloat.start();
        this.K = true;
        W9();
    }

    private void da() {
        View view;
        if (!this.K && this.f87328d != null && (view = this.f87331h) != null && view.getVisibility() != 8) {
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(Y9()).setTargetView(this.f87333m).setPredecode(true).setRequestWidth(this.f87333m.getLayoutParams().width).setRequestHeight(this.f87333m.getLayoutParams().height), new d());
        }
    }

    private void ea(@NonNull QFSFeedPositionChangeEvent qFSFeedPositionChangeEvent) {
        QLog.d("QFSClockInPendantPart", 1, "handleFeedPositionChangeEvent ");
        if (this.I != null && qFSFeedPositionChangeEvent.getTabType() == 6) {
            int position = qFSFeedPositionChangeEvent.getPosition();
            this.H = position;
            if (position == this.M + 3) {
                if (this.I.getStatus() == 3 || this.I.getStatus() == 4) {
                    da();
                }
            }
        }
    }

    private void ga(@NonNull QFSHeaderRefreshEvent qFSHeaderRefreshEvent) {
        QLog.d("QFSClockInPendantPart", 1, "handleHeaderRefreshEvent ");
        if (this.I != null && qFSHeaderRefreshEvent.getTabType() == 6 && qFSHeaderRefreshEvent.isCompleted()) {
            this.M = 0;
            this.H = 0;
        }
    }

    private void ha(@NonNull QFSClockInBean qFSClockInBean) {
        this.K = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (!uq3.n.c(currentTimeMillis, uq3.k.a().f("sp_key_clock_in_timestamp", 0L))) {
            RFWVideoDurationHelper.g().reset();
            uq3.k.a().n("sp_key_clock_in_timestamp", currentTimeMillis);
            uq3.k.a().n("sp_key_clock_in_duration", 0L);
            this.L = false;
            this.N = false;
            this.P = false;
            QLog.d("QFSClockInPendantPart", 1, "handleNoClockingStatus reset clock status ");
        }
        QLog.d("QFSClockInPendantPart", 1, "handleNoClockingStatus mHasShowNoClockStatus = " + this.L);
        if (this.L) {
            return;
        }
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(qFSClockInBean.getLockedImgUrl()).setTargetView(this.f87330f).setPredecode(true).setRequestWidth(this.f87330f.getLayoutParams().width).setRequestHeight(this.f87330f.getLayoutParams().height), new b(qFSClockInBean));
    }

    private void ia(@NonNull QFSClockInBean qFSClockInBean, int i3) {
        if (i3 == 3) {
            return;
        }
        this.K = false;
        if (i3 != 2 && i3 != 1) {
            va(qFSClockInBean);
        } else {
            ua(qFSClockInBean);
        }
    }

    private void ja(@NonNull QFSClockInBean qFSClockInBean, int i3) {
        if (i3 == 4) {
            return;
        }
        this.K = false;
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(qFSClockInBean.getUnLockedImgUrl()).setTargetView(this.f87330f).setPredecode(true).setRequestWidth(this.f87330f.getLayoutParams().width).setRequestHeight(this.f87330f.getLayoutParams().height), new c(qFSClockInBean));
    }

    private void la(@NonNull QFSUpdateClockStateEvent qFSUpdateClockStateEvent) {
        int i3;
        QLog.d("QFSClockInPendantPart", 1, "handleUpdateClockStateEvent  dayCount = " + qFSUpdateClockStateEvent.getDayCount() + " isAllComplete = " + qFSUpdateClockStateEvent.isAllComplete());
        QFSClockInBean qFSClockInBean = this.I;
        if (qFSClockInBean == null || qFSClockInBean.getDayCount() != qFSUpdateClockStateEvent.getDayCount()) {
            return;
        }
        QFSClockInBean m215clone = this.I.m215clone();
        if (qFSUpdateClockStateEvent.isAllComplete()) {
            i3 = 5;
        } else {
            i3 = 4;
        }
        m215clone.setStatus(i3);
        QCircleHostGlobalInfo.setClockInfoBean(m215clone);
        com.tencent.biz.qqcircle.immersive.manager.e.a().notifyGroupActivate(this);
    }

    private void ma(@NonNull QFSVideoLoopStartEvent qFSVideoLoopStartEvent) {
        View view;
        View view2;
        if (this.I != null && (view = this.f87328d) != null && view.getVisibility() != 8 && qFSVideoLoopStartEvent.getTabType() == 6) {
            if ((this.I.getStatus() == 2 || this.I.getStatus() == 1) && (view2 = this.f87331h) != null && view2.getVisibility() != 8) {
                final String slideText = this.I.getSlideText();
                int e16 = uq3.k.a().e("sp_key_clock_in_slide_bubble_times", 0);
                QLog.d("QFSClockInPendantPart", 1, "handleVideoLoopStartEvent slideText = " + slideText + " showTimes = " + e16);
                if (!TextUtils.isEmpty(slideText) && e16 < 3) {
                    uq3.k.a().m("sp_key_clock_in_slide_bubble_times", e16 + 1);
                    RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.aw
                        @Override // java.lang.Runnable
                        public final void run() {
                            QFSClockInPendantPart.this.oa(slideText);
                        }
                    });
                }
            }
        }
    }

    private void na() {
        View partRootView;
        if (this.f87328d != null || (partRootView = getPartRootView()) == null) {
            return;
        }
        View inflate = ((ViewStub) partRootView.findViewById(R.id.f349910n)).inflate();
        this.f87328d = inflate;
        this.f87331h = inflate.findViewById(R.id.f349710l);
        this.f87329e = (QFSCircleProgressView) this.f87328d.findViewById(R.id.f350010o);
        this.f87330f = (ImageView) this.f87328d.findViewById(R.id.f349810m);
        this.D = (TextView) this.f87328d.findViewById(R.id.f349610k);
        this.F = this.f87328d.findViewById(R.id.f349210g);
        this.E = (TextView) this.f87328d.findViewById(R.id.f349110f);
        this.f87332i = this.f87328d.findViewById(R.id.f349510j);
        this.f87333m = (ImageView) this.f87328d.findViewById(R.id.f349310h);
        this.C = (TextView) this.f87328d.findViewById(R.id.f349410i);
        this.f87328d.setOnClickListener(this);
        this.f87329e.setUseGradientFgColor(true);
        this.f87329e.setGradientColors(new int[]{getContext().getResources().getColor(R.color.f157863ck1), getContext().getResources().getColor(R.color.f157864ck2), getContext().getResources().getColor(R.color.f157864ck2), getContext().getResources().getColor(R.color.f157863ck1), getContext().getResources().getColor(R.color.ck9), getContext().getResources().getColor(R.color.f157864ck2)});
        this.f87329e.setGradientPotions(new float[]{0.0f, 0.1f, 0.4f, 0.5f, 0.75f, 1.0f});
    }

    private void pa(ASEngineTabStatusEvent aSEngineTabStatusEvent) {
        if (!ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE.equals(aSEngineTabStatusEvent.getBusinessKey())) {
            return;
        }
        QLog.d(getTAG(), 1, "onReceiveEvent onTabSelect change to :" + aSEngineTabStatusEvent.isSelected());
        if (!aSEngineTabStatusEvent.isSelected()) {
            this.Q = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qa() {
        QFSClockInBean clockInfoBean;
        QLog.d("QFSClockInPendantPart", 1, "reportTaskComplete mIsReportTaskRunning :" + this.G);
        if (this.G || (clockInfoBean = QCircleHostGlobalInfo.getClockInfoBean()) == null) {
            return;
        }
        this.G = true;
        VSNetworkHelper.getInstance().sendRequest(getContext(), new QCircleDoBrowseReportRequest(0, null, 1, clockInfoBean.getTransInfo()), new e());
    }

    private void ra() {
        if (this.N) {
            qa();
        }
    }

    private boolean sa() {
        QFSClockInBean qFSClockInBean = this.I;
        if (qFSClockInBean != null && ((qFSClockInBean.getStatus() == 2 || this.I.getStatus() == 1) && !this.P)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ta, reason: merged with bridge method [inline-methods] */
    public void oa(String str) {
        if (TextUtils.isEmpty(str)) {
            this.F.setVisibility(8);
            return;
        }
        this.F.setVisibility(0);
        this.E.setText(str);
        RFWThreadManager.getUIHandler().removeCallbacks(this.S);
        RFWThreadManager.getUIHandler().postDelayed(this.S, uq3.c.Q0());
    }

    private void ua(@NonNull QFSClockInBean qFSClockInBean) {
        String lockedToSignedUrl;
        QLog.d("QFSClockInPendantPart", 1, "startPunchedAnimation  dayCount = " + qFSClockInBean.getDayCount() + " getLockedToFinishedUrl = " + qFSClockInBean.getLockedToFinishedUrl() + "getLockedToSignedUrl = " + qFSClockInBean.getLockedToSignedUrl());
        if (qFSClockInBean.isLastDay()) {
            lockedToSignedUrl = qFSClockInBean.getLockedToFinishedUrl();
        } else {
            lockedToSignedUrl = qFSClockInBean.getLockedToSignedUrl();
        }
        q50.a.a(hashCode(), QCircleAnimationHelper.getDefaultBuilder(lockedToSignedUrl).setCreateTimeOut(TTL.MAX_VALUE).build(), new AnonymousClass6(qFSClockInBean));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void va(QFSClockInBean qFSClockInBean) {
        String signedRefreshingUrl;
        if (qFSClockInBean.isLastDay()) {
            signedRefreshingUrl = qFSClockInBean.getFinishedRefreshUrl();
        } else {
            signedRefreshingUrl = qFSClockInBean.getSignedRefreshingUrl();
        }
        q50.a.a(hashCode(), QCircleAnimationHelper.getDefaultBuilder(signedRefreshingUrl).setCreateTimeOut(TTL.MAX_VALUE).build(), new AnimationDrawableFactory.CreateResultListener() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSClockInPendantPart.7
            @Override // com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.CreateResultListener
            public void onCreateResult(boolean z16, final QQAnimationDrawable qQAnimationDrawable) {
                if (!z16) {
                    return;
                }
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSClockInPendantPart.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (QFSClockInPendantPart.this.f87330f == null) {
                            return;
                        }
                        QFSClockInPendantPart.this.f87331h.setVisibility(0);
                        QFSClockInPendantPart.this.D.setText("");
                        QFSClockInPendantPart.this.f87329e.setVisibility(8);
                        QFSClockInPendantPart.this.f87332i.setVisibility(8);
                        qQAnimationDrawable.setOneShot(false);
                        qQAnimationDrawable.setDuration(1000L);
                        QFSClockInPendantPart.this.f87330f.setImageDrawable(qQAnimationDrawable);
                        qQAnimationDrawable.start();
                        QFSClockInPendantPart.this.W9();
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wa() {
        int status;
        this.Q = true;
        QFSClockInBean clockInfoBean = QCircleHostGlobalInfo.getClockInfoBean();
        if (clockInfoBean == null) {
            QLog.d("QFSClockInPendantPart", 1, "[updateClockInPendantView] clockInfoBean == null.");
            return;
        }
        if (clockInfoBean.isLastDay() && clockInfoBean.getStatus() == 4) {
            clockInfoBean.setStatus(3);
        }
        QFSClockInBean qFSClockInBean = this.I;
        if (qFSClockInBean == null) {
            status = 0;
        } else {
            status = qFSClockInBean.getStatus();
        }
        this.I = clockInfoBean;
        if (clockInfoBean.getStatus() != 0 && clockInfoBean.getStatus() != 5) {
            na();
            View view = this.f87328d;
            if (view == null) {
                com.tencent.biz.qqcircle.immersive.manager.e.a().inactivateElement(this);
            } else {
                view.setVisibility(0);
            }
            this.K = false;
            int status2 = clockInfoBean.getStatus();
            if (status2 != 1 && status2 != 2) {
                if (status2 != 3) {
                    if (status2 == 4) {
                        ja(clockInfoBean, status);
                        return;
                    }
                    return;
                }
                ia(clockInfoBean, status);
                return;
            }
            ha(clockInfoBean);
            return;
        }
        com.tencent.biz.qqcircle.immersive.manager.e.a().inactivateElement(this);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public String getContextHashCode() {
        if (getContext() == null) {
            return "";
        }
        return String.valueOf(getContext().hashCode());
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public /* synthetic */ String getElementExtraKey() {
        return com.tencent.biz.richframework.order.a.a(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSClockInPendantChangeEvent.class);
        arrayList.add(QFSFeedPositionChangeEvent.class);
        arrayList.add(QFSUpdateClockStateEvent.class);
        arrayList.add(QFSHeaderRefreshEvent.class);
        arrayList.add(QFSVideoLoopStartEvent.class);
        arrayList.add(ASEngineTabStatusEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public String getGroup() {
        return "folder_pendant";
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public /* synthetic */ String getGroupExtraKey() {
        return com.tencent.biz.richframework.order.a.b(this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSClockInPendantPart";
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return 103;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public /* synthetic */ boolean isDataReady() {
        return com.tencent.biz.richframework.order.a.c(this);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        if (f40.b.a(this)) {
            QLog.e("QFSClockInPendantPart", 1, "isElementCanActivate elementShowHistory containChangeTabElement");
            return false;
        }
        QFSClockInBean clockInfoBean = QCircleHostGlobalInfo.getClockInfoBean();
        if (clockInfoBean == null) {
            return false;
        }
        if (clockInfoBean.isLastDay() && clockInfoBean.getStatus() == 4) {
            clockInfoBean.setStatus(3);
        }
        if (clockInfoBean.getStatus() == 0 || clockInfoBean.getStatus() == 5) {
            return false;
        }
        if (this.Q || clockInfoBean.getStatus() != 4) {
            return true;
        }
        QLog.d("QFSClockInPendantPart", 1, "CLOCK_STATUS_UNLOCKED status giveup display");
        return false;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        return !((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f350110p) {
            ba();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        QLog.d("QFSClockInPendantPart", 1, "showElement");
        if (Looper.getMainLooper() == Looper.myLooper()) {
            wa();
        } else {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.av
                @Override // java.lang.Runnable
                public final void run() {
                    QFSClockInPendantPart.this.wa();
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        QLog.d("QFSClockInPendantPart", 1, "hideElement");
        View view = this.f87328d;
        if (view == null) {
            return;
        }
        view.setVisibility(8);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        com.tencent.biz.qqcircle.immersive.manager.e.a().addElement(this);
        com.tencent.biz.qqcircle.immersive.manager.e.a().notifyGroupActivate(this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        RFWVideoDurationHelper.g().unRegisterVideoDurationUpdateListener(this.R);
        com.tencent.biz.qqcircle.immersive.manager.e.a().removeElement(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        RFWVideoDurationHelper.g().disable();
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        ra();
        W9();
        if (sa()) {
            RFWVideoDurationHelper.g().enable();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSClockInPendantChangeEvent) {
            aa();
            return;
        }
        if (simpleBaseEvent instanceof QFSFeedPositionChangeEvent) {
            ea((QFSFeedPositionChangeEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSUpdateClockStateEvent) {
            la((QFSUpdateClockStateEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSHeaderRefreshEvent) {
            ga((QFSHeaderRefreshEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSVideoLoopStartEvent) {
            ma((QFSVideoLoopStartEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof ASEngineTabStatusEvent) {
            pa((ASEngineTabStatusEvent) simpleBaseEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d extends QCirclePicStateListener {
        d() {
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            super.onStateChange(loadState, option);
            if (loadState == LoadState.STATE_SUCCESS) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(QFSClockInPendantPart.this.f87331h, "translationX", 0.0f, com.tencent.biz.qqcircle.utils.cx.a(7.0f));
                ofFloat.setDuration(120L);
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(QFSClockInPendantPart.this.f87331h, "translationX", com.tencent.biz.qqcircle.utils.cx.a(7.0f), -com.tencent.biz.qqcircle.utils.cx.a(88.0f));
                ofFloat2.setDuration(200L);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.addListener(new a());
                animatorSet.play(ofFloat).before(ofFloat2);
                animatorSet.start();
            }
        }

        /* loaded from: classes4.dex */
        class a implements Animator.AnimatorListener {
            a() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                QFSClockInPendantPart.this.ca();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }
    }
}
