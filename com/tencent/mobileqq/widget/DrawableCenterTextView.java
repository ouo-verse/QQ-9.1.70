package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

/* compiled from: P */
/* loaded from: classes20.dex */
public class DrawableCenterTextView extends TextView {
    public DrawableCenterTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        setGravity(16);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable[] compoundDrawables = getCompoundDrawables();
        if (compoundDrawables != null) {
            Drawable drawable = compoundDrawables[0];
            Drawable drawable2 = compoundDrawables[2];
            if (drawable != null || drawable2 != null) {
                float measureText = getPaint().measureText(getText().toString()) + getCompoundDrawablePadding();
                if (drawable != null && drawable2 == null) {
                    measureText += drawable.getIntrinsicWidth();
                } else if (drawable2 != null && drawable == null) {
                    measureText += drawable2.getIntrinsicWidth();
                    setPadding(0, 0, (int) (getWidth() - measureText), 0);
                } else if (drawable != null && drawable2 != null) {
                    measureText += drawable2.getIntrinsicWidth() + drawable.getIntrinsicWidth() + r4;
                    setPadding(0, 0, (int) (getWidth() - measureText), 0);
                }
                canvas.translate((getWidth() - measureText) / 2.0f, 0.0f);
            }
        }
        super.onDraw(canvas);
    }

    public DrawableCenterTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setGravity(16);
    }

    public DrawableCenterTextView(Context context) {
        super(context);
        setGravity(16);
    }
}
