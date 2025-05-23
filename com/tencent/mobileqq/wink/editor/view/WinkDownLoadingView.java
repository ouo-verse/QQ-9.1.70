package com.tencent.mobileqq.wink.editor.view;

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
/* loaded from: classes21.dex */
public class WinkDownLoadingView extends View {
    private static float P;
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
    boolean N;

    /* renamed from: d, reason: collision with root package name */
    protected Paint f322690d;

    /* renamed from: e, reason: collision with root package name */
    protected Paint f322691e;

    /* renamed from: f, reason: collision with root package name */
    protected Paint f322692f;

    /* renamed from: h, reason: collision with root package name */
    protected Path f322693h;

    /* renamed from: i, reason: collision with root package name */
    private int f322694i;

    /* renamed from: m, reason: collision with root package name */
    private int f322695m;

    public WinkDownLoadingView(Context context) {
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
        this.N = true;
        c();
    }

    private static int a(float f16, Context context) {
        if (P == 0.0f) {
            P = context.getResources().getDisplayMetrics().density;
        }
        return (int) (f16 * P);
    }

    public void b(boolean z16) {
        this.L = z16;
    }

    protected void c() {
        Paint paint = new Paint(1);
        this.f322690d = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f322690d.setColor(HWColorFormat.COLOR_FormatVendorStartUnused);
        Paint paint2 = new Paint(1);
        this.f322691e = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f322691e.setColor(0);
        this.f322691e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        Paint paint3 = new Paint(1);
        this.f322692f = paint3;
        paint3.setStyle(Paint.Style.STROKE);
        this.f322692f.setColor(0);
        this.f322692f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        setLayerType(1, null);
        this.f322693h = new Path();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.L) {
            RectF rectF = this.E;
            float f16 = this.I;
            canvas.drawRoundRect(rectF, f16, f16, this.f322690d);
            return;
        }
        RectF rectF2 = this.E;
        float f17 = this.I;
        canvas.drawRoundRect(rectF2, f17, f17, this.f322690d);
        if (!this.M) {
            canvas.drawArc(this.F, 360.0f, 360.0f, false, this.f322692f);
        }
        long j3 = this.H;
        if (j3 >= 0) {
            long j16 = this.G;
            if (j3 <= j16) {
                float f18 = (((float) j3) * 360.0f) / ((float) j16);
                if (this.M) {
                    canvas.drawCircle(this.C, this.D, this.J, this.f322691e);
                    canvas.drawCircle(this.C, this.D, this.J - this.K, this.f322690d);
                    this.f322693h.reset();
                    this.f322693h.moveTo(this.C, this.D);
                    this.f322693h.arcTo(this.F, 270.0f, f18);
                    canvas.drawPath(this.f322693h, this.f322691e);
                    return;
                }
                canvas.drawArc(this.F, 270.0f, f18, false, this.f322691e);
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
        this.f322694i = i3;
        this.f322695m = i16;
        this.C = i3 / 2;
        this.D = i16 / 2;
        this.E = new RectF(0.0f, 0.0f, this.f322694i, this.f322695m);
        float f16 = this.J - this.K;
        int i19 = this.C;
        int i26 = this.D;
        this.F = new RectF(i19 - f16, i26 - f16, i19 + f16, i26 + f16);
    }

    public void setBgColor(int i3) {
        this.f322690d.setColor(i3);
    }

    public void setBgCorner(float f16) {
        this.I = f16;
    }

    public void setMax(int i3) {
        this.G = i3;
    }

    public void setProgress(long j3) {
        this.H = j3;
        if (j3 == this.G) {
            setVisibility(4);
        }
        invalidate();
    }

    public void setProgressColor(int i3) {
        this.f322691e.setColor(i3);
    }

    public void setProgressSizeAndMode(float f16, float f17, boolean z16) {
        Paint.Cap cap;
        this.J = f16;
        this.K = f17;
        float f18 = f16 - f17;
        int i3 = this.C;
        int i16 = this.D;
        this.F = new RectF(i3 - f18, i16 - f18, i3 + f18, i16 + f18);
        this.M = z16;
        if (z16) {
            this.f322691e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            this.f322691e.setStyle(Paint.Style.FILL);
            return;
        }
        this.f322691e.setStrokeWidth(f17);
        this.f322691e.setXfermode(null);
        this.f322691e.setStyle(Paint.Style.STROKE);
        Paint paint = this.f322691e;
        if (this.N) {
            cap = Paint.Cap.ROUND;
        } else {
            cap = Paint.Cap.BUTT;
        }
        paint.setStrokeCap(cap);
        this.f322692f.setStrokeWidth(f17);
        this.f322692f.setXfermode(null);
        this.f322692f.setStyle(Paint.Style.STROKE);
    }

    public void setRingColor(int i3) {
        this.f322692f.setColor(i3);
    }

    public WinkDownLoadingView(Context context, AttributeSet attributeSet) {
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
        this.N = true;
        c();
    }

    public WinkDownLoadingView(Context context, AttributeSet attributeSet, int i3) {
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
        this.N = true;
        c();
    }
}
