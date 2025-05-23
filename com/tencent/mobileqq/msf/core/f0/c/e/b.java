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
public class b extends com.tencent.mobileqq.msf.core.x.f {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: m, reason: collision with root package name */
    public static final String f248130m = "MSFDualEngineConfig_mainConnType";

    /* renamed from: n, reason: collision with root package name */
    public static final String f248131n = "MSFDualEngineConfig_sidewayConnType";

    /* renamed from: o, reason: collision with root package name */
    public static final String f248132o = "MSFDualEngineConfig_sidewayConnLimit";

    /* renamed from: p, reason: collision with root package name */
    public static final String f248133p = "MSFDualEngineConfig_isEnableHearbeatOpt";

    /* renamed from: q, reason: collision with root package name */
    public static final String f248134q = "MSFDualEngineConfig_checkPingTimeout";

    /* renamed from: r, reason: collision with root package name */
    public static final String f248135r = "MSFDualEngineConfig_activeCheckPingInterval";

    /* renamed from: s, reason: collision with root package name */
    public static final String f248136s = "MSFDualEngineConfig_backgroundCheckPingInterval";

    /* renamed from: t, reason: collision with root package name */
    public static final String f248137t = "MSFDualEngineConfig_enableDynamicSideConnPool";

    /* renamed from: u, reason: collision with root package name */
    public static final String f248138u = "MSFDualEngineConfig_enableHandshakePersist";

    /* renamed from: v, reason: collision with root package name */
    public static final String f248139v = "MSFDualEngineConfig_enable0RTTPing";

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248140c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248141d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248142e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    private final AtomicBoolean f248143f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248144g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248145h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248146i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    private final AtomicBoolean f248147j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    private final AtomicBoolean f248148k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    private final AtomicBoolean f248149l;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f248140c = new AtomicInteger(a(f248130m, 1));
        this.f248141d = new AtomicInteger(a(f248131n, 5));
        this.f248142e = new AtomicInteger(a(f248132o, 1));
        this.f248143f = new AtomicBoolean(a(f248133p, true));
        this.f248144g = new AtomicInteger(a(f248134q, 15));
        this.f248145h = new AtomicInteger(a(f248135r, 45));
        this.f248146i = new AtomicInteger(a(f248136s, 300));
        this.f248147j = new AtomicBoolean(a(f248137t, true));
        this.f248148k = new AtomicBoolean(a(f248138u, false));
        this.f248149l = new AtomicBoolean(a(f248139v, false));
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
            QLog.d("MSFConfig", 1, "update MSFCoreDualEngineConfig, config = " + str);
            JSONObject jSONObject = new JSONObject(str);
            a(str, jSONObject, this.f248140c, f248130m);
            a(str, jSONObject, this.f248141d, f248131n);
            a(str, jSONObject, this.f248142e, f248132o);
            a(str, jSONObject, this.f248143f, f248133p);
            a(str, jSONObject, this.f248144g, f248134q);
            a(str, jSONObject, this.f248145h, f248135r);
            a(str, jSONObject, this.f248146i, f248136s);
            a(str, jSONObject, this.f248147j, f248137t);
            a(str, jSONObject, this.f248148k, f248138u);
            a(str, jSONObject, this.f248149l, f248139v);
        } catch (Exception e16) {
            QLog.d("MSFConfig", 1, "update MSFCoreDualEngineConfig error, ", e16);
        }
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.f248146i.get();
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f248144g.get();
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.f248140c.get();
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.f248142e.get();
    }

    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.f248141d.get();
    }

    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.f248149l.get();
    }

    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.f248147j.get();
    }

    public boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.f248148k.get();
    }

    public boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.f248143f.get();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return "MSFCoreDualEngineConfig{mainConnType=" + this.f248140c + ",sideWayConnType=" + this.f248141d + ",sideWayConnLimit=" + this.f248142e + ",isEnableHeartbeatOpt=" + this.f248143f + ",checkPingTimeout=" + this.f248144g + ",activeCheckPingInterval=" + this.f248145h + ",backgroundCheckPingInterval=" + this.f248146i + ",enableDynamicSideWayConnPool=" + this.f248147j + ",enableHandshakePersist=" + this.f248148k + ",enable0RTTPing=" + this.f248149l + "}";
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? this.f248145h.get() : ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
    }
}
