package com.tencent.luggage.wxa.tp;

import com.tencent.luggage.wxa.np.e;
import com.tencent.luggage.wxa.np.h;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static HashMap f141780a = new HashMap();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f141781a;

        /* renamed from: b, reason: collision with root package name */
        public int f141782b;

        /* renamed from: c, reason: collision with root package name */
        public String f141783c;

        public b() {
        }

        public void a(h hVar) {
            this.f141782b = hVar.f135896a;
            this.f141783c = hVar.f135897b;
            this.f141781a = 1;
        }
    }

    public static boolean a(Class cls, h hVar) {
        if (hVar.c()) {
            return false;
        }
        b bVar = (b) f141780a.get(cls);
        if (bVar == null) {
            bVar = new b();
            bVar.a(hVar);
            f141780a.put(cls, bVar);
        } else if (hVar.a() == bVar.f141782b && hVar.b().equals(bVar.f141783c)) {
            int i3 = bVar.f141781a + 1;
            bVar.f141781a = i3;
            if (i3 >= 2) {
                return true;
            }
        } else {
            bVar.a(hVar);
        }
        e.a("Soter.RemoveASKStrategy", "error counter: %s", Integer.valueOf(bVar.f141781a));
        return false;
    }
}
