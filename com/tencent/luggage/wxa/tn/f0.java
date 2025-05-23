package com.tencent.luggage.wxa.tn;

import android.content.SharedPreferences;
import android.os.Parcelable;
import android.util.ArrayMap;
import android.util.Pair;
import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.luggage.wxa.y8.b;
import com.tencent.mmkv.MMKV;
import com.tencent.mmkv.MMKVLogLevel;
import com.tencent.mmkv.MMKVRecoverStrategic;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f0 implements SharedPreferences, SharedPreferences.Editor {

    /* renamed from: h, reason: collision with root package name */
    public static Map f141580h;

    /* renamed from: i, reason: collision with root package name */
    public static boolean f141581i;

    /* renamed from: k, reason: collision with root package name */
    public static final Map f141583k;

    /* renamed from: a, reason: collision with root package name */
    public MMKV f141584a;

    /* renamed from: b, reason: collision with root package name */
    public Pair f141585b;

    /* renamed from: c, reason: collision with root package name */
    public int f141586c;

    /* renamed from: d, reason: collision with root package name */
    public final ReentrantReadWriteLock f141587d;

    /* renamed from: e, reason: collision with root package name */
    public final ReentrantReadWriteLock.ReadLock f141588e;

    /* renamed from: f, reason: collision with root package name */
    public final ReentrantReadWriteLock.WriteLock f141589f;

    /* renamed from: g, reason: collision with root package name */
    public static final Set f141579g = new HashSet();

    /* renamed from: j, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.y8.d f141582j = new com.tencent.luggage.wxa.y8.d(45, new a());

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements b.a {
        @Override // com.tencent.luggage.wxa.y8.b.a
        public void preRemoveCallback(Pair<String, String> pair, f0 f0Var, f0 f0Var2) {
            if (f0Var2 == null) {
                w.d("MicroMsg.MultiProcessMMKV", "preRemoveCallback newValue == null, name = " + f0Var.f());
                f0Var.d();
            }
            w.d("MicroMsg.MultiProcessMMKV", "preRemoveCallback done, name = " + f0Var.f());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements com.tencent.mmkv.b {
        @Override // com.tencent.mmkv.b
        public void mmkvLog(MMKVLogLevel mMKVLogLevel, String str, int i3, String str2, String str3) {
            w.d("MMKV", "[%s][%d][%s] %s", str, Integer.valueOf(i3), str2, str3);
        }

        @Override // com.tencent.mmkv.b
        public MMKVRecoverStrategic onMMKVCRCCheckFail(String str) {
            w.d("MicroMsg.MultiProcessMMKV", "onMMKVCRCCheckFail:%s", str);
            com.tencent.luggage.wxa.xm.b bVar = com.tencent.luggage.wxa.xm.b.INSTANCE;
            bVar.a(941L, 3L, 1L, true);
            bVar.a(24632, str, 1, 0, 0);
            return MMKVRecoverStrategic.OnErrorDiscard;
        }

        @Override // com.tencent.mmkv.b
        public MMKVRecoverStrategic onMMKVFileLengthError(String str) {
            w.d("MicroMsg.MultiProcessMMKV", "onMMKVFileLengthError:%s", str);
            com.tencent.luggage.wxa.xm.b bVar = com.tencent.luggage.wxa.xm.b.INSTANCE;
            bVar.a(941L, 4L, 1L, true);
            bVar.a(24632, str, 2, 0, 0);
            return MMKVRecoverStrategic.OnErrorDiscard;
        }

        @Override // com.tencent.mmkv.b
        public boolean wantLogRedirecting() {
            return true;
        }
    }

    static {
        f141580h = new ConcurrentHashMap();
        try {
            k();
        } catch (Exception e16) {
            w.b("MicroMsg.MultiProcessMMKV", "<clinit> setupMMKV first try failed %s", e16);
            try {
                k();
            } catch (Exception e17) {
                w.b("MicroMsg.MultiProcessMMKV", "<clinit> setupMMKV second try failed %s", e17);
            }
        }
        f141580h = new ConcurrentHashMap();
        f141581i = true;
        f141583k = new ArrayMap();
    }

    public f0(String str, String str2, int i3, MMKV mmkv) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f141587d = reentrantReadWriteLock;
        this.f141588e = reentrantReadWriteLock.readLock();
        this.f141589f = reentrantReadWriteLock.writeLock();
        this.f141584a = mmkv;
        this.f141585b = Pair.create(str, str2);
        this.f141586c = i3;
    }

    public static f0 c(String str, int i3) {
        k();
        return a(str, i3, (MMKV) null);
    }

    public static f0 e(String str) {
        k();
        return a(str, 2, (MMKV) null);
    }

    public static f0 g() {
        k();
        return e();
    }

    public static void k() {
        com.tencent.luggage.wxa.aa.h.h("mmkv");
        MMKV.T(z.c());
        MMKV.w();
        MMKV.e0(new b());
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        if (!i()) {
            this.f141584a.clear();
        } else {
            this.f141588e.lock();
            a(this.f141585b);
            this.f141584a.clear();
            this.f141588e.unlock();
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public boolean commit() {
        return true;
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        if (!i()) {
            return this.f141584a.contains(str);
        }
        this.f141588e.lock();
        a(this.f141585b);
        boolean contains = this.f141584a.contains(str);
        this.f141588e.unlock();
        return contains;
    }

    public Set d(String str) {
        if (!i()) {
            return this.f141584a.r(str);
        }
        this.f141588e.lock();
        a(this.f141585b);
        Set<String> r16 = this.f141584a.r(str);
        this.f141588e.unlock();
        return r16;
    }

    public final String f() {
        return (String) this.f141585b.first;
    }

    @Override // android.content.SharedPreferences
    public Map getAll() {
        if (!i()) {
            return this.f141584a.getAll();
        }
        this.f141588e.lock();
        a(this.f141585b);
        Map<String, ?> all = this.f141584a.getAll();
        this.f141588e.unlock();
        return all;
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z16) {
        if (!i()) {
            return this.f141584a.getBoolean(str, z16);
        }
        this.f141588e.lock();
        a(this.f141585b);
        boolean z17 = this.f141584a.getBoolean(str, z16);
        this.f141588e.unlock();
        return z17;
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f16) {
        if (!i()) {
            return this.f141584a.getFloat(str, f16);
        }
        this.f141588e.lock();
        a(this.f141585b);
        float f17 = this.f141584a.getFloat(str, f16);
        this.f141588e.unlock();
        return f17;
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i3) {
        if (!i()) {
            return this.f141584a.getInt(str, i3);
        }
        this.f141588e.lock();
        a(this.f141585b);
        int i16 = this.f141584a.getInt(str, i3);
        this.f141588e.unlock();
        return i16;
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j3) {
        if (!i()) {
            return this.f141584a.getLong(str, j3);
        }
        this.f141588e.lock();
        a(this.f141585b);
        long j16 = this.f141584a.getLong(str, j3);
        this.f141588e.unlock();
        return j16;
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        if (!i()) {
            return this.f141584a.getString(str, str2);
        }
        this.f141588e.lock();
        a(this.f141585b);
        String string = this.f141584a.getString(str, str2);
        this.f141588e.unlock();
        return string;
    }

    @Override // android.content.SharedPreferences
    public Set getStringSet(String str, Set set) {
        if (!i()) {
            return this.f141584a.getStringSet(str, set);
        }
        this.f141588e.lock();
        a(this.f141585b);
        Set<String> stringSet = this.f141584a.getStringSet(str, set);
        this.f141588e.unlock();
        return stringSet;
    }

    public final boolean h() {
        if (j() == null) {
            return true;
        }
        return false;
    }

    public boolean i() {
        if (f141581i && f141582j != null) {
            return true;
        }
        return false;
    }

    public final String j() {
        if (!i()) {
            return this.f141584a.mmapID();
        }
        this.f141588e.lock();
        String mmapID = this.f141584a.mmapID();
        this.f141588e.unlock();
        return mmapID;
    }

    public long l() {
        if (!i()) {
            return this.f141584a.totalSize();
        }
        this.f141588e.lock();
        a(this.f141585b);
        long j3 = this.f141584a.totalSize();
        this.f141588e.unlock();
        return j3;
    }

    public void m() {
        if (!i()) {
            this.f141584a.trim();
            return;
        }
        this.f141588e.lock();
        a(this.f141585b);
        this.f141584a.trim();
        this.f141588e.unlock();
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z16) {
        if (!a(str, Boolean.valueOf(z16))) {
            return edit();
        }
        if (!i()) {
            this.f141584a.putBoolean(str, z16);
        } else {
            this.f141588e.lock();
            a(this.f141585b);
            this.f141584a.putBoolean(str, z16);
            this.f141588e.unlock();
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f16) {
        if (!a(str, Float.valueOf(f16))) {
            return edit();
        }
        if (!i()) {
            this.f141584a.putFloat(str, f16);
        } else {
            this.f141588e.lock();
            a(this.f141585b);
            this.f141584a.putFloat(str, f16);
            this.f141588e.unlock();
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i3) {
        if (!a(str, Integer.valueOf(i3))) {
            return edit();
        }
        if (!i()) {
            this.f141584a.putInt(str, i3);
        } else {
            this.f141588e.lock();
            a(this.f141585b);
            this.f141584a.putInt(str, i3);
            this.f141588e.unlock();
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j3) {
        if (!a(str, Long.valueOf(j3))) {
            return edit();
        }
        if (!i()) {
            this.f141584a.putLong(str, j3);
        } else {
            this.f141588e.lock();
            a(this.f141585b);
            this.f141584a.putLong(str, j3);
            this.f141588e.unlock();
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, String str2) {
        if (!a(str, (Object) str2)) {
            return edit();
        }
        if (!i()) {
            this.f141584a.putString(str, str2);
        } else {
            this.f141588e.lock();
            a(this.f141585b);
            this.f141584a.putString(str, str2);
            this.f141588e.unlock();
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String str, Set set) {
        if (!a(str, (Object) set)) {
            return edit();
        }
        if (!i()) {
            this.f141584a.putStringSet(str, set);
        } else {
            this.f141588e.lock();
            a(this.f141585b);
            this.f141584a.putStringSet(str, set);
            this.f141588e.unlock();
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        if (!i()) {
            this.f141584a.remove(str);
        } else {
            this.f141588e.lock();
            a(this.f141585b);
            this.f141584a.remove(str);
            this.f141588e.unlock();
        }
        return this;
    }

    public static f0 a(String str, int i3, String str2) {
        k();
        return a(str, i3, MMKV.b0(str, i3, str2));
    }

    public static ReentrantLock b(Pair pair) {
        ReentrantLock reentrantLock;
        Map map = f141583k;
        synchronized (map) {
            reentrantLock = (ReentrantLock) map.get(pair);
            if (reentrantLock == null) {
                reentrantLock = new ReentrantLock(true);
                map.put(pair, reentrantLock);
            }
        }
        return reentrantLock;
    }

    public static f0 f(String str) {
        k();
        return a(str, 1, (MMKV) null);
    }

    public static boolean c(Pair pair) {
        return (!f141581i || f141582j == null || f141579g.contains(pair)) ? false : true;
    }

    public static f0 e() {
        k();
        return a("MULTIPROCESSMMKV_MULTI_DEFAULT", 2, MMKV.v(2, null));
    }

    public void g(String str) {
        if (!i()) {
            this.f141584a.f0(str);
            return;
        }
        this.f141588e.lock();
        a(this.f141585b);
        this.f141584a.f0(str);
        this.f141588e.unlock();
    }

    public String c(String str) {
        if (!i()) {
            return this.f141584a.p(str);
        }
        this.f141588e.lock();
        a(this.f141585b);
        String p16 = this.f141584a.p(str);
        this.f141588e.unlock();
        return p16;
    }

    public static f0 a(String str, int i3, MMKV mmkv) {
        if (!w0.c(str) && !w0.a(str, "MULTIPROCESSMMKV_PERSERVED_NAME")) {
            return a(str, null, i3, mmkv);
        }
        w.d("MicroMsg.MultiProcessMMKV", "getMMKV name is illegal");
        return null;
    }

    public final void d() {
        if (!i()) {
            this.f141584a.close();
            this.f141584a = null;
        } else {
            this.f141589f.lock();
            w.d("MicroMsg.MultiProcessMMKV", "preRemoveCallback MMKV : %s, will be closed, my hashcode = %d, coreMMKV hashcode = %d", this.f141585b.first, Integer.valueOf(hashCode()), Integer.valueOf(this.f141584a.hashCode()));
            this.f141584a.close();
            this.f141589f.unlock();
        }
    }

    public static f0 a(Pair pair, int i3) {
        if (c(pair)) {
            com.tencent.luggage.wxa.y8.d dVar = f141582j;
            f0 f0Var = (f0) dVar.d(pair);
            if (f0Var != null) {
                return f0Var;
            }
            f0 f0Var2 = (f0) f141580h.get(pair);
            if (f0Var2 == null) {
                return f0Var2;
            }
            f0Var2.f141588e.lock();
            f0Var2.a(pair);
            dVar.put(pair, f0Var2);
            f0Var2.f141588e.unlock();
            return f0Var2;
        }
        return (f0) f141580h.get(pair);
    }

    public boolean b(String str, String str2) {
        if (!a(str, (Object) str2)) {
            return false;
        }
        if (!i()) {
            return this.f141584a.J(str, str2);
        }
        this.f141588e.lock();
        a(this.f141585b);
        boolean J = this.f141584a.J(str, str2);
        this.f141588e.unlock();
        return J;
    }

    public void c() {
        if (!i()) {
            this.f141584a.clearMemoryCache();
            return;
        }
        this.f141588e.lock();
        a(this.f141585b);
        this.f141584a.clearMemoryCache();
        this.f141588e.unlock();
    }

    public boolean b(String str, int i3) {
        if (!a(str, Integer.valueOf(i3))) {
            return false;
        }
        if (!i()) {
            return this.f141584a.D(str, i3);
        }
        this.f141588e.lock();
        a(this.f141585b);
        boolean D = this.f141584a.D(str, i3);
        this.f141588e.unlock();
        return D;
    }

    public static f0 a(String str, String str2, int i3, MMKV mmkv) {
        f0 f0Var;
        Pair create = Pair.create(str, str2);
        f0 a16 = a(create, i3);
        if (a16 != null) {
            return a16;
        }
        ReentrantLock b16 = b(create);
        try {
            b16.lock();
            f0 a17 = a(create, i3);
            if (a17 != null) {
                return a17;
            }
            if (mmkv == null) {
                f0Var = new f0(str, str2, i3, a(str, str2, i3));
            } else {
                f0Var = new f0(str, str2, i3, mmkv);
            }
            long l3 = f0Var.l();
            if (l3 > 1048576) {
                w.b("MicroMsg.MultiProcessMMKV", "MMKV file is too big, name : %s, path : %s, size : %d, please contact with leafjia", str, str2, Long.valueOf(l3));
                a(l3, str);
                if (l3 > 5242880) {
                    com.tencent.luggage.wxa.xm.b bVar = com.tencent.luggage.wxa.xm.b.INSTANCE;
                    bVar.a(941L, 100L, 1L, true);
                    w.d("MicroMsg.MultiProcessMMKV", "start to trim, before size : %d", Long.valueOf(l3));
                    f0Var.m();
                    w.d("MicroMsg.MultiProcessMMKV", "trim is over, after size : %d", Long.valueOf(f0Var.l()));
                    if (l3 > IPublicAccountJavascriptInterface.MAX_H5_DATA_SIZE) {
                        bVar.a(24632, str, 3, Long.valueOf(l3), Long.valueOf(f0Var.l()), e.f141561c);
                    }
                }
            }
            if (c(create)) {
                f141582j.put(create, f0Var);
                f141580h.put(create, f0Var);
            } else {
                f141580h.put(create, f0Var);
            }
            b16.unlock();
            return f0Var;
        } finally {
            b16.unlock();
        }
    }

    @Override // android.content.SharedPreferences.Editor
    public void apply() {
    }

    public boolean b(String str, boolean z16) {
        if (!a(str, Boolean.valueOf(z16))) {
            return false;
        }
        if (!i()) {
            return this.f141584a.N(str, z16);
        }
        this.f141588e.lock();
        a(this.f141585b);
        boolean N = this.f141584a.N(str, z16);
        this.f141588e.unlock();
        return N;
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this;
    }

    public void finalize() {
    }

    public byte[] b(String str) {
        if (!i()) {
            return this.f141584a.f(str);
        }
        this.f141588e.lock();
        a(this.f141585b);
        byte[] f16 = this.f141584a.f(str);
        this.f141588e.unlock();
        return f16;
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    public void b() {
        if (!i()) {
            this.f141584a.clearAll();
            return;
        }
        this.f141588e.lock();
        a(this.f141585b);
        this.f141584a.clearAll();
        this.f141588e.unlock();
    }

    public static MMKV a(String str, String str2, int i3) {
        try {
            return MMKV.c0(str, i3, null, str2);
        } catch (IllegalArgumentException unused) {
            w.b("MicroMsg.MultiProcessMMKV", "getCoreMMKV mode error name : %s ,mode : %d", str, Integer.valueOf(i3));
            com.tencent.luggage.wxa.xm.b.INSTANCE.a(941L, 150L, 1L, true);
            if (i3 == 2) {
                return MMKV.c0(str, 1, null, str2);
            }
            return MMKV.c0(str, i3, null, str2);
        }
    }

    public static void a(long j3, String str) {
        if (j3 <= 5242880) {
            com.tencent.luggage.wxa.xm.b.INSTANCE.a(941L, 10L, 1L, true);
        } else if (j3 <= 10485760) {
            com.tencent.luggage.wxa.xm.b.INSTANCE.a(941L, 11L, 1L, true);
        } else if (j3 <= GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT) {
            com.tencent.luggage.wxa.xm.b.INSTANCE.a(941L, 12L, 1L, true);
        } else {
            com.tencent.luggage.wxa.xm.b.INSTANCE.a(941L, 13L, 1L, true);
        }
        com.tencent.luggage.wxa.xm.b.INSTANCE.a(18378, str, Long.valueOf(j3));
    }

    public boolean a(String str, Set set) {
        if (!a(str, (Object) set)) {
            return false;
        }
        if (!i()) {
            return this.f141584a.L(str, set);
        }
        this.f141588e.lock();
        a(this.f141585b);
        boolean L = this.f141584a.L(str, set);
        this.f141588e.unlock();
        return L;
    }

    public boolean a(String str, byte[] bArr) {
        if (!a(str, (Object) bArr)) {
            return false;
        }
        if (!i()) {
            return this.f141584a.P(str, bArr);
        }
        this.f141588e.lock();
        a(this.f141585b);
        boolean P = this.f141584a.P(str, bArr);
        this.f141588e.unlock();
        return P;
    }

    public boolean a(String str, Parcelable parcelable) {
        if (!a(str, (Object) parcelable)) {
            return false;
        }
        if (!i()) {
            return this.f141584a.H(str, parcelable);
        }
        this.f141588e.lock();
        a(this.f141585b);
        boolean H = this.f141584a.H(str, parcelable);
        this.f141588e.unlock();
        return H;
    }

    public String a(String str, String str2) {
        if (!i()) {
            return this.f141584a.q(str, str2);
        }
        this.f141588e.lock();
        a(this.f141585b);
        String q16 = this.f141584a.q(str, str2);
        this.f141588e.unlock();
        return q16;
    }

    public int a(String str, int i3) {
        if (!i()) {
            return this.f141584a.k(str, i3);
        }
        this.f141588e.lock();
        a(this.f141585b);
        int k3 = this.f141584a.k(str, i3);
        this.f141588e.unlock();
        return k3;
    }

    public long a(String str, long j3) {
        if (!i()) {
            return this.f141584a.m(str, j3);
        }
        this.f141588e.lock();
        a(this.f141585b);
        long m3 = this.f141584a.m(str, j3);
        this.f141588e.unlock();
        return m3;
    }

    public float a(String str, float f16) {
        if (!i()) {
            return this.f141584a.i(str, f16);
        }
        this.f141588e.lock();
        a(this.f141585b);
        float i3 = this.f141584a.i(str, f16);
        this.f141588e.unlock();
        return i3;
    }

    public boolean a(String str, boolean z16) {
        if (!i()) {
            return this.f141584a.e(str, z16);
        }
        this.f141588e.lock();
        a(this.f141585b);
        boolean e16 = this.f141584a.e(str, z16);
        this.f141588e.unlock();
        return e16;
    }

    public Parcelable a(String str, Class cls, Parcelable parcelable) {
        if (!i()) {
            return this.f141584a.o(str, cls, parcelable);
        }
        this.f141588e.lock();
        a(this.f141585b);
        Parcelable o16 = this.f141584a.o(str, cls, parcelable);
        this.f141588e.unlock();
        return o16;
    }

    public boolean a(String str) {
        if (!i()) {
            return this.f141584a.c(str);
        }
        this.f141588e.lock();
        a(this.f141585b);
        boolean c16 = this.f141584a.c(str);
        this.f141588e.unlock();
        return c16;
    }

    public String[] a() {
        if (!i()) {
            return this.f141584a.allKeys();
        }
        this.f141588e.lock();
        a(this.f141585b);
        String[] allKeys = this.f141584a.allKeys();
        this.f141588e.unlock();
        return allKeys;
    }

    public final boolean a(String str, Object obj) {
        return (w0.c(str) || obj == null || w0.c(f())) ? false : true;
    }

    public final void a(Pair pair) {
        if (f141579g.contains(pair)) {
            return;
        }
        com.tencent.luggage.wxa.y8.d dVar = f141582j;
        dVar.b(pair);
        if (h()) {
            this.f141588e.unlock();
            this.f141589f.lock();
            if (h()) {
                w.b("MicroMsg.MultiProcessMMKV", "MMKV : %s has bean closed, reopen now, my hashcode = %d, core mmkv hashcode = %d ", pair.first, Integer.valueOf(hashCode()), Integer.valueOf(this.f141584a.hashCode()));
                Pair pair2 = this.f141585b;
                this.f141584a = a((String) pair2.first, (String) pair2.second, this.f141586c);
                w.b("MicroMsg.MultiProcessMMKV", "MMKV : %s has bean closed, reopen done", pair.first);
                dVar.put(pair, this);
                w.b("MicroMsg.MultiProcessMMKV", "MMKV : %s checkReopen done", pair.first);
            }
            this.f141588e.lock();
            this.f141589f.unlock();
        }
    }
}
