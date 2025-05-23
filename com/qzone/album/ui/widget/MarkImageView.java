package com.qzone.album.ui.widget;

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
/* loaded from: classes39.dex */
public class MarkImageView extends ImageView implements h {

    /* renamed from: d, reason: collision with root package name */
    private h.a f44198d;

    /* renamed from: e, reason: collision with root package name */
    private int f44199e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f44200f;

    /* renamed from: h, reason: collision with root package name */
    private float f44201h;

    /* renamed from: i, reason: collision with root package name */
    private Path f44202i;

    /* renamed from: m, reason: collision with root package name */
    private RectF f44203m;

    public MarkImageView(Context context) {
        super(context);
        this.f44203m = new RectF();
        a(null);
    }

    private void a(AttributeSet attributeSet) {
        this.f44198d = new h.a(this, attributeSet);
    }

    public boolean b() {
        return this.f44198d.j();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        float f16 = this.f44201h;
        if (f16 != 0.0f) {
            if (this.f44202i == null) {
                this.f44202i = new Path();
            }
            try {
                Path path = this.f44202i;
                RectF rectF = this.f44203m;
                rectF.set(0.0f, 0.0f, getWidth(), getHeight());
                path.reset();
                path.addRoundRect(rectF, f16, f16, Path.Direction.CW);
                canvas.clipPath(path);
            } catch (UnsupportedOperationException unused) {
            }
        }
        super.onDraw(canvas);
        if (this.f44200f && b()) {
            canvas.drawColor(this.f44199e);
        }
        this.f44198d.a(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        this.f44198d.x();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f44198d.l(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCornerRadius(float f16) {
        if (this.f44201h != f16) {
            this.f44201h = f16;
            invalidate();
        }
    }

    public void setForgroundMaskColor(int i3) {
        this.f44199e = i3;
        this.f44200f = true;
    }

    public void setMarker(int i3, int i16) {
        this.f44198d.n(i3, i16);
        invalidate();
    }

    public void setMarkerPaddingOffset(int i3, int i16) {
        this.f44198d.r(i3, i16);
    }

    public void setMarkerPosition(int i3) {
        this.f44198d.s(i3);
    }

    public void setMarkerSize(int i3, int i16) {
        this.f44198d.t(i3, i16);
    }

    public void setMarkerVisible(boolean z16) {
        this.f44198d.u(z16);
    }

    public void setMarkerVisibleWhenSelected(boolean z16) {
        this.f44198d.v(z16);
    }

    public void setOnMarkerClickListener(h.b bVar) {
        this.f44198d.w(bVar);
    }

    public void setMarker(int i3) {
        this.f44198d.m(i3);
    }

    public MarkImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f44203m = new RectF();
        a(attributeSet);
    }

    public void setMarker(Drawable drawable) {
        this.f44198d.o(drawable);
    }

    public MarkImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f44203m = new RectF();
        a(attributeSet);
    }
}
