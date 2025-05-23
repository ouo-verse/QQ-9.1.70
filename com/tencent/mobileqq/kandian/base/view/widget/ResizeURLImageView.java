package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: P */
/* loaded from: classes15.dex */
public class ResizeURLImageView extends ZImageView {
    private boolean mBlockLayout;
    private Context mContext;
    private float mHeightWeight;
    private float mWidthWeight;

    public ResizeURLImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mWidthWeight = 1.0f;
        this.mHeightWeight = 1.0f;
        this.mBlockLayout = false;
        this.mContext = context;
        getResizeScale(attributeSet);
    }

    private void getResizeScale(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, j52.a.F4);
        this.mWidthWeight = obtainStyledAttributes.getFloat(j52.a.H4, 1.0f);
        this.mHeightWeight = obtainStyledAttributes.getFloat(j52.a.G4, 1.0f);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i16);
        float f16 = this.mWidthWeight;
        if (f16 == 1.0f) {
            float f17 = this.mHeightWeight;
            if (f17 != 1.0f) {
                setMeasuredDimension(size, (int) (size * f17));
                return;
            }
        }
        if (f16 != 1.0f && this.mHeightWeight == 1.0f) {
            setMeasuredDimension((int) (size2 * f16), size2);
        }
    }

    @Override // android.view.View
    public void requestLayout() {
        if (!this.mBlockLayout) {
            super.requestLayout();
        }
    }

    @Override // com.tencent.mobileqq.kandian.base.view.widget.ZImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        this.mBlockLayout = true;
        super.setImageDrawable(null);
        super.setImageDrawable(drawable);
        this.mBlockLayout = false;
    }

    public ResizeURLImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ResizeURLImageView(Context context) {
        this(context, null);
    }
}
