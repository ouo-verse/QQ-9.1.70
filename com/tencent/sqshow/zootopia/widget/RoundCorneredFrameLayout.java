package com.tencent.sqshow.zootopia.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.mobileqq.util.Utils;
import m74.a;

/* compiled from: P */
/* loaded from: classes34.dex */
public class RoundCorneredFrameLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    public int f373394d;

    public RoundCorneredFrameLayout(Context context) {
        super(context);
        this.f373394d = 6;
        setLayerType(1, null);
    }

    int a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f416409v);
        int i3 = obtainStyledAttributes.getInt(a.f416410w, 6);
        obtainStyledAttributes.recycle();
        return i3;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        Path path = new Path();
        path.moveTo(0.0f, this.f373394d);
        int i3 = this.f373394d;
        path.arcTo(new RectF(0.0f, 0.0f, i3 * 2, i3 * 2), -180.0f, 90.0f);
        path.lineTo(width - this.f373394d, 0.0f);
        int i16 = this.f373394d;
        float f16 = width;
        path.arcTo(new RectF(width - (i16 * 2), 0.0f, f16, i16 * 2), -90.0f, 90.0f);
        path.lineTo(f16, height - this.f373394d);
        int i17 = this.f373394d;
        float f17 = height;
        path.arcTo(new RectF(width - (i17 * 2), height - (i17 * 2), f16, f17), 0.0f, 90.0f);
        path.lineTo(this.f373394d, f17);
        int i18 = this.f373394d;
        path.arcTo(new RectF(0.0f, height - (i18 * 2), i18 * 2, f17), 90.0f, 90.0f);
        path.lineTo(0.0f, this.f373394d);
        path.close();
        canvas.clipPath(path);
        super.dispatchDraw(canvas);
    }

    public RoundCorneredFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f373394d = 6;
        this.f373394d = Utils.n(a(context, attributeSet), context.getResources());
        setLayerType(1, null);
    }
}
