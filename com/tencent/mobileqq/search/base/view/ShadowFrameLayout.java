package com.tencent.mobileqq.search.base.view;

import android.annotation.TargetApi;
import android.content.Context;
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
import com.tencent.mobileqq.guild.util.s;
import gp2.a;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ShadowFrameLayout extends FrameLayout {
    private static final int F = Color.parseColor("#EEEEEE");
    protected float C;
    private float D;
    private float E;

    /* renamed from: d, reason: collision with root package name */
    protected final RectF f282810d;

    /* renamed from: e, reason: collision with root package name */
    protected float f282811e;

    /* renamed from: f, reason: collision with root package name */
    protected Paint f282812f;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f282813h;

    /* renamed from: i, reason: collision with root package name */
    protected int f282814i;

    /* renamed from: m, reason: collision with root package name */
    protected int f282815m;

    public ShadowFrameLayout(Context context) {
        this(context, null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f402909o6);
        int color = obtainStyledAttributes.getColor(a.f402949s6, F);
        this.f282814i = color;
        this.f282815m = obtainStyledAttributes.getColor(a.f402939r6, color);
        this.C = obtainStyledAttributes.getDimension(a.f402978v6, 0.0f);
        this.D = obtainStyledAttributes.getDimension(a.f402959t6, 0.0f);
        this.E = obtainStyledAttributes.getDimension(a.f402969u6, 0.0f);
        this.f282811e = obtainStyledAttributes.getDimension(a.f402919p6, 0.0f);
        this.f282813h = obtainStyledAttributes.getBoolean(a.f402929q6, true);
        obtainStyledAttributes.recycle();
    }

    private void b() {
        Paint paint = new Paint();
        this.f282812f = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f282812f.setAntiAlias(true);
        this.f282812f.setColor(this.f282815m);
        this.f282812f.setShadowLayer(this.C, this.D, this.E, this.f282814i);
    }

    @Override // android.view.ViewGroup, android.view.View
    @TargetApi(21)
    protected void dispatchDraw(Canvas canvas) {
        if (this.f282813h) {
            if (Build.VERSION.SDK_INT < 28 && getLayerType() != 1) {
                setLayerType(1, null);
            }
            if (getChildAt(0) != null) {
                this.f282810d.left = r0.getLeft();
                this.f282810d.top = r0.getTop();
                this.f282810d.right = r0.getRight();
                this.f282810d.bottom = r0.getBottom();
            } else {
                this.f282810d.left = getPaddingLeft();
                this.f282810d.top = getPaddingTop();
                this.f282810d.right = getWidth() - getPaddingRight();
                this.f282810d.bottom = getHeight() - getPaddingBottom();
            }
            RectF rectF = this.f282810d;
            float f16 = this.f282811e;
            canvas.drawRoundRect(rectF, f16, f16, this.f282812f);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        if (getChildCount() > 1) {
            s.e("ShadowFrameLayout", "\u5b50View\u4e0d\u80fd\u591a\u4e8e\u4e00\u4e2a", new IllegalStateException("\u5b50View\u4e0d\u80fd\u591a\u4e8e\u4e00\u4e2a"));
        }
    }

    public void setCornerRadius(int i3) {
        this.f282811e = i3;
        invalidate();
    }

    public void setFillColor(@ColorInt int i3, boolean z16) {
        this.f282815m = i3;
        this.f282813h = true;
        this.f282812f.setColor(i3);
        if (z16) {
            this.f282812f.setShadowLayer(this.C, this.D, this.E, this.f282814i);
        } else {
            this.f282812f.clearShadowLayer();
        }
        invalidate();
    }

    public void setShadowColor(@ColorInt int i3) {
        this.f282814i = i3;
        this.f282812f.setColor(i3);
        this.f282812f.setShadowLayer(this.C, this.D, this.E, this.f282814i);
        invalidate();
    }

    public void setShadowRadius(int i3) {
        float f16 = i3;
        this.C = f16;
        this.f282812f.setShadowLayer(f16, this.D, this.E, this.f282814i);
        invalidate();
    }

    public ShadowFrameLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShadowFrameLayout(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f282810d = new RectF();
        a(context, attributeSet);
        b();
    }
}
