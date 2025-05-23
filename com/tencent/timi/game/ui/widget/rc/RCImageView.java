package com.tencent.timi.game.ui.widget.rc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import ao4.a;
import ao4.b;
import ao4.c;
import ao4.d;

/* compiled from: P */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes26.dex */
public class RCImageView extends ImageView implements Checkable, b, a {

    /* renamed from: d, reason: collision with root package name */
    private d f380175d;

    public RCImageView(Context context) {
        this(context, null);
    }

    @Override // ao4.a
    public void a(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
    }

    @Override // ao4.a
    public void b(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // ao4.a
    public void c() {
        super.drawableStateChanged();
    }

    @Override // ao4.a
    public void d() {
        super.invalidate();
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f380175d.b(motionEvent);
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
        this.f380175d.c(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    @SuppressLint({"MissingSuperCall"})
    protected void drawableStateChanged() {
        this.f380175d.d();
    }

    @Override // ao4.a
    public void e(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    @Override // android.view.View
    public void invalidate() {
        d dVar = this.f380175d;
        if (dVar != null) {
            dVar.e();
        } else {
            super.invalidate();
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f380175d.f();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        this.f380175d.g(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        this.f380175d.h(i3, i16, i17, i18);
    }

    public void setBottomLeftRadius(int i3) {
        this.f380175d.i(i3);
    }

    public void setBottomRightRadius(int i3) {
        this.f380175d.j(i3);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z16) {
        this.f380175d.k(z16);
    }

    public void setClipBackground(boolean z16) {
        this.f380175d.l(z16);
    }

    public void setOnCheckedChangeListener(c.a aVar) {
        this.f380175d.m(aVar);
    }

    public void setRadius(int i3) {
        this.f380175d.n(i3);
    }

    public void setRoundAsCircle(boolean z16) {
        this.f380175d.o(z16);
    }

    @Override // ao4.b
    public void setStrokeColor(int i3) {
        this.f380175d.p(i3);
    }

    public void setStrokeWidth(int i3) {
        this.f380175d.q(i3);
    }

    public void setTopLeftRadius(int i3) {
        this.f380175d.r(i3);
    }

    public void setTopRightRadius(int i3) {
        this.f380175d.s(i3);
    }

    @Override // ao4.a
    public boolean superDispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // ao4.a
    @SuppressLint({"WrongCall"})
    public void superOnDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.f380175d.t();
    }

    public RCImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RCImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        c cVar = new c();
        cVar.c(context, attributeSet);
        this.f380175d = new d(this, cVar);
    }

    @Override // ao4.a
    public View getView() {
        return this;
    }
}
