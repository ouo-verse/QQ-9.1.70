package com.tencent.aelight.camera.ae.camera.ui.animator;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Interpolator;
import bq.d;
import com.tencent.mobileqq.widget.f;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class ViewAnimator {

    /* renamed from: g, reason: collision with root package name */
    private AnimatorSet f62451g;

    /* renamed from: i, reason: collision with root package name */
    private bq.c f62453i;

    /* renamed from: j, reason: collision with root package name */
    private d f62454j;

    /* renamed from: a, reason: collision with root package name */
    private List<com.tencent.aelight.camera.ae.camera.ui.animator.a> f62445a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private long f62446b = 3000;

    /* renamed from: c, reason: collision with root package name */
    private long f62447c = 0;

    /* renamed from: d, reason: collision with root package name */
    private Interpolator f62448d = null;

    /* renamed from: e, reason: collision with root package name */
    private int f62449e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f62450f = 1;

    /* renamed from: h, reason: collision with root package name */
    private View f62452h = null;

    /* renamed from: k, reason: collision with root package name */
    private ViewAnimator f62455k = null;

    /* renamed from: l, reason: collision with root package name */
    private ViewAnimator f62456l = null;

    /* renamed from: m, reason: collision with root package name */
    private boolean f62457m = false;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes32.dex */
    public @interface RepeatMode {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c implements ViewTreeObserver.OnPreDrawListener {
        c() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            ViewAnimator.this.f62451g.start();
            ViewAnimator.this.f62452h.getViewTreeObserver().removeOnPreDrawListener(this);
            return false;
        }
    }

    static /* bridge */ /* synthetic */ bq.a b(ViewAnimator viewAnimator) {
        viewAnimator.getClass();
        return null;
    }

    static /* bridge */ /* synthetic */ bq.b d(ViewAnimator viewAnimator) {
        viewAnimator.getClass();
        return null;
    }

    public static com.tencent.aelight.camera.ae.camera.ui.animator.a j(View... viewArr) {
        return new ViewAnimator().i(viewArr);
    }

    public com.tencent.aelight.camera.ae.camera.ui.animator.a i(View... viewArr) {
        com.tencent.aelight.camera.ae.camera.ui.animator.a aVar = new com.tencent.aelight.camera.ae.camera.ui.animator.a(this, viewArr);
        this.f62445a.add(aVar);
        return aVar;
    }

    public ViewAnimator l(long j3) {
        this.f62446b = j3;
        return this;
    }

    public ViewAnimator m(Interpolator interpolator) {
        this.f62448d = interpolator;
        return this;
    }

    public ViewAnimator n(bq.c cVar) {
        this.f62453i = cVar;
        return this;
    }

    public ViewAnimator o(d dVar) {
        this.f62454j = dVar;
        return this;
    }

    public ViewAnimator p(int i3) {
        this.f62449e = i3;
        return this;
    }

    public ViewAnimator q(int i3) {
        this.f62450f = i3;
        return this;
    }

    public ViewAnimator r() {
        ViewAnimator viewAnimator = this.f62455k;
        if (viewAnimator != null) {
            viewAnimator.r();
        } else {
            AnimatorSet k3 = k();
            this.f62451g = k3;
            View view = this.f62452h;
            if (view != null) {
                view.getViewTreeObserver().addOnPreDrawListener(new c());
            } else {
                k3.start();
            }
        }
        return this;
    }

    protected AnimatorSet k() {
        this.f62457m = false;
        ArrayList<Animator> arrayList = new ArrayList();
        for (com.tencent.aelight.camera.ae.camera.ui.animator.a aVar : this.f62445a) {
            List<Animator> e16 = aVar.e();
            if (aVar.i() != null) {
                Iterator<Animator> it = e16.iterator();
                while (it.hasNext()) {
                    it.next().setInterpolator(aVar.i());
                }
            }
            arrayList.addAll(e16);
        }
        Iterator<com.tencent.aelight.camera.ae.camera.ui.animator.a> it5 = this.f62445a.iterator();
        while (true) {
            if (!it5.hasNext()) {
                break;
            }
            com.tencent.aelight.camera.ae.camera.ui.animator.a next = it5.next();
            if (next.n()) {
                this.f62452h = next.k();
                break;
            }
        }
        for (Animator animator : arrayList) {
            if (animator instanceof ValueAnimator) {
                ValueAnimator valueAnimator = (ValueAnimator) animator;
                valueAnimator.setRepeatCount(this.f62449e);
                valueAnimator.setRepeatMode(this.f62450f);
                if (!this.f62457m) {
                    valueAnimator.addListener(new a());
                    this.f62457m = true;
                }
            }
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.setDuration(this.f62446b);
        animatorSet.setStartDelay(this.f62447c);
        Interpolator interpolator = this.f62448d;
        if (interpolator != null) {
            animatorSet.setInterpolator(interpolator);
        }
        animatorSet.addListener(new b());
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a extends f {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            ViewAnimator.d(ViewAnimator.this);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b extends f {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ViewAnimator.b(ViewAnimator.this);
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (ViewAnimator.this.f62454j != null) {
                ViewAnimator.this.f62454j.onStop();
            }
            if (ViewAnimator.this.f62456l != null) {
                ViewAnimator.this.f62456l.f62455k = null;
                ViewAnimator.this.f62456l.r();
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (ViewAnimator.this.f62453i != null) {
                ViewAnimator.this.f62453i.onStart();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}
