package com.tencent.mobileqq.statistics;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class t {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static t f290139d;

    /* renamed from: a, reason: collision with root package name */
    private final String f290140a;

    /* renamed from: b, reason: collision with root package name */
    public Map<String, Boolean> f290141b;

    /* renamed from: c, reason: collision with root package name */
    public Map<String, Boolean> f290142c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36456);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f290139d = new t("qzone");
        }
    }

    public t(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.f290141b = new ConcurrentHashMap();
        this.f290142c = new ConcurrentHashMap();
        this.f290140a = "StatisticHitRateCollector_" + str;
    }

    public static t a() {
        return f290139d;
    }

    public static String b() {
        AppRuntime appRuntime;
        MobileQQ mobileQQ = MobileQQ.getMobileQQ();
        if (mobileQQ != null) {
            appRuntime = mobileQQ.peekAppRuntime();
        } else {
            appRuntime = null;
        }
        if (appRuntime == null || appRuntime.getAccount() == null) {
            return "0";
        }
        return appRuntime.getAccount();
    }

    public void c(String str, String str2) {
        Boolean bool;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (str2 != null) {
            Boolean bool2 = this.f290141b.get(str2);
            if ((bool2 == null || !bool2.booleanValue()) && (bool = this.f290142c.get(str2)) != null && bool.booleanValue()) {
                this.f290141b.put(str2, Boolean.TRUE);
                if (QLog.isColorLevel()) {
                    QLog.d(this.f290140a, 2, "hitEnd action = " + str2 + " , hit = false, uin = " + str);
                }
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str, str2, false, 0L, 0L, null, null);
                this.f290141b.remove(str2);
                this.f290142c.remove(str2);
            }
        }
    }

    public void d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        Iterator it = new ArrayList(this.f290142c.keySet()).iterator();
        while (it.hasNext()) {
            c(str, (String) it.next());
        }
    }

    public void e(String str, String str2) {
        Boolean bool;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2);
            return;
        }
        Boolean bool2 = this.f290141b.get(str2);
        if ((bool2 == null || !bool2.booleanValue()) && (bool = this.f290142c.get(str2)) != null && bool.booleanValue()) {
            this.f290141b.put(str2, Boolean.TRUE);
            if (QLog.isColorLevel()) {
                QLog.d(this.f290140a, 2, "hitEnd sucess action = " + str2 + " , hit = true, uin = " + str);
            }
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str, str2, true, 0L, 0L, null, null);
            this.f290141b.remove(str2);
            this.f290142c.remove(str2);
        }
    }

    public void f(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.f290140a, 2, "preloadMark preloadAction = " + str + " , flag = " + z16);
        }
        if (z16) {
            c(b(), str);
        }
        this.f290141b.put(str, Boolean.FALSE);
        this.f290142c.put(str, Boolean.TRUE);
    }

    public void g(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            e(str, "actQZLoadHitRateLeba");
        }
    }

    public void h(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            e(str, "actQZLoadHitRateProfile");
        }
    }

    public void i(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else {
            e(str, "actQZLoadHitRateRed");
        }
    }
}
