package com.tencent.luggage.wxa.s1;

import com.tencent.luggage.wxa.aa.h;
import com.tencent.luggage.wxa.da.a;
import com.tencent.luggage.wxa.jo.a;
import com.tencent.luggage.wxa.ko.a;
import com.tencent.luggage.wxa.p8.b;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements b.c {
        @Override // com.tencent.luggage.wxa.p8.b.c
        public String a(String str) {
            w.d("MicroMsg.MBLoadDelegateRegistry", "findLibrary libName:%s", str);
            return h.c(str);
        }

        @Override // com.tencent.luggage.wxa.p8.b.c
        public void loadLibrary(String str) {
            try {
                w.d("MicroMsg.MBLoadDelegateRegistry", "loadLibrary libName:%s", str);
                h.b(str, d.class.getClassLoader());
            } catch (UnsatisfiedLinkError e16) {
                w.a("MicroMsg.MBLoadDelegateRegistry", e16, "hy: link %s error!!", str);
                d.c();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements a.b {
        @Override // com.tencent.luggage.wxa.ko.a.b
        public void loadLibrary(String str) {
            try {
                w.d("MicroMsg.MBLoadDelegateRegistry", "loadLibrary libName:%s", str);
                h.b(str, d.class.getClassLoader());
            } catch (UnsatisfiedLinkError e16) {
                w.a("MicroMsg.MBLoadDelegateRegistry", e16, "hy: link %s error!!", str);
                d.c();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements a.b {
        @Override // com.tencent.luggage.wxa.jo.a.b
        public void loadLibrary(String str) {
            try {
                w.d("MicroMsg.MBLoadDelegateRegistry", "loadLibrary libName:%s", str);
                h.b(str, d.class.getClassLoader());
            } catch (UnsatisfiedLinkError e16) {
                w.a("MicroMsg.MBLoadDelegateRegistry", e16, "hy: link %s error!!", str);
                d.c();
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.s1.d$d, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6700d implements a.b {
        @Override // com.tencent.luggage.wxa.da.a.b
        public void loadLibrary(String str) {
            try {
                w.d("MicroMsg.MBLoadDelegateRegistry", "loadLibrary libName:%s", str);
                h.b(str, d.class.getClassLoader());
            } catch (UnsatisfiedLinkError e16) {
                w.a("MicroMsg.MBLoadDelegateRegistry", e16, "hy: link %s error!!", str);
                d.c();
            }
        }
    }

    public static void b() {
        com.tencent.luggage.wxa.p8.b.a(new a());
        com.tencent.luggage.wxa.ko.a.a(new b());
        com.tencent.luggage.wxa.jo.a.a(new c());
        com.tencent.luggage.wxa.da.a.a(new C6700d());
    }

    public static void c() {
        com.tencent.luggage.wxa.y9.a.makeText(z.c(), R.string.z2u, 1).show();
    }
}
