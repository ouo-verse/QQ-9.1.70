package com.tencent.widget;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes27.dex */
public abstract class OneViewPagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {
    static IPatchRedirector $redirector_;
    private int mPageScrollState;
    ViewPager mViewPager;
    SparseArray<View> mViews;

    public OneViewPagerAdapter(ViewPager viewPager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) viewPager);
            return;
        }
        this.mViews = new SparseArray<>();
        this.mPageScrollState = 0;
        this.mViewPager = viewPager;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, viewGroup, Integer.valueOf(i3), obj);
        } else {
            viewGroup.removeView((View) obj);
            this.mViews.remove(i3);
        }
    }

    public abstract View getView(int i3);

    public abstract void initView(Object obj, int i3);

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup, i3);
        }
        View view = getView(i3);
        if (view == null) {
            view = new FrameLayout(viewGroup.getContext());
        }
        if (((ViewPager) viewGroup).getCurrentItem() == i3) {
            initView(view, i3);
        }
        viewGroup.addView(view);
        this.mViews.put(i3, view);
        return view;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, obj)).booleanValue();
        }
        if (view == obj) {
            return true;
        }
        return false;
    }

    public void loadView(int i3) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else if (i3 < getCount() && (view = this.mViews.get(i3)) != null) {
            initView(view, i3);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i3) {
        View valueAt;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        this.mPageScrollState = i3;
        if (i3 == 0) {
            int currentItem = this.mViewPager.getCurrentItem();
            for (int i16 = 0; i16 < this.mViews.size(); i16++) {
                int keyAt = this.mViews.keyAt(i16);
                if (keyAt != currentItem && (valueAt = this.mViews.valueAt(i16)) != null) {
                    unInitView(valueAt, keyAt);
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i3, float f16, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Float.valueOf(f16), Integer.valueOf(i16));
            return;
        }
        if (this.mPageScrollState == 1) {
            if (i3 < this.mViewPager.getCurrentItem()) {
                loadView(i3);
            } else if (i3 == this.mViewPager.getCurrentItem()) {
                loadView(i3 + 1);
            }
        }
    }

    public void onPageSelected(int i3) {
        View valueAt;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        loadView(i3);
        for (int i16 = 0; i16 < this.mViews.size(); i16++) {
            int keyAt = this.mViews.keyAt(i16);
            if (keyAt != i3 && (valueAt = this.mViews.valueAt(i16)) != null) {
                unInitView(valueAt, keyAt);
            }
        }
    }

    public abstract void unInitView(Object obj, int i3);
}
