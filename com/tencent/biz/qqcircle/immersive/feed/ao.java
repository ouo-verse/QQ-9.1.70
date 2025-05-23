package com.tencent.biz.qqcircle.immersive.feed;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.views.banner.bottom.QFSBottomGuideMuteView;
import com.tencent.biz.qqcircle.immersive.views.banner.bottom.QFSFeedBottomRecommendView;
import com.tencent.biz.qqcircle.immersive.views.banner.bottom.QFSFeedBottomShareGuideView;
import com.tencent.biz.qqcircle.immersive.views.banner.bottom.QFSFeedFreeFlowView;
import com.tencent.biz.qqcircle.immersive.views.banner.bottom.QFSFeedFriendCommentGuideView;
import com.tencent.biz.qqcircle.immersive.views.banner.bottom.QFSFeedShareQQGroupView;
import com.tencent.biz.qqcircle.immersive.views.banner.bottom.autoslideguide.QFSAutoSlideGuideView;
import com.tencent.biz.qqcircle.immersive.views.banner.bottom.configguidefollow.QFSFeedBottomConfigGuideFollowView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.order.IOrderElement;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class ao extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements IOrderElement {
    private static final List<String> L;
    protected View I;
    protected View J;
    protected LinearLayout K;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f85979d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f85980e;

        b(View view, View view2) {
            this.f85979d = view;
            this.f85980e = view2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (this.f85979d != null && this.f85980e != null) {
                float f16 = -((Integer) valueAnimator.getAnimatedValue()).intValue();
                this.f85979d.setTranslationY(f16);
                this.f85980e.setTranslationY(f16);
            }
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        L = arrayList;
        arrayList.add(com.tencent.biz.qqcircle.immersive.views.banner.bottom.g.class.getSimpleName());
        arrayList.add(QFSFeedFreeFlowView.class.getSimpleName());
        arrayList.add(QFSFeedBottomRecommendView.class.getSimpleName());
        arrayList.add(QFSFeedChildBottomDynamicGuideView.class.getSimpleName());
        arrayList.add(com.tencent.biz.qqcircle.immersive.views.banner.bottom.o.class.getSimpleName());
        arrayList.add(QFSFeedBottomGuideFollowView.class.getSimpleName());
        arrayList.add(QFSFeedBottomConfigGuideFollowView.class.getSimpleName());
        arrayList.add(o.class.getSimpleName());
        arrayList.add(QFSFeedBottomShareGuideView.class.getSimpleName());
        arrayList.add(com.tencent.biz.qqcircle.immersive.views.banner.bottom.f.class.getSimpleName());
        arrayList.add(QFSFeedShareQQGroupView.class.getSimpleName());
        arrayList.add(QFSAutoSlideGuideView.class.getSimpleName());
        arrayList.add(com.tencent.biz.qqcircle.immersive.views.banner.bottom.af.class.getSimpleName());
        arrayList.add(QFSFeedFriendCommentGuideView.class.getSimpleName());
        arrayList.add(com.tencent.biz.qqcircle.immersive.views.banner.bottom.ae.class.getSimpleName());
        arrayList.add(QFSBottomGuideMuteView.class.getSimpleName());
        arrayList.add(com.tencent.biz.qqcircle.immersive.views.banner.bottom.h.class.getSimpleName());
        arrayList.add(com.tencent.biz.qqcircle.immersive.views.banner.bottom.m.class.getSimpleName());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.I = view.findViewById(R.id.f34510zc);
        this.J = view.findViewById(R.id.f39941d1);
        this.K = (LinearLayout) view.findViewById(R.id.f34340yw);
        com.tencent.biz.qqcircle.immersive.manager.e.a().addElement(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean g1() {
        IOrderElement groupActivatingElement = com.tencent.biz.qqcircle.immersive.manager.e.a().getGroupActivatingElement(v0(), "feed_type_bottom_banner_group");
        if (groupActivatingElement != null && L.contains(groupActivatingElement.getClass().getSimpleName())) {
            QLog.e("QFSFeedChildNonResidentBottomBannerPresenter", 1, "[isHigherOrderElementShowing] is mutual exclusive. showingElement =" + groupActivatingElement);
            return true;
        }
        QLog.d("QFSFeedChildNonResidentBottomBannerPresenter", 1, "[isHigherOrderElementShowing] mShowingElement = " + groupActivatingElement);
        return false;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public String getContextHashCode() {
        return v0();
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public /* synthetic */ String getElementExtraKey() {
        return com.tencent.biz.richframework.order.a.a(this);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public String getGroup() {
        return "feed_type_bottom_non_resident_banner_group";
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public /* synthetic */ String getGroupExtraKey() {
        return com.tencent.biz.richframework.order.a.b(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h1(View view, View view2, Animator.AnimatorListener animatorListener) {
        if (view2 == null) {
            i1(view, animatorListener);
            return;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, DisplayUtil.dip2px(m0(), 32.0f));
        ofInt.setStartDelay(40L);
        ofInt.setDuration(300L);
        ofInt.addUpdateListener(new b(view, view2));
        if (animatorListener != null) {
            ofInt.addListener(animatorListener);
        }
        ofInt.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i1(View view, Animator.AnimatorListener animatorListener) {
        if (this.I != null && this.J != null) {
            QLog.d("QFSFeedChildNonResidentBottomBannerPresenter", 1, "[playShowAnimOnly]");
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
            ofFloat.setDuration(250L);
            ofFloat.setStartDelay(80L);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.I, "translationY", 0.0f, -DisplayUtil.dip2px(m0(), 42.0f));
            ofFloat2.setDuration(250L);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.J, "translationY", 0.0f, -DisplayUtil.dip2px(m0(), 42.0f));
            ofFloat3.setDuration(250L);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(330L);
            animatorSet.playTogether(ofFloat2, ofFloat3, ofFloat);
            animatorSet.addListener(new a());
            if (animatorListener != null) {
                animatorSet.addListener(animatorListener);
            }
            animatorSet.start();
        }
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public /* synthetic */ boolean isDataReady() {
        return com.tencent.biz.richframework.order.a.c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements Animator.AnimatorListener {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            View view = ao.this.I;
            if (view != null) {
                view.setTranslationY(0.0f);
            }
            View view2 = ao.this.J;
            if (view2 != null) {
                view2.setTranslationY(0.0f);
            }
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
