package com.tencent.mobileqq.activity.framebusiness.controllerinject;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qui.quiblurview.QQBlurViewWrapper;

/* compiled from: P */
/* loaded from: classes10.dex */
public class o {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static volatile o f182364c;

    /* renamed from: a, reason: collision with root package name */
    private AnimatorSet f182365a;

    /* renamed from: b, reason: collision with root package name */
    private AnimatorSet f182366b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a extends com.tencent.mobileqq.widget.f {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f182367d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f182368e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ FrameFragment.d f182369f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ FrameFragment.c f182370h;

        a(View view, View view2, FrameFragment.d dVar, FrameFragment.c cVar) {
            this.f182367d = view;
            this.f182368e = view2;
            this.f182369f = dVar;
            this.f182370h = cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, o.this, view, view2, dVar, cVar);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                o.this.f182365a = null;
                this.f182367d.setTranslationY(0.0f);
                this.f182368e.setTranslationY(0.0f);
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                o.this.f182365a = null;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                o.this.h(this.f182369f, this.f182370h, 0);
            } else {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animator);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b extends com.tencent.mobileqq.widget.f {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FrameFragment.d f182372d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ FrameFragment.c f182373e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f182374f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ View f182375h;

        b(FrameFragment.d dVar, FrameFragment.c cVar, View view, View view2) {
            this.f182372d = dVar;
            this.f182373e = cVar;
            this.f182374f = view;
            this.f182375h = view2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, o.this, dVar, cVar, view, view2);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                o.this.f182366b = null;
                o.this.h(this.f182372d, this.f182373e, 8);
                this.f182374f.setTranslationY(r4.getHeight());
                this.f182375h.setTranslationY(r4.getHeight());
                this.f182374f.setVisibility(8);
                this.f182375h.setVisibility(8);
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                o.this.f182366b = null;
                o.this.h(this.f182372d, this.f182373e, 8);
                this.f182374f.setVisibility(8);
                this.f182375h.setVisibility(8);
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animator);
            }
        }
    }

    o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void d(FrameFragment.d dVar, View view, View view2, FrameFragment.c cVar, long j3) {
        if (view != null && view2 != null && cVar != null) {
            if (view.getVisibility() == 8) {
                QLog.d("TabWidgetHelper", 1, "doAnimate: is gone do nothing");
                return;
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", 0.0f, view.getHeight());
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, "translationY", 0.0f, view2.getHeight());
            AnimatorSet animatorSet = new AnimatorSet();
            this.f182366b = animatorSet;
            animatorSet.setDuration(j3);
            this.f182366b.playTogether(ofFloat, ofFloat2);
            this.f182366b.setInterpolator(new LinearInterpolator());
            this.f182366b.addListener(new b(dVar, cVar, view, view2));
            this.f182366b.start();
            QLog.d("TabWidgetHelper", 1, "dismissTabWidget start");
            return;
        }
        QLog.e("TabWidgetHelper", 1, "dismissTabWidget: params wrong");
    }

    public static o e() {
        if (f182364c == null) {
            synchronized (o.class) {
                if (f182364c == null) {
                    f182364c = new o();
                }
            }
        }
        return f182364c;
    }

    private boolean f(@NonNull FrameFragment.d dVar) {
        if (dVar.getCurrentTab() == com.tencent.mobileqq.activity.home.impl.a.f183046i) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void h(FrameFragment.d dVar, FrameFragment.c cVar, int i3) {
        if (cVar != 0 && !f(dVar)) {
            if (!SimpleModeHelper.C()) {
                QLog.d("TabWidgetHelper", 1, "resetTabHostDivider, do nothing in current mode");
                return;
            }
            View findViewById = ((ViewGroup) cVar).findViewById(R.id.f916655s);
            if (findViewById != null) {
                findViewById.setVisibility(i3);
                return;
            }
            return;
        }
        QLog.d("TabWidgetHelper", 1, "resetTabHostDivider do nothing");
    }

    private void i(FrameFragment.d dVar, View view, View view2, FrameFragment.c cVar, long j3) {
        if (view != null && view2 != null && cVar != null) {
            if (view.getVisibility() == 0) {
                QLog.d("TabWidgetHelper", 1, "doAnimate: is visible do nothing");
                return;
            }
            view.setVisibility(0);
            view2.setVisibility(0);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", view.getHeight(), 0.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, "translationY", view2.getHeight(), 0.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            this.f182365a = animatorSet;
            animatorSet.setDuration(j3);
            this.f182365a.playTogether(ofFloat, ofFloat2);
            this.f182365a.setInterpolator(new LinearInterpolator());
            this.f182365a.addListener(new a(view, view2, dVar, cVar));
            this.f182365a.start();
            QLog.d("TabWidgetHelper", 1, "showTabWidget start");
            return;
        }
        QLog.e("TabWidgetHelper", 1, "showTabWidget: params wrong");
    }

    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        AnimatorSet animatorSet = this.f182365a;
        if (animatorSet != null && animatorSet.isRunning()) {
            QLog.d("TabWidgetHelper", 1, "isDoingTabShowAnim");
            return true;
        }
        AnimatorSet animatorSet2 = this.f182366b;
        if (animatorSet2 != null && animatorSet2.isRunning()) {
            QLog.d("TabWidgetHelper", 1, "isDoingTabHidAnim");
            return true;
        }
        return false;
    }

    public void j(QBaseActivity qBaseActivity, boolean z16, long j3) {
        FrameFragment.d dVar;
        FrameFragment.c cVar;
        QQBlurViewWrapper qQBlurViewWrapper;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, qBaseActivity, Boolean.valueOf(z16), Long.valueOf(j3));
            return;
        }
        if ((qBaseActivity instanceof SplashActivity) && SplashActivity.currentFragment == 1) {
            if (qBaseActivity != null && Looper.getMainLooper() == Looper.myLooper()) {
                if (g()) {
                    QLog.e("TabWidgetHelper", 1, "doAnimate error: isDoingTabAnim");
                    return;
                }
                FragmentManager supportFragmentManager = qBaseActivity.getSupportFragmentManager();
                if (supportFragmentManager == null) {
                    QLog.e("TabWidgetHelper", 1, "doAnimate error: fm == null");
                    return;
                }
                MainFragment mainFragment = (MainFragment) supportFragmentManager.findFragmentByTag(MainFragment.class.getName());
                if (mainFragment != null && (dVar = mainFragment.mTabIndicator) != null && (cVar = mainFragment.mTabHost) != null && (qQBlurViewWrapper = mainFragment.mTabBlurView) != null) {
                    if (z16) {
                        i(dVar, mainFragment.mTabWidget, qQBlurViewWrapper, cVar, j3);
                        return;
                    } else {
                        d(dVar, mainFragment.mTabWidget, qQBlurViewWrapper, cVar, j3);
                        return;
                    }
                }
                QLog.e("TabWidgetHelper", 1, "doAnimate error: widget empty");
                return;
            }
            QLog.e("TabWidgetHelper", 1, "doAnimate error: context or thread wrong");
        }
    }
}
