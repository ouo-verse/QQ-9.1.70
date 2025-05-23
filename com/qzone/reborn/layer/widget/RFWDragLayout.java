package com.qzone.reborn.layer.widget;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.qzone.reborn.layer.widget.RFWDragLayout;
import com.tencent.biz.richframework.compat.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes37.dex */
public class RFWDragLayout extends FrameLayout {
    private static final int K = ImmersiveUtils.getScreenHeight();
    private final PointF C;
    private boolean D;
    private int E;
    private int F;
    private long G;
    private int H;
    private int I;
    private View J;

    /* renamed from: d, reason: collision with root package name */
    private boolean f58227d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f58228e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f58229f;

    /* renamed from: h, reason: collision with root package name */
    private final ColorDrawable f58230h;

    /* renamed from: i, reason: collision with root package name */
    private final PointF f58231i;

    /* renamed from: m, reason: collision with root package name */
    private final PointF f58232m;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface a {
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface b {
    }

    public RFWDragLayout(Context context) {
        this(context, null);
    }

    private void b() {
        final float translationX = e().getTranslationX();
        final float translationY = e().getTranslationY();
        final float scaleX = e().getScaleX();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: vk.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                RFWDragLayout.this.h(translationX, translationY, scaleX, valueAnimator);
            }
        });
        ofFloat.setDuration(200L);
        ofFloat.start();
    }

    private int c(float f16, float f17) {
        boolean z16 = Math.abs(f16) > Math.abs(f17);
        if (z16 && this.f58228e && f16 > this.E) {
            return 1;
        }
        return (z16 || !this.f58229f || f17 <= ((float) this.E)) ? 0 : 2;
    }

    private void f() {
        this.E = (int) (ViewConfiguration.get(getContext()).getScaledTouchSlop() * 3.0f);
        setWillNotDraw(false);
        this.J = this;
    }

    private boolean g(PointF pointF, float f16, float f17, long j3) {
        float f18 = f16 - pointF.x;
        float f19 = f17 - pointF.y;
        float f26 = ((float) j3) / 1000.0f;
        float f27 = f18 / f26;
        int i3 = K;
        return f27 > ((float) i3) || f19 / f26 > ((float) i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(float f16, float f17, float f18, ValueAnimator valueAnimator) {
        float animatedFraction = 1.0f - valueAnimator.getAnimatedFraction();
        e().setTranslationX(f16 * animatedFraction);
        e().setTranslationY(f17 * animatedFraction);
        float f19 = 1.0f - f18;
        j((valueAnimator.getAnimatedFraction() * f19) + f18);
        setWindowBgAlpha(f18 + (f19 * valueAnimator.getAnimatedFraction()));
    }

    private void i(float f16, float f17) {
        e().setTranslationX(e().getTranslationX() + f16);
        e().setTranslationY(e().getTranslationY() + f17);
    }

    private void j(float f16) {
        setPivotX(e().getWidth() / 2.0f);
        setPivotY(e().getHeight() / 2.0f);
        e().setScaleX(f16);
        e().setScaleY(f16);
    }

    public View e() {
        return this.J;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.I > 0) {
            canvas.clipRect(0, this.H, getWidth(), this.H + this.I);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f58227d) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.G = System.currentTimeMillis();
            this.f58231i.set(motionEvent.getRawX(), motionEvent.getRawY());
        } else if (action == 2) {
            int c16 = c(motionEvent.getRawX() - this.f58231i.x, motionEvent.getRawY() - this.f58231i.y);
            this.F = c16;
            if (this.D || c16 == 1 || c16 == 2) {
                this.D = true;
                this.f58232m.set(motionEvent.getRawX(), motionEvent.getRawY());
                this.C.set(motionEvent.getRawX(), motionEvent.getRawY());
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0014, code lost:
    
        if (r0 != 3) goto L18;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f58227d) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                PointF pointF = this.f58232m;
                float f16 = rawX - pointF.x;
                float f17 = rawY - pointF.y;
                pointF.set(rawX, rawY);
                int i3 = this.F;
                PointF pointF2 = this.C;
                float d16 = d(i3, rawX - pointF2.x, rawY - pointF2.y, getWidth() * 1.5f, getHeight() * 1.5f);
                j(d16);
                i(f16, f17);
                setWindowBgAlpha(d16);
            }
            return super.onTouchEvent(motionEvent);
        }
        this.D = false;
        this.F = 0;
        boolean g16 = g(this.f58231i, motionEvent.getRawX(), motionEvent.getRawY(), System.currentTimeMillis() - this.G);
        if (e().getScaleX() >= 0.7f && !g16) {
            b();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setClipVertical(int i3, int i16) {
        this.H = i3;
        this.I = i16;
    }

    public void setEnableDragHorizontal(boolean z16) {
        this.f58228e = z16;
    }

    public void setEnableDragVertical(boolean z16) {
        this.f58229f = z16;
    }

    public void setFeatureEnable(boolean z16) {
        this.f58227d = z16;
    }

    public void setTargetDragView(View view) {
        this.J = view;
    }

    public RFWDragLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RFWDragLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f58230h = new ColorDrawable(-33554432);
        this.f58231i = new PointF();
        this.f58232m = new PointF();
        this.C = new PointF();
        f();
    }

    public void setWindowBgAlpha(float f16) {
        int i3 = (int) (f16 * 1.0f * 255.0f);
        if (i3 < 0) {
            i3 = 0;
        } else if (i3 > 255) {
            i3 = 255;
        }
        this.f58230h.setAlpha(i3);
        if (getContext() instanceof Activity) {
            ((Activity) getContext()).getWindow().setBackgroundDrawable(this.f58230h);
        }
    }

    public void setDragInterceptDelegate(a aVar) {
    }

    public void setOnDragListener(b bVar) {
    }

    private float d(int i3, float f16, float f17, float f18, float f19) {
        float f26 = i3 != 1 ? i3 != 2 ? 1.0f : 1.0f - (f17 / f19) : 1.0f - (f16 / f18);
        if (f26 < 0.5f) {
            return 0.5f;
        }
        return Math.min(f26, 1.0f);
    }
}
