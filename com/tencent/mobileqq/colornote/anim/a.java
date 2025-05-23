package com.tencent.mobileqq.colornote.anim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a extends ValueAnimator {

    /* renamed from: d, reason: collision with root package name */
    private ValueAnimator.AnimatorUpdateListener f201355d;

    /* renamed from: e, reason: collision with root package name */
    private View f201356e;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.colornote.anim.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class C7450a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CircularRevealCompatLayout f201357d;

        C7450a(CircularRevealCompatLayout circularRevealCompatLayout) {
            this.f201357d = circularRevealCompatLayout;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            c cVar = (c) valueAnimator.getAnimatedValue();
            this.f201357d.setRevealClip(cVar.f201362a, cVar.f201363b, cVar.f201364c);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    static final class b extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        private View f201359d;

        /* renamed from: e, reason: collision with root package name */
        private int f201360e;

        /* renamed from: f, reason: collision with root package name */
        private int f201361f;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(View view, int i3) {
            this.f201359d = view;
            this.f201360e = i3;
            this.f201361f = view.getLayerType();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f201359d.setLayerType(this.f201361f, null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f201359d.setLayerType(this.f201361f, null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f201359d.setLayerType(this.f201360e, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public float f201362a;

        /* renamed from: b, reason: collision with root package name */
        public float f201363b;

        /* renamed from: c, reason: collision with root package name */
        public float f201364c;

        public c(float f16, float f17, float f18) {
            this.f201362a = f16;
            this.f201363b = f17;
            this.f201364c = f18;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private static final class d implements TypeEvaluator<c> {

        /* renamed from: a, reason: collision with root package name */
        private c f201365a;

        d() {
        }

        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c evaluate(float f16, c cVar, c cVar2) {
            float f17 = cVar.f201362a;
            float f18 = f17 + ((cVar2.f201362a - f17) * f16);
            float f19 = cVar.f201363b;
            float f26 = f19 + ((cVar2.f201363b - f19) * f16);
            float f27 = cVar.f201364c;
            float f28 = f27 + ((cVar2.f201364c - f27) * f16);
            c cVar3 = this.f201365a;
            if (cVar3 == null) {
                this.f201365a = new c(f18, f26, f28);
            } else {
                cVar3.f201362a = f18;
                cVar3.f201363b = f26;
                cVar3.f201364c = f28;
            }
            return this.f201365a;
        }
    }

    a(View view, float f16, float f17, float f18, float f19, float f26, float f27) {
        this.f201356e = view;
        setObjectValues(new c(f16, f17, f18), new c(f19, f26, f27));
        setEvaluator(new d());
        C7450a c7450a = new C7450a(b(view));
        this.f201355d = c7450a;
        addUpdateListener(c7450a);
    }

    private CircularRevealCompatLayout b(View view) {
        if (view instanceof CircularRevealCompatLayout) {
            return (CircularRevealCompatLayout) view;
        }
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup instanceof CircularRevealCompatLayout) {
            return (CircularRevealCompatLayout) viewGroup;
        }
        CircularRevealCompatLayout circularRevealCompatLayout = new CircularRevealCompatLayout(view.getContext());
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int indexOfChild = viewGroup.indexOfChild(view);
        viewGroup.removeView(view);
        circularRevealCompatLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
        viewGroup.addView(circularRevealCompatLayout, indexOfChild, layoutParams);
        return circularRevealCompatLayout;
    }

    public static a c(View view, int i3, int i16, float f16, float f17) {
        float f18 = i3;
        float f19 = i16;
        return new a(view, f18, f19, f16, f18, f19, f17);
    }

    public void a() {
        ViewParent parent = this.f201356e.getParent();
        if (parent instanceof CircularRevealCompatLayout) {
            CircularRevealCompatLayout circularRevealCompatLayout = (CircularRevealCompatLayout) parent;
            circularRevealCompatLayout.removeView(this.f201356e);
            ViewGroup viewGroup = (ViewGroup) circularRevealCompatLayout.getParent();
            ViewGroup.LayoutParams layoutParams = circularRevealCompatLayout.getLayoutParams();
            int indexOfChild = viewGroup.indexOfChild(circularRevealCompatLayout);
            viewGroup.removeView(circularRevealCompatLayout);
            viewGroup.addView(this.f201356e, indexOfChild, layoutParams);
        }
    }

    @Override // android.animation.ValueAnimator
    public void removeAllUpdateListeners() {
        super.removeAllUpdateListeners();
        addUpdateListener(this.f201355d);
    }
}
