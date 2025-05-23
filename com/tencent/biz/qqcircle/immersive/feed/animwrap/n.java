package com.tencent.biz.qqcircle.immersive.feed.animwrap;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private final List<View> f85953a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<Integer> f85954b;

    /* renamed from: c, reason: collision with root package name */
    private final int f85955c;

    /* renamed from: d, reason: collision with root package name */
    private final int f85956d;

    /* renamed from: e, reason: collision with root package name */
    private ValueAnimator f85957e;

    /* renamed from: f, reason: collision with root package name */
    private ValueAnimator f85958f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!(valueAnimator.getAnimatedValue() instanceof Float)) {
                return;
            }
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            Iterator it = n.this.f85953a.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setAlpha(floatValue);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private ArrayList<Integer> f85962a = new ArrayList<>();

        /* renamed from: b, reason: collision with root package name */
        private int f85963b;

        /* renamed from: c, reason: collision with root package name */
        private int f85964c;

        public n a() {
            return new n(this);
        }

        public int b() {
            return this.f85964c;
        }

        public int c() {
            return this.f85963b;
        }

        public ArrayList<Integer> d() {
            return this.f85962a;
        }

        public d e(int i3) {
            this.f85964c = i3;
            return this;
        }

        public d f(int i3) {
            this.f85963b = i3;
            return this;
        }

        public d g(ArrayList<Integer> arrayList) {
            this.f85962a = arrayList;
            return this;
        }
    }

    n(d dVar) {
        this.f85954b = new ArrayList<>();
        this.f85954b = dVar.d();
        this.f85955c = dVar.c();
        this.f85956d = dVar.b();
        e();
    }

    private void c(View view) {
        if (view != null && (view.getParent() instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = viewGroup.getChildAt(i3);
                if (childAt != view && !this.f85954b.contains(Integer.valueOf(childAt.getId())) && childAt.getVisibility() == 0) {
                    this.f85953a.add(childAt);
                }
            }
            if ((view.getParent() instanceof View) && ((ViewGroup) view.getParent()).getId() != this.f85955c) {
                c((View) view.getParent());
            }
        }
    }

    private void e() {
        a aVar = new a();
        g(aVar);
        f(aVar);
    }

    private void f(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        ValueAnimator duration = ValueAnimator.ofFloat(1.0f, 0.0f).setDuration(this.f85956d);
        this.f85958f = duration;
        duration.addListener(new c());
        this.f85958f.addUpdateListener(animatorUpdateListener);
    }

    private void g(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        ValueAnimator duration = ValueAnimator.ofFloat(0.3f, 1.0f).setDuration(this.f85956d);
        this.f85957e = duration;
        duration.addListener(new b());
        this.f85957e.addUpdateListener(animatorUpdateListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Iterator<View> it = this.f85953a.iterator();
        while (it.hasNext()) {
            it.next().setAlpha(1.0f);
            it.remove();
        }
    }

    private void i() {
        Iterator<View> it = this.f85953a.iterator();
        while (it.hasNext()) {
            it.next().setAlpha(0.0f);
        }
    }

    public void d(View view, boolean z16) {
        if (this.f85957e.isRunning()) {
            this.f85957e.cancel();
        }
        c(view);
        if (z16) {
            this.f85958f.start();
        } else {
            i();
        }
    }

    public void j(boolean z16) {
        if (this.f85958f.isRunning()) {
            this.f85958f.cancel();
        }
        if (z16) {
            this.f85957e.start();
        } else {
            h();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            n.this.h();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements Animator.AnimatorListener {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Iterator it = n.this.f85953a.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setAlpha(1.0f);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}
