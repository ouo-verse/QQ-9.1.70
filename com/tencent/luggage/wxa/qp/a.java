package com.tencent.luggage.wxa.qp;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.luggage.wxa.sp.b;
import com.tencent.luggage.wxa.sp.d;
import com.tencent.luggage.wxa.wp.c;
import com.tencent.luggage.wxa.xp.e;
import com.tencent.luggage.wxa.xp.f;
import com.tencent.luggage.wxa.xp.g;
import com.tencent.luggage.wxa.xp.h;
import com.tencent.luggage.wxa.xp.i;
import com.tencent.luggage.wxa.xp.j;
import com.tencent.luggage.wxa.xp.k;
import com.tencent.luggage.wxa.xp.l;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.qp.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC6655a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f138956a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f138957b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f138958c;

        public RunnableC6655a(Context context, e eVar, b bVar) {
            this.f138956a = context;
            this.f138957b = eVar;
            this.f138958c = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            j jVar = new j(this.f138956a, this.f138957b);
            jVar.a(this.f138958c);
            if (!f.c().a(jVar, new d())) {
                com.tencent.luggage.wxa.np.e.b("Soter.SoterWrapperApi", "soter: add init task failed.", new Object[0]);
            }
        }
    }

    public static void a(Context context, b bVar, e eVar) {
        g.a().b(new RunnableC6655a(context, eVar, bVar));
    }

    public static boolean b() {
        return com.tencent.luggage.wxa.tp.b.c().e();
    }

    public static void c() {
        d();
        com.tencent.luggage.wxa.tp.b.c().a();
    }

    public static void d() {
        f.c().b();
    }

    public static void a(b bVar, boolean z16, c cVar) {
        com.tencent.luggage.wxa.np.e.c("Soter.SoterWrapperApi", "soter: starting prepare ask key. ", new Object[0]);
        k kVar = new k(cVar, z16);
        kVar.a(bVar);
        if (f.c().a(kVar, new com.tencent.luggage.wxa.sp.c())) {
            return;
        }
        com.tencent.luggage.wxa.np.e.a("Soter.SoterWrapperApi", "soter: add prepareAppSecureKey task failed.", new Object[0]);
    }

    public static void a(b bVar, boolean z16, boolean z17, int i3, c cVar, c cVar2) {
        com.tencent.luggage.wxa.np.e.c("Soter.SoterWrapperApi", "soter: starting prepare auth key: %d", Integer.valueOf(i3));
        l lVar = new l(i3, cVar, cVar2, z16, z17);
        lVar.a(bVar);
        if (f.c().a(lVar, new com.tencent.luggage.wxa.sp.c())) {
            return;
        }
        com.tencent.luggage.wxa.np.e.a("Soter.SoterWrapperApi", "soter: add prepareAuthKey task failed.", new Object[0]);
    }

    public static void a(b bVar, com.tencent.luggage.wxa.xp.b bVar2) {
        com.tencent.luggage.wxa.np.e.c("Soter.SoterWrapperApi", "soter: request authorize provide challenge. scene: %d", Integer.valueOf(bVar2.k()));
        if (bVar2.a() != 1 && bVar2.a() != 2) {
            h hVar = new h(bVar2);
            hVar.a(bVar);
            if (f.c().a(hVar, new com.tencent.luggage.wxa.sp.a())) {
                return;
            }
            com.tencent.luggage.wxa.np.e.a("Soter.SoterWrapperApi", "soter: add 1.0 requestAuthorizeAndSign task failed.", new Object[0]);
            return;
        }
        i iVar = new i(bVar2);
        iVar.a(bVar);
        if (f.c().a(iVar, new com.tencent.luggage.wxa.sp.a())) {
            return;
        }
        com.tencent.luggage.wxa.np.e.a("Soter.SoterWrapperApi", "soter: add 2.0 requestAuthorizeAndSign task failed.", new Object[0]);
    }

    public static boolean a(int i3) {
        boolean e16 = com.tencent.luggage.wxa.tp.b.c().e();
        String str = (String) com.tencent.luggage.wxa.tp.b.c().b().get(i3);
        if (e16 && !com.tencent.luggage.wxa.np.i.a(str)) {
            return com.tencent.luggage.wxa.jp.a.b(str, false).f135896a == 0;
        }
        if (!e16) {
            com.tencent.luggage.wxa.np.e.e("Soter.SoterWrapperApi", "soter: not initialized yet", new Object[0]);
            return false;
        }
        com.tencent.luggage.wxa.np.e.e("Soter.SoterWrapperApi", "soter: scene not registered in init. please make sure", new Object[0]);
        return false;
    }

    public static void a() {
        SparseArray b16 = com.tencent.luggage.wxa.tp.b.c().b();
        int size = b16.size();
        for (int i3 = 0; i3 < size; i3++) {
            com.tencent.luggage.wxa.jp.a.b((String) b16.valueAt(i3), false);
        }
        com.tencent.luggage.wxa.jp.a.i();
    }
}
