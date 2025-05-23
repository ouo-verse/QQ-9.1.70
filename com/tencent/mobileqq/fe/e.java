package com.tencent.mobileqq.fe;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes12.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static e f205826e;

    /* renamed from: f, reason: collision with root package name */
    public static String f205827f;

    /* renamed from: g, reason: collision with root package name */
    private static final AtomicBoolean f205828g;

    /* renamed from: h, reason: collision with root package name */
    private static String f205829h;

    /* renamed from: i, reason: collision with root package name */
    private static String f205830i;

    /* renamed from: j, reason: collision with root package name */
    private static String f205831j;

    /* renamed from: a, reason: collision with root package name */
    private boolean f205832a;

    /* renamed from: b, reason: collision with root package name */
    private long f205833b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f205834c;

    /* renamed from: d, reason: collision with root package name */
    private String f205835d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13112);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
            return;
        }
        f205827f = "fekit";
        f205828g = new AtomicBoolean(false);
        f205829h = "FEKit_SO_PATH_20220713";
        f205830i = "FEKit_SO_VERSION_20220823";
        f205831j = "FEKit_V1_20220713";
    }

    e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f205832a = false;
        this.f205833b = 0L;
        this.f205834c = false;
        this.f205835d = "release/sq_8.4.1_6b18f4816";
    }

    private boolean a() {
        String d16 = d();
        c.c("FEKitSoLoader", 1, "local version:8.401.830");
        c.c("FEKitSoLoader", 1, "lastVersion is " + d16 + " local is 8.401.830");
        if (!TextUtils.isEmpty(d16) && k(d16)) {
            File file = new File(c());
            if (file.exists()) {
                try {
                    System.load(file.getAbsolutePath());
                    c.c("FEKitSoLoader", 1, "load download so success");
                    this.f205835d = d16;
                    this.f205832a = true;
                    this.f205834c = true;
                    return true;
                } catch (Throwable th5) {
                    c.a("FEKitSoLoader", 1, "load download so error!,path:" + file.getAbsolutePath() + ",info:" + th5.getMessage());
                }
            }
        }
        return false;
    }

    public static e b() {
        if (f205826e == null) {
            synchronized (e.class) {
                if (f205826e == null) {
                    f205826e = new e();
                }
            }
        }
        return f205826e;
    }

    private String c() {
        return f.a().g(f205831j + f205829h);
    }

    private String d() {
        return f.a().g(f205831j + f205830i);
    }

    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.f205832a;
    }

    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f205835d;
    }

    public long g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
        }
        return this.f205833b;
    }

    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.f205834c;
    }

    public boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        synchronized (e.class) {
            if (this.f205832a || a()) {
                return true;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            boolean k3 = com.tencent.mobileqq.fe.utils.soload.f.k(FEKit.getInstance().getContext(), f205827f);
            this.f205833b = SystemClock.uptimeMillis() - uptimeMillis;
            if (k3) {
                this.f205832a = true;
                c.c("FEKitSoLoader", 1, "load local so success");
                return true;
            }
            this.f205832a = false;
            c.a("FEKitSoLoader", 1, "load local so error!");
            return false;
        }
    }

    public boolean j(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str)).booleanValue();
        }
        try {
            String[] split = "8.401.830".split("\\.");
            String[] split2 = str.split("\\.");
            int min = Math.min(split.length, split2.length);
            for (int i3 = 0; i3 < min; i3++) {
                int parseInt = Integer.parseInt(split[i3]);
                int parseInt2 = Integer.parseInt(split2[i3]);
                if (parseInt > parseInt2) {
                    return false;
                }
                if (parseInt < parseInt2) {
                    return true;
                }
            }
            if (split.length < split2.length) {
                if (Integer.parseInt(split2[min]) > 0) {
                    return true;
                }
            }
        } catch (Throwable th5) {
            c.a("FEKitSoLoader", 1, "compare version error :" + th5.getMessage());
        }
        return false;
    }

    public boolean k(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str)).booleanValue();
        }
        try {
            String[] split = "8.401.830".split("\\.");
            String[] split2 = str.split("\\.");
            if (split.length == 3 && split2.length == 3 && TextUtils.equals(split[0], split2[0]) && TextUtils.equals(split[1], split2[1])) {
                if (Integer.parseInt(split[2]) < Integer.parseInt(split2[2])) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th5) {
            c.a("FEKitSoLoader", 1, "compare version error :" + th5.getMessage());
            return false;
        }
    }

    public void l(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        f.a().f(f205831j + f205829h, str);
    }

    public void m(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        f.a().f(f205831j + f205830i, str);
    }
}
