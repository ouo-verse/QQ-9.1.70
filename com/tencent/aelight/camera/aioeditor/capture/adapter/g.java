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
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GridView;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes32.dex */
public class g extends PagerAdapter {

    /* renamed from: d, reason: collision with root package name */
    private Context f66660d;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<FilterCategory> f66661e;

    /* renamed from: f, reason: collision with root package name */
    public SparseArray<GridView> f66662f = new SparseArray<>();

    /* renamed from: h, reason: collision with root package name */
    private AdapterView.OnItemClickListener f66663h;

    /* renamed from: i, reason: collision with root package name */
    public int f66664i;

    /* renamed from: m, reason: collision with root package name */
    public static final int f66659m = ViewUtils.dpToPx(7.0f);
    public static final int C = ViewUtils.dpToPx(0.0f);

    public g(Context context, int i3) {
        this.f66660d = context;
        this.f66664i = i3;
    }

    public void d(AdapterView.OnItemClickListener onItemClickListener) {
        this.f66663h = onItemClickListener;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
        viewGroup.removeView(this.f66662f.get(i3));
    }

    public void e(ArrayList<FilterCategory> arrayList) {
        this.f66661e = arrayList;
    }

    public void f() {
        if (this.f66662f != null) {
            for (int i3 = 0; i3 < this.f66662f.size(); i3++) {
                GridView valueAt = this.f66662f.valueAt(i3);
                if (valueAt != null && (valueAt.getAdapter() instanceof f)) {
                    ((f) valueAt.getAdapter()).e();
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        ArrayList<FilterCategory> arrayList = this.f66661e;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("TransitionProviderPagerAdapter", 2, "instantiateItem position = " + i3);
        }
        GridView gridView = this.f66662f.get(i3);
        if (gridView == null) {
            gridView = new GridView(this.f66660d);
            gridView.setNumColumns(3);
            gridView.setSelector(new ColorDrawable(0));
            int i16 = C;
            gridView.setVerticalSpacing(i16);
            gridView.setHorizontalSpacing(i16);
            gridView.setClipToPadding(false);
            int i17 = f66659m;
            gridView.setPadding(i17, i17, i17, i17 + i17 + BaseAIOUtils.f(36.0f, this.f66660d.getResources()));
            gridView.setVerticalScrollBarEnabled(false);
            f fVar = new f(this.f66660d, this.f66664i);
            fVar.setData(this.f66661e.get(i3).f66687f);
            gridView.setAdapter((ListAdapter) fVar);
            gridView.setOnItemClickListener(this.f66663h);
            this.f66662f.put(i3, gridView);
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

    public void onDestroy() {
        if (this.f66662f != null) {
            for (int i3 = 0; i3 < this.f66662f.size(); i3++) {
                GridView valueAt = this.f66662f.valueAt(i3);
                if (valueAt != null && (valueAt.getAdapter() instanceof f)) {
                    ((f) valueAt.getAdapter()).b();
                }
            }
        }
    }
}
