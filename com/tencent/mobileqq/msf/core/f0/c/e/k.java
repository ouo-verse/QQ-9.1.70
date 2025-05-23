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
public class k extends com.tencent.mobileqq.msf.core.x.f {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: e, reason: collision with root package name */
    public static final String f248251e = "MSFSSIDConfig_isOpen";

    /* renamed from: f, reason: collision with root package name */
    public static final String f248252f = "MSFSSIDConfig_historySSIDValidity";

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    private final AtomicBoolean f248253c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248254d;

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f248253c = new AtomicBoolean(a(f248251e, false));
        this.f248254d = new AtomicInteger(a(f248252f, 3));
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
            QLog.d("MSFConfig", 1, "update MSFCoreSSIDConfig, config = " + str);
            JSONObject jSONObject = new JSONObject(str);
            a(str, jSONObject, this.f248253c, f248251e);
            a(str, jSONObject, this.f248254d, f248252f);
        } catch (Exception e16) {
            QLog.d("MSFConfig", 2, "update MSFCoreSSIDConfig error, ", e16);
        }
    }

    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.f248253c.get();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "MSFCoreSSIDConfig{mIsOpen=" + this.f248253c + ", mHistorySSIDValidity=" + this.f248254d + '}';
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? this.f248254d.get() : ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
    }
}
