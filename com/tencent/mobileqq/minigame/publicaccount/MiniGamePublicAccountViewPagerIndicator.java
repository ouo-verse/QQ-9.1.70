package com.tencent.mobileqq.minigame.publicaccount;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import java.lang.reflect.Array;

/* loaded from: classes33.dex */
public class MiniGamePublicAccountViewPagerIndicator extends LinearLayout implements ViewPager.OnPageChangeListener {
    private IndicatorViewConfig mConfig;
    public ViewPager mViewPager;
    public OnPageSelectedListener onPageSelectedListener;

    /* loaded from: classes33.dex */
    private static class IndicatorView extends View {
        private static final int HEIGHT = ViewUtils.dpToPx(2.0f);
        private static final int SPACE = ViewUtils.dpToPx(2.5f);
        private IndicatorViewConfig mConfig;

        public IndicatorView(Context context, IndicatorViewConfig indicatorViewConfig) {
            super(context);
            this.mConfig = indicatorViewConfig;
            init(context);
        }

        private void init(Context context) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mConfig.normalWidth, HEIGHT);
            layoutParams.gravity = 17;
            int i3 = SPACE;
            layoutParams.leftMargin = i3;
            layoutParams.rightMargin = i3;
            setLayoutParams(layoutParams);
            setClickable(false);
            setFocusable(false);
        }

        @Override // android.view.View
        public void setSelected(boolean z16) {
            int i3;
            int i16;
            IndicatorViewConfig indicatorViewConfig = this.mConfig;
            if (z16) {
                i3 = indicatorViewConfig.selectedColor;
            } else {
                i3 = indicatorViewConfig.normalColor;
            }
            setBackgroundColor(i3);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (z16) {
                i16 = this.mConfig.selectedWidth;
            } else {
                i16 = this.mConfig.normalWidth;
            }
            layoutParams.width = i16;
            setLayoutParams(layoutParams);
        }

        public void update(float f16) {
            setBackgroundColor(getCurrentColor(f16));
            int i3 = (int) (this.mConfig.selectedWidth + ((r0.normalWidth - r1) * f16));
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            layoutParams.width = i3;
            setLayoutParams(layoutParams);
        }

        private int getCurrentColor(float f16) {
            int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 2, 3);
            int[] iArr2 = iArr[0];
            IndicatorViewConfig indicatorViewConfig = this.mConfig;
            int i3 = indicatorViewConfig.selectedColor;
            iArr2[0] = (i3 & ITVKAsset.VOD_ASSET_MASK_BIT) >> 16;
            iArr2[1] = (i3 & 65280) >> 8;
            iArr2[2] = i3 & 255;
            int[] iArr3 = iArr[1];
            int i16 = indicatorViewConfig.normalColor;
            iArr3[0] = (i16 & ITVKAsset.VOD_ASSET_MASK_BIT) >> 16;
            iArr3[1] = (i16 & 65280) >> 8;
            iArr3[2] = i16 & 255;
            int[] iArr4 = new int[3];
            for (int i17 = 0; i17 < 3; i17++) {
                iArr4[i17] = (int) (iArr[0][i17] + ((iArr[1][i17] - r6) * f16));
            }
            return Color.rgb(iArr4[0], iArr4[1], iArr4[2]);
        }
    }

    /* loaded from: classes33.dex */
    public static class IndicatorViewConfig {
        public int normalColor;
        public int normalWidth;
        public int selectedColor;
        public int selectedWidth;
    }

    /* loaded from: classes33.dex */
    public interface OnPageSelectedListener {
        void onPageSelected(int i3);
    }

    public MiniGamePublicAccountViewPagerIndicator(Context context) {
        super(context);
        super.setOrientation(0);
        super.setGravity(17);
    }

    public ViewPager getViewPager() {
        return this.mViewPager;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i3, float f16, int i16) {
        IndicatorView indicatorView = (IndicatorView) getChildAt(i3);
        if (indicatorView != null) {
            indicatorView.update(f16);
        }
        if (i3 < getChildCount() - 1) {
            ((IndicatorView) getChildAt(i3 + 1)).update(1.0f - f16);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i3) {
        ViewPager viewPager = this.mViewPager;
        if (viewPager == null || viewPager.getAdapter() == null || super.getChildCount() <= i3) {
            return;
        }
        int i16 = 0;
        while (i16 < super.getChildCount()) {
            IndicatorView indicatorView = (IndicatorView) super.getChildAt(i16);
            if (indicatorView != null) {
                indicatorView.setSelected(i16 == i3);
            }
            i16++;
        }
        OnPageSelectedListener onPageSelectedListener = this.onPageSelectedListener;
        if (onPageSelectedListener != null) {
            onPageSelectedListener.onPageSelected(i3);
        }
    }

    public void refreshIndicator() {
        PagerAdapter adapter;
        ViewPager viewPager = this.mViewPager;
        if (viewPager == null || (adapter = viewPager.getAdapter()) == null) {
            return;
        }
        int count = adapter.getCount();
        if (count <= 1) {
            super.setVisibility(4);
            return;
        }
        super.setVisibility(0);
        super.removeAllViews();
        int currentItem = this.mViewPager.getCurrentItem();
        if (currentItem >= super.getChildCount()) {
            currentItem = super.getChildCount() - 1;
        }
        if (currentItem < 0) {
            currentItem = 0;
        }
        for (int i3 = 0; i3 < count; i3++) {
            super.addView(new IndicatorView(getContext(), this.mConfig));
        }
        int i16 = 0;
        while (i16 < super.getChildCount()) {
            IndicatorView indicatorView = (IndicatorView) super.getChildAt(i16);
            if (indicatorView != null) {
                indicatorView.setSelected(i16 == currentItem);
            }
            i16++;
        }
    }

    public void setIndicatorViewConfig(IndicatorViewConfig indicatorViewConfig) {
        this.mConfig = indicatorViewConfig;
    }

    public void setOnPageSelectedListener(OnPageSelectedListener onPageSelectedListener) {
        this.onPageSelectedListener = onPageSelectedListener;
    }

    public void setViewPager(ViewPager viewPager) {
        this.mViewPager = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(this);
        }
    }

    public MiniGamePublicAccountViewPagerIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setOrientation(0);
        super.setGravity(17);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i3) {
    }
}
