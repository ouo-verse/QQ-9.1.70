package com.tencent.timi.game.ui.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yn4.b;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\u0007H&J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014J\b\u0010\r\u001a\u00020\u0002H\u0004J\b\u0010\u000e\u001a\u00020\u0002H\u0004R\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/timi/game/ui/widget/s;", "Lcom/tencent/timi/game/ui/widget/j;", "", "superDismiss", "Ljava/lang/Runnable;", "action", "c0", "Landroid/view/View;", "e0", "Y", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "f0", "Z", "", "I", "J", "getAnimDuration", "()J", "setAnimDuration", "(J)V", "animDuration", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public abstract class s extends j {

    /* renamed from: I, reason: from kotlin metadata */
    private long animDuration;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/timi/game/ui/widget/s$a", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            s.this.superDismiss();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(@NotNull Context context) {
        super(context, R.style.f173905av2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.animDuration = 500L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(final View contentView, final s this$0, final View shadowView) {
        Intrinsics.checkNotNullParameter(contentView, "$contentView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(shadowView, "$shadowView");
        final int height = contentView.getHeight();
        contentView.setTranslationY(0.0f);
        contentView.setVisibility(0);
        this$0.c0(new Runnable() { // from class: com.tencent.timi.game.ui.widget.r
            @Override // java.lang.Runnable
            public final void run() {
                s.b0(contentView, height, this$0, shadowView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(View contentView, int i3, s this$0, View shadowView) {
        Intrinsics.checkNotNullParameter(contentView, "$contentView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(shadowView, "$shadowView");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(contentView, "translationY", 0.0f, i3);
        ofFloat.addListener(new a());
        ofFloat.setInterpolator(b.f.f450694b);
        ofFloat.setDuration(this$0.animDuration);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(shadowView, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        ofFloat2.setDuration(this$0.animDuration);
        ofFloat2.setInterpolator(b.f.f450694b);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat);
        animatorSet.play(ofFloat2);
        animatorSet.start();
    }

    private final void c0(final Runnable action) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.timi.game.ui.widget.q
            @Override // java.lang.Runnable
            public final void run() {
                s.d0(action);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(Runnable action) {
        Intrinsics.checkNotNullParameter(action, "$action");
        action.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(final View shadowView, final View contentView, final s this$0) {
        Intrinsics.checkNotNullParameter(shadowView, "$shadowView");
        Intrinsics.checkNotNullParameter(contentView, "$contentView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        shadowView.setAlpha(0.0f);
        final int height = contentView.getHeight();
        contentView.setTranslationY(height);
        contentView.setVisibility(0);
        this$0.c0(new Runnable() { // from class: com.tencent.timi.game.ui.widget.p
            @Override // java.lang.Runnable
            public final void run() {
                s.i0(contentView, height, this$0, shadowView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(View contentView, int i3, s this$0, View shadowView) {
        Intrinsics.checkNotNullParameter(contentView, "$contentView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(shadowView, "$shadowView");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(contentView, "translationY", i3, 0.0f);
        ofFloat.setDuration(this$0.animDuration);
        ofFloat.setInterpolator(b.f.f450694b);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(shadowView, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ofFloat2.setDuration(this$0.animDuration);
        ofFloat2.setInterpolator(b.f.f450694b);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat);
        animatorSet.play(ofFloat2);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void superDismiss() {
        super.dismiss();
    }

    @NotNull
    public abstract View Y();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Z() {
        final View e06 = e0();
        final View Y = Y();
        c0(new Runnable() { // from class: com.tencent.timi.game.ui.widget.n
            @Override // java.lang.Runnable
            public final void run() {
                s.a0(Y, this, e06);
            }
        });
    }

    @NotNull
    public abstract View e0();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void f0() {
        final View e06 = e0();
        final View Y = Y();
        c0(new Runnable() { // from class: com.tencent.timi.game.ui.widget.o
            @Override // java.lang.Runnable
            public final void run() {
                s.g0(e06, Y, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.ui.widget.j, android.app.Dialog
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        if (window != null) {
            window.addFlags(Integer.MIN_VALUE);
        }
        com.tencent.timi.game.utils.u.e(getWindow());
    }
}
