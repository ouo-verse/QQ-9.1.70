package com.tencent.luggage.wxa.on;

import android.content.Context;
import android.os.Looper;
import com.tencent.luggage.wxa.ap.j;
import com.tencent.luggage.wxa.ca.i;
import com.tencent.luggage.wxa.so.h;
import com.tencent.luggage.wxa.tn.b0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mm.sdk.event.IListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public static a f137044d = new a();

    /* renamed from: a, reason: collision with root package name */
    public b f137045a = new b();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f137046b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f137047c = new HashMap();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.on.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6562a implements Comparator {
        public C6562a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(d dVar, d dVar2) {
            return dVar2.a() - dVar.a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b extends com.tencent.luggage.wxa.yo.d {
        @Override // com.tencent.luggage.wxa.yo.d
        public void a() {
        }

        @Override // com.tencent.luggage.wxa.yo.d
        public void a(Runnable runnable) {
            runnable.run();
        }

        @Override // com.tencent.luggage.wxa.yo.d
        public void a(Runnable runnable, long j3) {
            runnable.run();
        }
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean a(com.tencent.luggage.wxa.on.c cVar) {
        return a(cVar, false);
    }

    public com.tencent.luggage.wxa.to.b a(IListener iListener) {
        com.tencent.luggage.wxa.to.b a16;
        synchronized (this) {
            com.tencent.luggage.wxa.er.a.a("EventPoolImpl.add", (Object) iListener);
            w.g("MicroMsg.EventCenter", "addListener %s(%d)", iListener, Integer.valueOf(iListener.a()));
            c cVar = (c) this.f137047c.get(Integer.valueOf(iListener.a()));
            if (cVar == null) {
                HashMap hashMap = this.f137047c;
                Integer valueOf = Integer.valueOf(iListener.a());
                c cVar2 = new c();
                hashMap.put(valueOf, cVar2);
                cVar = cVar2;
            }
            a16 = cVar.a(iListener);
        }
        return a16;
    }

    public boolean a(com.tencent.luggage.wxa.on.c cVar, boolean z16) {
        c cVar2;
        Runnable runnable;
        com.tencent.luggage.wxa.er.a.a("EventPoolImpl.publish", (Object) cVar);
        boolean z17 = false;
        w.g("MicroMsg.EventCenter", "publish %s(%d)", cVar, Integer.valueOf(cVar.a()));
        List a16 = a(cVar.getClass());
        if (z16) {
            w.d("MicroMsg.EventCenter", "publishing " + cVar + " to " + a16.size() + "listeners:");
            Iterator it = a16.iterator();
            while (it.hasNext()) {
                w.d("MicroMsg.EventCenter", " - " + ((d) it.next()));
            }
        }
        boolean z18 = !a16.isEmpty();
        synchronized (this) {
            int a17 = cVar.a();
            List list = (List) this.f137046b.get(Integer.valueOf(a17));
            if (list != null) {
                new ArrayList(list);
                z18 = true;
            }
            cVar2 = (c) this.f137047c.get(Integer.valueOf(a17));
            if (cVar2 != null) {
                z18 = true;
            }
            if (!z18) {
                w.h("MicroMsg.EventCenter", "No listener for this event %s(%d), Stack: %s.", cVar, Integer.valueOf(a17), "");
            }
        }
        if (!a16.isEmpty()) {
            Collections.sort(a16, new C6562a());
            Iterator it5 = a16.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                d dVar = (d) it5.next();
                try {
                    h.a("[static] " + h.a(z.c(), dVar.getClass().getName()) + ".callback()");
                    if (dVar.a(cVar) && cVar.b()) {
                        w.h("MicroMsg.EventCenter", "event '%s' was consumed by listener '%s' so it will not be passed to other listeners.", cVar, a16);
                        z17 = true;
                        break;
                    }
                } finally {
                    h.a();
                }
            }
        }
        if (cVar2 != null) {
            cVar2.a(com.tencent.luggage.wxa.xo.h.b(cVar, Boolean.valueOf(z17)));
        } else if (!a16.isEmpty() && (runnable = cVar.f137055a) != null) {
            runnable.run();
        }
        return z18;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c extends com.tencent.luggage.wxa.to.a {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.on.a$c$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6563a implements Comparator {
            public C6563a() {
            }

            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(com.tencent.luggage.wxa.to.b bVar, com.tencent.luggage.wxa.to.b bVar2) {
                return ((IListener) bVar2.a()).b() - ((IListener) bVar.a()).b();
            }
        }

        public c() {
            super(a.this.f137045a);
        }

        public void a(j jVar) {
            LinkedList a16 = a();
            com.tencent.luggage.wxa.on.c cVar = (com.tencent.luggage.wxa.on.c) jVar.a(0);
            if (cVar == null) {
                w.b("MicroMsg.EventCenter", "event is null! fatal!");
                return;
            }
            if (!((Boolean) jVar.a(1)).booleanValue()) {
                if (cVar.b()) {
                    Collections.sort(a16, new C6563a());
                }
                int size = a16.size();
                com.tencent.luggage.wxa.to.b[] bVarArr = new com.tencent.luggage.wxa.to.b[size];
                a16.toArray(bVarArr);
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        break;
                    }
                    com.tencent.luggage.wxa.to.b bVar = bVarArr[i3];
                    IListener iListener = (IListener) bVar.a();
                    try {
                        h.a(h.a(z.c(), iListener.getClass().getName()) + ".callback()");
                        if (iListener.callback(cVar) && cVar.b()) {
                            w.h("MicroMsg.EventCenter", "event '%s' was consumed by listener '%s' so it will not be passed to other listeners.", cVar, bVar.a());
                            break;
                        }
                        i3++;
                    } finally {
                        h.a();
                    }
                }
            }
            Runnable runnable = cVar.f137055a;
            if (runnable != null) {
                runnable.run();
            }
        }

        public com.tencent.luggage.wxa.to.b a(IListener iListener) {
            return a(new com.tencent.luggage.wxa.to.b(iListener, this));
        }
    }

    public final List a(Class cls) {
        ArrayList arrayList = new ArrayList(32);
        Context c16 = z.c();
        for (i iVar : com.tencent.luggage.wxa.ca.b.a(d.class).a()) {
            if (com.tencent.luggage.wxa.ca.b.c(c16, iVar) && iVar.a(cls)) {
                arrayList.add((d) iVar.get());
            }
        }
        return arrayList;
    }

    public void a(final com.tencent.luggage.wxa.on.c cVar, Looper looper) {
        com.tencent.luggage.wxa.er.a.a("EventPoolImpl.asyncPublish event", (Object) cVar);
        com.tencent.luggage.wxa.er.a.a("EventPoolImpl.asyncPublish looper", (Object) looper);
        w.g("MicroMsg.EventCenter", "publish %s(%d)", cVar, Integer.valueOf(cVar.a()));
        new b0(looper).a(new Runnable() { // from class: q31.a
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.luggage.wxa.on.a.this.a(cVar);
            }
        });
    }
}
