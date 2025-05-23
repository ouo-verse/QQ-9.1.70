package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* loaded from: classes32.dex */
public abstract class AEAbsBottomPanal extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    protected boolean f62849d;

    public AEAbsBottomPanal(Context context) {
        super(context);
        this.f62849d = false;
    }

    public abstract void f(boolean z16);

    public abstract boolean g();

    public void setClosedByTouch(boolean z16) {
        this.f62849d = z16;
    }

    public void e() {
        f(true);
    }

    public AEAbsBottomPanal(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f62849d = false;
    }

    public AEAbsBottomPanal(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f62849d = false;
    }
}
