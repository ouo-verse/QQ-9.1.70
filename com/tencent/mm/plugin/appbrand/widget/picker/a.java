package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ScrollerCompat;
import com.tencent.ams.fusion.widget.downloadcard.DownloadCardView;
import com.tencent.luggage.wxa.tn.b0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class a extends View {
    public int A0;
    public int B0;
    public int C;
    public float C0;
    public int D;
    public float D0;
    public int E;
    public float E0;
    public int F;
    public boolean F0;
    public int G;
    public int G0;
    public int H;
    public int H0;
    public int I;
    public int I0;
    public int J;
    public float J0;
    public int K;
    public float K0;
    public int L;
    public float L0;
    public int M;
    public int M0;
    public int N;
    public int N0;
    public int O;
    public int O0;
    public int P;
    public int P0;
    public int Q;
    public int Q0;
    public int R;
    public int S;
    public String T;
    public String U;
    public String V;
    public String W;

    /* renamed from: a, reason: collision with root package name */
    public int f152459a;

    /* renamed from: a0, reason: collision with root package name */
    public float f152460a0;

    /* renamed from: b, reason: collision with root package name */
    public int f152461b;

    /* renamed from: b0, reason: collision with root package name */
    public float f152462b0;

    /* renamed from: c, reason: collision with root package name */
    public int f152463c;

    /* renamed from: c0, reason: collision with root package name */
    public float f152464c0;

    /* renamed from: d, reason: collision with root package name */
    public int f152465d;

    /* renamed from: d0, reason: collision with root package name */
    public float f152466d0;

    /* renamed from: e, reason: collision with root package name */
    public int f152467e;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f152468e0;

    /* renamed from: f, reason: collision with root package name */
    public int f152469f;

    /* renamed from: f0, reason: collision with root package name */
    public boolean f152470f0;

    /* renamed from: g, reason: collision with root package name */
    public int f152471g;

    /* renamed from: g0, reason: collision with root package name */
    public boolean f152472g0;

    /* renamed from: h, reason: collision with root package name */
    public int f152473h;

    /* renamed from: h0, reason: collision with root package name */
    public boolean f152474h0;

    /* renamed from: i, reason: collision with root package name */
    public int f152475i;

    /* renamed from: i0, reason: collision with root package name */
    public boolean f152476i0;

    /* renamed from: j, reason: collision with root package name */
    public int f152477j;

    /* renamed from: j0, reason: collision with root package name */
    public boolean f152478j0;

    /* renamed from: k, reason: collision with root package name */
    public int f152479k;

    /* renamed from: k0, reason: collision with root package name */
    public boolean f152480k0;

    /* renamed from: l, reason: collision with root package name */
    public int f152481l;

    /* renamed from: l0, reason: collision with root package name */
    public boolean f152482l0;

    /* renamed from: m, reason: collision with root package name */
    public int f152483m;

    /* renamed from: m0, reason: collision with root package name */
    public ScrollerCompat f152484m0;

    /* renamed from: n0, reason: collision with root package name */
    public VelocityTracker f152485n0;

    /* renamed from: o0, reason: collision with root package name */
    public Paint f152486o0;

    /* renamed from: p0, reason: collision with root package name */
    public TextPaint f152487p0;

    /* renamed from: q0, reason: collision with root package name */
    public Paint f152488q0;

    /* renamed from: r0, reason: collision with root package name */
    public String[] f152489r0;

    /* renamed from: s0, reason: collision with root package name */
    public CharSequence[] f152490s0;

    /* renamed from: t0, reason: collision with root package name */
    public CharSequence[] f152491t0;

    /* renamed from: u0, reason: collision with root package name */
    public b0 f152492u0;

    /* renamed from: v0, reason: collision with root package name */
    public Handler f152493v0;

    /* renamed from: w0, reason: collision with root package name */
    public d f152494w0;

    /* renamed from: x0, reason: collision with root package name */
    public int f152495x0;

    /* renamed from: y0, reason: collision with root package name */
    public int f152496y0;

    /* renamed from: z0, reason: collision with root package name */
    public int f152497z0;

    /* compiled from: P */
    /* renamed from: com.tencent.mm.plugin.appbrand.widget.picker.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C7066a extends b0 {
        public C7066a(String str) {
            super(str);
        }

        @Override // com.tencent.luggage.wxa.tn.b0
        public void d(Message message) {
            int c16;
            int i3;
            int i16 = message.what;
            if (i16 != 1) {
                if (i16 == 2) {
                    a.this.a(message.arg1, message.arg2, message.obj);
                    return;
                }
                return;
            }
            int i17 = 0;
            if (!a.this.f152484m0.isFinished()) {
                if (a.this.f152495x0 == 0) {
                    a.this.g(1);
                }
                a.this.f152492u0.a(a.this.a(1, 0, 0, message.obj), 32L);
                return;
            }
            if (a.this.N0 == 0) {
                a.this.g(0);
                a aVar = a.this;
                c16 = aVar.c(aVar.O0);
            } else {
                if (a.this.f152495x0 == 0) {
                    a.this.g(1);
                }
                if (a.this.N0 < (-a.this.I0) / 2) {
                    i3 = (int) (((a.this.I0 + a.this.N0) * 300.0f) / a.this.I0);
                    a.this.f152484m0.startScroll(0, a.this.O0, 0, a.this.I0 + a.this.N0, i3 * 3);
                    a aVar2 = a.this;
                    c16 = aVar2.c(aVar2.O0 + a.this.I0 + a.this.N0);
                } else {
                    i3 = (int) (((-a.this.N0) * 300.0f) / a.this.I0);
                    a.this.f152484m0.startScroll(0, a.this.O0, 0, a.this.N0, i3 * 3);
                    a aVar3 = a.this;
                    c16 = aVar3.c(aVar3.O0 + a.this.N0);
                }
                i17 = i3;
                a.this.postInvalidate();
            }
            a aVar4 = a.this;
            Message a16 = aVar4.a(2, aVar4.Q, c16, message.obj);
            if (a.this.f152482l0) {
                a.this.f152493v0.sendMessageDelayed(a16, i17 * 2);
            } else {
                a.this.f152492u0.a(a16, i17 * 2);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b extends Handler {
        public b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i3 = message.what;
            if (i3 == 2) {
                a.this.a(message.arg1, message.arg2, message.obj);
            } else if (i3 == 3) {
                a.this.requestLayout();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface c {
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface d {
        void a(a aVar, int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface e {
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface f {
    }

    public a(Context context) {
        super(context);
        this.f152459a = DownloadCardView.COLOR_BUTTON_BACKGROUND_DARK;
        this.f152461b = -695533;
        this.f152463c = -695533;
        this.f152465d = 0;
        this.f152467e = 0;
        this.f152469f = 0;
        this.f152471g = 0;
        this.f152473h = 0;
        this.f152475i = 0;
        this.f152477j = 0;
        this.f152479k = 0;
        this.f152481l = 0;
        this.f152483m = -695533;
        this.C = 2;
        this.D = 0;
        this.E = 0;
        this.F = 3;
        this.G = 0;
        this.H = 0;
        this.I = -1;
        this.J = -1;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 150;
        this.S = 8;
        this.f152460a0 = 1.0f;
        this.f152462b0 = 0.0f;
        this.f152464c0 = 0.0f;
        this.f152466d0 = 0.0f;
        this.f152468e0 = true;
        this.f152470f0 = true;
        this.f152472g0 = false;
        this.f152474h0 = false;
        this.f152476i0 = true;
        this.f152478j0 = false;
        this.f152480k0 = false;
        this.f152482l0 = true;
        this.f152486o0 = new Paint();
        this.f152487p0 = new TextPaint();
        this.f152488q0 = new Paint();
        this.f152495x0 = 0;
        this.C0 = 0.0f;
        this.D0 = 0.0f;
        this.E0 = 0.0f;
        this.F0 = false;
        this.M0 = 0;
        this.N0 = 0;
        this.O0 = 0;
        this.P0 = 0;
        this.Q0 = 0;
        a(context);
    }

    private TextUtils.TruncateAt getEllipsizeType() {
        String str = this.U;
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1074341483:
                if (str.equals("middle")) {
                    c16 = 0;
                    break;
                }
                break;
            case 100571:
                if (str.equals("end")) {
                    c16 = 1;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    c16 = 2;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return TextUtils.TruncateAt.MIDDLE;
            case 1:
                return TextUtils.TruncateAt.END;
            case 2:
                return TextUtils.TruncateAt.START;
            default:
                throw new IllegalArgumentException("Illegal text ellipsize type.");
        }
    }

    public final float a(float f16, float f17, float f18) {
        return f17 + ((f18 - f17) * f16);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.I0 != 0 && this.f152484m0.computeScrollOffset()) {
            this.O0 = this.f152484m0.getCurrY();
            a();
            postInvalidate();
        }
    }

    public String getContentByCurrValue() {
        return this.f152489r0[getValue() - this.K];
    }

    public String[] getDisplayedValues() {
        return this.f152489r0;
    }

    public int getMaxValue() {
        return this.L;
    }

    public int getMinValue() {
        return this.K;
    }

    public int getOneRecycleSize() {
        return (this.J - this.I) + 1;
    }

    public int getPickedIndexRelativeToRaw() {
        int i3 = this.N0;
        if (i3 != 0) {
            int i16 = this.I0;
            if (i3 < (-i16) / 2) {
                return c(this.O0 + i16 + i3);
            }
            return c(this.O0 + i3);
        }
        return c(this.O0);
    }

    public int getRawContentSize() {
        String[] strArr = this.f152489r0;
        if (strArr != null) {
            return strArr.length;
        }
        return 0;
    }

    public int getValue() {
        return getPickedIndexRelativeToRaw() + this.K;
    }

    public boolean getWrapSelectorWheel() {
        return this.f152470f0;
    }

    public boolean getWrapSelectorWheelAbsolutely() {
        if (this.f152470f0 && this.f152476i0) {
            return true;
        }
        return false;
    }

    public final void j() {
        int i3 = this.f152465d;
        int i16 = this.I0;
        if (i3 > i16) {
            this.f152465d = i16;
        }
        if (this.f152467e > i16) {
            this.f152467e = i16;
        }
        Paint paint = this.f152488q0;
        if (paint != null) {
            paint.setTextSize(this.f152469f);
            this.f152466d0 = a(this.f152488q0.getFontMetrics());
            this.f152471g = a(this.T, this.f152488q0);
            TextPaint textPaint = this.f152487p0;
            if (textPaint != null) {
                textPaint.setTextSize(this.f152467e);
                this.f152464c0 = a(this.f152487p0.getFontMetrics());
                this.f152487p0.setTextSize(this.f152465d);
                this.f152462b0 = a(this.f152487p0.getFontMetrics());
                return;
            }
            throw new IllegalArgumentException("mPaintText should not be null.");
        }
        throw new IllegalArgumentException("mPaintHint should not be null.");
    }

    public final void k() {
        float textSize = this.f152487p0.getTextSize();
        this.f152487p0.setTextSize(this.f152467e);
        this.N = (int) ((this.f152487p0.getFontMetrics().bottom - this.f152487p0.getFontMetrics().top) + 0.5d);
        this.f152487p0.setTextSize(textSize);
    }

    public final void l() {
        float textSize = this.f152487p0.getTextSize();
        this.f152487p0.setTextSize(this.f152467e);
        this.M = a(this.f152489r0, this.f152487p0);
        this.O = a(this.f152490s0, this.f152487p0);
        this.P = a(this.f152491t0, this.f152487p0);
        this.f152487p0.setTextSize(this.f152469f);
        this.f152473h = a(this.W, this.f152487p0);
        this.f152487p0.setTextSize(textSize);
    }

    public final void m() {
        this.A0 = 0;
        this.B0 = (-this.F) * this.I0;
        if (this.f152489r0 != null) {
            int oneRecycleSize = getOneRecycleSize();
            int i3 = this.F / 2;
            int i16 = this.I0;
            this.A0 = ((oneRecycleSize - i3) - 1) * i16;
            this.B0 = (-i3) * i16;
        }
    }

    public final void n() {
        b();
        o();
        if (this.I == -1) {
            this.I = 0;
        }
        if (this.J == -1) {
            this.J = this.f152489r0.length - 1;
        }
        b(this.I, this.J, false);
    }

    public final void o() {
        boolean z16;
        if (this.f152489r0.length <= this.F) {
            z16 = false;
        } else {
            z16 = true;
        }
        this.f152476i0 = z16;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f152492u0 == null) {
            c();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f152492u0.e();
        this.f152493v0 = null;
        if (this.I0 == 0) {
            return;
        }
        if (!this.f152484m0.isFinished()) {
            this.f152484m0.abortAnimation();
            this.O0 = this.f152484m0.getCurrY();
            a();
            int i3 = this.N0;
            if (i3 != 0) {
                int i16 = this.I0;
                if (i3 < (-i16) / 2) {
                    this.O0 = this.O0 + i16 + i3;
                } else {
                    this.O0 += i3;
                }
                a();
            }
            g(0);
        }
        int c16 = c(this.O0);
        int i17 = this.Q;
        if (c16 != i17 && this.f152480k0) {
            try {
                d dVar = this.f152494w0;
                if (dVar != null) {
                    int i18 = this.K;
                    dVar.a(this, i17 + i18, i18 + c16);
                }
            } catch (Exception e16) {
                w.a("MicroMsg.YANumberPicker", e16, "", new Object[0]);
            }
        }
        this.Q = c16;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
        c(canvas);
        b(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        a(false);
        setMeasuredDimension(f(i3), e(i16));
    }

    @Override // android.view.View
    public void onSizeChanged(int i3, int i16, int i17, int i18) {
        int i19;
        super.onSizeChanged(i3, i16, i17, i18);
        this.G0 = i3;
        this.H0 = i16;
        this.I0 = i16 / this.F;
        this.L0 = ((i3 + getPaddingLeft()) - getPaddingRight()) / 2.0f;
        boolean z16 = false;
        if (getOneRecycleSize() > 1) {
            if (this.f152474h0) {
                i19 = getValue() - this.K;
            } else if (this.f152472g0) {
                i19 = this.M0 + ((this.F - 1) / 2);
            }
            if (this.f152470f0 && this.f152476i0) {
                z16 = true;
            }
            a(i19, z16);
            j();
            m();
            i();
            this.f152474h0 = true;
        }
        i19 = 0;
        if (this.f152470f0) {
            z16 = true;
        }
        a(i19, z16);
        j();
        m();
        i();
        this.f152474h0 = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0059, code lost:
    
        if (r1 < r3) goto L25;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.I0 == 0) {
            return true;
        }
        if (this.f152485n0 == null) {
            this.f152485n0 = VelocityTracker.obtain();
        }
        this.f152485n0.addMovement(motionEvent);
        this.E0 = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action == 3) {
                        this.C0 = this.O0;
                        g();
                        this.f152492u0.a(b(1), 0L);
                    }
                } else {
                    float f16 = this.D0 - this.E0;
                    if (this.F0) {
                        int i3 = this.S;
                        if ((-i3) < f16) {
                        }
                    }
                    this.F0 = false;
                    this.O0 = d((int) (this.C0 + f16));
                    a();
                    invalidate();
                    g(1);
                }
            } else if (this.F0) {
                a(motionEvent);
            } else {
                VelocityTracker velocityTracker = this.f152485n0;
                velocityTracker.computeCurrentVelocity(1000);
                int yVelocity = (int) (velocityTracker.getYVelocity() * this.f152460a0);
                if (Math.abs(yVelocity) > this.R) {
                    this.f152484m0.fling(0, this.O0, 0, -yVelocity, Integer.MIN_VALUE, Integer.MAX_VALUE, d(Integer.MIN_VALUE), d(Integer.MAX_VALUE));
                    invalidate();
                    g(2);
                }
                this.f152492u0.a(b(1), 0L);
                e();
            }
        } else {
            this.F0 = true;
            this.f152492u0.c(1);
            g();
            this.D0 = this.E0;
            this.C0 = this.O0;
            g(0);
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return true;
    }

    @Override // android.view.View
    public void postInvalidate() {
        if (!ViewCompat.isAttachedToWindow(this)) {
            return;
        }
        super.postInvalidate();
    }

    public void setContentTextTypeface(Typeface typeface) {
        this.f152487p0.setTypeface(typeface);
    }

    public void setDisplayedValues(String[] strArr) {
        f();
        g();
        if (strArr != null) {
            boolean z16 = true;
            if ((this.L - this.K) + 1 <= strArr.length) {
                b(strArr);
                a(true);
                this.Q = this.I + 0;
                if (!this.f152470f0 || !this.f152476i0) {
                    z16 = false;
                }
                a(0, z16);
                postInvalidate();
                this.f152493v0.sendEmptyMessage(3);
                return;
            }
            throw new IllegalArgumentException("mMaxValue - mMinValue + 1 should not be greater than mDisplayedValues.length, now ((mMaxValue - mMinValue + 1) is " + ((this.L - this.K) + 1) + " newDisplayedValues.length is " + strArr.length + ", you need to set MaxValue and MinValue before setDisplayedValues(String[])");
        }
        throw new IllegalArgumentException("newDisplayedValues should not be null.");
    }

    public void setDividerColor(int i3) {
        if (this.f152483m == i3) {
            return;
        }
        this.f152483m = i3;
        this.f152486o0.setColor(i3);
        postInvalidate();
    }

    public void setDividerHeight(int i3) {
        if (i3 == this.C) {
            return;
        }
        this.C = i3;
        this.f152486o0.setStrokeWidth(i3);
        postInvalidate();
    }

    public void setEllipsizeType(String str) {
        String[] strArr = {"end", "middle", "start"};
        for (int i3 = 0; i3 < 3; i3++) {
            if (strArr[i3].equals(str)) {
                this.U = str;
                return;
            }
        }
        this.U = "end";
    }

    public void setFriction(float f16) {
        if (f16 > 0.0f) {
            ViewConfiguration.get(getContext());
            this.f152460a0 = ViewConfiguration.getScrollFriction() / f16;
        } else {
            throw new IllegalArgumentException("you should set a a positive float friction, now friction is " + f16);
        }
    }

    public void setHintText(String str) {
        if (a(this.T, str)) {
            return;
        }
        this.T = str;
        this.f152466d0 = a(this.f152488q0.getFontMetrics());
        this.f152471g = a(this.T, this.f152488q0);
        this.f152493v0.sendEmptyMessage(3);
    }

    public void setHintTextColor(int i3) {
        if (this.f152463c == i3) {
            return;
        }
        this.f152463c = i3;
        this.f152488q0.setColor(i3);
        postInvalidate();
    }

    public void setHintTextTypeface(Typeface typeface) {
        this.f152488q0.setTypeface(typeface);
    }

    public void setItemPaddingVertical(int i3) {
        if (this.f152479k == i3) {
            return;
        }
        this.f152479k = i3;
        postInvalidate();
    }

    public void setMaxValue(int i3) {
        String[] strArr = this.f152489r0;
        if (strArr != null) {
            int i16 = i3 - this.K;
            if (i16 + 1 <= strArr.length) {
                this.L = i3;
                int i17 = this.I;
                int i18 = i16 + i17;
                this.J = i18;
                a(i17, i18);
                m();
                return;
            }
            throw new IllegalArgumentException("(maxValue - mMinValue + 1) should not be greater than mDisplayedValues.length now  (maxValue - mMinValue + 1) is " + ((i3 - this.K) + 1) + " and mDisplayedValues.length is " + this.f152489r0.length);
        }
        throw new NullPointerException("mDisplayedValues should not be null");
    }

    public void setMinValue(int i3) {
        this.K = i3;
        this.I = 0;
        m();
    }

    public void setNormalTextColor(int i3) {
        if (this.f152459a == i3) {
            return;
        }
        this.f152459a = i3;
        postInvalidate();
    }

    public void setOnValueChangedListener(d dVar) {
        this.f152494w0 = dVar;
    }

    public void setPickedIndexRelativeToMin(int i3) {
        boolean z16;
        if (i3 >= 0 && i3 < getOneRecycleSize()) {
            this.Q = this.I + i3;
            if (this.f152470f0 && this.f152476i0) {
                z16 = true;
            } else {
                z16 = false;
            }
            a(i3, z16);
            postInvalidate();
        }
    }

    public void setPickedIndexRelativeToRaw(int i3) {
        boolean z16;
        int i16 = this.I;
        if (i16 > -1 && i16 <= i3 && i3 <= this.J) {
            this.Q = i3;
            int i17 = i3 - i16;
            if (this.f152470f0 && this.f152476i0) {
                z16 = true;
            } else {
                z16 = false;
            }
            a(i17, z16);
            postInvalidate();
        }
    }

    public void setSelectedTextColor(int i3) {
        if (this.f152461b == i3) {
            return;
        }
        this.f152461b = i3;
        postInvalidate();
    }

    public void setValue(int i3) {
        int i16 = this.K;
        if (i3 >= i16) {
            if (i3 <= this.L) {
                setPickedIndexRelativeToRaw(i3 - i16);
                return;
            }
            throw new IllegalArgumentException("should not set a value greater than mMaxValue, value is " + i3);
        }
        throw new IllegalArgumentException("should not set a value less than mMinValue, value is " + i3);
    }

    public void setWrapSelectorWheel(boolean z16) {
        if (this.f152470f0 != z16) {
            if (!z16) {
                if (this.f152495x0 == 0) {
                    d();
                    return;
                } else {
                    this.f152478j0 = true;
                    return;
                }
            }
            this.f152470f0 = z16;
            o();
            postInvalidate();
        }
    }

    public final int a(float f16, int i3, int i16) {
        int i17 = (i3 & (-16777216)) >>> 24;
        int i18 = (i3 & ITVKAsset.VOD_ASSET_MASK_BIT) >>> 16;
        int i19 = (i3 & 65280) >>> 8;
        return ((int) (((i3 & 255) >>> 0) + ((((i16 & 255) >>> 0) - r9) * f16))) | (((int) (i17 + (((((-16777216) & i16) >>> 24) - i17) * f16))) << 24) | (((int) (i18 + ((((16711680 & i16) >>> 16) - i18) * f16))) << 16) | (((int) (i19 + ((((65280 & i16) >>> 8) - i19) * f16))) << 8);
    }

    public final void c() {
        this.f152492u0 = new C7066a("HandlerThread-For-Refreshing");
        this.f152493v0 = new b();
    }

    public final void d() {
        a(getPickedIndexRelativeToRaw() - this.I, false);
        this.f152470f0 = false;
        postInvalidate();
    }

    public final void e() {
        VelocityTracker velocityTracker = this.f152485n0;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.f152485n0.recycle();
            this.f152485n0 = null;
        }
    }

    public final int f(int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        this.P0 = mode;
        int size = View.MeasureSpec.getSize(i3);
        if (mode == 1073741824) {
            return size;
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight() + Math.max(this.O, Math.max(this.M, this.P) + (((Math.max(this.f152471g, this.f152473h) != 0 ? this.f152475i : 0) + Math.max(this.f152471g, this.f152473h) + (Math.max(this.f152471g, this.f152473h) == 0 ? 0 : this.f152477j) + (this.f152481l * 2)) * 2));
        return mode == Integer.MIN_VALUE ? Math.min(paddingLeft, size) : paddingLeft;
    }

    public final void g(int i3) {
        if (this.f152495x0 == i3) {
            return;
        }
        this.f152495x0 = i3;
    }

    public final void h(int i3) {
        b(i3, true);
    }

    public final void i() {
        int i3 = this.F / 2;
        this.G = i3;
        this.H = i3 + 1;
        int i16 = this.H0;
        this.J0 = (i3 * i16) / r0;
        this.K0 = (r2 * i16) / r0;
        if (this.D < 0) {
            this.D = 0;
        }
        if (this.E < 0) {
            this.E = 0;
        }
        if (this.D + this.E != 0 && getPaddingLeft() + this.D >= (this.G0 - getPaddingRight()) - this.E) {
            int paddingLeft = getPaddingLeft() + this.D + getPaddingRight();
            int i17 = this.E;
            int i18 = (paddingLeft + i17) - this.G0;
            float f16 = this.D;
            float f17 = i18;
            this.D = (int) (f16 - ((f17 * f16) / (r2 + i17)));
            float f18 = i17;
            this.E = (int) (f18 - ((f17 * f18) / (r2 + i17)));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0035, code lost:
    
        if (r10 < 0) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(int i3, boolean z16) {
        int pickedIndexRelativeToRaw;
        int pickedIndexRelativeToRaw2;
        int i16;
        int i17;
        int i18;
        if ((!this.f152470f0 || !this.f152476i0) && ((pickedIndexRelativeToRaw2 = (pickedIndexRelativeToRaw = getPickedIndexRelativeToRaw()) + i3) > (i16 = this.J) || pickedIndexRelativeToRaw2 < (i16 = this.I))) {
            i3 = i16 - pickedIndexRelativeToRaw;
        }
        int i19 = this.N0;
        int i26 = this.I0;
        if (i19 < (-i26) / 2) {
            i19 += i26;
            i17 = (int) ((i19 * 300.0f) / i26);
            if (i3 < 0) {
                i17 = -i17;
                i18 = i17 - (i3 * 300);
            }
            i18 = i17 + (i3 * 300);
        } else {
            i17 = (int) (((-i19) * 300.0f) / i26);
        }
        int i27 = i19 + (i3 * i26);
        if (i18 < 300) {
            i18 = 300;
        }
        if (i18 > 600) {
            i18 = 600;
        }
        this.f152484m0.startScroll(0, this.O0, 0, i27, i18);
        if (z16) {
            this.f152492u0.a(b(1), i18 / 4);
        } else {
            this.f152492u0.a(a(1, 0, 0, new Boolean(z16)), i18 / 4);
        }
        postInvalidate();
    }

    public void h() {
        g();
        b0 b0Var = this.f152492u0;
        if (b0Var != null) {
            b0Var.a(b(1), 0L);
        }
    }

    public final int c(int i3) {
        int i16 = this.I0;
        boolean z16 = false;
        if (i16 == 0) {
            return 0;
        }
        int i17 = (i3 / i16) + (this.F / 2);
        int oneRecycleSize = getOneRecycleSize();
        if (this.f152470f0 && this.f152476i0) {
            z16 = true;
        }
        int a16 = a(i17, oneRecycleSize, z16);
        if (a16 >= 0 && a16 < getOneRecycleSize()) {
            return a16 + this.I;
        }
        throw new IllegalArgumentException("getWillPickIndexByGlobalY illegal index : " + a16 + " getOneRecycleSize() : " + getOneRecycleSize() + " mWrapSelectorWheel : " + this.f152470f0);
    }

    public void g() {
        ScrollerCompat scrollerCompat = this.f152484m0;
        if (scrollerCompat == null || scrollerCompat.isFinished()) {
            return;
        }
        ScrollerCompat scrollerCompat2 = this.f152484m0;
        scrollerCompat2.startScroll(0, scrollerCompat2.getCurrY(), 0, 0, 1);
        this.f152484m0.abortAnimation();
        postInvalidate();
    }

    public final int d(int i3) {
        if (this.f152470f0 && this.f152476i0) {
            return i3;
        }
        int i16 = this.B0;
        return (i3 >= i16 && i3 <= (i16 = this.A0)) ? i3 : i16;
    }

    public final int e(int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        this.Q0 = mode;
        int size = View.MeasureSpec.getSize(i3);
        if (mode == 1073741824) {
            return size;
        }
        int paddingTop = getPaddingTop() + getPaddingBottom() + (this.F * (this.N + (this.f152479k * 2)));
        return mode == Integer.MIN_VALUE ? Math.min(paddingTop, size) : paddingTop;
    }

    public final void a(Context context) {
        this.f152484m0 = ScrollerCompat.create(context);
        this.R = ViewConfiguration.get(getContext()).getScaledMinimumFlingVelocity();
        this.S = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        if (this.f152465d == 0) {
            this.f152465d = b(context, 13.0f);
        }
        if (this.f152467e == 0) {
            this.f152467e = b(context, 15.0f);
        }
        if (this.f152469f == 0) {
            this.f152469f = b(context, 14.0f);
        }
        if (this.f152475i == 0) {
            this.f152475i = a(context, 8.0f);
        }
        if (this.f152477j == 0) {
            this.f152477j = a(context, 8.0f);
        }
        this.f152486o0.setColor(this.f152483m);
        this.f152486o0.setAntiAlias(true);
        this.f152486o0.setStyle(Paint.Style.STROKE);
        this.f152486o0.setStrokeWidth(this.C);
        this.f152487p0.setColor(this.f152459a);
        this.f152487p0.setAntiAlias(true);
        this.f152487p0.setTextAlign(Paint.Align.CENTER);
        this.f152488q0.setColor(this.f152463c);
        this.f152488q0.setAntiAlias(true);
        this.f152488q0.setTextAlign(Paint.Align.CENTER);
        this.f152488q0.setTextSize(this.f152469f);
        int i3 = this.F;
        if (i3 % 2 == 0) {
            this.F = i3 + 1;
        }
        if (this.I == -1 || this.J == -1) {
            n();
        }
        c();
    }

    public final void c(Canvas canvas) {
        if (this.f152468e0) {
            canvas.drawLine(getPaddingLeft() + this.D, this.J0, (this.G0 - getPaddingRight()) - this.E, this.J0, this.f152486o0);
            canvas.drawLine(getPaddingLeft() + this.D, this.K0, (this.G0 - getPaddingRight()) - this.E, this.K0, this.f152486o0);
        }
    }

    public void b(int i3, int i16, boolean z16) {
        if (i3 <= i16) {
            String[] strArr = this.f152489r0;
            if (strArr == null) {
                throw new IllegalArgumentException("mDisplayedValues should not be null, you need to set mDisplayedValues first.");
            }
            if (i3 >= 0) {
                if (i3 > strArr.length - 1) {
                    throw new IllegalArgumentException("minShowIndex should not be greater than (mDisplayedValues.length - 1), now (mDisplayedValues.length - 1) is " + (this.f152489r0.length - 1) + " minShowIndex is " + i3);
                }
                if (i16 >= 0) {
                    if (i16 <= strArr.length - 1) {
                        this.I = i3;
                        this.J = i16;
                        if (z16) {
                            this.Q = i3 + 0;
                            a(0, this.f152470f0 && this.f152476i0);
                            postInvalidate();
                            return;
                        }
                        return;
                    }
                    throw new IllegalArgumentException("maxShowIndex should not be greater than (mDisplayedValues.length - 1), now (mDisplayedValues.length - 1) is " + (this.f152489r0.length - 1) + " maxShowIndex is " + i16);
                }
                throw new IllegalArgumentException("maxShowIndex should not be less than 0, now maxShowIndex is " + i16);
            }
            throw new IllegalArgumentException("minShowIndex should not be less than 0, now minShowIndex is " + i3);
        }
        throw new IllegalArgumentException("minShowIndex should be less than maxShowIndex, minShowIndex is " + i3 + ", maxShowIndex is " + i16 + ".");
    }

    public final void f() {
        b0 b0Var = this.f152492u0;
        if (b0Var != null) {
            b0Var.c(1);
        }
    }

    public final void b(Canvas canvas) {
        if (TextUtils.isEmpty(this.T)) {
            return;
        }
        canvas.drawText(this.T, this.L0 + ((this.M + this.f152471g) / 2) + this.f152475i, ((this.J0 + this.K0) / 2.0f) + this.f152466d0, this.f152488q0);
    }

    public void setOnScrollListener(c cVar) {
    }

    public void setOnValueChangeListenerInScrolling(e eVar) {
    }

    public void setOnValueChangedListenerRelativeToRaw(f fVar) {
    }

    public final void b(String[] strArr) {
        this.f152489r0 = strArr;
        o();
    }

    public final void b() {
        if (this.f152489r0 == null) {
            this.f152489r0 = r0;
            String[] strArr = {"0"};
        }
    }

    public void a(String[] strArr) {
        int minValue = getMinValue();
        int maxValue = (getMaxValue() - minValue) + 1;
        int length = strArr.length - 1;
        if ((length - minValue) + 1 > maxValue) {
            setDisplayedValues(strArr);
            setMaxValue(length);
        } else {
            setMaxValue(length);
            setDisplayedValues(strArr);
        }
    }

    public final Message b(int i3) {
        return a(i3, 0, 0, (Object) null);
    }

    public final int b(Context context, float f16) {
        return (int) ((f16 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public final void a(int i3, int i16, Object obj) {
        d dVar;
        g(0);
        if (i3 != i16 && ((obj == null || !(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) && (dVar = this.f152494w0) != null)) {
            int i17 = this.K;
            dVar.a(this, i3 + i17, i17 + i16);
        }
        this.Q = i16;
        if (this.f152478j0) {
            this.f152478j0 = false;
            d();
        }
    }

    public void a(int i3, int i16) {
        b(i3, i16, true);
    }

    public final int a(int i3, int i16, boolean z16) {
        if (i16 <= 0) {
            return 0;
        }
        if (!z16) {
            return i3;
        }
        int i17 = i3 % i16;
        return i17 < 0 ? i17 + i16 : i17;
    }

    public final void a(MotionEvent motionEvent) {
        float y16 = motionEvent.getY();
        for (int i3 = 0; i3 < this.F; i3++) {
            int i16 = this.I0;
            if (i16 * i3 <= y16 && y16 < i16 * (i3 + 1)) {
                a(i3);
                return;
            }
        }
    }

    public final void a(int i3) {
        int i16;
        if (i3 < 0 || i3 >= (i16 = this.F)) {
            return;
        }
        h(i3 - (i16 / 2));
    }

    public final float a(Paint.FontMetrics fontMetrics) {
        if (fontMetrics == null) {
            return 0.0f;
        }
        return Math.abs(fontMetrics.top + fontMetrics.bottom) / 2.0f;
    }

    public final void a(int i3, boolean z16) {
        int i16 = i3 - ((this.F - 1) / 2);
        this.M0 = i16;
        int a16 = a(i16, getOneRecycleSize(), z16);
        this.M0 = a16;
        int i17 = this.I0;
        if (i17 == 0) {
            this.f152472g0 = true;
            return;
        }
        this.O0 = i17 * a16;
        int i18 = a16 + (this.F / 2);
        this.f152496y0 = i18;
        int oneRecycleSize = i18 % getOneRecycleSize();
        this.f152496y0 = oneRecycleSize;
        if (oneRecycleSize < 0) {
            this.f152496y0 = oneRecycleSize + getOneRecycleSize();
        }
        this.f152497z0 = this.f152496y0;
        a();
    }

    public final void a() {
        int floor = (int) Math.floor(this.O0 / this.I0);
        this.M0 = floor;
        this.N0 = -(this.O0 - (floor * this.I0));
    }

    public final void a(boolean z16) {
        l();
        k();
        if (z16) {
            if (this.P0 == Integer.MIN_VALUE || this.Q0 == Integer.MIN_VALUE) {
                this.f152493v0.sendEmptyMessage(3);
            }
        }
    }

    public final void a(Canvas canvas) {
        float f16;
        float f17;
        float f18;
        int i3;
        float f19 = 0.0f;
        int i16 = 0;
        while (true) {
            if (i16 >= this.F + 1) {
                return;
            }
            float f26 = this.N0 + (this.I0 * i16);
            int a16 = a(this.M0 + i16, getOneRecycleSize(), this.f152470f0 && this.f152476i0);
            int i17 = this.F / 2;
            if (i16 == i17) {
                f18 = (this.N0 + r0) / this.I0;
                i3 = a(f18, this.f152459a, this.f152461b);
                f16 = a(f18, this.f152465d, this.f152467e);
                f17 = a(f18, this.f152462b0, this.f152464c0);
            } else if (i16 == i17 + 1) {
                float f27 = 1.0f - f19;
                int a17 = a(f27, this.f152459a, this.f152461b);
                float a18 = a(f27, this.f152465d, this.f152467e);
                float a19 = a(f27, this.f152462b0, this.f152464c0);
                f18 = f19;
                i3 = a17;
                f16 = a18;
                f17 = a19;
            } else {
                int i18 = this.f152459a;
                f16 = this.f152465d;
                f17 = this.f152462b0;
                f18 = f19;
                i3 = i18;
            }
            this.f152487p0.setColor(i3);
            this.f152487p0.setTextSize(f16);
            if (a16 >= 0 && a16 < getOneRecycleSize()) {
                CharSequence charSequence = this.f152489r0[a16 + this.I];
                if (this.U != null) {
                    charSequence = TextUtils.ellipsize(charSequence, this.f152487p0, getWidth() - (this.f152481l * 2), getEllipsizeType());
                }
                canvas.drawText(charSequence.toString(), this.L0, f26 + (this.I0 / 2) + f17, this.f152487p0);
            } else if (!TextUtils.isEmpty(this.V)) {
                canvas.drawText(this.V, this.L0, f26 + (this.I0 / 2) + f17, this.f152487p0);
            }
            i16++;
            f19 = f18;
        }
    }

    public final int a(CharSequence[] charSequenceArr, Paint paint) {
        if (charSequenceArr == null) {
            return 0;
        }
        int i3 = 0;
        for (CharSequence charSequence : charSequenceArr) {
            if (charSequence != null) {
                i3 = Math.max(a(charSequence, paint), i3);
            }
        }
        return i3;
    }

    public final int a(CharSequence charSequence, Paint paint) {
        if (TextUtils.isEmpty(charSequence)) {
            return 0;
        }
        return (int) (paint.measureText(charSequence.toString()) + 0.5f);
    }

    public final Message a(int i3, int i16, int i17, Object obj) {
        Message obtain = Message.obtain();
        obtain.what = i3;
        obtain.arg1 = i16;
        obtain.arg2 = i17;
        obtain.obj = obj;
        return obtain;
    }

    public final boolean a(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equals(str2);
    }

    public final int a(Context context, float f16) {
        return (int) ((f16 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
