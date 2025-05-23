package com.tencent.timi.game.ui.widget.rc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import android.widget.RelativeLayout;
import ao4.a;
import ao4.b;
import ao4.c;
import ao4.d;

/* compiled from: P */
/* loaded from: classes26.dex */
public class RCRelativeLayout extends RelativeLayout implements Checkable, b, a {

    /* renamed from: d, reason: collision with root package name */
    private d f380176d;

    public RCRelativeLayout(Context context) {
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

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.f380176d.a(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f380176d.b(motionEvent);
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
        this.f380176d.c(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    @SuppressLint({"MissingSuperCall"})
    protected void drawableStateChanged() {
        this.f380176d.d();
    }

    @Override // ao4.a
    public void e(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    @Override // android.view.View
    public void invalidate() {
        this.f380176d.e();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f380176d.f();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        this.f380176d.h(i3, i16, i17, i18);
    }

    public void setBottomLeftRadius(int i3) {
        this.f380176d.i(i3);
    }

    public void setBottomRightRadius(int i3) {
        this.f380176d.j(i3);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z16) {
        this.f380176d.k(z16);
    }

    public void setClipBackground(boolean z16) {
        this.f380176d.l(z16);
    }

    public void setOnCheckedChangeListener(c.a aVar) {
        this.f380176d.m(aVar);
    }

    public void setRadius(int i3) {
        this.f380176d.n(i3);
    }

    public void setRoundAsCircle(boolean z16) {
        this.f380176d.o(z16);
    }

    @Override // ao4.b
    public void setStrokeColor(int i3) {
        this.f380176d.p(i3);
    }

    public void setStrokeWidth(int i3) {
        this.f380176d.q(i3);
    }

    public void setTopLeftRadius(int i3) {
        this.f380176d.r(i3);
    }

    public void setTopRightRadius(int i3) {
        this.f380176d.s(i3);
    }

    @Override // ao4.a
    public boolean superDispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.f380176d.t();
    }

    public RCRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RCRelativeLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        c cVar = new c();
        cVar.c(context, attributeSet);
        this.f380176d = new d(this, cVar);
    }

    @Override // ao4.a
    public View getView() {
        return this;
    }

    @Override // ao4.a
    public void superOnDraw(Canvas canvas) {
    }
}
