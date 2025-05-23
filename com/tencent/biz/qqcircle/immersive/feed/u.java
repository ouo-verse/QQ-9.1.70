package com.tencent.biz.qqcircle.immersive.feed;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.aspectj.QCircleForbidInteractProcessor;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QFSCommentInfo;
import com.tencent.biz.qqcircle.comment.QFSBaseCommentPresenter;
import com.tencent.biz.qqcircle.comment.QFSCommentReportHelper;
import com.tencent.biz.qqcircle.events.QCircleCommentCountUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.events.QCircleResetCommentBlockEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSUnShowFreeFlowViewEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSRatePlayGestureEvent;
import com.tencent.biz.qqcircle.immersive.model.bottombarrage.QFSVideoPauseEvent;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class u extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements Observer<e30.b>, View.OnClickListener {
    private TextView I;
    private ImageView J;
    private FeedCloudMeta$StFeed K;
    private View L;
    private View M;
    private View N;
    private QCircleAvatarView P;
    private View Q;
    private View R;
    private TextView S;
    private QFSVideoView T;
    private AnimatorSet U;
    private AnimatorSet V;
    private e30.b W;
    private int X;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            u.this.R.setVisibility(8);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            u.this.R.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            u.this.R.setAlpha(1.0f);
            u.this.R.setTranslationX(0.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            u.this.R.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void C1(boolean z16, int i3) {
        String str;
        if (s0() == null) {
            QLog.d("QFSFeedChildCommentPresenter", 1, "[openCommentPanel] feed ioc should not be null.");
            return;
        }
        if (this.f85017h == 0) {
            QLog.e(getTAG(), 1, "[openCommentPanel] mData == null");
            return;
        }
        QFSCommentInfo i16 = i1(i3);
        t40.a s06 = s0();
        if (z16) {
            str = "event_open_comment_input";
        } else {
            str = "event_open_comment";
        }
        s06.onHandlerMessage(str, i16);
        R0(6, 2, r(), QFSCommentReportHelper.n((FeedCloudMeta$StFeed) this.f85017h));
        w20.a.j().m();
    }

    private void D1() {
        if (this.M == null || !y1()) {
            return;
        }
        this.M.startAnimation((AnimationSet) AnimationUtils.loadAnimation(m0(), R.anim.f154913ti));
    }

    private void E1() {
        AnimatorSet animatorSet = this.V;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.V.cancel();
            return;
        }
        View view = this.R;
        if (view != null && view.getVisibility() != 0) {
            QLog.d("QFSFeedChildCommentPresenter", 1, "showEnterAnim");
            AnimatorSet k16 = k1(true);
            this.U = k16;
            k16.addListener(new a());
            this.U.start();
            return;
        }
        QLog.d("QFSFeedChildCommentPresenter", 1, "showEnterAnim, comment guide is shown. ");
    }

    private void F1() {
        AnimatorSet animatorSet = this.U;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.U.cancel();
            return;
        }
        View view = this.R;
        if (view != null && view.getVisibility() == 0) {
            QLog.d("QFSFeedChildCommentPresenter", 1, "showExitAnim");
            AnimatorSet k16 = k1(false);
            this.V = k16;
            k16.addListener(new b());
            this.V.start();
            return;
        }
        QLog.d("QFSFeedChildCommentPresenter", 1, "showExitAnim, comment guide is not shown. ");
    }

    private void G1(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (!uq3.c.H6()) {
            return;
        }
        QLog.d("QFSFeedChildCommentPresenter", 1, "showFirstCommentGuildText isNotAllowCommentFeed return");
    }

    private boolean H1() {
        if (QCirclePluginUtil.isFeedOwner(n0()) || this.I == null || !u1()) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void I1() {
        if (y1()) {
            v1();
            this.M.setVisibility(0);
            this.J.setVisibility(8);
            this.P.setAvatar(((FeedCloudMeta$StFeed) this.f85017h).commentExtraInfo.reddotInfo.user, com.tencent.biz.qqcircle.immersive.utils.n.a(m0(), R.dimen.d1u));
            return;
        }
        View view = this.M;
        if (view != null) {
            view.clearAnimation();
            this.M.setVisibility(8);
        }
        this.J.setVisibility(0);
    }

    private void J1(String str) {
        ImageView imageView = this.J;
        if (imageView == null) {
            return;
        }
        imageView.setContentDescription(str);
    }

    private void K1() {
        String a16;
        TextView textView = this.S;
        if (textView != null) {
            if (u1()) {
                a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f19231476);
            } else {
                a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f181853ew);
            }
            textView.setText(a16);
        }
    }

    private void L1(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (this.I == null) {
            QLog.d("QFSFeedChildCommentPresenter", 1, "[updateFeedCommentText] video comment text should not be null.");
            return;
        }
        if (feedCloudMeta$StFeed.commentCount.get() <= 0) {
            this.I.setText(R.string.f181813es);
            G1(feedCloudMeta$StFeed);
            this.I.setTextSize(1, 11.0f);
            J1(com.tencent.biz.qqcircle.utils.h.a(R.string.f181813es));
        } else {
            this.I.setText(com.tencent.biz.qqcircle.immersive.utils.r.d(feedCloudMeta$StFeed.commentCount.get(), 11));
            this.I.setTextSize(1, 12.0f);
            J1(com.tencent.biz.qqcircle.utils.h.a(R.string.f187793uy) + ((Object) this.I.getText()));
        }
        this.X = feedCloudMeta$StFeed.commentCount.get();
        HashMap hashMap = new HashMap();
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_AVATAR, Integer.valueOf(y1() ? 1 : 0));
        String str = "";
        if (y1()) {
            str = uq3.k.a().h("sp_key_last_insert_red_point_id", "");
        }
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_REDDOT_ID, str);
        g0(this.N, QCircleDaTongConstant.ElementId.EM_XSJ_COMMENT_BUTTON, hashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void h1(QFSCommentInfo.ActionBean actionBean) {
        T t16;
        if (y1() && (t16 = this.f85017h) != 0 && actionBean != null) {
            String str = ((FeedCloudMeta$StFeed) t16).commentExtraInfo.reddotInfo.commentId.get();
            String str2 = ((FeedCloudMeta$StFeed) this.f85017h).commentExtraInfo.reddotInfo.replyId.get();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            QCircleInitBean.QCircleActionBean qCircleActionBean = new QCircleInitBean.QCircleActionBean();
            qCircleActionBean.mItemTopAnimationCommentId = str;
            qCircleActionBean.mItemTopAnimationReplyId = str2;
            actionBean.mCommentInitBeanActionBean = qCircleActionBean;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private QFSCommentInfo i1(int i3) {
        View view;
        QFSCommentInfo qFSCommentInfo = new QFSCommentInfo();
        qFSCommentInfo.mFeedBlockData = this.E;
        qFSCommentInfo.mFeed = (FeedCloudMeta$StFeed) this.f85017h;
        qFSCommentInfo.mReportBean = getReportBean();
        qFSCommentInfo.mRelocationScrollType = 100;
        QCircleExtraTypeInfo r16 = r();
        if (r16 == null) {
            r16 = new QCircleExtraTypeInfo();
        }
        qFSCommentInfo.mExtraTypeInfo = r16;
        r16.mDataPosition = this.f85018i;
        qFSCommentInfo.mCmtPanelSource = i3;
        if (this.T == null && (view = this.L) != null) {
            this.T = (QFSVideoView) view.findViewById(R.id.f74163vi);
        }
        QFSCommentInfo.ActionBean actionBean = new QFSCommentInfo.ActionBean();
        h1(actionBean);
        qFSCommentInfo.mActionBean = actionBean;
        View view2 = this.L;
        if (view2 != null) {
            qFSCommentInfo.mHadAdBanner = com.tencent.biz.qqcircle.immersive.utils.ad.a.h((ViewGroup) view2.findViewById(R.id.f40181do));
        }
        return qFSCommentInfo;
    }

    private void j1(View view) {
        if (QCircleForbidInteractProcessor.forbidInteractIfGuildFeed(this.K, 1)) {
            QLog.d(getTAG(), 1, "commentBtnClick: guild feed forbid interact");
            return;
        }
        if (view.getId() == R.id.f40151dl) {
            C1(H1(), 2);
            SimpleEventBus.getInstance().dispatchEvent(new QFSUnShowFreeFlowViewEvent());
            e30.b bVar = this.E;
            if (bVar != null) {
                bVar.o("key_comment_at_has_consumed", Boolean.TRUE);
                I1();
                return;
            }
            return;
        }
        if ((view.getId() != R.id.f40891fl && view.getId() != R.id.f40551eo) || fb0.a.a("pauseCommentGuide")) {
            return;
        }
        C1(true, 14);
        n1("dt_clck");
        SimpleEventBus.getInstance().dispatchEvent(new QFSUnShowFreeFlowViewEvent());
    }

    private AnimatorSet k1(boolean z16) {
        float f16;
        float f17;
        View view = this.R;
        float[] fArr = new float[2];
        float f18 = 1.0f;
        float f19 = 0.0f;
        if (z16) {
            f16 = 0.0f;
        } else {
            f16 = 1.0f;
        }
        fArr[0] = f16;
        if (!z16) {
            f18 = 0.0f;
        }
        fArr[1] = f18;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, fArr);
        int a16 = com.tencent.biz.qqcircle.utils.cx.a(22.0f);
        View view2 = this.R;
        float[] fArr2 = new float[2];
        if (z16) {
            f17 = a16;
        } else {
            f17 = 0.0f;
        }
        fArr2[0] = f17;
        if (!z16) {
            f19 = a16;
        }
        fArr2[1] = f19;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, "translationX", fArr2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(200L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        return animatorSet;
    }

    private void l1() {
        View view = this.M;
        if (view == null) {
            return;
        }
        view.clearAnimation();
    }

    private void m1() {
        View view = this.R;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private void n1(String str) {
        String str2;
        ExposurePolicy exposurePolicy;
        View view = this.R;
        if (view == null) {
            return;
        }
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_EXTERNAL_COMMENT_BOX);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.K;
        String str3 = "";
        if (feedCloudMeta$StFeed == null) {
            str2 = "";
        } else {
            str2 = feedCloudMeta$StFeed.poster.f398463id.get();
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, str2);
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = this.K;
        if (feedCloudMeta$StFeed2 != null) {
            str3 = feedCloudMeta$StFeed2.f398449id.get();
        }
        buildElementParams.put("xsj_feed_id", str3);
        View view2 = this.R;
        if (TextUtils.equals(str, "dt_clck")) {
            exposurePolicy = ExposurePolicy.REPORT_NONE;
        } else {
            exposurePolicy = ExposurePolicy.REPORT_ALL;
        }
        VideoReport.setElementExposePolicy(view2, exposurePolicy);
        VideoReport.reportEvent(str, this.R, buildElementParams);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void o1(QCircleCommentUpdateEvent qCircleCommentUpdateEvent) {
        View view;
        T t16 = this.f85017h;
        if (t16 != 0 && TextUtils.equals(((FeedCloudMeta$StFeed) t16).f398449id.get(), qCircleCommentUpdateEvent.feedId) && qCircleCommentUpdateEvent.eventStatus == 3 && (view = this.R) != null && view.getVisibility() == 0) {
            F1();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void p1(com.tencent.biz.qqcircle.immersive.feed.event.w wVar) {
        if (this.f85017h != 0 && TextUtils.equals(wVar.a(), ((FeedCloudMeta$StFeed) this.f85017h).f398449id.get())) {
            m1();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void q1(QCircleCommentCountUpdateEvent qCircleCommentCountUpdateEvent) {
        T t16 = this.f85017h;
        if (t16 == 0 || !TextUtils.equals(((FeedCloudMeta$StFeed) t16).f398449id.get(), qCircleCommentCountUpdateEvent.getFeedId())) {
            return;
        }
        ((FeedCloudMeta$StFeed) this.f85017h).commentCount.set(qCircleCommentCountUpdateEvent.getCount());
        L1((FeedCloudMeta$StFeed) this.f85017h);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void r1(QFSRatePlayGestureEvent qFSRatePlayGestureEvent) {
        View view;
        if (this.f85017h != 0 && qFSRatePlayGestureEvent.getFeed() != null && TextUtils.equals(qFSRatePlayGestureEvent.getFeed().f398449id.get(), ((FeedCloudMeta$StFeed) this.f85017h).f398449id.get()) && qFSRatePlayGestureEvent.getEventType() == 0 && (view = this.R) != null) {
            view.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void s1(QFSVideoPauseEvent qFSVideoPauseEvent) {
        T t16 = this.f85017h;
        if (t16 == 0 || !TextUtils.equals(((FeedCloudMeta$StFeed) t16).f398449id.get(), qFSVideoPauseEvent.mFeedId) || !w1() || QFSBaseCommentPresenter.l((FeedCloudMeta$StFeed) this.f85017h)) {
            return;
        }
        x1();
        if (qFSVideoPauseEvent.mIsPause && qFSVideoPauseEvent.mIsClick) {
            K1();
            E1();
            n1("dt_imp");
            return;
        }
        F1();
    }

    private boolean t1() {
        e30.b bVar = this.E;
        if (bVar == null) {
            return false;
        }
        Object b16 = bVar.b("key_comment_at_has_consumed");
        if (!(b16 instanceof Boolean)) {
            return false;
        }
        return ((Boolean) b16).booleanValue();
    }

    private boolean u1() {
        return TextUtils.equals(com.tencent.biz.qqcircle.utils.h.a(R.string.f183253io), this.I.getText());
    }

    private void v1() {
        View view;
        if (this.M != null || (view = this.L) == null) {
            return;
        }
        View inflate = ((ViewStub) view.findViewById(R.id.f40101dg)).inflate();
        this.M = inflate;
        this.P = (QCircleAvatarView) inflate.findViewById(R.id.f40091df);
    }

    private boolean w1() {
        return false;
    }

    private void x1() {
        View view;
        if (this.R == null && (view = this.Q) != null) {
            View inflate = ((ViewStub) view.findViewById(R.id.f40901fm)).inflate();
            this.R = inflate;
            inflate.setOnClickListener(this);
            TextView textView = (TextView) this.R.findViewById(R.id.f40551eo);
            this.S = textView;
            textView.setOnClickListener(this);
            this.R.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean y1() {
        T t16 = this.f85017h;
        if (t16 != 0 && !TextUtils.isEmpty(((FeedCloudMeta$StFeed) t16).commentExtraInfo.reddotInfo.user.f398463id.get()) && !t1()) {
            return true;
        }
        return false;
    }

    private boolean z1(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return false;
        }
        if (h20.c.h() && feedCloudMeta$StFeed.commentCount.get() == this.X) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: A1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        if (feedCloudMeta$StFeed == null) {
            QLog.d("QFSFeedChildCommentPresenter", 1, "[onBindData] data should not be null.");
            return;
        }
        this.K = feedCloudMeta$StFeed;
        L1(feedCloudMeta$StFeed);
        this.W = new e30.b(feedCloudMeta$StFeed);
        w20.a.j().observerGlobalState(this.W, this);
        I1();
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    public void onChanged(e30.b bVar) {
        if (bVar != null && z1(bVar.g())) {
            L1(bVar.g());
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        super.C0(hVar);
        if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.w) {
            p1((com.tencent.biz.qqcircle.immersive.feed.event.w) hVar);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public boolean H0() {
        return com.tencent.biz.qqcircle.manager.i.a("qfs_feed_comment_show");
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.L = view;
        View findViewById = view.findViewById(R.id.f40161dm);
        this.Q = findViewById;
        findViewById.setVisibility(0);
        View findViewById2 = this.Q.findViewById(R.id.f40151dl);
        this.N = findViewById2;
        findViewById2.setOnClickListener(this);
        this.I = (TextView) this.N.findViewById(R.id.v_n);
        ImageView imageView = (ImageView) this.N.findViewById(R.id.v_l);
        this.J = imageView;
        imageView.setImageResource(com.tencent.biz.qqcircle.k.c());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QCircleCommentCountUpdateEvent.class);
        eventClass.add(QFSVideoPauseEvent.class);
        eventClass.add(QCircleCommentUpdateEvent.class);
        eventClass.add(QFSRatePlayGestureEvent.class);
        eventClass.add(QCirclePanelStateEvent.class);
        return eventClass;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null) {
            j1(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
        D1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        String str;
        super.onFeedUnSelected(rFWFeedSelectInfo);
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.K;
        if (feedCloudMeta$StFeed != null) {
            str = feedCloudMeta$StFeed.f398449id.get();
        } else {
            str = "";
        }
        simpleEventBus.dispatchEvent(new QCircleResetCommentBlockEvent(str));
        l1();
        m1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QCircleCommentCountUpdateEvent) {
            q1((QCircleCommentCountUpdateEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSVideoPauseEvent) {
            s1((QFSVideoPauseEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QCircleCommentUpdateEvent) {
            o1((QCircleCommentUpdateEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSRatePlayGestureEvent) {
            r1((QFSRatePlayGestureEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return null;
    }
}
