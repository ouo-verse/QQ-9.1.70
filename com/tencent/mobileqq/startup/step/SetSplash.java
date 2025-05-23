package com.tencent.mobileqq.startup.step;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ei;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
@Deprecated
/* loaded from: classes18.dex */
public class SetSplash {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected static WeakReference<View> f289738a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f289739b;

    /* renamed from: c, reason: collision with root package name */
    private static d f289740c;

    /* renamed from: d, reason: collision with root package name */
    private static long f289741d;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f289742e;

    /* renamed from: f, reason: collision with root package name */
    public static Runnable f289743f;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.startup.step.SetSplash$1, reason: invalid class name */
    /* loaded from: classes18.dex */
    class AnonymousClass1 implements Runnable {
        static IPatchRedirector $redirector_;

        AnonymousClass1() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                SetSplash.m(SetSplash.f289740c);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f289744d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f289745e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f289746f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ View f289747h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ d f289748i;

        a(int i3, int i16, int i17, View view, d dVar) {
            this.f289744d = i3;
            this.f289745e = i16;
            this.f289746f = i17;
            this.f289747h = view;
            this.f289748i = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), view, dVar);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int i16 = this.f289744d;
            if (i16 > 0) {
                i3 = (int) (i16 * floatValue);
            } else {
                i3 = 0;
            }
            ViewCompat.setClipBounds(this.f289747h, new Rect(0, i3, this.f289747h.getRight(), (this.f289745e - ((int) ((r2 - this.f289746f) * floatValue))) + i3));
            if (floatValue > 0.6d && !SetSplash.f289739b) {
                SetSplash.f289739b = true;
                SetSplash.o(this.f289747h, this.f289748i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f289749d;

        b(d dVar) {
            this.f289749d = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) dVar);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            } else {
                super.onAnimationEnd(animator);
                SetSplash.m(this.f289749d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f289750d;

        c(View view) {
            this.f289750d = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
            } else {
                this.f289750d.setAlpha(1.0f - ((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface d {
        void a();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75395);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f289741d = 0L;
        f289742e = false;
        f289743f = new Runnable() { // from class: com.tencent.mobileqq.startup.step.SetSplash.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    SetSplash.m(SetSplash.f289740c);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        };
    }

    public static View e() {
        WeakReference<View> weakReference = f289738a;
        if (weakReference != null && weakReference.get() != null) {
            return f289738a.get();
        }
        return null;
    }

    public static boolean f() {
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = f289741d;
        if (currentTimeMillis > j3 && currentTimeMillis - j3 < 5000) {
            return true;
        }
        return false;
    }

    public static boolean g() {
        if (e() != null) {
            return true;
        }
        return false;
    }

    public static boolean h() {
        return f289742e;
    }

    public static void i(boolean z16) {
        QLog.i("SetSplash", 1, "onShuaYiShuaSplashClosed isJumpBtn:" + z16);
        f289742e = false;
        if (!z16) {
            f289741d = System.currentTimeMillis();
        }
    }

    public static void j() {
        WeakReference<View> weakReference = f289738a;
        if (weakReference != null) {
            weakReference.clear();
            f289738a = null;
        }
    }

    public static void k(boolean z16) {
        f289742e = z16;
        QLog.i("SetSplash", 1, "setShuaYiShuaSplashShowState isShowing:" + z16);
    }

    private static void l(d dVar, int i3, int i16) {
        View e16 = e();
        if (e16 != null && i16 != 0) {
            j();
            QLog.i("SetSplash", 1, "adView:" + e16 + " listener:" + f289740c);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f);
            ofFloat.setDuration(800L);
            ofFloat.setInterpolator(new PathInterpolator(0.65f, 0.0f, 0.28f, 1.0f));
            e16.setClipToOutline(true);
            f289739b = false;
            ofFloat.addUpdateListener(new a(i3, e16.getHeight(), i16, e16, dVar));
            ofFloat.start();
            return;
        }
        m(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m(d dVar) {
        QLog.i("SetSplash", 1, "splashAnimEnd listener:" + dVar);
        if (dVar != null) {
            dVar.a();
        }
        View e16 = e();
        if (e16 != null && e16.getParent() != null && (e16.getParent() instanceof ViewGroup)) {
            ((ViewGroup) e16.getParent()).removeView(e16);
            QLog.i("SetSplash", 1, "removeView splash view");
        }
        j();
        f289740c = null;
        f289743f = null;
    }

    public static void n(View view) {
        Object obj;
        d dVar;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("startSplashAnim:");
        sb5.append(view);
        sb5.append(" bannerView height:");
        if (view != null) {
            obj = Integer.valueOf(view.getHeight());
        } else {
            obj = "0";
        }
        sb5.append(obj);
        sb5.append(" sSplashAnimListener:");
        sb5.append(f289740c);
        QLog.i("SetSplash", 1, sb5.toString());
        if (view != null && view.getHeight() > 0 && (dVar = f289740c) != null) {
            p(view, dVar);
            f289740c = null;
        }
    }

    protected static void o(View view, d dVar) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f);
        ofFloat.setDuration(300L);
        ofFloat.addListener(new b(dVar));
        ofFloat.addUpdateListener(new c(view));
        ofFloat.start();
    }

    public static void p(View view, d dVar) {
        QLog.i("SetSplash", 1, "startSplashAnim:" + view + " listener:" + dVar + " sSplashView:" + f289738a);
        ei.a("splashCost", null);
        View e16 = e();
        if (e16 == null) {
            QLog.w("SetSplash", 1, "splashView is null, anim End:");
            m(dVar);
            return;
        }
        if (view != null && view.getHeight() > 0) {
            Runnable runnable = f289743f;
            if (runnable != null) {
                e16.removeCallbacks(runnable);
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            l(dVar, iArr[1], view.getHeight());
            return;
        }
        if (g()) {
            e16.postDelayed(f289743f, 1000L);
            f289740c = dVar;
        } else {
            m(dVar);
        }
    }

    public static void q(View view) {
        f289738a = new WeakReference<>(view);
    }
}
