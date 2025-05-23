package com.tencent.mapsdk.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import java.io.File;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class mz {

    /* renamed from: a, reason: collision with root package name */
    public static final String f149356a = "data/";

    /* renamed from: f, reason: collision with root package name */
    private static final String f149357f = "/tencentmapsdk/";

    /* renamed from: g, reason: collision with root package name */
    private static mz f149358g;

    /* renamed from: b, reason: collision with root package name */
    public String f149359b;

    /* renamed from: c, reason: collision with root package name */
    public String f149360c;

    /* renamed from: d, reason: collision with root package name */
    public String f149361d;

    /* renamed from: e, reason: collision with root package name */
    public String f149362e;

    /* renamed from: h, reason: collision with root package name */
    private Context f149363h;

    /* renamed from: i, reason: collision with root package name */
    private String f149364i;

    /* renamed from: j, reason: collision with root package name */
    private String f149365j;

    /* renamed from: k, reason: collision with root package name */
    private String f149366k;

    /* renamed from: l, reason: collision with root package name */
    private String f149367l;

    /* renamed from: m, reason: collision with root package name */
    private String f149368m;

    /* renamed from: n, reason: collision with root package name */
    private String f149369n;

    /* renamed from: o, reason: collision with root package name */
    private String f149370o;

    /* renamed from: p, reason: collision with root package name */
    private String f149371p;

    /* JADX WARN: Removed duplicated region for block: B:17:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    mz(Context context, TencentMapOptions tencentMapOptions) {
        boolean z16;
        if (context != null) {
            this.f149363h = context.getApplicationContext();
            if (tencentMapOptions != null) {
                String customCacheRootPath = tencentMapOptions.getCustomCacheRootPath();
                if (!TextUtils.isEmpty(customCacheRootPath)) {
                    File file = new File(customCacheRootPath);
                    if (file.isDirectory() && file.canRead() && file.canWrite() && e(customCacheRootPath) > 5) {
                        z16 = true;
                        if (z16) {
                            this.f149371p = customCacheRootPath;
                        }
                    }
                }
                z16 = false;
                if (z16) {
                }
            }
            this.f149369n = this.f149363h.getFilesDir().getAbsolutePath();
            this.f149366k = this.f149369n + "/tencentMapSdk/config/";
            this.f149370o = this.f149366k + "temp/";
            this.f149367l = this.f149369n + "/tencentMapSdk/assets/";
            this.f149368m = this.f149369n + "/tencentMapSdk/dynamicAssets/";
            Context context2 = this.f149363h;
            String a16 = my.a(context2).a("sdkVersion");
            if (!hs.a(my.a(context2).a("sdkVersion")) && ho.b("4.1.0", a16) > 0) {
                mx.a(context2);
                kt.f(new File(this.f149366k));
                kt.f(new File(this.f149367l));
                kt.f(new File(this.f149369n + "/tencentMapSdk/subKey/"));
            }
            String a17 = a();
            String a18 = kt.a(this.f149363h);
            if (hs.a(a18)) {
                this.f149364i = a17 + f149357f;
            } else {
                this.f149364i = a17 + f149357f + a18;
            }
            this.f149365j = this.f149364i + "/data/v4/render/";
            this.f149359b = this.f149364i + "/sat/";
            this.f149360c = this.f149365j + "closeRoadDatas/";
            this.f149361d = this.f149365j + "events/icons";
            this.f149362e = this.f149365j + "offlineMaps/";
            return;
        }
        throw new Error("context can not be null");
    }

    private static mz a(Context context) {
        return a(context, (TencentMapOptions) null);
    }

    private static String b(Context context) {
        File externalFilesDir = context.getExternalFilesDir(null);
        if (externalFilesDir != null) {
            return externalFilesDir.getAbsolutePath();
        }
        return context.getFilesDir().getPath();
    }

    private static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        return file.isDirectory() && file.canRead() && file.canWrite() && e(str) > 5;
    }

    @SuppressLint({"NewApi"})
    private static long e(String str) {
        try {
            StatFs statFs = new StatFs(str);
            return ((statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong()) / 1024) / 1024;
        } catch (Exception unused) {
            return 0L;
        }
    }

    private void f() {
        this.f149369n = this.f149363h.getFilesDir().getAbsolutePath();
        this.f149366k = this.f149369n + "/tencentMapSdk/config/";
        this.f149370o = this.f149366k + "temp/";
        this.f149367l = this.f149369n + "/tencentMapSdk/assets/";
        this.f149368m = this.f149369n + "/tencentMapSdk/dynamicAssets/";
        Context context = this.f149363h;
        String a16 = my.a(context).a("sdkVersion");
        if (!hs.a(my.a(context).a("sdkVersion")) && ho.b("4.1.0", a16) > 0) {
            mx.a(context);
            kt.f(new File(this.f149366k));
            kt.f(new File(this.f149367l));
            kt.f(new File(this.f149369n + "/tencentMapSdk/subKey/"));
        }
    }

    private void g() {
        String a16 = a();
        String a17 = kt.a(this.f149363h);
        if (hs.a(a17)) {
            this.f149364i = a16 + f149357f;
        } else {
            this.f149364i = a16 + f149357f + a17;
        }
        this.f149365j = this.f149364i + "/data/v4/render/";
        this.f149359b = this.f149364i + "/sat/";
        this.f149360c = this.f149365j + "closeRoadDatas/";
        this.f149361d = this.f149365j + "events/icons";
        this.f149362e = this.f149365j + "offlineMaps/";
    }

    private String h() {
        ku.a(this.f149359b);
        return this.f149359b;
    }

    private String i() {
        ku.a(this.f149360c);
        return this.f149360c;
    }

    private String j() {
        ku.a(this.f149361d);
        return this.f149361d;
    }

    private String k() {
        ku.a(this.f149362e);
        return this.f149362e;
    }

    public final File c() {
        return new File(this.f149364i);
    }

    public static mz a(Context context, TencentMapOptions tencentMapOptions) {
        if (f149358g == null) {
            f149358g = new mz(context, tencentMapOptions);
        }
        return f149358g;
    }

    public final String c(String str) {
        String str2;
        if (hs.a(str)) {
            str2 = this.f149370o;
        } else {
            str2 = a(str) + "temp/";
        }
        ku.a(str2);
        return str2;
    }

    public final File b() {
        return new File(this.f149364i + "/data/");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(TencentMapOptions tencentMapOptions) {
        boolean z16;
        if (tencentMapOptions == null) {
            return;
        }
        String customCacheRootPath = tencentMapOptions.getCustomCacheRootPath();
        if (!TextUtils.isEmpty(customCacheRootPath)) {
            File file = new File(customCacheRootPath);
            if (file.isDirectory() && file.canRead() && file.canWrite() && e(customCacheRootPath) > 5) {
                z16 = true;
                if (z16) {
                    return;
                }
                this.f149371p = customCacheRootPath;
                return;
            }
        }
        z16 = false;
        if (z16) {
        }
    }

    public final String b(String str) {
        String str2;
        if (hs.a(str)) {
            str2 = this.f149367l;
        } else {
            str2 = this.f149369n + "/tencentMapSdk/subKey/" + str + "/assets/";
        }
        ku.a(str2);
        return str2;
    }

    public final String e() {
        ku.a(this.f149368m);
        return this.f149368m;
    }

    public final String d() {
        ku.a(this.f149365j);
        return this.f149365j;
    }

    private void a(Context context, String str) {
        if (!hs.a(my.a(context).a("sdkVersion")) && ho.b("4.1.0", str) > 0) {
            mx.a(context);
            kt.f(new File(this.f149366k));
            kt.f(new File(this.f149367l));
            kt.f(new File(this.f149369n + "/tencentMapSdk/subKey/"));
        }
    }

    public final String a() {
        if (!TextUtils.isEmpty(this.f149371p)) {
            return this.f149371p;
        }
        Context context = this.f149363h;
        String b16 = b(context);
        if (e(b16) >= 5) {
            return b16;
        }
        String path = context.getFilesDir().getPath();
        return e(path) < 5 ? b(context) : path;
    }

    public final String a(String str) {
        String str2;
        if (hs.a(str)) {
            str2 = this.f149366k;
        } else {
            str2 = this.f149369n + "/tencentMapSdk/subKey/" + str + "/config/";
        }
        ku.a(str2);
        return str2;
    }
}
