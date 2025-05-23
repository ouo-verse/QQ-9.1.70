package com.tencent.biz.pubaccount.weishi.util;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002H\u0007J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002H\u0007\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/util/h;", "", "Landroid/view/View;", "view", "", "b", "", ViewStickEventHelper.IS_SHOW, "Landroid/view/animation/Animation$AnimationListener;", "animationListener", "d", "targetView", "c", "a", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f81766a = new h();

    h() {
    }

    @JvmStatic
    public static final void a(View targetView) {
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        ObjectAnimator.ofFloat(targetView, View.ROTATION.getName(), 270.0f, 90.0f).start();
    }

    @JvmStatic
    public static final void b(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, view.getWidth() / 2.0f, view.getHeight() / 2.0f);
        scaleAnimation.setDuration(500L);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setRepeatCount(-1);
        scaleAnimation.setRepeatMode(2);
        view.startAnimation(scaleAnimation);
    }

    @JvmStatic
    public static final void c(View targetView) {
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        ObjectAnimator.ofFloat(targetView, View.ROTATION.getName(), 90.0f, 270.0f).start();
    }

    @JvmStatic
    public static final void d(View view, boolean isShow, Animation.AnimationListener animationListener) {
        ScaleAnimation scaleAnimation;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(animationListener, "animationListener");
        if (isShow) {
            scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, view.getWidth() / 2.0f, view.getHeight() / 2.0f);
        } else {
            scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, view.getWidth() / 2.0f, view.getHeight() / 2.0f);
        }
        scaleAnimation.setAnimationListener(animationListener);
        scaleAnimation.setDuration(250L);
        scaleAnimation.setFillAfter(true);
        view.startAnimation(scaleAnimation);
    }
}
