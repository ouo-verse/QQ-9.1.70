package com.tencent.adelie.av.ui;

import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import com.airbnb.lottie.LottieDrawable;
import com.tencent.adelie.av.ui.AdelieAVControlUI;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes37.dex */
public class c implements Animation.AnimationListener {
    public static boolean N = false;
    private View C;
    private View D;
    private View E;
    private View F;
    private View G;
    private LottieDrawable H = null;
    private AlphaAnimation I = null;
    private AlphaAnimation J = null;
    private WeakReference<Context> K;
    private boolean L;
    private AdelieAVControlUI.h M;

    /* renamed from: d, reason: collision with root package name */
    private AnimationSet f61559d;

    /* renamed from: e, reason: collision with root package name */
    private AnimationSet f61560e;

    /* renamed from: f, reason: collision with root package name */
    private View f61561f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f61562h;

    /* renamed from: i, reason: collision with root package name */
    private View f61563i;

    /* renamed from: m, reason: collision with root package name */
    private View f61564m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b implements LottieHelper.d {
        b() {
        }

        @Override // com.tencent.mobileqq.onlinestatus.utils.LottieHelper.d
        public void onLoad(LottieDrawable lottieDrawable) {
            QLog.d("AdelieAVInviteAnimation", 1, "loadWaveLottie " + lottieDrawable);
            c.this.H = lottieDrawable;
            c.this.f61562h.setImageDrawable(lottieDrawable);
            c.this.H.start();
            QLog.d("AdelieAVInviteAnimation", 1, "updateWaveLottie start " + c.this.f61562h.getVisibility());
        }
    }

    public c(Context context, boolean z16, View view, ImageView imageView, View view2, View view3, View view4, View view5, View view6, View view7, View view8) {
        this.f61561f = view;
        this.f61562h = imageView;
        this.K = new WeakReference<>(context);
        this.L = z16;
        this.f61563i = view2;
        this.f61564m = view3;
        this.C = view4;
        this.D = view5;
        this.E = view6;
        this.F = view7;
        this.G = view8;
    }

    private void m() {
        r();
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(200L);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setFillEnabled(true);
        scaleAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        if (this.I == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            this.I = alphaAnimation;
            alphaAnimation.setDuration(500L);
            this.I.setFillAfter(true);
            this.I.setFillEnabled(true);
        }
        AnimationSet animationSet = new AnimationSet(false);
        this.f61560e = animationSet;
        animationSet.addAnimation(scaleAnimation);
        this.f61560e.addAnimation(this.I);
        this.f61560e.setDuration(500L);
        this.f61560e.setFillAfter(true);
        this.f61560e.setFillEnabled(true);
        this.f61560e.setAnimationListener(new a());
        View view = this.f61563i;
        if (view != null) {
            view.startAnimation(this.I);
        }
        View view2 = this.f61564m;
        if (view2 != null) {
            view2.startAnimation(this.I);
        }
        if (this.J == null) {
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
            this.J = alphaAnimation2;
            alphaAnimation2.setDuration(500L);
            this.J.setFillAfter(true);
            this.J.setFillEnabled(true);
        }
        if (!this.L) {
            this.f61561f.startAnimation(this.f61560e);
            View view3 = this.C;
            if (view3 != null) {
                view3.startAnimation(this.I);
            }
            View view4 = this.E;
            if (view4 != null) {
                view4.setVisibility(0);
                this.E.startAnimation(this.J);
            }
            View view5 = this.D;
            if (view5 != null) {
                view5.setVisibility(0);
                this.D.startAnimation(this.J);
            }
        }
        View view6 = this.F;
        if (view6 != null) {
            view6.setVisibility(0);
            this.F.startAnimation(this.J);
        }
        View view7 = this.G;
        if (view7 != null) {
            view7.setVisibility(0);
            this.G.startAnimation(this.J);
        }
    }

    private void n() {
        if (!this.L) {
            this.f61561f.setVisibility(8);
            this.C.setVisibility(8);
            View view = this.E;
            if (view != null) {
                view.setVisibility(0);
            }
            View view2 = this.D;
            if (view2 != null) {
                view2.setVisibility(0);
            }
        }
        this.f61563i.setVisibility(8);
        this.f61564m.setVisibility(8);
        AdelieAVControlUI.h hVar = this.M;
        if (hVar != null) {
            hVar.a();
        }
        View view3 = this.F;
        if (view3 != null) {
            view3.setVisibility(0);
        }
        View view4 = this.G;
        if (view4 != null) {
            view4.setVisibility(0);
        }
        ImageView imageView = this.f61562h;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    private void q() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(200L);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setFillEnabled(true);
        this.f61562h.startAnimation(alphaAnimation);
    }

    private void s(boolean z16) {
        QLog.d("AdelieAVInviteAnimation", 1, "updateWaveLottie " + z16);
        if (z16) {
            LottieDrawable lottieDrawable = this.H;
            if (lottieDrawable == null) {
                int dimensionPixelSize = this.K.get().getResources().getDimensionPixelSize(R.dimen.f12838j);
                LottieHelper.b(BaseApplication.getContext(), "sound_wave_animation.json", null, dimensionPixelSize, dimensionPixelSize, 0, new b());
            } else {
                if (lottieDrawable != null && lottieDrawable.isRunning()) {
                    this.H.stop();
                }
                this.H.start();
                QLog.d("AdelieAVInviteAnimation", 1, "updateWaveLottie start");
            }
            if (this.f61562h.getVisibility() != 0) {
                this.f61562h.setVisibility(0);
                return;
            }
            return;
        }
        LottieDrawable lottieDrawable2 = this.H;
        if (lottieDrawable2 != null && lottieDrawable2.isRunning()) {
            this.H.stop();
        }
        this.f61562h.setVisibility(8);
    }

    public void j(boolean z16) {
        this.L = z16;
    }

    public void k(AdelieAVControlUI.h hVar) {
        this.M = hVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        if (N) {
            o(true);
            N = false;
            this.M.b();
        } else {
            AnimationSet animationSet = this.f61559d;
            if (animationSet != null) {
                animationSet.cancel();
                this.f61559d = null;
            }
            View view = this.f61561f;
            if (view != null) {
                view.clearAnimation();
            }
            p();
        }
        QLog.d("AdelieAVInviteAnimation", 1, "startInvitingAnim onAnimationEnd " + animation + " mReadyToShowConnectAnim=" + N);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
        QLog.d("AdelieAVInviteAnimation", 1, "startInvitingAnim onAnimationRepeat " + animation);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        QLog.d("AdelieAVInviteAnimation", 1, "startInvitingAnim onAnimationStart " + animation);
    }

    public void p() {
        if (this.f61559d == null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.86f, 1.0f, 0.86f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(500L);
            scaleAnimation.setFillAfter(true);
            scaleAnimation.setFillEnabled(true);
            scaleAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 1.1628f, 1.0f, 1.1628f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setStartOffset(500L);
            scaleAnimation2.setDuration(500L);
            scaleAnimation2.setFillAfter(true);
            scaleAnimation2.setFillEnabled(true);
            scaleAnimation2.setInterpolator(new AccelerateDecelerateInterpolator());
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 1.0f);
            alphaAnimation.setDuration(500L);
            alphaAnimation.setStartOffset(1000L);
            alphaAnimation.setAnimationListener(this);
            AnimationSet animationSet = new AnimationSet(false);
            this.f61559d = animationSet;
            animationSet.addAnimation(scaleAnimation);
            this.f61559d.addAnimation(scaleAnimation2);
            this.f61559d.addAnimation(alphaAnimation);
            this.f61559d.setFillAfter(true);
            this.f61559d.setFillEnabled(true);
        }
        this.f61561f.setVisibility(0);
        this.f61561f.startAnimation(this.f61559d);
        QLog.d("AdelieAVInviteAnimation", 1, "startInvitingAnim.");
        s(true);
        q();
    }

    public void r() {
        AnimationSet animationSet = this.f61559d;
        if (animationSet != null) {
            animationSet.setAnimationListener(null);
            this.f61559d.cancel();
        }
        LottieDrawable lottieDrawable = this.H;
        if (lottieDrawable != null) {
            lottieDrawable.stop();
        }
        ImageView imageView = this.f61562h;
        if (imageView != null) {
            imageView.clearAnimation();
            this.f61562h.setVisibility(8);
        }
        View view = this.f61561f;
        if (view != null) {
            view.clearAnimation();
        }
    }

    public void i() {
        QLog.d("AdelieAVInviteAnimation", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        AnimationSet animationSet = this.f61559d;
        if (animationSet != null) {
            animationSet.cancel();
            this.f61559d.setAnimationListener(null);
            this.f61559d = null;
        }
        LottieDrawable lottieDrawable = this.H;
        if (lottieDrawable != null) {
            lottieDrawable.stop();
            this.H.removeAllAnimatorListeners();
            this.H.clearComposition();
            this.H = null;
        }
        AlphaAnimation alphaAnimation = this.J;
        if (alphaAnimation != null) {
            alphaAnimation.setAnimationListener(null);
            this.J.cancel();
            this.J = null;
        }
        AnimationSet animationSet2 = this.f61560e;
        if (animationSet2 != null) {
            animationSet2.cancel();
            this.f61560e.setAnimationListener(null);
            this.f61560e = null;
        }
        AlphaAnimation alphaAnimation2 = this.I;
        if (alphaAnimation2 != null) {
            alphaAnimation2.setAnimationListener(null);
            this.I.cancel();
            this.I = null;
        }
        ImageView imageView = this.f61562h;
        if (imageView != null) {
            imageView.clearAnimation();
        }
        View view = this.f61561f;
        if (view != null) {
            view.clearAnimation();
            this.f61561f = null;
        }
        View view2 = this.G;
        if (view2 != null) {
            view2.clearAnimation();
            this.G = null;
        }
        View view3 = this.F;
        if (view3 != null) {
            view3.clearAnimation();
            this.F = null;
        }
        View view4 = this.C;
        if (view4 != null) {
            view4.clearAnimation();
            this.C = null;
        }
        View view5 = this.f61564m;
        if (view5 != null) {
            view5.clearAnimation();
            this.f61564m = null;
        }
        View view6 = this.E;
        if (view6 != null) {
            view6.clearAnimation();
            this.E = null;
        }
        View view7 = this.D;
        if (view7 != null) {
            view7.clearAnimation();
            this.D = null;
        }
        View view8 = this.f61563i;
        if (view8 != null) {
            view8.clearAnimation();
            this.f61563i = null;
        }
        this.K = null;
        N = false;
    }

    public void l() {
        N = true;
    }

    public void o(boolean z16) {
        if (z16) {
            m();
        } else {
            n();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (!c.this.L) {
                c.this.f61561f.setVisibility(8);
            }
            c.this.f61563i.setVisibility(8);
            c.this.f61564m.setVisibility(8);
            if (c.this.M != null) {
                c.this.M.a();
            }
            QLog.d("AdelieAVInviteAnimation", 1, "startConnectAnim onAnimationEnd");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
