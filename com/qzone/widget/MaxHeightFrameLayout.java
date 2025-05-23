package com.qzone.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes37.dex */
public class MaxHeightFrameLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private float f60418d;

    public MaxHeightFrameLayout(Context context) {
        super(context);
        this.f60418d = 0.0f;
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaxHeightFragment);
        this.f60418d = obtainStyledAttributes.getDimension(0, 0.0f);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        float measuredHeight = getMeasuredHeight();
        float f16 = this.f60418d;
        if (measuredHeight <= f16 || f16 <= 0.0f) {
            return;
        }
        super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec((int) f16, 1073741824));
    }

    public MaxHeightFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f60418d = 0.0f;
        a(context, attributeSet);
    }

    public MaxHeightFrameLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f60418d = 0.0f;
        a(context, attributeSet);
    }
}
