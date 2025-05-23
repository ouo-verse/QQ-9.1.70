package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.core.internal.view.SupportMenu;

/* loaded from: classes20.dex */
public class OvalProgress extends RelativeLayout {
    private RectF C;
    private RectF D;
    private RectF E;
    private RectF F;
    private RectF G;
    private RectF H;
    private RectF I;
    private RectF J;
    private a K;
    private float L;
    private float M;
    private boolean N;
    private double P;
    private int Q;
    private int R;

    /* renamed from: d, reason: collision with root package name */
    public float f315895d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f315896e;

    /* renamed from: f, reason: collision with root package name */
    private Paint f315897f;

    /* renamed from: h, reason: collision with root package name */
    private Paint f315898h;

    /* renamed from: i, reason: collision with root package name */
    private Paint f315899i;

    /* renamed from: m, reason: collision with root package name */
    private Paint f315900m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        double f315901a;

        /* renamed from: b, reason: collision with root package name */
        double f315902b;

        /* renamed from: c, reason: collision with root package name */
        double f315903c;

        /* renamed from: d, reason: collision with root package name */
        double f315904d;

        /* renamed from: e, reason: collision with root package name */
        double f315905e;

        a() {
        }
    }

    public OvalProgress(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.L = -1.0f;
        this.M = -1.0f;
        this.N = false;
        this.Q = -3355444;
        this.R = -16745985;
    }

    private boolean a() {
        int width = getWidth();
        int height = getHeight();
        if (width <= 0 && height <= 0) {
            return false;
        }
        if (this.f315895d <= 0.0f) {
            this.f315895d = (getResources().getDisplayMetrics().density * 4.0f) / 2.0f;
        }
        if (this.f315896e == null || this.f315897f == null) {
            Paint paint = new Paint();
            this.f315896e = paint;
            paint.setAntiAlias(true);
            this.f315896e.setColor(this.Q);
            this.f315896e.setStrokeWidth(2.0f);
            Paint paint2 = new Paint();
            this.f315897f = paint2;
            paint2.setAntiAlias(true);
            this.f315897f.setColor(this.R);
            this.f315897f.setStrokeWidth(2.0f);
        }
        if (this.E == null || this.F == null || this.I == null || this.J == null || this.f315898h == null || this.f315899i == null) {
            Paint paint3 = new Paint();
            this.f315898h = paint3;
            paint3.setAntiAlias(true);
            this.f315898h.setColor(this.Q);
            this.f315898h.setStrokeWidth(2.0f);
            this.f315898h.setStyle(Paint.Style.STROKE);
            Paint paint4 = new Paint();
            this.f315899i = paint4;
            paint4.setAntiAlias(true);
            this.f315899i.setColor(this.R);
            this.f315899i.setStrokeWidth(2.0f);
            this.f315899i.setStyle(Paint.Style.STROKE);
            RectF rectF = new RectF();
            this.E = rectF;
            rectF.left = 1.0f;
            float f16 = height;
            rectF.right = (1.0f + f16) - 2.0f;
            rectF.top = 1.0f;
            float f17 = height - 1;
            rectF.bottom = f17;
            RectF rectF2 = new RectF();
            this.F = rectF2;
            int i3 = width - 1;
            float f18 = i3 - (height - 2);
            rectF2.left = f18;
            float f19 = i3;
            rectF2.right = f19;
            rectF2.top = 1.0f;
            rectF2.bottom = f17;
            RectF rectF3 = new RectF();
            this.I = rectF3;
            rectF3.left = 1.0f;
            rectF3.right = (f16 + 1.0f) - 2.0f;
            rectF3.top = 1.0f;
            rectF3.bottom = f17;
            RectF rectF4 = new RectF();
            this.J = rectF4;
            rectF4.left = f18;
            rectF4.right = f19;
            rectF4.top = 1.0f;
            rectF4.bottom = f17;
        }
        float f26 = width - height;
        if (this.C == null || this.D == null || this.G == null || this.H == null) {
            RectF rectF5 = new RectF();
            this.C = rectF5;
            rectF5.left = (float) ((((width - f26) * 1.0d) / 2.0d) - 0.5d);
            rectF5.right = (float) (r0 + f26 + 0.5d + 0.5d);
            rectF5.top = 0.0f;
            rectF5.bottom = 2.0f;
            RectF rectF6 = new RectF();
            this.D = rectF6;
            RectF rectF7 = this.C;
            rectF6.left = rectF7.left;
            rectF6.right = rectF7.right;
            float f27 = height - 2;
            rectF6.top = f27;
            float f28 = height;
            rectF6.bottom = f28;
            RectF rectF8 = new RectF();
            this.G = rectF8;
            RectF rectF9 = this.C;
            rectF8.left = rectF9.left;
            rectF8.right = rectF9.right;
            rectF8.top = 0.0f;
            rectF8.bottom = 2.0f;
            RectF rectF10 = new RectF();
            this.H = rectF10;
            RectF rectF11 = this.G;
            rectF10.left = rectF11.left;
            rectF10.right = rectF11.right;
            rectF10.top = f27;
            rectF10.bottom = f28;
        }
        if (this.f315900m == null || this.L == -1.0f || this.M == -1.0f) {
            Paint paint5 = new Paint();
            this.f315900m = paint5;
            paint5.setAntiAlias(true);
            this.f315900m.setColor(SupportMenu.CATEGORY_MASK);
            double d16 = ((height - 2) / 2) / 1.4142135623731d;
            RectF rectF12 = this.F;
            float f29 = (rectF12.left + rectF12.right) / 2.0f;
            float f36 = (rectF12.top + rectF12.bottom) / 2.0f;
            this.L = (float) (f29 + d16);
            this.M = (float) (f36 - d16);
        }
        if (this.K == null) {
            double d17 = (height - 2) * 3.141592653589793d;
            double d18 = (2.0f * f26) + d17;
            a aVar = new a();
            this.K = aVar;
            double d19 = (0.25d * d17) / d18;
            aVar.f315901a = d19;
            double d26 = (f26 * 1.0d) / d18;
            aVar.f315902b = d26;
            aVar.f315903c = (d17 * 0.5d) / d18;
            aVar.f315904d = d26;
            aVar.f315905e = d19;
        }
        return true;
    }

    private double b(Canvas canvas, double d16) {
        int i3;
        if (d16 <= 0.0d) {
            return 0.0d;
        }
        double d17 = this.K.f315905e;
        int i16 = 90;
        if (d17 > 0.0d) {
            if (d16 > 0.99d * d17) {
                i3 = 90;
            } else {
                i3 = (int) (((1.0d * d16) * 90) / d17);
            }
        } else {
            i3 = 0;
        }
        if (i3 <= 90) {
            i16 = i3;
        }
        canvas.drawArc(this.I, 90.0f, i16, false, this.f315899i);
        return d16 - this.K.f315905e;
    }

    private double c(Canvas canvas, double d16) {
        int i3;
        if (d16 <= 0.0d) {
            return 0.0d;
        }
        double d17 = this.K.f315901a;
        int i16 = 90;
        if (d17 > 0.0d) {
            i3 = (int) (((1.0d * d16) * 90) / d17);
        } else {
            i3 = 0;
        }
        if (i3 <= 90) {
            i16 = i3;
        }
        canvas.drawArc(this.I, 180.0f, i16, false, this.f315899i);
        return d16 - this.K.f315901a;
    }

    private double d(Canvas canvas, double d16) {
        int i3;
        if (d16 <= 0.0d) {
            return 0.0d;
        }
        double d17 = this.K.f315903c;
        int i16 = 180;
        if (d17 > 0.0d) {
            i3 = (int) (((1.0d * d16) * 180) / d17);
        } else {
            i3 = 0;
        }
        if (i3 <= 180) {
            i16 = i3;
        }
        canvas.drawArc(this.J, 270.0f, i16, false, this.f315899i);
        return d16 - this.K.f315903c;
    }

    private void e(Canvas canvas) {
        canvas.drawRect(this.C, this.f315896e);
        canvas.drawRect(this.D, this.f315896e);
        canvas.drawArc(this.E, 90.0f, 180.0f, false, this.f315898h);
        canvas.drawArc(this.F, 270.0f, 180.0f, false, this.f315898h);
        b(canvas, f(canvas, d(canvas, g(canvas, c(canvas, this.P)))));
    }

    private double f(Canvas canvas, double d16) {
        double d17 = 0.0d;
        if (d16 <= 0.0d) {
            return 0.0d;
        }
        double d18 = this.K.f315904d;
        if (d18 > 0.0d) {
            d17 = d16 / d18;
        }
        if (d17 > 1.0d) {
            d17 = 1.0d;
        }
        RectF rectF = this.H;
        canvas.drawRect(rectF.left + ((float) ((1.0d - d17) * (r8 - r5))), rectF.top, rectF.right, rectF.bottom, this.f315897f);
        return d16 - this.K.f315904d;
    }

    private double g(Canvas canvas, double d16) {
        double d17 = 0.0d;
        if (d16 <= 0.0d) {
            return 0.0d;
        }
        double d18 = this.K.f315902b;
        if (d18 > 0.0d) {
            d17 = d16 / d18;
        }
        if (d17 > 1.0d) {
            d17 = 1.0d;
        }
        RectF rectF = this.G;
        float f16 = rectF.right;
        float f17 = rectF.left;
        canvas.drawRect(f17, rectF.top, f17 + ((float) (d17 * (f16 - f17))), rectF.bottom, this.f315897f);
        return d16 - this.K.f315902b;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (a()) {
            e(canvas);
            if (this.N) {
                canvas.drawCircle(this.L, this.M, 4.0f, this.f315900m);
            }
        }
    }

    public void setProgressParams(long j3, long j16) {
        if (j3 > 0 && j16 >= 0) {
            if (j16 > j3) {
                this.N = false;
                this.P = 1.0d;
            } else {
                this.N = false;
                this.P = (j16 * 1.0d) / j3;
            }
        } else {
            this.P = 0.0d;
        }
        postInvalidate();
    }

    public void setThemeColor(int i3, int i16) {
        this.Q = i3;
        this.R = i16;
    }

    public OvalProgress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.L = -1.0f;
        this.M = -1.0f;
        this.N = false;
        this.Q = -3355444;
        this.R = -16745985;
    }

    public OvalProgress(Context context) {
        super(context);
        this.L = -1.0f;
        this.M = -1.0f;
        this.N = false;
        this.Q = -3355444;
        this.R = -16745985;
    }
}
