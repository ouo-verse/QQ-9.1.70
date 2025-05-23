package com.qzone.module.feedcomponent.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: P */
/* loaded from: classes39.dex */
public class RadioCornerImageView extends CornerImageView {
    private float mWidthHeightRadio;

    public RadioCornerImageView(Context context) {
        super(context);
        this.mWidthHeightRadio = -1.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.widget.ExtendImageView, android.widget.ImageView, android.view.View
    public void onMeasure(int i3, int i16) {
        if (this.mWidthHeightRadio > 0.0f) {
            int size = View.MeasureSpec.getSize(i3);
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec((int) (size / this.mWidthHeightRadio), 1073741824));
            return;
        }
        super.onMeasure(i3, i16);
    }

    public void setWidthHeightRadio(float f16) {
        this.mWidthHeightRadio = f16;
    }

    public RadioCornerImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mWidthHeightRadio = -1.0f;
    }

    public RadioCornerImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mWidthHeightRadio = -1.0f;
    }
}
