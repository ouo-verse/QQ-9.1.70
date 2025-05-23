package com.qzone.homepage.ui.component.newpanel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.qzone.homepage.ui.component.newpanel.g;

/* compiled from: P */
/* loaded from: classes39.dex */
public class MarkFrameLayout extends FrameLayout implements g {

    /* renamed from: d, reason: collision with root package name */
    private g.a f47724d;

    public MarkFrameLayout(Context context) {
        super(context);
        a(null);
    }

    private void a(AttributeSet attributeSet) {
        this.f47724d = new g.a(this, attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.f47724d.a(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        this.f47724d.z();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f47724d.l(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setMarker(int i3) {
        this.f47724d.n(i3);
    }

    public void setMarkerMatrix(Matrix matrix) {
        this.f47724d.q(matrix);
    }

    public void setMarkerPaddingOffset(int i3, int i16) {
        this.f47724d.r(i3, i16);
    }

    public void setMarkerPosition(int i3) {
        this.f47724d.s(i3);
    }

    public void setMarkerScaleType(int i3) {
        this.f47724d.t(i3);
    }

    public void setMarkerSize(int i3, int i16) {
        this.f47724d.u(i3, i16);
    }

    public void setMarkerVisible(boolean z16) {
        this.f47724d.v(z16);
    }

    public void setMarkerVisibleWhenSelected(boolean z16) {
        this.f47724d.w(z16);
    }

    public void setOnMarkerClickListener(g.b bVar) {
        this.f47724d.x(bVar);
    }

    public void setMarker(Drawable drawable) {
        this.f47724d.o(drawable);
    }

    public MarkFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public MarkFrameLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a(attributeSet);
    }
}
