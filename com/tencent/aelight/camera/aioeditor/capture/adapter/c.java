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
public class c extends PagerAdapter {

    /* renamed from: d, reason: collision with root package name */
    private Context f66621d;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<FilterCategory> f66622e;

    /* renamed from: f, reason: collision with root package name */
    public SparseArray<GridView> f66623f = new SparseArray<>();

    /* renamed from: h, reason: collision with root package name */
    private AdapterView.OnItemClickListener f66624h;

    /* renamed from: i, reason: collision with root package name */
    public int f66625i;

    /* renamed from: m, reason: collision with root package name */
    public static final int f66620m = BaseAIOUtils.f(7.0f, BaseApplication.getContext().getResources());
    public static final int C = BaseAIOUtils.f(0.0f, BaseApplication.getContext().getResources());

    public c(Context context, int i3) {
        this.f66621d = context;
        this.f66625i = i3;
    }

    public void d(AdapterView.OnItemClickListener onItemClickListener) {
        this.f66624h = onItemClickListener;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
        viewGroup.removeView(this.f66623f.get(i3));
    }

    public void e(ArrayList<FilterCategory> arrayList) {
        this.f66622e = arrayList;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        return this.f66622e.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("FilterProviderView", 2, "instantiateItem position = " + i3);
        }
        GridView gridView = this.f66623f.get(i3);
        if (gridView == null) {
            gridView = new GridView(this.f66621d);
            gridView.setNumColumns(4);
            gridView.setSelector(new ColorDrawable(0));
            int i16 = C;
            gridView.setVerticalSpacing(i16);
            gridView.setHorizontalSpacing(i16);
            gridView.setClipToPadding(false);
            int i17 = f66620m;
            gridView.setPadding(i17, i17, i17, i17 + i17 + BaseAIOUtils.f(36.0f, this.f66621d.getResources()));
            gridView.setVerticalScrollBarEnabled(false);
            b bVar = new b(this.f66621d, this.f66625i);
            bVar.setData(this.f66622e.get(i3).f66687f);
            gridView.setAdapter((ListAdapter) bVar);
            gridView.setOnItemClickListener(this.f66624h);
            this.f66623f.put(i3, gridView);
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
