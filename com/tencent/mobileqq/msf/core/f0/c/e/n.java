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
public class n extends com.tencent.mobileqq.msf.core.x.f {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: l, reason: collision with root package name */
    public static final String f248283l = "TcpEngineConfig_serialConnNum";

    /* renamed from: m, reason: collision with root package name */
    public static final String f248284m = "TcpEngineConfig_parallelConnNum";

    /* renamed from: n, reason: collision with root package name */
    public static final String f248285n = "TcpEngineConfig_parallelConnInterval";

    /* renamed from: o, reason: collision with root package name */
    public static final String f248286o = "TcpEngineConfig_connMode";

    /* renamed from: p, reason: collision with root package name */
    public static final String f248287p = "TcpEngineConfig_sideWayConnLimit";

    /* renamed from: q, reason: collision with root package name */
    public static final String f248288q = "TcpEngineConfig_enableHeartbeatOpt";

    /* renamed from: r, reason: collision with root package name */
    public static final String f248289r = "TcpEngineConfig_checkPingTimeout";

    /* renamed from: s, reason: collision with root package name */
    public static final String f248290s = "TcpEngineConfig_activeCheckPingInterval";

    /* renamed from: t, reason: collision with root package name */
    public static final String f248291t = "TcpEngineConfig_backgroundCheckPingInterval";

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248292c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248293d;

    /* renamed from: e, reason: collision with root package name */
    double f248294e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248295f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248296g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    private final AtomicBoolean f248297h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248298i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248299j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248300k;

    public n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f248292c = new AtomicInteger(a(f248283l, 3));
        this.f248293d = new AtomicInteger(a(f248284m, 3));
        this.f248294e = a(f248285n, 3000.0d);
        this.f248295f = new AtomicInteger(a(f248286o, 1));
        this.f248296g = new AtomicInteger(a(f248287p, 0));
        this.f248297h = new AtomicBoolean(a(f248288q, false));
        this.f248298i = new AtomicInteger(a(f248289r, 15));
        this.f248299j = new AtomicInteger(a(f248290s, 45));
        this.f248300k = new AtomicInteger(a(f248291t, 300));
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
            QLog.d("MSFConfig", 1, "update MSFCoreTcpEngineConfig, config = " + str);
            JSONObject jSONObject = new JSONObject(str);
            a(str, jSONObject, this.f248292c, f248283l);
            a(str, jSONObject, this.f248293d, f248284m);
            this.f248294e = a(str, jSONObject, f248285n, this.f248294e);
            a(str, jSONObject, this.f248295f, f248286o);
            a(str, jSONObject, this.f248296g, f248287p);
            a(str, jSONObject, this.f248297h, f248288q);
            a(str, jSONObject, this.f248298i, f248289r);
            a(str, jSONObject, this.f248299j, f248290s);
            a(str, jSONObject, this.f248300k, f248291t);
        } catch (Exception e16) {
            QLog.d("MSFConfig", 2, "update MSFCoreTcpEngineConfig error, ", e16);
        }
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.f248300k.get();
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.f248298i.get();
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f248295f.get();
    }

    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.f248297h.get();
    }

    public double f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Double) iPatchRedirector.redirect((short) 5, (Object) this)).doubleValue();
        }
        return this.f248294e;
    }

    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.f248293d.get();
    }

    public int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.f248292c.get();
    }

    public int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f248296g.get();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return "MSFCoreTcpEngineConfig{mSerialConnNum=" + this.f248292c + ",mParallelConnNum=" + this.f248293d + ",mParallelConnInterval=" + this.f248294e + ",mConnMode=" + this.f248295f + ",mSideWayConnLimit=" + this.f248296g + ",mEnableHeartbeatOpt=" + this.f248297h + ",mCheckPingTimeout=" + this.f248298i + ",mActiveCheckPingInterval=" + this.f248299j + ",mBackgroundCheckPingInterval=" + this.f248300k + "}";
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) ? this.f248299j.get() : ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
    }
}
