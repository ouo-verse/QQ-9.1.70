package com.tencent.luggage.wxa.h9;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: f, reason: collision with root package name */
    private static final String f126928f = "MicroMsg.Audio.AudioDownloadMgr";

    /* renamed from: a, reason: collision with root package name */
    private volatile HashMap<String, c> f126929a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private volatile LinkedList<String> f126930b = new LinkedList<>();

    /* renamed from: c, reason: collision with root package name */
    private volatile ArrayList<String> f126931c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    private Object f126932d = new Object();

    /* renamed from: e, reason: collision with root package name */
    private f f126933e;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.h9.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6258a implements e {
        public C6258a() {
        }

        @Override // com.tencent.luggage.wxa.h9.e
        public void a(com.tencent.luggage.wxa.qb.b bVar) {
            String str = "";
            synchronized (a.this.f126932d) {
                if (bVar != null) {
                    a.this.f126929a.remove(bVar.f138565b);
                    str = bVar.f138565b;
                }
            }
            com.tencent.luggage.wxa.m9.b.a(a.f126928f, "download fail, src:%s", str);
        }

        @Override // com.tencent.luggage.wxa.h9.e
        public void b(com.tencent.luggage.wxa.qb.b bVar) {
            String str = "";
            synchronized (a.this.f126932d) {
                if (bVar != null) {
                    a.this.f126929a.remove(bVar.f138565b);
                    str = bVar.f138565b;
                    a.this.f126931c.add(bVar.f138565b);
                }
            }
            com.tencent.luggage.wxa.m9.b.b(a.f126928f, "download finish, src:%s", str);
            if (a.this.f126933e != null) {
                a.this.f126933e.a(bVar);
            }
        }
    }

    public abstract com.tencent.luggage.wxa.l9.c a(com.tencent.luggage.wxa.qb.b bVar);

    public void a(f fVar) {
        this.f126933e = fVar;
    }

    public void b() {
        a();
    }

    public void c() {
        com.tencent.luggage.wxa.m9.b.b(f126928f, "stopAll");
        Iterator<String> it = this.f126930b.iterator();
        while (it.hasNext()) {
            c cVar = this.f126929a.get(it.next());
            if (cVar != null && !cVar.e() && !cVar.d()) {
                g c16 = cVar.c();
                if (c16 != null) {
                    c16.stop();
                }
                cVar.b();
                this.f126929a.remove(cVar);
            } else {
                com.tencent.luggage.wxa.m9.b.a(f126928f, "task is not exist");
                cVar.b();
                this.f126929a.remove(cVar);
            }
        }
    }

    public void a() {
        this.f126929a.clear();
    }

    public boolean b(com.tencent.luggage.wxa.qb.b bVar) {
        com.tencent.luggage.wxa.m9.b.b(f126928f, "startDownload");
        if (bVar == null) {
            com.tencent.luggage.wxa.m9.b.a(f126928f, "param is null");
            return false;
        }
        if (TextUtils.isEmpty(bVar.f138565b)) {
            com.tencent.luggage.wxa.m9.b.a(f126928f, "srcUrl is null");
            return false;
        }
        if (this.f126931c.contains(bVar.f138565b)) {
            com.tencent.luggage.wxa.m9.b.a(f126928f, "srcUrl:%s is download finish", bVar.f138565b);
            return false;
        }
        if (this.f126929a.containsKey(bVar.f138565b)) {
            com.tencent.luggage.wxa.m9.b.a(f126928f, "task is exit!");
            return true;
        }
        com.tencent.luggage.wxa.m9.b.b(f126928f, "download src:%s, audioId:%s", bVar.f138565b, bVar.f138564a);
        c cVar = new c(new b(new C6258a()), bVar.f138564a, 5);
        cVar.a(a(bVar));
        d.b(cVar);
        synchronized (this.f126932d) {
            this.f126929a.put(bVar.f138565b, cVar);
            this.f126930b.add(bVar.f138565b);
        }
        return true;
    }

    public final boolean a(String str) {
        com.tencent.luggage.wxa.m9.b.b(f126928f, "stopDownload taskId:%s", str);
        c cVar = this.f126929a.get(str);
        if (cVar == null) {
            com.tencent.luggage.wxa.m9.b.a(f126928f, "task is not exist");
            return false;
        }
        if (cVar.e()) {
            com.tencent.luggage.wxa.m9.b.a(f126928f, "task is execute end!");
            cVar.b();
            this.f126929a.remove(cVar);
            return false;
        }
        g c16 = cVar.c();
        if (c16 != null) {
            c16.stop();
            cVar.b();
            this.f126929a.remove(str);
        }
        return true;
    }

    public boolean c(com.tencent.luggage.wxa.qb.b bVar) {
        return a(bVar.f138565b);
    }
}
