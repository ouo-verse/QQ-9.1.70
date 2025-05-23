package com.tencent.av.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes3.dex */
public class WrapContentViewPager extends ViewPager {
    public WrapContentViewPager(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i3) - getPaddingLeft()) - getPaddingRight()), View.MeasureSpec.getMode(i3));
        int i17 = 0;
        for (int i18 = 0; i18 < getChildCount(); i18++) {
            View childAt = getChildAt(i18);
            childAt.measure(makeMeasureSpec, 0);
            int measuredHeight = childAt.getMeasuredHeight();
            if (measuredHeight > i17) {
                i17 = measuredHeight;
            }
        }
        if (i17 != 0) {
            i16 = View.MeasureSpec.makeMeasureSpec(i17, 1073741824);
        }
        super.onMeasure(i3, i16);
    }

    public WrapContentViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
