package com.tencent.mobileqq.msf.core.f0.c.e;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class l extends com.tencent.mobileqq.msf.core.x.f {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: k, reason: collision with root package name */
    public static final String f248255k = "SideWayHttpConfig_isOpen";

    /* renamed from: l, reason: collision with root package name */
    public static final String f248256l = "SideWayHttpConfig_quickRetryDelay";

    /* renamed from: m, reason: collision with root package name */
    public static final String f248257m = "SideWayHttpConfig_sendDelayTimeInXg";

    /* renamed from: n, reason: collision with root package name */
    public static final String f248258n = "SideWayHttpConfig_sendDelayTimeInWifi";

    /* renamed from: o, reason: collision with root package name */
    public static final String f248259o = "SideWayHttpConfig_resendIntervalTimeInXg";

    /* renamed from: p, reason: collision with root package name */
    public static final String f248260p = "SideWayHttpConfig_resendIntervalTimeInWifi";

    /* renamed from: q, reason: collision with root package name */
    public static final String f248261q = "SideWayHttpConfig_maxParallelCount";

    /* renamed from: r, reason: collision with root package name */
    public static final String f248262r = "SideWayHttpConfig_sidewayMode";

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    private final AtomicBoolean f248263c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248264d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248265e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248266f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248267g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248268h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248269i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248270j;

    public l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f248263c = new AtomicBoolean(a(f248255k, true));
        this.f248264d = new AtomicInteger(a(f248256l, 1));
        this.f248265e = new AtomicInteger(a(f248257m, 3));
        this.f248266f = new AtomicInteger(a(f248258n, 3));
        this.f248267g = new AtomicInteger(a(f248259o, 15));
        this.f248268h = new AtomicInteger(a(f248260p, 8));
        this.f248269i = new AtomicInteger(a(f248261q, 20));
        this.f248270j = new AtomicInteger(a(f248262r, 2));
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
            QLog.d("MSFConfig", 1, "update MSFCoreSideWayHttpConfig, config = " + str);
            JSONObject jSONObject = new JSONObject(str);
            a(str, jSONObject, this.f248263c, f248255k);
            a(str, jSONObject, this.f248264d, f248256l);
            a(str, jSONObject, this.f248265e, f248257m);
            a(str, jSONObject, this.f248266f, f248258n);
            a(str, jSONObject, this.f248267g, f248259o);
            a(str, jSONObject, this.f248268h, f248260p);
            a(str, jSONObject, this.f248269i, f248261q);
            a(str, jSONObject, this.f248270j, f248262r);
        } catch (Exception e16) {
            QLog.d("MSFConfig", 2, "update MSFCoreSideWayHttpConfig error, ", e16);
        }
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.f248269i.get();
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.f248264d.get();
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.f248268h.get();
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f248267g.get();
    }

    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f248266f.get();
    }

    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.f248265e.get();
    }

    public int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.f248270j.get();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return "MSFCoreSideWayHttpConfig{mIsOpen=" + this.f248263c + ", mQuickRetryDelay=" + this.f248264d + ", mSendDelayTimeInXg=" + this.f248265e + ", mSendDelayTimeInWiFi=" + this.f248266f + ", mResendIntervalTimeInXg=" + this.f248267g + ", mResendIntervalTimeInWiFi=" + this.f248268h + ", mMaxParallelCount=" + this.f248269i + ", mSidewayMode=" + this.f248270j + '}';
    }

    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this.f248263c.get() : ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
    }
}
