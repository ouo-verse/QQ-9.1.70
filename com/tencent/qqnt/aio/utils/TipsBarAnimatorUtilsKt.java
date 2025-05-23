package com.tencent.qqnt.aio.utils;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a'\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u001b\b\u0002\u0010\u0005\u001a\u0015\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0001\u00a2\u0006\u0002\b\u0004\u001a'\u0010\u0007\u001a\u00020\u0003*\u00020\u00002\u001b\b\u0002\u0010\u0005\u001a\u0015\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0001\u00a2\u0006\u0002\b\u0004\u001aN\u0010\u000b\u001a\u00020\u0003*\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u00002\u001b\b\u0002\u0010\t\u001a\u0015\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0001\u00a2\u0006\u0002\b\u00042\u001b\b\u0002\u0010\n\u001a\u0015\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0001\u00a2\u0006\u0002\b\u0004\u00a8\u0006\f"}, d2 = {"Landroid/view/View;", "Lkotlin/Function1;", "Lcom/tencent/qqnt/aio/utils/ag;", "", "Lkotlin/ExtensionFunctionType;", "init", "c", "a", "replaceView", "hideBlock", "showBlock", "b", "aio_kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class TipsBarAnimatorUtilsKt {
    public static final void a(@NotNull final View view, @Nullable Function1<? super ag, Unit> function1) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        ag agVar = new ag();
        if (function1 != null) {
            function1.invoke(agVar);
        }
        agVar.c(new Function0<Animator>(view) { // from class: com.tencent.qqnt.aio.utils.TipsBarAnimatorUtilsKt$hideTipsBarAnimator$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ View $this_hideTipsBarAnimator;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$this_hideTipsBarAnimator = view;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Animator invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Animator) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.$this_hideTipsBarAnimator, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
                he0.b.l(ofFloat, R.anim.f154982up);
                Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(this@hideTipsBar\u2026inear_fast)\n            }");
                return ofFloat;
            }
        });
        agVar.f();
    }

    public static final void b(@NotNull final View view, @Nullable final View view2, @Nullable Function1<? super ag, Unit> function1, @Nullable Function1<? super ag, Unit> function12) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (view2 == null) {
            return;
        }
        ag agVar = new ag();
        if (function1 != null) {
            function1.invoke(agVar);
        }
        agVar.c(new Function0<Animator>(view) { // from class: com.tencent.qqnt.aio.utils.TipsBarAnimatorUtilsKt$replaceTipsBarAnimator$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ View $this_replaceTipsBarAnimator;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$this_replaceTipsBarAnimator = view;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Animator invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Animator) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.$this_replaceTipsBarAnimator, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
                he0.b.l(ofFloat, R.anim.f154982up);
                Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(this@replaceTips\u2026inear_fast)\n            }");
                return ofFloat;
            }
        });
        agVar.f();
        ag agVar2 = new ag();
        if (function12 != null) {
            function12.invoke(agVar2);
        }
        agVar2.c(new Function0<Animator>(view2) { // from class: com.tencent.qqnt.aio.utils.TipsBarAnimatorUtilsKt$replaceTipsBarAnimator$2$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ View $replaceView;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$replaceView = view2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) view2);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Animator invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Animator) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.$replaceView, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
                he0.b.l(ofFloat, R.anim.f154982up);
                ofFloat.setStartDelay(50L);
                Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(replaceView, \"al\u2026tDelay = 50\n            }");
                return ofFloat;
            }
        });
        agVar2.f();
    }

    public static final void c(@NotNull final View view, @Nullable Function1<? super ag, Unit> function1) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        ag agVar = new ag();
        if (function1 != null) {
            function1.invoke(agVar);
        }
        agVar.c(new Function0<Animator>(view) { // from class: com.tencent.qqnt.aio.utils.TipsBarAnimatorUtilsKt$showTipsBarAnimator$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ View $this_showTipsBarAnimator;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$this_showTipsBarAnimator = view;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Animator invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Animator) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.$this_showTipsBarAnimator, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
                he0.b.l(ofFloat, R.anim.f154982up);
                Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(this@showTipsBar\u2026inear_fast)\n            }");
                return ofFloat;
            }
        });
        agVar.f();
    }
}
