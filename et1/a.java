package et1;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Let1/a;", "Let1/c;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationEnd", "Landroid/view/View;", "e", "Landroid/view/View;", "animView", "Let1/d;", "animListener", "<init>", "(Landroid/view/View;Let1/d;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a extends c {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View animView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull View animView, @Nullable d dVar) {
        super(dVar);
        Intrinsics.checkNotNullParameter(animView, "animView");
        this.animView = animView;
    }

    @Override // et1.c, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(@Nullable Animation animation) {
        this.animView.clearAnimation();
        ViewGroup.LayoutParams layoutParams = this.animView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.bottomMargin = 0;
        this.animView.setLayoutParams(layoutParams2);
        super.onAnimationEnd(animation);
    }
}
