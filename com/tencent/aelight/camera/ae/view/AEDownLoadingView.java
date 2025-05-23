package com.tencent.aelight.camera.ae.view;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.avcore.jni.codec.HWColorFormat;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEDownLoadingView extends View {
    private static String P = "AEDownLoadingView";
    private static float Q;
    protected int C;
    protected int D;
    protected RectF E;
    protected RectF F;
    protected long G;
    protected long H;
    protected float I;
    protected float J;
    protected float K;
    boolean L;
    boolean M;
    private boolean N;

    /* renamed from: d, reason: collision with root package name */
    protected Paint f65845d;

    /* renamed from: e, reason: collision with root package name */
    protected Paint f65846e;

    /* renamed from: f, reason: collision with root package name */
    protected Paint f65847f;

    /* renamed from: h, reason: collision with root package name */
    protected Path f65848h;

    /* renamed from: i, reason: collision with root package name */
    private int f65849i;

    /* renamed from: m, reason: collision with root package name */
    private int f65850m;

    public AEDownLoadingView(Context context) {
        super(context);
        float f16 = this.C - R.attr.radius;
        int i3 = this.D;
        this.F = new RectF(f16, i3 - R.attr.radius, r0 + R.attr.radius, i3 + R.attr.radius);
        this.G = 100L;
        this.H = 0L;
        this.I = a(2.0f, getContext());
        this.J = a(17.5f, getContext());
        this.K = a(2.5f, getContext());
        this.L = false;
        this.M = true;
        this.N = false;
        c();
    }

    private static int a(float f16, Context context) {
        if (Q == 0.0f) {
            Q = context.getResources().getDisplayMetrics().density;
        }
        return (int) (f16 * Q);
    }

    public void b(boolean z16) {
        this.L = z16;
    }

    protected void c() {
        Paint paint = new Paint(1);
        this.f65845d = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f65845d.setColor(HWColorFormat.COLOR_FormatVendorStartUnused);
        if (this.N) {
            Paint paint2 = new Paint(1);
            this.f65847f = paint2;
            paint2.setStyle(Paint.Style.FILL);
            this.f65847f.setColor(-1);
            this.f65847f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        Paint paint3 = new Paint(1);
        this.f65846e = paint3;
        paint3.setStyle(Paint.Style.FILL);
        this.f65846e.setColor(0);
        this.f65846e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        setLayerType(1, null);
        this.f65848h = new Path();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.L) {
            RectF rectF = this.E;
            float f16 = this.I;
            canvas.drawRoundRect(rectF, f16, f16, this.f65845d);
            return;
        }
        RectF rectF2 = this.E;
        float f17 = this.I;
        canvas.drawRoundRect(rectF2, f17, f17, this.f65845d);
        long j3 = this.H;
        if (j3 >= 0) {
            long j16 = this.G;
            if (j3 <= j16) {
                float f18 = (((float) j3) * 360.0f) / ((float) j16);
                if (this.M) {
                    canvas.drawCircle(this.C, this.D, this.J, this.f65846e);
                    canvas.drawCircle(this.C, this.D, this.J - this.K, this.f65845d);
                    this.f65848h.reset();
                    this.f65848h.moveTo(this.C, this.D);
                    this.f65848h.arcTo(this.F, 270.0f, f18);
                    canvas.drawPath(this.f65848h, this.f65846e);
                    return;
                }
                if (this.N) {
                    try {
                        Paint paint = this.f65847f;
                        if (paint != null) {
                            canvas.drawArc(this.F, 270.0f, 360.0f, false, paint);
                        }
                    } catch (Exception e16) {
                        ms.a.c(P, "draw mDefaultArcPaint error " + e16.getMessage());
                        e16.printStackTrace();
                    }
                }
                canvas.drawArc(this.F, 270.0f, f18, false, this.f65846e);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        this.f65849i = i3;
        this.f65850m = i16;
        this.C = i3 / 2;
        this.D = i16 / 2;
        this.E = new RectF(0.0f, 0.0f, this.f65849i, this.f65850m);
        float f16 = this.J - this.K;
        int i19 = this.C;
        int i26 = this.D;
        this.F = new RectF(i19 - f16, i26 - f16, i19 + f16, i26 + f16);
    }

    public void setBgColor(int i3) {
        this.f65845d.setColor(i3);
    }

    public void setBgCorner(float f16) {
        this.I = f16;
    }

    public void setProgress(long j3) {
        this.H = j3;
        if (j3 == this.G) {
            setVisibility(4);
        }
        invalidate();
    }

    public void setProgressColor(int i3) {
        this.f65846e.setColor(i3);
    }

    public void setProgressSizeAndMode(float f16, float f17, boolean z16) {
        this.J = f16;
        this.K = f17;
        float f18 = f16 - f17;
        int i3 = this.C;
        int i16 = this.D;
        this.F = new RectF(i3 - f18, i16 - f18, i3 + f18, i16 + f18);
        this.M = z16;
        if (z16) {
            this.f65846e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            this.f65846e.setStyle(Paint.Style.FILL);
            return;
        }
        this.f65846e.setStrokeWidth(f17);
        this.f65846e.setXfermode(null);
        this.f65846e.setStyle(Paint.Style.STROKE);
        this.f65846e.setStrokeCap(Paint.Cap.ROUND);
        if (this.N) {
            this.f65847f.setStrokeWidth(f17);
            this.f65847f.setXfermode(null);
            this.f65847f.setStyle(Paint.Style.STROKE);
            this.f65847f.setStrokeCap(Paint.Cap.ROUND);
        }
    }

    public void setMax(int i3) {
        this.G = i3;
    }

    public AEDownLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        float f16 = this.C - R.attr.radius;
        int i3 = this.D;
        this.F = new RectF(f16, i3 - R.attr.radius, r6 + R.attr.radius, i3 + R.attr.radius);
        this.G = 100L;
        this.H = 0L;
        this.I = a(2.0f, getContext());
        this.J = a(17.5f, getContext());
        this.K = a(2.5f, getContext());
        this.L = false;
        this.M = true;
        this.N = false;
        c();
    }

    public AEDownLoadingView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        float f16 = this.C - R.attr.radius;
        int i16 = this.D;
        this.F = new RectF(f16, i16 - R.attr.radius, r5 + R.attr.radius, i16 + R.attr.radius);
        this.G = 100L;
        this.H = 0L;
        this.I = a(2.0f, getContext());
        this.J = a(17.5f, getContext());
        this.K = a(2.5f, getContext());
        this.L = false;
        this.M = true;
        this.N = false;
        c();
    }
}
