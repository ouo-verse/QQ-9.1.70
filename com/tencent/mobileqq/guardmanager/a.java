package com.tencent.mobileqq.guardmanager;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.hitrate.api.IPreloadProcHitMgrApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.o;
import com.tencent.mobileqq.statistics.t;
import com.tencent.mobileqq.u;
import com.tencent.mobileqq.utils.bq;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a implements u {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.u
    public void a(AppRuntime appRuntime, String str, String str2, String str3, String str4, String str5, int i3, int i16, int i17, String str6, String str7, String str8, String str9) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, appRuntime, str, str2, str3, str4, str5, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str6, str7, str8, str9);
        } else {
            ReportController.n(appRuntime, str, str2, str3, str4, str5, i3, i16, i17, str6, str7, str8, str9);
        }
    }

    @Override // com.tencent.mobileqq.u
    public void b(int i3, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16));
        } else {
            MobileQQ.sMobileQQ.waitAppRuntime(null).onGuardEvent(i3, j3, j16);
        }
    }

    @Override // com.tencent.mobileqq.u
    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return o.b();
    }

    @Override // com.tencent.mobileqq.u
    public void collectPerformance(String str, String str2, boolean z16, long j3, long j16, HashMap<String, String> hashMap, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, str2, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), hashMap, str3);
        } else {
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str, str2, z16, j3, j16, hashMap, str3);
        }
    }

    @Override // com.tencent.mobileqq.u
    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return ((IDPCApi) QRoute.api(IDPCApi.class)).isFeatureSupported(DPCNames.disable_qzone_kill.name());
    }

    @Override // com.tencent.mobileqq.u
    public String[] e(String str, String str2, String str3) {
        String str4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String[]) iPatchRedirector.redirect((short) 3, this, str, str2, str3);
        }
        String featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(str);
        if (QLog.isColorLevel()) {
            QLog.d(GuardManager.TAG, 2, "config = " + featureValue);
        }
        if (TextUtils.isEmpty(featureValue) || featureValue.equals("0")) {
            return null;
        }
        String[] split = featureValue.split(str2);
        if (split.length > 1) {
            str4 = split[((IDPCApi) QRoute.api(IDPCApi.class)).getAbRamdom() % split.length];
        } else {
            str4 = split[0];
        }
        String[] split2 = str4.split(str3);
        if (split2.length < 4) {
            return null;
        }
        return split2;
    }

    @Override // com.tencent.mobileqq.u
    public void exitProcess(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            ((IPreloadProcHitMgrApi) QRoute.api(IPreloadProcHitMgrApi.class)).exitProcess(str);
        }
    }

    @Override // com.tencent.mobileqq.u
    public Looper f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Looper) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return bq.a();
    }

    @Override // com.tencent.mobileqq.u
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            t.a().d(t.b());
        }
    }

    @Override // com.tencent.mobileqq.u
    public void h(AppRuntime appRuntime, String str, String str2, String str3, String str4, int i3, String str5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, appRuntime, str, str2, str3, str4, Integer.valueOf(i3), str5);
        } else {
            ReportController.w(appRuntime, str, str2, str3, str4, i3, str5);
        }
    }
}
