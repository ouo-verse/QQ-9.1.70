package com.tencent.biz.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: P */
/* loaded from: classes5.dex */
public class Hole extends View {

    /* renamed from: d, reason: collision with root package name */
    private Paint f97692d;

    /* renamed from: e, reason: collision with root package name */
    public int f97693e;

    /* renamed from: f, reason: collision with root package name */
    public int f97694f;

    /* renamed from: h, reason: collision with root package name */
    public int f97695h;

    public Hole(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawARGB(221, 0, 0, 0);
        canvas.drawCircle(this.f97693e, this.f97694f, this.f97695h, this.f97692d);
    }

    public void setHole(int i3, int i16, int i17) {
        this.f97693e = i3;
        this.f97694f = i16;
        this.f97695h = i17;
    }

    public Hole(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.f97692d = paint;
        paint.setColor(-16777216);
        this.f97692d.setAntiAlias(true);
        this.f97692d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public Hole(Context context) {
        super(context);
    }
}
