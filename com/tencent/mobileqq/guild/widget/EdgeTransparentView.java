package com.tencent.mobileqq.guild.widget;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* compiled from: P */
/* loaded from: classes14.dex */
public class EdgeTransparentView extends FrameLayout {
    public static int G = 1;
    public static int H = 1 << 1;
    public static int I = 1 << 2;
    public static int J = 1 << 3;
    private int C;
    private ArgbEvaluator D;
    private int[] E;
    private float[] F;

    /* renamed from: d, reason: collision with root package name */
    private Paint f235798d;

    /* renamed from: e, reason: collision with root package name */
    private int f235799e;

    /* renamed from: f, reason: collision with root package name */
    private float f235800f;

    /* renamed from: h, reason: collision with root package name */
    private float f235801h;

    /* renamed from: i, reason: collision with root package name */
    private float f235802i;

    /* renamed from: m, reason: collision with root package name */
    private int f235803m;

    public EdgeTransparentView(Context context) {
        this(context, null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        setLayerType(2, null);
        Paint paint = new Paint(1);
        this.f235798d = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f235798d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, up1.a.f439430b1);
        this.f235799e = obtainStyledAttributes.getInt(up1.a.f439444c1, 0);
        this.f235800f = obtainStyledAttributes.getDimension(up1.a.f439458d1, 40.0f);
        this.f235801h = obtainStyledAttributes.getFloat(up1.a.f439486f1, 0.0f);
        this.f235802i = obtainStyledAttributes.getFloat(up1.a.f439472e1, 1.0f);
        obtainStyledAttributes.recycle();
    }

    private void b() {
        this.f235798d.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.f235800f, new int[]{((Integer) this.D.evaluate(this.f235801h, Integer.valueOf(this.E[0]), Integer.valueOf(this.E[1]))).intValue(), ((Integer) this.D.evaluate(this.f235802i, Integer.valueOf(this.E[0]), Integer.valueOf(this.E[1]))).intValue()}, this.F, Shader.TileMode.CLAMP));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j3) {
        if (this.f235799e != 0 && this.f235800f != 0.0f) {
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
            boolean drawChild = super.drawChild(canvas, view, j3);
            if ((this.f235799e & G) != 0) {
                canvas.drawRect(0.0f, 0.0f, this.f235803m, this.f235800f, this.f235798d);
            }
            if ((this.f235799e & H) != 0) {
                int save = canvas.save();
                canvas.rotate(180.0f, this.f235803m / 2.0f, this.C / 2.0f);
                canvas.drawRect(0.0f, 0.0f, this.f235803m, this.f235800f, this.f235798d);
                canvas.restoreToCount(save);
            }
            float f16 = (this.C - this.f235803m) / 2.0f;
            if ((this.f235799e & I) != 0) {
                int save2 = canvas.save();
                canvas.rotate(270.0f, this.f235803m / 2.0f, this.C / 2.0f);
                canvas.translate(0.0f, f16);
                canvas.drawRect(0.0f - f16, 0.0f, this.f235803m + f16, this.f235800f, this.f235798d);
                canvas.restoreToCount(save2);
            }
            if ((this.f235799e & J) != 0) {
                int save3 = canvas.save();
                canvas.rotate(90.0f, this.f235803m / 2.0f, this.C / 2.0f);
                canvas.translate(0.0f, f16);
                canvas.drawRect(0.0f - f16, 0.0f, this.f235803m + f16, this.f235800f, this.f235798d);
                canvas.restoreToCount(save3);
            }
            canvas.restoreToCount(saveLayer);
            return drawChild;
        }
        return super.drawChild(canvas, view, j3);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        b();
        this.f235803m = getWidth();
        this.C = getHeight();
    }

    public void setEdgePosition(int i3) {
        this.f235799e = i3;
        invalidate();
    }

    public void setEdgeWidth(int i3) {
        this.f235800f = i3;
        b();
        invalidate();
    }

    public void setEndAlpha(double d16) {
        this.f235802i = (float) d16;
        invalidate();
    }

    public void setStartAlpha(double d16) {
        this.f235801h = (float) d16;
        invalidate();
    }

    public EdgeTransparentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EdgeTransparentView(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
        a(context, attributeSet);
    }

    public EdgeTransparentView(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        this.D = new ArgbEvaluator();
        this.E = new int[]{-1, 0};
        this.F = new float[]{0.0f, 1.0f};
        a(context, attributeSet);
    }
}
