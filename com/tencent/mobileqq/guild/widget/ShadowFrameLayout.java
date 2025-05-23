package com.tencent.mobileqq.guild.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes14.dex */
public class ShadowFrameLayout extends FrameLayout {
    private static final int H = Color.parseColor("#EEEEEE");
    protected int C;
    protected ColorStateList D;
    protected float E;
    private float F;
    private float G;

    /* renamed from: d, reason: collision with root package name */
    protected final RectF f236153d;

    /* renamed from: e, reason: collision with root package name */
    protected float f236154e;

    /* renamed from: f, reason: collision with root package name */
    protected Paint f236155f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f236156h;

    /* renamed from: i, reason: collision with root package name */
    protected int f236157i;

    /* renamed from: m, reason: collision with root package name */
    protected ColorStateList f236158m;

    public ShadowFrameLayout(Context context) {
        this(context, null);
    }

    private void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, up1.a.f439610o9);
        this.f236158m = obtainStyledAttributes.getColorStateList(up1.a.f439649r9);
        this.D = obtainStyledAttributes.getColorStateList(up1.a.f439636q9);
        this.E = obtainStyledAttributes.getDimension(up1.a.f439688u9, 0.0f);
        this.F = obtainStyledAttributes.getDimension(up1.a.f439662s9, 0.0f);
        this.G = obtainStyledAttributes.getDimension(up1.a.f439675t9, 0.0f);
        this.f236154e = obtainStyledAttributes.getDimension(up1.a.f439623p9, 0.0f);
        obtainStyledAttributes.recycle();
    }

    private void d() {
        Paint paint = new Paint();
        this.f236155f = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f236155f.setAntiAlias(true);
        e();
    }

    private void e() {
        ColorStateList colorStateList = this.f236158m;
        if (colorStateList == null) {
            this.f236157i = H;
        } else {
            this.f236157i = colorStateList.getDefaultColor();
        }
        ColorStateList colorStateList2 = this.D;
        if (colorStateList2 == null) {
            this.D = this.f236158m;
            this.C = this.f236157i;
        } else {
            this.C = colorStateList2.getDefaultColor();
        }
        this.f236155f.setColor(this.C);
        if (this.f236156h) {
            this.f236155f.setShadowLayer(this.E, this.F, this.G, this.f236157i);
        } else {
            this.f236155f.clearShadowLayer();
        }
    }

    public ColorStateList a() {
        return this.D;
    }

    public ColorStateList b() {
        return this.f236158m;
    }

    @Override // android.view.ViewGroup, android.view.View
    @TargetApi(21)
    protected void dispatchDraw(Canvas canvas) {
        if (Build.VERSION.SDK_INT < 28 && getLayerType() != 1) {
            setLayerType(1, null);
        }
        if (getChildAt(0) != null) {
            this.f236153d.left = r0.getLeft();
            this.f236153d.top = r0.getTop();
            this.f236153d.right = r0.getRight();
            this.f236153d.bottom = r0.getBottom();
        } else {
            this.f236153d.left = getPaddingLeft();
            this.f236153d.top = getPaddingTop();
            this.f236153d.right = getWidth() - getPaddingRight();
            this.f236153d.bottom = getHeight() - getPaddingBottom();
        }
        RectF rectF = this.f236153d;
        float f16 = this.f236154e;
        canvas.drawRoundRect(rectF, f16, f16, this.f236155f);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        if (getChildCount() <= 1) {
        } else {
            throw new IllegalStateException("\u5b50View\u4e0d\u80fd\u591a\u4e8e\u4e00\u4e2a");
        }
    }

    public void setBorder(ColorStateList colorStateList, int i3) {
        this.D = colorStateList;
        this.f236155f.setStrokeWidth(i3);
        this.f236155f.setStyle(Paint.Style.STROKE);
        e();
        invalidate();
    }

    public void setCornerRadius(int i3) {
        this.f236154e = i3;
        invalidate();
    }

    public void setFillColor(ColorStateList colorStateList) {
        this.D = colorStateList;
        e();
        invalidate();
    }

    public void setShadowColor(ColorStateList colorStateList) {
        this.f236158m = colorStateList;
        e();
        invalidate();
    }

    public void setShadowRadius(int i3) {
        float f16 = i3;
        this.E = f16;
        this.f236155f.setShadowLayer(f16, this.F, this.G, this.f236157i);
        invalidate();
    }

    public ShadowFrameLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShadowFrameLayout(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f236153d = new RectF();
        this.f236156h = true;
        c(context, attributeSet);
        d();
    }

    public void setFillColor(ColorStateList colorStateList, boolean z16) {
        this.D = colorStateList;
        this.f236156h = z16;
        e();
        invalidate();
    }

    public void setShadowColor(@ColorInt int i3) {
        this.f236158m = ColorStateList.valueOf(i3);
        e();
        invalidate();
    }

    public void setBorder(int i3, int i16) {
        setBorder(ColorStateList.valueOf(i3), i16);
    }

    public void setFillColor(@ColorInt int i3, boolean z16) {
        setFillColor(ColorStateList.valueOf(i3), z16);
    }
}
