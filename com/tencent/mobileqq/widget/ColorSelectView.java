package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ColorSelectView extends View {

    /* renamed from: d, reason: collision with root package name */
    private int f315550d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f315551e;

    /* renamed from: f, reason: collision with root package name */
    private int f315552f;

    /* renamed from: h, reason: collision with root package name */
    private Paint f315553h;

    /* renamed from: i, reason: collision with root package name */
    private float f315554i;

    public ColorSelectView(Context context) {
        super(context);
        a();
    }

    private void a() {
        this.f315552f = com.tencent.mobileqq.util.x.c(getContext(), 5.0f);
        Paint paint = new Paint();
        this.f315553h = paint;
        paint.setAntiAlias(true);
        this.f315554i = getResources().getDisplayMetrics().density;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int measuredWidth = getMeasuredWidth();
        this.f315553h.setColor(this.f315550d);
        this.f315553h.setStyle(Paint.Style.FILL);
        float f16 = measuredWidth / 2;
        canvas.drawCircle(f16, f16, (measuredWidth - this.f315552f) / 2, this.f315553h);
        if (this.f315551e) {
            this.f315553h.setColor(-15550475);
            this.f315553h.setStyle(Paint.Style.STROKE);
            this.f315553h.setStrokeWidth(this.f315554i);
            canvas.drawCircle(f16, f16, f16 - this.f315554i, this.f315553h);
        }
    }

    public void setColor(int i3) {
        this.f315550d = i3;
        invalidate();
    }

    public void setSelect(boolean z16) {
        this.f315551e = z16;
        invalidate();
    }

    public ColorSelectView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public ColorSelectView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a();
    }
}
