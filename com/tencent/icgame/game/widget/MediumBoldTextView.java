package com.tencent.icgame.game.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import d52.a;

/* compiled from: P */
/* loaded from: classes7.dex */
public class MediumBoldTextView extends TextView {

    /* renamed from: d, reason: collision with root package name */
    private float f116107d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f116108e;

    public MediumBoldTextView(Context context) {
        super(context);
        this.f116107d = 0.9f;
        this.f116108e = true;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f116108e) {
            TextPaint paint = getPaint();
            paint.setStrokeWidth(this.f116107d);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
        }
        super.onDraw(canvas);
    }

    public MediumBoldTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f116107d = 0.9f;
        this.f116108e = true;
    }

    public MediumBoldTextView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f116107d = 0.9f;
        this.f116108e = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.R2, i3, 0);
        this.f116107d = obtainStyledAttributes.getFloat(a.S2, 0.9f);
        obtainStyledAttributes.recycle();
    }
}
