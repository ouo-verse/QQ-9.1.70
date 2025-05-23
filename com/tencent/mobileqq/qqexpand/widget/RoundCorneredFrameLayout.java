package com.tencent.mobileqq.qqexpand.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.mobileqq.util.x;

/* compiled from: P */
/* loaded from: classes16.dex */
public class RoundCorneredFrameLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    public int f264186d;

    @TargetApi(11)
    public RoundCorneredFrameLayout(Context context) {
        super(context);
        this.f264186d = 6;
    }

    int a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, tg2.a.f436150d7);
        int i3 = obtainStyledAttributes.getInt(tg2.a.f436159e7, 6);
        obtainStyledAttributes.recycle();
        return i3;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        Path path = new Path();
        path.moveTo(0.0f, this.f264186d);
        int i3 = this.f264186d;
        path.arcTo(new RectF(0.0f, 0.0f, i3 * 2, i3 * 2), -180.0f, 90.0f);
        path.lineTo(width - this.f264186d, 0.0f);
        int i16 = this.f264186d;
        float f16 = width;
        path.arcTo(new RectF(width - (i16 * 2), 0.0f, f16, i16 * 2), -90.0f, 90.0f);
        path.lineTo(f16, height - this.f264186d);
        int i17 = this.f264186d;
        float f17 = height;
        path.arcTo(new RectF(width - (i17 * 2), height - (i17 * 2), f16, f17), 0.0f, 90.0f);
        path.lineTo(this.f264186d, f17);
        int i18 = this.f264186d;
        path.arcTo(new RectF(0.0f, height - (i18 * 2), i18 * 2, f17), 90.0f, 90.0f);
        path.lineTo(0.0f, this.f264186d);
        path.close();
        canvas.clipPath(path);
        super.dispatchDraw(canvas);
    }

    @TargetApi(11)
    public RoundCorneredFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f264186d = 6;
        this.f264186d = x.c(context, a(context, attributeSet));
    }
}
