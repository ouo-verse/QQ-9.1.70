package com.tencent.biz.qqcircle.richframework.widget.menu;

import android.graphics.drawable.Drawable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    List<b> f92221a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    String f92222b;

    public void a(int i3, String str) {
        b(i3, str, null);
    }

    public void b(int i3, String str, Drawable drawable) {
        this.f92221a.add(new b(i3, str, drawable));
    }

    public void c(b bVar) {
        this.f92221a.add(bVar);
    }

    public b d(int i3) {
        return this.f92221a.get(i3);
    }

    public c e() {
        c cVar = new c();
        cVar.f92222b = this.f92222b;
        cVar.f92221a.addAll(this.f92221a);
        return cVar;
    }

    public int f() {
        return this.f92221a.size();
    }

    public b[] g() {
        List<b> list = this.f92221a;
        if (list != null && list.size() > 0) {
            b[] bVarArr = new b[this.f92221a.size()];
            this.f92221a.toArray(bVarArr);
            return bVarArr;
        }
        return null;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        List<b> list = this.f92221a;
        if (list != null) {
            Iterator<b> it = list.iterator();
            while (it.hasNext()) {
                sb5.append(" " + it.next().f92218b);
            }
        }
        return sb5.toString();
    }
}
