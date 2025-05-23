package com.tencent.richframework.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.richframework.bubble.R$styleable;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RFWTriangleView extends View {
    private int mDirection;
    private int mHeight;
    private Paint mPaint;
    private Path mPath;
    private int mWidth;

    public RFWTriangleView(Context context) {
        this(context, null);
    }

    private void init() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPath = new Path();
        this.mDirection = 0;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i3 = this.mDirection;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        this.mPath.moveTo(0.0f, this.mHeight / 2);
                        this.mPath.lineTo(this.mWidth, this.mHeight);
                        this.mPath.lineTo(this.mWidth, 0.0f);
                    }
                } else {
                    this.mPath.moveTo(0.0f, 0.0f);
                    this.mPath.lineTo(0.0f, this.mHeight);
                    this.mPath.lineTo(this.mWidth, this.mHeight / 2);
                }
            } else {
                this.mPath.moveTo(0.0f, 0.0f);
                this.mPath.lineTo(this.mWidth / 2, this.mHeight);
                this.mPath.lineTo(this.mWidth, 0.0f);
            }
        } else {
            this.mPath.moveTo(0.0f, this.mHeight);
            this.mPath.lineTo(this.mWidth, this.mHeight);
            this.mPath.lineTo(this.mWidth / 2, 0.0f);
        }
        this.mPath.close();
        canvas.drawPath(this.mPath, this.mPaint);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        this.mWidth = View.MeasureSpec.getSize(i3);
        this.mHeight = View.MeasureSpec.getSize(i16);
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        if (this.mWidth == 0 || mode != 1073741824) {
            this.mWidth = DisplayUtil.dip2px(getContext(), 10.0f);
        }
        if (this.mHeight == 0 || mode2 != 1073741824) {
            this.mHeight = DisplayUtil.dip2px(getContext(), 6.0f);
        }
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    public void setArrowColor(int i3) {
        this.mPaint.setColor(i3);
        invalidate();
    }

    public RFWTriangleView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RFWTriangleView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        init();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.RFWTriangleView, 0, 0);
        int color = obtainStyledAttributes.getColor(R$styleable.RFWTriangleView_trv_color, -16777216);
        this.mDirection = obtainStyledAttributes.getInt(R$styleable.RFWTriangleView_trv_direction, this.mDirection);
        obtainStyledAttributes.recycle();
        this.mPaint.setColor(color);
    }
}
