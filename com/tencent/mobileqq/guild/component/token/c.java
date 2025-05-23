package com.tencent.mobileqq.guild.component.token;

import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.animator.j;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u001c\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J\u001c\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/component/token/c;", "", "Landroid/view/View;", "view", "", "scale", "Lcom/tencent/mobileqq/guild/component/animator/j$c;", "listener", "", "a", "d", "b", "<init>", "()V", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f216020a = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/guild/component/token/c$a", "Lcom/tencent/mobileqq/guild/component/animator/j$a;", "Landroid/view/ViewPropertyAnimator;", "a", "b", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a extends j.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f216021d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f216022e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(View view, float f16) {
            super(view);
            this.f216021d = view;
            this.f216022e = f16;
        }

        @Override // com.tencent.mobileqq.guild.component.animator.j.a
        @NotNull
        public ViewPropertyAnimator a() {
            ViewPropertyAnimator animate = this.f216021d.animate();
            float f16 = this.f216022e;
            animate.scaleX(f16);
            animate.scaleY(f16);
            he0.b.l(animate, R.anim.f154977uk);
            Intrinsics.checkNotNullExpressionValue(animate, "view.animate().apply {\n \u2026derate)\n                }");
            return animate;
        }

        @Override // com.tencent.mobileqq.guild.component.animator.j.a
        @NotNull
        public ViewPropertyAnimator b() {
            ViewPropertyAnimator animate = this.f216021d.animate();
            animate.scaleX(1.0f);
            animate.scaleY(1.0f);
            he0.b.l(animate, R.anim.f154977uk);
            Intrinsics.checkNotNullExpressionValue(animate, "view.animate().apply {\n \u2026derate)\n                }");
            return animate;
        }
    }

    c() {
    }

    private final void a(View view, float scale, j.c listener) {
        j jVar = new j(view);
        jVar.o(listener);
        jVar.n(true);
        jVar.m(new a(view, scale));
    }

    @JvmStatic
    public static final void b(@NotNull View view, @Nullable j.c listener) {
        Intrinsics.checkNotNullParameter(view, "view");
        f216020a.a(view, 0.96f, listener);
    }

    public static /* synthetic */ void c(View view, j.c cVar, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            cVar = null;
        }
        b(view, cVar);
    }

    @JvmStatic
    public static final void d(@NotNull View view, @Nullable j.c listener) {
        Intrinsics.checkNotNullParameter(view, "view");
        f216020a.a(view, 0.9f, listener);
    }

    public static /* synthetic */ void e(View view, j.c cVar, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            cVar = null;
        }
        d(view, cVar);
    }
}
