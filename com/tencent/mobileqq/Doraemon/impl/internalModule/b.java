package com.tencent.mobileqq.Doraemon.impl.internalModule;

import android.support.annotation.NonNull;
import android.util.Log;
import com.tencent.mobileqq.Doraemon.e;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.imcore.proxy.basic.StatisticCollectorProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class b extends e {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.Doraemon.e
    public boolean c(int i3, String str, JSONObject jSONObject, @NonNull com.tencent.mobileqq.Doraemon.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, jSONObject, aVar)).booleanValue();
        }
        if (i3 != 9) {
            return false;
        }
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        QLog.e("DoraemonOpenAPI.innerApi", 1, "InternalAPIModule_api_getSkey trace=", new RuntimeException("getSkey"));
        HashMap hashMap = new HashMap();
        hashMap.put("log_uin", waitAppRuntime.getCurrentUin());
        hashMap.put("trace", Log.getStackTraceString(new RuntimeException("D.api.getSkey trace")));
        StatisticCollectorProxy.collectPerformance(waitAppRuntime.getCurrentUin(), "InternalAPIModule_api_getSkey", true, 0L, 0L, hashMap, null);
        String account = waitAppRuntime.getAccount();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("uin", account);
            jSONObject2.put("skey", "no_exist");
            DoraemonUtil.e(aVar, jSONObject2);
        } catch (JSONException e16) {
            String message = e16.getMessage();
            if (QLog.isColorLevel()) {
                QLog.w("DoraemonOpenAPI.innerApi", 2, message, e16);
            }
            if (message == null) {
                message = "";
            }
            DoraemonUtil.c(aVar, -1, message);
        }
        return true;
    }
}
