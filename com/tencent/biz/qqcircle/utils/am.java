package com.tencent.biz.qqcircle.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.biz.qqcircle.widgets.QFSCommentPraiseLayout;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/biz/qqcircle/utils/am;", "", "Landroid/widget/FrameLayout;", HippyNestedScrollComponent.PRIORITY_PARENT, "", HippyTKDListViewAdapter.X, "y", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "targetViewWrf", "", "a", "Lcom/airbnb/lottie/LottieAnimationView;", "b", "Ljava/lang/ref/WeakReference;", "lottieAnimViewWrf", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class am {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final am f92635a = new am();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static WeakReference<LottieAnimationView> lottieAnimViewWrf;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/biz/qqcircle/utils/am$a", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "onAnimationCancel", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class a extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FrameLayout f92637d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ LottieAnimationView f92638e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ WeakReference<View> f92639f;

        a(FrameLayout frameLayout, LottieAnimationView lottieAnimationView, WeakReference<View> weakReference) {
            this.f92637d = frameLayout;
            this.f92638e = lottieAnimationView;
            this.f92639f = weakReference;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            QLog.d("QFSCommentDoublePraiseHelper", 1, "[onAnimationCancel] remove anim view");
            this.f92637d.removeView(this.f92638e);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            QLog.d("QFSCommentDoublePraiseHelper", 1, "remove anim view");
            this.f92637d.removeView(this.f92638e);
            View view = this.f92639f.get();
            if (view instanceof QFSCommentPraiseLayout) {
                ((QFSCommentPraiseLayout) view).d0();
            }
        }
    }

    am() {
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(@NotNull FrameLayout parent, int x16, int y16, @NotNull WeakReference<View> targetViewWrf) {
        String str;
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(targetViewWrf, "targetViewWrf");
        LottieAnimationView lottieAnimationView = new LottieAnimationView(parent.getContext());
        if (targetViewWrf.get() instanceof QFSCommentPraiseLayout) {
            View view = targetViewWrf.get();
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.biz.qqcircle.widgets.QFSCommentPraiseLayout");
            if (((QFSCommentPraiseLayout) view).O()) {
                str = "https://qq-video.cdn-go.cn/android/latest/defaultmode/9110/comment_like/qvideo_comment_animation_hotlike.json";
                lottieAnimationView.setAnimationFromUrl(str);
                int dip2px = DisplayUtil.dip2px(parent.getContext(), 80.0f);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dip2px, dip2px);
                if (!bz.p()) {
                    int[] iArr = new int[2];
                    parent.getLocationOnScreen(iArr);
                    layoutParams.leftMargin = (x16 - iArr[0]) - (dip2px / 2);
                } else {
                    layoutParams.leftMargin = x16 - (dip2px / 2);
                }
                layoutParams.topMargin = y16 - (dip2px / 2);
                lottieAnimationView.setLayoutParams(layoutParams);
                parent.addView(lottieAnimationView);
                lottieAnimationView.playAnimation();
                lottieAnimViewWrf = new WeakReference<>(lottieAnimationView);
                lottieAnimationView.addAnimatorListener(new a(parent, lottieAnimationView, targetViewWrf));
            }
        }
        str = "https://qq-video.cdn-go.cn/android/latest/defaultmode/9110/comment_like/qvideo_comment_animation_normallike.json";
        lottieAnimationView.setAnimationFromUrl(str);
        int dip2px2 = DisplayUtil.dip2px(parent.getContext(), 80.0f);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(dip2px2, dip2px2);
        if (!bz.p()) {
        }
        layoutParams2.topMargin = y16 - (dip2px2 / 2);
        lottieAnimationView.setLayoutParams(layoutParams2);
        parent.addView(lottieAnimationView);
        lottieAnimationView.playAnimation();
        lottieAnimViewWrf = new WeakReference<>(lottieAnimationView);
        lottieAnimationView.addAnimatorListener(new a(parent, lottieAnimationView, targetViewWrf));
    }
}
