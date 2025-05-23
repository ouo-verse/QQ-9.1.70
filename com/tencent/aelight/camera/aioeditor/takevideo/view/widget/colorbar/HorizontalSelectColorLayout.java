package com.tencent.aelight.camera.aioeditor.takevideo.view.widget.colorbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes32.dex */
public class HorizontalSelectColorLayout extends RelativeLayout {
    boolean C;
    d D;
    e E;
    private long F;

    /* renamed from: d, reason: collision with root package name */
    HorizontalListView f68951d;

    /* renamed from: e, reason: collision with root package name */
    f f68952e;

    /* renamed from: f, reason: collision with root package name */
    ImageView f68953f;

    /* renamed from: h, reason: collision with root package name */
    ArrayList<qs.d> f68954h;

    /* renamed from: i, reason: collision with root package name */
    int f68955i;

    /* renamed from: m, reason: collision with root package name */
    boolean f68956m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
            HorizontalSelectColorLayout.this.c(i3);
            EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e eVar;
            EventCollector.getInstance().onViewClickedBefore(view);
            if (HorizontalSelectColorLayout.this.F <= System.currentTimeMillis() && (eVar = HorizontalSelectColorLayout.this.E) != null) {
                eVar.b();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface d {
        void a(qs.d dVar);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface e {
        void b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class f extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name */
        ArrayList<qs.d> f68960d = new ArrayList<>();

        /* renamed from: e, reason: collision with root package name */
        int f68961e = -1;

        /* renamed from: f, reason: collision with root package name */
        Context f68962f;

        /* compiled from: P */
        /* loaded from: classes32.dex */
        class a {

            /* renamed from: a, reason: collision with root package name */
            ImageView f68964a;

            /* renamed from: b, reason: collision with root package name */
            ImageView f68965b;

            /* renamed from: c, reason: collision with root package name */
            ViewGroup f68966c;

            a() {
            }
        }

        public f(Context context) {
            this.f68962f = context;
        }

        public void a(int i3) {
            this.f68961e = i3;
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f68960d.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            return this.f68960d.get(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            a aVar;
            View inflate;
            qs.d dVar = (qs.d) getItem(i3);
            if (view == null) {
                aVar = new a();
                if (HorizontalSelectColorLayout.this.C) {
                    inflate = LayoutInflater.from(this.f68962f).inflate(R.layout.f167921mi, viewGroup, false);
                    aVar.f68965b = (ImageView) inflate.findViewById(R.id.dqz);
                } else {
                    inflate = LayoutInflater.from(this.f68962f).inflate(R.layout.f167920mh, viewGroup, false);
                }
                aVar.f68964a = (ImageView) inflate.findViewById(R.id.dpm);
                aVar.f68966c = (ViewGroup) inflate.findViewById(R.id.dpl);
                inflate.setTag(aVar);
                view2 = inflate;
            } else {
                view2 = view;
                aVar = (a) view.getTag();
            }
            aVar.f68964a.setImageDrawable(dVar.f429431c);
            if (i3 == this.f68961e) {
                HorizontalSelectColorLayout horizontalSelectColorLayout = HorizontalSelectColorLayout.this;
                if (horizontalSelectColorLayout.C) {
                    aVar.f68965b.setVisibility(0);
                } else {
                    aVar.f68966c.setBackgroundDrawable(horizontalSelectColorLayout.getResources().getDrawable(R.drawable.err));
                }
            } else if (HorizontalSelectColorLayout.this.C) {
                aVar.f68965b.setVisibility(4);
            } else {
                aVar.f68966c.setBackgroundDrawable(null);
            }
            String str = dVar.f429432d;
            if (str != null) {
                view2.setContentDescription(str);
            }
            EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
            return view2;
        }

        public void setData(ArrayList<qs.d> arrayList) {
            this.f68960d = arrayList;
            notifyDataSetChanged();
        }
    }

    public HorizontalSelectColorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f68954h = new ArrayList<>();
        this.C = false;
        this.F = 0L;
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i3) {
        if (this.F > System.currentTimeMillis()) {
            return;
        }
        this.f68952e.a(i3);
        this.f68955i = i3;
        d dVar = this.D;
        if (dVar != null) {
            dVar.a(d());
        }
    }

    private void e() {
        LayoutInflater.from(getContext()).inflate(R.layout.b6o, this);
        HorizontalListView horizontalListView = (HorizontalListView) super.findViewById(R.id.b1j);
        this.f68951d = horizontalListView;
        horizontalListView.setStayDisplayOffsetZero(true);
        this.f68951d.setOverScrollMode(2);
        this.f68951d.setOnItemClickListener(new a());
        this.f68951d.setOnItemSelectedListener(new b());
        f fVar = new f(getContext());
        this.f68952e = fVar;
        this.f68951d.setAdapter((ListAdapter) fVar);
        ImageView imageView = (ImageView) super.findViewById(R.id.khe);
        this.f68953f = imageView;
        imageView.setOnClickListener(new c());
        this.f68956m = false;
        this.f68953f.setEnabled(false);
    }

    public qs.d d() {
        return this.f68954h.get(this.f68955i);
    }

    public void setAnimationEndTime(long j3) {
        this.F = j3;
    }

    public void setEditDialogMode(boolean z16) {
        this.C = z16;
    }

    public void setOnStrokeSelectedListener(d dVar) {
        this.D = dVar;
    }

    public void setOnUndoViewClickListener(e eVar) {
        this.E = eVar;
    }

    public void setSelectedStroke(int i3, int i16) {
        if (this.f68954h.isEmpty()) {
            return;
        }
        for (int i17 = 0; i17 < this.f68954h.size(); i17++) {
            qs.d dVar = this.f68954h.get(i17);
            if (dVar.f429429a == i3 && dVar.f429430b == i16) {
                c(i17);
                if (i17 > 5) {
                    this.f68951d.smoothScrollToPosition(i17);
                    return;
                }
                return;
            }
        }
    }

    public void setSelectedStrokeWithColor(int i3) {
        if (this.f68954h.isEmpty()) {
            return;
        }
        for (int i16 = 0; i16 < this.f68954h.size(); i16++) {
            qs.d dVar = this.f68954h.get(i16);
            if (dVar.f429429a == 0 && dVar.f429430b == i3) {
                c(i16);
                return;
            }
        }
    }

    public void setStrokeStrategy(gs.c cVar, boolean z16, int i3) {
        this.f68953f.setVisibility(z16 ? 0 : 8);
        super.findViewById(R.id.khf).setVisibility(z16 ? 0 : 8);
        View findViewById = super.findViewById(R.id.jtk);
        View findViewById2 = super.findViewById(R.id.acz);
        if (i3 == 1) {
            findViewById.setVisibility(0);
        } else if (i3 == 2) {
            findViewById2.setVisibility(0);
        } else if (i3 == 3) {
            findViewById.setVisibility(0);
            findViewById2.setVisibility(0);
        }
        if (cVar != null) {
            this.f68954h.clear();
            cVar.a(this.f68954h, getContext());
            f fVar = this.f68952e;
            if (fVar != null) {
                fVar.setData(this.f68954h);
                return;
            }
            return;
        }
        setVisibility(8);
    }

    public void setUndoViewEnable(boolean z16) {
        if (this.f68956m != z16) {
            this.f68956m = z16;
            this.f68953f.setEnabled(z16);
        }
    }

    public HorizontalSelectColorLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f68954h = new ArrayList<>();
        this.C = false;
        this.F = 0L;
        e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements AdapterView.OnItemSelectedListener {
        b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i3, long j3) {
            HorizontalSelectColorLayout.this.c(i3);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }
}
