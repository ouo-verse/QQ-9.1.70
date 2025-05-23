package com.tencent.now.linkpkanchorplay.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.now.app.common.widget.BaseViewPager;

/* loaded from: classes22.dex */
public class WrapContentHeightViewPager extends BaseViewPager {
    public WrapContentHeightViewPager(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onMeasure(int i3, int i16) {
        int mode = View.MeasureSpec.getMode(i16);
        if (mode == 0 || mode == Integer.MIN_VALUE) {
            super.onMeasure(i3, i16);
            int i17 = 0;
            for (int i18 = 0; i18 < getChildCount(); i18++) {
                View childAt = getChildAt(i18);
                childAt.measure(i3, View.MeasureSpec.makeMeasureSpec(0, 0));
                int measuredHeight = childAt.getMeasuredHeight();
                if (measuredHeight > i17) {
                    i17 = measuredHeight;
                }
            }
            i16 = View.MeasureSpec.makeMeasureSpec(i17, 1073741824);
        }
        super.onMeasure(i3, i16);
    }

    public WrapContentHeightViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
