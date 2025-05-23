package com.tencent.biz.subscribe.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SubscribeBannerView extends BaseWidgetView {
    private static int H = ImmersiveUtils.dpToPx(20.0f);
    private b E;
    private DotsIndicator F;
    private ViewPager G;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class DotsIndicator extends LinearLayout {

        /* renamed from: d, reason: collision with root package name */
        public int f96403d;

        /* renamed from: e, reason: collision with root package name */
        public int f96404e;

        /* renamed from: f, reason: collision with root package name */
        public int f96405f;

        /* renamed from: h, reason: collision with root package name */
        public int f96406h;

        public DotsIndicator(Context context) {
            super(context);
            this.f96403d = R.drawable.hbh;
            b();
        }

        private void b() {
            this.f96404e = BaseAIOUtils.f(10.0f, getResources());
            this.f96405f = BaseAIOUtils.f(7.0f, getResources());
            this.f96406h = BaseAIOUtils.f(7.0f, getResources());
            setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        }

        public void a(int i3) {
            if (i3 > 1) {
                for (int i16 = 0; i16 < i3; i16++) {
                    View view = new View(getContext());
                    view.setBackgroundResource(this.f96403d);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f96405f, this.f96406h);
                    layoutParams.setMargins(this.f96404e, 0, 0, 0);
                    view.setLayoutParams(layoutParams);
                    addView(view);
                }
            }
        }

        public void setDotsSelected(int i3) {
            if (i3 >= 0 && i3 < getChildCount()) {
                for (int i16 = 0; i16 < getChildCount(); i16++) {
                    View childAt = getChildAt(i16);
                    if (i16 == i3) {
                        childAt.setSelected(true);
                    } else {
                        childAt.setSelected(false);
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static abstract class b extends PagerAdapter {

        /* renamed from: d, reason: collision with root package name */
        private final ArrayList f96408d = new ArrayList();

        /* renamed from: e, reason: collision with root package name */
        private final LinkedList<View> f96409e = new LinkedList<>();

        /* renamed from: f, reason: collision with root package name */
        private int f96410f;

        protected abstract View d(View view, Object obj);

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
            View view = (View) obj;
            viewGroup.removeView(view);
            this.f96409e.add(view);
        }

        protected abstract View e(ViewGroup viewGroup);

        public ArrayList f() {
            return this.f96408d;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public View instantiateItem(ViewGroup viewGroup, int i3) {
            Object obj;
            View e16;
            if (this.f96408d.size() > 1) {
                ArrayList arrayList = this.f96408d;
                obj = arrayList.get(i3 % arrayList.size());
            } else {
                obj = this.f96408d.get(0);
            }
            if (this.f96409e.size() > 0) {
                e16 = this.f96409e.removeFirst();
            } else {
                e16 = e(viewGroup);
            }
            viewGroup.addView(e16);
            return d(e16, obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount */
        public int getF373114d() {
            if (this.f96408d.size() > 1) {
                return Integer.MAX_VALUE;
            }
            return this.f96408d.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            int i3 = this.f96410f;
            if (i3 > 0) {
                this.f96410f = i3 - 1;
                return -2;
            }
            return super.getItemPosition(obj);
        }

        public void h(ArrayList arrayList) {
            this.f96408d.clear();
            notifyDataSetChanged();
            if (arrayList != null) {
                this.f96408d.addAll(arrayList);
                notifyDataSetChanged();
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            if (view == obj) {
                return true;
            }
            return false;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void notifyDataSetChanged() {
            this.f96410f = getF373114d();
            super.notifyDataSetChanged();
        }
    }

    public SubscribeBannerView(@NonNull Context context) {
        super(context);
    }

    private void u(FrameLayout frameLayout) {
        this.F = new DotsIndicator(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        addView(this.F, layoutParams);
    }

    public void destroy() {
        b bVar = this.E;
        if (bVar != null) {
            bVar.f().clear();
        }
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    protected int i() {
        return 0;
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    protected void p(Context context, View view) {
        this.G = new ViewPager(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.bottomMargin = H;
        this.G.setLayoutParams(layoutParams);
        this.G.setOffscreenPageLimit(3);
        this.G.setOnPageChangeListener(new a());
        FrameLayout frameLayout = (FrameLayout) view;
        frameLayout.addView(this.G);
        u(frameLayout);
    }

    public void setAdapter(b bVar) {
        this.E = bVar;
        ViewPager viewPager = this.G;
        if (viewPager != null) {
            viewPager.setAdapter(bVar);
        }
    }

    public void setBannerHeight(int i3) {
        if (getLayoutParams() != null) {
            getLayoutParams().height = i3 + H;
            requestLayout();
        }
    }

    public void setDatas(List list) {
        b bVar = this.E;
        if (bVar != null) {
            bVar.h((ArrayList) list);
        }
        DotsIndicator dotsIndicator = this.F;
        if (dotsIndicator != null) {
            dotsIndicator.removeAllViews();
            if (list != null && list.size() > 0) {
                this.F.a(list.size());
                this.F.setDotsSelected(0);
            }
        }
    }

    public SubscribeBannerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements ViewPager.OnPageChangeListener {
        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            if (SubscribeBannerView.this.F != null && SubscribeBannerView.this.E != null) {
                SubscribeBannerView.this.F.setDotsSelected(i3 % SubscribeBannerView.this.E.f().size());
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
        }
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    protected void c(Object obj) {
    }
}
