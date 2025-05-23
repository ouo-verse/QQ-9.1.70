package com.tencent.biz.qqcircle.immersive.feed;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.events.QFSFeedInfoViewShowEvent;
import com.tencent.biz.qqcircle.immersive.manager.QFSEcommercePreloadManager;
import com.tencent.biz.qqcircle.widgets.QFSDispatchTouchEventFrameLayout;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqecommerce.biz.consumer.api.IQQGoodsViewModel;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StLiteBanner;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ad extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {
    private QFSDispatchTouchEventFrameLayout I;
    private QFSDispatchTouchEventFrameLayout J;
    private View K;
    private View L;
    private IQQGoodsViewModel M;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements QFSDispatchTouchEventFrameLayout.a {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.biz.qqcircle.widgets.QFSDispatchTouchEventFrameLayout.a
        public void onDispatchTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                ad adVar = ad.this;
                ua0.e.a((FeedCloudMeta$StFeed) adVar.f85017h, adVar.r0());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements QFSDispatchTouchEventFrameLayout.a {
        b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.biz.qqcircle.widgets.QFSDispatchTouchEventFrameLayout.a
        public void onDispatchTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                ad adVar = ad.this;
                ua0.e.a((FeedCloudMeta$StFeed) adVar.f85017h, adVar.r0());
            }
        }
    }

    private void g1(boolean z16) {
        View view = this.L;
        if (view != null && this.K != null) {
            if (!z16) {
                view.setVisibility(4);
                this.K.setVisibility(4);
                return;
            }
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(400L);
            alphaAnimation.setAnimationListener(h1(this.L));
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation2.setDuration(400L);
            alphaAnimation2.setAnimationListener(h1(this.K));
            this.L.startAnimation(alphaAnimation);
            this.K.startAnimation(alphaAnimation2);
        }
    }

    private Animation.AnimationListener h1(View view) {
        return new c(view);
    }

    private void i1(com.tencent.biz.qqcircle.immersive.feed.event.l lVar) {
        IQQGoodsViewModel iQQGoodsViewModel = this.M;
        if (iQQGoodsViewModel != null) {
            iQQGoodsViewModel.sendXingHuanCardEvent(1);
            lVar.a();
            throw null;
        }
        lVar.a();
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void j1(@NonNull QFSFeedInfoViewShowEvent qFSFeedInfoViewShowEvent) {
        T t16 = this.f85017h;
        if (t16 != 0 && TextUtils.equals(((FeedCloudMeta$StFeed) t16).f398449id.get(), qFSFeedInfoViewShowEvent.getFeedId())) {
            if (qFSFeedInfoViewShowEvent.isShow()) {
                q1(qFSFeedInfoViewShowEvent.needAnim());
            } else {
                g1(qFSFeedInfoViewShowEvent.needAnim());
            }
        }
    }

    private void k1(com.tencent.biz.qqcircle.immersive.feed.event.an anVar) {
        IQQGoodsViewModel iQQGoodsViewModel;
        if (anVar != null && (iQQGoodsViewModel = this.M) != null) {
            iQQGoodsViewModel.onVideoProgressChange(anVar.e(), anVar.c());
        }
    }

    private void l1() {
        QFSDispatchTouchEventFrameLayout qFSDispatchTouchEventFrameLayout = this.I;
        if (qFSDispatchTouchEventFrameLayout != null) {
            qFSDispatchTouchEventFrameLayout.setVisibility(8);
        }
        QFSDispatchTouchEventFrameLayout qFSDispatchTouchEventFrameLayout2 = this.J;
        if (qFSDispatchTouchEventFrameLayout2 != null) {
            qFSDispatchTouchEventFrameLayout2.setVisibility(8);
        }
        View view = this.L;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.K;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        this.M = null;
    }

    private void m1() {
        if (this.I == null) {
            QFSDispatchTouchEventFrameLayout qFSDispatchTouchEventFrameLayout = (QFSDispatchTouchEventFrameLayout) ((ViewStub) this.C.findViewById(R.id.f54552fi)).inflate();
            this.I = qFSDispatchTouchEventFrameLayout;
            qFSDispatchTouchEventFrameLayout.setOnDispatchListener(new a());
            this.I.setTag("goods_card_layout");
        }
        if (this.J == null) {
            QFSDispatchTouchEventFrameLayout qFSDispatchTouchEventFrameLayout2 = (QFSDispatchTouchEventFrameLayout) ((ViewStub) this.C.findViewById(R.id.f44741q0)).inflate();
            this.J = qFSDispatchTouchEventFrameLayout2;
            qFSDispatchTouchEventFrameLayout2.setOnDispatchListener(new b());
            this.K = this.C.findViewById(R.id.f39931d0);
            this.L = this.C.findViewById(R.id.f39941d1);
        }
    }

    private boolean n1() {
        FeedCloudMeta$StFeed g16;
        FeedCloudMeta$StLiteBanner feedCloudMeta$StLiteBanner;
        e30.b bVar = this.E;
        if (bVar == null || bVar.g() == null || (feedCloudMeta$StLiteBanner = (g16 = this.E.g()).liteBanner) == null || feedCloudMeta$StLiteBanner.style_type.get() != 4 || g16.liteBanner.business_type.get() != 4) {
            return true;
        }
        return false;
    }

    private void p1() {
        QFSDispatchTouchEventFrameLayout qFSDispatchTouchEventFrameLayout = this.I;
        if (qFSDispatchTouchEventFrameLayout != null) {
            qFSDispatchTouchEventFrameLayout.removeAllViews();
        }
        QFSDispatchTouchEventFrameLayout qFSDispatchTouchEventFrameLayout2 = this.J;
        if (qFSDispatchTouchEventFrameLayout2 != null) {
            qFSDispatchTouchEventFrameLayout2.removeAllViews();
        }
    }

    private void q1(boolean z16) {
        View view = this.L;
        if (view != null && this.K != null) {
            view.setVisibility(0);
            this.K.setVisibility(0);
            if (!z16) {
                return;
            }
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation2.setDuration(400L);
            this.L.startAnimation(alphaAnimation);
            this.K.startAnimation(alphaAnimation2);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.an) {
            k1((com.tencent.biz.qqcircle.immersive.feed.event.an) hVar);
        } else if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.l) {
            i1((com.tencent.biz.qqcircle.immersive.feed.event.l) hVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void K0() {
        super.K0();
        if (!n1()) {
            ua0.e.b((FeedCloudMeta$StFeed) this.f85017h, r0());
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QFSFeedInfoViewShowEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: o1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        QFSDispatchTouchEventFrameLayout qFSDispatchTouchEventFrameLayout;
        super.L0(feedCloudMeta$StFeed, i3);
        p1();
        if (n1()) {
            l1();
            return;
        }
        m1();
        IQQGoodsViewModel i16 = QFSEcommercePreloadManager.j().i(m0(), feedCloudMeta$StFeed, QFSEcommercePreloadManager.j().f(feedCloudMeta$StFeed), y0());
        this.M = i16;
        QFSDispatchTouchEventFrameLayout qFSDispatchTouchEventFrameLayout2 = this.I;
        if (qFSDispatchTouchEventFrameLayout2 != null && i16 != null && (qFSDispatchTouchEventFrameLayout = this.J) != null) {
            i16.setWrapperView(qFSDispatchTouchEventFrameLayout2, qFSDispatchTouchEventFrameLayout);
            this.I.setVisibility(0);
            this.J.setVisibility(0);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onDestroy() {
        super.onDestroy();
        IQQGoodsViewModel iQQGoodsViewModel = this.M;
        if (iQQGoodsViewModel == null) {
            return;
        }
        iQQGoodsViewModel.onWrapperViewDisappear();
        this.M = null;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
        if (this.M == null) {
            return;
        }
        Boolean bool = Boolean.FALSE;
        e30.b bVar = this.E;
        if (bVar != null && bVar.g() != null) {
            bool = QFSEcommercePreloadManager.j().g(this.E.g());
        }
        this.M.onWrapperViewAppear(bool.booleanValue());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedUnSelected(rFWFeedSelectInfo);
        IQQGoodsViewModel iQQGoodsViewModel = this.M;
        if (iQQGoodsViewModel == null) {
            return;
        }
        iQQGoodsViewModel.onWrapperViewDisappear();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QFSFeedInfoViewShowEvent) {
            j1((QFSFeedInfoViewShowEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onResumed(rFWFeedSelectInfo);
        QCirclePluginUtil.setIsECFloatWebViewOnShow(false);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildEcommerceCardPresenter";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f85543d;

        c(View view) {
            this.f85543d = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f85543d.setVisibility(4);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
