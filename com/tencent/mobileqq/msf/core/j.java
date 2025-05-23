package com.tencent.mobileqq.msf.core;

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

    /* renamed from: g, reason: collision with root package name */
    private static final String f248577g = "isIPCDivideToTransportEnable";

    /* renamed from: h, reason: collision with root package name */
    private static final String f248578h = "isSleepThreadWhenIPCBlockEnable";

    /* renamed from: i, reason: collision with root package name */
    private static final String f248579i = "isBinderConnectOptEnable";

    /* renamed from: j, reason: collision with root package name */
    private static final String f248580j = "deepSleepDetectInterval";

    /* renamed from: k, reason: collision with root package name */
    public static final boolean f248581k = false;

    /* renamed from: l, reason: collision with root package name */
    public static final boolean f248582l = false;

    /* renamed from: m, reason: collision with root package name */
    public static final boolean f248583m = false;

    /* renamed from: n, reason: collision with root package name */
    public static final int f248584n = 60;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    private final AtomicBoolean f248585c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final AtomicBoolean f248586d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    private final AtomicBoolean f248587e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    private final AtomicInteger f248588f;

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f248585c = new AtomicBoolean(a(f248577g, false));
        this.f248586d = new AtomicBoolean(a(f248578h, false));
        this.f248587e = new AtomicBoolean(a(f248579i, false));
        this.f248588f = new AtomicInteger(a(f248580j, 60));
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
            QLog.d("MSFConfig", 1, "update MSFConfigManager config = " + str);
            JSONObject jSONObject = new JSONObject(str);
            a(str, jSONObject, this.f248587e, f248579i);
            a(str, jSONObject, this.f248585c, f248577g);
            a(str, jSONObject, this.f248586d, f248578h);
            a(str, jSONObject, this.f248588f, f248580j);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("MSFConfig", 2, "updateManagerConfig throw e", e16);
            }
        }
    }

    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.f248586d.get();
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f248588f.get();
    }

    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() && !this.f248587e.get()) {
            return false;
        }
        return true;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "MSFConfigManager{isIPCDivideToTransportEnable=" + this.f248585c + ", isSleepThreadWhenIPCBlockEnable=" + this.f248586d + ", isBinderConnectOptEnable=" + this.f248587e + ", deepSleepDetectInterval=" + this.f248588f + '}';
    }

    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this.f248585c.get() : ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
    }
}
