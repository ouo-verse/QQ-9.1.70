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
public class d extends com.tencent.mobileqq.msf.core.x.f {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: g, reason: collision with root package name */
    public static final String f248170g = "MSFCoreMonitor_enableKillMsf";

    /* renamed from: h, reason: collision with root package name */
    public static final String f248171h = "MSFCoreMonitor_MaxResponseInterval";

    /* renamed from: i, reason: collision with root package name */
    public static final String f248172i = "MSFCoreMonitor_MaxIntervalBetweenSendAndResponse";

    /* renamed from: j, reason: collision with root package name */
    public static final String f248173j = "MSFCoreMonitor_MaxCountNoConnectWithNetSupport";

    /* renamed from: k, reason: collision with root package name */
    public static final boolean f248174k = false;

    /* renamed from: l, reason: collision with root package name */
    public static final int f248175l = 60000;

    /* renamed from: m, reason: collision with root package name */
    public static final int f248176m = 60000;

    /* renamed from: n, reason: collision with root package name */
    public static final int f248177n = 30;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    private final AtomicBoolean f248178c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248179d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248180e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248181f;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f248178c = new AtomicBoolean(a(f248170g, false));
        this.f248179d = new AtomicInteger(a(f248171h, 60000));
        this.f248180e = new AtomicInteger(a(f248172i, 60000));
        this.f248181f = new AtomicInteger(a(f248173j, 30));
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
            QLog.d("MSFConfig", 1, "update MSFCoreMonitorConfig, config = " + str);
            JSONObject jSONObject = new JSONObject(str);
            a(str, jSONObject, this.f248178c, f248170g);
            a(str, jSONObject, this.f248179d, f248171h);
            a(str, jSONObject, this.f248180e, f248172i);
            a(str, jSONObject, this.f248181f, f248173j);
        } catch (Exception e16) {
            QLog.d("MSFConfig", 2, "update MSFCoreMonitorConfig error, ", e16);
        }
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.f248180e.get();
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.f248179d.get();
    }

    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.f248178c.get();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "MSFCoreMonitorConfig{mEnableKillMSF=" + this.f248178c + ", mMaxResponseInterval=" + this.f248179d + ", mMaxIntervalBetweenSendAndResponse=" + this.f248180e + ", mMaxCountNoConnectWithNetSupport=" + this.f248181f + '}';
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? this.f248181f.get() : ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
    }
}
