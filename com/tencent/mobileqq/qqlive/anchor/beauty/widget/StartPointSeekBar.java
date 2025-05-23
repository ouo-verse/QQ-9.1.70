package com.tencent.mobileqq.qqlive.anchor.beauty.widget;

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
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.anchor.beauty.utils.d;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes17.dex */
public class StartPointSeekBar extends View {
    static IPatchRedirector $redirector_;

    /* renamed from: o0, reason: collision with root package name */
    private static final String f270560o0;

    /* renamed from: p0, reason: collision with root package name */
    static final /* synthetic */ boolean f270561p0;
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
    private boolean f270562a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f270563b0;

    /* renamed from: c0, reason: collision with root package name */
    private float f270564c0;

    /* renamed from: d, reason: collision with root package name */
    private final int f270565d;

    /* renamed from: d0, reason: collision with root package name */
    private float f270566d0;

    /* renamed from: e, reason: collision with root package name */
    private final float f270567e;

    /* renamed from: e0, reason: collision with root package name */
    private a f270568e0;

    /* renamed from: f, reason: collision with root package name */
    private final float f270569f;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f270570f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f270571g0;

    /* renamed from: h, reason: collision with root package name */
    private final int f270572h;

    /* renamed from: h0, reason: collision with root package name */
    private Vibrator f270573h0;

    /* renamed from: i, reason: collision with root package name */
    private double f270574i;

    /* renamed from: i0, reason: collision with root package name */
    private final int f270575i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f270576j0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f270577k0;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f270578l0;

    /* renamed from: m, reason: collision with root package name */
    private double f270579m;

    /* renamed from: m0, reason: collision with root package name */
    private float f270580m0;

    /* renamed from: n0, reason: collision with root package name */
    private int f270581n0;

    /* loaded from: classes17.dex */
    public interface a {
        void a(StartPointSeekBar startPointSeekBar);

        void b(StartPointSeekBar startPointSeekBar);

        void c(StartPointSeekBar startPointSeekBar, int i3);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55188);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            f270561p0 = true;
            f270560o0 = StartPointSeekBar.class.getSimpleName();
        }
    }

    public StartPointSeekBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f270565d = 200;
        this.R = 0.0d;
        this.V = 0.7f;
        this.W = -1L;
        this.f270581n0 = 255;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, hi2.a.f405003f6, i3, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(hi2.a.f405115s6);
        this.G = drawable;
        if (drawable == null) {
            this.G = ResourcesCompat.getDrawable(getResources(), R.drawable.nn7, null);
        }
        this.H = obtainStyledAttributes.getDrawable(hi2.a.f405124t6);
        this.f270574i = obtainStyledAttributes.getFloat(hi2.a.f405038j6, -100.0f);
        this.f270579m = obtainStyledAttributes.getFloat(hi2.a.f405030i6, 100.0f);
        double d16 = obtainStyledAttributes.getFloat(hi2.a.f405054l6, (float) this.f270574i);
        this.C = d16;
        setProgress(d16);
        this.L = obtainStyledAttributes.getDrawable(hi2.a.f405013g6);
        this.J = obtainStyledAttributes.getDrawable(hi2.a.f405022h6);
        this.K = obtainStyledAttributes.getDrawable(hi2.a.f405046k6);
        if (!f270561p0 && this.L == null) {
            throw new AssertionError();
        }
        this.D = obtainStyledAttributes.getBoolean(hi2.a.f405097q6, false);
        this.U = obtainStyledAttributes.getBoolean(hi2.a.f405106r6, true);
        this.f270570f0 = obtainStyledAttributes.getBoolean(hi2.a.f405133u6, false);
        this.I = obtainStyledAttributes.getBoolean(hi2.a.f405079o6, true);
        this.E = obtainStyledAttributes.getDrawable(hi2.a.f405070n6);
        this.F = obtainStyledAttributes.getDrawable(hi2.a.f405088p6);
        this.M = obtainStyledAttributes.getBoolean(hi2.a.f405062m6, true);
        obtainStyledAttributes.recycle();
        this.f270573h0 = (Vibrator) getContext().getSystemService("vibrator");
        if (!this.U) {
            this.V = 1.0f;
        }
        float intrinsicWidth = this.G.getIntrinsicWidth() >> 1;
        this.f270567e = intrinsicWidth;
        float intrinsicHeight = this.G.getIntrinsicHeight() >> 1;
        this.f270569f = intrinsicHeight;
        float f16 = this.V;
        this.f270564c0 = intrinsicWidth * f16;
        this.f270566d0 = intrinsicHeight * f16;
        this.f270575i0 = this.L.getIntrinsicHeight();
        this.N = new Rect();
        this.P = new Rect();
        this.Q = new Rect();
        this.f270572h = (int) intrinsicWidth;
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.f270576j0 = ViewConfiguration.get(getContext()).getScaledTouchSlop();
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
        float j3 = j(this.T);
        int save = canvas.save();
        float f16 = this.S;
        if ((f16 >= 0.0f && this.R >= this.T) || (f16 <= 0.0f && this.R <= this.T)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.E != null && !z16) {
            this.E.setBounds(new Rect((int) (j3 - (this.E.getIntrinsicWidth() / 2)), (getHeight() - this.E.getIntrinsicHeight()) / 2, (int) ((this.E.getIntrinsicWidth() / 2) + j3), (getHeight() + this.E.getIntrinsicHeight()) / 2));
            this.E.draw(canvas);
        }
        if (this.F != null && z16) {
            this.F.setBounds(new Rect((int) (j3 - (this.F.getIntrinsicWidth() / 2)), (getHeight() - this.F.getIntrinsicHeight()) / 2, (int) (j3 + (this.F.getIntrinsicWidth() / 2)), (getHeight() + this.F.getIntrinsicHeight()) / 2));
            this.F.draw(canvas);
        }
        canvas.restoreToCount(save);
    }

    private void e(Canvas canvas) {
        Drawable drawable;
        int save = canvas.save();
        if (!this.f270563b0 && this.f270578l0 && (drawable = this.H) != null) {
            drawable.setBounds(this.Q);
            this.H.draw(canvas);
        } else {
            this.G.setBounds(this.Q);
            this.G.draw(canvas);
        }
        canvas.restoreToCount(save);
    }

    private boolean f(float f16) {
        return h(f16, this.R);
    }

    private float g() {
        return j(this.R);
    }

    private boolean h(float f16, double d16) {
        if (Math.abs(f16 - j(d16)) <= this.f270567e + 100.0f) {
            return true;
        }
        return false;
    }

    private float i(float f16, float f17, float f18) {
        return f16 + ((f17 - f16) * f18);
    }

    private float j(double d16) {
        return (float) (this.f270572h + (d16 * (getWidth() - (this.f270572h * 2))));
    }

    private double k(double d16) {
        double d17 = this.f270574i;
        return d17 + (d16 * (this.f270579m - d17));
    }

    private void l(MotionEvent motionEvent) {
        int i3;
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (motionEvent.getPointerId(action) == this.f270581n0) {
            if (action == 0) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            this.f270580m0 = motionEvent.getX(i3);
            this.f270581n0 = motionEvent.getPointerId(i3);
        }
    }

    private double p(float f16) {
        if (getWidth() <= this.f270572h * 2) {
            return 0.0d;
        }
        return Math.min(1.0d, Math.max(0.0d, (f16 - r1) / (r0 - (r1 * 2))));
    }

    private void q(double d16) {
        this.R = Math.max(0.0d, d16);
        invalidate();
    }

    private void r(MotionEvent motionEvent) {
        float x16 = motionEvent.getX(motionEvent.findPointerIndex(this.f270581n0));
        if (this.M && Math.abs(x16 - j(this.T)) < this.f270576j0) {
            q(this.T);
            if (this.f270571g0 && this.f270570f0 && this.f270573h0 != null) {
                this.f270571g0 = false;
                return;
            }
            return;
        }
        q(p(x16));
        this.f270571g0 = true;
    }

    public static void s(StartPointSeekBar startPointSeekBar, int i3, TextView textView) {
        if (startPointSeekBar != null && textView != null) {
            textView.setText(String.valueOf(i3));
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            textView.measure(makeMeasureSpec, makeMeasureSpec);
            int measuredWidth = textView.getMeasuredWidth();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            String str = f270560o0;
            QLog.d(str, 2, "[updateBubble] location[0] = " + startPointSeekBar.getX() + ", seekBar .getThumbImageRelativeLocation() = " + startPointSeekBar.g());
            int x16 = (int) ((startPointSeekBar.getX() + startPointSeekBar.g()) - ((float) (measuredWidth / 2)));
            int y16 = (int) (startPointSeekBar.getY() - ((float) d.a(startPointSeekBar.getContext(), 14.0f)));
            QLog.d(str, 2, "[updateBubble] left = " + x16 + ", top = " + y16);
            layoutParams.leftMargin = x16;
            layoutParams.topMargin = y16;
            textView.setLayoutParams(layoutParams);
        }
    }

    private double t(double d16) {
        double d17 = this.f270579m;
        double d18 = this.f270574i;
        if (0.0d == d17 - d18) {
            return 0.0d;
        }
        return (d16 - d18) / (d17 - d18);
    }

    protected void b(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) canvas);
            return;
        }
        int save = canvas.save();
        this.L.setBounds(this.N);
        if (this.D) {
            canvas.clipRect(this.Q, Region.Op.DIFFERENCE);
        }
        this.L.draw(canvas);
        canvas.restoreToCount(save);
    }

    protected void d(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) canvas);
            return;
        }
        if (this.J == null) {
            return;
        }
        int save = canvas.save();
        this.P.set(this.N);
        if (j(t(0.0d)) < j(this.R)) {
            this.P.left = (int) j(t(0.0d));
            this.P.right = (int) j(this.R);
        } else {
            this.P.right = (int) j(t(0.0d));
            this.P.left = (int) j(this.R);
        }
        if (this.D) {
            canvas.clipRect(this.Q, Region.Op.DIFFERENCE);
        }
        this.J.setBounds(this.P);
        this.J.draw(canvas);
        canvas.restoreToCount(save);
    }

    void m() {
        this.f270577k0 = true;
        a aVar = this.f270568e0;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    void n() {
        this.f270577k0 = false;
        a aVar = this.f270568e0;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    void o(boolean z16) {
        this.W = System.currentTimeMillis();
        this.f270562a0 = z16;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        this.f270563b0 = false;
        if (this.W != -1 && this.U) {
            long currentTimeMillis = System.currentTimeMillis() - this.W;
            if (currentTimeMillis > 0 && currentTimeMillis < 200) {
                this.f270563b0 = true;
                float f16 = (((float) currentTimeMillis) * 1.0f) / 200.0f;
                if (this.f270562a0) {
                    f16 = 1.0f - f16;
                }
                float i3 = i(this.V, 1.0f, f16);
                this.f270564c0 = this.f270567e * i3;
                this.f270566d0 = this.f270569f * i3;
                invalidate();
            }
        }
        this.N.set(this.f270572h, (getHeight() - this.f270575i0) / 2, getWidth() - this.f270572h, (getHeight() + this.f270575i0) / 2);
        int j3 = (int) j(this.R);
        int height = getHeight() / 2;
        Rect rect = this.Q;
        float f17 = j3;
        float f18 = this.f270564c0;
        float f19 = height;
        float f26 = this.f270566d0;
        rect.set((int) (f17 - f18), (int) (f19 - f26), (int) (f17 + f18), (int) (f19 + f26));
        b(canvas);
        d(canvas);
        c(canvas);
        e(canvas);
    }

    @Override // android.view.View
    protected synchronized void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) motionEvent)).booleanValue();
        }
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
                                l(motionEvent);
                                invalidate();
                            }
                        } else {
                            int pointerCount = motionEvent.getPointerCount() - 1;
                            this.f270580m0 = motionEvent.getX(pointerCount);
                            this.f270581n0 = motionEvent.getPointerId(pointerCount);
                            invalidate();
                        }
                    } else {
                        if (this.f270577k0) {
                            n();
                            setPressed(false);
                        }
                        invalidate();
                    }
                } else if (this.f270578l0) {
                    if (this.f270577k0) {
                        r(motionEvent);
                    } else if (Math.abs(motionEvent.getX(motionEvent.findPointerIndex(this.f270581n0)) - this.f270580m0) > this.f270576j0) {
                        setPressed(true);
                        invalidate();
                        m();
                        r(motionEvent);
                        a();
                    }
                    a aVar = this.f270568e0;
                    if (aVar != null) {
                        aVar.c(this, (int) Math.round(k(this.R)));
                    }
                }
            } else {
                if (this.f270577k0) {
                    o(true);
                    r(motionEvent);
                    n();
                    setPressed(false);
                } else {
                    m();
                    r(motionEvent);
                    n();
                }
                this.f270578l0 = false;
                invalidate();
            }
        } else {
            int pointerId = motionEvent.getPointerId(motionEvent.getPointerCount() - 1);
            this.f270581n0 = pointerId;
            float x16 = motionEvent.getX(motionEvent.findPointerIndex(pointerId));
            this.f270580m0 = x16;
            boolean f16 = f(x16);
            this.f270578l0 = f16;
            if (!f16) {
                return super.onTouchEvent(motionEvent);
            }
            setPressed(false);
            invalidate();
            m();
            r(motionEvent);
            a();
            o(false);
        }
        return true;
    }

    public void setAbsoluteMinMaxValue(double d16, double d17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Double.valueOf(d16), Double.valueOf(d17));
        } else {
            this.f270574i = d16;
            this.f270579m = d17;
        }
    }

    public void setDefaultValue(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Float.valueOf(f16));
            return;
        }
        this.S = f16;
        this.T = (float) t(f16);
        invalidate();
    }

    public void setOnSeekBarChangeListener(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
        } else {
            this.f270568e0 = aVar;
        }
    }

    public void setProgress(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Double.valueOf(d16));
            return;
        }
        double t16 = t(d16);
        if (t16 <= this.f270579m && t16 >= this.f270574i) {
            this.R = t16;
            invalidate();
            return;
        }
        throw new IllegalArgumentException("Value should be in the middle of max and min value");
    }

    public void setSectionEnable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        } else {
            this.I = z16;
            invalidate();
        }
    }

    public StartPointSeekBar(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
    }

    public StartPointSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) attributeSet);
    }
}
