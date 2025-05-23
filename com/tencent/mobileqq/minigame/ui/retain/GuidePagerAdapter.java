package com.tencent.mobileqq.minigame.ui.retain;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.widget.RoundRectImageView;

/* loaded from: classes33.dex */
public class GuidePagerAdapter extends PagerAdapter {
    private final UsageGuideStyle mGuideStyle;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GuidePagerAdapter(UsageGuideStyle usageGuideStyle) {
        this.mGuideStyle = usageGuideStyle;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
        super.destroyItem(viewGroup, i3, obj);
        viewGroup.removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        return this.mGuideStyle.guideMediasList.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i3) {
        RoundRectImageView roundRectImageView = new RoundRectImageView(viewGroup.getContext());
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mFailedDrawable = drawable;
        obtain.mLoadingDrawable = drawable;
        UsageGuideStyle usageGuideStyle = this.mGuideStyle;
        if (usageGuideStyle.mediaType == 2) {
            obtain.mUseApngImage = true;
        }
        roundRectImageView.setImageDrawable(URLDrawable.getDrawable(usageGuideStyle.guideMediasList.get(i3), obtain));
        roundRectImageView.setCornerRadiusAndMode((int) (viewGroup.getResources().getDisplayMetrics().density * 8.0f), 1);
        viewGroup.addView(roundRectImageView);
        roundRectImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return roundRectImageView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        if (view == obj) {
            return true;
        }
        return false;
    }
}
