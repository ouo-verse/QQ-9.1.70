package com.tencent.state.utils;

import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J*\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/state/utils/AnimationUtils;", "", "()V", "ALPHA_MAX", "", "ALPHA_MIN", "SQUARE_AVATAR_DURATION", "", "startAlphaAnimation", "Landroid/animation/ObjectAnimator;", "view", "Landroid/view/View;", ViewStickEventHelper.IS_SHOW, "", "duration", "listener", "Landroid/animation/AnimatorListenerAdapter;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class AnimationUtils {
    public static final float ALPHA_MAX = 1.0f;
    public static final float ALPHA_MIN = 0.0f;
    public static final AnimationUtils INSTANCE = new AnimationUtils();
    public static final long SQUARE_AVATAR_DURATION = 400;

    AnimationUtils() {
    }

    public final ObjectAnimator startAlphaAnimation(View view, boolean isShow, long duration, AnimatorListenerAdapter listener) {
        Intrinsics.checkNotNullParameter(view, "view");
        ObjectAnimator alpha = ObjectAnimator.ofFloat(view, c.f123400v, isShow ? 0.0f : 1.0f, isShow ? 1.0f : 0.0f);
        Intrinsics.checkNotNullExpressionValue(alpha, "alpha");
        alpha.setDuration(duration);
        if (listener != null) {
            alpha.addListener(listener);
        }
        alpha.start();
        return alpha;
    }

    public static /* synthetic */ ObjectAnimator startAlphaAnimation$default(AnimationUtils animationUtils, View view, boolean z16, long j3, AnimatorListenerAdapter animatorListenerAdapter, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            animatorListenerAdapter = null;
        }
        return animationUtils.startAlphaAnimation(view, z16, j3, animatorListenerAdapter);
    }
}
