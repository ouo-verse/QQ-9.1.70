package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes20.dex */
public class FixRatioPAHighLightImageView extends PAHighLightImageView {
    private float U;

    public FixRatioPAHighLightImageView(Context context) {
        super(context);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i3, int i16) {
        if (this.U == 0.0f) {
            super.onMeasure(i3, i16);
        } else {
            super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i3) / this.U), 1073741824));
        }
    }

    public void setRatio(float f16) {
        this.U = f16;
    }

    public FixRatioPAHighLightImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FixRatioPAHighLightImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
