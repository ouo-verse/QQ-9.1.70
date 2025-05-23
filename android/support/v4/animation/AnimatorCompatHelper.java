package android.support.v4.animation;

import android.view.View;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AnimatorCompatHelper {
    private static final AnimatorProvider IMPL = new HoneycombMr1AnimatorCompatProvider();

    AnimatorCompatHelper() {
    }

    public static void clearInterpolator(View view) {
        IMPL.clearInterpolator(view);
    }

    public static ValueAnimatorCompat emptyValueAnimator() {
        return IMPL.emptyValueAnimator();
    }
}
