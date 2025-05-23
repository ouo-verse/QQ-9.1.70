package com.qzone.detail.ui.adapter;

import android.database.DataSetObserver;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class MergeListAdapter extends BaseAdapter {

    /* renamed from: d, reason: collision with root package name */
    private final ArrayList<Adapter> f46889d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    private Handler f46890e = new Handler(Looper.getMainLooper());

    /* renamed from: f, reason: collision with root package name */
    private DataSetObserver f46891f = new a();

    public static int d(ArrayList<Adapter> arrayList) {
        int size = arrayList.size();
        int i3 = 0;
        for (int i16 = 0; i16 < size; i16++) {
            Adapter adapter = arrayList.get(i16);
            if (adapter != null) {
                i3 += adapter.getCount();
            }
        }
        return i3;
    }

    public static int e(ArrayList<Adapter> arrayList) {
        int size = arrayList.size();
        int i3 = 0;
        for (int i16 = 0; i16 < size; i16++) {
            Adapter adapter = arrayList.get(i16);
            if (adapter != null) {
                i3 += adapter.getViewTypeCount();
            }
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        super.notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return false;
    }

    public void b(BaseAdapter baseAdapter) {
        try {
            this.f46889d.add(baseAdapter);
            g(baseAdapter);
        } catch (Exception unused) {
        }
    }

    public ArrayList<Adapter> c() {
        return this.f46889d;
    }

    protected void g(BaseAdapter baseAdapter) {
        baseAdapter.registerDataSetObserver(this.f46891f);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return d(this.f46889d);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        int size = this.f46889d.size();
        for (int i16 = 0; i16 < size; i16++) {
            Adapter adapter = this.f46889d.get(i16);
            int count = adapter.getCount();
            if (i3 < count) {
                return adapter.getItem(i3);
            }
            i3 -= count;
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i3) {
        int size = this.f46889d.size();
        int i16 = 0;
        for (int i17 = 0; i17 < size; i17++) {
            Adapter adapter = this.f46889d.get(i17);
            int count = adapter.getCount();
            if (i3 < count) {
                return i16 + adapter.getItemViewType(i3);
            }
            i3 -= count;
            i16 += adapter.getViewTypeCount();
        }
        return -1;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        int size = this.f46889d.size();
        int i16 = 0;
        int i17 = i3;
        while (true) {
            if (i16 >= size) {
                view2 = null;
                break;
            }
            Adapter adapter = this.f46889d.get(i16);
            int count = adapter.getCount();
            if (i17 < count) {
                view2 = adapter.getView(i17, view, viewGroup);
                break;
            }
            i17 -= count;
            i16++;
        }
        EventCollector.getInstance().onListGetView(i17, view, viewGroup, getItemId(i17));
        return view2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return Math.max(e(this.f46889d), 1);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        return getCount() == 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i3) {
        int size = this.f46889d.size();
        for (int i16 = 0; i16 < size; i16++) {
            BaseAdapter baseAdapter = (BaseAdapter) this.f46889d.get(i16);
            int count = baseAdapter.getCount();
            if (i3 < count) {
                return baseAdapter.isEnabled(i3);
            }
            i3 -= count;
        }
        return false;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            f();
        } else {
            this.f46890e.post(new Runnable() { // from class: com.qzone.detail.ui.adapter.MergeListAdapter.1
                @Override // java.lang.Runnable
                public void run() {
                    MergeListAdapter.this.f();
                }
            });
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends DataSetObserver {
        a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
        }
    }
}
