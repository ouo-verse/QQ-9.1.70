package com.qzone.module.feedcomponent.ui.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes39.dex */
public class WrapContentViewPager extends CenterViewPager {
    int height;
    int mDefaultHeight;
    boolean mMeasured;
    boolean mPreMeasureChildToMeasureHeight;

    public WrapContentViewPager(Context context) {
        super(context);
    }

    public int getDefaultHeight() {
        return this.mDefaultHeight;
    }

    public int getTotalHeight() {
        return this.height;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.module.feedcomponent.ui.common.CenterViewPager, android.view.View
    public void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        if (getMeasuredHeight() <= 0) {
            this.height = 0;
            for (int i17 = 0; i17 < getChildCount(); i17++) {
                View childAt = getChildAt(i17);
                if (this.mPreMeasureChildToMeasureHeight) {
                    childAt.measure(i3, View.MeasureSpec.makeMeasureSpec(0, 0));
                }
                int measuredHeight = childAt.getMeasuredHeight();
                if (measuredHeight > this.height) {
                    this.height = measuredHeight;
                }
            }
            if (this.height <= 0) {
                this.height = this.mDefaultHeight;
            }
            int paddingTop = this.height + getPaddingTop() + getPaddingBottom();
            this.height = paddingTop;
            super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824));
        }
    }

    public void setDefaultHeight(int i3) {
        this.mDefaultHeight = i3;
    }

    public void setPreMeasureChildToMeasureHeight(boolean z16) {
        this.mPreMeasureChildToMeasureHeight = z16;
    }

    public WrapContentViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
