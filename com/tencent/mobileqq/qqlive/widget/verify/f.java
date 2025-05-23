package com.tencent.mobileqq.qqlive.widget.verify;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.login.ILiveLoginApi;
import com.tencent.mobileqq.qqlive.api.verified.IQQLiveDataStore;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes17.dex */
public class f implements t43.a {
    static IPatchRedirector $redirector_;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // t43.a
    public List<String> a(String str) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        if ("https://qlive.qq.com/".equals(str)) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            String appId = ((IQQLiveDataStore) QRoute.api(IQQLiveDataStore.class)).getAppId();
            String currentUin = peekAppRuntime.getCurrentUin();
            ILiveLoginApi iLiveLoginApi = (ILiveLoginApi) QRoute.api(ILiveLoginApi.class);
            if (appId == null) {
                str2 = "";
            } else {
                str2 = appId;
            }
            LoginInfo loginInfo = new LoginInfo(iLiveLoginApi.getLoginInfo(str2, currentUin));
            if (QLog.isColorLevel()) {
                QLog.d("QQLiveBrowserCookieInjector", 4, "[collectBusinessCookies] loginInfo:" + loginInfo);
            }
            return com.tencent.mobileqq.qqlive.widget.a.a(appId, loginInfo, str);
        }
        return null;
    }
}
