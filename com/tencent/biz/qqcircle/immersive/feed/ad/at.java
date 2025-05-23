package com.tencent.biz.qqcircle.immersive.feed.ad;

import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.manager.QFSTopViewManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.shake.GdtShakeIconView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.HashMap;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes4.dex */
public class at extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {
    private View I;
    private View J;
    private GdtShakeIconView K;
    private TextView L;
    private View M;
    private boolean N;
    private GdtAd R;
    private int S;
    private int T;
    private boolean P = false;
    private boolean Q = false;
    private boolean U = false;
    private final Runnable V = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.aq
        @Override // java.lang.Runnable
        public final void run() {
            at.this.w1();
        }
    };
    private final Runnable W = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.ar
        @Override // java.lang.Runnable
        public final void run() {
            at.this.x1();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            com.tencent.biz.qqcircle.immersive.utils.j.f90213a.I(at.this.R, view, ((QFSBaseFeedChildPresenter) at.this).f85018i, at.this.r(), Integer.MIN_VALUE);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f85465d;

        c(int i3) {
            this.f85465d = i3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            at.this.L.setTextSize(1, 16.0f - (((Float) valueAnimator.getAnimatedValue()).floatValue() * this.f85465d));
        }
    }

    private void q1(View view, String str) {
        e30.b bVar = this.E;
        if (bVar != null && bVar.g() != null && view != null && !TextUtils.isEmpty(str)) {
            VideoReport.setElementId(view, str);
            HashMap hashMap = new HashMap();
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(this.f85018i + 1));
            hashMap.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
            VideoReport.setElementReuseIdentifier(view, str + this.E.g().f398449id.get());
            VideoReport.setElementParams(view, hashMap);
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        }
    }

    private void r1(QFSFeedAdFeedbackEvent qFSFeedAdFeedbackEvent) {
        String str;
        boolean z16;
        if (qFSFeedAdFeedbackEvent == null) {
            QLog.e("QFSFeedChildAdBottomEntryPresenter", 2, "[handleFeedbackEvent] error, event is null");
            return;
        }
        QLog.i("QFSFeedChildAdBottomEntryPresenter", 2, String.format("[handleFeedbackEvent] state:%d", Integer.valueOf(qFSFeedAdFeedbackEvent.getStatus())));
        String str2 = null;
        if (qFSFeedAdFeedbackEvent.getGdtAd() != null) {
            str = qFSFeedAdFeedbackEvent.getGdtAd().getTraceId();
        } else {
            str = null;
        }
        GdtAd gdtAd = this.R;
        if (gdtAd != null) {
            str2 = gdtAd.getTraceId();
        }
        if (!TextUtils.isEmpty(str) && TextUtils.equals(str, str2)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            QLog.d("QFSFeedChildAdBottomEntryPresenter", 1, "[handleFeedbackEvent] not the same ad");
            return;
        }
        if (qFSFeedAdFeedbackEvent.getStatus() == QFSFeedAdFeedbackEvent.STATUS_START) {
            this.U = true;
            stop();
        } else {
            if (qFSFeedAdFeedbackEvent.getStatus() == QFSFeedAdFeedbackEvent.STATUS_END) {
                this.U = false;
                if (qFSFeedAdFeedbackEvent.getAction() == 0) {
                    start();
                    return;
                }
                return;
            }
            QLog.e("QFSFeedChildAdBottomEntryPresenter", 2, "[handleFeedbackEvent] error, unknown state");
        }
    }

    private void s1(com.tencent.biz.qqcircle.immersive.feed.event.q qVar) {
        GdtShakeIconView gdtShakeIconView;
        if (qVar == null) {
            QLog.e("QFSFeedChildAdBottomEntryPresenter", 2, "[handleSplashEndBroadcastMessage] error, event is null");
            return;
        }
        if (!this.N) {
            QLog.e("QFSFeedChildAdBottomEntryPresenter", 2, "[handleSplashEndBroadcastMessage] error, not topView ad");
            return;
        }
        QLog.i("QFSFeedChildAdBottomEntryPresenter", 2, String.format("[handleSplashEndBroadcastMessage] shouldShowButtonScaleAnimation:%b", Boolean.valueOf(qVar.d())));
        if (this.P && (gdtShakeIconView = this.K) != null) {
            gdtShakeIconView.setVisibility(0);
            this.K.setImageResource();
        }
        if (!qVar.d()) {
            this.Q = true;
        } else if (x0() != null) {
            this.S = qVar.b();
            this.T = qVar.a();
            x0().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.as
                @Override // java.lang.Runnable
                public final void run() {
                    at.this.v1();
                }
            });
        }
    }

    private void start() {
        if (this.U) {
            QLog.i("QFSFeedChildAdBottomEntryPresenter", 1, "[start] error, feedback dialog is showing");
        } else if (!J0()) {
            QLog.i("QFSFeedChildAdBottomEntryPresenter", 1, "[start] error, !isVideoOnScreen()");
        } else {
            QLog.i("QFSFeedChildAdBottomEntryPresenter", 2, "[start]");
            w1();
        }
    }

    private void stop() {
        QLog.i("QFSFeedChildAdBottomEntryPresenter", 2, "[stop]");
        z1();
    }

    private void t1() {
        if (this.I != null) {
            return;
        }
        this.I = ((ViewStub) this.C.findViewById(R.id.f41491h8)).inflate();
        this.J = this.C.findViewById(R.id.f39051am);
        this.K = (GdtShakeIconView) this.C.findViewById(R.id.f39061an);
        this.L = (TextView) this.C.findViewById(R.id.f39071ao);
        this.M = this.C.findViewById(R.id.f39031ak);
        this.I.setOnClickListener(new a());
        q1(this.I, QCircleDaTongConstant.ElementId.EM_XSJ_COMERCIAL_BAR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v1() {
        if (this.I.getParent() != null && this.I.getParent().getParent() != null) {
            ViewGroup viewGroup = (ViewGroup) this.I.getParent();
            boolean clipChildren = ((ViewGroup) viewGroup.getParent()).getClipChildren();
            boolean clipToPadding = viewGroup.getClipToPadding();
            boolean clipChildren2 = viewGroup.getClipChildren();
            boolean clipToPadding2 = ((ViewGroup) this.I).getClipToPadding();
            ((ViewGroup) viewGroup.getParent()).setClipChildren(false);
            viewGroup.setClipToPadding(false);
            viewGroup.setClipChildren(false);
            ((ViewGroup) this.I).setClipToPadding(false);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(330L);
            ofFloat.addUpdateListener(new c(2));
            ofFloat.start();
            if (this.P) {
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                scaleAnimation.setDuration(330L);
                this.K.startAnimation(scaleAnimation);
            }
            int width = this.I.getWidth();
            int height = this.I.getHeight();
            TranslateAnimation translateAnimation = new TranslateAnimation((this.S - width) / 2.0f, 0.0f, ((this.T - height) / 2.0f) * (-1.0f), 0.0f);
            translateAnimation.setDuration(330L);
            this.L.startAnimation(translateAnimation);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(this.S / width, 1.0f, this.T / height, 1.0f, 1, 0.0f, 1, 1.0f);
            scaleAnimation2.setDuration(330L);
            this.M.startAnimation(scaleAnimation2);
            scaleAnimation2.setAnimationListener(new d(clipChildren, clipToPadding, clipChildren2, clipToPadding2));
            VideoReport.traversePage(this.I);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w1() {
        GdtShakeIconView gdtShakeIconView;
        if (!this.Q) {
            return;
        }
        z1();
        if (this.P && (gdtShakeIconView = this.K) != null) {
            gdtShakeIconView.startAnimation(1, 260);
        }
        if (x0() != null) {
            x0().postDelayed(this.W, 334L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x1() {
        if (this.J != null && this.I != null && this.Q) {
            TranslateAnimation translateAnimation = new TranslateAnimation(-this.J.getWidth(), this.I.getWidth(), 0.0f, 0.0f);
            translateAnimation.setDuration(600L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setRepeatCount(1);
            translateAnimation.setAnimationListener(new b());
            this.J.startAnimation(translateAnimation);
            this.J.setVisibility(0);
        }
    }

    private void y1() {
        View view = this.I;
        if (view != null && this.J != null) {
            if (this.N) {
                view.setVisibility(0);
                this.J.setVisibility(4);
                GdtShakeIconView gdtShakeIconView = this.K;
                if (gdtShakeIconView != null) {
                    gdtShakeIconView.setVisibility(8);
                    this.K.resetImageResource();
                }
            } else {
                view.setVisibility(8);
            }
            this.Q = false;
            return;
        }
        QLog.e("QFSFeedChildAdBottomEntryPresenter", 2, "[reset] error");
    }

    private void z1() {
        GdtShakeIconView gdtShakeIconView;
        if (x0() != null) {
            x0().removeCallbacks(this.W);
            x0().removeCallbacks(this.V);
        }
        if (this.P && (gdtShakeIconView = this.K) != null) {
            gdtShakeIconView.stop();
        }
        View view = this.J;
        if (view != null) {
            view.clearAnimation();
            this.J.setVisibility(4);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        super.C0(hVar);
        if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.q) {
            s1((com.tencent.biz.qqcircle.immersive.feed.event.q) com.tencent.biz.qqcircle.immersive.feed.event.q.class.cast(hVar));
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        if (eventClass == null) {
            eventClass = new ArrayList<>();
        }
        eventClass.add(QFSFeedAdFeedbackEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onDestroy() {
        QLog.i("QFSFeedChildAdBottomEntryPresenter", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        stop();
        super.onDestroy();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        QLog.i("QFSFeedChildAdBottomEntryPresenter", 2, "onFeedSelected");
        super.onFeedSelected(rFWFeedSelectInfo);
        start();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        QLog.i("QFSFeedChildAdBottomEntryPresenter", 2, "onFeedUnSelected");
        stop();
        super.onFeedUnSelected(rFWFeedSelectInfo);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onPaused(RFWFeedSelectInfo rFWFeedSelectInfo) {
        QLog.i("QFSFeedChildAdBottomEntryPresenter", 2, "onPaused");
        stop();
        super.onPaused(rFWFeedSelectInfo);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QFSFeedAdFeedbackEvent) {
            r1((QFSFeedAdFeedbackEvent) QFSFeedAdFeedbackEvent.class.cast(simpleBaseEvent));
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(RFWFeedSelectInfo rFWFeedSelectInfo) {
        QLog.i("QFSFeedChildAdBottomEntryPresenter", 2, "onResumed");
        super.onResumed(rFWFeedSelectInfo);
        start();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerItemViewScrollerStatus
    public void onViewHolderAttachedToWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        QLog.i("QFSFeedChildAdBottomEntryPresenter", 2, "onViewHolderAttachedToWindow");
        super.onViewHolderAttachedToWindow(viewHolder);
        start();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerItemViewScrollerStatus
    public void onViewHolderDetachedFromWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        QLog.i("QFSFeedChildAdBottomEntryPresenter", 2, "onViewHolderDetachedFromWindow");
        stop();
        super.onViewHolderDetachedFromWindow(viewHolder);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [feedcloud.FeedCloudMeta$StFeed, T] */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: u1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        QLog.i("QFSFeedChildAdBottomEntryPresenter", 2, "onBindData");
        this.f85017h = u.c(this.E);
        qq_ad_get.QQAdGetRsp.AdInfo e16 = u.e(this.E);
        this.R = new GdtAd(e16);
        this.N = QFSTopViewManager.h(e16);
        this.P = QFSTopViewManager.i(e16);
        this.Q = false;
        this.U = false;
        if (this.N) {
            t1();
            this.L.setText(QFSTopViewManager.e().d(e16));
        }
        y1();
        super.L0(feedCloudMeta$StFeed, i3);
        U0(ae.b(feedCloudMeta$StFeed, i3));
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildAdBottomEntryPresenter";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements Animation.AnimationListener {
        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            at.this.J.setVisibility(4);
            if (at.this.x0() != null) {
                at.this.x0().postDelayed(at.this.V, 5000L);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            animation.setStartOffset(330L);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class d implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f85467d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f85468e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f85469f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f85470h;

        d(boolean z16, boolean z17, boolean z18, boolean z19) {
            this.f85467d = z16;
            this.f85468e = z17;
            this.f85469f = z18;
            this.f85470h = z19;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (at.this.I.getParent() != null && at.this.I.getParent().getParent() != null) {
                ViewGroup viewGroup = (ViewGroup) at.this.I.getParent();
                ((ViewGroup) viewGroup.getParent()).setClipChildren(this.f85467d);
                viewGroup.setClipToPadding(this.f85468e);
                viewGroup.setClipChildren(this.f85469f);
                ((ViewGroup) at.this.I).setClipToPadding(this.f85470h);
                at.this.Q = true;
                if (at.this.x0() != null) {
                    at.this.x0().postDelayed(at.this.V, 2000L);
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            at.this.I.setAlpha(1.0f);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }
}
