package com.tencent.now.app.music.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MusicLoadingCircleView extends View {

    /* renamed from: d, reason: collision with root package name */
    Paint f338058d;

    /* renamed from: e, reason: collision with root package name */
    private RectF f338059e;

    /* renamed from: f, reason: collision with root package name */
    private float f338060f;

    public MusicLoadingCircleView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a();
    }

    private void a() {
        Paint paint = new Paint();
        this.f338058d = paint;
        paint.setAntiAlias(true);
        this.f338058d.setColor(Color.parseColor("#6605d380"));
        this.f338058d.setStyle(Paint.Style.FILL);
        this.f338059e = new RectF();
        this.f338060f = 0.0f;
        setVisibility(8);
    }

    public void b(float f16) {
        if (f16 >= 1.0f) {
            setVisibility(8);
        } else {
            setVisibility(0);
            this.f338060f = f16;
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f338060f >= 0.0f) {
            float measuredWidth = getMeasuredWidth();
            this.f338059e.set(0.0f, 0.0f, measuredWidth, measuredWidth);
            canvas.drawArc(this.f338059e, 270.0f, -((1.0f - this.f338060f) * 360.0f), true, this.f338058d);
        }
    }

    public MusicLoadingCircleView(Context context) {
        this(context, null);
    }

    public MusicLoadingCircleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
