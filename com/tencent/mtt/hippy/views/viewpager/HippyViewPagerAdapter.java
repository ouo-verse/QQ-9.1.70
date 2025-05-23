package com.tencent.mtt.hippy.views.viewpager;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.supportui.views.viewpager.ViewPager;
import com.tencent.mtt.supportui.views.viewpager.ViewPagerAdapter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes20.dex */
public class HippyViewPagerAdapter extends ViewPagerAdapter {
    private static final String TAG = "HippyViewPagerAdapter";
    protected final HippyViewPager mViewPager;
    protected final List<View> mViews = new ArrayList();
    private int mChildSize = 0;
    private int mInitPageIndex = 0;

    public HippyViewPagerAdapter(HippyInstanceContext hippyInstanceContext, HippyViewPager hippyViewPager) {
        this.mViewPager = hippyViewPager;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addView(HippyViewPagerItem hippyViewPagerItem, int i3) {
        if (hippyViewPagerItem != null && i3 >= 0) {
            if (i3 >= this.mViews.size()) {
                this.mViews.add(hippyViewPagerItem);
            } else {
                this.mViews.add(i3, hippyViewPagerItem);
            }
        }
    }

    @Override // com.tencent.mtt.supportui.views.viewpager.ViewPagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
        if (obj instanceof View) {
            View view = (View) obj;
            view.layout(0, 0, 0, 0);
            viewGroup.removeView(view);
        }
    }

    @Override // com.tencent.mtt.supportui.views.viewpager.ViewPagerAdapter
    public int getCount() {
        return this.mChildSize;
    }

    @Override // com.tencent.mtt.supportui.views.viewpager.ViewPagerAdapter
    public int getInitialItemIndex() {
        return this.mInitPageIndex;
    }

    @Override // com.tencent.mtt.supportui.views.viewpager.ViewPagerAdapter
    public int getItemPosition(Object obj) {
        int indexOf;
        if (this.mViews.isEmpty() || (indexOf = this.mViews.indexOf(obj)) < 0) {
            return -2;
        }
        return indexOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getItemViewSize() {
        return this.mViews.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getViewAt(int i3) {
        if (i3 >= 0 && i3 < this.mViews.size()) {
            return this.mViews.get(i3);
        }
        return null;
    }

    @Override // com.tencent.mtt.supportui.views.viewpager.ViewPagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i3) {
        View view;
        if (i3 < this.mViews.size()) {
            view = this.mViews.get(i3);
        } else {
            view = null;
        }
        if (view == null || view.getParent() != null) {
            return null;
        }
        viewGroup.addView(view, new ViewPager.LayoutParams());
        this.mViewPager.triggerRequestLayout();
        return view;
    }

    @Override // com.tencent.mtt.supportui.views.viewpager.ViewPagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        if (view == obj) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void removeView(View view) {
        int size = this.mViews.size();
        int i3 = 0;
        while (true) {
            if (i3 < size) {
                if (getViewAt(i3) == view) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 >= 0) {
            this.mViews.remove(i3);
        }
    }

    protected void removeViewAtIndex(int i3) {
        if (i3 >= 0 && i3 < this.mViews.size()) {
            this.mViews.remove(i3);
        }
    }

    public void setChildSize(int i3) {
        this.mChildSize = i3;
    }

    public void setInitPageIndex(int i3) {
        this.mInitPageIndex = i3;
    }
}
