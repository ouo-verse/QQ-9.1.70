package com.tencent.mobileqq.nearbypro.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.nearbypro.utils.d;

/* compiled from: P */
/* loaded from: classes15.dex */
public class StrokeTextView extends TextView {

    /* renamed from: d, reason: collision with root package name */
    private TextView f253968d;

    public StrokeTextView(Context context) {
        super(context);
        this.f253968d = new TextView(context);
        a();
    }

    public void a() {
        TextPaint paint = this.f253968d.getPaint();
        paint.setStrokeWidth(d.c(3, getContext()));
        paint.setStyle(Paint.Style.STROKE);
        this.f253968d.setTextColor(Color.parseColor("#FFFFFF"));
        this.f253968d.setGravity(getGravity());
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        this.f253968d.draw(canvas);
        super.onDraw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        this.f253968d.layout(i3, i16, i17, i18);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        CharSequence text = this.f253968d.getText();
        if (text == null || !text.equals(getText())) {
            this.f253968d.setText(getText());
            postInvalidate();
        }
        this.f253968d.measure(i3, i16);
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        this.f253968d.setLayoutParams(layoutParams);
    }

    public StrokeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f253968d = new TextView(context, attributeSet);
        a();
    }

    public StrokeTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f253968d = new TextView(context, attributeSet, i3);
        a();
    }
}
