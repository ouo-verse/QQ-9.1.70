package com.tencent.mobileqq.msf.core.f0.c.e;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class j extends com.tencent.mobileqq.msf.core.x.f {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: k, reason: collision with root package name */
    public static final String f248235k = "QuicEngineConfig_parallelConnNum";

    /* renamed from: l, reason: collision with root package name */
    public static final String f248236l = "QuicEngineConfig_parallelConnInterval";

    /* renamed from: m, reason: collision with root package name */
    public static final String f248237m = "QuicEngineConfig_sideWayConnLimit";

    /* renamed from: n, reason: collision with root package name */
    public static final String f248238n = "QuicEngineConfig_enableHeartbeatOpt";

    /* renamed from: o, reason: collision with root package name */
    public static final String f248239o = "QuicEngineConfig_checkPingTimeout";

    /* renamed from: p, reason: collision with root package name */
    public static final String f248240p = "QuicEngineConfig_activeCheckPingInterval";

    /* renamed from: q, reason: collision with root package name */
    public static final String f248241q = "QuicEngineConfig_backgroundCheckPingInterval";

    /* renamed from: r, reason: collision with root package name */
    public static final String f248242r = "QuicEngineConfig_enableHandshakePersist";

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248243c;

    /* renamed from: d, reason: collision with root package name */
    double f248244d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248245e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    private final AtomicBoolean f248246f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248247g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248248h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248249i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    private final AtomicBoolean f248250j;

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f248243c = new AtomicInteger(a(f248235k, 3));
        this.f248244d = a(f248236l, 3000.0d);
        this.f248245e = new AtomicInteger(a(f248237m, 0));
        this.f248246f = new AtomicBoolean(a(f248238n, true));
        this.f248247g = new AtomicInteger(a(f248239o, 15));
        this.f248248h = new AtomicInteger(a(f248240p, 45));
        this.f248249i = new AtomicInteger(a(f248241q, 300));
        this.f248250j = new AtomicBoolean(a(f248242r, !BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion()));
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
            QLog.d("MSFConfig", 1, "update MSFCoreQuicEngineConfig, config = " + str);
            JSONObject jSONObject = new JSONObject(str);
            a(str, jSONObject, this.f248243c, f248235k);
            this.f248244d = a(str, jSONObject, f248236l, this.f248244d);
            a(str, jSONObject, this.f248245e, f248237m);
            a(str, jSONObject, this.f248246f, f248238n);
            a(str, jSONObject, this.f248247g, f248239o);
            a(str, jSONObject, this.f248248h, f248240p);
            a(str, jSONObject, this.f248249i, f248241q);
            a(str, jSONObject, this.f248250j, f248242r);
        } catch (Exception e16) {
            QLog.d("MSFConfig", 2, "update MSFCoreQuicEngineConfig error, ", e16);
        }
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.f248249i.get();
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f248247g.get();
    }

    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.f248250j.get();
    }

    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.f248246f.get();
    }

    public double f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Double) iPatchRedirector.redirect((short) 4, (Object) this)).doubleValue();
        }
        return this.f248244d;
    }

    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.f248243c.get();
    }

    public int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.f248245e.get();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return "MSFCoreQuicEngineConfig{mParallelConnNum=" + this.f248243c + ",mParallelConnInterval=" + this.f248244d + ",mSideWayConnLimit=" + this.f248245e + ",mEnableHeartbeatOpt=" + this.f248246f + ",mCheckPingTimeout=" + this.f248247g + ",mActiveCheckPingInterval=" + this.f248248h + ",mBackgroundCheckPingInterval=" + this.f248249i + ",mEnableHandshakePersist=" + this.f248250j + "}";
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? this.f248248h.get() : ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
    }
}
