package com.qzone.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* loaded from: classes37.dex */
public class PercentProgressBar extends ProgressBar {

    /* renamed from: d, reason: collision with root package name */
    String f60435d;

    /* renamed from: e, reason: collision with root package name */
    Paint f60436e;

    /* renamed from: f, reason: collision with root package name */
    private Rect f60437f;

    public PercentProgressBar(Context context) {
        super(context);
        this.f60437f = new Rect();
        a();
    }

    private void a() {
        Paint paint = new Paint();
        this.f60436e = paint;
        paint.setColor(-16777216);
        this.f60436e.setTextSize(18.0f);
    }

    private void b(int i3) {
        this.f60435d = "";
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f60437f.setEmpty();
        Paint paint = this.f60436e;
        String str = this.f60435d;
        paint.getTextBounds(str, 0, str.length(), this.f60437f);
        canvas.drawText(this.f60435d, (getWidth() / 2) - this.f60437f.centerX(), (getHeight() / 2) - this.f60437f.centerY(), this.f60436e);
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i3) {
        b(i3);
        super.setProgress(i3);
    }

    @Override // android.widget.ProgressBar
    public synchronized void setSecondaryProgress(int i3) {
        b(i3);
        super.setSecondaryProgress(i3);
    }

    public PercentProgressBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f60437f = new Rect();
        a();
    }

    public PercentProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f60437f = new Rect();
        a();
    }
}
