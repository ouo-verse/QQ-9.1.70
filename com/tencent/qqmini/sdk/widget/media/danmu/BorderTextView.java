package com.tencent.qqmini.sdk.widget.media.danmu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/* compiled from: P */
/* loaded from: classes23.dex */
public class BorderTextView extends TextView {
    private int borderColor;

    public BorderTextView(Context context, int i3) {
        this(context, null, i3);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(this.borderColor);
        paint.setStrokeWidth(5.0f);
        canvas.drawLine(0.0f, 0.0f, getWidth(), 0.0f, paint);
        canvas.drawLine(0.0f, 0.0f, 0.0f, getHeight(), paint);
        canvas.drawLine(getWidth(), 0.0f, getWidth(), getHeight(), paint);
        canvas.drawLine(0.0f, getHeight(), getWidth(), getHeight(), paint);
        super.onDraw(canvas);
    }

    public BorderTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet);
        this.borderColor = i3;
    }
}
