package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.microapp.sdk.MiniAppLauncher;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes11.dex */
public class aj extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;

    public aj(QQAppInterface qQAppInterface, Context context) {
        super(qQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
        }
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        try {
            HashMap<String, String> hashMap = this.f307441f;
            if (hashMap != null && hashMap.containsKey(PreloadingFragment.KEY_APPID) && !this.f307441f.containsKey("fakeUrl")) {
                z16 = true;
            } else {
                z16 = false;
            }
            int i3 = 2016;
            try {
                HashMap<String, String> hashMap2 = this.f307441f;
                if (hashMap2 != null && hashMap2.containsKey("appscene")) {
                    i3 = Integer.parseInt(this.f307441f.get("appscene"));
                }
            } catch (Exception e16) {
                QLog.e("HttpOpenMicroAppAction", 1, QLog.getStackTraceString(e16));
            }
            int i16 = i3;
            if (z16) {
                return MiniAppLauncher.launchMiniAppByScheme(this.f307437b, this.f307441f);
            }
            return ((IMiniAppService) QRoute.api(IMiniAppService.class)).launchMiniAppByScheme(this.f307437b, this.f307441f, i16, null, null);
        } catch (Exception e17) {
            QLog.e("HttpOpenMicroAppAction", 1, "doAction error: " + e17.getMessage());
            i("HttpOpenMicroAppAction");
            return false;
        }
    }
}
