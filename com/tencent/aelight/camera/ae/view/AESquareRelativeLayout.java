package com.tencent.aelight.camera.ae.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AESquareRelativeLayout extends RelativeLayout {
    public AESquareRelativeLayout(Context context) {
        super(context);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        int min = Math.min(View.MeasureSpec.getSize(i3), View.MeasureSpec.getSize(i16));
        setMeasuredDimension(min, min);
    }

    public AESquareRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AESquareRelativeLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
