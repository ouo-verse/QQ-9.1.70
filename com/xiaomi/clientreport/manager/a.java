package com.xiaomi.clientreport.manager;

import android.content.Context;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import com.xiaomi.push.ae;
import com.xiaomi.push.ag;
import com.xiaomi.push.an;
import com.xiaomi.push.ap;
import com.xiaomi.push.bi;
import com.xiaomi.push.bj;
import com.xiaomi.push.bk;
import com.xiaomi.push.hz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import kz4.c;
import kz4.d;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {

    /* renamed from: i, reason: collision with root package name */
    private static final int f387950i;

    /* renamed from: j, reason: collision with root package name */
    private static volatile a f387951j;

    /* renamed from: a, reason: collision with root package name */
    private ExecutorService f387952a = ProxyExecutors.newSingleThreadExecutor();

    /* renamed from: b, reason: collision with root package name */
    private HashMap<String, HashMap<String, d>> f387953b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private HashMap<String, ArrayList<d>> f387954c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private Context f387955d;

    /* renamed from: e, reason: collision with root package name */
    private kz4.a f387956e;

    /* renamed from: f, reason: collision with root package name */
    private String f387957f;

    /* renamed from: g, reason: collision with root package name */
    private lz4.a f387958g;

    /* renamed from: h, reason: collision with root package name */
    private lz4.b f387959h;

    static {
        int i3;
        if (hz.i()) {
            i3 = 30;
        } else {
            i3 = 10;
        }
        f387950i = i3;
    }

    a(Context context) {
        this.f387955d = context;
    }

    private void A() {
        if (!c(this.f387955d).e().h()) {
            return;
        }
        final bj bjVar = new bj(this.f387955d);
        int e16 = (int) c(this.f387955d).e().e();
        if (e16 < 1800) {
            e16 = 1800;
        }
        if (System.currentTimeMillis() - ap.b(this.f387955d).a("sp_client_report_status", "perf_last_upload_time", 0L) > e16 * 1000) {
            ae.b(this.f387955d).h(new Runnable() { // from class: com.xiaomi.clientreport.manager.a.6
                @Override // java.lang.Runnable
                public void run() {
                    bjVar.run();
                }
            }, 15);
        }
        synchronized (a.class) {
            if (!ae.b(this.f387955d).j(bjVar, e16)) {
                ae.b(this.f387955d).m("100887");
                ae.b(this.f387955d).j(bjVar, e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a() {
        int i3;
        HashMap<String, ArrayList<d>> hashMap = this.f387954c;
        if (hashMap == null) {
            return 0;
        }
        Iterator<String> it = hashMap.keySet().iterator();
        int i16 = 0;
        while (it.hasNext()) {
            ArrayList<d> arrayList = this.f387954c.get(it.next());
            if (arrayList != null) {
                i3 = arrayList.size();
            } else {
                i3 = 0;
            }
            i16 += i3;
        }
        return i16;
    }

    public static a c(Context context) {
        if (f387951j == null) {
            synchronized (a.class) {
                if (f387951j == null) {
                    f387951j = new a(context);
                }
            }
        }
        return f387951j;
    }

    private void k(ae.a aVar, int i3) {
        ae.b(this.f387955d).n(aVar, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int q() {
        HashMap<String, HashMap<String, d>> hashMap = this.f387953b;
        int i3 = 0;
        if (hashMap != null) {
            Iterator<String> it = hashMap.keySet().iterator();
            while (it.hasNext()) {
                HashMap<String, d> hashMap2 = this.f387953b.get(it.next());
                if (hashMap2 != null) {
                    Iterator<String> it5 = hashMap2.keySet().iterator();
                    while (it5.hasNext()) {
                        d dVar = hashMap2.get(it5.next());
                        if (dVar instanceof c) {
                            i3 = (int) (i3 + ((c) dVar).f413527i);
                        }
                    }
                }
            }
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(kz4.b bVar) {
        lz4.a aVar = this.f387958g;
        if (aVar != null) {
            aVar.b(bVar);
            if (a() >= 10) {
                x();
                ae.b(this.f387955d).m("100888");
            } else {
                k(new ae.a() { // from class: com.xiaomi.clientreport.manager.a.3
                    @Override // com.xiaomi.push.ae.a
                    public String e() {
                        return "100888";
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.a() > 0) {
                            a.this.f387952a.execute(new Runnable() { // from class: com.xiaomi.clientreport.manager.a.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    a.this.x();
                                }
                            });
                        }
                    }
                }, f387950i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(c cVar) {
        lz4.b bVar = this.f387959h;
        if (bVar != null) {
            bVar.b(cVar);
            if (q() >= 10) {
                y();
                ae.b(this.f387955d).m("100889");
            } else {
                k(new ae.a() { // from class: com.xiaomi.clientreport.manager.a.4
                    @Override // com.xiaomi.push.ae.a
                    public String e() {
                        return "100889";
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.q() > 0) {
                            a.this.f387952a.execute(new Runnable() { // from class: com.xiaomi.clientreport.manager.a.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    a.this.y();
                                }
                            });
                        }
                    }
                }, f387950i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        try {
            this.f387958g.b();
        } catch (Exception e16) {
            jz4.c.B("we: " + e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        try {
            this.f387959h.b();
        } catch (Exception e16) {
            jz4.c.B("wp: " + e16.getMessage());
        }
    }

    private void z() {
        if (!c(this.f387955d).e().g()) {
            return;
        }
        final bi biVar = new bi(this.f387955d);
        int c16 = (int) c(this.f387955d).e().c();
        if (c16 < 1800) {
            c16 = 1800;
        }
        if (System.currentTimeMillis() - ap.b(this.f387955d).a("sp_client_report_status", "event_last_upload_time", 0L) > c16 * 1000) {
            ae.b(this.f387955d).h(new Runnable() { // from class: com.xiaomi.clientreport.manager.a.5
                @Override // java.lang.Runnable
                public void run() {
                    biVar.run();
                }
            }, 10);
        }
        synchronized (a.class) {
            if (!ae.b(this.f387955d).j(biVar, c16)) {
                ae.b(this.f387955d).m("100886");
                ae.b(this.f387955d).j(biVar, c16);
            }
        }
    }

    public synchronized kz4.a e() {
        if (this.f387956e == null) {
            this.f387956e = kz4.a.a(this.f387955d);
        }
        return this.f387956e;
    }

    public kz4.b f(int i3, String str) {
        kz4.b bVar = new kz4.b();
        bVar.f413525k = str;
        bVar.f413524j = System.currentTimeMillis();
        bVar.f413523i = i3;
        bVar.f413522h = ag.a(6);
        bVar.f413529a = 1000;
        bVar.f413531c = 1001;
        bVar.f413530b = "E100004";
        bVar.a(this.f387955d.getPackageName());
        bVar.b(this.f387957f);
        return bVar;
    }

    public void g() {
        c(this.f387955d).z();
        c(this.f387955d).A();
    }

    public void l(String str) {
        this.f387957f = str;
    }

    public void m(kz4.a aVar, lz4.a aVar2, lz4.b bVar) {
        this.f387956e = aVar;
        this.f387958g = aVar2;
        this.f387959h = bVar;
        aVar2.a(this.f387954c);
        this.f387959h.c(this.f387953b);
    }

    public void n(final kz4.b bVar) {
        if (e().g()) {
            this.f387952a.execute(new Runnable() { // from class: com.xiaomi.clientreport.manager.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.u(bVar);
                }
            });
        }
    }

    public void o(final c cVar) {
        if (e().h()) {
            this.f387952a.execute(new Runnable() { // from class: com.xiaomi.clientreport.manager.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.v(cVar);
                }
            });
        }
    }

    public void p(boolean z16, boolean z17, long j3, long j16) {
        kz4.a aVar = this.f387956e;
        if (aVar != null) {
            if (z16 != aVar.g() || z17 != this.f387956e.h() || j3 != this.f387956e.c() || j16 != this.f387956e.e()) {
                long c16 = this.f387956e.c();
                long e16 = this.f387956e.e();
                kz4.a h16 = kz4.a.b().i(an.b(this.f387955d)).j(this.f387956e.f()).l(z16).k(j3).o(z17).n(j16).h(this.f387955d);
                this.f387956e = h16;
                if (!h16.g()) {
                    ae.b(this.f387955d).m("100886");
                } else if (c16 != h16.c()) {
                    jz4.c.z(this.f387955d.getPackageName() + "reset event job " + h16.c());
                    z();
                }
                if (!this.f387956e.h()) {
                    ae.b(this.f387955d).m("100887");
                    return;
                }
                if (e16 != h16.e()) {
                    jz4.c.z(this.f387955d.getPackageName() + " reset perf job " + h16.e());
                    A();
                }
            }
        }
    }

    public void s() {
        if (e().g()) {
            bk bkVar = new bk();
            bkVar.a(this.f387955d);
            bkVar.b(this.f387958g);
            this.f387952a.execute(bkVar);
        }
    }

    public void w() {
        if (e().h()) {
            bk bkVar = new bk();
            bkVar.b(this.f387959h);
            bkVar.a(this.f387955d);
            this.f387952a.execute(bkVar);
        }
    }
}
