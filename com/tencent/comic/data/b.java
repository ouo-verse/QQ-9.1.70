package com.tencent.comic.data;

import android.os.Build;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {
    static IPatchRedirector $redirector_;
    public long A;

    /* renamed from: a, reason: collision with root package name */
    public String f99291a;

    /* renamed from: b, reason: collision with root package name */
    public String f99292b;

    /* renamed from: c, reason: collision with root package name */
    public String f99293c;

    /* renamed from: d, reason: collision with root package name */
    public String f99294d;

    /* renamed from: e, reason: collision with root package name */
    public String f99295e;

    /* renamed from: f, reason: collision with root package name */
    public String f99296f;

    /* renamed from: g, reason: collision with root package name */
    public String f99297g;

    /* renamed from: h, reason: collision with root package name */
    public String f99298h;

    /* renamed from: i, reason: collision with root package name */
    public String f99299i;

    /* renamed from: j, reason: collision with root package name */
    public String f99300j;

    /* renamed from: k, reason: collision with root package name */
    public long f99301k;

    /* renamed from: l, reason: collision with root package name */
    public long f99302l;

    /* renamed from: m, reason: collision with root package name */
    public long f99303m;

    /* renamed from: n, reason: collision with root package name */
    public long f99304n;

    /* renamed from: o, reason: collision with root package name */
    public long f99305o;

    /* renamed from: p, reason: collision with root package name */
    public long f99306p;

    /* renamed from: q, reason: collision with root package name */
    public long f99307q;

    /* renamed from: r, reason: collision with root package name */
    public long f99308r;

    /* renamed from: s, reason: collision with root package name */
    public int f99309s;

    /* renamed from: t, reason: collision with root package name */
    public int f99310t;

    /* renamed from: u, reason: collision with root package name */
    public String f99311u;

    /* renamed from: v, reason: collision with root package name */
    public String f99312v;

    /* renamed from: w, reason: collision with root package name */
    public String f99313w;

    /* renamed from: x, reason: collision with root package name */
    public String f99314x;

    /* renamed from: y, reason: collision with root package name */
    public String f99315y;

    /* renamed from: z, reason: collision with root package name */
    public String f99316z;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f99291a = "";
        this.f99292b = "";
        this.f99293c = "";
        this.f99294d = "";
        this.f99295e = "";
        this.f99296f = "";
        this.f99297g = "";
        this.f99298h = "";
        this.f99299i = "";
        this.f99300j = "";
        this.f99301k = -1L;
        this.f99302l = -1L;
        this.f99303m = -1L;
        this.f99304n = -1L;
        this.f99305o = -1L;
        this.f99306p = -1L;
        this.f99307q = -1L;
        this.f99308r = -1L;
        this.f99309s = 0;
        this.f99310t = -1;
        this.f99311u = Build.VERSION.RELEASE;
        this.f99312v = Build.BRAND;
        this.f99313w = DeviceInfoMonitor.getModel();
        this.f99314x = Build.MANUFACTURER;
        this.f99315y = AppSetting.f99554n;
        this.f99316z = f.f99362s;
        this.A = System.currentTimeMillis();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f99291a + "|" + this.f99292b + "|" + this.f99293c + "|" + this.f99294d + "|" + this.f99295e + "|" + this.f99296f + "|" + this.f99297g + "|" + this.f99298h + "|" + this.f99299i + "|" + this.f99300j + "|" + this.f99301k + "|" + this.f99302l + "|" + this.f99303m + "|" + this.f99304n + "|" + this.f99305o + "|" + this.f99306p + "|" + this.f99307q + "|" + this.f99308r + "|" + this.f99309s + "|" + this.f99310t + "|" + this.f99311u + "|" + this.f99312v + "|" + this.f99313w + "|" + this.f99314x + "|" + this.f99315y + "|" + this.f99316z + "|" + this.A;
    }
}
