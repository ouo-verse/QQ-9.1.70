package com.tencent.biz.richframework.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import jj2.b;

/* compiled from: P */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes5.dex */
public class RFWSquareImageView extends ImageView {
    private int mCircleBgColor;
    private Paint mCircleBgPaint;
    protected final Path mClipPath;
    private int mFilterColor;
    private String mFilterText;
    private int mFilterTextSize;
    protected int mRoundRectRadius;
    private float mScale;
    private float mScaleOffset;
    protected final RectF mViewBounds;

    public RFWSquareImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mScale = 1.0f;
        this.mScaleOffset = 0.0f;
        this.mFilterColor = -1;
        this.mFilterTextSize = 20;
        this.mViewBounds = new RectF();
        this.mClipPath = new Path();
        this.mCircleBgPaint = new Paint();
        this.mCircleBgColor = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.V7);
        this.mScale = obtainStyledAttributes.getFloat(b.f409991a8, 1.0f);
        this.mScaleOffset = obtainStyledAttributes.getFloat(b.f410003b8, 0.0f);
        this.mFilterColor = obtainStyledAttributes.getColor(b.W7, -1);
        this.mFilterText = obtainStyledAttributes.getString(b.X7);
        this.mFilterTextSize = obtainStyledAttributes.getDimensionPixelSize(b.Y7, 40);
        this.mRoundRectRadius = obtainStyledAttributes.getDimensionPixelSize(b.Z7, 0);
        obtainStyledAttributes.recycle();
        setLayerType(1, null);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.mRoundRectRadius != 0) {
            if (this.mClipPath.isEmpty()) {
                Path path = this.mClipPath;
                RectF rectF = this.mViewBounds;
                int i3 = this.mRoundRectRadius;
                path.addRoundRect(rectF, i3, i3, Path.Direction.CW);
            }
            canvas.clipPath(this.mClipPath);
        }
        super.draw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        int i3 = this.mCircleBgColor;
        if (i3 != -1) {
            this.mCircleBgPaint.setColor(i3);
            this.mCircleBgPaint.setAntiAlias(false);
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2, this.mCircleBgPaint);
        }
        super.onDraw(canvas);
        if (this.mFilterColor != -1) {
            Paint paint = new Paint();
            paint.setColor(this.mFilterColor);
            RectF rectF = new RectF(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
            int i16 = this.mRoundRectRadius;
            canvas.drawRoundRect(rectF, i16, i16, paint);
        }
        if (!TextUtils.isEmpty(this.mFilterText)) {
            Paint paint2 = new Paint(1);
            paint2.setTextSize(this.mFilterTextSize);
            paint2.setColor(-1);
            paint2.setTextAlign(Paint.Align.CENTER);
            Paint.FontMetricsInt fontMetricsInt = paint2.getFontMetricsInt();
            canvas.drawText(this.mFilterText, getMeasuredWidth() / 2, ((getMeasuredHeight() - fontMetricsInt.ascent) - fontMetricsInt.descent) / 2, paint2);
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        this.mViewBounds.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i3);
        int measuredWidth = getMeasuredWidth();
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec((int) (((measuredWidth * 1.0f) / this.mScale) + ((int) this.mScaleOffset)), 1073741824));
    }

    public void setCircleBgColor(int i3) {
        this.mCircleBgColor = i3;
        invalidate();
    }

    public void setFilterColor(int i3) {
        this.mFilterColor = i3;
        invalidate();
    }

    public void setFilterText(String str) {
        this.mFilterText = str;
        requestLayout();
    }

    public void setFilterTextSize(int i3) {
        this.mFilterTextSize = i3;
        requestLayout();
    }

    public void setImageScale(float f16, float f17) {
        if (f16 > 0.0f) {
            this.mScale = f16;
        }
        this.mScaleOffset = f17;
        requestLayout();
    }

    public void setRoundRect(int i3) {
        if (i3 <= 0) {
            i3 = 0;
        }
        this.mRoundRectRadius = i3;
        invalidate();
    }

    public RFWSquareImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RFWSquareImageView(Context context) {
        this(context, null);
    }
}
