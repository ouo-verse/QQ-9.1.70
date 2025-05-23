package com.tencent.mobileqq.qqvideoedit.editor.view;

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
/* loaded from: classes17.dex */
public class VideoDownLoadingView extends View {
    private static float M;
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

    /* renamed from: d, reason: collision with root package name */
    protected Paint f275855d;

    /* renamed from: e, reason: collision with root package name */
    protected Paint f275856e;

    /* renamed from: f, reason: collision with root package name */
    protected Path f275857f;

    /* renamed from: h, reason: collision with root package name */
    private int f275858h;

    /* renamed from: i, reason: collision with root package name */
    private int f275859i;

    /* renamed from: m, reason: collision with root package name */
    protected int f275860m;

    public VideoDownLoadingView(Context context) {
        super(context);
        float f16 = this.f275860m - R.attr.radius;
        int i3 = this.C;
        this.E = new RectF(f16, i3 - R.attr.radius, r0 + R.attr.radius, i3 + R.attr.radius);
        this.F = 100L;
        this.G = 0L;
        this.H = a(2.0f, getContext());
        this.I = a(17.5f, getContext());
        this.J = a(2.5f, getContext());
        this.K = false;
        this.L = true;
        c();
    }

    private static int a(float f16, Context context) {
        if (M == 0.0f) {
            M = context.getResources().getDisplayMetrics().density;
        }
        return (int) (f16 * M);
    }

    public void b(boolean z16) {
        this.K = z16;
    }

    protected void c() {
        Paint paint = new Paint(1);
        this.f275855d = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f275855d.setColor(HWColorFormat.COLOR_FormatVendorStartUnused);
        Paint paint2 = new Paint(1);
        this.f275856e = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f275856e.setColor(0);
        this.f275856e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        setLayerType(1, null);
        this.f275857f = new Path();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.K) {
            RectF rectF = this.D;
            float f16 = this.H;
            canvas.drawRoundRect(rectF, f16, f16, this.f275855d);
            return;
        }
        RectF rectF2 = this.D;
        float f17 = this.H;
        canvas.drawRoundRect(rectF2, f17, f17, this.f275855d);
        long j3 = this.G;
        if (j3 >= 0) {
            long j16 = this.F;
            if (j3 <= j16) {
                float f18 = (((float) j3) * 360.0f) / ((float) j16);
                if (this.L) {
                    canvas.drawCircle(this.f275860m, this.C, this.I, this.f275856e);
                    canvas.drawCircle(this.f275860m, this.C, this.I - this.J, this.f275855d);
                    this.f275857f.reset();
                    this.f275857f.moveTo(this.f275860m, this.C);
                    this.f275857f.arcTo(this.E, 270.0f, f18);
                    canvas.drawPath(this.f275857f, this.f275856e);
                    return;
                }
                canvas.drawArc(this.E, 270.0f, f18, false, this.f275856e);
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
        this.f275858h = i3;
        this.f275859i = i16;
        this.f275860m = i3 / 2;
        this.C = i16 / 2;
        this.D = new RectF(0.0f, 0.0f, this.f275858h, this.f275859i);
        float f16 = this.I - this.J;
        int i19 = this.f275860m;
        int i26 = this.C;
        this.E = new RectF(i19 - f16, i26 - f16, i19 + f16, i26 + f16);
    }

    public void setBgColor(int i3) {
        this.f275855d.setColor(i3);
    }

    public void setBgCorner(float f16) {
        this.H = f16;
    }

    public void setMax(int i3) {
        this.F = i3;
    }

    public void setProgress(long j3) {
        this.G = j3;
        if (j3 == this.F) {
            setVisibility(4);
        }
        invalidate();
    }

    public void setProgressColor(int i3) {
        this.f275856e.setColor(i3);
    }

    public void setProgressSizeAndMode(float f16, float f17, boolean z16) {
        this.I = f16;
        this.J = f17;
        float f18 = f16 - f17;
        int i3 = this.f275860m;
        int i16 = this.C;
        this.E = new RectF(i3 - f18, i16 - f18, i3 + f18, i16 + f18);
        this.L = z16;
        if (z16) {
            this.f275856e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            this.f275856e.setStyle(Paint.Style.FILL);
        } else {
            this.f275856e.setStrokeWidth(f17);
            this.f275856e.setXfermode(null);
            this.f275856e.setStyle(Paint.Style.STROKE);
            this.f275856e.setStrokeCap(Paint.Cap.ROUND);
        }
    }

    public VideoDownLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        float f16 = this.f275860m - R.attr.radius;
        int i3 = this.C;
        this.E = new RectF(f16, i3 - R.attr.radius, r6 + R.attr.radius, i3 + R.attr.radius);
        this.F = 100L;
        this.G = 0L;
        this.H = a(2.0f, getContext());
        this.I = a(17.5f, getContext());
        this.J = a(2.5f, getContext());
        this.K = false;
        this.L = true;
        c();
    }

    public VideoDownLoadingView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        float f16 = this.f275860m - R.attr.radius;
        int i16 = this.C;
        this.E = new RectF(f16, i16 - R.attr.radius, r5 + R.attr.radius, i16 + R.attr.radius);
        this.F = 100L;
        this.G = 0L;
        this.H = a(2.0f, getContext());
        this.I = a(17.5f, getContext());
        this.J = a(2.5f, getContext());
        this.K = false;
        this.L = true;
        c();
    }
}
