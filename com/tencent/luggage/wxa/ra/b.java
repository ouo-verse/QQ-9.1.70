package com.tencent.luggage.wxa.ra;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final Set f139430a = new HashSet();

    /* renamed from: b, reason: collision with root package name */
    public static final Map f139431b = new HashMap();

    public static void a(Object obj) {
        if (obj == null) {
            return;
        }
        Set set = f139430a;
        synchronized (set) {
            set.add(obj);
        }
    }

    public static void b(Object obj) {
        if (obj == null) {
            return;
        }
        Set set = f139430a;
        synchronized (set) {
            set.remove(obj);
        }
    }

    public static boolean a(String str, c cVar) {
        Set set;
        boolean add;
        if (str == null || str.length() == 0 || cVar == null) {
            return false;
        }
        Map map = f139431b;
        synchronized (map) {
            set = (Set) map.get(str);
            if (set == null) {
                set = new HashSet();
                map.put(str, set);
            }
        }
        com.tencent.luggage.wxa.ta.c.c("IPC.ObjectRecycler", "addIntoSet(%s)", str);
        synchronized (set) {
            add = set.add(cVar);
        }
        return add;
    }

    public static boolean b(String str, c cVar) {
        Set set;
        boolean remove;
        if (str == null || str.length() == 0 || cVar == null) {
            return false;
        }
        Map map = f139431b;
        synchronized (map) {
            set = (Set) map.get(str);
        }
        if (set == null) {
            return false;
        }
        com.tencent.luggage.wxa.ta.c.c("IPC.ObjectRecycler", "removeFromSet(%s)", str);
        synchronized (set) {
            remove = set.remove(cVar);
        }
        return remove;
    }

    public static void a(String str) {
        Set<c> set;
        if (str == null || str.length() == 0) {
            return;
        }
        Map map = f139431b;
        synchronized (map) {
            set = (Set) map.remove(str);
        }
        if (set == null) {
            return;
        }
        com.tencent.luggage.wxa.ta.c.c("IPC.ObjectRecycler", "recycleAll(%s)", str);
        synchronized (set) {
            for (c cVar : set) {
                com.tencent.luggage.wxa.ta.c.c("IPC.ObjectRecycler", "recycle(%s)", Integer.valueOf(cVar.hashCode()));
                cVar.recycle();
            }
            set.clear();
        }
    }
}
