package com.tencent.mobileqq.app.identity;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public class t implements IDelayReporter {
    static IPatchRedirector $redirector_;

    public t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.identity.IDelayReporter
    public boolean processReport(String str, HashMap<String, String> hashMap) {
        String account;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) hashMap)).booleanValue();
        }
        boolean equals = "quickLoginError".equals(str);
        if (equals) {
            if (hashMap == null) {
                return true;
            }
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            if (waitAppRuntime == null) {
                account = "";
            } else {
                account = waitAppRuntime.getAccount();
            }
            String str2 = account;
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put("keyUin", str2);
            }
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str2, "quickLoginError", false, 0L, 0L, hashMap, "");
        }
        return equals;
    }
}
