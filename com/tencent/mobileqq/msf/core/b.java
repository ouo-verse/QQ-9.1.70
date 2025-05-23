package com.tencent.mobileqq.msf.core;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: b, reason: collision with root package name */
    private static final String f247511b = "ComplexConnectConfigManager";

    /* renamed from: c, reason: collision with root package name */
    public static final String f247512c = "complex_connect_config_sp_name";

    /* renamed from: d, reason: collision with root package name */
    public static final String f247513d = "config_all";

    /* renamed from: e, reason: collision with root package name */
    public static final String f247514e = "isComplexConnectEnable";

    /* renamed from: f, reason: collision with root package name */
    public static final String f247515f = "complexConnectSwitchInnerVersion";

    /* renamed from: g, reason: collision with root package name */
    public static final String f247516g = "connectInterval";

    /* renamed from: h, reason: collision with root package name */
    public static final String f247517h = "maxConnecting";

    /* renamed from: i, reason: collision with root package name */
    public static final String f247518i = "maxLoopTime";

    /* renamed from: j, reason: collision with root package name */
    public static final String f247519j = "maxLoopTimeoutCount";

    /* renamed from: k, reason: collision with root package name */
    public static final String f247520k = "maxErrorCount";

    /* renamed from: l, reason: collision with root package name */
    public static final boolean f247521l = true;

    /* renamed from: m, reason: collision with root package name */
    public static final int f247522m = 3000;

    /* renamed from: n, reason: collision with root package name */
    public static final int f247523n = 5;

    /* renamed from: o, reason: collision with root package name */
    public static final int f247524o = 40000;

    /* renamed from: p, reason: collision with root package name */
    public static final int f247525p = 5;

    /* renamed from: q, reason: collision with root package name */
    public static final int f247526q = 5;

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, String> f247527a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.msf.core.b$b, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C8072b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final b f247528a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22846);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f247528a = new b(null);
            }
        }

        C8072b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* synthetic */ b(a aVar) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
    }

    public static b f() {
        return C8072b.f247528a;
    }

    public void a(@NonNull ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) toServiceMsg);
            return;
        }
        Object obj = toServiceMsg.getAttributes().get(BaseConstants.KEY_COMPLEX_CONNECT_CONFIG_ALL);
        if (obj instanceof String) {
            String str = (String) obj;
            this.f247527a.putAll(MsfSdkUtils.convertJsonToMap(str));
            MsfService.getCore().getSharedPreferences(f247512c, 0).edit().putString(f247513d, str).apply();
            QLog.d(f247511b, 1, "[onUpdate], ComplexConnectConfig: " + str);
        }
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        try {
            if (this.f247527a.containsKey(f247517h)) {
                String str = this.f247527a.get(f247517h);
                Objects.requireNonNull(str);
                return Integer.parseInt(str);
            }
            return 5;
        } catch (Exception e16) {
            QLog.d(f247511b, 1, "getMaxConnecting error", e16);
            return 5;
        }
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        try {
            if (this.f247527a.containsKey(f247520k)) {
                String str = this.f247527a.get(f247520k);
                Objects.requireNonNull(str);
                return Integer.parseInt(str);
            }
            return 5;
        } catch (Exception e16) {
            QLog.d(f247511b, 1, "getMaxErrorCount error", e16);
            return 5;
        }
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        try {
            if (this.f247527a.containsKey(f247518i)) {
                String str = this.f247527a.get(f247518i);
                Objects.requireNonNull(str);
                return Integer.parseInt(str);
            }
            return 40000;
        } catch (Exception e16) {
            QLog.d(f247511b, 1, "getMaxLoopTime error", e16);
            return 40000;
        }
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        try {
            if (this.f247527a.containsKey(f247519j)) {
                String str = this.f247527a.get(f247519j);
                Objects.requireNonNull(str);
                return Integer.parseInt(str);
            }
            return 5;
        } catch (Exception e16) {
            QLog.d(f247511b, 1, "getMaxLoopTimeOutCount error", e16);
            return 5;
        }
    }

    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        try {
            if (this.f247527a.containsKey(f247514e)) {
                String str = this.f247527a.get(f247514e);
                Objects.requireNonNull(str);
                return Boolean.parseBoolean(str);
            }
        } catch (Exception e16) {
            QLog.d(f247511b, 1, "isComplexConnectEnable error", e16);
        }
        return true;
    }

    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        try {
            if (this.f247527a.containsKey(f247515f)) {
                String str = this.f247527a.get(f247515f);
                Objects.requireNonNull(str);
                return Boolean.parseBoolean(str);
            }
        } catch (Exception e16) {
            QLog.d(f247511b, 1, "isComplexConnectEnableForInner error", e16);
        }
        return true;
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        this.f247527a = concurrentHashMap;
        String string = MsfService.getCore().getSharedPreferences(f247512c, 0).getString(f247513d, "");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        concurrentHashMap.putAll(MsfSdkUtils.convertJsonToMap(string));
        QLog.d(f247511b, 1, "[init], ComplexConnectConfig: " + string);
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        try {
            if (!this.f247527a.containsKey(f247516g)) {
                return 3000;
            }
            String str = this.f247527a.get(f247516g);
            Objects.requireNonNull(str);
            return Integer.parseInt(str);
        } catch (Exception e16) {
            QLog.d(f247511b, 1, "getConnectInterval error", e16);
            return 3000;
        }
    }
}
