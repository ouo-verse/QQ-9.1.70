package com.tencent.mapsdk.internal;

import android.text.TextUtils;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.ll;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class lc implements lb {

    /* renamed from: ac, reason: collision with root package name */
    private static final HashSet<String> f149162ac = new HashSet<>();

    /* renamed from: ad, reason: collision with root package name */
    private static final ll.g<a> f149163ad;

    /* renamed from: ae, reason: collision with root package name */
    private static final AtomicInteger f149164ae;

    /* renamed from: af, reason: collision with root package name */
    private static final Map<String, Map<String, c>> f149165af;

    /* renamed from: ag, reason: collision with root package name */
    private static final Map<String, StringBuilder> f149166ag;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a implements ll.h {

        /* renamed from: a, reason: collision with root package name */
        int f149167a = 3;

        /* renamed from: b, reason: collision with root package name */
        String f149168b = ky.f149099e;

        private a a(String str) {
            lc.f149164ae.incrementAndGet();
            this.f149168b = str;
            return this;
        }

        private a a(int i3) {
            lc.f149164ae.incrementAndGet();
            this.f149167a = i3;
            return this;
        }

        public final void a(Object... objArr) {
            lc.f149164ae.incrementAndGet();
            lc.b(this.f149167a, this.f149168b, objArr);
            lc.f149163ad.a(this);
        }

        @Override // com.tencent.mapsdk.internal.ll.h
        public final ll.l a() {
            return new ll.d();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface b {
        void a();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class c {

        /* renamed from: b, reason: collision with root package name */
        String f149170b;

        /* renamed from: d, reason: collision with root package name */
        b f149172d;

        /* renamed from: f, reason: collision with root package name */
        String f149174f;

        /* renamed from: g, reason: collision with root package name */
        String f149175g;

        /* renamed from: h, reason: collision with root package name */
        private String f149176h;

        /* renamed from: c, reason: collision with root package name */
        List<Long> f149171c = new CopyOnWriteArrayList();

        /* renamed from: a, reason: collision with root package name */
        AtomicInteger f149169a = new AtomicInteger(0);

        /* renamed from: e, reason: collision with root package name */
        final Map<String, Object> f149173e = new ConcurrentHashMap();

        c(String str, String str2) {
            this.f149176h = str;
            this.f149170b = str2;
        }

        public final String toString() {
            return "TraceInfo{id='" + this.f149170b + "', values=" + this.f149173e + '}';
        }

        public final Object b(String str) {
            return this.f149173e.get(str);
        }

        final boolean a(String str) {
            return this.f149170b.equals(str);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void b() {
            this.f149169a.set(0);
            this.f149171c.clear();
            this.f149172d = null;
            this.f149173e.clear();
        }

        public final String a() {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[");
            if (!TextUtils.isEmpty(this.f149175g)) {
                sb5.append(this.f149175g);
            }
            if (!this.f149176h.equals(this.f149170b)) {
                sb5.append("|");
                sb5.append(this.f149176h);
                sb5.append("|");
                sb5.append(this.f149170b);
            } else {
                sb5.append("|");
                sb5.append(this.f149176h);
            }
            if (!TextUtils.isEmpty(this.f149174f)) {
                sb5.append("|");
                sb5.append(this.f149174f);
            }
            sb5.append("]");
            return sb5.toString();
        }

        public final void a(String str, Object obj) {
            if (TextUtils.isEmpty(str) || obj == null) {
                return;
            }
            this.f149173e.put(str, obj);
        }
    }

    static {
        b(ky.f149111q);
        b(ky.f149113s);
        b(ky.f149115u);
        f149163ad = ll.a(30, new ll.e<a>() { // from class: com.tencent.mapsdk.internal.lc.1
            private static a b() {
                return new a();
            }

            @Override // com.tencent.mapsdk.internal.ll.e
            public final /* synthetic */ a a() {
                return new a();
            }
        });
        f149164ae = new AtomicInteger();
        f149165af = Collections.synchronizedMap(new Hashtable());
        f149166ag = new ConcurrentHashMap();
    }

    private static String c(String str) {
        return str;
    }

    public static int d(String str, String str2, int i3) {
        if (e(str, i3) && e(str, i3)) {
            Map<String, c> map = f149165af.get(str);
            c cVar = map != null ? map.get(str) : null;
            if (cVar != null) {
                Object b16 = cVar.b(str2);
                if (b16 instanceof AtomicInteger) {
                    return ((AtomicInteger) b16).get();
                }
            }
        }
        return 0;
    }

    private static String e(String str) {
        return str;
    }

    private static String f(String str, int i3) {
        String str2;
        if (TextUtils.isEmpty(str) || tf.f150437d) {
            return str;
        }
        List<String> d16 = kt.d(new File(LogUtil.a(), "kv"));
        if (d16 != null && !d16.isEmpty() && !TextUtils.isEmpty(d16.get(0))) {
            str2 = d16.get(0);
        } else {
            try {
                String a16 = ld.a(ho.a() + tf.f150443j + tf.f150442i + tf.f150436c + tf.f150435b);
                try {
                    LogUtil.a(i3).b(ky.f149099e, a16);
                } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused) {
                }
                str2 = a16;
            } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused2) {
                str2 = null;
            }
        }
        try {
            if (!TextUtils.isEmpty(str2)) {
                return ld.a(str2, str);
            }
        } catch (GeneralSecurityException unused3) {
        }
        return "";
    }

    private static int g(String str, String str2, int i3) {
        c cVar;
        if (e(str, i3) && e(str, i3)) {
            Map<String, c> map = f149165af.get(str);
            if (map != null) {
                cVar = map.get(str);
            } else {
                cVar = null;
            }
            if (cVar != null) {
                Object b16 = cVar.b(str2);
                if (b16 instanceof AtomicInteger) {
                    AtomicInteger atomicInteger = (AtomicInteger) b16;
                    int decrementAndGet = atomicInteger.decrementAndGet();
                    if (decrementAndGet < 0) {
                        atomicInteger.set(0);
                        return 0;
                    }
                    return decrementAndGet;
                }
            }
        }
        return -1;
    }

    private static long h(String str, String str2, int i3) {
        if (!e(str, i3)) {
            return 0L;
        }
        return a(str, str, str2, "", null, i3);
    }

    public static void b(String str, int i3) {
        if (e(str, i3)) {
            a(str, str, (b) null, i3);
        }
    }

    private static boolean c() {
        return LogUtil.e(ky.f149099e);
    }

    private static boolean e(String str, int i3) {
        return LogUtil.a(i3).a(4, ky.f149099e) && !f149162ac.contains(str);
    }

    public static void a(String str, int i3) {
        if (e(str, i3)) {
            a(str, str, (b) null, i3);
        }
    }

    public static Object c(String str, String str2, int i3) {
        if (e(str, i3) && e(str, i3)) {
            Map<String, c> map = f149165af.get(str);
            c cVar = map != null ? map.get(str) : null;
            if (cVar != null) {
                return cVar.b(str2);
            }
        }
        return null;
    }

    public static int e(String str, String str2, int i3) {
        if (e(str, i3) && e(str, i3)) {
            Map<String, c> map = f149165af.get(str);
            c cVar = map != null ? map.get(str) : null;
            if (cVar != null) {
                Object b16 = cVar.b(str2);
                if (b16 instanceof AtomicInteger) {
                    return ((AtomicInteger) b16).incrementAndGet();
                }
                cVar.a(str2, new AtomicInteger(1));
                return 1;
            }
        }
        return -1;
    }

    public static void b(String str, String str2, int i3) {
        if (e(str, i3)) {
            a(str, str2, (b) null, i3);
        }
    }

    public static void a(String str, String str2, int i3) {
        if (e(str, i3)) {
            a(str, str2, (b) null, i3);
        }
    }

    private static int b(String str, String str2, String str3, int i3) {
        if (!e(str, i3)) {
            return 0;
        }
        Map<String, c> map = f149165af.get(str);
        c cVar = map != null ? map.get(str2) : null;
        if (cVar != null) {
            Object b16 = cVar.b(str3);
            if (b16 instanceof AtomicInteger) {
                return ((AtomicInteger) b16).get();
            }
        }
        return 0;
    }

    private static void a(String str, b bVar, int i3) {
        if (e(str, i3)) {
            a(str, str, bVar, i3);
        }
    }

    private static int c(String str, String str2, String str3, int i3) {
        if (!e(str, i3)) {
            return -1;
        }
        Map<String, c> map = f149165af.get(str);
        c cVar = map != null ? map.get(str2) : null;
        if (cVar == null) {
            return -1;
        }
        Object b16 = cVar.b(str3);
        if (b16 instanceof AtomicInteger) {
            return ((AtomicInteger) b16).incrementAndGet();
        }
        cVar.a(str3, new AtomicInteger(1));
        return 1;
    }

    private static int d(String str, String str2, String str3, int i3) {
        if (!e(str, i3)) {
            return -1;
        }
        Map<String, c> map = f149165af.get(str);
        c cVar = map != null ? map.get(str2) : null;
        if (cVar != null) {
            Object b16 = cVar.b(str3);
            if (b16 instanceof AtomicInteger) {
                AtomicInteger atomicInteger = (AtomicInteger) b16;
                int decrementAndGet = atomicInteger.decrementAndGet();
                if (decrementAndGet >= 0) {
                    return decrementAndGet;
                }
                atomicInteger.set(0);
                return 0;
            }
        }
        return -1;
    }

    private static void a(String str, String str2, b bVar, int i3) {
        c cVar;
        if (e(str, i3)) {
            Map<String, Map<String, c>> map = f149165af;
            Map<String, c> map2 = map.get(str);
            if (map2 == null) {
                HashMap hashMap = new HashMap();
                cVar = new c(str, str2);
                hashMap.put(str2, cVar);
                map.put(str, hashMap);
            } else {
                cVar = map2.get(str2);
                if (cVar == null) {
                    cVar = new c(str, str2);
                    map2.put(str2, cVar);
                } else {
                    cVar.b();
                }
            }
            cVar.f149170b = str2;
            cVar.f149172d = bVar;
            cVar.f149171c.add(Long.valueOf(System.currentTimeMillis()));
            cVar.f149175g = "Begin";
            a(cVar, i3);
        }
    }

    public static long b(String str, String str2, Object obj, int i3) {
        if (e(str, i3)) {
            return a(str, str, "", str2, obj, i3);
        }
        return 0L;
    }

    private static boolean b(String str, String str2) {
        return a(str, str2) != null;
    }

    public static long f(String str, String str2, int i3) {
        if (!e(str, i3)) {
            return 0L;
        }
        c a16 = a(str, str2);
        if (a16 != null) {
            a16.f149175g = "End";
        }
        long a17 = a(a16, i3);
        if (a17 != -1) {
            f149165af.remove(str);
        }
        return a17;
    }

    public static void b(String str) {
        f149162ac.add(str);
    }

    public static long c(String str, int i3) {
        if (e(str, i3)) {
            return f(str, str, i3);
        }
        return 0L;
    }

    public static long d(String str, int i3) {
        if (e(str, i3) && e(str, i3)) {
            return a(str, str, str, "", null, i3);
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(int i3, String str, Object... objArr) {
        Class<?>[] clsArr;
        if (LogUtil.e(ky.f149099e)) {
            if (f149162ac.contains(str)) {
                f149164ae.set(0);
                return;
            }
            Thread currentThread = Thread.currentThread();
            StackTraceElement[] stackTrace = currentThread.getStackTrace();
            if (stackTrace != null) {
                int length = stackTrace.length;
                AtomicInteger atomicInteger = f149164ae;
                if (length <= atomicInteger.get() + 3) {
                    return;
                }
                StackTraceElement stackTraceElement = stackTrace[atomicInteger.get() + 3];
                atomicInteger.set(0);
                StringBuilder sb5 = new StringBuilder();
                try {
                    for (Method method : Class.forName(stackTraceElement.getClassName()).getDeclaredMethods()) {
                        if (method.getName().equals(stackTraceElement.getMethodName())) {
                            clsArr = method.getParameterTypes();
                            break;
                        }
                    }
                } catch (ClassNotFoundException e16) {
                    e16.printStackTrace();
                }
                clsArr = null;
                if (stackTraceElement.isNativeMethod()) {
                    sb5.append("(Native Method)");
                } else if (stackTraceElement.getFileName() != null) {
                    if (stackTraceElement.getLineNumber() >= 0) {
                        sb5.append("(");
                        sb5.append(stackTraceElement.getFileName());
                        sb5.append(":");
                        sb5.append(stackTraceElement.getLineNumber());
                        sb5.append(")");
                    } else {
                        sb5.append("(");
                        sb5.append(stackTraceElement.getFileName());
                        sb5.append(")");
                    }
                } else if (stackTraceElement.getLineNumber() >= 0) {
                    sb5.append("(Unknown Source:");
                    sb5.append(stackTraceElement.getLineNumber());
                    sb5.append(")");
                } else {
                    sb5.append("(Unknown Source)");
                }
                sb5.append("==");
                sb5.append(currentThread.getName());
                sb5.append(":");
                sb5.append(currentThread.getId());
                sb5.append("==");
                sb5.append("#");
                sb5.append(stackTraceElement.getMethodName());
                sb5.append("(");
                if (clsArr != null && clsArr.length > 0) {
                    int i16 = 0;
                    for (Class<?> cls : clsArr) {
                        sb5.append(cls.getSimpleName());
                        if (i16 != clsArr.length - 1) {
                            sb5.append(",");
                        }
                        i16++;
                    }
                }
                sb5.append(")");
                StringBuilder sb6 = new StringBuilder();
                int i17 = 0;
                for (Object obj : objArr) {
                    i17++;
                    sb6.append("[");
                    sb6.append(i17);
                    sb6.append("] ");
                    sb6.append(obj);
                }
                if (i17 > 0) {
                    sb5.append((CharSequence) sb6);
                }
                if (TextUtils.isEmpty(str)) {
                    str = ky.f149099e;
                }
                if (i3 == 2) {
                    LogUtil.a(str, sb5.toString());
                    return;
                }
                if (i3 == 3) {
                    LogUtil.b(str, sb5.toString());
                    return;
                }
                if (i3 == 4) {
                    LogUtil.c(str, sb5.toString());
                } else if (i3 != 5) {
                    if (i3 != 6) {
                        return;
                    }
                    LogUtil.e(str, sb5.toString());
                } else {
                    LogUtil.d(str, sb5.toString());
                }
            }
        }
    }

    private static boolean d(String str) {
        return a(str, str) != null;
    }

    public static void a(String str, String str2, Object obj, int i3) {
        if (e(str, i3)) {
            a(str, str, str2, obj, i3);
        }
    }

    public static void a(String str, String str2, String str3, Object obj, int i3) {
        if (e(str, i3)) {
            Map<String, c> map = f149165af.get(str);
            c cVar = map != null ? map.get(str2) : null;
            if (cVar != null) {
                cVar.a(str3, obj);
                cVar.f149175g = "Set";
                LogUtil.a(i3).b(ky.f149099e, cVar.a() + ":" + str3 + "=>" + obj);
            }
        }
    }

    private static Object a(String str, String str2, String str3, int i3) {
        if (!e(str, i3)) {
            return null;
        }
        Map<String, c> map = f149165af.get(str);
        c cVar = map != null ? map.get(str2) : null;
        if (cVar != null) {
            return cVar.b(str3);
        }
        return null;
    }

    private static int a(String str, String str2, String str3, int i3, int i16) {
        int i17 = -1;
        if (!e(str, i16)) {
            return -1;
        }
        Map<String, c> map = f149165af.get(str);
        c cVar = map != null ? map.get(str2) : null;
        if (cVar != null) {
            Object b16 = cVar.b(str3);
            i17 = 1;
            if (b16 instanceof AtomicInteger) {
                if (i3 <= 0) {
                    i3 = 1;
                }
                AtomicInteger atomicInteger = (AtomicInteger) b16;
                int i18 = atomicInteger.get() + i3;
                atomicInteger.set(i18);
                return i18;
            }
            cVar.a(str3, new AtomicInteger(1));
        }
        return i17;
    }

    private static long a(String str, String str2, String str3, String str4, Object obj, int i3) {
        if (!e(str, i3)) {
            return 0L;
        }
        a(str, str2, str4, obj, i3);
        c a16 = a(str, str2);
        if (a16 != null) {
            a16.f149175g = "Log";
            a16.f149169a.incrementAndGet();
            a16.f149174f = str3;
            a16.f149171c.add(Long.valueOf(System.currentTimeMillis()));
        }
        return a(a16, i3);
    }

    private static long a(c cVar, int i3) {
        long j3;
        long j16 = -1;
        if (cVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (cVar.f149171c.size() > 0) {
                j16 = currentTimeMillis - cVar.f149171c.get(0).longValue();
                j3 = currentTimeMillis - cVar.f149171c.get(r4.size() - 1).longValue();
            } else {
                j3 = -1;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(cVar.a());
            if (cVar.f149169a.get() != 0) {
                sb5.append("$idx:");
                sb5.append(cVar.f149169a.get());
            }
            if (j16 > 0) {
                sb5.append("$ut:");
                sb5.append(j16);
                sb5.append("ms");
            }
            if (j3 > 0) {
                sb5.append("$it:");
                sb5.append(j3);
                sb5.append("ms");
            }
            Map<String, Object> map = cVar.f149173e;
            if (map != null && !map.isEmpty()) {
                sb5.append("$val:");
                sb5.append(cVar.f149173e);
            }
            LogUtil.a(i3).c(ky.f149099e, sb5.toString());
        }
        return j16;
    }

    private static c a(String str, String str2) {
        Map<String, c> map = f149165af.get(str);
        c cVar = map != null ? map.get(str2) : null;
        if (cVar == null || !cVar.a(str2)) {
            return null;
        }
        return cVar;
    }

    private static a a(int i3) {
        f149164ae.incrementAndGet();
        a a16 = f149163ad.a();
        a16.f149167a = i3;
        return a16;
    }

    public static a a(String str) {
        f149164ae.incrementAndGet();
        a a16 = f149163ad.a();
        a16.f149168b = str;
        return a16;
    }

    private static void a(Throwable th5, int i3) {
        if (th5 != null) {
            StringBuilder sb5 = new StringBuilder();
            try {
                StringWriter stringWriter = new StringWriter();
                PrintWriter printWriter = new PrintWriter(stringWriter);
                th5.printStackTrace(printWriter);
                for (Throwable cause = th5.getCause(); cause != null; cause = cause.getCause()) {
                    cause.printStackTrace(printWriter);
                }
                printWriter.close();
                sb5.append(stringWriter.toString());
                sb5.append("\n =============== ");
            } catch (Throwable unused) {
            }
            LogUtil.a(i3).e(ky.f149099e, sb5.toString());
        }
    }

    public static void a(Object... objArr) {
        if (LogUtil.e(ky.f149099e)) {
            f149164ae.incrementAndGet();
            b(3, ky.f149099e, objArr);
        }
    }

    private static int a(String str, String str2, int i3, int i16) {
        if (!e(str, i16)) {
            return -1;
        }
        Map<String, c> map = f149165af.get(str);
        c cVar = map != null ? map.get(str) : null;
        if (cVar == null) {
            return -1;
        }
        Object b16 = cVar.b(str2);
        if (b16 instanceof AtomicInteger) {
            if (i3 <= 0) {
                i3 = 1;
            }
            AtomicInteger atomicInteger = (AtomicInteger) b16;
            int i17 = atomicInteger.get() + i3;
            atomicInteger.set(i17);
            return i17;
        }
        cVar.a(str2, new AtomicInteger(1));
        return 1;
    }
}
