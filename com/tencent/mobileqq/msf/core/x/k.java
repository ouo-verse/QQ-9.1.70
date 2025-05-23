package com.tencent.mobileqq.msf.core.x;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class k extends f {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: k, reason: collision with root package name */
    private static final String f250287k = "default_enable_new_msf_probe";

    /* renamed from: l, reason: collision with root package name */
    private static final String f250288l = "enableNewMSFProbe";

    /* renamed from: m, reason: collision with root package name */
    private static final String f250289m = "enableWakeLock";

    /* renamed from: n, reason: collision with root package name */
    private static final String f250290n = "enableSendPing";

    /* renamed from: o, reason: collision with root package name */
    private static final String f250291o = "wakeLockTimeOnAlarm";

    /* renamed from: p, reason: collision with root package name */
    private static final String f250292p = "wakeLockTimeStartAlarm";

    /* renamed from: q, reason: collision with root package name */
    private static final String f250293q = "wakeLockTimeCancelAlarm";

    /* renamed from: r, reason: collision with root package name */
    private static final String f250294r = "msfPingAlarmInterval";

    /* renamed from: s, reason: collision with root package name */
    private static final String f250295s = "helloPingTimeout";

    /* renamed from: t, reason: collision with root package name */
    public static final boolean f250296t = true;

    /* renamed from: u, reason: collision with root package name */
    public static final boolean f250297u = false;

    /* renamed from: v, reason: collision with root package name */
    public static final int f250298v = 500;

    /* renamed from: w, reason: collision with root package name */
    public static final int f250299w = 500;

    /* renamed from: x, reason: collision with root package name */
    public static final int f250300x = 6000;

    /* renamed from: y, reason: collision with root package name */
    public static final int f250301y = 180000;

    /* renamed from: z, reason: collision with root package name */
    public static final int f250302z = 5000;

    /* renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f250303c;

    /* renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f250304d;

    /* renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f250305e;

    /* renamed from: f, reason: collision with root package name */
    private final AtomicInteger f250306f;

    /* renamed from: g, reason: collision with root package name */
    private final AtomicInteger f250307g;

    /* renamed from: h, reason: collision with root package name */
    private final AtomicInteger f250308h;

    /* renamed from: i, reason: collision with root package name */
    private final AtomicInteger f250309i;

    /* renamed from: j, reason: collision with root package name */
    private final AtomicInteger f250310j;

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        boolean z16 = !BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion();
        if (!BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion()) {
            SharedPreferences sharedPreferences = MsfService.getCore().getSharedPreferences("msf_config", 4);
            if (sharedPreferences.contains(f250287k)) {
                z16 = sharedPreferences.getBoolean(f250287k, true);
            } else {
                boolean nextBoolean = new Random().nextBoolean();
                sharedPreferences.edit().putBoolean(f250287k, nextBoolean).apply();
                z16 = nextBoolean;
            }
        }
        this.f250303c = new AtomicBoolean(a(f250288l, z16));
        this.f250304d = new AtomicBoolean(a(f250289m, true));
        this.f250305e = new AtomicBoolean(a(f250290n, false));
        this.f250306f = new AtomicInteger(a(f250291o, 6000));
        this.f250307g = new AtomicInteger(a(f250292p, 500));
        this.f250308h = new AtomicInteger(a(f250293q, 500));
        this.f250309i = new AtomicInteger(a(f250294r, 180000));
        this.f250310j = new AtomicInteger(a(f250295s, 5000));
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
            QLog.d("MSFConfig", 1, "update MSFProbeConfigManager config = " + str);
            JSONObject jSONObject = new JSONObject(str);
            a(str, jSONObject, this.f250303c, f250288l);
            a(str, jSONObject, this.f250304d, f250289m);
            a(str, jSONObject, this.f250305e, f250290n);
            a(str, jSONObject, this.f250306f, f250291o);
            a(str, jSONObject, this.f250307g, f250292p);
            a(str, jSONObject, this.f250308h, f250293q);
            a(str, jSONObject, this.f250309i, f250294r);
            a(str, jSONObject, this.f250310j, f250295s);
        } catch (Exception e16) {
            QLog.d("MSFConfig", 1, "MSFProbeConfigManager onUpdateConfig error, ", e16);
        }
    }

    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.f250303c.get();
    }

    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.f250305e.get();
    }

    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.f250304d.get();
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.f250308h.get();
    }

    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f250306f.get();
    }

    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f250307g.get();
    }

    public int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.f250309i.get();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return "MSFProbeConfigManager{mEnableNewMSFProbe=" + this.f250303c + ", mEnableWakeLock=" + this.f250304d + ", mEnableSendPing=" + this.f250305e + ", mLockTimeOnAlarm=" + this.f250306f + ", mLockTimeStartAlarm=" + this.f250307g + ", mLockTimeCancelAlarm=" + this.f250308h + ", mMSFPingAlarmInterval=" + this.f250309i + ", mHelloPingTimeout=" + this.f250310j + '}';
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) ? this.f250310j.get() : ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
    }
}
