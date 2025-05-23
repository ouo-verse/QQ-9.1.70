package com.tencent.mobileqq.now.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.R;

/* compiled from: P */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes9.dex */
public class RoundedRectImageView extends ImageView {

    /* renamed from: d, reason: collision with root package name */
    private float[] f254399d;

    /* renamed from: e, reason: collision with root package name */
    private Path f254400e;

    /* renamed from: f, reason: collision with root package name */
    private RectF f254401f;

    public RoundedRectImageView(Context context) {
        super(context);
        this.f254399d = new float[8];
        this.f254401f = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        a(context, null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes;
        this.f254400e = new Path();
        if (attributeSet != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoundedRectImageView)) != null) {
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundedRectImageView_top_left_radius, 0);
            int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundedRectImageView_bottom_left_radius, 0);
            int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundedRectImageView_top_right_radius, 0);
            int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundedRectImageView_bottom_right_radius, 0);
            float[] fArr = this.f254399d;
            float f16 = dimensionPixelSize;
            fArr[1] = f16;
            fArr[0] = f16;
            float f17 = dimensionPixelSize3;
            fArr[3] = f17;
            fArr[2] = f17;
            float f18 = dimensionPixelSize4;
            fArr[5] = f18;
            fArr[4] = f18;
            float f19 = dimensionPixelSize2;
            fArr[7] = f19;
            fArr[6] = f19;
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        this.f254401f.set(0.0f, 0.0f, getWidth(), getHeight());
        this.f254400e.addRoundRect(this.f254401f, this.f254399d, Path.Direction.CW);
        canvas.clipPath(this.f254400e);
        super.onDraw(canvas);
    }

    public void setBottomLeftRadius(int i3) {
        float[] fArr = this.f254399d;
        float f16 = i3;
        fArr[7] = f16;
        fArr[6] = f16;
    }

    public void setBottomRightRadius(int i3) {
        float[] fArr = this.f254399d;
        float f16 = i3;
        fArr[5] = f16;
        fArr[4] = f16;
    }

    public void setTopLeftRadius(int i3) {
        float[] fArr = this.f254399d;
        float f16 = i3;
        fArr[1] = f16;
        fArr[0] = f16;
    }

    public void setTopRightRadius(int i3) {
        float[] fArr = this.f254399d;
        float f16 = i3;
        fArr[3] = f16;
        fArr[2] = f16;
    }

    public RoundedRectImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f254399d = new float[8];
        this.f254401f = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        a(context, attributeSet);
    }

    public RoundedRectImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f254399d = new float[8];
        this.f254401f = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        a(context, attributeSet);
    }
}
