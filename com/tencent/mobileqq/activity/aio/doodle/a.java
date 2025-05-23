package com.tencent.mobileqq.activity.aio.doodle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;

/* compiled from: P */
/* loaded from: classes10.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected Context f178505a;

    /* renamed from: b, reason: collision with root package name */
    protected DoodleView f178506b;

    /* renamed from: c, reason: collision with root package name */
    protected Rect f178507c = new Rect();

    public a(DoodleView doodleView) {
        if (doodleView != null) {
            this.f178505a = doodleView.getContext();
            this.f178506b = doodleView;
            return;
        }
        throw new IllegalStateException("DoodleView can not be null.");
    }

    public final boolean c(MotionEvent motionEvent) {
        f();
        return i(motionEvent);
    }

    public final void d(Canvas canvas) {
        h(canvas);
    }

    public boolean e() {
        return g();
    }

    public void f() {
        DoodleView doodleView = this.f178506b;
        if (doodleView != null) {
            doodleView.invalidate();
        }
    }

    public abstract boolean g();

    protected abstract void h(Canvas canvas);

    protected abstract boolean i(MotionEvent motionEvent);

    public void j(int i3, int i16) {
        if (i3 > 0 && i16 > 0) {
            this.f178507c.set(0, 0, i3, i16);
        }
    }
}
