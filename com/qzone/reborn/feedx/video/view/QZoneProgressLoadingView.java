package com.qzone.reborn.feedx.video.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import com.qzone.reborn.feedx.widget.i;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.lang.ref.WeakReference;

/* loaded from: classes37.dex */
public class QZoneProgressLoadingView extends QZoneBaseWidgetView {
    private View C;
    private a D;
    private boolean E;
    private int F;
    private Runnable G;

    /* renamed from: e, reason: collision with root package name */
    private AnimatorSet f55860e;

    /* renamed from: f, reason: collision with root package name */
    private ValueAnimator f55861f;

    /* renamed from: h, reason: collision with root package name */
    private ValueAnimator f55862h;

    /* renamed from: i, reason: collision with root package name */
    private ValueAnimator f55863i;

    /* renamed from: m, reason: collision with root package name */
    private AnimatorSet f55864m;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes37.dex */
    public static class a implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<QZoneProgressLoadingView> f55865d;

        public a(QZoneProgressLoadingView qZoneProgressLoadingView) {
            this.f55865d = new WeakReference<>(qZoneProgressLoadingView);
        }

        private boolean a() {
            WeakReference<QZoneProgressLoadingView> weakReference = this.f55865d;
            QZoneProgressLoadingView qZoneProgressLoadingView = weakReference == null ? null : weakReference.get();
            return qZoneProgressLoadingView != null && qZoneProgressLoadingView.E;
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
    /* loaded from: classes37.dex */
    public static class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<QZoneProgressLoadingView> f55866d;

        b(QZoneProgressLoadingView qZoneProgressLoadingView) {
            this.f55866d = new WeakReference<>(qZoneProgressLoadingView);
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            QZoneProgressLoadingView qZoneProgressLoadingView;
            View q06;
            WeakReference<QZoneProgressLoadingView> weakReference = this.f55866d;
            if (weakReference == null || (qZoneProgressLoadingView = weakReference.get()) == null || (q06 = qZoneProgressLoadingView.q0()) == null || q06.getBackground() == null) {
                return;
            }
            i.a(q06, ((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes37.dex */
    public static class c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<QZoneProgressLoadingView> f55867d;

        /* renamed from: e, reason: collision with root package name */
        private int f55868e;

        c(QZoneProgressLoadingView qZoneProgressLoadingView, int i3) {
            this.f55868e = 16;
            this.f55867d = new WeakReference<>(qZoneProgressLoadingView);
            this.f55868e = i3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            QZoneProgressLoadingView qZoneProgressLoadingView;
            View q06;
            int screenHeight;
            WeakReference<QZoneProgressLoadingView> weakReference = this.f55867d;
            if (weakReference == null || (qZoneProgressLoadingView = weakReference.get()) == null || (q06 = qZoneProgressLoadingView.q0()) == null || q06.getLayoutParams() == null) {
                return;
            }
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (this.f55868e == 16) {
                screenHeight = DisplayUtil.getScreenWidth();
            } else {
                screenHeight = DisplayUtil.getScreenHeight();
            }
            q06.setX((screenHeight / 2) - intValue);
            q06.getLayoutParams().width = intValue * 2;
            q06.getLayoutParams().height = ImmersiveUtils.dpToPx(1.0f);
            q06.setLayoutParams(q06.getLayoutParams());
        }
    }

    public QZoneProgressLoadingView(Context context) {
        super(context);
        this.E = false;
        this.F = 16;
        this.G = new Runnable() { // from class: com.qzone.reborn.feedx.video.view.QZoneProgressLoadingView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QZoneProgressLoadingView.this.f55860e != null) {
                    QZoneProgressLoadingView.this.f55860e.removeAllListeners();
                    if (QZoneProgressLoadingView.this.D != null) {
                        QZoneProgressLoadingView.this.f55860e.addListener(QZoneProgressLoadingView.this.D);
                    }
                    QZoneProgressLoadingView.this.f55860e.start();
                }
            }
        };
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public AnimatorSet p0() {
        int screenHeight;
        AnimatorSet animatorSet = this.f55860e;
        if (animatorSet != null) {
            return animatorSet;
        }
        if (this.C == null) {
            return null;
        }
        int[] iArr = new int[2];
        iArr[0] = 0;
        if (this.F == 16) {
            screenHeight = DisplayUtil.getScreenWidth();
        } else {
            screenHeight = DisplayUtil.getScreenHeight();
        }
        iArr[1] = screenHeight / 2;
        ValueAnimator ofInt = ValueAnimator.ofInt(iArr);
        this.f55863i = ofInt;
        ofInt.setDuration(800L);
        nh.a aVar = new nh.a(0.0f, 0.0f, 0.25f, 1.0f);
        this.f55863i.setInterpolator(aVar);
        this.f55863i.addUpdateListener(new c(this, this.F));
        ValueAnimator ofInt2 = ValueAnimator.ofInt(0, 255);
        this.f55861f = ofInt2;
        ofInt2.setDuration(600L);
        ValueAnimator ofInt3 = ValueAnimator.ofInt(255, 0);
        this.f55862h = ofInt3;
        ofInt3.setDuration(200L);
        this.f55864m = new AnimatorSet();
        this.f55862h.addUpdateListener(new b(this));
        this.f55864m.setInterpolator(aVar);
        this.f55864m.playSequentially(this.f55861f, this.f55862h);
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.f55860e = animatorSet2;
        animatorSet2.playTogether(this.f55863i, this.f55864m);
        this.f55860e.setStartDelay(200L);
        this.D = new a(this);
        return this.f55860e;
    }

    public View q0() {
        View view = this.C;
        if (view != null) {
            return view;
        }
        return null;
    }

    public void s0() {
        View view = this.C;
        if (view != null) {
            view.setVisibility(0);
        }
        this.f55860e = p0();
        if (this.E) {
            return;
        }
        RFWThreadManager.getUIHandler().removeCallbacks(this.G);
        RFWThreadManager.getUIHandler().postDelayed(this.G, 800L);
        this.E = true;
    }

    public void setLoadingView(View view) {
        this.C = view;
    }

    public void setScreenOrientation(int i3) {
        this.F = i3;
    }

    public void r0() {
        this.E = false;
        if (this.G != null) {
            RFWThreadManager.getUIHandler().removeCallbacks(this.G);
        }
        View view = this.C;
        if (view != null) {
            view.getLayoutParams().width = 0;
            this.C.getLayoutParams().height = ImmersiveUtils.dpToPx(1.0f);
            View view2 = this.C;
            view2.setLayoutParams(view2.getLayoutParams());
            this.C.setVisibility(8);
        }
        ValueAnimator valueAnimator = this.f55861f;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.f55861f.cancel();
            this.f55861f = null;
        }
        ValueAnimator valueAnimator2 = this.f55862h;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllUpdateListeners();
            this.f55862h.cancel();
            this.f55862h = null;
        }
        ValueAnimator valueAnimator3 = this.f55863i;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
            this.f55863i.cancel();
            this.f55863i = null;
        }
        AnimatorSet animatorSet = this.f55864m;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
            this.f55864m.cancel();
            this.f55864m = null;
        }
        AnimatorSet animatorSet2 = this.f55860e;
        if (animatorSet2 != null) {
            animatorSet2.removeAllListeners();
            this.f55860e.cancel();
            this.f55860e = null;
            this.D = null;
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object obj, int i3) {
    }
}
