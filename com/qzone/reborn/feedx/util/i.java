package com.qzone.reborn.feedx.util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieListener;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.feed.business.model.FeedHolidayCommentEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.vas.widget.lottie.LottieLoader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0010B\u0013\b\u0016\u0012\b\u0010&\u001a\u0004\u0018\u00010\u001a\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\u000e\u001a\u00020\u0002R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001cR\u0016\u0010!\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006)"}, d2 = {"Lcom/qzone/reborn/feedx/util/i;", "", "", "f", "Lcom/airbnb/lottie/LottieAnimationView;", "loadingView", "", "zipResUrl", "i", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/common/business/result/QZoneResult;", "result", "e", tl.h.F, "Landroid/widget/FrameLayout;", "a", "Landroid/widget/FrameLayout;", "mFirstCommentContainer", "b", "Lcom/airbnb/lottie/LottieAnimationView;", "mLottieAnimationView", "Lcom/tencent/mobileqq/vas/widget/lottie/LottieLoader;", "c", "Lcom/tencent/mobileqq/vas/widget/lottie/LottieLoader;", "mLottieLoader", "Landroid/view/View;", "d", "Landroid/view/View;", "mRootView", "mInflateView", "", "Z", "mIsLoadedLottieAnim", "Ljava/lang/Runnable;", "g", "Ljava/lang/Runnable;", "mAnimHideRunnable", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "<init>", "(Landroid/view/View;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private FrameLayout mFirstCommentContainer;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private LottieAnimationView mLottieAnimationView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private LottieLoader mLottieLoader;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View mRootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View mInflateView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mIsLoadedLottieAnim;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Runnable mAnimHideRunnable = new Runnable() { // from class: com.qzone.reborn.feedx.util.f
        @Override // java.lang.Runnable
        public final void run() {
            i.g(i.this);
        }
    };

    public i(View view) {
        this.mRootView = view;
    }

    private final void f() {
        View view = this.mRootView;
        if (view == null) {
            return;
        }
        ViewStub viewStub = view != null ? (ViewStub) view.findViewById(R.id.mzd) : null;
        if (viewStub != null && this.mInflateView == null) {
            View inflate = viewStub.inflate();
            this.mInflateView = inflate;
            this.mLottieAnimationView = inflate != null ? (LottieAnimationView) inflate.findViewById(R.id.mze) : null;
            View view2 = this.mInflateView;
            this.mFirstCommentContainer = view2 != null ? (FrameLayout) view2.findViewById(R.id.f162870n24) : null;
            return;
        }
        QLog.e("QZoneCommentAnimalManger", 1, "getFirstCommentAnimalViewStub error, viewStub is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(i this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mIsLoadedLottieAnim) {
            return;
        }
        this$0.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(i this$0, Throwable th5) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.e("QZoneCommentAnimalManger", 1, "[setLottieAnimView] fail " + th5);
        this$0.mIsLoadedLottieAnim = true;
        this$0.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        long j3;
        LottieAnimationView lottieAnimationView = this.mLottieAnimationView;
        if (lottieAnimationView == null) {
            return;
        }
        this.mIsLoadedLottieAnim = true;
        Intrinsics.checkNotNull(lottieAnimationView);
        lottieAnimationView.setVisibility(0);
        LottieAnimationView lottieAnimationView2 = this.mLottieAnimationView;
        Intrinsics.checkNotNull(lottieAnimationView2);
        if (lottieAnimationView2.getDuration() > 0) {
            LottieAnimationView lottieAnimationView3 = this.mLottieAnimationView;
            Intrinsics.checkNotNull(lottieAnimationView3);
            j3 = lottieAnimationView3.getDuration();
        } else {
            j3 = 3000;
        }
        QLog.i("QZoneCommentAnimalManger", 1, "[startLottieAnim] duration = " + j3);
        RFWThreadManager.getUIHandler().removeCallbacks(this.mAnimHideRunnable);
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.feedx.util.h
            @Override // java.lang.Runnable
            public final void run() {
                i.l(i.this);
            }
        }, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(i this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m();
    }

    public final void e(QZoneResult result) {
        if (com.qzone.reborn.configx.g.f53821a.b().r()) {
            return;
        }
        if ((result != null ? result.getData() : null) != null && (result.getData() instanceof Bundle)) {
            Object data = result.getData();
            Intrinsics.checkNotNull(data, "null cannot be cast to non-null type android.os.Bundle");
            Serializable serializable = ((Bundle) data).getSerializable("extendInfo");
            if (serializable == null || !(serializable instanceof FeedHolidayCommentEvent)) {
                return;
            }
            FeedHolidayCommentEvent feedHolidayCommentEvent = (FeedHolidayCommentEvent) serializable;
            if (TextUtils.isEmpty(feedHolidayCommentEvent.getPlayRid())) {
                QLog.e("QZoneCommentAnimalManger", 1, "[handleCommentAndReplyMsg] play_rid is null");
                return;
            }
            com.tencent.mobileqq.service.qzone.e eVar = com.tencent.mobileqq.service.qzone.e.f286406a;
            if (eVar.c()) {
                f();
                String playRid = feedHolidayCommentEvent.getPlayRid();
                Intrinsics.checkNotNull(playRid);
                i(this.mLottieAnimationView, eVar.a(playRid));
                return;
            }
            return;
        }
        RFWLog.e("QZoneCommentAnimalManger", RFWLog.USR, "[handleCommentAndReplyMsg] result = null");
    }

    public final void h() {
        LottieLoader lottieLoader = this.mLottieLoader;
        if (lottieLoader != null) {
            lottieLoader.destroy();
        }
        LottieAnimationView lottieAnimationView = this.mLottieAnimationView;
        if (lottieAnimationView != null) {
            lottieAnimationView.removeAllAnimatorListeners();
        }
        RFWThreadManager.getUIHandler().removeCallbacks(this.mAnimHideRunnable);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/qzone/reborn/feedx/util/i$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "", "isReverse", "onAnimationEnd", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation, boolean isReverse) {
            super.onAnimationEnd(animation, isReverse);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            super.onAnimationStart(animation);
            i.this.k();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation, boolean isReverse) {
            super.onAnimationStart(animation, isReverse);
            i.this.k();
        }
    }

    private final void m() {
        QLog.i("QZoneCommentAnimalManger", 1, "[stopLottieAnim]");
        LottieAnimationView lottieAnimationView = this.mLottieAnimationView;
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(8);
        }
        FrameLayout frameLayout = this.mFirstCommentContainer;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        h();
    }

    private final void i(LottieAnimationView loadingView, String zipResUrl) {
        if (loadingView != null && !TextUtils.isEmpty(zipResUrl)) {
            this.mIsLoadedLottieAnim = false;
            LottieLoader lottieLoader = new LottieLoader(loadingView.getContext());
            this.mLottieLoader = lottieLoader;
            lottieLoader.fromNetworkWithCacheBitmap(loadingView, zipResUrl);
            loadingView.setRepeatCount(0);
            RFWThreadManager.getUIHandler().postDelayed(this.mAnimHideRunnable, 3000L);
            FrameLayout frameLayout = this.mFirstCommentContainer;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            loadingView.setVisibility(8);
            loadingView.addAnimatorListener(new b());
            loadingView.setFailureListener(new LottieListener() { // from class: com.qzone.reborn.feedx.util.g
                @Override // com.airbnb.lottie.LottieListener
                public final void onResult(Object obj) {
                    i.j(i.this, (Throwable) obj);
                }
            });
            return;
        }
        QLog.e("QZoneCommentAnimalManger", 1, "[setLottieAnimView] zipUrl is " + zipResUrl);
    }
}
