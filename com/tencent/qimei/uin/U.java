package com.tencent.qimei.uin;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.ab.a;
import com.tencent.qimei.ad.c;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;

/* compiled from: P */
/* loaded from: classes22.dex */
public class U {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static boolean f343406a = false;

    public U() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static byte a(String str, String str2) {
        if (!f343406a) {
            return (byte) -1;
        }
        try {
            return e(str, str2);
        } catch (NoSuchMethodError e16) {
            e16.printStackTrace();
            return (byte) -1;
        }
    }

    private static native byte[] a(int i3, byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static String b(Context context) {
        if (!f343406a) {
            return "";
        }
        try {
            return z2(context, Build.VERSION.SDK_INT);
        } catch (UnsatisfiedLinkError e16) {
            e16.printStackTrace();
            return "";
        }
    }

    private static native boolean b();

    public static String c() {
        if (!f343406a) {
            return "";
        }
        try {
            return u();
        } catch (UnsatisfiedLinkError e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public static String d() {
        if (f343406a) {
            try {
                return o();
            } catch (UnsatisfiedLinkError e16) {
                e16.printStackTrace();
                return "";
            }
        }
        return "";
    }

    private static native byte[] d(String str);

    private static native byte e(String str, String str2);

    public static boolean e() {
        if (!f343406a) {
            return false;
        }
        try {
            return b();
        } catch (UnsatisfiedLinkError e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public static boolean f(String str) {
        if (f343406a) {
            try {
                return w(str);
            } catch (UnsatisfiedLinkError e16) {
                e16.printStackTrace();
                return false;
            }
        }
        return false;
    }

    private static native String m(int i3);

    private static native void n(Context context, String str, Object[] objArr, boolean z16);

    private static native String o();

    private static native String p();

    private static native String r(boolean z16, int i3, int i16, String str, int i17, String[] strArr, String str2);

    private static native byte[] r4(byte[] bArr, int i3, byte[] bArr2, int i16);

    private static native boolean s(String str);

    private static native String tvc();

    private static native String tvd();

    private static native String tvm(String str);

    private static native String tvs();

    private static native String u();

    private static native boolean w(String str);

    private static native String x(String str);

    private static native void y(String str);

    private static native String z(Context context);

    private static native String z2(Context context, int i3);

    public static String a() {
        if (!f343406a) {
            return "";
        }
        try {
            return m(Build.VERSION.SDK_INT);
        } catch (UnsatisfiedLinkError e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public static byte[] b(int i3, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (!f343406a) {
            return null;
        }
        try {
            return a(i3, bArr, bArr2, bArr3);
        } catch (UnsatisfiedLinkError e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static boolean c(String str) {
        if (!f343406a) {
            return false;
        }
        try {
            return s(str);
        } catch (UnsatisfiedLinkError e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public static synchronized boolean e(String str) {
        synchronized (U.class) {
            if (f343406a) {
                return true;
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    System.load(str);
                    f343406a = true;
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
                return f343406a;
            }
            int i3 = 0;
            do {
                try {
                    int i16 = a.f342921a;
                    System.loadLibrary(TVKLiveRequestBuilder.RequestParamKey.QIMEI36);
                    f343406a = true;
                } catch (Throwable th6) {
                    c.a("so load fail,error info :%s", th6.toString(), new Object[0]);
                }
                i3++;
                if (f343406a) {
                    break;
                }
            } while (i3 < 2);
            return f343406a;
        }
    }

    public static String a(Context context) {
        if (!f343406a) {
            return "";
        }
        try {
            return z(context);
        } catch (UnsatisfiedLinkError e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public static byte[] b(String str) {
        if (!f343406a) {
            return null;
        }
        try {
            return d(str);
        } catch (NoSuchMethodError e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static String a(String str) {
        if (f343406a) {
            try {
                String x16 = x(str);
                return TextUtils.isEmpty(x16) ? "" : x16;
            } catch (UnsatisfiedLinkError e16) {
                e16.printStackTrace();
            }
        }
        return "";
    }

    public static String a(String str, int i3, String str2, int i16) {
        if (!f343406a) {
            return null;
        }
        try {
            return r(false, Build.VERSION.SDK_INT, i3, str2, i16, com.tencent.qimei.au.a.a(str).a(), "");
        } catch (UnsatisfiedLinkError e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static String a(String str, int i3, String str2, int i16, String str3) {
        if (!f343406a) {
            return null;
        }
        try {
            return r(true, Build.VERSION.SDK_INT, i3, str2, i16, com.tencent.qimei.au.a.a(str).a(), str3);
        } catch (UnsatisfiedLinkError e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static boolean a(Context context, String str, String str2, boolean z16) {
        e(str2);
        if (f343406a) {
            try {
                n(context, str, com.tencent.qimei.f.a.c(), z16);
                return true;
            } catch (UnsatisfiedLinkError e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int length2 = bArr2.length;
        if (!f343406a) {
            return null;
        }
        try {
            return r4(bArr, length, bArr2, length2);
        } catch (UnsatisfiedLinkError e16) {
            e16.printStackTrace();
            return null;
        }
    }
}
