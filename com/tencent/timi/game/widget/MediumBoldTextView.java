package com.tencent.timi.game.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import mr2.a;

/* compiled from: P */
/* loaded from: classes26.dex */
public class MediumBoldTextView extends TextView {

    /* renamed from: d, reason: collision with root package name */
    private float f380350d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f380351e;

    public MediumBoldTextView(Context context) {
        super(context);
        this.f380350d = 0.9f;
        this.f380351e = true;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f380351e) {
            TextPaint paint = getPaint();
            paint.setStrokeWidth(this.f380350d);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
        }
        super.onDraw(canvas);
    }

    public MediumBoldTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f380350d = 0.9f;
        this.f380351e = true;
    }

    public MediumBoldTextView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f380350d = 0.9f;
        this.f380351e = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.T2, i3, 0);
        this.f380350d = obtainStyledAttributes.getFloat(a.U2, 0.9f);
        obtainStyledAttributes.recycle();
    }
}
