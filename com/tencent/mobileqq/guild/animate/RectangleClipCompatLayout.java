package com.tencent.mobileqq.guild.animate;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* compiled from: P */
/* loaded from: classes12.dex */
public class RectangleClipCompatLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private RectF f214273d;

    /* renamed from: e, reason: collision with root package name */
    private float f214274e;

    /* renamed from: f, reason: collision with root package name */
    private final Path f214275f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f214276h;

    public RectangleClipCompatLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.f214276h) {
            if (!this.f214275f.isEmpty()) {
                canvas.save();
                canvas.clipPath(this.f214275f);
                super.dispatchDraw(canvas);
                canvas.restore();
                return;
            }
            super.dispatchDraw(canvas);
            return;
        }
        super.dispatchDraw(canvas);
    }

    public void setClipRect(RectF rectF, float f16) {
        if (rectF.width() >= getWidth() && rectF.height() >= getHeight()) {
            this.f214276h = false;
        } else {
            this.f214276h = true;
            this.f214273d.set(rectF);
            this.f214274e = f16;
            this.f214275f.reset();
            Path path = this.f214275f;
            RectF rectF2 = this.f214273d;
            float f17 = this.f214274e;
            path.addRoundRect(rectF2, f17, f17, Path.Direction.CW);
            this.f214275f.close();
        }
        invalidate();
    }

    public RectangleClipCompatLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RectangleClipCompatLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f214273d = new RectF();
        this.f214275f = new Path();
    }
}
