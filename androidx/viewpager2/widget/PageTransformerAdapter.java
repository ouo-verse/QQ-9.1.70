package androidx.viewpager2.widget;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class PageTransformerAdapter extends ViewPager2.OnPageChangeCallback {
    private final LinearLayoutManager mLayoutManager;
    private ViewPager2.PageTransformer mPageTransformer;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PageTransformerAdapter(LinearLayoutManager linearLayoutManager) {
        this.mLayoutManager = linearLayoutManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewPager2.PageTransformer getPageTransformer() {
        return this.mPageTransformer;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrolled(int i3, float f16, int i16) {
        if (this.mPageTransformer == null) {
            return;
        }
        float f17 = -f16;
        for (int i17 = 0; i17 < this.mLayoutManager.getChildCount(); i17++) {
            View childAt = this.mLayoutManager.getChildAt(i17);
            if (childAt != null) {
                this.mPageTransformer.transformPage(childAt, (this.mLayoutManager.getPosition(childAt) - i3) + f17);
            } else {
                throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", Integer.valueOf(i17), Integer.valueOf(this.mLayoutManager.getChildCount())));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPageTransformer(@Nullable ViewPager2.PageTransformer pageTransformer) {
        this.mPageTransformer = pageTransformer;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrollStateChanged(int i3) {
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(int i3) {
    }
}
