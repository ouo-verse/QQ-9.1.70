package com.tencent.luggage.wxa.ol;

import android.os.Looper;
import androidx.collection.ArrayMap;
import com.tencent.luggage.wxa.ol.g;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes8.dex */
public enum r {
    ;


    /* renamed from: a, reason: collision with root package name */
    public static final Map f136917a;

    /* renamed from: b, reason: collision with root package name */
    public static final Set f136918b;

    /* renamed from: c, reason: collision with root package name */
    public static final ArrayMap f136919c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements g.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f136921a;

        public a(int i3) {
            this.f136921a = i3;
        }

        @Override // com.tencent.luggage.wxa.ol.g.a
        public boolean a(p0 p0Var) {
            if (p0Var.d() != null && ((q0) p0Var.d()).getInputId() == this.f136921a) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.kj.v f136922a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f136923b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Integer f136924c;

        public b(com.tencent.luggage.wxa.kj.v vVar, String str, Integer num) {
            this.f136922a = vVar;
            this.f136923b = str;
            this.f136924c = num;
        }

        @Override // java.lang.Runnable
        public void run() {
            p0 a16;
            q0 q0Var = (q0) r.f136919c.get(this.f136922a);
            if (q0Var != null && (a16 = r.a(this.f136922a, q0Var.getInputId())) != null) {
                a16.a(this.f136923b, this.f136924c);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.kj.v f136925a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ q0 f136926b;

        public c(com.tencent.luggage.wxa.kj.v vVar, q0 q0Var) {
            this.f136925a = vVar;
            this.f136926b = q0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            r.f136919c.put(this.f136925a, this.f136926b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.kj.v f136927a;

        public d(com.tencent.luggage.wxa.kj.v vVar) {
            this.f136927a = vVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            r.f136919c.remove(this.f136927a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.kj.v f136928a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ q0 f136929b;

        public e(com.tencent.luggage.wxa.kj.v vVar, q0 q0Var) {
            this.f136928a = vVar;
            this.f136929b = q0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            r.a(this.f136928a, this.f136929b);
        }
    }

    static {
        HashSet hashSet = new HashSet();
        hashSet.add("text");
        hashSet.add("emoji");
        hashSet.add("number");
        hashSet.add("digit");
        hashSet.add("idcard");
        hashSet.add("CommercialScanCodePayment");
        hashSet.add("safe-password");
        hashSet.add("encrypt-text");
        hashSet.add("encrypt-number");
        hashSet.add("encrypt-digit");
        hashSet.add("encrypt-idcard");
        hashSet.add("encrypt-bankcard");
        f136918b = Collections.unmodifiableSet(hashSet);
        HashMap hashMap = new HashMap(3);
        hashMap.put("digit", 2);
        hashMap.put("encrypt-digit", 2);
        hashMap.put("number", 0);
        hashMap.put("encrypt-number", 0);
        hashMap.put("idcard", 1);
        hashMap.put("encrypt-idcard", 1);
        hashMap.put("encrypt-bankcard", 0);
        f136917a = Collections.unmodifiableMap(hashMap);
        f136919c = new ArrayMap();
    }

    public static void c(com.tencent.luggage.wxa.kj.v vVar) {
        if (vVar == null) {
            return;
        }
        com.tencent.luggage.wxa.tk.l.a(new d(vVar));
    }

    public static boolean d(String str) {
        return "encrypt-text".equalsIgnoreCase(str);
    }

    public static boolean e(String str) {
        if (!g(str) && !c(str)) {
            return false;
        }
        return true;
    }

    public static boolean f(String str) {
        return "CommercialScanCodePayment".equalsIgnoreCase(str);
    }

    public static boolean g(String str) {
        if (!"digit".equalsIgnoreCase(str) && !"number".equalsIgnoreCase(str) && !"idcard".equalsIgnoreCase(str)) {
            return false;
        }
        return true;
    }

    public static boolean i(String str) {
        return "text".equalsIgnoreCase(str);
    }

    public static boolean j(String str) {
        if (!i(str) && !d(str)) {
            return false;
        }
        return true;
    }

    public static r valueOf(String str) {
        com.tencent.luggage.wxa.k0.d.a(Enum.valueOf(r.class, str));
        return null;
    }

    public static void a(com.tencent.luggage.wxa.kj.v vVar, p0 p0Var) {
        g.a(vVar, p0Var);
    }

    public static boolean b(com.tencent.luggage.wxa.kj.v vVar) {
        return a(vVar, (Integer) null);
    }

    public static boolean c(String str) {
        return "encrypt-digit".equalsIgnoreCase(str) || "encrypt-number".equalsIgnoreCase(str) || "encrypt-idcard".equalsIgnoreCase(str) || "encrypt-bankcard".equalsIgnoreCase(str);
    }

    public static p0 a(com.tencent.luggage.wxa.kj.v vVar, int i3) {
        return g.a(vVar, new a(i3));
    }

    public static boolean b(com.tencent.luggage.wxa.kj.v vVar, Integer num) {
        if (num == null) {
            q0 q0Var = (q0) f136919c.get(vVar);
            if (q0Var == null) {
                return false;
            }
            num = Integer.valueOf(q0Var.getInputId());
        }
        p0 a16 = a(vVar, num.intValue());
        return a16 != null && a16.a();
    }

    public static void a(com.tencent.luggage.wxa.kj.v vVar, String str, Integer num) {
        if (vVar == null) {
            return;
        }
        com.tencent.luggage.wxa.tk.l.a(new b(vVar, str, num));
    }

    public static boolean a(com.tencent.luggage.wxa.kj.v vVar, Integer num) {
        try {
            return b(vVar, num);
        } catch (Throwable th5) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandInputService", th5, "[NOT CRASH]", new Object[0]);
            return false;
        }
    }

    public static boolean a(com.tencent.luggage.wxa.kj.v vVar, int i3, int i16, int i17) {
        p0 a16 = a(vVar, i3);
        return a16 != null && a16.a(vVar) && a16.a(i16, i17, vVar.D().forceLightMode());
    }

    public static boolean b(com.tencent.luggage.wxa.kj.v vVar, int i3) {
        p0 a16 = a(vVar, i3);
        return a16 != null && a16.b();
    }

    public static void b(com.tencent.luggage.wxa.kj.v vVar, q0 q0Var) {
        if (vVar == null) {
            return;
        }
        com.tencent.luggage.wxa.tk.l.a(new c(vVar, q0Var));
    }

    public static void a(com.tencent.luggage.wxa.kj.v vVar, q0 q0Var) {
        if (vVar == null || q0Var == null) {
            return;
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            com.tencent.luggage.wxa.tk.l.a(new e(vVar, q0Var));
            return;
        }
        ArrayMap arrayMap = f136919c;
        if (arrayMap.get(vVar) == q0Var) {
            arrayMap.remove(vVar);
        }
    }

    public static boolean b(String str) {
        return d(str) || c(str);
    }

    public static p0 a(com.tencent.luggage.wxa.kj.v vVar) {
        q0 q0Var;
        if (vVar == null || (q0Var = (q0) f136919c.get(vVar)) == null) {
            return null;
        }
        return a(vVar, q0Var.getInputId());
    }

    public static boolean a(String str) {
        return "encrypt-bankcard".equalsIgnoreCase(str);
    }
}
