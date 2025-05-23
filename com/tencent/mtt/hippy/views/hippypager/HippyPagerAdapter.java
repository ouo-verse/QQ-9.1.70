package com.tencent.mtt.hippy.views.hippypager;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mtt.hippy.views.viewpager.HippyViewPagerItem;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes20.dex */
public class HippyPagerAdapter extends PagerAdapter {
    protected final HippyPager viewPager;
    protected final List<View> views = new ArrayList();
    private int childSize = 0;
    private Object currentItemObj = null;

    public HippyPagerAdapter(HippyPager hippyPager) {
        this.viewPager = hippyPager;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addView(HippyViewPagerItem hippyViewPagerItem, int i3) {
        if (hippyViewPagerItem != null && i3 >= 0) {
            if (i3 >= this.views.size()) {
                this.views.add(hippyViewPagerItem);
            } else {
                this.views.add(i3, hippyViewPagerItem);
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
        if (obj instanceof View) {
            View view = (View) obj;
            view.layout(0, 0, 0, 0);
            viewGroup.removeView(view);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        return this.childSize;
    }

    public Object getCurrentItemObj() {
        return this.currentItemObj;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        int indexOf;
        if (this.views.isEmpty() || (indexOf = this.views.indexOf(obj)) < 0) {
            return -2;
        }
        return indexOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getItemViewSize() {
        return this.views.size();
    }

    protected View getPageItemView(int i3) {
        View view;
        if (i3 >= 0 && i3 < this.views.size()) {
            view = this.views.get(i3);
        } else {
            view = null;
        }
        if (view != null) {
            return view;
        }
        throw new NullPointerException("Can not instantiateItem,position:" + i3 + ",size:" + this.views.size());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getViewAt(int i3) {
        if (i3 >= 0 && i3 < this.views.size()) {
            return this.views.get(i3);
        }
        return null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(ViewGroup viewGroup, int i3) {
        View pageItemView = getPageItemView(i3);
        if (pageItemView.getParent() == null) {
            viewGroup.addView(pageItemView, new ViewPager.LayoutParams());
            this.viewPager.triggerRequestLayout();
        }
        return pageItemView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        if (view == obj) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void removeView(View view) {
        int size = this.views.size();
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
            this.views.remove(i3);
        }
    }

    public void setChildSize(int i3) {
        this.childSize = i3;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i3, @NonNull Object obj) {
        super.setPrimaryItem(viewGroup, i3, obj);
        this.currentItemObj = obj;
    }
}
