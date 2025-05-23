package com.qq.e.comm.plugin.stat;

import android.content.Context;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.k.ac;
import com.qq.e.comm.plugin.stat.m;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class a<T extends m> {

    /* renamed from: a, reason: collision with root package name */
    Context f39698a;

    /* renamed from: b, reason: collision with root package name */
    List<T> f39699b = new LinkedList();

    /* renamed from: c, reason: collision with root package name */
    private long f39700c = 0;

    /* renamed from: d, reason: collision with root package name */
    private long f39701d = 0;

    public a(Context context) {
        this.f39698a = context;
    }

    private void e(List<T> list) {
        if (list != null && list.size() != 0) {
            if (!ac.a(this.f39698a)) {
                GDTLogger.d("Send stat event failed for no available network");
                return;
            }
            int d16 = f.d();
            ArrayList arrayList = new ArrayList(d16);
            for (int i3 = 0; i3 < list.size(); i3++) {
                arrayList.add(list.get(i3));
                if (arrayList.size() == d16) {
                    c(arrayList);
                    arrayList.clear();
                }
            }
            c(arrayList);
            arrayList.clear();
            return;
        }
        GDTLogger.d("No stat items need send");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        ArrayList arrayList = new ArrayList(this.f39699b);
        this.f39699b.clear();
        d(arrayList);
    }

    abstract void a(Set<Integer> set);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        GDTLogger.d("Start commit stat data");
        ArrayList arrayList = new ArrayList(this.f39699b);
        List<T> h16 = h();
        if (h16 != null && h16.size() > 0) {
            arrayList.addAll(h16);
        }
        if (arrayList.size() > 0) {
            e(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long c() {
        return this.f39700c;
    }

    abstract void c(List<T> list);

    /* JADX INFO: Access modifiers changed from: package-private */
    public long d() {
        return this.f39701d;
    }

    abstract void d(List<T> list);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        if (g()) {
            b();
        }
    }

    abstract boolean g();

    abstract List<T> h();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(T t16) {
        if (t16 == null) {
            return;
        }
        if (this.f39699b.size() >= 1000) {
            Iterator<T> it = this.f39699b.iterator();
            for (int size = (this.f39699b.size() - 1000) + 1; size > 0 && it.hasNext(); size--) {
                it.next();
                it.remove();
            }
        }
        this.f39699b.add(t16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(List<T> list) {
        GDTLogger.d("Send stat failed");
        this.f39701d = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(List<T> list) {
        GDTLogger.d("Send stat success");
        this.f39700c = System.currentTimeMillis() / 1000;
        HashSet hashSet = new HashSet();
        for (T t16 : list) {
            if (t16 != null) {
                if (t16.a() >= 0) {
                    hashSet.add(Integer.valueOf(t16.a()));
                }
                this.f39699b.remove(t16);
            }
        }
        a(hashSet);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long e() {
        return GDTADManager.getInstance().getSM().getLong("report_failed_ddl", 5000L);
    }
}
