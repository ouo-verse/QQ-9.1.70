package com.tencent.mobileqq.msf.core.x;

import android.support.annotation.NonNull;
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
public class e {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: b, reason: collision with root package name */
    public static final String f250230b = "MSFCommonConfigManager";

    /* renamed from: c, reason: collision with root package name */
    public static final String f250231c = "msf_activePreDetect";

    /* renamed from: d, reason: collision with root package name */
    public static final String f250232d = "msf_preDetectTimeout";

    /* renamed from: e, reason: collision with root package name */
    public static final String f250233e = "msf_heartBeatRetrycount";

    /* renamed from: f, reason: collision with root package name */
    public static final String f250234f = "msf_heartBeatTimeout";

    /* renamed from: g, reason: collision with root package name */
    public static final String f250235g = "msf_heartBeatSwitch";

    /* renamed from: h, reason: collision with root package name */
    public static final String f250236h = "msf_heartBeatTimeInterval";

    /* renamed from: i, reason: collision with root package name */
    public static final String f250237i = "msf_heartBeatWaitTimeInterval";

    /* renamed from: j, reason: collision with root package name */
    public static final String f250238j = "msf_quickHeartBeatTimeout";

    /* renamed from: k, reason: collision with root package name */
    public static final String f250239k = "msf_getQuickHeartBeatReConnInterval";

    /* renamed from: l, reason: collision with root package name */
    public static final String f250240l = "msf_quickHeartBeatSwitch";

    /* renamed from: m, reason: collision with root package name */
    public static final String f250241m = "msf_preHeartBeatTimeInterval";

    /* renamed from: n, reason: collision with root package name */
    public static final String f250242n = "msf_forceQuickSend1S";

    /* renamed from: o, reason: collision with root package name */
    public static final String f250243o = "msf_quickSendFastTimes";

    /* renamed from: p, reason: collision with root package name */
    public static final String f250244p = "msf_quickSendFastInterval";

    /* renamed from: q, reason: collision with root package name */
    private static final String f250245q = "msf_common_config";

    /* renamed from: a, reason: collision with root package name */
    final ConcurrentHashMap<String, String> f250246a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final e f250247a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11483);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f250247a = new e(null);
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* synthetic */ e(a aVar) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
    }

    public static e o() {
        return b.f250247a;
    }

    public void a(@NonNull ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) toServiceMsg);
            return;
        }
        Object obj = toServiceMsg.getAttributes().get(BaseConstants.KEY_MSF_COMMON_CONFIG_STRING);
        if (obj instanceof String) {
            String str = (String) obj;
            this.f250246a.putAll(MsfSdkUtils.convertJsonToMap(str));
            MsfService.getCore().getSharedPreferences(f250245q, 0).edit().putString(BaseConstants.KEY_MSF_COMMON_CONFIG_STRING, str).apply();
            QLog.d(f250230b, 1, "[onUpdateConfig], config: " + str);
        }
    }

    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        try {
            if (this.f250246a.containsKey(f250242n)) {
                String str = this.f250246a.get(f250242n);
                Objects.requireNonNull(str);
                return Boolean.parseBoolean(str);
            }
        } catch (Exception e16) {
            QLog.e(f250230b, 1, "getForceQuickSend1S error", e16);
        }
        return true;
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        try {
            if (this.f250246a.containsKey(f250233e)) {
                String str = this.f250246a.get(f250233e);
                Objects.requireNonNull(str);
                return Integer.parseInt(str);
            }
        } catch (Exception e16) {
            QLog.e(f250230b, 1, "getHeartBeatRetryCount error", e16);
        }
        return 1;
    }

    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        try {
            if (this.f250246a.containsKey(f250235g)) {
                String str = this.f250246a.get(f250235g);
                Objects.requireNonNull(str);
                return Boolean.parseBoolean(str);
            }
        } catch (Exception e16) {
            QLog.e(f250230b, 1, "getHeartBeatSwitch error", e16);
        }
        return true;
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        try {
            if (this.f250246a.containsKey(f250236h)) {
                String str = this.f250246a.get(f250236h);
                Objects.requireNonNull(str);
                return Integer.parseInt(str);
            }
            return 60000;
        } catch (Exception e16) {
            QLog.e(f250230b, 1, "getHeartBeatTimeInterval error", e16);
            return 60000;
        }
    }

    public long f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
        }
        if (!a()) {
            try {
                if (this.f250246a.containsKey(f250234f)) {
                    Objects.requireNonNull(this.f250246a.get(f250234f));
                    return Integer.parseInt(r0);
                }
                return 30000L;
            } catch (Exception e16) {
                QLog.d(f250230b, 1, "getHeartBeatTimeout error", e16);
                return 30000L;
            }
        }
        return h();
    }

    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        try {
            if (this.f250246a.containsKey(f250237i)) {
                String str = this.f250246a.get(f250237i);
                Objects.requireNonNull(str);
                return Integer.parseInt(str);
            }
            return 180000;
        } catch (Exception e16) {
            QLog.e(f250230b, 1, "getHeartBeatWaitTimeInterval error", e16);
            return 180000;
        }
    }

    public long h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        try {
            if (this.f250246a.containsKey(f250232d)) {
                Objects.requireNonNull(this.f250246a.get(f250232d));
                return Integer.parseInt(r0);
            }
            return 10000L;
        } catch (Exception e16) {
            QLog.e(f250230b, 1, "getPreDetectTimeout error", e16);
            return 10000L;
        }
    }

    public int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        try {
            if (this.f250246a.containsKey(f250241m)) {
                String str = this.f250246a.get(f250241m);
                Objects.requireNonNull(str);
                return Integer.parseInt(str);
            }
            return 10000;
        } catch (Exception e16) {
            QLog.e(f250230b, 1, "getPreHeartBeatTimeInterval error", e16);
            return 10000;
        }
    }

    public long j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Long) iPatchRedirector.redirect((short) 11, (Object) this)).longValue();
        }
        try {
            if (this.f250246a.containsKey(f250239k)) {
                Objects.requireNonNull(this.f250246a.get(f250239k));
                return Integer.parseInt(r0);
            }
            return 120000L;
        } catch (Exception e16) {
            QLog.e(f250230b, 1, "getQuickHeartBeatReConnInterval error", e16);
            return 120000L;
        }
    }

    public boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        try {
            if (this.f250246a.containsKey(f250240l)) {
                String str = this.f250246a.get(f250240l);
                Objects.requireNonNull(str);
                return Boolean.parseBoolean(str);
            }
        } catch (Exception e16) {
            QLog.e(f250230b, 1, "getQuickHeartBeatSwitch error", e16);
        }
        return true;
    }

    public long l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Long) iPatchRedirector.redirect((short) 13, (Object) this)).longValue();
        }
        try {
            if (this.f250246a.containsKey(f250238j)) {
                Objects.requireNonNull(this.f250246a.get(f250238j));
                return Integer.parseInt(r0);
            }
            return 10000L;
        } catch (Exception e16) {
            QLog.e(f250230b, 1, "getQuickHeartBeatTimeout error", e16);
            return 10000L;
        }
    }

    public int m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        try {
            if (this.f250246a.containsKey(f250244p)) {
                String str = this.f250246a.get(f250244p);
                Objects.requireNonNull(str);
                return Integer.parseInt(str);
            }
            return 15000;
        } catch (Exception e16) {
            QLog.e(f250230b, 1, "getQuickSendFastInterval error", e16);
            return 15000;
        }
    }

    public int n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        try {
            if (this.f250246a.containsKey(f250243o)) {
                String str = this.f250246a.get(f250243o);
                Objects.requireNonNull(str);
                return Integer.parseInt(str);
            }
            return 4;
        } catch (Exception e16) {
            QLog.e(f250230b, 1, "getQuickSendFastTimes error", e16);
            return 4;
        }
    }

    e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        this.f250246a = concurrentHashMap;
        concurrentHashMap.putAll(MsfSdkUtils.convertJsonToMap(MsfService.getCore().getSharedPreferences(f250245q, 0).getString(BaseConstants.KEY_MSF_COMMON_CONFIG_STRING, "")));
        QLog.d(f250230b, 1, "[init], config: " + concurrentHashMap);
    }

    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        try {
            if (this.f250246a.containsKey(f250231c)) {
                String str = this.f250246a.get(f250231c);
                Objects.requireNonNull(str);
                return Boolean.parseBoolean(str);
            }
        } catch (Exception e16) {
            QLog.d(f250230b, 1, "getActivePreDetect error", e16);
        }
        return true;
    }
}
