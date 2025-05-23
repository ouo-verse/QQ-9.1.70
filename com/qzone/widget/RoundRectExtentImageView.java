package com.qzone.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;

/* compiled from: P */
/* loaded from: classes37.dex */
public class RoundRectExtentImageView extends ExtendImageView {

    /* renamed from: d, reason: collision with root package name */
    private int f60659d;

    /* renamed from: e, reason: collision with root package name */
    private int f60660e;

    /* renamed from: f, reason: collision with root package name */
    private int f60661f;

    /* renamed from: h, reason: collision with root package name */
    private Path f60662h;

    public RoundRectExtentImageView(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.widget.ExtendImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f60662h == null) {
            return;
        }
        canvas.save();
        canvas.clipPath(this.f60662h);
        super.onDraw(canvas);
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.widget.ExtendImageView, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        int width = getWidth();
        int height = getHeight();
        if (width == this.f60661f && height == this.f60660e && this.f60662h != null) {
            return;
        }
        this.f60661f = width;
        this.f60660e = height;
        int min = Math.min(width, height);
        int i19 = this.f60659d;
        if (i19 * 2 > min) {
            i19 = min / 2;
        }
        Path path = new Path();
        this.f60662h = path;
        if (i19 == 0) {
            path.addRect(0.0f, 0.0f, this.f60661f, this.f60660e, Path.Direction.CCW);
        } else {
            float f16 = i19;
            path.addRoundRect(new RectF(0.0f, 0.0f, this.f60661f, this.f60660e), f16, f16, Path.Direction.CCW);
        }
    }

    public RoundRectExtentImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RoundRectExtentImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    public void setRadius(int i3) {
        if (i3 < 0) {
            i3 = 0;
        }
        if (this.f60659d == i3) {
            return;
        }
        this.f60659d = i3;
        requestLayout();
    }
}
