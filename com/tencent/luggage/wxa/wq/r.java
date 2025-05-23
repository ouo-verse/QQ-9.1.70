package com.tencent.luggage.wxa.wq;

import android.os.Looper;
import com.tencent.luggage.wxa.ar.n0;
import com.tencent.luggage.wxa.ar.v0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.xweb.CommandCfg;
import com.tencent.xweb.XWebSdk;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes8.dex */
public class r {

    /* renamed from: y, reason: collision with root package name */
    public static boolean f144395y = false;

    /* renamed from: a, reason: collision with root package name */
    public boolean f144396a = false;

    /* renamed from: b, reason: collision with root package name */
    public boolean f144397b = true;

    /* renamed from: c, reason: collision with root package name */
    public boolean f144398c = false;

    /* renamed from: d, reason: collision with root package name */
    public String f144399d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f144400e = "others";

    /* renamed from: f, reason: collision with root package name */
    public long f144401f = -1;

    /* renamed from: g, reason: collision with root package name */
    public long f144402g = -1;

    /* renamed from: h, reason: collision with root package name */
    public long f144403h = -1;

    /* renamed from: i, reason: collision with root package name */
    public int f144404i = 1;

    /* renamed from: j, reason: collision with root package name */
    public long f144405j = -1;

    /* renamed from: k, reason: collision with root package name */
    public int f144406k = -1;

    /* renamed from: l, reason: collision with root package name */
    public long f144407l = -1;

    /* renamed from: m, reason: collision with root package name */
    public long f144408m = -1;

    /* renamed from: n, reason: collision with root package name */
    public long f144409n = -1;

    /* renamed from: o, reason: collision with root package name */
    public int f144410o = 1;

    /* renamed from: p, reason: collision with root package name */
    public int f144411p = -1;

    /* renamed from: q, reason: collision with root package name */
    public long f144412q = -1;

    /* renamed from: r, reason: collision with root package name */
    public long f144413r = -1;

    /* renamed from: s, reason: collision with root package name */
    public long f144414s = -1;

    /* renamed from: t, reason: collision with root package name */
    public int f144415t = 1;

    /* renamed from: u, reason: collision with root package name */
    public int f144416u = -1;

    /* renamed from: v, reason: collision with root package name */
    public long f144417v = -1;

    /* renamed from: w, reason: collision with root package name */
    public long f144418w = -1;

    /* renamed from: x, reason: collision with root package name */
    public long f144419x = -1;

    public void a(boolean z16) {
        this.f144396a = z16;
    }

    public void b(boolean z16) {
        this.f144397b = z16;
    }

    public void c() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(XWebSdk.getXWebSdkVersion());
        sb5.append(",");
        sb5.append(XWebSdk.getAvailableVersion());
        sb5.append(",");
        sb5.append(this.f144396a ? "1" : "0");
        sb5.append(",");
        sb5.append(this.f144397b ? "1" : "0");
        sb5.append(",");
        sb5.append(this.f144399d);
        sb5.append(",");
        sb5.append(this.f144401f);
        sb5.append(",");
        sb5.append(this.f144402g);
        sb5.append(",");
        sb5.append(this.f144403h);
        sb5.append(",");
        sb5.append(this.f144404i);
        sb5.append(",");
        sb5.append(this.f144405j);
        sb5.append(",");
        sb5.append(this.f144406k);
        sb5.append(",");
        sb5.append(this.f144407l);
        sb5.append(",");
        sb5.append(this.f144408m);
        sb5.append(",");
        sb5.append(this.f144409n);
        sb5.append(",");
        sb5.append(this.f144410o);
        sb5.append(",");
        sb5.append(this.f144411p);
        sb5.append(",");
        sb5.append(this.f144412q);
        sb5.append(",");
        sb5.append(this.f144413r);
        sb5.append(",");
        sb5.append(this.f144414s);
        sb5.append(",");
        sb5.append(this.f144415t);
        sb5.append(",");
        sb5.append(this.f144416u);
        sb5.append(",");
        sb5.append(this.f144417v);
        sb5.append(",");
        sb5.append(this.f144418w);
        sb5.append(",");
        sb5.append(this.f144419x);
        sb5.append(",");
        sb5.append(this.f144398c ? "1" : "0");
        sb5.append(",");
        sb5.append(XWalkEnvironment.getApplicationContext().getPackageName());
        sb5.append(",");
        sb5.append(Looper.myLooper() == Looper.getMainLooper() ? 1 : 0);
        sb5.append(",");
        sb5.append(v0.b());
        sb5.append(",");
        sb5.append(this.f144400e);
        sb5.append(",");
        sb5.append(CommandCfg.getInstance().getConfigVersion());
        String sb6 = sb5.toString();
        x0.d("KVReportForWebView", "report:" + sb6);
        if (XWalkEnvironment.getBuildConfigThirdPartyRelease() && CommandCfg.getInstance().getEnableThirdAppReport()) {
            n0.a(10128, sb6);
        } else {
            n0.a(24340, sb6);
        }
    }

    public void d() {
        this.f144412q = System.currentTimeMillis();
    }

    public void e() {
        this.f144401f = System.currentTimeMillis();
    }

    public void a(String str) {
        this.f144400e = str;
    }

    public void b(String str) {
        this.f144399d = str;
    }

    public void d(int i3) {
        this.f144416u = i3;
        this.f144417v = System.currentTimeMillis();
    }

    public void a(int i3) {
        long currentTimeMillis = System.currentTimeMillis();
        this.f144408m = currentTimeMillis;
        this.f144409n = currentTimeMillis - this.f144407l;
        this.f144410o = i3;
    }

    public long b() {
        return this.f144403h;
    }

    public void b(int i3) {
        long currentTimeMillis = System.currentTimeMillis();
        this.f144402g = currentTimeMillis;
        this.f144403h = currentTimeMillis - this.f144401f;
        this.f144404i = i3;
        if (i3 == 1 && !f144395y) {
            f144395y = true;
            this.f144398c = true;
        }
        x0.d("KVReportForWebView", "finishCreateWebView, isFirstCreatedWebView:" + this.f144398c);
        c();
    }

    public void a(int i3, int i16) {
        this.f144411p = i16;
        long currentTimeMillis = System.currentTimeMillis();
        this.f144413r = currentTimeMillis;
        this.f144414s = currentTimeMillis - this.f144412q;
        this.f144415t = i3;
    }

    public void a() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f144418w = currentTimeMillis;
        this.f144419x = currentTimeMillis - this.f144417v;
    }

    public void c(int i3) {
        this.f144406k = i3;
        long currentTimeMillis = System.currentTimeMillis();
        this.f144407l = currentTimeMillis;
        this.f144405j = currentTimeMillis - this.f144401f;
    }
}
