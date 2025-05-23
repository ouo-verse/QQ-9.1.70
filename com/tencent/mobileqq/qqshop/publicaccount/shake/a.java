package com.tencent.mobileqq.qqshop.publicaccount.shake;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.tencent.mobileqq.ecshop.conf.EcshopConfBean;
import com.tencent.mobileqq.ecshop.conf.EcshopConfUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqshop.publicaccount.adapter.p;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bJ\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qqshop/publicaccount/shake/a;", "", "Lcom/tencent/mobileqq/qqshop/publicaccount/adapter/p;", "headCardModel", "", "a", "Landroid/view/View;", "view", "", "duration", "", "b", "", "sec", "d", "<init>", "()V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f274656a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qqshop/publicaccount/shake/a$a", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqshop.publicaccount.shake.a$a, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public static final class AnimationAnimationListenerC8429a implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f274657d;

        AnimationAnimationListenerC8429a(View view) {
            this.f274657d = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@NotNull Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            } else {
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.f274657d.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@NotNull Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            } else {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@NotNull Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            } else {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34044);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f274656a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ void c(a aVar, View view, long j3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j3 = 300;
        }
        aVar.b(view, j3);
    }

    public final boolean a(@NotNull p headCardModel) {
        boolean z16;
        EcshopConfBean.ShakeAdEffectBean shakeAdEffectBean;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) headCardModel)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(headCardModel, "headCardModel");
        EcshopConfBean ecshopConfBean = EcshopConfUtil.getEcshopConfBean();
        if (ecshopConfBean != null && (shakeAdEffectBean = ecshopConfBean.shakeAdEffectBean) != null && shakeAdEffectBean.isValid()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && -1 != com.tencent.mobileqq.ecshop.view.adcard.gift.a.f203960a.a(com.tencent.mobileqq.ecshop.ad.a.l(headCardModel.a()))) {
            return true;
        }
        return false;
    }

    public final void b(@NotNull View view, long duration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, view, Long.valueOf(duration));
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(duration);
        alphaAnimation.setAnimationListener(new AnimationAnimationListenerC8429a(view));
        view.startAnimation(alphaAnimation);
    }

    public final long d(double sec) {
        long roundToLong;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            roundToLong = MathKt__MathJVMKt.roundToLong(sec * 1000);
            return roundToLong;
        }
        return ((Long) iPatchRedirector.redirect((short) 4, this, Double.valueOf(sec))).longValue();
    }
}
