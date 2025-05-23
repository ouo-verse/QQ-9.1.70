package com.tencent.icgame.game.ui.widget.rc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import dy0.a;
import dy0.b;
import dy0.c;
import dy0.d;

/* compiled from: P */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes7.dex */
public class RCImageView extends ImageView implements Checkable, b, a {

    /* renamed from: d, reason: collision with root package name */
    private d f115993d;

    public RCImageView(Context context) {
        this(context, null);
    }

    @Override // dy0.a
    public void a(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
    }

    @Override // dy0.a
    public void b(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // dy0.a
    public void c() {
        super.drawableStateChanged();
    }

    @Override // dy0.a
    public void d() {
        super.invalidate();
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f115993d.b(motionEvent);
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
        this.f115993d.c(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    @SuppressLint({"MissingSuperCall"})
    protected void drawableStateChanged() {
        this.f115993d.d();
    }

    @Override // dy0.a
    public void e(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    @Override // android.view.View
    public void invalidate() {
        d dVar = this.f115993d;
        if (dVar != null) {
            dVar.e();
        } else {
            super.invalidate();
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f115993d.f();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        this.f115993d.g(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        this.f115993d.h(i3, i16, i17, i18);
    }

    public void setBottomLeftRadius(int i3) {
        this.f115993d.i(i3);
    }

    public void setBottomRightRadius(int i3) {
        this.f115993d.j(i3);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z16) {
        this.f115993d.k(z16);
    }

    public void setClipBackground(boolean z16) {
        this.f115993d.l(z16);
    }

    public void setOnCheckedChangeListener(c.a aVar) {
        this.f115993d.m(aVar);
    }

    public void setRadius(int i3) {
        this.f115993d.n(i3);
    }

    public void setRoundAsCircle(boolean z16) {
        this.f115993d.o(z16);
    }

    @Override // dy0.b
    public void setStrokeColor(int i3) {
        this.f115993d.p(i3);
    }

    public void setStrokeWidth(int i3) {
        this.f115993d.q(i3);
    }

    public void setTopLeftRadius(int i3) {
        this.f115993d.r(i3);
    }

    public void setTopRightRadius(int i3) {
        this.f115993d.s(i3);
    }

    @Override // dy0.a
    public boolean superDispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // dy0.a
    @SuppressLint({"WrongCall"})
    public void superOnDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.f115993d.t();
    }

    public RCImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RCImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        c cVar = new c();
        cVar.c(context, attributeSet);
        this.f115993d = new d(this, cVar);
    }

    @Override // dy0.a
    public View getView() {
        return this;
    }
}
