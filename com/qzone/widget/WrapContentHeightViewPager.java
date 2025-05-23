package com.qzone.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.utils.ViewUtils;

/* loaded from: classes37.dex */
public class WrapContentHeightViewPager extends ViewPager {

    /* renamed from: d, reason: collision with root package name */
    private boolean f60694d;

    public WrapContentHeightViewPager(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        int defaultSize = View.getDefaultSize(0, i3);
        if (this.f60694d) {
            setMeasuredDimension(defaultSize, (int) (ViewUtils.getScreenWidth() * 0.625f));
        } else {
            setMeasuredDimension(defaultSize, (int) (ViewUtils.getScreenWidth() * 0.51180553f));
        }
    }

    public WrapContentHeightViewPager(Context context, boolean z16) {
        super(context);
        this.f60694d = z16;
    }

    public WrapContentHeightViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
