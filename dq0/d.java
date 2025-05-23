package dq0;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import dq0.d;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Ldq0/d;", "Ldq0/f;", "Landroid/view/View;", "view", "", "a", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class d implements f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private static WeakReference<ValueAnimator> f394580b;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Ldq0/d$a;", "", "Landroid/view/View;", "view", "", "b", "c", "", "ALPHA_END", UserInfo.SEX_FEMALE, "ALPHA_START", "", "FIRST_ANIM_DURATION", "J", "SECOND_ANIM_DELAY_TIME", "SECOND_ANIM_DURATION", "", "TAG", "Ljava/lang/String;", "Ljava/lang/ref/WeakReference;", "Landroid/animation/ValueAnimator;", "mOriginAnimator", "Ljava/lang/ref/WeakReference;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: dq0.d$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"dq0/d$a$a", "Lcom/tencent/mobileqq/widget/f;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: dq0.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C10198a extends com.tencent.mobileqq.widget.f {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ View f394581d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ View f394582e;

            C10198a(View view, View view2) {
                this.f394581d = view;
                this.f394582e = view2;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@NotNull Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.f394581d.setTag(R.id.w3f, null);
            }

            @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NotNull Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.f394581d.setTag(R.id.w3f, null);
                if (this.f394582e.getParent() != null) {
                    this.f394582e.clearAnimation();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@NotNull Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NotNull Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final float d(float f16) {
            if (f16 < 0.25f) {
                return f16 / 0.25f;
            }
            if (f16 <= 0.5833334f) {
                return 1.0f;
            }
            return (1 - f16) / 0.41666666f;
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            Animator animator = (Animator) view.getTag(R.id.w3f);
            if (animator == null) {
                return;
            }
            animator.cancel();
        }

        public final void c(@NotNull View view) {
            ValueAnimator valueAnimator;
            Intrinsics.checkNotNullParameter(view, "view");
            View findViewById = view.findViewById(R.id.wri);
            if (findViewById != null) {
                WeakReference weakReference = d.f394580b;
                if (weakReference != null && (valueAnimator = (ValueAnimator) weakReference.get()) != null) {
                    valueAnimator.cancel();
                }
                findViewById.setBackgroundResource(R.drawable.guild_live_channel_reply_hightlight_bg);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(findViewById, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
                Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(highLightView, \"\u2026, ALPHA_START, ALPHA_END)");
                ofFloat.setDuration(1200L);
                ofFloat.setInterpolator(new TimeInterpolator() { // from class: dq0.c
                    @Override // android.animation.TimeInterpolator
                    public final float getInterpolation(float f16) {
                        float d16;
                        d16 = d.Companion.d(f16);
                        return d16;
                    }
                });
                ofFloat.addListener(new C10198a(view, findViewById));
                view.setTag(R.id.w3f, ofFloat);
                d.f394580b = new WeakReference(ofFloat);
                ofFloat.start();
            }
        }

        Companion() {
        }
    }

    @Override // dq0.f
    public void a(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        INSTANCE.c(view);
    }
}
