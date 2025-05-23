package com.tencent.luggage.wxa.k;

import androidx.collection.ArrayMap;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/* compiled from: P */
/* loaded from: classes8.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayMap f131359a = new ArrayMap();

    public boolean a(q qVar) {
        for (a aVar : this.f131359a.keySet()) {
            if (aVar.a(qVar)) {
                SortedSet sortedSet = (SortedSet) this.f131359a.get(aVar);
                if (sortedSet.contains(qVar)) {
                    return false;
                }
                sortedSet.add(qVar);
                return true;
            }
        }
        TreeSet treeSet = new TreeSet();
        treeSet.add(qVar);
        this.f131359a.put(a.b(qVar.b(), qVar.a()), treeSet);
        return true;
    }

    public SortedSet b(a aVar) {
        return (SortedSet) this.f131359a.get(aVar);
    }

    public Set c() {
        return this.f131359a.keySet();
    }

    public boolean b() {
        return this.f131359a.isEmpty();
    }

    public void a(a aVar) {
        this.f131359a.remove(aVar);
    }

    public void a() {
        this.f131359a.clear();
    }
}
