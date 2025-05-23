package com.tencent.mobileqq.onlinestatus;

import android.content.Context;
import android.os.Vibrator;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes16.dex */
public class aw extends PagerAdapter implements View.OnClickListener, ViewPager.OnPageChangeListener {
    private int C;
    private boolean D;
    private int E;
    private ViewPager F;
    private ba G;

    /* renamed from: f, reason: collision with root package name */
    private Context f255551f;

    /* renamed from: h, reason: collision with root package name */
    private WeakReference<a> f255552h;

    /* renamed from: m, reason: collision with root package name */
    public Long f255554m;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<au> f255549d = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    public ArrayList<au> f255553i = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    private bd f255550e = new bd();

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface a {
        void Q9(au auVar, View view);

        void g2(au auVar, au auVar2, View view);

        void l3(View view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(Context context, ba baVar, ViewPager viewPager) {
        this.D = false;
        this.f255551f = context;
        this.C = baVar.f255564c * baVar.f255565d;
        this.D = baVar.f255563b;
        this.G = baVar;
        this.F = viewPager;
    }

    private List<au> e(int i3) {
        int i16 = i3 * this.C;
        return this.f255549d.subList(i16, Math.min(this.f255549d.size(), this.C + i16));
    }

    public ArrayList<au> d() {
        return this.f255549d;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
        if (obj instanceof OnlineStatusListLayout) {
            OnlineStatusListLayout onlineStatusListLayout = (OnlineStatusListLayout) obj;
            onlineStatusListLayout.setPageIndex(-1);
            viewGroup.removeView(onlineStatusListLayout);
            this.f255550e.a(i3, (View) obj);
        }
    }

    public a f() {
        WeakReference<a> weakReference = this.f255552h;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public int g() {
        int i3 = 0;
        if (this.D) {
            return 0;
        }
        if (this.f255553i.size() == 1) {
            au auVar = this.f255553i.get(0);
            int i16 = 0;
            while (true) {
                if (i16 >= this.f255549d.size()) {
                    break;
                }
                if (this.f255549d.get(i16).f255489b == auVar.f255489b) {
                    i3 = i16;
                    break;
                }
                i16++;
            }
        }
        return i3 / this.C;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        int i3;
        int size = this.f255549d.size();
        int i16 = this.C;
        int i17 = size / i16;
        if (size % i16 > 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        return i17 + i3;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    public int h(Long l3) {
        if (l3 == null) {
            return -1;
        }
        int i3 = 0;
        while (true) {
            if (i3 < this.f255549d.size()) {
                if (this.f255549d.get(i3).f255489b == l3.longValue()) {
                    break;
                }
                i3++;
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 == -1) {
            return -1;
        }
        return i3 / this.C;
    }

    public void i(ArrayList<au> arrayList) {
        this.f255549d = arrayList;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i3) {
        List<au> e16 = e(i3);
        OnlineStatusListLayout onlineStatusListLayout = (OnlineStatusListLayout) this.f255550e.c(i3);
        if (onlineStatusListLayout == null) {
            onlineStatusListLayout = new OnlineStatusListLayout(this.f255551f);
            onlineStatusListLayout.e(this.G);
            onlineStatusListLayout.setItemWidth(this.E);
            onlineStatusListLayout.setOnClickListener(this);
            onlineStatusListLayout.f(this.C, this);
        }
        onlineStatusListLayout.a(e16, this.f255553i, this.f255554m, this);
        onlineStatusListLayout.setPageIndex(i3);
        if (onlineStatusListLayout.getParent() != viewGroup && i3 < getF373114d()) {
            viewGroup.addView(onlineStatusListLayout);
        }
        return onlineStatusListLayout;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        if (view == obj) {
            return true;
        }
        return false;
    }

    public void j(int i3) {
        this.E = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(a aVar) {
        this.f255552h = new WeakReference<>(aVar);
    }

    public void l(au auVar) {
        com.tencent.mobileqq.config.business.ai a16 = com.tencent.mobileqq.config.business.ak.f202506a.a();
        boolean m3 = a16.m(auVar.f255494g, auVar.f255489b);
        int i3 = 0;
        for (int i16 = 0; i16 < this.f255549d.size(); i16++) {
            au auVar2 = this.f255549d.get(i16);
            long j3 = auVar2.f255489b;
            if (j3 == auVar.f255489b || (m3 && a16.m(auVar2.f255494g, j3))) {
                i3 = i16;
                break;
            }
        }
        this.F.setCurrentItem(i3 / this.C);
    }

    public void m() {
        ViewPager viewPager = this.F;
        if (viewPager == null) {
            return;
        }
        int childCount = viewPager.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.F.getChildAt(i3);
            if (childAt instanceof OnlineStatusListLayout) {
                ((OnlineStatusListLayout) childAt).i();
            }
        }
        int d16 = this.f255550e.d();
        for (int i16 = 0; i16 < d16; i16++) {
            View b16 = this.f255550e.b(i16);
            if (b16 instanceof OnlineStatusListLayout) {
                ((OnlineStatusListLayout) b16).i();
            }
        }
    }

    public void n() {
        int c16;
        if (this.F == null) {
            return;
        }
        int f373114d = getF373114d();
        int childCount = this.F.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            OnlineStatusListLayout onlineStatusListLayout = (OnlineStatusListLayout) this.F.getChildAt(i3);
            if (onlineStatusListLayout != null && (c16 = onlineStatusListLayout.c()) >= 0 && c16 < f373114d) {
                onlineStatusListLayout.a(e(c16), this.f255553i, this.f255554m, this);
            }
        }
    }

    public boolean o(au auVar, View view) {
        a f16 = f();
        au auVar2 = null;
        if (!this.D) {
            if (this.f255553i.size() > 0) {
                auVar2 = this.f255553i.get(0);
            }
            this.f255553i.clear();
            this.f255553i.add(auVar);
            if (f16 != null) {
                f16.g2(auVar2, auVar, view);
            }
            if (auVar != auVar2) {
                return true;
            }
            return false;
        }
        if (this.f255553i.contains(auVar)) {
            this.f255553i.remove(auVar);
            if (f16 != null) {
                f16.g2(auVar, null, view);
            }
        } else {
            this.f255553i.add(auVar);
            if (f16 != null) {
                f16.g2(null, auVar, view);
            }
        }
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Object tag = view.getTag();
        int id5 = view.getId();
        a f16 = f();
        if (view instanceof OnlineStatusListLayout) {
            if (((OnlineStatusListLayout) view).g() && f16 != null) {
                f16.l3(view);
            }
        } else if (tag instanceof au) {
            au auVar = (au) tag;
            Vibrator vibrator = (Vibrator) this.f255551f.getSystemService("vibrator");
            if (vibrator != null) {
                vibrator.vibrate(new long[]{0, 1, 20, 21}, -1);
            }
            if (id5 == R.id.zy6 && f16 != null) {
                f16.Q9(auVar, view);
            } else if (o(auVar, view)) {
                this.G.f255575n = true;
                n();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i3) {
        Iterator<au> it = e(i3).iterator();
        while (it.hasNext()) {
            bv.b("0X800BB58", (int) it.next().f255489b);
        }
    }

    public void p(int i3) {
        ViewPager viewPager = this.F;
        if (viewPager == null) {
            return;
        }
        int childCount = viewPager.getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = this.F.getChildAt(i16);
            if (childAt instanceof OnlineStatusListLayout) {
                ((OnlineStatusListLayout) childAt).j(i3);
            }
        }
        int d16 = this.f255550e.d();
        for (int i17 = 0; i17 < d16; i17++) {
            View b16 = this.f255550e.b(i17);
            if (b16 instanceof OnlineStatusListLayout) {
                ((OnlineStatusListLayout) b16).j(i3);
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i3) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i3, float f16, int i16) {
    }
}
