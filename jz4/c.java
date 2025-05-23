package jz4;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.xiaomi.push.hz;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private static int f411287a = 2;

    /* renamed from: b, reason: collision with root package name */
    private static Context f411288b = null;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f411289c = false;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f411290d = false;

    /* renamed from: e, reason: collision with root package name */
    private static String f411291e = "XMPush-" + Process.myPid();

    /* renamed from: f, reason: collision with root package name */
    private static jz4.a f411292f = new a();

    /* renamed from: g, reason: collision with root package name */
    private static final HashMap<Integer, Long> f411293g = new HashMap<>();

    /* renamed from: h, reason: collision with root package name */
    private static final HashMap<Integer, String> f411294h = new HashMap<>();

    /* renamed from: i, reason: collision with root package name */
    private static final Integer f411295i = -1;

    /* renamed from: j, reason: collision with root package name */
    private static AtomicInteger f411296j = new AtomicInteger(1);

    /* compiled from: P */
    /* loaded from: classes22.dex */
    static class a implements jz4.a {

        /* renamed from: a, reason: collision with root package name */
        private String f411297a = c.f411291e;

        a() {
        }

        @Override // jz4.a
        public void log(String str) {
            Log.v(this.f411297a, str);
        }

        @Override // jz4.a
        public void log(String str, Throwable th5) {
            Log.v(this.f411297a, str, th5);
        }
    }

    public static void A(String str, String str2) {
        if (t(4)) {
            h(4, v(str, str2));
        }
    }

    public static void B(String str) {
        if (t(4)) {
            h(4, d(str));
        }
    }

    public static void C(String str, String str2) {
        if (f411289c) {
            n(str, str2);
            return;
        }
        Log.w(f411291e, v(str, str2));
        if (!f411290d) {
            n(str, str2);
        }
    }

    public static void D(String str) {
        if (f411289c) {
            m(str);
            return;
        }
        Log.w(f411291e, d(str));
        if (!f411290d) {
            m(str);
        }
    }

    public static int a() {
        return f411287a;
    }

    public static Integer b(String str) {
        if (f411287a <= 1) {
            Integer valueOf = Integer.valueOf(f411296j.incrementAndGet());
            f411293g.put(valueOf, Long.valueOf(System.currentTimeMillis()));
            f411294h.put(valueOf, str);
            f411292f.log(str + " starts");
            return valueOf;
        }
        return f411295i;
    }

    private static String d(String str) {
        return u() + str;
    }

    public static String e(String str, String str2) {
        return "[" + str + "] " + str2;
    }

    private static String f(String str, Object... objArr) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[Tid:");
        sb5.append(Thread.currentThread().getId());
        sb5.append("] ");
        sb5.append("[");
        sb5.append(str);
        sb5.append("] ");
        if (objArr != null && objArr.length > 0) {
            for (Object obj : objArr) {
                sb5.append(obj);
            }
        }
        return sb5.toString();
    }

    public static void g(int i3) {
        if (i3 < 0 || i3 > 5) {
            h(2, "set log level as " + i3);
        }
        f411287a = i3;
    }

    public static void h(int i3, String str) {
        if (i3 >= f411287a) {
            f411292f.log(str);
            return;
        }
        if (s()) {
            Log.d("MyLog", "-->log(" + i3 + "): " + str);
        }
    }

    public static void i(int i3, String str, Throwable th5) {
        if (i3 >= f411287a) {
            f411292f.log(str, th5);
            return;
        }
        if (s()) {
            Log.w("MyLog", "-->log(" + i3 + "): " + str, th5);
        }
    }

    public static void j(int i3, Throwable th5) {
        if (i3 >= f411287a) {
            f411292f.log("", th5);
            return;
        }
        if (s()) {
            Log.w("MyLog", "-->log(" + i3 + "): ", th5);
        }
    }

    public static void k(Context context) {
        f411288b = context;
        if (hz.j(context)) {
            f411289c = true;
        }
        if (hz.i()) {
            f411290d = true;
        }
    }

    public static void l(Integer num) {
        if (f411287a <= 1) {
            HashMap<Integer, Long> hashMap = f411293g;
            if (!hashMap.containsKey(num)) {
                return;
            }
            long longValue = hashMap.remove(num).longValue();
            String remove = f411294h.remove(num);
            long currentTimeMillis = System.currentTimeMillis() - longValue;
            f411292f.log(remove + " ends in " + currentTimeMillis + " ms");
        }
    }

    public static void m(String str) {
        if (t(2)) {
            h(2, d(str));
        }
    }

    public static void n(String str, String str2) {
        if (t(2)) {
            h(2, v(str, str2));
        }
    }

    public static void o(String str, Throwable th5) {
        if (t(4)) {
            i(4, d(str), th5);
        }
    }

    public static void p(String str, Object... objArr) {
        if (t(2)) {
            h(2, f(str, objArr));
        }
    }

    public static void q(Throwable th5) {
        if (t(4)) {
            j(4, th5);
        }
    }

    public static void r(jz4.a aVar) {
        f411292f = aVar;
    }

    private static boolean s() {
        return false;
    }

    private static boolean t(int i3) {
        if (i3 < f411287a && !s()) {
            return false;
        }
        return true;
    }

    private static String u() {
        return "[Tid:" + Thread.currentThread().getId() + "] ";
    }

    private static String v(String str, String str2) {
        return u() + e(str, str2);
    }

    public static void w(String str) {
        if (t(0)) {
            h(0, d(str));
        }
    }

    public static void x(String str, String str2) {
        if (t(1)) {
            h(1, v(str, str2));
        }
    }

    public static void y(String str, Object... objArr) {
        if (t(1)) {
            h(1, f(str, objArr));
        }
    }

    public static void z(String str) {
        if (t(0)) {
            h(1, d(str));
        }
    }
}
