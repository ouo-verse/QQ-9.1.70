package com.tencent.mobileqq.vas;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.ColorSelectView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class e extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private int C;

    /* renamed from: e, reason: collision with root package name */
    private LayoutInflater f309035e;

    /* renamed from: h, reason: collision with root package name */
    private InterfaceC8906e f309037h;

    /* renamed from: m, reason: collision with root package name */
    public Drawable f309039m;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<b> f309034d = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    private int f309036f = -1;

    /* renamed from: i, reason: collision with root package name */
    public f f309038i = new f();

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a extends GridLayoutManager.SpanSizeLookup {
        a() {
        }

        @Override // android.support.v7.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i3) {
            int itemViewType = e.this.getItemViewType(i3);
            if (itemViewType != 1 && itemViewType != 2 && itemViewType != 4) {
                return 1;
            }
            return 3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f309041a;

        /* renamed from: b, reason: collision with root package name */
        public String f309042b;

        /* renamed from: c, reason: collision with root package name */
        public String f309043c;

        /* renamed from: d, reason: collision with root package name */
        public int f309044d;

        public b(int i3, String str, int i16, String str2) {
            this.f309041a = i3;
            this.f309042b = str;
            this.f309044d = i16;
            this.f309043c = str2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static abstract class c extends RecyclerView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name */
        private boolean f309045d = false;

        public abstract void b();

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
            if (i3 == 0) {
                if (((e) recyclerView.getAdapter()).p(gridLayoutManager.findLastCompletelyVisibleItemPosition()).f309041a == 4 && this.f309045d) {
                    b();
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
            boolean z16;
            super.onScrolled(recyclerView, i3, i16);
            if (i16 > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f309045d = z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class d extends RecyclerView.ViewHolder implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        public int f309046d;

        /* renamed from: e, reason: collision with root package name */
        ImageView f309047e;

        /* renamed from: f, reason: collision with root package name */
        ImageView f309048f;

        /* renamed from: h, reason: collision with root package name */
        e f309049h;

        /* renamed from: i, reason: collision with root package name */
        InterfaceC8906e f309050i;

        public d(View view, e eVar, InterfaceC8906e interfaceC8906e) {
            super(view);
            this.f309049h = eVar;
            this.f309047e = (ImageView) view.findViewById(R.id.b1q);
            this.f309048f = (ImageView) view.findViewById(R.id.b1r);
            view.setOnClickListener(this);
            this.f309050i = interfaceC8906e;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            this.f309049h.r(this.f309046d);
            InterfaceC8906e interfaceC8906e = this.f309050i;
            if (interfaceC8906e != null) {
                interfaceC8906e.a(this.f309049h.p(this.f309046d));
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.vas.e$e, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public interface InterfaceC8906e {
        void a(b bVar);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class f extends BaseAdapter {

        /* renamed from: e, reason: collision with root package name */
        public static final int[] f309051e = {0, -16777216, -51904, -41579, -2992688, -15808515, -16268201, -12464};

        /* renamed from: d, reason: collision with root package name */
        public int f309052d = -1;

        public void a(int i3) {
            this.f309052d = i3;
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return f309051e.length;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            return Integer.valueOf(f309051e[i3]);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            int i16;
            boolean z16 = false;
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bbk, viewGroup, false);
            }
            ColorSelectView colorSelectView = (ColorSelectView) view.findViewById(R.id.f164840b25);
            ImageView imageView = (ImageView) view.findViewById(R.id.f164838b23);
            if (i3 == 0) {
                colorSelectView.setVisibility(8);
                imageView.setVisibility(0);
                if (this.f309052d == i3) {
                    i16 = R.drawable.fmu;
                } else {
                    i16 = R.drawable.fmt;
                }
                imageView.setImageResource(i16);
            } else {
                colorSelectView.setVisibility(0);
                imageView.setVisibility(8);
                colorSelectView.setColor(f309051e[i3]);
                if (this.f309052d == i3) {
                    z16 = true;
                }
                colorSelectView.setSelect(z16);
            }
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class g extends RecyclerView.ViewHolder implements AdapterView.OnItemClickListener {

        /* renamed from: d, reason: collision with root package name */
        HorizontalListView f309053d;

        /* renamed from: e, reason: collision with root package name */
        f f309054e;

        /* renamed from: f, reason: collision with root package name */
        InterfaceC8906e f309055f;

        /* renamed from: h, reason: collision with root package name */
        e f309056h;

        public g(View view, InterfaceC8906e interfaceC8906e, f fVar, e eVar) {
            super(view);
            HorizontalListView horizontalListView = (HorizontalListView) view.findViewById(R.id.f164839b24);
            this.f309053d = horizontalListView;
            this.f309054e = fVar;
            horizontalListView.setAdapter((ListAdapter) fVar);
            this.f309053d.setOnItemClickListener(this);
            this.f309055f = interfaceC8906e;
            this.f309056h = eVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
            this.f309054e.a(i3);
            this.f309056h.r(-1);
            if (this.f309055f != null) {
                this.f309055f.a(new b(2, null, ((Integer) this.f309054e.getItem(i3)).intValue(), null));
            }
            EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class h extends RecyclerView.ViewHolder {

        /* renamed from: d, reason: collision with root package name */
        TextView f309057d;

        /* renamed from: e, reason: collision with root package name */
        int f309058e;

        public h(View view, int i3) {
            super(view);
            this.f309058e = i3;
            if (i3 == 1) {
                this.f309057d = (TextView) view.findViewById(R.id.b26);
            }
        }
    }

    public e(Context context, InterfaceC8906e interfaceC8906e) {
        this.f309035e = LayoutInflater.from(context);
        this.f309037h = interfaceC8906e;
        this.f309039m = context.getResources().getDrawable(R.drawable.fmy);
        this.C = com.tencent.mobileqq.util.x.c(context, 2.0f);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f309034d.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        if (this.f309034d.get(i3).f309041a == 3) {
            return r0.f309044d;
        }
        return i3;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        return this.f309034d.get(i3).f309041a;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        ((GridLayoutManager) recyclerView.getLayoutManager()).setSpanSizeLookup(new a());
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        b bVar = this.f309034d.get(i3);
        int i16 = bVar.f309041a;
        if (i16 != 1) {
            if (i16 == 3 && (viewHolder instanceof d)) {
                d dVar = (d) viewHolder;
                dVar.f309046d = i3;
                GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) dVar.itemView.getLayoutParams();
                if (i3 % 3 == 0) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = 0;
                } else {
                    ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = this.C;
                }
                if (i3 == this.f309036f) {
                    dVar.f309048f.setVisibility(0);
                } else {
                    dVar.f309048f.setVisibility(8);
                }
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                Drawable drawable = this.f309039m;
                obtain.mLoadingDrawable = drawable;
                obtain.mFailedDrawable = drawable;
                dVar.f309047e.setImageDrawable(URLDrawable.getDrawable(bVar.f309043c, obtain));
            }
        } else if (viewHolder instanceof h) {
            h hVar = (h) viewHolder;
            if (hVar.f309058e == 1) {
                hVar.f309057d.setText(bVar.f309042b);
            }
        }
        EventCollector.getInstance().onRecyclerBindViewHolder(viewHolder, i3, getItemId(i3));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        RecyclerView.ViewHolder hVar;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return null;
                    }
                    hVar = new h(this.f309035e.inflate(R.layout.bbh, viewGroup, false), 4);
                } else {
                    hVar = new d(this.f309035e.inflate(R.layout.bbj, viewGroup, false), this, this.f309037h);
                }
            } else {
                hVar = new g(this.f309035e.inflate(R.layout.bbl, viewGroup, false), this.f309037h, this.f309038i, this);
            }
        } else {
            hVar = new h(this.f309035e.inflate(R.layout.bbi, viewGroup, false), 1);
        }
        return hVar;
    }

    public b p(int i3) {
        return this.f309034d.get(i3);
    }

    public void q(List<b> list, boolean z16) {
        this.f309034d.clear();
        this.f309034d.addAll(list);
        if (z16) {
            this.f309034d.add(new b(4, null, 0, null));
        }
        notifyDataSetChanged();
    }

    public void r(int i3) {
        int i16 = this.f309036f;
        this.f309036f = i3;
        if (i16 > 0) {
            notifyItemChanged(i16);
        }
        int i17 = this.f309036f;
        if (i17 > 0) {
            notifyItemChanged(i17);
        }
        if (i3 > 0) {
            this.f309038i.a(-1);
        }
    }
}
