package com.tencent.mobileqq.richmedia.capture.view;

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
/* loaded from: classes18.dex */
public class CaptureCommonLoadingView extends View {
    private static float K;
    private int C;
    private RectF D;
    private RectF E;
    private int F;
    private int G;
    private float H;
    private float I;
    private float J;

    /* renamed from: d, reason: collision with root package name */
    private Paint f281440d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f281441e;

    /* renamed from: f, reason: collision with root package name */
    private Path f281442f;

    /* renamed from: h, reason: collision with root package name */
    private int f281443h;

    /* renamed from: i, reason: collision with root package name */
    private int f281444i;

    /* renamed from: m, reason: collision with root package name */
    private int f281445m;

    public CaptureCommonLoadingView(Context context) {
        super(context);
        float f16 = this.f281445m - R.attr.radius;
        int i3 = this.C;
        this.E = new RectF(f16, i3 - R.attr.radius, r0 + R.attr.radius, i3 + R.attr.radius);
        this.F = 100;
        this.G = 0;
        this.H = a(2.0f, getContext());
        this.I = a(17.5f, getContext());
        this.J = a(2.5f, getContext());
        b();
    }

    public static int a(float f16, Context context) {
        if (K == 0.0f) {
            K = context.getResources().getDisplayMetrics().density;
        }
        return (int) (f16 * K);
    }

    private void b() {
        Paint paint = new Paint(1);
        this.f281440d = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f281440d.setColor(HWColorFormat.COLOR_FormatVendorStartUnused);
        this.f281441e = new Paint(1);
        this.f281440d.setStyle(Paint.Style.FILL);
        this.f281441e.setColor(0);
        this.f281441e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        setLayerType(1, null);
        this.f281442f = new Path();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.D;
        float f16 = this.H;
        canvas.drawRoundRect(rectF, f16, f16, this.f281440d);
        canvas.drawCircle(this.f281445m, this.C, this.I, this.f281441e);
        canvas.drawCircle(this.f281445m, this.C, this.I - this.J, this.f281440d);
        this.f281442f.moveTo(this.f281445m, this.C);
        this.f281442f.arcTo(this.E, 270.0f, (this.G * 360.0f) / this.F);
        canvas.drawPath(this.f281442f, this.f281441e);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        this.f281443h = i3;
        this.f281444i = i16;
        this.f281445m = i3 / 2;
        this.C = i16 / 2;
        this.D = new RectF(0.0f, 0.0f, this.f281443h, this.f281444i);
        float f16 = this.I - this.J;
        int i19 = this.f281445m;
        int i26 = this.C;
        this.E = new RectF(i19 - f16, i26 - f16, i19 + f16, i26 + f16);
    }

    public void setCorner(int i3) {
        this.H = i3;
    }

    public void setMax(int i3) {
        this.F = i3;
    }

    public void setProgress(int i3) {
        this.G = i3;
        invalidate();
        if (this.G == this.F) {
            setVisibility(4);
        }
    }

    public CaptureCommonLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        float f16 = this.f281445m - R.attr.radius;
        int i3 = this.C;
        this.E = new RectF(f16, i3 - R.attr.radius, r6 + R.attr.radius, i3 + R.attr.radius);
        this.F = 100;
        this.G = 0;
        this.H = a(2.0f, getContext());
        this.I = a(17.5f, getContext());
        this.J = a(2.5f, getContext());
        b();
    }

    public CaptureCommonLoadingView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        float f16 = this.f281445m - R.attr.radius;
        int i16 = this.C;
        this.E = new RectF(f16, i16 - R.attr.radius, r5 + R.attr.radius, i16 + R.attr.radius);
        this.F = 100;
        this.G = 0;
        this.H = a(2.0f, getContext());
        this.I = a(17.5f, getContext());
        this.J = a(2.5f, getContext());
        b();
    }
}
