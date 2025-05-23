package com.tencent.mobileqq.aio.utils;

import android.animation.Animator;
import android.content.Context;
import android.util.Size;
import android.widget.ImageView;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rlottie.AXrLottieDrawable;
import com.tencent.rlottie.OnLottieFrameListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J(\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006J8\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/aio/utils/ag;", "", "Lcom/airbnb/lottie/LottieAnimationView;", "animationView", "", "path", "Lkotlin/Function0;", "", "onAnimationEnd", "b", "Landroid/content/Context;", "context", "Landroid/widget/ImageView;", "imageView", "Landroid/util/Size;", "size", "e", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class ag {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ag f194106a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/aio/utils/ag$a", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "onAnimationStart", "onAnimationCancel", "onAnimationRepeat", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class a implements Animator.AnimatorListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f194107d;

        a(Function0<Unit> function0) {
            this.f194107d = function0;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            } else {
                this.f194107d.invoke();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animation);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/utils/ag$b", "Lcom/tencent/rlottie/OnLottieFrameListener;", "", "endAnimation", "", "onStopOnUi", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b extends OnLottieFrameListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f194108a;

        b(Function0<Unit> function0) {
            this.f194108a = function0;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function0);
            }
        }

        @Override // com.tencent.rlottie.OnLottieFrameListener
        public void onStopOnUi(boolean endAnimation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, endAnimation);
                return;
            }
            Function0<Unit> function0 = this.f194108a;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49830);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f194106a = new ag();
        }
    }

    ag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void c(ag agVar, LottieAnimationView lottieAnimationView, String str, Function0 function0, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            function0 = null;
        }
        agVar.b(lottieAnimationView, str, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(LottieAnimationView animationView, Function0 function0, LottieComposition lottieComposition) {
        Intrinsics.checkNotNullParameter(animationView, "$animationView");
        if (lottieComposition == null) {
            QLog.e("LottieAnimationUtil", 1, "composition is null, return");
            return;
        }
        animationView.setComposition(lottieComposition);
        if (function0 != null) {
            animationView.addAnimatorListener(new a(function0));
        }
        animationView.playAnimation();
        QLog.i("LottieAnimationUtil", 1, "playLottieAnimation");
    }

    public final void b(@NotNull final LottieAnimationView animationView, @NotNull String path, @Nullable final Function0<Unit> onAnimationEnd) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, animationView, path, onAnimationEnd);
            return;
        }
        Intrinsics.checkNotNullParameter(animationView, "animationView");
        Intrinsics.checkNotNullParameter(path, "path");
        try {
            LottieComposition.Factory.fromInputStream(new FileInputStream(new File(path)), new OnCompositionLoadedListener() { // from class: com.tencent.mobileqq.aio.utils.af
                @Override // com.airbnb.lottie.OnCompositionLoadedListener
                public final void onCompositionLoaded(LottieComposition lottieComposition) {
                    ag.d(LottieAnimationView.this, onAnimationEnd, lottieComposition);
                }
            });
        } catch (FileNotFoundException e16) {
            QLog.e("LottieAnimationUtil", 1, "file not found, path:" + path, e16);
        }
    }

    public final void e(@NotNull Context context, @NotNull ImageView imageView, @NotNull Size size, @NotNull String path, @Nullable Function0<Unit> onAnimationEnd) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, imageView, size, path, onAnimationEnd);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(path, "path");
        AXrLottieDrawable b16 = AXrLottieDrawable.U(context, new File(path)).i(size.getWidth(), size.getHeight()).f(true).h(false).d(1).b();
        b16.y0(new b(onAnimationEnd));
        imageView.setImageDrawable(b16);
        b16.start();
    }
}
