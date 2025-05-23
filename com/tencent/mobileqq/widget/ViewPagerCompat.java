package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes20.dex */
public class ViewPagerCompat extends ViewPager {

    /* renamed from: d, reason: collision with root package name */
    private List<ViewPager.OnPageChangeListener> f316516d;

    /* renamed from: e, reason: collision with root package name */
    private List<a> f316517e;

    /* renamed from: f, reason: collision with root package name */
    private b f316518f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f316519h;

    /* loaded from: classes20.dex */
    public interface a {
        void onAdapterChanged(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public class b implements ViewPager.OnPageChangeListener {
        b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
            if (ViewPagerCompat.this.f316516d != null) {
                Iterator it = ViewPagerCompat.this.f316516d.iterator();
                while (it.hasNext()) {
                    ((ViewPager.OnPageChangeListener) it.next()).onPageScrollStateChanged(i3);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
            if (ViewPagerCompat.this.f316516d != null) {
                Iterator it = ViewPagerCompat.this.f316516d.iterator();
                while (it.hasNext()) {
                    ((ViewPager.OnPageChangeListener) it.next()).onPageScrolled(i3, f16, i16);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            if (ViewPagerCompat.this.f316516d != null) {
                Iterator it = ViewPagerCompat.this.f316516d.iterator();
                while (it.hasNext()) {
                    ((ViewPager.OnPageChangeListener) it.next()).onPageSelected(i3);
                }
            }
        }
    }

    public ViewPagerCompat(Context context) {
        super(context);
        this.f316519h = true;
        setupListener();
    }

    private void setupListener() {
        b bVar = new b();
        this.f316518f = bVar;
        super.setOnPageChangeListener(bVar);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void addOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.f316516d == null) {
            this.f316516d = new ArrayList();
        }
        this.f316516d.add(onPageChangeListener);
    }

    public void b(a aVar) {
        if (this.f316517e == null) {
            this.f316517e = new ArrayList();
        }
        this.f316517e.add(aVar);
    }

    public void c(a aVar) {
        List<a> list = this.f316517e;
        if (list != null) {
            list.remove(aVar);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void clearOnPageChangeListeners() {
        List<ViewPager.OnPageChangeListener> list = this.f316516d;
        if (list != null) {
            list.clear();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f316519h) {
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
        if (this.f316519h) {
            try {
                return super.onTouchEvent(motionEvent);
            } catch (IllegalArgumentException e16) {
                e16.printStackTrace();
                return false;
            }
        }
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void removeOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        List<ViewPager.OnPageChangeListener> list = this.f316516d;
        if (list != null) {
            list.remove(onPageChangeListener);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setAdapter(PagerAdapter pagerAdapter) {
        PagerAdapter adapter = getAdapter();
        super.setAdapter(pagerAdapter);
        List<a> list = this.f316517e;
        if (list != null && !list.isEmpty()) {
            int size = this.f316517e.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.f316517e.get(i3).onAdapterChanged(this, adapter, pagerAdapter);
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager
    @Deprecated
    public final void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        QLog.e("ViewPagerCompat", 2, "ViewPagerCompat#setOnPageChangeListener had been deprecated !", new IllegalAccessException("call addOnPageChangeListener instead !"));
    }

    public void setScrollable(boolean z16) {
        this.f316519h = z16;
    }

    public ViewPagerCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f316519h = true;
        setupListener();
    }
}
