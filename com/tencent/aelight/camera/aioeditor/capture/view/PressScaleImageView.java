package com.tencent.aelight.camera.aioeditor.capture.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

/* loaded from: classes32.dex */
public class PressScaleImageView extends ImageView {

    /* renamed from: d, reason: collision with root package name */
    private final a f67266d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f67267e;

    public PressScaleImageView(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f67266d.c()) {
            canvas.save();
            this.f67266d.b(canvas);
        }
        super.onDraw(canvas);
        if (this.f67266d.c()) {
            canvas.restore();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0 && this.f67267e) {
            this.f67266d.a();
        }
        return super.onTouchEvent(motionEvent);
    }

    public PressScaleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PressScaleImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f67267e = true;
        this.f67266d = new a(this);
    }
}
