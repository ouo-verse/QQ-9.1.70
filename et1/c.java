package et1;

import android.view.animation.Animation;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Let1/c;", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "Let1/d;", "d", "Let1/d;", "animListener", "<init>", "(Let1/d;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public class c implements Animation.AnimationListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final d animListener;

    public c(@Nullable d dVar) {
        this.animListener = dVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(@Nullable Animation animation) {
        d dVar = this.animListener;
        if (dVar != null) {
            dVar.b();
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(@Nullable Animation animation) {
        d dVar = this.animListener;
        if (dVar != null) {
            dVar.a();
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(@Nullable Animation animation) {
    }
}
