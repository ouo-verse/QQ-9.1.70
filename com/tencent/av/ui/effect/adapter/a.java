package com.tencent.av.ui.effect.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.effect.toolbar.newversion.InteractiveToolbar;
import com.tencent.av.ui.effect.view.MaterialRecyclerView;
import com.tencent.common.app.AppInterface;
import iw.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a extends PagerAdapter {
    private b C;
    private int D;
    private iw.a E;

    /* renamed from: d, reason: collision with root package name */
    private AppInterface f75544d;

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<Context> f75545e;

    /* renamed from: f, reason: collision with root package name */
    private hu.a f75546f;

    /* renamed from: h, reason: collision with root package name */
    private int f75547h;

    /* renamed from: i, reason: collision with root package name */
    private List<hw.a> f75548i;

    /* renamed from: m, reason: collision with root package name */
    public HashMap<Integer, MaterialRecyclerView> f75549m = new HashMap<>();

    public a(Context context, AppInterface appInterface, int i3) {
        this.f75545e = new WeakReference<>(context);
        this.f75544d = appInterface;
        this.f75547h = i3;
        this.f75546f = (hu.a) ((VideoAppInterface) appInterface).B(15);
    }

    private void d(MaterialAdapter materialAdapter, int i3, String str) {
        if (f(this.f75547h, str) == 1) {
            this.f75546f.l(materialAdapter, 1);
            if (i3 == 0) {
                this.f75546f.l(materialAdapter, 2);
                return;
            }
            return;
        }
        if (f(this.f75547h, str) == 202) {
            this.f75546f.l(materialAdapter, 4);
            return;
        }
        if (f(this.f75547h, str) == 3) {
            this.f75546f.l(materialAdapter, 6);
        } else if (f(this.f75547h, str) == 4) {
            this.f75546f.l(materialAdapter, 7);
        } else if (f(this.f75547h, str) == 5) {
            this.f75546f.l(materialAdapter, 8);
        }
    }

    private MaterialRecyclerView e() {
        return new MaterialRecyclerView(this.f75545e.get());
    }

    private int f(int i3, String str) {
        if (i3 != 2) {
            return i3;
        }
        str.hashCode();
        if (!str.equals(InteractiveToolbar.DOUBLE_PENDANT_CATEGORY)) {
            return i3;
        }
        return 202;
    }

    private void i(MaterialAdapter materialAdapter) {
        this.f75546f.E(materialAdapter);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NonNull ViewGroup viewGroup, int i3, @NonNull Object obj) {
        MaterialRecyclerView materialRecyclerView = this.f75549m.get(Integer.valueOf(i3));
        if (materialRecyclerView != null) {
            i((MaterialAdapter) materialRecyclerView.getAdapter());
            viewGroup.removeView(this.f75549m.get(Integer.valueOf(i3)));
        }
    }

    public void g(long j3, String str, boolean z16) {
        Iterator<MaterialRecyclerView> it = this.f75549m.values().iterator();
        while (it.hasNext()) {
            MaterialAdapter materialAdapter = (MaterialAdapter) it.next().getAdapter();
            if (materialAdapter != null && materialAdapter.l0(str)) {
                materialAdapter.s(j3, str, z16);
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        List<hw.a> list = this.f75548i;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void h(String str, int i3) {
        MaterialAdapter materialAdapter;
        MaterialRecyclerView materialRecyclerView = this.f75549m.get(Integer.valueOf(this.D));
        if (materialRecyclerView != null && (materialAdapter = (MaterialAdapter) materialRecyclerView.getAdapter()) != null && materialAdapter.l0(str)) {
            materialAdapter.u0(str, i3);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i3) {
        MaterialAdapter materialAdapter;
        boolean z16;
        MaterialRecyclerView materialRecyclerView = this.f75549m.get(Integer.valueOf(i3));
        if (materialRecyclerView == null) {
            WeakReference<Context> weakReference = this.f75545e;
            if (weakReference != null && weakReference.get() != null) {
                materialRecyclerView = e();
                AppInterface appInterface = this.f75544d;
                Context context = this.f75545e.get();
                ArrayList arrayList = (ArrayList) this.f75548i.get(i3).f406501d;
                int f16 = f(this.f75547h, this.f75548i.get(i3).f406498a);
                if (i3 == 0 && this.f75546f.w(this.f75547h)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                materialAdapter = new MaterialAdapter(appInterface, context, arrayList, materialRecyclerView, f16, z16);
                this.f75549m.put(Integer.valueOf(i3), materialRecyclerView);
            } else {
                return null;
            }
        } else {
            materialAdapter = (MaterialAdapter) materialRecyclerView.getAdapter();
            materialAdapter.A0((ArrayList) this.f75548i.get(i3).f406501d);
        }
        d(materialAdapter, i3, this.f75548i.get(i3).f406498a);
        materialAdapter.w0(this.C);
        materialAdapter.v0(this.E);
        materialAdapter.x0(this.f75548i.get(i3).f406500c);
        materialRecyclerView.setAdapter(materialAdapter);
        viewGroup.addView(materialRecyclerView);
        return materialRecyclerView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        if (view == obj) {
            return true;
        }
        return false;
    }

    public void j(iw.a aVar) {
        this.E = aVar;
    }

    public void k(b bVar) {
        this.C = bVar;
    }

    public void onDestroy() {
        HashMap<Integer, MaterialRecyclerView> hashMap = this.f75549m;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public void setCategoryList(List<hw.a> list) {
        this.f75548i = list;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i3, @NonNull Object obj) {
        super.setPrimaryItem(viewGroup, i3, obj);
        this.D = i3;
    }
}
