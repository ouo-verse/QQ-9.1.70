package com.tencent.luggage.wxa.ar;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.xweb.XWebSdk;
import com.tencent.xweb.internal.ConstValue;
import java.util.regex.Pattern;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes8.dex */
public class l {
    public String H;
    public String I;
    public String J;

    /* renamed from: a, reason: collision with root package name */
    public int f121708a = -1;

    /* renamed from: b, reason: collision with root package name */
    public int f121709b = -1;

    /* renamed from: c, reason: collision with root package name */
    public int f121710c = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f121711d = -1;

    /* renamed from: e, reason: collision with root package name */
    public int f121712e = -1;

    /* renamed from: f, reason: collision with root package name */
    public int f121713f = -1;

    /* renamed from: g, reason: collision with root package name */
    public int f121714g = -1;

    /* renamed from: h, reason: collision with root package name */
    public int f121715h = -1;

    /* renamed from: i, reason: collision with root package name */
    public int f121716i = -1;

    /* renamed from: j, reason: collision with root package name */
    public int f121717j = -1;

    /* renamed from: k, reason: collision with root package name */
    public String f121718k = "";

    /* renamed from: l, reason: collision with root package name */
    public String f121719l = "";

    /* renamed from: m, reason: collision with root package name */
    public int f121720m = -1;

    /* renamed from: n, reason: collision with root package name */
    public int f121721n = -1;

    /* renamed from: o, reason: collision with root package name */
    public int f121722o = -1;

    /* renamed from: p, reason: collision with root package name */
    public int f121723p = -1;

    /* renamed from: q, reason: collision with root package name */
    public int f121724q = -1;

    /* renamed from: r, reason: collision with root package name */
    public int f121725r = -1;

    /* renamed from: s, reason: collision with root package name */
    public int f121726s = -1;

    /* renamed from: t, reason: collision with root package name */
    public double f121727t = -1.0d;

    /* renamed from: u, reason: collision with root package name */
    public double f121728u = -1.0d;

    /* renamed from: v, reason: collision with root package name */
    public String f121729v = "";

    /* renamed from: w, reason: collision with root package name */
    public String f121730w = "";

    /* renamed from: x, reason: collision with root package name */
    public int f121731x = -1;

    /* renamed from: y, reason: collision with root package name */
    public int f121732y = -1;

    /* renamed from: z, reason: collision with root package name */
    public int f121733z = -1;
    public int A = -1;
    public String B = null;
    public String C = null;
    public String D = null;
    public String E = null;
    public int F = -1;
    public int G = -1;
    public String K = null;

    public final boolean a(double d16) {
        return d16 >= 0.0d && d16 < 24.0d;
    }

    public void b(String str) {
        this.K = str;
    }

    public final boolean c() {
        if (!TextUtils.isEmpty(this.D) && b(this.D, b.a())) {
            return true;
        }
        return false;
    }

    public final boolean d() {
        if (!TextUtils.isEmpty(this.E) && b(this.E, j())) {
            return true;
        }
        return false;
    }

    public final boolean e() {
        if (!TextUtils.isEmpty(this.B) && !b(this.B, b.a())) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        if (this.f121726s > 0 && XWebSdk.getIpType() != this.f121726s) {
            return true;
        }
        return false;
    }

    public final boolean g() {
        String str = this.f121730w;
        if (str != null && str.trim() != null && !this.f121730w.trim().isEmpty() && !a(this.f121730w, XWalkEnvironment.getPackageName())) {
            return true;
        }
        return false;
    }

    public final boolean h() {
        String str = this.f121719l;
        if (str != null && str.trim() != null && !this.f121719l.trim().isEmpty() && !a(this.f121719l)) {
            return true;
        }
        return false;
    }

    public final String i() {
        String str = this.J;
        if (str != null && !"".equals(str)) {
            return "ConfigFilter(" + this.J + "|" + hashCode() + ")";
        }
        return "ConfigFilter(" + hashCode() + ")";
    }

    public String j() {
        if (!TextUtils.isEmpty(this.K)) {
            return this.K;
        }
        return b.b();
    }

    public final boolean k() {
        if (!a(this.f121727t) && !a(this.f121728u)) {
            return true;
        }
        double a16 = a0.a();
        double d16 = this.f121728u;
        if (d16 > 0.0d && a16 > d16) {
            return false;
        }
        double d17 = this.f121727t;
        if (d17 <= 0.0d || a16 >= d17) {
            return true;
        }
        return false;
    }

    public boolean l() {
        return !b.b().equalsIgnoreCase(this.K);
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder("Filter{");
        if (this.f121708a != 0) {
            sb5.append("sdkMin=");
            sb5.append(this.f121708a);
        }
        if (this.f121709b != 0) {
            sb5.append(", sdkMax=");
            sb5.append(this.f121709b);
        }
        if (this.f121710c != 0) {
            sb5.append(", apkMin=");
            sb5.append(this.f121710c);
        }
        if (this.f121711d != 0) {
            sb5.append(", apkMax=");
            sb5.append(this.f121711d);
        }
        if (this.f121712e != 0) {
            sb5.append(", preDownApkMin=");
            sb5.append(this.f121712e);
        }
        if (this.f121713f != 0) {
            sb5.append(", preDownApkMax=");
            sb5.append(this.f121713f);
        }
        if (this.f121714g != 0) {
            sb5.append(", apiMin=");
            sb5.append(this.f121714g);
        }
        if (this.f121715h != 0) {
            sb5.append(", apiMax=");
            sb5.append(this.f121715h);
        }
        if (this.f121716i != 0) {
            sb5.append(", targetApiMin=");
            sb5.append(this.f121716i);
        }
        if (this.f121717j != 0) {
            sb5.append(", targetApiMax=");
            sb5.append(this.f121717j);
        }
        if (this.f121720m != 0) {
            sb5.append(", grayMin=");
            sb5.append(this.f121720m);
        }
        if (this.f121721n != 0) {
            sb5.append(", grayMax=");
            sb5.append(this.f121721n);
        }
        if (this.f121722o != 0) {
            sb5.append(", dayGrayMin=");
            sb5.append(this.f121722o);
        }
        if (this.f121723p != 0) {
            sb5.append(", dayGrayMax=");
            sb5.append(this.f121723p);
        }
        if (this.f121724q != 0) {
            sb5.append(", chromeMin=");
            sb5.append(this.f121724q);
        }
        if (this.f121725r != 0) {
            sb5.append(", chromeMax=");
            sb5.append(this.f121725r);
        }
        if (this.f121726s != 0) {
            sb5.append(", usertype=");
            sb5.append(this.f121726s);
        }
        if (this.f121727t != -1.0d) {
            sb5.append(", hoursStart=");
            sb5.append(this.f121727t);
        }
        if (this.f121728u != -1.0d) {
            sb5.append(", hoursEnd=");
            sb5.append(this.f121728u);
        }
        if (this.f121731x != 0) {
            sb5.append(", x5sdkmin=");
            sb5.append(this.f121731x);
        }
        if (this.f121732y != 0) {
            sb5.append(", x5sdkmax=");
            sb5.append(this.f121732y);
        }
        if (this.f121733z != 0) {
            sb5.append(", x5coremin=");
            sb5.append(this.f121733z);
        }
        if (this.A != 0) {
            sb5.append(", x5coremax=");
            sb5.append(this.A);
        }
        if (this.F != 0) {
            sb5.append(", appClientVerMin=");
            sb5.append(this.F);
        }
        if (this.G != 0) {
            sb5.append(", appClientVerMax=");
            sb5.append(this.G);
        }
        if (!TextUtils.isEmpty(this.f121718k)) {
            sb5.append(", forbidDeviceRegex='");
            sb5.append(this.f121718k);
            sb5.append('\'');
        }
        if (!TextUtils.isEmpty(this.f121719l)) {
            sb5.append(", whiteDeviceRegex='");
            sb5.append(this.f121719l);
            sb5.append('\'');
        }
        if (!TextUtils.isEmpty(this.f121729v)) {
            sb5.append(", forbidAppRegex='");
            sb5.append(this.f121729v);
            sb5.append('\'');
        }
        if (!TextUtils.isEmpty(this.f121730w)) {
            sb5.append(", whiteAppRegex='");
            sb5.append(this.f121730w);
            sb5.append('\'');
        }
        if (!TextUtils.isEmpty(this.B)) {
            sb5.append(", deviceAbis='");
            sb5.append(this.B);
            sb5.append('\'');
        }
        if (!TextUtils.isEmpty(this.C)) {
            sb5.append(", runtimeAbis='");
            sb5.append(this.C);
            sb5.append('\'');
        }
        if (!TextUtils.isEmpty(this.D)) {
            sb5.append(", blackDeviceAbis='");
            sb5.append(this.D);
            sb5.append('\'');
        }
        if (!TextUtils.isEmpty(this.E)) {
            sb5.append(", blackRuntimeAbis='");
            sb5.append(this.E);
            sb5.append('\'');
        }
        if (!TextUtils.isEmpty(this.H)) {
            sb5.append(", appInfoWhiteList='");
            sb5.append(this.H);
            sb5.append('\'');
        }
        if (!TextUtils.isEmpty(this.I)) {
            sb5.append(", appInfoBlackList='");
            sb5.append(this.I);
            sb5.append('\'');
        }
        sb5.append('}');
        return sb5.toString();
    }

    public static boolean a(int i3, int i16, int i17) {
        if (i17 <= 0 || i3 <= i17) {
            return i16 <= 0 || i3 >= i16;
        }
        return false;
    }

    public final boolean b() {
        return (TextUtils.isEmpty(this.H) || XWalkEnvironment.containsAppInfo(this.H)) ? false : true;
    }

    public static boolean b(String str, String str2) {
        String[] split;
        if (str == null || (split = str.split("\\|")) == null || split.length < 0 || TextUtils.isEmpty(str2)) {
            return false;
        }
        String trim = str2.trim();
        for (String str3 : split) {
            if (!TextUtils.isEmpty(str3) && str3.trim().equalsIgnoreCase(trim)) {
                return true;
            }
        }
        return false;
    }

    public boolean a(boolean z16, boolean z17, String str) {
        this.J = str;
        int installedNewstVersionForCurAbi = XWalkEnvironment.getInstalledNewstVersionForCurAbi();
        int installedNewstVersionForPredownAbi = XWalkEnvironment.getInstalledNewstVersionForPredownAbi();
        int xWebSdkVersion = XWebSdk.getXWebSdkVersion();
        int i3 = XWalkEnvironment.getApplicationContext().getApplicationInfo() != null ? XWalkEnvironment.getApplicationContext().getApplicationInfo().targetSdkVersion : 0;
        int b16 = v0.b();
        boolean z18 = z16 || a(b16, this.f121720m, this.f121721n);
        String i16 = i();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("checkMatch, ignoreGrayValue:");
        sb5.append(z16);
        sb5.append(", grayValue(");
        sb5.append(b16);
        sb5.append("):");
        sb5.append(a(b16, this.f121720m, this.f121721n));
        sb5.append(", apk(");
        sb5.append(installedNewstVersionForCurAbi);
        sb5.append("):");
        sb5.append(a(installedNewstVersionForCurAbi, this.f121710c, this.f121711d));
        sb5.append(", preDownApk(");
        sb5.append(installedNewstVersionForPredownAbi);
        sb5.append("):");
        sb5.append(a(installedNewstVersionForPredownAbi, this.f121712e, this.f121713f));
        sb5.append(", sdk(");
        sb5.append(xWebSdkVersion);
        sb5.append("):");
        sb5.append(a(xWebSdkVersion, this.f121708a, this.f121709b));
        sb5.append(", api(");
        int i17 = Build.VERSION.SDK_INT;
        sb5.append(i17);
        sb5.append("):");
        sb5.append(a(i17, this.f121714g, this.f121715h));
        sb5.append(", targetApi(");
        sb5.append(i3);
        sb5.append("):");
        sb5.append(a(i3, this.f121716i, this.f121717j));
        sb5.append(", todayGrayValue(");
        sb5.append(v0.d());
        sb5.append("):");
        sb5.append(a(v0.d(), this.f121722o, this.f121723p));
        sb5.append(", forbidDeviceRegex(");
        sb5.append(this.f121718k);
        sb5.append("):");
        sb5.append(a(this.f121718k));
        sb5.append(", forbidAppRegex(");
        sb5.append(this.f121729v);
        sb5.append("):");
        sb5.append(a(this.f121729v, XWalkEnvironment.getPackageName()));
        sb5.append(", timeRange:");
        sb5.append(k());
        sb5.append(", runtimeAbi:");
        sb5.append(b.b());
        sb5.append(", targetRuntimeAbi:");
        sb5.append(j());
        x0.d(i16, sb5.toString());
        if (a(installedNewstVersionForCurAbi, installedNewstVersionForPredownAbi, xWebSdkVersion, i3, z18)) {
            if (f()) {
                x0.d(i(), "not match user type:" + this.f121726s);
                return false;
            }
            if (h()) {
                x0.d(i(), "not match white device regex:" + this.f121719l);
                return false;
            }
            if (g()) {
                x0.d(i(), "not match white app regex:" + this.f121730w);
                return false;
            }
            if (this.f121724q > 0 || this.f121725r > 0) {
                int a16 = g.a();
                if (!a(a16, this.f121724q, this.f121725r)) {
                    x0.d(i(), "not match chromium version(" + this.f121724q + ", " + this.f121725r + "), current version is:" + a16);
                    return false;
                }
            }
            if (a(z17)) {
                x0.d(i(), "not match whiteRuntimeAbis, white abis is:" + this.C + ", cur runtime abi is:" + b.b() + ", target runtime abi:" + j());
                return false;
            }
            if (e()) {
                x0.d(i(), "not match whiteDeviceAbis, white abis is:" + this.B + ", cur device abi is:" + b.a());
                return false;
            }
            if (d()) {
                x0.d(i(), "not match in blackRuntimeAbis, black abis is:" + this.E + ", cur runtime abi is:" + b.b() + ", target runtime abi:" + j());
                return false;
            }
            if (c()) {
                x0.d(i(), "not match in blackDeviceAbis, black abis is:" + this.D + ", cur device abi is:" + b.a());
                return false;
            }
            int initConfig = XWalkEnvironment.getInitConfig(ConstValue.INIT_CONFIG_KEY_CLIENT_VERSION, 0);
            if (initConfig > 0 && !a(initConfig, this.F, this.G)) {
                x0.d(i(), "not match AppClientVersion(" + this.F + ", " + this.G + "), cur client version is:" + initConfig);
                return false;
            }
            if (b()) {
                x0.d(i(), "not match appInfoWhiteList:" + this.H);
                return false;
            }
            if (!a()) {
                return true;
            }
            x0.d(i(), "not match in appInfoBlackList:" + this.I);
            return false;
        }
        x0.d(i(), "checkMatch, not match");
        return false;
    }

    public final boolean a(int i3, int i16, int i17, int i18, boolean z16) {
        return z16 && a(i3, this.f121710c, this.f121711d) && a(i16, this.f121712e, this.f121713f) && a(i17, this.f121708a, this.f121709b) && a(Build.VERSION.SDK_INT, this.f121714g, this.f121715h) && a(i18, this.f121716i, this.f121717j) && a(v0.d(), this.f121722o, this.f121723p) && !a(this.f121718k) && !a(this.f121729v, XWalkEnvironment.getPackageName()) && k();
    }

    public final boolean a(boolean z16) {
        return (z16 || !TextUtils.isEmpty(this.C)) && !b(this.C, j());
    }

    public final boolean a() {
        return !TextUtils.isEmpty(this.I) && XWalkEnvironment.containsAppInfo(this.I);
    }

    public static boolean a(String str) {
        String str2 = "";
        if (f.a() != null) {
            str2 = "" + f.a();
        }
        if (f.c() != null) {
            str2 = str2 + " " + f.c();
        }
        if (f.b() != null) {
            str2 = str2 + " " + f.b();
        }
        if (str == null || str2 == null || str.isEmpty()) {
            return false;
        }
        return a(str, str2);
    }

    public static boolean a(String str, String str2) {
        boolean z16 = false;
        if (str == null || str.isEmpty() || str.trim() == null || str.trim().isEmpty() || str2 == null || str2.isEmpty()) {
            return false;
        }
        try {
            z16 = Pattern.compile(str.toUpperCase()).matcher(str2.toUpperCase()).find();
            x0.f("ConfigDef", "isMatchRex, result:" + z16 + ", regex:" + str + ", content:" + str2);
            return z16;
        } catch (Throwable unused) {
            x0.c("ConfigDef", "_IsMatchRex, compile pattern failed, strRex:" + str + ", strContent:" + str2);
            return z16;
        }
    }
}
