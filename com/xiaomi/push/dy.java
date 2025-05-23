package com.xiaomi.push;

import com.tencent.mobileqq.vas.qid.QidPagView;
import com.xiaomi.push.ig;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ae;
import com.xiaomi.push.z;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/* compiled from: P */
/* loaded from: classes28.dex */
public class dy {

    /* renamed from: a, reason: collision with root package name */
    private String f388635a;

    /* renamed from: c, reason: collision with root package name */
    private int f388637c;

    /* renamed from: d, reason: collision with root package name */
    private long f388638d;

    /* renamed from: e, reason: collision with root package name */
    private dx f388639e;

    /* renamed from: b, reason: collision with root package name */
    private boolean f388636b = false;

    /* renamed from: f, reason: collision with root package name */
    private z f388640f = z.b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class a extends ae.b {
        a() {
        }

        @Override // com.xiaomi.push.service.ae.b
        public void c(cp cpVar) {
            if (cpVar.w()) {
                dy.f().h(cpVar.v());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        static final dy f388642a = new dy();
    }

    private ej b(z.a aVar) {
        if (aVar.f389872a == 0) {
            Object obj = aVar.f389874c;
            if (obj instanceof ej) {
                return (ej) obj;
            }
            return null;
        }
        ej a16 = a();
        a16.a(ei.CHANNEL_STATS_COUNTER.a());
        a16.c(aVar.f389872a);
        a16.c(aVar.f389873b);
        return a16;
    }

    private ek d(int i3) {
        ArrayList arrayList = new ArrayList();
        ek ekVar = new ek(this.f388635a, arrayList);
        if (!au.x(this.f388639e.f388629d)) {
            ekVar.a(ge.B(this.f388639e.f388629d));
        }
        hv hvVar = new hv(i3);
        hn a16 = new ig.a().a(hvVar);
        try {
            ekVar.b(a16);
        } catch (hu unused) {
        }
        LinkedList<z.a> c16 = this.f388640f.c();
        while (c16.size() > 0) {
            try {
                ej b16 = b(c16.getLast());
                if (b16 != null) {
                    b16.b(a16);
                }
                if (hvVar.h() > i3) {
                    break;
                }
                if (b16 != null) {
                    arrayList.add(b16);
                }
                c16.removeLast();
            } catch (hu | NoSuchElementException unused2) {
            }
        }
        return ekVar;
    }

    public static dx e() {
        dx dxVar;
        dy dyVar = b.f388642a;
        synchronized (dyVar) {
            dxVar = dyVar.f388639e;
        }
        return dxVar;
    }

    public static dy f() {
        return b.f388642a;
    }

    private void g() {
        if (this.f388636b && System.currentTimeMillis() - this.f388638d > this.f388637c) {
            this.f388636b = false;
            this.f388638d = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized ej a() {
        ej ejVar;
        ejVar = new ej();
        ejVar.a(au.j(this.f388639e.f388629d));
        ejVar.f388726a = (byte) 0;
        ejVar.f388727b = 1;
        ejVar.d((int) (System.currentTimeMillis() / 1000));
        return ejVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized ek c() {
        ek ekVar;
        int i3;
        if (l()) {
            if (!au.x(this.f388639e.f388629d)) {
                i3 = QidPagView.DESIGN_PAG_WIDTH;
            } else {
                i3 = 750;
            }
            ekVar = d(i3);
        } else {
            ekVar = null;
        }
        return ekVar;
    }

    public void h(int i3) {
        if (i3 > 0) {
            int i16 = i3 * 1000;
            if (i16 > 604800000) {
                i16 = 604800000;
            }
            if (this.f388637c != i16 || !this.f388636b) {
                this.f388636b = true;
                this.f388638d = System.currentTimeMillis();
                this.f388637c = i16;
                jz4.c.z("enable dot duration = " + i16 + " start = " + this.f388638d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void i(ej ejVar) {
        this.f388640f.e(ejVar);
    }

    public synchronized void j(XMPushService xMPushService) {
        this.f388639e = new dx(xMPushService);
        this.f388635a = "";
        com.xiaomi.push.service.ae.f().k(new a());
    }

    public boolean k() {
        return this.f388636b;
    }

    boolean l() {
        g();
        if (this.f388636b && this.f388640f.a() > 0) {
            return true;
        }
        return false;
    }
}
