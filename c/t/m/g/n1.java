package c.t.m.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes.dex */
public class n1 {

    /* renamed from: l, reason: collision with root package name */
    public static volatile n1 f29874l;

    /* renamed from: a, reason: collision with root package name */
    public final Context f29875a;

    /* renamed from: b, reason: collision with root package name */
    public final o1 f29876b;

    /* renamed from: c, reason: collision with root package name */
    public final SharedPreferences f29877c = k1.a("LocationSDK");

    /* renamed from: d, reason: collision with root package name */
    public final ExecutorService f29878d;

    /* renamed from: e, reason: collision with root package name */
    public final HashMap<String, p1> f29879e;

    /* renamed from: f, reason: collision with root package name */
    public final PackageManager f29880f;

    /* renamed from: g, reason: collision with root package name */
    public final TelephonyManager f29881g;

    /* renamed from: h, reason: collision with root package name */
    public final WifiManager f29882h;

    /* renamed from: i, reason: collision with root package name */
    public final LocationManager f29883i;

    /* renamed from: j, reason: collision with root package name */
    public final y2 f29884j;

    /* renamed from: k, reason: collision with root package name */
    public List<y3> f29885k;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public class a implements ThreadFactory {
        public a(n1 n1Var) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new BaseThread(runnable, "locationsdk_network_request_pool");
        }
    }

    public n1(Context context) {
        this.f29875a = context;
        this.f29880f = context.getPackageManager();
        this.f29881g = (TelephonyManager) context.getSystemService("phone");
        this.f29882h = (WifiManager) context.getSystemService("wifi");
        this.f29883i = (LocationManager) context.getSystemService("location");
        new Bundle().putString("channelId", u3.a(context.getPackageName()));
        this.f29884j = z2.a().b();
        BaseThreadPoolExecutor baseThreadPoolExecutor = new BaseThreadPoolExecutor(1, 5, 60000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new a(this));
        baseThreadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f29878d = baseThreadPoolExecutor;
        HashMap<String, p1> hashMap = new HashMap<>();
        this.f29879e = hashMap;
        hashMap.put("cell", new q1("cell"));
        o1 o1Var = new o1(this);
        this.f29876b = o1Var;
        try {
            o1Var.c(c(context));
        } catch (Throwable unused) {
            o3.a("AppContext", "transactionTooLarge");
        }
        k();
    }

    public static n1 b(Context context) {
        if (f29874l == null) {
            synchronized (n1.class) {
                if (f29874l == null) {
                    f29874l = new n1(context.getApplicationContext());
                }
            }
        }
        return f29874l;
    }

    public o1 a() {
        return this.f29876b;
    }

    @Nullable
    public SharedPreferences c() {
        return this.f29877c;
    }

    @Nullable
    public TelephonyManager d() {
        return this.f29881g;
    }

    public ExecutorService e() {
        return this.f29878d;
    }

    @Nullable
    public WifiManager f() {
        return this.f29882h;
    }

    public boolean g() {
        if (this.f29883i != null) {
            return true;
        }
        return false;
    }

    public boolean h() {
        if (this.f29881g != null) {
            return true;
        }
        return false;
    }

    public boolean i() {
        if (this.f29882h != null) {
            return true;
        }
        return false;
    }

    @SuppressLint({"MissingPermission"})
    public final void j() {
        String str;
        o1 o1Var = this.f29876b;
        PackageInfo n3 = n();
        o1Var.d(n3.versionCode);
        o1Var.h(n3.versionName);
        CharSequence loadLabel = this.f29875a.getApplicationInfo().loadLabel(this.f29880f);
        if (loadLabel != null) {
            str = loadLabel.toString();
        } else {
            str = "unknown";
        }
        o1Var.a(str);
        TelephonyManager d16 = d();
        if (d16 != null) {
            o1Var.b(d16.getPhoneType());
            String a16 = r3.a("", r3.f29969a);
            String a17 = r3.a("", r3.f29970b);
            o1Var.b(a16);
            o1Var.g(a17);
            o1Var.d("");
        }
        o1Var.e(r3.a("", r3.f29971c));
        PackageManager packageManager = this.f29880f;
        boolean hasSystemFeature = packageManager.hasSystemFeature("android.hardware.location.gps");
        boolean hasSystemFeature2 = packageManager.hasSystemFeature("android.hardware.wifi");
        boolean hasSystemFeature3 = packageManager.hasSystemFeature("android.hardware.telephony");
        o1Var.b(hasSystemFeature);
        o1Var.c(hasSystemFeature2);
        o1Var.a(hasSystemFeature3);
        o3.b("AppContext", "doInBg: hasGps=" + hasSystemFeature + ",hasWifi=" + hasSystemFeature2 + ",hasCell=" + hasSystemFeature3);
        o1Var.c(a(this.f29875a));
    }

    public void k() {
        m();
        l();
    }

    public void l() {
        try {
            o3.b("AppContext", "doInBg: app status init start");
            j();
            o3.b("AppContext", "doInBg: app status init done");
        } catch (Throwable th5) {
            o3.a("AppContext", "doInBg: app status init error", th5);
        }
    }

    public final void m() {
        SharedPreferences.Editor edit = k1.a("BuglySdkInfos").edit();
        edit.putString("c467546440", this.f29876b.p() + "_" + this.f29876b.d());
        edit.apply();
    }

    public final PackageInfo n() {
        try {
            return InstalledAppListMonitor.getPackageInfo(this.f29880f, this.f29875a.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException unused) {
            return new PackageInfo();
        }
    }

    public static String c(Context context) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle != null) {
                if (bundle.containsKey("TencentGeoLocationSDK")) {
                    return bundle.getString("TencentGeoLocationSDK");
                }
                if (bundle.containsKey("TencentMapSDK")) {
                    return bundle.getString("TencentMapSDK");
                }
            }
        } catch (Exception unused) {
        }
        return "";
    }

    public o1 a(long j3) {
        return this.f29876b;
    }

    public p1 a(String str) {
        return this.f29879e.get(str);
    }

    public String a(String str, byte[] bArr) throws IOException {
        long currentTimeMillis = System.currentTimeMillis();
        Pair<byte[], String> a16 = this.f29884j.a(str, bArr);
        o3.a("HttpUrlConnectionTimeCost:" + (System.currentTimeMillis() - currentTimeMillis));
        byte[] b16 = u3.b((byte[]) a16.first);
        if (b16 != null) {
            return new String(b16, (String) a16.second);
        }
        o3.b("AppContext", "HttpUrlConnection postSync: inflate failed");
        return "{}";
    }

    @Nullable
    public LocationManager b() {
        return this.f29883i;
    }

    public synchronized void b(Object obj) {
        boolean z16;
        if (this.f29885k == null) {
            this.f29885k = new ArrayList();
        }
        Iterator<y3> it = this.f29885k.iterator();
        while (true) {
            if (it.hasNext()) {
                if (obj == it.next().b()) {
                    z16 = true;
                    break;
                }
            } else {
                z16 = false;
                break;
            }
        }
        if (z16) {
            return;
        }
        for (Method method : obj.getClass().getDeclaredMethods()) {
            String name = method.getName();
            if (name.startsWith("on") && name.endsWith("Event")) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1) {
                    this.f29885k.add(new y3(parameterTypes[0], method, obj, false));
                } else {
                    throw new IllegalArgumentException("EventHandler methods must specify a single Object paramter.");
                }
            }
        }
    }

    public synchronized void a(@Nullable Object obj) {
        if (obj == null) {
            return;
        }
        List<y3> list = this.f29885k;
        if (list != null) {
            for (y3 y3Var : list) {
                if (y3Var.a(obj)) {
                    try {
                        y3Var.a().invoke(y3Var.b(), obj);
                    } catch (Exception e16) {
                        o3.a("AppContext", "", e16);
                    }
                }
            }
        }
    }

    public void a(Pair<String, String> pair) {
        this.f29876b.a(pair);
    }

    public final int a(Context context) {
        PackageInfo packageInfo;
        if (context == null) {
            return -2;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (packageInfo = InstalledAppListMonitor.getPackageInfo(packageManager, "com.txy.anywhere", 4)) == null) {
                return -2;
            }
            return packageInfo.versionCode;
        } catch (Throwable unused) {
            return -1;
        }
    }
}
