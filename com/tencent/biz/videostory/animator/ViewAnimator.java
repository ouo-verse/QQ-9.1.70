package com.tencent.biz.videostory.animator;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Interpolator;
import com.tencent.mobileqq.widget.f;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jf0.d;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ViewAnimator {

    /* renamed from: g, reason: collision with root package name */
    private AnimatorSet f97039g;

    /* renamed from: i, reason: collision with root package name */
    private jf0.c f97041i;

    /* renamed from: j, reason: collision with root package name */
    private d f97042j;

    /* renamed from: a, reason: collision with root package name */
    private List<com.tencent.biz.videostory.animator.a> f97033a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private long f97034b = 3000;

    /* renamed from: c, reason: collision with root package name */
    private long f97035c = 0;

    /* renamed from: d, reason: collision with root package name */
    private Interpolator f97036d = null;

    /* renamed from: e, reason: collision with root package name */
    private int f97037e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f97038f = 1;

    /* renamed from: h, reason: collision with root package name */
    private View f97040h = null;

    /* renamed from: k, reason: collision with root package name */
    private ViewAnimator f97043k = null;

    /* renamed from: l, reason: collision with root package name */
    private ViewAnimator f97044l = null;

    /* renamed from: m, reason: collision with root package name */
    private boolean f97045m = false;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes5.dex */
    public @interface RepeatMode {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c implements ViewTreeObserver.OnPreDrawListener {
        c() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            ViewAnimator.this.f97039g.start();
            ViewAnimator.this.f97040h.getViewTreeObserver().removeOnPreDrawListener(this);
            return false;
        }
    }

    static /* bridge */ /* synthetic */ jf0.a b(ViewAnimator viewAnimator) {
        viewAnimator.getClass();
        return null;
    }

    static /* bridge */ /* synthetic */ jf0.b d(ViewAnimator viewAnimator) {
        viewAnimator.getClass();
        return null;
    }

    public static com.tencent.biz.videostory.animator.a j(View... viewArr) {
        return new ViewAnimator().i(viewArr);
    }

    public com.tencent.biz.videostory.animator.a i(View... viewArr) {
        com.tencent.biz.videostory.animator.a aVar = new com.tencent.biz.videostory.animator.a(this, viewArr);
        this.f97033a.add(aVar);
        return aVar;
    }

    protected AnimatorSet k() {
        this.f97045m = false;
        ArrayList<Animator> arrayList = new ArrayList();
        for (com.tencent.biz.videostory.animator.a aVar : this.f97033a) {
            List<Animator> b16 = aVar.b();
            if (aVar.d() != null) {
                Iterator<Animator> it = b16.iterator();
                while (it.hasNext()) {
                    it.next().setInterpolator(aVar.d());
                }
            }
            arrayList.addAll(b16);
        }
        Iterator<com.tencent.biz.videostory.animator.a> it5 = this.f97033a.iterator();
        while (true) {
            if (!it5.hasNext()) {
                break;
            }
            com.tencent.biz.videostory.animator.a next = it5.next();
            if (next.g()) {
                this.f97040h = next.f();
                break;
            }
        }
        for (Animator animator : arrayList) {
            if (animator instanceof ValueAnimator) {
                ValueAnimator valueAnimator = (ValueAnimator) animator;
                valueAnimator.setRepeatCount(this.f97037e);
                valueAnimator.setRepeatMode(this.f97038f);
                if (!this.f97045m) {
                    valueAnimator.addListener(new a());
                    this.f97045m = true;
                }
            }
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.setDuration(this.f97034b);
        animatorSet.setStartDelay(this.f97035c);
        Interpolator interpolator = this.f97036d;
        if (interpolator != null) {
            animatorSet.setInterpolator(interpolator);
        }
        animatorSet.addListener(new b());
        return animatorSet;
    }

    public ViewAnimator l(long j3) {
        this.f97034b = j3;
        return this;
    }

    public ViewAnimator m(jf0.c cVar) {
        this.f97041i = cVar;
        return this;
    }

    public ViewAnimator n(d dVar) {
        this.f97042j = dVar;
        return this;
    }

    public ViewAnimator o() {
        ViewAnimator viewAnimator = this.f97043k;
        if (viewAnimator != null) {
            viewAnimator.o();
        } else {
            AnimatorSet k3 = k();
            this.f97039g = k3;
            View view = this.f97040h;
            if (view != null) {
                view.getViewTreeObserver().addOnPreDrawListener(new c());
            } else {
                k3.start();
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
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
    /* loaded from: classes5.dex */
    public class b extends f {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ViewAnimator.b(ViewAnimator.this);
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (ViewAnimator.this.f97042j != null) {
                ViewAnimator.this.f97042j.onStop();
            }
            if (ViewAnimator.this.f97044l != null) {
                ViewAnimator.this.f97044l.f97043k = null;
                ViewAnimator.this.f97044l.o();
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (ViewAnimator.this.f97041i != null) {
                ViewAnimator.this.f97041i.onStart();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}
