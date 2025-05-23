package com.tencent.open.business.base;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes22.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    protected static d f341061b;

    /* renamed from: a, reason: collision with root package name */
    protected ArrayList<c> f341062a;

    protected d() {
    }

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (f341061b == null) {
                d dVar2 = new d();
                f341061b = dVar2;
                dVar2.f341062a = new ArrayList<>();
            }
            dVar = f341061b;
        }
        return dVar;
    }

    public ArrayList<c> b() {
        return f341061b.f341062a;
    }

    public void c(c cVar) {
        int size = f341061b.f341062a.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (f341061b.f341062a.get(i3) == cVar) {
                return;
            }
        }
        f341061b.f341062a.add(cVar);
    }

    public void d(c cVar) {
        int size = f341061b.f341062a.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (f341061b.f341062a.get(i3) == cVar) {
                f341061b.f341062a.remove(i3);
                return;
            }
        }
    }
}
