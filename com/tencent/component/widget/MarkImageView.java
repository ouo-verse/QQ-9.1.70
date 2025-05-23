package com.tencent.component.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.qzone.widget.h;

/* compiled from: P */
/* loaded from: classes32.dex */
public class MarkImageView extends ImageView implements h {
    private float mCornerRadius;
    private boolean mEnabledForgroundMaskColor;
    private int mForgroundMaskColor;
    private h.a mMarker;
    private Path mPath;
    private RectF mTmpRectF;

    public MarkImageView(Context context) {
        super(context);
        this.mTmpRectF = new RectF();
        init(null);
    }

    private void init(AttributeSet attributeSet) {
        this.mMarker = new h.a(this, attributeSet);
    }

    public boolean isMarkerVisible() {
        return this.mMarker.j();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        float f16 = this.mCornerRadius;
        if (f16 != 0.0f) {
            if (this.mPath == null) {
                this.mPath = new Path();
            }
            try {
                Path path = this.mPath;
                RectF rectF = this.mTmpRectF;
                rectF.set(0.0f, 0.0f, getWidth(), getHeight());
                path.reset();
                path.addRoundRect(rectF, f16, f16, Path.Direction.CW);
                canvas.clipPath(path);
            } catch (UnsupportedOperationException unused) {
            }
        }
        super.onDraw(canvas);
        if (this.mEnabledForgroundMaskColor && isMarkerVisible()) {
            canvas.drawColor(this.mForgroundMaskColor);
        }
        this.mMarker.a(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        this.mMarker.x();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mMarker.l(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCornerRadius(float f16) {
        if (this.mCornerRadius != f16) {
            this.mCornerRadius = f16;
            invalidate();
        }
    }

    public void setForgroundMaskColor(int i3) {
        this.mForgroundMaskColor = i3;
        this.mEnabledForgroundMaskColor = true;
    }

    public void setMarker(int i3, int i16) {
        this.mMarker.n(i3, i16);
        invalidate();
    }

    public void setMarkerPaddingOffset(int i3, int i16) {
        this.mMarker.r(i3, i16);
    }

    public void setMarkerPosition(int i3) {
        this.mMarker.s(i3);
    }

    public void setMarkerSize(int i3, int i16) {
        this.mMarker.t(i3, i16);
    }

    public void setMarkerVisible(boolean z16) {
        this.mMarker.u(z16);
    }

    public void setMarkerVisibleWhenSelected(boolean z16) {
        this.mMarker.v(z16);
    }

    public void setOnMarkerClickListener(h.b bVar) {
        this.mMarker.w(bVar);
    }

    public void setMarker(int i3) {
        this.mMarker.m(i3);
    }

    public MarkImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTmpRectF = new RectF();
        init(attributeSet);
    }

    public void setMarker(Drawable drawable) {
        this.mMarker.o(drawable);
    }

    public MarkImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mTmpRectF = new RectF();
        init(attributeSet);
    }
}
