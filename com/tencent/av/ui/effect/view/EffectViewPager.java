package com.tencent.av.ui.effect.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.mobileqq.widget.QQViewPager;

/* loaded from: classes3.dex */
public class EffectViewPager extends QQViewPager {

    /* renamed from: d, reason: collision with root package name */
    DisplayMetrics f75586d;

    public EffectViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f75586d = getContext().getResources().getDisplayMetrics();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(this.f75586d.widthPixels, 1073741824), i16);
    }

    public EffectViewPager(Context context) {
        super(context);
        this.f75586d = getContext().getResources().getDisplayMetrics();
    }
}
