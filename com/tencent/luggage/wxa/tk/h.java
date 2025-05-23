package com.tencent.luggage.wxa.tk;

import androidx.collection.ArrayMap;
import androidx.core.util.Consumer;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public final Map f141498a = new ArrayMap();

    public boolean a(Object obj, Object obj2) {
        boolean contains;
        Set a16 = a(obj, false);
        if (a16 == null) {
            return false;
        }
        synchronized (a16) {
            contains = a16.contains(obj2);
        }
        return contains;
    }

    public boolean b(Object obj, Object obj2) {
        boolean add;
        if (obj != null && obj2 != null) {
            Set a16 = a(obj, true);
            synchronized (a16) {
                add = a16.add(obj2);
            }
            return add;
        }
        if (com.tencent.luggage.wxa.tn.e.f141559a) {
            com.tencent.luggage.wxa.er.a.a(String.format(Locale.ENGLISH, "Invalid arguments, k %s, v %s", obj, obj2));
        }
        return false;
    }

    public boolean c(Object obj, Object obj2) {
        Set a16;
        boolean remove;
        if (obj2 == null || (a16 = a(obj, false)) == null) {
            return false;
        }
        synchronized (a16) {
            remove = a16.remove(obj2);
        }
        return remove;
    }

    public final Set a(Object obj, boolean z16) {
        Set set;
        synchronized (this.f141498a) {
            set = (Set) this.f141498a.get(obj);
            if (set == null && z16) {
                set = new HashSet();
                this.f141498a.put(obj, set);
            }
        }
        return set;
    }

    public Set b(Object obj) {
        Set set;
        if (obj == null) {
            return null;
        }
        synchronized (this.f141498a) {
            set = (Set) this.f141498a.remove(obj);
        }
        return set;
    }

    public Set a(Object obj) {
        HashSet hashSet;
        if (obj == null) {
            return null;
        }
        Set a16 = a(obj, false);
        if (a16 == null) {
            return Collections.emptySet();
        }
        synchronized (a16) {
            hashSet = new HashSet(a16);
        }
        return hashSet;
    }

    public void a(Object obj, Consumer consumer) {
        if (obj == null || consumer == null) {
            return;
        }
        Iterator it = a(obj).iterator();
        while (it.hasNext()) {
            consumer.accept(it.next());
        }
    }

    public void a() {
        synchronized (this.f141498a) {
            Iterator it = this.f141498a.values().iterator();
            while (it.hasNext()) {
                ((Set) it.next()).clear();
            }
            this.f141498a.clear();
        }
    }
}
