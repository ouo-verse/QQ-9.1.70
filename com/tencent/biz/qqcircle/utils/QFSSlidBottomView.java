package com.tencent.biz.qqcircle.utils;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.utils.QCircleSlidBottomView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.compat.RFLiuHaiUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSSlidBottomView extends FrameLayout {
    private int C;
    private View D;
    private ObjectAnimator E;
    private ObjectAnimator F;
    private ObjectAnimator G;
    protected Interpolator H;
    protected Interpolator I;
    private int J;
    private int K;
    private int L;
    private List<QCircleSlidBottomView.d> M;
    private boolean N;

    /* renamed from: d, reason: collision with root package name */
    private float f92622d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f92623e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f92624f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f92625h;

    /* renamed from: i, reason: collision with root package name */
    private int f92626i;

    /* renamed from: m, reason: collision with root package name */
    private int f92627m;

    public QFSSlidBottomView(@NonNull Context context) {
        super(context);
        this.H = new lc0.a(0.39f, 0.0f, 0.23f, 1.0f);
        this.I = new lc0.a(0.39f, 0.0f, 0.23f, 1.0f);
        this.M = new ArrayList();
        this.N = true;
    }

    private void e(MotionEvent motionEvent) {
        if (motionEvent.getY() < this.D.getTop()) {
            this.f92627m = this.D.getTop();
            d();
        }
    }

    private void f() {
        int top = this.D.getTop();
        this.f92626i = top;
        this.f92627m = top;
        this.C = this.D.getBottom();
    }

    private boolean g() {
        int i3 = this.C;
        int i16 = this.f92627m;
        if (i3 - i16 < i16 - this.f92626i) {
            return true;
        }
        return false;
    }

    private void h(int i3) {
        if (this.f92624f) {
            return;
        }
        this.f92627m += i3;
        i();
        int i16 = this.f92627m;
        if (i16 >= this.f92626i) {
            scrollBy(0, -i3);
        } else {
            this.f92627m = i16 - i3;
        }
    }

    private void i() {
        ObjectAnimator objectAnimator = this.E;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator objectAnimator2 = this.F;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
        ObjectAnimator objectAnimator3 = this.G;
        if (objectAnimator3 != null) {
            objectAnimator3.cancel();
        }
    }

    private void k() {
        if (this.f92623e && !this.f92624f && this.D != null) {
            if (g()) {
                d();
                return;
            }
            ObjectAnimator duration = ObjectAnimator.ofInt(this, "ScrollY", getScrollY(), 0).setDuration(200L);
            this.F = duration;
            duration.setInterpolator(this.H);
            this.F.start();
            f();
        }
    }

    public void c(QCircleSlidBottomView.d dVar) {
        this.M.add(dVar);
    }

    public void d() {
        int scrollY = getScrollY();
        QLog.d("QFSSlidBottomView", 1, "dismissView currentY:" + scrollY);
        ObjectAnimator objectAnimator = this.G;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            return;
        }
        ObjectAnimator duration = ObjectAnimator.ofInt(this, "ScrollY", scrollY, -getHeight()).setDuration(300L);
        this.G = duration;
        duration.setInterpolator(this.I);
        this.G.addListener(new b());
        this.G.start();
    }

    public void j(View view) {
        this.E = ObjectAnimator.ofInt(this, "ScrollY", -this.J, 0).setDuration(300L);
        this.D = view;
        setVisibility(0);
        this.E.addListener(new a());
        this.E.setInterpolator(this.H);
        this.E.start();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        if (this.D != null) {
            f();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.N) {
            return true;
        }
        if (this.D != null && !this.f92625h) {
            f();
            this.f92625h = true;
        }
        if (motionEvent.getAction() == 0) {
            e(motionEvent);
            this.f92622d = motionEvent.getRawY();
        } else if (motionEvent.getAction() == 2) {
            float rawY = motionEvent.getRawY() - this.f92622d;
            this.f92622d = motionEvent.getRawY();
            h((int) rawY);
            this.f92623e = true;
        } else if (motionEvent.getAction() == 1) {
            k();
            this.f92623e = false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setEnableOperate(boolean z16) {
        this.N = z16;
    }

    public QFSSlidBottomView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.H = new lc0.a(0.39f, 0.0f, 0.23f, 1.0f);
        this.I = new lc0.a(0.39f, 0.0f, 0.23f, 1.0f);
        this.M = new ArrayList();
        this.N = true;
        int i3 = 0;
        int statusBarHeight = ImmersiveUtils.isSupporImmersive() == 1 ? ImmersiveUtils.getStatusBarHeight(context) - 1 : 0;
        Activity activity = (Activity) context;
        if (RFLiuHaiUtils.enableNotch(activity)) {
            RFLiuHaiUtils.initLiuHaiBarHeight(activity);
            i3 = RFLiuHaiUtils.liuHaiTopBarHeight();
        }
        this.L = Math.max(statusBarHeight, i3);
        int screenCommonAreaHeight = DisplayUtil.getScreenCommonAreaHeight(context);
        int i16 = this.L;
        int i17 = screenCommonAreaHeight + i16;
        this.K = i17;
        this.J = i17 - i16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a extends com.tencent.mobileqq.widget.ak {
        a() {
        }

        @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (QFSSlidBottomView.this.M == null) {
                return;
            }
            Iterator it = QFSSlidBottomView.this.M.iterator();
            while (it.hasNext()) {
                ((QCircleSlidBottomView.d) it.next()).a();
            }
        }

        @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (QFSSlidBottomView.this.M == null) {
                return;
            }
            Iterator it = QFSSlidBottomView.this.M.iterator();
            while (it.hasNext()) {
                ((QCircleSlidBottomView.d) it.next()).onShow();
            }
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
    /* loaded from: classes5.dex */
    public class b extends com.tencent.mobileqq.widget.ak {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            QLog.d("QFSSlidBottomView", 1, " onAnimationCancel");
        }

        @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (QFSSlidBottomView.this.M != null) {
                Iterator it = QFSSlidBottomView.this.M.iterator();
                while (it.hasNext()) {
                    ((QCircleSlidBottomView.d) it.next()).onDismiss();
                }
            }
            QFSSlidBottomView.this.setVisibility(8);
            QLog.d("QFSSlidBottomView", 1, " onAnimationEnd");
            QFSSlidBottomView.this.f92624f = false;
        }

        @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            QFSSlidBottomView.this.f92624f = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}
