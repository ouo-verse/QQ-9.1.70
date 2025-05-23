package com.tencent.image_picker.imagepicker.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* compiled from: P */
/* loaded from: classes7.dex */
public class SquareFrameLayout extends FrameLayout {
    public SquareFrameLayout(Context context) {
        super(context);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i3);
    }

    public SquareFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SquareFrameLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
