package com.tencent.luggage.wxa.c6;

import com.tencent.luggage.wxa.fd.k0;
import com.tencent.luggage.wxa.fd.n0;
import com.tencent.luggage.wxa.ii.w;
import com.tencent.luggage.wxa.mc.e0;
import com.tencent.luggage.wxa.mc.l0;
import com.tencent.luggage.wxa.mc.o0;
import com.tencent.luggage.wxa.mc.p0;
import com.tencent.luggage.wxa.n3.v;
import com.tencent.luggage.wxa.o3.e;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mm.plugin.appbrand.appcache.predownload.storage.WxaSyncCmdPersistentStorage;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.support.Log;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicReference f123336a = new AtomicReference();

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicReference f123337b = new AtomicReference();

    /* renamed from: c, reason: collision with root package name */
    public static final Log.LogCallback f123338c = new j();

    /* renamed from: d, reason: collision with root package name */
    public static final Map f123339d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public static final Map f123340e;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements s {
        @Override // com.tencent.luggage.wxa.c6.b.s
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.tencent.luggage.wxa.p7.h a(com.tencent.luggage.wxa.xn.b bVar) {
            return new com.tencent.luggage.wxa.p7.h(bVar);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.c6.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6097b implements s {
        @Override // com.tencent.luggage.wxa.c6.b.s
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public p0 a(com.tencent.luggage.wxa.xn.b bVar) {
            return new p0(bVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements s {
        @Override // com.tencent.luggage.wxa.c6.b.s
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public w a(com.tencent.luggage.wxa.xn.b bVar) {
            return new w(bVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements s {
        @Override // com.tencent.luggage.wxa.c6.b.s
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public e0 a(com.tencent.luggage.wxa.xn.b bVar) {
            return new e0(bVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements s {
        @Override // com.tencent.luggage.wxa.c6.b.s
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.tencent.luggage.wxa.ii.s a(com.tencent.luggage.wxa.xn.b bVar) {
            return new com.tencent.luggage.wxa.ii.s(bVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f implements s {
        @Override // com.tencent.luggage.wxa.c6.b.s
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.tencent.luggage.wxa.tc.e a(com.tencent.luggage.wxa.xn.b bVar) {
            return new com.tencent.luggage.wxa.tc.e(bVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class g implements s {
        @Override // com.tencent.luggage.wxa.c6.b.s
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.tencent.luggage.wxa.sk.b a(com.tencent.luggage.wxa.xn.b bVar) {
            return new com.tencent.luggage.wxa.sk.b(bVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class h implements s {
        @Override // com.tencent.luggage.wxa.c6.b.s
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.tencent.luggage.wxa.ak.b a(com.tencent.luggage.wxa.xn.b bVar) {
            return new com.tencent.luggage.wxa.ak.b(bVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class i implements s {
        @Override // com.tencent.luggage.wxa.c6.b.s
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public WxaSyncCmdPersistentStorage a(com.tencent.luggage.wxa.xn.b bVar) {
            return new WxaSyncCmdPersistentStorage(bVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class j implements Log.LogCallback {
        @Override // com.tencent.wcdb.support.Log.LogCallback
        public void println(int i3, String str, String str2) {
            switch (i3) {
                case 2:
                    com.tencent.luggage.wxa.tn.w.e(str, str2);
                    return;
                case 3:
                    com.tencent.luggage.wxa.tn.w.a(str, str2);
                    return;
                case 4:
                    com.tencent.luggage.wxa.tn.w.d(str, str2);
                    return;
                case 5:
                    com.tencent.luggage.wxa.tn.w.f(str, str2);
                    return;
                case 6:
                case 7:
                    com.tencent.luggage.wxa.tn.w.b(str, str2);
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class k implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xn.b f123341a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.w4.a f123342b;

        public k(com.tencent.luggage.wxa.xn.b bVar, com.tencent.luggage.wxa.w4.a aVar) {
            this.f123341a = bVar;
            this.f123342b = aVar;
        }

        @Override // com.tencent.luggage.wxa.o3.e.a
        public void a(com.tencent.luggage.wxa.o3.j jVar) {
        }

        @Override // com.tencent.luggage.wxa.o3.e.a
        public void a() {
            try {
                synchronized (com.tencent.luggage.wxa.rc.b.class) {
                    this.f123341a.a("AppBrandKVData", "drop table AppBrandKVData".toUpperCase());
                    this.f123341a.a("AppBrandCommonKVData", "drop table AppBrandCommonKVData".toUpperCase());
                    b.a(this.f123341a);
                }
            } catch (Throwable th5) {
                com.tencent.luggage.wxa.tn.w.a("Luggage.WxaDBRegistry", th5, "drop kv table with userId %s", this.f123342b);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class l implements s {
        @Override // com.tencent.luggage.wxa.c6.b.s
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public k0 a(com.tencent.luggage.wxa.xn.b bVar) {
            return new k0(bVar, "WxaAttributesTable", com.tencent.luggage.wxa.q9.l.f138454r0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class m implements s {
        @Override // com.tencent.luggage.wxa.c6.b.s
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.tencent.luggage.wxa.ii.p a(com.tencent.luggage.wxa.xn.b bVar) {
            return new com.tencent.luggage.wxa.ii.p(bVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class n implements s {
        @Override // com.tencent.luggage.wxa.c6.b.s
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.tencent.luggage.wxa.ii.q a(com.tencent.luggage.wxa.xn.b bVar) {
            return new com.tencent.luggage.wxa.ii.q(bVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class o implements s {
        @Override // com.tencent.luggage.wxa.c6.b.s
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public l0 a(com.tencent.luggage.wxa.xn.b bVar) {
            return new l0(bVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class p implements s {
        @Override // com.tencent.luggage.wxa.c6.b.s
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.tencent.luggage.wxa.rc.b a(com.tencent.luggage.wxa.xn.b bVar) {
            return new com.tencent.luggage.wxa.rc.b(bVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class q implements s {
        @Override // com.tencent.luggage.wxa.c6.b.s
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.tencent.luggage.wxa.fd.e a(com.tencent.luggage.wxa.xn.b bVar) {
            return new com.tencent.luggage.wxa.fd.e(bVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class r implements s {
        @Override // com.tencent.luggage.wxa.c6.b.s
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.tencent.luggage.wxa.ii.i a(com.tencent.luggage.wxa.xn.b bVar) {
            return new com.tencent.luggage.wxa.ii.i(bVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface s {
        Object a(com.tencent.luggage.wxa.xn.b bVar);
    }

    static {
        a(new l(), new String[]{com.tencent.luggage.wxa.xn.c.a(n0.V0, "WxaAttributesTable")});
        a(new m(), com.tencent.luggage.wxa.ii.p.f130584g);
        a(new n(), com.tencent.luggage.wxa.ii.q.f130585g);
        a(new o(), l0.f134325c);
        a(new p(), com.tencent.luggage.wxa.rc.b.f139460j);
        a(new q(), com.tencent.luggage.wxa.fd.e.f125709h);
        a(new r(), com.tencent.luggage.wxa.ii.i.f130504g);
        a(new a(), com.tencent.luggage.wxa.p7.g.f137386r);
        a(new C6097b(), o0.f134348v);
        a(new c(), w.f130596g);
        a(new d(), e0.f134281j);
        a(new e(), com.tencent.luggage.wxa.ii.s.f130587g);
        a(new f(), com.tencent.luggage.wxa.tc.e.f141221g);
        a(new g(), com.tencent.luggage.wxa.sk.a.f140386r, true);
        a(new h(), com.tencent.luggage.wxa.ak.a.f121551t);
        a(new i(), WxaSyncCmdPersistentStorage.f151871e);
        f123340e = new HashMap();
    }

    public static com.tencent.luggage.wxa.xn.b a() {
        return a(new v(0));
    }

    public static void b() {
        Map map = f123340e;
        synchronized (map) {
            map.clear();
        }
        com.tencent.luggage.wxa.xn.b bVar = (com.tencent.luggage.wxa.xn.b) f123337b.get();
        if (bVar != null) {
            bVar.close();
        }
    }

    public static Iterator c() {
        HashMap hashMap;
        Map map = f123340e;
        synchronized (map) {
            hashMap = new HashMap(map);
        }
        return hashMap.entrySet().iterator();
    }

    public static com.tencent.luggage.wxa.xn.b a(com.tencent.luggage.wxa.w4.a aVar) {
        synchronized (b.class) {
            AtomicReference atomicReference = f123336a;
            if (aVar.equals(atomicReference.get())) {
                AtomicReference atomicReference2 = f123337b;
                if (atomicReference2.get() != null) {
                    return (com.tencent.luggage.wxa.xn.b) atomicReference2.get();
                }
            }
            com.tencent.luggage.wxa.er.a.b(z.m());
            b();
            File databasePath = z.c().getDatabasePath(String.format(Locale.US, "wxa_%s_common.db", aVar.toString()));
            a(databasePath);
            com.tencent.luggage.wxa.c6.a aVar2 = new com.tencent.luggage.wxa.c6.a(SQLiteDatabase.F(databasePath.getAbsolutePath(), null, 4));
            Log.f(f123338c);
            a(aVar2);
            atomicReference.set(aVar);
            f123337b.set(aVar2);
            com.tencent.luggage.wxa.o3.l.f136139a.b(new k(aVar2, aVar));
            return aVar2;
        }
    }

    public static void a(s sVar, String[] strArr, boolean z16) {
        if (z16) {
            com.tencent.luggage.wxa.c6.c.f123343a.a(sVar, strArr);
        } else {
            f123339d.put(sVar, strArr);
        }
    }

    public static void a(s sVar, String[] strArr) {
        a(sVar, strArr, false);
    }

    public static void a(com.tencent.luggage.wxa.xn.b bVar) {
        Map map = f123340e;
        synchronized (map) {
            map.clear();
            for (s sVar : f123339d.keySet()) {
                for (String str : (String[]) f123339d.get(sVar)) {
                    bVar.a((String) null, str);
                }
                Object a16 = sVar.a(bVar);
                f123340e.put(a16.getClass(), a16);
            }
        }
    }

    public static Object a(Class cls) {
        Objects.requireNonNull(cls, "Cant pass Null class here");
        a();
        com.tencent.luggage.wxa.c6.c cVar = com.tencent.luggage.wxa.c6.c.f123343a;
        cVar.a();
        Map map = f123340e;
        synchronized (map) {
            Object obj = map.get(cls);
            return obj != null ? obj : cVar.a(cls);
        }
    }

    public static boolean a(File file) {
        if (!file.exists()) {
            com.tencent.luggage.wxa.tn.w.d("Luggage.WxaDBRegistry", "try to create db file");
            File parentFile = file.getParentFile();
            if (parentFile == null) {
                return false;
            }
            if (!parentFile.exists()) {
                return parentFile.mkdirs();
            }
        }
        return true;
    }
}
