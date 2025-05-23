package com.tencent.now.od.ui.common.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/* loaded from: classes22.dex */
public class StageProgressView extends View {
    private int C;
    private int D;
    private String[] E;
    private int F;
    private int G;
    private int H;
    private int I;
    private Paint J;
    private Paint K;
    private boolean L;
    private float M;
    private Rect N;
    private int P;
    private int Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private int V;

    /* renamed from: d, reason: collision with root package name */
    private int f338535d;

    /* renamed from: e, reason: collision with root package name */
    private float f338536e;

    /* renamed from: f, reason: collision with root package name */
    private int f338537f;

    /* renamed from: h, reason: collision with root package name */
    private int f338538h;

    /* renamed from: i, reason: collision with root package name */
    private int f338539i;

    /* renamed from: m, reason: collision with root package name */
    private int f338540m;

    public StageProgressView(Context context) {
        super(context);
        this.f338535d = 17;
        this.L = true;
        this.M = 0.0f;
        a(context, null, 0);
    }

    private void a(Context context, AttributeSet attributeSet, int i3) {
        String[] split;
        this.J = new Paint(1);
        this.K = new Paint(1);
        this.N = new Rect();
        this.I = (int) (getResources().getDisplayMetrics().density * 6.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, tn3.a.L, i3, 0);
        String string = obtainStyledAttributes.getString(tn3.a.T);
        if (string == null) {
            split = null;
        } else {
            split = string.split(";");
        }
        setStages(split);
        setStageInterval(obtainStyledAttributes.getDimensionPixelSize(tn3.a.S, 12));
        setIndicatorIndent(obtainStyledAttributes.getDimensionPixelSize(tn3.a.N, 12));
        setOnTextColor(obtainStyledAttributes.getColor(tn3.a.X, -7829368));
        setToTextColor(obtainStyledAttributes.getColor(tn3.a.Y, -7829368));
        d(obtainStyledAttributes.getDimensionPixelSize(tn3.a.W, 12));
        setIndicatorColor(obtainStyledAttributes.getColor(tn3.a.M, -7829368));
        setProgressColor(obtainStyledAttributes.getColor(tn3.a.Q, -16777216));
        setIndicatorRadius(obtainStyledAttributes.getDimensionPixelSize(tn3.a.O, 8));
        setIndicatorStrokeSize(obtainStyledAttributes.getDimensionPixelSize(tn3.a.P, 4));
        setProgress(obtainStyledAttributes.getInteger(tn3.a.R, 0));
        setTextBelow(obtainStyledAttributes.getBoolean(tn3.a.V, false));
        setSubProgress(obtainStyledAttributes.getFloat(tn3.a.U, 0.0f));
        obtainStyledAttributes.recycle();
    }

    private int b() {
        String[] strArr = this.E;
        if (strArr == null || strArr.length == 0) {
            return 0;
        }
        Paint paint = this.J;
        String str = strArr[0];
        paint.getTextBounds(str, 0, str.length(), this.N);
        this.R = this.N.height();
        return this.N.height() + (this.C * 2) + this.I;
    }

    private int c() {
        String[] strArr = this.E;
        if (strArr != null && strArr.length != 0) {
            return (this.G * (strArr.length - 1)) + (this.H * 2);
        }
        return 0;
    }

    private void d(float f16) {
        if (this.f338536e != f16) {
            this.f338536e = f16;
            this.J.setTextSize(f16);
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        String[] strArr = this.E;
        if (strArr != null && strArr.length != 0) {
            this.K.setColor(this.f338539i);
            int length = this.E.length - 1;
            int i3 = 0;
            while (i3 < length) {
                int i16 = this.T;
                int i17 = this.H;
                int i18 = this.G;
                float f16 = i16 + i17 + (i3 * i18) + this.C;
                int i19 = this.U;
                i3++;
                canvas.drawLine(f16, i19 + r7, ((i16 + i17) + (i18 * i3)) - r7, i19 + r7, this.K);
            }
            for (int i26 = 0; i26 < this.E.length; i26++) {
                if (i26 <= this.F) {
                    this.J.setColor(this.f338537f);
                } else {
                    this.J.setColor(this.f338538h);
                }
                Paint paint = this.J;
                String str = this.E[i26];
                paint.getTextBounds(str, 0, str.length(), this.N);
                if (i26 == 0) {
                    canvas.drawText(this.E[i26], this.T, this.V - this.N.top, this.J);
                } else {
                    String[] strArr2 = this.E;
                    if (i26 == strArr2.length - 1) {
                        canvas.drawText(strArr2[i26], (this.T + this.P) - this.N.width(), this.V - this.N.top, this.J);
                    } else {
                        canvas.drawText(strArr2[i26], ((this.T + this.H) + (this.G * i26)) - (this.N.width() / 2.0f), this.V - this.N.top, this.J);
                    }
                }
                float f17 = this.T + this.H + (this.G * i26);
                int i27 = this.U;
                canvas.drawCircle(f17, i27 + r4, this.C, this.K);
            }
            this.K.setColor(this.f338540m);
            int i28 = this.T;
            int i29 = this.H;
            int i36 = this.U;
            int i37 = this.C;
            canvas.drawLine(i28 + i29, i36 + i37, i28 + i29 + (this.F * this.G), i36 + i37, this.K);
            if (this.F < this.E.length - 1) {
                float f18 = this.M;
                if (f18 > 0.0f) {
                    int i38 = this.T;
                    int i39 = this.H;
                    int i46 = this.G;
                    int i47 = this.U;
                    int i48 = this.C;
                    canvas.drawLine(i38 + i39 + (r0 * i46), i47 + i48, i38 + i39 + (r0 * i46) + (f18 * i46), i47 + i48, this.K);
                }
            }
            for (int i49 = 0; i49 <= this.F; i49++) {
                float f19 = this.T + this.H + (this.G * i49);
                int i56 = this.U;
                canvas.drawCircle(f19, i56 + r3, this.C, this.K);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int i17;
        int i18;
        this.P = c();
        this.Q = b();
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode == 0) {
            size = this.P;
        } else if (mode == Integer.MIN_VALUE && (i17 = this.P) <= size) {
            size = i17;
        }
        int mode2 = View.MeasureSpec.getMode(i16);
        int size2 = View.MeasureSpec.getSize(i16);
        if (mode2 == 0) {
            size2 = this.Q;
        } else if (mode2 == Integer.MIN_VALUE && (i18 = this.Q) <= size2) {
            size2 = i18;
        }
        int paddingLeft = size + getPaddingLeft() + getPaddingRight();
        int paddingBottom = size2 + getPaddingBottom() + getPaddingTop();
        this.T = (paddingLeft - this.P) / 2;
        int i19 = (paddingBottom - this.Q) / 2;
        this.S = i19;
        if (this.L) {
            this.U = i19;
            this.V = i19 + (this.C * 2) + this.I;
        } else {
            this.V = i19;
            this.U = i19 + this.R + this.I;
        }
        setMeasuredDimension(paddingLeft, paddingBottom);
    }

    public void setIndicatorColor(int i3) {
        if (this.f338539i == i3) {
            return;
        }
        this.f338539i = i3;
        invalidate();
    }

    public void setIndicatorIndent(int i3) {
        if (this.H == i3) {
            return;
        }
        this.H = i3;
        requestLayout();
        invalidate();
    }

    public void setIndicatorRadius(int i3) {
        if (this.C == i3) {
            return;
        }
        this.C = i3;
        requestLayout();
        invalidate();
    }

    public void setIndicatorStrokeSize(int i3) {
        if (this.D == i3) {
            return;
        }
        this.D = i3;
        this.K.setStrokeWidth(i3);
        requestLayout();
        invalidate();
    }

    public void setOnTextColor(int i3) {
        if (this.f338537f == i3) {
            return;
        }
        this.f338537f = i3;
        invalidate();
    }

    public void setProgress(int i3) {
        String[] strArr = this.E;
        if (strArr != null && i3 < strArr.length && this.F != i3) {
            this.F = i3;
            this.M = 0.0f;
            invalidate();
        }
    }

    public void setProgressColor(int i3) {
        if (this.f338540m == i3) {
            return;
        }
        this.f338540m = i3;
        invalidate();
    }

    public void setStageInterval(int i3) {
        if (this.G == i3) {
            return;
        }
        this.G = i3;
        requestLayout();
        invalidate();
    }

    public void setStages(String[] strArr) {
        if (this.E == strArr) {
            return;
        }
        this.E = strArr;
        requestLayout();
        invalidate();
    }

    public void setSubProgress(float f16) {
        if (f16 != this.M) {
            this.M = f16;
            invalidate();
        }
    }

    public void setTextBelow(boolean z16) {
        if (this.L != z16) {
            this.L = z16;
            invalidate();
        }
    }

    public void setTextSize(int i3) {
        Resources resources;
        Context context = getContext();
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        d(TypedValue.applyDimension(2, i3, resources.getDisplayMetrics()));
    }

    public void setToTextColor(int i3) {
        if (this.f338538h == i3) {
            return;
        }
        this.f338538h = i3;
        invalidate();
    }

    public StageProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f338535d = 17;
        this.L = true;
        this.M = 0.0f;
        a(context, attributeSet, 0);
    }

    public StageProgressView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f338535d = 17;
        this.L = true;
        this.M = 0.0f;
        a(context, attributeSet, i3);
    }
}
