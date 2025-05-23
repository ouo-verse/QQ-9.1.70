package com.tencent.luggage.wxa.oa;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    public static volatile b f136260b;

    /* renamed from: a, reason: collision with root package name */
    public Map f136261a = new ConcurrentHashMap();

    public static b a() {
        if (f136260b == null) {
            synchronized (b.class) {
                if (f136260b == null) {
                    f136260b = new b();
                }
            }
        }
        return f136260b;
    }

    public boolean b(String str, c cVar) {
        List list;
        boolean z16 = false;
        if (str != null && str.length() != 0 && cVar != null && (list = (List) this.f136261a.get(str)) != null) {
            synchronized (list) {
                z16 = list.remove(cVar);
            }
            if (list.isEmpty()) {
                this.f136261a.remove(str);
            }
        }
        return z16;
    }

    public boolean a(String str, c cVar) {
        boolean add;
        if (str == null || str.length() == 0 || cVar == null) {
            return false;
        }
        List list = (List) this.f136261a.get(str);
        if (list == null) {
            list = new LinkedList();
            this.f136261a.put(str, list);
        }
        if (list.contains(cVar)) {
            return false;
        }
        synchronized (list) {
            add = list.add(cVar);
        }
        return add;
    }
}
