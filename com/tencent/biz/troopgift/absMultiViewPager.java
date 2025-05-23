package com.tencent.biz.troopgift;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public abstract class absMultiViewPager extends ViewPager implements AdapterView.OnItemClickListener {
    protected ViewPager.OnPageChangeListener C;

    /* renamed from: d, reason: collision with root package name */
    protected ArrayList<Object> f96914d;

    /* renamed from: e, reason: collision with root package name */
    protected ArrayList<View> f96915e;

    /* renamed from: f, reason: collision with root package name */
    protected b f96916f;

    /* renamed from: h, reason: collision with root package name */
    protected AdapterView.OnItemClickListener f96917h;

    /* renamed from: i, reason: collision with root package name */
    protected int f96918i;

    /* renamed from: m, reason: collision with root package name */
    protected a f96919m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public interface a {
        void a(int i3, int i16, int i17);
    }

    /* loaded from: classes5.dex */
    public static class b extends PagerAdapter {

        /* renamed from: d, reason: collision with root package name */
        protected ArrayList<View> f96920d = new ArrayList<>();

        public void d(ArrayList<View> arrayList) {
            this.f96920d = arrayList;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
            viewGroup.removeView(this.f96920d.get(i3));
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.f96920d.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i3) {
            viewGroup.addView(this.f96920d.get(i3));
            return this.f96920d.get(i3);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            if (view == ((View) obj)) {
                return true;
            }
            return false;
        }
    }

    public absMultiViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f96914d = new ArrayList<>();
        this.f96915e = new ArrayList<>();
    }

    public static ArrayList<Object> h(ArrayList<Object> arrayList, int i3, int i16) {
        if (i3 <= arrayList.size() && i16 <= arrayList.size()) {
            ArrayList<Object> arrayList2 = new ArrayList<>();
            while (i3 < i16) {
                arrayList2.add(arrayList.get(i3));
                i3++;
            }
            return arrayList2;
        }
        throw new IndexOutOfBoundsException("subArrayList exception, start or end is large than src list size. src size:" + arrayList.size() + ", start:" + i3 + ", end:" + i16);
    }

    public abstract View a(int i3);

    public abstract int b();

    protected void c(int i3, int i16) {
        a aVar = this.f96919m;
        if (aVar != null) {
            aVar.a(i3, i16, getCurrentItem());
        }
    }

    public void g() {
        b bVar = new b();
        this.f96916f = bVar;
        setAdapter(bVar);
        this.f96915e.clear();
        int b16 = b();
        int i3 = this.f96918i;
        if (i3 != b16) {
            c(i3, b16);
            this.f96918i = b16;
        }
        for (int i16 = 0; i16 < b16; i16++) {
            this.f96915e.add(a(i16));
        }
        this.f96916f.d(this.f96915e);
        this.f96916f.notifyDataSetChanged();
        ViewPager.OnPageChangeListener onPageChangeListener = this.C;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(0);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
        AdapterView.OnItemClickListener onItemClickListener = this.f96917h;
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(adapterView, view, i3, j3);
        }
        EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
    }

    public void setData(ArrayList<Object> arrayList) {
        this.f96914d = arrayList;
        g();
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.f96917h = onItemClickListener;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.C = onPageChangeListener;
        super.setOnPageChangeListener(onPageChangeListener);
    }

    public void setOnPagerSizeChangeListener(a aVar) {
        this.f96919m = aVar;
    }

    public absMultiViewPager(Context context) {
        this(context, null);
    }
}
