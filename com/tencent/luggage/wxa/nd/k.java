package com.tencent.luggage.wxa.nd;

import android.text.TextUtils;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

/* compiled from: P */
/* loaded from: classes8.dex */
public class k {

    /* renamed from: i, reason: collision with root package name */
    public static final String f135683i = "k";

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ boolean f135684j = true;

    /* renamed from: a, reason: collision with root package name */
    public CompositeSubscription f135685a;

    /* renamed from: b, reason: collision with root package name */
    public ReentrantReadWriteLock f135686b;

    /* renamed from: c, reason: collision with root package name */
    public Lock f135687c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f135688d;

    /* renamed from: e, reason: collision with root package name */
    public int f135689e;

    /* renamed from: f, reason: collision with root package name */
    public com.tencent.luggage.wxa.nd.g f135690f;

    /* renamed from: g, reason: collision with root package name */
    public Pattern f135691g;

    /* renamed from: h, reason: collision with root package name */
    public Set f135692h;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Action1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ld.e f135693a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.od.a f135694b;

        public a(com.tencent.luggage.wxa.ld.e eVar, com.tencent.luggage.wxa.od.a aVar) {
            this.f135693a = eVar;
            this.f135694b = aVar;
        }

        @Override // rx.functions.Action1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(com.tencent.luggage.wxa.pd.e eVar) {
            com.tencent.luggage.wxa.kd.a.b(k.f135683i, "Send Tcp Custom:" + this.f135693a.b() + " response: code=" + eVar.f137497c);
            com.tencent.luggage.wxa.od.a aVar = this.f135694b;
            if (aVar != null) {
                if (eVar.f137497c == 200) {
                    aVar.b(eVar);
                } else {
                    aVar.a(eVar);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Action1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.od.a f135696a;

        public b(com.tencent.luggage.wxa.od.a aVar) {
            this.f135696a = aVar;
        }

        @Override // rx.functions.Action1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Throwable th5) {
            if (th5 != null && th5.getMessage() != null) {
                com.tencent.luggage.wxa.kd.a.a(k.f135683i, "sendTcpCustom fail: " + th5.getMessage());
            }
            com.tencent.luggage.wxa.od.a aVar = this.f135696a;
            if (aVar != null) {
                aVar.a(null);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements Action1 {
        public d() {
        }

        @Override // rx.functions.Action1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Throwable th5) {
            if (th5 != null && th5.getMessage() != null) {
                com.tencent.luggage.wxa.kd.a.a(k.f135683i, "action send fail:" + th5.getMessage());
                return;
            }
            com.tencent.luggage.wxa.kd.a.a(k.f135683i, "action send fail");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements Action1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.pd.b f135700a;

        public e(com.tencent.luggage.wxa.pd.b bVar) {
            this.f135700a = bVar;
        }

        @Override // rx.functions.Action1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(com.tencent.luggage.wxa.md.b bVar) {
            if (bVar != null && bVar.f134426f != null && bVar.f134427g != null) {
                k.this.f135692h.remove(bVar.f134421a);
                com.tencent.luggage.wxa.md.c a16 = com.tencent.luggage.wxa.md.c.a(bVar);
                if (a16 != null) {
                    String b16 = k.this.b(this.f135700a.a("USN"));
                    if (!TextUtils.isEmpty(b16)) {
                        a16.c().f134431k = b16;
                        com.tencent.luggage.wxa.md.a.c().a(b16, a16);
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f implements Action1 {
        public f() {
        }

        @Override // rx.functions.Action1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Throwable th5) {
            k.this.f135692h.clear();
            if (th5 != null && th5.getMessage() != null) {
                com.tencent.luggage.wxa.kd.a.a(k.f135683i, "get mDevice info err:" + th5.getMessage());
                return;
            }
            com.tencent.luggage.wxa.kd.a.a(k.f135683i, "get mDevice info err");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public static k f135703a = new k(null);
    }

    public /* synthetic */ k(j jVar) {
        this();
    }

    public static k d() {
        return g.f135703a;
    }

    public boolean b() {
        com.tencent.luggage.wxa.kd.a.b(f135683i, "mRouter is shutting down...");
        if (!this.f135688d) {
            return false;
        }
        this.f135692h.clear();
        this.f135690f.b();
        this.f135685a.clear();
        this.f135688d = false;
        return true;
    }

    public boolean c() {
        com.tencent.luggage.wxa.kd.a.b(f135683i, "mRouter is starting ...");
        this.f135689e = l.a().b();
        try {
            if (this.f135688d) {
                return false;
            }
            com.tencent.luggage.wxa.nd.g gVar = new com.tencent.luggage.wxa.nd.g(new h("239.255.255.250", 1900), i.c(), this, this.f135689e);
            this.f135690f = gVar;
            gVar.f();
            this.f135688d = true;
            return true;
        } catch (Exception e16) {
            com.tencent.luggage.wxa.kd.a.a(f135683i, e16, "");
            return false;
        }
    }

    public final int e() {
        return 6000;
    }

    public k() {
        this.f135685a = new CompositeSubscription();
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock(true);
        this.f135686b = reentrantReadWriteLock;
        this.f135687c = reentrantReadWriteLock.writeLock();
        this.f135688d = false;
        this.f135689e = -1;
        this.f135692h = new HashSet();
        this.f135691g = Pattern.compile("uuid:([a-fA-F\\d]{8}(-[a-fA-F\\d]{4}){3}-[a-fA-F\\d]{12})");
    }

    public void a(boolean z16) {
        a(new com.tencent.luggage.wxa.ld.h(z16));
    }

    public void a(com.tencent.luggage.wxa.ld.e eVar, com.tencent.luggage.wxa.od.a aVar) {
        if (!this.f135688d) {
            com.tencent.luggage.wxa.kd.a.a(f135683i, "DLNA Router is not enable");
        } else {
            this.f135685a.add(new com.tencent.luggage.wxa.nd.c(eVar).b().subscribe(new a(eVar, aVar), new b(aVar)));
        }
    }

    public final boolean b(com.tencent.luggage.wxa.pd.b bVar) {
        String a16 = bVar.a("NT");
        String a17 = bVar.a(NowProxyConstants.AccountInfoKey.ST);
        String a18 = bVar.a("NTS");
        String a19 = bVar.a("USN");
        String a26 = bVar.a("LOCATION");
        if (!"upnp:rootdevice".equals(a16) && !"upnp:rootdevice".equals(a17)) {
            return false;
        }
        if (this.f135692h.size() > 0 && this.f135692h.contains(a26)) {
            return false;
        }
        String b16 = b(a19);
        if (TextUtils.isEmpty(b16)) {
            return false;
        }
        com.tencent.luggage.wxa.md.a c16 = com.tencent.luggage.wxa.md.a.c();
        if ("ssdp:alive".equals(a18)) {
            com.tencent.luggage.wxa.md.c b17 = c16.b(b16);
            if (b17 != null) {
                if (b17.c().f134421a.equals(a26)) {
                    return false;
                }
                c16.c(b16);
                this.f135692h.add(a26);
                return true;
            }
            if (TextUtils.isEmpty(a26)) {
                return false;
            }
            this.f135692h.add(a26);
            return true;
        }
        if ("ssdp:byebye".equals(a18)) {
            if (c16.a(b16)) {
                c16.c(b16);
            }
            return false;
        }
        if (TextUtils.isEmpty(a26)) {
            com.tencent.luggage.wxa.kd.a.a(f135683i, "mDevice location is empty");
            return false;
        }
        return !c16.a(b16);
    }

    public void a(com.tencent.luggage.wxa.ld.d dVar) {
        if (!this.f135688d) {
            com.tencent.luggage.wxa.kd.a.a(f135683i, "DLNA Router is not enable");
        } else {
            this.f135685a.add(new com.tencent.luggage.wxa.nd.d(dVar).b().subscribe(new c(), new d()));
        }
    }

    public void a(com.tencent.luggage.wxa.pd.b bVar) {
        try {
            a(this.f135687c);
            if (this.f135688d) {
                if (b(bVar)) {
                    this.f135685a.add(new com.tencent.luggage.wxa.nd.b(bVar).b().subscribe(new e(bVar), new f()));
                } else {
                    com.tencent.luggage.wxa.kd.a.b(f135683i, "parser fail");
                }
            }
        } catch (Exception e16) {
            com.tencent.luggage.wxa.kd.a.a(f135683i, e16, "");
        } finally {
            b(this.f135687c);
        }
    }

    public final String a(String str) {
        com.tencent.luggage.wxa.kd.a.a(f135683i, "fallbackGetUuid: " + str);
        return str.startsWith("uuid:") ? str.substring(5) : str;
    }

    public final void a(Lock lock, int i3) {
        try {
            if (lock.tryLock(i3, TimeUnit.MILLISECONDS)) {
                return;
            }
            throw new com.tencent.luggage.wxa.qd.a("Router wasn't available exclusively after waiting " + i3 + "ms, lock failed: " + lock.getClass().getSimpleName());
        } catch (InterruptedException e16) {
            throw new com.tencent.luggage.wxa.qd.a("Interruption while waiting for exclusive access: " + lock.getClass().getSimpleName(), e16);
        }
    }

    public final void a(Lock lock) {
        a(lock, e());
    }

    public final String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Matcher matcher = this.f135691g.matcher(str);
        String group = matcher.find() ? matcher.group(1) : null;
        if (group != null) {
            return group;
        }
        if (f135684j || str != null) {
            return a(str);
        }
        throw new AssertionError();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Action1 {
        public c() {
        }

        @Override // rx.functions.Action1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Void r16) {
        }
    }

    public final void b(Lock lock) {
        lock.unlock();
    }
}
