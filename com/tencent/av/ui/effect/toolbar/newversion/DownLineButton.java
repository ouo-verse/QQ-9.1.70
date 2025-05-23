package com.tencent.av.ui.effect.toolbar.newversion;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DownLineButton extends Button {

    /* renamed from: e, reason: collision with root package name */
    private static String f75565e = "DownLineButton";

    /* renamed from: d, reason: collision with root package name */
    private Paint f75566d;

    public DownLineButton(Context context) {
        super(context);
        this.f75566d = new Paint();
    }

    private void a(boolean z16) {
        ColorStateList textColors = getTextColors();
        if (textColors == null) {
            return;
        }
        int colorForState = textColors.getColorForState(View.SELECTED_STATE_SET, 0);
        if (!z16) {
            colorForState = Color.parseColor("#00000000");
        }
        if (QLog.isColorLevel()) {
            QLog.d(f75565e, 2, "color = " + colorForState);
        }
        this.f75566d.setAntiAlias(true);
        this.f75566d.setColor(colorForState);
        this.f75566d.setStyle(Paint.Style.FILL);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(getPaddingLeft(), (getHeight() - ViewUtils.dip2px(2.0f)) - getPaddingBottom(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.f75566d);
        if (QLog.isColorLevel()) {
            QLog.d(f75565e, 2, "onDraw");
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z16) {
        super.setEnabled(z16);
    }

    @Override // android.view.View
    public void setPressed(boolean z16) {
        super.setPressed(z16);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z16) {
        super.setSelected(z16);
        a(z16);
    }

    public DownLineButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f75566d = new Paint();
    }

    public DownLineButton(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f75566d = new Paint();
    }
}
