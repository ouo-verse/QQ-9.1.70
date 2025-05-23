package com.tencent.mobileqq.emosm.view;

import android.content.Context;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public abstract class b<T> extends BaseAdapter {

    /* renamed from: d, reason: collision with root package name */
    protected List<T> f204444d;

    /* renamed from: e, reason: collision with root package name */
    protected Context f204445e;

    /* renamed from: h, reason: collision with root package name */
    private boolean f204447h;

    /* renamed from: f, reason: collision with root package name */
    private Object f204446f = new Object();

    /* renamed from: i, reason: collision with root package name */
    private HashMap<T, Boolean> f204448i = new HashMap<>();

    public b(Context context, List<T> list) {
        this.f204445e = context;
        this.f204444d = list;
    }

    public void a() {
        this.f204448i.clear();
    }

    public List<T> b() {
        return this.f204444d;
    }

    public boolean c(int i3) {
        T item = getItem(i3);
        if (this.f204448i.containsKey(item)) {
            return this.f204448i.get(item).booleanValue();
        }
        return false;
    }

    public List<T> d() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<T, Boolean> entry : this.f204448i.entrySet()) {
            if (entry.getValue().booleanValue()) {
                arrayList.add(entry.getKey());
            }
        }
        return arrayList;
    }

    public void e(T t16, int i3) {
        synchronized (this.f204446f) {
            this.f204444d.add(i3, t16);
        }
        if (this.f204447h) {
            notifyDataSetChanged();
        }
    }

    public void f(T t16) {
        synchronized (this.f204446f) {
            this.f204448i.remove(t16);
            this.f204444d.remove(t16);
        }
        if (this.f204447h) {
            notifyDataSetChanged();
        }
    }

    public void g(boolean z16) {
        this.f204447h = z16;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<T> list = this.f204444d;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public T getItem(int i3) {
        return this.f204444d.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return 0L;
    }

    public void h(int i3) {
        this.f204448i.put(getItem(i3), Boolean.valueOf(!c(i3)));
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.f204447h = true;
    }
}
