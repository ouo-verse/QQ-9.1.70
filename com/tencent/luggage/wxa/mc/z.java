package com.tencent.luggage.wxa.mc;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import androidx.arch.core.util.Function;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.pts.utils.PTSFileUtil;
import java.io.FileNotFoundException;
import java.io.InputStream;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class z {

    /* renamed from: a, reason: collision with root package name */
    public static final int f134409a;

    /* renamed from: b, reason: collision with root package name */
    public static final int f134410b;

    /* renamed from: c, reason: collision with root package name */
    public static final b f134411c;

    /* renamed from: d, reason: collision with root package name */
    public static Boolean f134412d;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f134413a;

        static {
            int[] iArr = new int[b.values().length];
            f134413a = iArr;
            try {
                iArr[b.DEVELOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum b {
        DEVELOP,
        STABLE
    }

    static {
        int i3 = -1;
        try {
            String a16 = a();
            if (!w0.c(a16) && com.tencent.luggage.wxa.cp.x.d(a16)) {
                i3 = new JSONObject(com.tencent.luggage.wxa.cp.x.p(a16)).optInt("version");
            }
        } catch (Exception unused) {
        }
        if (i3 > 0) {
            f134409a = i3;
            f134411c = b.STABLE;
        } else {
            f134409a = 1354;
            f134411c = b.STABLE;
        }
        f134410b = 0;
        f134412d = null;
    }

    public static String a() {
        return new com.tencent.luggage.wxa.cp.v(com.tencent.luggage.wxa.tn.z.c().getCacheDir().getAbsolutePath() + "/MockLibInfo.json").g();
    }

    public static AssetFileDescriptor b(String str) {
        String a16 = com.tencent.luggage.wxa.rc.m.a(str);
        if (a16.endsWith(PTSFileUtil.JS_FORMAT)) {
            a16 = a16 + ".nocompress";
        }
        AssetManager b16 = com.tencent.luggage.wxa.tn.z.b();
        try {
            if (a.f134413a[f134411c.ordinal()] != 1) {
                return b16.openFd("wxa_library" + a16);
            }
            return b16.openFd("wxa_library/develop" + a16);
        } catch (Exception unused) {
            return null;
        }
    }

    public static InputStream c(String str) {
        InputStream inputStream;
        Function b16 = com.tencent.luggage.wxa.tk.c.b();
        if (b16 != null && (inputStream = (InputStream) b16.apply(str)) != null) {
            return inputStream;
        }
        AssetManager b17 = com.tencent.luggage.wxa.tn.z.b();
        try {
            if (str.endsWith(PTSFileUtil.JS_FORMAT)) {
                return b17.open(str + ".nocompress", 3);
            }
            return b17.open(str, 3);
        } catch (Exception e16) {
            if (e16 instanceof FileNotFoundException) {
                try {
                    return b17.open(str, 3);
                } catch (Exception e17) {
                    com.tencent.luggage.wxa.tn.w.g("MicroMsg.AppBrand.WxaLocalLibPkg", "openRead file( %s ) failed, exp = %s", str, e17);
                    return null;
                }
            }
            com.tencent.luggage.wxa.tn.w.g("MicroMsg.AppBrand.WxaLocalLibPkg", "openRead file( %s ) failed, exp = %s", str, e16);
            return null;
        }
    }

    public static InputStream a(String str) {
        String a16 = com.tencent.luggage.wxa.rc.m.a(str);
        if (a.f134413a[f134411c.ordinal()] != 1) {
            return c("wxa_library" + a16);
        }
        return c("wxa_library/develop" + a16);
    }
}
