package com.tencent.biz.qqcircle.immersive.part;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSQzoneFirstVideoAutoSlideEvent;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.util.NumberUtil;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StDebugInfo;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StGuideInfo;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.util.WeakReference;

/* loaded from: classes4.dex */
public abstract class QFSMiddlePageNextVideoGuideBasePart extends u implements View.OnClickListener {
    protected QCircleAsyncTextView C;
    protected FeedCloudMeta$StFeed D;
    protected FeedCloudMeta$StFeed E;
    private int F;
    private int G;
    protected String H;
    protected long I;
    protected boolean J;
    private boolean K;
    private boolean L;
    private Runnable M;

    /* renamed from: d, reason: collision with root package name */
    private final Class<? extends com.tencent.biz.qqcircle.viewmodels.a> f87468d;

    /* renamed from: e, reason: collision with root package name */
    protected com.tencent.biz.qqcircle.immersive.layer.base.e f87469e;

    /* renamed from: f, reason: collision with root package name */
    private View f87470f;

    /* renamed from: h, reason: collision with root package name */
    protected FrameLayout f87471h;

    /* renamed from: i, reason: collision with root package name */
    protected View f87472i;

    /* renamed from: m, reason: collision with root package name */
    protected ImageView f87473m;

    /* loaded from: classes4.dex */
    private static class PlayGuideAnimRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<QFSMiddlePageNextVideoGuideBasePart> f87474d;

        @Override // java.lang.Runnable
        public void run() {
            QFSMiddlePageNextVideoGuideBasePart qFSMiddlePageNextVideoGuideBasePart = this.f87474d.get();
            if (qFSMiddlePageNextVideoGuideBasePart == null) {
                return;
            }
            QLog.d(qFSMiddlePageNextVideoGuideBasePart.getTAG(), 1, "[bindDataAndShow] mIsShowing =" + qFSMiddlePageNextVideoGuideBasePart.L);
            if (!qFSMiddlePageNextVideoGuideBasePart.L) {
                qFSMiddlePageNextVideoGuideBasePart.K = false;
                qFSMiddlePageNextVideoGuideBasePart.R9();
            }
        }
    }

    private boolean H9() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        if (this.D == null || (feedCloudMeta$StFeed = this.E) == null) {
            return false;
        }
        Iterator<FeedCloudMeta$StGuideInfo> it = feedCloudMeta$StFeed.guideInfos.get().iterator();
        while (it.hasNext()) {
            if (it.next().guide_type.get() == 6) {
                this.D.opMask2.add(58);
                QLog.d("QFSMiddlePageNextVideoGuideBasePart", 1, "[canShowGuide] true.");
                return true;
            }
        }
        return false;
    }

    private void I9() {
        QLog.d(getTAG(), 1, "[dismissGuideDirectly] mIsShowing =" + this.L);
        if (!this.L) {
            return;
        }
        View view = this.f87472i;
        if (view != null) {
            view.setAlpha(0.0f);
            this.f87472i.setVisibility(8);
        }
        FrameLayout frameLayout = this.f87471h;
        if (frameLayout != null) {
            frameLayout.setAlpha(1.0f);
            this.f87471h.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J9(String str) {
        if (this.f87472i == null) {
            return;
        }
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.D;
        if (feedCloudMeta$StFeed != null) {
            buildElementParams.put("xsj_feed_id", feedCloudMeta$StFeed.f398449id.get());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, this.D.poster.f398463id.get());
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = this.E;
        if (feedCloudMeta$StFeed2 != null) {
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TARGET_FEED_ID, feedCloudMeta$StFeed2.f398449id.get());
            buildElementParams.put("xsj_target_qq", this.E.poster.f398463id.get());
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_RECOM_REASON, this.H);
        VideoReport.setElementId(this.f87472i, QCircleDaTongConstant.ElementId.EM_XSJ_SOON_PLAY_GUIDE_BAR);
        VideoReport.setElementExposePolicy(this.f87472i, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(this.f87472i, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent(str, this.f87472i, buildElementParams);
    }

    private void L9() {
        if (this.D != null) {
            QLog.d(getTAG(), 1, "[onClick]");
            SimpleEventBus.getInstance().dispatchEvent(new QFSQzoneFirstVideoAutoSlideEvent(this.D.f398449id.get()));
        }
        J9("dt_clck");
    }

    private boolean P9(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$StDebugInfo feedCloudMeta$StDebugInfo;
        if (feedCloudMeta$StFeed != null && (feedCloudMeta$StDebugInfo = feedCloudMeta$StFeed.debugInfo) != null) {
            return TextUtils.equals(fb0.b.c(feedCloudMeta$StDebugInfo.debugMap, "is_client_back_up_feed", ""), "1");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q9(UIStateData uIStateData) {
        if (uIStateData != null && !uIStateData.isFakeData() && uIStateData.getData() != null && ((List) uIStateData.getData()).size() > 0 && !this.J) {
            e30.b bVar = (e30.b) RFSafeListUtils.get((List) uIStateData.getData(), this.F);
            e30.b bVar2 = (e30.b) RFSafeListUtils.get((List) uIStateData.getData(), this.G);
            if (bVar != null && bVar.g() != null && bVar2 != null && bVar2.g() != null) {
                this.D = bVar.g();
                this.E = bVar2.g();
                if (!H9()) {
                    return;
                }
                QLog.d(getTAG(), 1, "[initViewModel] init and show. size: " + ((List) uIStateData.getData()).size());
                if (P9(this.E)) {
                    QLog.d(getTAG(), 1, "isBackUpFeed: true");
                    return;
                }
                O9();
                F9();
                this.J = true;
                return;
            }
            QLog.e(getTAG(), 1, "[initViewModel] feed is null, return.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R9() {
        if (this.f87471h == null) {
            return;
        }
        View view = this.f87472i;
        if (view != null) {
            view.setVisibility(0);
        }
        FrameLayout frameLayout = this.f87471h;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(frameLayout, com.tencent.luggage.wxa.c8.c.f123400v, frameLayout.getAlpha(), 0.0f);
        ofFloat.setDuration(160L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f87472i, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ofFloat2.setDuration(160L);
        ofFloat2.setStartDelay(160L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.start();
        animatorSet.addListener(new a());
    }

    private void initViewModel() {
        com.tencent.biz.qqcircle.immersive.layer.base.e eVar = (com.tencent.biz.qqcircle.immersive.layer.base.e) getViewModel(this.f87468d);
        this.f87469e = eVar;
        eVar.j().observe(getHostFragment(), new Observer() { // from class: com.tencent.biz.qqcircle.immersive.part.dh
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSMiddlePageNextVideoGuideBasePart.this.Q9((UIStateData) obj);
            }
        });
    }

    protected abstract void E9();

    protected void F9() {
        if (!this.K) {
            QLog.e(getTAG(), 1, "[bindDataAndShow] need not show guide");
            return;
        }
        G9();
        E9();
        getMainHandler().postDelayed(this.M, this.I - 160);
    }

    protected abstract void G9();

    protected abstract int K9();

    protected void M9() {
        ImageView imageView = this.f87473m;
        if (imageView == null) {
            QLog.e("QFSMiddlePageNextVideoGuideBasePart", 1, "[initArrowAnimation] mArrow is null");
            return;
        }
        imageView.setRotation(180.0f);
        this.f87473m.setBackgroundResource(R.drawable.kji);
        AnimationDrawable animationDrawable = (AnimationDrawable) this.f87473m.getBackground();
        if (animationDrawable != null) {
            animationDrawable.start();
        }
    }

    protected abstract void N9(View view);

    protected void O9() {
        View view = this.f87470f;
        if (view == null) {
            QLog.e(getTAG(), 1, "[initNextGuideView] mRootView is null");
            return;
        }
        ViewStub viewStub = (ViewStub) view.findViewById(K9());
        if (viewStub == null) {
            QLog.e(getTAG(), 1, "[initNextGuideView] viewStub is null");
            return;
        }
        View inflate = viewStub.inflate();
        if (inflate == null) {
            QLog.e(getTAG(), 1, "[initNextGuideView] container is null");
            return;
        }
        this.f87472i = inflate.findViewById(R.id.f45491s1);
        this.f87473m = (ImageView) inflate.findViewById(R.id.f45451rx);
        this.C = (QCircleAsyncTextView) inflate.findViewById(R.id.f45471rz);
        this.f87472i.setOnClickListener(this);
        this.C.setOnClickListener(this);
        this.f87472i.setAlpha(0.0f);
        this.f87472i.setVisibility(8);
        N9(inflate);
        M9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSMiddlePageNextVideoGuideBasePart";
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        if ("layer_notify_part_update_feed_index".equals(str)) {
            Integer num = (Integer) obj;
            QLog.d(getTAG(), 1, "[handleBroadcastMessage] position : " + num);
            if (num.intValue() == 0) {
                return;
            }
            getMainHandler().removeCallbacks(this.M);
            I9();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        I9();
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!fb0.a.b("QFSMiddlePageNextVideoGuideBasePart", 500L) && (view.getId() == R.id.f45491s1 || view.getId() == R.id.f45471rz || view.getId() == R.id.f45441rw || view.getId() == R.id.f45431rv)) {
            L9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f87470f = view;
        this.f87471h = (FrameLayout) view.findViewById(R.id.f45311rj);
        this.I = NumberUtil.stringToLong(uq3.o.z0("102520", "duration", QzoneConfig.DefaultValue.DEFAULT_GIF_ANTISHAKE_MAX_FRAME_SHOOTTIME));
        initViewModel();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        I9();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements Animator.AnimatorListener {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            QLog.e(QFSMiddlePageNextVideoGuideBasePart.this.getTAG(), 4, "[playShowAnimation] animatorSet onAnimationCancel");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QLog.e(QFSMiddlePageNextVideoGuideBasePart.this.getTAG(), 4, "[playShowAnimation] animatorSet onAnimationEnd");
            QFSMiddlePageNextVideoGuideBasePart.this.L = true;
            QFSMiddlePageNextVideoGuideBasePart.this.J9("dt_imp");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}
