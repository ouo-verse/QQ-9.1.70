package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.widget.TextView;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class nc extends TextView {

    /* renamed from: a, reason: collision with root package name */
    private int f149377a;

    /* renamed from: b, reason: collision with root package name */
    private float f149378b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f149379c;

    public nc(Context context) {
        super(context);
        setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        getPaint().setFakeBoldText(true);
    }

    @Override // android.view.View
    public final void invalidate() {
        if (this.f149379c) {
            return;
        }
        super.invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    protected final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f149378b > 0.0f) {
            this.f149379c = true;
            int currentTextColor = getCurrentTextColor();
            TextPaint paint = getPaint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(this.f149378b);
            setTextColor(this.f149377a);
            super.onDraw(canvas);
            paint.setStyle(Paint.Style.FILL);
            paint.setStrokeWidth(0.0f);
            setTextColor(currentTextColor);
            super.onDraw(canvas);
            setTextColor(currentTextColor);
            this.f149379c = false;
            return;
        }
        super.onDraw(canvas);
    }

    public final void setStrokeColor(int i3) {
        this.f149377a = i3;
    }

    public final void setStrokeWidth(float f16) {
        this.f149378b = f16;
    }
}
