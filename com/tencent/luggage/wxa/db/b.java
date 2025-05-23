package com.tencent.luggage.wxa.db;

import android.content.Context;
import android.os.Environment;
import com.tencent.libra.util.ImageContentType;
import com.tencent.luggage.wxa.tn.f0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f124170a = new b();

    /* renamed from: b, reason: collision with root package name */
    public static String f124171b = "luggage";

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f124172c = new String[1];

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f124173d = new String[1];

    /* renamed from: e, reason: collision with root package name */
    public static final String f124174e = "tencent/wxa/";

    /* renamed from: f, reason: collision with root package name */
    public static final String[] f124175f = new String[1];

    public static final void a(String namespace) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        f124171b = namespace;
    }

    public static final String b() {
        return j() + "files/public/";
    }

    public static final String c() {
        if (Intrinsics.areEqual(n(), m())) {
            return f124170a.q();
        }
        return f124170a.o();
    }

    public static final String d() {
        if (Intrinsics.areEqual(n(), m())) {
            return l();
        }
        return f124170a.o();
    }

    public static final String e() {
        String[] strArr = f124173d;
        synchronized (strArr) {
            String str = strArr[0];
            if (str != null) {
                Intrinsics.checkNotNull(str);
                return str;
            }
            String n3 = n();
            if (Intrinsics.areEqual(n3, k())) {
                return n3 + "/tencent/MicroMsg/luggage/";
            }
            StringBuilder sb5 = new StringBuilder();
            File file = new File(n3, "files/" + f124171b);
            file.mkdirs();
            sb5.append(file.getAbsolutePath());
            sb5.append('/');
            String sb6 = sb5.toString();
            strArr[0] = sb6;
            return sb6;
        }
    }

    public static final String f() {
        return e() + "Temp/";
    }

    public static final String g() {
        return f() + ImageContentType.IMAGE_PREFIX;
    }

    public static final String h() {
        return e() + "appbrand/secureInput/";
    }

    public static final String i() {
        return e() + "appbrand/wxaudio/";
    }

    public static final String j() {
        String str;
        String[] strArr = f124175f;
        synchronized (strArr) {
            if (strArr[0] == null) {
                Context c16 = z.c();
                if (c16 != null) {
                    strArr[0] = c16.getFilesDir().getParentFile().getAbsolutePath() + '/';
                } else {
                    throw new IllegalStateException("MMApplicationContext not initialized.".toString());
                }
            }
            str = strArr[0];
            Intrinsics.checkNotNull(str);
        }
        return str;
    }

    public static final String k() {
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getExternalStorageDirectory().absolutePath");
        return absolutePath;
    }

    public static final synchronized String l() {
        File file;
        String str;
        synchronized (b.class) {
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
            if (externalStoragePublicDirectory != null) {
                file = new File(externalStoragePublicDirectory, f124174e);
            } else {
                file = new File(a.k(), "DCIM/" + f124174e);
                if (!file.exists() && !file.mkdirs()) {
                    file = new File(f124170a.o());
                }
            }
            try {
                str = file.getCanonicalPath() + '/';
            } catch (Throwable unused) {
                str = file.getAbsolutePath() + '/';
            }
        }
        return str;
    }

    public static final String m() {
        File parentFile;
        String absolutePath;
        boolean z16;
        File externalCacheDir = z.c().getExternalCacheDir();
        if (externalCacheDir != null && (parentFile = externalCacheDir.getParentFile()) != null && (absolutePath = parentFile.getAbsolutePath()) != null) {
            if (absolutePath.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return absolutePath;
            }
        }
        File file = new File("/sdcard/Android/data/" + z.a());
        if (file.isDirectory() && file.exists() && file.canWrite()) {
            return file.getAbsolutePath();
        }
        return null;
    }

    public static final String n() {
        String m3;
        boolean z16;
        String[] strArr = f124172c;
        synchronized (strArr) {
            String str = strArr[0];
            if (str != null) {
                Intrinsics.checkNotNull(str);
                return str;
            }
            b bVar = f124170a;
            if (bVar.p().getBoolean("CONST_STORAGE_USE_OLD_SDCARD_ROOT", false)) {
                w.d("Luggage.CConstants", "SDCARD_ROOT=default, by MMKV");
                m3 = k();
            } else {
                if (Intrinsics.areEqual("wmpf", f124171b)) {
                    File file = new File(k(), "/tencent/MicroMsg/luggage/");
                    if (file.exists() && file.isDirectory() && file.canWrite()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        w.d("Luggage.CConstants", "SDCARD_ROOT=default, by existed directory");
                        bVar.p().putBoolean("CONST_STORAGE_USE_OLD_SDCARD_ROOT", true);
                        m3 = k();
                    }
                }
                m3 = m();
                if (m3 == null) {
                    m3 = k();
                }
            }
            strArr[0] = m3;
            w.d("Luggage.CConstants", "SDCARD_ROOT_VAL[0] = " + m3);
            return m3;
        }
    }

    public final String o() {
        return e() + "Camera/";
    }

    public final f0 p() {
        f0 e16 = f0.e("__luggage_stub_CConstants.cfg");
        Intrinsics.checkNotNullExpressionValue(e16, "getMMKV(\"__luggage_stub_CConstants.cfg\")");
        return e16;
    }

    public final String q() {
        File file;
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        if (externalStoragePublicDirectory != null) {
            file = new File(externalStoragePublicDirectory, f124174e);
        } else {
            file = new File(m(), "Pictures/" + f124174e);
            if (!file.exists() && !file.mkdirs()) {
                file = new File(o());
            }
        }
        try {
            return file.getCanonicalPath() + '/';
        } catch (Throwable unused) {
            return file.getAbsolutePath() + '/';
        }
    }

    public static final String a() {
        return j() + f124171b + '/';
    }
}
