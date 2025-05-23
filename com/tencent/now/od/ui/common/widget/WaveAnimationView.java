package com.tencent.now.od.ui.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.internal.view.SupportMenu;

/* compiled from: P */
/* loaded from: classes22.dex */
public class WaveAnimationView extends View {
    private int C;
    private int D;
    private int E;
    private RectF F;
    private Paint G;
    private int H;
    private boolean I;
    private boolean J;
    private final Handler K;
    private Runnable L;

    /* renamed from: d, reason: collision with root package name */
    private int f338552d;

    /* renamed from: e, reason: collision with root package name */
    private int f338553e;

    /* renamed from: f, reason: collision with root package name */
    private int f338554f;

    /* renamed from: h, reason: collision with root package name */
    private int f338555h;

    /* renamed from: i, reason: collision with root package name */
    private int f338556i;

    /* renamed from: m, reason: collision with root package name */
    private int f338557m;

    public WaveAnimationView(Context context) {
        super(context);
        this.f338552d = 0;
        this.f338553e = 0;
        this.f338554f = 0;
        this.f338555h = 0;
        this.f338556i = SupportMenu.CATEGORY_MASK;
        this.f338557m = 1000;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.H = 0;
        this.I = false;
        this.J = false;
        this.K = new Handler(Looper.getMainLooper());
        this.L = new Runnable() { // from class: com.tencent.now.od.ui.common.widget.a
            @Override // java.lang.Runnable
            public final void run() {
                WaveAnimationView.this.invalidate();
            }
        };
    }

    private int a(float f16) {
        return (int) (((float) Math.sin(Math.pow(f16 - 1.0f, 2.0d) * 3.141592653589793d)) * this.f338552d);
    }

    private float b(float f16) {
        int i3;
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int i16 = this.C;
        if (i16 >= measuredWidth || (i3 = this.D) >= measuredHeight) {
            return 0.0f;
        }
        float min = Math.min(measuredWidth - i16, measuredHeight - i3);
        if (f16 <= 0.0f) {
            return 0.0f;
        }
        if (f16 >= 1.0f) {
            return min;
        }
        return (2.0f - (2.0f / (f16 + 1.0f))) * min;
    }

    private float c(int i3) {
        int i16;
        if (i3 < 0 || i3 >= (i16 = this.E)) {
            return 0.0f;
        }
        float f16 = (this.f338557m * 2.0f) / (i16 + 1);
        float f17 = (this.H - ((i3 * f16) / 2.0f)) / f16;
        if (f17 < 0.0f) {
            return 0.0f;
        }
        if (f17 > 1.0f) {
            return 1.0f;
        }
        return f17;
    }

    public void d() {
        if (!this.I) {
            return;
        }
        this.K.removeCallbacks(this.L);
        this.I = false;
        this.H = 0;
        invalidate();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.J = true;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.J = false;
        d();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i3;
        super.onDraw(canvas);
        if (getVisibility() != 0 || !this.J || this.f338557m <= 0 || !this.I) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (this.C < measuredWidth && (i3 = this.D) < measuredHeight) {
            this.F.set((measuredWidth - r2) / 2.0f, (measuredHeight - i3) / 2.0f, (measuredWidth + r2) / 2.0f, (measuredHeight + i3) / 2.0f);
        } else {
            this.F.set(0.0f, 0.0f, measuredWidth, measuredHeight);
        }
        if (this.H >= this.f338557m) {
            this.H = 0;
        }
        for (int i16 = 0; i16 < this.E; i16++) {
            float c16 = c(i16);
            if (c16 > 0.0f && c16 < 1.0f) {
                float b16 = b(c16);
                int a16 = a(c16);
                this.G.setStrokeWidth(b16);
                this.G.setARGB(a16, this.f338553e, this.f338554f, this.f338555h);
                canvas.drawOval(this.F, this.G);
            }
        }
        this.H += 50;
        this.K.removeCallbacks(this.L);
        this.K.postDelayed(this.L, 80L);
    }

    public void setColor(int i3, boolean z16) {
        if (i3 == this.f338556i) {
            return;
        }
        this.f338556i = i3;
        this.f338552d = (i3 >> 24) & 255;
        this.f338553e = (i3 >> 16) & 255;
        this.f338554f = (i3 >> 8) & 255;
        this.f338555h = i3 & 255;
        if (z16) {
            setProgress(0);
        }
    }

    public void setDuration(int i3, boolean z16) {
        this.f338557m = i3;
        if (z16) {
            setProgress(0);
        }
    }

    public void setInnerSize(int i3, int i16, boolean z16) {
        this.C = i3;
        this.D = i16;
        if (z16) {
            setProgress(0);
        }
    }

    public void setProgress(int i3) {
        this.H = i3;
    }

    public WaveAnimationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WaveAnimationView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f338552d = 0;
        this.f338553e = 0;
        this.f338554f = 0;
        this.f338555h = 0;
        this.f338556i = SupportMenu.CATEGORY_MASK;
        this.f338557m = 1000;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.H = 0;
        this.I = false;
        this.J = false;
        this.K = new Handler(Looper.getMainLooper());
        this.L = new Runnable() { // from class: com.tencent.now.od.ui.common.widget.a
            @Override // java.lang.Runnable
            public final void run() {
                WaveAnimationView.this.invalidate();
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, tn3.a.f436681c0);
        int color = obtainStyledAttributes.getColor(tn3.a.f436731h0, SupportMenu.CATEGORY_MASK);
        this.f338556i = color;
        this.f338552d = (color >> 24) & 255;
        this.f338553e = (color >> 16) & 255;
        this.f338554f = (color >> 8) & 255;
        this.f338555h = color & 255;
        this.f338557m = obtainStyledAttributes.getInt(tn3.a.f436701e0, 1000);
        this.C = obtainStyledAttributes.getDimensionPixelSize(tn3.a.f436721g0, 0);
        this.D = obtainStyledAttributes.getDimensionPixelSize(tn3.a.f436711f0, 0);
        this.E = obtainStyledAttributes.getInt(tn3.a.f436691d0, 3);
        obtainStyledAttributes.recycle();
        this.F = new RectF();
        Paint paint = new Paint();
        this.G = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.G.setAntiAlias(true);
    }
}
