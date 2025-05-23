package com.tencent.ad.tangram.views.canvas.components.imagescarousel;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ad.tangram.log.AdLog;
import java.util.List;

/* loaded from: classes3.dex */
public class AdImagesCarouselPagerAdapter extends PagerAdapter {
    private static final String TAG = "AdImagesCarouselPagerAdapter";
    private int pageLimit;
    private List<View> viewList;

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(@NonNull ViewGroup viewGroup, int i3, Object obj) {
        viewGroup.removeView(this.viewList.get(i3));
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.viewList.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public float getPageWidth(int i3) {
        return 1.0f / this.pageLimit;
    }

    @Nullable
    public View getView(int i3) {
        List<View> list = this.viewList;
        if (list != null && i3 >= 0 && i3 < list.size()) {
            return this.viewList.get(i3);
        }
        return null;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i3) {
        AdLog.i(TAG, "instantiateItem: position: " + i3);
        viewGroup.addView(this.viewList.get(i3));
        return this.viewList.get(i3);
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        if (view == obj) {
            return true;
        }
        return false;
    }

    public void setPageLimit(int i3) {
        this.pageLimit = i3;
    }

    public void setViewList(List<View> list) {
        this.viewList = list;
    }
}
