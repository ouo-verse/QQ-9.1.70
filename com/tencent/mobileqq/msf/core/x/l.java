package com.tencent.mobileqq.msf.core.x;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class l extends f {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: j, reason: collision with root package name */
    private static final String f250311j = "releaseSamplingRate";

    /* renamed from: k, reason: collision with root package name */
    private static final String f250312k = "graySamplingRate";

    /* renamed from: l, reason: collision with root package name */
    private static final String f250313l = "importantCmdRate";

    /* renamed from: m, reason: collision with root package name */
    private static final String f250314m = "subConnSamplingRate";

    /* renamed from: n, reason: collision with root package name */
    public static final String f250315n = "nullQimeiReleaseSamplingRate";

    /* renamed from: o, reason: collision with root package name */
    public static final String f250316o = "nullQimeiGraySamplingRate";

    /* renamed from: p, reason: collision with root package name */
    public static final String f250317p = "grayImportantCmdRate";

    /* renamed from: q, reason: collision with root package name */
    public static final int f250318q = 10000;

    /* renamed from: r, reason: collision with root package name */
    public static final int f250319r = 100;

    /* renamed from: s, reason: collision with root package name */
    public static final int f250320s = 100;

    /* renamed from: t, reason: collision with root package name */
    public static final int f250321t = 1;

    /* renamed from: u, reason: collision with root package name */
    public static final int f250322u = 10000;

    /* renamed from: v, reason: collision with root package name */
    public static final int f250323v = 100;

    /* renamed from: w, reason: collision with root package name */
    public static final int f250324w = 10;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f250325c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f250326d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f250327e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f250328f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f250329g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f250330h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f250331i;

    public l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f250325c = new AtomicInteger(a(f250311j, 10000));
        this.f250326d = new AtomicInteger(a(f250312k, 100));
        this.f250327e = new AtomicInteger(a(f250313l, 100));
        this.f250331i = new AtomicInteger(a(f250317p, 10));
        this.f250328f = new AtomicInteger(a(f250314m, 1));
        this.f250329g = new AtomicInteger(a(f250315n, 10000));
        this.f250330h = new AtomicInteger(a(f250316o, 100));
        QLog.d("MSFConfig", 1, toString());
    }

    @Override // com.tencent.mobileqq.msf.core.x.f
    public void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            QLog.d("MSFConfig", 1, "update MSFSampleRateConfig, config = " + str);
            JSONObject jSONObject = new JSONObject(str);
            a(str, jSONObject, this.f250325c, f250311j);
            a(str, jSONObject, this.f250326d, f250312k);
            a(str, jSONObject, this.f250327e, f250313l);
            a(str, jSONObject, this.f250328f, f250314m);
            a(str, jSONObject, this.f250329g, f250315n);
            a(str, jSONObject, this.f250330h, f250316o);
            a(str, jSONObject, this.f250331i, f250317p);
        } catch (Exception e16) {
            QLog.d("MSFConfig", 2, "update UdpConfigManager error, ", e16);
        }
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.f250326d.get();
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.f250327e.get();
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.f250330h.get();
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f250329g.get();
    }

    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.f250325c.get();
    }

    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f250328f.get();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return "MSFSampleRateConfig{releaseSamplingRate=" + this.f250325c + ", graySamplingRate=" + this.f250326d + ", importantCmdRate=" + this.f250327e + ", subConnSamplingRate=" + this.f250328f + ", nullQimeiReleaseSamplingRate=" + this.f250329g + ", nullQimeiGraySamplingRate=" + this.f250330h + ", grayImportantCmdRate=" + this.f250331i + '}';
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) ? this.f250331i.get() : ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
    }
}
