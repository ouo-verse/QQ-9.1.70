package com.qzone.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* compiled from: P */
/* loaded from: classes37.dex */
public class RoundLayout extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private final Paint f60658d;

    public RoundLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(getWidth() / 2, getWidth() / 2, getWidth() / 2, this.f60658d);
        super.onDraw(canvas);
    }

    public RoundLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Paint paint = new Paint();
        this.f60658d = paint;
        setBackgroundColor(0);
        paint.setColor(-1);
        paint.setStyle(Paint.Style.FILL);
    }
}
