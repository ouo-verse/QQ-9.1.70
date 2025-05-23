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
public class e extends com.tencent.mobileqq.msf.core.x.f {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: i, reason: collision with root package name */
    public static final String f248182i = "MultiTcpConfig_isOpen";

    /* renamed from: j, reason: collision with root package name */
    public static final String f248183j = "MultiTcpConfig_sendDelayTimeInXg";

    /* renamed from: k, reason: collision with root package name */
    public static final String f248184k = "MultiTcpConfig_sendDelayTimeInWifi";

    /* renamed from: l, reason: collision with root package name */
    public static final String f248185l = "MultiTcpConfig_resendIntervalTimeInXg";

    /* renamed from: m, reason: collision with root package name */
    public static final String f248186m = "MultiTcpConfig_resendIntervalTimeInWifi";

    /* renamed from: n, reason: collision with root package name */
    public static final String f248187n = "MultiTcpConfig_sidewayMode";

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    private final AtomicBoolean f248188c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248189d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248190e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248191f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248192g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248193h;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f248188c = new AtomicBoolean(a(f248182i, true));
        this.f248189d = new AtomicInteger(a(f248183j, 3));
        this.f248190e = new AtomicInteger(a(f248184k, 3));
        this.f248191f = new AtomicInteger(a(f248185l, 15));
        this.f248192g = new AtomicInteger(a(f248186m, 8));
        this.f248193h = new AtomicInteger(a(f248187n, 2));
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
            QLog.d("MSFConfig", 1, "update MSFCoreMultiTcpConfig, config = " + str);
            JSONObject jSONObject = new JSONObject(str);
            a(str, jSONObject, this.f248188c, f248182i);
            a(str, jSONObject, this.f248189d, f248183j);
            a(str, jSONObject, this.f248190e, f248184k);
            a(str, jSONObject, this.f248191f, f248185l);
            a(str, jSONObject, this.f248192g, f248186m);
            a(str, jSONObject, this.f248193h, f248187n);
        } catch (Exception e16) {
            QLog.d("MSFConfig", 2, "update MSFCoreMultiTcpConfig error, ", e16);
        }
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f248192g.get();
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f248191f.get();
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.f248190e.get();
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.f248189d.get();
    }

    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.f248193h.get();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "MSFCoreMultiTcpConfig{mIsOpen=" + this.f248188c + ", mSendDelayTimeInXg=" + this.f248189d + ", mSendDelayTimeInWiFi=" + this.f248190e + ", mResendIntervalTimeInXg=" + this.f248191f + ", mResendIntervalTimeInWiFi=" + this.f248192g + ", mSidewayMode=" + this.f248193h + '}';
    }

    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this.f248188c.get() : ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
    }
}
