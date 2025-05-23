package dq0;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.view.View;
import com.tencent.mobileqq.R;
import dq0.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Ldq0/b;", "Ldq0/f;", "Landroid/view/View;", "view", "", "a", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b implements f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J4\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nR\u0014\u0010\r\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Ldq0/b$a;", "", "Landroid/view/View;", "view", "", "b", "", "duration", "", "repeatCount", "Lkotlin/Function0;", "afterAnimationEnd", "c", "BLINK_ANIM_DELAY_TIME", "J", "BLINK_ANIM_DURATION", "ORIGIN_ANIM_DURATION", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: dq0.b$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"dq0/b$a$a", "Lcom/tencent/mobileqq/widget/f;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: dq0.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C10197a extends com.tencent.mobileqq.widget.f {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ View f394576d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f394577e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ Function0<Unit> f394578f;

            C10197a(View view, int i3, Function0<Unit> function0) {
                this.f394576d = view;
                this.f394577e = i3;
                this.f394578f = function0;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@NotNull Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.f394576d.setBackgroundColor(this.f394577e);
                this.f394576d.setTag(R.id.w3f, null);
            }

            @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NotNull Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.f394576d.setBackgroundColor(this.f394577e);
                this.f394576d.setTag(R.id.w3f, null);
                Function0<Unit> function0 = this.f394578f;
                if (function0 != null) {
                    function0.invoke();
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

        public static /* synthetic */ void d(Companion companion, View view, long j3, int i3, Function0 function0, int i16, Object obj) {
            if ((i16 & 2) != 0) {
                j3 = 1200;
            }
            long j16 = j3;
            if ((i16 & 4) != 0) {
                i3 = 0;
            }
            int i17 = i3;
            if ((i16 & 8) != 0) {
                function0 = null;
            }
            companion.c(view, j16, i17, function0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final float e(float f16) {
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

        public final void c(@NotNull View view, long duration, int repeatCount, @Nullable Function0<Unit> afterAnimationEnd) {
            Intrinsics.checkNotNullParameter(view, "view");
            b(view);
            int color = view.getResources().getColor(R.color.qui_common_brand_light);
            int color2 = view.getResources().getColor(R.color.box);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(view, "backgroundColor", color2, color);
            Intrinsics.checkNotNullExpressionValue(ofInt, "ofInt(view, \"backgroundC\u2026sparentColor, blinkColor)");
            ofInt.setDuration(duration);
            ofInt.setEvaluator(new ArgbEvaluator());
            ofInt.setInterpolator(new TimeInterpolator() { // from class: dq0.a
                @Override // android.animation.TimeInterpolator
                public final float getInterpolation(float f16) {
                    float e16;
                    e16 = b.Companion.e(f16);
                    return e16;
                }
            });
            ofInt.addListener(new C10197a(view, color2, afterAnimationEnd));
            view.setTag(R.id.w3f, ofInt);
            ofInt.setRepeatCount(repeatCount);
            ofInt.start();
        }

        Companion() {
        }
    }

    @Override // dq0.f
    public void a(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Companion.d(INSTANCE, view, 0L, 0, null, 14, null);
    }
}
