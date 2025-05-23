package com.tencent.mobileqq.guild.component.menu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    List<a> f215945a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    String f215946b;

    public void a(a aVar) {
        this.f215945a.add(aVar);
    }

    public a b(int i3) {
        return this.f215945a.get(i3);
    }

    public b c() {
        b bVar = new b();
        bVar.f215946b = this.f215946b;
        bVar.f215945a.addAll(this.f215945a);
        return bVar;
    }

    public int d() {
        return this.f215945a.size();
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        List<a> list = this.f215945a;
        if (list != null) {
            Iterator<a> it = list.iterator();
            while (it.hasNext()) {
                sb5.append(" " + it.next().f215942b);
            }
        }
        return sb5.toString();
    }
}
