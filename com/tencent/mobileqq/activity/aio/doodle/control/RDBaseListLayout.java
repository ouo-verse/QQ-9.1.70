package com.tencent.mobileqq.activity.aio.doodle.control;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes10.dex */
public abstract class RDBaseListLayout<TItemData, TItemViewHolder> extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private RDBaseListLayout<TItemData, TItemViewHolder>.a f178529d;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<TItemData> f178530e;

    /* renamed from: f, reason: collision with root package name */
    private int f178531f;

    /* renamed from: h, reason: collision with root package name */
    private int f178532h;

    /* renamed from: i, reason: collision with root package name */
    private View f178533i;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        TItemViewHolder f178535a;

        /* renamed from: b, reason: collision with root package name */
        int f178536b;

        public b(int i3, TItemViewHolder titemviewholder) {
            this.f178536b = i3;
            this.f178535a = titemviewholder;
        }
    }

    public RDBaseListLayout(Context context) {
        super(context);
        this.f178530e = new ArrayList<>();
        this.f178531f = -1;
        this.f178532h = 0;
    }

    private void f(int i3) {
        if (i3 == 1) {
            HorizontalListView horizontalListView = new HorizontalListView(getContext());
            this.f178533i = horizontalListView;
            horizontalListView.setOverScrollMode(2);
            this.f178533i.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            ((HorizontalListView) this.f178533i).setAdapter((ListAdapter) this.f178529d);
            addView(this.f178533i);
            return;
        }
        ScrollView scrollView = new ScrollView(getContext());
        scrollView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(scrollView);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        scrollView.addView(linearLayout);
        linearLayout.setOrientation(1);
        ListView listView = new ListView(getContext());
        this.f178533i = listView;
        listView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        ((ListView) this.f178533i).setAdapter((ListAdapter) this.f178529d);
        linearLayout.addView(this.f178533i);
    }

    private RDBaseListLayout<TItemData, TItemViewHolder>.b j(View view) {
        if (view == null) {
            return null;
        }
        View view2 = view;
        while (true) {
            Object tag = view2.getTag();
            if (tag != null && (tag instanceof b)) {
                return (b) tag;
            }
            Object parent = view.getParent();
            if (!(parent instanceof View)) {
                return null;
            }
            view2 = (View) parent;
        }
    }

    public void d(TItemData titemdata, boolean z16) {
        this.f178530e.add(titemdata);
        if (z16) {
            q();
        }
    }

    public void e(int i3, boolean z16) {
        int i16;
        if (i3 >= 0 && i3 < this.f178530e.size()) {
            if (!z16 && (i16 = this.f178531f) >= 0) {
                ((com.tencent.mobileqq.activity.aio.doodle.control.a) this.f178530e.get(i16)).b(false);
                this.f178531f = -1;
            }
            TItemData titemdata = this.f178530e.get(i3);
            com.tencent.mobileqq.activity.aio.doodle.control.a aVar = (com.tencent.mobileqq.activity.aio.doodle.control.a) titemdata;
            aVar.b(true);
            aVar.b(true);
            View view = this.f178533i;
            if (view instanceof ListView) {
                ((ListView) view).setSelection(i3);
            } else if (view instanceof HorizontalListView) {
                ((HorizontalListView) view).setSelection(i3);
                ((HorizontalListView) this.f178533i).smoothScrollToPosition(i3, 0, 1);
            }
            n(i3, titemdata);
            this.f178531f = i3;
            q();
        }
    }

    public TItemData g(int i3) {
        if (i3 >= 0 && i3 < this.f178530e.size()) {
            return this.f178530e.get(i3);
        }
        return null;
    }

    public int h(View view) {
        RDBaseListLayout<TItemData, TItemViewHolder>.b j3 = j(view);
        if (j3 != null) {
            return j3.f178536b;
        }
        return -1;
    }

    public int i() {
        return this.f178531f;
    }

    public boolean k(int i3) {
        this.f178532h = i3;
        RDBaseListLayout<TItemData, TItemViewHolder>.a aVar = new a();
        this.f178529d = aVar;
        aVar.a();
        f(this.f178532h);
        boolean m3 = m();
        if (m3) {
            this.f178529d.notifyDataSetChanged();
        }
        return m3;
    }

    public abstract TItemViewHolder l(int i3, TItemData titemdata);

    public abstract boolean m();

    public abstract void n(int i3, TItemData titemdata);

    public abstract void o(int i3, @NonNull TItemData titemdata, @NonNull TItemViewHolder titemviewholder);

    public void p(boolean z16) {
        ArrayList<TItemData> arrayList = this.f178530e;
        if (arrayList != null) {
            arrayList.clear();
        }
        if (z16) {
            q();
        }
    }

    public void q() {
        RDBaseListLayout<TItemData, TItemViewHolder>.a aVar = this.f178529d;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // android.view.View
    public void setOverScrollMode(int i3) {
        View view = this.f178533i;
        if (view != null) {
            view.setOverScrollMode(i3);
        }
    }

    public RDBaseListLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f178530e = new ArrayList<>();
        this.f178531f = -1;
        this.f178532h = 0;
    }

    public RDBaseListLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f178530e = new ArrayList<>();
        this.f178531f = -1;
        this.f178532h = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a extends BaseAdapter {
        a() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return RDBaseListLayout.this.f178530e.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            return RDBaseListLayout.this.f178530e.get(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            Object obj;
            View view2;
            Object obj2 = RDBaseListLayout.this.f178530e.get(i3);
            View view3 = null;
            if (view == null) {
                obj = RDBaseListLayout.this.l(i3, obj2);
            } else {
                b bVar = (b) view.getTag();
                if (bVar != null) {
                    obj = bVar.f178535a;
                } else {
                    obj = null;
                }
            }
            if (obj == null) {
                view2 = view;
            } else {
                RDBaseListLayout.this.o(i3, obj2, obj);
                View a16 = ((d61.a) obj).a();
                if (a16 != null) {
                    a16.setTag(new b(i3, obj));
                }
                view3 = a16;
                view2 = view3;
            }
            EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
            return view3;
        }

        public void a() {
        }
    }
}
