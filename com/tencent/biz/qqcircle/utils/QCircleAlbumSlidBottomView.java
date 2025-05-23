package com.tencent.biz.qqcircle.utils;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.compat.RFLiuHaiUtils;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleAlbumSlidBottomView extends FrameLayout {
    public static final int S = cx.a(50.0f);
    private static final int T = cx.a(5.0f);
    private static final int U = cx.a(20.0f);
    private int C;
    private int D;
    private int E;
    protected Interpolator F;
    protected Interpolator G;
    private boolean H;
    private float I;
    private float J;
    private int K;
    private boolean L;
    private final Set<c> M;
    private ObjectAnimator N;
    private ObjectAnimator P;
    private int Q;
    private int R;

    /* renamed from: d, reason: collision with root package name */
    private int f92515d;

    /* renamed from: e, reason: collision with root package name */
    private int f92516e;

    /* renamed from: f, reason: collision with root package name */
    private int f92517f;

    /* renamed from: h, reason: collision with root package name */
    private int f92518h;

    /* renamed from: i, reason: collision with root package name */
    private int f92519i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f92520m;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface c {
        void onDismiss();

        void onScrollChanged(int i3, int i16, int i17, int i18);

        void onShow();
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class d implements Interpolator {

        /* renamed from: a, reason: collision with root package name */
        private double f92523a;

        public d(double d16) {
            this.f92523a = d16;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f16) {
            double d16 = f16;
            double pow = Math.pow(2.0d, (-24.0d) * d16);
            double d17 = this.f92523a;
            return (float) ((pow * Math.sin(((d16 - (d17 / 10.0d)) * 6.283185307179586d) / d17)) + 1.0d);
        }
    }

    public QCircleAlbumSlidBottomView(@NonNull Context context) {
        this(context, null);
    }

    private int e() {
        View decorView;
        int max = Math.max(ImmersiveUtils.getScreenHeight(), ImmersiveUtils.getScreenWidth()) + Math.max(this.f92516e, this.E) + DisplayUtil.getNavigationBarHeight(QCircleApplication.getAPP());
        if (getContext() instanceof Activity) {
            Window window = ((Activity) getContext()).getWindow();
            if (window == null) {
                decorView = null;
            } else {
                decorView = window.getDecorView();
            }
            if (decorView == null) {
                return max;
            }
            return Math.max(decorView.getMeasuredHeight(), decorView.getMeasuredWidth());
        }
        return max;
    }

    private boolean j() {
        if (this.Q == 2) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        Iterator<c> it = this.M.iterator();
        while (it.hasNext()) {
            it.next().onDismiss();
        }
    }

    private void m(int i3, int i16, int i17, int i18) {
        Iterator<c> it = this.M.iterator();
        while (it.hasNext()) {
            it.next().onScrollChanged(i3, i16, i17, i18);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        Iterator<c> it = this.M.iterator();
        while (it.hasNext()) {
            it.next().onShow();
        }
    }

    private void p(@NonNull View view) {
        if (j()) {
            view.setPadding(0, 0, 0, 0);
        } else {
            view.setPadding(0, 0, 0, this.f92515d + T);
        }
    }

    public void c(c cVar) {
        if (cVar == null) {
            return;
        }
        this.M.add(cVar);
    }

    public void d() {
        String str;
        int i3;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        QLog.d("QCircleSlidBottomView", 1, "[dismissView] currentX: " + scrollX + " | currentY:" + scrollY);
        if (j()) {
            str = "ScrollX";
        } else {
            str = "ScrollY";
        }
        if (!j()) {
            scrollX = scrollY;
        }
        if (j()) {
            i3 = -this.K;
        } else {
            i3 = (-this.K) / 2;
        }
        ObjectAnimator duration = ObjectAnimator.ofInt(this, str, scrollX, i3).setDuration(200L);
        this.P = duration;
        duration.setInterpolator(this.G);
        this.P.addListener(new b());
        this.P.start();
        this.C = -1;
    }

    public float g() {
        int i3;
        if (j()) {
            i3 = this.K;
        } else {
            i3 = this.f92518h;
        }
        return i3;
    }

    public int h() {
        return -this.K;
    }

    public int i() {
        return this.K;
    }

    public boolean k() {
        if (this.C > -1) {
            return true;
        }
        return false;
    }

    public void o() {
        String str;
        int i3;
        int i16;
        int i17;
        int i18;
        if (this.C == 0 && !this.L) {
            return;
        }
        if (j()) {
            str = "ScrollX";
        } else {
            str = "ScrollY";
        }
        if (this.L) {
            this.C = 2;
            if (this.f92520m) {
                i16 = this.f92519i;
            } else {
                i16 = 0;
            }
            if (j()) {
                i18 = this.K;
                i17 = 0;
            } else {
                i17 = (-this.K) / 2;
                i18 = (this.D / 2) - i16;
            }
            this.N = ObjectAnimator.ofInt(this, str, i17, i18).setDuration(250L);
            QLog.d("QCircleSlidBottomView", 1, "[showView] STATE_FIX pointOne: " + i17 + " | pointTwo: " + i18);
        } else {
            this.C = 0;
            if (j()) {
                i3 = 0;
            } else {
                i3 = (-this.K) / 2;
            }
            this.N = ObjectAnimator.ofInt(this, str, i3, 0).setDuration(250L);
            QLog.d("QCircleSlidBottomView", 1, "[showView] STATE_HALF pointOne: " + i3 + " | pointTwo: 0");
        }
        setVisibility(0);
        this.N.addListener(new a());
        this.N.start();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        if (motionEvent.getAction() == 0) {
            this.I = motionEvent.getY();
            this.J = motionEvent.getX();
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 2) {
            float y16 = motionEvent.getY() - this.I;
            float x16 = motionEvent.getX() - this.J;
            if (!j() ? y16 > 0.0f : x16 > 0.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && this.H) {
                return true;
            }
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        int childCount = getChildCount();
        int i19 = this.f92518h;
        for (int i26 = 0; i26 < childCount; i26++) {
            View childAt = getChildAt(i26);
            if (i26 == 0) {
                p(childAt);
            }
            if (j()) {
                int e16 = e();
                childAt.layout(e16, 0, childAt.getMeasuredWidth() + e16, childAt.getMeasuredHeight());
            } else {
                childAt.layout(0, i19, childAt.getMeasuredWidth(), childAt.getMeasuredHeight() + i19 + T);
            }
        }
        QLog.d("QCircleSlidBottomView", 1, "[onLayout] mPanelHeight: " + this.K + " | newTop: " + i19);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i3, int i16, int i17, int i18) {
        m(i3, i16, i17, i18);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.I = motionEvent.getY();
            this.J = motionEvent.getX();
        } else if (motionEvent.getAction() == 2) {
            float y16 = motionEvent.getY() - this.I;
            float x16 = motionEvent.getX() - this.J;
            boolean z16 = false;
            if (!j() ? y16 > U : x16 > U) {
                z16 = true;
            }
            if (z16) {
                d();
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setPanelSize(int i3) {
        this.K = i3;
    }

    public void setParentConsumeEvent(boolean z16) {
        this.H = z16;
    }

    public void setStatusListener(c cVar) {
        if (cVar == null) {
            return;
        }
        this.M.remove(cVar);
    }

    public QCircleAlbumSlidBottomView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QCircleAlbumSlidBottomView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.C = -2;
        this.F = new d(1.0d);
        this.G = new AccelerateInterpolator();
        this.H = false;
        this.M = new CopyOnWriteArraySet();
        this.Q = 1;
        this.R = 0;
        ViewConfiguration.get(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, y91.a.L5);
        float f16 = obtainStyledAttributes.getFloat(y91.a.R5, 0.5f);
        this.f92515d = (int) obtainStyledAttributes.getDimension(y91.a.N5, 0.0f);
        this.L = obtainStyledAttributes.getBoolean(y91.a.Q5, false);
        this.f92520m = obtainStyledAttributes.getBoolean(y91.a.T5, true);
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            this.f92516e = ImmersiveUtils.getStatusBarHeight(context) - 1;
        }
        Activity activity = (Activity) context;
        if (RFLiuHaiUtils.enableNotch(activity)) {
            RFLiuHaiUtils.initLiuHaiBarHeight(activity);
            this.E = RFLiuHaiUtils.liuHaiTopBarHeight();
        }
        this.Q = obtainStyledAttributes.getInt(y91.a.O5, 1);
        int screenCommonAreaHeight = DisplayUtil.getScreenCommonAreaHeight(context) + Math.max(this.f92516e, this.E);
        this.D = screenCommonAreaHeight;
        this.f92518h = (int) (screenCommonAreaHeight * f16);
        this.f92517f = (int) obtainStyledAttributes.getDimension(y91.a.S5, S);
        this.f92519i = (int) (this.D / 6.0f);
        int dimension = (int) obtainStyledAttributes.getDimension(y91.a.P5, 0.0f);
        obtainStyledAttributes.recycle();
        this.R = DisplayUtil.checkDeviceHasNavigationBar(getContext()) ? cx.d(getContext()) : 0;
        if (dimension == 0) {
            this.K = (this.D - (this.L ? this.f92519i : this.f92517f)) - Math.max(this.f92516e, this.E);
        } else {
            this.K = j() ? f(dimension) : dimension;
        }
        QLog.d("QCircleSlidBottomView", 1, "[QCircleAlbumSlidBottomView] isFix = " + this.L + " | mPanelHeight: " + this.K + " | mScreenHeight: " + this.D + " | mNavigationBarHeight: " + this.R);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a extends com.tencent.mobileqq.widget.ak {
        a() {
        }

        @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            QCircleAlbumSlidBottomView.this.n();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
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

        @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QCircleAlbumSlidBottomView.this.l();
            QCircleAlbumSlidBottomView.this.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    private int f(int i3) {
        return i3;
    }
}
