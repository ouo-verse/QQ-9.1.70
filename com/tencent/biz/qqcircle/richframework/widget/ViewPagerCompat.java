package com.tencent.biz.qqcircle.richframework.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class ViewPagerCompat extends ViewPager {
    private List<a> mAdapterChangeListeners;
    private boolean mIsScrollable;
    private List<ViewPager.OnPageChangeListener> mOnPageChangeListeners;
    private b mPageChangeListener;

    /* loaded from: classes5.dex */
    public interface a {
        void onAdapterChanged(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class b implements ViewPager.OnPageChangeListener {
        b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
            if (ViewPagerCompat.this.mOnPageChangeListeners != null) {
                Iterator it = ViewPagerCompat.this.mOnPageChangeListeners.iterator();
                while (it.hasNext()) {
                    ((ViewPager.OnPageChangeListener) it.next()).onPageScrollStateChanged(i3);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
            if (ViewPagerCompat.this.mOnPageChangeListeners != null) {
                Iterator it = ViewPagerCompat.this.mOnPageChangeListeners.iterator();
                while (it.hasNext()) {
                    ((ViewPager.OnPageChangeListener) it.next()).onPageScrolled(i3, f16, i16);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            if (ViewPagerCompat.this.mOnPageChangeListeners != null) {
                Iterator it = ViewPagerCompat.this.mOnPageChangeListeners.iterator();
                while (it.hasNext()) {
                    ((ViewPager.OnPageChangeListener) it.next()).onPageSelected(i3);
                }
            }
        }
    }

    public ViewPagerCompat(Context context) {
        super(context);
        this.mIsScrollable = true;
        setupListener();
    }

    private void setupListener() {
        b bVar = new b();
        this.mPageChangeListener = bVar;
        super.setOnPageChangeListener(bVar);
    }

    public void addOnAdapterChangeListener(a aVar) {
        if (this.mAdapterChangeListeners == null) {
            this.mAdapterChangeListeners = new ArrayList();
        }
        this.mAdapterChangeListeners.add(aVar);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void addOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.mOnPageChangeListeners == null) {
            this.mOnPageChangeListeners = new ArrayList();
        }
        this.mOnPageChangeListeners.add(onPageChangeListener);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void clearOnPageChangeListeners() {
        List<ViewPager.OnPageChangeListener> list = this.mOnPageChangeListeners;
        if (list != null) {
            list.clear();
        }
    }

    public boolean getScrollable() {
        return this.mIsScrollable;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.mIsScrollable) {
            try {
                return super.onInterceptTouchEvent(motionEvent);
            } catch (IllegalArgumentException e16) {
                e16.printStackTrace();
                return false;
            }
        }
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mIsScrollable) {
            try {
                return super.onTouchEvent(motionEvent);
            } catch (IllegalArgumentException e16) {
                e16.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public void removeOnAdapterChangeListener(a aVar) {
        List<a> list = this.mAdapterChangeListeners;
        if (list != null) {
            list.remove(aVar);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void removeOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        List<ViewPager.OnPageChangeListener> list = this.mOnPageChangeListeners;
        if (list != null) {
            list.remove(onPageChangeListener);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setAdapter(PagerAdapter pagerAdapter) {
        PagerAdapter adapter = getAdapter();
        super.setAdapter(pagerAdapter);
        List<a> list = this.mAdapterChangeListeners;
        if (list != null && !list.isEmpty()) {
            int size = this.mAdapterChangeListeners.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.mAdapterChangeListeners.get(i3).onAdapterChanged(this, adapter, pagerAdapter);
            }
        }
    }

    public void setScrollable(boolean z16) {
        this.mIsScrollable = z16;
    }

    public ViewPagerCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsScrollable = true;
        setupListener();
    }

    @Override // androidx.viewpager.widget.ViewPager
    @Deprecated
    public final void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
    }
}
