package com.tencent.mobileqq.msf.core.net.r;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class f {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static final String f249010a = "SocketAdaptorFactory";

    /* renamed from: b, reason: collision with root package name */
    private static e f249011b = null;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f249012c = false;

    /* renamed from: d, reason: collision with root package name */
    public static int f249013d = 0;

    /* renamed from: e, reason: collision with root package name */
    public static int f249014e = 0;

    /* renamed from: f, reason: collision with root package name */
    public static final int f249015f = 0;

    /* renamed from: g, reason: collision with root package name */
    public static final int f249016g = 1;

    /* renamed from: h, reason: collision with root package name */
    public static final int f249017h = 2;

    /* renamed from: i, reason: collision with root package name */
    public static final int f249018i = 146;

    /* renamed from: j, reason: collision with root package name */
    public static final int f249019j = 147;

    /* renamed from: k, reason: collision with root package name */
    public static final int f249020k = 148;

    /* renamed from: l, reason: collision with root package name */
    public static final int f249021l = 149;

    /* renamed from: m, reason: collision with root package name */
    public static final int f249022m = 150;

    /* renamed from: n, reason: collision with root package name */
    public static final int f249023n = 151;

    /* renamed from: o, reason: collision with root package name */
    public static final int f249024o = 152;

    /* renamed from: p, reason: collision with root package name */
    public static final int f249025p = 153;

    /* renamed from: q, reason: collision with root package name */
    public static final int f249026q = 154;

    /* renamed from: r, reason: collision with root package name */
    public static final int f249027r = 155;

    /* renamed from: s, reason: collision with root package name */
    public static final int f249028s = 156;

    /* renamed from: t, reason: collision with root package name */
    public static final int f249029t = 513;

    /* renamed from: u, reason: collision with root package name */
    public static final int f249030u = 514;

    /* renamed from: v, reason: collision with root package name */
    public static final int f249031v = 515;

    /* renamed from: w, reason: collision with root package name */
    public static final int f249032w = 516;

    /* renamed from: x, reason: collision with root package name */
    private static Context f249033x;

    /* renamed from: y, reason: collision with root package name */
    private static a f249034y;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11037);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    public f(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        try {
            f249033x = context;
            f249011b = a(context);
            f249034y = new a(f249013d);
            QLog.d(f249010a, 1, "init socketadaptorfacotry succ");
        } catch (Exception e16) {
            QLog.d(f249010a, 1, "failed to init socketadaptorfacotry " + e16.toString());
            f249013d = 0;
            f249012c = false;
        }
    }

    private e a(Context context) {
        try {
            f249013d = a();
            QLog.d(f249010a, 1, "create adaptor get mode " + f249013d);
            if (f249013d != 2) {
                f249012c = true;
                return new d(context);
            }
            f249012c = true;
            return new c(context);
        } catch (Exception e16) {
            f249012c = false;
            QLog.d(f249010a, 1, "Failed to create SocketAdaptor " + e16.toString());
            return new d(context);
        }
    }

    public static boolean f() {
        return f249012c;
    }

    public e b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (e) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return f249011b;
    }

    public a c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return f249034y;
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        f249014e = f249013d;
        f249013d = 0;
        f249012c = false;
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            f249013d = f249014e;
            f249012c = true;
        }
    }

    private int a() {
        try {
            Class.forName("com.huawei.android.bastet.HwBastet");
            return 2;
        } catch (ClassNotFoundException e16) {
            e16.printStackTrace();
            return 1;
        }
    }
}
