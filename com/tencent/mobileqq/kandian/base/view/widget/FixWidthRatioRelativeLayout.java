package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes33.dex */
public class FixWidthRatioRelativeLayout extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private float f239180d;

    public FixWidthRatioRelativeLayout(Context context) {
        super(context);
        this.f239180d = 1.0f;
    }

    private void a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.FixWidthRatioRelativeLayout);
        this.f239180d = obtainStyledAttributes.getInteger(1, 1) / obtainStyledAttributes.getInteger(0, 1);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i3) / this.f239180d), 1073741824));
    }

    public FixWidthRatioRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f239180d = 1.0f;
        a(attributeSet);
    }

    public FixWidthRatioRelativeLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f239180d = 1.0f;
        a(attributeSet);
    }
}
