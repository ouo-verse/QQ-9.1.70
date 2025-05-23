package com.tencent.luggage.wxa.xn;

import android.os.Looper;
import com.tencent.luggage.wxa.tn.b0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class e {

    /* renamed from: d, reason: collision with root package name */
    public static final b0 f145171d = new b0(Looper.getMainLooper());

    /* renamed from: a, reason: collision with root package name */
    public int f145172a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final Hashtable f145173b = new Hashtable();

    /* renamed from: c, reason: collision with root package name */
    public final HashSet f145174c = new HashSet();

    public abstract void a(Object obj, Object obj2);

    public void a(List list) {
    }

    public void b(Object obj) {
    }

    public final void c() {
        ArrayList arrayList;
        ArrayList a16 = a();
        if (a16.size() == 0 && !e()) {
            this.f145174c.clear();
            return;
        }
        synchronized (this.f145174c) {
            arrayList = new ArrayList(this.f145174c);
            this.f145174c.clear();
        }
        a((List) arrayList);
        new HashMap();
        for (Object obj : a16) {
            Object obj2 = this.f145173b.get(obj);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next != null && obj2 != null) {
                    a(obj, next);
                }
            }
        }
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            b(it5.next());
        }
    }

    public boolean d() {
        if (this.f145172a > 0) {
            return true;
        }
        return false;
    }

    public boolean e() {
        return false;
    }

    public final synchronized ArrayList a() {
        return new ArrayList(this.f145173b.keySet());
    }

    public void b() {
        if (d()) {
            return;
        }
        c();
    }

    public boolean a(Object obj) {
        boolean add;
        synchronized (this.f145174c) {
            add = this.f145174c.add(obj);
        }
        return add;
    }
}
