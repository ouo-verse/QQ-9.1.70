package com.qzone.reborn.qzmoment.util;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.compat.RFLiuHaiUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZMSlidBottomView extends FrameLayout {
    private int C;
    private int D;
    private int E;
    private int F;
    private boolean G;
    private View H;
    private ObjectAnimator I;
    private ObjectAnimator J;
    private ObjectAnimator K;
    private c L;
    private boolean M;

    /* renamed from: d, reason: collision with root package name */
    protected Interpolator f59034d;

    /* renamed from: e, reason: collision with root package name */
    protected Interpolator f59035e;

    /* renamed from: f, reason: collision with root package name */
    private float f59036f;

    /* renamed from: h, reason: collision with root package name */
    private int f59037h;

    /* renamed from: i, reason: collision with root package name */
    private int f59038i;

    /* renamed from: m, reason: collision with root package name */
    private int f59039m;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface c {
        void a();

        void b();
    }

    public QZMSlidBottomView(Context context) {
        super(context);
        this.f59034d = new ss.b(0.39f, 0.0f, 0.23f, 1.0f);
        this.f59035e = new ss.b(0.39f, 0.0f, 0.23f, 1.0f);
    }

    private void d(MotionEvent motionEvent) {
        if (motionEvent.getY() < this.H.getTop()) {
            this.D = this.H.getTop();
            c();
        }
    }

    private void e() {
        this.C = this.H.getTop();
        this.E = this.H.getBottom();
    }

    private void f() {
        ObjectAnimator objectAnimator = this.I;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator objectAnimator2 = this.J;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
        ObjectAnimator objectAnimator3 = this.K;
        if (objectAnimator3 != null) {
            objectAnimator3.cancel();
        }
    }

    public void c() {
        int scrollY = getScrollY();
        QLog.d("QFSSlidBottomView", 1, "dismissView currentY:" + scrollY);
        ObjectAnimator objectAnimator = this.K;
        if (objectAnimator == null || !objectAnimator.isRunning()) {
            ObjectAnimator duration = ObjectAnimator.ofInt(this, "ScrollY", scrollY, -getHeight()).setDuration(300L);
            this.K = duration;
            duration.setInterpolator(this.f59035e);
            this.K.addListener(new b());
            this.K.start();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.M) {
            return true;
        }
        if (this.H != null && !this.G) {
            e();
            this.G = true;
        }
        if (motionEvent.getAction() == 0) {
            d(motionEvent);
            this.f59036f = motionEvent.getRawY();
        } else if (motionEvent.getAction() == 2) {
            f();
            this.f59036f = motionEvent.getRawY();
        } else if (motionEvent.getAction() == 1 && this.f59036f < this.F) {
            d(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setContentHeight(int i3) {
        this.F = i3;
    }

    public void setSlidAnimListener(c cVar) {
        this.L = cVar;
    }

    public void g(View view) {
        ObjectAnimator duration = ObjectAnimator.ofInt(this, "ScrollY", -this.f59037h, 0).setDuration(300L);
        this.I = duration;
        duration.addListener(new a());
        this.H = view;
        setVisibility(0);
        this.I.setInterpolator(this.f59034d);
        this.I.start();
    }

    public QZMSlidBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f59034d = new ss.b(0.39f, 0.0f, 0.23f, 1.0f);
        this.f59035e = new ss.b(0.39f, 0.0f, 0.23f, 1.0f);
        int i3 = 0;
        int statusBarHeight = ImmersiveUtils.isSupporImmersive() == 1 ? ImmersiveUtils.getStatusBarHeight(context) - 1 : 0;
        Activity activity = (Activity) context;
        if (RFLiuHaiUtils.enableNotch(activity)) {
            RFLiuHaiUtils.initLiuHaiBarHeight(activity);
            i3 = RFLiuHaiUtils.liuHaiTopBarHeight();
        }
        this.f59039m = Math.max(statusBarHeight, i3);
        int screenCommonAreaHeight = DisplayUtil.getScreenCommonAreaHeight(context);
        int i16 = this.f59039m;
        int i17 = screenCommonAreaHeight + i16;
        this.f59038i = i17;
        this.f59037h = i17 - i16;
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements Animator.AnimatorListener {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (QZMSlidBottomView.this.L != null) {
                QZMSlidBottomView.this.L.b();
            }
            QZMSlidBottomView.this.M = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (QZMSlidBottomView.this.L != null) {
                QZMSlidBottomView.this.L.a();
            }
            QZMSlidBottomView.this.M = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QZMSlidBottomView.this.setVisibility(8);
            QLog.d("QFSSlidBottomView", 1, " onAnimationEnd");
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
}
