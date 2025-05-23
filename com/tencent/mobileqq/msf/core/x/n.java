package com.tencent.mobileqq.msf.core.x;

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
public class n extends f {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: f, reason: collision with root package name */
    private static final String f250355f = "udpSendSwitchOn";

    /* renamed from: g, reason: collision with root package name */
    private static final String f250356g = "udpMaxRetryCount";

    /* renamed from: h, reason: collision with root package name */
    private static final String f250357h = "udpSendTimeout";

    /* renamed from: i, reason: collision with root package name */
    public static final boolean f250358i = false;

    /* renamed from: j, reason: collision with root package name */
    public static final int f250359j = 12;

    /* renamed from: k, reason: collision with root package name */
    public static final int f250360k = 5;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    private final AtomicBoolean f250361c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f250362d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f250363e;

    public n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f250361c = new AtomicBoolean(a(f250355f, false));
        this.f250362d = new AtomicInteger(a(f250356g, 12));
        this.f250363e = new AtomicInteger(a(f250357h, 5));
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
            QLog.d("MSFConfig", 1, "update UdpConfigManager, config = " + str);
            JSONObject jSONObject = new JSONObject(str);
            a(str, jSONObject, this.f250361c, f250355f);
            a(str, jSONObject, this.f250362d, f250356g);
            a(str, jSONObject, this.f250363e, f250357h);
        } catch (Exception e16) {
            QLog.d("MSFConfig", 2, "update UdpConfigManager error, ", e16);
        }
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.f250363e.get();
    }

    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() && !this.f250361c.get()) {
            return false;
        }
        return true;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "MSFUdpConfigManager{udpSendSwitchOn=" + this.f250361c + ", udpMaxRetryCount=" + this.f250362d + ", udpSendTimeout=" + this.f250363e + '}';
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this.f250362d.get() : ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
    }
}
