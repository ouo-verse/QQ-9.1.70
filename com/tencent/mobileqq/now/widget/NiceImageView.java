package com.tencent.mobileqq.now.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes9.dex */
public class NiceImageView extends ImageView {
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    private Xfermode J;
    private int K;
    private int L;
    private float M;
    private float[] N;
    private float[] P;
    private RectF Q;
    private RectF R;
    private Paint S;
    private Path T;
    private Path U;

    /* renamed from: d, reason: collision with root package name */
    private Context f254393d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f254394e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f254395f;

    /* renamed from: h, reason: collision with root package name */
    private int f254396h;

    /* renamed from: i, reason: collision with root package name */
    private int f254397i;

    /* renamed from: m, reason: collision with root package name */
    private int f254398m;

    public NiceImageView(Context context) {
        this(context, null);
    }

    private void a() {
        if (this.f254394e) {
            return;
        }
        int i3 = 0;
        if (this.D <= 0) {
            float[] fArr = this.N;
            int i16 = this.E;
            float f16 = i16;
            fArr[1] = f16;
            fArr[0] = f16;
            int i17 = this.F;
            float f17 = i17;
            fArr[3] = f17;
            fArr[2] = f17;
            int i18 = this.H;
            float f18 = i18;
            fArr[5] = f18;
            fArr[4] = f18;
            int i19 = this.G;
            float f19 = i19;
            fArr[7] = f19;
            fArr[6] = f19;
            float[] fArr2 = this.P;
            int i26 = this.f254396h;
            float f26 = i16 - (i26 / 2.0f);
            fArr2[1] = f26;
            fArr2[0] = f26;
            float f27 = i17 - (i26 / 2.0f);
            fArr2[3] = f27;
            fArr2[2] = f27;
            float f28 = i18 - (i26 / 2.0f);
            fArr2[5] = f28;
            fArr2[4] = f28;
            float f29 = i19 - (i26 / 2.0f);
            fArr2[7] = f29;
            fArr2[6] = f29;
            return;
        }
        while (true) {
            float[] fArr3 = this.N;
            if (i3 < fArr3.length) {
                int i27 = this.D;
                fArr3[i3] = i27;
                this.P[i3] = i27 - (this.f254396h / 2.0f);
                i3++;
            } else {
                return;
            }
        }
    }

    private void b(boolean z16) {
        if (z16) {
            this.D = 0;
        }
        a();
        i();
        invalidate();
    }

    private void c() {
        if (!this.f254394e) {
            this.f254398m = 0;
        }
    }

    private int d(Context context, float f16) {
        return (int) ((f16 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void e(Canvas canvas) {
        if (this.f254394e) {
            int i3 = this.f254396h;
            if (i3 > 0) {
                f(canvas, i3, this.f254397i, this.M - (i3 / 2.0f));
            }
            int i16 = this.f254398m;
            if (i16 > 0) {
                f(canvas, i16, this.C, (this.M - this.f254396h) - (i16 / 2.0f));
                return;
            }
            return;
        }
        int i17 = this.f254396h;
        if (i17 > 0) {
            g(canvas, i17, this.f254397i, this.R, this.N);
        }
    }

    private void f(Canvas canvas, int i3, int i16, float f16) {
        h(i3, i16);
        this.T.addCircle(this.K / 2.0f, this.L / 2.0f, f16, Path.Direction.CCW);
        canvas.drawPath(this.T, this.S);
    }

    private void g(Canvas canvas, int i3, int i16, RectF rectF, float[] fArr) {
        h(i3, i16);
        this.T.addRoundRect(rectF, fArr, Path.Direction.CCW);
        canvas.drawPath(this.T, this.S);
    }

    private void h(int i3, int i16) {
        this.T.reset();
        this.S.setStrokeWidth(i3);
        this.S.setColor(i16);
        this.S.setStyle(Paint.Style.STROKE);
    }

    private void i() {
        if (!this.f254394e) {
            RectF rectF = this.R;
            int i3 = this.f254396h;
            rectF.set(i3 / 2.0f, i3 / 2.0f, this.K - (i3 / 2.0f), this.L - (i3 / 2.0f));
        }
    }

    private void j() {
        if (this.f254394e) {
            float min = Math.min(this.K, this.L) / 2.0f;
            this.M = min;
            RectF rectF = this.Q;
            int i3 = this.K;
            int i16 = this.L;
            rectF.set((i3 / 2.0f) - min, (i16 / 2.0f) - min, (i3 / 2.0f) + min, (i16 / 2.0f) + min);
            return;
        }
        this.Q.set(0.0f, 0.0f, this.K, this.L);
        if (this.f254395f) {
            this.Q = this.R;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.saveLayer(this.Q, null, 31);
        if (!this.f254395f) {
            int i3 = this.K;
            int i16 = this.f254396h;
            int i17 = this.f254398m;
            int i18 = this.L;
            canvas.scale((((i3 - (i16 * 2)) - (i17 * 2)) * 1.0f) / i3, (((i18 - (i16 * 2)) - (i17 * 2)) * 1.0f) / i18, i3 / 2.0f, i18 / 2.0f);
        }
        super.onDraw(canvas);
        this.S.reset();
        this.T.reset();
        if (this.f254394e) {
            this.T.addCircle(this.K / 2.0f, this.L / 2.0f, this.M, Path.Direction.CCW);
        } else {
            this.T.addRoundRect(this.Q, this.P, Path.Direction.CCW);
        }
        this.S.setAntiAlias(true);
        this.S.setStyle(Paint.Style.FILL);
        this.S.setXfermode(this.J);
        if (Build.VERSION.SDK_INT <= 27) {
            canvas.drawPath(this.T, this.S);
        } else {
            this.U.addRect(this.Q, Path.Direction.CCW);
            this.U.op(this.T, Path.Op.DIFFERENCE);
            canvas.drawPath(this.U, this.S);
        }
        this.S.setXfermode(null);
        int i19 = this.I;
        if (i19 != 0) {
            this.S.setColor(i19);
            canvas.drawPath(this.T, this.S);
        }
        canvas.restore();
        e(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        this.K = i3;
        this.L = i16;
        i();
        j();
    }

    public void setBorderColor(@ColorInt int i3) {
        this.f254397i = i3;
        invalidate();
    }

    public void setBorderWidth(int i3) {
        this.f254396h = d(this.f254393d, i3);
        b(false);
    }

    public void setCornerBottomLeftRadius(int i3) {
        this.G = d(this.f254393d, i3);
        b(true);
    }

    public void setCornerBottomRightRadius(int i3) {
        this.H = d(this.f254393d, i3);
        b(true);
    }

    public void setCornerRadius(int i3) {
        this.D = d(this.f254393d, i3);
        b(false);
    }

    public void setCornerTopLeftRadius(int i3) {
        this.E = d(this.f254393d, i3);
        b(true);
    }

    public void setCornerTopRightRadius(int i3) {
        this.F = d(this.f254393d, i3);
        b(true);
    }

    public void setInnerBorderColor(@ColorInt int i3) {
        this.C = i3;
        invalidate();
    }

    public void setInnerBorderWidth(int i3) {
        this.f254398m = d(this.f254393d, i3);
        c();
        invalidate();
    }

    public void setMaskColor(@ColorInt int i3) {
        this.I = i3;
        invalidate();
    }

    public NiceImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NiceImageView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f254397i = -1;
        this.C = -1;
        this.f254393d = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.NiceImageView, 0, 0);
        for (int i16 = 0; i16 < obtainStyledAttributes.getIndexCount(); i16++) {
            int index = obtainStyledAttributes.getIndex(i16);
            if (index == R.styleable.NiceImageView_is_cover_src) {
                this.f254395f = obtainStyledAttributes.getBoolean(index, this.f254395f);
            } else if (index == R.styleable.NiceImageView_is_circle) {
                this.f254394e = obtainStyledAttributes.getBoolean(index, this.f254394e);
            } else if (index == R.styleable.NiceImageView_border_width) {
                this.f254396h = obtainStyledAttributes.getDimensionPixelSize(index, this.f254396h);
            } else if (index == R.styleable.NiceImageView_border_color) {
                this.f254397i = obtainStyledAttributes.getColor(index, this.f254397i);
            } else if (index == R.styleable.NiceImageView_inner_border_width) {
                this.f254398m = obtainStyledAttributes.getDimensionPixelSize(index, this.f254398m);
            } else if (index == R.styleable.NiceImageView_inner_border_color) {
                this.C = obtainStyledAttributes.getColor(index, this.C);
            } else if (index == R.styleable.NiceImageView_corner_radius_value) {
                this.D = obtainStyledAttributes.getDimensionPixelSize(index, this.D);
            } else if (index == R.styleable.NiceImageView_corner_top_left_radius) {
                this.E = obtainStyledAttributes.getDimensionPixelSize(index, this.E);
            } else if (index == R.styleable.NiceImageView_corner_top_right_radius) {
                this.F = obtainStyledAttributes.getDimensionPixelSize(index, this.F);
            } else if (index == R.styleable.NiceImageView_corner_bottom_left_radius) {
                this.G = obtainStyledAttributes.getDimensionPixelSize(index, this.G);
            } else if (index == R.styleable.NiceImageView_corner_bottom_right_radius) {
                this.H = obtainStyledAttributes.getDimensionPixelSize(index, this.H);
            } else if (index == R.styleable.NiceImageView_mask_color_value) {
                this.I = obtainStyledAttributes.getColor(index, this.I);
            }
        }
        obtainStyledAttributes.recycle();
        this.N = new float[8];
        this.P = new float[8];
        this.R = new RectF();
        this.Q = new RectF();
        this.S = new Paint();
        this.T = new Path();
        if (Build.VERSION.SDK_INT <= 27) {
            this.J = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        } else {
            this.J = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
            this.U = new Path();
        }
        a();
        c();
    }
}
