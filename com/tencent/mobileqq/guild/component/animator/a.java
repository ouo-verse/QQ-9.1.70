package com.tencent.mobileqq.guild.component.animator;

import android.animation.Animator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.animator.a;
import com.tencent.mobileqq.guild.component.token.AppearDirection;
import com.tencent.mobileqq.guild.component.token.AppearDistance;
import com.tencent.mobileqq.guild.component.token.AppearDuration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \u00162\u00020\u0001:\u0002\u0018\u001cB\u001d\b\u0000\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001b\u00a2\u0006\u0004\b'\u0010(J,\u0010\t\u001a\n \b*\u0004\u0018\u00010\u00070\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H\u0002J\u001a\u0010\u000b\u001a\n \b*\u0004\u0018\u00010\u00070\u00072\b\b\u0002\u0010\n\u001a\u00020\u0004H\u0002J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0012\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J8\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004J\u0010\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\n\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u0013R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR$\u0010#\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R$\u0010&\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b%\u0010\"\u001a\u0004\b&\u0010$\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/guild/component/animator/a;", "", "Lcom/tencent/mobileqq/guild/component/token/AppearDuration;", "appearDuration", "", "showTimeMs", "disappearDurationMs", "Landroid/view/ViewPropertyAnimator;", "kotlin.jvm.PlatformType", "g", "durationHide", "f", "Lcom/tencent/mobileqq/guild/component/token/AppearDirection;", "appearDirection", "Lcom/tencent/mobileqq/guild/component/token/AppearDistance;", "appearDistance", "", tl.h.F, "i", "", "k", "j", "e", "Landroid/view/View;", "a", "Landroid/view/View;", "view", "Lcom/tencent/mobileqq/guild/component/animator/a$a;", "b", "Lcom/tencent/mobileqq/guild/component/animator/a$a;", "listener", "", "<set-?>", "c", "Z", "isShowRunning", "()Z", "d", "isHideRunning", "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/guild/component/animator/a$a;)V", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View view;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final AbstractC7700a listener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isShowRunning;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isHideRunning;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f215583a;

        static {
            int[] iArr = new int[AppearDirection.values().length];
            try {
                iArr[AppearDirection.LEFT_TO_RIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AppearDirection.RIGHT_TO_LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AppearDirection.TOP_TO_BOTTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AppearDirection.BOTTOM_TO_TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f215583a = iArr;
        }
    }

    public a(@NotNull View view, @Nullable AbstractC7700a abstractC7700a) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        this.listener = abstractC7700a;
    }

    private final ViewPropertyAnimator f(long durationHide) {
        ViewPropertyAnimator animate = this.view.animate();
        animate.alpha(0.0f);
        animate.setDuration(durationHide);
        animate.setListener(new d());
        return animate;
    }

    private final ViewPropertyAnimator g(AppearDuration appearDuration, long showTimeMs, long disappearDurationMs) {
        long j3;
        ViewPropertyAnimator animate = this.view.animate();
        animate.alpha(1.0f);
        animate.translationX(0.0f);
        animate.translationY(0.0f);
        if (appearDuration == AppearDuration.MS_150) {
            he0.b.l(animate, R.anim.f154977uk);
            j3 = 150;
        } else {
            he0.b.m(animate, R.anim.f154977uk, 2.0f);
            j3 = 300;
        }
        animate.setDuration(j3);
        animate.setListener(new e(showTimeMs, disappearDurationMs));
        return animate;
    }

    private final int h(AppearDirection appearDirection, AppearDistance appearDistance) {
        int i3 = c.f215583a[appearDirection.ordinal()];
        float f16 = 20.0f;
        if (i3 != 1) {
            if (i3 != 2) {
                return 0;
            }
            kotlin.g gVar = kotlin.g.f433789a;
            if (appearDistance != AppearDistance.PX_60) {
                f16 = 40.0f;
            }
            Resources resources = this.view.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "view.resources");
            return gVar.b(f16, resources);
        }
        kotlin.g gVar2 = kotlin.g.f433789a;
        if (appearDistance != AppearDistance.PX_60) {
            f16 = 40.0f;
        }
        Resources resources2 = this.view.getResources();
        Intrinsics.checkNotNullExpressionValue(resources2, "view.resources");
        return -gVar2.b(f16, resources2);
    }

    private final int i(AppearDirection appearDirection, AppearDistance appearDistance) {
        int i3 = c.f215583a[appearDirection.ordinal()];
        float f16 = 20.0f;
        if (i3 != 3) {
            if (i3 != 4) {
                return 0;
            }
            kotlin.g gVar = kotlin.g.f433789a;
            if (appearDistance != AppearDistance.PX_60) {
                f16 = 40.0f;
            }
            Resources resources = this.view.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "view.resources");
            return gVar.b(f16, resources);
        }
        kotlin.g gVar2 = kotlin.g.f433789a;
        if (appearDistance != AppearDistance.PX_60) {
            f16 = 40.0f;
        }
        Resources resources2 = this.view.getResources();
        Intrinsics.checkNotNullExpressionValue(resources2, "view.resources");
        return -gVar2.b(f16, resources2);
    }

    public final void e() {
        if (this.isShowRunning || this.isHideRunning) {
            this.view.animate().cancel();
        }
    }

    public final void j(long durationHide) {
        f(durationHide).start();
    }

    public final void k(@NotNull AppearDirection appearDirection, @NotNull AppearDistance appearDistance, @NotNull AppearDuration appearDuration, long showTimeMs, long disappearDurationMs) {
        Intrinsics.checkNotNullParameter(appearDirection, "appearDirection");
        Intrinsics.checkNotNullParameter(appearDistance, "appearDistance");
        Intrinsics.checkNotNullParameter(appearDuration, "appearDuration");
        this.view.setAlpha(0.0f);
        this.view.setTranslationX(h(appearDirection, appearDistance));
        this.view.setTranslationY(i(appearDirection, appearDistance));
        g(appearDuration, showTimeMs, disappearDurationMs).start();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/component/animator/a$a;", "", "", "d", "c", "b", "a", "<init>", "()V", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.component.animator.a$a, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static abstract class AbstractC7700a {
        public void a() {
        }

        public void b() {
        }

        public void c() {
        }

        public void d() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/component/animator/a$d", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class d implements Animator.AnimatorListener {
        d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            a.this.view.setAlpha(0.0f);
            a.this.view.invalidate();
            a.this.isHideRunning = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            AbstractC7700a abstractC7700a = a.this.listener;
            if (abstractC7700a != null) {
                abstractC7700a.a();
            }
            a.this.isHideRunning = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            AbstractC7700a abstractC7700a = a.this.listener;
            if (abstractC7700a != null) {
                abstractC7700a.b();
            }
            a.this.isShowRunning = false;
            a.this.isHideRunning = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/component/animator/a$e", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class e implements Animator.AnimatorListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f215586e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f215587f;

        e(long j3, long j16) {
            this.f215586e = j3;
            this.f215587f = j16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(a this$0, long j3) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.j(j3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(a this$0, long j3) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.j(j3);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            a.this.view.setAlpha(1.0f);
            a.this.view.setTranslationX(0.0f);
            a.this.view.setTranslationY(0.0f);
            a.this.view.invalidate();
            a.this.isShowRunning = false;
            if (this.f215586e > 0) {
                View view = a.this.view;
                final a aVar = a.this;
                final long j3 = this.f215587f;
                view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.component.animator.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.e.c(a.this, j3);
                    }
                }, this.f215586e);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            AbstractC7700a abstractC7700a = a.this.listener;
            if (abstractC7700a != null) {
                abstractC7700a.c();
            }
            a.this.isShowRunning = false;
            if (this.f215586e > 0) {
                View view = a.this.view;
                final a aVar = a.this;
                final long j3 = this.f215587f;
                view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.component.animator.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.e.d(a.this, j3);
                    }
                }, this.f215586e);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            AbstractC7700a abstractC7700a = a.this.listener;
            if (abstractC7700a != null) {
                abstractC7700a.d();
            }
            a.this.isHideRunning = false;
            a.this.isShowRunning = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
        }
    }
}
