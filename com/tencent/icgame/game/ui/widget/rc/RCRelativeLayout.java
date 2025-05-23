package com.tencent.icgame.game.ui.widget.rc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import android.widget.RelativeLayout;
import dy0.a;
import dy0.b;
import dy0.c;
import dy0.d;

/* compiled from: P */
/* loaded from: classes7.dex */
public class RCRelativeLayout extends RelativeLayout implements Checkable, b, a {

    /* renamed from: d, reason: collision with root package name */
    private d f115994d;

    public RCRelativeLayout(Context context) {
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

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.f115994d.a(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f115994d.b(motionEvent);
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
        this.f115994d.c(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    @SuppressLint({"MissingSuperCall"})
    protected void drawableStateChanged() {
        this.f115994d.d();
    }

    @Override // dy0.a
    public void e(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    @Override // android.view.View
    public void invalidate() {
        this.f115994d.e();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f115994d.f();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        this.f115994d.h(i3, i16, i17, i18);
    }

    public void setBottomLeftRadius(int i3) {
        this.f115994d.i(i3);
    }

    public void setBottomRightRadius(int i3) {
        this.f115994d.j(i3);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z16) {
        this.f115994d.k(z16);
    }

    public void setClipBackground(boolean z16) {
        this.f115994d.l(z16);
    }

    public void setOnCheckedChangeListener(c.a aVar) {
        this.f115994d.m(aVar);
    }

    public void setRadius(int i3) {
        this.f115994d.n(i3);
    }

    public void setRoundAsCircle(boolean z16) {
        this.f115994d.o(z16);
    }

    @Override // dy0.b
    public void setStrokeColor(int i3) {
        this.f115994d.p(i3);
    }

    public void setStrokeWidth(int i3) {
        this.f115994d.q(i3);
    }

    public void setTopLeftRadius(int i3) {
        this.f115994d.r(i3);
    }

    public void setTopRightRadius(int i3) {
        this.f115994d.s(i3);
    }

    @Override // dy0.a
    public boolean superDispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.f115994d.t();
    }

    public RCRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RCRelativeLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        c cVar = new c();
        cVar.c(context, attributeSet);
        this.f115994d = new d(this, cVar);
    }

    @Override // dy0.a
    public View getView() {
        return this;
    }

    @Override // dy0.a
    public void superOnDraw(Canvas canvas) {
    }
}
