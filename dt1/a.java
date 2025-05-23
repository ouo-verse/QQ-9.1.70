package dt1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R;
import et1.e;
import et1.f;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0013\u0010\u0014J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\"\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J \u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J \u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0016\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002J\u0016\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002R\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Ldt1/a;", "", "Landroid/view/View;", "titleBar", "", "toMoveOut", "Let1/d;", "animListener", "", "b", "bottomBar", "a", "c", "e", "d", "f", "Landroid/content/Context;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    public a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    private final void a(View bottomBar, boolean toMoveOut, et1.d animListener) {
        Animation loadAnimation;
        if (toMoveOut) {
            loadAnimation = AnimationUtils.loadAnimation(this.context, R.anim.f154585nt);
            loadAnimation.setFillAfter(true);
            loadAnimation.setAnimationListener(new et1.b(bottomBar, animListener));
        } else if (!toMoveOut) {
            loadAnimation = AnimationUtils.loadAnimation(this.context, R.anim.f154583nr);
            loadAnimation.setFillAfter(true);
            loadAnimation.setAnimationListener(new et1.a(bottomBar, animListener));
        } else {
            throw new NoWhenBranchMatchedException();
        }
        bottomBar.startAnimation(loadAnimation);
    }

    private final void b(View titleBar, boolean toMoveOut, et1.d animListener) {
        Animation loadAnimation;
        if (toMoveOut) {
            loadAnimation = AnimationUtils.loadAnimation(this.context, R.anim.f154586nu);
            loadAnimation.setFillAfter(true);
            loadAnimation.setAnimationListener(new f(titleBar, animListener));
        } else if (!toMoveOut) {
            loadAnimation = AnimationUtils.loadAnimation(this.context, R.anim.f154584ns);
            loadAnimation.setFillAfter(true);
            loadAnimation.setAnimationListener(new e(titleBar, animListener));
        } else {
            throw new NoWhenBranchMatchedException();
        }
        titleBar.startAnimation(loadAnimation);
    }

    public final void c(@NotNull View titleBar, @NotNull View bottomBar, @Nullable et1.d animListener) {
        Intrinsics.checkNotNullParameter(titleBar, "titleBar");
        Intrinsics.checkNotNullParameter(bottomBar, "bottomBar");
        b(titleBar, true, animListener);
        a(bottomBar, true, animListener);
    }

    public final void d(@NotNull View titleBar, @NotNull View bottomBar) {
        Intrinsics.checkNotNullParameter(titleBar, "titleBar");
        Intrinsics.checkNotNullParameter(bottomBar, "bottomBar");
        ViewGroup.LayoutParams layoutParams = titleBar.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.topMargin = -titleBar.getMeasuredHeight();
        titleBar.setLayoutParams(layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = bottomBar.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
        layoutParams4.bottomMargin = -bottomBar.getMeasuredHeight();
        bottomBar.setLayoutParams(layoutParams4);
    }

    public final void e(@NotNull View titleBar, @NotNull View bottomBar, @Nullable et1.d animListener) {
        Intrinsics.checkNotNullParameter(titleBar, "titleBar");
        Intrinsics.checkNotNullParameter(bottomBar, "bottomBar");
        b(titleBar, false, animListener);
        a(bottomBar, false, animListener);
    }

    public final void f(@NotNull View titleBar, @NotNull View bottomBar) {
        Intrinsics.checkNotNullParameter(titleBar, "titleBar");
        Intrinsics.checkNotNullParameter(bottomBar, "bottomBar");
        ViewGroup.LayoutParams layoutParams = titleBar.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.topMargin = 0;
        titleBar.setLayoutParams(layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = bottomBar.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
        layoutParams4.bottomMargin = 0;
        bottomBar.setLayoutParams(layoutParams4);
    }
}
