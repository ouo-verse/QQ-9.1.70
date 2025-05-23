package c.t.m.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes.dex */
public class l1 {

    /* renamed from: a, reason: collision with root package name */
    public static volatile String f29821a = "";

    /* renamed from: b, reason: collision with root package name */
    public static volatile String f29822b = "";

    /* renamed from: c, reason: collision with root package name */
    public static volatile String f29823c = "";

    /* renamed from: d, reason: collision with root package name */
    public static volatile boolean f29824d = true;

    /* renamed from: e, reason: collision with root package name */
    public static final byte[] f29825e = new byte[0];

    /* renamed from: f, reason: collision with root package name */
    public static HashMap<String, Object> f29826f = new HashMap<>();

    @Deprecated
    public static String a() {
        return "";
    }

    public static String b() {
        Context a16 = o0.a();
        CharSequence loadLabel = a16.getApplicationInfo().loadLabel(a16.getPackageManager());
        if (loadLabel == null) {
            return "UNKNOWN";
        }
        return loadLabel.toString();
    }

    public static String c() {
        return a(o0.a());
    }

    public static String d() {
        Context a16 = o0.a();
        try {
            return InstalledAppListMonitor.getPackageInfo(a16.getPackageManager(), a16.getPackageName(), 16384).versionName;
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    public static String e() {
        String f16 = f();
        try {
            if (TextUtils.isEmpty(f29823c)) {
                f29823c = k1.a(k1.a(), "loc_build_model_encr", "");
                if (TextUtils.isEmpty(f29823c)) {
                    f29823c = d1.a(f16, KeyPropertiesCompact.DIGEST_MD5);
                    if (f29823c.length() > 8) {
                        f29823c = f29823c.substring(0, 8);
                    }
                    k1.b(k1.a(), "loc_build_model_encr", f29823c);
                }
            }
        } catch (Exception unused) {
        }
        if (f29824d) {
            f29824d = false;
            return f16 + "_" + f29823c;
        }
        return "_" + f29823c;
    }

    public static String f() {
        l();
        if (TextUtils.isEmpty(f29822b)) {
            f29822b = k1.a(k1.a(), "loc_build_model", "");
            if (TextUtils.isEmpty(f29822b)) {
                f29822b = DeviceInfoMonitor.getModel();
                k1.b(k1.a(), "loc_build_model", f29822b);
            }
        }
        return f29822b;
    }

    @Deprecated
    public static String g() {
        return "";
    }

    @Deprecated
    public static String h() {
        return "";
    }

    public static String i() {
        if (h1.a(f29821a)) {
            synchronized (f29825e) {
                f29821a = (String) k1.a(k1.a(), "loc_id_LocCommId", (Object) "");
                if (h1.a(f29821a)) {
                    long nanoTime = System.nanoTime();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j3 = (currentTimeMillis * 1000000) + (nanoTime % 1000000);
                    f29821a = d1.a("" + j3, KeyPropertiesCompact.DIGEST_MD5);
                    c1.a("SystemUtil", "generate LocCommId : " + nanoTime + "," + currentTimeMillis + "," + j3 + "," + f29821a);
                    k1.b(k1.a(), "loc_id_LocCommId", (Object) f29821a);
                }
            }
        }
        return f29821a;
    }

    @Deprecated
    public static String j() {
        return "";
    }

    @SuppressLint({"MissingPermission"})
    @Deprecated
    public static String k() {
        return "";
    }

    public static synchronized void l() {
        synchronized (l1.class) {
        }
    }

    public static synchronized void a(boolean z16) {
        synchronized (l1.class) {
        }
    }

    public static synchronized Object a(String str) {
        Object obj;
        synchronized (l1.class) {
            obj = f29826f.get(str);
            if (obj == null && (obj = o0.a().getSystemService(str)) != null) {
                f29826f.put(str, obj);
            }
        }
        return obj;
    }

    @Deprecated
    public static String a(Context context) {
        try {
            return context.getPackageName();
        } catch (Throwable unused) {
            return "UNKNOWN";
        }
    }
}
