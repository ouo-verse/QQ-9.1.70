package com.tencent.biz.richframework.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RoundCorneredLinearLayout extends LinearLayout {
    private Path mPath;
    private float mRadius;
    private RectF mRectF;

    public RoundCorneredLinearLayout(Context context) {
        this(context, null);
    }

    private void init() {
        this.mPath = new Path();
        this.mRectF = new RectF();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        this.mPath.reset();
        this.mRectF.set(0.0f, 0.0f, getWidth(), getHeight());
        Path path = this.mPath;
        RectF rectF = this.mRectF;
        float f16 = this.mRadius;
        path.addRoundRect(rectF, f16, f16, Path.Direction.CW);
        canvas.clipPath(this.mPath);
        super.dispatchDraw(canvas);
    }

    public void setRadius(float f16) {
        this.mRadius = f16;
    }

    public RoundCorneredLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundCorneredLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        init();
    }
}
