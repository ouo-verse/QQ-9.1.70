package com.tencent.mobileqq.utils.dialogutils;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    List<b> f307669a = new CopyOnWriteArrayList();

    /* renamed from: b, reason: collision with root package name */
    String f307670b;

    @Deprecated
    public void a(int i3, String str) {
        this.f307669a.add(new b(i3, str));
    }

    public void b(int i3, String str, int i16) {
        b bVar = new b(i3, str);
        bVar.f307673c = i16;
        this.f307669a.add(bVar);
    }

    public void c(b bVar) {
        if (bVar != null) {
            this.f307669a.add(bVar);
        }
    }

    public void d() {
        this.f307669a.clear();
    }

    public String e() {
        return this.f307670b;
    }

    public b f(int i3) {
        return this.f307669a.get(i3);
    }

    public a g() {
        a aVar = new a();
        aVar.f307670b = this.f307670b;
        aVar.f307669a.addAll(this.f307669a);
        return aVar;
    }

    public int h() {
        return this.f307669a.size();
    }

    public b[] i() {
        List<b> list = this.f307669a;
        if (list != null && list.size() > 0) {
            b[] bVarArr = new b[this.f307669a.size()];
            this.f307669a.toArray(bVarArr);
            return bVarArr;
        }
        return null;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        List<b> list = this.f307669a;
        if (list != null) {
            Iterator<b> it = list.iterator();
            while (it.hasNext()) {
                sb5.append(" " + it.next().f307671a);
            }
        }
        return sb5.toString();
    }
}
