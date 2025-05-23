package com.tencent.open.adapter;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {

    /* renamed from: l, reason: collision with root package name */
    protected static a f339516l = null;

    /* renamed from: m, reason: collision with root package name */
    protected static String f339517m = "androidqq";

    /* renamed from: a, reason: collision with root package name */
    protected long f339518a = 0;

    /* renamed from: b, reason: collision with root package name */
    protected long f339519b = 0;

    /* renamed from: c, reason: collision with root package name */
    protected String f339520c = "";

    /* renamed from: d, reason: collision with root package name */
    protected String f339521d = "";

    /* renamed from: e, reason: collision with root package name */
    protected String f339522e = "";

    /* renamed from: f, reason: collision with root package name */
    protected String f339523f = "";

    /* renamed from: g, reason: collision with root package name */
    protected String f339524g = "";

    /* renamed from: h, reason: collision with root package name */
    protected String f339525h = "";

    /* renamed from: i, reason: collision with root package name */
    protected int f339526i = -1;

    /* renamed from: j, reason: collision with root package name */
    protected String f339527j = "";

    /* renamed from: k, reason: collision with root package name */
    protected Context f339528k = BaseApplication.getContext();

    protected a() {
    }

    public static synchronized a f() {
        a aVar;
        synchronized (a.class) {
            if (f339516l == null) {
                f339516l = new a();
            }
            aVar = f339516l;
        }
        return aVar;
    }

    public String a() {
        return this.f339521d;
    }

    public String b() {
        return "12";
    }

    public int c() {
        int i3 = this.f339526i;
        if (i3 != -1) {
            return i3;
        }
        g();
        return this.f339526i;
    }

    public String d() {
        if (!TextUtils.isEmpty(this.f339523f)) {
            return this.f339523f;
        }
        g();
        return this.f339523f;
    }

    public Context e() {
        Context context = this.f339528k;
        if (context == null) {
            return BaseApplication.getContext();
        }
        return context;
    }

    protected void g() {
        Context applicationContext = f().e().getApplicationContext();
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(applicationContext.getPackageManager(), applicationContext.getPackageName(), 0);
            this.f339522e = packageInfo.versionName;
            this.f339523f = this.f339522e + "." + packageInfo.versionCode;
            String str = this.f339522e;
            this.f339524g = str.substring(str.lastIndexOf(46) + 1, this.f339522e.length());
            this.f339526i = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e16) {
            QLog.e("AppUpdate", 1, "getPackageInfo NameNotFoundException : " + e16.toString());
        } catch (Exception e17) {
            QLog.e("AppUpdate", 1, "getPackageInfo exception : " + e17.toString());
        }
    }

    public String h() {
        return f339517m;
    }

    public String i() {
        if (!TextUtils.isEmpty(this.f339525h)) {
            return this.f339525h;
        }
        String str = "V1_AND_SQ_" + d();
        this.f339525h = str;
        return str;
    }

    public String j() {
        return this.f339527j;
    }

    public String k() {
        return this.f339520c;
    }

    public long l() {
        try {
            this.f339518a = Long.valueOf(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount()).longValue();
            if (QLog.isColorLevel()) {
                QLog.i("CommonDataAdapter", 2, "get uin from app runtim succ:" + this.f339518a);
            }
        } catch (Throwable unused) {
        }
        return this.f339518a;
    }

    public long m() {
        return this.f339519b;
    }

    public String n() {
        if (!TextUtils.isEmpty(this.f339522e)) {
            return this.f339522e;
        }
        g();
        return this.f339522e;
    }

    public void o(String str) {
        this.f339521d = str;
    }

    public void p(Context context) {
        if (context == null) {
            return;
        }
        this.f339528k = context;
    }

    public void q(String str) {
        this.f339527j = str;
    }

    public void r(String str) {
        this.f339520c = str;
    }

    public void s(long j3) {
        this.f339518a = j3;
    }

    public void t(long j3) {
        this.f339519b = j3;
    }
}
