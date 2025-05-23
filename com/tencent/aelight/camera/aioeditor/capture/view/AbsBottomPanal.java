package com.tencent.aelight.camera.aioeditor.capture.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* loaded from: classes32.dex */
public abstract class AbsBottomPanal extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    protected boolean f67224d;

    public AbsBottomPanal(Context context) {
        super(context);
        this.f67224d = false;
    }

    public void setClosedByTouch(boolean z16) {
        this.f67224d = z16;
    }

    public AbsBottomPanal(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f67224d = false;
    }

    public AbsBottomPanal(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f67224d = false;
    }
}
