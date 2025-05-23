package com.tencent.aelight.camera.aioeditor.capture.adapter;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.aelight.camera.aioeditor.capture.data.i;
import com.tencent.aelight.camera.aioeditor.capture.view.MusicProviderView;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GridView;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class e extends PagerAdapter {
    public static final int C = BaseAIOUtils.f(7.0f, BaseApplication.getContext().getResources());
    public static final int D = BaseAIOUtils.f(0.0f, BaseApplication.getContext().getResources());

    /* renamed from: e, reason: collision with root package name */
    private Context f66643e;

    /* renamed from: f, reason: collision with root package name */
    private List<i> f66644f;

    /* renamed from: i, reason: collision with root package name */
    private AdapterView.OnItemClickListener f66646i;

    /* renamed from: m, reason: collision with root package name */
    MusicProviderView f66647m;

    /* renamed from: d, reason: collision with root package name */
    Drawable f66642d = new ColorDrawable(0);

    /* renamed from: h, reason: collision with root package name */
    private SparseArray<GridView> f66645h = new SparseArray<>();

    public e(Context context, MusicProviderView musicProviderView) {
        this.f66643e = context;
        this.f66647m = musicProviderView;
    }

    public GridView d(int i3) {
        return this.f66645h.get(this.f66645h.keyAt(i3));
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
        viewGroup.removeView(this.f66645h.get(i3));
    }

    public GridView e(int i3) {
        return this.f66645h.get(i3);
    }

    public int f() {
        return this.f66645h.size();
    }

    public void g(AdapterView.OnItemClickListener onItemClickListener) {
        this.f66646i = onItemClickListener;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        return this.f66644f.size();
    }

    public void h(List<i> list) {
        this.f66644f = list;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i3) {
        d dVar;
        if (QLog.isColorLevel()) {
            QLog.d("MusicProviderView", 2, "instantiateItem position = " + i3);
        }
        GridView gridView = this.f66645h.get(i3);
        if (gridView == null) {
            gridView = new GridView(this.f66643e);
            gridView.setNumColumns(4);
            gridView.setSelector(this.f66642d);
            int i16 = D;
            gridView.setVerticalSpacing(i16);
            gridView.setHorizontalSpacing(i16);
            gridView.setVerticalScrollBarEnabled(false);
            int i17 = C;
            gridView.setPadding(i17, i17, i17, (i17 * 2) + BaseAIOUtils.f(36.0f, this.f66643e.getResources()));
            gridView.setClipToPadding(false);
            dVar = new d(this.f66643e, this.f66647m);
            gridView.setOnItemClickListener(this.f66646i);
            this.f66645h.put(i3, gridView);
        } else {
            dVar = (d) gridView.getAdapter();
        }
        dVar.setData(this.f66644f.get(i3).f66743h);
        gridView.setAdapter((ListAdapter) dVar);
        MusicProviderView musicProviderView = this.f66647m;
        if (musicProviderView.W == i3) {
            gridView.setSelection(musicProviderView.f67249a0);
            MusicProviderView musicProviderView2 = this.f66647m;
            musicProviderView2.W = -1;
            musicProviderView2.f67249a0 = -1;
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
