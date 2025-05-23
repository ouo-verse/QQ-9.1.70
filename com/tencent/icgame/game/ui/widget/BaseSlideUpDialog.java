package com.tencent.icgame.game.ui.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cy0.a;

/* compiled from: P */
/* loaded from: classes7.dex */
public class BaseSlideUpDialog extends h {
    public boolean I;
    ValueAnimator J;
    ValueAnimator K;
    private View L;
    private View M;
    private boolean N;
    private float P;
    private boolean Q;
    private boolean R;
    private boolean S;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BaseSlideUpDialog.this.b0(valueAnimator);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            BaseSlideUpDialog.this.L.setTranslationY(0.0f);
            BaseSlideUpDialog.this.L.setTranslationX(0.0f);
            BaseSlideUpDialog baseSlideUpDialog = BaseSlideUpDialog.this;
            baseSlideUpDialog.e0(baseSlideUpDialog.M, 0.7f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            BaseSlideUpDialog.this.L.setTranslationY(0.0f);
            BaseSlideUpDialog.this.L.setTranslationX(0.0f);
            BaseSlideUpDialog baseSlideUpDialog = BaseSlideUpDialog.this;
            baseSlideUpDialog.e0(baseSlideUpDialog.M, 0.7f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (!BaseSlideUpDialog.this.R) {
                BaseSlideUpDialog.this.L.setTranslationY(BaseSlideUpDialog.this.L.getHeight() * BaseSlideUpDialog.this.P);
            } else {
                BaseSlideUpDialog.this.L.setTranslationX(BaseSlideUpDialog.this.L.getWidth() * BaseSlideUpDialog.this.P);
            }
            if (BaseSlideUpDialog.this.M != null) {
                BaseSlideUpDialog baseSlideUpDialog = BaseSlideUpDialog.this;
                baseSlideUpDialog.e0(baseSlideUpDialog.M, 0.0f);
                BaseSlideUpDialog.this.M.setVisibility(0);
            }
            BaseSlideUpDialog.this.L.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            BaseSlideUpDialog.this.cancel();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f115915d;

        d(float f16) {
            this.f115915d = f16;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (!BaseSlideUpDialog.this.R) {
                BaseSlideUpDialog.this.L.setTranslationY(this.f115915d * floatValue);
            } else {
                BaseSlideUpDialog.this.L.setTranslationX(this.f115915d * floatValue);
            }
            BaseSlideUpDialog baseSlideUpDialog = BaseSlideUpDialog.this;
            baseSlideUpDialog.e0(baseSlideUpDialog.M, (1.0f - floatValue) * 0.7f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class e extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f115917d;

        e(float f16) {
            this.f115917d = f16;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            if (!BaseSlideUpDialog.this.R) {
                BaseSlideUpDialog.this.L.setTranslationY(this.f115917d);
            } else {
                BaseSlideUpDialog.this.L.setTranslationX(this.f115917d);
            }
            BaseSlideUpDialog baseSlideUpDialog = BaseSlideUpDialog.this;
            baseSlideUpDialog.e0(baseSlideUpDialog.M, 0.0f);
            BaseSlideUpDialog.super.dismiss();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (!BaseSlideUpDialog.this.R) {
                BaseSlideUpDialog.this.L.setTranslationY(this.f115917d);
            } else {
                BaseSlideUpDialog.this.L.setTranslationX(this.f115917d);
            }
            BaseSlideUpDialog baseSlideUpDialog = BaseSlideUpDialog.this;
            baseSlideUpDialog.e0(baseSlideUpDialog.M, 0.0f);
            BaseSlideUpDialog.super.dismiss();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (!BaseSlideUpDialog.this.R) {
                BaseSlideUpDialog.this.L.setTranslationY(0.0f);
            } else {
                BaseSlideUpDialog.this.L.setTranslationX(0.0f);
            }
            BaseSlideUpDialog baseSlideUpDialog = BaseSlideUpDialog.this;
            baseSlideUpDialog.e0(baseSlideUpDialog.M, 0.7f);
        }
    }

    public BaseSlideUpDialog(Context context) {
        this(context, R.style.MenuDialogStyle);
        com.tencent.icgame.game.utils.j.c(getWindow());
    }

    private void Z() {
        ViewGroup viewGroup = (ViewGroup) this.L.getParent();
        if (viewGroup != null) {
            ImageView imageView = new ImageView(getContext());
            this.M = imageView;
            if (this.I) {
                imageView.setImageResource(R.drawable.lre);
            }
            this.M.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            viewGroup.addView(this.M, 0);
            if (this.S) {
                this.M.setOnClickListener(new c());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0(ValueAnimator valueAnimator) {
        float floatValue;
        if (!this.R) {
            float height = this.L.getHeight() * this.P;
            floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.L.setTranslationY(height * floatValue);
        } else {
            float width = this.L.getWidth() * this.P;
            floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.L.setTranslationX(width * floatValue);
        }
        e0(this.M, (1.0f - floatValue) * 0.7f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0(View view, float f16) {
        if (view != null) {
            if (view instanceof ImageView) {
                ((ImageView) view).setImageAlpha((int) (f16 * 255.0f));
            } else {
                view.setAlpha(f16);
            }
        }
    }

    protected long a0() {
        return 500L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c0(View view) {
        this.L = view;
    }

    @Override // com.tencent.icgame.game.ui.widget.b, android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        super.cancel();
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d0(View view) {
        this.M = view;
    }

    @Override // com.tencent.icgame.game.ui.widget.b, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        float height;
        float f16;
        if (this.L != null && this.Q) {
            ValueAnimator valueAnimator = this.J;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            if (this.K != null) {
                return;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.K = ofFloat;
            ofFloat.setInterpolator(a.f.f392377b);
            if (this.R) {
                height = this.L.getWidth();
                f16 = this.P;
            } else {
                height = this.L.getHeight();
                f16 = this.P;
            }
            float f17 = height * f16;
            this.K.setDuration(a0());
            this.K.addUpdateListener(new d(f17));
            this.K.addListener(new e(f17));
            this.K.start();
            return;
        }
        super.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.icgame.game.ui.widget.h, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(Integer.MIN_VALUE);
        com.tencent.icgame.game.utils.j.d(getWindow());
    }

    @Override // com.tencent.icgame.game.ui.widget.b, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        super.show();
        if (this.L != null && this.Q) {
            if (this.M == null) {
                Z();
            }
            View view = this.M;
            if (view != null) {
                view.setVisibility(4);
            }
            this.L.setVisibility(4);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.J = ofFloat;
            ofFloat.setInterpolator(a.f.f392376a);
            this.J.setDuration(a0());
            this.J.addUpdateListener(new a());
            this.J.addListener(new b());
            this.L.post(new Runnable() { // from class: com.tencent.icgame.game.ui.widget.BaseSlideUpDialog.3
                @Override // java.lang.Runnable
                public void run() {
                    BaseSlideUpDialog.this.J.start();
                }
            });
        }
    }

    public BaseSlideUpDialog(Context context, int i3) {
        super(context, i3);
        this.I = true;
        this.N = false;
        this.P = 1.0f;
        this.Q = true;
        this.R = false;
        this.S = false;
    }
}
