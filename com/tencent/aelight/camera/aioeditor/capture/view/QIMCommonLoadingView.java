package com.tencent.aelight.camera.aioeditor.capture.view;

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
import com.tencent.aelight.camera.aioeditor.capture.view.c;
import com.tencent.avcore.jni.codec.HWColorFormat;

/* compiled from: P */
/* loaded from: classes32.dex */
public class QIMCommonLoadingView extends View implements c.a {
    private static float P;
    protected int C;
    protected RectF D;
    protected RectF E;
    protected long F;
    protected long G;
    protected float H;
    protected float I;
    protected float J;
    boolean K;
    boolean L;
    boolean M;
    c N;

    /* renamed from: d, reason: collision with root package name */
    protected Paint f67288d;

    /* renamed from: e, reason: collision with root package name */
    protected Paint f67289e;

    /* renamed from: f, reason: collision with root package name */
    protected Path f67290f;

    /* renamed from: h, reason: collision with root package name */
    private int f67291h;

    /* renamed from: i, reason: collision with root package name */
    private int f67292i;

    /* renamed from: m, reason: collision with root package name */
    protected int f67293m;

    public QIMCommonLoadingView(Context context) {
        super(context);
        float f16 = this.f67293m - R.attr.radius;
        int i3 = this.C;
        this.E = new RectF(f16, i3 - R.attr.radius, r0 + R.attr.radius, i3 + R.attr.radius);
        this.F = 100L;
        this.G = 0L;
        this.H = b(2.0f, getContext());
        this.I = b(17.5f, getContext());
        this.J = b(2.5f, getContext());
        this.K = false;
        this.L = true;
        this.M = false;
        c();
    }

    public static int b(float f16, Context context) {
        if (P == 0.0f) {
            P = context.getResources().getDisplayMetrics().density;
        }
        return (int) (f16 * P);
    }

    public void a(c cVar) {
        c cVar2 = this.N;
        if (cVar2 != null) {
            cVar2.f(this);
        }
        this.N = cVar;
        if (cVar != null) {
            cVar.a(this);
            setProgress(Math.round(cVar.d() * ((float) this.F)));
        }
    }

    protected void c() {
        Paint paint = new Paint(1);
        this.f67288d = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f67288d.setColor(HWColorFormat.COLOR_FormatVendorStartUnused);
        Paint paint2 = new Paint(1);
        this.f67289e = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f67289e.setColor(0);
        this.f67289e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        setLayerType(1, null);
        this.f67290f = new Path();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        c cVar;
        super.onDraw(canvas);
        if (this.K) {
            RectF rectF = this.D;
            float f16 = this.H;
            canvas.drawRoundRect(rectF, f16, f16, this.f67288d);
            return;
        }
        long j3 = this.G;
        if (j3 == 0 || j3 == this.F) {
            return;
        }
        RectF rectF2 = this.D;
        float f17 = this.H;
        canvas.drawRoundRect(rectF2, f17, f17, this.f67288d);
        float f18 = (((float) this.G) * 360.0f) / ((float) this.F);
        if (this.L) {
            canvas.drawCircle(this.f67293m, this.C, this.I, this.f67289e);
            canvas.drawCircle(this.f67293m, this.C, this.I - this.J, this.f67288d);
            this.f67290f.reset();
            this.f67290f.moveTo(this.f67293m, this.C);
            this.f67290f.arcTo(this.E, 270.0f, f18);
            canvas.drawPath(this.f67290f, this.f67289e);
        } else {
            canvas.drawArc(this.E, 270.0f, f18, false, this.f67289e);
        }
        if (this.M) {
            if (this.G != this.F && (cVar = this.N) != null) {
                setProgress(Math.round(cVar.d() * ((float) this.F)));
            } else {
                this.M = false;
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
        this.f67291h = i3;
        this.f67292i = i16;
        this.f67293m = i3 / 2;
        this.C = i16 / 2;
        this.D = new RectF(0.0f, 0.0f, this.f67291h, this.f67292i);
        float f16 = this.I - this.J;
        int i19 = this.f67293m;
        int i26 = this.C;
        this.E = new RectF(i19 - f16, i26 - f16, i19 + f16, i26 + f16);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.c.a
    public void onUpdate() {
        if (this.N != null) {
            setProgress(Math.round(r0.d() * ((float) this.F)));
        }
    }

    public void setBgColor(int i3) {
        this.f67288d.setColor(i3);
    }

    public void setBgCorner(float f16) {
        this.H = f16;
    }

    public void setProgressColor(int i3) {
        this.f67289e.setColor(i3);
    }

    public void setProgressSizeAndMode(float f16, float f17, boolean z16) {
        this.I = f16;
        this.J = f17;
        float f18 = f16 - f17;
        int i3 = this.f67293m;
        int i16 = this.C;
        this.E = new RectF(i3 - f18, i16 - f18, i3 + f18, i16 + f18);
        this.L = z16;
        if (z16) {
            this.f67289e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            this.f67289e.setStyle(Paint.Style.FILL);
        } else {
            this.f67289e.setStrokeWidth(f17);
            this.f67289e.setXfermode(null);
            this.f67289e.setStyle(Paint.Style.STROKE);
            this.f67289e.setStrokeCap(Paint.Cap.ROUND);
        }
    }

    public void setMax(int i3) {
        this.F = i3;
    }

    public void setProgress(long j3) {
        if (j3 == 0) {
            this.G = j3;
        }
        this.G = j3;
        if (j3 != this.F && this.N != null) {
            this.M = true;
        }
        invalidate();
    }

    public QIMCommonLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        float f16 = this.f67293m - R.attr.radius;
        int i3 = this.C;
        this.E = new RectF(f16, i3 - R.attr.radius, r6 + R.attr.radius, i3 + R.attr.radius);
        this.F = 100L;
        this.G = 0L;
        this.H = b(2.0f, getContext());
        this.I = b(17.5f, getContext());
        this.J = b(2.5f, getContext());
        this.K = false;
        this.L = true;
        this.M = false;
        c();
    }

    public QIMCommonLoadingView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        float f16 = this.f67293m - R.attr.radius;
        int i16 = this.C;
        this.E = new RectF(f16, i16 - R.attr.radius, r5 + R.attr.radius, i16 + R.attr.radius);
        this.F = 100L;
        this.G = 0L;
        this.H = b(2.0f, getContext());
        this.I = b(17.5f, getContext());
        this.J = b(2.5f, getContext());
        this.K = false;
        this.L = true;
        this.M = false;
        c();
    }
}
