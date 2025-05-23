package com.tencent.biz.qqcircle.immersive.views;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.richframework.widget.drag.RFWDragLayout;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSRFWDragLayout extends FrameLayout implements GestureDetector.OnGestureListener {
    private static final int R = ImmersiveUtils.getScreenHeight();
    private GestureDetector C;
    private boolean D;
    private final PointF E;
    private final PointF F;
    private final PointF G;
    private boolean H;
    private int I;
    private int J;
    private long K;
    private int L;
    private int M;
    private View N;
    private RFWDragLayout.DragInterceptDelegate P;
    private GestureDetector.OnGestureListener Q;

    /* renamed from: d, reason: collision with root package name */
    private boolean f90445d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f90446e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f90447f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f90448h;

    /* renamed from: i, reason: collision with root package name */
    private RFWDragLayout.OnDragListener f90449i;

    /* renamed from: m, reason: collision with root package name */
    private final ColorDrawable f90450m;

    public QFSRFWDragLayout(@NonNull Context context) {
        this(context, null);
    }

    private void b() {
        final float translationX = e().getTranslationX();
        final float translationY = e().getTranslationY();
        final float scaleX = e().getScaleX();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.immersive.views.ad
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                QFSRFWDragLayout.this.i(translationX, translationY, scaleX, valueAnimator);
            }
        });
        ofFloat.setDuration(200L);
        ofFloat.start();
    }

    private int c(float f16, float f17) {
        boolean z16;
        if (Math.abs(f16) > Math.abs(f17)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && this.f90446e && f16 > this.I) {
            return 1;
        }
        if (this.f90448h) {
            if (z16 || !this.f90447f || Math.abs(f17) <= this.I) {
                return 0;
            }
            return 2;
        }
        if (z16 || !this.f90447f || f17 <= this.I) {
            return 0;
        }
        return 2;
    }

    private float d(int i3, float f16, float f17, float f18, float f19) {
        float f26;
        if (i3 != 1) {
            if (i3 != 2) {
                f26 = 1.0f;
            } else {
                f26 = 1.0f - (f17 / f19);
            }
        } else {
            f26 = 1.0f - (f16 / f18);
        }
        if (f26 < 0.5f) {
            return 0.5f;
        }
        return Math.min(f26, 1.0f);
    }

    private void f() {
        this.I = (int) (ViewConfiguration.get(getContext()).getScaledTouchSlop() * 3.0f);
        setWillNotDraw(false);
        this.N = this;
        this.C = new GestureDetector(getContext(), this, new Handler(Looper.getMainLooper()));
    }

    private boolean h(PointF pointF, float f16, float f17, long j3) {
        float f18 = f16 - pointF.x;
        float f19 = f17 - pointF.y;
        float f26 = ((float) j3) / 1000.0f;
        if (this.f90448h) {
            float f27 = f18 / f26;
            int i3 = R;
            if (f27 <= i3 && Math.abs(f19) / f26 <= i3) {
                return false;
            }
            return true;
        }
        float f28 = f18 / f26;
        int i16 = R;
        if (f28 <= i16 && f19 / f26 <= i16) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(float f16, float f17, float f18, ValueAnimator valueAnimator) {
        float animatedFraction = 1.0f - valueAnimator.getAnimatedFraction();
        e().setTranslationX(f16 * animatedFraction);
        e().setTranslationY(f17 * animatedFraction);
        float f19 = 1.0f - f18;
        k((valueAnimator.getAnimatedFraction() * f19) + f18);
        setWindowBgAlpha(f18 + (f19 * valueAnimator.getAnimatedFraction()));
    }

    private void j(float f16, float f17) {
        e().setTranslationX(e().getTranslationX() + f16);
        e().setTranslationY(e().getTranslationY() + f17);
    }

    private void k(float f16) {
        if (Float.isNaN(f16)) {
            return;
        }
        setPivotX(e().getWidth() / 2.0f);
        setPivotY(e().getHeight() / 2.0f);
        e().setScaleX(f16);
        e().setScaleY(f16);
    }

    public View e() {
        return this.N;
    }

    public boolean g() {
        return this.f90448h;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        GestureDetector.OnGestureListener onGestureListener = this.Q;
        if (onGestureListener != null) {
            return onGestureListener.onDown(motionEvent);
        }
        return false;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.M > 0) {
            canvas.clipRect(0, this.L, getWidth(), this.L + this.M);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
        GestureDetector.OnGestureListener onGestureListener = this.Q;
        if (onGestureListener != null) {
            return onGestureListener.onFling(motionEvent, motionEvent2, f16, f17);
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        if (motionEvent.getPointerCount() == 1) {
            this.C.onTouchEvent(motionEvent);
        }
        if (!this.f90445d) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2) {
                float rawX = motionEvent.getRawX() - this.E.x;
                float rawY = motionEvent.getRawY() - this.E.y;
                RFWDragLayout.DragInterceptDelegate dragInterceptDelegate = this.P;
                if (dragInterceptDelegate != null) {
                    z16 = dragInterceptDelegate.needIntercept(motionEvent, rawX, rawY);
                } else {
                    z16 = true;
                }
                if (z16) {
                    int c16 = c(rawX, rawY);
                    this.J = c16;
                    if (this.H || c16 == 1 || c16 == 2) {
                        RFWDragLayout.OnDragListener onDragListener = this.f90449i;
                        if (onDragListener != null) {
                            onDragListener.onStartDrag();
                        }
                        this.H = true;
                        this.F.set(motionEvent.getRawX(), motionEvent.getRawY());
                        this.G.set(motionEvent.getRawX(), motionEvent.getRawY());
                        return true;
                    }
                }
            }
        } else {
            this.K = System.currentTimeMillis();
            this.E.set(motionEvent.getRawX(), motionEvent.getRawY());
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        GestureDetector.OnGestureListener onGestureListener = this.Q;
        if (onGestureListener != null) {
            onGestureListener.onLongPress(motionEvent);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
        GestureDetector.OnGestureListener onGestureListener = this.Q;
        if (onGestureListener != null) {
            return onGestureListener.onScroll(motionEvent, motionEvent2, f16, f17);
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
        GestureDetector.OnGestureListener onGestureListener = this.Q;
        if (onGestureListener != null) {
            onGestureListener.onShowPress(motionEvent);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        GestureDetector.OnGestureListener onGestureListener = this.Q;
        if (onGestureListener != null) {
            return onGestureListener.onSingleTapUp(motionEvent);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0014, code lost:
    
        if (r0 != 3) goto L30;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f16;
        if (!this.f90445d) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                PointF pointF = this.F;
                float f17 = rawX - pointF.x;
                float f18 = rawY - pointF.y;
                pointF.set(rawX, rawY);
                if (this.f90448h) {
                    f16 = Math.abs(rawY - this.G.y);
                } else {
                    f16 = rawY - this.G.y;
                }
                float d16 = d(this.J, rawX - this.G.x, f16, getWidth() * 1.1f, getHeight() * 1.1f);
                k(d16);
                j(f17, f18);
                setWindowBgAlpha(d16);
                RFWDragLayout.OnDragListener onDragListener = this.f90449i;
                if (onDragListener != null) {
                    onDragListener.onDragging(d16);
                }
            }
            return super.onTouchEvent(motionEvent);
        }
        this.H = false;
        this.J = 0;
        boolean h16 = h(this.E, motionEvent.getRawX(), motionEvent.getRawY(), System.currentTimeMillis() - this.K);
        if (e().getScaleX() >= 0.7f && !h16) {
            RFWDragLayout.OnDragListener onDragListener2 = this.f90449i;
            if (onDragListener2 != null) {
                onDragListener2.onEndDrag(false);
            }
            b();
        } else {
            RFWDragLayout.OnDragListener onDragListener3 = this.f90449i;
            if (onDragListener3 != null) {
                onDragListener3.onEndDrag(true);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setClipVertical(int i3, int i16) {
        this.L = i3;
        this.M = i16;
    }

    public void setDragInterceptDelegate(RFWDragLayout.DragInterceptDelegate dragInterceptDelegate) {
        this.P = dragInterceptDelegate;
    }

    public void setEnableChangeWindowBg(boolean z16) {
        this.D = z16;
    }

    public void setEnableDragHorizontal(boolean z16) {
        this.f90446e = z16;
    }

    public void setEnableDragVertical(boolean z16) {
        this.f90447f = z16;
    }

    public void setEnableDragVerticalUpAction(boolean z16) {
        this.f90448h = z16;
    }

    public void setFeatureEnable(boolean z16) {
        this.f90445d = z16;
    }

    public void setGestureListener(GestureDetector.OnGestureListener onGestureListener) {
        this.Q = onGestureListener;
    }

    public void setOnDragListener(RFWDragLayout.OnDragListener onDragListener) {
        this.f90449i = onDragListener;
    }

    public void setTargetDragView(View view) {
        this.N = view;
    }

    public void setWindowBgAlpha(float f16) {
        if (!this.D) {
            return;
        }
        int i3 = (int) (f16 * 1.0f * 255.0f);
        if (i3 < 0) {
            i3 = 0;
        } else if (i3 > 255) {
            i3 = 255;
        }
        this.f90450m.setAlpha(i3);
        if (getContext() instanceof Activity) {
            ((Activity) getContext()).getWindow().setBackgroundDrawable(this.f90450m);
        }
    }

    public QFSRFWDragLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSRFWDragLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f90450m = new ColorDrawable(-16777216);
        this.D = true;
        this.E = new PointF();
        this.F = new PointF();
        this.G = new PointF();
        f();
    }
}
