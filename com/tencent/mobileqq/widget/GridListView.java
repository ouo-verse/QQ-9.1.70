package com.tencent.mobileqq.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.XListView;

/* compiled from: P */
@Deprecated
/* loaded from: classes20.dex */
public class GridListView extends XListView {
    static final int K = 2131361853;
    static final int L = 2131361901;
    int C;
    int D;
    int E;
    int F;
    int G;
    View H;
    e I;
    int J;

    /* renamed from: d, reason: collision with root package name */
    d f315697d;

    /* renamed from: e, reason: collision with root package name */
    int f315698e;

    /* renamed from: f, reason: collision with root package name */
    int f315699f;

    /* renamed from: h, reason: collision with root package name */
    int f315700h;

    /* renamed from: i, reason: collision with root package name */
    AdapterView.OnItemClickListener f315701i;

    /* renamed from: m, reason: collision with root package name */
    View.OnClickListener f315702m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a extends DataSetObserver {
        a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            GridListView gridListView = GridListView.this;
            d dVar = gridListView.f315697d;
            if (dVar != null) {
                gridListView.d0(dVar.getCount());
            }
            e eVar = GridListView.this.I;
            if (eVar != null) {
                eVar.notifyDataSetChanged();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            GridListView gridListView = GridListView.this;
            d dVar = gridListView.f315697d;
            if (dVar != null) {
                gridListView.d0(dVar.getCount());
            }
            e eVar = GridListView.this.I;
            if (eVar != null) {
                eVar.notifyDataSetInvalidated();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            int intValue = ((Integer) view.getTag(GridListView.K)).intValue();
            GridListView gridListView = GridListView.this;
            gridListView.f315701i.onItemClick(gridListView, view, intValue, 0L);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        View[] f315705a = new View[12];

        c() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static abstract class d extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name */
        protected int f315706d = 0;

        public abstract int a(int i3);

        public abstract int b(int i3);

        public abstract int c();

        void d(int i3) {
            this.f315706d = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class e extends BaseAdapter {
        public e() {
        }

        private LinearLayout a(ViewGroup viewGroup) {
            LinearLayout linearLayout = new LinearLayout(GridListView.this.getContext());
            linearLayout.setOrientation(0);
            linearLayout.setClickable(false);
            linearLayout.setLongClickable(false);
            linearLayout.setTag(new c());
            return linearLayout;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            GridListView gridListView = GridListView.this;
            int i3 = gridListView.f315700h;
            if (i3 == 0) {
                if (gridListView.H != null) {
                    return 1;
                }
                return 0;
            }
            return i3;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return 0L;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i3) {
            GridListView gridListView = GridListView.this;
            if (gridListView.f315700h == 0) {
                return 0;
            }
            if (gridListView.f315698e == 0) {
                return gridListView.f315697d.getItemViewType(i3) + 2;
            }
            return 1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r12v11 */
        /* JADX WARN: Type inference failed for: r12v12 */
        /* JADX WARN: Type inference failed for: r12v2, types: [android.view.View] */
        /* JADX WARN: Type inference failed for: r12v4 */
        /* JADX WARN: Type inference failed for: r12v6, types: [android.view.View, android.view.ViewGroup] */
        /* JADX WARN: Type inference failed for: r8v1, types: [com.tencent.mobileqq.widget.GridListView$d, android.widget.Adapter] */
        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            ?? view2;
            View view3;
            View view4;
            GridListView gridListView = GridListView.this;
            if (gridListView.f315700h == 0) {
                gridListView.H.setLayoutParams(new AbsListView.LayoutParams(GridListView.this.getWidth(), GridListView.this.getHeight()));
                view3 = view;
                view4 = GridListView.this.H;
            } else {
                if (gridListView.f315698e == 1) {
                    LinearLayout linearLayout = (LinearLayout) view;
                    view2 = linearLayout;
                    if (linearLayout == null) {
                        view2 = a(viewGroup);
                    }
                    view2.removeAllViews();
                    GridListView gridListView2 = GridListView.this;
                    int i16 = gridListView2.C;
                    int i17 = gridListView2.f315699f;
                    int i18 = i16 - (i3 * i17);
                    if (i18 < i17) {
                        i17 = i18;
                    }
                    c cVar = (c) view2.getTag();
                    int i19 = GridListView.this.f315699f * i3;
                    for (int i26 = 0; i26 < i17; i26++) {
                        View view5 = cVar.f315705a[i26];
                        int i27 = i19 + i26;
                        int a16 = GridListView.this.f315697d.a(i27);
                        if (view5 != null && ((Integer) view5.getTag(GridListView.L)).intValue() != a16) {
                            view5 = null;
                        }
                        View view6 = GridListView.this.f315697d.getView(i27, view5, view2);
                        view6.setTag(GridListView.L, Integer.valueOf(a16));
                        cVar.f315705a[i26] = view6;
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view6.getLayoutParams();
                        if (layoutParams == null) {
                            GridListView gridListView3 = GridListView.this;
                            layoutParams = new LinearLayout.LayoutParams(gridListView3.F, gridListView3.G);
                            view6.setLayoutParams(layoutParams);
                        }
                        GridListView gridListView4 = GridListView.this;
                        layoutParams.width = gridListView4.F;
                        layoutParams.height = gridListView4.G;
                        layoutParams.leftMargin = gridListView4.D;
                        layoutParams.topMargin = gridListView4.E;
                        view2.addView(view6);
                        GridListView gridListView5 = GridListView.this;
                        if (gridListView5.f315701i != null && gridListView5.f315697d.isEnabled(i27)) {
                            view6.setTag(GridListView.K, Integer.valueOf(i27));
                            view6.setOnClickListener(GridListView.this.f315702m);
                        } else {
                            view6.setOnClickListener(null);
                        }
                    }
                } else {
                    int b16 = gridListView.f315697d.b(i3) + 2;
                    if (view != null && ((Integer) view.getTag(GridListView.L)).intValue() != b16) {
                        view = null;
                    }
                    view2 = GridListView.this.f315697d.getView(i3, view, viewGroup);
                    view2.setTag(GridListView.L, Integer.valueOf(b16));
                    GridListView gridListView6 = GridListView.this;
                    if (gridListView6.f315701i != null && gridListView6.f315697d.isEnabled(i3)) {
                        view2.setTag(GridListView.K, Integer.valueOf(i3));
                        view2.setOnClickListener(GridListView.this.f315702m);
                    } else {
                        view2.setOnClickListener(null);
                    }
                }
                view3 = view2;
                view4 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view4;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return GridListView.this.J + 2;
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int i3) {
            GridListView gridListView = GridListView.this;
            if (gridListView.f315700h != 0 && gridListView.f315698e != 1) {
                return super.isEnabled(i3);
            }
            return false;
        }
    }

    public GridListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f315698e = 0;
        this.f315699f = 4;
        this.f315700h = 0;
        this.H = new View(getContext());
        this.I = new e();
    }

    private void c0(int i3) {
        this.C = i3;
        this.f315700h = i3;
        if (this.f315698e == 1) {
            int i16 = this.f315699f;
            this.f315700h = ((i3 + i16) - 1) / i16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(int i3) {
        if (this.C != i3) {
            c0(i3);
        }
    }

    @Override // com.tencent.widget.AdapterView
    public void setEmptyView(View view) {
        this.H = view;
        if (this.C == 0) {
            this.I.notifyDataSetChanged();
        }
    }

    public void setGridSize(int i3, int i16) {
        if (this.F == i3 && this.G == i16) {
            return;
        }
        this.F = i3;
        this.G = i16;
        this.I.notifyDataSetChanged();
    }

    public void setGridSpacing(int i3, int i16) {
        if (this.D != i3 || this.E != i16) {
            this.D = i3;
            this.E = i16;
            if (this.f315698e == 1) {
                setPadding(0, 0, 0, i16);
            }
            this.I.notifyDataSetChanged();
        }
    }

    public void setMode(int i3) {
        int i16;
        if (this.f315698e != i3) {
            this.f315698e = i3;
            d dVar = this.f315697d;
            if (dVar != null) {
                dVar.d(i3);
                c0(this.f315697d.getCount());
            }
            if (this.f315698e == 1) {
                i16 = this.E;
            } else {
                i16 = 0;
            }
            setPadding(0, 0, 0, i16);
            this.I.notifyDataSetChanged();
        }
    }

    public void setNumColumns(int i3) {
        if (i3 != this.f315699f) {
            this.f315699f = i3;
            d dVar = this.f315697d;
            if (dVar != null) {
                d0(dVar.getCount());
            }
        }
    }

    @Override // com.tencent.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.f315701i = onItemClickListener;
        if (this.f315702m == null) {
            this.f315702m = new b();
        }
    }

    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView, com.tencent.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter == null) {
            return;
        }
        d dVar = (d) listAdapter;
        this.f315697d = dVar;
        dVar.registerDataSetObserver(new a());
        this.f315697d.d(this.f315698e);
        this.J = this.f315697d.c();
        d0(this.f315697d.getCount());
        super.setAdapter((ListAdapter) this.I);
    }

    public void setGridSize(int i3) {
        setGridSize(i3, i3);
    }

    public GridListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f315698e = 0;
        this.f315699f = 4;
        this.f315700h = 0;
        this.H = new View(getContext());
        this.I = new e();
    }

    public GridListView(Context context) {
        super(context);
        this.f315698e = 0;
        this.f315699f = 4;
        this.f315700h = 0;
        this.H = new View(getContext());
        this.I = new e();
    }
}
