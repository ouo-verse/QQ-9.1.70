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
public class m extends com.tencent.mobileqq.msf.core.x.f {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: i, reason: collision with root package name */
    public static final String f248271i = "SideWayUdpConfig_isOpen";

    /* renamed from: j, reason: collision with root package name */
    public static final String f248272j = "SideWayUdpConfig_sendDelayTimeInXg";

    /* renamed from: k, reason: collision with root package name */
    public static final String f248273k = "SideWayUdpConfig_sendDelayTimeInWifi";

    /* renamed from: l, reason: collision with root package name */
    public static final String f248274l = "SideWayUdpConfig_resendIntervalTimeInXg";

    /* renamed from: m, reason: collision with root package name */
    public static final String f248275m = "SideWayUdpConfig_resendIntervalTimeInWifi";

    /* renamed from: n, reason: collision with root package name */
    public static final String f248276n = "SideWayUdpConfig_sidewayMode";

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    private final AtomicBoolean f248277c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248278d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248279e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248280f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248281g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248282h;

    public m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f248277c = new AtomicBoolean(a(f248271i, true));
        this.f248278d = new AtomicInteger(a(f248272j, 3));
        this.f248279e = new AtomicInteger(a(f248273k, 3));
        this.f248280f = new AtomicInteger(a(f248274l, 15));
        this.f248281g = new AtomicInteger(a(f248275m, 8));
        this.f248282h = new AtomicInteger(a(f248276n, 2));
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
            QLog.d("MSFConfig", 1, "update MSFCoreSideWayUdpConfig, config = " + str);
            JSONObject jSONObject = new JSONObject(str);
            a(str, jSONObject, this.f248277c, f248271i);
            a(str, jSONObject, this.f248278d, f248272j);
            a(str, jSONObject, this.f248279e, f248273k);
            a(str, jSONObject, this.f248280f, f248274l);
            a(str, jSONObject, this.f248281g, f248275m);
            a(str, jSONObject, this.f248282h, f248276n);
        } catch (Exception e16) {
            QLog.d("MSFConfig", 2, "update MSFCoreSideWayUdpConfig error, ", e16);
        }
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f248281g.get();
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f248280f.get();
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.f248279e.get();
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.f248278d.get();
    }

    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.f248282h.get();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "MSFCoreSideWayUdpConfig{mIsOpen=" + this.f248277c + ", mSendDelayTimeInXg=" + this.f248278d + ", mSendDelayTimeInWiFi=" + this.f248279e + ", mResendIntervalTimeInXg=" + this.f248280f + ", mResendIntervalTimeInWiFi=" + this.f248281g + ", mSidewayMode=" + this.f248282h + '}';
    }

    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this.f248277c.get() : ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
    }
}
