package com.tencent.mtt.hippy.views.hippypager.transform;

import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes20.dex */
public class VerticalPageTransformer implements ViewPager.PageTransformer {
    @Override // androidx.viewpager.widget.ViewPager.PageTransformer
    public void transformPage(View view, float f16) {
        if (f16 >= -1.0f && f16 <= 1.0f) {
            view.setTranslationX(view.getWidth() * (-f16));
            view.setTranslationY(f16 * view.getHeight());
        }
    }
}
