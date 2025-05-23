package com.tencent.luggage.wxa.ge;

import com.tencent.luggage.wxa.ic.e;
import com.tencent.luggage.wxa.ne.k;
import com.tencent.luggage.wxa.tn.z;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends e.c implements h {

    /* renamed from: a, reason: collision with root package name */
    public final String f126681a;

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.luggage.wxa.je.b f126683c;

    /* renamed from: b, reason: collision with root package name */
    public volatile boolean f126682b = false;

    /* renamed from: d, reason: collision with root package name */
    public final List f126684d = new CopyOnWriteArrayList();

    /* renamed from: e, reason: collision with root package name */
    public final List f126685e = new CopyOnWriteArrayList();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements com.tencent.luggage.wxa.ne.i {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.ne.i
        public void a(String str, boolean z16) {
            Iterator it = b.this.f126685e.iterator();
            while (it.hasNext()) {
                ((com.tencent.luggage.wxa.ne.i) it.next()).a(str, z16);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ge.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class C6241b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f126687a;

        static {
            int[] iArr = new int[com.tencent.luggage.wxa.ge.c.values().length];
            f126687a = iArr;
            try {
                iArr[com.tencent.luggage.wxa.ge.c.REJECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f126687a[com.tencent.luggage.wxa.ge.c.ACCEPTED_IN_FOREGROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f126687a[com.tencent.luggage.wxa.ge.c.ALWAYS_ACCEPTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface c {
        void a(boolean z16);
    }

    public b(String str) {
        this.f126681a = str;
    }

    public void b(c cVar) {
        a(cVar);
    }

    public synchronized void c() {
        com.tencent.luggage.wxa.je.b bVar = new com.tencent.luggage.wxa.je.b(z.c());
        this.f126683c = bVar;
        bVar.b();
        this.f126683c.a(new a());
    }

    public boolean d() {
        com.tencent.luggage.wxa.je.b b16 = b();
        if (b16 != null) {
            return b16.c();
        }
        return false;
    }

    public boolean e() {
        return com.tencent.luggage.wxa.pe.c.a();
    }

    public k f() {
        com.tencent.luggage.wxa.je.b b16 = b();
        if (b16 != null) {
            return b16.d();
        }
        return k.f135746f;
    }

    public synchronized void g() {
        com.tencent.luggage.wxa.je.b bVar = this.f126683c;
        if (bVar != null) {
            bVar.e();
            this.f126683c = null;
        }
        this.f126685e.clear();
        this.f126684d.clear();
        this.f126682b = false;
    }

    @Override // com.tencent.luggage.wxa.ic.e.c
    public void onDestroy() {
        com.tencent.luggage.wxa.ge.a.a(this.f126681a);
    }

    public void a(c cVar) {
        this.f126684d.add(cVar);
    }

    public void b(boolean z16) {
        Iterator it = this.f126684d.iterator();
        while (it.hasNext()) {
            ((c) it.next()).a(z16);
        }
    }

    public void a(com.tencent.luggage.wxa.ne.i iVar) {
        this.f126685e.add(iVar);
    }

    public void a(com.tencent.luggage.wxa.ne.h hVar) {
        com.tencent.luggage.wxa.je.b b16 = b();
        if (b16 != null) {
            b16.a(hVar);
        }
    }

    public void b(com.tencent.luggage.wxa.ne.i iVar) {
        a(iVar);
    }

    public void c(boolean z16) {
        this.f126682b = z16;
    }

    public final synchronized com.tencent.luggage.wxa.je.b b() {
        com.tencent.luggage.wxa.je.b bVar;
        bVar = this.f126683c;
        if (bVar == null) {
            com.tencent.luggage.wxa.pe.a.d("MicroMsg.ble.BleWorker", "getBleManager, bleManager is null", new Object[0]);
        }
        return bVar;
    }

    public void a(com.tencent.luggage.wxa.ne.g gVar) {
        com.tencent.luggage.wxa.je.b b16 = b();
        if (b16 != null) {
            b16.a(gVar);
        }
    }

    public void a(com.tencent.luggage.wxa.je.a aVar) {
        com.tencent.luggage.wxa.je.b b16 = b();
        if (b16 != null) {
            b16.a(aVar);
        }
    }

    public void a(com.tencent.luggage.wxa.ne.b bVar, List list, com.tencent.luggage.wxa.ne.j jVar) {
        com.tencent.luggage.wxa.je.b b16 = b();
        if (b16 != null) {
            b16.a(bVar, list, jVar);
        }
    }

    public List a() {
        com.tencent.luggage.wxa.je.b b16 = b();
        if (b16 != null) {
            return b16.a();
        }
        return null;
    }

    public List a(boolean z16) {
        com.tencent.luggage.wxa.je.b b16 = b();
        if (b16 != null) {
            return b16.a(z16);
        }
        return null;
    }

    public List a(List list, boolean z16) {
        com.tencent.luggage.wxa.je.b b16 = b();
        if (b16 != null) {
            return b16.a(list, z16);
        }
        return null;
    }

    public void a(String str, com.tencent.luggage.wxa.ne.a aVar, com.tencent.luggage.wxa.ne.b bVar) {
        com.tencent.luggage.wxa.je.b b16 = b();
        if (b16 != null) {
            b16.a(str, aVar, bVar);
        }
    }

    public List a(String str) {
        return a(str, true);
    }

    public List a(String str, boolean z16) {
        com.tencent.luggage.wxa.je.b b16 = b();
        if (b16 != null) {
            return b16.a(str, z16);
        }
        return null;
    }

    public List a(String str, String str2) {
        com.tencent.luggage.wxa.je.b b16 = b();
        if (b16 != null) {
            return b16.a(str, str2);
        }
        return null;
    }

    public com.tencent.luggage.wxa.ne.c a(String str, String str2, String str3, Integer num) {
        com.tencent.luggage.wxa.je.b b16 = b();
        if (b16 != null) {
            return b16.a(str, str2, str3, num);
        }
        return null;
    }

    @Override // com.tencent.luggage.wxa.ge.h
    public void a(com.tencent.luggage.wxa.ge.c cVar) {
        com.tencent.luggage.wxa.pe.a.c("MicroMsg.ble.BleWorker", "onAuthorizeStateChange, newState: " + cVar, new Object[0]);
        int i3 = C6241b.f126687a[cVar.ordinal()];
        if (i3 == 1) {
            com.tencent.luggage.wxa.ge.a.a(this.f126681a);
        } else if (i3 == 2) {
            c(false);
        } else {
            if (i3 != 3) {
                return;
            }
            c(true);
        }
    }
}
