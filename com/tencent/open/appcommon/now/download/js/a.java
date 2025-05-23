package com.tencent.open.appcommon.now.download.js;

import com.tencent.open.business.base.c;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    protected static a f340728b;

    /* renamed from: a, reason: collision with root package name */
    protected ArrayList<c> f340729a;

    protected a() {
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f340728b == null) {
                a aVar2 = new a();
                f340728b = aVar2;
                aVar2.f340729a = new ArrayList<>();
            }
            aVar = f340728b;
        }
        return aVar;
    }

    public ArrayList<c> b() {
        return f340728b.f340729a;
    }

    public void c(c cVar) {
        int size = f340728b.f340729a.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (f340728b.f340729a.get(i3) == cVar) {
                return;
            }
        }
        f340728b.f340729a.add(cVar);
    }

    public void d(c cVar) {
        int size = f340728b.f340729a.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (f340728b.f340729a.get(i3) == cVar) {
                f340728b.f340729a.remove(i3);
                return;
            }
        }
    }
}
