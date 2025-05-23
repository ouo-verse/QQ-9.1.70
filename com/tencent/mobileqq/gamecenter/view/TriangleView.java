package com.tencent.mobileqq.gamecenter.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes12.dex */
public class TriangleView extends View {

    /* renamed from: d, reason: collision with root package name */
    private Paint f213492d;

    /* renamed from: e, reason: collision with root package name */
    private Path f213493e;

    /* renamed from: f, reason: collision with root package name */
    private float f213494f;

    public TriangleView(Context context) {
        super(context);
        this.f213492d = new Paint(1);
        this.f213493e = new Path();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.rotate(this.f213494f);
        canvas.drawPath(this.f213493e, this.f213492d);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        this.f213493e.reset();
        this.f213493e.moveTo(0.0f, 0.0f);
        this.f213493e.lineTo(i3, 0.0f);
        this.f213493e.lineTo(i3 / 2, i16);
        this.f213493e.close();
    }

    public void setAngle(float f16) {
        this.f213494f = f16;
    }

    public void setColor(int i3) {
        this.f213492d.setColor(i3);
    }

    public TriangleView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f213492d = new Paint(1);
        this.f213493e = new Path();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TriangleView, 0, 0);
        try {
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                if (index == R.styleable.TriangleView_draw_color) {
                    setColor(obtainStyledAttributes.getColor(index, -16777216));
                } else if (index == R.styleable.TriangleView_draw_angle) {
                    setAngle(obtainStyledAttributes.getFloat(index, 0.0f));
                }
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
