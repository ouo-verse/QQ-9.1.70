package com.tencent.now.od.ui.game.meleegame.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

/* compiled from: P */
/* loaded from: classes22.dex */
public class StrokeTextView extends AppCompatTextView {
    private int C;

    /* renamed from: h, reason: collision with root package name */
    private TextView f338577h;

    /* renamed from: i, reason: collision with root package name */
    private TextPaint f338578i;

    /* renamed from: m, reason: collision with root package name */
    private int f338579m;

    public StrokeTextView(@NonNull Context context) {
        this(context, null, 0);
    }

    private void f(Context context) {
        TextView textView = new TextView(context);
        this.f338577h = textView;
        textView.setTypeface(Typeface.defaultFromStyle(1));
        this.f338577h.setTextColor(this.f338579m);
        this.f338577h.setGravity(getGravity());
        TextPaint paint = this.f338577h.getPaint();
        this.f338578i = paint;
        paint.setStrokeWidth(this.C);
        this.f338578i.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f338578i.setStrokeJoin(Paint.Join.ROUND);
    }

    public TextView e() {
        return this.f338577h;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        this.f338577h.draw(canvas);
        super.onDraw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        this.f338577h.layout(i3, i16, i17, i18);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        this.f338577h.measure(i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        super.onTextChanged(charSequence, i3, i16, i17);
        TextView textView = this.f338577h;
        if (textView != null) {
            CharSequence text = textView.getText();
            if (text == null || !text.equals(getText())) {
                this.f338577h.setText(getText());
                postInvalidate();
            }
        }
    }

    @Override // android.widget.TextView
    public void setGravity(int i3) {
        super.setGravity(i3);
        this.f338577h.setGravity(i3);
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        this.f338577h.setLayoutParams(layoutParams);
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f16, float f17) {
        super.setLineSpacing(f16, f17);
        this.f338577h.setLineSpacing(f16, f17);
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int i3) {
        super.setMaxWidth(i3);
        this.f338577h.setMaxWidth(i3);
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i3, int i16, int i17, int i18) {
        super.setPadding(i3, i16, i17, i18);
        this.f338577h.setPadding(i3, i16, i17, i18);
    }

    public void setStroke(int i3, int i16) {
        this.f338578i.setStrokeWidth(i16);
        this.f338577h.setTextColor(i3);
    }

    @Override // android.widget.TextView
    public void setTextSize(float f16) {
        super.setTextSize(f16);
        this.f338577h.setTextSize(f16);
    }

    public StrokeTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StrokeTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f338579m = -16777216;
        this.C = 2;
        f(context);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setTextSize(int i3, float f16) {
        super.setTextSize(i3, f16);
        this.f338577h.setTextSize(i3, f16);
    }
}
