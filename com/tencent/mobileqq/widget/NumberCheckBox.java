package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.CheckBox;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes20.dex */
public class NumberCheckBox extends CheckBox {

    /* renamed from: d, reason: collision with root package name */
    private int f315884d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f315885e;

    /* renamed from: f, reason: collision with root package name */
    private Paint f315886f;

    public NumberCheckBox(Context context) {
        this(context, null, 0);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f315885e) {
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, Math.min(getWidth() / 2.0f, getHeight() / 2.0f), this.f315886f);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z16) {
        String str;
        int i3;
        super.setChecked(z16);
        if (z16 && (i3 = this.f315884d) >= 0) {
            str = String.valueOf(i3);
        } else {
            str = "";
        }
        if (!str.equals(getText())) {
            setText(str);
        }
    }

    public void setCheckedNumber(int i3) {
        if (this.f315884d != i3) {
            this.f315884d = i3;
            setText(String.valueOf(i3));
        }
        setChecked(true);
    }

    public void setForegroundColor(int i3) {
        this.f315886f.setColor(i3);
    }

    public void setNeedForeground(boolean z16) {
        this.f315885e = z16;
    }

    public NumberCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NumberCheckBox(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f315884d = -1;
        this.f315885e = false;
        Paint paint = new Paint();
        this.f315886f = paint;
        paint.setColor(context.getResources().getColor(R.color.al9));
        this.f315886f.setStyle(Paint.Style.FILL);
    }
}
