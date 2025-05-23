package hynb.m;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import com.tencent.ams.adcore.mma.util.SharedPreferencedUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import hynb.p.g;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static Context f406754a = null;

    /* renamed from: b, reason: collision with root package name */
    public static String f406755b = "";

    /* renamed from: c, reason: collision with root package name */
    public static int f406756c = 0;

    /* renamed from: d, reason: collision with root package name */
    public static String f406757d = "huayasdk";

    /* renamed from: e, reason: collision with root package name */
    public static volatile String f406758e;

    /* renamed from: f, reason: collision with root package name */
    public static volatile String f406759f;

    /* renamed from: g, reason: collision with root package name */
    public static volatile String f406760g;

    /* renamed from: h, reason: collision with root package name */
    public static final Object f406761h = new Object();

    /* renamed from: i, reason: collision with root package name */
    public static final Object f406762i = new Object();

    /* renamed from: j, reason: collision with root package name */
    public static final Object f406763j = new Object();

    /* compiled from: P */
    /* renamed from: hynb.m.a$a, reason: collision with other inner class name */
    /* loaded from: classes28.dex */
    public static class C10487a {

        /* renamed from: a, reason: collision with root package name */
        public static final String f406764a = DeviceInfoMonitor.getModel();

        /* renamed from: b, reason: collision with root package name */
        public static final String f406765b = Build.BRAND;
    }

    static {
        new AtomicBoolean(false);
        new AtomicBoolean(false);
        new AtomicLong(0L);
        new AtomicLong(0L);
        new AtomicLong(0L);
        new AtomicBoolean(false);
        new AtomicBoolean(false);
        new AtomicLong(0L);
    }

    public static String a(ContentResolver contentResolver, String str) {
        if (SharedPreferencedUtil.SP_KEY_ANDROID_ID.equals(str)) {
            return a();
        }
        return DeviceInfoMonitor.getString(contentResolver, str);
    }

    public static String b() {
        if (f406760g != null) {
            return f406760g;
        }
        synchronized (f406763j) {
            if (f406760g == null) {
                f406760g = C10487a.f406765b;
            }
        }
        return f406760g;
    }

    public static String c() {
        if (f406759f != null) {
            return f406759f;
        }
        synchronized (f406762i) {
            if (f406759f == null) {
                f406759f = C10487a.f406764a;
            }
        }
        return f406759f;
    }

    public static boolean d() {
        return true;
    }

    public static String a() {
        if (f406758e != null) {
            return f406758e;
        }
        synchronized (f406761h) {
            if (f406758e == null && d()) {
                f406758e = a(f406754a);
            }
        }
        g.f406799a.a("HuyaSystemInfoUtils", "getAndroidId:" + f406758e);
        return f406758e;
    }

    @SuppressLint({"HardwareIds"})
    @TargetApi(3)
    public static String a(Context context) {
        return DeviceInfoMonitor.getString(context.getContentResolver(), SharedPreferencedUtil.SP_KEY_ANDROID_ID);
    }
}
