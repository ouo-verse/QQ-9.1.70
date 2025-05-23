package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSCoverImageView extends RoundCornerImageView {
    private float G;

    public QFSCoverImageView(Context context) {
        super(context);
        this.G = 0.8f;
    }

    public float b() {
        return this.G;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        int measuredWidth = getMeasuredWidth();
        if (measuredWidth == 0) {
            return;
        }
        setMeasuredDimension(measuredWidth, (int) (measuredWidth / this.G));
    }

    public void setRadio(float f16) {
        this.G = f16;
    }

    public QFSCoverImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.G = 0.8f;
    }

    public QFSCoverImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.G = 0.8f;
    }
}
