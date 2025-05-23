package com.tencent.mobileqq.wink.view;

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
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;

/* loaded from: classes21.dex */
public class StartPointSeekBar extends View {
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
    private int N;
    private Rect P;
    private Rect Q;
    private Rect R;
    private double S;
    private float T;
    private float U;
    private boolean V;
    private float W;

    /* renamed from: a0, reason: collision with root package name */
    private long f326853a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f326854b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f326855c0;

    /* renamed from: d, reason: collision with root package name */
    private final int f326856d;

    /* renamed from: d0, reason: collision with root package name */
    private float f326857d0;

    /* renamed from: e, reason: collision with root package name */
    private final float f326858e;

    /* renamed from: e0, reason: collision with root package name */
    private float f326859e0;

    /* renamed from: f, reason: collision with root package name */
    private final float f326860f;

    /* renamed from: f0, reason: collision with root package name */
    private a f326861f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f326862g0;

    /* renamed from: h, reason: collision with root package name */
    private final int f326863h;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f326864h0;

    /* renamed from: i, reason: collision with root package name */
    private double f326865i;

    /* renamed from: i0, reason: collision with root package name */
    private Vibrator f326866i0;

    /* renamed from: j0, reason: collision with root package name */
    private final int f326867j0;

    /* renamed from: k0, reason: collision with root package name */
    private int f326868k0;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f326869l0;

    /* renamed from: m, reason: collision with root package name */
    private double f326870m;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f326871m0;

    /* renamed from: n0, reason: collision with root package name */
    private float f326872n0;

    /* renamed from: o0, reason: collision with root package name */
    private int f326873o0;

    /* loaded from: classes21.dex */
    public interface a {
        void Fd(StartPointSeekBar startPointSeekBar);

        void uc(StartPointSeekBar startPointSeekBar);

        void wd(StartPointSeekBar startPointSeekBar, int i3);
    }

    public StartPointSeekBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f326856d = 200;
        this.S = 0.0d;
        this.W = 0.7f;
        this.f326853a0 = -1L;
        this.f326873o0 = 255;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.mobileqq.wink.j.N7, i3, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(com.tencent.mobileqq.wink.j.f323117c8);
        this.G = drawable;
        if (drawable == null) {
            this.G = ResourcesCompat.getDrawable(getResources(), R.drawable.odv, null);
        }
        this.H = obtainStyledAttributes.getDrawable(com.tencent.mobileqq.wink.j.f323129d8);
        this.f326865i = obtainStyledAttributes.getFloat(com.tencent.mobileqq.wink.j.R7, -100.0f);
        this.f326870m = obtainStyledAttributes.getFloat(com.tencent.mobileqq.wink.j.Q7, 100.0f);
        double d16 = obtainStyledAttributes.getFloat(com.tencent.mobileqq.wink.j.U7, (float) this.f326865i);
        this.C = d16;
        setProgress(d16);
        this.L = obtainStyledAttributes.getDrawable(com.tencent.mobileqq.wink.j.O7);
        this.J = obtainStyledAttributes.getDrawable(com.tencent.mobileqq.wink.j.P7);
        this.K = obtainStyledAttributes.getDrawable(com.tencent.mobileqq.wink.j.S7);
        this.D = obtainStyledAttributes.getBoolean(com.tencent.mobileqq.wink.j.f323093a8, false);
        this.V = obtainStyledAttributes.getBoolean(com.tencent.mobileqq.wink.j.f323105b8, true);
        this.f326862g0 = obtainStyledAttributes.getBoolean(com.tencent.mobileqq.wink.j.f323141e8, false);
        this.I = obtainStyledAttributes.getBoolean(com.tencent.mobileqq.wink.j.Y7, true);
        this.E = obtainStyledAttributes.getDrawable(com.tencent.mobileqq.wink.j.X7);
        this.F = obtainStyledAttributes.getDrawable(com.tencent.mobileqq.wink.j.Z7);
        this.M = obtainStyledAttributes.getBoolean(com.tencent.mobileqq.wink.j.V7, true);
        this.N = obtainStyledAttributes.getInt(com.tencent.mobileqq.wink.j.W7, -1);
        int i16 = obtainStyledAttributes.getInt(com.tencent.mobileqq.wink.j.T7, 0);
        obtainStyledAttributes.recycle();
        this.f326866i0 = (Vibrator) getContext().getSystemService("vibrator");
        if (!this.V) {
            this.W = 1.0f;
        }
        float intrinsicWidth = this.G.getIntrinsicWidth() >> 1;
        this.f326858e = intrinsicWidth;
        float intrinsicHeight = this.G.getIntrinsicHeight() >> 1;
        this.f326860f = intrinsicHeight;
        float f16 = this.W;
        this.f326857d0 = intrinsicWidth * f16;
        this.f326859e0 = intrinsicHeight * f16;
        this.f326867j0 = i16 > 0 ? ViewUtils.dip2px(i16) : this.L.getIntrinsicHeight();
        this.P = new Rect();
        this.Q = new Rect();
        this.R = new Rect();
        this.f326863h = (int) intrinsicWidth;
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.f326868k0 = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    private void a() {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
    }

    private void c(Canvas canvas) {
        boolean z16;
        if (!this.I) {
            return;
        }
        float l3 = l(this.U);
        int save = canvas.save();
        float f16 = this.T;
        if ((f16 >= 0.0f && this.S >= this.U) || (f16 <= 0.0f && this.S <= this.U)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.E != null && !z16) {
            this.E.setBounds(new Rect((int) (l3 - (this.E.getIntrinsicWidth() / 2)), (getHeight() - this.E.getIntrinsicHeight()) / 2, (int) ((this.E.getIntrinsicWidth() / 2) + l3), (getHeight() + this.E.getIntrinsicHeight()) / 2));
            this.E.draw(canvas);
        }
        if (this.F != null && z16) {
            this.F.setBounds(new Rect((int) (l3 - (this.F.getIntrinsicWidth() / 2)), (getHeight() - this.F.getIntrinsicHeight()) / 2, (int) (l3 + (this.F.getIntrinsicWidth() / 2)), (getHeight() + this.F.getIntrinsicHeight()) / 2));
            this.F.draw(canvas);
        }
        canvas.restoreToCount(save);
    }

    private void e(Canvas canvas) {
        Drawable drawable;
        int save = canvas.save();
        if (!this.f326855c0 && this.f326871m0 && (drawable = this.H) != null) {
            drawable.setBounds(this.R);
            this.H.draw(canvas);
        } else {
            this.G.setBounds(this.R);
            this.G.draw(canvas);
        }
        canvas.restoreToCount(save);
    }

    private boolean f(float f16) {
        return j(f16, this.S);
    }

    private float g() {
        int i3 = this.N;
        if (i3 < 0) {
            return this.f326868k0;
        }
        return (float) (w(i3) * (getWidth() - (this.f326863h * 2)));
    }

    private float i() {
        return l(this.S);
    }

    private boolean j(float f16, double d16) {
        if (Math.abs(f16 - l(d16)) <= this.f326858e + 100.0f) {
            return true;
        }
        return false;
    }

    private float k(float f16, float f17, float f18) {
        return f16 + ((f17 - f16) * f18);
    }

    private float l(double d16) {
        return (float) (this.f326863h + (d16 * (getWidth() - (this.f326863h * 2))));
    }

    private double m(double d16) {
        double d17 = this.f326865i;
        return d17 + (d16 * (this.f326870m - d17));
    }

    private void n(MotionEvent motionEvent) {
        int i3;
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (motionEvent.getPointerId(action) == this.f326873o0) {
            if (action == 0) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            this.f326872n0 = motionEvent.getX(i3);
            this.f326873o0 = motionEvent.getPointerId(i3);
        }
    }

    private double r(float f16) {
        if (getWidth() <= this.f326863h * 2) {
            return 0.0d;
        }
        return Math.min(1.0d, Math.max(0.0d, (f16 - r1) / (r0 - (r1 * 2))));
    }

    private void s(double d16) {
        this.S = Math.max(0.0d, d16);
        invalidate();
    }

    private void t(MotionEvent motionEvent) {
        float x16 = motionEvent.getX(motionEvent.findPointerIndex(this.f326873o0));
        if (this.M && Math.abs(x16 - l(this.U)) < g()) {
            s(this.U);
            if (this.f326864h0 && this.f326862g0 && this.f326866i0 != null) {
                com.tencent.mobileqq.wink.utils.ac.f326659a.b(getContext(), 100L);
                this.f326864h0 = false;
                return;
            }
            return;
        }
        s(r(x16));
        this.f326864h0 = true;
    }

    public static void u(StartPointSeekBar startPointSeekBar, int i3, TextView textView) {
        v(startPointSeekBar, String.valueOf(i3), textView);
    }

    public static void v(StartPointSeekBar startPointSeekBar, String str, TextView textView) {
        if (startPointSeekBar != null && textView != null) {
            textView.setText(str);
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            textView.measure(makeMeasureSpec, makeMeasureSpec);
            int measuredWidth = textView.getMeasuredWidth();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            int x16 = (int) ((startPointSeekBar.getX() + startPointSeekBar.i()) - (measuredWidth / 2));
            int y16 = (int) (startPointSeekBar.getY() - com.tencent.mobileqq.util.x.c(startPointSeekBar.getContext(), 14.0f));
            layoutParams.leftMargin = x16;
            layoutParams.topMargin = y16;
            textView.setLayoutParams(layoutParams);
        }
    }

    private double w(double d16) {
        double d17 = this.f326870m;
        double d18 = this.f326865i;
        if (0.0d == d17 - d18) {
            return 0.0d;
        }
        return (d16 - d18) / (d17 - d18);
    }

    protected void b(Canvas canvas) {
        int save = canvas.save();
        this.L.setBounds(this.P);
        if (this.D) {
            canvas.clipRect(this.R, Region.Op.DIFFERENCE);
        }
        this.L.draw(canvas);
        canvas.restoreToCount(save);
    }

    protected void d(Canvas canvas) {
        if (this.J == null) {
            return;
        }
        int save = canvas.save();
        this.Q.set(this.P);
        if (l(w(0.0d)) < l(this.S)) {
            this.Q.left = (int) l(w(0.0d));
            this.Q.right = (int) l(this.S);
        } else {
            this.Q.right = (int) l(w(0.0d));
            this.Q.left = (int) l(this.S);
        }
        if (this.D) {
            canvas.clipRect(this.R, Region.Op.DIFFERENCE);
        }
        this.J.setBounds(this.Q);
        this.J.draw(canvas);
        canvas.restoreToCount(save);
    }

    public float h() {
        return (float) m(this.S);
    }

    void o() {
        this.f326869l0 = true;
        a aVar = this.f326861f0;
        if (aVar != null) {
            aVar.uc(this);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f326855c0 = false;
        if (this.f326853a0 != -1 && this.V) {
            long currentTimeMillis = System.currentTimeMillis() - this.f326853a0;
            if (currentTimeMillis > 0 && currentTimeMillis < 200) {
                this.f326855c0 = true;
                float f16 = (((float) currentTimeMillis) * 1.0f) / 200.0f;
                if (this.f326854b0) {
                    f16 = 1.0f - f16;
                }
                float k3 = k(this.W, 1.0f, f16);
                this.f326857d0 = this.f326858e * k3;
                this.f326859e0 = this.f326860f * k3;
                invalidate();
            }
        }
        this.P.set(this.f326863h, (getHeight() - this.f326867j0) / 2, getWidth() - this.f326863h, (getHeight() + this.f326867j0) / 2);
        int l3 = (int) l(this.S);
        int height = getHeight() / 2;
        Rect rect = this.R;
        float f17 = l3;
        float f18 = this.f326857d0;
        float f19 = height;
        float f26 = this.f326859e0;
        rect.set((int) (f17 - f18), (int) (f19 - f26), (int) (f17 + f18), (int) (f19 + f26));
        b(canvas);
        d(canvas);
        if (this.T != 100.0f) {
            c(canvas);
        }
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
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action != 5) {
                            if (action == 6) {
                                n(motionEvent);
                                invalidate();
                            }
                        } else {
                            int pointerCount = motionEvent.getPointerCount() - 1;
                            this.f326872n0 = motionEvent.getX(pointerCount);
                            this.f326873o0 = motionEvent.getPointerId(pointerCount);
                            invalidate();
                        }
                    } else {
                        if (this.f326869l0) {
                            p();
                            setPressed(false);
                        }
                        invalidate();
                    }
                } else if (this.f326871m0) {
                    if (this.f326869l0) {
                        t(motionEvent);
                    } else if (Math.abs(motionEvent.getX(motionEvent.findPointerIndex(this.f326873o0)) - this.f326872n0) > this.f326868k0) {
                        setPressed(true);
                        invalidate();
                        o();
                        t(motionEvent);
                        a();
                    }
                    a aVar = this.f326861f0;
                    if (aVar != null) {
                        aVar.wd(this, (int) Math.round(m(this.S)));
                    }
                }
            } else {
                if (this.f326869l0) {
                    q(true);
                    t(motionEvent);
                    p();
                    setPressed(false);
                    a aVar2 = this.f326861f0;
                    if (aVar2 != null) {
                        aVar2.wd(this, (int) Math.round(m(this.S)));
                    }
                } else {
                    o();
                    t(motionEvent);
                    p();
                }
                this.f326871m0 = false;
                invalidate();
            }
        } else {
            int pointerId = motionEvent.getPointerId(motionEvent.getPointerCount() - 1);
            this.f326873o0 = pointerId;
            float x16 = motionEvent.getX(motionEvent.findPointerIndex(pointerId));
            this.f326872n0 = x16;
            boolean f16 = f(x16);
            this.f326871m0 = f16;
            if (!f16) {
                return super.onTouchEvent(motionEvent);
            }
            setPressed(false);
            invalidate();
            o();
            t(motionEvent);
            a();
            q(false);
        }
        return true;
    }

    void p() {
        this.f326869l0 = false;
        a aVar = this.f326861f0;
        if (aVar != null) {
            aVar.Fd(this);
        }
    }

    void q(boolean z16) {
        this.f326853a0 = System.currentTimeMillis();
        this.f326854b0 = z16;
    }

    public void setAbsoluteMinMaxValue(double d16, double d17) {
        this.f326865i = d16;
        this.f326870m = d17;
    }

    public void setBackgroundDrawable(int i3) {
        this.L = ResourcesCompat.getDrawable(getResources(), i3, null);
    }

    public void setDefaultValue(float f16) {
        this.T = f16;
        this.U = (float) w(f16);
        invalidate();
    }

    public void setOnSeekBarChangeListener(a aVar) {
        this.f326861f0 = aVar;
    }

    public void setProgress(double d16) {
        double w3 = w(d16);
        if (w3 <= this.f326870m && w3 >= this.f326865i) {
            this.S = w3;
            invalidate();
            return;
        }
        throw new IllegalArgumentException("Value should be in the middle of max and min value");
    }

    public void setSectionEnable(boolean z16) {
        this.I = z16;
        invalidate();
    }

    public void setThumbDrawable(int i3) {
        this.G = ResourcesCompat.getDrawable(getResources(), i3, null);
    }

    public StartPointSeekBar(Context context) {
        this(context, null);
    }

    public StartPointSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
