package com.tencent.av.ui.funchat.filter;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.qphone.base.util.QLog;

@TargetApi(9)
/* loaded from: classes3.dex */
public class EffectCycleViewPager extends ViewPager {

    /* renamed from: d, reason: collision with root package name */
    protected b f75778d;

    /* renamed from: e, reason: collision with root package name */
    SparseArray<View> f75779e;

    /* loaded from: classes3.dex */
    private class a implements ViewPager.OnPageChangeListener {

        /* renamed from: d, reason: collision with root package name */
        private ViewPager.OnPageChangeListener f75780d;

        /* renamed from: e, reason: collision with root package name */
        private int f75781e;

        public a(ViewPager.OnPageChangeListener onPageChangeListener, int i3) {
            this.f75780d = onPageChangeListener;
            this.f75781e = i3;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
            b bVar;
            if (i3 == 0 && (bVar = EffectCycleViewPager.this.f75778d) != null) {
                if (this.f75781e == bVar.getF373114d() - 1) {
                    AVCoreLog.printColorLog("EffectCycleViewPager", "onPageScrollStateChanged 00:1");
                    EffectCycleViewPager.this.setCurrentItem(1, false);
                } else if (this.f75781e == 0) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("onPageScrollStateChanged 11:");
                    sb5.append(EffectCycleViewPager.this.f75778d.getF373114d() - 2);
                    AVCoreLog.printColorLog("EffectCycleViewPager", sb5.toString());
                    EffectCycleViewPager.this.setCurrentItem(r0.f75778d.getF373114d() - 2, false);
                }
            }
            ViewPager.OnPageChangeListener onPageChangeListener = this.f75780d;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrollStateChanged(i3);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
            ViewPager.OnPageChangeListener onPageChangeListener = this.f75780d;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrolled(i3, f16, i16);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            b bVar;
            boolean z16;
            this.f75781e = i3;
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onPageSelected, pos[");
                sb5.append(i3);
                sb5.append("], mSelectListener[");
                if (this.f75780d != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb5.append(z16);
                sb5.append("]");
                QLog.w("EffectCycleViewPager", 1, sb5.toString());
            }
            if (this.f75780d != null && (bVar = EffectCycleViewPager.this.f75778d) != null) {
                this.f75780d.onPageSelected(bVar.d(i3));
            }
        }
    }

    /* loaded from: classes3.dex */
    class b extends PagerAdapter {

        /* renamed from: d, reason: collision with root package name */
        private PagerAdapter f75783d;

        /* loaded from: classes3.dex */
        class a extends DataSetObserver {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ EffectCycleViewPager f75785a;

            a(EffectCycleViewPager effectCycleViewPager) {
                this.f75785a = effectCycleViewPager;
            }

            @Override // android.database.DataSetObserver
            public void onChanged() {
                b.this.notifyDataSetChanged();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                b.this.notifyDataSetChanged();
            }
        }

        public b(PagerAdapter pagerAdapter) {
            this.f75783d = pagerAdapter;
            pagerAdapter.registerDataSetObserver(new a(EffectCycleViewPager.this));
        }

        int d(int i3) {
            if (i3 == 0) {
                return this.f75783d.getF373114d() - 1;
            }
            if (i3 == this.f75783d.getF373114d() + 1) {
                return 0;
            }
            return i3 - 1;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
            int d16 = d(i3);
            EffectCycleViewPager.this.f75779e.remove(i3);
            this.f75783d.destroyItem(viewGroup, d16, obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount */
        public int getF373114d() {
            int f373114d = this.f75783d.getF373114d();
            if (f373114d > 0) {
                return f373114d + 2;
            }
            return 0;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i3) {
            View view = (View) this.f75783d.instantiateItem(viewGroup, d(i3));
            EffectCycleViewPager.this.f75779e.put(i3, view);
            return view;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return this.f75783d.isViewFromObject(view, obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void notifyDataSetChanged() {
            EffectCycleViewPager.this.setCurrentItem(1);
            super.notifyDataSetChanged();
        }
    }

    public EffectCycleViewPager(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View a() {
        return this.f75779e.get(getCurrentItem());
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setAdapter(PagerAdapter pagerAdapter) {
        if (pagerAdapter == null) {
            return;
        }
        b bVar = new b(pagerAdapter);
        this.f75778d = bVar;
        super.setAdapter(bVar);
        setCurrentItem(1);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        super.setOnPageChangeListener(new a(onPageChangeListener, getCurrentItem()));
    }

    public EffectCycleViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f75779e = new SparseArray<>();
    }
}
