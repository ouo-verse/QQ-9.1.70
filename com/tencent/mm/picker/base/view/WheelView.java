package com.tencent.mm.picker.base.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import com.tencent.luggage.wxa.cc.d;
import com.tencent.luggage.wxa.cc.e;
import com.tencent.luggage.wxa.lo.n;
import com.tencent.mobileqq.R;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.util.concurrent.Future;

/* compiled from: P */
/* loaded from: classes9.dex */
public class WheelView extends View {
    public Paint C;
    public com.tencent.luggage.wxa.ac.b D;
    public String E;
    public int F;
    public int G;
    public float H;
    public int I;
    public boolean J;
    public boolean K;
    public int L;
    public boolean M;
    public float N;
    public float O;
    public float P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public int V;
    public int W;

    /* renamed from: a, reason: collision with root package name */
    public int f151811a;

    /* renamed from: a0, reason: collision with root package name */
    public float f151812a0;

    /* renamed from: b, reason: collision with root package name */
    public int f151813b;

    /* renamed from: b0, reason: collision with root package name */
    public long f151814b0;

    /* renamed from: c, reason: collision with root package name */
    public int f151815c;

    /* renamed from: c0, reason: collision with root package name */
    public int f151816c0;

    /* renamed from: d, reason: collision with root package name */
    public final int f151817d;

    /* renamed from: d0, reason: collision with root package name */
    public int f151818d0;

    /* renamed from: e, reason: collision with root package name */
    public Handler f151819e;

    /* renamed from: e0, reason: collision with root package name */
    public int f151820e0;

    /* renamed from: f, reason: collision with root package name */
    public GestureDetector f151821f;

    /* renamed from: f0, reason: collision with root package name */
    public Context f151822f0;

    /* renamed from: g, reason: collision with root package name */
    public com.tencent.luggage.wxa.bc.b f151823g;

    /* renamed from: g0, reason: collision with root package name */
    public Rect f151824g0;

    /* renamed from: h, reason: collision with root package name */
    public String f151825h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f151826i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f151827j;

    /* renamed from: k, reason: collision with root package name */
    public final com.tencent.luggage.wxa.cc.b f151828k;

    /* renamed from: l, reason: collision with root package name */
    public Future f151829l;

    /* renamed from: m, reason: collision with root package name */
    public Paint f151830m;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            WheelView.this.f151823g.a(WheelView.this.getCurrentItem());
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public enum b {
        CLICK,
        FLING,
        DAGGLE
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public enum c {
        FILL,
        WRAP
    }

    public WheelView(Context context) {
        this(context, null);
        this.f151822f0 = context;
    }

    public void b() {
        Future future = this.f151829l;
        if (future == null || future.isCancelled()) {
            return;
        }
        this.f151829l.cancel(true);
        this.f151829l = null;
    }

    public final void c() {
        Paint paint = new Paint();
        this.f151830m = paint;
        paint.setColor(this.f151813b);
        this.f151830m.setAntiAlias(true);
        this.f151830m.setTextSize(this.F);
        Paint paint2 = new Paint();
        this.C = paint2;
        paint2.setColor(this.I);
        this.C.setAntiAlias(true);
        setLayerType(2, null);
    }

    public boolean d() {
        return this.J;
    }

    public final boolean e() {
        if (this.f151830m.measureText(this.f151825h) <= (this.V - getPaddingLeft()) - getPaddingRight()) {
            return true;
        }
        return false;
    }

    public final void f() {
        this.H = this.f151811a + getPaddingBottom() + getPaddingTop();
    }

    public int g() {
        return (this.V - getPaddingLeft()) - getPaddingRight();
    }

    public final com.tencent.luggage.wxa.ac.b getAdapter() {
        return this.D;
    }

    public final int getCurrentItem() {
        int i3;
        com.tencent.luggage.wxa.ac.b bVar = this.D;
        if (bVar == null) {
            return 0;
        }
        if (this.K && this.R == 0) {
            return -1;
        }
        if (this.J && ((i3 = this.R) < 0 || i3 >= bVar.a())) {
            return Math.max(0, Math.min(Math.abs(Math.abs(this.R) - this.D.a()), this.D.a() - 1));
        }
        return Math.max(0, Math.min(this.R, this.D.a() - 1));
    }

    @Override // android.view.View
    public Handler getHandler() {
        return this.f151819e;
    }

    public int getInitPosition() {
        return this.Q;
    }

    public float getItemHeight() {
        return this.H;
    }

    public int getItemsCount() {
        com.tencent.luggage.wxa.ac.b bVar = this.D;
        if (bVar != null) {
            return bVar.a();
        }
        return 0;
    }

    public float getTotalScrollY() {
        return this.P;
    }

    public final void h() {
        String str;
        Paint paint = this.f151830m;
        String str2 = this.f151825h;
        paint.getTextBounds(str2, 0, str2.length(), this.f151824g0);
        int i3 = this.f151818d0;
        if (i3 != 3) {
            if (i3 != 5) {
                if (i3 == 17) {
                    if (!this.f151826i && (str = this.E) != null && !str.equals("") && this.f151827j) {
                        this.f151820e0 = (int) ((this.V - this.f151824g0.width()) * 0.25d);
                        return;
                    }
                    if (this.V < this.f151824g0.width()) {
                        j();
                        if (!e()) {
                            a();
                        }
                        Paint paint2 = this.f151830m;
                        String str3 = this.f151825h;
                        paint2.getTextBounds(str3, 0, str3.length(), this.f151824g0);
                        this.f151820e0 = (int) ((this.V - this.f151824g0.width()) * 0.5d);
                        return;
                    }
                    this.f151820e0 = (int) ((this.V - this.f151824g0.width()) * 0.5d);
                    return;
                }
                return;
            }
            this.f151820e0 = this.V - this.f151824g0.width();
            return;
        }
        this.f151820e0 = 0;
    }

    public final void i() {
        l();
        if (this.f151823g != null) {
            postDelayed(new a(), 200L);
        }
    }

    public final void j() {
        int i3 = this.F;
        this.f151830m.setTextSize(i3);
        while (i3 > this.G && !e()) {
            i3--;
            this.f151830m.setTextSize(i3);
        }
    }

    public final void k() {
        if (this.D == null) {
            return;
        }
        f();
        this.U = (int) (this.H * this.T);
        this.V = View.MeasureSpec.getSize(this.f151816c0);
        float f16 = this.U;
        float f17 = this.H;
        this.N = (f16 - f17) / 2.0f;
        this.O = (f16 + f17) / 2.0f;
        if (this.Q == -1) {
            if (this.J) {
                this.Q = (this.D.a() + 1) / 2;
            } else {
                this.Q = 0;
            }
        }
        this.S = this.Q;
    }

    public final void l() {
        String a16 = a(a(getCurrentItem()));
        if (!TextUtils.isEmpty(a16)) {
            setContentDescription(a16);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Object obj;
        super.onDraw(canvas);
        if (this.D == null) {
            return;
        }
        int i3 = 0;
        int min = Math.min(Math.max(0, this.Q), this.D.a() - 1);
        this.Q = min;
        Object[] objArr = new Object[this.T];
        Object obj2 = new Object();
        Object obj3 = new Object();
        try {
            this.S = min + (((int) (this.P / this.H)) % this.D.a());
        } catch (ArithmeticException unused) {
            n.b("WheelView", "\u51fa\u9519\u4e86\uff01adapter.getItemsCount() == 0\uff0c\u8054\u52a8\u6570\u636e\u4e0d\u5339\u914d", new Object[0]);
        }
        if (!this.J) {
            if (this.S < 0) {
                this.S = 0;
            }
            if (this.S > this.D.a() - 1) {
                this.S = this.D.a() - 1;
            }
        } else {
            if (this.S < 0) {
                this.S = this.D.a() + this.S;
            }
            if (this.S > this.D.a() - 1) {
                this.S -= this.D.a();
            }
        }
        float f16 = this.P % this.H;
        int i16 = 0;
        while (true) {
            int i17 = this.T;
            if (i16 >= i17) {
                break;
            }
            int i18 = this.S - ((i17 / 2) - i16);
            if (i16 == 0) {
                obj2 = a(i18 - 1);
            }
            if (i16 == this.T - 1) {
                obj3 = a(i18 + 1);
            }
            objArr[i16] = a(i18);
            i16++;
        }
        float f17 = this.N;
        canvas.drawLine(0.0f, f17, this.V, f17, this.C);
        float f18 = this.O;
        canvas.drawLine(0.0f, f18, this.V, f18, this.C);
        while (true) {
            int i19 = this.T + 2;
            if (i3 < i19) {
                if (i3 == 0) {
                    obj = obj2;
                } else if (i3 == i19 - 1) {
                    obj = obj3;
                } else {
                    obj = objArr[i3 - 1];
                }
                float f19 = this.H;
                float f26 = (((i3 * f19) - f16) + (f19 / 2.0f)) - f19;
                if (!this.f151827j && !TextUtils.isEmpty(this.E) && !TextUtils.isEmpty(a(obj))) {
                    if (this.K && obj.equals(this.f151822f0.getString(this.L))) {
                        this.f151825h = a(obj);
                    } else {
                        this.f151825h = a(obj) + this.E;
                    }
                } else {
                    this.f151825h = a(obj);
                }
                h();
                this.f151830m.setAlpha(a(f26));
                if (f26 >= this.N && f26 <= this.O) {
                    this.R = (this.S - ((this.T / 2) - i3)) - 1;
                }
                if (f26 >= 0.0f && f26 <= this.U) {
                    canvas.drawText(this.f151825h, this.f151820e0, b(f26), this.f151830m);
                }
                i3++;
                this.f151830m.setTextSize(this.F);
            } else {
                return;
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i3, int i16) {
        this.f151816c0 = i3;
        k();
        setMeasuredDimension(this.V, this.U);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f16;
        boolean onTouchEvent = this.f151821f.onTouchEvent(motionEvent);
        float f17 = (-this.Q) * this.H;
        float a16 = ((this.D.a() - 1) - this.Q) * this.H;
        int action = motionEvent.getAction();
        boolean z16 = false;
        if (action != 0) {
            if (action != 2) {
                if (!onTouchEvent) {
                    if (System.currentTimeMillis() - this.f151814b0 > 120) {
                        a(b.DAGGLE);
                    } else {
                        int y16 = (int) (motionEvent.getY() - (this.U / 2.0f));
                        if (y16 > 0) {
                            f16 = y16 + (this.H / 2.0f);
                        } else {
                            f16 = y16 - (this.H / 2.0f);
                        }
                        int i3 = (int) f16;
                        float f18 = this.H;
                        if (f18 != 0.0f) {
                            this.W = (int) (((int) (i3 / f18)) * f18);
                            a(b.CLICK);
                        }
                    }
                }
            } else {
                float rawY = this.f151812a0 - motionEvent.getRawY();
                this.f151812a0 = motionEvent.getRawY();
                float f19 = this.P + rawY;
                this.P = f19;
                if (!this.J) {
                    float f26 = this.H * 0.25f;
                    if ((f19 - f26 < f17 && rawY < 0.0f) || (f26 + f19 > a16 && rawY > 0.0f)) {
                        this.P = f19 - rawY;
                        z16 = true;
                    }
                }
            }
        } else {
            this.f151814b0 = System.currentTimeMillis();
            b();
            this.f151812a0 = motionEvent.getRawY();
        }
        if (!z16 && motionEvent.getAction() != 0) {
            invalidate();
        }
        return true;
    }

    public final void setAdapter(com.tencent.luggage.wxa.ac.b bVar) {
        this.D = bVar;
        k();
        invalidate();
    }

    public final void setCurrentItem(int i3) {
        this.R = i3;
        this.Q = i3;
        this.P = 0.0f;
        l();
        invalidate();
    }

    public final void setCyclic(boolean z16) {
        this.J = z16;
    }

    public void setDividerColor(int i3) {
        if (i3 != 0) {
            this.I = i3;
            this.C.setColor(i3);
        }
    }

    public void setDividerHeight(float f16) {
        this.C.setStrokeWidth(f16);
    }

    public void setGravity(int i3) {
        this.f151818d0 = i3;
    }

    public void setIsOptions(boolean z16) {
        this.f151826i = z16;
    }

    public void setLabel(String str) {
        this.E = str;
    }

    public void setLongTermMonthDay(boolean z16) {
        this.M = z16;
    }

    public final void setOnItemSelectedListener(com.tencent.luggage.wxa.bc.b bVar) {
        this.f151823g = bVar;
    }

    public void setTotalScrollY(float f16) {
        this.P = f16;
    }

    public final void a(Context context) {
        this.f151819e = new d(this);
        GestureDetector gestureDetector = new GestureDetector(context, new com.tencent.luggage.wxa.bc.a(this));
        this.f151821f = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.J = true;
        this.P = 0.0f;
        this.Q = -1;
        c();
    }

    public WheelView d(int i3) {
        this.f151813b = i3;
        this.f151830m.setColor(i3);
        this.f151815c = (int) ((((i3 >> 24) & 255) / 255.0f) * 255.0f);
        return this;
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f151811a = 0;
        this.f151813b = Color.rgb(255, 255, 255);
        this.f151817d = 2;
        this.f151825h = "";
        this.f151826i = false;
        this.f151827j = true;
        this.f151828k = com.tencent.luggage.wxa.ec.a.a();
        this.T = 5;
        this.W = 0;
        this.f151812a0 = 0.0f;
        this.f151814b0 = 0L;
        this.f151818d0 = 17;
        this.f151820e0 = 0;
        this.f151824g0 = new Rect();
        this.f151822f0 = context;
        this.F = getResources().getDimensionPixelSize(R.dimen.f159281cy4);
        this.G = getResources().getDimensionPixelSize(R.dimen.f159280cy3);
        this.f151818d0 = 17;
        this.I = -2763307;
        a(context);
    }

    public final float b(float f16) {
        Paint.FontMetricsInt fontMetricsInt = this.f151830m.getFontMetricsInt();
        float abs = Math.abs(fontMetricsInt.top);
        float f17 = fontMetricsInt.bottom;
        return (f16 - f17) + ((abs + f17) / 2.0f);
    }

    public final int b(int i3) {
        int a16 = this.D.a();
        if (a16 == 0) {
            return a16;
        }
        int i16 = i3 % a16;
        return i16 < 0 ? i16 + a16 : i16;
    }

    public void a(b bVar) {
        b();
        if (bVar == b.FLING || bVar == b.DAGGLE) {
            float f16 = this.P;
            float f17 = this.H;
            int i3 = (int) (((f16 % f17) + f17) % f17);
            this.W = i3;
            float f18 = i3;
            if (f18 > f17 / 2.0f) {
                this.W = (int) (f17 - f18);
            } else {
                this.W = -i3;
            }
        }
        this.f151829l = this.f151828k.a(new e(this, this.W), 0L, 10L);
    }

    public final void c(float f16) {
        b();
        this.f151829l = this.f151828k.a(new com.tencent.luggage.wxa.cc.c(this, f16), 0L, 5L);
    }

    public WheelView c(int i3) {
        this.f151811a = i3;
        invalidate();
        return this;
    }

    public final String a(int i3) {
        if (this.J) {
            i3 = b(i3);
        }
        return this.D.a(i3);
    }

    public final int a(float f16) {
        float f17 = this.U / 2.0f;
        float interpolation = 1.0f - new AccelerateInterpolator(0.3f).getInterpolation(Math.abs((f16 - f17) / f17));
        int i3 = this.f151815c;
        float f18 = i3;
        int i16 = (int) (interpolation * f18);
        float f19 = f18 * 0.14f;
        return ((float) i16) < f19 ? (int) f19 : i16 > i3 ? i3 : i16;
    }

    public final String a(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    public final void a() {
        Rect rect = new Rect();
        Paint paint = this.f151830m;
        String str = this.f151825h;
        paint.getTextBounds(str, 0, str.length(), rect);
        this.f151830m.getTextBounds(this.f151825h, 0, 0, new Rect());
        int length = this.f151825h.length();
        int i3 = 0;
        while (true) {
            int i16 = length - i3;
            if (i16 <= 1) {
                break;
            }
            Rect rect2 = new Rect();
            int i17 = (i16 >> 1) + i3;
            this.f151830m.getTextBounds(this.f151825h, 0, i17, rect2);
            if (rect2.width() >= g()) {
                length = i17 - 1;
            } else if (rect2.width() < g()) {
                i3 = i17 + 1;
            }
        }
        this.f151825h = this.f151825h.substring(0, i3);
        while (true) {
            if (this.f151830m.measureText(this.f151825h + MiniBoxNoticeInfo.APPNAME_SUFFIX) <= g() || i3 - 1 <= 0) {
                break;
            } else {
                this.f151825h = this.f151825h.substring(0, i3);
            }
        }
        this.f151825h += MiniBoxNoticeInfo.APPNAME_SUFFIX;
    }

    public void a(boolean z16) {
        this.f151827j = z16;
    }

    public void a(boolean z16, int i3) {
        this.K = z16;
        this.L = i3;
    }
}
