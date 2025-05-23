package com.tencent.biz.pubaccount.weishi.view;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.widget.ViewPagerCompat;

/* loaded from: classes32.dex */
public class WSViewPager extends ViewPagerCompat {

    /* renamed from: i, reason: collision with root package name */
    private boolean f82425i;

    public WSViewPager(Context context) {
        super(context);
        this.f82425i = true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean canScrollHorizontally(int i3) {
        if (this.f82425i) {
            return super.canScrollHorizontally(i3);
        }
        return false;
    }

    public void setCanScrollHorizontally(boolean z16) {
        this.f82425i = z16;
    }

    public WSViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f82425i = true;
    }
}
