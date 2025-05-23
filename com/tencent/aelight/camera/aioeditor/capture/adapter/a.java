package com.tencent.aelight.camera.aioeditor.capture.adapter;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.aelight.camera.aioeditor.capture.data.FilterCategory;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GridView;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a extends PagerAdapter {

    /* renamed from: d, reason: collision with root package name */
    private Context f66609d;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<FilterCategory> f66610e;

    /* renamed from: f, reason: collision with root package name */
    public SparseArray<GridView> f66611f = new SparseArray<>();

    /* renamed from: h, reason: collision with root package name */
    private AdapterView.OnItemClickListener f66612h;

    /* renamed from: i, reason: collision with root package name */
    int f66613i;

    /* renamed from: m, reason: collision with root package name */
    public static final int f66608m = BaseAIOUtils.f(7.0f, BaseApplication.getContext().getResources());
    public static final int C = BaseAIOUtils.f(0.0f, BaseApplication.getContext().getResources());

    public a(Context context, int i3) {
        this.f66613i = i3;
        this.f66609d = context;
    }

    public GridView d(int i3) {
        return this.f66611f.get(i3);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
        viewGroup.removeView(this.f66611f.get(i3));
    }

    public void e(AdapterView.OnItemClickListener onItemClickListener) {
        this.f66612h = onItemClickListener;
    }

    public void f(ArrayList<FilterCategory> arrayList) {
        this.f66610e = arrayList;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        return this.f66610e.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("ComboProviderView", 2, "instantiateItem position = " + i3);
        }
        GridView gridView = this.f66611f.get(i3);
        if (gridView == null) {
            gridView = new GridView(this.f66609d);
            gridView.setNumColumns(3);
            gridView.setSelector(new ColorDrawable(0));
            int i16 = C;
            gridView.setVerticalSpacing(i16);
            gridView.setHorizontalSpacing(i16);
            gridView.setClipToPadding(false);
            int i17 = f66608m;
            gridView.setPadding(i17, i17, i17, BaseAIOUtils.f(36.0f, this.f66609d.getResources()) + i17);
            gridView.setVerticalScrollBarEnabled(false);
            ComboProviderGridAdapter comboProviderGridAdapter = new ComboProviderGridAdapter(this.f66609d, this.f66613i);
            comboProviderGridAdapter.f66599f = gridView;
            comboProviderGridAdapter.setData(this.f66610e.get(i3).f66687f);
            gridView.setAdapter((ListAdapter) comboProviderGridAdapter);
            comboProviderGridAdapter.b(this.f66610e.get(i3).f66685d);
            gridView.setOnItemClickListener(this.f66612h);
            this.f66611f.put(i3, gridView);
        }
        viewGroup.addView(gridView, -1, -1);
        return gridView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        if (view == obj) {
            return true;
        }
        return false;
    }
}
