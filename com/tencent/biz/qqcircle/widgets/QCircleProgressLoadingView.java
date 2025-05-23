package com.tencent.biz.qqcircle.widgets;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.lang.ref.WeakReference;

/* loaded from: classes5.dex */
public class QCircleProgressLoadingView extends QCircleBaseWidgetView {
    private a C;
    private boolean D;
    private int E;
    private Runnable F;

    /* renamed from: d, reason: collision with root package name */
    private AnimatorSet f93054d;

    /* renamed from: e, reason: collision with root package name */
    private ValueAnimator f93055e;

    /* renamed from: f, reason: collision with root package name */
    private ValueAnimator f93056f;

    /* renamed from: h, reason: collision with root package name */
    private ValueAnimator f93057h;

    /* renamed from: i, reason: collision with root package name */
    private AnimatorSet f93058i;

    /* renamed from: m, reason: collision with root package name */
    private View f93059m;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<QCircleProgressLoadingView> f93060d;

        public a(QCircleProgressLoadingView qCircleProgressLoadingView) {
            this.f93060d = new WeakReference<>(qCircleProgressLoadingView);
        }

        private boolean a() {
            QCircleProgressLoadingView qCircleProgressLoadingView;
            WeakReference<QCircleProgressLoadingView> weakReference = this.f93060d;
            if (weakReference == null) {
                qCircleProgressLoadingView = null;
            } else {
                qCircleProgressLoadingView = weakReference.get();
            }
            if (qCircleProgressLoadingView != null && qCircleProgressLoadingView.D) {
                return true;
            }
            return false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!a()) {
                QLog.d("CycleAnimationListener", 2, "[onAnimationEnd] not show loading view, flow end.");
            } else if (animator != null) {
                try {
                    animator.start();
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z16) {
            onAnimationStart(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z16) {
            onAnimationEnd(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<QCircleProgressLoadingView> f93061d;

        b(QCircleProgressLoadingView qCircleProgressLoadingView) {
            this.f93061d = new WeakReference<>(qCircleProgressLoadingView);
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            QCircleProgressLoadingView qCircleProgressLoadingView;
            View o06;
            WeakReference<QCircleProgressLoadingView> weakReference = this.f93061d;
            if (weakReference != null && (qCircleProgressLoadingView = weakReference.get()) != null && (o06 = qCircleProgressLoadingView.o0()) != null && o06.getBackground() != null && valueAnimator.getAnimatedValue() != null) {
                o06.getBackground().setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<QCircleProgressLoadingView> f93062d;

        /* renamed from: e, reason: collision with root package name */
        private int f93063e;

        c(QCircleProgressLoadingView qCircleProgressLoadingView, int i3) {
            this.f93063e = 16;
            this.f93062d = new WeakReference<>(qCircleProgressLoadingView);
            this.f93063e = i3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            QCircleProgressLoadingView qCircleProgressLoadingView;
            View o06;
            int screenWidth;
            WeakReference<QCircleProgressLoadingView> weakReference = this.f93062d;
            if (weakReference != null && (qCircleProgressLoadingView = weakReference.get()) != null && (o06 = qCircleProgressLoadingView.o0()) != null && o06.getLayoutParams() != null && valueAnimator.getAnimatedValue() != null) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (this.f93063e == 16) {
                    screenWidth = bz.j();
                } else {
                    screenWidth = DisplayUtil.getScreenWidth();
                }
                o06.setX((screenWidth / 2) - intValue);
                o06.getLayoutParams().width = intValue * 2;
                o06.getLayoutParams().height = ImmersiveUtils.dpToPx(1.0f);
                o06.setLayoutParams(o06.getLayoutParams());
            }
        }
    }

    public QCircleProgressLoadingView(@NonNull Context context) {
        super(context);
        this.D = false;
        this.E = 16;
        this.F = new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.QCircleProgressLoadingView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QCircleProgressLoadingView.this.f93054d != null) {
                    QCircleProgressLoadingView.this.f93054d.removeAllListeners();
                    if (QCircleProgressLoadingView.this.C != null) {
                        QCircleProgressLoadingView.this.f93054d.addListener(QCircleProgressLoadingView.this.C);
                    }
                    QCircleProgressLoadingView.this.f93054d.start();
                }
            }
        };
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return null;
    }

    public AnimatorSet n0() {
        int screenWidth;
        AnimatorSet animatorSet = this.f93054d;
        if (animatorSet != null) {
            return animatorSet;
        }
        if (this.f93059m == null) {
            return null;
        }
        int[] iArr = new int[2];
        iArr[0] = 0;
        if (this.E == 16) {
            screenWidth = bz.j();
        } else {
            screenWidth = DisplayUtil.getScreenWidth();
        }
        iArr[1] = screenWidth / 2;
        ValueAnimator ofInt = ValueAnimator.ofInt(iArr);
        this.f93057h = ofInt;
        ofInt.setDuration(800L);
        lc0.a aVar = new lc0.a(0.0f, 0.0f, 0.25f, 1.0f);
        this.f93057h.setInterpolator(aVar);
        this.f93057h.addUpdateListener(new c(this, this.E));
        ValueAnimator ofInt2 = ValueAnimator.ofInt(0, 255);
        this.f93055e = ofInt2;
        ofInt2.setDuration(600L);
        ValueAnimator ofInt3 = ValueAnimator.ofInt(255, 0);
        this.f93056f = ofInt3;
        ofInt3.setDuration(200L);
        this.f93058i = new AnimatorSet();
        this.f93056f.addUpdateListener(new b(this));
        this.f93058i.setInterpolator(aVar);
        this.f93058i.playSequentially(this.f93055e, this.f93056f);
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.f93054d = animatorSet2;
        animatorSet2.playTogether(this.f93057h, this.f93058i);
        this.f93054d.setStartDelay(200L);
        this.C = new a(this);
        return this.f93054d;
    }

    public View o0() {
        View view = this.f93059m;
        if (view != null) {
            return view;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void p0() {
        this.D = false;
        if (this.F != null) {
            RFWThreadManager.getUIHandler().removeCallbacks(this.F);
        }
        View view = this.f93059m;
        if (view != null) {
            view.getLayoutParams().width = 0;
            this.f93059m.getLayoutParams().height = ImmersiveUtils.dpToPx(1.0f);
            View view2 = this.f93059m;
            view2.setLayoutParams(view2.getLayoutParams());
            this.f93059m.setVisibility(8);
        }
        ValueAnimator valueAnimator = this.f93055e;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.f93055e.cancel();
            this.f93055e = null;
        }
        ValueAnimator valueAnimator2 = this.f93056f;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllUpdateListeners();
            this.f93056f.cancel();
            this.f93056f = null;
        }
        ValueAnimator valueAnimator3 = this.f93057h;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
            this.f93057h.cancel();
            this.f93057h = null;
        }
        AnimatorSet animatorSet = this.f93058i;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
            this.f93058i.cancel();
            this.f93058i = null;
        }
        AnimatorSet animatorSet2 = this.f93054d;
        if (animatorSet2 != null) {
            animatorSet2.removeAllListeners();
            this.f93054d.cancel();
            this.f93054d = null;
            this.C = null;
        }
    }

    public void q0() {
        View view = this.f93059m;
        if (view != null) {
            view.setVisibility(0);
        }
        this.f93054d = n0();
        if (!this.D) {
            RFWThreadManager.getUIHandler().removeCallbacks(this.F);
            RFWThreadManager.getUIHandler().postDelayed(this.F, 800L);
            this.D = true;
        }
    }

    public void setLoadingView(View view) {
        this.f93059m = view;
    }

    public void setScreenOrientation(int i3) {
        this.E = i3;
    }

    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public void setReportBean(Object obj) {
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object obj, int i3) {
    }
}
