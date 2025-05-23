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
public class i extends com.tencent.mobileqq.msf.core.x.f {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: h, reason: collision with root package name */
    public static final String f248225h = "PkgStatisticsConfig_isOpen";

    /* renamed from: i, reason: collision with root package name */
    public static final String f248226i = "PkgStatisticsConfig_tooLongConnTime";

    /* renamed from: j, reason: collision with root package name */
    public static final String f248227j = "PkgStatisticsConfig_RTTUpBound";

    /* renamed from: k, reason: collision with root package name */
    public static final String f248228k = "PkgStatisticsConfig_RTTLowBound";

    /* renamed from: l, reason: collision with root package name */
    public static final String f248229l = "PkgStatisticsConfig_thresholdForHeartBeatRtt";

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    private final AtomicBoolean f248230c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248231d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248232e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248233f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248234g;

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f248230c = new AtomicBoolean(a(f248225h, true));
        this.f248231d = new AtomicInteger(a(f248226i, 1500));
        this.f248232e = new AtomicInteger(a(f248227j, 1500));
        this.f248233f = new AtomicInteger(a(f248228k, 500));
        this.f248234g = new AtomicInteger(a(f248229l, 1000));
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
            QLog.d("MSFConfig", 1, "update MSFCorePkgStatisticsConfig, config = " + str);
            JSONObject jSONObject = new JSONObject(str);
            a(str, jSONObject, this.f248230c, f248225h);
            a(str, jSONObject, this.f248231d, f248226i);
            a(str, jSONObject, this.f248232e, f248227j);
            a(str, jSONObject, this.f248233f, f248228k);
            a(str, jSONObject, this.f248234g, f248229l);
        } catch (Exception e16) {
            QLog.d("MSFConfig", 2, "update MSFCorePkgStatisticsConfig error, ", e16);
        }
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f248233f.get();
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.f248232e.get();
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f248234g.get();
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.f248231d.get();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return "MSFCorePkgStatisticsConfig{mIsOpen=" + this.f248230c + ", mTooLongConnTime=" + this.f248231d + ", mRTTUpBound=" + this.f248232e + ", mRTTLowBound=" + this.f248233f + ", mThresholdForHeartBeatRtt=" + this.f248234g + '}';
    }

    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this.f248230c.get() : ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
    }
}
