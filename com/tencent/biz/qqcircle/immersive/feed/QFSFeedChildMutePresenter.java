package com.tencent.biz.qqcircle.immersive.feed;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSFloatVolumeSwitchEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSMuteSwitchChangeEvent;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.qcircle.api.event.QCircleVolumeMuteChangeEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes4.dex */
public class QFSFeedChildMutePresenter extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements View.OnClickListener {
    private static final int Q = DisplayUtil.dip2px(RFWApplication.getApplication(), 52.0f);
    private static final int R = DisplayUtil.dip2px(RFWApplication.getApplication(), 34.0f);
    private static final int S = DisplayUtil.dip2px(RFWApplication.getApplication(), 85.0f);
    private static final boolean T = com.tencent.biz.qqcircle.f.e();
    private static boolean U;
    private FrameLayout I;
    private FrameLayout J;
    private ImageView K;
    private View L;
    private TextView M;
    private Runnable N;
    private final AnimatorSet P = new AnimatorSet();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (QFSFeedChildMutePresenter.this.J == null) {
                QLog.e("QFSFeedChildMutePresenter", 1, "[getCircle2RectAnimSet] -> [onAnimationUpdate] mMuteBg == null, return");
                return;
            }
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) QFSFeedChildMutePresenter.this.J.getLayoutParams();
            layoutParams.width = intValue;
            QFSFeedChildMutePresenter.this.J.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (QFSFeedChildMutePresenter.this.J != null && QFSFeedChildMutePresenter.this.M != null) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) QFSFeedChildMutePresenter.this.J.getLayoutParams();
                layoutParams.width = intValue;
                QFSFeedChildMutePresenter.this.J.setLayoutParams(layoutParams);
                return;
            }
            QLog.e("QFSFeedChildMutePresenter", 1, "[getFolderAnimSet] -> [onAnimationUpdate] mMuteBg == null, return");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class e implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QFSFeedChildMutePresenter> f85132a;

        e(QFSFeedChildMutePresenter qFSFeedChildMutePresenter) {
            this.f85132a = new WeakReference<>(qFSFeedChildMutePresenter);
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            if (this.f85132a.get() == null) {
                return null;
            }
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            int i3 = 1;
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PRIVACY_SETTING_BUTTON_STATE, Integer.valueOf(!this.f85132a.get().y1() ? 1 : 0));
            if (this.f85132a.get().M != null) {
                if (this.f85132a.get().M.getVisibility() != 0) {
                    i3 = 0;
                }
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_TEXT, Integer.valueOf(i3));
            }
            return buildElementParams;
        }
    }

    private void A1() {
        VideoReport.setElementId(this.L, QCircleDaTongConstant.ElementId.EM_XSJ_VOLUME_ON_OF_BUTTON);
        VideoReport.setEventDynamicParams(this.L, new e(this));
        VideoReport.setElementExposePolicy(this.L, ExposurePolicy.REPORT_FIRST);
        VideoReport.setElementClickPolicy(this.L, ClickPolicy.REPORT_NONE);
    }

    private void B1(boolean z16) {
        FrameLayout frameLayout;
        int i3;
        if (z16) {
            q1();
        }
        if (this.K != null && (frameLayout = this.I) != null && this.M != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            frameLayout.setVisibility(i3);
            this.M.setVisibility(8);
            ImageView imageView = this.K;
            tb0.a aVar = tb0.a.f435779d;
            imageView.setSelected(aVar.b());
            if (((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).isExperiment("xsp_xsj_fabuqi_feedyinyuefengmianchangzhu") && !aVar.b()) {
                this.L.setVisibility(8);
            } else {
                this.L.setVisibility(0);
            }
            A1();
            return;
        }
        QLog.e("QFSFeedChildMutePresenter", 1, "[resetInitViewState] mIvMute == null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C1(View view, int i3) {
        if (view == null) {
            QLog.e("QFSFeedChildMutePresenter", 1, "[updateViewVisible] view is null");
        } else {
            view.setVisibility(i3);
        }
    }

    private void p1(Runnable runnable) {
        if (runnable != null) {
            QLog.d("QFSFeedChildMutePresenter", 1, "[cancelRunnable] remove mAnimRunnable = " + runnable);
            x0().removeCallbacks(runnable);
        }
    }

    private void q1() {
        View view = this.C;
        if (view == null) {
            QLog.e("QFSFeedChildMutePresenter", 1, "[checkViewInit] mRootView == null, return");
            return;
        }
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.f43371ma);
        if (viewStub == null) {
            QLog.e("QFSFeedChildMutePresenter", 1, "[checkViewInit] viewStub == null, return");
            return;
        }
        View inflate = viewStub.inflate();
        this.L = inflate;
        if (inflate == null) {
            QLog.d("QFSFeedChildMutePresenter", 1, "[checkViewInit] viewStub.inflate() == null, return");
            return;
        }
        this.K = (ImageView) inflate.findViewById(R.id.f165951y63);
        this.M = (TextView) this.L.findViewById(R.id.f1064668s);
        this.J = (FrameLayout) this.L.findViewById(R.id.v8c);
        this.I = (FrameLayout) this.L.findViewById(R.id.v8d);
        this.J.setOnClickListener(this);
        this.N = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildMutePresenter.1
            @Override // java.lang.Runnable
            public void run() {
                QFSFeedChildMutePresenter.U = true;
                if (QFSFeedChildMutePresenter.this.M == null) {
                    QLog.e("QFSFeedChildMutePresenter", 1, "[mCircle2RectAnimRunnable] mTvCancelMute is null");
                    return;
                }
                QLog.d("QFSFeedChildMutePresenter", 1, "[mCircle2RectAnimRunnable] start anim, mHasDoAnim = true");
                QFSFeedChildMutePresenter.this.P.playSequentially(QFSFeedChildMutePresenter.this.t1(), QFSFeedChildMutePresenter.this.u1());
                QFSFeedChildMutePresenter.this.P.start();
            }
        };
    }

    private void r1() {
        int i3;
        VideoReport.setElementId(this.L, QCircleDaTongConstant.ElementId.EM_XSJ_VOLUME_ON_OF_BUTTON);
        VideoReport.setElementClickPolicy(this.L, ClickPolicy.REPORT_NONE);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        TextView textView = this.M;
        if (textView != null) {
            if (textView.getVisibility() == 0) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_TEXT, Integer.valueOf(i3));
        }
        VideoReport.reportEvent("dt_clck", this.L, buildElementParams);
    }

    private void s1() {
        if (this.P.isRunning()) {
            QLog.d("QFSFeedChildMutePresenter", 1, "[endAnimSet] mTotalAnim.isRunning()");
            this.P.end();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AnimatorSet t1() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.M, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.M, "translationX", Q, 0.0f);
        ofFloat.setDuration(200L);
        ofFloat2.setDuration(240L);
        ValueAnimator ofInt = ValueAnimator.ofInt(R, S);
        ofInt.addUpdateListener(new a());
        ofInt.setDuration(240L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2, ofInt);
        animatorSet.addListener(new b());
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AnimatorSet u1() {
        TextView textView = this.M;
        if (textView == null) {
            QLog.e(getTAG(), 1, "[getFolderAnimSet] mTvCancelMute is null");
            return new AnimatorSet();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.M, "translationX", 0.0f, Q);
        ofFloat.setDuration(200L);
        ofFloat2.setDuration(240L);
        ValueAnimator ofInt = ValueAnimator.ofInt(S, R);
        ofInt.addUpdateListener(new c());
        ofInt.setDuration(240L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setStartDelay(5000L);
        animatorSet.playTogether(ofFloat, ofFloat2, ofInt);
        animatorSet.addListener(new d());
        return animatorSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void v1(final QFSFloatVolumeSwitchEvent qFSFloatVolumeSwitchEvent) {
        if (com.tencent.biz.qqcircle.f.e() && this.f85017h != 0 && TextUtils.equals(qFSFloatVolumeSwitchEvent.getFeedId(), ((FeedCloudMeta$StFeed) this.f85017h).f398449id.get())) {
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.an
                @Override // java.lang.Runnable
                public final void run() {
                    QFSFeedChildMutePresenter.this.z1(qFSFloatVolumeSwitchEvent);
                }
            });
        }
    }

    private void w1() {
        r1();
        s1();
        boolean z16 = !this.K.isSelected();
        this.K.setSelected(z16);
        if (((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).isExperiment("xsp_xsj_fabuqi_feedyinyuefengmianchangzhu") && !z16) {
            this.L.setVisibility(8);
        } else {
            this.L.setVisibility(0);
        }
        tb0.a.f435779d.c(z16);
    }

    private void x1(final QCircleVolumeMuteChangeEvent qCircleVolumeMuteChangeEvent) {
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildMutePresenter.6
            @Override // java.lang.Runnable
            public void run() {
                if (QFSFeedChildMutePresenter.this.K == null) {
                    return;
                }
                QFSFeedChildMutePresenter.this.K.setSelected(qCircleVolumeMuteChangeEvent.isMute());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z1(QFSFloatVolumeSwitchEvent qFSFloatVolumeSwitchEvent) {
        ImageView imageView = this.K;
        if (imageView == null) {
            return;
        }
        imageView.setSelected(qFSFloatVolumeSwitchEvent.isMute());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public boolean H0() {
        if (!com.tencent.biz.qqcircle.f.f()) {
            QLog.d("QFSFeedChildMutePresenter", 1, "not enableDefaultMuteFromWNS, return");
            return false;
        }
        QLog.d("QFSFeedChildMutePresenter", 1, "muteEnabled true");
        return true;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void K0() {
        super.K0();
        B1(com.tencent.biz.qqcircle.f.e());
        if (!U && T) {
            p1(this.N);
            x0().postDelayed(this.N, 600L);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void M0() {
        super.M0();
        s1();
        p1(this.N);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QCircleVolumeMuteChangeEvent.class);
        eventClass.add(QFSMuteSwitchChangeEvent.class);
        eventClass.add(QFSFloatVolumeSwitchEvent.class);
        return eventClass;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.v8c) {
            w1();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCircleVolumeMuteChangeEvent) {
            x1((QCircleVolumeMuteChangeEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSMuteSwitchChangeEvent) {
            B1(((QFSMuteSwitchChangeEvent) simpleBaseEvent).isSwitchOpen());
        } else if (simpleBaseEvent instanceof QFSFloatVolumeSwitchEvent) {
            v1((QFSFloatVolumeSwitchEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildMutePresenter";
    }

    public boolean y1() {
        ImageView imageView = this.K;
        if (imageView != null && imageView.isSelected()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            String dtPageId;
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_VOLUME_ON_OF_BUTTON);
            if (QFSFeedChildMutePresenter.this.getReportBean() == null) {
                dtPageId = "";
            } else {
                dtPageId = QFSFeedChildMutePresenter.this.getReportBean().getDtPageId();
            }
            buildElementParams.put("xsj_custom_pgid", dtPageId);
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_TEXT, 1);
            VideoReport.reportEvent("ev_xsj_abnormal_imp", buildElementParams);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            QFSFeedChildMutePresenter qFSFeedChildMutePresenter = QFSFeedChildMutePresenter.this;
            qFSFeedChildMutePresenter.C1(qFSFeedChildMutePresenter.M, 0);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d implements Animator.AnimatorListener {
        d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (QFSFeedChildMutePresenter.this.M == null) {
                QLog.e("QFSFeedChildMutePresenter", 1, "[getFolderAnimSet] -> [onAnimationEnd] mTvCancelMute == null, return");
                return;
            }
            QFSFeedChildMutePresenter.this.M.setVisibility(8);
            QFSFeedChildMutePresenter.this.M.setAlpha(1.0f);
            QFSFeedChildMutePresenter.this.M.setTranslationX(0.0f);
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
