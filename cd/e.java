package cd;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \b2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0007R$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcd/e;", "", "Landroid/view/View;", "menuViewContainer", "", "startHeight", "endHeight", "", "b", "d", "Landroid/animation/ValueAnimator;", "a", "Landroid/animation/ValueAnimator;", "getSwitchAnim", "()Landroid/animation/ValueAnimator;", "setSwitchAnim", "(Landroid/animation/ValueAnimator;)V", "switchAnim", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class e {

    /* renamed from: c, reason: collision with root package name */
    private static final String f30659c = "QZoneKeyBoardAnimalHelper";

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private ValueAnimator switchAnim;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(View menuViewContainer, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(menuViewContainer, "$menuViewContainer");
        ViewGroup.LayoutParams layoutParams = menuViewContainer.getLayoutParams();
        if (layoutParams != null) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
            layoutParams.height = ((Integer) animatedValue).intValue();
        }
        menuViewContainer.requestLayout();
    }

    public final void b(final View menuViewContainer, int startHeight, int endHeight) {
        Intrinsics.checkNotNullParameter(menuViewContainer, "menuViewContainer");
        QLog.i(f30659c, 1, "[startValueAnimator] startHeight=" + startHeight + ", endHeight=" + endHeight);
        ValueAnimator ofInt = ValueAnimator.ofInt(startHeight, endHeight);
        this.switchAnim = ofInt;
        Intrinsics.checkNotNull(ofInt);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: cd.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                e.c(menuViewContainer, valueAnimator);
            }
        });
        he0.b.l(this.switchAnim, R.anim.f154977uk);
        int abs = Math.abs(startHeight - endHeight) / 8;
        if (abs < 150) {
            abs = 150;
        }
        if (menuViewContainer.getVisibility() == 8) {
            abs = 400;
        }
        ValueAnimator valueAnimator = this.switchAnim;
        Intrinsics.checkNotNull(valueAnimator);
        valueAnimator.setDuration(abs);
        ValueAnimator valueAnimator2 = this.switchAnim;
        Intrinsics.checkNotNull(valueAnimator2);
        valueAnimator2.start();
    }

    public final void d() {
        ValueAnimator valueAnimator = this.switchAnim;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }
}
