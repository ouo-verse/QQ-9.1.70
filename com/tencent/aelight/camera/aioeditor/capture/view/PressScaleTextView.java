package com.tencent.aelight.camera.aioeditor.capture.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

/* loaded from: classes32.dex */
public class PressScaleTextView extends TextView {

    /* renamed from: d, reason: collision with root package name */
    private final a f67268d;

    public PressScaleTextView(Context context) {
        this(context, null);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f67268d.c()) {
            canvas.save();
            this.f67268d.b(canvas);
        }
        super.onDraw(canvas);
        if (this.f67268d.c()) {
            canvas.restore();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            this.f67268d.a();
        }
        return super.onTouchEvent(motionEvent);
    }

    public PressScaleTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PressScaleTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f67268d = new a(this);
    }
}
