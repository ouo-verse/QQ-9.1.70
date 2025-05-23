package com.tencent.aelight.camera.ae.flashshow.ui.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.aelight.camera.ae.flashshow.util.v;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes32.dex */
public class StartPointSeekBar extends View {

    /* renamed from: o0, reason: collision with root package name */
    private static final String f64824o0 = "StartPointSeekBar";
    private double C;
    private boolean D;
    private Drawable E;
    private Drawable F;
    private Drawable G;
    private Drawable H;
    private boolean I;
    private Drawable J;
    private Drawable K;
    private Drawable L;
    private boolean M;
    private Rect N;
    private Rect P;
    private Rect Q;
    private double R;
    private float S;
    private float T;
    private boolean U;
    private float V;
    private long W;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f64825a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f64826b0;

    /* renamed from: c0, reason: collision with root package name */
    private float f64827c0;

    /* renamed from: d, reason: collision with root package name */
    private final int f64828d;

    /* renamed from: d0, reason: collision with root package name */
    private float f64829d0;

    /* renamed from: e, reason: collision with root package name */
    private final float f64830e;

    /* renamed from: e0, reason: collision with root package name */
    private a f64831e0;

    /* renamed from: f, reason: collision with root package name */
    private final float f64832f;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f64833f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f64834g0;

    /* renamed from: h, reason: collision with root package name */
    private final int f64835h;

    /* renamed from: h0, reason: collision with root package name */
    private Vibrator f64836h0;

    /* renamed from: i, reason: collision with root package name */
    private double f64837i;

    /* renamed from: i0, reason: collision with root package name */
    private final int f64838i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f64839j0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f64840k0;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f64841l0;

    /* renamed from: m, reason: collision with root package name */
    private double f64842m;

    /* renamed from: m0, reason: collision with root package name */
    private float f64843m0;

    /* renamed from: n0, reason: collision with root package name */
    private int f64844n0;

    /* loaded from: classes32.dex */
    public interface a {
        void a(StartPointSeekBar startPointSeekBar);

        void b(StartPointSeekBar startPointSeekBar, int i3);

        void c(StartPointSeekBar startPointSeekBar);
    }

    public StartPointSeekBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f64828d = 200;
        this.R = 0.0d;
        this.V = 0.7f;
        this.W = -1L;
        this.f64844n0 = 255;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ls.a.f415484h, i3, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(12);
        this.G = drawable;
        if (drawable == null) {
            this.G = ResourcesCompat.getDrawable(getResources(), R.drawable.odv, null);
        }
        this.H = obtainStyledAttributes.getDrawable(13);
        this.f64837i = obtainStyledAttributes.getFloat(3, -100.0f);
        this.f64842m = obtainStyledAttributes.getFloat(2, 100.0f);
        double d16 = obtainStyledAttributes.getFloat(5, (float) this.f64837i);
        this.C = d16;
        setProgress(d16);
        this.L = obtainStyledAttributes.getDrawable(0);
        this.J = obtainStyledAttributes.getDrawable(1);
        this.K = obtainStyledAttributes.getDrawable(4);
        this.D = obtainStyledAttributes.getBoolean(10, false);
        this.U = obtainStyledAttributes.getBoolean(11, true);
        this.f64833f0 = obtainStyledAttributes.getBoolean(14, false);
        this.I = obtainStyledAttributes.getBoolean(8, true);
        this.E = obtainStyledAttributes.getDrawable(7);
        this.F = obtainStyledAttributes.getDrawable(9);
        this.M = obtainStyledAttributes.getBoolean(6, true);
        obtainStyledAttributes.recycle();
        this.f64836h0 = (Vibrator) getContext().getSystemService("vibrator");
        if (!this.U) {
            this.V = 1.0f;
        }
        float intrinsicWidth = this.G.getIntrinsicWidth() >> 1;
        this.f64830e = intrinsicWidth;
        float intrinsicHeight = this.G.getIntrinsicHeight() >> 1;
        this.f64832f = intrinsicHeight;
        float f16 = this.V;
        this.f64827c0 = intrinsicWidth * f16;
        this.f64829d0 = intrinsicHeight * f16;
        this.f64838i0 = this.L.getIntrinsicHeight();
        this.N = new Rect();
        this.P = new Rect();
        this.Q = new Rect();
        this.f64835h = (int) intrinsicWidth;
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.f64839j0 = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    private void a() {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
    }

    private void c(Canvas canvas) {
        if (this.I) {
            float k3 = k(this.T);
            int save = canvas.save();
            float f16 = this.S;
            boolean z16 = (f16 >= 0.0f && this.R >= ((double) this.T)) || (f16 <= 0.0f && this.R <= ((double) this.T));
            if (this.E != null && !z16) {
                this.E.setBounds(new Rect((int) (k3 - (this.E.getIntrinsicWidth() / 2)), (getHeight() - this.E.getIntrinsicHeight()) / 2, (int) ((this.E.getIntrinsicWidth() / 2) + k3), (getHeight() + this.E.getIntrinsicHeight()) / 2));
                this.E.draw(canvas);
            }
            if (this.F != null && z16) {
                this.F.setBounds(new Rect((int) (k3 - (this.F.getIntrinsicWidth() / 2)), (getHeight() - this.F.getIntrinsicHeight()) / 2, (int) (k3 + (this.F.getIntrinsicWidth() / 2)), (getHeight() + this.F.getIntrinsicHeight()) / 2));
                this.F.draw(canvas);
            }
            canvas.restoreToCount(save);
        }
    }

    private void e(Canvas canvas) {
        Drawable drawable;
        int save = canvas.save();
        if (!this.f64826b0 && this.f64841l0 && (drawable = this.H) != null) {
            drawable.setBounds(this.Q);
            this.H.draw(canvas);
        } else {
            this.G.setBounds(this.Q);
            this.G.draw(canvas);
        }
        canvas.restoreToCount(save);
    }

    private boolean f(float f16) {
        return i(f16, this.R);
    }

    private float h() {
        return k(this.R);
    }

    private boolean i(float f16, double d16) {
        return Math.abs(f16 - k(d16)) <= this.f64830e + 100.0f;
    }

    private float j(float f16, float f17, float f18) {
        return f16 + ((f17 - f16) * f18);
    }

    private float k(double d16) {
        return (float) (this.f64835h + (d16 * (getWidth() - (this.f64835h * 2))));
    }

    private double l(double d16) {
        double d17 = this.f64837i;
        return d17 + (d16 * (this.f64842m - d17));
    }

    private void m(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (motionEvent.getPointerId(action) == this.f64844n0) {
            int i3 = action == 0 ? 1 : 0;
            this.f64843m0 = motionEvent.getX(i3);
            this.f64844n0 = motionEvent.getPointerId(i3);
        }
    }

    private double q(float f16) {
        if (getWidth() <= this.f64835h * 2) {
            return 0.0d;
        }
        return Math.min(1.0d, Math.max(0.0d, (f16 - r1) / (r0 - (r1 * 2))));
    }

    private void s(MotionEvent motionEvent) {
        float x16 = motionEvent.getX(motionEvent.findPointerIndex(this.f64844n0));
        if (this.M && Math.abs(x16 - k(this.T)) < this.f64839j0) {
            r(this.T);
            if (this.f64834g0 && this.f64833f0 && this.f64836h0 != null) {
                this.f64834g0 = false;
                return;
            }
            return;
        }
        r(q(x16));
        this.f64834g0 = true;
    }

    private double u(double d16) {
        double d17 = this.f64842m;
        double d18 = this.f64837i;
        if (0.0d == d17 - d18) {
            return 0.0d;
        }
        return (d16 - d18) / (d17 - d18);
    }

    protected void b(Canvas canvas) {
        int save = canvas.save();
        this.L.setBounds(this.N);
        if (this.D) {
            canvas.clipRect(this.Q, Region.Op.DIFFERENCE);
        }
        this.L.draw(canvas);
        canvas.restoreToCount(save);
    }

    protected void d(Canvas canvas) {
        if (this.J == null) {
            return;
        }
        int save = canvas.save();
        this.P.set(this.N);
        if (k(u(0.0d)) < k(this.R)) {
            this.P.left = (int) k(u(0.0d));
            this.P.right = (int) k(this.R);
        } else {
            this.P.right = (int) k(u(0.0d));
            this.P.left = (int) k(this.R);
        }
        if (this.D) {
            canvas.clipRect(this.Q, Region.Op.DIFFERENCE);
        }
        this.J.setBounds(this.P);
        this.J.draw(canvas);
        canvas.restoreToCount(save);
    }

    public float g() {
        return (float) l(this.R);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f64826b0 = false;
        if (this.W != -1 && this.U) {
            long currentTimeMillis = System.currentTimeMillis() - this.W;
            if (currentTimeMillis > 0 && currentTimeMillis < 200) {
                this.f64826b0 = true;
                float f16 = (((float) currentTimeMillis) * 1.0f) / 200.0f;
                if (this.f64825a0) {
                    f16 = 1.0f - f16;
                }
                float j3 = j(this.V, 1.0f, f16);
                this.f64827c0 = this.f64830e * j3;
                this.f64829d0 = this.f64832f * j3;
                invalidate();
            }
        }
        this.N.set(this.f64835h, (getHeight() - this.f64838i0) / 2, getWidth() - this.f64835h, (getHeight() + this.f64838i0) / 2);
        int k3 = (int) k(this.R);
        int height = getHeight() / 2;
        Rect rect = this.Q;
        float f17 = k3;
        float f18 = this.f64827c0;
        float f19 = height;
        float f26 = this.f64829d0;
        rect.set((int) (f17 - f18), (int) (f19 - f26), (int) (f17 + f18), (int) (f19 + f26));
        b(canvas);
        d(canvas);
        c(canvas);
        e(canvas);
    }

    @Override // android.view.View
    protected synchronized void onMeasure(int i3, int i16) {
        int max = Math.max(this.G.getIntrinsicWidth(), this.L.getIntrinsicWidth());
        if (View.MeasureSpec.getMode(i3) != 0) {
            max = View.MeasureSpec.getSize(i3);
        }
        int max2 = Math.max(this.G.getIntrinsicHeight(), this.L.getIntrinsicHeight());
        if (View.MeasureSpec.getMode(i16) != 0) {
            max2 = Math.max(max2, View.MeasureSpec.getSize(i16));
        }
        setMeasuredDimension(max, max2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            int pointerId = motionEvent.getPointerId(motionEvent.getPointerCount() - 1);
            this.f64844n0 = pointerId;
            float x16 = motionEvent.getX(motionEvent.findPointerIndex(pointerId));
            this.f64843m0 = x16;
            boolean f16 = f(x16);
            this.f64841l0 = f16;
            if (!f16) {
                return super.onTouchEvent(motionEvent);
            }
            setPressed(false);
            invalidate();
            n();
            s(motionEvent);
            a();
            p(false);
        } else if (action == 1) {
            if (this.f64840k0) {
                p(true);
                s(motionEvent);
                o();
                setPressed(false);
            } else {
                n();
                s(motionEvent);
                o();
            }
            this.f64841l0 = false;
            invalidate();
            a aVar = this.f64831e0;
            if (aVar != null) {
                aVar.b(this, (int) Math.round(l(this.R)));
            }
        } else if (action != 2) {
            if (action == 3) {
                if (this.f64840k0) {
                    o();
                    setPressed(false);
                }
                invalidate();
            } else if (action == 5) {
                int pointerCount = motionEvent.getPointerCount() - 1;
                this.f64843m0 = motionEvent.getX(pointerCount);
                this.f64844n0 = motionEvent.getPointerId(pointerCount);
                invalidate();
            } else if (action == 6) {
                m(motionEvent);
                invalidate();
            }
        } else if (this.f64841l0) {
            if (this.f64840k0) {
                s(motionEvent);
            } else if (Math.abs(motionEvent.getX(motionEvent.findPointerIndex(this.f64844n0)) - this.f64843m0) > this.f64839j0) {
                setPressed(true);
                invalidate();
                n();
                s(motionEvent);
                a();
            }
            a aVar2 = this.f64831e0;
            if (aVar2 != null) {
                aVar2.b(this, (int) Math.round(l(this.R)));
            }
        }
        return true;
    }

    void p(boolean z16) {
        this.W = System.currentTimeMillis();
        this.f64825a0 = z16;
    }

    public void setAbsoluteMinMaxValue(double d16, double d17) {
        this.f64837i = d16;
        this.f64842m = d17;
    }

    public void setDefaultValue(float f16) {
        this.S = f16;
        this.T = (float) u(f16);
        invalidate();
    }

    public void setOnSeekBarChangeListener(a aVar) {
        this.f64831e0 = aVar;
    }

    public void setProgress(double d16) {
        double u16 = u(d16);
        if (u16 <= this.f64842m && u16 >= this.f64837i) {
            this.R = u16;
            invalidate();
            return;
        }
        throw new IllegalArgumentException("Value should be in the middle of max and min value");
    }

    public void setSectionEnable(boolean z16) {
        this.I = z16;
        invalidate();
    }

    void n() {
        this.f64840k0 = true;
        a aVar = this.f64831e0;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    void o() {
        this.f64840k0 = false;
        a aVar = this.f64831e0;
        if (aVar != null) {
            aVar.c(this);
        }
    }

    private void r(double d16) {
        this.R = Math.max(0.0d, d16);
        invalidate();
    }

    public static void t(StartPointSeekBar startPointSeekBar, int i3, TextView textView) {
        if (startPointSeekBar == null || textView == null) {
            return;
        }
        textView.setText(String.valueOf(i3));
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        textView.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredWidth = textView.getMeasuredWidth();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        String str = f64824o0;
        QLog.d(str, 2, "[updateBubble] location[0] = " + startPointSeekBar.getX() + ", seekBar .getThumbImageRelativeLocation() = " + startPointSeekBar.h());
        int x16 = (int) ((startPointSeekBar.getX() + startPointSeekBar.h()) - ((float) (measuredWidth / 2)));
        int y16 = (int) (startPointSeekBar.getY() - ((float) v.a(startPointSeekBar.getContext(), 14.0f)));
        QLog.d(str, 2, "[updateBubble] left = " + x16 + ", top = " + y16);
        layoutParams.leftMargin = x16;
        layoutParams.topMargin = y16;
        textView.setLayoutParams(layoutParams);
    }

    public StartPointSeekBar(Context context) {
        this(context, null);
    }

    public StartPointSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
