package com.qzone.widget.dynamicgridview;

import android.widget.BaseAdapter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public abstract class a extends BaseAdapter implements d {

    /* renamed from: d, reason: collision with root package name */
    private int f60835d = 0;

    /* renamed from: e, reason: collision with root package name */
    private HashMap<Object, Integer> f60836e = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(List<?> list) {
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            e(it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(Object obj) {
        if (this.f60836e.containsKey(obj)) {
            return;
        }
        HashMap<Object, Integer> hashMap = this.f60836e;
        int i3 = this.f60835d;
        this.f60835d = i3 + 1;
        hashMap.put(obj, Integer.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f() {
        this.f60836e.clear();
    }

    public abstract Object g(int i3);

    public final long h(int i3) {
        Integer num;
        Object g16 = g(i3);
        if (g16 == null || (num = this.f60836e.get(g16)) == null) {
            return -1L;
        }
        return num.intValue();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final boolean hasStableIds() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(Object obj) {
        this.f60836e.remove(obj);
    }
}
