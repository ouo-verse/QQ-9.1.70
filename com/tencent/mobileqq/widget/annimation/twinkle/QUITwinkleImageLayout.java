package com.tencent.mobileqq.widget.annimation.twinkle;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QUITwinkleImageLayout extends FrameLayout {
    private ImageView C;
    private Animator.AnimatorListener D;

    /* renamed from: d, reason: collision with root package name */
    private int f316663d;

    /* renamed from: e, reason: collision with root package name */
    private int f316664e;

    /* renamed from: f, reason: collision with root package name */
    private float f316665f;

    /* renamed from: h, reason: collision with root package name */
    private ValueAnimator f316666h;

    /* renamed from: i, reason: collision with root package name */
    private ValueAnimator f316667i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f316668m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.widget.annimation.twinkle.QUITwinkleImageLayout$5, reason: invalid class name */
    /* loaded from: classes20.dex */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ QUITwinkleImageLayout this$0;

        @Override // java.lang.Runnable
        public void run() {
            if (this.this$0.f316666h == null) {
                this.this$0.j();
            } else if (this.this$0.f316666h.isRunning()) {
                this.this$0.f316666h.cancel();
            }
            if (this.this$0.f316667i == null) {
                this.this$0.k();
            } else if (this.this$0.f316667i.isRunning()) {
                this.this$0.f316667i.cancel();
            }
            this.this$0.f316666h.start();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.widget.annimation.twinkle.QUITwinkleImageLayout$6, reason: invalid class name */
    /* loaded from: classes20.dex */
    class AnonymousClass6 implements Runnable {
        final /* synthetic */ QUITwinkleImageLayout this$0;

        @Override // java.lang.Runnable
        public void run() {
            if (this.this$0.f316666h == null) {
                this.this$0.j();
            } else if (this.this$0.f316666h.isRunning()) {
                this.this$0.f316666h.cancel();
            }
            this.this$0.f316667i = null;
            this.this$0.f316666h.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            QUITwinkleImageLayout.this.f316665f = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            QUITwinkleImageLayout.this.f316668m.setAlpha(QUITwinkleImageLayout.this.f316665f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (QUITwinkleImageLayout.this.D != null) {
                QUITwinkleImageLayout.this.D.onAnimationCancel(animator);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (QUITwinkleImageLayout.this.D != null) {
                QUITwinkleImageLayout.this.D.onAnimationEnd(animator);
            }
            if (QUITwinkleImageLayout.this.f316667i != null) {
                QUITwinkleImageLayout.this.f316667i.start();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (QUITwinkleImageLayout.this.D != null) {
                QUITwinkleImageLayout.this.D.onAnimationStart(animator);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            QUITwinkleImageLayout.this.f316665f = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            QUITwinkleImageLayout.this.f316668m.setAlpha(QUITwinkleImageLayout.this.f316665f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (QUITwinkleImageLayout.this.D != null) {
                QUITwinkleImageLayout.this.D.onAnimationCancel(animator);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (QUITwinkleImageLayout.this.D != null) {
                QUITwinkleImageLayout.this.D.onAnimationEnd(animator);
            }
            if (QUITwinkleImageLayout.this.f316666h != null) {
                QUITwinkleImageLayout.this.f316666h.start();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (QUITwinkleImageLayout.this.D != null) {
                QUITwinkleImageLayout.this.D.onAnimationStart(animator);
            }
        }
    }

    public QUITwinkleImageLayout(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.f316666h = ofFloat;
        he0.b.m(ofFloat, this.f316663d, this.f316664e);
        this.f316666h.addUpdateListener(new a());
        this.f316666h.addListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f316667i = ofFloat;
        he0.b.m(ofFloat, this.f316663d, this.f316664e);
        this.f316667i.addUpdateListener(new c());
        this.f316667i.addListener(new d());
    }

    public void setAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.D = animatorListener;
    }

    public QUITwinkleImageLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QUITwinkleImageLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f316663d = R.anim.f154986ut;
        this.f316664e = 3;
        this.f316665f = 1.0f;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        ImageView imageView = new ImageView(context);
        this.C = imageView;
        imageView.setLayoutParams(layoutParams);
        addView(this.C);
        ImageView imageView2 = new ImageView(context);
        this.f316668m = imageView2;
        imageView2.setLayoutParams(layoutParams);
        addView(this.f316668m);
    }
}
