package c.t.m.g;

import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes.dex */
public class q implements Observer {

    /* renamed from: g, reason: collision with root package name */
    public static volatile String f29941g = "";

    /* renamed from: h, reason: collision with root package name */
    public static volatile String f29942h = "";

    /* renamed from: i, reason: collision with root package name */
    public static volatile String f29943i = "";

    /* renamed from: j, reason: collision with root package name */
    public static final HashMap<String, String> f29944j = new HashMap<>();

    /* renamed from: k, reason: collision with root package name */
    public static volatile q f29945k = null;

    /* renamed from: b, reason: collision with root package name */
    public volatile ConcurrentHashMap<String, String> f29947b;

    /* renamed from: c, reason: collision with root package name */
    public volatile ConcurrentHashMap<String, List<o>> f29948c;

    /* renamed from: a, reason: collision with root package name */
    public HashMap<Class<?>, Object> f29946a = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f29949d = false;

    /* renamed from: e, reason: collision with root package name */
    public AtomicBoolean f29950e = new AtomicBoolean(true);

    /* renamed from: f, reason: collision with root package name */
    public AtomicBoolean f29951f = new AtomicBoolean(true);

    public q() {
        this.f29947b = null;
        this.f29948c = null;
        HashMap<String, String> hashMap = f29944j;
        this.f29947b = new ConcurrentHashMap<>(((hashMap.size() * 4) / 3) + 1);
        this.f29948c = new ConcurrentHashMap<>(((hashMap.size() * 4) / 3) + 1);
        this.f29946a.put(String.class, "");
        this.f29946a.put(Integer.class, Integer.MIN_VALUE);
        this.f29946a.put(Float.class, Float.valueOf(Float.MIN_VALUE));
        this.f29946a.put(Double.class, Double.valueOf(Double.MIN_VALUE));
        this.f29946a.put(Long.class, Long.MIN_VALUE);
        this.f29946a.put(Boolean.class, Boolean.FALSE);
        c();
    }

    public static void a(String str, String str2) {
        f29941g = str;
        f29943i = str2;
        b("app_version", str2);
    }

    public static void b(String str, String str2) throws IllegalStateException {
        f29944j.put(str, str2);
    }

    public static void f(String str) {
        f29942h = str;
    }

    public final void c() {
        try {
            d();
            e();
        } catch (Throwable th5) {
            c1.a("CC_Set", "initFromSp error.", th5);
        }
    }

    public final void d() {
        SharedPreferences b16 = r.a().b();
        if (b16 == null) {
            return;
        }
        String str = (String) k1.a(b16, "app_version", (Object) "");
        c1.a("CC_Set", "tagVer:" + f29943i + ",spVer:" + str);
        if (f29943i.length() <= 0 || f29943i.equals(str)) {
            return;
        }
        c1.a("CC_Set", "clear sp > pre:" + str + ",now:" + f29943i);
        b16.edit().clear().apply();
        k1.b(b16, "app_version", (Object) f29943i);
    }

    public void e() {
        if (r.a().b() == null) {
            c1.a("CC_Set", "---> read xml: failed,not init finish!");
            return;
        }
        Iterator<String> it = f29944j.keySet().iterator();
        while (it.hasNext()) {
            g(it.next());
        }
        this.f29949d = true;
        a();
        c1.a("CC_Set", "---> read xml:" + this.f29947b.toString());
    }

    public final void g(String str) {
        if (f29944j.get(str) == null) {
            return;
        }
        try {
            SharedPreferences b16 = r.a().b();
            if (b16 != null) {
                this.f29947b.put(str, b16.getString(str, a(str)));
            }
        } catch (Throwable th5) {
            c1.a("CC_Set", "update set value error [" + str + "]", th5);
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        String str;
        if (obj == null) {
            str = null;
        } else {
            str = (String) obj;
        }
        if (str != null && str.length() != 0) {
            String str2 = "update [" + str + "] : " + this.f29947b.get(str) + " --> ";
            g(str);
            c1.a("CC_Set", str2 + this.f29947b.get(str));
            List<o> list = this.f29948c.get(str);
            if (list != null && !list.isEmpty()) {
                Iterator<o> it = list.iterator();
                while (it.hasNext()) {
                    it.next().a(str);
                }
            }
        }
    }

    public static synchronized q b() {
        q qVar;
        synchronized (q.class) {
            if (f29945k == null) {
                synchronized (q.class) {
                    f29945k = new q();
                }
            }
            qVar = f29945k;
        }
        return qVar;
    }

    public void f() {
        this.f29948c.clear();
    }

    public static void a(HashMap<String, String> hashMap) {
        b("cc_version", "-1");
        b("cc_req_interval", "10800000");
        b("last_pull_time", "0");
        b("list_valid_model", "");
        b("list_valid_sdk_int", "");
        for (String str : hashMap.keySet()) {
            b(str, hashMap.get(str));
        }
    }

    public int c(String str) {
        return ((Integer) a(str, Integer.class)).intValue();
    }

    public boolean b(String str) {
        return ((Boolean) a(str, Boolean.class)).booleanValue();
    }

    public final Object b(String str, Class<?> cls) {
        if (cls == Integer.class) {
            return Integer.valueOf(Integer.parseInt(str));
        }
        if (cls == Long.class) {
            return Long.valueOf(Long.parseLong(str));
        }
        if (cls == Boolean.class) {
            return Boolean.valueOf(Boolean.parseBoolean(str));
        }
        if (cls == Float.class) {
            return Float.valueOf(Float.parseFloat(str));
        }
        return cls == Double.class ? Double.valueOf(Double.parseDouble(str)) : str;
    }

    public long d(String str) {
        return ((Long) a(str, Long.class)).longValue();
    }

    public String e(String str) {
        return (String) a(str, String.class);
    }

    public final Object a(String str, Class<?> cls) {
        if (!this.f29949d) {
            c();
        }
        if (this.f29946a.containsKey(cls)) {
            String str2 = this.f29947b.get(str);
            if (str2 == null || str2.length() == 0) {
                str2 = f29944j.get(str);
            }
            if (str2 == null) {
                str2 = "";
            }
            if (!this.f29950e.get() || !this.f29951f.get()) {
                if (str2.contains("[f]")) {
                    str2 = str2.replace("[f]", "");
                } else {
                    return b(f29944j.get(str), cls);
                }
            }
            try {
                try {
                    return b(str2, cls);
                } catch (Throwable unused) {
                    return b(f29944j.get(str), cls);
                }
            } catch (Throwable unused2) {
                return this.f29946a.get(cls);
            }
        }
        throw new IllegalStateException("The property \"" + str + "\" don't support class type \"" + cls.toString() + "\"");
    }

    public final String a(String str) {
        HashMap<String, String> hashMap = f29944j;
        if (hashMap.containsKey(str)) {
            return hashMap.get(str);
        }
        throw new NullPointerException("Not exists property name \"" + str + "\"");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:10:0x0048
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1166)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:1022)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:55)
        */
    public final void a() {
        /*
            r8 = this;
            java.lang.String r0 = ";"
            r1 = 0
            r2 = 1
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r3 = r8.f29947b     // Catch: java.lang.Throwable -> L48
            java.lang.String r4 = "list_valid_model"
            java.lang.Object r3 = r3.get(r4)     // Catch: java.lang.Throwable -> L48
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L48
            boolean r4 = c.t.m.g.h1.a(r3)     // Catch: java.lang.Throwable -> L48
            if (r4 == 0) goto L1c
            java.util.concurrent.atomic.AtomicBoolean r3 = r8.f29950e     // Catch: java.lang.Throwable -> L48
            r3.getAndSet(r2)     // Catch: java.lang.Throwable -> L48
            goto L4d
        L1c:
            java.lang.String r4 = c.t.m.g.l1.e()     // Catch: java.lang.Throwable -> L48
            java.lang.String r5 = " "
            java.lang.String r6 = ""
            java.lang.String r4 = r4.replace(r5, r6)     // Catch: java.lang.Throwable -> L48
            java.lang.String[] r3 = r3.split(r0)     // Catch: java.lang.Throwable -> L48
            java.util.concurrent.atomic.AtomicBoolean r5 = r8.f29950e     // Catch: java.lang.Throwable -> L48
            r5.getAndSet(r1)     // Catch: java.lang.Throwable -> L48
            int r5 = r3.length     // Catch: java.lang.Throwable -> L48
            r6 = r1
        L35:
            if (r6 >= r5) goto L4d
            r7 = r3[r6]     // Catch: java.lang.Throwable -> L48
            boolean r7 = r4.equalsIgnoreCase(r7)     // Catch: java.lang.Throwable -> L48
            if (r7 == 0) goto L45
            java.util.concurrent.atomic.AtomicBoolean r3 = r8.f29950e     // Catch: java.lang.Throwable -> L48
            r3.getAndSet(r2)     // Catch: java.lang.Throwable -> L48
            goto L4d
        L45:
            int r6 = r6 + 1
            goto L35
        L48:
            java.util.concurrent.atomic.AtomicBoolean r3 = r8.f29950e
            r3.getAndSet(r2)
        L4d:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r3 = r8.f29947b     // Catch: java.lang.Throwable -> L87
            java.lang.String r4 = "list_valid_sdk_int"
            java.lang.Object r3 = r3.get(r4)     // Catch: java.lang.Throwable -> L87
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L87
            boolean r4 = c.t.m.g.h1.a(r3)     // Catch: java.lang.Throwable -> L87
            if (r4 == 0) goto L64
            java.util.concurrent.atomic.AtomicBoolean r0 = r8.f29951f     // Catch: java.lang.Throwable -> L87
            r0.getAndSet(r2)     // Catch: java.lang.Throwable -> L87
            goto L8c
        L64:
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L87
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch: java.lang.Throwable -> L87
            java.lang.String[] r0 = r3.split(r0)     // Catch: java.lang.Throwable -> L87
            java.util.concurrent.atomic.AtomicBoolean r3 = r8.f29951f     // Catch: java.lang.Throwable -> L87
            r3.getAndSet(r1)     // Catch: java.lang.Throwable -> L87
            int r3 = r0.length     // Catch: java.lang.Throwable -> L87
        L74:
            if (r1 >= r3) goto L8c
            r5 = r0[r1]     // Catch: java.lang.Throwable -> L87
            boolean r5 = r4.equalsIgnoreCase(r5)     // Catch: java.lang.Throwable -> L87
            if (r5 == 0) goto L84
            java.util.concurrent.atomic.AtomicBoolean r0 = r8.f29951f     // Catch: java.lang.Throwable -> L87
            r0.getAndSet(r2)     // Catch: java.lang.Throwable -> L87
            goto L8c
        L84:
            int r1 = r1 + 1
            goto L74
        L87:
            java.util.concurrent.atomic.AtomicBoolean r0 = r8.f29951f
            r0.getAndSet(r2)
        L8c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.q.a():void");
    }
}
