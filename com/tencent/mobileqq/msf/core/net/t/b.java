package com.tencent.mobileqq.msf.core.net.t;

import android.os.Build;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.net.t.d;
import com.tencent.mobileqq.msf.core.o;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    private static final String f249137a = "QualityIpv6TestReport";

    /* renamed from: b, reason: collision with root package name */
    private static final String f249138b = "EvtIpv6QualityReport";

    /* renamed from: c, reason: collision with root package name */
    public static final int f249139c = 0;

    /* renamed from: d, reason: collision with root package name */
    public static final int f249140d = 1;

    /* renamed from: e, reason: collision with root package name */
    public static final int f249141e = 2;

    /* renamed from: f, reason: collision with root package name */
    public static final int f249142f = 3;

    /* renamed from: g, reason: collision with root package name */
    public static final int f249143g = 4;

    /* renamed from: h, reason: collision with root package name */
    public static final int f249144h = 5;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final b f249145a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23557);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f249145a = new b();
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static b a() {
        return a.f249145a;
    }

    public void a(int i3, int i16, int i17, int i18, d.EnumC8091d enumC8091d, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), enumC8091d, str, str2);
            return;
        }
        try {
            if (g.f249396d.getStatReporter() != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("result", String.valueOf(i3));
                hashMap.put("clientIpFamily", String.valueOf(i16));
                hashMap.put("clientNetType", String.valueOf(i17));
                hashMap.put("serverIpFamily", String.valueOf(i18));
                hashMap.put("testType", String.valueOf(enumC8091d));
                hashMap.put("domain", str);
                hashMap.put("nat64Prefix", str2);
                hashMap.put("apn", NetConnInfoCenter.getCurrentAPN());
                hashMap.put(MobileInfoUtil.IMSI, o.f());
                int i19 = Build.VERSION.SDK_INT;
                hashMap.put("osVersion", String.valueOf(i19));
                String str3 = Build.BRAND;
                hashMap.put("deviceBrand", str3);
                String model = DeviceInfoMonitor.getModel();
                hashMap.put("deviceModel", model);
                if (QLog.isDebugVersion()) {
                    QLog.d(f249137a, 4, "reportQualityTest result=" + i3 + ", clientIpFamily=" + i16 + ", clientNetType=" + i17 + ", serverIpFamily=" + i18 + ", testType=" + enumC8091d + ", domain=" + str + ", nat64Prefix=" + str2 + ", apn=" + NetConnInfoCenter.getCurrentAPN() + ", imsi=" + o.f() + ", os=" + i19 + ", brand=" + str3 + ", model=" + model);
                }
                g.f249396d.getStatReporter().a(f249138b, true, 0L, 0L, (Map<String, String>) hashMap, false, false);
            }
        } catch (Throwable th5) {
            QLog.d(f249137a, 1, "reportQualityTest exception=" + th5);
        }
    }
}
