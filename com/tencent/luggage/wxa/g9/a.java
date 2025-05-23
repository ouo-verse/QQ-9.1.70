package com.tencent.luggage.wxa.g9;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.j9.d f126611a;

    /* renamed from: b, reason: collision with root package name */
    public HashMap f126612b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public HashMap f126613c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public List f126614d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public LinkedList f126615e = new LinkedList();

    /* renamed from: f, reason: collision with root package name */
    public Object f126616f = new Object();

    public a(com.tencent.luggage.wxa.j9.d dVar) {
        this.f126611a = dVar;
        b();
    }

    public void c(com.tencent.luggage.wxa.qb.b bVar) {
        if (this.f126613c.containsKey(bVar.f138564a)) {
            this.f126613c.put(bVar.f138564a, bVar);
            d(bVar);
        }
    }

    public void d() {
        e();
        a();
        this.f126611a = null;
    }

    public void e() {
        n c16;
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecodeMgr", "stopAll");
        ArrayList arrayList = new ArrayList();
        synchronized (this.f126616f) {
            arrayList.addAll(this.f126615e);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            b bVar = (b) this.f126612b.get((String) it.next());
            if (bVar != null && !bVar.e() && !bVar.d() && (c16 = bVar.c()) != null) {
                c16.stop();
            }
        }
    }

    public void f(String str) {
        if (this.f126612b.containsKey(str) && this.f126615e.contains(str)) {
            h(str);
        }
        this.f126613c.remove(str);
        synchronized (this.f126616f) {
            this.f126615e.remove(str);
        }
    }

    public void g(String str) {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecodeMgr", "startDecode audioId:%s", str);
        a(str, false, false);
    }

    public void h(String str) {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecodeMgr", "stopDecode audioId:%s", str);
        b bVar = (b) this.f126612b.get(str);
        if (bVar == null) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioDecodeMgr", "task is not exist");
            return;
        }
        if (bVar.e()) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioDecodeMgr", "task is execute end!");
            return;
        }
        n c16 = bVar.c();
        if (c16 != null) {
            c16.stop();
            bVar.b();
            this.f126612b.remove(str);
        }
    }

    public void a() {
        this.f126612b.clear();
        this.f126615e.clear();
        this.f126613c.clear();
    }

    public void b() {
        com.tencent.luggage.wxa.d9.f.c().a();
    }

    public void b(com.tencent.luggage.wxa.qb.b bVar) {
        this.f126613c.put(bVar.f138564a, bVar);
    }

    public boolean b(String str) {
        boolean contains;
        synchronized (this.f126616f) {
            contains = this.f126614d.contains(str);
        }
        return contains;
    }

    public void c() {
        n c16;
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecodeMgr", "pauseAllOnBackground");
        ArrayList arrayList = new ArrayList();
        synchronized (this.f126616f) {
            arrayList.addAll(this.f126615e);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            b bVar = (b) this.f126612b.get((String) it.next());
            if (bVar != null && !bVar.e() && !bVar.d() && (c16 = bVar.c()) != null && !c16.d()) {
                c16.c();
            }
        }
    }

    public final void d(com.tencent.luggage.wxa.qb.b bVar) {
        b bVar2;
        n c16;
        if (d(bVar.f138564a) || (bVar2 = (b) this.f126612b.get(bVar.f138564a)) == null || (c16 = bVar2.c()) == null || c16.k()) {
            return;
        }
        float f16 = (float) bVar.f138575l;
        c16.a(f16, f16);
    }

    public void a(boolean z16) {
        synchronized (this.f126616f) {
            Iterator it = this.f126615e.iterator();
            while (it.hasNext()) {
                com.tencent.luggage.wxa.qb.b bVar = (com.tencent.luggage.wxa.qb.b) this.f126613c.get((String) it.next());
                if (bVar != null) {
                    if (z16) {
                        bVar.f138589z = z16;
                    } else {
                        com.tencent.luggage.wxa.j9.d dVar = this.f126611a;
                        if (dVar != null) {
                            dVar.b(bVar);
                        }
                    }
                }
            }
        }
    }

    public boolean b(String str, int i3) {
        if (!a(str, i3)) {
            return false;
        }
        a(str, i3);
        b bVar = (b) this.f126612b.get(str);
        if (bVar == null) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioDecodeMgr", "task is not exist");
            return false;
        }
        if (bVar.e()) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioDecodeMgr", "task is execute end!");
            return false;
        }
        if (bVar.d()) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioDecodeMgr", "task is isDetach!");
            return false;
        }
        n c16 = bVar.c();
        if (c16 == null) {
            return true;
        }
        c16.a(i3);
        return true;
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.g9.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6238a implements m {
        public C6238a() {
        }

        @Override // com.tencent.luggage.wxa.g9.m
        public void a(n nVar) {
            if (nVar == null) {
                com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioDecodeMgr", "process decoder is null");
                return;
            }
            com.tencent.luggage.wxa.qb.b b16 = nVar.b();
            nVar.i();
            nVar.e();
            nVar.release();
            synchronized (a.this.f126616f) {
                if (b16 != null) {
                    if (a.this.f126614d.contains(b16.f138566c)) {
                        a.this.f126614d.remove(b16.f138566c);
                    }
                }
            }
        }

        @Override // com.tencent.luggage.wxa.g9.m
        public void a(b bVar) {
            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecodeMgr", "decode process end");
            k.d(bVar);
        }
    }

    public boolean d(String str) {
        b bVar = (b) this.f126612b.get(str);
        return bVar == null || bVar.e() || bVar.d();
    }

    public void a(com.tencent.luggage.wxa.qb.b bVar) {
        boolean z16;
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecodeMgr", "prepareDecode");
        if (bVar == null) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioDecodeMgr", "param is null");
            return;
        }
        if (TextUtils.isEmpty(bVar.f138564a)) {
            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecodeMgr", "audioId is empty!");
            return;
        }
        if (!this.f126615e.contains(bVar.f138564a)) {
            synchronized (this.f126616f) {
                this.f126615e.add(bVar.f138564a);
            }
            this.f126613c.put(bVar.f138564a, bVar);
            z16 = false;
        } else {
            if (((com.tencent.luggage.wxa.qb.b) this.f126613c.get(bVar.f138564a)).a(bVar)) {
                com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecodeMgr", "is same param");
                z16 = false;
            } else {
                com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecodeMgr", "force to decode");
                z16 = true;
            }
            this.f126613c.put(bVar.f138564a, bVar);
        }
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecodeMgr", "ids:%d, id2ParamMap:%d", Integer.valueOf(this.f126615e.size()), Integer.valueOf(this.f126613c.size()));
        if (bVar.B) {
            boolean a16 = a(bVar.f138564a, z16, true);
            synchronized (this.f126616f) {
                if (a16) {
                    if (!this.f126614d.contains(bVar.f138566c)) {
                        this.f126614d.add(bVar.f138566c);
                    }
                }
            }
            return;
        }
        if (bVar.f138570g) {
            a(bVar.f138564a, z16, false);
            return;
        }
        boolean a17 = a(bVar.f138564a, z16, true);
        synchronized (this.f126616f) {
            if (a17) {
                if (!this.f126614d.contains(bVar.f138566c)) {
                    this.f126614d.add(bVar.f138566c);
                }
            }
        }
    }

    public void e(String str) {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecodeMgr", "pauseDecode audioId:%s", str);
        b bVar = (b) this.f126612b.get(str);
        if (bVar == null) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioDecodeMgr", "task is not exist");
            return;
        }
        if (bVar.e()) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioDecodeMgr", "task is execute end!");
            return;
        }
        if (bVar.d()) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioDecodeMgr", "task is isDetach!");
            return;
        }
        n c16 = bVar.c();
        if (c16 != null) {
            c16.pause();
        }
    }

    public boolean c(String str) {
        b bVar = (b) this.f126612b.get(str);
        if (bVar == null || !bVar.e() || this.f126611a.g().g() || this.f126611a.g().d(str)) {
            return false;
        }
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecodeMgr", "task is end, but not to play end");
        return true;
    }

    public final boolean a(String str, boolean z16, boolean z17) {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecodeMgr", "doDecodeAudio");
        if (this.f126611a == null) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioDecodeMgr", "mPlayer is null!");
            return false;
        }
        com.tencent.luggage.wxa.qb.b bVar = (com.tencent.luggage.wxa.qb.b) this.f126613c.get(str);
        if (bVar == null) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioDecodeMgr", "param for id %s is not exist!", str);
            return false;
        }
        b bVar2 = (b) this.f126612b.get(str);
        if (bVar2 != null) {
            if (bVar2.e() && !this.f126611a.g().g() && !this.f126611a.g().d(str)) {
                com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecodeMgr", "task is end, but not to play end");
                return true;
            }
            if (bVar2.e()) {
                com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecodeMgr", "task is end, reset source and decoder to run");
                bVar2.a();
                bVar2.a(h.a(this.f126611a, new com.tencent.luggage.wxa.l9.a(bVar), 1, z17));
                k.b(bVar2);
                return true;
            }
            n c16 = bVar2.c();
            if (c16 != null && z16) {
                com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecodeMgr", "force decode to stop and create new task to run");
                c16.stop();
            } else {
                if (c16 != null && c16.d() && !c16.g()) {
                    com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecodeMgr", "resume decoder to run");
                    c16.a();
                    return true;
                }
                if (c16 != null && c16.g()) {
                    com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecodeMgr", "decoder to stop, reset task run");
                    bVar2.a();
                    bVar2.a(h.a(this.f126611a, new com.tencent.luggage.wxa.l9.a(bVar), 1, z17));
                    k.b(bVar2);
                    return true;
                }
                if (c16 != null) {
                    com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecodeMgr", "task is run and playing audio");
                    return true;
                }
            }
        }
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecodeMgr", "task is not exist, create new task to run");
        n a16 = h.a(this.f126611a, new com.tencent.luggage.wxa.l9.a(bVar), 1, z17);
        b bVar3 = new b(new C6238a(), str, 5);
        bVar3.a(a16);
        k.b(bVar3);
        this.f126612b.put(str, bVar3);
        synchronized (this.f126616f) {
            if (!this.f126615e.contains(str)) {
                this.f126615e.add(str);
            }
        }
        return true;
    }

    public boolean a(String str, int i3) {
        com.tencent.luggage.wxa.qb.b bVar = (com.tencent.luggage.wxa.qb.b) this.f126613c.get(str);
        if (bVar == null) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioDecodeMgr", "param for id %s is not exist!", str);
            return false;
        }
        bVar.f138567d = i3;
        return true;
    }

    public long a(String str) {
        n c16;
        b bVar = (b) this.f126612b.get(str);
        if (bVar == null || (c16 = bVar.c()) == null) {
            return -1L;
        }
        return c16.getCurrentPosition();
    }
}
