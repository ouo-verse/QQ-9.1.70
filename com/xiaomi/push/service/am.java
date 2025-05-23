package com.xiaomi.push.service;

import android.content.Context;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes28.dex */
public class am {

    /* renamed from: c, reason: collision with root package name */
    private static am f389602c;

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, HashMap<String, b>> f389603a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private List<a> f389604b = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface a {
        void a();
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public enum c {
        unbind,
        binding,
        binded
    }

    am() {
    }

    public static synchronized am c() {
        am amVar;
        synchronized (am.class) {
            if (f389602c == null) {
                f389602c = new am();
            }
            amVar = f389602c;
        }
        return amVar;
    }

    private String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf("@");
        if (indexOf > 0) {
            return str.substring(0, indexOf);
        }
        return str;
    }

    public synchronized int a() {
        return this.f389603a.size();
    }

    public synchronized b b(String str, String str2) {
        HashMap<String, b> hashMap = this.f389603a.get(str);
        if (hashMap == null) {
            return null;
        }
        return hashMap.get(d(str2));
    }

    public synchronized ArrayList<b> e() {
        ArrayList<b> arrayList;
        arrayList = new ArrayList<>();
        Iterator<HashMap<String, b>> it = this.f389603a.values().iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().values());
        }
        return arrayList;
    }

    public synchronized Collection<b> f(String str) {
        if (!this.f389603a.containsKey(str)) {
            return new ArrayList();
        }
        return ((HashMap) this.f389603a.get(str).clone()).values();
    }

    public synchronized List<String> g(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<HashMap<String, b>> it = this.f389603a.values().iterator();
        while (it.hasNext()) {
            for (b bVar : it.next().values()) {
                if (str.equals(bVar.f389605a)) {
                    arrayList.add(bVar.f389612h);
                }
            }
        }
        return arrayList;
    }

    public synchronized void h() {
        Iterator<b> it = e().iterator();
        while (it.hasNext()) {
            it.next().f();
        }
        this.f389603a.clear();
    }

    public synchronized void i(Context context) {
        Iterator<HashMap<String, b>> it = this.f389603a.values().iterator();
        while (it.hasNext()) {
            Iterator<b> it5 = it.next().values().iterator();
            while (it5.hasNext()) {
                it5.next().k(c.unbind, 1, 3, null, null);
            }
        }
    }

    public synchronized void j(Context context, int i3) {
        Iterator<HashMap<String, b>> it = this.f389603a.values().iterator();
        while (it.hasNext()) {
            Iterator<b> it5 = it.next().values().iterator();
            while (it5.hasNext()) {
                it5.next().k(c.unbind, 2, i3, null, null);
            }
        }
    }

    public synchronized void k(a aVar) {
        this.f389604b.add(aVar);
    }

    public synchronized void l(b bVar) {
        HashMap<String, b> hashMap = this.f389603a.get(bVar.f389612h);
        if (hashMap == null) {
            hashMap = new HashMap<>();
            this.f389603a.put(bVar.f389612h, hashMap);
        }
        hashMap.put(d(bVar.f389606b), bVar);
        jz4.c.m("add active client. " + bVar.f389605a);
        Iterator<a> it = this.f389604b.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public synchronized void m(String str) {
        HashMap<String, b> hashMap = this.f389603a.get(str);
        if (hashMap != null) {
            Iterator<b> it = hashMap.values().iterator();
            while (it.hasNext()) {
                it.next().f();
            }
            hashMap.clear();
            this.f389603a.remove(str);
        }
        Iterator<a> it5 = this.f389604b.iterator();
        while (it5.hasNext()) {
            it5.next().a();
        }
    }

    public synchronized void n(String str, String str2) {
        HashMap<String, b> hashMap = this.f389603a.get(str);
        if (hashMap != null) {
            b bVar = hashMap.get(d(str2));
            if (bVar != null) {
                bVar.f();
            }
            hashMap.remove(d(str2));
            if (hashMap.isEmpty()) {
                this.f389603a.remove(str);
            }
        }
        Iterator<a> it = this.f389604b.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public synchronized void o() {
        this.f389604b.clear();
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f389605a;

        /* renamed from: b, reason: collision with root package name */
        public String f389606b;

        /* renamed from: c, reason: collision with root package name */
        public String f389607c;

        /* renamed from: d, reason: collision with root package name */
        public String f389608d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f389609e;

        /* renamed from: f, reason: collision with root package name */
        public String f389610f;

        /* renamed from: g, reason: collision with root package name */
        public String f389611g;

        /* renamed from: h, reason: collision with root package name */
        public String f389612h;

        /* renamed from: i, reason: collision with root package name */
        public String f389613i;

        /* renamed from: j, reason: collision with root package name */
        public String f389614j;

        /* renamed from: k, reason: collision with root package name */
        public an f389615k;

        /* renamed from: l, reason: collision with root package name */
        public Context f389616l;

        /* renamed from: p, reason: collision with root package name */
        private XMPushService f389620p;

        /* renamed from: r, reason: collision with root package name */
        Messenger f389622r;

        /* renamed from: m, reason: collision with root package name */
        c f389617m = c.unbind;

        /* renamed from: n, reason: collision with root package name */
        private int f389618n = 0;

        /* renamed from: o, reason: collision with root package name */
        private final CopyOnWriteArrayList<d> f389619o = new CopyOnWriteArrayList<>();

        /* renamed from: q, reason: collision with root package name */
        c f389621q = null;

        /* renamed from: s, reason: collision with root package name */
        private boolean f389623s = false;

        /* renamed from: t, reason: collision with root package name */
        private XMPushService.c f389624t = new XMPushService.c(this);

        /* renamed from: u, reason: collision with root package name */
        IBinder.DeathRecipient f389625u = null;

        /* renamed from: v, reason: collision with root package name */
        final C10091b f389626v = new C10091b();

        /* compiled from: P */
        /* loaded from: classes28.dex */
        class a implements d {
            a() {
            }

            @Override // com.xiaomi.push.service.am.b.d
            public void a(c cVar, c cVar2, int i3) {
                if (cVar2 == c.binding) {
                    b.this.f389620p.a(b.this.f389624t, 60000L);
                } else {
                    b.this.f389620p.b(b.this.f389624t);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: com.xiaomi.push.service.am$b$b, reason: collision with other inner class name */
        /* loaded from: classes28.dex */
        public class C10091b extends XMPushService.j {

            /* renamed from: e, reason: collision with root package name */
            int f389628e;

            /* renamed from: f, reason: collision with root package name */
            int f389629f;

            /* renamed from: h, reason: collision with root package name */
            String f389630h;

            /* renamed from: i, reason: collision with root package name */
            String f389631i;

            public C10091b() {
                super(0);
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            public void a() {
                if (b.this.l(this.f389628e, this.f389629f, this.f389631i)) {
                    b.this.g(this.f389628e, this.f389629f, this.f389630h, this.f389631i);
                    return;
                }
                jz4.c.w(" ignore notify client :" + b.this.f389612h);
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            public String e() {
                return "notify job";
            }

            public XMPushService.j f(int i3, int i16, String str, String str2) {
                this.f389628e = i3;
                this.f389629f = i16;
                this.f389631i = str2;
                this.f389630h = str;
                return this;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes28.dex */
        public class c implements IBinder.DeathRecipient {

            /* renamed from: d, reason: collision with root package name */
            final b f389633d;

            /* renamed from: e, reason: collision with root package name */
            final Messenger f389634e;

            c(b bVar, Messenger messenger) {
                this.f389633d = bVar;
                this.f389634e = messenger;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                jz4.c.w("peer died, chid = " + this.f389633d.f389612h);
                int i3 = 0;
                b.this.f389620p.a(new XMPushService.j(i3) { // from class: com.xiaomi.push.service.am.b.c.1
                    @Override // com.xiaomi.push.service.XMPushService.j
                    public void a() {
                        c cVar = c.this;
                        if (cVar.f389634e == cVar.f389633d.f389622r) {
                            jz4.c.w("clean peer, chid = " + c.this.f389633d.f389612h);
                            c.this.f389633d.f389622r = null;
                        }
                    }

                    @Override // com.xiaomi.push.service.XMPushService.j
                    public String e() {
                        return "clear peer job";
                    }
                }, 0L);
                if ("9".equals(this.f389633d.f389612h) && "com.xiaomi.xmsf".equals(b.this.f389620p.getPackageName())) {
                    b.this.f389620p.a(new XMPushService.j(i3) { // from class: com.xiaomi.push.service.am.b.c.2
                        @Override // com.xiaomi.push.service.XMPushService.j
                        public void a() {
                            am c16 = am.c();
                            b bVar = c.this.f389633d;
                            if (c16.b(bVar.f389612h, bVar.f389606b).f389622r == null) {
                                XMPushService xMPushService = b.this.f389620p;
                                b bVar2 = c.this.f389633d;
                                xMPushService.a(bVar2.f389612h, bVar2.f389606b, 2, null, null);
                            }
                        }

                        @Override // com.xiaomi.push.service.XMPushService.j
                        public String e() {
                            return "check peer job";
                        }
                    }, 60000L);
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes28.dex */
        public interface d {
            void a(c cVar, c cVar2, int i3);
        }

        public b() {
        }

        public static String e(String str) {
            int lastIndexOf;
            if (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf("/")) == -1) {
                return "";
            }
            return str.substring(lastIndexOf + 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(int i3, int i16, String str, String str2) {
            boolean z16;
            c cVar = this.f389617m;
            this.f389621q = cVar;
            if (i3 == 2) {
                this.f389615k.f(this.f389616l, this, i16);
                return;
            }
            if (i3 == 3) {
                this.f389615k.g(this.f389616l, this, str2, str);
                return;
            }
            if (i3 == 1) {
                if (cVar == c.binded) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16 && "wait".equals(str2)) {
                    this.f389618n++;
                } else if (z16) {
                    this.f389618n = 0;
                    if (this.f389622r != null) {
                        try {
                            this.f389622r.send(Message.obtain(null, 16, this.f389620p.f24867a));
                        } catch (RemoteException unused) {
                        }
                    }
                }
                this.f389615k.h(this.f389620p, this, z16, i16, str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean l(int i3, int i16, String str) {
            boolean z16;
            c cVar = this.f389621q;
            if (cVar == null || !(z16 = this.f389623s)) {
                return true;
            }
            if (cVar == this.f389617m) {
                jz4.c.w(" status recovered, don't notify client:" + this.f389612h);
                return false;
            }
            if (this.f389622r != null && z16) {
                jz4.c.w("Peer alive notify status to client:" + this.f389612h);
                return true;
            }
            jz4.c.w("peer died, ignore notify " + this.f389612h);
            return false;
        }

        private boolean o(int i3, int i16, String str) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        return false;
                    }
                    return !"wait".equals(str);
                }
                return this.f389620p.m462c();
            }
            if (this.f389617m != c.binded && this.f389620p.m462c() && i16 != 21 && (i16 != 7 || !"wait".equals(str))) {
                return true;
            }
            return false;
        }

        public long a() {
            return (((long) ((Math.random() * 20.0d) - 10.0d)) + ((this.f389618n + 1) * 15)) * 1000;
        }

        public String d(int i3) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        return "unknown";
                    }
                    return "KICK";
                }
                return "CLOSE";
            }
            return "OPEN";
        }

        void f() {
            try {
                Messenger messenger = this.f389622r;
                if (messenger != null && this.f389625u != null) {
                    messenger.getBinder().unlinkToDeath(this.f389625u, 0);
                }
            } catch (Exception unused) {
            }
            this.f389621q = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void h(Messenger messenger) {
            f();
            try {
                if (messenger != null) {
                    this.f389622r = messenger;
                    this.f389623s = true;
                    this.f389625u = new c(this, messenger);
                    messenger.getBinder().linkToDeath(this.f389625u, 0);
                } else {
                    jz4.c.w("peer linked with old sdk chid = " + this.f389612h);
                }
            } catch (Exception e16) {
                jz4.c.w("peer linkToDeath err: " + e16.getMessage());
                this.f389622r = null;
                this.f389623s = false;
            }
        }

        public void i(d dVar) {
            this.f389619o.add(dVar);
        }

        public void k(c cVar, int i3, int i16, String str, String str2) {
            boolean z16;
            Iterator<d> it = this.f389619o.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next != null) {
                    next.a(this.f389617m, cVar, i16);
                }
            }
            c cVar2 = this.f389617m;
            int i17 = 0;
            if (cVar2 != cVar) {
                jz4.c.m(String.format("update the client %7$s status. %1$s->%2$s %3$s %4$s %5$s %6$s", cVar2, cVar, d(i3), r.a(i16), str, str2, this.f389612h));
                this.f389617m = cVar;
            }
            if (this.f389615k == null) {
                jz4.c.B("status changed while the client dispatcher is missing");
                return;
            }
            if (cVar == c.binding) {
                return;
            }
            if (this.f389621q != null && (z16 = this.f389623s)) {
                i17 = (this.f389622r == null || !z16) ? 10100 : 1000;
            }
            this.f389620p.b(this.f389626v);
            if (o(i3, i16, str2)) {
                g(i3, i16, str, str2);
            } else {
                this.f389620p.a(this.f389626v.f(i3, i16, str, str2), i17);
            }
        }

        public void n(d dVar) {
            this.f389619o.remove(dVar);
        }

        public b(XMPushService xMPushService) {
            this.f389620p = xMPushService;
            i(new a());
        }
    }
}
