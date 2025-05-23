package as1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B_\u0012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u000e\u0012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u000e\u0012\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u000e\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u0016\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0016\u00a2\u0006\u0004\b\u001f\u0010 J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\r\u001a\u00020\u0006R \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0010R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0018R\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001d\u00a8\u0006!"}, d2 = {"Las1/c;", "", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", h.F, "holder", "", "e", "", "f", "j", "g", "k", "i", "Lkotlin/Function1;", "a", "Lkotlin/jvm/functions/Function1;", "dispatchRemoveStarting", "b", "dispatchRemoveFinished", "c", "resetAnimation", "Lkotlin/Function0;", "d", "Lkotlin/jvm/functions/Function0;", "dispatchFinishedWhenDone", "", "removeDuration", "Ljava/util/ArrayList;", "Ljava/util/ArrayList;", "mRemoveAnimations", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<RecyclerView.ViewHolder, Unit> dispatchRemoveStarting;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<RecyclerView.ViewHolder, Unit> dispatchRemoveFinished;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<RecyclerView.ViewHolder, Unit> resetAnimation;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Unit> dispatchFinishedWhenDone;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Long> removeDuration;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<RecyclerView.ViewHolder> mRemoveAnimations;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"as1/c$a", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animator", "", "onAnimationStart", "onAnimationEnd", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a extends AnimatorListenerAdapter {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ RecyclerView.ViewHolder f26871e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f26872f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ View f26873h;

        a(RecyclerView.ViewHolder viewHolder, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f26871e = viewHolder;
            this.f26872f = viewPropertyAnimator;
            this.f26873h = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            this.f26872f.setListener(null);
            this.f26873h.setScaleX(1.0f);
            this.f26873h.setScaleY(1.0f);
            c.this.dispatchRemoveFinished.invoke(this.f26871e);
            c.this.mRemoveAnimations.remove(this.f26871e);
            c.this.dispatchFinishedWhenDone.invoke();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            c.this.dispatchRemoveStarting.invoke(this.f26871e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(@NotNull Function1<? super RecyclerView.ViewHolder, Unit> dispatchRemoveStarting, @NotNull Function1<? super RecyclerView.ViewHolder, Unit> dispatchRemoveFinished, @NotNull Function1<? super RecyclerView.ViewHolder, Unit> resetAnimation, @NotNull Function0<Unit> dispatchFinishedWhenDone, @NotNull Function0<Long> removeDuration) {
        Intrinsics.checkNotNullParameter(dispatchRemoveStarting, "dispatchRemoveStarting");
        Intrinsics.checkNotNullParameter(dispatchRemoveFinished, "dispatchRemoveFinished");
        Intrinsics.checkNotNullParameter(resetAnimation, "resetAnimation");
        Intrinsics.checkNotNullParameter(dispatchFinishedWhenDone, "dispatchFinishedWhenDone");
        Intrinsics.checkNotNullParameter(removeDuration, "removeDuration");
        this.dispatchRemoveStarting = dispatchRemoveStarting;
        this.dispatchRemoveFinished = dispatchRemoveFinished;
        this.resetAnimation = resetAnimation;
        this.dispatchFinishedWhenDone = dispatchFinishedWhenDone;
        this.removeDuration = removeDuration;
        this.mRemoveAnimations = new ArrayList<>();
    }

    private final View h(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof fs1.b) {
            View v3 = ((fs1.b) viewHolder).v();
            Intrinsics.checkNotNullExpressionValue(v3, "{\n            this.animationView\n        }");
            return v3;
        }
        View view = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "{\n            this.itemView\n        }");
        return view;
    }

    public final boolean e(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof fs1.b) {
            ((fs1.b) holder).J();
        }
        this.resetAnimation.invoke(holder);
        return true;
    }

    public final void f(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        View h16 = h(holder);
        ViewPropertyAnimator animate = h16.animate();
        this.mRemoveAnimations.add(holder);
        animate.setDuration(this.removeDuration.invoke().longValue()).scaleX(0.0f).scaleY(0.0f).setListener(new a(holder, animate, h16)).start();
    }

    public final void g() {
        int size = this.mRemoveAnimations.size() - 1;
        if (size < 0) {
            return;
        }
        while (true) {
            int i3 = size - 1;
            RecyclerView.ViewHolder viewHolder = this.mRemoveAnimations.get(size);
            Intrinsics.checkNotNullExpressionValue(viewHolder, "mRemoveAnimations[i]");
            h(viewHolder).animate().cancel();
            if (i3 >= 0) {
                size = i3;
            } else {
                return;
            }
        }
    }

    public final boolean i() {
        return !this.mRemoveAnimations.isEmpty();
    }

    public final void j(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        View h16 = h(holder);
        h16.setScaleX(1.0f);
        h16.setScaleY(1.0f);
    }

    public final boolean k(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        return this.mRemoveAnimations.remove(holder);
    }
}
