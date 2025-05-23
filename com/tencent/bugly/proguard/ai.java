package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.bugly.common.constants.SPKey;
import com.tencent.bugly.common.reporter.builder.UniqueIDHelper;
import com.tencent.bugly.common.sp.SharedPreferencesProvider;
import com.tencent.bugly.common.trace.TraceGenerator;
import com.tencent.bugly.common.utils.DeviceInfoUtil;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.mobileqq.msf.MSFAccountChangeRegisterTask;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class ai {
    public List<String> D;
    public boolean L;
    public String M;
    public String N;
    public String O;
    public String P;
    public boolean R;
    public final SharedPreferences V;
    public final SharedPreferences W;

    /* renamed from: ah, reason: collision with root package name */
    private final Context f97996ah;

    /* renamed from: ai, reason: collision with root package name */
    private String f97997ai;

    /* renamed from: aj, reason: collision with root package name */
    private String f97998aj;

    /* renamed from: ak, reason: collision with root package name */
    private String f97999ak;

    /* renamed from: as, reason: collision with root package name */
    private String f98007as;

    /* renamed from: c, reason: collision with root package name */
    public String f98015c;

    /* renamed from: d, reason: collision with root package name */
    public final String f98016d;

    /* renamed from: e, reason: collision with root package name */
    public String f98017e;

    /* renamed from: k, reason: collision with root package name */
    public final String f98023k;

    /* renamed from: l, reason: collision with root package name */
    public String f98024l;

    /* renamed from: q, reason: collision with root package name */
    public String f98029q;

    /* renamed from: t, reason: collision with root package name */
    public String f98032t;

    /* renamed from: u, reason: collision with root package name */
    public int f98033u;

    /* renamed from: v, reason: collision with root package name */
    public String f98034v;

    /* renamed from: w, reason: collision with root package name */
    public String f98035w;

    /* renamed from: ag, reason: collision with root package name */
    private static final Map<String, String> f97989ag = new HashMap();

    /* renamed from: av, reason: collision with root package name */
    private static ai f97990av = null;

    /* renamed from: ae, reason: collision with root package name */
    public static boolean f97987ae = w.f98578a;

    /* renamed from: af, reason: collision with root package name */
    public static String f97988af = TraceGenerator.getProcessLaunchId();

    /* renamed from: f, reason: collision with root package name */
    public boolean f98018f = true;

    /* renamed from: g, reason: collision with root package name */
    public final String f98019g = "com.tencent.bugly";

    /* renamed from: h, reason: collision with root package name */
    public String f98020h = "4.4.3";

    /* renamed from: i, reason: collision with root package name */
    public final String f98021i = "";

    /* renamed from: j, reason: collision with root package name */
    @Deprecated
    public final String f98022j = "";

    /* renamed from: m, reason: collision with root package name */
    public String f98025m = MSFAccountChangeRegisterTask.MSF_DEFAULT_UIN;

    /* renamed from: al, reason: collision with root package name */
    private String f98000al = "unknown";

    /* renamed from: am, reason: collision with root package name */
    private String f98001am = "";

    /* renamed from: n, reason: collision with root package name */
    public long f98026n = 0;

    /* renamed from: an, reason: collision with root package name */
    private long f98002an = -1;

    /* renamed from: ao, reason: collision with root package name */
    private long f98003ao = -1;

    /* renamed from: ap, reason: collision with root package name */
    private long f98004ap = -1;

    /* renamed from: aq, reason: collision with root package name */
    private String f98005aq = null;

    /* renamed from: o, reason: collision with root package name */
    public String f98027o = null;

    /* renamed from: p, reason: collision with root package name */
    public String f98028p = null;

    /* renamed from: ar, reason: collision with root package name */
    private Map<String, PlugInBean> f98006ar = null;

    /* renamed from: r, reason: collision with root package name */
    public boolean f98030r = false;

    /* renamed from: s, reason: collision with root package name */
    public String f98031s = null;

    /* renamed from: x, reason: collision with root package name */
    public Boolean f98036x = null;

    /* renamed from: y, reason: collision with root package name */
    public int f98037y = 0;

    /* renamed from: z, reason: collision with root package name */
    public String f98038z = "";
    public String A = null;
    public String B = null;
    public String C = null;

    /* renamed from: at, reason: collision with root package name */
    private Map<String, PlugInBean> f98008at = null;

    /* renamed from: au, reason: collision with root package name */
    private Map<String, PlugInBean> f98009au = null;
    public int E = -1;
    public int F = -1;

    /* renamed from: aw, reason: collision with root package name */
    private final Map<String, String> f98010aw = new HashMap();

    /* renamed from: ax, reason: collision with root package name */
    private final Map<String, String> f98011ax = new HashMap();

    /* renamed from: ay, reason: collision with root package name */
    private final Map<String, String> f98012ay = new HashMap();
    public String G = "unknown";
    public long H = 0;
    public long I = 0;
    public long J = 0;
    public long K = 0;
    public boolean Q = false;
    public HashMap<String, String> S = new HashMap<>();
    public boolean T = false;
    public r U = null;
    public boolean X = true;
    public boolean Y = true;
    public boolean Z = false;

    /* renamed from: aa, reason: collision with root package name */
    public boolean f97992aa = true;

    /* renamed from: az, reason: collision with root package name */
    private final Object f98013az = new Object();
    private final Object aA = new Object();
    private final Object aB = new Object();
    private final Object aC = new Object();

    /* renamed from: ab, reason: collision with root package name */
    public final Object f97993ab = new Object();

    /* renamed from: ac, reason: collision with root package name */
    public final Object f97994ac = new Object();
    private final Object aD = new Object();

    /* renamed from: ad, reason: collision with root package name */
    public boolean f97995ad = false;
    private boolean aE = false;

    /* renamed from: a, reason: collision with root package name */
    public final long f97991a = System.currentTimeMillis();

    /* renamed from: b, reason: collision with root package name */
    public final byte f98014b = 1;

    ai(Context context) {
        this.f98029q = null;
        this.f98032t = null;
        this.f98034v = null;
        this.f98007as = null;
        this.f98035w = null;
        this.D = null;
        this.L = false;
        this.M = null;
        this.N = null;
        this.O = "";
        this.P = "";
        this.R = false;
        this.f97996ah = ba.a(context);
        PackageInfo b16 = ah.b(context);
        if (b16 != null) {
            try {
                String str = b16.versionName;
                this.f98032t = str;
                this.M = str;
                this.N = Integer.toString(b16.versionCode);
            } catch (Throwable th5) {
                if (!av.a(th5)) {
                    th5.printStackTrace();
                }
            }
        }
        this.f98015c = ah.a(context);
        this.f98016d = ah.a(Process.myPid());
        this.f98034v = ah.c(context);
        this.f98023k = "Android " + aj.b() + ",level " + aj.c();
        Map<String, String> d16 = ah.d(context);
        if (d16 != null) {
            try {
                this.D = ah.a(d16);
                String str2 = d16.get("BUGLY_APPID");
                if (str2 != null) {
                    this.f98007as = str2;
                    b("APP_ID", str2);
                }
                String str3 = d16.get("BUGLY_APP_VERSION");
                if (str3 != null) {
                    this.f98032t = str3;
                }
                String str4 = d16.get("BUGLY_APP_CHANNEL");
                if (str4 != null) {
                    this.f98035w = str4;
                }
                String str5 = d16.get("BUGLY_ENABLE_DEBUG");
                if (str5 != null) {
                    this.L = str5.equalsIgnoreCase("true");
                }
                String str6 = d16.get("com.tencent.rdm.uuid");
                if (str6 != null) {
                    this.O = str6;
                }
                String str7 = d16.get("BUGLY_APP_BUILD_NO");
                if (!TextUtils.isEmpty(str7)) {
                    this.f98033u = Integer.parseInt(str7);
                }
                String str8 = d16.get("BUGLY_AREA");
                if (str8 != null) {
                    this.P = str8;
                }
            } catch (Throwable th6) {
                if (!av.a(th6)) {
                    th6.printStackTrace();
                }
            }
        }
        try {
            if (!context.getDatabasePath("bugly_db_").exists()) {
                this.R = true;
                av.c("App is first time to be installed on the device.", new Object[0]);
            }
        } catch (Throwable th7) {
            if (p.f98529c) {
                th7.printStackTrace();
            }
        }
        this.V = ba.a(Constants.BUGLY_SHARED_PREFERENCES, context);
        this.W = ba.a("BUGLY_RESERVED_VALUES", context);
        this.f98029q = DeviceInfoUtil.getCpuAbiByLibDir(context);
        G();
        av.c("com info create end", new Object[0]);
    }

    public static int C() {
        return aj.c();
    }

    @Deprecated
    public static boolean F() {
        av.a("Detect if the device hook is unavailable", new Object[0]);
        return false;
    }

    private void G() {
        try {
            for (Map.Entry<String, ?> entry : this.W.getAll().entrySet()) {
                av.c("put reserved request data from sp, key:%s value:%s", entry.getKey(), entry.getValue());
                a(entry.getKey(), entry.getValue().toString(), false);
            }
            for (Map.Entry<String, String> entry2 : f97989ag.entrySet()) {
                av.c("put reserved request data from cache, key:%s value:%s", entry2.getKey(), entry2.getValue());
                a(entry2.getKey(), entry2.getValue(), true);
            }
            f97989ag.clear();
        } catch (Throwable th5) {
            av.b(th5);
        }
    }

    public static synchronized ai c() {
        ai aiVar;
        synchronized (ai.class) {
            aiVar = f97990av;
        }
        return aiVar;
    }

    @Deprecated
    public static String o() {
        return "";
    }

    public final int A() {
        int i3;
        synchronized (this.f97993ab) {
            i3 = this.E;
        }
        return i3;
    }

    public final synchronized Map<String, PlugInBean> B() {
        Map<String, PlugInBean> map;
        map = this.f98008at;
        Map<String, PlugInBean> map2 = this.f98009au;
        if (map2 != null) {
            map.putAll(map2);
        }
        return map;
    }

    public final int D() {
        int i3 = this.V.getInt(Constants.SP_EMULATOR_CONFIDENCE, 0);
        this.f98037y = i3;
        return i3;
    }

    public final String E() {
        String d16 = ba.d(Constants.SP_EMULATOR_REASON, "");
        this.f98038z = d16;
        return d16;
    }

    public final boolean a() {
        return this.T && this.f97992aa;
    }

    public final boolean b() {
        av.c("isAppForeground:%s", Boolean.valueOf(this.aE));
        return this.aE;
    }

    public final void d() {
        synchronized (this.f98013az) {
            this.f97997ai = UUID.randomUUID().toString();
        }
    }

    public final String e() {
        String str;
        synchronized (this.f98013az) {
            if (this.f97997ai == null) {
                d();
            }
            str = this.f97997ai;
        }
        return str;
    }

    public final String f() {
        if (!ba.b(this.f98017e)) {
            return this.f98017e;
        }
        return this.f98007as;
    }

    public final String g() {
        String str;
        synchronized (this.f97994ac) {
            str = this.f98025m;
        }
        return str;
    }

    public final String h() {
        if (!TextUtils.isEmpty(this.f97999ak)) {
            return this.f97999ak;
        }
        SharedPreferences sharedPreferences = SharedPreferencesProvider.getInstance().getSharedPreferences(this.f97996ah, SPKey.SP_NAME, true);
        UniqueIDHelper uniqueIDHelper = new UniqueIDHelper();
        String uniqueID = uniqueIDHelper.getUniqueID(this.f97999ak, sharedPreferences, this.V);
        this.f97999ak = uniqueID;
        if (TextUtils.isEmpty(uniqueID)) {
            return "";
        }
        uniqueIDHelper.updateLastUniqueID(this.f97999ak, sharedPreferences, this.V);
        return this.f97999ak;
    }

    public final synchronized String i() {
        if (!TextUtils.isEmpty(this.f97998aj)) {
            return this.f97998aj;
        }
        String d16 = ba.d("deviceModel", null);
        this.f97998aj = d16;
        if (d16 != null) {
            av.c("collect device model from sp:%s", d16);
            return this.f97998aj;
        }
        if (!this.f98030r) {
            av.c("not allow collect device model", new Object[0]);
            return "fail";
        }
        String a16 = aj.a();
        this.f97998aj = a16;
        av.c("collect device model:%s", a16);
        ba.c("deviceModel", this.f97998aj);
        return this.f97998aj;
    }

    public final synchronized String j() {
        return this.f98001am;
    }

    public final long k() {
        if (this.f98002an <= 0) {
            this.f98002an = aj.e();
        }
        return this.f98002an;
    }

    public final long l() {
        if (this.f98003ao <= 0) {
            this.f98003ao = aj.k();
        }
        return this.f98003ao;
    }

    public final long m() {
        if (this.f98004ap <= 0) {
            this.f98004ap = aj.m();
        }
        return this.f98004ap;
    }

    public final String n() {
        if (!TextUtils.isEmpty(this.f98027o)) {
            return this.f98027o;
        }
        return "unknown";
    }

    public final String p() {
        try {
            Map<String, ?> all = this.f97996ah.getSharedPreferences("BuglySdkInfos", 0).getAll();
            if (!all.isEmpty()) {
                synchronized (this.aA) {
                    for (Map.Entry<String, ?> entry : all.entrySet()) {
                        try {
                            this.S.put(entry.getKey(), entry.getValue().toString());
                        } catch (Throwable th5) {
                            av.a(th5);
                        }
                    }
                }
            }
        } catch (Throwable th6) {
            av.a(th6);
        }
        if (!this.S.isEmpty()) {
            StringBuilder sb5 = new StringBuilder();
            for (Map.Entry<String, String> entry2 : this.S.entrySet()) {
                sb5.append("[");
                sb5.append(entry2.getKey());
                sb5.append(",");
                sb5.append(entry2.getValue());
                sb5.append("] ");
            }
            av.c("SDK_INFO = %s", sb5.toString());
            b("SDK_INFO", sb5.toString());
            return sb5.toString();
        }
        av.c("SDK_INFO is empty", new Object[0]);
        return null;
    }

    public final synchronized Map<String, PlugInBean> q() {
        Map<String, PlugInBean> map = this.f98006ar;
        if (map != null && map.size() > 0) {
            HashMap hashMap = new HashMap(this.f98006ar.size());
            hashMap.putAll(this.f98006ar);
            return hashMap;
        }
        return null;
    }

    public final String r() {
        if (this.f98031s == null) {
            this.f98031s = aj.o();
        }
        return this.f98031s;
    }

    public final Boolean s() {
        if (this.f98036x == null) {
            this.f98036x = Boolean.valueOf(aj.s());
        }
        return this.f98036x;
    }

    public final String t() {
        if (this.A == null) {
            String str = aj.p();
            this.A = str;
            av.a("ROM ID: %s", str);
        }
        return this.A;
    }

    public final Map<String, String> u() {
        synchronized (this.aB) {
            if (this.f98010aw.size() <= 0) {
                return null;
            }
            return new HashMap(this.f98010aw);
        }
    }

    public final void v() {
        synchronized (this.aB) {
            this.f98010aw.clear();
        }
    }

    public final int w() {
        int size;
        synchronized (this.aB) {
            size = this.f98010aw.size();
        }
        return size;
    }

    public final Set<String> x() {
        Set<String> keySet;
        synchronized (this.aB) {
            keySet = this.f98010aw.keySet();
        }
        return keySet;
    }

    public final Map<String, String> y() {
        synchronized (this.aD) {
            if (this.f98011ax.size() <= 0) {
                return null;
            }
            return new HashMap(this.f98011ax);
        }
    }

    public final Map<String, String> z() {
        synchronized (this.aC) {
            if (this.f98012ay.size() <= 0) {
                return null;
            }
            return new HashMap(this.f98012ay);
        }
    }

    public final void a(boolean z16) {
        av.c("setActivityForeState, isFore:%s", Boolean.valueOf(z16));
        this.aE = z16;
        r rVar = this.U;
        if (rVar != null) {
            rVar.setNativeIsAppForeground(z16);
        }
    }

    public final void c(String str) {
        av.a("change deviceModel\uff0cold:%s new:%s", this.f97998aj, str);
        this.f97998aj = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ba.c("deviceModel", str);
    }

    public final void b(String str) {
        this.f97999ak = str;
        if (!TextUtils.isEmpty(str)) {
            ba.c(Constants.SP_DEVICE_ID, str);
        }
        synchronized (this.aD) {
            this.f98011ax.put(Constants.USER_SET_DEVICE_ID, str);
        }
    }

    public final synchronized void d(String str) {
        this.f98000al = String.valueOf(str);
    }

    public final void f(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f98028p = str.trim();
    }

    public final synchronized void g(String str) {
        if (str != null) {
            Map<String, PlugInBean> map = this.f98006ar;
            if (map != null) {
                map.remove(str);
            }
        }
    }

    public static synchronized ai a(Context context) {
        ai aiVar;
        synchronized (ai.class) {
            if (f97990av == null) {
                f97990av = new ai(context);
            }
            aiVar = f97990av;
        }
        return aiVar;
    }

    public final synchronized void e(String str) {
        this.f98001am = String.valueOf(str);
    }

    private void b(String str, String str2) {
        if (ba.b(str) || ba.b(str2)) {
            av.d("server key&value should not be empty %s %s", String.valueOf(str), String.valueOf(str2));
            return;
        }
        synchronized (this.aC) {
            this.f98012ay.put(str, str2);
        }
    }

    public final void a(String str) {
        this.f98007as = str;
        b("APP_ID", str);
    }

    public final String h(String str) {
        String remove;
        if (ba.b(str)) {
            av.d("key should not be empty %s", String.valueOf(str));
            return null;
        }
        synchronized (this.aB) {
            remove = this.f98010aw.remove(str);
        }
        return remove;
    }

    public final synchronized boolean a(String str, String str2, String str3) {
        if (str == null || str2 == null || str3 == null) {
            return false;
        }
        if (this.f98006ar == null) {
            this.f98006ar = new HashMap();
        }
        this.f98006ar.put(str, new PlugInBean(str, str2, str3));
        av.a("add %s %s %s", str, str2, str3);
        return true;
    }

    public final String i(String str) {
        String str2;
        if (ba.b(str)) {
            av.d("key should not be empty %s", String.valueOf(str));
            return null;
        }
        synchronized (this.aB) {
            str2 = this.f98010aw.get(str);
        }
        return str2;
    }

    public final synchronized void b(Map<String, PlugInBean> map) {
        this.f98009au = map;
    }

    public final void a(String str, String str2) {
        if (ba.b(str) || ba.b(str2)) {
            av.d("key&value should not be empty %s %s", String.valueOf(str), String.valueOf(str2));
            return;
        }
        synchronized (this.aB) {
            this.f98010aw.put(str, str2);
        }
    }

    public final void a(String str, String str2, boolean z16) {
        if (ba.b(str)) {
            av.d("key should not be empty %s", str);
            return;
        }
        av.c("putExtraRequestData key:%s value:%s save:%s", str, str2, Boolean.valueOf(z16));
        synchronized (this.aD) {
            if (TextUtils.isEmpty(str2)) {
                this.f98011ax.remove(str);
                this.W.edit().remove(str).apply();
            } else {
                this.f98011ax.put(str, str2);
                if (z16) {
                    this.W.edit().putString(str, str2).apply();
                }
            }
        }
    }

    public final synchronized void a(Map<String, PlugInBean> map) {
        this.f98008at = map;
    }
}
