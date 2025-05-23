package fj4;

import android.animation.Animator;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\t\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lfj4/b;", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "Landroid/view/View;", "d", "Landroid/view/View;", "view", "", "e", "I", "originLayerType", "<init>", "(Landroid/view/View;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public class b implements Animator.AnimatorListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View view;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int originLayerType;

    public b(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        this.originLayerType = view.getLayerType();
        view.setLayerType(2, null);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(@Nullable Animator animation) {
        this.view.setLayerType(this.originLayerType, null);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(@Nullable Animator animation) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(@Nullable Animator animation) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(@Nullable Animator animation) {
    }
}
